package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.RemoteProcessGroupPortDTO;
import org.apache.nifi.web.api.entity.RemoteProcessGroupPortEntity;

public final class RemoteProcessGroupPortEntityBuilder extends AbstractComponentEntityBuilder<RemoteProcessGroupPortEntityBuilder> {
  private RemoteProcessGroupPortDTO remoteProcessGroupPort;

  public RemoteProcessGroupPortDTO getRemoteProcessGroupPort() {
    return remoteProcessGroupPort;
  }

  public RemoteProcessGroupPortEntityBuilder setRemoteProcessGroupPort(final RemoteProcessGroupPortDTO remoteProcessGroupPort) {
    this.remoteProcessGroupPort = remoteProcessGroupPort;
    return this;
  }

  public RemoteProcessGroupPortEntity build() {
    final RemoteProcessGroupPortEntity remoteProcessGroupPortEntity = new RemoteProcessGroupPortEntity();
    super.setPropertyValues(remoteProcessGroupPortEntity);
    remoteProcessGroupPortEntity.setRemoteProcessGroupPort(remoteProcessGroupPort);
    return remoteProcessGroupPortEntity;
  }

  public static RemoteProcessGroupPortEntityBuilder of(final RemoteProcessGroupPortEntity remoteProcessGroupPortEntity) {
    final RemoteProcessGroupPortEntityBuilder remoteProcessGroupPortEntityBuilder = new RemoteProcessGroupPortEntityBuilder();
    AbstractComponentEntityBuilder.setBuilderValues(remoteProcessGroupPortEntityBuilder, remoteProcessGroupPortEntity);
    remoteProcessGroupPortEntityBuilder.setRemoteProcessGroupPort(remoteProcessGroupPortEntity.getRemoteProcessGroupPort());
    return remoteProcessGroupPortEntityBuilder;
  }
}
