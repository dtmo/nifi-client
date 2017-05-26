package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.FunnelDTO;
import org.apache.nifi.web.api.entity.FunnelEntity;

public final class FunnelEntityBuilder extends AbstractComponentEntityBuilder<FunnelEntityBuilder> {
  private FunnelDTO component;

  public FunnelDTO getComponent() {
    return component;
  }

  public FunnelEntityBuilder setComponent(final FunnelDTO component) {
    this.component = component;
    return this;
  }

  public FunnelEntity build() {
    final FunnelEntity funnelEntity = new FunnelEntity();
    super.setPropertyValues(funnelEntity);
    funnelEntity.setComponent(component);
    return funnelEntity;
  }

  public static FunnelEntityBuilder of(final FunnelEntity funnelEntity) {
    final FunnelEntityBuilder funnelEntityBuilder = new FunnelEntityBuilder();
    AbstractComponentEntityBuilder.setBuilderValues(funnelEntityBuilder, funnelEntity);
    funnelEntityBuilder.setComponent(funnelEntity.getComponent());
    return funnelEntityBuilder;
  }
}
