package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.DropRequestDTO;
import org.apache.nifi.web.api.entity.DropRequestEntity;

public final class DropRequestEntityBuilder extends AbstractEntityBuilder<DropRequestEntityBuilder> {
  private DropRequestDTO dropRequest;

  public DropRequestDTO getDropRequest() {
    return dropRequest;
  }

  public DropRequestEntityBuilder setDropRequest(final DropRequestDTO dropRequest) {
    this.dropRequest = dropRequest;
    return this;
  }

  public DropRequestEntity build() {
    final DropRequestEntity dropRequestEntity = new DropRequestEntity();
    super.setPropertyValues(dropRequestEntity);
    dropRequestEntity.setDropRequest(dropRequest);
    return dropRequestEntity;
  }

  public static DropRequestEntityBuilder of(final DropRequestEntity dropRequestEntity) {
    final DropRequestEntityBuilder dropRequestEntityBuilder = new DropRequestEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(dropRequestEntityBuilder, dropRequestEntity);
    dropRequestEntityBuilder.setDropRequest(dropRequestEntity.getDropRequest());
    return dropRequestEntityBuilder;
  }
}
