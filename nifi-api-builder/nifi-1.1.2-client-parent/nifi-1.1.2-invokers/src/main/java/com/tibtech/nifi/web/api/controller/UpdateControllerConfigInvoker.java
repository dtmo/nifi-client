package com.tibtech.nifi.web.api.controller;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ControllerConfigurationEntity;

/**
 * Retrieves the configuration for this NiFi
 */
public final class UpdateControllerConfigInvoker extends AbstractInvoker<ControllerConfigurationEntity> {
  private ControllerConfigurationEntity controllerConfigurationEntity;

  public UpdateControllerConfigInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The controller configuration. */
  public final ControllerConfigurationEntity getControllerConfigurationEntity() {
    return controllerConfigurationEntity;
  }

  /**
   * The controller configuration. */
  public final UpdateControllerConfigInvoker setControllerConfigurationEntity(final ControllerConfigurationEntity controllerConfigurationEntity) {
    this.controllerConfigurationEntity = controllerConfigurationEntity;
    return this;
  }

  public final ControllerConfigurationEntity invoke() throws InvokerException {
    // /controller/config
    WebTarget target = getBaseWebTarget();
    target = target.path("controller");
    target = target.path("config");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Entity<ControllerConfigurationEntity> entity = Entity.entity(controllerConfigurationEntity, "application/json");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleResponse(response, ControllerConfigurationEntity.class);
    }
    finally {
      response.close();
    }
  }
}
