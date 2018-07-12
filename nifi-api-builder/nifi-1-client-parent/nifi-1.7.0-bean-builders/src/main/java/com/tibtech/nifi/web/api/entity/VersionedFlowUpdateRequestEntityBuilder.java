package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.RevisionDTO;
import org.apache.nifi.web.api.dto.VersionedFlowUpdateRequestDTO;
import org.apache.nifi.web.api.entity.VersionedFlowUpdateRequestEntity;

public final class VersionedFlowUpdateRequestEntityBuilder extends AbstractEntityBuilder<VersionedFlowUpdateRequestEntityBuilder> {
  private RevisionDTO processGroupRevision;

  private VersionedFlowUpdateRequestDTO request;

  /**
   * The revision for the Process Group that owns this variable registry.
   */
  public RevisionDTO getProcessGroupRevision() {
    return processGroupRevision;
  }

  /**
   * The revision for the Process Group that owns this variable registry.
   */
  public VersionedFlowUpdateRequestEntityBuilder setProcessGroupRevision(
      final RevisionDTO processGroupRevision) {
    this.processGroupRevision = processGroupRevision;
    return this;
  }

  /**
   * The Versioned Flow Update Request
   */
  public VersionedFlowUpdateRequestDTO getRequest() {
    return request;
  }

  /**
   * The Versioned Flow Update Request
   */
  public VersionedFlowUpdateRequestEntityBuilder setRequest(
      final VersionedFlowUpdateRequestDTO request) {
    this.request = request;
    return this;
  }

  public VersionedFlowUpdateRequestEntity build() {
    final VersionedFlowUpdateRequestEntity versionedFlowUpdateRequestEntity = new VersionedFlowUpdateRequestEntity();
    super.setPropertyValues(versionedFlowUpdateRequestEntity);
    versionedFlowUpdateRequestEntity.setProcessGroupRevision(processGroupRevision);
    versionedFlowUpdateRequestEntity.setRequest(request);
    return versionedFlowUpdateRequestEntity;
  }

  public static VersionedFlowUpdateRequestEntityBuilder of(
      final VersionedFlowUpdateRequestEntity versionedFlowUpdateRequestEntity) {
    final VersionedFlowUpdateRequestEntityBuilder versionedFlowUpdateRequestEntityBuilder = new VersionedFlowUpdateRequestEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(versionedFlowUpdateRequestEntityBuilder, versionedFlowUpdateRequestEntity);
    versionedFlowUpdateRequestEntityBuilder.setProcessGroupRevision(versionedFlowUpdateRequestEntity.getProcessGroupRevision());
    versionedFlowUpdateRequestEntityBuilder.setRequest(versionedFlowUpdateRequestEntity.getRequest());
    return versionedFlowUpdateRequestEntityBuilder;
  }
}
