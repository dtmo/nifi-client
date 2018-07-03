package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.TenantDTO;
import org.apache.nifi.web.api.entity.TenantEntity;

public final class TenantEntityBuilder extends AbstractComponentEntityBuilder<TenantEntityBuilder> {
  private TenantDTO component;

  public TenantDTO getComponent() {
    return component;
  }

  public TenantEntityBuilder setComponent(final TenantDTO component) {
    this.component = component;
    return this;
  }

  public TenantEntity build() {
    final TenantEntity tenantEntity = new TenantEntity();
    super.setPropertyValues(tenantEntity);
    tenantEntity.setComponent(component);
    return tenantEntity;
  }

  public static TenantEntityBuilder of(final TenantEntity tenantEntity) {
    final TenantEntityBuilder tenantEntityBuilder = new TenantEntityBuilder();
    AbstractComponentEntityBuilder.setBuilderValues(tenantEntityBuilder, tenantEntity);
    tenantEntityBuilder.setComponent(tenantEntity.getComponent());
    return tenantEntityBuilder;
  }
}
