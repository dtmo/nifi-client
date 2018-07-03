package com.tibtech.nifi.web.api.snippet;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.SnippetEntity;

/**
 * Move's the components in this Snippet into a new Process Group and discards the snippet
 */
public final class UpdateSnippetInvoker extends AbstractInvoker<SnippetEntity> {
  private String id;

  private SnippetEntity snippetEntity;

  public UpdateSnippetInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The snippet id. */
  public final String getId() {
    return id;
  }

  /**
   * The snippet id. */
  public final UpdateSnippetInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The snippet configuration details. */
  public final SnippetEntity getSnippetEntity() {
    return snippetEntity;
  }

  /**
   * The snippet configuration details. */
  public final UpdateSnippetInvoker setSnippetEntity(final SnippetEntity snippetEntity) {
    this.snippetEntity = snippetEntity;
    return this;
  }

  public final SnippetEntity invoke() throws InvokerException {
    // nifi-api/snippets/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("snippets");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Entity<SnippetEntity> entity = Entity.entity(snippetEntity, "application/json");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleResponse(response, SnippetEntity.class);
    }
    finally {
      response.close();
    }
  }
}
