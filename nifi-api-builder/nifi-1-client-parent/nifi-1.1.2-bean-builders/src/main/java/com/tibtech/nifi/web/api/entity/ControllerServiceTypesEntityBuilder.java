package com.tibtech.nifi.web.api.entity;

import java.util.Set;
import org.apache.nifi.web.api.dto.DocumentedTypeDTO;
import org.apache.nifi.web.api.entity.ControllerServiceTypesEntity;

public final class ControllerServiceTypesEntityBuilder extends AbstractEntityBuilder<ControllerServiceTypesEntityBuilder> {
  private Set<DocumentedTypeDTO> controllerServiceTypes;

  public Set<DocumentedTypeDTO> getControllerServiceTypes() {
    return controllerServiceTypes;
  }

  public ControllerServiceTypesEntityBuilder setControllerServiceTypes(final Set<DocumentedTypeDTO> controllerServiceTypes) {
    this.controllerServiceTypes = controllerServiceTypes;
    return this;
  }

  public ControllerServiceTypesEntity build() {
    final ControllerServiceTypesEntity controllerServiceTypesEntity = new ControllerServiceTypesEntity();
    super.setPropertyValues(controllerServiceTypesEntity);
    controllerServiceTypesEntity.setControllerServiceTypes(controllerServiceTypes);
    return controllerServiceTypesEntity;
  }

  public static ControllerServiceTypesEntityBuilder of(final ControllerServiceTypesEntity controllerServiceTypesEntity) {
    final ControllerServiceTypesEntityBuilder controllerServiceTypesEntityBuilder = new ControllerServiceTypesEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(controllerServiceTypesEntityBuilder, controllerServiceTypesEntity);
    controllerServiceTypesEntityBuilder.setControllerServiceTypes(controllerServiceTypesEntity.getControllerServiceTypes());
    return controllerServiceTypesEntityBuilder;
  }
}
