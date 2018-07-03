package com.tibtech.nifi.web.api.processgroup;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.io.InputStream;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.TemplateEntity;

/**
 * Uploads a template
 */
public final class UploadTemplateInvoker extends ComponentEntityInvoker<TemplateEntity> {
  private String id;

  private InputStream inputStream;

  public UploadTemplateInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final UploadTemplateInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final InputStream getInputStream() {
    return inputStream;
  }

  public final UploadTemplateInvoker setInputStream(final InputStream inputStream) {
    this.inputStream = inputStream;
    return this;
  }

  public final TemplateEntity invoke() throws InvokerException {
    // nifi-api/process-groups/{id}/templates/upload
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("templates");
    target = target.path("upload");
    final Invocation.Builder invocationBuilder = target.request("application/xml");
    final Entity<InputStream> entity = Entity.entity(inputStream, "multipart/form-data");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleComponentEntityResponse(response, TemplateEntity.class);
    }
    finally {
      response.close();
    }
  }
}
