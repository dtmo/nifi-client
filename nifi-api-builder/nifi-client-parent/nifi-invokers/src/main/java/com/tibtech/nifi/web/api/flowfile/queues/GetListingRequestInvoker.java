package com.tibtech.nifi.web.api.flowfile.queues;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ListingRequestEntity;

public final class GetListingRequestInvoker extends AbstractInvoker<ListingRequestEntity> {
  private String id;

  private String listingRequestId;

  public GetListingRequestInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The connection id. */
  public final String getId() {
    return id;
  }

  /**
   * The connection id. */
  public final GetListingRequestInvoker setId(final String id) {
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
  public final GetListingRequestInvoker setListingRequestId(final String listingRequestId) {
    this.listingRequestId = listingRequestId;
    return this;
  }

  public final ListingRequestEntity invoke() throws InvokerException {
    // /flowfile-queues/{id}/listing-requests/{listing-request-id}
    WebTarget target = getBaseWebTarget();
    target = target.path("flowfile-queues");
    target = target.path(id);
    target = target.path("listing-requests");
    target = target.path(listingRequestId);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ListingRequestEntity.class);
    }
    finally {
      response.close();
    }
  }
}
