package com.tibtech.nifi.web.api.output.ports;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.PortEntity;

public final class UpdateOutputPortInvoker extends ComponentEntityInvoker<PortEntity> {
  private String id;

  private PortEntity portEntity;

  public UpdateOutputPortInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The output port id. */
  public final String getId() {
    return id;
  }

  /**
   * The output port id. */
  public final UpdateOutputPortInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The output port configuration details. */
  public final PortEntity getPortEntity() {
    return portEntity;
  }

  /**
   * The output port configuration details. */
  public final UpdateOutputPortInvoker setPortEntity(final PortEntity portEntity) {
    this.portEntity = portEntity;
    return this;
  }

  public final PortEntity invoke() throws InvokerException {
    // /output-ports/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("output-ports");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    portEntity.setRevision(createRevisionDto());
    final Entity<PortEntity> entity = Entity.entity(portEntity, "application/json");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleComponentEntityResponse(response, PortEntity.class);
    }
    finally {
      response.close();
    }
  }
}
