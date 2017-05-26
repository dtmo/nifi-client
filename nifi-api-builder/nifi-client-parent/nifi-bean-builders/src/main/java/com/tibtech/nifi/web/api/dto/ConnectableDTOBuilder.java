package com.tibtech.nifi.web.api.dto;

import java.lang.Boolean;
import java.lang.String;
import org.apache.nifi.web.api.dto.ConnectableDTO;

public final class ConnectableDTOBuilder {
  private String comments;

  private Boolean exists;

  private String groupId;

  private String id;

  private String name;

  private Boolean running;

  private Boolean transmitting;

  private String type;

  /**
   * The comments for the connectable component.
   */
  public String getComments() {
    return comments;
  }

  /**
   * The comments for the connectable component.
   */
  public ConnectableDTOBuilder setComments(final String comments) {
    this.comments = comments;
    return this;
  }

  /**
   * If the connectable component represents a remote port, indicates if the target exists.
   */
  public Boolean getExists() {
    return exists;
  }

  /**
   * If the connectable component represents a remote port, indicates if the target exists.
   */
  public ConnectableDTOBuilder setExists(final Boolean exists) {
    this.exists = exists;
    return this;
  }

  /**
   * The id of the group that the connectable component resides in
   */
  public String getGroupId() {
    return groupId;
  }

  /**
   * The id of the group that the connectable component resides in
   */
  public ConnectableDTOBuilder setGroupId(final String groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * The id of the connectable component.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the connectable component.
   */
  public ConnectableDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The name of the connectable component
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the connectable component
   */
  public ConnectableDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * Reflects the current state of the connectable component.
   */
  public Boolean getRunning() {
    return running;
  }

  /**
   * Reflects the current state of the connectable component.
   */
  public ConnectableDTOBuilder setRunning(final Boolean running) {
    this.running = running;
    return this;
  }

  /**
   * If the connectable component represents a remote port, indicates if the target is configured to transmit.
   */
  public Boolean getTransmitting() {
    return transmitting;
  }

  /**
   * If the connectable component represents a remote port, indicates if the target is configured to transmit.
   */
  public ConnectableDTOBuilder setTransmitting(final Boolean transmitting) {
    this.transmitting = transmitting;
    return this;
  }

  /**
   * The type of component the connectable is.
   */
  public String getType() {
    return type;
  }

  /**
   * The type of component the connectable is.
   */
  public ConnectableDTOBuilder setType(final String type) {
    this.type = type;
    return this;
  }

  public ConnectableDTO build() {
    final ConnectableDTO connectableDTO = new ConnectableDTO();
    connectableDTO.setComments(comments);
    connectableDTO.setExists(exists);
    connectableDTO.setGroupId(groupId);
    connectableDTO.setId(id);
    connectableDTO.setName(name);
    connectableDTO.setRunning(running);
    connectableDTO.setTransmitting(transmitting);
    connectableDTO.setType(type);
    return connectableDTO;
  }

  public static ConnectableDTOBuilder of(final ConnectableDTO connectableDTO) {
    final ConnectableDTOBuilder connectableDTOBuilder = new ConnectableDTOBuilder();
    connectableDTOBuilder.setComments(connectableDTO.getComments());
    connectableDTOBuilder.setExists(connectableDTO.getExists());
    connectableDTOBuilder.setGroupId(connectableDTO.getGroupId());
    connectableDTOBuilder.setId(connectableDTO.getId());
    connectableDTOBuilder.setName(connectableDTO.getName());
    connectableDTOBuilder.setRunning(connectableDTO.isRunning());
    connectableDTOBuilder.setTransmitting(connectableDTO.getTransmitting());
    connectableDTOBuilder.setType(connectableDTO.getType());
    return connectableDTOBuilder;
  }
}
