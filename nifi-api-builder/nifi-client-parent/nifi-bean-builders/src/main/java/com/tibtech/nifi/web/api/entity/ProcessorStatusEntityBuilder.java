package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import org.apache.nifi.web.api.dto.status.ProcessorStatusDTO;
import org.apache.nifi.web.api.entity.ProcessorStatusEntity;

public final class ProcessorStatusEntityBuilder extends AbstractEntityBuilder<ProcessorStatusEntityBuilder> {
  private Boolean canRead;

  private ProcessorStatusDTO processorStatus;

  public Boolean getCanRead() {
    return canRead;
  }

  public ProcessorStatusEntityBuilder setCanRead(final Boolean canRead) {
    this.canRead = canRead;
    return this;
  }

  public ProcessorStatusDTO getProcessorStatus() {
    return processorStatus;
  }

  public ProcessorStatusEntityBuilder setProcessorStatus(final ProcessorStatusDTO processorStatus) {
    this.processorStatus = processorStatus;
    return this;
  }

  public ProcessorStatusEntity build() {
    final ProcessorStatusEntity processorStatusEntity = new ProcessorStatusEntity();
    super.setPropertyValues(processorStatusEntity);
    processorStatusEntity.setCanRead(canRead);
    processorStatusEntity.setProcessorStatus(processorStatus);
    return processorStatusEntity;
  }

  public static ProcessorStatusEntityBuilder of(final ProcessorStatusEntity processorStatusEntity) {
    final ProcessorStatusEntityBuilder processorStatusEntityBuilder = new ProcessorStatusEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(processorStatusEntityBuilder, processorStatusEntity);
    processorStatusEntityBuilder.setCanRead(processorStatusEntity.getCanRead());
    processorStatusEntityBuilder.setProcessorStatus(processorStatusEntity.getProcessorStatus());
    return processorStatusEntityBuilder;
  }
}
