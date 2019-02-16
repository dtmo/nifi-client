package com.tibtech.nifi.web.api.flowfilequeue;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.FlowFileEntity;

/**
 * Gets a FlowFile from a Connection.
 */
public final class GetFlowFileInvoker extends AbstractInvoker<FlowFileEntity> {
  private String id;

  private String flowfileUuid;

  private String clusterNodeId;

  public GetFlowFileInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The connection id. */
  public final String getId() {
    return id;
  }

  /**
   * The connection id. */
  public final GetFlowFileInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The flowfile uuid. */
  public final String getFlowfileUuid() {
    return flowfileUuid;
  }

  /**
   * The flowfile uuid. */
  public final GetFlowFileInvoker setFlowfileUuid(final String flowfileUuid) {
    this.flowfileUuid = flowfileUuid;
    return this;
  }

  /**
   * The id of the node where the content exists if clustered. */
  public final String getClusterNodeId() {
    return clusterNodeId;
  }

  /**
   * The id of the node where the content exists if clustered. */
  public final GetFlowFileInvoker setClusterNodeId(final String clusterNodeId) {
    this.clusterNodeId = clusterNodeId;
    return this;
  }

  public final FlowFileEntity invoke() throws InvokerException {
    // nifi-api/flowfile-queues/{id}/flowfiles/{flowfile-uuid}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flowfile-queues");
    target = target.path(id);
    target = target.path("flowfiles");
    target = target.path(flowfileUuid);
    target = target.queryParam("clusterNodeId", clusterNodeId);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, FlowFileEntity.class);
    }
    finally {
      response.close();
    }
  }
}
