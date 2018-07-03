package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import org.apache.nifi.web.api.dto.TenantDTO;

public final class TenantDTOBuilder extends AbstractTenantDTOBuilder<TenantDTOBuilder> {
  private String identity;

  /**
   * The identity of the tenant.
   */
  public String getIdentity() {
    return identity;
  }

  /**
   * The identity of the tenant.
   */
  public TenantDTOBuilder setIdentity(final String identity) {
    this.identity = identity;
    return this;
  }

  public TenantDTO build() {
    final TenantDTO tenantDTO = new TenantDTO();
    super.setPropertyValues(tenantDTO);
    tenantDTO.setIdentity(identity);
    return tenantDTO;
  }

  public static TenantDTOBuilder of(final TenantDTO tenantDTO) {
    final TenantDTOBuilder tenantDTOBuilder = new TenantDTOBuilder();
    AbstractTenantDTOBuilder.setBuilderValues(tenantDTOBuilder, tenantDTO);
    tenantDTOBuilder.setIdentity(tenantDTO.getIdentity());
    return tenantDTOBuilder;
  }
}
