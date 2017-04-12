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
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.nifi.web.api.dto.AboutDTO;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.wordnik.swagger.annotations.ApiModelProperty;

public class DtoBuilderCodeWriter
{
	public static TypeSpec createDtoBuilderTypeSpec(final Class<?> dtoClass, final Class<?> superclass,
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

	public static Collection<Pair<String, TypeSpec>> getDtoPackagesAndTypeSpecs()
			throws NoSuchFieldException, SecurityException, IntrospectionException
	{
		final Reflections reflections = new Reflections(AboutDTO.class.getPackage().getName(),
				new SubTypesScanner(false));

		// For each classname ending with DTO, convert it to the class object
		// and then group them by superclass.
		final Set<Class<?>> dtoClasses = reflections.getAllTypes().parallelStream().filter(s -> s.endsWith("DTO"))
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
				}).collect(Collectors.toSet());

		final Map<Class<?>, List<Class<?>>> classSubclasses = dtoClasses.parallelStream()
				.collect(Collectors.groupingBy(c -> c.getSuperclass()));

		// We aren't building an abstract builder for Object...
		classSubclasses.remove(Object.class);

		final List<Pair<String, TypeSpec>> typeSpecs = new ArrayList<>();

		// Classes in the key set are classes that are extended and therefore
		// require an abstract builder.
		for (final Class<?> dtoClass : classSubclasses.keySet())
		{
			final Class<?> superclass = classSubclasses.containsKey(dtoClass.getSuperclass()) ? dtoClass.getSuperclass()
					: null;

			final TypeSpec abstractDtoBuilderTypeSpec = createDtoBuilderTypeSpec(dtoClass, superclass, true);

			final String dtoPackageName = dtoClass.getPackage().getName();

			typeSpecs.add(Pair.of(dtoPackageName, abstractDtoBuilderTypeSpec));
		}

		// All classes are DTOs and therefore require concrete DTO builders.
		for (final Class<?> dtoClass : dtoClasses)
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

			final TypeSpec dtoBuilderTypeSpec = createDtoBuilderTypeSpec(dtoClass, superclass, false);

			final String dtoPackageName = dtoClass.getPackage().getName();

			typeSpecs.add(Pair.of(dtoPackageName, dtoBuilderTypeSpec));
		}

		return typeSpecs;
	}

	public static void main(final String[] args) throws Exception
	{
		final Path generatedJavaPath = Paths.get("src/generated/java");

		for (Pair<String, TypeSpec> pair : getDtoPackagesAndTypeSpecs())
		{
			final String builderPackageName = pair.getLeft().replaceFirst("org\\.apache", "com.tibtech");
			final JavaFile javaFile = JavaFile.builder(builderPackageName, pair.getRight()).build();

			javaFile.writeTo(generatedJavaPath);
		}
	}
}
