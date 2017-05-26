package com.tibtech.nifi.web.api.dto;

import org.apache.nifi.web.api.dto.FunnelDTO;

public final class FunnelDTOBuilder extends AbstractComponentDTOBuilder<FunnelDTOBuilder> {
  public FunnelDTO build() {
    final FunnelDTO funnelDTO = new FunnelDTO();
    super.setPropertyValues(funnelDTO);
    return funnelDTO;
  }

  public static FunnelDTOBuilder of(final FunnelDTO funnelDTO) {
    final FunnelDTOBuilder funnelDTOBuilder = new FunnelDTOBuilder();
    AbstractComponentDTOBuilder.setBuilderValues(funnelDTOBuilder, funnelDTO);
    return funnelDTOBuilder;
  }
}
