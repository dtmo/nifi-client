package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ProcessGroupFlowEntity;

/**
 * Gets a process group
 */
public final class GetFlowInvoker extends AbstractInvoker<ProcessGroupFlowEntity> {
  private String id;

  public GetFlowInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final GetFlowInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final ProcessGroupFlowEntity invoke() throws InvokerException {
    // nifi-api/flow/process-groups/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flow");
    target = target.path("process-groups");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ProcessGroupFlowEntity.class);
    }
    finally {
      response.close();
    }
  }
}
