package com.tibtech.nifi.web.api.versions;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.VersionedFlowUpdateRequestEntity;

/**
 * Returns the Revert Request with the given ID
 * <p>Returns the Revert Request with the given ID. Once a Revert Request has been created by performing a POST to /versions/revert-requests/process-groups/{id}, that request can subsequently be retrieved via this endpoint, and the request that is fetched will contain the updated state, such as percent complete, the current state of the request, and any failures. Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class GetRevertRequestInvoker extends AbstractInvoker<VersionedFlowUpdateRequestEntity> {
  private String id;

  public GetRevertRequestInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The ID of the Revert Request */
  public final String getId() {
    return id;
  }

  /**
   * The ID of the Revert Request */
  public final GetRevertRequestInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final VersionedFlowUpdateRequestEntity invoke() throws InvokerException {
    // nifi-api/versions/revert-requests/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("versions");
    target = target.path("revert-requests");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, VersionedFlowUpdateRequestEntity.class);
    }
    finally {
      response.close();
    }
  }
}
