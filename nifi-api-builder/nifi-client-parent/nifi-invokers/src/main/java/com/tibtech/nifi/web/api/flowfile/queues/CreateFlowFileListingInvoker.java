package com.tibtech.nifi.web.api.flowfile.queues;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ListingRequestEntity;

public final class CreateFlowFileListingInvoker extends AbstractInvoker<ListingRequestEntity> {
  private String id;

  public CreateFlowFileListingInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The connection id. */
  public final String getId() {
    return id;
  }

  /**
   * The connection id. */
  public final CreateFlowFileListingInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final ListingRequestEntity invoke() throws InvokerException {
    // /flowfile-queues/{id}/listing-requests
    WebTarget target = getBaseWebTarget();
    target = target.path("flowfile-queues");
    target = target.path(id);
    target = target.path("listing-requests");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("POST");
    try {
      return handleResponse(response, ListingRequestEntity.class);
    }
    finally {
      response.close();
    }
  }
}
