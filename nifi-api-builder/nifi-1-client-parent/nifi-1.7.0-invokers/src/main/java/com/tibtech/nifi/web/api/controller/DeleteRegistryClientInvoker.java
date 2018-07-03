package com.tibtech.nifi.web.api.controller;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Boolean;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.RegistryClientEntity;

/**
 * Deletes a registry client
 */
public final class DeleteRegistryClientInvoker extends ComponentEntityInvoker<RegistryClientEntity> {
  private String id;

  private Boolean disconnectedNodeAcknowledged;

  public DeleteRegistryClientInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The registry id. */
  public final String getId() {
    return id;
  }

  /**
   * The registry id. */
  public final DeleteRegistryClientInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed. */
  public final Boolean getDisconnectedNodeAcknowledged() {
    return disconnectedNodeAcknowledged;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed. */
  public final DeleteRegistryClientInvoker setDisconnectedNodeAcknowledged(
      final Boolean disconnectedNodeAcknowledged) {
    this.disconnectedNodeAcknowledged = disconnectedNodeAcknowledged;
    return this;
  }

  public final RegistryClientEntity invoke() throws InvokerException {
    // nifi-api/controller/registry-clients/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("controller");
    target = target.path("registry-clients");
    target = target.path(id);
    target = target.queryParam("version", getVersion());
    target = target.queryParam("clientId", getClientId());
    target = target.queryParam("disconnectedNodeAcknowledged", disconnectedNodeAcknowledged);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("DELETE");
    try {
      return handleComponentEntityResponse(response, RegistryClientEntity.class);
    }
    finally {
      response.close();
    }
  }
}
