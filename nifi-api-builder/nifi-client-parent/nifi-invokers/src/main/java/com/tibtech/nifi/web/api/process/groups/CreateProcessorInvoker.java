package com.tibtech.nifi.web.api.process.groups;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ProcessorEntity;

public final class CreateProcessorInvoker extends ComponentEntityInvoker<ProcessorEntity> {
  private String id;

  private ProcessorEntity processorEntity;

  public CreateProcessorInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final CreateProcessorInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The processor configuration details. */
  public final ProcessorEntity getProcessorEntity() {
    return processorEntity;
  }

  /**
   * The processor configuration details. */
  public final CreateProcessorInvoker setProcessorEntity(final ProcessorEntity processorEntity) {
    this.processorEntity = processorEntity;
    return this;
  }

  public final ProcessorEntity invoke() throws InvokerException {
    // /process-groups/{id}/processors
    WebTarget target = getBaseWebTarget();
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("processors");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    processorEntity.setRevision(createRevisionDto());
    processorEntity.getRevision().setVersion(0L);
    final Entity<ProcessorEntity> entity = Entity.entity(processorEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleComponentEntityResponse(response, ProcessorEntity.class);
    }
    finally {
      response.close();
    }
  }
}
