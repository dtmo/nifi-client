package com.tibtech.nifi.web.api.remote.process.groups;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.RemoteProcessGroupEntity;

public final class UpdateRemoteProcessGroupInvoker extends ComponentEntityInvoker<RemoteProcessGroupEntity> {
  private String id;

  private RemoteProcessGroupEntity remoteProcessGroupEntity;

  public UpdateRemoteProcessGroupInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The remote process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The remote process group id. */
  public final UpdateRemoteProcessGroupInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The remote process group. */
  public final RemoteProcessGroupEntity getRemoteProcessGroupEntity() {
    return remoteProcessGroupEntity;
  }

  /**
   * The remote process group. */
  public final UpdateRemoteProcessGroupInvoker setRemoteProcessGroupEntity(final RemoteProcessGroupEntity remoteProcessGroupEntity) {
    this.remoteProcessGroupEntity = remoteProcessGroupEntity;
    return this;
  }

  public final RemoteProcessGroupEntity invoke() throws InvokerException {
    // /remote-process-groups/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("remote-process-groups");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    remoteProcessGroupEntity.setRevision(createRevisionDto());
    final Entity<RemoteProcessGroupEntity> entity = Entity.entity(remoteProcessGroupEntity, "application/json");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleComponentEntityResponse(response, RemoteProcessGroupEntity.class);
    }
    finally {
      response.close();
    }
  }
}
