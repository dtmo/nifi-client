package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import org.apache.nifi.web.api.dto.VariableDTO;
import org.apache.nifi.web.api.entity.VariableEntity;

public final class VariableEntityBuilder extends AbstractEntityBuilder<VariableEntityBuilder> {
  private Boolean canWrite;

  private VariableDTO variable;

  /**
   * Indicates whether the user can write a given resource.
   */
  public Boolean getCanWrite() {
    return canWrite;
  }

  /**
   * Indicates whether the user can write a given resource.
   */
  public VariableEntityBuilder setCanWrite(final Boolean canWrite) {
    this.canWrite = canWrite;
    return this;
  }

  /**
   * The variable information
   */
  public VariableDTO getVariable() {
    return variable;
  }

  /**
   * The variable information
   */
  public VariableEntityBuilder setVariable(final VariableDTO variable) {
    this.variable = variable;
    return this;
  }

  public VariableEntity build() {
    final VariableEntity variableEntity = new VariableEntity();
    super.setPropertyValues(variableEntity);
    variableEntity.setCanWrite(canWrite);
    variableEntity.setVariable(variable);
    return variableEntity;
  }

  public static VariableEntityBuilder of(final VariableEntity variableEntity) {
    final VariableEntityBuilder variableEntityBuilder = new VariableEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(variableEntityBuilder, variableEntity);
    variableEntityBuilder.setCanWrite(variableEntity.getCanWrite());
    variableEntityBuilder.setVariable(variableEntity.getVariable());
    return variableEntityBuilder;
  }
}
