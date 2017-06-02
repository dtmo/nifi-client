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
 * Deletes an output port
 */
public final class RemoveOutputPortInvoker extends ComponentEntityInvoker<PortEntity> {
  private String id;

  public RemoveOutputPortInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The output port id. */
  public final String getId() {
    return id;
  }

  /**
   * The output port id. */
  public final RemoveOutputPortInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final PortEntity invoke() throws InvokerException {
    // nifi-api/output-ports/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("output-ports");
    target = target.path(id);
    target = target.queryParam("version", getVersion());
    target = target.queryParam("clientId", getClientId());
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("DELETE");
    try {
      return handleComponentEntityResponse(response, PortEntity.class);
    }
    finally {
      response.close();
    }
  }
}
