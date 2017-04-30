package com.tibtech.nifi.apibuilder;

import java.lang.reflect.Modifier;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.nifi.components.ConfigurableComponent;
import org.apache.nifi.components.PropertyDescriptor;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;

public class ConfigurableComponentPropertiesBuilderTypeSpecBuilderFactory
{
	public static PackagedTypeSpec createConfigurableComponentPropertiesBuilderTypeSpec(
			final Class<?> configurableComponentClass, final Function<String, String> packageNameMapper)
	{
		final String propertiesBuilderClassName = configurableComponentClass.getSimpleName() + "PropertiesBuilder";
		final String builderPackageName = packageNameMapper.apply(configurableComponentClass.getPackage().getName());
		final ClassName builderClassName = ClassName.get(builderPackageName, propertiesBuilderClassName);

		final ConfigurableComponentPropertiesBuilderTypeSpecBuilder builder = new ConfigurableComponentPropertiesBuilderTypeSpecBuilder(
				builderClassName);
		
		builder.setComponentType(configurableComponentClass.getName());

		Arrays.stream(configurableComponentClass.getFields())
				.filter(f -> PropertyDescriptor.class.isAssignableFrom(f.getType())).map(f ->
				{
					try
					{
						final PropertyDescriptor propertyDescriptor = (PropertyDescriptor) f.get(null);
						return new ConfigurableComponentProperty(propertyDescriptor.getName(),
								propertyDescriptor.getDescription());
					}
					catch (final IllegalAccessException e)
					{
						throw new IllegalStateException("Could not get property descriptor from field: " + f, e);
					}
				}).forEach(p -> builder.addConfigurableComponentProperty(p));

		return new PackagedTypeSpec(builderPackageName, builder.build());
	}

	public static Set<PackagedTypeSpec> createConfigurableComponentPropertiesBuilderTypeSpecs(
			final String configurableComponentPackage, final Function<String, String> packageNameMapper)
	{
		final Reflections reflections = new Reflections(configurableComponentPackage, new SubTypesScanner(true));
		final Set<Class<? extends ConfigurableComponent>> configurableComponentClasses = reflections
				.getSubTypesOf(ConfigurableComponent.class);
		final Set<PackagedTypeSpec> packagedTypeSpecs = configurableComponentClasses.stream()
				.filter(c -> Modifier.isAbstract(c.getModifiers()) == false)
				.map(c -> createConfigurableComponentPropertiesBuilderTypeSpec(c, packageNameMapper))
				.collect(Collectors.toSet());
		return packagedTypeSpecs;
	}

	public static void main(final String[] args) throws Exception
	{
		final Path generatedJavaPath = Paths.get("src/generated/java");
		for (PackagedTypeSpec packagedTypeSpec : createConfigurableComponentPropertiesBuilderTypeSpecs(
				"org.apache.nifi", s -> s.replaceFirst("org\\.apache", "com.tibtech")))
		{
			final JavaFile javaFile = JavaFile
					.builder(packagedTypeSpec.getPackageName(), packagedTypeSpec.getTypeSpec()).build();

			javaFile.writeTo(generatedJavaPath);
		}
	}
}
