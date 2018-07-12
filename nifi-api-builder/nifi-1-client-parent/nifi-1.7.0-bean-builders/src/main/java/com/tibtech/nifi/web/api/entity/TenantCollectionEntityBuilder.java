package com.tibtech.nifi.web.api.entity;

import java.lang.String;
import java.util.Set;
import org.apache.nifi.web.api.entity.TenantCollectionEntity;

public final class TenantCollectionEntityBuilder extends AbstractComponentEntityBuilder<TenantCollectionEntityBuilder> {
  private Set<String> tenants;

  public Set<String> getTenants() {
    return tenants;
  }

  public TenantCollectionEntityBuilder setTenants(final Set<String> tenants) {
    this.tenants = tenants;
    return this;
  }

  public TenantCollectionEntity build() {
    final TenantCollectionEntity tenantCollectionEntity = new TenantCollectionEntity();
    super.setPropertyValues(tenantCollectionEntity);
    tenantCollectionEntity.setTenants(tenants);
    return tenantCollectionEntity;
  }

  public static TenantCollectionEntityBuilder of(
      final TenantCollectionEntity tenantCollectionEntity) {
    final TenantCollectionEntityBuilder tenantCollectionEntityBuilder = new TenantCollectionEntityBuilder();
    AbstractComponentEntityBuilder.setBuilderValues(tenantCollectionEntityBuilder, tenantCollectionEntity);
    tenantCollectionEntityBuilder.setTenants(tenantCollectionEntity.getTenants());
    return tenantCollectionEntityBuilder;
  }
}
