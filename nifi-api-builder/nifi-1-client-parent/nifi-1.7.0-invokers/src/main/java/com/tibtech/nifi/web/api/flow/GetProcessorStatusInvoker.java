package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Boolean;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ProcessorStatusEntity;

/**
 * Gets status for a processor
 */
public final class GetProcessorStatusInvoker extends AbstractInvoker<ProcessorStatusEntity> {
  private String id;

  private Boolean nodewise;

  private String clusterNodeId;

  public GetProcessorStatusInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The processor id. */
  public final String getId() {
    return id;
  }

  /**
   * The processor id. */
  public final GetProcessorStatusInvoker setId(final String id) {
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
  public final GetProcessorStatusInvoker setNodewise(final Boolean nodewise) {
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
  public final GetProcessorStatusInvoker setClusterNodeId(final String clusterNodeId) {
    this.clusterNodeId = clusterNodeId;
    return this;
  }

  public final ProcessorStatusEntity invoke() throws InvokerException {
    // nifi-api/flow/processors/{id}/status
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flow");
    target = target.path("processors");
    target = target.path(id);
    target = target.path("status");
    target = target.queryParam("nodewise", nodewise);
    target = target.queryParam("clusterNodeId", clusterNodeId);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ProcessorStatusEntity.class);
    }
    finally {
      response.close();
    }
  }
}
