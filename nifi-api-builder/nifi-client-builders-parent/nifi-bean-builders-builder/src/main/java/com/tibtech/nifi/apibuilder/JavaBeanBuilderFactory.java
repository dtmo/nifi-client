package com.tibtech.nifi.apibuilder;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.wordnik.swagger.annotations.ApiModelProperty;

public class JavaBeanBuilderFactory
{
	public static TypeSpec createBuilderTypeSpec(final Class<?> dtoClass, final Class<?> superclass,
			final boolean abstractBuilder, final Map<Class<?>, ClassName> beanBuilders)
			throws IntrospectionException, NoSuchFieldException, SecurityException
	{
		final JavaBeanBuilderTypeSpecBuilder objectBuilderBuilder = new JavaBeanBuilderTypeSpecBuilder();
		objectBuilderBuilder.setAbstractBuilder(abstractBuilder);
		objectBuilderBuilder.setBeanType(dtoClass);
		objectBuilderBuilder.setBuiltTypeSuperclass(superclass);

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
					final String comment = apiModelProperty != null ? apiModelProperty.value() + "\n" : "";

					// Get the parameterized type name for the property to
					// handle.
					final TypeName fieldTypeName = ClassUtils.getFieldTypeName(dtoClass, propertyDescriptor.getName());

					final Class<?> propertyType = propertyDescriptor.getPropertyType();
					objectBuilderBuilder.addBuilderProperty(
							new BuilderProperty(propertyDescriptor.getName(), propertyType, fieldTypeName, comment,
									beanBuilders.keySet().contains(propertyType), beanBuilders.get(propertyType)));
				}
			}
		}

		return objectBuilderBuilder.build();
	}

	public static Collection<PackagedTypeSpec> getPackagesAndTypeSpecs(final String packageName,
			final Predicate<String> classNameFilter, final Function<String, String> packageNameMapper)
			throws NoSuchFieldException, SecurityException, IntrospectionException
	{
		final Reflections reflections = new Reflections(packageName, new SubTypesScanner(false));

		// For each class name that passes filtering, convert it to the
		// corresponding class object and then group them all by superclass.
		final Map<Class<?>, ClassName> beanBuilders = reflections.getAllTypes().parallelStream().filter(classNameFilter)
				.map(s ->
				{
					try
					{
						return Class.forName(s);
					}
					catch (ClassNotFoundException e)
					{
						throw new RuntimeException("Could not find class for name: " + s);
					}
				}).collect(Collectors.toMap(c -> c, c -> ClassName
						.get(packageNameMapper.apply(c.getPackage().getName()), c.getSimpleName() + "Builder")));

		final Set<Class<?>> beanClasses = beanBuilders.keySet();
		final Map<Class<?>, List<Class<?>>> classSubclasses = beanClasses.parallelStream()
				.collect(Collectors.groupingBy(c -> c.getSuperclass()));

		// We aren't building an abstract builder for Object
		classSubclasses.remove(Object.class);

		final List<PackagedTypeSpec> packagedTypeSpecs = new ArrayList<>();

		// Classes in the key set are classes that are extended and therefore
		// require an abstract builder.
		for (final Class<?> beanClass : classSubclasses.keySet())
		{
			final Class<?> superclass = classSubclasses.containsKey(beanClass.getSuperclass())
					? beanClass.getSuperclass() : null;

			final TypeSpec abstractDtoBuilderTypeSpec = createBuilderTypeSpec(beanClass, superclass, true,
					beanBuilders);

			final String beanPackageName = packageNameMapper.apply(beanClass.getPackage().getName());

			packagedTypeSpecs.add(new PackagedTypeSpec(beanPackageName, abstractDtoBuilderTypeSpec));
		}

		for (final Class<?> beanClass : beanClasses)
		{
			if (Modifier.isAbstract(beanClass.getModifiers()) == false)
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

				final TypeSpec beanBuilderTypeSpec = createBuilderTypeSpec(beanClass, superclass, false, beanBuilders);

				final String beanPackageName = packageNameMapper.apply(beanClass.getPackage().getName());

				packagedTypeSpecs.add(new PackagedTypeSpec(beanPackageName, beanBuilderTypeSpec));
			}
		}

		return packagedTypeSpecs;
	}
}
