package com.tibtech.nifi.apibuilder;

import static com.tibtech.nifi.apibuilder.NameUtils.componentsToCamelCase;
import static com.tibtech.nifi.apibuilder.NameUtils.componentsToConstantName;
import static com.tibtech.nifi.apibuilder.NameUtils.getNameComponents;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.nifi.components.ConfigurableComponent;
import org.apache.nifi.components.PropertyDescriptor;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeSpec.Builder;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

import com.squareup.javapoet.TypeVariableName;

public class ConfigurableComponentPropertiesBuilderCodeWriter
{
	public static void addPropertyDescriptorField(final TypeSpec.Builder typeSpecBuilder,
			final Field propertyDescriptorField, final String propertiesBuilderClassName)
			throws IllegalArgumentException, IllegalAccessException
	{
		propertyDescriptorField.setAccessible(true);

		final PropertyDescriptor propertyDescriptor = (PropertyDescriptor) propertyDescriptorField.get(null);
		final List<String> propertyDescriptorNameComponents = getNameComponents(propertyDescriptor.getName());
		final String propertyConstantName = componentsToConstantName(propertyDescriptorNameComponents, "", "_PROPERTY");

		// Add the field with Javadoc.
		typeSpecBuilder.addField(FieldSpec
				.builder(String.class, propertyConstantName, javax.lang.model.element.Modifier.PUBLIC,
						javax.lang.model.element.Modifier.STATIC, javax.lang.model.element.Modifier.FINAL)
				.initializer("$S", propertyDescriptor.getName())
				.addJavadoc(propertyDescriptor.getDescription().replaceAll("\\$", "\\$\\$") + "\n").build());

		final String propertyName = componentsToCamelCase(propertyDescriptorNameComponents, true);

		// Add a getter method.
		final String getterName = "get" + componentsToCamelCase(propertyDescriptorNameComponents, false);
		typeSpecBuilder.addMethod(MethodSpec.methodBuilder(getterName)
				.addModifiers(javax.lang.model.element.Modifier.PUBLIC, javax.lang.model.element.Modifier.FINAL)
				.returns(String.class).addStatement("return properties.get($L)", propertyConstantName).build());

		// Add a setter method.
		final String setterName = "set" + componentsToCamelCase(propertyDescriptorNameComponents, false);
		typeSpecBuilder.addMethod(MethodSpec.methodBuilder(setterName)
				.addModifiers(javax.lang.model.element.Modifier.PUBLIC, javax.lang.model.element.Modifier.FINAL)
				.returns(TypeVariableName.get(propertiesBuilderClassName))
				.addParameter(String.class, propertyName, javax.lang.model.element.Modifier.FINAL)
				.addStatement("properties.put($L, $L)", propertyConstantName, propertyName).addStatement("return this")
				.build());

		// Add a remove method.
		final String removeName = "remove" + componentsToCamelCase(propertyDescriptorNameComponents, false);
		typeSpecBuilder.addMethod(MethodSpec.methodBuilder(removeName)
				.addModifiers(javax.lang.model.element.Modifier.PUBLIC, javax.lang.model.element.Modifier.FINAL)
				.returns(TypeVariableName.get(propertiesBuilderClassName))
				.addStatement("properties.remove($L)", propertyConstantName).addStatement("return this").build());
	}

	public static void addDynamicPropertyMethods(final TypeSpec.Builder typeSpecBuilder,
			final String propertiesBuilderClassName)
	{
		// Add a getter for dynamic properties
		typeSpecBuilder.addMethod(MethodSpec.methodBuilder("getDynamicProperty")
				.addModifiers(javax.lang.model.element.Modifier.PUBLIC, javax.lang.model.element.Modifier.FINAL)
				.returns(String.class).addParameter(String.class, "name", javax.lang.model.element.Modifier.FINAL)
				.addStatement("return properties.get($L)", "name").build());

		// Add a setter for dynamic properties
		typeSpecBuilder.addMethod(MethodSpec.methodBuilder("setDynamicProperty")
				.addModifiers(javax.lang.model.element.Modifier.PUBLIC, javax.lang.model.element.Modifier.FINAL)
				.returns(TypeVariableName.get(propertiesBuilderClassName))
				.addParameter(String.class, "name", javax.lang.model.element.Modifier.FINAL)
				.addParameter(String.class, "value", javax.lang.model.element.Modifier.FINAL)
				.addStatement("properties.put($L, $L)", "name", "value").addStatement("return this").build());

		// Add a remove method for dynamic properties.
		typeSpecBuilder.addMethod(MethodSpec.methodBuilder("removeDynamicProperty")
				.addModifiers(javax.lang.model.element.Modifier.PUBLIC, javax.lang.model.element.Modifier.FINAL)
				.returns(TypeVariableName.get(propertiesBuilderClassName))
				.addParameter(String.class, "name", javax.lang.model.element.Modifier.FINAL)
				.addStatement("properties.remove($L)", "name").addStatement("return this").build());
	}

	public static void addConfiguratorFactoryMethods(final TypeSpec.Builder typeSpecBuilder,
			final Class<?> concreteConfigurableComponentClass, final String propertiesBuilderClassName)
	{
		// Add a lambda based configurator factory method
		typeSpecBuilder.addMethod(MethodSpec.methodBuilder("build")
				.addModifiers(javax.lang.model.element.Modifier.PUBLIC, javax.lang.model.element.Modifier.STATIC,
						javax.lang.model.element.Modifier.FINAL)
				.returns(
						ParameterizedTypeName.get(Map.class, String.class,
								String.class))
				.addParameter(ParameterSpec.builder(
						ParameterizedTypeName.get(ClassName.get(Function.class),
								TypeVariableName.get(propertiesBuilderClassName),
								TypeVariableName.get(propertiesBuilderClassName)),
						"configurator", javax.lang.model.element.Modifier.FINAL).build())
				.addStatement("return configurator.apply(new $T()).build()",
						TypeVariableName.get(propertiesBuilderClassName))
				.build());

		// Add a Closure based configurator factory method

		typeSpecBuilder
				.addMethod(
						MethodSpec.methodBuilder("build")
								.addModifiers(javax.lang.model.element.Modifier.PUBLIC,
										javax.lang.model.element.Modifier.STATIC,
										javax.lang.model.element.Modifier.FINAL)
								.returns(
										ParameterizedTypeName.get(Map.class, String.class, String.class))
								.addParameter(ParameterSpec
										.builder(
												ParameterizedTypeName.get(ClassName.get(Closure.class),
														TypeVariableName.get(propertiesBuilderClassName)),
												"closure", javax.lang.model.element.Modifier.FINAL)
										.addAnnotation(AnnotationSpec.builder(DelegatesTo.class)
												.addMember("strategy", "Closure.DELEGATE_ONLY")
												.addMember("value", "$T.class",
														TypeVariableName.get(propertiesBuilderClassName))
												.build())
										.build())
								.beginControlFlow("return build(c ->")
								.addStatement("final Closure<$L> code = closure.rehydrate(c, $L.class, $L.class)",
										propertiesBuilderClassName, propertiesBuilderClassName,
										propertiesBuilderClassName)
								.addStatement("code.setResolveStrategy(Closure.DELEGATE_ONLY)")
								.addStatement("code.call()").addStatement("return c").endControlFlow(")").build());
	}

	public static TypeSpec createConfigurableComponentPropertiesBuilderTypeSpec(
			final Class<?> configurableComponentClass) throws IllegalArgumentException, IllegalAccessException
	{
		final String propertiesBuilderClassName = configurableComponentClass.getSimpleName() + "PropertiesBuilder";

		final Builder propertyBuilderTypeSpecBuilder = TypeSpec.classBuilder(propertiesBuilderClassName)
				.addModifiers(javax.lang.model.element.Modifier.PUBLIC, javax.lang.model.element.Modifier.FINAL);

		propertyBuilderTypeSpecBuilder.addField(FieldSpec
				.builder(ParameterizedTypeName.get(Map.class, String.class, String.class), "properties",
						javax.lang.model.element.Modifier.PRIVATE, javax.lang.model.element.Modifier.FINAL)
				.initializer("new $T()", ParameterizedTypeName.get(HashMap.class, String.class, String.class)).build());

		final Field[] declaredFields = configurableComponentClass.getDeclaredFields();
		final List<Field> propertyDescriptorFields = Arrays.stream(declaredFields)
				.filter(f -> PropertyDescriptor.class.isAssignableFrom(f.getType())).collect(Collectors.toList());
		for (final Field propertyDescriptorField : propertyDescriptorFields)
		{
			addPropertyDescriptorField(propertyBuilderTypeSpecBuilder, propertyDescriptorField,
					propertiesBuilderClassName);
		}

		addDynamicPropertyMethods(propertyBuilderTypeSpecBuilder, propertiesBuilderClassName);

		// build method
		propertyBuilderTypeSpecBuilder.addMethod(MethodSpec.methodBuilder("build")
				.addModifiers(javax.lang.model.element.Modifier.PUBLIC, javax.lang.model.element.Modifier.FINAL)
				.returns(ParameterizedTypeName.get(Map.class, String.class, String.class))
				.addStatement("return properties").build());

		addConfiguratorFactoryMethods(propertyBuilderTypeSpecBuilder, configurableComponentClass,
				propertiesBuilderClassName);

		return propertyBuilderTypeSpecBuilder.build();
	}

	public static void main(final String[] args) throws Exception
	{
		Reflections reflections = new Reflections("org.apache.nifi", new SubTypesScanner(true));
		Set<Class<? extends ConfigurableComponent>> configurableComponentClasses = reflections
				.getSubTypesOf(ConfigurableComponent.class);
		Set<Class<? extends ConfigurableComponent>> concreteConfigurableComponentClasses = configurableComponentClasses
				.stream().filter(c -> (c.getModifiers() & Modifier.ABSTRACT) == 0).collect(Collectors.toSet());

		final Path generatedJavaPath = Paths.get("src/generated/java");
		for (Class<? extends ConfigurableComponent> concreteConfigurableComponentClass : concreteConfigurableComponentClasses)
		{
			TypeSpec configurableComponentPropertiesBuilderTypeSpec = createConfigurableComponentPropertiesBuilderTypeSpec(
					concreteConfigurableComponentClass);

			final String configurableComponentPackageName = concreteConfigurableComponentClass.getPackage().getName();
			final String builderPackageName = configurableComponentPackageName.replaceFirst("org\\.apache",
					"com.tibtech");

			final JavaFile javaFile = JavaFile
					.builder(builderPackageName, configurableComponentPropertiesBuilderTypeSpec).build();

			javaFile.writeTo(generatedJavaPath);
		}
	}
}
