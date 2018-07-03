package com.tibtech.nifi.web.api.entity;

import java.util.Set;
import org.apache.nifi.web.api.entity.VersionedFlowSnapshotMetadataEntity;
import org.apache.nifi.web.api.entity.VersionedFlowSnapshotMetadataSetEntity;

public final class VersionedFlowSnapshotMetadataSetEntityBuilder extends AbstractEntityBuilder<VersionedFlowSnapshotMetadataSetEntityBuilder> {
  private Set<VersionedFlowSnapshotMetadataEntity> versionedFlowSnapshotMetadataSet;

  public Set<VersionedFlowSnapshotMetadataEntity> getVersionedFlowSnapshotMetadataSet() {
    return versionedFlowSnapshotMetadataSet;
  }

  public VersionedFlowSnapshotMetadataSetEntityBuilder setVersionedFlowSnapshotMetadataSet(final Set<VersionedFlowSnapshotMetadataEntity> versionedFlowSnapshotMetadataSet) {
    this.versionedFlowSnapshotMetadataSet = versionedFlowSnapshotMetadataSet;
    return this;
  }

  public VersionedFlowSnapshotMetadataSetEntity build() {
    final VersionedFlowSnapshotMetadataSetEntity versionedFlowSnapshotMetadataSetEntity = new VersionedFlowSnapshotMetadataSetEntity();
    super.setPropertyValues(versionedFlowSnapshotMetadataSetEntity);
    versionedFlowSnapshotMetadataSetEntity.setVersionedFlowSnapshotMetadataSet(versionedFlowSnapshotMetadataSet);
    return versionedFlowSnapshotMetadataSetEntity;
  }

  public static VersionedFlowSnapshotMetadataSetEntityBuilder of(final VersionedFlowSnapshotMetadataSetEntity versionedFlowSnapshotMetadataSetEntity) {
    final VersionedFlowSnapshotMetadataSetEntityBuilder versionedFlowSnapshotMetadataSetEntityBuilder = new VersionedFlowSnapshotMetadataSetEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(versionedFlowSnapshotMetadataSetEntityBuilder, versionedFlowSnapshotMetadataSetEntity);
    versionedFlowSnapshotMetadataSetEntityBuilder.setVersionedFlowSnapshotMetadataSet(versionedFlowSnapshotMetadataSetEntity.getVersionedFlowSnapshotMetadataSet());
    return versionedFlowSnapshotMetadataSetEntityBuilder;
  }
}
