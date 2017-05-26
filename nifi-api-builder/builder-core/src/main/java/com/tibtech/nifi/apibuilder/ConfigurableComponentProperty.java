package com.tibtech.nifi.apibuilder;

public class ConfigurableComponentProperty
{
	private final String propertyText;
	private final String propertyDescription;

	public ConfigurableComponentProperty(final String propertyText, final String propertyDescription)
	{
		this.propertyText = propertyText;
		this.propertyDescription = propertyDescription;
	}

	public String getPropertyText()
	{
		return propertyText;
	}

	public String getPropertyDescription()
	{
		return propertyDescription;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append(" [propertyText=");
		builder.append(propertyText);
		builder.append(", propertyDescription=");
		builder.append(propertyDescription);
		builder.append("]");
		return builder.toString();
	}
}
