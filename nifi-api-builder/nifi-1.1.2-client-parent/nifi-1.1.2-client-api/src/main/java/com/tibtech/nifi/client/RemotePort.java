package com.tibtech.nifi.client;

import java.util.Collection;
import java.util.function.Consumer;

import org.apache.nifi.web.api.dto.RemoteProcessGroupPortDTO;

import com.tibtech.nifi.web.api.dto.ConnectionDTOBuilder;
import com.tibtech.nifi.web.api.dto.RemoteProcessGroupPortDTOBuilder;

public abstract class RemotePort<T extends RemotePort<T>>
		implements Connectable, Updatable<T, RemoteProcessGroupPortDTOBuilder>
{
	private final Transport transport;
	private final RemoteProcessGroup remoteProcessGroup;
	private final long version;
	private RemoteProcessGroupPortDTO remoteProcessGroupPortDTO;

	public RemotePort(final Transport transport, final RemoteProcessGroup remoteProcessGroup, final long version,
			final RemoteProcessGroupPortDTO remoteProcessGroupPortDTO)
	{
		this.transport = transport;
		this.remoteProcessGroup = remoteProcessGroup;
		this.version = version;
		this.remoteProcessGroupPortDTO = remoteProcessGroupPortDTO;
	}

	protected Transport getTransport()
	{
		return transport;
	}

	protected long getVersion()
	{
		return version;
	}

	public RemoteProcessGroup getRemoteProcessGroup()
	{
		return remoteProcessGroup;
	}

	protected RemoteProcessGroupPortDTO getRemoteProcessGroupPortDTO()
	{
		return remoteProcessGroupPortDTO;
	}

	protected void setRemoteProcessGroupPortDTO(final RemoteProcessGroupPortDTO remoteProcessGroupPortDTO)
	{
		this.remoteProcessGroupPortDTO = remoteProcessGroupPortDTO;
	}

	public String getComments()
	{
		return remoteProcessGroupPortDTO.getComments();
	}

	public Integer getConcurrentlySchedulableTaskCount()
	{
		return remoteProcessGroupPortDTO.getConcurrentlySchedulableTaskCount();
	}

	public Boolean getExists()
	{
		return remoteProcessGroupPortDTO.getExists();
	}

	@Override
	public String getParentGroupId()
	{
		return remoteProcessGroup.getId();
	}

	@Override
	public String getId()
	{
		return remoteProcessGroupPortDTO.getId();
	}

	public String getName()
	{
		return remoteProcessGroupPortDTO.getName();
	}

	public Boolean getUseCompression()
	{
		return remoteProcessGroupPortDTO.getUseCompression();
	}

	@Override
	public Connection connectTo(final Connectable destination, final Collection<String> selectedRelationships,
			final Consumer<ConnectionDTOBuilder> configurator) throws InvokerException
	{
		return Connection.createConnection(transport, this, destination, selectedRelationships, configurator);
	}

	public T setTransmitting(final boolean transmitting) throws InvokerException
	{
		return update(configurator -> configurator.setTransmitting(transmitting));
	}
}