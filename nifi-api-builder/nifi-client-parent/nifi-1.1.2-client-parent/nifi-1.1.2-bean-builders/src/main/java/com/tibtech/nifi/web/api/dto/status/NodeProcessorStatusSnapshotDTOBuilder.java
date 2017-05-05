package com.tibtech.nifi.web.api.dto.status;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Integer;
import java.lang.String;
import java.util.function.Function;
import org.apache.nifi.web.api.dto.status.NodeProcessorStatusSnapshotDTO;
import org.apache.nifi.web.api.dto.status.ProcessorStatusSnapshotDTO;

public final class NodeProcessorStatusSnapshotDTOBuilder {
  private String address;

  private Integer apiPort;

  private String nodeId;

  private ProcessorStatusSnapshotDTO statusSnapshot;

  /**
   * The API address of the node
   */
  public String getAddress() {
    return address;
  }

  /**
   * The API address of the node
   */
  public NodeProcessorStatusSnapshotDTOBuilder setAddress(final String address) {
    this.address = address;
    return this;
  }

  /**
   * The API port used to communicate with the node
   */
  public Integer getApiPort() {
    return apiPort;
  }

  /**
   * The API port used to communicate with the node
   */
  public NodeProcessorStatusSnapshotDTOBuilder setApiPort(final Integer apiPort) {
    this.apiPort = apiPort;
    return this;
  }

  /**
   * The unique ID that identifies the node
   */
  public String getNodeId() {
    return nodeId;
  }

  /**
   * The unique ID that identifies the node
   */
  public NodeProcessorStatusSnapshotDTOBuilder setNodeId(final String nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /**
   * The processor status snapshot from the node.
   */
  public ProcessorStatusSnapshotDTO getStatusSnapshot() {
    return statusSnapshot;
  }

  /**
   * The processor status snapshot from the node.
   */
  public NodeProcessorStatusSnapshotDTOBuilder setStatusSnapshot(final ProcessorStatusSnapshotDTO statusSnapshot) {
    this.statusSnapshot = statusSnapshot;
    return this;
  }

  /**
   * The processor status snapshot from the node.
   */
  public NodeProcessorStatusSnapshotDTOBuilder setStatusSnapshot(final Function<ProcessorStatusSnapshotDTOBuilder, ProcessorStatusSnapshotDTOBuilder> configurator) {
    return setStatusSnapshot(configurator.apply(statusSnapshot != null ? ProcessorStatusSnapshotDTOBuilder.of(statusSnapshot) : new ProcessorStatusSnapshotDTOBuilder()).build());
  }

  /**
   * The processor status snapshot from the node.
   */
  public NodeProcessorStatusSnapshotDTOBuilder setStatusSnapshot(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessorStatusSnapshotDTOBuilder.class) final Closure<ProcessorStatusSnapshotDTOBuilder> closure) {
    return setStatusSnapshot(c -> {
      final Closure<ProcessorStatusSnapshotDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public NodeProcessorStatusSnapshotDTO build() {
    final NodeProcessorStatusSnapshotDTO nodeProcessorStatusSnapshotDTO = new NodeProcessorStatusSnapshotDTO();
    nodeProcessorStatusSnapshotDTO.setAddress(address);
    nodeProcessorStatusSnapshotDTO.setApiPort(apiPort);
    nodeProcessorStatusSnapshotDTO.setNodeId(nodeId);
    nodeProcessorStatusSnapshotDTO.setStatusSnapshot(statusSnapshot);
    return nodeProcessorStatusSnapshotDTO;
  }

  public static NodeProcessorStatusSnapshotDTOBuilder of(final NodeProcessorStatusSnapshotDTO nodeProcessorStatusSnapshotDTO) {
    final NodeProcessorStatusSnapshotDTOBuilder nodeProcessorStatusSnapshotDTOBuilder = new NodeProcessorStatusSnapshotDTOBuilder();
    nodeProcessorStatusSnapshotDTOBuilder.setAddress(nodeProcessorStatusSnapshotDTO.getAddress());
    nodeProcessorStatusSnapshotDTOBuilder.setApiPort(nodeProcessorStatusSnapshotDTO.getApiPort());
    nodeProcessorStatusSnapshotDTOBuilder.setNodeId(nodeProcessorStatusSnapshotDTO.getNodeId());
    nodeProcessorStatusSnapshotDTOBuilder.setStatusSnapshot(nodeProcessorStatusSnapshotDTO.getStatusSnapshot());
    return nodeProcessorStatusSnapshotDTOBuilder;
  }
}
