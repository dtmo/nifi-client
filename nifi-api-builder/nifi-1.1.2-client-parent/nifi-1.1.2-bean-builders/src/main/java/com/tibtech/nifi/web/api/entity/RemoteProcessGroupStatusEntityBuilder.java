package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import org.apache.nifi.web.api.dto.status.RemoteProcessGroupStatusDTO;
import org.apache.nifi.web.api.entity.RemoteProcessGroupStatusEntity;

public final class RemoteProcessGroupStatusEntityBuilder extends AbstractEntityBuilder<RemoteProcessGroupStatusEntityBuilder> {
  private Boolean canRead;

  private RemoteProcessGroupStatusDTO remoteProcessGroupStatus;

  public Boolean getCanRead() {
    return canRead;
  }

  public RemoteProcessGroupStatusEntityBuilder setCanRead(final Boolean canRead) {
    this.canRead = canRead;
    return this;
  }

  public RemoteProcessGroupStatusDTO getRemoteProcessGroupStatus() {
    return remoteProcessGroupStatus;
  }

  public RemoteProcessGroupStatusEntityBuilder setRemoteProcessGroupStatus(final RemoteProcessGroupStatusDTO remoteProcessGroupStatus) {
    this.remoteProcessGroupStatus = remoteProcessGroupStatus;
    return this;
  }

  public RemoteProcessGroupStatusEntity build() {
    final RemoteProcessGroupStatusEntity remoteProcessGroupStatusEntity = new RemoteProcessGroupStatusEntity();
    super.setPropertyValues(remoteProcessGroupStatusEntity);
    remoteProcessGroupStatusEntity.setCanRead(canRead);
    remoteProcessGroupStatusEntity.setRemoteProcessGroupStatus(remoteProcessGroupStatus);
    return remoteProcessGroupStatusEntity;
  }

  public static RemoteProcessGroupStatusEntityBuilder of(final RemoteProcessGroupStatusEntity remoteProcessGroupStatusEntity) {
    final RemoteProcessGroupStatusEntityBuilder remoteProcessGroupStatusEntityBuilder = new RemoteProcessGroupStatusEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(remoteProcessGroupStatusEntityBuilder, remoteProcessGroupStatusEntity);
    remoteProcessGroupStatusEntityBuilder.setCanRead(remoteProcessGroupStatusEntity.getCanRead());
    remoteProcessGroupStatusEntityBuilder.setRemoteProcessGroupStatus(remoteProcessGroupStatusEntity.getRemoteProcessGroupStatus());
    return remoteProcessGroupStatusEntityBuilder;
  }
}
