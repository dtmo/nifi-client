package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.TemplatesEntity;

public final class GetTemplatesInvoker extends AbstractInvoker<TemplatesEntity> {
  public GetTemplatesInvoker(final Transport transport) {
    super(transport);
  }

  public final TemplatesEntity invoke() throws InvokerException {
    // /flow/templates
    WebTarget target = getBaseWebTarget();
    target = target.path("flow");
    target = target.path("templates");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, TemplatesEntity.class);
    }
    finally {
      response.close();
    }
  }
}
