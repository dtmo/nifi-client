package com.tibtech.nifi.web.api.processgroup;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.RemoteProcessGroupEntity;

/**
 * Creates a new process group
 */
public final class CreateRemoteProcessGroupInvoker extends ComponentEntityInvoker<RemoteProcessGroupEntity> {
  private String id;

  private RemoteProcessGroupEntity remoteProcessGroupEntity;

  public CreateRemoteProcessGroupInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final CreateRemoteProcessGroupInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The remote process group configuration details. */
  public final RemoteProcessGroupEntity getRemoteProcessGroupEntity() {
    return remoteProcessGroupEntity;
  }

  /**
   * The remote process group configuration details. */
  public final CreateRemoteProcessGroupInvoker setRemoteProcessGroupEntity(final RemoteProcessGroupEntity remoteProcessGroupEntity) {
    this.remoteProcessGroupEntity = remoteProcessGroupEntity;
    return this;
  }

  public final RemoteProcessGroupEntity invoke() throws InvokerException {
    // /process-groups/{id}/remote-process-groups
    WebTarget target = getBaseWebTarget();
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("remote-process-groups");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    remoteProcessGroupEntity.setRevision(createRevisionDto());
    final Entity<RemoteProcessGroupEntity> entity = Entity.entity(remoteProcessGroupEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleComponentEntityResponse(response, RemoteProcessGroupEntity.class);
    }
    finally {
      response.close();
    }
  }
}
