package com.tibtech.nifi.web.api.tenants;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.UsersEntity;

/**
 * Gets all users
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class GetUsersInvoker extends AbstractInvoker<UsersEntity> {
  public GetUsersInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final UsersEntity invoke() throws InvokerException {
    // nifi-apitenants/users
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-apitenants");
    target = target.path("users");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, UsersEntity.class);
    }
    finally {
      response.close();
    }
  }
}
