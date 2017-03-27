package com.tibtech.nifi.apibuilder;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Modifier;
import javax.ws.rs.core.MediaType;

import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import com.tibtech.nifi.client.ComponentEntityInvoker;
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

	public List<MediaType> getProducesMediaTypes()
	{
		return producesMediaTypes;
	}

	public void setProducesMediaTypes(List<MediaType> producesMediaTypes)
	{
		this.producesMediaTypes = producesMediaTypes;
	}

	public String getHttpMethod()
	{
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod)
	{
		this.httpMethod = httpMethod;
	}

	public TypeSpec build()
	{
		final TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder(invokerName)
				.addModifiers(Modifier.PUBLIC, Modifier.FINAL)
				.superclass(ParameterizedTypeName.get(ComponentEntityInvoker.class, responseType));

		// Add a constructor
		typeSpecBuilder.addMethod(MethodSpec.constructorBuilder().addModifiers(Modifier.PUBLIC)
				.addParameter(Transport.class, "transport", Modifier.FINAL).addStatement("super(transport)").build());

		return typeSpecBuilder.build();
	}
}
