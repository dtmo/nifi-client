package com.tibtech.nifi.web.api.connection;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ConnectionEntity;

/**
 * Deletes a connection
 */
public final class DeleteConnectionInvoker extends ComponentEntityInvoker<ConnectionEntity> {
  private String id;

  public DeleteConnectionInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The connection id. */
  public final String getId() {
    return id;
  }

  /**
   * The connection id. */
  public final DeleteConnectionInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final ConnectionEntity invoke() throws InvokerException {
    // nifi-api/connections/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("connections");
    target = target.path(id);
    target = target.queryParam("version", getVersion());
    target = target.queryParam("clientId", getClientId());
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("DELETE");
    try {
      return handleComponentEntityResponse(response, ConnectionEntity.class);
    }
    finally {
      response.close();
    }
  }
}
