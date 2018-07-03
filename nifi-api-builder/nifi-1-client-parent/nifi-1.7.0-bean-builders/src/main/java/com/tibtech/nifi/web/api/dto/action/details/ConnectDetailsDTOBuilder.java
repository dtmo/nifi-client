package com.tibtech.nifi.web.api.dto.action.details;

import java.lang.String;
import org.apache.nifi.web.api.dto.action.details.ConnectDetailsDTO;

public final class ConnectDetailsDTOBuilder extends AbstractActionDetailsDTOBuilder<ConnectDetailsDTOBuilder> {
  private String destinationId;

  private String destinationName;

  private String destinationType;

  private String relationship;

  private String sourceId;

  private String sourceName;

  private String sourceType;

  /**
   * The id of the destination of the connection.
   */
  public String getDestinationId() {
    return destinationId;
  }

  /**
   * The id of the destination of the connection.
   */
  public ConnectDetailsDTOBuilder setDestinationId(final String destinationId) {
    this.destinationId = destinationId;
    return this;
  }

  /**
   * The name of the destination of the connection.
   */
  public String getDestinationName() {
    return destinationName;
  }

  /**
   * The name of the destination of the connection.
   */
  public ConnectDetailsDTOBuilder setDestinationName(final String destinationName) {
    this.destinationName = destinationName;
    return this;
  }

  /**
   * The type of the destination of the connection.
   */
  public String getDestinationType() {
    return destinationType;
  }

  /**
   * The type of the destination of the connection.
   */
  public ConnectDetailsDTOBuilder setDestinationType(final String destinationType) {
    this.destinationType = destinationType;
    return this;
  }

  /**
   * The name of the relationship that was connected.
   */
  public String getRelationship() {
    return relationship;
  }

  /**
   * The name of the relationship that was connected.
   */
  public ConnectDetailsDTOBuilder setRelationship(final String relationship) {
    this.relationship = relationship;
    return this;
  }

  /**
   * The id of the source of the connection.
   */
  public String getSourceId() {
    return sourceId;
  }

  /**
   * The id of the source of the connection.
   */
  public ConnectDetailsDTOBuilder setSourceId(final String sourceId) {
    this.sourceId = sourceId;
    return this;
  }

  /**
   * The name of the source of the connection.
   */
  public String getSourceName() {
    return sourceName;
  }

  /**
   * The name of the source of the connection.
   */
  public ConnectDetailsDTOBuilder setSourceName(final String sourceName) {
    this.sourceName = sourceName;
    return this;
  }

  /**
   * The type of the source of the connection.
   */
  public String getSourceType() {
    return sourceType;
  }

  /**
   * The type of the source of the connection.
   */
  public ConnectDetailsDTOBuilder setSourceType(final String sourceType) {
    this.sourceType = sourceType;
    return this;
  }

  public ConnectDetailsDTO build() {
    final ConnectDetailsDTO connectDetailsDTO = new ConnectDetailsDTO();
    super.setPropertyValues(connectDetailsDTO);
    connectDetailsDTO.setDestinationId(destinationId);
    connectDetailsDTO.setDestinationName(destinationName);
    connectDetailsDTO.setDestinationType(destinationType);
    connectDetailsDTO.setRelationship(relationship);
    connectDetailsDTO.setSourceId(sourceId);
    connectDetailsDTO.setSourceName(sourceName);
    connectDetailsDTO.setSourceType(sourceType);
    return connectDetailsDTO;
  }

  public static ConnectDetailsDTOBuilder of(final ConnectDetailsDTO connectDetailsDTO) {
    final ConnectDetailsDTOBuilder connectDetailsDTOBuilder = new ConnectDetailsDTOBuilder();
    AbstractActionDetailsDTOBuilder.setBuilderValues(connectDetailsDTOBuilder, connectDetailsDTO);
    connectDetailsDTOBuilder.setDestinationId(connectDetailsDTO.getDestinationId());
    connectDetailsDTOBuilder.setDestinationName(connectDetailsDTO.getDestinationName());
    connectDetailsDTOBuilder.setDestinationType(connectDetailsDTO.getDestinationType());
    connectDetailsDTOBuilder.setRelationship(connectDetailsDTO.getRelationship());
    connectDetailsDTOBuilder.setSourceId(connectDetailsDTO.getSourceId());
    connectDetailsDTOBuilder.setSourceName(connectDetailsDTO.getSourceName());
    connectDetailsDTOBuilder.setSourceType(connectDetailsDTO.getSourceType());
    return connectDetailsDTOBuilder;
  }
}
