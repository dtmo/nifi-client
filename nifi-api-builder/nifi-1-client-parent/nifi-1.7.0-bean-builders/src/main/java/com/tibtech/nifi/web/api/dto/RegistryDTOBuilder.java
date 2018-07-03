package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import org.apache.nifi.web.api.dto.RegistryDTO;

public final class RegistryDTOBuilder {
  private String description;

  private String id;

  private String name;

  private String uri;

  /**
   * The registry description
   */
  public String getDescription() {
    return description;
  }

  /**
   * The registry description
   */
  public RegistryDTOBuilder setDescription(final String description) {
    this.description = description;
    return this;
  }

  /**
   * The registry identifier
   */
  public String getId() {
    return id;
  }

  /**
   * The registry identifier
   */
  public RegistryDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The registry name
   */
  public String getName() {
    return name;
  }

  /**
   * The registry name
   */
  public RegistryDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * The registry URI
   */
  public String getUri() {
    return uri;
  }

  /**
   * The registry URI
   */
  public RegistryDTOBuilder setUri(final String uri) {
    this.uri = uri;
    return this;
  }

  public RegistryDTO build() {
    final RegistryDTO registryDTO = new RegistryDTO();
    registryDTO.setDescription(description);
    registryDTO.setId(id);
    registryDTO.setName(name);
    registryDTO.setUri(uri);
    return registryDTO;
  }

  public static RegistryDTOBuilder of(final RegistryDTO registryDTO) {
    final RegistryDTOBuilder registryDTOBuilder = new RegistryDTOBuilder();
    registryDTOBuilder.setDescription(registryDTO.getDescription());
    registryDTOBuilder.setId(registryDTO.getId());
    registryDTOBuilder.setName(registryDTO.getName());
    registryDTOBuilder.setUri(registryDTO.getUri());
    return registryDTOBuilder;
  }
}
