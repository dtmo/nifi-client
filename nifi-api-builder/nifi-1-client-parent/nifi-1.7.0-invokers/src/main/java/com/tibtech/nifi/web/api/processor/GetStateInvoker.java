package com.tibtech.nifi.web.api.processor;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ComponentStateEntity;

/**
 * Gets the state for a processor
 */
public final class GetStateInvoker extends AbstractInvoker<ComponentStateEntity> {
  private String id;

  public GetStateInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The processor id. */
  public final String getId() {
    return id;
  }

  /**
   * The processor id. */
  public final GetStateInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final ComponentStateEntity invoke() throws InvokerException {
    // nifi-api/processors/{id}/state
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("processors");
    target = target.path(id);
    target = target.path("state");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ComponentStateEntity.class);
    }
    finally {
      response.close();
    }
  }
}
