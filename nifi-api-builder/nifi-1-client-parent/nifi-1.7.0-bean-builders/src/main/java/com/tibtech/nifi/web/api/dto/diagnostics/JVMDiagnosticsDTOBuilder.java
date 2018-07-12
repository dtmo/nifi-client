package com.tibtech.nifi.web.api.dto.diagnostics;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Boolean;
import java.util.List;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.diagnostics.JVMDiagnosticsDTO;
import org.apache.nifi.web.api.dto.diagnostics.JVMDiagnosticsSnapshotDTO;
import org.apache.nifi.web.api.dto.diagnostics.NodeJVMDiagnosticsSnapshotDTO;

public final class JVMDiagnosticsDTOBuilder {
  private JVMDiagnosticsSnapshotDTO aggregateSnapshot;

  private Boolean clustered;

  private Boolean connected;

  private List<NodeJVMDiagnosticsSnapshotDTO> nodeSnapshots;

  /**
   * Aggregate JVM diagnostic information about the entire cluster
   */
  public JVMDiagnosticsSnapshotDTO getAggregateSnapshot() {
    return aggregateSnapshot;
  }

  /**
   * Aggregate JVM diagnostic information about the entire cluster
   */
  public JVMDiagnosticsDTOBuilder setAggregateSnapshot(
      final JVMDiagnosticsSnapshotDTO aggregateSnapshot) {
    this.aggregateSnapshot = aggregateSnapshot;
    return this;
  }

  /**
   * Aggregate JVM diagnostic information about the entire cluster
   */
  public JVMDiagnosticsDTOBuilder setAggregateSnapshot(
      final Consumer<JVMDiagnosticsSnapshotDTOBuilder> configurator) {
    final JVMDiagnosticsSnapshotDTOBuilder builder = (aggregateSnapshot != null ? JVMDiagnosticsSnapshotDTOBuilder.of(aggregateSnapshot) : new JVMDiagnosticsSnapshotDTOBuilder());
    configurator.accept(builder);
    return setAggregateSnapshot(builder.build());
  }

  /**
   * Aggregate JVM diagnostic information about the entire cluster
   */
  public JVMDiagnosticsDTOBuilder setAggregateSnapshot(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = JVMDiagnosticsSnapshotDTOBuilder.class) final Closure<JVMDiagnosticsSnapshotDTOBuilder> closure) {
    return setAggregateSnapshot(c -> {
      final Closure<JVMDiagnosticsSnapshotDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * Whether or not the NiFi instance is clustered
   */
  public Boolean getClustered() {
    return clustered;
  }

  /**
   * Whether or not the NiFi instance is clustered
   */
  public JVMDiagnosticsDTOBuilder setClustered(final Boolean clustered) {
    this.clustered = clustered;
    return this;
  }

  /**
   * Whether or not the node is connected to the cluster
   */
  public Boolean getConnected() {
    return connected;
  }

  /**
   * Whether or not the node is connected to the cluster
   */
  public JVMDiagnosticsDTOBuilder setConnected(final Boolean connected) {
    this.connected = connected;
    return this;
  }

  /**
   * Node-wise breakdown of JVM diagnostic information
   */
  public List<NodeJVMDiagnosticsSnapshotDTO> getNodeSnapshots() {
    return nodeSnapshots;
  }

  /**
   * Node-wise breakdown of JVM diagnostic information
   */
  public JVMDiagnosticsDTOBuilder setNodeSnapshots(
      final List<NodeJVMDiagnosticsSnapshotDTO> nodeSnapshots) {
    this.nodeSnapshots = nodeSnapshots;
    return this;
  }

  public JVMDiagnosticsDTO build() {
    final JVMDiagnosticsDTO jVMDiagnosticsDTO = new JVMDiagnosticsDTO();
    jVMDiagnosticsDTO.setAggregateSnapshot(aggregateSnapshot);
    jVMDiagnosticsDTO.setClustered(clustered);
    jVMDiagnosticsDTO.setConnected(connected);
    jVMDiagnosticsDTO.setNodeSnapshots(nodeSnapshots);
    return jVMDiagnosticsDTO;
  }

  public static JVMDiagnosticsDTOBuilder of(final JVMDiagnosticsDTO jVMDiagnosticsDTO) {
    final JVMDiagnosticsDTOBuilder jVMDiagnosticsDTOBuilder = new JVMDiagnosticsDTOBuilder();
    jVMDiagnosticsDTOBuilder.setAggregateSnapshot(jVMDiagnosticsDTO.getAggregateSnapshot());
    jVMDiagnosticsDTOBuilder.setClustered(jVMDiagnosticsDTO.getClustered());
    jVMDiagnosticsDTOBuilder.setConnected(jVMDiagnosticsDTO.getConnected());
    jVMDiagnosticsDTOBuilder.setNodeSnapshots(jVMDiagnosticsDTO.getNodeSnapshots());
    return jVMDiagnosticsDTOBuilder;
  }
}
