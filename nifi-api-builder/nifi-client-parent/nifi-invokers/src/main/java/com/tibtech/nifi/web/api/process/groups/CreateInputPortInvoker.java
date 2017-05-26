package com.tibtech.nifi.web.api.process.groups;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.PortEntity;

public final class CreateInputPortInvoker extends ComponentEntityInvoker<PortEntity> {
  private String id;

  private PortEntity portEntity;

  public CreateInputPortInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final CreateInputPortInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The input port configuration details. */
  public final PortEntity getPortEntity() {
    return portEntity;
  }

  /**
   * The input port configuration details. */
  public final CreateInputPortInvoker setPortEntity(final PortEntity portEntity) {
    this.portEntity = portEntity;
    return this;
  }

  public final PortEntity invoke() throws InvokerException {
    // /process-groups/{id}/input-ports
    WebTarget target = getBaseWebTarget();
    target = target.path("process-groups");
    target = target.path(id);
    target = target.path("input-ports");
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
