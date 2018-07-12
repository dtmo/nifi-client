package com.tibtech.nifi.web.api.entity;

import java.util.Date;
import java.util.Set;
import org.apache.nifi.web.api.entity.ControllerServiceEntity;
import org.apache.nifi.web.api.entity.ControllerServicesEntity;

public final class ControllerServicesEntityBuilder extends AbstractEntityBuilder<ControllerServicesEntityBuilder> {
  private Set<ControllerServiceEntity> controllerServices;

  private Date currentTime;

  public Set<ControllerServiceEntity> getControllerServices() {
    return controllerServices;
  }

  public ControllerServicesEntityBuilder setControllerServices(
      final Set<ControllerServiceEntity> controllerServices) {
    this.controllerServices = controllerServices;
    return this;
  }

  /**
   * The current time on the system.
   */
  public Date getCurrentTime() {
    return currentTime;
  }

  /**
   * The current time on the system.
   */
  public ControllerServicesEntityBuilder setCurrentTime(final Date currentTime) {
    this.currentTime = currentTime;
    return this;
  }

  public ControllerServicesEntity build() {
    final ControllerServicesEntity controllerServicesEntity = new ControllerServicesEntity();
    super.setPropertyValues(controllerServicesEntity);
    controllerServicesEntity.setControllerServices(controllerServices);
    controllerServicesEntity.setCurrentTime(currentTime);
    return controllerServicesEntity;
  }

  public static ControllerServicesEntityBuilder of(
      final ControllerServicesEntity controllerServicesEntity) {
    final ControllerServicesEntityBuilder controllerServicesEntityBuilder = new ControllerServicesEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(controllerServicesEntityBuilder, controllerServicesEntity);
    controllerServicesEntityBuilder.setControllerServices(controllerServicesEntity.getControllerServices());
    controllerServicesEntityBuilder.setCurrentTime(controllerServicesEntity.getCurrentTime());
    return controllerServicesEntityBuilder;
  }
}
