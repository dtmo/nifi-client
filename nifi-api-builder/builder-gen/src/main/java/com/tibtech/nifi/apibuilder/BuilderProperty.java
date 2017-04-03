package com.tibtech.nifi.apibuilder;

import com.squareup.javapoet.TypeName;

public class BuilderProperty
{
	private final String name;

	private final Class<?> propertyClass;
	
	private final TypeName typeName;

	private final String comment;

	public BuilderProperty(final String name, final Class<?> propertyClass, final TypeName typeName, final String comment)
	{
		this.name = name;
		this.propertyClass = propertyClass;
		this.typeName = typeName;
		this.comment = comment;
	}

	public String getName()
	{
		return name;
	}

	public Class<?> getPropertyClass()
	{
		return propertyClass;
	}

	public TypeName getTypeName()
	{
		return typeName;
	}

	public String getComment()
	{
		return comment;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(" [name=");
		builder.append(name);
		builder.append(", propertyClass=");
		builder.append(propertyClass);
		builder.append(", typeName=");
		builder.append(typeName);
		builder.append(", comment=");
		builder.append(comment);
		builder.append("]");
		return builder.toString();
	}
}