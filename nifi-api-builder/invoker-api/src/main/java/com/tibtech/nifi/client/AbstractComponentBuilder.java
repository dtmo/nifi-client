package com.tibtech.nifi.client;

public abstract class AbstractComponentBuilder<T extends AbstractComponentBuilder<T>>
{
	private final Transport transport;

	public AbstractComponentBuilder(final Transport transport)
	{
		this.transport = transport;
	}

	protected Transport getTransport()
	{
		return transport;
	}
}
