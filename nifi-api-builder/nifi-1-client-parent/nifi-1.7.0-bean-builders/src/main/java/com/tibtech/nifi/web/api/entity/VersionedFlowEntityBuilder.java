package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.VersionedFlowDTO;
import org.apache.nifi.web.api.entity.VersionedFlowEntity;

public final class VersionedFlowEntityBuilder extends AbstractEntityBuilder<VersionedFlowEntityBuilder> {
  private VersionedFlowDTO versionedFlow;

  /**
   * The versioned flow
   */
  public VersionedFlowDTO getVersionedFlow() {
    return versionedFlow;
  }

  /**
   * The versioned flow
   */
  public VersionedFlowEntityBuilder setVersionedFlow(final VersionedFlowDTO versionedFlow) {
    this.versionedFlow = versionedFlow;
    return this;
  }

  public VersionedFlowEntity build() {
    final VersionedFlowEntity versionedFlowEntity = new VersionedFlowEntity();
    super.setPropertyValues(versionedFlowEntity);
    versionedFlowEntity.setVersionedFlow(versionedFlow);
    return versionedFlowEntity;
  }

  public static VersionedFlowEntityBuilder of(final VersionedFlowEntity versionedFlowEntity) {
    final VersionedFlowEntityBuilder versionedFlowEntityBuilder = new VersionedFlowEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(versionedFlowEntityBuilder, versionedFlowEntity);
    versionedFlowEntityBuilder.setVersionedFlow(versionedFlowEntity.getVersionedFlow());
    return versionedFlowEntityBuilder;
  }
}
