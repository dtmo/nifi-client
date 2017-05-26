package com.tibtech.nifi.web.api.connections;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ConnectionEntity;

public final class UpdateConnectionInvoker extends ComponentEntityInvoker<ConnectionEntity> {
  private String id;

  private ConnectionEntity connectionEntity;

  public UpdateConnectionInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The connection id. */
  public final String getId() {
    return id;
  }

  /**
   * The connection id. */
  public final UpdateConnectionInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The connection configuration details. */
  public final ConnectionEntity getConnectionEntity() {
    return connectionEntity;
  }

  /**
   * The connection configuration details. */
  public final UpdateConnectionInvoker setConnectionEntity(final ConnectionEntity connectionEntity) {
    this.connectionEntity = connectionEntity;
    return this;
  }

  public final ConnectionEntity invoke() throws InvokerException {
    // /connections/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("connections");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    connectionEntity.setRevision(createRevisionDto());
    final Entity<ConnectionEntity> entity = Entity.entity(connectionEntity, "application/json");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleComponentEntityResponse(response, ConnectionEntity.class);
    }
    finally {
      response.close();
    }
  }
}