package com.tibtech.nifi.web.api.snippet;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.SnippetEntity;

/**
 * Creates a snippet. The snippet will be automatically discarded if not used in a subsequent request after 1 minute.
 */
public final class CreateSnippetInvoker extends AbstractInvoker<SnippetEntity> {
  private SnippetEntity snippetEntity;

  public CreateSnippetInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The snippet configuration details. */
  public final SnippetEntity getSnippetEntity() {
    return snippetEntity;
  }

  /**
   * The snippet configuration details. */
  public final CreateSnippetInvoker setSnippetEntity(final SnippetEntity snippetEntity) {
    this.snippetEntity = snippetEntity;
    return this;
  }

  public final SnippetEntity invoke() throws InvokerException {
    // nifi-api/snippets
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("snippets");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Entity<SnippetEntity> entity = Entity.entity(snippetEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleResponse(response, SnippetEntity.class);
    }
    finally {
      response.close();
    }
  }
}
