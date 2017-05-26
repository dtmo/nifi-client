package com.tibtech.nifi.web.api.entity;

import java.util.Set;
import org.apache.nifi.web.api.entity.ControllerServiceReferencingComponentEntity;
import org.apache.nifi.web.api.entity.ControllerServiceReferencingComponentsEntity;

public final class ControllerServiceReferencingComponentsEntityBuilder extends AbstractEntityBuilder<ControllerServiceReferencingComponentsEntityBuilder> {
  private Set<ControllerServiceReferencingComponentEntity> controllerServiceReferencingComponents;

  public Set<ControllerServiceReferencingComponentEntity> getControllerServiceReferencingComponents() {
    return controllerServiceReferencingComponents;
  }

  public ControllerServiceReferencingComponentsEntityBuilder setControllerServiceReferencingComponents(final Set<ControllerServiceReferencingComponentEntity> controllerServiceReferencingComponents) {
    this.controllerServiceReferencingComponents = controllerServiceReferencingComponents;
    return this;
  }

  public ControllerServiceReferencingComponentsEntity build() {
    final ControllerServiceReferencingComponentsEntity controllerServiceReferencingComponentsEntity = new ControllerServiceReferencingComponentsEntity();
    super.setPropertyValues(controllerServiceReferencingComponentsEntity);
    controllerServiceReferencingComponentsEntity.setControllerServiceReferencingComponents(controllerServiceReferencingComponents);
    return controllerServiceReferencingComponentsEntity;
  }

  public static ControllerServiceReferencingComponentsEntityBuilder of(final ControllerServiceReferencingComponentsEntity controllerServiceReferencingComponentsEntity) {
    final ControllerServiceReferencingComponentsEntityBuilder controllerServiceReferencingComponentsEntityBuilder = new ControllerServiceReferencingComponentsEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(controllerServiceReferencingComponentsEntityBuilder, controllerServiceReferencingComponentsEntity);
    controllerServiceReferencingComponentsEntityBuilder.setControllerServiceReferencingComponents(controllerServiceReferencingComponentsEntity.getControllerServiceReferencingComponents());
    return controllerServiceReferencingComponentsEntityBuilder;
  }
}
