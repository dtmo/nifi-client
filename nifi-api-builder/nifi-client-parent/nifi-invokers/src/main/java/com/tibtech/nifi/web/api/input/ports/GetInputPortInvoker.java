package com.tibtech.nifi.web.api.input.ports;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.PortEntity;

public final class GetInputPortInvoker extends ComponentEntityInvoker<PortEntity> {
  private String id;

  public GetInputPortInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The input port id. */
  public final String getId() {
    return id;
  }

  /**
   * The input port id. */
  public final GetInputPortInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final PortEntity invoke() throws InvokerException {
    // /input-ports/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("input-ports");
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
