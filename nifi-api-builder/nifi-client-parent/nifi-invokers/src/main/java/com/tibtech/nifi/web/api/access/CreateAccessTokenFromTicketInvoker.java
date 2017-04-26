package com.tibtech.nifi.web.api.access;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Creates a token for accessing the REST API via Kerberos ticket exchange / SPNEGO negotiation
 */
public final class CreateAccessTokenFromTicketInvoker extends AbstractInvoker<String> {
  public CreateAccessTokenFromTicketInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final String invoke() throws InvokerException {
    // /access/kerberos
    WebTarget target = getBaseWebTarget();
    target = target.path("access");
    target = target.path("kerberos");
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
