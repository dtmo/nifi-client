package com.tibtech.nifi.client;

import java.util.Set;
import java.util.function.Function;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.apache.nifi.web.api.dto.DocumentedTypeDTO;

import com.tibtech.nifi.web.api.controller.CreateControllerServiceInvoker;
import com.tibtech.nifi.web.api.controller.CreateReportingTaskInvoker;
import com.tibtech.nifi.web.api.dto.ControllerServiceDTOBuilder;
import com.tibtech.nifi.web.api.dto.ReportingTaskDTOBuilder;
import com.tibtech.nifi.web.api.entity.ControllerServiceEntityBuilder;
import com.tibtech.nifi.web.api.entity.ReportingTaskEntityBuilder;
import com.tibtech.nifi.web.api.flow.GenerateClientIdInvoker;
import com.tibtech.nifi.web.api.flow.GetControllerServiceTypesInvoker;
import com.tibtech.nifi.web.api.flow.GetProcessorTypesInvoker;
import com.tibtech.nifi.web.api.flow.GetReportingTaskTypesInvoker;
import com.tibtech.nifi.web.api.process.groups.GetProcessGroupInvoker;

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
		return new ProcessGroup(transport, new GetProcessGroupInvoker(transport).setId("root").invoke().getComponent());
	}

	public ControllerService createControllerService(
			final Function<ControllerServiceDTOBuilder, ControllerServiceDTOBuilder> configurator)
			throws InvokerException
	{
		return new ControllerService(transport,
				new CreateControllerServiceInvoker(transport)
						.setControllerServiceEntity(new ControllerServiceEntityBuilder()
								.setComponent(configurator.apply(new ControllerServiceDTOBuilder()).build()).build())
						.invoke().getComponent());
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

	public Set<DocumentedTypeDTO> getControllerServiceTypes() throws InvokerException
	{
		return new GetControllerServiceTypesInvoker(transport).invoke().getControllerServiceTypes();
	}

	public Set<DocumentedTypeDTO> getProcessorTypes() throws InvokerException
	{
		return new GetProcessorTypesInvoker(transport).invoke().getProcessorTypes();
	}

	public Set<DocumentedTypeDTO> getReportingTaskTypes() throws InvokerException
	{
		return new GetReportingTaskTypesInvoker(transport).invoke().getReportingTaskTypes();
	}

	public ReportingTask createReportingTask(
			final Function<ReportingTaskDTOBuilder, ReportingTaskDTOBuilder> configurator) throws InvokerException
	{
		return new ReportingTask(transport,
				new CreateReportingTaskInvoker(transport)
						.setReportingTaskEntity(new ReportingTaskEntityBuilder()
								.setComponent(configurator.apply(new ReportingTaskDTOBuilder()).build()).build())
						.invoke().getComponent());
	}

	public ReportingTask createReportingTask(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ReportingTaskDTOBuilder.class) final Closure<ReportingTaskDTOBuilder> closure)
			throws InvokerException
	{
		return createReportingTask(c ->
		{
			final Closure<ReportingTaskDTOBuilder> code = closure.rehydrate(c, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
			return c;
		});
	}

	public static Flow connect(final String baseUri) throws InvokerException
	{
		final ClientBuilder clientBuilder = ClientBuilder.newBuilder();
		final Client client = clientBuilder.build();

		final Transport transport = new Transport(client, baseUri);

		new GenerateClientIdInvoker(transport).invoke();

		final Flow flow = new Flow(transport);
		return flow;
	}
}
