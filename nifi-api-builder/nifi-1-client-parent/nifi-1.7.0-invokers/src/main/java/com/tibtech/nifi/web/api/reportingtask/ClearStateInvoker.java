package com.tibtech.nifi.web.api.reportingtask;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ComponentStateEntity;

/**
 * Clears the state for a reporting task
 */
public final class ClearStateInvoker extends AbstractInvoker<ComponentStateEntity> {
  private String id;

  public ClearStateInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The reporting task id. */
  public final String getId() {
    return id;
  }

  /**
   * The reporting task id. */
  public final ClearStateInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final ComponentStateEntity invoke() throws InvokerException {
    // nifi-api/reporting-tasks/{id}/state/clear-requests
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("reporting-tasks");
    target = target.path(id);
    target = target.path("state");
    target = target.path("clear-requests");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("POST");
    try {
      return handleResponse(response, ComponentStateEntity.class);
    }
    finally {
      response.close();
    }
  }
}
