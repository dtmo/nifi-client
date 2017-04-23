package com.tibtech.nifi.web.api.provenance;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ProvenanceEntity;

public final class DeleteProvenanceInvoker extends AbstractInvoker<ProvenanceEntity> {
  private String id;

  private String clusterNodeId;

  public DeleteProvenanceInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The id of the provenance query. */
  public final String getId() {
    return id;
  }

  /**
   * The id of the provenance query. */
  public final DeleteProvenanceInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The id of the node where this query exists if clustered. */
  public final String getClusterNodeId() {
    return clusterNodeId;
  }

  /**
   * The id of the node where this query exists if clustered. */
  public final DeleteProvenanceInvoker setClusterNodeId(final String clusterNodeId) {
    this.clusterNodeId = clusterNodeId;
    return this;
  }

  public final ProvenanceEntity invoke() throws InvokerException {
    // /provenance/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("provenance");
    target = target.path(id);
    target = target.queryParam("clusterNodeId", clusterNodeId);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("DELETE");
    try {
      return handleResponse(response, ProvenanceEntity.class);
    }
    finally {
      response.close();
    }
  }
}
