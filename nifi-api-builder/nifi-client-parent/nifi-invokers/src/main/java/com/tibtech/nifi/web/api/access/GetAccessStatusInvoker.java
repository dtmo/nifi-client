package com.tibtech.nifi.web.api.access;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.AccessStatusEntity;

public final class GetAccessStatusInvoker extends AbstractInvoker<AccessStatusEntity> {
  public GetAccessStatusInvoker(final Transport transport) {
    super(transport);
  }

  public final AccessStatusEntity invoke() throws InvokerException {
    // /access
    WebTarget target = getBaseWebTarget();
    target = target.path("access");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, AccessStatusEntity.class);
    }
    finally {
      response.close();
    }
  }
}
