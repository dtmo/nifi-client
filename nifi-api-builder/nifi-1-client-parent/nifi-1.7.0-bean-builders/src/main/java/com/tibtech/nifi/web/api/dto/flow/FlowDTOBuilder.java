package com.tibtech.nifi.web.api.dto.flow;

import java.util.Set;
import org.apache.nifi.web.api.dto.flow.FlowDTO;
import org.apache.nifi.web.api.entity.ConnectionEntity;
import org.apache.nifi.web.api.entity.FunnelEntity;
import org.apache.nifi.web.api.entity.LabelEntity;
import org.apache.nifi.web.api.entity.PortEntity;
import org.apache.nifi.web.api.entity.ProcessGroupEntity;
import org.apache.nifi.web.api.entity.ProcessorEntity;
import org.apache.nifi.web.api.entity.RemoteProcessGroupEntity;

public final class FlowDTOBuilder {
  private Set<ConnectionEntity> connections;

  private Set<FunnelEntity> funnels;

  private Set<PortEntity> inputPorts;

  private Set<LabelEntity> labels;

  private Set<PortEntity> outputPorts;

  private Set<ProcessGroupEntity> processGroups;

  private Set<ProcessorEntity> processors;

  private Set<RemoteProcessGroupEntity> remoteProcessGroups;

  /**
   * The connections in this flow.
   */
  public Set<ConnectionEntity> getConnections() {
    return connections;
  }

  /**
   * The connections in this flow.
   */
  public FlowDTOBuilder setConnections(final Set<ConnectionEntity> connections) {
    this.connections = connections;
    return this;
  }

  /**
   * The funnels in this flow.
   */
  public Set<FunnelEntity> getFunnels() {
    return funnels;
  }

  /**
   * The funnels in this flow.
   */
  public FlowDTOBuilder setFunnels(final Set<FunnelEntity> funnels) {
    this.funnels = funnels;
    return this;
  }

  /**
   * The input ports in this flow.
   */
  public Set<PortEntity> getInputPorts() {
    return inputPorts;
  }

  /**
   * The input ports in this flow.
   */
  public FlowDTOBuilder setInputPorts(final Set<PortEntity> inputPorts) {
    this.inputPorts = inputPorts;
    return this;
  }

  /**
   * The labels in this flow.
   */
  public Set<LabelEntity> getLabels() {
    return labels;
  }

  /**
   * The labels in this flow.
   */
  public FlowDTOBuilder setLabels(final Set<LabelEntity> labels) {
    this.labels = labels;
    return this;
  }

  /**
   * The output ports in this flow.
   */
  public Set<PortEntity> getOutputPorts() {
    return outputPorts;
  }

  /**
   * The output ports in this flow.
   */
  public FlowDTOBuilder setOutputPorts(final Set<PortEntity> outputPorts) {
    this.outputPorts = outputPorts;
    return this;
  }

  /**
   * The process groups in this flow.
   */
  public Set<ProcessGroupEntity> getProcessGroups() {
    return processGroups;
  }

  /**
   * The process groups in this flow.
   */
  public FlowDTOBuilder setProcessGroups(final Set<ProcessGroupEntity> processGroups) {
    this.processGroups = processGroups;
    return this;
  }

  /**
   * The processors in this flow.
   */
  public Set<ProcessorEntity> getProcessors() {
    return processors;
  }

  /**
   * The processors in this flow.
   */
  public FlowDTOBuilder setProcessors(final Set<ProcessorEntity> processors) {
    this.processors = processors;
    return this;
  }

  /**
   * The remote process groups in this flow.
   */
  public Set<RemoteProcessGroupEntity> getRemoteProcessGroups() {
    return remoteProcessGroups;
  }

  /**
   * The remote process groups in this flow.
   */
  public FlowDTOBuilder setRemoteProcessGroups(
      final Set<RemoteProcessGroupEntity> remoteProcessGroups) {
    this.remoteProcessGroups = remoteProcessGroups;
    return this;
  }

  public FlowDTO build() {
    final FlowDTO flowDTO = new FlowDTO();
    flowDTO.setConnections(connections);
    flowDTO.setFunnels(funnels);
    flowDTO.setInputPorts(inputPorts);
    flowDTO.setLabels(labels);
    flowDTO.setOutputPorts(outputPorts);
    flowDTO.setProcessGroups(processGroups);
    flowDTO.setProcessors(processors);
    flowDTO.setRemoteProcessGroups(remoteProcessGroups);
    return flowDTO;
  }

  public static FlowDTOBuilder of(final FlowDTO flowDTO) {
    final FlowDTOBuilder flowDTOBuilder = new FlowDTOBuilder();
    flowDTOBuilder.setConnections(flowDTO.getConnections());
    flowDTOBuilder.setFunnels(flowDTO.getFunnels());
    flowDTOBuilder.setInputPorts(flowDTO.getInputPorts());
    flowDTOBuilder.setLabels(flowDTO.getLabels());
    flowDTOBuilder.setOutputPorts(flowDTO.getOutputPorts());
    flowDTOBuilder.setProcessGroups(flowDTO.getProcessGroups());
    flowDTOBuilder.setProcessors(flowDTO.getProcessors());
    flowDTOBuilder.setRemoteProcessGroups(flowDTO.getRemoteProcessGroups());
    return flowDTOBuilder;
  }
}
