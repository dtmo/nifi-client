package com.tibtech.nifi.apibuilder;

import com.squareup.javapoet.TypeSpec;

public class PackagedTypeSpec
{
	private final String packageName;

	private final TypeSpec typeSpec;

	public PackagedTypeSpec(final String packageName, final TypeSpec typeSpec)
	{
		this.packageName = packageName;
		this.typeSpec = typeSpec;
	}

	public String getPackageName()
	{
		return packageName;
	}

	public TypeSpec getTypeSpec()
	{
		return typeSpec;
	}
}
