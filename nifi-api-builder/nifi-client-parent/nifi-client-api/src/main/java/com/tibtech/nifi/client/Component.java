package com.tibtech.nifi.client;

public abstract class Component
{
	private final Transport transport;
	private long version;

	public Component(final Transport transport, final long version)
	{
		this.transport = transport;
		this.version = version;
	}

	protected Transport getTransport()
	{
		return transport;
	}

	public long getVersion()
	{
		return version;
	}

	protected void setVersion(long version)
	{
		this.version = version;
	}
	
	public abstract void delete() throws InvokerException;
}
