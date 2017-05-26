package com.tibtech.nifi.web.api.processgroup;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.io.IOException;
import java.io.InputStream;
import java.lang.IllegalStateException;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.TemplateEntity;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.file.StreamDataBodyPart;

/**
 * Uploads a template
 */
public final class UploadTemplateInvoker extends ComponentEntityInvoker<TemplateEntity> {
  private String id;

  private InputStream template;

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

  public final InputStream getTemplate() {
    return template;
  }

  public final UploadTemplateInvoker setTemplate(final InputStream template) {
    this.template = template;
    return this;
  }

  public final TemplateEntity invoke() throws InvokerException {
    // /process-groups/{id}/templates/upload
    WebTarget target = getBaseWebTarget();
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("templates");
    target = target.path("upload");
    final FormDataMultiPart formDataMultiPart = new FormDataMultiPart();
    final StreamDataBodyPart streamDataBodyPart = new StreamDataBodyPart("template", template);
    formDataMultiPart.bodyPart(streamDataBodyPart);
    final Entity<FormDataMultiPart> entity = Entity.entity(formDataMultiPart, formDataMultiPart.getMediaType());
    final Invocation.Builder invocationBuilder = target.request("application/xml");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleComponentEntityResponse(response, TemplateEntity.class);
    }
    finally {
      response.close();
      try {
        formDataMultiPart.close();
      }
      catch (final IOException e) {
        throw new IllegalStateException("Could not close form data multipart", e);
      }
    }
  }
}
