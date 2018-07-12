package com.tibtech.nifi.web.api.entity;

import java.util.Set;
import org.apache.nifi.web.api.entity.ReportingTaskEntity;
import org.apache.nifi.web.api.entity.ReportingTasksEntity;

public final class ReportingTasksEntityBuilder extends AbstractEntityBuilder<ReportingTasksEntityBuilder> {
  private Set<ReportingTaskEntity> reportingTasks;

  public Set<ReportingTaskEntity> getReportingTasks() {
    return reportingTasks;
  }

  public ReportingTasksEntityBuilder setReportingTasks(
      final Set<ReportingTaskEntity> reportingTasks) {
    this.reportingTasks = reportingTasks;
    return this;
  }

  public ReportingTasksEntity build() {
    final ReportingTasksEntity reportingTasksEntity = new ReportingTasksEntity();
    super.setPropertyValues(reportingTasksEntity);
    reportingTasksEntity.setReportingTasks(reportingTasks);
    return reportingTasksEntity;
  }

  public static ReportingTasksEntityBuilder of(final ReportingTasksEntity reportingTasksEntity) {
    final ReportingTasksEntityBuilder reportingTasksEntityBuilder = new ReportingTasksEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(reportingTasksEntityBuilder, reportingTasksEntity);
    reportingTasksEntityBuilder.setReportingTasks(reportingTasksEntity.getReportingTasks());
    return reportingTasksEntityBuilder;
  }
}
