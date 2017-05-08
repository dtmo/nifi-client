package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import java.util.Date;
import org.apache.nifi.web.api.dto.NodeEventDTO;

public final class NodeEventDTOBuilder {
  private String category;

  private String message;

  private Date timestamp;

  /**
   * The category of the node event.
   */
  public String getCategory() {
    return category;
  }

  /**
   * The category of the node event.
   */
  public NodeEventDTOBuilder setCategory(final String category) {
    this.category = category;
    return this;
  }

  /**
   * The message in the node event.
   */
  public String getMessage() {
    return message;
  }

  /**
   * The message in the node event.
   */
  public NodeEventDTOBuilder setMessage(final String message) {
    this.message = message;
    return this;
  }

  /**
   * The timestamp of the node event.
   */
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * The timestamp of the node event.
   */
  public NodeEventDTOBuilder setTimestamp(final Date timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  public NodeEventDTO build() {
    final NodeEventDTO nodeEventDTO = new NodeEventDTO();
    nodeEventDTO.setCategory(category);
    nodeEventDTO.setMessage(message);
    nodeEventDTO.setTimestamp(timestamp);
    return nodeEventDTO;
  }

  public static NodeEventDTOBuilder of(final NodeEventDTO nodeEventDTO) {
    final NodeEventDTOBuilder nodeEventDTOBuilder = new NodeEventDTOBuilder();
    nodeEventDTOBuilder.setCategory(nodeEventDTO.getCategory());
    nodeEventDTOBuilder.setMessage(nodeEventDTO.getMessage());
    nodeEventDTOBuilder.setTimestamp(nodeEventDTO.getTimestamp());
    return nodeEventDTOBuilder;
  }
}
