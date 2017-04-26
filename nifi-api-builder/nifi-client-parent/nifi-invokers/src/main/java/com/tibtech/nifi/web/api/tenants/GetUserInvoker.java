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
 * Gets a user
 */
public final class GetUserInvoker extends ComponentEntityInvoker<UserEntity> {
  private String id;

  public GetUserInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The user id. */
  public final String getId() {
    return id;
  }

  /**
   * The user id. */
  public final GetUserInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final UserEntity invoke() throws InvokerException {
    // tenants/users/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("tenants");
    target = target.path("users");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleComponentEntityResponse(response, UserEntity.class);
    }
    finally {
      response.close();
    }
  }
}
