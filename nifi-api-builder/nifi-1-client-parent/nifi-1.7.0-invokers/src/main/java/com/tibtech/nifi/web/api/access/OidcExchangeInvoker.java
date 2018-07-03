package com.tibtech.nifi.web.api.access;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Retrieves a JWT following a successful login sequence using the configured OpenId Connect provider.
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class OidcExchangeInvoker extends AbstractInvoker<String> {
  public OidcExchangeInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final String invoke() throws InvokerException {
    // nifi-api/access/oidc/exchange
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("access");
    target = target.path("oidc");
    target = target.path("exchange");
    final Invocation.Builder invocationBuilder = target.request("text/plain");
    final Response response = invocationBuilder.method("POST");
    try {
      return handleResponse(response, String.class);
    }
    finally {
      response.close();
    }
  }
}
