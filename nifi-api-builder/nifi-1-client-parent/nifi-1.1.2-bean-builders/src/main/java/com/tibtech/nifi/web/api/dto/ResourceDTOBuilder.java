package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import org.apache.nifi.web.api.dto.ResourceDTO;

public final class ResourceDTOBuilder {
  private String identifier;

  private String name;

  /**
   * The identifier of the resource.
   */
  public String getIdentifier() {
    return identifier;
  }

  /**
   * The identifier of the resource.
   */
  public ResourceDTOBuilder setIdentifier(final String identifier) {
    this.identifier = identifier;
    return this;
  }

  /**
   * The name of the resource.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the resource.
   */
  public ResourceDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  public ResourceDTO build() {
    final ResourceDTO resourceDTO = new ResourceDTO();
    resourceDTO.setIdentifier(identifier);
    resourceDTO.setName(name);
    return resourceDTO;
  }

  public static ResourceDTOBuilder of(final ResourceDTO resourceDTO) {
    final ResourceDTOBuilder resourceDTOBuilder = new ResourceDTOBuilder();
    resourceDTOBuilder.setIdentifier(resourceDTO.getIdentifier());
    resourceDTOBuilder.setName(resourceDTO.getName());
    return resourceDTOBuilder;
  }
}
