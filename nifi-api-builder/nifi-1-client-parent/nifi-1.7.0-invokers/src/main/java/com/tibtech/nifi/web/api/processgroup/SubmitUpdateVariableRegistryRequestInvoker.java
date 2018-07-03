package com.tibtech.nifi.web.api.processgroup;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.VariableRegistryEntity;
import org.apache.nifi.web.api.entity.VariableRegistryUpdateRequestEntity;

/**
 * Submits a request to update a process group's variable registry
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class SubmitUpdateVariableRegistryRequestInvoker extends AbstractInvoker<VariableRegistryUpdateRequestEntity> {
  private String id;

  private VariableRegistryEntity variableRegistryEntity;

  public SubmitUpdateVariableRegistryRequestInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final SubmitUpdateVariableRegistryRequestInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The variable registry configuration details. */
  public final VariableRegistryEntity getVariableRegistryEntity() {
    return variableRegistryEntity;
  }

  /**
   * The variable registry configuration details. */
  public final SubmitUpdateVariableRegistryRequestInvoker setVariableRegistryEntity(
      final VariableRegistryEntity variableRegistryEntity) {
    this.variableRegistryEntity = variableRegistryEntity;
    return this;
  }

  public final VariableRegistryUpdateRequestEntity invoke() throws InvokerException {
    // nifi-api/process-groups/{id}/variable-registry/update-requests
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("variable-registry");
    target = target.path("update-requests");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Entity<VariableRegistryEntity> entity = Entity.entity(variableRegistryEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleResponse(response, VariableRegistryUpdateRequestEntity.class);
    }
    finally {
      response.close();
    }
  }
}
