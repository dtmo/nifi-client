package com.tibtech.nifi.client;

import java.util.Set;
import java.util.function.Function;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.apache.nifi.web.api.dto.DocumentedTypeDTO;
import org.apache.nifi.web.api.entity.ControllerServiceEntity;
import org.apache.nifi.web.api.entity.ProcessGroupEntity;
import org.apache.nifi.web.api.entity.ReportingTaskEntity;

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

	public Flow(final Transport transport)
	{
		this.transport = transport;
	}

	public ProcessGroup getRootProcessGroup() throws InvokerException
	{
		final ProcessGroupEntity processGroupEntity = new GetProcessGroupInvoker(transport, 0).setId("root").invoke();
		return new ProcessGroup(transport, processGroupEntity.getRevision().getVersion(),
				processGroupEntity.getComponent());
	}

	public ControllerService createControllerService(
			final Function<ControllerServiceDTOBuilder, ControllerServiceDTOBuilder> configurator)
			throws InvokerException
	{
		final ControllerServiceEntity controllerServiceEntity = new CreateControllerServiceInvoker(transport, 0)
				.setControllerServiceEntity(new ControllerServiceEntityBuilder()
						.setComponent(configurator.apply(new ControllerServiceDTOBuilder()).build()).build())
				.invoke();
		return new ControllerService(transport, controllerServiceEntity.getRevision().getVersion(),
				controllerServiceEntity.getComponent());
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

	public ReportingTask createReportingTask(
			final Function<ReportingTaskDTOBuilder, ReportingTaskDTOBuilder> configurator) throws InvokerException
	{
		final ReportingTaskEntity reporingTaskEntity = new CreateReportingTaskInvoker(transport, 0)
				.setReportingTaskEntity(new ReportingTaskEntityBuilder()
						.setComponent(configurator.apply(new ReportingTaskDTOBuilder()).build()).build())
				.invoke();
		return new ReportingTask(transport, reporingTaskEntity.getRevision().getVersion(),
				reporingTaskEntity.getComponent());
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

		new GenerateClientIdInvoker(transport, 0).invoke();

		final Flow flow = new Flow(transport);
		return flow;
	}
}