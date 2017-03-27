package com.tibtech.nifi.apibuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PathUtils
{
	public static List<String> getComponentsFromPathString(final String pathString)
	{
		final String[] strings = pathString.split("[//]");
		return Arrays.stream(strings).filter(s -> s.isEmpty() == false).collect(Collectors.toList());
	}
}
