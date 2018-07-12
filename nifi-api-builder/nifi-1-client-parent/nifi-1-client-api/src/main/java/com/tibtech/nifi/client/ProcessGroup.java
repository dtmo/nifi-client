package com.tibtech.nifi.client;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.dto.ProcessGroupDTO;
import org.apache.nifi.web.api.dto.flow.FlowDTO;
import org.apache.nifi.web.api.entity.FlowEntity;
import org.apache.nifi.web.api.entity.ProcessGroupEntity;

import com.tibtech.nifi.web.api.dto.FunnelDTOBuilder;
import com.tibtech.nifi.web.api.dto.LabelDTOBuilder;
import com.tibtech.nifi.web.api.dto.PortDTOBuilder;
import com.tibtech.nifi.web.api.dto.ProcessGroupDTOBuilder;
import com.tibtech.nifi.web.api.dto.ProcessorDTOBuilder;
import com.tibtech.nifi.web.api.dto.RemoteProcessGroupDTOBuilder;
import com.tibtech.nifi.web.api.entity.FunnelEntityBuilder;
import com.tibtech.nifi.web.api.entity.InstantiateTemplateRequestEntityBuilder;
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
import com.tibtech.nifi.web.api.processgroup.InstantiateTemplateInvoker;
import com.tibtech.nifi.web.api.processgroup.RemoveProcessGroupInvoker;
import com.tibtech.nifi.web.api.processgroup.UpdateProcessGroupInvoker;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

/**
 * ProcessGroup represents a NiFi flow process group which groups related flow
 * components together.
 */
public class ProcessGroup extends UpdatableComponent<ProcessGroup, ProcessGroupEntity, ProcessGroupDTOBuilder>
		implements Deletable, Refreshable<ProcessGroup, ProcessGroupDTOBuilder>
{
	/**
	 * Constructs a new instance of ProcessGroup.
	 * 
	 * @param transport The transport with which to communicate with the NiFi
	 *        server.
	 * @param processGroupEntity The entity that describes the process group.
	 */
	public ProcessGroup(final Transport transport, final ProcessGroupEntity processGroupEntity)
	{
		super(transport, processGroupEntity);
	}

	/**
	 * Returns the DTO that describes the process group.
	 * 
	 * @return The DTO that describes the process group.
	 */
	protected ProcessGroupDTO getProcessGroupDTO()
	{
		return getComponentEntity().getComponent();
	}

	/**
	 * Returns the ID of process group containing the component.
	 * 
	 * @return The ID of process group containing the component.
	 */
	public String getParentGroupId()
	{
		return getProcessGroupDTO().getParentGroupId();
	}

	/**
	 * Returns the user defined name of the process group.
	 * 
	 * @return The user defined name of the process group.
	 */
	public String getName()
	{
		return getProcessGroupDTO().getName();
	}

	/**
	 * Returns the user defined comments for the process group.
	 * 
	 * @return The user defined comments for the process group.
	 */
	public String getComments()
	{
		return getProcessGroupDTO().getComments();
	}

	/**
	 * Returns the number of input ports in the process group.
	 * 
	 * @return The number of input ports in the process group.
	 */
	public int getInputPortCount()
	{
		return getProcessGroupDTO().getInputPortCount().intValue();
	}

	/**
	 * Returns the number of invalid components in the process group.
	 * 
	 * @return The number of invalid components in the process group.
	 */
	public int getInvalidCount()
	{
		return getProcessGroupDTO().getInvalidCount().intValue();
	}

	/**
	 * Returns the number of output ports in the process group.
	 * 
	 * @return The number of output ports in the process group.
	 */
	public int getOutputPortCount()
	{
		return getProcessGroupDTO().getOutputPortCount().intValue();
	}

	/**
	 * Returns the number of running components in this process group.
	 * 
	 * @return The number of running components in this process group.
	 */
	public int getRunningCount()
	{
		return getProcessGroupDTO().getRunningCount().intValue();
	}

	/**
	 * Returns the number of stopped components in the process group.
	 * 
	 * @return The number of stopped components in the process group.
	 */
	public int getStoppedCount()
	{
		return getProcessGroupDTO().getStoppedCount().intValue();
	}

	/**
	 * Returns the number of disabled components in the process group.
	 * 
	 * @return The number of disabled components in the process group.
	 */
	public int getDisabledCount()
	{
		return getProcessGroupDTO().getDisabledCount().intValue();
	}

	/**
	 * Returns the number of active remote ports in the process group.
	 * 
	 * @return The number of active remote ports in the process group.
	 */
	public int getActiveRemotePortCount()
	{
		return getProcessGroupDTO().getActiveRemotePortCount().intValue();
	}

	/**
	 * Returns the number of inactive remote ports in the process group.
	 * 
	 * @return The number of inactive remote ports in the process group.
	 */
	public int getInactiveRemotePortCount()
	{
		return getProcessGroupDTO().getInactiveRemotePortCount().intValue();
	}

	/**
	 * Returns the connections in the process group.
	 * 
	 * @return The connections in the process group.
	 * @throws InvokerException if there is a problem getting the connections.
	 */
	public Set<Connection> getConnections() throws InvokerException
	{
		return new GetConnectionsInvoker(getTransport(), getVersion())
				.setId(getId())
				.invoke()
				.getConnections().stream()
				.map(connectionEntity -> new Connection(getTransport(), connectionEntity))
				.collect(Collectors.toSet());
	}

	/**
	 * Creates a new funnel in the process group.
	 * 
	 * @param x The x position for the funnel.
	 * @param y The y position for the funnel.
	 * @param configurator A {@link Consumer} that accepts a
	 *        {@link FunnelDTOBuilder} on which the funnel configuration may be set.
	 * @return The new funnel.
	 * @throws InvokerException if there is a problem creating the funnel.
	 */
	public Funnel createFunnel(final double x, final double y, final Consumer<FunnelDTOBuilder> configurator)
			throws InvokerException
	{
		final FunnelDTOBuilder funnelDTOBuilder = new FunnelDTOBuilder().setParentGroupId(getId())
				.setPosition(new PositionDTO(x, y));

		configurator.accept(funnelDTOBuilder);

		return new Funnel(getTransport(), new CreateFunnelInvoker(getTransport(), 0)
				.setId(getId())
				.setFunnelEntity(new FunnelEntityBuilder()
						.setComponent(funnelDTOBuilder.build())
						.build())
				.invoke());
	}

	/**
	 * Creates a new funnel in the process group.
	 * 
	 * @param x The x position for the funnel.
	 * @param y The y position for the funnel.
	 * @param closure A {@link Closure} that delegates to a {@link FunnelDTOBuilder}
	 *        on which the funnel configuration may be set.
	 * @return The new funnel.
	 * @throws InvokerException if there is a problem creating the funnel.
	 */
	public Funnel createFunnel(final double x, final double y,
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FunnelDTOBuilder.class) final Closure<FunnelDTOBuilder> closure)
			throws InvokerException
	{
		return createFunnel(x, y, configurator -> {
			final Closure<FunnelDTOBuilder> code = closure.rehydrate(configurator, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
		});
	}

	/**
	 * Returns the funnels in the process group.
	 * 
	 * @return The funnels in the process group.
	 * @throws InvokerException if there is a problem getting the funnels.
	 */
	public Set<Funnel> getFunnels() throws InvokerException
	{
		return new GetFunnelsInvoker(getTransport(), getVersion())
				.setId(getId())
				.invoke()
				.getFunnels().stream()
				.map(funnelEntity -> new Funnel(getTransport(), funnelEntity))
				.collect(Collectors.toSet());
	}

	/**
	 * Creates an input port in the process group.
	 * 
	 * @param x The x position for the input port.
	 * @param y The y position for the input port.
	 * @param configurator A {@link Consumer} that accepts an instance of
	 *        {@link PortDTOBuilder} on which the input port configuration may be
	 *        set.
	 * @return A new input port.
	 * @throws InvokerException if there is a problem creating an input port.
	 */
	public InputPort createInputPort(final double x, final double y, final Consumer<PortDTOBuilder> configurator)
			throws InvokerException
	{
		final PortDTOBuilder portDTOBuilder = new PortDTOBuilder().setParentGroupId(getId())
				.setPosition(new PositionDTO(x, y));

		configurator.accept(portDTOBuilder);

		return new InputPort(getTransport(), new CreateInputPortInvoker(getTransport(), 0)
				.setId(getId())
				.setPortEntity(new PortEntityBuilder()
						.setComponent(portDTOBuilder.build())
						.build())
				.invoke());
	}

	/**
	 * Creates an input port in the process group.
	 * 
	 * @param x The x position for the input port.
	 * @param y The y position for the input port.
	 * @param closure A {@link Closure} that delegates to an instance of
	 *        {@link PortDTOBuilder} on which the input port configuration may be
	 *        set.
	 * @return A new input port.
	 * @throws InvokerException if there is a problem creating an input port.
	 */
	public InputPort createInputPort(final double x, final double y,
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PortDTOBuilder.class) final Closure<PortDTOBuilder> closure)
			throws InvokerException
	{
		return createInputPort(x, y, configurator -> {
			final Closure<PortDTOBuilder> code = closure.rehydrate(configurator, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
		});
	}

	/**
	 * Returns the input ports in the process group.
	 * 
	 * @return The input ports in the process group.
	 * @throws InvokerException if there is a problem getting the input ports.
	 */
	public Set<InputPort> getInputPorts() throws InvokerException
	{
		return new GetInputPortsInvoker(getTransport(), getVersion())
				.setId(getId())
				.invoke()
				.getInputPorts().stream()
				.map(inputPortEntity -> new InputPort(getTransport(), inputPortEntity))
				.collect(Collectors.toSet());
	}

	public OutputPort createOutputPort(final double x, final double y, final Consumer<PortDTOBuilder> configurator)
			throws InvokerException
	{
		final PortDTOBuilder portDTOBuilder = new PortDTOBuilder().setParentGroupId(getId())
				.setPosition(new PositionDTO(x, y));

		configurator.accept(portDTOBuilder);

		return new OutputPort(getTransport(), new CreateOutputPortInvoker(getTransport(), 0)
				.setId(getId())
				.setPortEntity(new PortEntityBuilder()
						.setComponent(portDTOBuilder.build())
						.build())
				.invoke());
	}

	public OutputPort createOutputPort(final double x, final double y,
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PortDTOBuilder.class) final Closure<PortDTOBuilder> closure)
			throws InvokerException
	{
		return createOutputPort(x, y, configurator -> {
			final Closure<PortDTOBuilder> code = closure.rehydrate(configurator, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
		});
	}

	public Set<OutputPort> getOutputPorts() throws InvokerException
	{
		return new GetOutputPortsInvoker(getTransport(), getVersion())
				.setId(getId())
				.invoke()
				.getOutputPorts().stream()
				.map(outputPortEntity -> new OutputPort(getTransport(), outputPortEntity))
				.collect(Collectors.toSet());
	}

	public Processor createProcessor(final double x, final double y, final String type,
			final Consumer<ProcessorDTOBuilder> configurator) throws InvokerException
	{
		final ProcessorDTOBuilder processorDTOBuilder = new ProcessorDTOBuilder().setParentGroupId(getId())
				.setPosition(new PositionDTO(x, y)).setType(type);

		configurator.accept(processorDTOBuilder);

		return new Processor(getTransport(), new CreateProcessorInvoker(getTransport(), 0)
				.setId(getId())
				.setProcessorEntity(new ProcessorEntityBuilder()
						.setComponent(processorDTOBuilder.build())
						.build())
				.invoke());
	}

	public Processor createProcessor(final double x, final double y, final String type,
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessorDTOBuilder.class) final Closure<ProcessorDTOBuilder> closure)
			throws InvokerException
	{
		return createProcessor(x, y, type, configurator -> {
			final Closure<ProcessorDTOBuilder> code = closure.rehydrate(configurator, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
		});
	}

	public Set<Processor> getProcessors() throws InvokerException
	{
		return new GetProcessorsInvoker(getTransport(), getVersion())
				.setId(getId())
				.invoke()
				.getProcessors().stream()
				.map(processorEntity -> new Processor(getTransport(), processorEntity))
				.collect(Collectors.toSet());
	}

	public ProcessGroup createProcessGroup(final double x, final double y, final String name,
			final Consumer<ProcessGroupDTOBuilder> configurator) throws InvokerException
	{
		final ProcessGroupDTOBuilder processGroupDTOBuilder = new ProcessGroupDTOBuilder()
				.setParentGroupId(getParentGroupId())
				.setPosition(new PositionDTO(x, y))
				.setName(name);

		configurator.accept(processGroupDTOBuilder);

		return new ProcessGroup(getTransport(), new CreateProcessGroupInvoker(getTransport(), 0)
				.setId(getParentGroupId())
				.setProcessGroupEntity(new ProcessGroupEntityBuilder()
						.setComponent(processGroupDTOBuilder.build())
						.build())
				.invoke());
	}

	public ProcessGroup createProcessGroup(final double x, final double y, final String name,
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessGroupDTOBuilder.class) final Closure<ProcessGroupDTOBuilder> closure)
			throws InvokerException
	{
		return createProcessGroup(x, y, name, configurator -> {
			final Closure<ProcessGroupDTOBuilder> code = closure.rehydrate(configurator, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
		});
	}

	public Set<ProcessGroup> getProcessGroups() throws InvokerException
	{
		return new GetProcessGroupsInvoker(getTransport(), getVersion())
				.setId(getId())
				.invoke()
				.getProcessGroups().stream()
				.map(processGroupEntity -> new ProcessGroup(getTransport(), processGroupEntity))
				.collect(Collectors.toSet());
	}

	public RemoteProcessGroup createRemoteProcessGroup(final double x, final double y, final String targetUri,
			final Consumer<RemoteProcessGroupDTOBuilder> configurator) throws InvokerException
	{
		final RemoteProcessGroupDTOBuilder remoteProcessGroupDTOBuilder = new RemoteProcessGroupDTOBuilder()
				.setParentGroupId(getParentGroupId())
				.setPosition(new PositionDTO(x, y))
				.setTargetUris(targetUri);

		configurator.accept(remoteProcessGroupDTOBuilder);

		return new RemoteProcessGroup(getTransport(), new CreateRemoteProcessGroupInvoker(getTransport(), 0)
				.setId(getId())
				.setRemoteProcessGroupEntity(new RemoteProcessGroupEntityBuilder()
						.setComponent(remoteProcessGroupDTOBuilder.build())
						.build())
				.invoke());
	}

	public RemoteProcessGroup createRemoteProcessGroup(final double x, final double y, final String targetUri,
			final Closure<RemoteProcessGroup> closure) throws InvokerException
	{
		return createRemoteProcessGroup(x, y, targetUri, configurator -> {
			final Closure<RemoteProcessGroup> code = closure.rehydrate(closure, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
		});
	}

	public RemoteProcessGroup createRemoteProcessGroup(final double x, final double y, final List<String> targetUris,
			final Consumer<RemoteProcessGroupDTOBuilder> configurator) throws InvokerException
	{
		return createRemoteProcessGroup(x, y, targetUris.stream().collect(Collectors.joining(",")), configurator);
	}

	public RemoteProcessGroup createRemoteProcessGroup(final double x, final double y, final List<String> targetUris,
			final Closure<RemoteProcessGroup> closure) throws InvokerException
	{
		return createRemoteProcessGroup(x, y, targetUris, configurator -> {
			final Closure<RemoteProcessGroup> code = closure.rehydrate(closure, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
		});
	}

	public Set<RemoteProcessGroup> getRemoteProcessGroups() throws InvokerException
	{
		return new GetRemoteProcessGroupsInvoker(getTransport(), getVersion())
				.setId(getId())
				.invoke()
				.getRemoteProcessGroups().stream()
				.map(remoteProcessGroupEntity -> new RemoteProcessGroup(getTransport(), remoteProcessGroupEntity))
				.collect(Collectors.toSet());
	}

	public Label createLabel(final double x, final double y, final Consumer<LabelDTOBuilder> configurator)
			throws InvokerException
	{
		final LabelDTOBuilder labelDTOBuilder = new LabelDTOBuilder().setParentGroupId(getId())
				.setPosition(new PositionDTO(x, y));

		configurator.accept(labelDTOBuilder);

		return new Label(getTransport(), new CreateLabelInvoker(getTransport(), 0)
				.setId(getId())
				.setLabelEntity(new LabelEntityBuilder()
						.setComponent(labelDTOBuilder.build())
						.build())
				.invoke());
	}

	public Label createLabel(final double x, final double y,
			@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = Label.class) final Closure<LabelDTOBuilder> closure)
			throws InvokerException
	{
		return createLabel(x, y, configurator -> {
			final Closure<LabelDTOBuilder> code = closure.rehydrate(configurator, this, this);
			code.setResolveStrategy(Closure.DELEGATE_ONLY);
			code.call();
		});
	}

	public Set<Label> getLabels() throws InvokerException
	{
		return new GetLabelsInvoker(getTransport(), getVersion())
				.setId(getId())
				.invoke()
				.getLabels().stream()
				.map(labelEntity -> new Label(getTransport(), labelEntity))
				.collect(Collectors.toSet());
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

		setComponentEntity(new UpdateProcessGroupInvoker(getTransport(), getVersion())
				.setId(getId())
				.setProcessGroupEntity(new ProcessGroupEntityBuilder()
						.setComponent(processGroupDTOBuilder.build())
						.build())
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

	public void instantiateTemplate(final double x, final double y, final Template template) throws InvokerException
	{
		final FlowEntity flowEntity = new InstantiateTemplateInvoker(getTransport(), getVersion())
				.setId(getId())
				.setInstantiateTemplateRequestEntity(new InstantiateTemplateRequestEntityBuilder()
						.setOriginX(x)
						.setOriginY(y)
						.setTemplateId(template.getId())
						.build())
				.invoke();
		final FlowDTO flowDTO = flowEntity.getFlow();
	}
}
