package com.tibtech.nifi.web.api.dto;

import java.lang.Boolean;
import java.lang.String;
import org.apache.nifi.web.api.dto.RelationshipDTO;

public final class RelationshipDTOBuilder {
  private Boolean autoTerminate;

  private String description;

  private String name;

  /**
   * Whether or not flowfiles sent to this relationship should auto terminate.
   */
  public Boolean getAutoTerminate() {
    return autoTerminate;
  }

  /**
   * Whether or not flowfiles sent to this relationship should auto terminate.
   */
  public RelationshipDTOBuilder setAutoTerminate(final Boolean autoTerminate) {
    this.autoTerminate = autoTerminate;
    return this;
  }

  /**
   * The relationship description.
   */
  public String getDescription() {
    return description;
  }

  /**
   * The relationship description.
   */
  public RelationshipDTOBuilder setDescription(final String description) {
    this.description = description;
    return this;
  }

  /**
   * The relationship name.
   */
  public String getName() {
    return name;
  }

  /**
   * The relationship name.
   */
  public RelationshipDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  public RelationshipDTO build() {
    final RelationshipDTO relationshipDTO = new RelationshipDTO();
    relationshipDTO.setAutoTerminate(autoTerminate);
    relationshipDTO.setDescription(description);
    relationshipDTO.setName(name);
    return relationshipDTO;
  }

  public static RelationshipDTOBuilder of(final RelationshipDTO relationshipDTO) {
    final RelationshipDTOBuilder relationshipDTOBuilder = new RelationshipDTOBuilder();
    relationshipDTOBuilder.setAutoTerminate(relationshipDTO.isAutoTerminate());
    relationshipDTOBuilder.setDescription(relationshipDTO.getDescription());
    relationshipDTOBuilder.setName(relationshipDTO.getName());
    return relationshipDTOBuilder;
  }
}
