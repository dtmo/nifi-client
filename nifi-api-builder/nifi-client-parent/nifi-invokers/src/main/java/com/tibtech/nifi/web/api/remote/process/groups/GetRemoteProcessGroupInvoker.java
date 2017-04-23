package com.tibtech.nifi.web.api.remote.process.groups;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.RemoteProcessGroupEntity;

public final class GetRemoteProcessGroupInvoker extends ComponentEntityInvoker<RemoteProcessGroupEntity> {
  private String id;

  public GetRemoteProcessGroupInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The remote process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The remote process group id. */
  public final GetRemoteProcessGroupInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final RemoteProcessGroupEntity invoke() throws InvokerException {
    // /remote-process-groups/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("remote-process-groups");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleComponentEntityResponse(response, RemoteProcessGroupEntity.class);
    }
    finally {
      response.close();
    }
  }
}
