package com.tibtech.nifi.web.api.funnels;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.FunnelEntity;

public final class GetFunnelInvoker extends ComponentEntityInvoker<FunnelEntity> {
  private String id;

  public GetFunnelInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The funnel id. */
  public final String getId() {
    return id;
  }

  /**
   * The funnel id. */
  public final GetFunnelInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final FunnelEntity invoke() throws InvokerException {
    // /funnels/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("funnels");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleComponentEntityResponse(response, FunnelEntity.class);
    }
    finally {
      response.close();
    }
  }
}
