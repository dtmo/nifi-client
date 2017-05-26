package com.tibtech.nifi.web.api.process.groups;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.CreateTemplateRequestEntity;
import org.apache.nifi.web.api.entity.TemplateEntity;

public final class CreateTemplateInvoker extends ComponentEntityInvoker<TemplateEntity> {
  private String id;

  private CreateTemplateRequestEntity createTemplateRequestEntity;

  public CreateTemplateInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final CreateTemplateInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The create template request. */
  public final CreateTemplateRequestEntity getCreateTemplateRequestEntity() {
    return createTemplateRequestEntity;
  }

  /**
   * The create template request. */
  public final CreateTemplateInvoker setCreateTemplateRequestEntity(final CreateTemplateRequestEntity createTemplateRequestEntity) {
    this.createTemplateRequestEntity = createTemplateRequestEntity;
    return this;
  }

  public final TemplateEntity invoke() throws InvokerException {
    // /process-groups/{id}/templates
    WebTarget target = getBaseWebTarget();
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("templates");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Entity<CreateTemplateRequestEntity> entity = Entity.entity(createTemplateRequestEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleComponentEntityResponse(response, TemplateEntity.class);
    }
    finally {
      response.close();
    }
  }
}
