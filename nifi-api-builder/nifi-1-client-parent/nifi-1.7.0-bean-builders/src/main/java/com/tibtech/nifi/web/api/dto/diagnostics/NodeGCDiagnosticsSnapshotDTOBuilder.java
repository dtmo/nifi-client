package com.tibtech.nifi.web.api.dto.diagnostics;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Integer;
import java.lang.String;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.diagnostics.GCDiagnosticsSnapshotDTO;
import org.apache.nifi.web.api.dto.diagnostics.NodeGCDiagnosticsSnapshotDTO;

public final class NodeGCDiagnosticsSnapshotDTOBuilder {
  private String address;

  private Integer apiPort;

  private String nodeId;

  private GCDiagnosticsSnapshotDTO snapshot;

  /**
   * The API address of the node
   */
  public String getAddress() {
    return address;
  }

  /**
   * The API address of the node
   */
  public NodeGCDiagnosticsSnapshotDTOBuilder setAddress(final String address) {
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
  public NodeGCDiagnosticsSnapshotDTOBuilder setApiPort(final Integer apiPort) {
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
  public NodeGCDiagnosticsSnapshotDTOBuilder setNodeId(final String nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /**
   * The Garbage Collection Diagnostics Snapshot
   */
  public GCDiagnosticsSnapshotDTO getSnapshot() {
    return snapshot;
  }

  /**
   * The Garbage Collection Diagnostics Snapshot
   */
  public NodeGCDiagnosticsSnapshotDTOBuilder setSnapshot(final GCDiagnosticsSnapshotDTO snapshot) {
    this.snapshot = snapshot;
    return this;
  }

  /**
   * The Garbage Collection Diagnostics Snapshot
   */
  public NodeGCDiagnosticsSnapshotDTOBuilder setSnapshot(
      final Consumer<GCDiagnosticsSnapshotDTOBuilder> configurator) {
    final GCDiagnosticsSnapshotDTOBuilder builder = (snapshot != null ? GCDiagnosticsSnapshotDTOBuilder.of(snapshot) : new GCDiagnosticsSnapshotDTOBuilder());
    configurator.accept(builder);
    return setSnapshot(builder.build());
  }

  /**
   * The Garbage Collection Diagnostics Snapshot
   */
  public NodeGCDiagnosticsSnapshotDTOBuilder setSnapshot(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GCDiagnosticsSnapshotDTOBuilder.class) final Closure<GCDiagnosticsSnapshotDTOBuilder> closure) {
    return setSnapshot(c -> {
      final Closure<GCDiagnosticsSnapshotDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  public NodeGCDiagnosticsSnapshotDTO build() {
    final NodeGCDiagnosticsSnapshotDTO nodeGCDiagnosticsSnapshotDTO = new NodeGCDiagnosticsSnapshotDTO();
    nodeGCDiagnosticsSnapshotDTO.setAddress(address);
    nodeGCDiagnosticsSnapshotDTO.setApiPort(apiPort);
    nodeGCDiagnosticsSnapshotDTO.setNodeId(nodeId);
    nodeGCDiagnosticsSnapshotDTO.setSnapshot(snapshot);
    return nodeGCDiagnosticsSnapshotDTO;
  }

  public static NodeGCDiagnosticsSnapshotDTOBuilder of(
      final NodeGCDiagnosticsSnapshotDTO nodeGCDiagnosticsSnapshotDTO) {
    final NodeGCDiagnosticsSnapshotDTOBuilder nodeGCDiagnosticsSnapshotDTOBuilder = new NodeGCDiagnosticsSnapshotDTOBuilder();
    nodeGCDiagnosticsSnapshotDTOBuilder.setAddress(nodeGCDiagnosticsSnapshotDTO.getAddress());
    nodeGCDiagnosticsSnapshotDTOBuilder.setApiPort(nodeGCDiagnosticsSnapshotDTO.getApiPort());
    nodeGCDiagnosticsSnapshotDTOBuilder.setNodeId(nodeGCDiagnosticsSnapshotDTO.getNodeId());
    nodeGCDiagnosticsSnapshotDTOBuilder.setSnapshot(nodeGCDiagnosticsSnapshotDTO.getSnapshot());
    return nodeGCDiagnosticsSnapshotDTOBuilder;
  }
}
