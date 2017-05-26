package com.tibtech.nifi.web.api.controller.services;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ControllerServiceReferencingComponentsEntity;
import org.apache.nifi.web.api.entity.UpdateControllerServiceReferenceRequestEntity;

public final class UpdateControllerServiceReferencesInvoker extends AbstractInvoker<ControllerServiceReferencingComponentsEntity> {
  private String id;

  private UpdateControllerServiceReferenceRequestEntity updateControllerServiceReferenceRequestEntity;

  public UpdateControllerServiceReferencesInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The controller service id. */
  public final String getId() {
    return id;
  }

  /**
   * The controller service id. */
  public final UpdateControllerServiceReferencesInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The controller service request update request. */
  public final UpdateControllerServiceReferenceRequestEntity getUpdateControllerServiceReferenceRequestEntity() {
    return updateControllerServiceReferenceRequestEntity;
  }

  /**
   * The controller service request update request. */
  public final UpdateControllerServiceReferencesInvoker setUpdateControllerServiceReferenceRequestEntity(final UpdateControllerServiceReferenceRequestEntity updateControllerServiceReferenceRequestEntity) {
    this.updateControllerServiceReferenceRequestEntity = updateControllerServiceReferenceRequestEntity;
    return this;
  }

  public final ControllerServiceReferencingComponentsEntity invoke() throws InvokerException {
    // /controller-services/{id}/references
    WebTarget target = getBaseWebTarget();
    target = target.path("controller-services");
    target = target.path(id);
    target = target.path("references");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Entity<UpdateControllerServiceReferenceRequestEntity> entity = Entity.entity(updateControllerServiceReferenceRequestEntity, "application/json");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleResponse(response, ControllerServiceReferencingComponentsEntity.class);
    }
    finally {
      response.close();
    }
  }
}
