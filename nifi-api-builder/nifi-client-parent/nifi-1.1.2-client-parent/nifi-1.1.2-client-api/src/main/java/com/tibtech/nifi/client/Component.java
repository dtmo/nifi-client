package com.tibtech.nifi.client;

public abstract class Component
{
	private final Transport transport;

	public Component(final Transport transport)
	{
		this.transport = transport;
	}

	protected Transport getTransport()
	{
		return transport;
	}
}
