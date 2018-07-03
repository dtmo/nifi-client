package com.tibtech.nifi.web.api.dto;

import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import org.apache.nifi.web.api.dto.BulletinQueryDTO;

public final class BulletinQueryDTOBuilder {
  private Long after;

  private String groupId;

  private Integer limit;

  private String message;

  private String name;

  private String sourceId;

  /**
   * Will include bulletins that occurred after this id. The ids are a one-up number that are used to ensure bulletins that occur at the same time will not be missed.
   */
  public Long getAfter() {
    return after;
  }

  /**
   * Will include bulletins that occurred after this id. The ids are a one-up number that are used to ensure bulletins that occur at the same time will not be missed.
   */
  public BulletinQueryDTOBuilder setAfter(final Long after) {
    this.after = after;
    return this;
  }

  /**
   * Will include bulletins that occurred within this group. Supports a regular expression.
   */
  public String getGroupId() {
    return groupId;
  }

  /**
   * Will include bulletins that occurred within this group. Supports a regular expression.
   */
  public BulletinQueryDTOBuilder setGroupId(final String groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * The maximum number of bulletins to return.
   */
  public Integer getLimit() {
    return limit;
  }

  /**
   * The maximum number of bulletins to return.
   */
  public BulletinQueryDTOBuilder setLimit(final Integer limit) {
    this.limit = limit;
    return this;
  }

  /**
   * Will include bulletins that match this message. Supports a regular expression.
   */
  public String getMessage() {
    return message;
  }

  /**
   * Will include bulletins that match this message. Supports a regular expression.
   */
  public BulletinQueryDTOBuilder setMessage(final String message) {
    this.message = message;
    return this;
  }

  /**
   * Will include bulletins that match this name. Supports a regular expression.
   */
  public String getName() {
    return name;
  }

  /**
   * Will include bulletins that match this name. Supports a regular expression.
   */
  public BulletinQueryDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * Will include bulletins from components that match this id. Supports a regular expression.
   */
  public String getSourceId() {
    return sourceId;
  }

  /**
   * Will include bulletins from components that match this id. Supports a regular expression.
   */
  public BulletinQueryDTOBuilder setSourceId(final String sourceId) {
    this.sourceId = sourceId;
    return this;
  }

  public BulletinQueryDTO build() {
    final BulletinQueryDTO bulletinQueryDTO = new BulletinQueryDTO();
    bulletinQueryDTO.setAfter(after);
    bulletinQueryDTO.setGroupId(groupId);
    bulletinQueryDTO.setLimit(limit);
    bulletinQueryDTO.setMessage(message);
    bulletinQueryDTO.setName(name);
    bulletinQueryDTO.setSourceId(sourceId);
    return bulletinQueryDTO;
  }

  public static BulletinQueryDTOBuilder of(final BulletinQueryDTO bulletinQueryDTO) {
    final BulletinQueryDTOBuilder bulletinQueryDTOBuilder = new BulletinQueryDTOBuilder();
    bulletinQueryDTOBuilder.setAfter(bulletinQueryDTO.getAfter());
    bulletinQueryDTOBuilder.setGroupId(bulletinQueryDTO.getGroupId());
    bulletinQueryDTOBuilder.setLimit(bulletinQueryDTO.getLimit());
    bulletinQueryDTOBuilder.setMessage(bulletinQueryDTO.getMessage());
    bulletinQueryDTOBuilder.setName(bulletinQueryDTO.getName());
    bulletinQueryDTOBuilder.setSourceId(bulletinQueryDTO.getSourceId());
    return bulletinQueryDTOBuilder;
  }
}
