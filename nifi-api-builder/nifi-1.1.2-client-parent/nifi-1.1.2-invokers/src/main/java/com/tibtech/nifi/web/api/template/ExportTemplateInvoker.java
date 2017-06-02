package com.tibtech.nifi.web.api.template;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.dto.TemplateDTO;

/**
 * Exports a template
 */
public final class ExportTemplateInvoker extends AbstractInvoker<TemplateDTO> {
  private String id;

  public ExportTemplateInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The template id. */
  public final String getId() {
    return id;
  }

  /**
   * The template id. */
  public final ExportTemplateInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final TemplateDTO invoke() throws InvokerException {
    // nifi-api/templates/{id}/download
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("templates");
    target = target.path(id);
    target = target.path("download");
    final Invocation.Builder invocationBuilder = target.request("application/xml");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, TemplateDTO.class);
    }
    finally {
      response.close();
    }
  }
}
