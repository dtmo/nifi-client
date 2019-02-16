package com.tibtech.nifi.web.api.provenanceevent;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Long;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

/**
 * Gets the input content for a provenance event
 */
public final class GetInputContentInvoker extends AbstractInvoker<StreamingOutput> {
  private Long id;

  private String clusterNodeId;

  public GetInputContentInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The provenance event id. */
  public final Long getId() {
    return id;
  }

  /**
   * The provenance event id. */
  public final GetInputContentInvoker setId(final Long id) {
    this.id = id;
    return this;
  }

  /**
   * The id of the node where the content exists if clustered. */
  public final String getClusterNodeId() {
    return clusterNodeId;
  }

  /**
   * The id of the node where the content exists if clustered. */
  public final GetInputContentInvoker setClusterNodeId(final String clusterNodeId) {
    this.clusterNodeId = clusterNodeId;
    return this;
  }

  public final StreamingOutput invoke() throws InvokerException {
    // nifi-api/provenance-events/{id}/content/input
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("provenance-events");
    target = target.path(String.valueOf(id));
    target = target.path("content");
    target = target.path("input");
    target = target.queryParam("clusterNodeId", clusterNodeId);
    final Invocation.Builder invocationBuilder = target.request("*/*");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, StreamingOutput.class);
    }
    finally {
      response.close();
    }
  }
}
