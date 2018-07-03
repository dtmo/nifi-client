package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.status.ControllerStatusDTO;
import org.apache.nifi.web.api.entity.ControllerStatusEntity;

public final class ControllerStatusEntityBuilder extends AbstractEntityBuilder<ControllerStatusEntityBuilder> {
  private ControllerStatusDTO controllerStatus;

  public ControllerStatusDTO getControllerStatus() {
    return controllerStatus;
  }

  public ControllerStatusEntityBuilder setControllerStatus(final ControllerStatusDTO controllerStatus) {
    this.controllerStatus = controllerStatus;
    return this;
  }

  public ControllerStatusEntity build() {
    final ControllerStatusEntity controllerStatusEntity = new ControllerStatusEntity();
    super.setPropertyValues(controllerStatusEntity);
    controllerStatusEntity.setControllerStatus(controllerStatus);
    return controllerStatusEntity;
  }

  public static ControllerStatusEntityBuilder of(final ControllerStatusEntity controllerStatusEntity) {
    final ControllerStatusEntityBuilder controllerStatusEntityBuilder = new ControllerStatusEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(controllerStatusEntityBuilder, controllerStatusEntity);
    controllerStatusEntityBuilder.setControllerStatus(controllerStatusEntity.getControllerStatus());
    return controllerStatusEntityBuilder;
  }
}
