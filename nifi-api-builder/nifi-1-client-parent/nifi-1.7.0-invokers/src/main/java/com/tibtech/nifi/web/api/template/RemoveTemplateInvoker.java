package com.tibtech.nifi.web.api.template;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Boolean;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.TemplateEntity;

/**
 * Deletes a template
 */
public final class RemoveTemplateInvoker extends ComponentEntityInvoker<TemplateEntity> {
  private String id;

  private Boolean disconnectedNodeAcknowledged;

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

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed. */
  public final Boolean getDisconnectedNodeAcknowledged() {
    return disconnectedNodeAcknowledged;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed. */
  public final RemoveTemplateInvoker setDisconnectedNodeAcknowledged(
      final Boolean disconnectedNodeAcknowledged) {
    this.disconnectedNodeAcknowledged = disconnectedNodeAcknowledged;
    return this;
  }

  public final TemplateEntity invoke() throws InvokerException {
    // nifi-api/templates/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("templates");
    target = target.path(id);
    target = target.queryParam("disconnectedNodeAcknowledged", disconnectedNodeAcknowledged);
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
