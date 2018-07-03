package com.tibtech.nifi.web.api.entity;

import java.util.Set;
import org.apache.nifi.web.api.dto.DocumentedTypeDTO;
import org.apache.nifi.web.api.entity.ProcessorTypesEntity;

public final class ProcessorTypesEntityBuilder extends AbstractEntityBuilder<ProcessorTypesEntityBuilder> {
  private Set<DocumentedTypeDTO> processorTypes;

  public Set<DocumentedTypeDTO> getProcessorTypes() {
    return processorTypes;
  }

  public ProcessorTypesEntityBuilder setProcessorTypes(final Set<DocumentedTypeDTO> processorTypes) {
    this.processorTypes = processorTypes;
    return this;
  }

  public ProcessorTypesEntity build() {
    final ProcessorTypesEntity processorTypesEntity = new ProcessorTypesEntity();
    super.setPropertyValues(processorTypesEntity);
    processorTypesEntity.setProcessorTypes(processorTypes);
    return processorTypesEntity;
  }

  public static ProcessorTypesEntityBuilder of(final ProcessorTypesEntity processorTypesEntity) {
    final ProcessorTypesEntityBuilder processorTypesEntityBuilder = new ProcessorTypesEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(processorTypesEntityBuilder, processorTypesEntity);
    processorTypesEntityBuilder.setProcessorTypes(processorTypesEntity.getProcessorTypes());
    return processorTypesEntityBuilder;
  }
}
