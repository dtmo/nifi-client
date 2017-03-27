package com.tibtech.nifi.apibuilder;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.lang.model.element.Modifier;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.nifi.web.api.ApplicationResource;
import org.apache.nifi.web.api.dto.RevisionDTO;
import org.apache.nifi.web.api.entity.ComponentEntity;
import org.apache.nifi.web.api.entity.Entity;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;
import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import com.wordnik.swagger.annotations.ApiOperation;

public class InvokerCodeWriter
{
	public static List<Annotation> getJaxRsAnnotations(final AnnotatedElement annotatedElement)
	{
		return Arrays.stream(annotatedElement.getAnnotations())
				.filter(a -> a.annotationType().getName().matches("javax\\.ws\\.rs.*")).collect(Collectors.toList());
	}

	public static List<MediaType> stringsToMediaTypes(final String[] mediaTypeStrings)
	{
		return Arrays.stream(mediaTypeStrings).map(s -> MediaType.valueOf(s)).collect(Collectors.toList());
	}

	public static void addEntity(final Class<?> entityType, final TypeSpec.Builder invokerTypeSpecBuilder,
			final TypeName invokerTypeName, final MethodSpec.Builder invokeMethodBuilder, final MediaType mediaType)
			throws IntrospectionException
	{
		System.out.println("Adding entity: " + entityType);

		final BeanInfo beanInfo = Introspector.getBeanInfo(entityType);

		final String entityVariable = NameUtils
				.componentsToCamelCase(NameUtils.getNameComponents(entityType.getSimpleName()), true);

		invokeMethodBuilder.addStatement("final $T $L = new $T()", entityType, entityVariable, entityType);

		final PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (final PropertyDescriptor propertyDescriptor : propertyDescriptors)
		{
			if (propertyDescriptor.getWriteMethod() != null)
			{
				if (RevisionDTO.class.isAssignableFrom(propertyDescriptor.getPropertyType()) == false)
				{
					addProperty(propertyDescriptor.getName(), propertyDescriptor.getPropertyType(),
							invokerTypeSpecBuilder, invokerTypeName);

					invokeMethodBuilder.addStatement("$L.$L($L)", entityVariable,
							propertyDescriptor.getWriteMethod().getName(), propertyDescriptor.getName());
				}
				else
				{
					invokeMethodBuilder.addStatement("$L.$L(createRevisionDto())", entityVariable,
							propertyDescriptor.getWriteMethod().getName());
				}
			}
		}

		invokeMethodBuilder.addStatement("final $T<$T> entity = $T.entity($L, $S)", javax.ws.rs.client.Entity.class,
				entityType, javax.ws.rs.client.Entity.class, entityVariable, mediaType);
	}

	public static void addProperty(final String restPropertyName, final Class<?> propertyType,
			final TypeSpec.Builder invokerTypeSpecBuilder, final TypeName invokerTypeName)
	{
		final List<String> propertyNameComponents = NameUtils.getNameComponents(restPropertyName);
		final String propertyName = NameUtils.componentsToCamelCase(propertyNameComponents, true);

		invokerTypeSpecBuilder.addField(FieldSpec.builder(propertyType, propertyName, Modifier.PRIVATE).build());

		final String getterMethodName = "get" + NameUtils.componentsToCamelCase(propertyNameComponents, false);
		invokerTypeSpecBuilder.addMethod(MethodSpec.methodBuilder(getterMethodName).returns(propertyType)
				.addModifiers(Modifier.PUBLIC, Modifier.FINAL).addStatement("return $L", propertyName).build());

		final String setterMethodName = "set" + NameUtils.componentsToCamelCase(propertyNameComponents, false);
		invokerTypeSpecBuilder.addMethod(MethodSpec.methodBuilder(setterMethodName).returns(invokerTypeName)
				.addParameter(propertyType, propertyName, Modifier.FINAL).addModifiers(Modifier.PUBLIC, Modifier.FINAL)
				.addStatement("this.$L = $L", propertyName, propertyName).addStatement("return this").build());
	}

	public static void addInvokerProperties(final TypeSpec.Builder typeSpecBuilder, final TypeName invokerTypeName,
			final Method resourceMethod, final MethodSpec.Builder invokeMethodBuilder, final MediaType mediaType)
			throws IntrospectionException
	{
		final Parameter[] parameters = resourceMethod.getParameters();
		for (final Parameter parameter : parameters)
		{
			final List<Annotation> parameterJaxRsAnnotations = getJaxRsAnnotations(parameter);

			// If the parameter annotation is a XxxParam annotation then add the
			// parameter as an invoker property.
			final Annotation paramAnnotation = parameterJaxRsAnnotations.parallelStream()
					.filter(a -> a.annotationType().getName().endsWith("Param")).findFirst().orElse(null);

			if (paramAnnotation != null)
			{
				if (paramAnnotation instanceof PathParam)
				{
					// Add path parameter.
					final PathParam pathParam = (PathParam) paramAnnotation;
					final String value = pathParam.value();
					addProperty(value, parameter.getType(), typeSpecBuilder, invokerTypeName);
				}
				else if (paramAnnotation instanceof QueryParam)
				{
					// Add query parameter.
					final QueryParam queryParam = (QueryParam) paramAnnotation;
					final String value = queryParam.value();
					addProperty(value, parameter.getType(), typeSpecBuilder, invokerTypeName);
				}
				else if (paramAnnotation instanceof FormParam)
				{
					// Add form parameter.
					final FormParam formParam = (FormParam) paramAnnotation;
					final String value = formParam.value();
					addProperty(value, parameter.getType(), typeSpecBuilder, invokerTypeName);
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
					addEntity(parameter.getType(), typeSpecBuilder, invokerTypeName, invokeMethodBuilder, mediaType);
				}
			}

			System.out.println("param: " + parameter);
			parameterJaxRsAnnotations.stream().forEach(a -> System.out.println(a));
		}
	}

	public static TypeSpec createComponentEntityInvokerTypeSpec(
			final Class<? extends ApplicationResource> resourceClass, final Method resourceMethod,
			final Class<?> responseType) throws Exception
	{
		final String invokerName = NameUtils
				.componentsToCamelCase(NameUtils.getNameComponents(resourceMethod.getName()), false) + "Invoker";

		String classResourcePathString = null;

		final List<Annotation> classJaxRsAnnotations = getJaxRsAnnotations(resourceClass);
		for (final Annotation classAnnotation : classJaxRsAnnotations)
		{
			switch (classAnnotation.annotationType().getName())
			{
				case "javax.ws.rs.Path":
					final Path path = (Path) classAnnotation;
					classResourcePathString = path.value();
					break;

				default:
					throw new IllegalStateException("Unsupported JAX-RS class annotation: " + classAnnotation);
			}
		}

		classJaxRsAnnotations.stream().forEach(a -> System.out.println("class: " + resourceClass + ": " + a));

		final List<MediaType> consumesMediaTypes = new ArrayList<>();
		final List<MediaType> producesMediaTypes = new ArrayList<>();

		String httpMethod = null;
		String methodResourcePathString = null;

		final List<Annotation> methodJaxRsAnnotations = getJaxRsAnnotations(resourceMethod);
		for (final Annotation methodAnnotation : methodJaxRsAnnotations)
		{
			switch (methodAnnotation.annotationType().getName())
			{
				case "javax.ws.rs.Consumes":
					final Consumes consumes = (Consumes) methodAnnotation;
					consumesMediaTypes.addAll(stringsToMediaTypes(consumes.value()));
					break;

				case "javax.ws.rs.Produces":
					final Produces produces = (Produces) methodAnnotation;
					producesMediaTypes.addAll(stringsToMediaTypes(produces.value()));
					break;

				case "javax.ws.rs.DELETE":
					httpMethod = "DELETE";
					break;

				case "javax.ws.rs.HEAD":
					httpMethod = "HEAD";
					break;

				case "javax.ws.rs.GET":
					httpMethod = "GET";
					break;

				case "javax.ws.rs.OPTIONS":
					httpMethod = "OPTIONS";
					break;

				case "javax.ws.rs.POST":
					httpMethod = "POST";
					break;

				case "javax.ws.rs.PUT":
					httpMethod = "PUT";
					break;

				case "javax.ws.rs.Path":
					final Path path = (Path) methodAnnotation;
					methodResourcePathString = path.value();
					break;

				default:
					throw new IllegalStateException("Unsupported JAX-RS method annotation: " + methodAnnotation);
			}
		}
		consumesMediaTypes.add(MediaType.TEXT_PLAIN_TYPE);

		methodJaxRsAnnotations.stream().forEach(a -> System.out.println("method: " + resourceMethod + ": " + a));

		final TypeSpec.Builder invokerClassBuilder = TypeSpec.classBuilder(invokerName)
				.addModifiers(Modifier.PUBLIC, Modifier.FINAL)
				.superclass(ParameterizedTypeName.get(ComponentEntityInvoker.class, responseType));

		invokerClassBuilder.addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC)
				.addParameter(Transport.class, "transport", Modifier.FINAL).addStatement("super(transport)").build());

		final MethodSpec.Builder invokeMethodBuilder = MethodSpec.methodBuilder("invoke").returns(responseType)
				.addModifiers(Modifier.PUBLIC, Modifier.FINAL).addException(InvokerException.class);

		final TypeVariableName invokerTypeName = TypeVariableName.get(invokerName);
		
		addInvokerProperties(invokerClassBuilder, invokerTypeName, resourceMethod, invokeMethodBuilder,
				consumesMediaTypes.get(0));

		final String resourcePathString = Paths.get(classResourcePathString, methodResourcePathString).toString();
		invokeMethodBuilder.addComment("$L", resourcePathString);
		invokeMethodBuilder.addStatement("$T target = getBaseWebTarget()", WebTarget.class);

		// We need to add each of the path components. (methodPathString)
		// When we come across one that is a parameter, we need to compose the
		// path with the appropriate property.
		final List<String> pathComponents = PathUtils.getComponentsFromPathString(resourcePathString);
		for (String pathComponent : pathComponents)
		{
			if (pathComponent.matches("\\{.*\\}"))
			{
				final String propertyName = NameUtils.componentsToCamelCase(NameUtils.getNameComponents(pathComponent),
						true);
				invokeMethodBuilder.addStatement("target = target.path($L)", propertyName);
			}
			else
			{
				invokeMethodBuilder.addStatement("target = target.path($S)", pathComponent);
			}
		}

		final String mediaTypesString = producesMediaTypes.stream().map(mediaType -> "\"" + mediaType.toString() + "\"")
				.collect(Collectors.joining(", "));
		invokeMethodBuilder.addStatement("final $T invocationBuilder = target.request($L)", Invocation.Builder.class,
				mediaTypesString);
		invokeMethodBuilder.addStatement("final $T response = invocationBuilder.method($S, entity)", Response.class,
				httpMethod);

		invokeMethodBuilder.beginControlFlow("try");
		invokeMethodBuilder.addStatement("return handleComponentEntityResponse(response, $T.class)", responseType);
		invokeMethodBuilder.endControlFlow();
		invokeMethodBuilder.beginControlFlow("finally");
		invokeMethodBuilder.addStatement("response.close()");
		invokeMethodBuilder.endControlFlow();

		// final Response response =
		// baseWebTarget.path(PROCESS_GROUPS).path(groupId).path(LABELS)
		// .request(MediaType.APPLICATION_JSON).post(jsonEntity);

		invokerClassBuilder.addMethod(invokeMethodBuilder.build());

		return invokerClassBuilder.build();
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

					TypeSpec invokerTypeSpec;

					if (ComponentEntity.class.isAssignableFrom(invokerResponseType))
					{
						invokerTypeSpec = createComponentEntityInvokerTypeSpec(applicationResourceClass, restApiMethod,
								invokerResponseType);
					}
					else
					{
						// TODO: Replace this with a non-component-entity
						// invoker building method.
						invokerTypeSpec = createComponentEntityInvokerTypeSpec(applicationResourceClass, restApiMethod,
								invokerResponseType);
					}

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
