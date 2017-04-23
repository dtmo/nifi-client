package com.tibtech.nifi.web.api.templates;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.TemplateEntity;

public final class RemoveTemplateInvoker extends ComponentEntityInvoker<TemplateEntity> {
  private String id;

  public RemoveTemplateInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The template id. */
  public final String getId() {
    return id;
  }

  /**
   * The template id. */
  public final RemoveTemplateInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final TemplateEntity invoke() throws InvokerException {
    // /templates/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("templates");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("DELETE");
    try {
      return handleComponentEntityResponse(response, TemplateEntity.class);
    }
    finally {
      response.close();
    }
  }
}
