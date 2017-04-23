package com.tibtech.nifi.web.api.provenance;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.LineageEntity;

public final class SubmitLineageRequestInvoker extends AbstractInvoker<LineageEntity> {
  private LineageEntity lineageEntity;

  public SubmitLineageRequestInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The lineage query details. */
  public final LineageEntity getLineageEntity() {
    return lineageEntity;
  }

  /**
   * The lineage query details. */
  public final SubmitLineageRequestInvoker setLineageEntity(final LineageEntity lineageEntity) {
    this.lineageEntity = lineageEntity;
    return this;
  }

  public final LineageEntity invoke() throws InvokerException {
    // /provenance/lineage
    WebTarget target = getBaseWebTarget();
    target = target.path("provenance");
    target = target.path("lineage");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Entity<LineageEntity> entity = Entity.entity(lineageEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleResponse(response, LineageEntity.class);
    }
    finally {
      response.close();
    }
  }
}
