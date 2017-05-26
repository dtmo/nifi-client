package com.tibtech.nifi.web.api.entity;

import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.List;
import org.apache.nifi.web.api.dto.ConnectionDTO;
import org.apache.nifi.web.api.dto.PositionDTO;
import org.apache.nifi.web.api.dto.status.ConnectionStatusDTO;
import org.apache.nifi.web.api.entity.ConnectionEntity;

public final class ConnectionEntityBuilder extends AbstractComponentEntityBuilder<ConnectionEntityBuilder> {
  private List<PositionDTO> bends;

  private ConnectionDTO component;

  private String destinationGroupId;

  private String destinationId;

  private String destinationType;

  private Integer labelIndex;

  private String sourceGroupId;

  private String sourceId;

  private String sourceType;

  private ConnectionStatusDTO status;

  private Long zIndex;

  /**
   * The bend points on the connection.
   */
  public List<PositionDTO> getBends() {
    return bends;
  }

  /**
   * The bend points on the connection.
   */
  public ConnectionEntityBuilder setBends(final List<PositionDTO> bends) {
    this.bends = bends;
    return this;
  }

  public ConnectionDTO getComponent() {
    return component;
  }

  public ConnectionEntityBuilder setComponent(final ConnectionDTO component) {
    this.component = component;
    return this;
  }

  /**
   * The identifier of the group of the destination of this connection.
   */
  public String getDestinationGroupId() {
    return destinationGroupId;
  }

  /**
   * The identifier of the group of the destination of this connection.
   */
  public ConnectionEntityBuilder setDestinationGroupId(final String destinationGroupId) {
    this.destinationGroupId = destinationGroupId;
    return this;
  }

  /**
   * The identifier of the destination of this connection.
   */
  public String getDestinationId() {
    return destinationId;
  }

  /**
   * The identifier of the destination of this connection.
   */
  public ConnectionEntityBuilder setDestinationId(final String destinationId) {
    this.destinationId = destinationId;
    return this;
  }

  /**
   * The type of component the destination connectable is.
   */
  public String getDestinationType() {
    return destinationType;
  }

  /**
   * The type of component the destination connectable is.
   */
  public ConnectionEntityBuilder setDestinationType(final String destinationType) {
    this.destinationType = destinationType;
    return this;
  }

  /**
   * The index of the bend point where to place the connection label.
   */
  public Integer getLabelIndex() {
    return labelIndex;
  }

  /**
   * The index of the bend point where to place the connection label.
   */
  public ConnectionEntityBuilder setLabelIndex(final Integer labelIndex) {
    this.labelIndex = labelIndex;
    return this;
  }

  /**
   * The identifier of the group of the source of this connection.
   */
  public String getSourceGroupId() {
    return sourceGroupId;
  }

  /**
   * The identifier of the group of the source of this connection.
   */
  public ConnectionEntityBuilder setSourceGroupId(final String sourceGroupId) {
    this.sourceGroupId = sourceGroupId;
    return this;
  }

  /**
   * The identifier of the source of this connection.
   */
  public String getSourceId() {
    return sourceId;
  }

  /**
   * The identifier of the source of this connection.
   */
  public ConnectionEntityBuilder setSourceId(final String sourceId) {
    this.sourceId = sourceId;
    return this;
  }

  /**
   * The type of component the source connectable is.
   */
  public String getSourceType() {
    return sourceType;
  }

  /**
   * The type of component the source connectable is.
   */
  public ConnectionEntityBuilder setSourceType(final String sourceType) {
    this.sourceType = sourceType;
    return this;
  }

  /**
   * The status of the connection.
   */
  public ConnectionStatusDTO getStatus() {
    return status;
  }

  /**
   * The status of the connection.
   */
  public ConnectionEntityBuilder setStatus(final ConnectionStatusDTO status) {
    this.status = status;
    return this;
  }

  /**
   * The z index of the connection.
   */
  public Long getZIndex() {
    return zIndex;
  }

  /**
   * The z index of the connection.
   */
  public ConnectionEntityBuilder setZIndex(final Long zIndex) {
    this.zIndex = zIndex;
    return this;
  }

  public ConnectionEntity build() {
    final ConnectionEntity connectionEntity = new ConnectionEntity();
    super.setPropertyValues(connectionEntity);
    connectionEntity.setBends(bends);
    connectionEntity.setComponent(component);
    connectionEntity.setDestinationGroupId(destinationGroupId);
    connectionEntity.setDestinationId(destinationId);
    connectionEntity.setDestinationType(destinationType);
    connectionEntity.setLabelIndex(labelIndex);
    connectionEntity.setSourceGroupId(sourceGroupId);
    connectionEntity.setSourceId(sourceId);
    connectionEntity.setSourceType(sourceType);
    connectionEntity.setStatus(status);
    connectionEntity.setzIndex(zIndex);
    return connectionEntity;
  }

  public static ConnectionEntityBuilder of(final ConnectionEntity connectionEntity) {
    final ConnectionEntityBuilder connectionEntityBuilder = new ConnectionEntityBuilder();
    AbstractComponentEntityBuilder.setBuilderValues(connectionEntityBuilder, connectionEntity);
    connectionEntityBuilder.setBends(connectionEntity.getBends());
    connectionEntityBuilder.setComponent(connectionEntity.getComponent());
    connectionEntityBuilder.setDestinationGroupId(connectionEntity.getDestinationGroupId());
    connectionEntityBuilder.setDestinationId(connectionEntity.getDestinationId());
    connectionEntityBuilder.setDestinationType(connectionEntity.getDestinationType());
    connectionEntityBuilder.setLabelIndex(connectionEntity.getLabelIndex());
    connectionEntityBuilder.setSourceGroupId(connectionEntity.getSourceGroupId());
    connectionEntityBuilder.setSourceId(connectionEntity.getSourceId());
    connectionEntityBuilder.setSourceType(connectionEntity.getSourceType());
    connectionEntityBuilder.setStatus(connectionEntity.getStatus());
    connectionEntityBuilder.setZIndex(connectionEntity.getzIndex());
    return connectionEntityBuilder;
  }
}
