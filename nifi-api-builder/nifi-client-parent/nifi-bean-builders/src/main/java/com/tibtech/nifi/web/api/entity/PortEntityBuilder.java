package com.tibtech.nifi.web.api.entity;

import java.lang.String;
import org.apache.nifi.web.api.dto.PortDTO;
import org.apache.nifi.web.api.dto.status.PortStatusDTO;
import org.apache.nifi.web.api.entity.PortEntity;

public final class PortEntityBuilder extends AbstractComponentEntityBuilder<PortEntityBuilder> {
  private PortDTO component;

  private String portType;

  private PortStatusDTO status;

  public PortDTO getComponent() {
    return component;
  }

  public PortEntityBuilder setComponent(final PortDTO component) {
    this.component = component;
    return this;
  }

  public String getPortType() {
    return portType;
  }

  public PortEntityBuilder setPortType(final String portType) {
    this.portType = portType;
    return this;
  }

  /**
   * The status of the port.
   */
  public PortStatusDTO getStatus() {
    return status;
  }

  /**
   * The status of the port.
   */
  public PortEntityBuilder setStatus(final PortStatusDTO status) {
    this.status = status;
    return this;
  }

  public PortEntity build() {
    final PortEntity portEntity = new PortEntity();
    super.setPropertyValues(portEntity);
    portEntity.setComponent(component);
    portEntity.setPortType(portType);
    portEntity.setStatus(status);
    return portEntity;
  }

  public static PortEntityBuilder of(final PortEntity portEntity) {
    final PortEntityBuilder portEntityBuilder = new PortEntityBuilder();
    AbstractComponentEntityBuilder.setBuilderValues(portEntityBuilder, portEntity);
    portEntityBuilder.setComponent(portEntity.getComponent());
    portEntityBuilder.setPortType(portEntity.getPortType());
    portEntityBuilder.setStatus(portEntity.getStatus());
    return portEntityBuilder;
  }
}
