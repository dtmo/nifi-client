package com.tibtech.nifi.web.api.reporting.tasks;

import com.tibtech.nifi.client.ComponentEntityInvoker;
import com.tibtech.nifi.client.InvokerException;
import com.tibtech.nifi.client.Transport;
import java.lang.String;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.apache.nifi.web.api.entity.ReportingTaskEntity;

public final class UpdateReportingTaskInvoker extends ComponentEntityInvoker<ReportingTaskEntity> {
  private String id;

  private ReportingTaskEntity reportingTaskEntity;

  public UpdateReportingTaskInvoker(final Transport transport) {
    super(transport);
  }

  /**
   * The reporting task id. */
  public final String getId() {
    return id;
  }

  /**
   * The reporting task id. */
  public final UpdateReportingTaskInvoker setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The reporting task configuration details. */
  public final ReportingTaskEntity getReportingTaskEntity() {
    return reportingTaskEntity;
  }

  /**
   * The reporting task configuration details. */
  public final UpdateReportingTaskInvoker setReportingTaskEntity(final ReportingTaskEntity reportingTaskEntity) {
    this.reportingTaskEntity = reportingTaskEntity;
    return this;
  }

  public final ReportingTaskEntity invoke() throws InvokerException {
    // /reporting-tasks/{id}
    WebTarget target = getBaseWebTarget();
    target = target.path("reporting-tasks");
    target = target.path(id);
    final Invocation.Builder invocationBuilder = target.request("application/json");
    reportingTaskEntity.setRevision(createRevisionDto());
    final Entity<ReportingTaskEntity> entity = Entity.entity(reportingTaskEntity, "application/json");
    final Response response = invocationBuilder.method("PUT", entity);
    try {
      return handleComponentEntityResponse(response, ReportingTaskEntity.class);
    }
    finally {
      response.close();
    }
  }
}
