package com.tibtech.nifi.web.api.dto;

import org.apache.nifi.web.api.dto.TenantDTO;

public final class TenantDTOBuilder extends AbstractTenantDTOBuilder<TenantDTOBuilder> {
  public TenantDTO build() {
    final TenantDTO tenantDTO = new TenantDTO();
    super.setPropertyValues(tenantDTO);
    return tenantDTO;
  }

  public static TenantDTOBuilder of(final TenantDTO tenantDTO) {
    final TenantDTOBuilder tenantDTOBuilder = new TenantDTOBuilder();
    AbstractTenantDTOBuilder.setBuilderValues(tenantDTOBuilder, tenantDTO);
    return tenantDTOBuilder;
  }
}
