package com.tibtech.nifi.web.api.controller;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ReportingTaskEntity;

/**
 * Creates a new reporting task
 */
public final class CreateReportingTaskInvoker extends ComponentEntityInvoker<ReportingTaskEntity> {
  private ReportingTaskEntity reportingTaskEntity;

  public CreateReportingTaskInvoker(final Transport transport, final long version) {
    super(transport, version);
  }

  /**
   * The reporting task configuration details. */
  public final ReportingTaskEntity getReportingTaskEntity() {
    return reportingTaskEntity;
  }

  /**
   * The reporting task configuration details. */
  public final CreateReportingTaskInvoker setReportingTaskEntity(final ReportingTaskEntity reportingTaskEntity) {
    this.reportingTaskEntity = reportingTaskEntity;
    return this;
  }

  public final ReportingTaskEntity invoke() throws InvokerException {
    // /controller/reporting-tasks
    WebTarget target = getBaseWebTarget();
    target = target.path("controller");
    target = target.path("reporting-tasks");
    final Invocation.Builder invocationBuilder = target.request("application/json");
    reportingTaskEntity.setRevision(createRevisionDto());
    final Entity<ReportingTaskEntity> entity = Entity.entity(reportingTaskEntity, "application/json");
    final Response response = invocationBuilder.method("POST", entity);
    try {
      return handleComponentEntityResponse(response, ReportingTaskEntity.class);
    }
    finally {
      response.close();
    }
  }
}
