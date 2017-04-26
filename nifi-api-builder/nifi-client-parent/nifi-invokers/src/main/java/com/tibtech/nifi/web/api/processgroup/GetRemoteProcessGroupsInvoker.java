package com.tibtech.nifi.web.api.processgroup;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.RemoteProcessGroupsEntity;

/**
 * Gets all remote process groups
 */
public final class GetRemoteProcessGroupsInvoker extends AbstractInvoker<RemoteProcessGroupsEntity> {
  private String id;

  public GetRemoteProcessGroupsInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final GetRemoteProcessGroupsInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final RemoteProcessGroupsEntity invoke() throws InvokerException {
    // /process-groups/{id}/remote-process-groups
    WebTarget target = getBaseWebTarget();
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("remote-process-groups");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, RemoteProcessGroupsEntity.class);
    }
    finally {
      response.close();
    }
  }
}
