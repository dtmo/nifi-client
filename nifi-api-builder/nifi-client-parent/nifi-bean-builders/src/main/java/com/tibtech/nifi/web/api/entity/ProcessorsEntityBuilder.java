package com.tibtech.nifi.web.api.entity;

import java.util.Set;
import org.apache.nifi.web.api.entity.ProcessorEntity;
import org.apache.nifi.web.api.entity.ProcessorsEntity;

public final class ProcessorsEntityBuilder extends AbstractEntityBuilder<ProcessorsEntityBuilder> {
  private Set<ProcessorEntity> processors;

  public Set<ProcessorEntity> getProcessors() {
    return processors;
  }

  public ProcessorsEntityBuilder setProcessors(final Set<ProcessorEntity> processors) {
    this.processors = processors;
    return this;
  }

  public ProcessorsEntity build() {
    final ProcessorsEntity processorsEntity = new ProcessorsEntity();
    super.setPropertyValues(processorsEntity);
    processorsEntity.setProcessors(processors);
    return processorsEntity;
  }

  public static ProcessorsEntityBuilder of(final ProcessorsEntity processorsEntity) {
    final ProcessorsEntityBuilder processorsEntityBuilder = new ProcessorsEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(processorsEntityBuilder, processorsEntity);
    processorsEntityBuilder.setProcessors(processorsEntity.getProcessors());
    return processorsEntityBuilder;
  }
}
