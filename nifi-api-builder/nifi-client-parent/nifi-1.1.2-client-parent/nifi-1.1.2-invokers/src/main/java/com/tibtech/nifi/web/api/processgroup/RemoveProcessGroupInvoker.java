package com.tibtech.nifi.web.api.processgroup;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ProcessGroupEntity;

/**
 * Deletes a process group
 */
public final class RemoveProcessGroupInvoker extends ComponentEntityInvoker<ProcessGroupEntity> {
  private String id;

  public RemoveProcessGroupInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final RemoveProcessGroupInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final ProcessGroupEntity invoke() throws InvokerException {
    // /process-groups/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("process-groups");
    target = target.path(id);
    target = target.queryParam("version", getVersion());
    target = target.queryParam("clientId", getClientId());
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("DELETE");
    try {
      return handleComponentEntityResponse(response, ProcessGroupEntity.class);
    }
    finally {
      response.close();
    }
  }
}
