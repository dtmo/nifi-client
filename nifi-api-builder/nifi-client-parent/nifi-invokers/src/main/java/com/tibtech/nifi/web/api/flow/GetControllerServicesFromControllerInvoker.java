package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ControllerServicesEntity;

public final class GetControllerServicesFromControllerInvoker extends AbstractInvoker<ControllerServicesEntity> {
  public GetControllerServicesFromControllerInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final ControllerServicesEntity invoke() throws InvokerException {
    // /flow/controller/controller-services
    WebTarget target = getBaseWebTarget();
    target = target.path("flow");
    target = target.path("controller");
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
