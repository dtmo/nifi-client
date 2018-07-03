package com.tibtech.nifi.web.api.controller;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.NodeEntity;

/**
 * Updates a node in the cluster
 */
public final class UpdateNodeInvoker extends AbstractInvoker<NodeEntity> {
  private String id;

  private NodeEntity nodeEntity;

  public UpdateNodeInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The node id. */
  public final String getId() {
    return id;
  }

  /**
   * The node id. */
  public final UpdateNodeInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The node configuration. The only configuration that will be honored at this endpoint is the status. */
  public final NodeEntity getNodeEntity() {
    return nodeEntity;
  }

  /**
   * The node configuration. The only configuration that will be honored at this endpoint is the status. */
  public final UpdateNodeInvoker setNodeEntity(final NodeEntity nodeEntity) {
    this.nodeEntity = nodeEntity;
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
    final Entity<NodeEntity> entity = Entity.entity(nodeEntity, "application/json");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleResponse(response, NodeEntity.class);
    }
    finally {
      response.close();
    }
  }
}
