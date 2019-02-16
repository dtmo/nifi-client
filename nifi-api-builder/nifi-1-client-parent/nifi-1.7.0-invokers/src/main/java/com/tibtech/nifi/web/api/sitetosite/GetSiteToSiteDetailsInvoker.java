package com.tibtech.nifi.web.api.sitetosite;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ControllerEntity;

/**
 * Returns the details about this NiFi necessary to communicate via site to site
 */
public final class GetSiteToSiteDetailsInvoker extends AbstractInvoker<ControllerEntity> {
  public GetSiteToSiteDetailsInvoker(final Transport transport) {
    super(transport);
  }

  public final ControllerEntity invoke() throws InvokerException {
    // nifi-api/site-to-site
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("site-to-site");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ControllerEntity.class);
    }
    finally {
      response.close();
    }
  }
}
