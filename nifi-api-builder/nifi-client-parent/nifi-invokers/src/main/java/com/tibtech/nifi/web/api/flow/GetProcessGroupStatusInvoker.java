package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Boolean;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ProcessGroupStatusEntity;

public final class GetProcessGroupStatusInvoker extends AbstractInvoker<ProcessGroupStatusEntity> {
  private String id;

  private Boolean recursive;

  private Boolean nodewise;

  private String clusterNodeId;

  public GetProcessGroupStatusInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final GetProcessGroupStatusInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * Whether all descendant groups and the status of their content will be included. Optional, defaults to false */
  public final Boolean getRecursive() {
    return recursive;
  }

  /**
   * Whether all descendant groups and the status of their content will be included. Optional, defaults to false */
  public final GetProcessGroupStatusInvoker setRecursive(final Boolean recursive) {
    this.recursive = recursive;
    return this;
  }

  /**
   * Whether or not to include the breakdown per node. Optional, defaults to false */
  public final Boolean getNodewise() {
    return nodewise;
  }

  /**
   * Whether or not to include the breakdown per node. Optional, defaults to false */
  public final GetProcessGroupStatusInvoker setNodewise(final Boolean nodewise) {
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
  public final GetProcessGroupStatusInvoker setClusterNodeId(final String clusterNodeId) {
    this.clusterNodeId = clusterNodeId;
    return this;
  }

  public final ProcessGroupStatusEntity invoke() throws InvokerException {
    // /flow/process-groups/{id}/status
    WebTarget target = getBaseWebTarget();
    target = target.path("flow");
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("status");
    target = target.queryParam("recursive", recursive);
    target = target.queryParam("nodewise", nodewise);
    target = target.queryParam("clusterNodeId", clusterNodeId);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ProcessGroupStatusEntity.class);
    }
    finally {
      response.close();
    }
  }
}
