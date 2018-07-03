package com.tibtech.nifi.web.api.dto;

import org.apache.nifi.web.api.dto.ComponentDTO;

public final class ComponentDTOBuilder extends AbstractComponentDTOBuilder<ComponentDTOBuilder> {
  public ComponentDTO build() {
    final ComponentDTO componentDTO = new ComponentDTO();
    super.setPropertyValues(componentDTO);
    return componentDTO;
  }

  public static ComponentDTOBuilder of(final ComponentDTO componentDTO) {
    final ComponentDTOBuilder componentDTOBuilder = new ComponentDTOBuilder();
    AbstractComponentDTOBuilder.setBuilderValues(componentDTOBuilder, componentDTO);
    return componentDTOBuilder;
  }
}
