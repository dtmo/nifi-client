package com.tibtech.nifi.web.api.sitetosite;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.PeersEntity;

/**
 * Returns the available Peers and its status of this NiFi
 */
public final class GetPeersInvoker extends AbstractInvoker<PeersEntity> {
  public GetPeersInvoker(final Transport transport) {
    super(transport);
  }

  public final PeersEntity invoke() throws InvokerException {
    // nifi-api/site-to-site/peers
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("site-to-site");
    target = target.path("peers");
    final Invocation.Builder invocationBuilder = target.request("application/json, application/xml");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, PeersEntity.class);
    }
    finally {
      response.close();
    }
  }
}
