package com.tibtech.nifi.web.api.versions;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Boolean;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.VersionedFlowUpdateRequestEntity;

/**
 * Deletes the Update Request with the given ID
 * <p>Deletes the Update Request with the given ID. After a request is created via a POST to /versions/update-requests/process-groups/{id}, it is expected that the client will properly clean up the request by DELETE'ing it, once the Update process has completed. If the request is deleted before the request completes, then the Update request will finish the step that it is currently performing and then will cancel any subsequent steps. Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class DeleteUpdateRequestInvoker extends AbstractInvoker<VersionedFlowUpdateRequestEntity> {
  private String id;

  private Boolean disconnectedNodeAcknowledged;

  public DeleteUpdateRequestInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The ID of the Update Request */
  public final String getId() {
    return id;
  }

  /**
   * The ID of the Update Request */
  public final DeleteUpdateRequestInvoker setId(final String id) {
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
  public final DeleteUpdateRequestInvoker setDisconnectedNodeAcknowledged(
      final Boolean disconnectedNodeAcknowledged) {
    this.disconnectedNodeAcknowledged = disconnectedNodeAcknowledged;
    return this;
  }

  public final VersionedFlowUpdateRequestEntity invoke() throws InvokerException {
    // nifi-api/versions/update-requests/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("versions");
    target = target.path("update-requests");
    target = target.path(id);
    target = target.queryParam("disconnectedNodeAcknowledged", disconnectedNodeAcknowledged);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("DELETE");
    try {
      return handleResponse(response, VersionedFlowUpdateRequestEntity.class);
    }
    finally {
      response.close();
    }
  }
}
