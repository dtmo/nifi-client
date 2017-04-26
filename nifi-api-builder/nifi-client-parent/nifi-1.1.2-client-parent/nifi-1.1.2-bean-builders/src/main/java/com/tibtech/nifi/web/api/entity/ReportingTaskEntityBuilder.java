package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.ReportingTaskDTO;
import org.apache.nifi.web.api.entity.ReportingTaskEntity;

public final class ReportingTaskEntityBuilder extends AbstractComponentEntityBuilder<ReportingTaskEntityBuilder> {
  private ReportingTaskDTO component;

  public ReportingTaskDTO getComponent() {
    return component;
  }

  public ReportingTaskEntityBuilder setComponent(final ReportingTaskDTO component) {
    this.component = component;
    return this;
  }

  public ReportingTaskEntity build() {
    final ReportingTaskEntity reportingTaskEntity = new ReportingTaskEntity();
    super.setPropertyValues(reportingTaskEntity);
    reportingTaskEntity.setComponent(component);
    return reportingTaskEntity;
  }

  public static ReportingTaskEntityBuilder of(final ReportingTaskEntity reportingTaskEntity) {
    final ReportingTaskEntityBuilder reportingTaskEntityBuilder = new ReportingTaskEntityBuilder();
    AbstractComponentEntityBuilder.setBuilderValues(reportingTaskEntityBuilder, reportingTaskEntity);
    reportingTaskEntityBuilder.setComponent(reportingTaskEntity.getComponent());
    return reportingTaskEntityBuilder;
  }
}
