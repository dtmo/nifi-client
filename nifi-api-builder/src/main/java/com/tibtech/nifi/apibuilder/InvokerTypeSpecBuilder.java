package com.tibtech.nifi.apibuilder;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.lang.model.element.Modifier;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.nifi.web.api.dto.RevisionDTO;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;
import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;

public class InvokerTypeSpecBuilder
{
	private String invokerName;

	private Class<?> responseType;

	private String classResourcePathString;

	private String methodResourcePathString;

	private List<MediaType> consumesMediaTypes = new ArrayList<>();
	private List<MediaType> producesMediaTypes = new ArrayList<>();

	private String httpMethod;

	private List<InvokerProperty> pathParameters = new ArrayList<>();
	private List<InvokerProperty> queryParameters = new ArrayList<>();
	private List<InvokerProperty> formParameters = new ArrayList<>();

	private Class<?> requestEntityType = null;

	public String getInvokerName()
	{
		return invokerName;
	}

	public void setInvokerName(String invokerName)
	{
		this.invokerName = invokerName;
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

	public void addPathParameter(final String name, final Class<?> type, final String comment)
	{
		pathParameters.add(new InvokerProperty(name, type, comment));
	}

	public void addQueryParameter(final String name, final Class<?> type, final String comment)
	{
		queryParameters.add(new InvokerProperty(name, type, comment));
	}

	public void addFormParameter(final String name, final Class<?> type, final String comment)
	{
		formParameters.add(new InvokerProperty(name, type, comment));
	}

	public void setRequestEntityType(final Class<?> requestEntityType)
	{
		this.requestEntityType = requestEntityType;
	}

	private void addProperty(final TypeSpec.Builder typeSpecBuilder, final String restName, final Class<?> propertyType,
			final String comment)
	{
		final List<String> propertyNameComponents = NameUtils.getNameComponents(restName);
		final String propertyName = NameUtils.componentsToCamelCase(propertyNameComponents, true);

		typeSpecBuilder.addField(FieldSpec.builder(propertyType, propertyName, Modifier.PRIVATE).build());

		final String getterMethodName = "get" + NameUtils.componentsToCamelCase(propertyNameComponents, false);
		typeSpecBuilder.addMethod(MethodSpec.methodBuilder(getterMethodName).returns(propertyType)
				.addModifiers(Modifier.PUBLIC, Modifier.FINAL).addJavadoc(comment)
				.addStatement("return $L", propertyName).build());

		final TypeVariableName invokerTypeName = TypeVariableName.get(invokerName);
		final String setterMethodName = "set" + NameUtils.componentsToCamelCase(propertyNameComponents, false);
		typeSpecBuilder.addMethod(MethodSpec.methodBuilder(setterMethodName).returns(invokerTypeName)
				.addParameter(propertyType, propertyName, Modifier.FINAL).addModifiers(Modifier.PUBLIC, Modifier.FINAL)
				.addJavadoc(comment).addStatement("this.$L = $L", propertyName, propertyName)
				.addStatement("return this").build());
	}

	private void addEntity(final TypeSpec.Builder typeSpecBuilder) throws IntrospectionException
	{
		final BeanInfo beanInfo = Introspector.getBeanInfo(requestEntityType);

		final PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (final PropertyDescriptor propertyDescriptor : propertyDescriptors)
		{
			if (propertyDescriptor.getWriteMethod() != null)
			{
				if (RevisionDTO.class.isAssignableFrom(propertyDescriptor.getPropertyType()) == false)
				{
					addProperty(typeSpecBuilder, propertyDescriptor.getName(), propertyDescriptor.getPropertyType(), "");
				}
			}
		}
	}

	private void addInvokeMethod(final TypeSpec.Builder typeSpecBuilder) throws IntrospectionException
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

		for (final InvokerProperty invokerProperty : queryParameters)
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

		// TODO: Add Form parameters

		final String mediaTypesString = producesMediaTypes.stream().map(mediaType -> mediaType.toString())
				.collect(Collectors.joining(", "));
		invokeMethodBuilder.addStatement("final $T invocationBuilder = target.request($S)", Invocation.Builder.class,
				mediaTypesString);

		if (requestEntityType != null)
		{
			final String entityVariable = NameUtils
					.componentsToCamelCase(NameUtils.getNameComponents(requestEntityType.getSimpleName()), true);
			invokeMethodBuilder.addStatement("final $T $L = new $T()", requestEntityType, entityVariable,
					requestEntityType);

			final BeanInfo beanInfo = Introspector.getBeanInfo(requestEntityType);
			final PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			for (final PropertyDescriptor propertyDescriptor : propertyDescriptors)
			{
				if (propertyDescriptor.getWriteMethod() != null)
				{
					if (RevisionDTO.class.isAssignableFrom(propertyDescriptor.getPropertyType()) == false)
					{
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

			final MediaType mediaType = consumesMediaTypes.isEmpty() ? MediaType.TEXT_PLAIN_TYPE
					: consumesMediaTypes.get(0);

			invokeMethodBuilder.addStatement("final $T<$T> entity = $T.entity($L, $S)", javax.ws.rs.client.Entity.class,
					requestEntityType, javax.ws.rs.client.Entity.class, entityVariable, mediaType);

			invokeMethodBuilder.addStatement("final $T response = invocationBuilder.method($S, entity)", Response.class,
					httpMethod);
		}
		else
		{
			invokeMethodBuilder.addStatement("final $T response = invocationBuilder.method($S)", Response.class,
					httpMethod);
		}

		invokeMethodBuilder.beginControlFlow("try");
		invokeMethodBuilder.addStatement("return handleComponentEntityResponse(response, $T.class)", responseType);
		invokeMethodBuilder.endControlFlow();
		invokeMethodBuilder.beginControlFlow("finally");
		invokeMethodBuilder.addStatement("response.close()");
		invokeMethodBuilder.endControlFlow();

		typeSpecBuilder.addMethod(invokeMethodBuilder.build());
	}

	public TypeSpec build() throws IntrospectionException
	{
		final TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder(invokerName)
				.addModifiers(Modifier.PUBLIC, Modifier.FINAL)
				.superclass(ParameterizedTypeName.get(ComponentEntityInvoker.class, responseType));

		// Add a constructor
		typeSpecBuilder.addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC)
				.addParameter(Transport.class, "transport", Modifier.FINAL).addStatement("super(transport)").build());

		for (final InvokerProperty invokerProperty : pathParameters)
		{
			addProperty(typeSpecBuilder, invokerProperty.getName(), invokerProperty.getType(),
					invokerProperty.getComment());
		}

		for (final InvokerProperty invokerProperty : queryParameters)
		{
			// clientId and version are special properties that get set by the
			// invoker framework.
			if (invokerProperty.getName().equalsIgnoreCase("version") == false
					&& invokerProperty.getName().equalsIgnoreCase("clientId") == false)
			{
				addProperty(typeSpecBuilder, invokerProperty.getName(), invokerProperty.getType(),
						invokerProperty.getComment());
			}
		}

		for (final InvokerProperty invokerProperty : formParameters)
		{
			addProperty(typeSpecBuilder, invokerProperty.getName(), invokerProperty.getType(),
					invokerProperty.getComment());
		}

		if (requestEntityType != null)
		{
			addEntity(typeSpecBuilder);
		}

		addInvokeMethod(typeSpecBuilder);

		return typeSpecBuilder.build();
	}

	public static class InvokerProperty
	{
		private final String name;

		private final Class<?> type;

		private final String comment;

		public InvokerProperty(final String name, final Class<?> type, final String comment)
		{
			this.name = name;
			this.type = type;
			this.comment = comment;
		}

		public String getName()
		{
			return name;
		}

		public Class<?> getType()
		{
			return type;
		}

		public String getComment()
		{
			return comment;
		}
	}
}
