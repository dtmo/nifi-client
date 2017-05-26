package com.tibtech.nifi.client;

import org.apache.nifi.web.api.dto.ComponentDTO;

public class Component
{
	private final Transport transport;
	private final ComponentDTO componentDTO;

	public Component(final Transport transport, final ComponentDTO componentDTO)
	{
		this.transport = transport;
		this.componentDTO = componentDTO;
	}
	
	protected Transport getTransport()
	{
		return transport;
	}

	public String getId()
	{
		return componentDTO.getId();
	}
}
