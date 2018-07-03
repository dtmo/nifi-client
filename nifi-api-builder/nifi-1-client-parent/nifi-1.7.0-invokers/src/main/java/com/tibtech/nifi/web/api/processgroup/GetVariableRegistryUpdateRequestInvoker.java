package com.tibtech.nifi.web.api.processgroup;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.VariableRegistryUpdateRequestEntity;

/**
 * Gets a process group's variable registry
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class GetVariableRegistryUpdateRequestInvoker extends AbstractInvoker<VariableRegistryUpdateRequestEntity> {
  private String groupId;

  private String updateId;

  public GetVariableRegistryUpdateRequestInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getGroupId() {
    return groupId;
  }

  /**
   * The process group id. */
  public final GetVariableRegistryUpdateRequestInvoker setGroupId(final String groupId) {
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
  public final GetVariableRegistryUpdateRequestInvoker setUpdateId(final String updateId) {
    this.updateId = updateId;
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
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, VariableRegistryUpdateRequestEntity.class);
    }
    finally {
      response.close();
    }
  }
}
