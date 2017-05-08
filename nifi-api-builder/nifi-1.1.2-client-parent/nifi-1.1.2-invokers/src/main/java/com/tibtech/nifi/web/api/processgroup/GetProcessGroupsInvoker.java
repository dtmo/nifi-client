package com.tibtech.nifi.web.api.processgroup;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ProcessGroupsEntity;

/**
 * Gets all process groups
 */
public final class GetProcessGroupsInvoker extends AbstractInvoker<ProcessGroupsEntity> {
  private String id;

  public GetProcessGroupsInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final GetProcessGroupsInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final ProcessGroupsEntity invoke() throws InvokerException {
    // /process-groups/{id}/process-groups
    WebTarget target = getBaseWebTarget();
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("process-groups");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ProcessGroupsEntity.class);
    }
    finally {
      response.close();
    }
  }
}
