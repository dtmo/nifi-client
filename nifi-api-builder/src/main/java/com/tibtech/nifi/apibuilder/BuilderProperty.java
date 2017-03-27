package com.tibtech.nifi.apibuilder;

import com.squareup.javapoet.TypeName;

public class BuilderProperty
{
	private final String name;

	private final TypeName typeName;

	private final String comment;

	public BuilderProperty(final String name, final TypeName typeName, final String comment)
	{
		this.name = name;
		this.typeName = typeName;
		this.comment = comment;
	}

	public String getName()
	{
		return name;
	}

	public TypeName getTypeName()
	{
		return typeName;
	}

	public String getComment()
	{
		return comment;
	}
}