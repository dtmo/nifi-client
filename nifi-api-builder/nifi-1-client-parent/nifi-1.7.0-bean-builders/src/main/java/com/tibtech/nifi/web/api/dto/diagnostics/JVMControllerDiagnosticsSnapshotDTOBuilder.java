package com.tibtech.nifi.web.api.dto.diagnostics;

import java.lang.Boolean;
import java.lang.Integer;
import org.apache.nifi.web.api.dto.diagnostics.JVMControllerDiagnosticsSnapshotDTO;

public final class JVMControllerDiagnosticsSnapshotDTOBuilder {
  private Boolean clusterCoordinator;

  private Integer maxEventDrivenThreads;

  private Integer maxTimerDrivenThreads;

  private Boolean primaryNode;

  /**
   * Whether or not this node is cluster coordinator
   */
  public Boolean getClusterCoordinator() {
    return clusterCoordinator;
  }

  /**
   * Whether or not this node is cluster coordinator
   */
  public JVMControllerDiagnosticsSnapshotDTOBuilder setClusterCoordinator(
      final Boolean clusterCoordinator) {
    this.clusterCoordinator = clusterCoordinator;
    return this;
  }

  /**
   * The maximum number of event-driven threads
   */
  public Integer getMaxEventDrivenThreads() {
    return maxEventDrivenThreads;
  }

  /**
   * The maximum number of event-driven threads
   */
  public JVMControllerDiagnosticsSnapshotDTOBuilder setMaxEventDrivenThreads(
      final Integer maxEventDrivenThreads) {
    this.maxEventDrivenThreads = maxEventDrivenThreads;
    return this;
  }

  /**
   * The maximum number of timer-driven threads
   */
  public Integer getMaxTimerDrivenThreads() {
    return maxTimerDrivenThreads;
  }

  /**
   * The maximum number of timer-driven threads
   */
  public JVMControllerDiagnosticsSnapshotDTOBuilder setMaxTimerDrivenThreads(
      final Integer maxTimerDrivenThreads) {
    this.maxTimerDrivenThreads = maxTimerDrivenThreads;
    return this;
  }

  /**
   * Whether or not this node is primary node
   */
  public Boolean getPrimaryNode() {
    return primaryNode;
  }

  /**
   * Whether or not this node is primary node
   */
  public JVMControllerDiagnosticsSnapshotDTOBuilder setPrimaryNode(final Boolean primaryNode) {
    this.primaryNode = primaryNode;
    return this;
  }

  public JVMControllerDiagnosticsSnapshotDTO build() {
    final JVMControllerDiagnosticsSnapshotDTO jVMControllerDiagnosticsSnapshotDTO = new JVMControllerDiagnosticsSnapshotDTO();
    jVMControllerDiagnosticsSnapshotDTO.setClusterCoordinator(clusterCoordinator);
    jVMControllerDiagnosticsSnapshotDTO.setMaxEventDrivenThreads(maxEventDrivenThreads);
    jVMControllerDiagnosticsSnapshotDTO.setMaxTimerDrivenThreads(maxTimerDrivenThreads);
    jVMControllerDiagnosticsSnapshotDTO.setPrimaryNode(primaryNode);
    return jVMControllerDiagnosticsSnapshotDTO;
  }

  public static JVMControllerDiagnosticsSnapshotDTOBuilder of(
      final JVMControllerDiagnosticsSnapshotDTO jVMControllerDiagnosticsSnapshotDTO) {
    final JVMControllerDiagnosticsSnapshotDTOBuilder jVMControllerDiagnosticsSnapshotDTOBuilder = new JVMControllerDiagnosticsSnapshotDTOBuilder();
    jVMControllerDiagnosticsSnapshotDTOBuilder.setClusterCoordinator(jVMControllerDiagnosticsSnapshotDTO.getClusterCoordinator());
    jVMControllerDiagnosticsSnapshotDTOBuilder.setMaxEventDrivenThreads(jVMControllerDiagnosticsSnapshotDTO.getMaxEventDrivenThreads());
    jVMControllerDiagnosticsSnapshotDTOBuilder.setMaxTimerDrivenThreads(jVMControllerDiagnosticsSnapshotDTO.getMaxTimerDrivenThreads());
    jVMControllerDiagnosticsSnapshotDTOBuilder.setPrimaryNode(jVMControllerDiagnosticsSnapshotDTO.getPrimaryNode());
    return jVMControllerDiagnosticsSnapshotDTOBuilder;
  }
}
