package com.tibtech.nifi.apibuilder;

import java.beans.IntrospectionException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.nifi.web.api.ApplicationResource;
import org.apache.nifi.web.api.entity.Entity;
import org.apache.nifi.web.api.request.IntegerParameter;
import org.apache.nifi.web.api.request.LongParameter;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;
import com.sun.jersey.multipart.FormDataParam;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

public class InvokerCodeWriter
{
	public static List<Annotation> getJaxRsAnnotations(final AnnotatedElement annotatedElement)
	{
		return Arrays.stream(annotatedElement.getAnnotations())
				.filter(a -> a.annotationType().getName().matches("javax\\.ws\\.rs\\..*|com\\.sun\\.jersey\\..*"))
				.collect(Collectors.toList());
	}

	public static List<MediaType> stringsToMediaTypes(final String[] mediaTypeStrings)
	{
		return Arrays.stream(mediaTypeStrings).map(s -> MediaType.valueOf(s)).collect(Collectors.toList());
	}

	public static void addInvokerProperties(final InvokerTypeSpecBuilder invokerTypeSpecBuilder,
			final Method resourceMethod) throws IntrospectionException
	{
		final Parameter[] parameters = resourceMethod.getParameters();
		for (final Parameter parameter : parameters)
		{
			final List<Annotation> parameterJaxRsAnnotations = getJaxRsAnnotations(parameter);

			// If the parameter annotation is a XxxParam annotation then add the
			// parameter as an invoker property.
			final Annotation paramAnnotation = parameterJaxRsAnnotations.parallelStream()
					.filter(a -> a.annotationType().getName().endsWith("Param")).findFirst().orElse(null);

			final TypeName parameterTypeName;
			final Class<?> parameterType;
			if (IntegerParameter.class.isAssignableFrom(parameter.getType()))
			{
				parameterTypeName = TypeVariableName.get(int.class);
				parameterType = int.class;
			}
			else if (LongParameter.class.isAssignableFrom(parameter.getType()))
			{
				parameterTypeName = TypeVariableName.get(long.class);
				parameterType = long.class;
			}
			else
			{
				parameterTypeName = ClassUtils.getParameterTypeName(parameter);
				parameterType = parameter.getType();
			}

			final ApiParam apiParam = parameter.getAnnotation(ApiParam.class);
			final String comment = apiParam != null ? apiParam.value() : "";

			if (paramAnnotation != null)
			{
				if (paramAnnotation instanceof PathParam)
				{
					// Add path parameter.
					final PathParam pathParam = (PathParam) paramAnnotation;
					final String name = pathParam.value();

					final String propertyName = NameUtils.componentsToCamelCase(NameUtils.getNameComponents(name), true);
					invokerTypeSpecBuilder.addPathParameter(propertyName, parameterType, parameterTypeName, comment);
				}
				else if (paramAnnotation instanceof QueryParam)
				{
					// Add query parameter.
					final QueryParam queryParam = (QueryParam) paramAnnotation;
					final String name = queryParam.value();

					final String propertyName = NameUtils.componentsToCamelCase(NameUtils.getNameComponents(name), true);
					invokerTypeSpecBuilder.addQueryParameter(propertyName, parameter.getType(), parameterTypeName, comment);
				}
				else if (paramAnnotation instanceof FormParam)
				{
					// Add form parameter.
					final FormParam formParam = (FormParam) paramAnnotation;
					final String name = formParam.value();

					final String propertyName = NameUtils.componentsToCamelCase(NameUtils.getNameComponents(name), true);
					invokerTypeSpecBuilder.addFormParameter(propertyName, parameter.getType(), parameterTypeName, comment);
				}
				else if (paramAnnotation instanceof FormDataParam)
				{
					// Add form data parameter.
					final FormDataParam formDataParam = (FormDataParam) paramAnnotation;
					final String name = formDataParam.value();

					final String propertyName = NameUtils.componentsToCamelCase(NameUtils.getNameComponents(name), true);
					invokerTypeSpecBuilder.addFormDataParameter(propertyName, parameter.getType(), parameterTypeName, comment);
				}
				else
				{
					throw new IllegalStateException("Unrecognised param annotation: " + paramAnnotation);
				}
			}
			else
			{
				// If the parameter is an Entity, then add its members as
				// invoker properties.
				if (Entity.class.isAssignableFrom(parameter.getType()))
				{
					final String entityPropertyName = NameUtils.componentsToCamelCase(
							NameUtils.getNameComponents(parameter.getType().getSimpleName()), true);
					invokerTypeSpecBuilder.setRequestEntity(
							new BuilderProperty(entityPropertyName, parameter.getType(), parameterTypeName, comment));
				}
			}

			parameterJaxRsAnnotations.stream().forEach(a -> System.out.println(a));
		}
	}

	public static TypeSpec createComponentEntityInvokerTypeSpec(
			final Class<? extends ApplicationResource> resourceClass, final Method resourceMethod,
			final Class<?> responseType) throws Exception
	{
		final InvokerTypeSpecBuilder invokerTypeSpecBuilder = new InvokerTypeSpecBuilder();
		invokerTypeSpecBuilder.setResponseType(responseType);

		invokerTypeSpecBuilder.setInvokerName(
				NameUtils.componentsToCamelCase(NameUtils.getNameComponents(resourceMethod.getName()), false)
						+ "Invoker");

		final List<Annotation> classJaxRsAnnotations = getJaxRsAnnotations(resourceClass);
		for (final Annotation classAnnotation : classJaxRsAnnotations)
		{
			switch (classAnnotation.annotationType().getName())
			{
				case "javax.ws.rs.Path":
					final Path path = (Path) classAnnotation;
					invokerTypeSpecBuilder.setClassResourcePathString(path.value());
					break;

				default:
					throw new IllegalStateException("Unsupported JAX-RS class annotation: " + classAnnotation);
			}
		}

		final List<Annotation> methodJaxRsAnnotations = getJaxRsAnnotations(resourceMethod);
		for (final Annotation methodAnnotation : methodJaxRsAnnotations)
		{
			switch (methodAnnotation.annotationType().getName())
			{
				case "javax.ws.rs.Consumes":
					final Consumes consumes = (Consumes) methodAnnotation;
					invokerTypeSpecBuilder.addConsumesMediaTypes(stringsToMediaTypes(consumes.value()));
					break;

				case "javax.ws.rs.Produces":
					final Produces produces = (Produces) methodAnnotation;
					invokerTypeSpecBuilder.addProducesMediaTypes(stringsToMediaTypes(produces.value()));
					break;

				case "javax.ws.rs.DELETE":
					invokerTypeSpecBuilder.setHttpMethod("DELETE");
					break;

				case "javax.ws.rs.HEAD":
					invokerTypeSpecBuilder.setHttpMethod("HEAD");
					break;

				case "javax.ws.rs.GET":
					invokerTypeSpecBuilder.setHttpMethod("GET");
					break;

				case "javax.ws.rs.OPTIONS":
					invokerTypeSpecBuilder.setHttpMethod("OPTIONS");
					break;

				case "javax.ws.rs.POST":
					invokerTypeSpecBuilder.setHttpMethod("POST");
					break;

				case "javax.ws.rs.PUT":
					invokerTypeSpecBuilder.setHttpMethod("PUT");
					break;

				case "javax.ws.rs.Path":
					final Path path = (Path) methodAnnotation;
					invokerTypeSpecBuilder.setMethodResourcePathString(path.value());
					break;

				default:
					throw new IllegalStateException("Unsupported JAX-RS method annotation: " + methodAnnotation);
			}
		}

		addInvokerProperties(invokerTypeSpecBuilder, resourceMethod);

		return invokerTypeSpecBuilder.build();
	}

	public static void main(final String[] args) throws Exception
	{
		final Reflections reflections = new Reflections("org.apache.nifi", new SubTypesScanner(true));
		final Set<Class<? extends ApplicationResource>> applicationResources = reflections
				.getSubTypesOf(ApplicationResource.class);

		for (final Class<? extends ApplicationResource> applicationResourceClass : applicationResources)
		{
			Annotation[] annotations = applicationResourceClass.getAnnotations();
			Path classResourcePathAnnotation = (Path) Arrays.stream(annotations).filter(a -> a instanceof Path)
					.findFirst().orElse(null);
			if (classResourcePathAnnotation != null)
			{
				List<String> classResourcePathNameComponents = NameUtils
						.getNameComponents(classResourcePathAnnotation.value());

				final Method[] methods = applicationResourceClass.getMethods();
				final List<Method> restApiMethods = Arrays.stream(methods)
						.filter(m -> Arrays.stream(m.getAnnotations()).anyMatch(a -> a instanceof Path))
						.collect(Collectors.toList());

				final java.nio.file.Path generatedJavaPath = Paths.get("src/generated/java");

				for (Method restApiMethod : restApiMethods)
				{
					final ApiOperation apiOperation = restApiMethod.getAnnotation(ApiOperation.class);
					final Class<?> invokerResponseType = apiOperation.response();

					final TypeSpec invokerTypeSpec = createComponentEntityInvokerTypeSpec(applicationResourceClass,
							restApiMethod, invokerResponseType);

					final String applicationResourcePackageName = applicationResourceClass.getPackage().getName();
					final String builderPackageName = applicationResourcePackageName.replaceFirst("org\\.apache",
							"com.tibtech") + "." + NameUtils.componentsToPackageName(classResourcePathNameComponents);

					final JavaFile javaFile = JavaFile.builder(builderPackageName, invokerTypeSpec).build();
					javaFile.writeTo(generatedJavaPath);
				}
			}
		}
	}
}
