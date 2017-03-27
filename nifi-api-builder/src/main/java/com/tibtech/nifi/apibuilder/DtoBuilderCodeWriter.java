package com.tibtech.nifi.apibuilder;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.lang.model.element.Modifier;

import org.apache.nifi.web.api.dto.AboutDTO;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeSpec.Builder;
import com.squareup.javapoet.TypeVariableName;

public class DtoBuilderCodeWriter
{
	private static final Logger LOGGER = LoggerFactory.getLogger(DtoBuilderCodeWriter.class);

	public static TypeName getFieldTypeName(final Class<?> dtoClass, final String fieldName)
			throws NoSuchFieldException, SecurityException
	{
		final Field declaredField = dtoClass.getDeclaredField(fieldName);
		final Type genericType = declaredField.getGenericType();
		final TypeName propertyTypeName = TypeName.get(genericType);
		return propertyTypeName;
	}

	public static Map<Class<?>, Set<Class<?>>> getClassSubclasses(final Collection<Class<?>> classes)
	{
		final Map<Class<?>, Set<Class<?>>> classSubclasses = new HashMap<>();
		for (final Class<?> dtoClass : classes)
		{
			final Class<?> superclass = dtoClass.getSuperclass();
			if (superclass != Object.class)
			{
				Set<Class<?>> subclasses = classSubclasses.get(superclass);
				if (subclasses == null)
				{
					subclasses = new HashSet<>();
					classSubclasses.put(superclass, subclasses);
				}

				subclasses.add(dtoClass);
			}
		}

		return classSubclasses;
	}

	public static MethodSpec createGetterMethod(final PropertyDescriptor propertyDescriptor,
			final TypeName propertyTypeName)
	{
		final String getterMethodName = "get"
				+ NameUtils.componentsToCamelCase(NameUtils.getNameComponents(propertyDescriptor.getName()), false);
		return MethodSpec.methodBuilder(getterMethodName).addModifiers(Modifier.PUBLIC).returns(propertyTypeName)
				.addStatement("return this.$L", propertyDescriptor.getName()).build();
	}

	public static TypeSpec createAbstractDtoBuilderTypeSpec(final Class<?> dtoClass, final Class<?> superclass)
			throws IntrospectionException, NoSuchFieldException, SecurityException
	{
		// final String className =
		// NameUtils.componentsToCamelCase(NameUtils.getNameComponents(dtoClass.getSimpleName()),
		// false);
		final String className = dtoClass.getSimpleName();

		// Convert the simple class name into a variable name.
		final String objectName = Character.toLowerCase(className.charAt(0)) + className.substring(1);

		final String dtoBuilderName = "Abstract" + className + "Builder";

		final Builder typeBuilder = TypeSpec.classBuilder(dtoBuilderName)
				.addModifiers(Modifier.PUBLIC, Modifier.ABSTRACT).addTypeVariable(TypeVariableName.get("T",
						ParameterizedTypeName.get(ClassName.bestGuess(dtoBuilderName), TypeVariableName.get("T"))));

		if (superclass != null)
		{
			final String superclassName = "Abstract" + superclass.getSimpleName() + "Builder";
			typeBuilder.superclass(
					ParameterizedTypeName.get(ClassName.bestGuess(superclassName), TypeVariableName.get("T")));
		}

		final MethodSpec.Builder setPropertyValuesMethodSpecBuilder = MethodSpec.methodBuilder("setPropertyValues")
				.addModifiers(Modifier.PUBLIC)
				.addParameter(ParameterSpec.builder(dtoClass, objectName, Modifier.FINAL).build()).returns(void.class);

		if (superclass != null)
		{
			setPropertyValuesMethodSpecBuilder.addStatement("super.setPropertyValues($L)", objectName);
		}

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
					// Get the parameterized type name for the property to
					// handle.
					final TypeName fieldTypeName = getFieldTypeName(dtoClass, propertyDescriptor.getName());

					typeBuilder.addField(
							FieldSpec.builder(fieldTypeName, propertyDescriptor.getName(), Modifier.PRIVATE).build());

					// Getter method
					typeBuilder.addMethod(createGetterMethod(propertyDescriptor, fieldTypeName));

					// Setter method
					final String setterMethodName = "set" + NameUtils
							.componentsToCamelCase(NameUtils.getNameComponents(propertyDescriptor.getName()), false);
					typeBuilder.addMethod(MethodSpec.methodBuilder(setterMethodName).addModifiers(Modifier.PUBLIC)
							.returns(TypeVariableName.get("T"))
							.addParameter(fieldTypeName, propertyDescriptor.getName(), Modifier.FINAL)
							.addStatement("this.$L = $L", propertyDescriptor.getName(), propertyDescriptor.getName())
							.addStatement("return (T) this").build());

					// Add the related set line to the builder method.
					setPropertyValuesMethodSpecBuilder.addStatement("$L.$L($L)", objectName, writeMethod.getName(),
							propertyDescriptor.getName());
				}
			}
		}

		typeBuilder.addMethod(setPropertyValuesMethodSpecBuilder.build());

		return typeBuilder.build();
	}

	public static TypeSpec createDtoBuilderTypeSpec(final Class<?> dtoClass, final Class<?> superclass)
			throws IntrospectionException, NoSuchFieldException, SecurityException
	{
		// final String className =
		// NameUtils.componentsToCamelCase(NameUtils.getNameComponents(dtoClass.getSimpleName()),
		// false);
		final String className = dtoClass.getSimpleName();

		// Convert the simple class name into a variable name.
		final String objectName = Character.toLowerCase(className.charAt(0)) + className.substring(1);

		final String dtoBuilderName = className + "Builder";
		final TypeName dtoBuilderTypeName = TypeVariableName.get(dtoBuilderName);

		final Builder typeBuilder = TypeSpec.classBuilder(dtoBuilderName).addModifiers(Modifier.PUBLIC, Modifier.FINAL);

		if (superclass != null)
		{
			final String superclassName = "Abstract" + superclass.getSimpleName() + "Builder";

			typeBuilder.superclass(ParameterizedTypeName.get(ClassName.bestGuess(superclassName),
					TypeVariableName.get(dtoBuilderName)));
		}

		final MethodSpec.Builder buildMethodSpecBuilder = MethodSpec.methodBuilder("build")
				.addModifiers(Modifier.PUBLIC).returns(dtoClass)
				.addStatement("final $T $L = new $T()", dtoClass, objectName, dtoClass);

		if (superclass != null)
		{
			buildMethodSpecBuilder.addStatement("super.setPropertyValues($L)", objectName);
		}

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
						// Get the parameterized type name for the property to
						// handle.
						final TypeName fieldTypeName = getFieldTypeName(dtoClass, propertyDescriptor.getName());

						typeBuilder.addField(FieldSpec
								.builder(fieldTypeName, propertyDescriptor.getName(), Modifier.PRIVATE).build());

						// Getter method
						typeBuilder.addMethod(createGetterMethod(propertyDescriptor, fieldTypeName));

						// Setter method
						final String setterMethodName = "set" + NameUtils.componentsToCamelCase(
								NameUtils.getNameComponents(propertyDescriptor.getName()), false);
						typeBuilder.addMethod(MethodSpec.methodBuilder(setterMethodName).addModifiers(Modifier.PUBLIC)
								.returns(dtoBuilderTypeName)
								.addParameter(fieldTypeName, propertyDescriptor.getName(), Modifier.FINAL)
								.addStatement("this.$L = $L", propertyDescriptor.getName(),
										propertyDescriptor.getName())
								.addStatement("return this").build());

						// Add the related set line to the builder method.
						buildMethodSpecBuilder.addStatement("$L.$L($L)", objectName, writeMethod.getName(),
								propertyDescriptor.getName());
					}
				}
			}
		}

		// When all properties have been handled, return the built DTO.
		buildMethodSpecBuilder.addStatement("return $L", objectName);

		typeBuilder.addMethod(buildMethodSpecBuilder.build());

		return typeBuilder.build();
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

		final Map<Class<?>, Set<Class<?>>> classSubclasses = getClassSubclasses(classes);

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
