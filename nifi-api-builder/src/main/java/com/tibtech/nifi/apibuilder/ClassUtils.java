package com.tibtech.nifi.apibuilder;

import java.lang.reflect.Field;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.squareup.javapoet.TypeName;

public class ClassUtils
{
	/**
	 * Transforms a collection of classes into a map where each class is stored
	 * grouped by its superclass (excluding {@link Object}) as the key.
	 * 
	 * @param classes
	 *            The classes to group as subclasses.
	 * @return The map of classes grouped by superclass.
	 */
	public static Map<Class<?>, Set<Class<?>>> groupBySuperclass(final Collection<Class<?>> classes)
	{
		final Map<Class<?>, Set<Class<?>>> classSubclasses = new HashMap<>();
		for (final Class<?> subclass : classes)
		{
			final Class<?> superclass = subclass.getSuperclass();
			Set<Class<?>> subclasses = classSubclasses.get(superclass);
			if (subclasses == null)
			{
				subclasses = new HashSet<>();
				classSubclasses.put(superclass, subclasses);
			}

			subclasses.add(subclass);
		}

		return classSubclasses;
	}

	public static TypeName getFieldTypeName(final Class<?> dtoClass, final String fieldName)
			throws NoSuchFieldException, SecurityException
	{
		final Field declaredField = dtoClass.getDeclaredField(fieldName);
		final Type genericType = declaredField.getGenericType();
		final TypeName propertyTypeName = TypeName.get(genericType);
		return propertyTypeName;
	}

	public static TypeName getParameterTypeName(final Parameter parameter)
	{
		final Type genericType = parameter.getParameterizedType();
		final TypeName propertyTypeName = TypeName.get(genericType);
		return propertyTypeName;
	}
}
