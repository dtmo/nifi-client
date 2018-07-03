package com.tibtech.nifi.web.api.entity;

import java.lang.String;
import org.apache.nifi.web.api.dto.ProcessorDTO;
import org.apache.nifi.web.api.dto.status.ProcessorStatusDTO;
import org.apache.nifi.web.api.entity.ProcessorEntity;

public final class ProcessorEntityBuilder extends AbstractComponentEntityBuilder<ProcessorEntityBuilder> {
  private ProcessorDTO component;

  private String inputRequirement;

  private ProcessorStatusDTO status;

  public ProcessorDTO getComponent() {
    return component;
  }

  public ProcessorEntityBuilder setComponent(final ProcessorDTO component) {
    this.component = component;
    return this;
  }

  /**
   * The input requirement for this processor.
   */
  public String getInputRequirement() {
    return inputRequirement;
  }

  /**
   * The input requirement for this processor.
   */
  public ProcessorEntityBuilder setInputRequirement(final String inputRequirement) {
    this.inputRequirement = inputRequirement;
    return this;
  }

  public ProcessorStatusDTO getStatus() {
    return status;
  }

  public ProcessorEntityBuilder setStatus(final ProcessorStatusDTO status) {
    this.status = status;
    return this;
  }

  public ProcessorEntity build() {
    final ProcessorEntity processorEntity = new ProcessorEntity();
    super.setPropertyValues(processorEntity);
    processorEntity.setComponent(component);
    processorEntity.setInputRequirement(inputRequirement);
    processorEntity.setStatus(status);
    return processorEntity;
  }

  public static ProcessorEntityBuilder of(final ProcessorEntity processorEntity) {
    final ProcessorEntityBuilder processorEntityBuilder = new ProcessorEntityBuilder();
    AbstractComponentEntityBuilder.setBuilderValues(processorEntityBuilder, processorEntity);
    processorEntityBuilder.setComponent(processorEntity.getComponent());
    processorEntityBuilder.setInputRequirement(processorEntity.getInputRequirement());
    processorEntityBuilder.setStatus(processorEntity.getStatus());
    return processorEntityBuilder;
  }
}
