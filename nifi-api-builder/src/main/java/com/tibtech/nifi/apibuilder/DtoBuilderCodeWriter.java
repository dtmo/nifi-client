package com.tibtech.nifi.apibuilder;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.nifi.web.api.dto.AboutDTO;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.wordnik.swagger.annotations.ApiModelProperty;

public class DtoBuilderCodeWriter
{
	public static TypeSpec createAbstractDtoBuilderTypeSpec(final Class<?> dtoClass, final Class<?> superclass)
			throws IntrospectionException, NoSuchFieldException, SecurityException
	{
		final ObjectBuilderBuilder objectBuilderBuilder = new ObjectBuilderBuilder();
		objectBuilderBuilder.setAbstractBuilder(true);
		objectBuilderBuilder.setBuiltType(dtoClass);
		objectBuilderBuilder.setSuperclass(superclass);

		final Set<String> declaredFieldNames = Arrays.stream(dtoClass.getDeclaredFields()).map(df -> df.getName())
				.collect(Collectors.toSet());

		final PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(dtoClass).getPropertyDescriptors();

		for (final PropertyDescriptor propertyDescriptor : propertyDescriptors)
		{
			if (declaredFieldNames.contains(propertyDescriptor.getName()))
			{
				// The property is declared on this class, so we need to handle
				// it as part of this builder.
				final Method writeMethod = propertyDescriptor.getWriteMethod();
				if (writeMethod != null)
				{
					final Method readMethod = ClassUtils.getReadMethod(dtoClass, propertyDescriptor);
					final ApiModelProperty apiModelProperty = readMethod.getAnnotation(ApiModelProperty.class);
					final String comment = apiModelProperty != null ? apiModelProperty.value() : "";

					// Get the parameterized type name for the property to
					// handle.
					final TypeName fieldTypeName = ClassUtils.getFieldTypeName(dtoClass, propertyDescriptor.getName());

					objectBuilderBuilder.addBuilderProperty(new BuilderProperty(propertyDescriptor.getName(),
							propertyDescriptor.getPropertyType(), fieldTypeName, comment));
				}
			}
		}

		return objectBuilderBuilder.build();
	}

	public static TypeSpec createDtoBuilderTypeSpec(final Class<?> dtoClass, final Class<?> superclass)
			throws IntrospectionException, NoSuchFieldException, SecurityException
	{
		final ObjectBuilderBuilder objectBuilderBuilder = new ObjectBuilderBuilder();
		objectBuilderBuilder.setAbstractBuilder(false);
		objectBuilderBuilder.setBuiltType(dtoClass);
		objectBuilderBuilder.setSuperclass(superclass);

		if (superclass != dtoClass)
		{
			final Set<String> declaredFieldNames = Arrays.stream(dtoClass.getDeclaredFields()).map(df -> df.getName())
					.collect(Collectors.toSet());

			final PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(dtoClass)
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
						final Method readMethod = ClassUtils.getReadMethod(dtoClass, propertyDescriptor);
						final ApiModelProperty apiModelProperty = readMethod.getAnnotation(ApiModelProperty.class);
						final String comment = apiModelProperty != null ? apiModelProperty.value() : "";

						// Get the parameterized type name for the property to
						// handle.
						final TypeName fieldTypeName = ClassUtils.getFieldTypeName(dtoClass,
								propertyDescriptor.getName());

						objectBuilderBuilder.addBuilderProperty(new BuilderProperty(propertyDescriptor.getName(),
								propertyDescriptor.getPropertyType(), fieldTypeName, comment));
					}
				}
			}
		}

		return objectBuilderBuilder.build();
	}

	public static void main(final String[] args) throws Exception
	{
		final Reflections reflections = new Reflections(AboutDTO.class.getPackage().getName(),
				new SubTypesScanner(false));
		final Set<String> allTypeNames = reflections.getAllTypes();

		final List<Class<?>> classes = new ArrayList<>();
		for (final String typeName : allTypeNames)
		{
			if (typeName.endsWith("DTO"))
			{
				final Class<?> dtoClass = Class.forName(typeName);
				if (dtoClass.isAnonymousClass() == false && dtoClass.isInterface() == false)
				{
					classes.add(dtoClass);
				}
			}
		}

		final Map<Class<?>, Set<Class<?>>> classSubclasses = ClassUtils.groupBySuperclass(classes);

		// We aren't building an abstract builder for Object...
		classSubclasses.remove(Object.class);

		final Path generatedJavaPath = Paths.get("src/generated/java");

		for (final Class<?> dtoClass : classSubclasses.keySet())
		{
			final Class<?> superclass = classSubclasses.containsKey(dtoClass.getSuperclass()) ? dtoClass.getSuperclass()
					: null;

			final TypeSpec abstractDtoBuilderTypeSpec = createAbstractDtoBuilderTypeSpec(dtoClass, superclass);

			final String dtoPackageName = dtoClass.getPackage().getName();
			final String builderPackageName = dtoPackageName.replaceFirst("org\\.apache", "com.tibtech");

			final JavaFile javaFile = JavaFile.builder(builderPackageName, abstractDtoBuilderTypeSpec).build();

			javaFile.writeTo(generatedJavaPath);
		}

		for (final Class<?> dtoClass : classes)
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

			final TypeSpec dtoBuilderTypeSpec = createDtoBuilderTypeSpec(dtoClass, superclass);

			final String dtoPackageName = dtoClass.getPackage().getName();
			final String builderPackageName = dtoPackageName.replaceFirst("org\\.apache", "com.tibtech");

			final JavaFile javaFile = JavaFile.builder(builderPackageName, dtoBuilderTypeSpec).build();

			javaFile.writeTo(generatedJavaPath);
		}
	}
}
