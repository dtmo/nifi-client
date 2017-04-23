package com.tibtech.nifi.web.api.policies;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.AccessPolicyEntity;

public final class GetAccessPolicyForResourceInvoker extends ComponentEntityInvoker<AccessPolicyEntity> {
  private String action;

  private String resource;

  public GetAccessPolicyForResourceInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The request action. */
  public final String getAction() {
    return action;
  }

  /**
   * The request action. */
  public final GetAccessPolicyForResourceInvoker setAction(final String action) {
    this.action = action;
    return this;
  }

  /**
   * The resource of the policy. */
  public final String getResource() {
    return resource;
  }

  /**
   * The resource of the policy. */
  public final GetAccessPolicyForResourceInvoker setResource(final String resource) {
    this.resource = resource;
    return this;
  }

  public final AccessPolicyEntity invoke() throws InvokerException {
    // /policies/{action}/{resource: .+}
    WebTarget target = getBaseWebTarget();
    target = target.path("policies");
    target = target.path(action);
    target = target.path(resource);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleComponentEntityResponse(response, AccessPolicyEntity.class);
    }
    finally {
      response.close();
    }
  }
}
