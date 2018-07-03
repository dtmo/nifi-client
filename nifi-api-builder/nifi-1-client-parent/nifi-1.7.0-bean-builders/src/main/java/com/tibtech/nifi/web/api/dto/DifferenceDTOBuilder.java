package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import org.apache.nifi.web.api.dto.DifferenceDTO;

public final class DifferenceDTOBuilder {
  private String difference;

  private String differenceType;

  /**
   * Description of the difference
   */
  public String getDifference() {
    return difference;
  }

  /**
   * Description of the difference
   */
  public DifferenceDTOBuilder setDifference(final String difference) {
    this.difference = difference;
    return this;
  }

  /**
   * The type of difference
   */
  public String getDifferenceType() {
    return differenceType;
  }

  /**
   * The type of difference
   */
  public DifferenceDTOBuilder setDifferenceType(final String differenceType) {
    this.differenceType = differenceType;
    return this;
  }

  public DifferenceDTO build() {
    final DifferenceDTO differenceDTO = new DifferenceDTO();
    differenceDTO.setDifference(difference);
    differenceDTO.setDifferenceType(differenceType);
    return differenceDTO;
  }

  public static DifferenceDTOBuilder of(final DifferenceDTO differenceDTO) {
    final DifferenceDTOBuilder differenceDTOBuilder = new DifferenceDTOBuilder();
    differenceDTOBuilder.setDifference(differenceDTO.getDifference());
    differenceDTOBuilder.setDifferenceType(differenceDTO.getDifferenceType());
    return differenceDTOBuilder;
  }
}
