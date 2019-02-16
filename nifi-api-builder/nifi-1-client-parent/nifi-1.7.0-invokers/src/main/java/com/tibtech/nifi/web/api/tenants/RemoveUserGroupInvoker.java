package com.tibtech.nifi.web.api.tenants;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.UserGroupEntity;

/**
 * Deletes a user group
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class RemoveUserGroupInvoker extends ComponentEntityInvoker<UserGroupEntity> {
  private String id;

  private Long version;

  private Boolean disconnectedNodeAcknowledged;

  public RemoveUserGroupInvoker(final Transport transport) {
    super(transport);
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

  /**
   * The revision is used to verify the client is working with the latest version of the flow. */
  public final Long getVersion() {
    return version;
  }

  /**
   * The revision is used to verify the client is working with the latest version of the flow. */
  public final RemoveUserGroupInvoker setVersion(final Long version) {
    this.version = version;
    return this;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed. */
  public final Boolean getDisconnectedNodeAcknowledged() {
    return disconnectedNodeAcknowledged;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed. */
  public final RemoveUserGroupInvoker setDisconnectedNodeAcknowledged(
      final Boolean disconnectedNodeAcknowledged) {
    this.disconnectedNodeAcknowledged = disconnectedNodeAcknowledged;
    return this;
  }

  public final UserGroupEntity invoke() throws InvokerException {
    // nifi-apitenants/user-groups/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-apitenants");
    target = target.path("user-groups");
    target = target.path(id);
    target = target.queryParam("version", version);
    target = target.queryParam("clientId", getClientId());
    target = target.queryParam("disconnectedNodeAcknowledged", disconnectedNodeAcknowledged);
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
