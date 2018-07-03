package com.tibtech.nifi.web.api.entity;

import java.util.Set;
import org.apache.nifi.web.api.entity.OutputPortsEntity;
import org.apache.nifi.web.api.entity.PortEntity;

public final class OutputPortsEntityBuilder extends AbstractEntityBuilder<OutputPortsEntityBuilder> {
  private Set<PortEntity> outputPorts;

  public Set<PortEntity> getOutputPorts() {
    return outputPorts;
  }

  public OutputPortsEntityBuilder setOutputPorts(final Set<PortEntity> outputPorts) {
    this.outputPorts = outputPorts;
    return this;
  }

  public OutputPortsEntity build() {
    final OutputPortsEntity outputPortsEntity = new OutputPortsEntity();
    super.setPropertyValues(outputPortsEntity);
    outputPortsEntity.setOutputPorts(outputPorts);
    return outputPortsEntity;
  }

  public static OutputPortsEntityBuilder of(final OutputPortsEntity outputPortsEntity) {
    final OutputPortsEntityBuilder outputPortsEntityBuilder = new OutputPortsEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(outputPortsEntityBuilder, outputPortsEntity);
    outputPortsEntityBuilder.setOutputPorts(outputPortsEntity.getOutputPorts());
    return outputPortsEntityBuilder;
  }
}
