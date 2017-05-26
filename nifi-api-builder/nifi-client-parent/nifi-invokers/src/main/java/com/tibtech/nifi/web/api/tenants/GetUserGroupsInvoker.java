package com.tibtech.nifi.web.api.tenants;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.UserGroupsEntity;

public final class GetUserGroupsInvoker extends AbstractInvoker<UserGroupsEntity> {
  public GetUserGroupsInvoker(final Transport transport) {
    super(transport);
  }

  public final UserGroupsEntity invoke() throws InvokerException {
    // tenants/user-groups
    WebTarget target = getBaseWebTarget();
    target = target.path("tenants");
    target = target.path("user-groups");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, UserGroupsEntity.class);
    }
    finally {
      response.close();
    }
  }
}
