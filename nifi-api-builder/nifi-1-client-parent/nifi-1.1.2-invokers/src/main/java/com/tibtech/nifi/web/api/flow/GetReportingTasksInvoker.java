package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ReportingTasksEntity;

/**
 * Gets all reporting tasks
 */
public final class GetReportingTasksInvoker extends AbstractInvoker<ReportingTasksEntity> {
  public GetReportingTasksInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final ReportingTasksEntity invoke() throws InvokerException {
    // nifi-api/flow/reporting-tasks
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flow");
    target = target.path("reporting-tasks");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ReportingTasksEntity.class);
    }
    finally {
      response.close();
    }
  }
}
