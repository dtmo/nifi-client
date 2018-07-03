package com.tibtech.nifi.web.api.accesspolicy;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Boolean;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.AccessPolicyEntity;

/**
 * Deletes an access policy
 */
public final class RemoveAccessPolicyInvoker extends ComponentEntityInvoker<AccessPolicyEntity> {
  private String id;

  private Boolean disconnectedNodeAcknowledged;

  public RemoveAccessPolicyInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The access policy id. */
  public final String getId() {
    return id;
  }

  /**
   * The access policy id. */
  public final RemoveAccessPolicyInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed. */
  public final Boolean getDisconnectedNodeAcknowledged() {
    return disconnectedNodeAcknowledged;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed. */
  public final RemoveAccessPolicyInvoker setDisconnectedNodeAcknowledged(
      final Boolean disconnectedNodeAcknowledged) {
    this.disconnectedNodeAcknowledged = disconnectedNodeAcknowledged;
    return this;
  }

  public final AccessPolicyEntity invoke() throws InvokerException {
    // nifi-api/policies/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("policies");
    target = target.path(id);
    target = target.queryParam("version", getVersion());
    target = target.queryParam("clientId", getClientId());
    target = target.queryParam("disconnectedNodeAcknowledged", disconnectedNodeAcknowledged);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("DELETE");
    try {
      return handleComponentEntityResponse(response, AccessPolicyEntity.class);
    }
    finally {
      response.close();
    }
  }
}
