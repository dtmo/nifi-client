package com.tibtech.nifi.apibuilder;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Modifier;

import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.ParameterizedTypeName;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;
import com.squareup.javapoet.TypeVariableName;

public class ObjectBuilderBuilder
{
	private Class<?> superclass;

	private boolean abstractBuilder;

	private List<BuilderProperty> builderProperties = new ArrayList<>();

	private Class<?> builtType;

	public Class<?> getSuperclass()
	{
		return superclass;
	}

	public void setSuperclass(final Class<?> superclass)
	{
		this.superclass = superclass;
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

	public Class<?> getBuiltType()
	{
		return builtType;
	}

	public void setBuiltType(Class<?> builtType)
	{
		this.builtType = builtType;
	}

	protected void addProperty(final TypeSpec.Builder typeSpecBuilder, final String builderName,
			final String propertyName, final TypeName propertyTypeName, final String comment)
	{
		typeSpecBuilder.addField(FieldSpec.builder(propertyTypeName, propertyName, Modifier.PRIVATE).build());
		final String getterName = "get" + Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
		typeSpecBuilder.addMethod(MethodSpec.methodBuilder(getterName).returns(propertyTypeName)
				.addModifiers(Modifier.PUBLIC).addJavadoc(comment).addStatement("return $L", propertyName).build());

		final String setterName = "set" + Character.toUpperCase(propertyName.charAt(0)) + propertyName.substring(1);
		final MethodSpec.Builder setterMethodBuilder = MethodSpec.methodBuilder(setterName)
				.addParameter(propertyTypeName, propertyName, Modifier.FINAL).addModifiers(Modifier.PUBLIC)
				.addJavadoc(comment).addStatement("this.$L = $L", propertyName, propertyName);
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

	protected void addSetPropertyValuesMethod(final TypeSpec.Builder typeSpecBuilder)
	{
		// Convert the simple class name into a variable name.
		final String objectName = Character.toLowerCase(builtType.getSimpleName().charAt(0))
				+ builtType.getSimpleName().substring(1);

		final MethodSpec.Builder setPropertyValuesMethodSpecBuilder = MethodSpec.methodBuilder("setPropertyValues")
				.addModifiers(Modifier.PUBLIC)
				.addParameter(ParameterSpec.builder(builtType, objectName, Modifier.FINAL).build()).returns(void.class);

		if (superclass != null)
		{
			setPropertyValuesMethodSpecBuilder.addStatement("super.setPropertyValues($L)", objectName);
		}

		for (final BuilderProperty builderProperty : builderProperties)
		{
			final String setterMethod = "set" + Character.toUpperCase(builderProperty.getName().charAt(0))
					+ builderProperty.getName().substring(1);

			// Add the related set line to the builder method.
			setPropertyValuesMethodSpecBuilder.addStatement("$L.$L($L)", objectName, setterMethod,
					builderProperty.getName());
		}

		typeSpecBuilder.addMethod(setPropertyValuesMethodSpecBuilder.build());
	}

	protected void addBuildMethod(final TypeSpec.Builder typeSpecBuilder) throws IntrospectionException
	{
		// Convert the simple class name into a variable name.
		final String objectName = Character.toLowerCase(builtType.getSimpleName().charAt(0))
				+ builtType.getSimpleName().substring(1);

		final MethodSpec.Builder buildMethodSpecBuilder = MethodSpec.methodBuilder("build")
				.addModifiers(Modifier.PUBLIC).returns(builtType)
				.addStatement("final $T $L = new $T()", builtType, objectName, builtType);

		if (superclass != null)
		{
			buildMethodSpecBuilder.addStatement("super.setPropertyValues($L)", objectName);
		}

		for (final BuilderProperty builderProperty : builderProperties)
		{
			final BeanInfo beanInfo = Introspector.getBeanInfo(builtType);
			final PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			PropertyDescriptor propertyDescriptor = null;
			int index = 0;
			while (index < propertyDescriptors.length && propertyDescriptor == null)
			{
				if (propertyDescriptors[index].getName().equals(builderProperty.getName()))
				{
					propertyDescriptor = propertyDescriptors[index];
				}

				index++;
			}

			if (propertyDescriptor != null)
			{
				// Add the related set line to the builder method.
				final String setterMethod = propertyDescriptor.getWriteMethod().getName();

				buildMethodSpecBuilder.addStatement("$L.$L($L)", objectName, setterMethod, builderProperty.getName());
			}
			else
			{
				throw new IllegalStateException("Could not find property descriptor for property: "
						+ builtType.getName() + "." + builderProperty.getName());
			}
		}

		// When all properties have been handled, return the built DTO.
		buildMethodSpecBuilder.addStatement("return $L", objectName);

		typeSpecBuilder.addMethod(buildMethodSpecBuilder.build());
	}

	public TypeSpec build() throws IntrospectionException
	{
		final StringBuilder builderNameBuilder = new StringBuilder();
		if (abstractBuilder)
		{
			builderNameBuilder.append("Abstract");
		}
		builderNameBuilder.append(builtType.getSimpleName());
		builderNameBuilder.append("Builder");
		final String builderName = builderNameBuilder.toString();

		final TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder(builderName).addModifiers(Modifier.PUBLIC);

		if (abstractBuilder)
		{
			typeSpecBuilder.addModifiers(Modifier.ABSTRACT);
			typeSpecBuilder.addTypeVariable(TypeVariableName.get("T",
					ParameterizedTypeName.get(ClassName.bestGuess(builderName), TypeVariableName.get("T"))));
		}
		else
		{
			typeSpecBuilder.addModifiers(Modifier.FINAL);
		}

		if (superclass != null)
		{
			final String superclassName = "Abstract" + superclass.getSimpleName() + "Builder";

			if (abstractBuilder)
			{
				typeSpecBuilder.superclass(
						ParameterizedTypeName.get(ClassName.bestGuess(superclassName), TypeVariableName.get("T")));
			}
			else
			{
				typeSpecBuilder.superclass(ParameterizedTypeName.get(ClassName.bestGuess(superclassName),
						TypeVariableName.get(builderName)));
			}
		}

		for (final BuilderProperty builderProperty : builderProperties)
		{
			addProperty(typeSpecBuilder, builderName, builderProperty.getName(), builderProperty.getTypeName(),
					builderProperty.getComment());
		}

		if (abstractBuilder)
		{
			addSetPropertyValuesMethod(typeSpecBuilder);
		}
		else
		{
			addBuildMethod(typeSpecBuilder);
		}

		return typeSpecBuilder.build();
	}
}
