package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import org.apache.nifi.web.api.dto.BulletinDTO;
import org.apache.nifi.web.api.entity.BulletinEntity;

public final class BulletinEntityBuilder extends AbstractEntityBuilder<BulletinEntityBuilder> {
  private BulletinDTO bulletin;

  private Boolean canRead;

  private String groupId;

  private Long id;

  private String nodeAddress;

  private String sourceId;

  private Date timestamp;

  public BulletinDTO getBulletin() {
    return bulletin;
  }

  public BulletinEntityBuilder setBulletin(final BulletinDTO bulletin) {
    this.bulletin = bulletin;
    return this;
  }

  public Boolean getCanRead() {
    return canRead;
  }

  public BulletinEntityBuilder setCanRead(final Boolean canRead) {
    this.canRead = canRead;
    return this;
  }

  public String getGroupId() {
    return groupId;
  }

  public BulletinEntityBuilder setGroupId(final String groupId) {
    this.groupId = groupId;
    return this;
  }

  public Long getId() {
    return id;
  }

  public BulletinEntityBuilder setId(final Long id) {
    this.id = id;
    return this;
  }

  public String getNodeAddress() {
    return nodeAddress;
  }

  public BulletinEntityBuilder setNodeAddress(final String nodeAddress) {
    this.nodeAddress = nodeAddress;
    return this;
  }

  public String getSourceId() {
    return sourceId;
  }

  public BulletinEntityBuilder setSourceId(final String sourceId) {
    this.sourceId = sourceId;
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
  public BulletinEntityBuilder setTimestamp(final Date timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  public BulletinEntity build() {
    final BulletinEntity bulletinEntity = new BulletinEntity();
    super.setPropertyValues(bulletinEntity);
    bulletinEntity.setBulletin(bulletin);
    bulletinEntity.setCanRead(canRead);
    bulletinEntity.setGroupId(groupId);
    bulletinEntity.setId(id);
    bulletinEntity.setNodeAddress(nodeAddress);
    bulletinEntity.setSourceId(sourceId);
    bulletinEntity.setTimestamp(timestamp);
    return bulletinEntity;
  }

  public static BulletinEntityBuilder of(final BulletinEntity bulletinEntity) {
    final BulletinEntityBuilder bulletinEntityBuilder = new BulletinEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(bulletinEntityBuilder, bulletinEntity);
    bulletinEntityBuilder.setBulletin(bulletinEntity.getBulletin());
    bulletinEntityBuilder.setCanRead(bulletinEntity.getCanRead());
    bulletinEntityBuilder.setGroupId(bulletinEntity.getGroupId());
    bulletinEntityBuilder.setId(bulletinEntity.getId());
    bulletinEntityBuilder.setNodeAddress(bulletinEntity.getNodeAddress());
    bulletinEntityBuilder.setSourceId(bulletinEntity.getSourceId());
    bulletinEntityBuilder.setTimestamp(bulletinEntity.getTimestamp());
    return bulletinEntityBuilder;
  }
}
