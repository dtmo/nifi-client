package com.tibtech.nifi.web.api.dto.status;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Integer;
import java.lang.String;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.status.ConnectionStatusSnapshotDTO;
import org.apache.nifi.web.api.dto.status.NodeConnectionStatusSnapshotDTO;

public final class NodeConnectionStatusSnapshotDTOBuilder {
  private String address;

  private Integer apiPort;

  private String nodeId;

  private ConnectionStatusSnapshotDTO statusSnapshot;

  /**
   * The API address of the node
   */
  public String getAddress() {
    return address;
  }

  /**
   * The API address of the node
   */
  public NodeConnectionStatusSnapshotDTOBuilder setAddress(final String address) {
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
  public NodeConnectionStatusSnapshotDTOBuilder setApiPort(final Integer apiPort) {
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
  public NodeConnectionStatusSnapshotDTOBuilder setNodeId(final String nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /**
   * The connection status snapshot from the node.
   */
  public ConnectionStatusSnapshotDTO getStatusSnapshot() {
    return statusSnapshot;
  }

  /**
   * The connection status snapshot from the node.
   */
  public NodeConnectionStatusSnapshotDTOBuilder setStatusSnapshot(final ConnectionStatusSnapshotDTO statusSnapshot) {
    this.statusSnapshot = statusSnapshot;
    return this;
  }

  /**
   * The connection status snapshot from the node.
   */
  public NodeConnectionStatusSnapshotDTOBuilder setStatusSnapshot(final Consumer<ConnectionStatusSnapshotDTOBuilder> configurator) {
    final ConnectionStatusSnapshotDTOBuilder builder = (statusSnapshot != null ? ConnectionStatusSnapshotDTOBuilder.of(statusSnapshot) : new ConnectionStatusSnapshotDTOBuilder());
    configurator.accept(builder);
    return setStatusSnapshot(builder.build());
  }

  /**
   * The connection status snapshot from the node.
   */
  public NodeConnectionStatusSnapshotDTOBuilder setStatusSnapshot(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConnectionStatusSnapshotDTOBuilder.class) final Closure<ConnectionStatusSnapshotDTOBuilder> closure) {
    return setStatusSnapshot(c -> {
      final Closure<ConnectionStatusSnapshotDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  public NodeConnectionStatusSnapshotDTO build() {
    final NodeConnectionStatusSnapshotDTO nodeConnectionStatusSnapshotDTO = new NodeConnectionStatusSnapshotDTO();
    nodeConnectionStatusSnapshotDTO.setAddress(address);
    nodeConnectionStatusSnapshotDTO.setApiPort(apiPort);
    nodeConnectionStatusSnapshotDTO.setNodeId(nodeId);
    nodeConnectionStatusSnapshotDTO.setStatusSnapshot(statusSnapshot);
    return nodeConnectionStatusSnapshotDTO;
  }

  public static NodeConnectionStatusSnapshotDTOBuilder of(final NodeConnectionStatusSnapshotDTO nodeConnectionStatusSnapshotDTO) {
    final NodeConnectionStatusSnapshotDTOBuilder nodeConnectionStatusSnapshotDTOBuilder = new NodeConnectionStatusSnapshotDTOBuilder();
    nodeConnectionStatusSnapshotDTOBuilder.setAddress(nodeConnectionStatusSnapshotDTO.getAddress());
    nodeConnectionStatusSnapshotDTOBuilder.setApiPort(nodeConnectionStatusSnapshotDTO.getApiPort());
    nodeConnectionStatusSnapshotDTOBuilder.setNodeId(nodeConnectionStatusSnapshotDTO.getNodeId());
    nodeConnectionStatusSnapshotDTOBuilder.setStatusSnapshot(nodeConnectionStatusSnapshotDTO.getStatusSnapshot());
    return nodeConnectionStatusSnapshotDTOBuilder;
  }
}
