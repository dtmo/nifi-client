package com.tibtech.nifi.web.api.provenance.events;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Long;
import java.lang.String;
import java.lang.Void;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public final class GetInputContentInvoker extends AbstractInvoker<Void> {
  private Long id;

  private String clusterNodeId;

  public GetInputContentInvoker(final Transport transport, final long version) {
    super(transport, version);
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

  public final Void invoke() throws InvokerException {
    // /provenance-events/{id}/content/input
    WebTarget target = getBaseWebTarget();
    target = target.path("provenance-events");
    target = target.path(id.toString());
    target = target.path("content");
    target = target.path("input");
    target = target.queryParam("clusterNodeId", clusterNodeId);
    final Invocation.Builder invocationBuilder = target.request("*/*");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, Void.class);
    }
    finally {
      response.close();
    }
  }
}
