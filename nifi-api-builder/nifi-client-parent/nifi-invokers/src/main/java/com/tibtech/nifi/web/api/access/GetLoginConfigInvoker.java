package com.tibtech.nifi.web.api.access;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.AccessConfigurationEntity;

public final class GetLoginConfigInvoker extends AbstractInvoker<AccessConfigurationEntity> {
  public GetLoginConfigInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final AccessConfigurationEntity invoke() throws InvokerException {
    // /access/config
    WebTarget target = getBaseWebTarget();
    target = target.path("access");
    target = target.path("config");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, AccessConfigurationEntity.class);
    }
    finally {
      response.close();
    }
  }
}
