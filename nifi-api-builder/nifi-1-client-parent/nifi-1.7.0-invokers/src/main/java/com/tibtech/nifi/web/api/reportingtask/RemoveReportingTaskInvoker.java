package com.tibtech.nifi.web.api.reportingtask;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.Boolean;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ReportingTaskEntity;

/**
 * Deletes a reporting task
 */
public final class RemoveReportingTaskInvoker extends ComponentEntityInvoker<ReportingTaskEntity> {
  private String id;

  private Boolean disconnectedNodeAcknowledged;

  public RemoveReportingTaskInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The reporting task id. */
  public final String getId() {
    return id;
  }

  /**
   * The reporting task id. */
  public final RemoveReportingTaskInvoker setId(final String id) {
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
  public final RemoveReportingTaskInvoker setDisconnectedNodeAcknowledged(
      final Boolean disconnectedNodeAcknowledged) {
    this.disconnectedNodeAcknowledged = disconnectedNodeAcknowledged;
    return this;
  }

  public final ReportingTaskEntity invoke() throws InvokerException {
    // nifi-api/reporting-tasks/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("reporting-tasks");
    target = target.path(id);
    target = target.queryParam("version", getVersion());
    target = target.queryParam("clientId", getClientId());
    target = target.queryParam("disconnectedNodeAcknowledged", disconnectedNodeAcknowledged);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("DELETE");
    try {
      return handleComponentEntityResponse(response, ReportingTaskEntity.class);
    }
    finally {
      response.close();
    }
  }
}
