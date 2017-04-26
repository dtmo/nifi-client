package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.AccessStatusDTO;
import org.apache.nifi.web.api.entity.AccessStatusEntity;

public final class AccessStatusEntityBuilder extends AbstractEntityBuilder<AccessStatusEntityBuilder> {
  private AccessStatusDTO accessStatus;

  public AccessStatusDTO getAccessStatus() {
    return accessStatus;
  }

  public AccessStatusEntityBuilder setAccessStatus(final AccessStatusDTO accessStatus) {
    this.accessStatus = accessStatus;
    return this;
  }

  public AccessStatusEntity build() {
    final AccessStatusEntity accessStatusEntity = new AccessStatusEntity();
    super.setPropertyValues(accessStatusEntity);
    accessStatusEntity.setAccessStatus(accessStatus);
    return accessStatusEntity;
  }

  public static AccessStatusEntityBuilder of(final AccessStatusEntity accessStatusEntity) {
    final AccessStatusEntityBuilder accessStatusEntityBuilder = new AccessStatusEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(accessStatusEntityBuilder, accessStatusEntity);
    accessStatusEntityBuilder.setAccessStatus(accessStatusEntity.getAccessStatus());
    return accessStatusEntityBuilder;
  }
}
