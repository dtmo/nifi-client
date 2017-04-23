package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.StatusHistoryEntity;

public final class GetProcessGroupStatusHistoryInvoker extends AbstractInvoker<StatusHistoryEntity> {
  private String id;

  public GetProcessGroupStatusHistoryInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final GetProcessGroupStatusHistoryInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final StatusHistoryEntity invoke() throws InvokerException {
    // /flow/process-groups/{id}/status/history
    WebTarget target = getBaseWebTarget();
    target = target.path("flow");
    target = target.path("process-groups");
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
