package com.tibtech.nifi.web.api.processgroup;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.PortEntity;

/**
 * Creates an output port
 */
public final class CreateOutputPortInvoker extends ComponentEntityInvoker<PortEntity> {
  private String id;

  private PortEntity portEntity;

  public CreateOutputPortInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final CreateOutputPortInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The output port configuration. */
  public final PortEntity getPortEntity() {
    return portEntity;
  }

  /**
   * The output port configuration. */
  public final CreateOutputPortInvoker setPortEntity(final PortEntity portEntity) {
    this.portEntity = portEntity;
    return this;
  }

  public final PortEntity invoke() throws InvokerException {
    // nifi-api/process-groups/{id}/output-ports
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("output-ports");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    portEntity.setRevision(createRevisionDto());
    final Entity<PortEntity> entity = Entity.entity(portEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleComponentEntityResponse(response, PortEntity.class);
    }
    finally {
      response.close();
    }
  }
}
