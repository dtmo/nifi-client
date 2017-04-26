package com.tibtech.nifi.apibuilder;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.lang.model.element.Modifier;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.nifi.web.api.entity.ComponentEntity;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.file.StreamDataBodyPart;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;
import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;

public class InvokerTypeSpecBuilder
{
	private static final Pattern PATH_VARIABLE_PATTERN = Pattern.compile("\\{([^:]*)(:.*)?\\}");
	private String invokerName;
	private String invokerComment;
	
	private Class<?> responseType;

	private String classResourcePathString;

	private String methodResourcePathString;

	private List<MediaType> consumesMediaTypes = new ArrayList<>();
	private List<MediaType> producesMediaTypes = new ArrayList<>();

	private String httpMethod;

	private List<BuilderProperty> pathParameters = new ArrayList<>();
	private List<BuilderProperty> queryParameters = new ArrayList<>();
	private List<BuilderProperty> formParameters = new ArrayList<>();
	private List<BuilderProperty> formDataParameters = new ArrayList<>();

	private BuilderProperty requestEntity = null;

	public String getInvokerName()
	{
		return invokerName;
	}

	public void setInvokerName(String invokerName)
	{
		this.invokerName = invokerName;
	}

	public String getInvokerComment()
	{
		return invokerComment;
	}

	public void setInvokerComment(String invokerComment)
	{
		this.invokerComment = invokerComment;
	}

	public Class<?> getResponseType()
	{
		return responseType;
	}

	public void setResponseType(Class<?> responseType)
	{
		this.responseType = responseType;
	}

	public String getClassResourcePathString()
	{
		return classResourcePathString;
	}

	public void setClassResourcePathString(String classResourcePathString)
	{
		this.classResourcePathString = classResourcePathString;
	}

	public String getMethodResourcePathString()
	{
		return methodResourcePathString;
	}

	public void setMethodResourcePathString(String methodResourcePathString)
	{
		this.methodResourcePathString = methodResourcePathString;
	}

	public List<MediaType> getConsumesMediaTypes()
	{
		return consumesMediaTypes;
	}

	public void setConsumesMediaTypes(List<MediaType> consumesMediaTypes)
	{
		this.consumesMediaTypes = consumesMediaTypes;
	}

	public void addConsumesMediaType(final MediaType mediaType)
	{
		consumesMediaTypes.add(mediaType);
	}

	public void addConsumesMediaTypes(final Collection<MediaType> mediaTypes)
	{
		consumesMediaTypes.addAll(mediaTypes);
	}

	public List<MediaType> getProducesMediaTypes()
	{
		return producesMediaTypes;
	}

	public void setProducesMediaTypes(List<MediaType> producesMediaTypes)
	{
		this.producesMediaTypes = producesMediaTypes;
	}

	public void addProducesMediaType(final MediaType mediaType)
	{
		producesMediaTypes.add(mediaType);
	}

	public void addProducesMediaTypes(final Collection<MediaType> mediaTypes)
	{
		producesMediaTypes.addAll(mediaTypes);
	}

	public String getHttpMethod()
	{
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod)
	{
		this.httpMethod = httpMethod;
	}

	public void addPathParameter(final String name, final Class<?> propertyClass, final TypeName typeName,
			final String comment)
	{
		pathParameters.add(new BuilderProperty(name, propertyClass, typeName, comment, false, null));
	}

	public BuilderProperty findPathParameter(final String name)
	{
		return pathParameters.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
	}

	public void addQueryParameter(final String name, final Class<?> propertyClass, final TypeName typeName,
			final String comment)
	{
		queryParameters.add(new BuilderProperty(name, propertyClass, typeName, comment, false, null));
	}

	public void addFormParameter(final String name, final Class<?> propertyClass, final TypeName typeName,
			final String comment)
	{
		formParameters.add(new BuilderProperty(name, propertyClass, typeName, comment, false, null));
	}

	public void addFormDataParameter(final String name, final Class<?> propertyClass, final TypeName typeName,
			final String comment)
	{
		formDataParameters.add(new BuilderProperty(name, propertyClass, typeName, comment, false, null));
	}

	public void setRequestEntity(final BuilderProperty requestEntity)
	{
		this.requestEntity = requestEntity;
	}

	private void addProperty(final TypeSpec.Builder typeSpecBuilder, final String restName,
			final TypeName propertyTypeName, final String comment)
	{
		final List<String> propertyNameComponents = NameUtils.getNameComponents(restName);
		final String propertyName = NameUtils.componentsToCamelCase(propertyNameComponents, true);

		typeSpecBuilder.addField(FieldSpec.builder(propertyTypeName, propertyName, Modifier.PRIVATE).build());

		final String getterMethodName = "get" + NameUtils.componentsToCamelCase(propertyNameComponents, false);
		typeSpecBuilder.addMethod(MethodSpec.methodBuilder(getterMethodName).returns(propertyTypeName)
				.addModifiers(Modifier.PUBLIC, Modifier.FINAL).addJavadoc(comment)
				.addStatement("return $L", propertyName).build());

		final TypeVariableName invokerTypeName = TypeVariableName.get(invokerName);
		final String setterMethodName = "set" + NameUtils.componentsToCamelCase(propertyNameComponents, false);
		typeSpecBuilder.addMethod(MethodSpec.methodBuilder(setterMethodName).returns(invokerTypeName)
				.addParameter(propertyTypeName, propertyName, Modifier.FINAL)
				.addModifiers(Modifier.PUBLIC, Modifier.FINAL).addJavadoc(comment)
				.addStatement("this.$L = $L", propertyName, propertyName).addStatement("return this").build());
	}

	private void addInvokeMethod(final TypeSpec.Builder typeSpecBuilder)
	{
		final MethodSpec.Builder invokeMethodBuilder = MethodSpec.methodBuilder("invoke").returns(responseType)
				.addModifiers(Modifier.PUBLIC, Modifier.FINAL).addException(InvokerException.class);

		final String resourcePathString = Paths.get(classResourcePathString, methodResourcePathString).toString();
		invokeMethodBuilder.addComment("$L", resourcePathString);
		invokeMethodBuilder.addStatement("$T target = getBaseWebTarget()", WebTarget.class);

		// We need to add each of the path components. (methodPathString)
		// When we come across one that is a parameter, we need to compose the
		// path with the appropriate property.
		final List<String> pathComponents = PathUtils.getComponentsFromPathString(resourcePathString);
		for (String pathComponent : pathComponents)
		{
			final Matcher matcher = PATH_VARIABLE_PATTERN.matcher(pathComponent);
			if (matcher.matches())
			{
				final String pathParameter = matcher.group(1);
				final BuilderProperty pathBuilderParameter = findPathParameter(pathParameter);
				final String propertyName = NameUtils
						.componentsToCamelCase(NameUtils.getNameComponents(pathBuilderParameter.getName()), true);
				if (pathBuilderParameter.getPropertyClass() == int.class)
				{
					invokeMethodBuilder.addStatement("target = target.path(Integer.toString($L))", propertyName);
				}
				else if (pathBuilderParameter.getPropertyClass() == Integer.class)
				{
					invokeMethodBuilder.addStatement("target = target.path($L.toString())", propertyName);
				}
				else if (pathBuilderParameter.getPropertyClass() == long.class)
				{
					invokeMethodBuilder.addStatement("target = target.path(Long.toString($L))", propertyName);
				}
				else if (pathBuilderParameter.getPropertyClass() == Long.class)
				{
					invokeMethodBuilder.addStatement("target = target.path($L.toString())", propertyName);
				}
				else
				{
					invokeMethodBuilder.addStatement("target = target.path($L)", propertyName);
				}
			}
			else
			{
				invokeMethodBuilder.addStatement("target = target.path($S)", pathComponent);
			}
		}

		for (final BuilderProperty invokerProperty : queryParameters)
		{
			// clientId and version are special parameters that get set by the
			// invoker framework.
			if (invokerProperty.getName().equalsIgnoreCase("clientId"))
			{
				invokeMethodBuilder.addStatement("target = target.queryParam($S, getClientId())",
						invokerProperty.getName());
			}
			else if (invokerProperty.getName().equalsIgnoreCase("version"))
			{
				invokeMethodBuilder.addStatement("target = target.queryParam($S, getVersion())",
						invokerProperty.getName());
			}
			else
			{
				final String propertyName = NameUtils
						.componentsToCamelCase(NameUtils.getNameComponents(invokerProperty.getName()), true);

				invokeMethodBuilder.addStatement("target = target.queryParam($S, $L)", invokerProperty.getName(),
						propertyName);
			}
		}

		if (formParameters.isEmpty() == false)
		{
			invokeMethodBuilder.addStatement("final $T form = new $T()", Form.class, Form.class);

			for (final BuilderProperty invokerProperty : formParameters)
			{
				final String formParamName = invokerProperty.getName();
				if (formParamName.equalsIgnoreCase("clientId"))
				{
					invokeMethodBuilder.addStatement("form.param($S, getClientId())", invokerProperty.getName());
				}
				else if (formParamName.equalsIgnoreCase("version"))
				{
					invokeMethodBuilder.addStatement("form.param($S, getVersion().toString())",
							invokerProperty.getName());
				}
				else
				{
					final String formParamValue = NameUtils
							.componentsToCamelCase(NameUtils.getNameComponents(invokerProperty.getName()), true);
					invokeMethodBuilder.addStatement("form.param($S, $L)", formParamName, formParamValue);
				}
			}

			invokeMethodBuilder.addStatement("final $T<$T> entity = $T.form(form)", Entity.class, Form.class,
					Entity.class);

			final String mediaTypesString = producesMediaTypes.stream().map(mediaType -> mediaType.toString())
					.collect(Collectors.joining(", "));
			invokeMethodBuilder.addStatement("final $T invocationBuilder = target.request($S)",
					Invocation.Builder.class, mediaTypesString);

			invokeMethodBuilder.addStatement("final $T response = invocationBuilder.method($S, entity)", Response.class,
					httpMethod);
		}
		else if (formDataParameters.isEmpty() == false)
		{
			invokeMethodBuilder.addStatement("final $T formDataMultiPart = new $T()", FormDataMultiPart.class,
					FormDataMultiPart.class);
			for (final BuilderProperty formDataParameter : formDataParameters)
			{
				final String propertyName = NameUtils
						.componentsToCamelCase(NameUtils.getNameComponents(formDataParameter.getName()), true);
				if (InputStream.class.isAssignableFrom(formDataParameter.getPropertyClass()))
				{
					invokeMethodBuilder.addStatement("final $T streamDataBodyPart = new $T($S, $L)",
							StreamDataBodyPart.class, StreamDataBodyPart.class, formDataParameter.getName(),
							propertyName);
					invokeMethodBuilder.addStatement("formDataMultiPart.bodyPart(streamDataBodyPart)");
				}
				else
				{
					if (propertyName.equalsIgnoreCase("clientId"))
					{
						invokeMethodBuilder.addStatement("formDataMultiPart.field($S, getClientId())",
								formDataParameter.getName());
					}
					else if (propertyName.equalsIgnoreCase("version"))
					{
						invokeMethodBuilder.addStatement("formDataMultiPart.field($S, getVersion())",
								formDataParameter.getName());
					}
					else
					{
						invokeMethodBuilder.addStatement("formDataMultiPart.field($S, $L)", formDataParameter.getName(),
								propertyName);
					}
				}
			}

			invokeMethodBuilder.addStatement(
					"final $T<$T> entity = $T.entity(formDataMultiPart, formDataMultiPart.getMediaType())",
					Entity.class, FormDataMultiPart.class, Entity.class);

			final String mediaTypesString = producesMediaTypes.stream().map(mediaType -> mediaType.toString())
					.collect(Collectors.joining(", "));
			invokeMethodBuilder.addStatement("final $T invocationBuilder = target.request($S)",
					Invocation.Builder.class, mediaTypesString);

			invokeMethodBuilder.addStatement("final $T response = invocationBuilder.method($S, entity)", Response.class,
					httpMethod);
		}
		else
		{
			final String mediaTypesString = producesMediaTypes.stream().map(mediaType -> mediaType.toString())
					.collect(Collectors.joining(", "));
			invokeMethodBuilder.addStatement("final $T invocationBuilder = target.request($S)",
					Invocation.Builder.class, mediaTypesString);

			if (requestEntity != null)
			{
				if (ComponentEntity.class.isAssignableFrom(requestEntity.getPropertyClass()))
				{
					invokeMethodBuilder.addStatement("$L.setRevision(createRevisionDto())", requestEntity.getName());
				}

				final MediaType mediaType = consumesMediaTypes.isEmpty() ? MediaType.TEXT_PLAIN_TYPE
						: consumesMediaTypes.get(0);

				invokeMethodBuilder.addStatement("final $T<$T> entity = $T.entity($L, $S)",
						javax.ws.rs.client.Entity.class, requestEntity.getTypeName(), javax.ws.rs.client.Entity.class,
						requestEntity.getName(), mediaType);

				invokeMethodBuilder.addStatement("final $T response = invocationBuilder.method($S, entity)",
						Response.class, httpMethod);
			}
			else
			{
				invokeMethodBuilder.addStatement("final $T response = invocationBuilder.method($S)", Response.class,
						httpMethod);
			}
		}

		invokeMethodBuilder.beginControlFlow("try");
		if (ComponentEntity.class.isAssignableFrom(responseType))
		{
			invokeMethodBuilder.addStatement("return handleComponentEntityResponse(response, $T.class)", responseType);
		}
		else
		{
			invokeMethodBuilder.addStatement("return handleResponse(response, $T.class)", responseType);
		}
		invokeMethodBuilder.endControlFlow();
		invokeMethodBuilder.beginControlFlow("finally");
		invokeMethodBuilder.addStatement("response.close()");

		if (formDataParameters.isEmpty() == false)
		{
			invokeMethodBuilder.beginControlFlow("try");
			invokeMethodBuilder.addStatement("formDataMultiPart.close()");
			invokeMethodBuilder.endControlFlow();
			invokeMethodBuilder.beginControlFlow("catch (final $T e)", IOException.class);
			invokeMethodBuilder.addStatement("throw new $T($S, e)", InvokerException.class,
					"Could not close form data multipart");
			invokeMethodBuilder.endControlFlow();
		}

		invokeMethodBuilder.endControlFlow();

		typeSpecBuilder.addMethod(invokeMethodBuilder.build());
	}

	public TypeSpec build()
	{
		final TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder(invokerName).addModifiers(Modifier.PUBLIC,
				Modifier.FINAL).addJavadoc(invokerComment);

		if (ComponentEntity.class.isAssignableFrom(responseType))
		{
			typeSpecBuilder.superclass(ParameterizedTypeName.get(ComponentEntityInvoker.class, responseType));
		}
		else
		{
			typeSpecBuilder.superclass(ParameterizedTypeName.get(AbstractInvoker.class, responseType));
		}

		// Add a constructor
		typeSpecBuilder.addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC)
				.addParameter(Transport.class, "transport", Modifier.FINAL)
				.addParameter(long.class, "version", Modifier.FINAL).addStatement("super(transport, version)").build());

		for (final BuilderProperty invokerProperty : pathParameters)
		{
			addProperty(typeSpecBuilder, invokerProperty.getName(), invokerProperty.getTypeName(),
					invokerProperty.getComment());
		}

		for (final BuilderProperty invokerProperty : queryParameters)
		{
			// clientId and version are special properties that get set by the
			// invoker framework.
			if (invokerProperty.getName().equalsIgnoreCase("version") == false
					&& invokerProperty.getName().equalsIgnoreCase("clientId") == false)
			{
				addProperty(typeSpecBuilder, invokerProperty.getName(), invokerProperty.getTypeName(),
						invokerProperty.getComment());
			}
		}

		for (final BuilderProperty invokerProperty : formParameters)
		{
			// clientId and version are special properties that get set by the
			// invoker framework.
			if (invokerProperty.getName().equalsIgnoreCase("version") == false
					&& invokerProperty.getName().equalsIgnoreCase("clientId") == false)
			{
				addProperty(typeSpecBuilder, invokerProperty.getName(), invokerProperty.getTypeName(),
						invokerProperty.getComment());
			}
		}

		for (final BuilderProperty invokerProperty : formDataParameters)
		{
			// clientId and version are special properties that get set by the
			// invoker framework.
			if (invokerProperty.getName().equalsIgnoreCase("version") == false
					&& invokerProperty.getName().equalsIgnoreCase("clientId") == false)
			{
				addProperty(typeSpecBuilder, invokerProperty.getName(), invokerProperty.getTypeName(),
						invokerProperty.getComment());
			}
		}

		if (requestEntity != null)
		{
			addProperty(typeSpecBuilder, requestEntity.getName(), requestEntity.getTypeName(),
					requestEntity.getComment());
		}

		addInvokeMethod(typeSpecBuilder);

		return typeSpecBuilder.build();
	}
}
