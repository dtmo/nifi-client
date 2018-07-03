package com.tibtech.nifi.web.api.dto.diagnostics;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Integer;
import java.lang.String;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.diagnostics.JVMDiagnosticsSnapshotDTO;
import org.apache.nifi.web.api.dto.diagnostics.NodeJVMDiagnosticsSnapshotDTO;

public final class NodeJVMDiagnosticsSnapshotDTOBuilder {
  private String address;

  private Integer apiPort;

  private String nodeId;

  private JVMDiagnosticsSnapshotDTO snapshot;

  /**
   * The API address of the node
   */
  public String getAddress() {
    return address;
  }

  /**
   * The API address of the node
   */
  public NodeJVMDiagnosticsSnapshotDTOBuilder setAddress(final String address) {
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
  public NodeJVMDiagnosticsSnapshotDTOBuilder setApiPort(final Integer apiPort) {
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
  public NodeJVMDiagnosticsSnapshotDTOBuilder setNodeId(final String nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /**
   * The JVM Diagnostics Snapshot
   */
  public JVMDiagnosticsSnapshotDTO getSnapshot() {
    return snapshot;
  }

  /**
   * The JVM Diagnostics Snapshot
   */
  public NodeJVMDiagnosticsSnapshotDTOBuilder setSnapshot(final JVMDiagnosticsSnapshotDTO snapshot) {
    this.snapshot = snapshot;
    return this;
  }

  /**
   * The JVM Diagnostics Snapshot
   */
  public NodeJVMDiagnosticsSnapshotDTOBuilder setSnapshot(final Consumer<JVMDiagnosticsSnapshotDTOBuilder> configurator) {
    final JVMDiagnosticsSnapshotDTOBuilder builder = (snapshot != null ? JVMDiagnosticsSnapshotDTOBuilder.of(snapshot) : new JVMDiagnosticsSnapshotDTOBuilder());
    configurator.accept(builder);
    return setSnapshot(builder.build());
  }

  /**
   * The JVM Diagnostics Snapshot
   */
  public NodeJVMDiagnosticsSnapshotDTOBuilder setSnapshot(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = JVMDiagnosticsSnapshotDTOBuilder.class) final Closure<JVMDiagnosticsSnapshotDTOBuilder> closure) {
    return setSnapshot(c -> {
      final Closure<JVMDiagnosticsSnapshotDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  public NodeJVMDiagnosticsSnapshotDTO build() {
    final NodeJVMDiagnosticsSnapshotDTO nodeJVMDiagnosticsSnapshotDTO = new NodeJVMDiagnosticsSnapshotDTO();
    nodeJVMDiagnosticsSnapshotDTO.setAddress(address);
    nodeJVMDiagnosticsSnapshotDTO.setApiPort(apiPort);
    nodeJVMDiagnosticsSnapshotDTO.setNodeId(nodeId);
    nodeJVMDiagnosticsSnapshotDTO.setSnapshot(snapshot);
    return nodeJVMDiagnosticsSnapshotDTO;
  }

  public static NodeJVMDiagnosticsSnapshotDTOBuilder of(final NodeJVMDiagnosticsSnapshotDTO nodeJVMDiagnosticsSnapshotDTO) {
    final NodeJVMDiagnosticsSnapshotDTOBuilder nodeJVMDiagnosticsSnapshotDTOBuilder = new NodeJVMDiagnosticsSnapshotDTOBuilder();
    nodeJVMDiagnosticsSnapshotDTOBuilder.setAddress(nodeJVMDiagnosticsSnapshotDTO.getAddress());
    nodeJVMDiagnosticsSnapshotDTOBuilder.setApiPort(nodeJVMDiagnosticsSnapshotDTO.getApiPort());
    nodeJVMDiagnosticsSnapshotDTOBuilder.setNodeId(nodeJVMDiagnosticsSnapshotDTO.getNodeId());
    nodeJVMDiagnosticsSnapshotDTOBuilder.setSnapshot(nodeJVMDiagnosticsSnapshotDTO.getSnapshot());
    return nodeJVMDiagnosticsSnapshotDTOBuilder;
  }
}
