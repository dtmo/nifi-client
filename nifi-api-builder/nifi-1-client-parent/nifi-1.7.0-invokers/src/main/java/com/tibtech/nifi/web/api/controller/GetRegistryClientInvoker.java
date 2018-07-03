package com.tibtech.nifi.web.api.controller;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.RegistryClientEntity;

/**
 * Gets a registry client
 */
public final class GetRegistryClientInvoker extends ComponentEntityInvoker<RegistryClientEntity> {
  private String id;

  public GetRegistryClientInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The registry id. */
  public final String getId() {
    return id;
  }

  /**
   * The registry id. */
  public final GetRegistryClientInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final RegistryClientEntity invoke() throws InvokerException {
    // nifi-api/controller/registry-clients/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("controller");
    target = target.path("registry-clients");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleComponentEntityResponse(response, RegistryClientEntity.class);
    }
    finally {
      response.close();
    }
  }
}
