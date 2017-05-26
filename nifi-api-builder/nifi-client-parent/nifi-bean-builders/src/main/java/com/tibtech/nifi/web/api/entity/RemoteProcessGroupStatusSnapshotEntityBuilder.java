package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import java.lang.String;
import org.apache.nifi.web.api.dto.status.RemoteProcessGroupStatusSnapshotDTO;
import org.apache.nifi.web.api.entity.RemoteProcessGroupStatusSnapshotEntity;

public final class RemoteProcessGroupStatusSnapshotEntityBuilder extends AbstractEntityBuilder<RemoteProcessGroupStatusSnapshotEntityBuilder> {
  private Boolean canRead;

  private String id;

  private RemoteProcessGroupStatusSnapshotDTO remoteProcessGroupStatusSnapshot;

  public Boolean getCanRead() {
    return canRead;
  }

  public RemoteProcessGroupStatusSnapshotEntityBuilder setCanRead(final Boolean canRead) {
    this.canRead = canRead;
    return this;
  }

  /**
   * The id of the remote process group.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the remote process group.
   */
  public RemoteProcessGroupStatusSnapshotEntityBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  public RemoteProcessGroupStatusSnapshotDTO getRemoteProcessGroupStatusSnapshot() {
    return remoteProcessGroupStatusSnapshot;
  }

  public RemoteProcessGroupStatusSnapshotEntityBuilder setRemoteProcessGroupStatusSnapshot(final RemoteProcessGroupStatusSnapshotDTO remoteProcessGroupStatusSnapshot) {
    this.remoteProcessGroupStatusSnapshot = remoteProcessGroupStatusSnapshot;
    return this;
  }

  public RemoteProcessGroupStatusSnapshotEntity build() {
    final RemoteProcessGroupStatusSnapshotEntity remoteProcessGroupStatusSnapshotEntity = new RemoteProcessGroupStatusSnapshotEntity();
    super.setPropertyValues(remoteProcessGroupStatusSnapshotEntity);
    remoteProcessGroupStatusSnapshotEntity.setCanRead(canRead);
    remoteProcessGroupStatusSnapshotEntity.setId(id);
    remoteProcessGroupStatusSnapshotEntity.setRemoteProcessGroupStatusSnapshot(remoteProcessGroupStatusSnapshot);
    return remoteProcessGroupStatusSnapshotEntity;
  }

  public static RemoteProcessGroupStatusSnapshotEntityBuilder of(final RemoteProcessGroupStatusSnapshotEntity remoteProcessGroupStatusSnapshotEntity) {
    final RemoteProcessGroupStatusSnapshotEntityBuilder remoteProcessGroupStatusSnapshotEntityBuilder = new RemoteProcessGroupStatusSnapshotEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(remoteProcessGroupStatusSnapshotEntityBuilder, remoteProcessGroupStatusSnapshotEntity);
    remoteProcessGroupStatusSnapshotEntityBuilder.setCanRead(remoteProcessGroupStatusSnapshotEntity.getCanRead());
    remoteProcessGroupStatusSnapshotEntityBuilder.setId(remoteProcessGroupStatusSnapshotEntity.getId());
    remoteProcessGroupStatusSnapshotEntityBuilder.setRemoteProcessGroupStatusSnapshot(remoteProcessGroupStatusSnapshotEntity.getRemoteProcessGroupStatusSnapshot());
    return remoteProcessGroupStatusSnapshotEntityBuilder;
  }
}
