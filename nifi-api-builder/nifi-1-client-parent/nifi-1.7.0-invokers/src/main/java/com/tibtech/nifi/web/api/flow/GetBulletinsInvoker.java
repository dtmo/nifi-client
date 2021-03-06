package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ControllerBulletinsEntity;

/**
 * Retrieves Controller level bulletins
 */
public final class GetBulletinsInvoker extends AbstractInvoker<ControllerBulletinsEntity> {
  public GetBulletinsInvoker(final Transport transport) {
    super(transport);
  }

  public final ControllerBulletinsEntity invoke() throws InvokerException {
    // nifi-api/flow/controller/bulletins
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flow");
    target = target.path("controller");
    target = target.path("bulletins");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ControllerBulletinsEntity.class);
    }
    finally {
      response.close();
    }
  }
}
