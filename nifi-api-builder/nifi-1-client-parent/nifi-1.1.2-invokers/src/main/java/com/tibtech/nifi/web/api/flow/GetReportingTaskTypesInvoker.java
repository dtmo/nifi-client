package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ReportingTaskTypesEntity;

/**
 * Retrieves the types of reporting tasks that this NiFi supports
 * <p>Note: This endpoint is subject to change as NiFi and it's REST API evolve.</p>
 */
public final class GetReportingTaskTypesInvoker extends AbstractInvoker<ReportingTaskTypesEntity> {
  public GetReportingTaskTypesInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  public final ReportingTaskTypesEntity invoke() throws InvokerException {
    // nifi-api/flow/reporting-task-types
    WebTarget target = getBaseWebTarget();
    target = target.path("nifi-api");
    target = target.path("flow");
    target = target.path("reporting-task-types");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    final Response response = invocationBuilder.method("GET");
    try {
      return handleResponse(response, ReportingTaskTypesEntity.class);
    }
    finally {
      response.close();
    }
  }
}
