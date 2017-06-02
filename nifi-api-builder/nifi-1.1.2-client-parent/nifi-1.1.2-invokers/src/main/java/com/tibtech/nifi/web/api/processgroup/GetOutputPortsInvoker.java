package com.tibtech.nifi.web.api.processgroup;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.OutputPortsEntity;

/**
 * Gets all output ports
 */
public final class GetOutputPortsInvoker extends AbstractInvoker<OutputPortsEntity> {
  private String id;

  public GetOutputPortsInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final GetOutputPortsInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final OutputPortsEntity invoke() throws InvokerException {
    // nifi-api/process-groups/{id}/output-ports
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("output-ports");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, OutputPortsEntity.class);
    }
    finally {
      response.close();
    }
  }
}
