package com.tibtech.nifi.web.api.dto;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.util.List;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.NodeSystemDiagnosticsSnapshotDTO;
import org.apache.nifi.web.api.dto.SystemDiagnosticsDTO;
import org.apache.nifi.web.api.dto.SystemDiagnosticsSnapshotDTO;

public final class SystemDiagnosticsDTOBuilder {
  private SystemDiagnosticsSnapshotDTO aggregateSnapshot;

  private List<NodeSystemDiagnosticsSnapshotDTO> nodeSnapshots;

  /**
   * A systems diagnostic snapshot that represents the aggregate values of all nodes in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this represents the stats of the single instance.
   */
  public SystemDiagnosticsSnapshotDTO getAggregateSnapshot() {
    return aggregateSnapshot;
  }

  /**
   * A systems diagnostic snapshot that represents the aggregate values of all nodes in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this represents the stats of the single instance.
   */
  public SystemDiagnosticsDTOBuilder setAggregateSnapshot(
      final SystemDiagnosticsSnapshotDTO aggregateSnapshot) {
    this.aggregateSnapshot = aggregateSnapshot;
    return this;
  }

  /**
   * A systems diagnostic snapshot that represents the aggregate values of all nodes in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this represents the stats of the single instance.
   */
  public SystemDiagnosticsDTOBuilder setAggregateSnapshot(
      final Consumer<SystemDiagnosticsSnapshotDTOBuilder> configurator) {
    final SystemDiagnosticsSnapshotDTOBuilder builder = (aggregateSnapshot != null ? SystemDiagnosticsSnapshotDTOBuilder.of(aggregateSnapshot) : new SystemDiagnosticsSnapshotDTOBuilder());
    configurator.accept(builder);
    return setAggregateSnapshot(builder.build());
  }

  /**
   * A systems diagnostic snapshot that represents the aggregate values of all nodes in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this represents the stats of the single instance.
   */
  public SystemDiagnosticsDTOBuilder setAggregateSnapshot(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SystemDiagnosticsSnapshotDTOBuilder.class) final Closure<SystemDiagnosticsSnapshotDTOBuilder> closure) {
    return setAggregateSnapshot(c -> {
      final Closure<SystemDiagnosticsSnapshotDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * A systems diagnostics snapshot for each node in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this may be null.
   */
  public List<NodeSystemDiagnosticsSnapshotDTO> getNodeSnapshots() {
    return nodeSnapshots;
  }

  /**
   * A systems diagnostics snapshot for each node in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this may be null.
   */
  public SystemDiagnosticsDTOBuilder setNodeSnapshots(
      final List<NodeSystemDiagnosticsSnapshotDTO> nodeSnapshots) {
    this.nodeSnapshots = nodeSnapshots;
    return this;
  }

  public SystemDiagnosticsDTO build() {
    final SystemDiagnosticsDTO systemDiagnosticsDTO = new SystemDiagnosticsDTO();
    systemDiagnosticsDTO.setAggregateSnapshot(aggregateSnapshot);
    systemDiagnosticsDTO.setNodeSnapshots(nodeSnapshots);
    return systemDiagnosticsDTO;
  }

  public static SystemDiagnosticsDTOBuilder of(final SystemDiagnosticsDTO systemDiagnosticsDTO) {
    final SystemDiagnosticsDTOBuilder systemDiagnosticsDTOBuilder = new SystemDiagnosticsDTOBuilder();
    systemDiagnosticsDTOBuilder.setAggregateSnapshot(systemDiagnosticsDTO.getAggregateSnapshot());
    systemDiagnosticsDTOBuilder.setNodeSnapshots(systemDiagnosticsDTO.getNodeSnapshots());
    return systemDiagnosticsDTOBuilder;
  }
}
