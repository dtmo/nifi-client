package com.tibtech.nifi.web.api.process.groups;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ProcessGroupEntity;

public final class UpdateProcessGroupInvoker extends ComponentEntityInvoker<ProcessGroupEntity> {
  private String id;

  private ProcessGroupEntity processGroupEntity;

  public UpdateProcessGroupInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final UpdateProcessGroupInvoker setId(final String id) {
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
  public final UpdateProcessGroupInvoker setProcessGroupEntity(final ProcessGroupEntity processGroupEntity) {
    this.processGroupEntity = processGroupEntity;
    return this;
  }

  public final ProcessGroupEntity invoke() throws InvokerException {
    // /process-groups/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("process-groups");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    processGroupEntity.setRevision(createRevisionDto());
    final Entity<ProcessGroupEntity> entity = Entity.entity(processGroupEntity, "application/json");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleComponentEntityResponse(response, ProcessGroupEntity.class);
    }
    finally {
      response.close();
    }
  }
}
