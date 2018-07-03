package com.tibtech.nifi.web.api.dto;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Integer;
import java.lang.String;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.NodeSystemDiagnosticsSnapshotDTO;
import org.apache.nifi.web.api.dto.SystemDiagnosticsSnapshotDTO;

public final class NodeSystemDiagnosticsSnapshotDTOBuilder {
  private String address;

  private Integer apiPort;

  private String nodeId;

  private SystemDiagnosticsSnapshotDTO snapshot;

  /**
   * The API address of the node
   */
  public String getAddress() {
    return address;
  }

  /**
   * The API address of the node
   */
  public NodeSystemDiagnosticsSnapshotDTOBuilder setAddress(final String address) {
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
  public NodeSystemDiagnosticsSnapshotDTOBuilder setApiPort(final Integer apiPort) {
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
  public NodeSystemDiagnosticsSnapshotDTOBuilder setNodeId(final String nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /**
   * The System Diagnostics snapshot from the node.
   */
  public SystemDiagnosticsSnapshotDTO getSnapshot() {
    return snapshot;
  }

  /**
   * The System Diagnostics snapshot from the node.
   */
  public NodeSystemDiagnosticsSnapshotDTOBuilder setSnapshot(final SystemDiagnosticsSnapshotDTO snapshot) {
    this.snapshot = snapshot;
    return this;
  }

  /**
   * The System Diagnostics snapshot from the node.
   */
  public NodeSystemDiagnosticsSnapshotDTOBuilder setSnapshot(final Consumer<SystemDiagnosticsSnapshotDTOBuilder> configurator) {
    final SystemDiagnosticsSnapshotDTOBuilder builder = (snapshot != null ? SystemDiagnosticsSnapshotDTOBuilder.of(snapshot) : new SystemDiagnosticsSnapshotDTOBuilder());
    configurator.accept(builder);
    return setSnapshot(builder.build());
  }

  /**
   * The System Diagnostics snapshot from the node.
   */
  public NodeSystemDiagnosticsSnapshotDTOBuilder setSnapshot(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SystemDiagnosticsSnapshotDTOBuilder.class) final Closure<SystemDiagnosticsSnapshotDTOBuilder> closure) {
    return setSnapshot(c -> {
      final Closure<SystemDiagnosticsSnapshotDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  public NodeSystemDiagnosticsSnapshotDTO build() {
    final NodeSystemDiagnosticsSnapshotDTO nodeSystemDiagnosticsSnapshotDTO = new NodeSystemDiagnosticsSnapshotDTO();
    nodeSystemDiagnosticsSnapshotDTO.setAddress(address);
    nodeSystemDiagnosticsSnapshotDTO.setApiPort(apiPort);
    nodeSystemDiagnosticsSnapshotDTO.setNodeId(nodeId);
    nodeSystemDiagnosticsSnapshotDTO.setSnapshot(snapshot);
    return nodeSystemDiagnosticsSnapshotDTO;
  }

  public static NodeSystemDiagnosticsSnapshotDTOBuilder of(final NodeSystemDiagnosticsSnapshotDTO nodeSystemDiagnosticsSnapshotDTO) {
    final NodeSystemDiagnosticsSnapshotDTOBuilder nodeSystemDiagnosticsSnapshotDTOBuilder = new NodeSystemDiagnosticsSnapshotDTOBuilder();
    nodeSystemDiagnosticsSnapshotDTOBuilder.setAddress(nodeSystemDiagnosticsSnapshotDTO.getAddress());
    nodeSystemDiagnosticsSnapshotDTOBuilder.setApiPort(nodeSystemDiagnosticsSnapshotDTO.getApiPort());
    nodeSystemDiagnosticsSnapshotDTOBuilder.setNodeId(nodeSystemDiagnosticsSnapshotDTO.getNodeId());
    nodeSystemDiagnosticsSnapshotDTOBuilder.setSnapshot(nodeSystemDiagnosticsSnapshotDTO.getSnapshot());
    return nodeSystemDiagnosticsSnapshotDTOBuilder;
  }
}
