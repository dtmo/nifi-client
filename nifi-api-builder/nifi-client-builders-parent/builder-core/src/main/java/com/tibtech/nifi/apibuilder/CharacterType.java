package com.tibtech.nifi.apibuilder;

public enum CharacterType
{
	UPPER, LOWER, OTHER;

	public static CharacterType ofChar(final char c)
	{
		return Character.isAlphabetic(c) ? (Character.isUpperCase(c) ? UPPER : LOWER) : OTHER;
	}
}
