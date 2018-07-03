package com.tibtech.nifi.web.api.entity;

import java.lang.Integer;
import java.lang.String;
import org.apache.nifi.registry.flow.VersionedFlowSnapshot;
import org.apache.nifi.web.api.dto.ProcessGroupDTO;
import org.apache.nifi.web.api.dto.status.ProcessGroupStatusDTO;
import org.apache.nifi.web.api.entity.ProcessGroupEntity;

public final class ProcessGroupEntityBuilder extends AbstractComponentEntityBuilder<ProcessGroupEntityBuilder> {
  private Integer activeRemotePortCount;

  private ProcessGroupDTO component;

  private Integer disabledCount;

  private Integer inactiveRemotePortCount;

  private Integer inputPortCount;

  private Integer invalidCount;

  private Integer locallyModifiedAndStaleCount;

  private Integer locallyModifiedCount;

  private Integer outputPortCount;

  private Integer runningCount;

  private Integer staleCount;

  private ProcessGroupStatusDTO status;

  private Integer stoppedCount;

  private Integer syncFailureCount;

  private Integer upToDateCount;

  private VersionedFlowSnapshot versionedFlowSnapshot;

  private String versionedFlowState;

  /**
   * The number of active remote ports in the process group.
   */
  public Integer getActiveRemotePortCount() {
    return activeRemotePortCount;
  }

  /**
   * The number of active remote ports in the process group.
   */
  public ProcessGroupEntityBuilder setActiveRemotePortCount(final Integer activeRemotePortCount) {
    this.activeRemotePortCount = activeRemotePortCount;
    return this;
  }

  public ProcessGroupDTO getComponent() {
    return component;
  }

  public ProcessGroupEntityBuilder setComponent(final ProcessGroupDTO component) {
    this.component = component;
    return this;
  }

  /**
   * The number of disabled components in the process group.
   */
  public Integer getDisabledCount() {
    return disabledCount;
  }

  /**
   * The number of disabled components in the process group.
   */
  public ProcessGroupEntityBuilder setDisabledCount(final Integer disabledCount) {
    this.disabledCount = disabledCount;
    return this;
  }

  /**
   * The number of inactive remote ports in the process group.
   */
  public Integer getInactiveRemotePortCount() {
    return inactiveRemotePortCount;
  }

  /**
   * The number of inactive remote ports in the process group.
   */
  public ProcessGroupEntityBuilder setInactiveRemotePortCount(final Integer inactiveRemotePortCount) {
    this.inactiveRemotePortCount = inactiveRemotePortCount;
    return this;
  }

  /**
   * The number of input ports in the process group.
   */
  public Integer getInputPortCount() {
    return inputPortCount;
  }

  /**
   * The number of input ports in the process group.
   */
  public ProcessGroupEntityBuilder setInputPortCount(final Integer inputPortCount) {
    this.inputPortCount = inputPortCount;
    return this;
  }

  /**
   * The number of invalid components in the process group.
   */
  public Integer getInvalidCount() {
    return invalidCount;
  }

  /**
   * The number of invalid components in the process group.
   */
  public ProcessGroupEntityBuilder setInvalidCount(final Integer invalidCount) {
    this.invalidCount = invalidCount;
    return this;
  }

  /**
   * The number of locally modified and stale versioned process groups in the process group.
   */
  public Integer getLocallyModifiedAndStaleCount() {
    return locallyModifiedAndStaleCount;
  }

  /**
   * The number of locally modified and stale versioned process groups in the process group.
   */
  public ProcessGroupEntityBuilder setLocallyModifiedAndStaleCount(final Integer locallyModifiedAndStaleCount) {
    this.locallyModifiedAndStaleCount = locallyModifiedAndStaleCount;
    return this;
  }

  /**
   * The number of locally modified versioned process groups in the process group.
   */
  public Integer getLocallyModifiedCount() {
    return locallyModifiedCount;
  }

  /**
   * The number of locally modified versioned process groups in the process group.
   */
  public ProcessGroupEntityBuilder setLocallyModifiedCount(final Integer locallyModifiedCount) {
    this.locallyModifiedCount = locallyModifiedCount;
    return this;
  }

  /**
   * The number of output ports in the process group.
   */
  public Integer getOutputPortCount() {
    return outputPortCount;
  }

  /**
   * The number of output ports in the process group.
   */
  public ProcessGroupEntityBuilder setOutputPortCount(final Integer outputPortCount) {
    this.outputPortCount = outputPortCount;
    return this;
  }

  /**
   * The number of running components in this process group.
   */
  public Integer getRunningCount() {
    return runningCount;
  }

  /**
   * The number of running components in this process group.
   */
  public ProcessGroupEntityBuilder setRunningCount(final Integer runningCount) {
    this.runningCount = runningCount;
    return this;
  }

  /**
   * The number of stale versioned process groups in the process group.
   */
  public Integer getStaleCount() {
    return staleCount;
  }

  /**
   * The number of stale versioned process groups in the process group.
   */
  public ProcessGroupEntityBuilder setStaleCount(final Integer staleCount) {
    this.staleCount = staleCount;
    return this;
  }

  /**
   * The status of the process group.
   */
  public ProcessGroupStatusDTO getStatus() {
    return status;
  }

  /**
   * The status of the process group.
   */
  public ProcessGroupEntityBuilder setStatus(final ProcessGroupStatusDTO status) {
    this.status = status;
    return this;
  }

  /**
   * The number of stopped components in the process group.
   */
  public Integer getStoppedCount() {
    return stoppedCount;
  }

  /**
   * The number of stopped components in the process group.
   */
  public ProcessGroupEntityBuilder setStoppedCount(final Integer stoppedCount) {
    this.stoppedCount = stoppedCount;
    return this;
  }

  /**
   * The number of versioned process groups in the process group that are unable to sync to a registry.
   */
  public Integer getSyncFailureCount() {
    return syncFailureCount;
  }

  /**
   * The number of versioned process groups in the process group that are unable to sync to a registry.
   */
  public ProcessGroupEntityBuilder setSyncFailureCount(final Integer syncFailureCount) {
    this.syncFailureCount = syncFailureCount;
    return this;
  }

  /**
   * The number of up to date versioned process groups in the process group.
   */
  public Integer getUpToDateCount() {
    return upToDateCount;
  }

  /**
   * The number of up to date versioned process groups in the process group.
   */
  public ProcessGroupEntityBuilder setUpToDateCount(final Integer upToDateCount) {
    this.upToDateCount = upToDateCount;
    return this;
  }

  /**
   * Returns the Versioned Flow that describes the contents of the Versioned Flow to be imported
   */
  public VersionedFlowSnapshot getVersionedFlowSnapshot() {
    return versionedFlowSnapshot;
  }

  /**
   * Returns the Versioned Flow that describes the contents of the Versioned Flow to be imported
   */
  public ProcessGroupEntityBuilder setVersionedFlowSnapshot(final VersionedFlowSnapshot versionedFlowSnapshot) {
    this.versionedFlowSnapshot = versionedFlowSnapshot;
    return this;
  }

  /**
   * The current state of the Process Group, as it relates to the Versioned Flow
   */
  public String getVersionedFlowState() {
    return versionedFlowState;
  }

  /**
   * The current state of the Process Group, as it relates to the Versioned Flow
   */
  public ProcessGroupEntityBuilder setVersionedFlowState(final String versionedFlowState) {
    this.versionedFlowState = versionedFlowState;
    return this;
  }

  public ProcessGroupEntity build() {
    final ProcessGroupEntity processGroupEntity = new ProcessGroupEntity();
    super.setPropertyValues(processGroupEntity);
    processGroupEntity.setActiveRemotePortCount(activeRemotePortCount);
    processGroupEntity.setComponent(component);
    processGroupEntity.setDisabledCount(disabledCount);
    processGroupEntity.setInactiveRemotePortCount(inactiveRemotePortCount);
    processGroupEntity.setInputPortCount(inputPortCount);
    processGroupEntity.setInvalidCount(invalidCount);
    processGroupEntity.setLocallyModifiedAndStaleCount(locallyModifiedAndStaleCount);
    processGroupEntity.setLocallyModifiedCount(locallyModifiedCount);
    processGroupEntity.setOutputPortCount(outputPortCount);
    processGroupEntity.setRunningCount(runningCount);
    processGroupEntity.setStaleCount(staleCount);
    processGroupEntity.setStatus(status);
    processGroupEntity.setStoppedCount(stoppedCount);
    processGroupEntity.setSyncFailureCount(syncFailureCount);
    processGroupEntity.setUpToDateCount(upToDateCount);
    processGroupEntity.setVersionedFlowSnapshot(versionedFlowSnapshot);
    processGroupEntity.setVersionedFlowState(versionedFlowState);
    return processGroupEntity;
  }

  public static ProcessGroupEntityBuilder of(final ProcessGroupEntity processGroupEntity) {
    final ProcessGroupEntityBuilder processGroupEntityBuilder = new ProcessGroupEntityBuilder();
    AbstractComponentEntityBuilder.setBuilderValues(processGroupEntityBuilder, processGroupEntity);
    processGroupEntityBuilder.setActiveRemotePortCount(processGroupEntity.getActiveRemotePortCount());
    processGroupEntityBuilder.setComponent(processGroupEntity.getComponent());
    processGroupEntityBuilder.setDisabledCount(processGroupEntity.getDisabledCount());
    processGroupEntityBuilder.setInactiveRemotePortCount(processGroupEntity.getInactiveRemotePortCount());
    processGroupEntityBuilder.setInputPortCount(processGroupEntity.getInputPortCount());
    processGroupEntityBuilder.setInvalidCount(processGroupEntity.getInvalidCount());
    processGroupEntityBuilder.setLocallyModifiedAndStaleCount(processGroupEntity.getLocallyModifiedAndStaleCount());
    processGroupEntityBuilder.setLocallyModifiedCount(processGroupEntity.getLocallyModifiedCount());
    processGroupEntityBuilder.setOutputPortCount(processGroupEntity.getOutputPortCount());
    processGroupEntityBuilder.setRunningCount(processGroupEntity.getRunningCount());
    processGroupEntityBuilder.setStaleCount(processGroupEntity.getStaleCount());
    processGroupEntityBuilder.setStatus(processGroupEntity.getStatus());
    processGroupEntityBuilder.setStoppedCount(processGroupEntity.getStoppedCount());
    processGroupEntityBuilder.setSyncFailureCount(processGroupEntity.getSyncFailureCount());
    processGroupEntityBuilder.setUpToDateCount(processGroupEntity.getUpToDateCount());
    processGroupEntityBuilder.setVersionedFlowSnapshot(processGroupEntity.getVersionedFlowSnapshot());
    processGroupEntityBuilder.setVersionedFlowState(processGroupEntity.getVersionedFlowState());
    return processGroupEntityBuilder;
  }
}
