package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.entity.ProcessorDiagnosticsEntity;

public final class ProcessorDiagnosticsEntityBuilder extends AbstractComponentEntityBuilder<ProcessorDiagnosticsEntityBuilder> {
  public ProcessorDiagnosticsEntity build() {
    final ProcessorDiagnosticsEntity processorDiagnosticsEntity = new ProcessorDiagnosticsEntity();
    super.setPropertyValues(processorDiagnosticsEntity);
    return processorDiagnosticsEntity;
  }

  public static ProcessorDiagnosticsEntityBuilder of(final ProcessorDiagnosticsEntity processorDiagnosticsEntity) {
    final ProcessorDiagnosticsEntityBuilder processorDiagnosticsEntityBuilder = new ProcessorDiagnosticsEntityBuilder();
    AbstractComponentEntityBuilder.setBuilderValues(processorDiagnosticsEntityBuilder, processorDiagnosticsEntity);
    return processorDiagnosticsEntityBuilder;
  }
}
