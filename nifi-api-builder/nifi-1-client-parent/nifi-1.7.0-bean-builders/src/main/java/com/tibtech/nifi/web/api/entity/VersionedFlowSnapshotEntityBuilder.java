package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import java.lang.String;
import org.apache.nifi.web.api.dto.RevisionDTO;
import org.apache.nifi.web.api.entity.VersionedFlowSnapshotEntity;

public final class VersionedFlowSnapshotEntityBuilder extends AbstractEntityBuilder<VersionedFlowSnapshotEntityBuilder> {
  private Boolean disconnectedNodeAcknowledged;

  private RevisionDTO processGroupRevision;

  private String registryId;

  private Boolean updateDescendantVersionedFlows;

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  public Boolean getDisconnectedNodeAcknowledged() {
    return disconnectedNodeAcknowledged;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  public VersionedFlowSnapshotEntityBuilder setDisconnectedNodeAcknowledged(
      final Boolean disconnectedNodeAcknowledged) {
    this.disconnectedNodeAcknowledged = disconnectedNodeAcknowledged;
    return this;
  }

  /**
   * The Revision of the Process Group under Version Control
   */
  public RevisionDTO getProcessGroupRevision() {
    return processGroupRevision;
  }

  /**
   * The Revision of the Process Group under Version Control
   */
  public VersionedFlowSnapshotEntityBuilder setProcessGroupRevision(
      final RevisionDTO processGroupRevision) {
    this.processGroupRevision = processGroupRevision;
    return this;
  }

  /**
   * The ID of the Registry that this flow belongs to
   */
  public String getRegistryId() {
    return registryId;
  }

  /**
   * The ID of the Registry that this flow belongs to
   */
  public VersionedFlowSnapshotEntityBuilder setRegistryId(final String registryId) {
    this.registryId = registryId;
    return this;
  }

  /**
   * If the Process Group to be updated has a child or descendant Process Group that is also under Version Control, this specifies whether or not the contents of that child/descendant Process Group should be updated.
   */
  public Boolean getUpdateDescendantVersionedFlows() {
    return updateDescendantVersionedFlows;
  }

  /**
   * If the Process Group to be updated has a child or descendant Process Group that is also under Version Control, this specifies whether or not the contents of that child/descendant Process Group should be updated.
   */
  public VersionedFlowSnapshotEntityBuilder setUpdateDescendantVersionedFlows(
      final Boolean updateDescendantVersionedFlows) {
    this.updateDescendantVersionedFlows = updateDescendantVersionedFlows;
    return this;
  }

  public VersionedFlowSnapshotEntity build() {
    final VersionedFlowSnapshotEntity versionedFlowSnapshotEntity = new VersionedFlowSnapshotEntity();
    super.setPropertyValues(versionedFlowSnapshotEntity);
    versionedFlowSnapshotEntity.setDisconnectedNodeAcknowledged(disconnectedNodeAcknowledged);
    versionedFlowSnapshotEntity.setProcessGroupRevision(processGroupRevision);
    versionedFlowSnapshotEntity.setRegistryId(registryId);
    versionedFlowSnapshotEntity.setUpdateDescendantVersionedFlows(updateDescendantVersionedFlows);
    return versionedFlowSnapshotEntity;
  }

  public static VersionedFlowSnapshotEntityBuilder of(
      final VersionedFlowSnapshotEntity versionedFlowSnapshotEntity) {
    final VersionedFlowSnapshotEntityBuilder versionedFlowSnapshotEntityBuilder = new VersionedFlowSnapshotEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(versionedFlowSnapshotEntityBuilder, versionedFlowSnapshotEntity);
    versionedFlowSnapshotEntityBuilder.setDisconnectedNodeAcknowledged(versionedFlowSnapshotEntity.isDisconnectedNodeAcknowledged());
    versionedFlowSnapshotEntityBuilder.setProcessGroupRevision(versionedFlowSnapshotEntity.getProcessGroupRevision());
    versionedFlowSnapshotEntityBuilder.setRegistryId(versionedFlowSnapshotEntity.getRegistryId());
    versionedFlowSnapshotEntityBuilder.setUpdateDescendantVersionedFlows(versionedFlowSnapshotEntity.getUpdateDescendantVersionedFlows());
    return versionedFlowSnapshotEntityBuilder;
  }
}
