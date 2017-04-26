package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Generates a client id.
 */
public final class GenerateClientIdInvoker extends AbstractInvoker<String> {
  public GenerateClientIdInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final String invoke() throws InvokerException {
    // /flow/client-id
    WebTarget target = getBaseWebTarget();
    target = target.path("flow");
    target = target.path("client-id");
    final Invocation.Builder invocationBuilder = target.request("text/plain");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, String.class);
    }
    finally {
      response.close();
    }
  }
}
