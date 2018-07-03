package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.ControllerDTO;
import org.apache.nifi.web.api.entity.ControllerEntity;

public final class ControllerEntityBuilder extends AbstractEntityBuilder<ControllerEntityBuilder> {
  private ControllerDTO controller;

  public ControllerDTO getController() {
    return controller;
  }

  public ControllerEntityBuilder setController(final ControllerDTO controller) {
    this.controller = controller;
    return this;
  }

  public ControllerEntity build() {
    final ControllerEntity controllerEntity = new ControllerEntity();
    super.setPropertyValues(controllerEntity);
    controllerEntity.setController(controller);
    return controllerEntity;
  }

  public static ControllerEntityBuilder of(final ControllerEntity controllerEntity) {
    final ControllerEntityBuilder controllerEntityBuilder = new ControllerEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(controllerEntityBuilder, controllerEntity);
    controllerEntityBuilder.setController(controllerEntity.getController());
    return controllerEntityBuilder;
  }
}
