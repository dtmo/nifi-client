package com.tibtech.nifi.web.api.tenants;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.UserGroupEntity;

public final class RemoveUserGroupInvoker extends ComponentEntityInvoker<UserGroupEntity> {
  private String id;

  public RemoveUserGroupInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The user group id. */
  public final String getId() {
    return id;
  }

  /**
   * The user group id. */
  public final RemoveUserGroupInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final UserGroupEntity invoke() throws InvokerException {
    // tenants/user-groups/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("tenants");
    target = target.path("user-groups");
    target = target.path(id);
    target = target.queryParam("version", getVersion());
    target = target.queryParam("clientId", getClientId());
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("DELETE");
    try {
      return handleComponentEntityResponse(response, UserGroupEntity.class);
    }
    finally {
      response.close();
    }
  }
}
