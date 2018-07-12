package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.AffectedComponentDTO;
import org.apache.nifi.web.api.entity.AffectedComponentEntity;

public final class AffectedComponentEntityBuilder extends AbstractComponentEntityBuilder<AffectedComponentEntityBuilder> {
  private AffectedComponentDTO component;

  public AffectedComponentDTO getComponent() {
    return component;
  }

  public AffectedComponentEntityBuilder setComponent(final AffectedComponentDTO component) {
    this.component = component;
    return this;
  }

  public AffectedComponentEntity build() {
    final AffectedComponentEntity affectedComponentEntity = new AffectedComponentEntity();
    super.setPropertyValues(affectedComponentEntity);
    affectedComponentEntity.setComponent(component);
    return affectedComponentEntity;
  }

  public static AffectedComponentEntityBuilder of(
      final AffectedComponentEntity affectedComponentEntity) {
    final AffectedComponentEntityBuilder affectedComponentEntityBuilder = new AffectedComponentEntityBuilder();
    AbstractComponentEntityBuilder.setBuilderValues(affectedComponentEntityBuilder, affectedComponentEntity);
    affectedComponentEntityBuilder.setComponent(affectedComponentEntity.getComponent());
    return affectedComponentEntityBuilder;
  }
}
