package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import java.util.Set;
import org.apache.nifi.web.api.dto.DocumentedTypeDTO;

public final class DocumentedTypeDTOBuilder {
  private String description;

  private Set<String> tags;

  private String type;

  private String usageRestriction;

  /**
   * The description of the type.
   */
  public String getDescription() {
    return description;
  }

  /**
   * The description of the type.
   */
  public DocumentedTypeDTOBuilder setDescription(final String description) {
    this.description = description;
    return this;
  }

  /**
   * The tags associated with this type.
   */
  public Set<String> getTags() {
    return tags;
  }

  /**
   * The tags associated with this type.
   */
  public DocumentedTypeDTOBuilder setTags(final Set<String> tags) {
    this.tags = tags;
    return this;
  }

  /**
   * The fully qualified name of the type.
   */
  public String getType() {
    return type;
  }

  /**
   * The fully qualified name of the type.
   */
  public DocumentedTypeDTOBuilder setType(final String type) {
    this.type = type;
    return this;
  }

  /**
   * The description of why the usage of this component is restricted.
   */
  public String getUsageRestriction() {
    return usageRestriction;
  }

  /**
   * The description of why the usage of this component is restricted.
   */
  public DocumentedTypeDTOBuilder setUsageRestriction(final String usageRestriction) {
    this.usageRestriction = usageRestriction;
    return this;
  }

  public DocumentedTypeDTO build() {
    final DocumentedTypeDTO documentedTypeDTO = new DocumentedTypeDTO();
    documentedTypeDTO.setDescription(description);
    documentedTypeDTO.setTags(tags);
    documentedTypeDTO.setType(type);
    documentedTypeDTO.setUsageRestriction(usageRestriction);
    return documentedTypeDTO;
  }

  public static DocumentedTypeDTOBuilder of(final DocumentedTypeDTO documentedTypeDTO) {
    final DocumentedTypeDTOBuilder documentedTypeDTOBuilder = new DocumentedTypeDTOBuilder();
    documentedTypeDTOBuilder.setDescription(documentedTypeDTO.getDescription());
    documentedTypeDTOBuilder.setTags(documentedTypeDTO.getTags());
    documentedTypeDTOBuilder.setType(documentedTypeDTO.getType());
    documentedTypeDTOBuilder.setUsageRestriction(documentedTypeDTO.getUsageRestriction());
    return documentedTypeDTOBuilder;
  }
}
