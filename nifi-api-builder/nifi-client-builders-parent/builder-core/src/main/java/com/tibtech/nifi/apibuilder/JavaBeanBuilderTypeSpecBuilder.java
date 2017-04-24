package com.tibtech.nifi.apibuilder;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class JavaBeanBuilderTypeSpecBuilder
{
	private static final String SET_BUILDER_VALUES_METHOD_NAME = "setBuilderValues";
	private static final String SET_PROPERTY_VALUES_METHOD_NAME = "setPropertyValues";

	private Class<?> beanType;

	private Class<?> builtTypeSuperclass;

	private boolean abstractBuilder;

	private List<BuilderProperty> builderProperties = new ArrayList<>();

	public Class<?> getBeanType()
	{
		return beanType;
	}

	public void setBeanType(Class<?> builtType)
	{
		this.beanType = builtType;
	}

	public Class<?> getBuiltTypeSuperclass()
	{
		return builtTypeSuperclass;
	}

	public void setBuiltTypeSuperclass(final Class<?> builtTypeSuperclass)
	{
		this.builtTypeSuperclass = builtTypeSuperclass;
	}

	public boolean isAbstractBuilder()
	{
		return abstractBuilder;
	}

	public void setAbstractBuilder(boolean abstractBuilder)
	{
		this.abstractBuilder = abstractBuilder;
	}

	public List<BuilderProperty> getBuilderProperties()
	{
		return builderProperties;
	}

	public void setBuilderProperties(List<BuilderProperty> builderProperties)
	{
		this.builderProperties = builderProperties;
	}

	public void addBuilderProperty(final BuilderProperty builderProperty)
	{
		this.builderProperties.add(builderProperty);
	}

	protected void addPropertyGetterMethod(final TypeSpec.Builder typeSpecBuilder,
			final BuilderProperty builderProperty)
	{
		final TypeName propertyTypeName = builderProperty.getTypeName();
		final String propertyName = builderProperty.getName();

		typeSpecBuilder.addField(FieldSpec.builder(propertyTypeName, propertyName, Modifier.PRIVATE).build());
		final String getterName = "get" + Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
		typeSpecBuilder
				.addMethod(MethodSpec.methodBuilder(getterName).returns(propertyTypeName).addModifiers(Modifier.PUBLIC)
						.addJavadoc(builderProperty.getComment()).addStatement("return $L", propertyName).build());
	}

	protected void addPropertySetterMethod(final TypeSpec.Builder typeSpecBuilder, final String builderName,
			final BuilderProperty builderProperty)
	{
		final String propertyName = builderProperty.getName();

		final String setterName = "set" + Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
		final MethodSpec.Builder setterMethodBuilder = MethodSpec.methodBuilder(setterName)
				.addParameter(builderProperty.getTypeName(), propertyName, Modifier.FINAL).addModifiers(Modifier.PUBLIC)
				.addJavadoc(builderProperty.getComment()).addStatement("this.$L = $L", propertyName, propertyName);
		if (abstractBuilder)
		{
			setterMethodBuilder.returns(TypeVariableName.get("T"));
			setterMethodBuilder.addStatement("return (T) this");
		}
		else
		{
			final TypeVariableName invokerTypeName = TypeVariableName.get(builderName);
			setterMethodBuilder.returns(invokerTypeName);
			setterMethodBuilder.addStatement("return this");
		}

		typeSpecBuilder.addMethod(setterMethodBuilder.build());
	}

	protected void addConfiguratorFunctionMethod(final TypeSpec.Builder typeSpecBuilder, final String builderName,
			final BuilderProperty builderProperty)
	{
		final String propertyName = builderProperty.getName();
		final ClassName propertyTypeBuilder = builderProperty.getTypeBuilder();

		final String setterName = "set" + Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
		final MethodSpec.Builder configuratorFunctionMethod = MethodSpec.methodBuilder(setterName)
				.returns(TypeVariableName.get(builderName))
				.addModifiers(Modifier.PUBLIC)
				.addJavadoc(builderProperty.getComment())
				.addParameter(ParameterSpec
						.builder(ParameterizedTypeName.get(ClassName.get(Function.class), propertyTypeBuilder, propertyTypeBuilder),
								"configurator", Modifier.FINAL)
						.build())
				.addStatement("return $L(configurator.apply(new $T()).build())", setterName, propertyTypeBuilder);

		typeSpecBuilder.addMethod(configuratorFunctionMethod.build());
	}
	
	protected void addConfiguratorClosureMethod(final TypeSpec.Builder typeSpecBuilder, final String builderName,
			final BuilderProperty builderProperty)
	{
		final String propertyName = builderProperty.getName();
		final ClassName propertyTypeBuilder = builderProperty.getTypeBuilder();

		final String setterName = "set" + Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
		final MethodSpec.Builder configuratorClosureMethod = MethodSpec.methodBuilder(setterName)
				.returns(TypeVariableName.get(builderName))
				.addModifiers(Modifier.PUBLIC)
				.addJavadoc(builderProperty.getComment())
				.addParameter(ParameterSpec
						.builder(ParameterizedTypeName.get(ClassName.get(Closure.class), propertyTypeBuilder),
								"closure", Modifier.FINAL)
						.addAnnotation(
								AnnotationSpec.builder(DelegatesTo.class).addMember("strategy", "Closure.DELEGATE_ONLY")
										.addMember("value", "$T.class", propertyTypeBuilder).build())
						.build())
				.beginControlFlow("return $L(c ->", setterName)
				.addStatement("final Closure<$T> code = closure.rehydrate(c, this, this)", propertyTypeBuilder)
				.addStatement("code.setResolveStrategy(Closure.DELEGATE_ONLY)")
				.addStatement("code.call()")
				.addStatement("return c", setterName)
				.endControlFlow(")");

		typeSpecBuilder.addMethod(configuratorClosureMethod.build());
	}

	protected void addProperty(final TypeSpec.Builder typeSpecBuilder, final String builderName,
			final BuilderProperty builderProperty)
	{
		addPropertyGetterMethod(typeSpecBuilder, builderProperty);

		addPropertySetterMethod(typeSpecBuilder, builderName, builderProperty);

		if (builderProperty.isBuildableType())
		{
			// Add lambda and Closure methods
			addConfiguratorFunctionMethod(typeSpecBuilder, builderName, builderProperty);
			addConfiguratorClosureMethod(typeSpecBuilder, builderName, builderProperty);
		}
	}

	protected void addSetPropertyValuesMethod(final TypeSpec.Builder typeSpecBuilder)
	{
		// Convert the simple class name into a variable name.
		final String beanName = Character.toLowerCase(beanType.getSimpleName().charAt(0))
				+ beanType.getSimpleName().substring(1);

		final MethodSpec.Builder setPropertyValuesMethodSpecBuilder = MethodSpec
				.methodBuilder(SET_PROPERTY_VALUES_METHOD_NAME).addModifiers(Modifier.PROTECTED)
				.addParameter(ParameterSpec.builder(beanType, beanName, Modifier.FINAL).build()).returns(void.class);

		if (builtTypeSuperclass != null)
		{
			setPropertyValuesMethodSpecBuilder.addStatement("super.$L($L)", SET_PROPERTY_VALUES_METHOD_NAME, beanName);
		}

		for (final BuilderProperty builderProperty : builderProperties)
		{
			final String setterMethod = "set" + Character.toUpperCase(builderProperty.getName().charAt(0))
					+ builderProperty.getName().substring(1);

			// Add the related set line to the builder method.
			setPropertyValuesMethodSpecBuilder.addStatement("$L.$L($L)", beanName, setterMethod,
					builderProperty.getName());
		}

		typeSpecBuilder.addMethod(setPropertyValuesMethodSpecBuilder.build());
	}

	protected void addSetBuilderValuesMethod(final TypeSpec.Builder typeSpecBuilder, final String builderClassName,
			final String builderSuperclassName)
	{
		// Convert the simple class name into a variable name.
		final String beanName = Character.toLowerCase(beanType.getSimpleName().charAt(0))
				+ beanType.getSimpleName().substring(1);

		final String builderObjectName = Character.toLowerCase(builderClassName.charAt(0))
				+ builderClassName.substring(1);

		final MethodSpec.Builder setPropertyValuesMethodSpecBuilder = MethodSpec
				.methodBuilder(SET_BUILDER_VALUES_METHOD_NAME).addModifiers(Modifier.STATIC, Modifier.PROTECTED)
				// TODO: parameter type should be {builderClass}<? extends
				// {superBuilderClass}<?>>
				.addParameter(ParameterSpec
						.builder(TypeVariableName.get(builderClassName), builderObjectName, Modifier.FINAL).build())
				.addParameter(ParameterSpec.builder(beanType, beanName, Modifier.FINAL).build()).returns(void.class);

		if (builtTypeSuperclass != null)
		{
			setPropertyValuesMethodSpecBuilder.addStatement("$L.$L($L, $L)", builderSuperclassName,
					SET_BUILDER_VALUES_METHOD_NAME, builderObjectName, beanName);
		}

		for (final BuilderProperty builderProperty : builderProperties)
		{
			final String setterMethod = "set" + Character.toUpperCase(builderProperty.getName().charAt(0))
					+ builderProperty.getName().substring(1);
			final String getterMethod = "get" + Character.toUpperCase(builderProperty.getName().charAt(0))
					+ builderProperty.getName().substring(1);

			// Add the related set line to the builder method.
			setPropertyValuesMethodSpecBuilder.addStatement("$L.$L($L.$L())", builderObjectName, setterMethod, beanName,
					getterMethod);
		}

		typeSpecBuilder.addMethod(setPropertyValuesMethodSpecBuilder.build());
	}

	protected void addBuildMethod(final TypeSpec.Builder typeSpecBuilder) throws IntrospectionException
	{
		// Convert the simple class name into a variable name.
		final String beanName = Character.toLowerCase(beanType.getSimpleName().charAt(0))
				+ beanType.getSimpleName().substring(1);

		final MethodSpec.Builder buildMethodSpecBuilder = MethodSpec.methodBuilder("build")
				.addModifiers(Modifier.PUBLIC).returns(beanType)
				.addStatement("final $T $L = new $T()", beanType, beanName, beanType);

		if (builtTypeSuperclass != null)
		{
			buildMethodSpecBuilder.addStatement("super.$L($L)", SET_PROPERTY_VALUES_METHOD_NAME, beanName);
		}

		for (final BuilderProperty builderProperty : builderProperties)
		{
			final BeanInfo beanInfo = Introspector.getBeanInfo(beanType);
			final PropertyDescriptor propertyDescriptor = Arrays.stream(beanInfo.getPropertyDescriptors())
					.filter(d -> d.getName().equals(builderProperty.getName())).findFirst().orElse(null);

			if (propertyDescriptor != null)
			{
				// Add the related set line to the builder method.
				final String setterMethod = propertyDescriptor.getWriteMethod().getName();

				buildMethodSpecBuilder.addStatement("$L.$L($L)", beanName, setterMethod, builderProperty.getName());
			}
			else
			{
				throw new IllegalStateException("Could not find property descriptor for property: " + beanType.getName()
						+ "." + builderProperty.getName());
			}
		}

		// When all properties have been handled, return the built DTO.
		buildMethodSpecBuilder.addStatement("return $L", beanName);

		typeSpecBuilder.addMethod(buildMethodSpecBuilder.build());
	}

	protected void addOfDtoMethod(final TypeSpec.Builder typeSpecBuilder, final String builderClassName,
			final String builderSuperclassName) throws IntrospectionException
	{
		// protected static XxxBuilder of(final Xxx xxx)
		// {
		// final XxxBuilder xxxBuilder = new XxxBuilder();
		// SuperClass.setBuilderValues(xxxBuilder, xxx);
		// xxxBuilder.setYyy(xxx.getYyy());
		// return xxxBuilder;
		// }

		final TypeVariableName builderTypeName = TypeVariableName.get(builderClassName);

		// Convert the builder class name into a variable name.
		final String builderName = Character.toLowerCase(builderClassName.charAt(0)) + builderClassName.substring(1);

		// Convert the simple class name into a variable name.
		final String beanName = Character.toLowerCase(beanType.getSimpleName().charAt(0))
				+ beanType.getSimpleName().substring(1);

		final MethodSpec.Builder buildMethodSpecBuilder = MethodSpec.methodBuilder("of")
				.addModifiers(Modifier.PUBLIC, Modifier.STATIC).returns(builderTypeName)
				.addParameter(beanType, beanName, Modifier.FINAL)
				.addStatement("final $T $L = new $T()", builderTypeName, builderName, builderTypeName);

		if (builtTypeSuperclass != null)
		{
			buildMethodSpecBuilder.addStatement("$T.$L($L, $L)", TypeVariableName.get(builderSuperclassName),
					SET_BUILDER_VALUES_METHOD_NAME, builderName, beanName);
		}

		for (final BuilderProperty builderProperty : builderProperties)
		{
			final BeanInfo beanInfo = Introspector.getBeanInfo(beanType);
			final PropertyDescriptor propertyDescriptor = Arrays.stream(beanInfo.getPropertyDescriptors())
					.filter(d -> d.getName().equals(builderProperty.getName())).findFirst().orElse(null);

			if (propertyDescriptor != null)
			{
				// Add the related set line to the builder method.
				final String propertyName = builderProperty.getName();
				final String setterName = "set" + Character.toUpperCase(propertyName.charAt(0))
						+ propertyName.substring(1);

				buildMethodSpecBuilder.addStatement("$L.$L($L.$L())", builderName, setterName, beanName,
						ClassUtils.getReadMethod(beanType, propertyDescriptor).getName());
			}
			else
			{
				throw new IllegalStateException("Could not find property descriptor for property: " + beanType.getName()
						+ "." + builderProperty.getName());
			}
		}

		// When all properties have been handled, return the built DTO.
		buildMethodSpecBuilder.addStatement("return $L", builderName);

		typeSpecBuilder.addMethod(buildMethodSpecBuilder.build());
	}

	public TypeSpec build() throws IntrospectionException
	{
		final StringBuilder builderNameBuilder = new StringBuilder();
		if (abstractBuilder)
		{
			builderNameBuilder.append("Abstract");
		}
		builderNameBuilder.append(beanType.getSimpleName());
		builderNameBuilder.append("Builder");
		final String builderClassName = builderNameBuilder.toString();

		final TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder(builderClassName).addModifiers(Modifier.PUBLIC);

		TypeVariableName builderTypeName = TypeVariableName.get("T",
				ParameterizedTypeName.get(ClassName.bestGuess(builderClassName), TypeVariableName.get("T")));
		if (abstractBuilder)
		{
			typeSpecBuilder.addModifiers(Modifier.ABSTRACT);
			typeSpecBuilder.addTypeVariable(builderTypeName);
		}
		else
		{
			typeSpecBuilder.addModifiers(Modifier.FINAL);
		}

		final String builderSuperclassName = builtTypeSuperclass != null
				? "Abstract" + builtTypeSuperclass.getSimpleName() + "Builder" : null;

		if (builtTypeSuperclass != null)
		{
			if (abstractBuilder)
			{
				typeSpecBuilder.superclass(ParameterizedTypeName.get(ClassName.bestGuess(builderSuperclassName),
						TypeVariableName.get("T")));
			}
			else
			{
				typeSpecBuilder.superclass(ParameterizedTypeName.get(ClassName.bestGuess(builderSuperclassName),
						TypeVariableName.get(builderClassName)));
			}
		}

		for (final BuilderProperty builderProperty : builderProperties)
		{
			addProperty(typeSpecBuilder, builderClassName, builderProperty);
		}

		if (abstractBuilder)
		{
			addSetPropertyValuesMethod(typeSpecBuilder);
			addSetBuilderValuesMethod(typeSpecBuilder, builderClassName, builderSuperclassName);
		}
		else
		{
			addBuildMethod(typeSpecBuilder);
			addOfDtoMethod(typeSpecBuilder, builderClassName, builderSuperclassName);
		}

		return typeSpecBuilder.build();
	}
}
