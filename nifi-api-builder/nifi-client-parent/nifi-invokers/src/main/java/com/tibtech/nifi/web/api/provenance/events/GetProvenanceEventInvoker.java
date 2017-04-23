package com.tibtech.nifi.web.api.provenance.events;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Long;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ProvenanceEventEntity;

public final class GetProvenanceEventInvoker extends AbstractInvoker<ProvenanceEventEntity> {
  private Long id;

  private String clusterNodeId;

  public GetProvenanceEventInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The provenance event id. */
  public final Long getId() {
    return id;
  }

  /**
   * The provenance event id. */
  public final GetProvenanceEventInvoker setId(final Long id) {
    this.id = id;
    return this;
  }

  /**
   * The id of the node where this event exists if clustered. */
  public final String getClusterNodeId() {
    return clusterNodeId;
  }

  /**
   * The id of the node where this event exists if clustered. */
  public final GetProvenanceEventInvoker setClusterNodeId(final String clusterNodeId) {
    this.clusterNodeId = clusterNodeId;
    return this;
  }

  public final ProvenanceEventEntity invoke() throws InvokerException {
    // /provenance-events/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("provenance-events");
    target = target.path(id.toString());
    target = target.queryParam("clusterNodeId", clusterNodeId);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ProvenanceEventEntity.class);
    }
    finally {
      response.close();
    }
  }
}
