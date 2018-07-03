package com.tibtech.nifi.web.api.entity;

import java.util.Set;
import org.apache.nifi.web.api.dto.DocumentedTypeDTO;
import org.apache.nifi.web.api.entity.ReportingTaskTypesEntity;

public final class ReportingTaskTypesEntityBuilder extends AbstractEntityBuilder<ReportingTaskTypesEntityBuilder> {
  private Set<DocumentedTypeDTO> reportingTaskTypes;

  public Set<DocumentedTypeDTO> getReportingTaskTypes() {
    return reportingTaskTypes;
  }

  public ReportingTaskTypesEntityBuilder setReportingTaskTypes(final Set<DocumentedTypeDTO> reportingTaskTypes) {
    this.reportingTaskTypes = reportingTaskTypes;
    return this;
  }

  public ReportingTaskTypesEntity build() {
    final ReportingTaskTypesEntity reportingTaskTypesEntity = new ReportingTaskTypesEntity();
    super.setPropertyValues(reportingTaskTypesEntity);
    reportingTaskTypesEntity.setReportingTaskTypes(reportingTaskTypes);
    return reportingTaskTypesEntity;
  }

  public static ReportingTaskTypesEntityBuilder of(final ReportingTaskTypesEntity reportingTaskTypesEntity) {
    final ReportingTaskTypesEntityBuilder reportingTaskTypesEntityBuilder = new ReportingTaskTypesEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(reportingTaskTypesEntityBuilder, reportingTaskTypesEntity);
    reportingTaskTypesEntityBuilder.setReportingTaskTypes(reportingTaskTypesEntity.getReportingTaskTypes());
    return reportingTaskTypesEntityBuilder;
  }
}
