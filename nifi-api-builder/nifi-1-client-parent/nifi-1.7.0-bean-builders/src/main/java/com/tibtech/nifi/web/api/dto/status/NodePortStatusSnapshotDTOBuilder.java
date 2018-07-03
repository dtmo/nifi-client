package com.tibtech.nifi.web.api.dto.status;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Integer;
import java.lang.String;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.status.NodePortStatusSnapshotDTO;
import org.apache.nifi.web.api.dto.status.PortStatusSnapshotDTO;

public final class NodePortStatusSnapshotDTOBuilder {
  private String address;

  private Integer apiPort;

  private String nodeId;

  private PortStatusSnapshotDTO statusSnapshot;

  /**
   * The API address of the node
   */
  public String getAddress() {
    return address;
  }

  /**
   * The API address of the node
   */
  public NodePortStatusSnapshotDTOBuilder setAddress(final String address) {
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
  public NodePortStatusSnapshotDTOBuilder setApiPort(final Integer apiPort) {
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
  public NodePortStatusSnapshotDTOBuilder setNodeId(final String nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /**
   * The port status snapshot from the node.
   */
  public PortStatusSnapshotDTO getStatusSnapshot() {
    return statusSnapshot;
  }

  /**
   * The port status snapshot from the node.
   */
  public NodePortStatusSnapshotDTOBuilder setStatusSnapshot(final PortStatusSnapshotDTO statusSnapshot) {
    this.statusSnapshot = statusSnapshot;
    return this;
  }

  /**
   * The port status snapshot from the node.
   */
  public NodePortStatusSnapshotDTOBuilder setStatusSnapshot(final Consumer<PortStatusSnapshotDTOBuilder> configurator) {
    final PortStatusSnapshotDTOBuilder builder = (statusSnapshot != null ? PortStatusSnapshotDTOBuilder.of(statusSnapshot) : new PortStatusSnapshotDTOBuilder());
    configurator.accept(builder);
    return setStatusSnapshot(builder.build());
  }

  /**
   * The port status snapshot from the node.
   */
  public NodePortStatusSnapshotDTOBuilder setStatusSnapshot(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PortStatusSnapshotDTOBuilder.class) final Closure<PortStatusSnapshotDTOBuilder> closure) {
    return setStatusSnapshot(c -> {
      final Closure<PortStatusSnapshotDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  public NodePortStatusSnapshotDTO build() {
    final NodePortStatusSnapshotDTO nodePortStatusSnapshotDTO = new NodePortStatusSnapshotDTO();
    nodePortStatusSnapshotDTO.setAddress(address);
    nodePortStatusSnapshotDTO.setApiPort(apiPort);
    nodePortStatusSnapshotDTO.setNodeId(nodeId);
    nodePortStatusSnapshotDTO.setStatusSnapshot(statusSnapshot);
    return nodePortStatusSnapshotDTO;
  }

  public static NodePortStatusSnapshotDTOBuilder of(final NodePortStatusSnapshotDTO nodePortStatusSnapshotDTO) {
    final NodePortStatusSnapshotDTOBuilder nodePortStatusSnapshotDTOBuilder = new NodePortStatusSnapshotDTOBuilder();
    nodePortStatusSnapshotDTOBuilder.setAddress(nodePortStatusSnapshotDTO.getAddress());
    nodePortStatusSnapshotDTOBuilder.setApiPort(nodePortStatusSnapshotDTO.getApiPort());
    nodePortStatusSnapshotDTOBuilder.setNodeId(nodePortStatusSnapshotDTO.getNodeId());
    nodePortStatusSnapshotDTOBuilder.setStatusSnapshot(nodePortStatusSnapshotDTO.getStatusSnapshot());
    return nodePortStatusSnapshotDTOBuilder;
  }
}
