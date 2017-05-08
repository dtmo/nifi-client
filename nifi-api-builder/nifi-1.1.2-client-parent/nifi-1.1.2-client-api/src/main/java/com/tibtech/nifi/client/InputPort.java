package com.tibtech.nifi.client;

import java.util.function.Consumer;

import org.apache.nifi.web.api.entity.PortEntity;

import com.tibtech.nifi.web.api.dto.PortDTOBuilder;
import com.tibtech.nifi.web.api.entity.PortEntityBuilder;
import com.tibtech.nifi.web.api.inputport.GetInputPortInvoker;
import com.tibtech.nifi.web.api.inputport.RemoveInputPortInvoker;
import com.tibtech.nifi.web.api.inputport.UpdateInputPortInvoker;

public class InputPort extends Port<InputPort>
{
	public InputPort(final Transport transport, final PortEntity portEntity)
	{
		super(transport, portEntity);
	}

	@Override
	public ConnectableType getConnectableType()
	{
		return ConnectableType.INPUT_PORT;
	}

	@Override
	public InputPort refresh() throws InvokerException
	{
		setComponentEntity(new GetInputPortInvoker(getTransport(), getVersion()).setId(getId()).invoke());

		return this;
	}

	@Override
	public InputPort update(final Consumer<PortDTOBuilder> configurator) throws InvokerException
	{
		final PortDTOBuilder portDTOBuilder = PortDTOBuilder.of(getPortDTO());

		configurator.accept(portDTOBuilder);

		setComponentEntity(new UpdateInputPortInvoker(getTransport(), getVersion()).setId(getId())
				.setPortEntity(new PortEntityBuilder().setComponent(portDTOBuilder.build()).build()).invoke());

		return this;
	}

	@Override
	public void delete() throws InvokerException
	{
		new RemoveInputPortInvoker(getTransport(), getVersion()).setId(getId());
	}
}
