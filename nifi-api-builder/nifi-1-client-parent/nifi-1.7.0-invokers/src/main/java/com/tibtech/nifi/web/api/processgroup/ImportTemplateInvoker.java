package com.tibtech.nifi.web.api.processgroup;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.TemplateEntity;

/**
 * Imports a template
 */
public final class ImportTemplateInvoker extends ComponentEntityInvoker<TemplateEntity> {
  private String id;

  private TemplateEntity templateEntity;

  public ImportTemplateInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final ImportTemplateInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final TemplateEntity getTemplateEntity() {
    return templateEntity;
  }

  public final ImportTemplateInvoker setTemplateEntity(final TemplateEntity templateEntity) {
    this.templateEntity = templateEntity;
    return this;
  }

  public final TemplateEntity invoke() throws InvokerException {
    // nifi-api/process-groups/{id}/templates/import
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("templates");
    target = target.path("import");
    final Invocation.Builder invocationBuilder = target.request("application/xml");
    final Entity<TemplateEntity> entity = Entity.entity(templateEntity, "application/xml");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleComponentEntityResponse(response, TemplateEntity.class);
    }
    finally {
      response.close();
    }
  }
}
