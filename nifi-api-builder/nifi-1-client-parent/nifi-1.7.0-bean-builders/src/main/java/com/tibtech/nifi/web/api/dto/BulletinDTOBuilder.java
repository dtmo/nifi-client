package com.tibtech.nifi.web.api.dto;

import java.lang.Long;
import java.lang.String;
import java.util.Date;
import org.apache.nifi.web.api.dto.BulletinDTO;

public final class BulletinDTOBuilder {
  private String category;

  private String groupId;

  private Long id;

  private String level;

  private String message;

  private String nodeAddress;

  private String sourceId;

  private String sourceName;

  private Date timestamp;

  /**
   * The category of this bulletin.
   */
  public String getCategory() {
    return category;
  }

  /**
   * The category of this bulletin.
   */
  public BulletinDTOBuilder setCategory(final String category) {
    this.category = category;
    return this;
  }

  /**
   * The group id of the source component.
   */
  public String getGroupId() {
    return groupId;
  }

  /**
   * The group id of the source component.
   */
  public BulletinDTOBuilder setGroupId(final String groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * The id of the bulletin.
   */
  public Long getId() {
    return id;
  }

  /**
   * The id of the bulletin.
   */
  public BulletinDTOBuilder setId(final Long id) {
    this.id = id;
    return this;
  }

  /**
   * The level of the bulletin.
   */
  public String getLevel() {
    return level;
  }

  /**
   * The level of the bulletin.
   */
  public BulletinDTOBuilder setLevel(final String level) {
    this.level = level;
    return this;
  }

  /**
   * The bulletin message.
   */
  public String getMessage() {
    return message;
  }

  /**
   * The bulletin message.
   */
  public BulletinDTOBuilder setMessage(final String message) {
    this.message = message;
    return this;
  }

  /**
   * If clustered, the address of the node from which the bulletin originated.
   */
  public String getNodeAddress() {
    return nodeAddress;
  }

  /**
   * If clustered, the address of the node from which the bulletin originated.
   */
  public BulletinDTOBuilder setNodeAddress(final String nodeAddress) {
    this.nodeAddress = nodeAddress;
    return this;
  }

  /**
   * The id of the source component.
   */
  public String getSourceId() {
    return sourceId;
  }

  /**
   * The id of the source component.
   */
  public BulletinDTOBuilder setSourceId(final String sourceId) {
    this.sourceId = sourceId;
    return this;
  }

  /**
   * The name of the source component.
   */
  public String getSourceName() {
    return sourceName;
  }

  /**
   * The name of the source component.
   */
  public BulletinDTOBuilder setSourceName(final String sourceName) {
    this.sourceName = sourceName;
    return this;
  }

  /**
   * When this bulletin was generated.
   */
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * When this bulletin was generated.
   */
  public BulletinDTOBuilder setTimestamp(final Date timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  public BulletinDTO build() {
    final BulletinDTO bulletinDTO = new BulletinDTO();
    bulletinDTO.setCategory(category);
    bulletinDTO.setGroupId(groupId);
    bulletinDTO.setId(id);
    bulletinDTO.setLevel(level);
    bulletinDTO.setMessage(message);
    bulletinDTO.setNodeAddress(nodeAddress);
    bulletinDTO.setSourceId(sourceId);
    bulletinDTO.setSourceName(sourceName);
    bulletinDTO.setTimestamp(timestamp);
    return bulletinDTO;
  }

  public static BulletinDTOBuilder of(final BulletinDTO bulletinDTO) {
    final BulletinDTOBuilder bulletinDTOBuilder = new BulletinDTOBuilder();
    bulletinDTOBuilder.setCategory(bulletinDTO.getCategory());
    bulletinDTOBuilder.setGroupId(bulletinDTO.getGroupId());
    bulletinDTOBuilder.setId(bulletinDTO.getId());
    bulletinDTOBuilder.setLevel(bulletinDTO.getLevel());
    bulletinDTOBuilder.setMessage(bulletinDTO.getMessage());
    bulletinDTOBuilder.setNodeAddress(bulletinDTO.getNodeAddress());
    bulletinDTOBuilder.setSourceId(bulletinDTO.getSourceId());
    bulletinDTOBuilder.setSourceName(bulletinDTO.getSourceName());
    bulletinDTOBuilder.setTimestamp(bulletinDTO.getTimestamp());
    return bulletinDTOBuilder;
  }
}
