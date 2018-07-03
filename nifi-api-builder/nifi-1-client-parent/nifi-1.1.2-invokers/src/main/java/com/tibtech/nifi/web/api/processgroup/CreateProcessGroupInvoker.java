package com.tibtech.nifi.web.api.processgroup;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ProcessGroupEntity;

/**
 * Creates a process group
 */
public final class CreateProcessGroupInvoker extends ComponentEntityInvoker<ProcessGroupEntity> {
  private String id;

  private ProcessGroupEntity processGroupEntity;

  public CreateProcessGroupInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final CreateProcessGroupInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The process group configuration details. */
  public final ProcessGroupEntity getProcessGroupEntity() {
    return processGroupEntity;
  }

  /**
   * The process group configuration details. */
  public final CreateProcessGroupInvoker setProcessGroupEntity(final ProcessGroupEntity processGroupEntity) {
    this.processGroupEntity = processGroupEntity;
    return this;
  }

  public final ProcessGroupEntity invoke() throws InvokerException {
    // nifi-api/process-groups/{id}/process-groups
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("process-groups");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    processGroupEntity.setRevision(createRevisionDto());
    final Entity<ProcessGroupEntity> entity = Entity.entity(processGroupEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleComponentEntityResponse(response, ProcessGroupEntity.class);
    }
    finally {
      response.close();
    }
  }
}
