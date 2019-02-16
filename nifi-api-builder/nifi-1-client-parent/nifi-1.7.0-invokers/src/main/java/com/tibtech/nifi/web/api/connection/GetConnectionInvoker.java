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
 * Gets a connection
 */
public final class GetConnectionInvoker extends ComponentEntityInvoker<ConnectionEntity> {
  private String id;

  public GetConnectionInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The connection id. */
  public final String getId() {
    return id;
  }

  /**
   * The connection id. */
  public final GetConnectionInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final ConnectionEntity invoke() throws InvokerException {
    // nifi-api/connections/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("connections");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleComponentEntityResponse(response, ConnectionEntity.class);
    }
    finally {
      response.close();
    }
  }
}
