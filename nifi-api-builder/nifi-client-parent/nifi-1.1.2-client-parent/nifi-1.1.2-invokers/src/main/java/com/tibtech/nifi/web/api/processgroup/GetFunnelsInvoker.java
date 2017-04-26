package com.tibtech.nifi.web.api.processgroup;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.FunnelsEntity;

/**
 * Gets all funnels
 */
public final class GetFunnelsInvoker extends AbstractInvoker<FunnelsEntity> {
  private String id;

  public GetFunnelsInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final GetFunnelsInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final FunnelsEntity invoke() throws InvokerException {
    // /process-groups/{id}/funnels
    WebTarget target = getBaseWebTarget();
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("funnels");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, FunnelsEntity.class);
    }
    finally {
      response.close();
    }
  }
}
