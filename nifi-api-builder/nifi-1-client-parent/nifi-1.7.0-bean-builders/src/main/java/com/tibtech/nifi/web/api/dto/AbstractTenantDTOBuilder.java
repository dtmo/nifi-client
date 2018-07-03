package com.tibtech.nifi.web.api.dto;

import java.lang.Boolean;
import java.lang.String;
import org.apache.nifi.web.api.dto.TenantDTO;

public abstract class AbstractTenantDTOBuilder<T extends AbstractTenantDTOBuilder<T>> extends AbstractComponentDTOBuilder<T> {
  private Boolean configurable;

  private String identity;

  /**
   * Whether this tenant is configurable.
   */
  public Boolean getConfigurable() {
    return configurable;
  }

  /**
   * Whether this tenant is configurable.
   */
  public T setConfigurable(final Boolean configurable) {
    this.configurable = configurable;
    return (T) this;
  }

  /**
   * The identity of the tenant.
   */
  public String getIdentity() {
    return identity;
  }

  /**
   * The identity of the tenant.
   */
  public T setIdentity(final String identity) {
    this.identity = identity;
    return (T) this;
  }

  protected void setPropertyValues(final TenantDTO tenantDTO) {
    super.setPropertyValues(tenantDTO);
    tenantDTO.setConfigurable(configurable);
    tenantDTO.setIdentity(identity);
  }

  protected static void setBuilderValues(final AbstractTenantDTOBuilder abstractTenantDTOBuilder,
      final TenantDTO tenantDTO) {
    AbstractComponentDTOBuilder.setBuilderValues(abstractTenantDTOBuilder, tenantDTO);
    abstractTenantDTOBuilder.setConfigurable(tenantDTO.getConfigurable());
    abstractTenantDTOBuilder.setIdentity(tenantDTO.getIdentity());
  }
}
