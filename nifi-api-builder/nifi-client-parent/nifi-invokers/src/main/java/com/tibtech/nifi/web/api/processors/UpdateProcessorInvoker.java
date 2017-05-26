package com.tibtech.nifi.web.api.processors;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ProcessorEntity;

public final class UpdateProcessorInvoker extends ComponentEntityInvoker<ProcessorEntity> {
  private String id;

  private ProcessorEntity processorEntity;

  public UpdateProcessorInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The processor id. */
  public final String getId() {
    return id;
  }

  /**
   * The processor id. */
  public final UpdateProcessorInvoker setId(final String id) {
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
  public final UpdateProcessorInvoker setProcessorEntity(final ProcessorEntity processorEntity) {
    this.processorEntity = processorEntity;
    return this;
  }

  public final ProcessorEntity invoke() throws InvokerException {
    // /processors/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("processors");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    processorEntity.setRevision(createRevisionDto());
    final Entity<ProcessorEntity> entity = Entity.entity(processorEntity, "application/json");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleComponentEntityResponse(response, ProcessorEntity.class);
    }
    finally {
      response.close();
    }
  }
}
