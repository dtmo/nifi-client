package com.tibtech.nifi.web.api.controller;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ControllerConfigurationEntity;

/**
 * Retrieves the configuration for this NiFi Controller
 */
public final class GetControllerConfigInvoker extends AbstractInvoker<ControllerConfigurationEntity> {
  public GetControllerConfigInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final ControllerConfigurationEntity invoke() throws InvokerException {
    // /controller/config
    WebTarget target = getBaseWebTarget();
    target = target.path("controller");
    target = target.path("config");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ControllerConfigurationEntity.class);
    }
    finally {
      response.close();
    }
  }
}
