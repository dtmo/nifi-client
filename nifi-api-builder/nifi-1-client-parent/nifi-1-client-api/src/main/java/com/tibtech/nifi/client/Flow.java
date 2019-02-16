package com.tibtech.nifi.client;

import org.apache.nifi.web.api.dto.flow.FlowDTO;
import org.apache.nifi.web.api.entity.FlowEntity;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Flow represents a flow of NiFi components.
 */
public class Flow
{
    private Controller controller;
    private FlowEntity flowEntity;

    /**
     * Constructs a new instance of Flow.
     *
     * @param controller The controller to which the flow belongs.
     * @param flowEntity The flow entity that represents the flow.
     */
    public Flow(final Controller controller, final FlowEntity flowEntity)
    {
        this.controller = controller;
        this.flowEntity = flowEntity;
    }

    /**
     * Returns the DTO that describes the flow.
     *
     * @return The DTO that describes the flow.
     */
    public FlowDTO getFlowDTO()
    {
        return flowEntity.getFlow();
    }

    /**
     * Returns the connections included in the flow.
     *
     * @return The connections included in the flow.
     */
    public Set<Connection> getConnections()
    {
        return getFlowDTO().getConnections().stream().map(entity -> new Connection(controller, entity))
                .collect(Collectors.toSet());
    }

    /**
     * Returns the funnels included in the flow.
     *
     * @return The funnels included in the flow.
     */
    public Set<Funnel> getFunnels()
    {
        return getFlowDTO().getFunnels().stream().map(entity -> new Funnel(controller, entity))
                .collect(Collectors.toSet());
    }

    /**
     * Returns the input ports included in the flow.
     *
     * @return The input ports included in the flow.
     */
    public Set<InputPort> getInputPorts()
    {
        return getFlowDTO().getInputPorts().stream().map(entity -> new InputPort(controller, entity))
                .collect(Collectors.toSet());
    }

    /**
     * Returns the labels included in the flow.
     *
     * @return The labels included in the flow.
     */
    public Set<Label> getLabels()
    {
        return getFlowDTO().getLabels().stream().map(entity -> new Label(controller, entity))
                .collect(Collectors.toSet());
    }

    /**
     * Returns the output ports included in the flow.
     *
     * @return The output ports included in the flow.
     */
    public Set<OutputPort> getOutputPorts()
    {
        return getFlowDTO().getOutputPorts().stream().map(entity -> new OutputPort(controller, entity))
                .collect(Collectors.toSet());
    }

    /**
     * Returns the process groups included in the flow.
     *
     * @return The process groups included in the flow.
     */
    public Set<ProcessGroup> getProcessGroups()
    {
        return getFlowDTO().getProcessGroups().stream().map(entity -> new ProcessGroup(controller, entity))
                .collect(Collectors.toSet());
    }

    /**
     * Returns the processors included in the flow.
     *
     * @return The processors included in the flow.
     */
    public Set<Processor> getProcessors()
    {
        return getFlowDTO().getProcessors().stream().map(entity -> new Processor(controller, entity))
                .collect(Collectors.toSet());
    }

    /**
     * Returns the remote process groups included in the flow.
     *
     * @return The remote process groups included in the flow.
     */
    public Set<RemoteProcessGroup> getRemoteProcessGroups()
    {
        return getFlowDTO().getRemoteProcessGroups().stream().map(entity -> new RemoteProcessGroup(controller, entity))
                .collect(Collectors.toSet());
    }
}
