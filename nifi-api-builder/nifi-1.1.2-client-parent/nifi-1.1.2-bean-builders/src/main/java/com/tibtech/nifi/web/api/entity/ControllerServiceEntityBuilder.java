package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.ControllerServiceDTO;
import org.apache.nifi.web.api.entity.ControllerServiceEntity;

public final class ControllerServiceEntityBuilder extends AbstractComponentEntityBuilder<ControllerServiceEntityBuilder> {
  private ControllerServiceDTO component;

  public ControllerServiceDTO getComponent() {
    return component;
  }

  public ControllerServiceEntityBuilder setComponent(final ControllerServiceDTO component) {
    this.component = component;
    return this;
  }

  public ControllerServiceEntity build() {
    final ControllerServiceEntity controllerServiceEntity = new ControllerServiceEntity();
    super.setPropertyValues(controllerServiceEntity);
    controllerServiceEntity.setComponent(component);
    return controllerServiceEntity;
  }

  public static ControllerServiceEntityBuilder of(final ControllerServiceEntity controllerServiceEntity) {
    final ControllerServiceEntityBuilder controllerServiceEntityBuilder = new ControllerServiceEntityBuilder();
    AbstractComponentEntityBuilder.setBuilderValues(controllerServiceEntityBuilder, controllerServiceEntity);
    controllerServiceEntityBuilder.setComponent(controllerServiceEntity.getComponent());
    return controllerServiceEntityBuilder;
  }
}
