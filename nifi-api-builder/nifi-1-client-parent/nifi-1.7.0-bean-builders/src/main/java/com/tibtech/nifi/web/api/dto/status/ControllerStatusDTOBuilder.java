package com.tibtech.nifi.web.api.dto.status;

import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import org.apache.nifi.web.api.dto.status.ControllerStatusDTO;

public final class ControllerStatusDTOBuilder {
  private Integer activeRemotePortCount;

  private Integer activeThreadCount;

  private Long bytesQueued;

  private Integer disabledCount;

  private Integer flowFilesQueued;

  private Integer inactiveRemotePortCount;

  private Integer invalidCount;

  private Integer locallyModifiedAndStaleCount;

  private Integer locallyModifiedCount;

  private String queued;

  private Integer runningCount;

  private Integer staleCount;

  private Integer stoppedCount;

  private Integer syncFailureCount;

  private Integer terminatedThreadCount;

  private Integer upToDateCount;

  /**
   * The number of active remote ports in the NiFi.
   */
  public Integer getActiveRemotePortCount() {
    return activeRemotePortCount;
  }

  /**
   * The number of active remote ports in the NiFi.
   */
  public ControllerStatusDTOBuilder setActiveRemotePortCount(final Integer activeRemotePortCount) {
    this.activeRemotePortCount = activeRemotePortCount;
    return this;
  }

  /**
   * The number of active threads in the NiFi.
   */
  public Integer getActiveThreadCount() {
    return activeThreadCount;
  }

  /**
   * The number of active threads in the NiFi.
   */
  public ControllerStatusDTOBuilder setActiveThreadCount(final Integer activeThreadCount) {
    this.activeThreadCount = activeThreadCount;
    return this;
  }

  /**
   * The size of the FlowFiles queued across the entire flow
   */
  public Long getBytesQueued() {
    return bytesQueued;
  }

  /**
   * The size of the FlowFiles queued across the entire flow
   */
  public ControllerStatusDTOBuilder setBytesQueued(final Long bytesQueued) {
    this.bytesQueued = bytesQueued;
    return this;
  }

  /**
   * The number of disabled components in the NiFi.
   */
  public Integer getDisabledCount() {
    return disabledCount;
  }

  /**
   * The number of disabled components in the NiFi.
   */
  public ControllerStatusDTOBuilder setDisabledCount(final Integer disabledCount) {
    this.disabledCount = disabledCount;
    return this;
  }

  /**
   * The number of FlowFiles queued across the entire flow
   */
  public Integer getFlowFilesQueued() {
    return flowFilesQueued;
  }

  /**
   * The number of FlowFiles queued across the entire flow
   */
  public ControllerStatusDTOBuilder setFlowFilesQueued(final Integer flowFilesQueued) {
    this.flowFilesQueued = flowFilesQueued;
    return this;
  }

  /**
   * The number of inactive remote ports in the NiFi.
   */
  public Integer getInactiveRemotePortCount() {
    return inactiveRemotePortCount;
  }

  /**
   * The number of inactive remote ports in the NiFi.
   */
  public ControllerStatusDTOBuilder setInactiveRemotePortCount(
      final Integer inactiveRemotePortCount) {
    this.inactiveRemotePortCount = inactiveRemotePortCount;
    return this;
  }

  /**
   * The number of invalid components in the NiFi.
   */
  public Integer getInvalidCount() {
    return invalidCount;
  }

  /**
   * The number of invalid components in the NiFi.
   */
  public ControllerStatusDTOBuilder setInvalidCount(final Integer invalidCount) {
    this.invalidCount = invalidCount;
    return this;
  }

  /**
   * The number of locally modified and stale versioned process groups in the NiFi.
   */
  public Integer getLocallyModifiedAndStaleCount() {
    return locallyModifiedAndStaleCount;
  }

  /**
   * The number of locally modified and stale versioned process groups in the NiFi.
   */
  public ControllerStatusDTOBuilder setLocallyModifiedAndStaleCount(
      final Integer locallyModifiedAndStaleCount) {
    this.locallyModifiedAndStaleCount = locallyModifiedAndStaleCount;
    return this;
  }

  /**
   * The number of locally modified versioned process groups in the NiFi.
   */
  public Integer getLocallyModifiedCount() {
    return locallyModifiedCount;
  }

  /**
   * The number of locally modified versioned process groups in the NiFi.
   */
  public ControllerStatusDTOBuilder setLocallyModifiedCount(final Integer locallyModifiedCount) {
    this.locallyModifiedCount = locallyModifiedCount;
    return this;
  }

  /**
   * The number of flowfiles queued in the NiFi.
   */
  public String getQueued() {
    return queued;
  }

  /**
   * The number of flowfiles queued in the NiFi.
   */
  public ControllerStatusDTOBuilder setQueued(final String queued) {
    this.queued = queued;
    return this;
  }

  /**
   * The number of running components in the NiFi.
   */
  public Integer getRunningCount() {
    return runningCount;
  }

  /**
   * The number of running components in the NiFi.
   */
  public ControllerStatusDTOBuilder setRunningCount(final Integer runningCount) {
    this.runningCount = runningCount;
    return this;
  }

  /**
   * The number of stale versioned process groups in the NiFi.
   */
  public Integer getStaleCount() {
    return staleCount;
  }

  /**
   * The number of stale versioned process groups in the NiFi.
   */
  public ControllerStatusDTOBuilder setStaleCount(final Integer staleCount) {
    this.staleCount = staleCount;
    return this;
  }

  /**
   * The number of stopped components in the NiFi.
   */
  public Integer getStoppedCount() {
    return stoppedCount;
  }

  /**
   * The number of stopped components in the NiFi.
   */
  public ControllerStatusDTOBuilder setStoppedCount(final Integer stoppedCount) {
    this.stoppedCount = stoppedCount;
    return this;
  }

  /**
   * The number of versioned process groups in the NiFi that are unable to sync to a registry.
   */
  public Integer getSyncFailureCount() {
    return syncFailureCount;
  }

  /**
   * The number of versioned process groups in the NiFi that are unable to sync to a registry.
   */
  public ControllerStatusDTOBuilder setSyncFailureCount(final Integer syncFailureCount) {
    this.syncFailureCount = syncFailureCount;
    return this;
  }

  /**
   * The number of terminated threads in the NiFi.
   */
  public Integer getTerminatedThreadCount() {
    return terminatedThreadCount;
  }

  /**
   * The number of terminated threads in the NiFi.
   */
  public ControllerStatusDTOBuilder setTerminatedThreadCount(final Integer terminatedThreadCount) {
    this.terminatedThreadCount = terminatedThreadCount;
    return this;
  }

  /**
   * The number of up to date versioned process groups in the NiFi.
   */
  public Integer getUpToDateCount() {
    return upToDateCount;
  }

  /**
   * The number of up to date versioned process groups in the NiFi.
   */
  public ControllerStatusDTOBuilder setUpToDateCount(final Integer upToDateCount) {
    this.upToDateCount = upToDateCount;
    return this;
  }

  public ControllerStatusDTO build() {
    final ControllerStatusDTO controllerStatusDTO = new ControllerStatusDTO();
    controllerStatusDTO.setActiveRemotePortCount(activeRemotePortCount);
    controllerStatusDTO.setActiveThreadCount(activeThreadCount);
    controllerStatusDTO.setBytesQueued(bytesQueued);
    controllerStatusDTO.setDisabledCount(disabledCount);
    controllerStatusDTO.setFlowFilesQueued(flowFilesQueued);
    controllerStatusDTO.setInactiveRemotePortCount(inactiveRemotePortCount);
    controllerStatusDTO.setInvalidCount(invalidCount);
    controllerStatusDTO.setLocallyModifiedAndStaleCount(locallyModifiedAndStaleCount);
    controllerStatusDTO.setLocallyModifiedCount(locallyModifiedCount);
    controllerStatusDTO.setQueued(queued);
    controllerStatusDTO.setRunningCount(runningCount);
    controllerStatusDTO.setStaleCount(staleCount);
    controllerStatusDTO.setStoppedCount(stoppedCount);
    controllerStatusDTO.setSyncFailureCount(syncFailureCount);
    controllerStatusDTO.setTerminatedThreadCount(terminatedThreadCount);
    controllerStatusDTO.setUpToDateCount(upToDateCount);
    return controllerStatusDTO;
  }

  public static ControllerStatusDTOBuilder of(final ControllerStatusDTO controllerStatusDTO) {
    final ControllerStatusDTOBuilder controllerStatusDTOBuilder = new ControllerStatusDTOBuilder();
    controllerStatusDTOBuilder.setActiveRemotePortCount(controllerStatusDTO.getActiveRemotePortCount());
    controllerStatusDTOBuilder.setActiveThreadCount(controllerStatusDTO.getActiveThreadCount());
    controllerStatusDTOBuilder.setBytesQueued(controllerStatusDTO.getBytesQueued());
    controllerStatusDTOBuilder.setDisabledCount(controllerStatusDTO.getDisabledCount());
    controllerStatusDTOBuilder.setFlowFilesQueued(controllerStatusDTO.getFlowFilesQueued());
    controllerStatusDTOBuilder.setInactiveRemotePortCount(controllerStatusDTO.getInactiveRemotePortCount());
    controllerStatusDTOBuilder.setInvalidCount(controllerStatusDTO.getInvalidCount());
    controllerStatusDTOBuilder.setLocallyModifiedAndStaleCount(controllerStatusDTO.getLocallyModifiedAndStaleCount());
    controllerStatusDTOBuilder.setLocallyModifiedCount(controllerStatusDTO.getLocallyModifiedCount());
    controllerStatusDTOBuilder.setQueued(controllerStatusDTO.getQueued());
    controllerStatusDTOBuilder.setRunningCount(controllerStatusDTO.getRunningCount());
    controllerStatusDTOBuilder.setStaleCount(controllerStatusDTO.getStaleCount());
    controllerStatusDTOBuilder.setStoppedCount(controllerStatusDTO.getStoppedCount());
    controllerStatusDTOBuilder.setSyncFailureCount(controllerStatusDTO.getSyncFailureCount());
    controllerStatusDTOBuilder.setTerminatedThreadCount(controllerStatusDTO.getTerminatedThreadCount());
    controllerStatusDTOBuilder.setUpToDateCount(controllerStatusDTO.getUpToDateCount());
    return controllerStatusDTOBuilder;
  }
}
