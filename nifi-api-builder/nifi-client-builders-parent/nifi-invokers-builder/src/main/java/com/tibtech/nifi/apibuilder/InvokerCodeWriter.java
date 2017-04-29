package com.tibtech.nifi.apibuilder;

import java.beans.IntrospectionException;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Deque;
import java.util.List;
import java.util.Optional;
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

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.sun.jersey.multipart.FormDataParam;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

public class InvokerCodeWriter
{
	private static List<Annotation> getJaxRsAnnotations(final AnnotatedElement annotatedElement)
	{
		return Arrays.stream(annotatedElement.getAnnotations())
				.filter(a -> a.annotationType().getName().matches("javax\\.ws\\.rs\\..*|com\\.sun\\.jersey\\..*"))
				.collect(Collectors.toList());
	}

	private static void addInvokerProperties(final InvokerTypeSpecBuilder invokerTypeSpecBuilder,
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

			final TypeName parameterTypeName = mapParameterTypeName(parameter);
			final Class<?> parameterType = mapParameterType(parameter);

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

	private static TypeName mapParameterTypeName(final Parameter parameter)
	{
		final TypeName parameterTypeName;
		final Class<?> mappedParameterType = mapParameterType(parameter);
		if (mappedParameterType != parameter.getClass())
		{
			parameterTypeName = ClassName.get(mappedParameterType);
		}
		else
		{
			parameterTypeName = TypeName.get(parameter.getParameterizedType());
		}

		return parameterTypeName;
	}

	private static Class<?> mapParameterType(final Parameter parameter)
	{
		final Class<?> mappedClass;
		if (BulletinBoardPatternParameter.class.isAssignableFrom(parameter.getType()))
		{
			mappedClass = String.class;
		}
		else if (ClientIdParameter.class.isAssignableFrom(parameter.getType()))
		{
			mappedClass = String.class;
		}
		else if (ConnectableTypeParameter.class.isAssignableFrom(parameter.getType()))
		{
			mappedClass = ConnectableType.class;
		}
		else if (DateTimeParameter.class.isAssignableFrom(parameter.getType()))
		{
			mappedClass = Date.class;
		}
		else if (DoubleParameter.class.isAssignableFrom(parameter.getType()))
		{
			mappedClass = Double.class;
		}
		else if (IntegerParameter.class.isAssignableFrom(parameter.getType()))
		{
			mappedClass = Integer.class;
		}
		else if (LongParameter.class.isAssignableFrom(parameter.getType()))
		{
			mappedClass = Long.class;
		}
		else
		{
			mappedClass = parameter.getType();
		}

		return mappedClass;
	}

	/**
	 * Determine what HTTP method is being used base on annotations on the
	 * method (there should only be one!).
	 * 
	 * @param invokerTypeSpecBuilder
	 * @param resourceMethod
	 */
	private static String getHttpMethod(final Method resourceMethod)
	{
		final String method;

		if (resourceMethod.getAnnotation(DELETE.class) != null)
		{
			method = "DELETE";
		}
		else if (resourceMethod.getAnnotation(HEAD.class) != null)
		{
			method = "HEAD";
		}
		else if (resourceMethod.getAnnotation(GET.class) != null)
		{
			method = "GET";
		}
		else if (resourceMethod.getAnnotation(OPTIONS.class) != null)
		{
			method = "OPTIONS";
		}
		else if (resourceMethod.getAnnotation(POST.class) != null)
		{
			method = "POST";
		}
		else if (resourceMethod.getAnnotation(PUT.class) != null)
		{
			method = "PUT";
		}
		else
		{
			throw new IllegalStateException("Could not find a HTTP method for resource method: " + resourceMethod);
		}

		return method;
	}

	private static Optional<BuilderProperty> getRequestEntityBuilderProperty(final Method resourceMethod)
	{
		final Optional<BuilderProperty> optionalBuilderProperty;
		final Parameter[] parameters = resourceMethod.getParameters();
		if (parameters.length > 0)
		{
			final Parameter finalParameter = parameters[parameters.length - 1];
			if (Entity.class.isAssignableFrom(finalParameter.getType()))
			{
				final String entityPropertyName = NameUtils.componentsToCamelCase(
						NameUtils.getNameComponents(finalParameter.getType().getSimpleName()), true);

				final ApiParam apiParam = finalParameter.getAnnotation(ApiParam.class);
				final String comment = apiParam != null ? apiParam.value() : "";

				final BuilderProperty builderProperty = new BuilderProperty(entityPropertyName,
						finalParameter.getType(), mapParameterTypeName(finalParameter), comment, false, null);

				optionalBuilderProperty = Optional.of(builderProperty);
			}
			else
			{
				optionalBuilderProperty = Optional.empty();
			}
		}
		else
		{
			optionalBuilderProperty = Optional.empty();
		}

		return optionalBuilderProperty;
	}

	private static List<MediaType> getConsumedMediaTypes(final Method resourceMethod)
	{
		final List<MediaType> consumedMediaTypes = new ArrayList<>();
		final Consumes[] consumesAnnotations = resourceMethod.getAnnotationsByType(Consumes.class);
		for (final Consumes consumesAnnotation : consumesAnnotations)
		{
			final String[] consumedMediaTypeStrings = consumesAnnotation.value();
			for (final String consumedMediaTypeString : consumedMediaTypeStrings)
			{
				consumedMediaTypes.add(MediaType.valueOf(consumedMediaTypeString));
			}
		}
		return consumedMediaTypes;
	}

	private static List<MediaType> getProducedMediaTypes(final Method resourceMethod)
	{
		final List<MediaType> producedMediaTypes = new ArrayList<>();
		final Produces[] producesAnnotations = resourceMethod.getAnnotationsByType(Produces.class);
		for (final Produces producesAnnotation : producesAnnotations)
		{
			final String[] producedMediaTypeStrings = producesAnnotation.value();
			for (final String producedMediaTypeString : producedMediaTypeStrings)
			{
				producedMediaTypes.add(MediaType.valueOf(producedMediaTypeString));
			}
		}
		return producedMediaTypes;
	}

	private static String getInvokerName(final Method resourceMethod)
	{
		return NameUtils.componentsToCamelCase(NameUtils.getNameComponents(resourceMethod.getName()), false)
				+ "Invoker";
	}

	private static String getInvokerPackageName(final Class<?> resourceClass)
	{
		final List<String> resourceClassNameComponents = NameUtils.getNameComponents(resourceClass.getSimpleName());
		final String packageName = resourceClass.getPackage().getName() + "."
				+ resourceClassNameComponents.subList(0, Math.max(1, resourceClassNameComponents.size() - 1)).stream()
						.map(s -> s.toLowerCase()).collect(Collectors.joining());
		return packageName;
	}

	private static TypeSpec createInvokerTypeSpec(final String classResourcePath, final Class<?> resourceClass,
			final String methodResourcePath, final Deque<Method> resourceMethodStack) throws IntrospectionException
	{
		final Method endpointMethod = resourceMethodStack.peek();
		final String invokerName = getInvokerName(endpointMethod);
		final String httpMethod = getHttpMethod(endpointMethod);
		final ApiOperation endpointMethodApiAnnotation = endpointMethod.getAnnotation(ApiOperation.class);
		final String invokerDescription = endpointMethodApiAnnotation != null
				? endpointMethodApiAnnotation.value() + "\n" : "";

		System.out.println(getInvokerPackageName(resourceClass) + "." + invokerName);

		final InvokerTypeSpecBuilder invokerTypeSpecBuilder = new InvokerTypeSpecBuilder();
		invokerTypeSpecBuilder.setInvokerComment(invokerDescription);
		invokerTypeSpecBuilder.setClassResourcePathString(classResourcePath);
		invokerTypeSpecBuilder.setMethodResourcePathString(methodResourcePath);
		invokerTypeSpecBuilder.setInvokerName(invokerName);
		invokerTypeSpecBuilder.setResponseType(endpointMethodApiAnnotation.response());
		invokerTypeSpecBuilder.setHttpMethod(httpMethod);
		invokerTypeSpecBuilder.setConsumesMediaTypes(getConsumedMediaTypes(endpointMethod));
		invokerTypeSpecBuilder.setProducesMediaTypes(getProducedMediaTypes(endpointMethod));
		invokerTypeSpecBuilder.setRequestEntity(getRequestEntityBuilderProperty(endpointMethod).orElse(null));

		for (final Method resourceMethod : resourceMethodStack)
		{
			addInvokerProperties(invokerTypeSpecBuilder, resourceMethod);
		}

		return invokerTypeSpecBuilder.build();
	}

	private static List<PackagedTypeSpec> recurseApplicationResources(final Function<String, String> packageNameMapper,
			final Class<?> resourceClass, final Deque<Method> resourceMethodStack, final String resourcePathPrefix)
	{
		final List<PackagedTypeSpec> packagedTypeSpecs = new ArrayList<>();

		final Path classPathAnnotation = resourceClass.getAnnotation(Path.class);
		final String classResourcePath = resourcePathPrefix
				+ (classPathAnnotation != null ? classPathAnnotation.value() : "");

		Arrays.stream(resourceClass.getMethods()).filter(method -> method.getAnnotation(Path.class) != null)
				.forEach(resourceMethod ->
				{
					final Path methodPathAnnotation = resourceMethod.getAnnotation(Path.class);
					final String methodResourcePath = methodPathAnnotation != null ? methodPathAnnotation.value() : "";

					// We accumulate the methods that take us to the end-point
					// so that they can all contribute parameters to the final
					// invoker.
					resourceMethodStack.push(resourceMethod);

					final ApiOperation methodApiOperationAnnotation = resourceMethod.getAnnotation(ApiOperation.class);
					if (methodApiOperationAnnotation != null)
					{
						final Class<?> responseClass = methodApiOperationAnnotation.response();
						if (ApplicationResource.class.isAssignableFrom(responseClass))
						{
							packagedTypeSpecs.addAll(recurseApplicationResources(packageNameMapper, responseClass,
									resourceMethodStack, classResourcePath + "/" + methodResourcePath));
						}
						else
						{
							try
							{
								final TypeSpec invokerTypeSpec = createInvokerTypeSpec(classResourcePath, resourceClass,
										methodResourcePath, resourceMethodStack);

								packagedTypeSpecs.add(new PackagedTypeSpec(
										packageNameMapper.apply(getInvokerPackageName(resourceClass)),
										invokerTypeSpec));
							}
							catch (IntrospectionException e)
							{
								throw new IllegalStateException("Could not create invoker class", e);
							}
						}
					}

					resourceMethodStack.pop();
				});

		return packagedTypeSpecs;
	}

	public static void main(final String[] args) throws Exception
	{
		final Reflections reflections = new Reflections("org.apache.nifi", new SubTypesScanner(true));
		final Set<Class<? extends ApplicationResource>> applicationResources = reflections
				.getSubTypesOf(ApplicationResource.class);

		final Function<String, String> packageNameMapper = s -> s.replaceFirst("org\\.apache", "com.tibtech");

		final List<PackagedTypeSpec> packagedTypeSpecs = applicationResources.stream()
				.filter(resourceClass -> resourceClass.getAnnotation(Api.class) == null
						|| resourceClass.getAnnotation(Api.class).hidden() == false)
				.map(resourceClass -> recurseApplicationResources(packageNameMapper, resourceClass, new ArrayDeque<>(),
						""))
				.reduce(new ArrayList<>(), (l, r) ->
				{
					l.addAll(r);
					return l;
				});

		final java.nio.file.Path generatedJavaPath = Paths.get("../../nifi-client-parent/nifi-1.1.2-client-parent/nifi-1.1.2-invokers/src/main/java");

		for (final PackagedTypeSpec packagedTypeSpec : packagedTypeSpecs)
		{
			final String builderPackageName = packagedTypeSpec.getPackageName().replaceFirst("org\\.apache",
					"com.tibtech");

			final JavaFile javaFile = JavaFile.builder(builderPackageName, packagedTypeSpec.getTypeSpec()).build();
			javaFile.writeTo(generatedJavaPath);
		}
	}
}
