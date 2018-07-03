package com.tibtech.nifi.web.api.versions;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Boolean;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.VersionControlInformationEntity;

/**
 * Stops version controlling the Process Group with the given ID
 * <p>Stops version controlling the Process Group with the given ID. The Process Group will no longer track to any Versioned Flow. Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class StopVersionControlInvoker extends AbstractInvoker<VersionControlInformationEntity> {
  private String id;

  private Boolean disconnectedNodeAcknowledged;

  public StopVersionControlInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The process group id. */
  public final String getId() {
    return id;
  }

  /**
   * The process group id. */
  public final StopVersionControlInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed. */
  public final Boolean getDisconnectedNodeAcknowledged() {
    return disconnectedNodeAcknowledged;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed. */
  public final StopVersionControlInvoker setDisconnectedNodeAcknowledged(
      final Boolean disconnectedNodeAcknowledged) {
    this.disconnectedNodeAcknowledged = disconnectedNodeAcknowledged;
    return this;
  }

  public final VersionControlInformationEntity invoke() throws InvokerException {
    // nifi-api/versions/process-groups/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("versions");
    target = target.path("process-groups");
    target = target.path(id);
    target = target.queryParam("version", getVersion());
    target = target.queryParam("clientId", getClientId());
    target = target.queryParam("disconnectedNodeAcknowledged", disconnectedNodeAcknowledged);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("DELETE");
    try {
      return handleResponse(response, VersionControlInformationEntity.class);
    }
    finally {
      response.close();
    }
  }
}
