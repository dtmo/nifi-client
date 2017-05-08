package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import org.apache.nifi.web.api.dto.status.ConnectionStatusDTO;
import org.apache.nifi.web.api.entity.ConnectionStatusEntity;

public final class ConnectionStatusEntityBuilder extends AbstractEntityBuilder<ConnectionStatusEntityBuilder> {
  private Boolean canRead;

  private ConnectionStatusDTO connectionStatus;

  public Boolean getCanRead() {
    return canRead;
  }

  public ConnectionStatusEntityBuilder setCanRead(final Boolean canRead) {
    this.canRead = canRead;
    return this;
  }

  public ConnectionStatusDTO getConnectionStatus() {
    return connectionStatus;
  }

  public ConnectionStatusEntityBuilder setConnectionStatus(final ConnectionStatusDTO connectionStatus) {
    this.connectionStatus = connectionStatus;
    return this;
  }

  public ConnectionStatusEntity build() {
    final ConnectionStatusEntity connectionStatusEntity = new ConnectionStatusEntity();
    super.setPropertyValues(connectionStatusEntity);
    connectionStatusEntity.setCanRead(canRead);
    connectionStatusEntity.setConnectionStatus(connectionStatus);
    return connectionStatusEntity;
  }

  public static ConnectionStatusEntityBuilder of(final ConnectionStatusEntity connectionStatusEntity) {
    final ConnectionStatusEntityBuilder connectionStatusEntityBuilder = new ConnectionStatusEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(connectionStatusEntityBuilder, connectionStatusEntity);
    connectionStatusEntityBuilder.setCanRead(connectionStatusEntity.getCanRead());
    connectionStatusEntityBuilder.setConnectionStatus(connectionStatusEntity.getConnectionStatus());
    return connectionStatusEntityBuilder;
  }
}
