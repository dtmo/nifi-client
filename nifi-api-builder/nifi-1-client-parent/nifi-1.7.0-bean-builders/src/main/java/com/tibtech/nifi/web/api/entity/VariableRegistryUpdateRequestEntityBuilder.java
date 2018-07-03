package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.RevisionDTO;
import org.apache.nifi.web.api.dto.VariableRegistryUpdateRequestDTO;
import org.apache.nifi.web.api.entity.VariableRegistryUpdateRequestEntity;

public final class VariableRegistryUpdateRequestEntityBuilder extends AbstractEntityBuilder<VariableRegistryUpdateRequestEntityBuilder> {
  private RevisionDTO processGroupRevision;

  private VariableRegistryUpdateRequestDTO request;

  /**
   * The revision for the Process Group that owns this variable registry.
   */
  public RevisionDTO getProcessGroupRevision() {
    return processGroupRevision;
  }

  /**
   * The revision for the Process Group that owns this variable registry.
   */
  public VariableRegistryUpdateRequestEntityBuilder setProcessGroupRevision(final RevisionDTO processGroupRevision) {
    this.processGroupRevision = processGroupRevision;
    return this;
  }

  /**
   * The Variable Registry Update Request
   */
  public VariableRegistryUpdateRequestDTO getRequest() {
    return request;
  }

  /**
   * The Variable Registry Update Request
   */
  public VariableRegistryUpdateRequestEntityBuilder setRequest(final VariableRegistryUpdateRequestDTO request) {
    this.request = request;
    return this;
  }

  public VariableRegistryUpdateRequestEntity build() {
    final VariableRegistryUpdateRequestEntity variableRegistryUpdateRequestEntity = new VariableRegistryUpdateRequestEntity();
    super.setPropertyValues(variableRegistryUpdateRequestEntity);
    variableRegistryUpdateRequestEntity.setProcessGroupRevision(processGroupRevision);
    variableRegistryUpdateRequestEntity.setRequest(request);
    return variableRegistryUpdateRequestEntity;
  }

  public static VariableRegistryUpdateRequestEntityBuilder of(final VariableRegistryUpdateRequestEntity variableRegistryUpdateRequestEntity) {
    final VariableRegistryUpdateRequestEntityBuilder variableRegistryUpdateRequestEntityBuilder = new VariableRegistryUpdateRequestEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(variableRegistryUpdateRequestEntityBuilder, variableRegistryUpdateRequestEntity);
    variableRegistryUpdateRequestEntityBuilder.setProcessGroupRevision(variableRegistryUpdateRequestEntity.getProcessGroupRevision());
    variableRegistryUpdateRequestEntityBuilder.setRequest(variableRegistryUpdateRequestEntity.getRequest());
    return variableRegistryUpdateRequestEntityBuilder;
  }
}
