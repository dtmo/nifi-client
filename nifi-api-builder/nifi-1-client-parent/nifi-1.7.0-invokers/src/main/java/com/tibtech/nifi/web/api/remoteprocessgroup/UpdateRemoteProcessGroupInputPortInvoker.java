package com.tibtech.nifi.web.api.remoteprocessgroup;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.RemoteProcessGroupPortEntity;

/**
 * Updates a remote port
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class UpdateRemoteProcessGroupInputPortInvoker extends ComponentEntityInvoker<RemoteProcessGroupPortEntity> {
  private String id;

  private String portId;

  private RemoteProcessGroupPortEntity remoteProcessGroupPortEntity;

  public UpdateRemoteProcessGroupInputPortInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The remote process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The remote process group id. */
  public final UpdateRemoteProcessGroupInputPortInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The remote process group port id. */
  public final String getPortId() {
    return portId;
  }

  /**
   * The remote process group port id. */
  public final UpdateRemoteProcessGroupInputPortInvoker setPortId(final String portId) {
    this.portId = portId;
    return this;
  }

  /**
   * The remote process group port. */
  public final RemoteProcessGroupPortEntity getRemoteProcessGroupPortEntity() {
    return remoteProcessGroupPortEntity;
  }

  /**
   * The remote process group port. */
  public final UpdateRemoteProcessGroupInputPortInvoker setRemoteProcessGroupPortEntity(
      final RemoteProcessGroupPortEntity remoteProcessGroupPortEntity) {
    this.remoteProcessGroupPortEntity = remoteProcessGroupPortEntity;
    return this;
  }

  public final RemoteProcessGroupPortEntity invoke() throws InvokerException {
    // nifi-api/remote-process-groups/{id}/input-ports/{port-id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("remote-process-groups");
    target = target.path(id);
    target = target.path("input-ports");
    target = target.path(portId);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Entity<RemoteProcessGroupPortEntity> entity = Entity.entity(remoteProcessGroupPortEntity, "application/json");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleComponentEntityResponse(response, RemoteProcessGroupPortEntity.class);
    }
    finally {
      response.close();
    }
  }
}
