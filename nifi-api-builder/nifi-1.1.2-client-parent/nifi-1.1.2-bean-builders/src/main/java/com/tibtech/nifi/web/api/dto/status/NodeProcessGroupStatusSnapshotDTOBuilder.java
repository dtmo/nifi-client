package com.tibtech.nifi.web.api.dto.status;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Integer;
import java.lang.String;
import java.util.function.Function;
import org.apache.nifi.web.api.dto.status.NodeProcessGroupStatusSnapshotDTO;
import org.apache.nifi.web.api.dto.status.ProcessGroupStatusSnapshotDTO;

public final class NodeProcessGroupStatusSnapshotDTOBuilder {
  private String address;

  private Integer apiPort;

  private String nodeId;

  private ProcessGroupStatusSnapshotDTO statusSnapshot;

  /**
   * The API address of the node
   */
  public String getAddress() {
    return address;
  }

  /**
   * The API address of the node
   */
  public NodeProcessGroupStatusSnapshotDTOBuilder setAddress(final String address) {
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
  public NodeProcessGroupStatusSnapshotDTOBuilder setApiPort(final Integer apiPort) {
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
  public NodeProcessGroupStatusSnapshotDTOBuilder setNodeId(final String nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /**
   * The process group status snapshot from the node.
   */
  public ProcessGroupStatusSnapshotDTO getStatusSnapshot() {
    return statusSnapshot;
  }

  /**
   * The process group status snapshot from the node.
   */
  public NodeProcessGroupStatusSnapshotDTOBuilder setStatusSnapshot(final ProcessGroupStatusSnapshotDTO statusSnapshot) {
    this.statusSnapshot = statusSnapshot;
    return this;
  }

  /**
   * The process group status snapshot from the node.
   */
  public NodeProcessGroupStatusSnapshotDTOBuilder setStatusSnapshot(final Function<ProcessGroupStatusSnapshotDTOBuilder, ProcessGroupStatusSnapshotDTOBuilder> configurator) {
    return setStatusSnapshot(configurator.apply(statusSnapshot != null ? ProcessGroupStatusSnapshotDTOBuilder.of(statusSnapshot) : new ProcessGroupStatusSnapshotDTOBuilder()).build());
  }

  /**
   * The process group status snapshot from the node.
   */
  public NodeProcessGroupStatusSnapshotDTOBuilder setStatusSnapshot(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessGroupStatusSnapshotDTOBuilder.class) final Closure<ProcessGroupStatusSnapshotDTOBuilder> closure) {
    return setStatusSnapshot(c -> {
      final Closure<ProcessGroupStatusSnapshotDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public NodeProcessGroupStatusSnapshotDTO build() {
    final NodeProcessGroupStatusSnapshotDTO nodeProcessGroupStatusSnapshotDTO = new NodeProcessGroupStatusSnapshotDTO();
    nodeProcessGroupStatusSnapshotDTO.setAddress(address);
    nodeProcessGroupStatusSnapshotDTO.setApiPort(apiPort);
    nodeProcessGroupStatusSnapshotDTO.setNodeId(nodeId);
    nodeProcessGroupStatusSnapshotDTO.setStatusSnapshot(statusSnapshot);
    return nodeProcessGroupStatusSnapshotDTO;
  }

  public static NodeProcessGroupStatusSnapshotDTOBuilder of(final NodeProcessGroupStatusSnapshotDTO nodeProcessGroupStatusSnapshotDTO) {
    final NodeProcessGroupStatusSnapshotDTOBuilder nodeProcessGroupStatusSnapshotDTOBuilder = new NodeProcessGroupStatusSnapshotDTOBuilder();
    nodeProcessGroupStatusSnapshotDTOBuilder.setAddress(nodeProcessGroupStatusSnapshotDTO.getAddress());
    nodeProcessGroupStatusSnapshotDTOBuilder.setApiPort(nodeProcessGroupStatusSnapshotDTO.getApiPort());
    nodeProcessGroupStatusSnapshotDTOBuilder.setNodeId(nodeProcessGroupStatusSnapshotDTO.getNodeId());
    nodeProcessGroupStatusSnapshotDTOBuilder.setStatusSnapshot(nodeProcessGroupStatusSnapshotDTO.getStatusSnapshot());
    return nodeProcessGroupStatusSnapshotDTOBuilder;
  }
}
