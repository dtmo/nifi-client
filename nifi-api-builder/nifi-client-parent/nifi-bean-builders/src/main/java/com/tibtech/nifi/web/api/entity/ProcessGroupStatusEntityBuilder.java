package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import org.apache.nifi.web.api.dto.status.ProcessGroupStatusDTO;
import org.apache.nifi.web.api.entity.ProcessGroupStatusEntity;

public final class ProcessGroupStatusEntityBuilder extends AbstractEntityBuilder<ProcessGroupStatusEntityBuilder> {
  private Boolean canRead;

  private ProcessGroupStatusDTO processGroupStatus;

  public Boolean getCanRead() {
    return canRead;
  }

  public ProcessGroupStatusEntityBuilder setCanRead(final Boolean canRead) {
    this.canRead = canRead;
    return this;
  }

  public ProcessGroupStatusDTO getProcessGroupStatus() {
    return processGroupStatus;
  }

  public ProcessGroupStatusEntityBuilder setProcessGroupStatus(final ProcessGroupStatusDTO processGroupStatus) {
    this.processGroupStatus = processGroupStatus;
    return this;
  }

  public ProcessGroupStatusEntity build() {
    final ProcessGroupStatusEntity processGroupStatusEntity = new ProcessGroupStatusEntity();
    super.setPropertyValues(processGroupStatusEntity);
    processGroupStatusEntity.setCanRead(canRead);
    processGroupStatusEntity.setProcessGroupStatus(processGroupStatus);
    return processGroupStatusEntity;
  }

  public static ProcessGroupStatusEntityBuilder of(final ProcessGroupStatusEntity processGroupStatusEntity) {
    final ProcessGroupStatusEntityBuilder processGroupStatusEntityBuilder = new ProcessGroupStatusEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(processGroupStatusEntityBuilder, processGroupStatusEntity);
    processGroupStatusEntityBuilder.setCanRead(processGroupStatusEntity.getCanRead());
    processGroupStatusEntityBuilder.setProcessGroupStatus(processGroupStatusEntity.getProcessGroupStatus());
    return processGroupStatusEntityBuilder;
  }
}
