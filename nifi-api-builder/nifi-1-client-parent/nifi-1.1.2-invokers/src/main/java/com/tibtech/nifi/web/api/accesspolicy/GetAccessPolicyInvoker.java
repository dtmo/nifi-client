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
 * Gets an access policy
 */
public final class GetAccessPolicyInvoker extends ComponentEntityInvoker<AccessPolicyEntity> {
  private String id;

  public GetAccessPolicyInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The access policy id. */
  public final String getId() {
    return id;
  }

  /**
   * The access policy id. */
  public final GetAccessPolicyInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final AccessPolicyEntity invoke() throws InvokerException {
    // nifi-api/policies/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("policies");
    target = target.path(id);
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
