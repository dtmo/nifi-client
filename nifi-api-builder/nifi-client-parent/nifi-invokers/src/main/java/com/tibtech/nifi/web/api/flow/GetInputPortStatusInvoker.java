package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Boolean;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.PortStatusEntity;

public final class GetInputPortStatusInvoker extends AbstractInvoker<PortStatusEntity> {
  private String id;

  private Boolean nodewise;

  private String clusterNodeId;

  public GetInputPortStatusInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The input port id. */
  public final String getId() {
    return id;
  }

  /**
   * The input port id. */
  public final GetInputPortStatusInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * Whether or not to include the breakdown per node. Optional, defaults to false */
  public final Boolean getNodewise() {
    return nodewise;
  }

  /**
   * Whether or not to include the breakdown per node. Optional, defaults to false */
  public final GetInputPortStatusInvoker setNodewise(final Boolean nodewise) {
    this.nodewise = nodewise;
    return this;
  }

  /**
   * The id of the node where to get the status. */
  public final String getClusterNodeId() {
    return clusterNodeId;
  }

  /**
   * The id of the node where to get the status. */
  public final GetInputPortStatusInvoker setClusterNodeId(final String clusterNodeId) {
    this.clusterNodeId = clusterNodeId;
    return this;
  }

  public final PortStatusEntity invoke() throws InvokerException {
    // /flow/input-ports/{id}/status
    WebTarget target = getBaseWebTarget();
    target = target.path("flow");
    target = target.path("input-ports");
    target = target.path(id);
    target = target.path("status");
    target = target.queryParam("nodewise", nodewise);
    target = target.queryParam("clusterNodeId", clusterNodeId);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, PortStatusEntity.class);
    }
    finally {
      response.close();
    }
  }
}
