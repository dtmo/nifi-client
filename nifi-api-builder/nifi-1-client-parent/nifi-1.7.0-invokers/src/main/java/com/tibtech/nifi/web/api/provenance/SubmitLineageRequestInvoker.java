package com.tibtech.nifi.web.api.provenance;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.LineageEntity;

/**
 * Submits a lineage query
 * <p>Lineage queries may be long running so this endpoint submits a request. The response will include the current state of the query. If the request is not completed the URI in the response can be used at a later time to get the updated state of the query. Once the query has completed the lineage request should be deleted by the client who originally submitted it.</p>
 */
public final class SubmitLineageRequestInvoker extends AbstractInvoker<LineageEntity> {
  private LineageEntity lineageEntity;

  public SubmitLineageRequestInvoker(final Transport transport) {
    super(transport);
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
    // nifi-api/provenance/lineage
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
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
