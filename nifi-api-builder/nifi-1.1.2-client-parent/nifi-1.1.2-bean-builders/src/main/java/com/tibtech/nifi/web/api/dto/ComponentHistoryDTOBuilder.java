package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import java.util.Map;
import org.apache.nifi.web.api.dto.ComponentHistoryDTO;
import org.apache.nifi.web.api.dto.PropertyHistoryDTO;

public final class ComponentHistoryDTOBuilder {
  private String componentId;

  private Map<String, PropertyHistoryDTO> propertyHistory;

  /**
   * The component id.
   */
  public String getComponentId() {
    return componentId;
  }

  /**
   * The component id.
   */
  public ComponentHistoryDTOBuilder setComponentId(final String componentId) {
    this.componentId = componentId;
    return this;
  }

  /**
   * The history for the properties of the component.
   */
  public Map<String, PropertyHistoryDTO> getPropertyHistory() {
    return propertyHistory;
  }

  /**
   * The history for the properties of the component.
   */
  public ComponentHistoryDTOBuilder setPropertyHistory(final Map<String, PropertyHistoryDTO> propertyHistory) {
    this.propertyHistory = propertyHistory;
    return this;
  }

  public ComponentHistoryDTO build() {
    final ComponentHistoryDTO componentHistoryDTO = new ComponentHistoryDTO();
    componentHistoryDTO.setComponentId(componentId);
    componentHistoryDTO.setPropertyHistory(propertyHistory);
    return componentHistoryDTO;
  }

  public static ComponentHistoryDTOBuilder of(final ComponentHistoryDTO componentHistoryDTO) {
    final ComponentHistoryDTOBuilder componentHistoryDTOBuilder = new ComponentHistoryDTOBuilder();
    componentHistoryDTOBuilder.setComponentId(componentHistoryDTO.getComponentId());
    componentHistoryDTOBuilder.setPropertyHistory(componentHistoryDTO.getPropertyHistory());
    return componentHistoryDTOBuilder;
  }
}
