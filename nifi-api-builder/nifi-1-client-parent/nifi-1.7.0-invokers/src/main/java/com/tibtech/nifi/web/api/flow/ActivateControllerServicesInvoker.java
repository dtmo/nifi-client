package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ActivateControllerServicesEntity;

/**
 * Enable or disable Controller Services in the specified Process Group.
 */
public final class ActivateControllerServicesInvoker extends AbstractInvoker<ActivateControllerServicesEntity> {
  private String id;

  private ActivateControllerServicesEntity activateControllerServicesEntity;

  public ActivateControllerServicesInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final ActivateControllerServicesInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The request to schedule or unschedule. If the comopnents in the request are not specified, all authorized components will be considered. */
  public final ActivateControllerServicesEntity getActivateControllerServicesEntity() {
    return activateControllerServicesEntity;
  }

  /**
   * The request to schedule or unschedule. If the comopnents in the request are not specified, all authorized components will be considered. */
  public final ActivateControllerServicesInvoker setActivateControllerServicesEntity(
      final ActivateControllerServicesEntity activateControllerServicesEntity) {
    this.activateControllerServicesEntity = activateControllerServicesEntity;
    return this;
  }

  public final ActivateControllerServicesEntity invoke() throws InvokerException {
    // nifi-api/flow/process-groups/{id}/controller-services
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flow");
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("controller-services");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Entity<ActivateControllerServicesEntity> entity = Entity.entity(activateControllerServicesEntity, "application/json");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleResponse(response, ActivateControllerServicesEntity.class);
    }
    finally {
      response.close();
    }
  }
}
