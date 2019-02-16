package com.tibtech.nifi.web.api.outputport;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.PortEntity;

/**
 * Gets an output port
 */
public final class GetOutputPortInvoker extends ComponentEntityInvoker<PortEntity> {
  private String id;

  public GetOutputPortInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The output port id. */
  public final String getId() {
    return id;
  }

  /**
   * The output port id. */
  public final GetOutputPortInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final PortEntity invoke() throws InvokerException {
    // nifi-api/output-ports/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("output-ports");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleComponentEntityResponse(response, PortEntity.class);
    }
    finally {
      response.close();
    }
  }
}
