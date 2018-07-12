package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.PermissionsDTO;
import org.apache.nifi.web.api.dto.flow.ProcessGroupFlowDTO;
import org.apache.nifi.web.api.entity.ProcessGroupFlowEntity;

public final class ProcessGroupFlowEntityBuilder extends AbstractEntityBuilder<ProcessGroupFlowEntityBuilder> {
  private PermissionsDTO permissions;

  private ProcessGroupFlowDTO processGroupFlow;

  /**
   * The access policy for this process group.
   */
  public PermissionsDTO getPermissions() {
    return permissions;
  }

  /**
   * The access policy for this process group.
   */
  public ProcessGroupFlowEntityBuilder setPermissions(final PermissionsDTO permissions) {
    this.permissions = permissions;
    return this;
  }

  public ProcessGroupFlowDTO getProcessGroupFlow() {
    return processGroupFlow;
  }

  public ProcessGroupFlowEntityBuilder setProcessGroupFlow(
      final ProcessGroupFlowDTO processGroupFlow) {
    this.processGroupFlow = processGroupFlow;
    return this;
  }

  public ProcessGroupFlowEntity build() {
    final ProcessGroupFlowEntity processGroupFlowEntity = new ProcessGroupFlowEntity();
    super.setPropertyValues(processGroupFlowEntity);
    processGroupFlowEntity.setPermissions(permissions);
    processGroupFlowEntity.setProcessGroupFlow(processGroupFlow);
    return processGroupFlowEntity;
  }

  public static ProcessGroupFlowEntityBuilder of(
      final ProcessGroupFlowEntity processGroupFlowEntity) {
    final ProcessGroupFlowEntityBuilder processGroupFlowEntityBuilder = new ProcessGroupFlowEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(processGroupFlowEntityBuilder, processGroupFlowEntity);
    processGroupFlowEntityBuilder.setPermissions(processGroupFlowEntity.getPermissions());
    processGroupFlowEntityBuilder.setProcessGroupFlow(processGroupFlowEntity.getProcessGroupFlow());
    return processGroupFlowEntityBuilder;
  }
}
