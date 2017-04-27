package com.tibtech.nifi.client;

import java.util.Collection;
import java.util.Set;

import org.apache.nifi.web.api.dto.PortDTO;
import org.apache.nifi.web.api.dto.PositionDTO;

import com.tibtech.nifi.web.api.dto.PortDTOBuilder;

public abstract class Port<T extends Port<T>> extends ConnectableComponent<T, PortDTOBuilder>
{
	private PortDTO portDTO;

	public Port(final Transport transport, final long version, final PortDTO portDTO)
	{
		super(transport, version);

		this.portDTO = portDTO;
	}

	protected PortDTO getPortDTO()
	{
		return portDTO;
	}

	protected void setPortDTO(final PortDTO portDTO)
	{
		this.portDTO = portDTO;
	}

	public String getComments()
	{
		return portDTO.getComments();
	}

	public Integer getConcurrentlySchedulableTaskCount()
	{
		return portDTO.getConcurrentlySchedulableTaskCount();
	}

	public Set<String> getGroupAccessControl()
	{
		return portDTO.getGroupAccessControl();
	}

	public String getId()
	{
		return portDTO.getId();
	}

	public String getName()
	{
		return portDTO.getName();
	}

	public String getParentGroupId()
	{
		return portDTO.getParentGroupId();
	}

	public PositionDTO getPosition()
	{
		return portDTO.getPosition();
	}

	public String getState()
	{
		return portDTO.getState();
	}

	public String getType()
	{
		return portDTO.getType();
	}

	public Set<String> getUserAccessControl()
	{
		return portDTO.getUserAccessControl();
	}

	public Collection<String> getValidationErrors()
	{
		return portDTO.getValidationErrors();
	}
}
