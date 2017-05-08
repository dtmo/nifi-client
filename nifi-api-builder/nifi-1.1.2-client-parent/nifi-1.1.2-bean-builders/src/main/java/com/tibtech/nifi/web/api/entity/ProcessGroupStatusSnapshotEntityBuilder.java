package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import java.lang.String;
import org.apache.nifi.web.api.dto.status.ProcessGroupStatusSnapshotDTO;
import org.apache.nifi.web.api.entity.ProcessGroupStatusSnapshotEntity;

public final class ProcessGroupStatusSnapshotEntityBuilder extends AbstractEntityBuilder<ProcessGroupStatusSnapshotEntityBuilder> {
  private Boolean canRead;

  private String id;

  private ProcessGroupStatusSnapshotDTO processGroupStatusSnapshot;

  public Boolean getCanRead() {
    return canRead;
  }

  public ProcessGroupStatusSnapshotEntityBuilder setCanRead(final Boolean canRead) {
    this.canRead = canRead;
    return this;
  }

  /**
   * The id of the process group.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the process group.
   */
  public ProcessGroupStatusSnapshotEntityBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  public ProcessGroupStatusSnapshotDTO getProcessGroupStatusSnapshot() {
    return processGroupStatusSnapshot;
  }

  public ProcessGroupStatusSnapshotEntityBuilder setProcessGroupStatusSnapshot(final ProcessGroupStatusSnapshotDTO processGroupStatusSnapshot) {
    this.processGroupStatusSnapshot = processGroupStatusSnapshot;
    return this;
  }

  public ProcessGroupStatusSnapshotEntity build() {
    final ProcessGroupStatusSnapshotEntity processGroupStatusSnapshotEntity = new ProcessGroupStatusSnapshotEntity();
    super.setPropertyValues(processGroupStatusSnapshotEntity);
    processGroupStatusSnapshotEntity.setCanRead(canRead);
    processGroupStatusSnapshotEntity.setId(id);
    processGroupStatusSnapshotEntity.setProcessGroupStatusSnapshot(processGroupStatusSnapshot);
    return processGroupStatusSnapshotEntity;
  }

  public static ProcessGroupStatusSnapshotEntityBuilder of(final ProcessGroupStatusSnapshotEntity processGroupStatusSnapshotEntity) {
    final ProcessGroupStatusSnapshotEntityBuilder processGroupStatusSnapshotEntityBuilder = new ProcessGroupStatusSnapshotEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(processGroupStatusSnapshotEntityBuilder, processGroupStatusSnapshotEntity);
    processGroupStatusSnapshotEntityBuilder.setCanRead(processGroupStatusSnapshotEntity.getCanRead());
    processGroupStatusSnapshotEntityBuilder.setId(processGroupStatusSnapshotEntity.getId());
    processGroupStatusSnapshotEntityBuilder.setProcessGroupStatusSnapshot(processGroupStatusSnapshotEntity.getProcessGroupStatusSnapshot());
    return processGroupStatusSnapshotEntityBuilder;
  }
}
