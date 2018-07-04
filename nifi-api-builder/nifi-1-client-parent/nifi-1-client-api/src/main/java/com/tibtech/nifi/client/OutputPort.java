package com.tibtech.nifi.client;

import java.util.function.Consumer;

import org.apache.nifi.web.api.entity.PortEntity;

import com.tibtech.nifi.web.api.dto.PortDTOBuilder;
import com.tibtech.nifi.web.api.entity.PortEntityBuilder;
import com.tibtech.nifi.web.api.outputport.GetOutputPortInvoker;
import com.tibtech.nifi.web.api.outputport.RemoveOutputPortInvoker;
import com.tibtech.nifi.web.api.outputport.UpdateOutputPortInvoker;

public class OutputPort extends Port<OutputPort>
{
	public OutputPort(final Transport transport, final PortEntity portEntity)
	{
		super(transport, portEntity);
	}

	@Override
	public ConnectableType getConnectableType()
	{
		return ConnectableType.OUTPUT_PORT;
	}

	@Override
	public void delete() throws InvokerException
	{
		new RemoveOutputPortInvoker(getTransport(), getVersion()).setId(getId());
	}

	@Override
	public OutputPort refresh() throws InvokerException
	{
		setComponentEntity(new GetOutputPortInvoker(getTransport(), getVersion()).setId(getId()).invoke());

		return this;
	}

	@Override
	public OutputPort update(final Consumer<PortDTOBuilder> configurator) throws InvokerException
	{
		final PortDTOBuilder portDTOBuilder = PortDTOBuilder.of(getPortDTO());

		configurator.accept(portDTOBuilder);

		setComponentEntity(new UpdateOutputPortInvoker(getTransport(), getVersion()).setId(getId())
				.setPortEntity(new PortEntityBuilder().setComponent(portDTOBuilder.build()).build()).invoke());

		return this;
	}
}
