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
 * Gets the current status of a drop request for the specified connection.
 */
public final class GetDropRequestInvoker extends AbstractInvoker<DropRequestEntity> {
  private String id;

  private String dropRequestId;

  public GetDropRequestInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The connection id. */
  public final String getId() {
    return id;
  }

  /**
   * The connection id. */
  public final GetDropRequestInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The drop request id. */
  public final String getDropRequestId() {
    return dropRequestId;
  }

  /**
   * The drop request id. */
  public final GetDropRequestInvoker setDropRequestId(final String dropRequestId) {
    this.dropRequestId = dropRequestId;
    return this;
  }

  public final DropRequestEntity invoke() throws InvokerException {
    // nifi-api/flowfile-queues/{id}/drop-requests/{drop-request-id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flowfile-queues");
    target = target.path(id);
    target = target.path("drop-requests");
    target = target.path(dropRequestId);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, DropRequestEntity.class);
    }
    finally {
      response.close();
    }
  }
}
