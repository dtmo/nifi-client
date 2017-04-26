package com.tibtech.nifi.web.api.flowfilequeue;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import java.lang.Void;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Gets the content for a FlowFile in a Connection.
 */
public final class DownloadFlowFileContentInvoker extends AbstractInvoker<Void> {
  private String id;

  private String flowfileUuid;

  private String clusterNodeId;

  public DownloadFlowFileContentInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The connection id. */
  public final String getId() {
    return id;
  }

  /**
   * The connection id. */
  public final DownloadFlowFileContentInvoker setId(final String id) {
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
  public final DownloadFlowFileContentInvoker setFlowfileUuid(final String flowfileUuid) {
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
  public final DownloadFlowFileContentInvoker setClusterNodeId(final String clusterNodeId) {
    this.clusterNodeId = clusterNodeId;
    return this;
  }

  public final Void invoke() throws InvokerException {
    // /flowfile-queues/{id}/flowfiles/{flowfile-uuid}/content
    WebTarget target = getBaseWebTarget();
    target = target.path("flowfile-queues");
    target = target.path(id);
    target = target.path("flowfiles");
    target = target.path(flowfileUuid);
    target = target.path("content");
    target = target.queryParam("clientId", getClientId());
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
