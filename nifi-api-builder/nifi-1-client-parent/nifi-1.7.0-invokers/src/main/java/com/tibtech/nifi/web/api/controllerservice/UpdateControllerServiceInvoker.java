package com.tibtech.nifi.web.api.controllerservice;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ControllerServiceEntity;

/**
 * Updates a controller service
 */
public final class UpdateControllerServiceInvoker extends ComponentEntityInvoker<ControllerServiceEntity> {
  private String id;

  private ControllerServiceEntity controllerServiceEntity;

  public UpdateControllerServiceInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The controller service id. */
  public final String getId() {
    return id;
  }

  /**
   * The controller service id. */
  public final UpdateControllerServiceInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The controller service configuration details. */
  public final ControllerServiceEntity getControllerServiceEntity() {
    return controllerServiceEntity;
  }

  /**
   * The controller service configuration details. */
  public final UpdateControllerServiceInvoker setControllerServiceEntity(
      final ControllerServiceEntity controllerServiceEntity) {
    this.controllerServiceEntity = controllerServiceEntity;
    return this;
  }

  public final ControllerServiceEntity invoke() throws InvokerException {
    // nifi-api/controller-services/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("controller-services");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Entity<ControllerServiceEntity> entity = Entity.entity(controllerServiceEntity, "application/json");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleComponentEntityResponse(response, ControllerServiceEntity.class);
    }
    finally {
      response.close();
    }
  }
}
