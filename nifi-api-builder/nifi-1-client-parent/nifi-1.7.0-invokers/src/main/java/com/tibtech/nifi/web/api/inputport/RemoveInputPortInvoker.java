package com.tibtech.nifi.web.api.inputport;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.PortEntity;

/**
 * Deletes an input port
 */
public final class RemoveInputPortInvoker extends ComponentEntityInvoker<PortEntity> {
  private String id;

  private Long version;

  private Boolean disconnectedNodeAcknowledged;

  public RemoveInputPortInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The input port id. */
  public final String getId() {
    return id;
  }

  /**
   * The input port id. */
  public final RemoveInputPortInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The revision is used to verify the client is working with the latest version of the flow. */
  public final Long getVersion() {
    return version;
  }

  /**
   * The revision is used to verify the client is working with the latest version of the flow. */
  public final RemoveInputPortInvoker setVersion(final Long version) {
    this.version = version;
    return this;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed. */
  public final Boolean getDisconnectedNodeAcknowledged() {
    return disconnectedNodeAcknowledged;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed. */
  public final RemoveInputPortInvoker setDisconnectedNodeAcknowledged(
      final Boolean disconnectedNodeAcknowledged) {
    this.disconnectedNodeAcknowledged = disconnectedNodeAcknowledged;
    return this;
  }

  public final PortEntity invoke() throws InvokerException {
    // nifi-api/input-ports/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("input-ports");
    target = target.path(id);
    target = target.queryParam("version", version);
    target = target.queryParam("clientId", getClientId());
    target = target.queryParam("disconnectedNodeAcknowledged", disconnectedNodeAcknowledged);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("DELETE");
    try {
      return handleComponentEntityResponse(response, PortEntity.class);
    }
    finally {
      response.close();
    }
  }
}
