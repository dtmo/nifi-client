package com.tibtech.nifi.web.api.flow;

import com.tibtech.nifi.client.AbstractInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ReportingTaskTypesEntity;

public final class GetReportingTaskTypesInvoker extends AbstractInvoker<ReportingTaskTypesEntity> {
  public GetReportingTaskTypesInvoker(final Transport transport) {
    super(transport);
  }

  public final ReportingTaskTypesEntity invoke() throws InvokerException {
    // /flow/reporting-task-types
    WebTarget target = getBaseWebTarget();
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
