package com.tibtech.nifi.client;

import java.util.Collection;
import java.util.function.Consumer;

import org.apache.nifi.web.api.dto.RemoteProcessGroupPortDTO;

import com.tibtech.nifi.web.api.dto.ConnectionDTOBuilder;

public abstract class RemoteProcessGroupPort<T extends RemoteProcessGroupPort<T, B>, B> implements Connectable, Updatable<T, B>
{
	private final Transport transport;
	private RemoteProcessGroup remoteProcessGroup;
	private final long version;
	private RemoteProcessGroupPortDTO remoteProcessGroupPortDTO;

	public RemoteProcessGroupPort(final Transport transport, final RemoteProcessGroup remoteProcessGroup,
			final long version, final RemoteProcessGroupPortDTO remoteProcessGroupPortDTO)
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
}