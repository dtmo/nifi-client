package com.tibtech.nifi.client;

import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.apache.nifi.web.api.dto.FlowSnippetDTO;
import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.dto.ProcessGroupDTO;
import org.apache.nifi.web.api.entity.ProcessGroupEntity;

import com.tibtech.nifi.web.api.dto.FunnelDTOBuilder;
import com.tibtech.nifi.web.api.dto.LabelDTOBuilder;
import com.tibtech.nifi.web.api.dto.PortDTOBuilder;
import com.tibtech.nifi.web.api.dto.ProcessGroupDTOBuilder;
import com.tibtech.nifi.web.api.dto.ProcessorDTOBuilder;
import com.tibtech.nifi.web.api.dto.RemoteProcessGroupDTOBuilder;
import com.tibtech.nifi.web.api.entity.FunnelEntityBuilder;
import com.tibtech.nifi.web.api.entity.LabelEntityBuilder;
import com.tibtech.nifi.web.api.entity.PortEntityBuilder;
import com.tibtech.nifi.web.api.entity.ProcessGroupEntityBuilder;
import com.tibtech.nifi.web.api.entity.ProcessorEntityBuilder;
import com.tibtech.nifi.web.api.entity.RemoteProcessGroupEntityBuilder;
import com.tibtech.nifi.web.api.processgroup.CreateFunnelInvoker;
import com.tibtech.nifi.web.api.processgroup.CreateInputPortInvoker;
import com.tibtech.nifi.web.api.processgroup.CreateLabelInvoker;
import com.tibtech.nifi.web.api.processgroup.CreateOutputPortInvoker;
import com.tibtech.nifi.web.api.processgroup.CreateProcessGroupInvoker;
import com.tibtech.nifi.web.api.processgroup.CreateProcessorInvoker;
import com.tibtech.nifi.web.api.processgroup.CreateRemoteProcessGroupInvoker;
import com.tibtech.nifi.web.api.processgroup.GetConnectionsInvoker;
import com.tibtech.nifi.web.api.processgroup.GetFunnelsInvoker;
import com.tibtech.nifi.web.api.processgroup.GetInputPortsInvoker;
import com.tibtech.nifi.web.api.processgroup.GetLabelsInvoker;
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

	public Funnel createFunnel(final double x, final double y, final Consumer<FunnelDTOBuilder> configurator)
			throws InvokerException
	{
		final FunnelDTOBuilder funnelDTOBuilder = new FunnelDTOBuilder().setParentGroupId(getId());

		configurator.accept(funnelDTOBuilder);

		return new Funnel(getTransport(),
				new CreateFunnelInvoker(getTransport(), 0).setId(getId())
						.setFunnelEntity(new FunnelEntityBuilder()
								.setComponent(funnelDTOBuilder.setPosition(new PositionDTO(x, y)).build()).build())
						.invoke());
	}

	public Funnel createFunnel(final double x, final double y,
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FunnelDTOBuilder.class) final Closure<FunnelDTOBuilder> closure)
			throws InvokerException
	{
		return createFunnel(x, y, configurator ->
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

	public InputPort createInputPort(final double x, final double y, final Consumer<PortDTOBuilder> configurator)
			throws InvokerException
	{
		final PortDTOBuilder portDTOBuilder = new PortDTOBuilder().setParentGroupId(getId());

		configurator.accept(portDTOBuilder);

		return new InputPort(getTransport(),
				new CreateInputPortInvoker(getTransport(), 0).setId(getId())
						.setPortEntity(new PortEntityBuilder()
								.setComponent(portDTOBuilder.setPosition(new PositionDTO(x, y)).build()).build())
						.invoke());
	}

	public InputPort createInputPort(final double x, final double y,
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PortDTOBuilder.class) final Closure<PortDTOBuilder> closure)
			throws InvokerException
	{
		return createInputPort(x, y, configurator ->
		{
			final Closure<PortDTOBuilder> code = closure.rehydrate(configurator, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
		});
	}

	public Set<InputPort> getInputPorts() throws InvokerException
	{
		return new GetInputPortsInvoker(getTransport(), getVersion()).setId(getId()).invoke().getInputPorts().stream()
				.map(inputPortEntity -> new InputPort(getTransport(), inputPortEntity)).collect(Collectors.toSet());
	}

	public OutputPort createOutputPort(final double x, final double y, final Consumer<PortDTOBuilder> configurator)
			throws InvokerException
	{
		final PortDTOBuilder portDTOBuilder = new PortDTOBuilder().setParentGroupId(getId());

		configurator.accept(portDTOBuilder);

		return new OutputPort(getTransport(),
				new CreateOutputPortInvoker(getTransport(), 0).setId(getId())
						.setPortEntity(new PortEntityBuilder()
								.setComponent(portDTOBuilder.setPosition(new PositionDTO(x, y)).build()).build())
						.invoke());
	}

	public OutputPort createOutputPort(final double x, final double y,
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PortDTOBuilder.class) final Closure<PortDTOBuilder> closure)
			throws InvokerException
	{
		return createOutputPort(x, y, configurator ->
		{
			final Closure<PortDTOBuilder> code = closure.rehydrate(configurator, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
		});
	}

	public Set<OutputPort> getOutputPorts() throws InvokerException
	{
		return new GetOutputPortsInvoker(getTransport(), getVersion()).setId(getId()).invoke().getOutputPorts().stream()
				.map(outputPortEntity -> new OutputPort(getTransport(), outputPortEntity)).collect(Collectors.toSet());
	}

	public Processor createProcessor(final double x, final double y, final String type,
			final Consumer<ProcessorDTOBuilder> configurator) throws InvokerException
	{
		final ProcessorDTOBuilder processorDTOBuilder = new ProcessorDTOBuilder().setParentGroupId(getId());

		configurator.accept(processorDTOBuilder);

		return new Processor(getTransport(), new CreateProcessorInvoker(getTransport(), 0).setId(getId())
				.setProcessorEntity(new ProcessorEntityBuilder()
						.setComponent(processorDTOBuilder.setPosition(new PositionDTO(x, y)).setType(type).build())
						.build())
				.invoke());
	}

	public Processor createProcessor(final double x, final double y, final String type,
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessorDTOBuilder.class) final Closure<ProcessorDTOBuilder> closure)
			throws InvokerException
	{
		return createProcessor(x, y, type, configurator ->
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

	public ProcessGroup createProcessGroup(final double x, final double y,
			final Consumer<ProcessGroupDTOBuilder> configurator) throws InvokerException
	{
		final ProcessGroupDTOBuilder processGroupDTOBuilder = new ProcessGroupDTOBuilder()
				.setParentGroupId(getParentGroupId());

		configurator.accept(processGroupDTOBuilder);

		return new ProcessGroup(getTransport(), new CreateProcessGroupInvoker(getTransport(), 0)
				.setId(getParentGroupId())
				.setProcessGroupEntity(new ProcessGroupEntityBuilder()
						.setComponent(processGroupDTOBuilder.setPosition(new PositionDTO(x, y)).build()).build())
				.invoke());
	}

	public ProcessGroup createProcessGroup(final double x, final double y,
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessGroupDTOBuilder.class) final Closure<ProcessGroupDTOBuilder> closure)
			throws InvokerException
	{
		return createProcessGroup(x, y, configurator ->
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

	public RemoteProcessGroup createRemoteProcessGroup(final double x, final double y,
			final Consumer<RemoteProcessGroupDTOBuilder> configurator) throws InvokerException
	{
		final RemoteProcessGroupDTOBuilder remoteProcessGroupDTOBuilder = new RemoteProcessGroupDTOBuilder()
				.setParentGroupId(getParentGroupId());

		configurator.accept(remoteProcessGroupDTOBuilder);

		return new RemoteProcessGroup(getTransport(), new CreateRemoteProcessGroupInvoker(getTransport(), 0)
				.setId(getId())
				.setRemoteProcessGroupEntity(new RemoteProcessGroupEntityBuilder()
						.setComponent(remoteProcessGroupDTOBuilder.setPosition(new PositionDTO(x, y)).build()).build())
				.invoke());
	}

	public RemoteProcessGroup createRemoteProcessGroup(final double x, final double y,
			final Closure<RemoteProcessGroup> closure) throws InvokerException
	{
		return createRemoteProcessGroup(x, y, configurator ->
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

	public Label createLabel(final double x, final double y, final Consumer<LabelDTOBuilder> configurator)
			throws InvokerException
	{
		final LabelDTOBuilder labelDTOBuilder = new LabelDTOBuilder().setParentGroupId(getId());

		configurator.accept(labelDTOBuilder);

		return new Label(getTransport(),
				new CreateLabelInvoker(getTransport(), 0).setId(getId())
						.setLabelEntity(new LabelEntityBuilder()
								.setComponent(labelDTOBuilder.setPosition(new PositionDTO(x, y)).build()).build())
						.invoke());
	}

	public Label createLabel(final double x, final double y,
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = Label.class) final Closure<LabelDTOBuilder> closure)
			throws InvokerException
	{
		return createLabel(x, y, configurator ->
		{
			final Closure<LabelDTOBuilder> code = closure.rehydrate(configurator, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
		});
	}

	public Set<Label> getLabels() throws InvokerException
	{
		return new GetLabelsInvoker(getTransport(), getVersion()).setId(getId()).invoke().getLabels().stream()
				.map(labelEntity -> new Label(getTransport(), labelEntity)).collect(Collectors.toSet());
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
