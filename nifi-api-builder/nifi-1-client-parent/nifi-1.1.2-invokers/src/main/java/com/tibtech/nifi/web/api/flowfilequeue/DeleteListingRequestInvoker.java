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
 * Cancels and/or removes a request to list the contents of this connection.
 */
public final class DeleteListingRequestInvoker extends AbstractInvoker<DropRequestEntity> {
  private String id;

  private String listingRequestId;

  public DeleteListingRequestInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The connection id. */
  public final String getId() {
    return id;
  }

  /**
   * The connection id. */
  public final DeleteListingRequestInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The listing request id. */
  public final String getListingRequestId() {
    return listingRequestId;
  }

  /**
   * The listing request id. */
  public final DeleteListingRequestInvoker setListingRequestId(final String listingRequestId) {
    this.listingRequestId = listingRequestId;
    return this;
  }

  public final DropRequestEntity invoke() throws InvokerException {
    // nifi-api/flowfile-queues/{id}/listing-requests/{listing-request-id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flowfile-queues");
    target = target.path(id);
    target = target.path("listing-requests");
    target = target.path(listingRequestId);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("DELETE");
    try {
      return handleResponse(response, DropRequestEntity.class);
    }
    finally {
      response.close();
    }
  }
}
