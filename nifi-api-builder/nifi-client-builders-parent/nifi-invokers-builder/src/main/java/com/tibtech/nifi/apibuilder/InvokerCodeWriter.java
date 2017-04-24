package com.tibtech.nifi.apibuilder;

import java.beans.IntrospectionException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.nifi.connectable.ConnectableType;
import org.apache.nifi.web.api.ApplicationResource;
import org.apache.nifi.web.api.entity.Entity;
import org.apache.nifi.web.api.request.BulletinBoardPatternParameter;
import org.apache.nifi.web.api.request.ClientIdParameter;
import org.apache.nifi.web.api.request.ConnectableTypeParameter;
import org.apache.nifi.web.api.request.DateTimeParameter;
import org.apache.nifi.web.api.request.DoubleParameter;
import org.apache.nifi.web.api.request.IntegerParameter;
import org.apache.nifi.web.api.request.LongParameter;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeVariableName;
import com.sun.jersey.multipart.FormDataParam;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

public class InvokerCodeWriter
{
	private static final Logger LOGGER = LoggerFactory.getLogger(InvokerCodeWriter.class);

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
			if (BulletinBoardPatternParameter.class.isAssignableFrom(parameter.getType()))
			{
				parameterTypeName = TypeVariableName.get(String.class);
				parameterType = String.class;
			}
			else if (ClientIdParameter.class.isAssignableFrom(parameter.getType()))
			{
				parameterTypeName = TypeVariableName.get(String.class);
				parameterType = String.class;
			}
			else if (ConnectableTypeParameter.class.isAssignableFrom(parameter.getType()))
			{
				parameterTypeName = TypeVariableName.get(ConnectableType.class);
				parameterType = ConnectableType.class;
			}
			else if (DateTimeParameter.class.isAssignableFrom(parameter.getType()))
			{
				parameterTypeName = TypeVariableName.get(Date.class);
				parameterType = Date.class;
			}
			else if (DoubleParameter.class.isAssignableFrom(parameter.getType()))
			{
				parameterTypeName = TypeVariableName.get(Double.class);
				parameterType = Double.class;
			}
			else if (IntegerParameter.class.isAssignableFrom(parameter.getType()))
			{
				parameterTypeName = TypeVariableName.get(Integer.class);
				parameterType = Integer.class;
			}
			else if (LongParameter.class.isAssignableFrom(parameter.getType()))
			{
				parameterTypeName = TypeVariableName.get(Long.class);
				parameterType = Long.class;
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

					invokerTypeSpecBuilder.addPathParameter(name, parameterType, parameterTypeName, comment);
				}
				else if (paramAnnotation instanceof QueryParam)
				{
					// Add query parameter.
					final QueryParam queryParam = (QueryParam) paramAnnotation;
					final String name = queryParam.value();

					invokerTypeSpecBuilder.addQueryParameter(name, parameterType, parameterTypeName, comment);
				}
				else if (paramAnnotation instanceof FormParam)
				{
					// Add form parameter.
					final FormParam formParam = (FormParam) paramAnnotation;
					final String name = formParam.value();

					invokerTypeSpecBuilder.addFormParameter(name, parameterType, parameterTypeName, comment);
				}
				else if (paramAnnotation instanceof FormDataParam)
				{
					// Add form data parameter.
					final FormDataParam formDataParam = (FormDataParam) paramAnnotation;
					final String name = formDataParam.value();

					invokerTypeSpecBuilder.addFormDataParameter(name, parameterType, parameterTypeName, comment);
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
					invokerTypeSpecBuilder.setRequestEntity(new BuilderProperty(entityPropertyName, parameter.getType(),
							parameterTypeName, comment, false, null));
				}
			}
		}
	}

	/**
	 * Determine what HTTP method is being used base on annotations on the
	 * method (there should only be one!).
	 * 
	 * @param invokerTypeSpecBuilder
	 * @param resourceMethod
	 */
	public static void configureHttpMethod(final InvokerTypeSpecBuilder invokerTypeSpecBuilder,
			final Method resourceMethod)
	{
		if (resourceMethod.getAnnotation(DELETE.class) != null)
		{
			invokerTypeSpecBuilder.setHttpMethod("DELETE");
		}
		else if (resourceMethod.getAnnotation(HEAD.class) != null)
		{
			invokerTypeSpecBuilder.setHttpMethod("HEAD");
		}
		else if (resourceMethod.getAnnotation(GET.class) != null)
		{
			invokerTypeSpecBuilder.setHttpMethod("GET");
		}
		else if (resourceMethod.getAnnotation(OPTIONS.class) != null)
		{
			invokerTypeSpecBuilder.setHttpMethod("OPTIONS");
		}
		else if (resourceMethod.getAnnotation(POST.class) != null)
		{
			invokerTypeSpecBuilder.setHttpMethod("POST");
		}
		else if (resourceMethod.getAnnotation(PUT.class) != null)
		{
			invokerTypeSpecBuilder.setHttpMethod("PUT");
		}
		else
		{
			throw new IllegalStateException("Could not find a HTTP method for resource method: " + resourceMethod);
		}
	}

	private static PackagedTypeSpec createComponentEntityInvokerTypeSpec(
			final Function<String, String> packageNameMapper, final Class<?> resourceClass, final Method resourceMethod,
			final Class<?> responseType, final String classResourcePathPrefix) throws IntrospectionException
	{
		final InvokerTypeSpecBuilder invokerTypeSpecBuilder = new InvokerTypeSpecBuilder();
		invokerTypeSpecBuilder.setResponseType(responseType);

		final String classResourcePath;
		// Determine the class level path.
		final Path classResourcePathAnnotation = resourceClass.getAnnotation(Path.class);
		if (classResourcePathAnnotation != null)
		{
			classResourcePath = classResourcePathPrefix + "/" + classResourcePathAnnotation.value();
			invokerTypeSpecBuilder.setClassResourcePathString(classResourcePath);
		}
		else
		{
			throw new IllegalStateException("No class resource path annotation found: " + resourceClass);
		}

		final String methodResourcePath;
		final Path methodResourcePathAnnotation = resourceMethod.getAnnotation(Path.class);
		if (methodResourcePathAnnotation != null)
		{
			methodResourcePath = methodResourcePathAnnotation.value();
			invokerTypeSpecBuilder.setMethodResourcePathString(methodResourcePath);
		}
		else
		{
			throw new IllegalStateException("No method resource path annotation found: " + resourceMethod);
		}

		invokerTypeSpecBuilder.setInvokerName(
				NameUtils.componentsToCamelCase(NameUtils.getNameComponents(resourceMethod.getName()), false)
						+ "Invoker");

		configureHttpMethod(invokerTypeSpecBuilder, resourceMethod);

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

				default:
					// Do nothing
			}
		}

		addInvokerProperties(invokerTypeSpecBuilder, resourceMethod);

		return new PackagedTypeSpec(
				packageNameMapper.apply(resourceClass.getPackage().getName()) + "."
						+ NameUtils.componentsToPackageName(NameUtils.getNameComponents(classResourcePath)),
				invokerTypeSpecBuilder.build());
	}

	public static void doStuff(final Collection<PackagedTypeSpec> packagedTypeSpecs,
			final Function<String, String> packageNameMapper, final Class<?> resourceClass, final Method resourceMethod,
			final Class<?> responseType, final String classResourcePathPrefix) throws IntrospectionException
	{
		if (ApplicationResource.class.isAssignableFrom(responseType))
		{
			final Method[] methods = responseType.getMethods();
			final List<Method> restApiMethods = Arrays.stream(methods)
					.filter(m -> Arrays.stream(m.getAnnotations()).anyMatch(a -> a instanceof Path))
					.collect(Collectors.toList());

			for (final Method restApiMethod : restApiMethods)
			{
				final ApiOperation apiOperation = restApiMethod.getAnnotation(ApiOperation.class);
				if (apiOperation != null)
				{
					final Path methodResourcePathAnnotation = restApiMethod.getAnnotation(Path.class);
					if (methodResourcePathAnnotation != null)
					{
						final String methodResourcePath = methodResourcePathAnnotation.value();
						final Class<?> invokerResponseType = apiOperation.response();
						doStuff(packagedTypeSpecs, packageNameMapper, responseType, restApiMethod, invokerResponseType,
								classResourcePathPrefix + "/" + methodResourcePath);
					}
					else
					{
						throw new IllegalStateException("No method resource path annotation found: " + resourceMethod);
					}
				}
				else
				{
					LOGGER.warn("Could not find API operation for method: {}", restApiMethod);
				}
			}
		}
		else
		{
			packagedTypeSpecs.add(createComponentEntityInvokerTypeSpec(packageNameMapper, resourceClass, resourceMethod,
					responseType, classResourcePathPrefix));
		}
	}

	public static void main(final String[] args) throws Exception
	{
		final Reflections reflections = new Reflections("org.apache.nifi", new SubTypesScanner(true));
		final Set<Class<? extends ApplicationResource>> applicationResources = reflections
				.getSubTypesOf(ApplicationResource.class);

		final Function<String, String> packageNameMapper = s -> s.replaceFirst("org\\.apache", "com.tibtech");

		final Set<PackagedTypeSpec> packagedTypeSpecs = new HashSet<>();

		for (final Class<? extends ApplicationResource> applicationResourceClass : applicationResources)
		{
			Annotation[] annotations = applicationResourceClass.getAnnotations();
			Path classResourcePathAnnotation = (Path) Arrays.stream(annotations).filter(a -> a instanceof Path)
					.findFirst().orElse(null);
			if (classResourcePathAnnotation != null)
			{
				final Method[] methods = applicationResourceClass.getMethods();
				final List<Method> restApiMethods = Arrays.stream(methods)
						.filter(m -> Arrays.stream(m.getAnnotations()).anyMatch(a -> a instanceof Path))
						.collect(Collectors.toList());

				for (final Method restApiMethod : restApiMethods)
				{
					final ApiOperation apiOperation = restApiMethod.getAnnotation(ApiOperation.class);
					if (apiOperation != null)
					{
						final Class<?> invokerResponseType = apiOperation.response();

						doStuff(packagedTypeSpecs, packageNameMapper, applicationResourceClass, restApiMethod,
								invokerResponseType, "");
					}
					else
					{
						LOGGER.warn("Could not find API operation for method: {}", restApiMethod);
					}
				}
			}
		}

		final java.nio.file.Path generatedJavaPath = Paths.get("../../nifi-client-parent/nifi-invokers/src/main/java");

		for (final PackagedTypeSpec packagedTypeSpec : packagedTypeSpecs)
		{
			final String builderPackageName = packagedTypeSpec.getPackageName().replaceFirst("org\\.apache",
					"com.tibtech");

			final JavaFile javaFile = JavaFile.builder(builderPackageName, packagedTypeSpec.getTypeSpec()).build();
			javaFile.writeTo(generatedJavaPath);
		}
	}
}
