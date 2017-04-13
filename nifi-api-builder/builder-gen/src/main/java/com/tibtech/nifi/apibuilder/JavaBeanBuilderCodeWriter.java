package com.tibtech.nifi.apibuilder;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.nifi.web.api.dto.AboutDTO;
import org.apache.nifi.web.api.entity.Entity;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.wordnik.swagger.annotations.ApiModelProperty;

public class JavaBeanBuilderCodeWriter
{
	public static TypeSpec createBuilderTypeSpec(final Class<?> dtoClass, final Class<?> superclass,
			final boolean abstractBuilder) throws IntrospectionException, NoSuchFieldException, SecurityException
	{
		final ObjectBuilderBuilder objectBuilderBuilder = new ObjectBuilderBuilder();
		objectBuilderBuilder.setAbstractBuilder(abstractBuilder);
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

	public static Collection<Pair<String, TypeSpec>> getPackagesAndTypeSpecs(final String packageName,
			final Predicate<String> classNameFilter)
			throws NoSuchFieldException, SecurityException, IntrospectionException
	{
		final Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));

		// For each class name that passes filtering, convert it to the
		// corresponding class object and then group them all by superclass.
		final Set<Class<?>> beanClasses = reflections.getAllTypes().parallelStream().filter(classNameFilter).map(s ->
		{
			try
			{
				return Class.forName(s);
			}
			catch (ClassNotFoundException e)
			{
				throw new RuntimeException("Could not find class for name: " + s);
			}
		}).collect(Collectors.toSet());

		final Map<Class<?>, List<Class<?>>> classSubclasses = beanClasses.parallelStream()
				.collect(Collectors.groupingBy(c -> c.getSuperclass()));

		// We aren't building an abstract builder for Object
		classSubclasses.remove(Object.class);

		final List<Pair<String, TypeSpec>> typeSpecs = new ArrayList<>();

		// Classes in the key set are classes that are extended and therefore
		// require an abstract builder.
		for (final Class<?> beanClass : classSubclasses.keySet())
		{
			final Class<?> superclass = classSubclasses.containsKey(beanClass.getSuperclass())
					? beanClass.getSuperclass() : null;

			final TypeSpec abstractDtoBuilderTypeSpec = createBuilderTypeSpec(beanClass, superclass, true);

			final String beanPackageName = beanClass.getPackage().getName();

			typeSpecs.add(Pair.of(beanPackageName, abstractDtoBuilderTypeSpec));
		}

		// All classes are Entities and therefore require concrete builders.
		for (final Class<?> beanClass : beanClasses)
		{
			final Class<?> superclass;
			if (classSubclasses.containsKey(beanClass))
			{
				superclass = beanClass;
			}
			else if (classSubclasses.containsKey(beanClass.getSuperclass()))
			{
				superclass = beanClass.getSuperclass();
			}
			else
			{
				superclass = null;
			}

			final TypeSpec beanBuilderTypeSpec = createBuilderTypeSpec(beanClass, superclass, false);

			final String beanPackageName = beanClass.getPackage().getName();

			typeSpecs.add(Pair.of(beanPackageName, beanBuilderTypeSpec));
		}

		return typeSpecs;
	}

	public static void main(final String[] args) throws Exception
	{
		final List<Pair<String, TypeSpec>> packageTypeSpecs = new ArrayList<>();
		packageTypeSpecs.addAll(getPackagesAndTypeSpecs(AboutDTO.class.getPackage().getName(), s -> s.endsWith("DTO")));
		packageTypeSpecs
				.addAll(getPackagesAndTypeSpecs(Entity.class.getPackage().getName(), s -> s.endsWith("Entity")));

		final Path generatedJavaPath = Paths.get("src/generated/java");

		for (Pair<String, TypeSpec> pair : packageTypeSpecs)
		{
			final String builderPackageName = pair.getLeft().replaceFirst("org\\.apache", "com.tibtech");
			final JavaFile javaFile = JavaFile.builder(builderPackageName, pair.getRight()).build();

			javaFile.writeTo(generatedJavaPath);
		}
	}
}
