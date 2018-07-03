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

/**
 * Updates the contents of a Process Group's variable Registry
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class UpdateVariableRegistryInvoker extends AbstractInvoker<VariableRegistryEntity> {
  private String id;

  private VariableRegistryEntity variableRegistryEntity;

  public UpdateVariableRegistryInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final UpdateVariableRegistryInvoker setId(final String id) {
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
  public final UpdateVariableRegistryInvoker setVariableRegistryEntity(
      final VariableRegistryEntity variableRegistryEntity) {
    this.variableRegistryEntity = variableRegistryEntity;
    return this;
  }

  public final VariableRegistryEntity invoke() throws InvokerException {
    // nifi-api/process-groups/{id}/variable-registry
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("variable-registry");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Entity<VariableRegistryEntity> entity = Entity.entity(variableRegistryEntity, "application/json");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleResponse(response, VariableRegistryEntity.class);
    }
    finally {
      response.close();
    }
  }
}
