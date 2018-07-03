package com.tibtech.nifi.client;

import java.util.Collection;
import java.util.Set;

import org.apache.nifi.web.api.dto.PortDTO;
import org.apache.nifi.web.api.dto.status.PortStatusDTO;
import org.apache.nifi.web.api.entity.PortEntity;

import com.tibtech.nifi.web.api.dto.PortDTOBuilder;

public abstract class Port<T extends Port<T>> extends ConnectableComponent<T, PortEntity, PortDTOBuilder>
{
	public Port(final Transport transport, final PortEntity portEntity)
	{
		super(transport, portEntity);
	}

	protected PortDTO getPortDTO()
	{
		return getComponentEntity().getComponent();
	}
	
	@Override
	public String getParentGroupId()
	{
		return getPortDTO().getParentGroupId();
	}

	public String getPortType()
	{
		return getComponentEntity().getPortType();
	}

	public PortStatusDTO getStatus()
	{
		return getComponentEntity().getStatus();
	}

	public String getUri()
	{
		return getComponentEntity().getUri();
	}

	public String getComments()
	{
		return getPortDTO().getComments();
	}

	public Integer getConcurrentlySchedulableTaskCount()
	{
		return getPortDTO().getConcurrentlySchedulableTaskCount();
	}

	public Set<String> getGroupAccessControl()
	{
		return getPortDTO().getGroupAccessControl();
	}

	public String getName()
	{
		return getPortDTO().getName();
	}

	public String getState()
	{
		return getPortDTO().getState();
	}

	public String getType()
	{
		return getPortDTO().getType();
	}

	public Set<String> getUserAccessControl()
	{
		return getPortDTO().getUserAccessControl();
	}

	public Collection<String> getValidationErrors()
	{
		return getPortDTO().getValidationErrors();
	}
}
