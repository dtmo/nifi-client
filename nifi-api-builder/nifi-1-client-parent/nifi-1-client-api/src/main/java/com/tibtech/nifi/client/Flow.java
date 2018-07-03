package com.tibtech.nifi.client;

import java.util.Set;
import java.util.function.Consumer;

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
import com.tibtech.nifi.web.api.processgroup.GetProcessGroupInvoker;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class Flow
{
	private final Transport transport;

	private Flow(final Transport transport)
	{
		this.transport = transport;
	}

	public ProcessGroup getRootProcessGroup() throws InvokerException
	{
		return new ProcessGroup(transport, new GetProcessGroupInvoker(transport, 0).setId("root").invoke());
	}

	public ControllerService createControllerService(final String type,
			final Consumer<ControllerServiceDTOBuilder> configurator) throws InvokerException
	{
		final ControllerServiceDTOBuilder controllerServiceDTOBuilder = new ControllerServiceDTOBuilder();

		configurator.accept(controllerServiceDTOBuilder);

		return new ControllerService(transport,
				new CreateControllerServiceInvoker(transport, 0)
						.setControllerServiceEntity(new ControllerServiceEntityBuilder()
								.setComponent(controllerServiceDTOBuilder.setType(type).build()).build())
						.invoke());
	}

	public ControllerService createControllerService(final String type,
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ControllerServiceDTOBuilder.class) final Closure<ControllerServiceDTOBuilder> closure)
			throws InvokerException
	{
		return createControllerService(type, configurator ->
		{
			final Closure<ControllerServiceDTOBuilder> code = closure.rehydrate(configurator, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
		});
	}

	public Set<DocumentedTypeDTO> getControllerServiceTypes() throws InvokerException
	{
		return new GetControllerServiceTypesInvoker(transport, 0).invoke().getControllerServiceTypes();
	}

	public Set<DocumentedTypeDTO> getProcessorTypes() throws InvokerException
	{
		return new GetProcessorTypesInvoker(transport, 0).invoke().getProcessorTypes();
	}

	public Set<DocumentedTypeDTO> getReportingTaskTypes() throws InvokerException
	{
		return new GetReportingTaskTypesInvoker(transport, 0).invoke().getReportingTaskTypes();
	}

	public ReportingTask createReportingTask(final String type, final Consumer<ReportingTaskDTOBuilder> configurator)
			throws InvokerException
	{
		final ReportingTaskDTOBuilder reportingTaskDTOBuilder = new ReportingTaskDTOBuilder();

		configurator.accept(reportingTaskDTOBuilder);

		return new ReportingTask(transport, new CreateReportingTaskInvoker(transport, 0).setReportingTaskEntity(
				new ReportingTaskEntityBuilder().setComponent(reportingTaskDTOBuilder.setType(type).build()).build())
				.invoke());
	}

	public ReportingTask createReportingTask(final String type,
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ReportingTaskDTOBuilder.class) final Closure<ReportingTaskDTOBuilder> closure)
			throws InvokerException
	{
		return createReportingTask(type, configurator ->
		{
			final Closure<ReportingTaskDTOBuilder> code = closure.rehydrate(configurator, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
		});
	}

	public static Flow connect(final Client client, final String baseUri) throws InvokerException
	{
		final Transport transport = new Transport(client, baseUri);

		new GenerateClientIdInvoker(transport, 0).invoke();

		final Flow flow = new Flow(transport);
		return flow;
	}

	public static Flow connect(final String baseUri) throws InvokerException
	{
		final ClientBuilder clientBuilder = ClientBuilder.newBuilder();
		final Client client = clientBuilder.build();

		return connect(client, baseUri);
	}
}
