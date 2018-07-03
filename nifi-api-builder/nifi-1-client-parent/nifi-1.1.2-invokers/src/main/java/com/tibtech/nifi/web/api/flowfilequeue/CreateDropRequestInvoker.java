package com.tibtech.nifi.web.api.flowfilequeue;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.DropRequestEntity;

/**
 * Creates a request to drop the contents of the queue in this connection.
 */
public final class CreateDropRequestInvoker extends AbstractInvoker<DropRequestEntity> {
  private String id;

  public CreateDropRequestInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The connection id. */
  public final String getId() {
    return id;
  }

  /**
   * The connection id. */
  public final CreateDropRequestInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final DropRequestEntity invoke() throws InvokerException {
    // nifi-api/flowfile-queues/{id}/drop-requests
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flowfile-queues");
    target = target.path(id);
    target = target.path("drop-requests");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("POST");
    try {
      return handleResponse(response, DropRequestEntity.class);
    }
    finally {
      response.close();
    }
  }
}
