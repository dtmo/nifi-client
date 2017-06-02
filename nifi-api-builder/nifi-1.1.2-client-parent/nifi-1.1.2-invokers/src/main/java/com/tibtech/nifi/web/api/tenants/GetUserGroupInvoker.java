package com.tibtech.nifi.web.api.tenants;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.UserGroupEntity;

/**
 * Gets a user group
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class GetUserGroupInvoker extends ComponentEntityInvoker<UserGroupEntity> {
  private String id;

  public GetUserGroupInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The user group id. */
  public final String getId() {
    return id;
  }

  /**
   * The user group id. */
  public final GetUserGroupInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final UserGroupEntity invoke() throws InvokerException {
    // nifi-apitenants/user-groups/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-apitenants");
    target = target.path("user-groups");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleComponentEntityResponse(response, UserGroupEntity.class);
    }
    finally {
      response.close();
    }
  }
}
