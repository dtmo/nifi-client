package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.CurrentUserEntity;

/**
 * Retrieves the user identity of the user making the request
 */
public final class GetCurrentUserInvoker extends AbstractInvoker<CurrentUserEntity> {
  public GetCurrentUserInvoker(final Transport transport) {
    super(transport);
  }

  public final CurrentUserEntity invoke() throws InvokerException {
    // nifi-api/flow/current-user
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flow");
    target = target.path("current-user");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, CurrentUserEntity.class);
    }
    finally {
      response.close();
    }
  }
}
