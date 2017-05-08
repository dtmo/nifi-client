package com.tibtech.nifi.client;

import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.apache.nifi.web.api.dto.FlowSnippetDTO;
import org.apache.nifi.web.api.dto.ProcessGroupDTO;
import org.apache.nifi.web.api.entity.ProcessGroupEntity;

import com.tibtech.nifi.web.api.dto.FunnelDTOBuilder;
import com.tibtech.nifi.web.api.dto.ProcessGroupDTOBuilder;
import com.tibtech.nifi.web.api.dto.ProcessorDTOBuilder;
import com.tibtech.nifi.web.api.dto.RemoteProcessGroupDTOBuilder;
import com.tibtech.nifi.web.api.entity.FunnelEntityBuilder;
import com.tibtech.nifi.web.api.entity.ProcessGroupEntityBuilder;
import com.tibtech.nifi.web.api.entity.ProcessorEntityBuilder;
import com.tibtech.nifi.web.api.entity.RemoteProcessGroupEntityBuilder;
import com.tibtech.nifi.web.api.processgroup.CreateFunnelInvoker;
import com.tibtech.nifi.web.api.processgroup.CreateProcessGroupInvoker;
import com.tibtech.nifi.web.api.processgroup.CreateProcessorInvoker;
import com.tibtech.nifi.web.api.processgroup.CreateRemoteProcessGroupInvoker;
import com.tibtech.nifi.web.api.processgroup.GetConnectionsInvoker;
import com.tibtech.nifi.web.api.processgroup.GetFunnelsInvoker;
import com.tibtech.nifi.web.api.processgroup.GetInputPortsInvoker;
import com.tibtech.nifi.web.api.processgroup.GetOutputPortsInvoker;
import com.tibtech.nifi.web.api.processgroup.GetProcessGroupInvoker;
import com.tibtech.nifi.web.api.processgroup.GetProcessGroupsInvoker;
import com.tibtech.nifi.web.api.processgroup.GetProcessorsInvoker;
import com.tibtech.nifi.web.api.processgroup.GetRemoteProcessGroupsInvoker;
import com.tibtech.nifi.web.api.processgroup.RemoveProcessGroupInvoker;
import com.tibtech.nifi.web.api.processgroup.UpdateProcessGroupInvoker;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

public class ProcessGroup extends UpdatableComponent<ProcessGroup, ProcessGroupEntity, ProcessGroupDTOBuilder>
{
	public ProcessGroup(final Transport transport, final ProcessGroupEntity processGroupEntity)
	{
		super(transport, processGroupEntity);
	}

	protected ProcessGroupDTO getProcessGroupDTO()
	{
		return getComponentEntity().getComponent();
	}

	public String getParentGroupId()
	{
		return getProcessGroupDTO().getParentGroupId();
	}

	public String getName()
	{
		return getProcessGroupDTO().getName();
	}

	public String getComments()
	{
		return getProcessGroupDTO().getComments();
	}

	public FlowSnippetDTO getContents()
	{
		return getProcessGroupDTO().getContents();
	}

	public Integer getInputPortCount()
	{
		return getProcessGroupDTO().getInputPortCount();
	}

	public Integer getInvalidCount()
	{
		return getProcessGroupDTO().getInvalidCount();
	}

	public Integer getOutputPortCount()
	{
		return getProcessGroupDTO().getOutputPortCount();
	}

	public Integer getRunningCount()
	{
		return getProcessGroupDTO().getRunningCount();
	}

	public Integer getStoppedCount()
	{
		return getProcessGroupDTO().getStoppedCount();
	}

	public Integer getDisabledCount()
	{
		return getProcessGroupDTO().getDisabledCount();
	}

	public Integer getActiveRemotePortCount()
	{
		return getProcessGroupDTO().getActiveRemotePortCount();
	}

	public Integer getInactiveRemotePortCount()
	{
		return getProcessGroupDTO().getInactiveRemotePortCount();
	}

	public Set<Connection> getConnections() throws InvokerException
	{
		return new GetConnectionsInvoker(getTransport(), getVersion()).setId(getId()).invoke().getConnections().stream()
				.map(connectionEntity -> new Connection(getTransport(), connectionEntity)).collect(Collectors.toSet());
	}

	public Funnel createFunnel(final Consumer<FunnelDTOBuilder> configurator) throws InvokerException
	{
		final FunnelDTOBuilder funnelDTOBuilder = new FunnelDTOBuilder().setParentGroupId(getId());

		configurator.accept(funnelDTOBuilder);

		return new Funnel(getTransport(), new CreateFunnelInvoker(getTransport(), 0).setId(getId())
				.setFunnelEntity(new FunnelEntityBuilder().setComponent(funnelDTOBuilder.build()).build()).invoke());
	}

	public Funnel createFunnel(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FunnelDTOBuilder.class) final Closure<FunnelDTOBuilder> closure)
			throws InvokerException
	{
		return createFunnel(configurator ->
		{
			final Closure<FunnelDTOBuilder> code = closure.rehydrate(configurator, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
		});
	}

	public Set<Funnel> getFunnels() throws InvokerException
	{
		return new GetFunnelsInvoker(getTransport(), getVersion()).setId(getId()).invoke().getFunnels().stream()
				.map(funnelEntity -> new Funnel(getTransport(), funnelEntity)).collect(Collectors.toSet());
	}

	public Set<InputPort> getInputPorts() throws InvokerException
	{
		return new GetInputPortsInvoker(getTransport(), getVersion()).setId(getId()).invoke().getInputPorts().stream()
				.map(inputPortEntity -> new InputPort(getTransport(), inputPortEntity)).collect(Collectors.toSet());
	}

	public Set<OutputPort> getOutputPorts() throws InvokerException
	{
		return new GetOutputPortsInvoker(getTransport(), getVersion()).setId(getId()).invoke().getOutputPorts().stream()
				.map(outputPortEntity -> new OutputPort(getTransport(), outputPortEntity)).collect(Collectors.toSet());
	}

	public Processor createProcessor(final Consumer<ProcessorDTOBuilder> configurator) throws InvokerException
	{
		final ProcessorDTOBuilder processorDTOBuilder = new ProcessorDTOBuilder().setParentGroupId(getId());

		configurator.accept(processorDTOBuilder);

		return new Processor(getTransport(),
				new CreateProcessorInvoker(getTransport(), 0).setId(getId())
						.setProcessorEntity(
								new ProcessorEntityBuilder().setComponent(processorDTOBuilder.build()).build())
						.invoke());
	}

	public Processor createProcessor(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessorDTOBuilder.class) final Closure<ProcessorDTOBuilder> closure)
			throws InvokerException
	{
		return createProcessor(configurator ->
		{
			final Closure<ProcessorDTOBuilder> code = closure.rehydrate(configurator, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
		});
	}

	public Set<Processor> getProcessors() throws InvokerException
	{
		return new GetProcessorsInvoker(getTransport(), getVersion()).setId(getId()).invoke().getProcessors().stream()
				.map(processorEntity -> new Processor(getTransport(), processorEntity)).collect(Collectors.toSet());
	}

	public ProcessGroup createProcessGroup(final Consumer<ProcessGroupDTOBuilder> configurator) throws InvokerException
	{
		final ProcessGroupDTOBuilder processGroupDTOBuilder = new ProcessGroupDTOBuilder()
				.setParentGroupId(getParentGroupId());

		configurator.accept(processGroupDTOBuilder);

		return new ProcessGroup(getTransport(),
				new CreateProcessGroupInvoker(getTransport(), 0).setId(getParentGroupId())
						.setProcessGroupEntity(
								new ProcessGroupEntityBuilder().setComponent(processGroupDTOBuilder.build()).build())
						.invoke());
	}

	public ProcessGroup createProcessGroup(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessGroupDTOBuilder.class) final Closure<ProcessGroupDTOBuilder> closure)
			throws InvokerException
	{
		return createProcessGroup(configurator ->
		{
			final Closure<ProcessGroupDTOBuilder> code = closure.rehydrate(configurator, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
		});
	}

	public Set<ProcessGroup> getProcessGroups() throws InvokerException
	{
		return new GetProcessGroupsInvoker(getTransport(), getVersion()).setId(getId()).invoke().getProcessGroups()
				.stream().map(processGroupEntity -> new ProcessGroup(getTransport(), processGroupEntity))
				.collect(Collectors.toSet());
	}

	public RemoteProcessGroup createRemoteProcessGroup(final Consumer<RemoteProcessGroupDTOBuilder> configurator)
			throws InvokerException
	{
		final RemoteProcessGroupDTOBuilder remoteProcessGroupDTOBuilder = new RemoteProcessGroupDTOBuilder()
				.setParentGroupId(getParentGroupId());

		configurator.accept(remoteProcessGroupDTOBuilder);

		return new RemoteProcessGroup(getTransport(),
				new CreateRemoteProcessGroupInvoker(getTransport(), 0).setId(getId())
						.setRemoteProcessGroupEntity(new RemoteProcessGroupEntityBuilder()
								.setComponent(remoteProcessGroupDTOBuilder.build()).build())
						.invoke());
	}

	public RemoteProcessGroup createRemoteProcessGroup(final Closure<RemoteProcessGroup> closure)
			throws InvokerException
	{
		return createRemoteProcessGroup(configurator ->
		{
			final Closure<RemoteProcessGroup> code = closure.rehydrate(closure, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
		});
	}

	public Set<RemoteProcessGroup> getRemoteProcessGroups() throws InvokerException
	{
		return new GetRemoteProcessGroupsInvoker(getTransport(), getVersion()).setId(getId()).invoke()
				.getRemoteProcessGroups().stream()
				.map(remoteProcessGroupEntity -> new RemoteProcessGroup(getTransport(), remoteProcessGroupEntity))
				.collect(Collectors.toSet());
	}

	{
	}

	{
		{
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
		});
	}

	{
	}

	@Override
	public ProcessGroup refresh() throws InvokerException
	{
		setComponentEntity(new GetProcessGroupInvoker(getTransport(), 0).setId(getId()).invoke());

		return this;
	}

	@Override
	public ProcessGroup update(final Consumer<ProcessGroupDTOBuilder> configurator) throws InvokerException
	{
		final ProcessGroupDTOBuilder processGroupDTOBuilder = ProcessGroupDTOBuilder.of(getProcessGroupDTO());

		configurator.accept(processGroupDTOBuilder);

		setComponentEntity(
				new UpdateProcessGroupInvoker(getTransport(), getVersion()).setId(getId())
						.setProcessGroupEntity(
								new ProcessGroupEntityBuilder().setComponent(processGroupDTOBuilder.build()).build())
						.invoke());

		return this;
	}

	@Override
	public ProcessGroup update(
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessGroupDTOBuilder.class) final Closure<ProcessGroupDTOBuilder> closure)
			throws InvokerException
	{
		return super.update(closure);
	}

	@Override
	public void delete() throws InvokerException
	{
		new RemoveProcessGroupInvoker(getTransport(), getVersion()).setId(getId()).invoke();
	}
}
