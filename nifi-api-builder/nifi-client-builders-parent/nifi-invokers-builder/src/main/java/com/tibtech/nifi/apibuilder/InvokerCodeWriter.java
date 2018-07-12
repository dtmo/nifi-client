package com.tibtech.nifi.apibuilder;

import java.beans.IntrospectionException;
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
import java.util.stream.StreamSupport;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.nifi.connectable.ConnectableType;
import org.apache.nifi.update.attributes.api.RuleResource;
import org.apache.nifi.web.api.ApplicationResource;
import org.apache.nifi.web.api.request.BulletinBoardPatternParameter;
import org.apache.nifi.web.api.request.ClientIdParameter;
import org.apache.nifi.web.api.request.ConnectableTypeParameter;
import org.apache.nifi.web.api.request.DateTimeParameter;
import org.apache.nifi.web.api.request.DoubleParameter;
import org.apache.nifi.web.api.request.IntegerParameter;
import org.apache.nifi.web.api.request.LongParameter;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

public class InvokerCodeWriter
{
	private static final Logger LOGGER = LogManager.getLogger(InvokerCodeWriter.class);
	
	private static void addInvokerProperties(final InvokerTypeSpecBuilder invokerTypeSpecBuilder,
			final Method resourceMethod) throws IntrospectionException
	{
		LOGGER.debug("Adding invoker properties: {}", resourceMethod);
		
		final Parameter[] parameters = resourceMethod.getParameters();
		for (final Parameter parameter : parameters)
		{
			final TypeName parameterTypeName = mapParameterTypeName(parameter);
			final Class<?> parameterType = mapParameterType(parameter);

			final ApiParam apiParam = parameter.getAnnotation(ApiParam.class);
			final String comment = apiParam != null ? apiParam.value() : "";

			if (parameter.getAnnotation(PathParam.class) != null)
			{
				// Add path parameter.
				final String name = parameter.getAnnotation(PathParam.class).value();

				invokerTypeSpecBuilder.addPathParameter(name, parameterType, parameterTypeName, comment);
			}
			else if (parameter.getAnnotation(QueryParam.class) != null)
			{
				// Add query parameter.
				final String name = parameter.getAnnotation(QueryParam.class).value();

				invokerTypeSpecBuilder.addQueryParameter(name, parameterType, parameterTypeName, comment);
			}
			else if (parameter.getAnnotation(FormParam.class) != null)
			{
				// Add form parameter.
				final String name = parameter.getAnnotation(FormParam.class).value();

				invokerTypeSpecBuilder.addFormParameter(name, parameterType, parameterTypeName, comment);
			}
			else if (parameter.getAnnotation(FormDataParam.class) != null)
			{
				// Add form data parameter.
				final String name = parameter.getAnnotation(FormDataParam.class).value();

				invokerTypeSpecBuilder.addFormDataParameter(name, parameterType, parameterTypeName, comment);
			}
			else if (parameter.getAnnotation(MatrixParam.class) != null)
			{
				throw new IllegalStateException(
						"Unsupported MatrixParam found on method: " + resourceMethod + " : " + parameter);
			}
			else if (parameter.getAnnotation(CookieParam.class) != null)
			{
				throw new IllegalStateException(
						"Unsupported CookieParam found on method: " + resourceMethod + " : " + parameter);
			}
			else if (parameter.getAnnotation(HeaderParam.class) != null)
			{
				throw new IllegalStateException(
						"Unsupported CookieParam found on method: " + resourceMethod + " : " + parameter);
			}
			else
			{
				// If the parameter is not annotated as a parameter, and is also
				// not annotated with @Context then treat it as an entity.
				if (parameter.getAnnotation(Context.class) == null)
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
		if (mappedParameterType != parameter.getType())
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
	private static Optional<String> getHttpMethod(final Method resourceMethod)
	{
		final Optional<String> method;

		if (resourceMethod.getAnnotation(DELETE.class) != null)
		{
			method = Optional.of(HttpMethod.DELETE);
		}
		else if (resourceMethod.getAnnotation(HEAD.class) != null)
		{
			method = Optional.of(HttpMethod.HEAD);
		}
		else if (resourceMethod.getAnnotation(GET.class) != null)
		{
			method = Optional.of(HttpMethod.GET);
		}
		else if (resourceMethod.getAnnotation(OPTIONS.class) != null)
		{
			method = Optional.of(HttpMethod.OPTIONS);
		}
		else if (resourceMethod.getAnnotation(POST.class) != null)
		{
			method = Optional.of(HttpMethod.POST);
		}
		else if (resourceMethod.getAnnotation(PUT.class) != null)
		{
			method = Optional.of(HttpMethod.PUT);
		}
		else
		{
			method = Optional.empty();
		}

		return method;
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

	private static TypeSpec createInvokerTypeSpec(final String resourcePath, final Class<?> resourceClass,
			final Deque<Method> resourceMethodStack) throws IntrospectionException
	{
		final Method endpointMethod = resourceMethodStack.peek();
		final String invokerName = getInvokerName(endpointMethod);
		final String httpMethod = getHttpMethod(endpointMethod).orElseThrow(
				() -> new IllegalStateException("Could not find a HTTP method for resource method: " + endpointMethod));
		final ApiOperation endpointMethodApiAnnotation = endpointMethod.getAnnotation(ApiOperation.class);
		final StringBuilder invokerDescriptionBuilder = new StringBuilder();
		if (endpointMethodApiAnnotation != null)
		{
			final String value = endpointMethodApiAnnotation.value();
			if ((value != null) && (value.isEmpty() == false))
			{
				invokerDescriptionBuilder.append(value);
				invokerDescriptionBuilder.append("\n");
			}

			final String notes = endpointMethodApiAnnotation.notes();
			if ((notes != null) && (notes.isEmpty() == false))
			{
				invokerDescriptionBuilder.append("<p>");
				invokerDescriptionBuilder.append(notes);
				invokerDescriptionBuilder.append("</p>\n");
			}
		}

		LOGGER.info("Creating invoker: {}.{}", getInvokerPackageName(resourceClass), invokerName);

		final InvokerTypeSpecBuilder invokerTypeSpecBuilder = new InvokerTypeSpecBuilder();
		invokerTypeSpecBuilder.setInvokerComment(invokerDescriptionBuilder.toString());
		invokerTypeSpecBuilder.setResourcePathString(resourcePath);
		invokerTypeSpecBuilder.setInvokerName(invokerName);
		invokerTypeSpecBuilder.setResponseType(endpointMethodApiAnnotation.response());
		invokerTypeSpecBuilder.setHttpMethod(httpMethod);
		invokerTypeSpecBuilder.setConsumesMediaTypes(getConsumedMediaTypes(endpointMethod));
		invokerTypeSpecBuilder.setProducesMediaTypes(getProducedMediaTypes(endpointMethod));

		for (final Method resourceMethod : resourceMethodStack)
		{
			addInvokerProperties(invokerTypeSpecBuilder, resourceMethod);
		}

		return invokerTypeSpecBuilder.build();
	}

	private static List<PackagedTypeSpec> recurseApplicationResources(final Function<String, String> packageNameMapper,
			final Class<?> resourceClass, final Deque<Method> resourceMethodStack, final String resourcePathPrefix)
	{
		LOGGER.debug("Recursing application resource: {}", resourceClass);
		
		final List<PackagedTypeSpec> packagedTypeSpecs = new ArrayList<>();

		final Path classPathAnnotation = resourceClass.getAnnotation(Path.class);
		final String classResourcePath = resourcePathPrefix
				+ (classPathAnnotation != null ? classPathAnnotation.value() : "");

		Arrays.stream(resourceClass.getMethods())
				.filter(method -> getHttpMethod(method).isPresent() || (method.getAnnotation(Path.class) != null))
				.forEach(resourceMethod ->
				{
					final Path methodPathAnnotation = resourceMethod.getAnnotation(Path.class);
					// The path annotation may well contain regular expressions prefixed with colons, which
					// the Paths class will not like the look of. We will need to strip the regex syntax
					// from the path before processing it.
					final String methodPathValue = methodPathAnnotation != null ? methodPathAnnotation.value() : "";
					final String strippedMethodPathValue = methodPathValue.replaceAll(":[^}]*\\}", "}");
					
					// Calling Paths.get on Windows platform returns a string with separators the wrong way around. Tsk.
					final String resourcePath = StreamSupport
							.stream(Paths.get(classResourcePath, strippedMethodPathValue).spliterator(), false)
							.map(path -> path.toString()).collect(Collectors.joining("/"));

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
									resourceMethodStack, resourcePath));
						}
						else
						{
							try
							{
								final TypeSpec invokerTypeSpec = createInvokerTypeSpec(resourcePath, resourceClass,
										resourceMethodStack);

								packagedTypeSpecs.add(new PackagedTypeSpec(
										packageNameMapper.apply(getInvokerPackageName(resourceClass)),
										invokerTypeSpec));
							}
							catch (final IntrospectionException e)
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

		final List<PackagedTypeSpec> packagedTypeSpecs = new ArrayList<>();

		packagedTypeSpecs.addAll(applicationResources.stream()
				.filter(resourceClass -> (resourceClass.getAnnotation(Api.class) == null)
						|| (resourceClass.getAnnotation(Api.class).hidden() == false))
				.map(resourceClass -> recurseApplicationResources(packageNameMapper, resourceClass, new ArrayDeque<>(),
						"nifi-api"))
				.reduce(new ArrayList<>(), (l, r) ->
				{
					l.addAll(r);
					return l;
				}));

		packagedTypeSpecs.addAll(recurseApplicationResources(packageNameMapper, RuleResource.class, new ArrayDeque<>(),
				"nifi-update-attribute-ui-1.7.0/api"));

		final java.nio.file.Path generatedJavaPath = Paths
				.get("../../nifi-1-client-parent/nifi-1.7.0-invokers/src/main/java");

		for (final PackagedTypeSpec packagedTypeSpec : packagedTypeSpecs)
		{
			final String builderPackageName = packagedTypeSpec.getPackageName().replaceFirst("org\\.apache",
					"com.tibtech");

			final JavaFile javaFile = JavaFile.builder(builderPackageName, packagedTypeSpec.getTypeSpec()).build();
			javaFile.writeTo(generatedJavaPath);
		}
	}
}
