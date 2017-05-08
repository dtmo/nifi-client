package com.tibtech.nifi.web.api.dto.status;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Integer;
import java.lang.String;
import java.util.function.Function;
import org.apache.nifi.web.api.dto.status.NodeRemoteProcessGroupStatusSnapshotDTO;
import org.apache.nifi.web.api.dto.status.RemoteProcessGroupStatusSnapshotDTO;

public final class NodeRemoteProcessGroupStatusSnapshotDTOBuilder {
  private String address;

  private Integer apiPort;

  private String nodeId;

  private RemoteProcessGroupStatusSnapshotDTO statusSnapshot;

  /**
   * The API address of the node
   */
  public String getAddress() {
    return address;
  }

  /**
   * The API address of the node
   */
  public NodeRemoteProcessGroupStatusSnapshotDTOBuilder setAddress(final String address) {
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
  public NodeRemoteProcessGroupStatusSnapshotDTOBuilder setApiPort(final Integer apiPort) {
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
  public NodeRemoteProcessGroupStatusSnapshotDTOBuilder setNodeId(final String nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /**
   * The remote process group status snapshot from the node.
   */
  public RemoteProcessGroupStatusSnapshotDTO getStatusSnapshot() {
    return statusSnapshot;
  }

  /**
   * The remote process group status snapshot from the node.
   */
  public NodeRemoteProcessGroupStatusSnapshotDTOBuilder setStatusSnapshot(final RemoteProcessGroupStatusSnapshotDTO statusSnapshot) {
    this.statusSnapshot = statusSnapshot;
    return this;
  }

  /**
   * The remote process group status snapshot from the node.
   */
  public NodeRemoteProcessGroupStatusSnapshotDTOBuilder setStatusSnapshot(final Function<RemoteProcessGroupStatusSnapshotDTOBuilder, RemoteProcessGroupStatusSnapshotDTOBuilder> configurator) {
    return setStatusSnapshot(configurator.apply(statusSnapshot != null ? RemoteProcessGroupStatusSnapshotDTOBuilder.of(statusSnapshot) : new RemoteProcessGroupStatusSnapshotDTOBuilder()).build());
  }

  /**
   * The remote process group status snapshot from the node.
   */
  public NodeRemoteProcessGroupStatusSnapshotDTOBuilder setStatusSnapshot(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = RemoteProcessGroupStatusSnapshotDTOBuilder.class) final Closure<RemoteProcessGroupStatusSnapshotDTOBuilder> closure) {
    return setStatusSnapshot(c -> {
      final Closure<RemoteProcessGroupStatusSnapshotDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public NodeRemoteProcessGroupStatusSnapshotDTO build() {
    final NodeRemoteProcessGroupStatusSnapshotDTO nodeRemoteProcessGroupStatusSnapshotDTO = new NodeRemoteProcessGroupStatusSnapshotDTO();
    nodeRemoteProcessGroupStatusSnapshotDTO.setAddress(address);
    nodeRemoteProcessGroupStatusSnapshotDTO.setApiPort(apiPort);
    nodeRemoteProcessGroupStatusSnapshotDTO.setNodeId(nodeId);
    nodeRemoteProcessGroupStatusSnapshotDTO.setStatusSnapshot(statusSnapshot);
    return nodeRemoteProcessGroupStatusSnapshotDTO;
  }

  public static NodeRemoteProcessGroupStatusSnapshotDTOBuilder of(final NodeRemoteProcessGroupStatusSnapshotDTO nodeRemoteProcessGroupStatusSnapshotDTO) {
    final NodeRemoteProcessGroupStatusSnapshotDTOBuilder nodeRemoteProcessGroupStatusSnapshotDTOBuilder = new NodeRemoteProcessGroupStatusSnapshotDTOBuilder();
    nodeRemoteProcessGroupStatusSnapshotDTOBuilder.setAddress(nodeRemoteProcessGroupStatusSnapshotDTO.getAddress());
    nodeRemoteProcessGroupStatusSnapshotDTOBuilder.setApiPort(nodeRemoteProcessGroupStatusSnapshotDTO.getApiPort());
    nodeRemoteProcessGroupStatusSnapshotDTOBuilder.setNodeId(nodeRemoteProcessGroupStatusSnapshotDTO.getNodeId());
    nodeRemoteProcessGroupStatusSnapshotDTOBuilder.setStatusSnapshot(nodeRemoteProcessGroupStatusSnapshotDTO.getStatusSnapshot());
    return nodeRemoteProcessGroupStatusSnapshotDTOBuilder;
  }
}
