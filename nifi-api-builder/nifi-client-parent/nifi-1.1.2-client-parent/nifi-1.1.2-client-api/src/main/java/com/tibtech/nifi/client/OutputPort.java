package com.tibtech.nifi.client;

import java.util.function.Function;

import org.apache.nifi.web.api.dto.PortDTO;
import org.apache.nifi.web.api.entity.PortEntity;

import com.tibtech.nifi.web.api.dto.PortDTOBuilder;
import com.tibtech.nifi.web.api.entity.PortEntityBuilder;
import com.tibtech.nifi.web.api.outputport.GetOutputPortInvoker;
import com.tibtech.nifi.web.api.outputport.RemoveOutputPortInvoker;
import com.tibtech.nifi.web.api.outputport.UpdateOutputPortInvoker;

public class OutputPort extends Port<OutputPort>
{
	public OutputPort(final Transport transport, final long version, final PortDTO portDTO)
	{
		super(transport, version, portDTO);
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
		setPortDTO(new GetOutputPortInvoker(getTransport(), getVersion()).setId(getId()).invoke().getComponent());
		return this;
	}

	@Override
	public OutputPort update(final Function<PortDTOBuilder, PortDTOBuilder> configurator) throws InvokerException
	{
		final PortEntity portEntity = new UpdateOutputPortInvoker(getTransport(), getVersion()).setId(getId())
				.setPortEntity(new PortEntityBuilder()
						.setComponent(configurator.apply(PortDTOBuilder.of(getPortDTO())).build()).build())
				.invoke();
		setVersion(portEntity.getRevision().getVersion());
		setPortDTO(portEntity.getComponent());
		return this;
	}
}
