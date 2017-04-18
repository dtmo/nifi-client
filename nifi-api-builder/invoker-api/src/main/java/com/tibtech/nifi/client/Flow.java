package com.tibtech.nifi.client;

import java.util.function.Function;

import com.tibtech.nifi.web.api.controller.CreateControllerServiceInvoker;
import com.tibtech.nifi.web.api.dto.ControllerServiceDTOBuilder;
import com.tibtech.nifi.web.api.entity.ControllerServiceEntityBuilder;
import com.tibtech.nifi.web.api.process.groups.GetProcessGroupInvoker;

public class Flow
{
	private final Transport transport;

	public Flow(final Transport transport)
	{
		this.transport = transport;
	}

	public ProcessGroup getRootProcessGroup() throws InvokerException
	{
		return new ProcessGroup(transport, new GetProcessGroupInvoker(transport).setId("ROOT").invoke().getComponent());
	}

	public ControllerService createControllerService(
			final Function<ControllerServiceDTOBuilder, ControllerServiceDTOBuilder> function) throws InvokerException
	{
		return new ControllerService(transport,
				new CreateControllerServiceInvoker(transport)
						.setControllerServiceEntity(new ControllerServiceEntityBuilder()
								.setComponent(function.apply(new ControllerServiceDTOBuilder()).build()).build())
						.invoke().getComponent());
	}
}
