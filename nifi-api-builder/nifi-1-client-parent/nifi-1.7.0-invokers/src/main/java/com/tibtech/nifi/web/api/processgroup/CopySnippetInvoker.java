package com.tibtech.nifi.web.api.processgroup;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.CopySnippetRequestEntity;
import org.apache.nifi.web.api.entity.FlowEntity;

/**
 * Copies a snippet and discards it.
 */
public final class CopySnippetInvoker extends AbstractInvoker<FlowEntity> {
  private String id;

  private CopySnippetRequestEntity copySnippetRequestEntity;

  public CopySnippetInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final CopySnippetInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The copy snippet request. */
  public final CopySnippetRequestEntity getCopySnippetRequestEntity() {
    return copySnippetRequestEntity;
  }

  /**
   * The copy snippet request. */
  public final CopySnippetInvoker setCopySnippetRequestEntity(
      final CopySnippetRequestEntity copySnippetRequestEntity) {
    this.copySnippetRequestEntity = copySnippetRequestEntity;
    return this;
  }

  public final FlowEntity invoke() throws InvokerException {
    // nifi-api/process-groups/{id}/snippet-instance
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("snippet-instance");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Entity<CopySnippetRequestEntity> entity = Entity.entity(copySnippetRequestEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleResponse(response, FlowEntity.class);
    }
    finally {
      response.close();
    }
  }
}
