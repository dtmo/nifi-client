package com.tibtech.nifi.web.api.accesspolicy;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.AccessPolicyEntity;

/**
 * Gets an access policy for the specified action and resource
 * <p>Will return the effective policy if no component specific policy exists for the specified action and resource. Must have Read permissions to the policy with the desired action and resource. Permissions for the policy that is returned will be indicated in the response. This means the client could be authorized to get the policy for a given component but the effective policy may be inherited from an ancestor Process Group. If the client does not have permissions to that policy, the response will not include the policy and the permissions in the response will be marked accordingly. If the client does not have permissions to the policy of the desired action and resource a 403 response will be returned.</p>
 */
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
