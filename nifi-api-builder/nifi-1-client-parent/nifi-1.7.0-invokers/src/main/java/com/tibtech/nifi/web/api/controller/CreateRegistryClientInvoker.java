package com.tibtech.nifi.web.api.controller;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.RegistryClientEntity;

/**
 * Creates a new registry client
 */
public final class CreateRegistryClientInvoker extends ComponentEntityInvoker<RegistryClientEntity> {
  private RegistryClientEntity registryClientEntity;

  public CreateRegistryClientInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The registry configuration details. */
  public final RegistryClientEntity getRegistryClientEntity() {
    return registryClientEntity;
  }

  /**
   * The registry configuration details. */
  public final CreateRegistryClientInvoker setRegistryClientEntity(
      final RegistryClientEntity registryClientEntity) {
    this.registryClientEntity = registryClientEntity;
    return this;
  }

  public final RegistryClientEntity invoke() throws InvokerException {
    // nifi-api/controller/registry-clients
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("controller");
    target = target.path("registry-clients");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    registryClientEntity.setRevision(createRevisionDto());
    final Entity<RegistryClientEntity> entity = Entity.entity(registryClientEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleComponentEntityResponse(response, RegistryClientEntity.class);
    }
    finally {
      response.close();
    }
  }
}
