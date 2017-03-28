package com.tibtech.nifi.apibuilder;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.nifi.web.api.entity.Entity;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

public class EntityBuilderCodeWriter
{
	public static TypeSpec createAbstractBuilderTypeSpec(final Class<?> entityClass, final Class<?> superclass)
			throws IntrospectionException, NoSuchFieldException, SecurityException
	{
		final ObjectBuilderBuilder objectBuilderBuilder = new ObjectBuilderBuilder();
		objectBuilderBuilder.setAbstractBuilder(true);
		objectBuilderBuilder.setBuiltType(entityClass);
		objectBuilderBuilder.setSuperclass(superclass);

		final Set<String> declaredFieldNames = Arrays.stream(entityClass.getDeclaredFields()).map(df -> df.getName())
				.collect(Collectors.toSet());

		final PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(entityClass).getPropertyDescriptors();

		for (final PropertyDescriptor propertyDescriptor : propertyDescriptors)
		{
			if (declaredFieldNames.contains(propertyDescriptor.getName()))
			{
				// The property is declared on this class, so we need to handle
				// it as part of this builder.
				final Method writeMethod = propertyDescriptor.getWriteMethod();
				if (writeMethod != null)
				{
					// Get the parameterized type name for the property to
					// handle.
					final TypeName fieldTypeName = ClassUtils.getFieldTypeName(entityClass, propertyDescriptor.getName());

					objectBuilderBuilder
							.addBuilderProperty(new BuilderProperty(propertyDescriptor.getName(), fieldTypeName, ""));
				}
			}
		}

		return objectBuilderBuilder.build();
	}

	public static TypeSpec createBuilderTypeSpec(final Class<?> entityClass, final Class<?> superclass)
			throws IntrospectionException, NoSuchFieldException, SecurityException
	{
		final ObjectBuilderBuilder objectBuilderBuilder = new ObjectBuilderBuilder();
		objectBuilderBuilder.setAbstractBuilder(false);
		objectBuilderBuilder.setBuiltType(entityClass);
		objectBuilderBuilder.setSuperclass(superclass);

		if (superclass != entityClass)
		{
			final Set<String> declaredFieldNames = Arrays.stream(entityClass.getDeclaredFields()).map(df -> df.getName())
					.collect(Collectors.toSet());

			final PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(entityClass)
					.getPropertyDescriptors();

			for (final PropertyDescriptor propertyDescriptor : propertyDescriptors)
			{
				if (declaredFieldNames.contains(propertyDescriptor.getName()))
				{
					// The property is declared on this class, so we need to
					// handle it as part of this builder.

					final Method writeMethod = propertyDescriptor.getWriteMethod();
					if (writeMethod != null)
					{
						// Get the parameterized type name for the property to
						// handle.
						final TypeName fieldTypeName = ClassUtils.getFieldTypeName(entityClass, propertyDescriptor.getName());

						objectBuilderBuilder.addBuilderProperty(
								new BuilderProperty(propertyDescriptor.getName(), fieldTypeName, ""));
					}
				}
			}
		}

		return objectBuilderBuilder.build();
	}
	
	public static void main(final String[] args) throws Exception
	{
		final Reflections reflections = new Reflections(Entity.class.getPackage().getName(),
				new SubTypesScanner(false));
		final Set<Class<?>> entitySubTypes = new HashSet<>(reflections.getSubTypesOf(Entity.class));

		final Map<Class<?>, Set<Class<?>>> classSubclasses = ClassUtils.groupBySuperclass(entitySubTypes);

		// We aren't building an abstract builder for Object...
		classSubclasses.remove(Object.class);

		final Path generatedJavaPath = Paths.get("src/generated/java");

		for (final Class<?> entityClass : classSubclasses.keySet())
		{
			final Class<?> superclass = classSubclasses.containsKey(entityClass.getSuperclass()) ? entityClass.getSuperclass()
					: null;

			final TypeSpec abstractDtoBuilderTypeSpec = createAbstractBuilderTypeSpec(entityClass, superclass);

			final String dtoPackageName = entityClass.getPackage().getName();
			final String builderPackageName = dtoPackageName.replaceFirst("org\\.apache", "com.tibtech");

			final JavaFile javaFile = JavaFile.builder(builderPackageName, abstractDtoBuilderTypeSpec).build();

			javaFile.writeTo(generatedJavaPath);
		}

		for (final Class<?> dtoClass : entitySubTypes)
		{
			final Class<?> superclass;
			if (classSubclasses.containsKey(dtoClass))
			{
				superclass = dtoClass;
			}
			else if (classSubclasses.containsKey(dtoClass.getSuperclass()))
			{
				superclass = dtoClass.getSuperclass();
			}
			else
			{
				superclass = null;
			}

			final TypeSpec dtoBuilderTypeSpec = createBuilderTypeSpec(dtoClass, superclass);

			final String dtoPackageName = dtoClass.getPackage().getName();
			final String builderPackageName = dtoPackageName.replaceFirst("org\\.apache", "com.tibtech");

			final JavaFile javaFile = JavaFile.builder(builderPackageName, dtoBuilderTypeSpec).build();

			javaFile.writeTo(generatedJavaPath);
		}
	}
}
