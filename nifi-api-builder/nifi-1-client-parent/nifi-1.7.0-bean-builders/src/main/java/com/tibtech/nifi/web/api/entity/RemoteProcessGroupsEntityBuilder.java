package com.tibtech.nifi.web.api.entity;

import java.util.Set;
import org.apache.nifi.web.api.entity.RemoteProcessGroupEntity;
import org.apache.nifi.web.api.entity.RemoteProcessGroupsEntity;

public final class RemoteProcessGroupsEntityBuilder extends AbstractEntityBuilder<RemoteProcessGroupsEntityBuilder> {
  private Set<RemoteProcessGroupEntity> remoteProcessGroups;

  public Set<RemoteProcessGroupEntity> getRemoteProcessGroups() {
    return remoteProcessGroups;
  }

  public RemoteProcessGroupsEntityBuilder setRemoteProcessGroups(
      final Set<RemoteProcessGroupEntity> remoteProcessGroups) {
    this.remoteProcessGroups = remoteProcessGroups;
    return this;
  }

  public RemoteProcessGroupsEntity build() {
    final RemoteProcessGroupsEntity remoteProcessGroupsEntity = new RemoteProcessGroupsEntity();
    super.setPropertyValues(remoteProcessGroupsEntity);
    remoteProcessGroupsEntity.setRemoteProcessGroups(remoteProcessGroups);
    return remoteProcessGroupsEntity;
  }

  public static RemoteProcessGroupsEntityBuilder of(
      final RemoteProcessGroupsEntity remoteProcessGroupsEntity) {
    final RemoteProcessGroupsEntityBuilder remoteProcessGroupsEntityBuilder = new RemoteProcessGroupsEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(remoteProcessGroupsEntityBuilder, remoteProcessGroupsEntity);
    remoteProcessGroupsEntityBuilder.setRemoteProcessGroups(remoteProcessGroupsEntity.getRemoteProcessGroups());
    return remoteProcessGroupsEntityBuilder;
  }
}
