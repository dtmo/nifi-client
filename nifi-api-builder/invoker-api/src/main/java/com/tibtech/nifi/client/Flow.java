package com.tibtech.nifi.client;

import java.util.function.Function;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import com.tibtech.nifi.web.api.controller.CreateControllerServiceInvoker;
import com.tibtech.nifi.web.api.dto.ControllerServiceDTOBuilder;
import com.tibtech.nifi.web.api.dto.ProcessGroupDTOBuilder;
import com.tibtech.nifi.web.api.entity.ControllerServiceEntityBuilder;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

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
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ControllerServiceDTOBuilder.class) final Closure<ControllerServiceDTOBuilder> closure)
			throws InvokerException
	{
		return createControllerService(c ->
		{
			final Closure<ControllerServiceDTOBuilder> code = closure.rehydrate(c, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
			return c;
		});
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

	public static Flow connect(final String baseUri)
	{
		final ClientBuilder clientBuilder = ClientBuilder.newBuilder();
		final Client client = clientBuilder.build();

		final Transport transport = new Transport(client, baseUri);
		final Flow flow = new Flow(transport);
		return flow;
	}
}
