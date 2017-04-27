package com.tibtech.nifi.client;

import java.util.function.Function;

import org.apache.nifi.web.api.dto.PortDTO;
import org.apache.nifi.web.api.entity.PortEntity;

import com.tibtech.nifi.web.api.dto.PortDTOBuilder;
import com.tibtech.nifi.web.api.entity.PortEntityBuilder;
import com.tibtech.nifi.web.api.inputport.GetInputPortInvoker;
import com.tibtech.nifi.web.api.inputport.RemoveInputPortInvoker;
import com.tibtech.nifi.web.api.inputport.UpdateInputPortInvoker;

public class InputPort extends Port<InputPort>
{
	public InputPort(final Transport transport, final long version, final PortDTO portDTO)
	{
		super(transport, version, portDTO);
	}

	@Override
	public ConnectableType getConnectableType()
	{
		return ConnectableType.INPUT_PORT;
	}

	@Override
	public void delete() throws InvokerException
	{
		new RemoveInputPortInvoker(getTransport(), getVersion()).setId(getId());
	}

	@Override
	public InputPort refresh() throws InvokerException
	{
		setPortDTO(new GetInputPortInvoker(getTransport(), getVersion()).setId(getId()).invoke().getComponent());
		return this;
	}

	@Override
	public InputPort update(final Function<PortDTOBuilder, PortDTOBuilder> configurator) throws InvokerException
	{
		final PortEntity portEntity = new UpdateInputPortInvoker(getTransport(), getVersion()).setId(getId())
				.setPortEntity(new PortEntityBuilder()
						.setComponent(configurator.apply(PortDTOBuilder.of(getPortDTO())).build()).build())
				.invoke();
		setVersion(portEntity.getRevision().getVersion());
		setPortDTO(portEntity.getComponent());
		return this;
	}
}
