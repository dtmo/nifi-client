package com.tibtech.nifi.web.api.dto;

import java.lang.Double;
import org.apache.nifi.web.api.dto.PositionDTO;

public final class PositionDTOBuilder {
  private Double x;

  private Double y;

  /**
   * The x coordinate.
   */
  public Double getX() {
    return x;
  }

  /**
   * The x coordinate.
   */
  public PositionDTOBuilder setX(final Double x) {
    this.x = x;
    return this;
  }

  /**
   * The y coordinate.
   */
  public Double getY() {
    return y;
  }

  /**
   * The y coordinate.
   */
  public PositionDTOBuilder setY(final Double y) {
    this.y = y;
    return this;
  }

  public PositionDTO build() {
    final PositionDTO positionDTO = new PositionDTO();
    positionDTO.setX(x);
    positionDTO.setY(y);
    return positionDTO;
  }

  public static PositionDTOBuilder of(final PositionDTO positionDTO) {
    final PositionDTOBuilder positionDTOBuilder = new PositionDTOBuilder();
    positionDTOBuilder.setX(positionDTO.getX());
    positionDTOBuilder.setY(positionDTO.getY());
    return positionDTOBuilder;
  }
}
