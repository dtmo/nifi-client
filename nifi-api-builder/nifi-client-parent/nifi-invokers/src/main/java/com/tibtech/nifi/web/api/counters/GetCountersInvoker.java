package com.tibtech.nifi.web.api.counters;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Boolean;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.CountersEntity;

public final class GetCountersInvoker extends AbstractInvoker<CountersEntity> {
  private Boolean nodewise;

  private String clusterNodeId;

  public GetCountersInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * Whether or not to include the breakdown per node. Optional, defaults to false */
  public final Boolean getNodewise() {
    return nodewise;
  }

  /**
   * Whether or not to include the breakdown per node. Optional, defaults to false */
  public final GetCountersInvoker setNodewise(final Boolean nodewise) {
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
  public final GetCountersInvoker setClusterNodeId(final String clusterNodeId) {
    this.clusterNodeId = clusterNodeId;
    return this;
  }

  public final CountersEntity invoke() throws InvokerException {
    // /counters
    WebTarget target = getBaseWebTarget();
    target = target.path("counters");
    target = target.queryParam("nodewise", nodewise);
    target = target.queryParam("clusterNodeId", clusterNodeId);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, CountersEntity.class);
    }
    finally {
      response.close();
    }
  }
}
