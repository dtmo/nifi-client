package com.tibtech.nifi.apibuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NameUtils
{
	public static List<String> getNameComponents(final String propertyDescriptorName)
	{
		List<String> components = new ArrayList<>();
		final String[] splits = propertyDescriptorName.replaceAll("[^a-zA-Z0-9_\\- ]", "").split("[_\\- ]");
		for (final String split : splits)
		{
			if (split.isEmpty() == false)
			{
				// Try to split CamelCase names based on capitalisation
				final StringBuilder stringBuilder = new StringBuilder();
				final char[] charArray = split.toCharArray();
				stringBuilder.append(charArray[0]);
				CharacterType prevCharType = CharacterType.ofChar(charArray[0]);
				for (int i = 1; i < charArray.length; i++)
				{
					char c = charArray[i];
					if (CharacterType.ofChar(c) == prevCharType)
					{
						stringBuilder.append(c);
					}
					else if (prevCharType == CharacterType.UPPER && CharacterType.ofChar(c) == CharacterType.LOWER)
					{
						// We've gone from an upper case character to
						// a lower case one
						if (stringBuilder.length() > 1)
						{
							components.add(stringBuilder.substring(0, stringBuilder.length() - 1));
							stringBuilder.delete(0, stringBuilder.length() - 1);
						}
						stringBuilder.append(c);
						prevCharType = CharacterType.LOWER;
					}
					else
					{
						// We've gone from upper case to something else
						components.add(stringBuilder.toString());
						stringBuilder.setLength(0);
						stringBuilder.append(c);
						prevCharType = CharacterType.ofChar(c);
					}
				}

				components.add(stringBuilder.toString());
			}
		}

		return components;
	}

	public static String componentsToCamelCase(final List<String> components, final boolean initialLower)
	{
		final StringBuilder propertyNameBuilder = new StringBuilder();
		for (final String component : components)
		{
			propertyNameBuilder.append(Character.toUpperCase(component.charAt(0)));
			propertyNameBuilder.append(component.substring(1, component.length()).toLowerCase());
		}

		if (initialLower)
		{
			propertyNameBuilder.replace(0, 1, Character.toString(Character.toLowerCase(propertyNameBuilder.charAt(0))));
		}

		return propertyNameBuilder.toString();
	}

	public static String componentsToConstantName(final List<String> components)
	{
		return components.stream().map(s -> s.toUpperCase()).collect(Collectors.joining("_"));
	}

	public static String componentsToConstantName(final List<String> components, final String prefix,
			final String suffix)
	{
		return components.stream().map(s -> s.toUpperCase()).collect(Collectors.joining("_", prefix, suffix));
	}

	public static String componentsToPackageName(final List<String> components)
	{
		return components.stream().map(s -> s.toLowerCase()).map(s -> Character.isDigit(s.charAt(0)) ? "_" + s : s)
				.collect(Collectors.joining("."));
	}
}
