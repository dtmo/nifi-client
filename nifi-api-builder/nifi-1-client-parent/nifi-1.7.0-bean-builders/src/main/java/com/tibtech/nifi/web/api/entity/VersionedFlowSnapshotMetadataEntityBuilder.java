package com.tibtech.nifi.web.api.entity;

import java.lang.String;
import org.apache.nifi.web.api.entity.VersionedFlowSnapshotMetadataEntity;

public final class VersionedFlowSnapshotMetadataEntityBuilder extends AbstractEntityBuilder<VersionedFlowSnapshotMetadataEntityBuilder> {
  private String registryId;

  /**
   * The ID of the Registry that this flow belongs to
   */
  public String getRegistryId() {
    return registryId;
  }

  /**
   * The ID of the Registry that this flow belongs to
   */
  public VersionedFlowSnapshotMetadataEntityBuilder setRegistryId(final String registryId) {
    this.registryId = registryId;
    return this;
  }

  public VersionedFlowSnapshotMetadataEntity build() {
    final VersionedFlowSnapshotMetadataEntity versionedFlowSnapshotMetadataEntity = new VersionedFlowSnapshotMetadataEntity();
    super.setPropertyValues(versionedFlowSnapshotMetadataEntity);
    versionedFlowSnapshotMetadataEntity.setRegistryId(registryId);
    return versionedFlowSnapshotMetadataEntity;
  }

  public static VersionedFlowSnapshotMetadataEntityBuilder of(final VersionedFlowSnapshotMetadataEntity versionedFlowSnapshotMetadataEntity) {
    final VersionedFlowSnapshotMetadataEntityBuilder versionedFlowSnapshotMetadataEntityBuilder = new VersionedFlowSnapshotMetadataEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(versionedFlowSnapshotMetadataEntityBuilder, versionedFlowSnapshotMetadataEntity);
    versionedFlowSnapshotMetadataEntityBuilder.setRegistryId(versionedFlowSnapshotMetadataEntity.getRegistryId());
    return versionedFlowSnapshotMetadataEntityBuilder;
  }
}
