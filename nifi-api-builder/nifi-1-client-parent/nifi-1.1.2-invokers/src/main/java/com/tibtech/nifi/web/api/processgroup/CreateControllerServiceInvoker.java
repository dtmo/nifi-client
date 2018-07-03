package com.tibtech.nifi.web.api.processgroup;

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
 * Creates a new controller service
 */
public final class CreateControllerServiceInvoker extends ComponentEntityInvoker<ControllerServiceEntity> {
  private String id;

  private ControllerServiceEntity controllerServiceEntity;

  public CreateControllerServiceInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final CreateControllerServiceInvoker setId(final String id) {
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
  public final CreateControllerServiceInvoker setControllerServiceEntity(final ControllerServiceEntity controllerServiceEntity) {
    this.controllerServiceEntity = controllerServiceEntity;
    return this;
  }

  public final ControllerServiceEntity invoke() throws InvokerException {
    // nifi-api/process-groups/{id}/controller-services
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("controller-services");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    controllerServiceEntity.setRevision(createRevisionDto());
    final Entity<ControllerServiceEntity> entity = Entity.entity(controllerServiceEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleComponentEntityResponse(response, ControllerServiceEntity.class);
    }
    finally {
      response.close();
    }
  }
}
