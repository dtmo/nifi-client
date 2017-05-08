package com.tibtech.nifi.client;

import java.util.function.Consumer;

import org.apache.nifi.web.api.dto.RemoteProcessGroupPortDTO;
import org.apache.nifi.web.api.entity.RemoteProcessGroupPortEntity;

import com.tibtech.nifi.web.api.dto.RemoteProcessGroupPortDTOBuilder;
import com.tibtech.nifi.web.api.entity.RemoteProcessGroupPortEntityBuilder;
import com.tibtech.nifi.web.api.remoteprocessgroup.UpdateRemoteProcessGroupOutputPortInvoker;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class RemoteProcessGroupOutputPort
		extends RemoteProcessGroupPort<RemoteProcessGroupOutputPort, RemoteProcessGroupPortDTOBuilder>
{
	public RemoteProcessGroupOutputPort(final Transport transport, final RemoteProcessGroup remoteProcessGroup,
			final long version, final RemoteProcessGroupPortDTO remoteProcessGroupPortDTO)
	{
		super(transport, remoteProcessGroup, version, remoteProcessGroupPortDTO);
	}

	@Override
	public ConnectableType getConnectableType()
	{
		return ConnectableType.REMOTE_OUTPUT_PORT;
	}

	public RemoteProcessGroupOutputPort update(final Consumer<RemoteProcessGroupPortDTOBuilder> configurator)
			throws InvokerException
	{
		final RemoteProcessGroupPortDTOBuilder remoteProcessGroupPortDTOBuilder = RemoteProcessGroupPortDTOBuilder
				.of(getRemoteProcessGroupPortDTO()).setGroupId(getParentGroupId());

		configurator.accept(remoteProcessGroupPortDTOBuilder);

		// TODO: Work out what, if anything, to do with this entity.
		final RemoteProcessGroupPortEntity remoteProcessGroupPortEntity = new UpdateRemoteProcessGroupOutputPortInvoker(
				getTransport(), getVersion()).setId(getParentGroupId()).setPortId(getId())
						.setRemoteProcessGroupPortEntity(new RemoteProcessGroupPortEntityBuilder()
								.setRemoteProcessGroupPort(remoteProcessGroupPortDTOBuilder.build()).build())
						.invoke();
		return this;
	}

	public RemoteProcessGroupOutputPort update(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = RemoteProcessGroupPortDTOBuilder.class) final Closure<RemoteProcessGroupPortDTOBuilder> closure)
			throws InvokerException
	{
		return update(configurator ->
		{
			final Closure<RemoteProcessGroupPortDTOBuilder> code = closure.rehydrate(configurator, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
		});
	}
}