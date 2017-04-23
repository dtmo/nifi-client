package com.tibtech.nifi.web.api.process.groups;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ConnectionsEntity;

public final class GetConnectionsInvoker extends AbstractInvoker<ConnectionsEntity> {
  private String id;

  public GetConnectionsInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final GetConnectionsInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final ConnectionsEntity invoke() throws InvokerException {
    // /process-groups/{id}/connections
    WebTarget target = getBaseWebTarget();
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("connections");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ConnectionsEntity.class);
    }
    finally {
      response.close();
    }
  }
}
