package com.tibtech.nifi.web.api.entity;

import java.util.Set;
import org.apache.nifi.web.api.entity.VersionedFlowEntity;
import org.apache.nifi.web.api.entity.VersionedFlowsEntity;

public final class VersionedFlowsEntityBuilder extends AbstractEntityBuilder<VersionedFlowsEntityBuilder> {
  private Set<VersionedFlowEntity> versionedFlows;

  public Set<VersionedFlowEntity> getVersionedFlows() {
    return versionedFlows;
  }

  public VersionedFlowsEntityBuilder setVersionedFlows(final Set<VersionedFlowEntity> versionedFlows) {
    this.versionedFlows = versionedFlows;
    return this;
  }

  public VersionedFlowsEntity build() {
    final VersionedFlowsEntity versionedFlowsEntity = new VersionedFlowsEntity();
    super.setPropertyValues(versionedFlowsEntity);
    versionedFlowsEntity.setVersionedFlows(versionedFlows);
    return versionedFlowsEntity;
  }

  public static VersionedFlowsEntityBuilder of(final VersionedFlowsEntity versionedFlowsEntity) {
    final VersionedFlowsEntityBuilder versionedFlowsEntityBuilder = new VersionedFlowsEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(versionedFlowsEntityBuilder, versionedFlowsEntity);
    versionedFlowsEntityBuilder.setVersionedFlows(versionedFlowsEntity.getVersionedFlows());
    return versionedFlowsEntityBuilder;
  }
}
