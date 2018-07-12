package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.SystemDiagnosticsDTO;
import org.apache.nifi.web.api.entity.SystemDiagnosticsEntity;

public final class SystemDiagnosticsEntityBuilder extends AbstractEntityBuilder<SystemDiagnosticsEntityBuilder> {
  private SystemDiagnosticsDTO systemDiagnostics;

  public SystemDiagnosticsDTO getSystemDiagnostics() {
    return systemDiagnostics;
  }

  public SystemDiagnosticsEntityBuilder setSystemDiagnostics(
      final SystemDiagnosticsDTO systemDiagnostics) {
    this.systemDiagnostics = systemDiagnostics;
    return this;
  }

  public SystemDiagnosticsEntity build() {
    final SystemDiagnosticsEntity systemDiagnosticsEntity = new SystemDiagnosticsEntity();
    super.setPropertyValues(systemDiagnosticsEntity);
    systemDiagnosticsEntity.setSystemDiagnostics(systemDiagnostics);
    return systemDiagnosticsEntity;
  }

  public static SystemDiagnosticsEntityBuilder of(
      final SystemDiagnosticsEntity systemDiagnosticsEntity) {
    final SystemDiagnosticsEntityBuilder systemDiagnosticsEntityBuilder = new SystemDiagnosticsEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(systemDiagnosticsEntityBuilder, systemDiagnosticsEntity);
    systemDiagnosticsEntityBuilder.setSystemDiagnostics(systemDiagnosticsEntity.getSystemDiagnostics());
    return systemDiagnosticsEntityBuilder;
  }
}
