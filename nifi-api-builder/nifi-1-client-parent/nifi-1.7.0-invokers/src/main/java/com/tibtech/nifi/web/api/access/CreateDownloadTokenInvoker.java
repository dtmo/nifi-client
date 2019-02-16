package com.tibtech.nifi.web.api.access;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Creates a single use access token for downloading FlowFile content.
 * <p>The token returned is a base64 encoded string. It is valid for a single request up to five minutes from being issued. It is used as a query parameter name 'access_token'.</p>
 */
public final class CreateDownloadTokenInvoker extends AbstractInvoker<String> {
  public CreateDownloadTokenInvoker(final Transport transport) {
    super(transport);
  }

  public final String invoke() throws InvokerException {
    // nifi-api/access/download-token
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("access");
    target = target.path("download-token");
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
