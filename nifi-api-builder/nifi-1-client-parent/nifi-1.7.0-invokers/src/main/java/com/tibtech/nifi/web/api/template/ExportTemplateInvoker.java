package com.tibtech.nifi.web.api.template;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Exports a template
 */
public final class ExportTemplateInvoker extends AbstractInvoker<String> {
  private String id;

  public ExportTemplateInvoker(final Transport transport) {
    super(transport);
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

  public final String invoke() throws InvokerException {
    // nifi-api/templates/{id}/download
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("templates");
    target = target.path(id);
    target = target.path("download");
    final Invocation.Builder invocationBuilder = target.request("application/xml");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, String.class);
    }
    finally {
      response.close();
    }
  }
}
