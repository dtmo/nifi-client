package com.tibtech.nifi.apibuilder;

import static com.tibtech.nifi.apibuilder.NameUtils.getNameComponents;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class ConfigurableComponentPropertiesBuilderCodeWriterTest
{

	@Test
	public void testGetPropertyDescriptorNameComponents()
	{
		assertEquals(Arrays.asList(new String[] { "DHCP", "Service" }),
				getNameComponents("DHCPService"));
		assertEquals(Arrays.asList(new String[] { "Another", "Example" }),
				getNameComponents("AnotherExample"));
		assertEquals(Arrays.asList(new String[] { "a", "Name" }), getNameComponents("aName"));
		assertEquals(Arrays.asList(new String[] { "123", "Something" }),
				getNameComponents("123Something"));
		assertEquals(Arrays.asList(new String[] { "123", "things" }), getNameComponents("123things"));
		assertEquals(Arrays.asList(new String[] { "this", "1", "label" }),
				getNameComponents("this1label"));
		assertEquals(Arrays.asList(new String[] { "This", "2", "Label" }),
				getNameComponents("This2Label"));
		assertEquals(Arrays.asList(new String[] { "ABC", "2", "Hkks" }),
				getNameComponents("ABC2Hkks"));
		assertEquals(
				Arrays.asList(new String[] { "this", "is", "a", "Complicated", "Example", "123", "Of", "Some",
						"DIFFICULT", "Naming", "Strategies" }),
				getNameComponents("this-is a ComplicatedExample_123OfSomeDIFFICULTNamingStrategies"));
	}

}
