package com.tibtech.nifi.web.api.processgroup;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ConnectionEntity;

/**
 * Creates a connection
 */
public final class CreateConnectionInvoker extends ComponentEntityInvoker<ConnectionEntity> {
  private String id;

  private ConnectionEntity connectionEntity;

  public CreateConnectionInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final CreateConnectionInvoker setId(final String id) {
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
  public final CreateConnectionInvoker setConnectionEntity(
      final ConnectionEntity connectionEntity) {
    this.connectionEntity = connectionEntity;
    return this;
  }

  public final ConnectionEntity invoke() throws InvokerException {
    // nifi-api/process-groups/{id}/connections
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("connections");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Entity<ConnectionEntity> entity = Entity.entity(connectionEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleComponentEntityResponse(response, ConnectionEntity.class);
    }
    finally {
      response.close();
    }
  }
}
