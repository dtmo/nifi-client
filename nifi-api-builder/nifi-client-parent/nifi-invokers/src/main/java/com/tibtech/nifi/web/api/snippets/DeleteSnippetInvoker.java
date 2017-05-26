package com.tibtech.nifi.web.api.snippets;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.SnippetEntity;

public final class DeleteSnippetInvoker extends AbstractInvoker<SnippetEntity> {
  private String id;

  public DeleteSnippetInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The snippet id. */
  public final String getId() {
    return id;
  }

  /**
   * The snippet id. */
  public final DeleteSnippetInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final SnippetEntity invoke() throws InvokerException {
    // /snippets/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("snippets");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("DELETE");
    try {
      return handleResponse(response, SnippetEntity.class);
    }
    finally {
      response.close();
    }
  }
}
