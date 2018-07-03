package com.tibtech.nifi.web.api.entity;

import java.util.Set;
import org.apache.nifi.web.api.entity.FunnelEntity;
import org.apache.nifi.web.api.entity.FunnelsEntity;

public final class FunnelsEntityBuilder extends AbstractEntityBuilder<FunnelsEntityBuilder> {
  private Set<FunnelEntity> funnels;

  public Set<FunnelEntity> getFunnels() {
    return funnels;
  }

  public FunnelsEntityBuilder setFunnels(final Set<FunnelEntity> funnels) {
    this.funnels = funnels;
    return this;
  }

  public FunnelsEntity build() {
    final FunnelsEntity funnelsEntity = new FunnelsEntity();
    super.setPropertyValues(funnelsEntity);
    funnelsEntity.setFunnels(funnels);
    return funnelsEntity;
  }

  public static FunnelsEntityBuilder of(final FunnelsEntity funnelsEntity) {
    final FunnelsEntityBuilder funnelsEntityBuilder = new FunnelsEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(funnelsEntityBuilder, funnelsEntity);
    funnelsEntityBuilder.setFunnels(funnelsEntity.getFunnels());
    return funnelsEntityBuilder;
  }
}
