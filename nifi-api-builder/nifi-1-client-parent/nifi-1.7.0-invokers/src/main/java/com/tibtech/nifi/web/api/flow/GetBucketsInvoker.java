package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.BucketsEntity;

/**
 * Gets the buckets from the specified registry for the current user
 */
public final class GetBucketsInvoker extends AbstractInvoker<BucketsEntity> {
  private String id;

  public GetBucketsInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The registry id. */
  public final String getId() {
    return id;
  }

  /**
   * The registry id. */
  public final GetBucketsInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final BucketsEntity invoke() throws InvokerException {
    // nifi-api/flow/registries/{id}/buckets
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flow");
    target = target.path("registries");
    target = target.path(id);
    target = target.path("buckets");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, BucketsEntity.class);
    }
    finally {
      response.close();
    }
  }
}
