package com.tibtech.nifi.web.api.dto;

import java.lang.Double;
import org.apache.nifi.web.api.dto.DimensionsDTO;

public final class DimensionsDTOBuilder {
  private Double height;

  private Double width;

  /**
   * The height of the label in pixels when at a 1:1 scale.
   */
  public Double getHeight() {
    return height;
  }

  /**
   * The height of the label in pixels when at a 1:1 scale.
   */
  public DimensionsDTOBuilder setHeight(final Double height) {
    this.height = height;
    return this;
  }

  /**
   * The width of the label in pixels when at a 1:1 scale.
   */
  public Double getWidth() {
    return width;
  }

  /**
   * The width of the label in pixels when at a 1:1 scale.
   */
  public DimensionsDTOBuilder setWidth(final Double width) {
    this.width = width;
    return this;
  }

  public DimensionsDTO build() {
    final DimensionsDTO dimensionsDTO = new DimensionsDTO();
    dimensionsDTO.setHeight(height);
    dimensionsDTO.setWidth(width);
    return dimensionsDTO;
  }

  public static DimensionsDTOBuilder of(final DimensionsDTO dimensionsDTO) {
    final DimensionsDTOBuilder dimensionsDTOBuilder = new DimensionsDTOBuilder();
    dimensionsDTOBuilder.setHeight(dimensionsDTO.getHeight());
    dimensionsDTOBuilder.setWidth(dimensionsDTO.getWidth());
    return dimensionsDTOBuilder;
  }
}
