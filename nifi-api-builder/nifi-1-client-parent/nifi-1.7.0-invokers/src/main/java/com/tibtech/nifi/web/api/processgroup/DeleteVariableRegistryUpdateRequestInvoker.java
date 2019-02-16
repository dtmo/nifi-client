package com.tibtech.nifi.web.api.processgroup;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Boolean;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.VariableRegistryUpdateRequestEntity;

/**
 * Deletes an update request for a process group's variable registry. If the request is not yet complete, it will automatically be cancelled.
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class DeleteVariableRegistryUpdateRequestInvoker extends AbstractInvoker<VariableRegistryUpdateRequestEntity> {
  private String groupId;

  private String updateId;

  private Boolean disconnectedNodeAcknowledged;

  public DeleteVariableRegistryUpdateRequestInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The process group id. */
  public final String getGroupId() {
    return groupId;
  }

  /**
   * The process group id. */
  public final DeleteVariableRegistryUpdateRequestInvoker setGroupId(final String groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * The ID of the Variable Registry Update Request */
  public final String getUpdateId() {
    return updateId;
  }

  /**
   * The ID of the Variable Registry Update Request */
  public final DeleteVariableRegistryUpdateRequestInvoker setUpdateId(final String updateId) {
    this.updateId = updateId;
    return this;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed. */
  public final Boolean getDisconnectedNodeAcknowledged() {
    return disconnectedNodeAcknowledged;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed. */
  public final DeleteVariableRegistryUpdateRequestInvoker setDisconnectedNodeAcknowledged(
      final Boolean disconnectedNodeAcknowledged) {
    this.disconnectedNodeAcknowledged = disconnectedNodeAcknowledged;
    return this;
  }

  public final VariableRegistryUpdateRequestEntity invoke() throws InvokerException {
    // nifi-api/process-groups/{groupId}/variable-registry/update-requests/{updateId}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("process-groups");
    target = target.path(groupId);
    target = target.path("variable-registry");
    target = target.path("update-requests");
    target = target.path(updateId);
    target = target.queryParam("disconnectedNodeAcknowledged", disconnectedNodeAcknowledged);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("DELETE");
    try {
      return handleResponse(response, VariableRegistryUpdateRequestEntity.class);
    }
    finally {
      response.close();
    }
  }
}
