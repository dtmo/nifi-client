package com.tibtech.nifi.web.api.controller;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.NodeEntity;

/**
 * Gets a node in the cluster
 */
public final class GetNodeInvoker extends AbstractInvoker<NodeEntity> {
  private String id;

  public GetNodeInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The node id. */
  public final String getId() {
    return id;
  }

  /**
   * The node id. */
  public final GetNodeInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final NodeEntity invoke() throws InvokerException {
    // nifi-api/controller/cluster/nodes/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("controller");
    target = target.path("cluster");
    target = target.path("nodes");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, NodeEntity.class);
    }
    finally {
      response.close();
    }
  }
}
