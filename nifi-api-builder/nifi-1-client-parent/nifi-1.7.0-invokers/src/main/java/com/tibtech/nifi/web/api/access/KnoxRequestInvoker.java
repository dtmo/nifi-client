package com.tibtech.nifi.web.api.access;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Void;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Initiates a request to authenticate through Apache Knox.
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class KnoxRequestInvoker extends AbstractInvoker<Void> {
  public KnoxRequestInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final Void invoke() throws InvokerException {
    // nifi-api/access/knox/request
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("access");
    target = target.path("knox");
    target = target.path("request");
    final Invocation.Builder invocationBuilder = target.request("*/*");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, Void.class);
    }
    finally {
      response.close();
    }
  }
}
