package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ControllerStatusEntity;

public final class GetControllerStatusInvoker extends AbstractInvoker<ControllerStatusEntity> {
  public GetControllerStatusInvoker(final Transport transport) {
    super(transport);
  }

  public final ControllerStatusEntity invoke() throws InvokerException {
    // /flow/status
    WebTarget target = getBaseWebTarget();
    target = target.path("flow");
    target = target.path("status");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ControllerStatusEntity.class);
    }
    finally {
      response.close();
    }
  }
}
