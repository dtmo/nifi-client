package com.tibtech.nifi.web.api.dto;

import java.util.Set;
import org.apache.nifi.web.api.dto.ConnectionDTO;
import org.apache.nifi.web.api.dto.ControllerServiceDTO;
import org.apache.nifi.web.api.dto.FlowSnippetDTO;
import org.apache.nifi.web.api.dto.FunnelDTO;
import org.apache.nifi.web.api.dto.LabelDTO;
import org.apache.nifi.web.api.dto.PortDTO;
import org.apache.nifi.web.api.dto.ProcessGroupDTO;
import org.apache.nifi.web.api.dto.ProcessorDTO;
import org.apache.nifi.web.api.dto.RemoteProcessGroupDTO;

public final class FlowSnippetDTOBuilder {
  private Set<ConnectionDTO> connections;

  private Set<ControllerServiceDTO> controllerServices;

  private Set<FunnelDTO> funnels;

  private Set<PortDTO> inputPorts;

  private Set<LabelDTO> labels;

  private Set<PortDTO> outputPorts;

  private Set<ProcessGroupDTO> processGroups;

  private Set<ProcessorDTO> processors;

  private Set<RemoteProcessGroupDTO> remoteProcessGroups;

  /**
   * The connections in this flow snippet.
   */
  public Set<ConnectionDTO> getConnections() {
    return connections;
  }

  /**
   * The connections in this flow snippet.
   */
  public FlowSnippetDTOBuilder setConnections(final Set<ConnectionDTO> connections) {
    this.connections = connections;
    return this;
  }

  /**
   * The controller services in this flow snippet.
   */
  public Set<ControllerServiceDTO> getControllerServices() {
    return controllerServices;
  }

  /**
   * The controller services in this flow snippet.
   */
  public FlowSnippetDTOBuilder setControllerServices(
      final Set<ControllerServiceDTO> controllerServices) {
    this.controllerServices = controllerServices;
    return this;
  }

  /**
   * The funnels in this flow snippet.
   */
  public Set<FunnelDTO> getFunnels() {
    return funnels;
  }

  /**
   * The funnels in this flow snippet.
   */
  public FlowSnippetDTOBuilder setFunnels(final Set<FunnelDTO> funnels) {
    this.funnels = funnels;
    return this;
  }

  /**
   * The input ports in this flow snippet.
   */
  public Set<PortDTO> getInputPorts() {
    return inputPorts;
  }

  /**
   * The input ports in this flow snippet.
   */
  public FlowSnippetDTOBuilder setInputPorts(final Set<PortDTO> inputPorts) {
    this.inputPorts = inputPorts;
    return this;
  }

  /**
   * The labels in this flow snippet.
   */
  public Set<LabelDTO> getLabels() {
    return labels;
  }

  /**
   * The labels in this flow snippet.
   */
  public FlowSnippetDTOBuilder setLabels(final Set<LabelDTO> labels) {
    this.labels = labels;
    return this;
  }

  /**
   * The output ports in this flow snippet.
   */
  public Set<PortDTO> getOutputPorts() {
    return outputPorts;
  }

  /**
   * The output ports in this flow snippet.
   */
  public FlowSnippetDTOBuilder setOutputPorts(final Set<PortDTO> outputPorts) {
    this.outputPorts = outputPorts;
    return this;
  }

  /**
   * The process groups in this flow snippet.
   */
  public Set<ProcessGroupDTO> getProcessGroups() {
    return processGroups;
  }

  /**
   * The process groups in this flow snippet.
   */
  public FlowSnippetDTOBuilder setProcessGroups(final Set<ProcessGroupDTO> processGroups) {
    this.processGroups = processGroups;
    return this;
  }

  /**
   * The processors in this flow snippet.
   */
  public Set<ProcessorDTO> getProcessors() {
    return processors;
  }

  /**
   * The processors in this flow snippet.
   */
  public FlowSnippetDTOBuilder setProcessors(final Set<ProcessorDTO> processors) {
    this.processors = processors;
    return this;
  }

  /**
   * The remote process groups in this flow snippet.
   */
  public Set<RemoteProcessGroupDTO> getRemoteProcessGroups() {
    return remoteProcessGroups;
  }

  /**
   * The remote process groups in this flow snippet.
   */
  public FlowSnippetDTOBuilder setRemoteProcessGroups(
      final Set<RemoteProcessGroupDTO> remoteProcessGroups) {
    this.remoteProcessGroups = remoteProcessGroups;
    return this;
  }

  public FlowSnippetDTO build() {
    final FlowSnippetDTO flowSnippetDTO = new FlowSnippetDTO();
    flowSnippetDTO.setConnections(connections);
    flowSnippetDTO.setControllerServices(controllerServices);
    flowSnippetDTO.setFunnels(funnels);
    flowSnippetDTO.setInputPorts(inputPorts);
    flowSnippetDTO.setLabels(labels);
    flowSnippetDTO.setOutputPorts(outputPorts);
    flowSnippetDTO.setProcessGroups(processGroups);
    flowSnippetDTO.setProcessors(processors);
    flowSnippetDTO.setRemoteProcessGroups(remoteProcessGroups);
    return flowSnippetDTO;
  }

  public static FlowSnippetDTOBuilder of(final FlowSnippetDTO flowSnippetDTO) {
    final FlowSnippetDTOBuilder flowSnippetDTOBuilder = new FlowSnippetDTOBuilder();
    flowSnippetDTOBuilder.setConnections(flowSnippetDTO.getConnections());
    flowSnippetDTOBuilder.setControllerServices(flowSnippetDTO.getControllerServices());
    flowSnippetDTOBuilder.setFunnels(flowSnippetDTO.getFunnels());
    flowSnippetDTOBuilder.setInputPorts(flowSnippetDTO.getInputPorts());
    flowSnippetDTOBuilder.setLabels(flowSnippetDTO.getLabels());
    flowSnippetDTOBuilder.setOutputPorts(flowSnippetDTO.getOutputPorts());
    flowSnippetDTOBuilder.setProcessGroups(flowSnippetDTO.getProcessGroups());
    flowSnippetDTOBuilder.setProcessors(flowSnippetDTO.getProcessors());
    flowSnippetDTOBuilder.setRemoteProcessGroups(flowSnippetDTO.getRemoteProcessGroups());
    return flowSnippetDTOBuilder;
  }
}
