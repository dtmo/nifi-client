package com.tibtech.nifi.web.api.reporting.tasks;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ReportingTaskEntity;

public final class GetReportingTaskInvoker extends ComponentEntityInvoker<ReportingTaskEntity> {
  private String id;

  public GetReportingTaskInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The reporting task id. */
  public final String getId() {
    return id;
  }

  /**
   * The reporting task id. */
  public final GetReportingTaskInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  public final ReportingTaskEntity invoke() throws InvokerException {
    // /reporting-tasks/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("reporting-tasks");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleComponentEntityResponse(response, ReportingTaskEntity.class);
    }
    finally {
      response.close();
    }
  }
}
