package com.tibtech.nifi.web.api.access;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Void;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Redirect/callback URI for processing the result of the Apache Knox login sequence.
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class KnoxCallbackInvoker extends AbstractInvoker<Void> {
  public KnoxCallbackInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final Void invoke() throws InvokerException {
    // nifi-api/access/knox/callback
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("access");
    target = target.path("knox");
    target = target.path("callback");
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
