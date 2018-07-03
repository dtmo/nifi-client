package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import org.apache.nifi.web.api.dto.RequiredPermissionDTO;

public final class RequiredPermissionDTOBuilder {
  private String id;

  private String label;

  /**
   * The required sub-permission necessary for this restriction.
   */
  public String getId() {
    return id;
  }

  /**
   * The required sub-permission necessary for this restriction.
   */
  public RequiredPermissionDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The label for the required sub-permission necessary for this restriction.
   */
  public String getLabel() {
    return label;
  }

  /**
   * The label for the required sub-permission necessary for this restriction.
   */
  public RequiredPermissionDTOBuilder setLabel(final String label) {
    this.label = label;
    return this;
  }

  public RequiredPermissionDTO build() {
    final RequiredPermissionDTO requiredPermissionDTO = new RequiredPermissionDTO();
    requiredPermissionDTO.setId(id);
    requiredPermissionDTO.setLabel(label);
    return requiredPermissionDTO;
  }

  public static RequiredPermissionDTOBuilder of(final RequiredPermissionDTO requiredPermissionDTO) {
    final RequiredPermissionDTOBuilder requiredPermissionDTOBuilder = new RequiredPermissionDTOBuilder();
    requiredPermissionDTOBuilder.setId(requiredPermissionDTO.getId());
    requiredPermissionDTOBuilder.setLabel(requiredPermissionDTO.getLabel());
    return requiredPermissionDTOBuilder;
  }
}
