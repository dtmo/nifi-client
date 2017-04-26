package com.tibtech.nifi.web.api.entity;

import java.util.Set;
import org.apache.nifi.web.api.entity.InputPortsEntity;
import org.apache.nifi.web.api.entity.PortEntity;

public final class InputPortsEntityBuilder extends AbstractEntityBuilder<InputPortsEntityBuilder> {
  private Set<PortEntity> inputPorts;

  public Set<PortEntity> getInputPorts() {
    return inputPorts;
  }

  public InputPortsEntityBuilder setInputPorts(final Set<PortEntity> inputPorts) {
    this.inputPorts = inputPorts;
    return this;
  }

  public InputPortsEntity build() {
    final InputPortsEntity inputPortsEntity = new InputPortsEntity();
    super.setPropertyValues(inputPortsEntity);
    inputPortsEntity.setInputPorts(inputPorts);
    return inputPortsEntity;
  }

  public static InputPortsEntityBuilder of(final InputPortsEntity inputPortsEntity) {
    final InputPortsEntityBuilder inputPortsEntityBuilder = new InputPortsEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(inputPortsEntityBuilder, inputPortsEntity);
    inputPortsEntityBuilder.setInputPorts(inputPortsEntity.getInputPorts());
    return inputPortsEntityBuilder;
  }
}
