package com.tibtech.nifi.web.api.tenants;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.UserEntity;

/**
 * Deletes a user
 */
public final class RemoveUserInvoker extends ComponentEntityInvoker<UserEntity> {
  private String id;

  public RemoveUserInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The user id. */
  public final String getId() {
    return id;
  }

  /**
   * The user id. */
  public final RemoveUserInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final UserEntity invoke() throws InvokerException {
    // tenants/users/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("tenants");
    target = target.path("users");
    target = target.path(id);
    target = target.queryParam("version", getVersion());
    target = target.queryParam("clientId", getClientId());
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("DELETE");
    try {
      return handleComponentEntityResponse(response, UserEntity.class);
    }
    finally {
      response.close();
    }
  }
}
