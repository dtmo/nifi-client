package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.AboutEntity;

public final class GetAboutInfoInvoker extends AbstractInvoker<AboutEntity> {
  public GetAboutInfoInvoker(final Transport transport) {
    super(transport);
  }

  public final AboutEntity invoke() throws InvokerException {
    // /flow/about
    WebTarget target = getBaseWebTarget();
    target = target.path("flow");
    target = target.path("about");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, AboutEntity.class);
    }
    finally {
      response.close();
    }
  }
}
