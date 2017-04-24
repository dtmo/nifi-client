package com.tibtech.nifi.apibuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeSpec.Builder;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class ConfigurableComponentPropertiesBuilderTypeSpecBuilder
{
	private static final String PROPERTY_NAME_SUFFIX = "_PROPERTY";

	private final ClassName builderClassName;

	public ConfigurableComponentPropertiesBuilderTypeSpecBuilder(final ClassName builderClassName)
	{
		this.builderClassName = builderClassName;
	}

	public ConfigurableComponentPropertiesBuilderTypeSpecBuilder(final String packageName, final String classname)
	{
		this(ClassName.get(packageName, classname));
	}

	private final List<ConfigurableComponentProperty> configurableComponentProperties = new ArrayList<>();

	public void addConfigurableComponentProperty(final ConfigurableComponentProperty configurableComponentProperty)
	{
		this.configurableComponentProperties.add(configurableComponentProperty);
	}

	protected void addPropertyNameConstant(final TypeSpec.Builder typeSpecBuilder,
			final ConfigurableComponentProperty configurableComponentProperty)
	{
		final List<String> nameComponents = NameUtils
				.getNameComponents(configurableComponentProperty.getPropertyText());
		final String propertyConstantName = NameUtils.componentsToConstantName(nameComponents) + PROPERTY_NAME_SUFFIX;

		// Add the field with Javadoc.
		typeSpecBuilder.addField(FieldSpec
				.builder(String.class, propertyConstantName, Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
				.initializer("$S", configurableComponentProperty.getPropertyText())
				.addJavadoc(configurableComponentProperty.getPropertyDescription().replaceAll("\\$", "\\$\\$") + "\n")
				.build());
	}

	protected void addStaticPropertyMethods(final TypeSpec.Builder typeSpecBuilder,
			final ConfigurableComponentProperty configurableComponentProperty)
	{
		final List<String> nameComponents = NameUtils
				.getNameComponents(configurableComponentProperty.getPropertyText());
		final String propertyConstantName = NameUtils.componentsToConstantName(nameComponents) + PROPERTY_NAME_SUFFIX;
		final String propertyName = NameUtils.componentsToCamelCase(nameComponents, true);
		final String javadocComment = configurableComponentProperty.getPropertyDescription().replaceAll("\\$", "\\$\\$")
				+ "\n";

		// Add a getter method.
		final String getterName = "get" + Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
		typeSpecBuilder.addMethod(MethodSpec.methodBuilder(getterName).addModifiers(Modifier.PUBLIC, Modifier.FINAL)
				.returns(String.class).addJavadoc(javadocComment)
				.addStatement("return properties.get($L)", propertyConstantName).build());

		// Add a setter method.
		final String setterName = "set" + Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
		typeSpecBuilder.addMethod(MethodSpec.methodBuilder(setterName).addModifiers(Modifier.PUBLIC, Modifier.FINAL)
				.returns(builderClassName).addParameter(String.class, propertyName, Modifier.FINAL)
				.addJavadoc(javadocComment).addStatement("properties.put($L, $L)", propertyConstantName, propertyName)
				.addStatement("return this").build());

		// Add a remove method.
		final String removerName = "remove" + Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
		typeSpecBuilder.addMethod(MethodSpec.methodBuilder(removerName).addModifiers(Modifier.PUBLIC, Modifier.FINAL)
				.returns(builderClassName).addJavadoc(javadocComment)
				.addStatement("properties.remove($L)", propertyConstantName).addStatement("return this").build());
	}

	protected void addDynamicPropertyMethods(final TypeSpec.Builder typeSpecBuilder)
	{
		// Add a getter for dynamic properties
		typeSpecBuilder
				.addMethod(MethodSpec.methodBuilder("getDynamicProperty").addModifiers(Modifier.PUBLIC, Modifier.FINAL)
						.returns(String.class).addParameter(String.class, "name", Modifier.FINAL)
						.addStatement("return properties.get($L)", "name").build());

		// Add a setter for dynamic properties
		typeSpecBuilder.addMethod(MethodSpec.methodBuilder("setDynamicProperty")
				.addModifiers(Modifier.PUBLIC, Modifier.FINAL).returns(builderClassName)
				.addParameter(String.class, "name", Modifier.FINAL).addParameter(String.class, "value", Modifier.FINAL)
				.addStatement("properties.put($L, $L)", "name", "value").addStatement("return this").build());

		// Add a remove method for dynamic properties.
		typeSpecBuilder.addMethod(
				MethodSpec.methodBuilder("removeDynamicProperty").addModifiers(Modifier.PUBLIC, Modifier.FINAL)
						.returns(builderClassName).addParameter(String.class, "name", Modifier.FINAL)
						.addStatement("properties.remove($L)", "name").addStatement("return this").build());
	}

	protected void addConfiguratorFactoryMethods(final TypeSpec.Builder typeSpecBuilder)
	{
		// Add a lambda based configurator factory method
		typeSpecBuilder.addMethod(
				MethodSpec.methodBuilder("build").addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
						.returns(ParameterizedTypeName.get(Map.class, String.class, String.class))
						.addParameter(ParameterSpec.builder(ParameterizedTypeName.get(ClassName.get(Function.class),
								builderClassName, builderClassName), "configurator", Modifier.FINAL).build())
						.addStatement("return configurator.apply(new $T()).build()", builderClassName).build());

		// Add a Closure based configurator factory method

		typeSpecBuilder.addMethod(MethodSpec.methodBuilder("build")
				.addModifiers(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL)
				.returns(ParameterizedTypeName.get(Map.class, String.class, String.class))
				.addParameter(ParameterSpec
						.builder(ParameterizedTypeName.get(ClassName.get(Closure.class), builderClassName), "closure",
								Modifier.FINAL)
						.addAnnotation(
								AnnotationSpec.builder(DelegatesTo.class).addMember("strategy", "Closure.DELEGATE_ONLY")
										.addMember("value", "$T.class", builderClassName).build())
						.build())
				.beginControlFlow("return build(c ->")
				.addStatement("final Closure<$L> code = closure.rehydrate(c, $L.class, $L.class)", builderClassName,
						builderClassName, builderClassName)
				.addStatement("code.setResolveStrategy(Closure.DELEGATE_ONLY)").addStatement("code.call()")
				.addStatement("return c").endControlFlow(")").build());
	}

	public TypeSpec build()
	{
		final Builder typeSpecBuilder = TypeSpec.classBuilder(builderClassName).addModifiers(Modifier.PUBLIC,
				Modifier.FINAL);

		for (final ConfigurableComponentProperty configurableComponentProperty : configurableComponentProperties)
		{
			addPropertyNameConstant(typeSpecBuilder, configurableComponentProperty);
		}

		typeSpecBuilder.addField(FieldSpec
				.builder(ParameterizedTypeName.get(Map.class, String.class, String.class), "properties",
						Modifier.PRIVATE, Modifier.FINAL)
				.initializer("new $T()", ParameterizedTypeName.get(HashMap.class, String.class, String.class)).build());

		for (final ConfigurableComponentProperty configurableComponentProperty : configurableComponentProperties)
		{
			addStaticPropertyMethods(typeSpecBuilder, configurableComponentProperty);
		}

		addDynamicPropertyMethods(typeSpecBuilder);

		// build method
		typeSpecBuilder.addMethod(MethodSpec.methodBuilder("build").addModifiers(Modifier.PUBLIC, Modifier.FINAL)
				.returns(ParameterizedTypeName.get(Map.class, String.class, String.class))
				.addStatement("return properties").build());

		addConfiguratorFactoryMethods(typeSpecBuilder);

		return typeSpecBuilder.build();
	}
}
