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
 * Gets status history for a processor
 */
public final class GetProcessorStatusHistoryInvoker extends AbstractInvoker<StatusHistoryEntity> {
  private String id;

  public GetProcessorStatusHistoryInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The processor id. */
  public final String getId() {
    return id;
  }

  /**
   * The processor id. */
  public final GetProcessorStatusHistoryInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final StatusHistoryEntity invoke() throws InvokerException {
    // nifi-api/flow/processors/{id}/status/history
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flow");
    target = target.path("processors");
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
