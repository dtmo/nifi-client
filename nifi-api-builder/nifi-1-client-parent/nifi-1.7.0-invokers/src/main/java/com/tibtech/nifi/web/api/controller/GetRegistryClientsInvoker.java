package com.tibtech.nifi.web.api.controller;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.RegistryClientsEntity;

/**
 * Gets the listing of available registry clients
 */
public final class GetRegistryClientsInvoker extends AbstractInvoker<RegistryClientsEntity> {
  public GetRegistryClientsInvoker(final Transport transport) {
    super(transport);
  }

  public final RegistryClientsEntity invoke() throws InvokerException {
    // nifi-api/controller/registry-clients
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("controller");
    target = target.path("registry-clients");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, RegistryClientsEntity.class);
    }
    finally {
      response.close();
    }
  }
}
