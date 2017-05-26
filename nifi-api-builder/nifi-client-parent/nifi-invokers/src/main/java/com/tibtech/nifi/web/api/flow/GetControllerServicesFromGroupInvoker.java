package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ControllerServicesEntity;

public final class GetControllerServicesFromGroupInvoker extends AbstractInvoker<ControllerServicesEntity> {
  private String id;

  public GetControllerServicesFromGroupInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final GetControllerServicesFromGroupInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final ControllerServicesEntity invoke() throws InvokerException {
    // /flow/process-groups/{id}/controller-services
    WebTarget target = getBaseWebTarget();
    target = target.path("flow");
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("controller-services");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ControllerServicesEntity.class);
    }
    finally {
      response.close();
    }
  }
}
