package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import org.apache.nifi.web.api.dto.status.PortStatusDTO;
import org.apache.nifi.web.api.entity.PortStatusEntity;

public final class PortStatusEntityBuilder extends AbstractEntityBuilder<PortStatusEntityBuilder> {
  private Boolean canRead;

  private PortStatusDTO portStatus;

  public Boolean getCanRead() {
    return canRead;
  }

  public PortStatusEntityBuilder setCanRead(final Boolean canRead) {
    this.canRead = canRead;
    return this;
  }

  public PortStatusDTO getPortStatus() {
    return portStatus;
  }

  public PortStatusEntityBuilder setPortStatus(final PortStatusDTO portStatus) {
    this.portStatus = portStatus;
    return this;
  }

  public PortStatusEntity build() {
    final PortStatusEntity portStatusEntity = new PortStatusEntity();
    super.setPropertyValues(portStatusEntity);
    portStatusEntity.setCanRead(canRead);
    portStatusEntity.setPortStatus(portStatus);
    return portStatusEntity;
  }

  public static PortStatusEntityBuilder of(final PortStatusEntity portStatusEntity) {
    final PortStatusEntityBuilder portStatusEntityBuilder = new PortStatusEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(portStatusEntityBuilder, portStatusEntity);
    portStatusEntityBuilder.setCanRead(portStatusEntity.getCanRead());
    portStatusEntityBuilder.setPortStatus(portStatusEntity.getPortStatus());
    return portStatusEntityBuilder;
  }
}
