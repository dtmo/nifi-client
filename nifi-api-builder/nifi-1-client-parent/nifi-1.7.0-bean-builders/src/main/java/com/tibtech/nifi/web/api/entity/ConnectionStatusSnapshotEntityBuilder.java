package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import java.lang.String;
import org.apache.nifi.web.api.dto.status.ConnectionStatusSnapshotDTO;
import org.apache.nifi.web.api.entity.ConnectionStatusSnapshotEntity;

public final class ConnectionStatusSnapshotEntityBuilder extends AbstractEntityBuilder<ConnectionStatusSnapshotEntityBuilder> {
  private Boolean canRead;

  private ConnectionStatusSnapshotDTO connectionStatusSnapshot;

  private String id;

  public Boolean getCanRead() {
    return canRead;
  }

  public ConnectionStatusSnapshotEntityBuilder setCanRead(final Boolean canRead) {
    this.canRead = canRead;
    return this;
  }

  public ConnectionStatusSnapshotDTO getConnectionStatusSnapshot() {
    return connectionStatusSnapshot;
  }

  public ConnectionStatusSnapshotEntityBuilder setConnectionStatusSnapshot(final ConnectionStatusSnapshotDTO connectionStatusSnapshot) {
    this.connectionStatusSnapshot = connectionStatusSnapshot;
    return this;
  }

  /**
   * The id of the connection.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the connection.
   */
  public ConnectionStatusSnapshotEntityBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  public ConnectionStatusSnapshotEntity build() {
    final ConnectionStatusSnapshotEntity connectionStatusSnapshotEntity = new ConnectionStatusSnapshotEntity();
    super.setPropertyValues(connectionStatusSnapshotEntity);
    connectionStatusSnapshotEntity.setCanRead(canRead);
    connectionStatusSnapshotEntity.setConnectionStatusSnapshot(connectionStatusSnapshot);
    connectionStatusSnapshotEntity.setId(id);
    return connectionStatusSnapshotEntity;
  }

  public static ConnectionStatusSnapshotEntityBuilder of(final ConnectionStatusSnapshotEntity connectionStatusSnapshotEntity) {
    final ConnectionStatusSnapshotEntityBuilder connectionStatusSnapshotEntityBuilder = new ConnectionStatusSnapshotEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(connectionStatusSnapshotEntityBuilder, connectionStatusSnapshotEntity);
    connectionStatusSnapshotEntityBuilder.setCanRead(connectionStatusSnapshotEntity.getCanRead());
    connectionStatusSnapshotEntityBuilder.setConnectionStatusSnapshot(connectionStatusSnapshotEntity.getConnectionStatusSnapshot());
    connectionStatusSnapshotEntityBuilder.setId(connectionStatusSnapshotEntity.getId());
    return connectionStatusSnapshotEntityBuilder;
  }
}
