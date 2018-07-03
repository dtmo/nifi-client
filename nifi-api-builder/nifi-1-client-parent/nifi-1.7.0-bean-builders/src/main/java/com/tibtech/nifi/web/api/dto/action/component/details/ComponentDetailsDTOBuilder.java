package com.tibtech.nifi.web.api.dto.action.component.details;

import org.apache.nifi.web.api.dto.action.component.details.ComponentDetailsDTO;

public final class ComponentDetailsDTOBuilder extends AbstractComponentDetailsDTOBuilder<ComponentDetailsDTOBuilder> {
  public ComponentDetailsDTO build() {
    final ComponentDetailsDTO componentDetailsDTO = new ComponentDetailsDTO();
    super.setPropertyValues(componentDetailsDTO);
    return componentDetailsDTO;
  }

  public static ComponentDetailsDTOBuilder of(final ComponentDetailsDTO componentDetailsDTO) {
    final ComponentDetailsDTOBuilder componentDetailsDTOBuilder = new ComponentDetailsDTOBuilder();
    AbstractComponentDetailsDTOBuilder.setBuilderValues(componentDetailsDTOBuilder, componentDetailsDTO);
    return componentDetailsDTOBuilder;
  }
}
