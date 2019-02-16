package com.tibtech.nifi.web.api.label;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.LabelEntity;

/**
 * Deletes a label
 */
public final class RemoveLabelInvoker extends ComponentEntityInvoker<LabelEntity> {
  private String id;

  private Long version;

  private Boolean disconnectedNodeAcknowledged;

  public RemoveLabelInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The label id. */
  public final String getId() {
    return id;
  }

  /**
   * The label id. */
  public final RemoveLabelInvoker setId(final String id) {
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
  public final RemoveLabelInvoker setVersion(final Long version) {
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
  public final RemoveLabelInvoker setDisconnectedNodeAcknowledged(
      final Boolean disconnectedNodeAcknowledged) {
    this.disconnectedNodeAcknowledged = disconnectedNodeAcknowledged;
    return this;
  }

  public final LabelEntity invoke() throws InvokerException {
    // nifi-api/labels/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("labels");
    target = target.path(id);
    target = target.queryParam("version", version);
    target = target.queryParam("clientId", getClientId());
    target = target.queryParam("disconnectedNodeAcknowledged", disconnectedNodeAcknowledged);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("DELETE");
    try {
      return handleComponentEntityResponse(response, LabelEntity.class);
    }
    finally {
      response.close();
    }
  }
}
