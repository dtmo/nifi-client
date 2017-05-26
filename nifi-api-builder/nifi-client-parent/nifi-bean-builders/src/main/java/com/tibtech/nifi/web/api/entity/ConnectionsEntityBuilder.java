package com.tibtech.nifi.web.api.entity;

import java.util.Set;
import org.apache.nifi.web.api.entity.ConnectionEntity;
import org.apache.nifi.web.api.entity.ConnectionsEntity;

public final class ConnectionsEntityBuilder extends AbstractEntityBuilder<ConnectionsEntityBuilder> {
  private Set<ConnectionEntity> connections;

  public Set<ConnectionEntity> getConnections() {
    return connections;
  }

  public ConnectionsEntityBuilder setConnections(final Set<ConnectionEntity> connections) {
    this.connections = connections;
    return this;
  }

  public ConnectionsEntity build() {
    final ConnectionsEntity connectionsEntity = new ConnectionsEntity();
    super.setPropertyValues(connectionsEntity);
    connectionsEntity.setConnections(connections);
    return connectionsEntity;
  }

  public static ConnectionsEntityBuilder of(final ConnectionsEntity connectionsEntity) {
    final ConnectionsEntityBuilder connectionsEntityBuilder = new ConnectionsEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(connectionsEntityBuilder, connectionsEntity);
    connectionsEntityBuilder.setConnections(connectionsEntity.getConnections());
    return connectionsEntityBuilder;
  }
}
