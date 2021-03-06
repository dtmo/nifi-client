package com.tibtech.nifi.web.api.reportingtask;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ReportingTaskEntity;

/**
 * Gets a reporting task
 */
public final class GetReportingTaskInvoker extends ComponentEntityInvoker<ReportingTaskEntity> {
  private String id;

  public GetReportingTaskInvoker(final Transport transport, final long version) {
    super(transport, version);
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
    // nifi-api/reporting-tasks/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
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
