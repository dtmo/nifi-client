package com.tibtech.nifi.web.api.dto;

import java.util.List;
import org.apache.nifi.web.api.dto.PreviousValueDTO;
import org.apache.nifi.web.api.dto.PropertyHistoryDTO;

public final class PropertyHistoryDTOBuilder {
  private List<PreviousValueDTO> previousValues;

  /**
   * Previous values for a given property.
   */
  public List<PreviousValueDTO> getPreviousValues() {
    return previousValues;
  }

  /**
   * Previous values for a given property.
   */
  public PropertyHistoryDTOBuilder setPreviousValues(final List<PreviousValueDTO> previousValues) {
    this.previousValues = previousValues;
    return this;
  }

  public PropertyHistoryDTO build() {
    final PropertyHistoryDTO propertyHistoryDTO = new PropertyHistoryDTO();
    propertyHistoryDTO.setPreviousValues(previousValues);
    return propertyHistoryDTO;
  }

  public static PropertyHistoryDTOBuilder of(final PropertyHistoryDTO propertyHistoryDTO) {
    final PropertyHistoryDTOBuilder propertyHistoryDTOBuilder = new PropertyHistoryDTOBuilder();
    propertyHistoryDTOBuilder.setPreviousValues(propertyHistoryDTO.getPreviousValues());
    return propertyHistoryDTOBuilder;
  }
}
