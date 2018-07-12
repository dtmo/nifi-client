package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import java.util.Set;
import org.apache.nifi.web.api.dto.VariableDTO;
import org.apache.nifi.web.api.entity.AffectedComponentEntity;

public final class VariableDTOBuilder {
  private Set<AffectedComponentEntity> affectedComponents;

  private String name;

  private String processGroupId;

  private String value;

  /**
   * A set of all components that will be affected if the value of this variable is changed
   */
  public Set<AffectedComponentEntity> getAffectedComponents() {
    return affectedComponents;
  }

  /**
   * A set of all components that will be affected if the value of this variable is changed
   */
  public VariableDTOBuilder setAffectedComponents(
      final Set<AffectedComponentEntity> affectedComponents) {
    this.affectedComponents = affectedComponents;
    return this;
  }

  /**
   * The name of the variable
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the variable
   */
  public VariableDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * The ID of the Process Group where this Variable is defined
   */
  public String getProcessGroupId() {
    return processGroupId;
  }

  /**
   * The ID of the Process Group where this Variable is defined
   */
  public VariableDTOBuilder setProcessGroupId(final String processGroupId) {
    this.processGroupId = processGroupId;
    return this;
  }

  /**
   * The value of the variable
   */
  public String getValue() {
    return value;
  }

  /**
   * The value of the variable
   */
  public VariableDTOBuilder setValue(final String value) {
    this.value = value;
    return this;
  }

  public VariableDTO build() {
    final VariableDTO variableDTO = new VariableDTO();
    variableDTO.setAffectedComponents(affectedComponents);
    variableDTO.setName(name);
    variableDTO.setProcessGroupId(processGroupId);
    variableDTO.setValue(value);
    return variableDTO;
  }

  public static VariableDTOBuilder of(final VariableDTO variableDTO) {
    final VariableDTOBuilder variableDTOBuilder = new VariableDTOBuilder();
    variableDTOBuilder.setAffectedComponents(variableDTO.getAffectedComponents());
    variableDTOBuilder.setName(variableDTO.getName());
    variableDTOBuilder.setProcessGroupId(variableDTO.getProcessGroupId());
    variableDTOBuilder.setValue(variableDTO.getValue());
    return variableDTOBuilder;
  }
}
