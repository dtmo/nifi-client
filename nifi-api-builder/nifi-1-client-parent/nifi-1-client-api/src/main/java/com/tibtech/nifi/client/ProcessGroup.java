package com.tibtech.nifi.client;

import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.dto.ProcessGroupDTO;
import org.apache.nifi.web.api.dto.RevisionDTO;
import org.apache.nifi.web.api.dto.status.ProcessGroupStatusDTO;
import org.apache.nifi.web.api.dto.status.ProcessGroupStatusSnapshotDTO;
import org.apache.nifi.web.api.entity.ProcessGroupEntity;

import com.tibtech.nifi.web.api.dto.ControllerServiceDTOBuilder;
import com.tibtech.nifi.web.api.dto.FunnelDTOBuilder;
import com.tibtech.nifi.web.api.dto.LabelDTOBuilder;
import com.tibtech.nifi.web.api.dto.PortDTOBuilder;
import com.tibtech.nifi.web.api.dto.ProcessGroupDTOBuilder;
import com.tibtech.nifi.web.api.dto.ProcessorDTOBuilder;
import com.tibtech.nifi.web.api.dto.RemoteProcessGroupDTOBuilder;
import com.tibtech.nifi.web.api.dto.RevisionDTOBuilder;
import com.tibtech.nifi.web.api.entity.ControllerServiceEntityBuilder;
import com.tibtech.nifi.web.api.entity.FunnelEntityBuilder;
import com.tibtech.nifi.web.api.entity.InstantiateTemplateRequestEntityBuilder;
import com.tibtech.nifi.web.api.entity.LabelEntityBuilder;
import com.tibtech.nifi.web.api.entity.PortEntityBuilder;
import com.tibtech.nifi.web.api.entity.ProcessGroupEntityBuilder;
import com.tibtech.nifi.web.api.entity.ProcessorEntityBuilder;
import com.tibtech.nifi.web.api.entity.RemoteProcessGroupEntityBuilder;
import com.tibtech.nifi.web.api.entity.ScheduleComponentsEntityBuilder;
import com.tibtech.nifi.web.api.entity.SnippetEntityBuilder;
import com.tibtech.nifi.web.api.flow.GetControllerServicesFromGroupInvoker;
import com.tibtech.nifi.web.api.flow.GetProcessGroupStatusInvoker;
import com.tibtech.nifi.web.api.flow.ScheduleComponentsInvoker;
import com.tibtech.nifi.web.api.processgroup.CreateControllerServiceInvoker;
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
import com.tibtech.nifi.web.api.processgroup.UploadTemplateInvoker;
import com.tibtech.nifi.web.api.snippet.CreateSnippetInvoker;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;

/**
 * ProcessGroup represents a NiFi flow process group which groups related flow
 * components together.
 */
public class ProcessGroup extends AbstractComponent<ProcessGroupEntity>
        implements Deletable, Refreshable<ProcessGroup>, Updatable<ProcessGroup, ProcessGroupDTOBuilder>
{
    public static final String STATE_RUNNING = "RUNNING";
    public static final String STATE_STOPPED = "STOPPED";
    public static final String STATE_ENABLED = "ENABLED";
    public static final String STATE_DISABLED = "DISABLED";

    /**
     * Constructs a new instance of ProcessGroup.
     *
     * @param controller         The controller to which the process group belongs.
     * @param processGroupEntity The entity that describes the process group.
     */
    public ProcessGroup(final Controller controller, final ProcessGroupEntity processGroupEntity)
    {
        super(controller, processGroupEntity);
    }

    /**
     * Returns the DTO that describes the process group.
     *
     * @return The DTO that describes the process group.
     */
    public ProcessGroupDTO getProcessGroupDTO()
    {
        return getComponentEntity().getComponent();
    }

    @Override
    public String getId()
    {
        return getProcessGroupDTO().getId();
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
        return new GetConnectionsInvoker(getController().getTransport()).setId(getId()).invoke().getConnections()
                .stream().map(connectionEntity -> new Connection(getController(), connectionEntity))
                .collect(Collectors.toSet());
    }

    /**
     * Creates a new funnel in the process group.
     *
     * @param x            The x position for the funnel.
     * @param y            The y position for the funnel.
     * @param configurator A {@link Consumer} that accepts a
     *                     {@link FunnelDTOBuilder} on which the funnel
     *                     configuration may be set.
     * @return The new funnel.
     * @throws InvokerException if there is a problem creating the funnel.
     */
    public Funnel createFunnel(final double x, final double y, final Consumer<FunnelDTOBuilder> configurator)
            throws InvokerException
    {
        final FunnelDTOBuilder funnelDTOBuilder = new FunnelDTOBuilder().setParentGroupId(getId())
                .setPosition(new PositionDTO(x, y));

        configurator.accept(funnelDTOBuilder);

        return new Funnel(getController(), new CreateFunnelInvoker(getController().getTransport()).setId(getId())
                .setFunnelEntity(new FunnelEntityBuilder()
                        .setComponent(funnelDTOBuilder.build()).setRevision(new RevisionDTOBuilder()
                                .setClientId(getController().getTransport().getClientId()).setVersion(0L).build())
                        .build())
                .invoke());
    }

    /**
     * Creates a new funnel in the process group.
     *
     * @param x       The x position for the funnel.
     * @param y       The y position for the funnel.
     * @param closure A {@link Closure} that delegates to a {@link FunnelDTOBuilder}
     *                on which the funnel configuration may be set.
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
        return new GetFunnelsInvoker(getController().getTransport()).setId(getId()).invoke().getFunnels().stream()
                .map(funnelEntity -> new Funnel(getController(), funnelEntity)).collect(Collectors.toSet());
    }

    /**
     * Creates an input port in the process group.
     *
     * @param x            The x position for the input port.
     * @param y            The y position for the input port.
     * @param configurator A {@link Consumer} that accepts an instance of
     *                     {@link PortDTOBuilder} on which the input port
     *                     configuration may be set.
     * @return A new input port.
     * @throws InvokerException if there is a problem creating an input port.
     */
    public InputPort createInputPort(final double x, final double y, final Consumer<PortDTOBuilder> configurator)
            throws InvokerException
    {
        final PortDTOBuilder portDTOBuilder = new PortDTOBuilder().setParentGroupId(getId())
                .setPosition(new PositionDTO(x, y));

        configurator.accept(portDTOBuilder);

        return new InputPort(getController(), new CreateInputPortInvoker(getController().getTransport()).setId(getId())
                .setPortEntity(new PortEntityBuilder()
                        .setComponent(portDTOBuilder.build()).setRevision(new RevisionDTOBuilder()
                                .setClientId(getController().getTransport().getClientId()).setVersion(0L).build())
                        .build())
                .invoke());
    }

    /**
     * Creates an input port in the process group.
     *
     * @param x       The x position for the input port.
     * @param y       The y position for the input port.
     * @param closure A {@link Closure} that delegates to an instance of
     *                {@link PortDTOBuilder} on which the input port configuration
     *                may be set.
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
        return new GetInputPortsInvoker(getController().getTransport()).setId(getId()).invoke().getInputPorts().stream()
                .map(inputPortEntity -> new InputPort(getController(), inputPortEntity)).collect(Collectors.toSet());
    }

    /**
     * Creates an instance of {@link OutputPort} within this process group.
     *
     * @param x            The x position of the output port.
     * @param y            The y position of the output port.
     * @param configurator A consumer that accepts an instance of
     *                     {@link PortDTOBuilder} on which the output port
     *                     configuration may be set.
     * @return The new {@link OutputPort}.
     * @throws InvokerException if there is a problem creating the output port.
     */
    public OutputPort createOutputPort(final double x, final double y, final Consumer<PortDTOBuilder> configurator)
            throws InvokerException
    {
        final PortDTOBuilder portDTOBuilder = new PortDTOBuilder().setParentGroupId(getId())
                .setPosition(new PositionDTO(x, y));

        configurator.accept(portDTOBuilder);

        return new OutputPort(getController(), new CreateOutputPortInvoker(getController().getTransport())
                .setId(getId())
                .setPortEntity(new PortEntityBuilder()
                        .setComponent(portDTOBuilder.build()).setRevision(new RevisionDTOBuilder()
                                .setClientId(getController().getTransport().getClientId()).setVersion(0L).build())
                        .build())
                .invoke());
    }

    /**
     * Creates an instance of {@link OutputPort} within this process group.
     *
     * @param x       The x position of the output port.
     * @param y       The y position of the output port.
     * @param closure A closure delegating to an instance of {@link PortDTOBuilder}
     *                on which the output port configuration may be set.
     * @return The new {@link OutputPort}.
     * @throws InvokerException if there is a problem creating the output port.
     */
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

    /**
     * Returns the output ports within this process group.
     *
     * @return The output ports within this process group.
     * @throws InvokerException if there is a problem getting the output ports.
     */
    public Set<OutputPort> getOutputPorts() throws InvokerException
    {
        return new GetOutputPortsInvoker(getController().getTransport()).setId(getId()).invoke().getOutputPorts()
                .stream().map(outputPortEntity -> new OutputPort(getController(), outputPortEntity))
                .collect(Collectors.toSet());
    }

    /**
     * Creates a new processor within the process group.
     *
     * @param x            The x position at which to create the processor.
     * @param y            The y position at which to create the processor.
     * @param type         The fully qualified type name of the processor to create.
     * @param configurator A consumer that accepts a {@link ProcessorDTOBuilder} on
     *                     which the processor configuration may be set.
     * @return The new processor.
     * @throws InvokerException if there is a problem creating the processor.
     */
    public Processor createProcessor(final double x, final double y, final String type,
            final Consumer<ProcessorDTOBuilder> configurator) throws InvokerException
    {
        final ProcessorDTOBuilder processorDTOBuilder = new ProcessorDTOBuilder().setParentGroupId(getId())
                .setPosition(new PositionDTO(x, y)).setType(type);

        configurator.accept(processorDTOBuilder);

        return new Processor(getController(), new CreateProcessorInvoker(getController().getTransport()).setId(getId())
                .setProcessorEntity(new ProcessorEntityBuilder()
                        .setComponent(processorDTOBuilder.build()).setRevision(new RevisionDTOBuilder()
                                .setClientId(getController().getTransport().getClientId()).setVersion(0L).build())
                        .build())
                .invoke());
    }

    /**
     * Creates a new processor within the process group.
     *
     * @param x       The x position at which to create the processor.
     * @param y       The y position at which to create the processor.
     * @param type    The fully qualified type name of the processor to create.
     * @param closure A closure that delegates to an instance of
     *                {@link ProcessorDTOBuilder} on which the processor
     *                configuration may be set.
     * @return The new processor.
     * @throws InvokerException if there is a problem creating the processor.
     */
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

    /**
     * Returns the set of processors contained by the proecss group.
     *
     * @return The set of processors contained by the process group.
     * @throws InvokerException if there is a problem getting the processors.
     */
    public Set<Processor> getProcessors() throws InvokerException
    {
        return new GetProcessorsInvoker(getController().getTransport()).setId(getId()).invoke().getProcessors().stream()
                .map(processorEntity -> new Processor(getController(), processorEntity)).collect(Collectors.toSet());
    }

    /**
     * Creates a new process group in this process group.
     *
     * @param x            The x position for the new process group.
     * @param y            The y position for the new process group.
     * @param name         The name of the new process group.
     * @param configurator A consumer that accepts a {@link ProcessGroupDTOBuilder}
     *                     on which the new process group configuration may be set.
     * @return The new process group.
     * @throws InvokerException if there is a problem creating the process group.
     */
    public ProcessGroup createProcessGroup(final double x, final double y, final String name,
            final Consumer<ProcessGroupDTOBuilder> configurator) throws InvokerException
    {
        final ProcessGroupDTOBuilder processGroupDTOBuilder = new ProcessGroupDTOBuilder()
                .setParentGroupId(getParentGroupId()).setPosition(new PositionDTO(x, y)).setName(name);

        configurator.accept(processGroupDTOBuilder);

        return new ProcessGroup(getController(), new CreateProcessGroupInvoker(getController().getTransport())
                .setId(getParentGroupId())
                .setProcessGroupEntity(new ProcessGroupEntityBuilder()
                        .setComponent(processGroupDTOBuilder.build()).setRevision(new RevisionDTOBuilder()
                                .setClientId(getController().getTransport().getClientId()).setVersion(0L).build())
                        .build())
                .invoke());
    }

    /**
     * Creates a new process group in this process group.
     *
     * @param x       The x position for the new process group.
     * @param y       The y position for the new process group.
     * @param name    The name of the new process group.
     * @param closure A closure that delegates to an instance of
     *                {@link ProcessGroupDTOBuilder} on which the new process group
     *                configuration may be set.
     * @return The new process group.
     * @throws InvokerException if there is a problem creating the process group.
     */
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

    /**
     * Returns the set of process groups contained by this process group.
     *
     * @return The set of process groups contained by this process group.
     * @throws InvokerException if there is a problem getting the set of process
     *                          groups.
     */
    public Set<ProcessGroup> getProcessGroups() throws InvokerException
    {
        return new GetProcessGroupsInvoker(getController().getTransport()).setId(getId()).invoke().getProcessGroups()
                .stream().map(processGroupEntity -> new ProcessGroup(getController(), processGroupEntity))
                .collect(Collectors.toSet());
    }

    /**
     * Creates a new remote process group within this process group.
     *
     * @param x            The x position for the new remote process group.
     * @param y            The y position for the new remote process group.
     * @param targetUri    The target URI for the new remote process group.
     * @param configurator A consumer that accepts a
     *                     {@link RemoteProcessGroupDTOBuilder} on which the remote
     *                     process group configuration may be set.
     * @return The new remote process group.
     * @throws InvokerException if there is a problem creating the remote process
     *                          group.
     */
    public RemoteProcessGroup createRemoteProcessGroup(final double x, final double y, final String targetUri,
            final Consumer<RemoteProcessGroupDTOBuilder> configurator) throws InvokerException
    {
        final RemoteProcessGroupDTOBuilder remoteProcessGroupDTOBuilder = new RemoteProcessGroupDTOBuilder()
                .setParentGroupId(getParentGroupId()).setPosition(new PositionDTO(x, y)).setTargetUris(targetUri);

        configurator.accept(remoteProcessGroupDTOBuilder);

        return new RemoteProcessGroup(getController(),
                new CreateRemoteProcessGroupInvoker(getController().getTransport()).setId(getId())
                        .setRemoteProcessGroupEntity(
                                new RemoteProcessGroupEntityBuilder().setComponent(remoteProcessGroupDTOBuilder.build())
                                        .setRevision(new RevisionDTOBuilder()
                                                .setClientId(getController().getTransport().getClientId())
                                                .setVersion(0L).build())
                                        .build())
                        .invoke());
    }

    /**
     * Creates a new remote process group within this process group.
     *
     * @param x         The x position for the new remote process group.
     * @param y         The y position for the new remote process group.
     * @param targetUri The target URI for the new remote process group.
     * @param closure   A closure that delegates to an instance of
     *                  {@link RemoteProcessGroupDTOBuilder} on which the remote
     *                  process group configuration may be set.
     * @return The new remote process group.
     * @throws InvokerException if there is a problem creating the remote process
     *                          group.
     */
    public RemoteProcessGroup createRemoteProcessGroup(final double x, final double y, final String targetUri,
            final Closure<RemoteProcessGroup> closure) throws InvokerException
    {
        return createRemoteProcessGroup(x, y, targetUri, configurator -> {
            final Closure<RemoteProcessGroup> code = closure.rehydrate(closure, this, this);
            code.setResolveStrategy(Closure.DELEGATE_ONLY);
            code.call();
        });
    }

    /**
     * Creates a new remote process group within this process group.
     *
     * @param x            The x position for the new remote process group.
     * @param y            The y position for the new remote process group.
     * @param targetUris   A list of target URIs for the new remote process group.
     * @param configurator A consumer that accepts a
     *                     {@link RemoteProcessGroupDTOBuilder} on which the remote
     *                     process group configuration may be set.
     * @return The new remote process group.
     * @throws InvokerException if there is a problem creating the remote process
     *                          group.
     */
    public RemoteProcessGroup createRemoteProcessGroup(final double x, final double y, final List<String> targetUris,
            final Consumer<RemoteProcessGroupDTOBuilder> configurator) throws InvokerException
    {
        return createRemoteProcessGroup(x, y, targetUris.stream().collect(Collectors.joining(",")), configurator);
    }

    /**
     * Creates a new remote process group within this process group.
     *
     * @param x          The x position for the new remote process group.
     * @param y          The y position for the new remote process group.
     * @param targetUris A list of target URIs for the new remote process group.
     * @param closure    A closure that delegates to an instance of
     *                   {@link RemoteProcessGroupDTOBuilder} on which the remote
     *                   process group configuration may be set.
     * @return The new remote process group.
     * @throws InvokerException if there is a problem creating the remote process
     *                          group.
     */
    public RemoteProcessGroup createRemoteProcessGroup(final double x, final double y, final List<String> targetUris,
            final Closure<RemoteProcessGroup> closure) throws InvokerException
    {
        return createRemoteProcessGroup(x, y, targetUris, configurator -> {
            final Closure<RemoteProcessGroup> code = closure.rehydrate(closure, this, this);
            code.setResolveStrategy(Closure.DELEGATE_ONLY);
            code.call();
        });
    }

    /**
     * Returns the set of remote process groups contained by this process group.
     *
     * @return The set of remote process groups contained by this process group.
     * @throws InvokerException if there is a problem getting the remote process
     *                          groups.
     */
    public Set<RemoteProcessGroup> getRemoteProcessGroups() throws InvokerException
    {
        return new GetRemoteProcessGroupsInvoker(getController().getTransport()).setId(getId()).invoke()
                .getRemoteProcessGroups().stream()
                .map(remoteProcessGroupEntity -> new RemoteProcessGroup(getController(), remoteProcessGroupEntity))
                .collect(Collectors.toSet());
    }

    /**
     * Creates a label within this process group.
     *
     * @param x            The x position for the new label.
     * @param y            The y position for the new label.
     * @param configurator A consumer that accepts an instance of
     *                     {@link LabelDTOBuilder} on which the label configuration
     *                     may be set.
     * @return The new label.
     * @throws InvokerException if there is a problem creating a new label.
     */
    public Label createLabel(final double x, final double y, final Consumer<LabelDTOBuilder> configurator)
            throws InvokerException
    {
        final LabelDTOBuilder labelDTOBuilder = new LabelDTOBuilder().setParentGroupId(getId())
                .setPosition(new PositionDTO(x, y));

        configurator.accept(labelDTOBuilder);

        return new Label(getController(), new CreateLabelInvoker(getController().getTransport()).setId(getId())
                .setLabelEntity(new LabelEntityBuilder()
                        .setComponent(labelDTOBuilder.build()).setRevision(new RevisionDTOBuilder()
                                .setClientId(getController().getTransport().getClientId()).setVersion(0L).build())
                        .build())
                .invoke());
    }

    /**
     * Creates a label within this process group.
     *
     * @param x       The x position for the new label.
     * @param y       The y position for the new label.
     * @param closure A closure that delegates to an instance of
     *                {@link LabelDTOBuilder} on which the label configuration may
     *                be set.
     * @return The new label.
     * @throws InvokerException if there is a problem creating a new label.
     */
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

    /**
     * Returns the set of labels contained by this process group.
     *
     * @return The set of labels contained by this process group.
     * @throws InvokerException if there is a problem getting the set of labels.
     */
    public Set<Label> getLabels() throws InvokerException
    {
        return new GetLabelsInvoker(getController().getTransport()).setId(getId()).invoke().getLabels().stream()
                .map(labelEntity -> new Label(getController(), labelEntity)).collect(Collectors.toSet());
    }

    @Override
    public ProcessGroup refresh() throws InvokerException
    {
        setComponentEntity(new GetProcessGroupInvoker(getController().getTransport()).setId(getId()).invoke());

        return this;
    }

    @Override
    public ProcessGroup update(final Consumer<ProcessGroupDTOBuilder> configurator) throws InvokerException
    {
        final ProcessGroupDTOBuilder processGroupDTOBuilder = new ProcessGroupDTOBuilder().setId(getId());

        configurator.accept(processGroupDTOBuilder);

        setComponentEntity(new UpdateProcessGroupInvoker(getController().getTransport()).setId(getId())
                .setProcessGroupEntity(new ProcessGroupEntityBuilder()
                        .setComponent(processGroupDTOBuilder.build()).setRevision(new RevisionDTOBuilder()
                                .setClientId(getController().getTransport().getClientId()).setVersion(0L).build())
                        .build())
                .invoke());

        return this;
    }

    @Override
    public ProcessGroup update(
            @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessGroupDTOBuilder.class) final Closure<ProcessGroupDTOBuilder> closure)
            throws InvokerException
    {
        return Updatable.super.update(closure);
    }

    /**
     * Gets the set of process group controller services.
     *
     * @param includeAncestorGroups   Whether or not to include parent/ancestory
     *                                process groups.
     * @param includeDescendantGroups Whether or not to include descendant process
     *                                groups.
     * @return The process group controller services.
     * @throws InvokerException if there is a problem getting all controller
     *                          services.
     */
    public Set<ControllerService> getControllerServices(final boolean includeAncestorGroups,
            final boolean includeDescendantGroups) throws InvokerException
    {
        return new GetControllerServicesFromGroupInvoker(getController().getTransport()).setId(getId())
                .setIncludeAncestorGroups(includeAncestorGroups).setIncludeDescendantGroups(includeDescendantGroups)
                .invoke().getControllerServices().stream()
                .map(controllerServiceEntity -> new ControllerService(getController(), controllerServiceEntity))
                .collect(Collectors.toSet());
    }

    /**
     * Creates a new Process Group scoped Controller Service.
     *
     * @param type         The fully qualified class name of the controller service
     *                     to create.
     * @param configurator A consumer that accepts an instance of
     *                     {@link ControllerServiceDTOBuilder} on which controller
     *                     service settings may be set.
     * @return The new controller service.
     * @throws InvokerException if there is a problem creating the controller
     *                          service.
     * @see Controller#getControllerServiceTypeDTOs()
     */
    public ControllerService createControllerService(final String type,
            final Consumer<ControllerServiceDTOBuilder> configurator) throws InvokerException
    {
        final ControllerServiceDTOBuilder controllerServiceDTOBuilder = new ControllerServiceDTOBuilder().setType(type);

        configurator.accept(controllerServiceDTOBuilder);

        return new ControllerService(getController(), new CreateControllerServiceInvoker(getController().getTransport())
                .setId(getId())
                .setControllerServiceEntity(new ControllerServiceEntityBuilder()
                        .setComponent(controllerServiceDTOBuilder.build()).setRevision(new RevisionDTOBuilder()
                                .setClientId(getController().getTransport().getClientId()).setVersion(0L).build())
                        .build())
                .invoke());
    }

    /**
     * Creates a new Process Group scoped Controller Service.
     *
     * @param type    The fully qualified class name of the type of controller
     *                service to create.
     * @param closure A closure that delegates to an instance of
     *                {@link ControllerServiceDTOBuilder} on which controller
     *                service settings may be set.
     * @return The new controller service.
     * @throws InvokerException if there is a problem creating the controller
     *                          service.
     * @see Controller#getControllerServiceTypeDTOs()
     */
    public ControllerService createControllerService(final String type,
            @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ControllerServiceDTOBuilder.class) final Closure<ControllerServiceDTOBuilder> closure)
            throws InvokerException
    {
        return createControllerService(type, configurator -> {
            final Closure<ControllerServiceDTOBuilder> code = closure.rehydrate(configurator, this, this);
            code.setResolveStrategy(Closure.DELEGATE_ONLY);
            code.call();
        });
    }

    @Override
    public void delete() throws InvokerException
    {
        new RemoveProcessGroupInvoker(getController().getTransport()).setId(getId())
                .setVersion(getRevisionDTO().getVersion()).invoke();
    }

    /**
     * Creates a snippet containing components from this process group.
     *
     * @param configurator A consumer that accepts an instance of
     *                     {@link com.tibtech.nifi.client.Snippet.SnippetDTOBuilder}
     *                     to which snippet components may be added.
     * @return The new snippet.
     * @throws InvokerException if there is a problem creating a snippet.
     */
    public Snippet createSnippet(final Consumer<Snippet.SnippetDTOBuilder> configurator) throws InvokerException
    {
        final Snippet.SnippetDTOBuilder snippetDtoBuilder = new Snippet.SnippetDTOBuilder().setParentGroup(this);

        configurator.accept(snippetDtoBuilder);

        return new Snippet(this, new CreateSnippetInvoker(getController().getTransport())
                .setSnippetEntity(new SnippetEntityBuilder().setSnippet(snippetDtoBuilder.build()).build()).invoke());
    }

    /**
     * Creates a snippet containing components from this process group.
     *
     * @param closure A closure that delegates to an instance of
     *                {@link com.tibtech.nifi.client.Snippet.SnippetDTOBuilder} to
     *                which snippet components may be added.
     * @return The new snippet.
     * @throws InvokerException if there is a problem creating a snippet.
     */
    public Snippet createSnippet(
            @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = Snippet.SnippetDTOBuilder.class) final Closure<Snippet.SnippetDTOBuilder> closure)
            throws InvokerException
    {
        return createSnippet(configurator -> {
            final Closure<Snippet.SnippetDTOBuilder> code = closure.rehydrate(configurator, this, this);
            code.setResolveStrategy(Closure.DELEGATE_ONLY);
            code.call();
        });
    }

    /**
     * Uploads a snippet of flow XML as a template.
     *
     * @param template The template XML to upload.
     * @return The Template representing the uploaded XML.
     * @throws InvokerException if there was a problem uploading the template.
     */
    public Template uploadTemplate(final InputStream template) throws InvokerException
    {
        return new Template(getController(), new UploadTemplateInvoker(getController().getTransport()).setId(getId())
                .setTemplate(template).invoke());
    }

    /**
     * Instantiates a template in this process group.
     *
     * @param x        The x position at which to instantiate the template.
     * @param y        The y position at which to instantiate the template.
     * @param template The template to instantiate.
     * @return A flow containing the instantiated components.
     * @throws InvokerException if there is a problem instantiating the template.
     */
    public Flow instantiateTemplate(final double x, final double y, final Template template) throws InvokerException
    {
        return new Flow(getController(),
                new InstantiateTemplateInvoker(getController().getTransport()).setId(getId())
                        .setInstantiateTemplateRequestEntity(new InstantiateTemplateRequestEntityBuilder().setOriginX(x)
                                .setOriginY(y).setTemplateId(template.getId()).build())
                        .invoke());
    }

    /**
     * Starts all components within the process group.
     *
     * @throws InvokerException if the components could not be started.
     */
    public ProcessGroup startComponents() throws InvokerException
    {
        return startComponents(Collections.emptySet());
    }

    /**
     * Starts components within the process group.
     *
     * @param components The components to start.
     * @throws InvokerException if the components could not be started.
     */
    public ProcessGroup startComponents(final Collection<Component> components) throws InvokerException
    {
        return setComponentRunStates(true, components);
    }

    /**
     * Stops all components within the process group.
     *
     * @throws InvokerException if the components could not be stopped.
     */
    public ProcessGroup stopComponents() throws InvokerException
    {
        return stopComponents(Collections.emptySet());
    }

    /**
     * Stops components within the process group.
     *
     * @param components The components to stop.
     * @throws InvokerException if the components could not be stopped.
     */
    public ProcessGroup stopComponents(final Collection<Component> components) throws InvokerException
    {
        return setComponentRunStates(false, components);
    }

    /**
     * Schedules components within the process group to be run or stopped.
     *
     * @param running Whether the components should be running or not.
     * @throws InvokerException if the run state of the components could not be
     *                          changed.
     */
    public ProcessGroup setComponentRunStates(final boolean running, final Collection<Component> components)
            throws InvokerException
    {
        final Map<String, RevisionDTO> revisionIdsMap = new HashMap<>();
        components.forEach(component -> {
            revisionIdsMap.put(component.getId(), component.getRevisionDTO());
        });

        final String runState = running ? STATE_RUNNING : STATE_STOPPED;

        new ScheduleComponentsInvoker(getController().getTransport()).setId(getId())
                .setScheduleComponentsEntity(new ScheduleComponentsEntityBuilder().setId(getId()).setState(runState)
                        .setComponents(revisionIdsMap).build())
                .invoke();

        return this.refresh();
    }

    /**
     * Gets the status for a process group. The status for a process group includes
     * status for all descendant components. When invoked on the root group with
     * recursive set to true, it will return the current status of every component
     * in the flow.
     *
     * @param recursive If set to true, all descendant groups and the status of
     *                  their content will be included.
     */
    public ProcessGroupStatus getStatus(final boolean recursive) throws InvokerException
    {
        final ProcessGroupStatusDTO processGroupStatusDTO = new GetProcessGroupStatusInvoker(
                getController().getTransport()).setId(getId()).setRecursive(recursive).invoke().getProcessGroupStatus();

        final Deque<ProcessGroupStatusSnapshotDTO> processGroupStatusSnapshotDtos = new ArrayDeque<ProcessGroupStatusSnapshotDTO>();
        processGroupStatusSnapshotDtos.push(processGroupStatusDTO.getAggregateSnapshot());

        final ProcessGroupStatus.Builder processGroupStatusBuilder = new ProcessGroupStatus.Builder();
        while (processGroupStatusSnapshotDtos.isEmpty() == false)
        {
            final ProcessGroupStatusSnapshotDTO processGroupStatusSnapshotDto = processGroupStatusSnapshotDtos.pop();

            if (processGroupStatusSnapshotDto.getConnectionStatusSnapshots() != null)
            {
                processGroupStatusSnapshotDto.getConnectionStatusSnapshots().forEach(entity -> processGroupStatusBuilder
                        .addConnectionStatusSnapshotDto(entity.getConnectionStatusSnapshot()));
            }

            if (processGroupStatusSnapshotDto.getInputPortStatusSnapshots() != null)
            {
                processGroupStatusSnapshotDto.getInputPortStatusSnapshots().forEach(entity -> processGroupStatusBuilder
                        .addInputPortStatusSnapshotDto(entity.getPortStatusSnapshot()));
            }

            if (processGroupStatusSnapshotDto.getOutputPortStatusSnapshots() != null)
            {
                processGroupStatusSnapshotDto.getOutputPortStatusSnapshots().forEach(entity -> processGroupStatusBuilder
                        .addOutputPortStatusSnapshotDto(entity.getPortStatusSnapshot()));
            }

            if (processGroupStatusSnapshotDto.getProcessorStatusSnapshots() != null)
            {
                processGroupStatusSnapshotDto.getProcessorStatusSnapshots().forEach(entity -> processGroupStatusBuilder
                        .addProcessorStatusSnapshotDto(entity.getProcessorStatusSnapshot()));
            }

            if (processGroupStatusSnapshotDto.getRemoteProcessGroupStatusSnapshots() != null)
            {
                processGroupStatusSnapshotDto.getRemoteProcessGroupStatusSnapshots()
                        .forEach(entity -> processGroupStatusBuilder
                                .addRemoteProcessGroupStatusSnapshotDto(entity.getRemoteProcessGroupStatusSnapshot()));
            }

            if (processGroupStatusSnapshotDto.getProcessGroupStatusSnapshots() != null)
            {
                processGroupStatusSnapshotDto.getProcessGroupStatusSnapshots().forEach(entity -> {
                    processGroupStatusBuilder.addProcessGroupStatusSnapshotDto(entity.getProcessGroupStatusSnapshot());
                    processGroupStatusSnapshotDtos.push(entity.getProcessGroupStatusSnapshot());
                });
            }
        }

        return processGroupStatusBuilder.build();
    }
}
