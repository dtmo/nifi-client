package com.tibtech.nifi.web.api.access;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public final class CreateUiExtensionTokenInvoker extends AbstractInvoker<String> {
  public CreateUiExtensionTokenInvoker(final Transport transport) {
    super(transport);
  }

  public final String invoke() throws InvokerException {
    // /access/ui-extension-token
    WebTarget target = getBaseWebTarget();
    target = target.path("access");
    target = target.path("ui-extension-token");
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
