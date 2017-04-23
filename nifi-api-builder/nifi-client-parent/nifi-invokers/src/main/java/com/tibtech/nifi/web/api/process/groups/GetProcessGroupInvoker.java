package com.tibtech.nifi.web.api.process.groups;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ProcessGroupEntity;

public final class GetProcessGroupInvoker extends ComponentEntityInvoker<ProcessGroupEntity> {
  private String id;

  public GetProcessGroupInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final GetProcessGroupInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final ProcessGroupEntity invoke() throws InvokerException {
    // /process-groups/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("process-groups");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleComponentEntityResponse(response, ProcessGroupEntity.class);
    }
    finally {
      response.close();
    }
  }
}
