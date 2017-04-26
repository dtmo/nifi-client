package com.tibtech.nifi.web.api.entity;

import java.lang.Integer;
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

  private Integer outputPortCount;

  private Integer runningCount;

  private ProcessGroupStatusDTO status;

  private Integer stoppedCount;

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

  public ProcessGroupEntity build() {
    final ProcessGroupEntity processGroupEntity = new ProcessGroupEntity();
    super.setPropertyValues(processGroupEntity);
    processGroupEntity.setActiveRemotePortCount(activeRemotePortCount);
    processGroupEntity.setComponent(component);
    processGroupEntity.setDisabledCount(disabledCount);
    processGroupEntity.setInactiveRemotePortCount(inactiveRemotePortCount);
    processGroupEntity.setInputPortCount(inputPortCount);
    processGroupEntity.setInvalidCount(invalidCount);
    processGroupEntity.setOutputPortCount(outputPortCount);
    processGroupEntity.setRunningCount(runningCount);
    processGroupEntity.setStatus(status);
    processGroupEntity.setStoppedCount(stoppedCount);
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
    processGroupEntityBuilder.setOutputPortCount(processGroupEntity.getOutputPortCount());
    processGroupEntityBuilder.setRunningCount(processGroupEntity.getRunningCount());
    processGroupEntityBuilder.setStatus(processGroupEntity.getStatus());
    processGroupEntityBuilder.setStoppedCount(processGroupEntity.getStoppedCount());
    return processGroupEntityBuilder;
  }
}
