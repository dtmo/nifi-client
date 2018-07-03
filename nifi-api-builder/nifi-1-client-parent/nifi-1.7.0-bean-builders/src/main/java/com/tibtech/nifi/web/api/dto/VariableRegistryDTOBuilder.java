package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import java.util.Set;
import org.apache.nifi.web.api.dto.VariableRegistryDTO;
import org.apache.nifi.web.api.entity.VariableEntity;

public final class VariableRegistryDTOBuilder {
  private String processGroupId;

  private Set<VariableEntity> variables;

  /**
   * The UUID of the Process Group that this Variable Registry belongs to
   */
  public String getProcessGroupId() {
    return processGroupId;
  }

  /**
   * The UUID of the Process Group that this Variable Registry belongs to
   */
  public VariableRegistryDTOBuilder setProcessGroupId(final String processGroupId) {
    this.processGroupId = processGroupId;
    return this;
  }

  /**
   * The variables that are available in this Variable Registry
   */
  public Set<VariableEntity> getVariables() {
    return variables;
  }

  /**
   * The variables that are available in this Variable Registry
   */
  public VariableRegistryDTOBuilder setVariables(final Set<VariableEntity> variables) {
    this.variables = variables;
    return this;
  }

  public VariableRegistryDTO build() {
    final VariableRegistryDTO variableRegistryDTO = new VariableRegistryDTO();
    variableRegistryDTO.setProcessGroupId(processGroupId);
    variableRegistryDTO.setVariables(variables);
    return variableRegistryDTO;
  }

  public static VariableRegistryDTOBuilder of(final VariableRegistryDTO variableRegistryDTO) {
    final VariableRegistryDTOBuilder variableRegistryDTOBuilder = new VariableRegistryDTOBuilder();
    variableRegistryDTOBuilder.setProcessGroupId(variableRegistryDTO.getProcessGroupId());
    variableRegistryDTOBuilder.setVariables(variableRegistryDTO.getVariables());
    return variableRegistryDTOBuilder;
  }
}
