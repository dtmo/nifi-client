package com.tibtech.nifi.client;

import java.util.function.Function;

import org.apache.nifi.web.api.dto.RemoteProcessGroupPortDTO;
import org.apache.nifi.web.api.entity.RemoteProcessGroupPortEntity;

import com.tibtech.nifi.web.api.dto.RemoteProcessGroupPortDTOBuilder;
import com.tibtech.nifi.web.api.entity.RemoteProcessGroupPortEntityBuilder;
import com.tibtech.nifi.web.api.remoteprocessgroup.UpdateRemoteProcessGroupInputPortInvoker;

public class RemoteProcessGroupInputPort extends RemoteProcessGroupPort
{
	public RemoteProcessGroupInputPort(final Transport transport, final RemoteProcessGroup remoteProcessGroup,
			final long version, final RemoteProcessGroupPortDTO remoteProcessGroupPortDTO)
	{
		super(transport, remoteProcessGroup, version, remoteProcessGroupPortDTO);
	}

	@Override
	public ConnectableType getConnectableType()
	{
		return ConnectableType.REMOTE_INPUT_PORT;
	}

	public RemoteProcessGroupInputPort update(
			final Function<RemoteProcessGroupPortDTOBuilder, RemoteProcessGroupPortDTOBuilder> configurator)
			throws InvokerException
	{
		// TODO: Work out what, if anything, to do with this entity.
		final RemoteProcessGroupPortEntity remoteProcessGroupPortEntity = new UpdateRemoteProcessGroupInputPortInvoker(
				getTransport(), getVersion()).setId(getParentGroupId())
						.setPortId(getId())
						.setRemoteProcessGroupPortEntity(
								new RemoteProcessGroupPortEntityBuilder().setRemoteProcessGroupPort(configurator
										.apply(RemoteProcessGroupPortDTOBuilder.of(getRemoteProcessGroupPortDTO()))
										.build()).build())
						.invoke();
		return this;
	}
}