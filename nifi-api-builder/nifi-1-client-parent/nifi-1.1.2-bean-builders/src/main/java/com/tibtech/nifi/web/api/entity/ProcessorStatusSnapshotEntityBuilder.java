package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import java.lang.String;
import org.apache.nifi.web.api.dto.status.ProcessorStatusSnapshotDTO;
import org.apache.nifi.web.api.entity.ProcessorStatusSnapshotEntity;

public final class ProcessorStatusSnapshotEntityBuilder extends AbstractEntityBuilder<ProcessorStatusSnapshotEntityBuilder> {
  private Boolean canRead;

  private String id;

  private ProcessorStatusSnapshotDTO processorStatusSnapshot;

  public Boolean getCanRead() {
    return canRead;
  }

  public ProcessorStatusSnapshotEntityBuilder setCanRead(final Boolean canRead) {
    this.canRead = canRead;
    return this;
  }

  /**
   * The id of the processor.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the processor.
   */
  public ProcessorStatusSnapshotEntityBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  public ProcessorStatusSnapshotDTO getProcessorStatusSnapshot() {
    return processorStatusSnapshot;
  }

  public ProcessorStatusSnapshotEntityBuilder setProcessorStatusSnapshot(final ProcessorStatusSnapshotDTO processorStatusSnapshot) {
    this.processorStatusSnapshot = processorStatusSnapshot;
    return this;
  }

  public ProcessorStatusSnapshotEntity build() {
    final ProcessorStatusSnapshotEntity processorStatusSnapshotEntity = new ProcessorStatusSnapshotEntity();
    super.setPropertyValues(processorStatusSnapshotEntity);
    processorStatusSnapshotEntity.setCanRead(canRead);
    processorStatusSnapshotEntity.setId(id);
    processorStatusSnapshotEntity.setProcessorStatusSnapshot(processorStatusSnapshot);
    return processorStatusSnapshotEntity;
  }

  public static ProcessorStatusSnapshotEntityBuilder of(final ProcessorStatusSnapshotEntity processorStatusSnapshotEntity) {
    final ProcessorStatusSnapshotEntityBuilder processorStatusSnapshotEntityBuilder = new ProcessorStatusSnapshotEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(processorStatusSnapshotEntityBuilder, processorStatusSnapshotEntity);
    processorStatusSnapshotEntityBuilder.setCanRead(processorStatusSnapshotEntity.getCanRead());
    processorStatusSnapshotEntityBuilder.setId(processorStatusSnapshotEntity.getId());
    processorStatusSnapshotEntityBuilder.setProcessorStatusSnapshot(processorStatusSnapshotEntity.getProcessorStatusSnapshot());
    return processorStatusSnapshotEntityBuilder;
  }
}
