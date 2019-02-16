package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.BannerEntity;

/**
 * Retrieves the banners for this NiFi
 */
public final class GetBannersInvoker extends AbstractInvoker<BannerEntity> {
  public GetBannersInvoker(final Transport transport) {
    super(transport);
  }

  public final BannerEntity invoke() throws InvokerException {
    // nifi-api/flow/banners
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flow");
    target = target.path("banners");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, BannerEntity.class);
    }
    finally {
      response.close();
    }
  }
}
