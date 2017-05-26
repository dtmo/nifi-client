package com.tibtech.nifi.web.api.process.groups;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.FlowEntity;
import org.apache.nifi.web.api.entity.InstantiateTemplateRequestEntity;

public final class InstantiateTemplateInvoker extends AbstractInvoker<FlowEntity> {
  private String id;

  private InstantiateTemplateRequestEntity instantiateTemplateRequestEntity;

  public InstantiateTemplateInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final InstantiateTemplateInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The instantiate template request. */
  public final InstantiateTemplateRequestEntity getInstantiateTemplateRequestEntity() {
    return instantiateTemplateRequestEntity;
  }

  /**
   * The instantiate template request. */
  public final InstantiateTemplateInvoker setInstantiateTemplateRequestEntity(final InstantiateTemplateRequestEntity instantiateTemplateRequestEntity) {
    this.instantiateTemplateRequestEntity = instantiateTemplateRequestEntity;
    return this;
  }

  public final FlowEntity invoke() throws InvokerException {
    // /process-groups/{id}/template-instance
    WebTarget target = getBaseWebTarget();
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("template-instance");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Entity<InstantiateTemplateRequestEntity> entity = Entity.entity(instantiateTemplateRequestEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleResponse(response, FlowEntity.class);
    }
    finally {
      response.close();
    }
  }
}
