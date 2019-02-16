package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.StatusHistoryEntity;

/**
 * Gets the status history for a connection
 */
public final class GetConnectionStatusHistoryInvoker extends AbstractInvoker<StatusHistoryEntity> {
  private String id;

  public GetConnectionStatusHistoryInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The connection id. */
  public final String getId() {
    return id;
  }

  /**
   * The connection id. */
  public final GetConnectionStatusHistoryInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final StatusHistoryEntity invoke() throws InvokerException {
    // nifi-api/flow/connections/{id}/status/history
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flow");
    target = target.path("connections");
    target = target.path(id);
    target = target.path("status");
    target = target.path("history");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, StatusHistoryEntity.class);
    }
    finally {
      response.close();
    }
  }
}
