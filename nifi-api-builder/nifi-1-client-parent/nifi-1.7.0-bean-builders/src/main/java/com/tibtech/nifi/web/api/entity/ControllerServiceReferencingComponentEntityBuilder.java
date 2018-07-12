package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.ControllerServiceReferencingComponentDTO;
import org.apache.nifi.web.api.entity.ControllerServiceReferencingComponentEntity;

public final class ControllerServiceReferencingComponentEntityBuilder extends AbstractComponentEntityBuilder<ControllerServiceReferencingComponentEntityBuilder> {
  private ControllerServiceReferencingComponentDTO component;

  public ControllerServiceReferencingComponentDTO getComponent() {
    return component;
  }

  public ControllerServiceReferencingComponentEntityBuilder setComponent(
      final ControllerServiceReferencingComponentDTO component) {
    this.component = component;
    return this;
  }

  public ControllerServiceReferencingComponentEntity build() {
    final ControllerServiceReferencingComponentEntity controllerServiceReferencingComponentEntity = new ControllerServiceReferencingComponentEntity();
    super.setPropertyValues(controllerServiceReferencingComponentEntity);
    controllerServiceReferencingComponentEntity.setComponent(component);
    return controllerServiceReferencingComponentEntity;
  }

  public static ControllerServiceReferencingComponentEntityBuilder of(
      final ControllerServiceReferencingComponentEntity controllerServiceReferencingComponentEntity) {
    final ControllerServiceReferencingComponentEntityBuilder controllerServiceReferencingComponentEntityBuilder = new ControllerServiceReferencingComponentEntityBuilder();
    AbstractComponentEntityBuilder.setBuilderValues(controllerServiceReferencingComponentEntityBuilder, controllerServiceReferencingComponentEntity);
    controllerServiceReferencingComponentEntityBuilder.setComponent(controllerServiceReferencingComponentEntity.getComponent());
    return controllerServiceReferencingComponentEntityBuilder;
  }
}
