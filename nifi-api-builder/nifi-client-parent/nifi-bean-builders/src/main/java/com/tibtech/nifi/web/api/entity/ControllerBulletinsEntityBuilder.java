package com.tibtech.nifi.web.api.entity;

import java.util.List;
import org.apache.nifi.web.api.entity.BulletinEntity;
import org.apache.nifi.web.api.entity.ControllerBulletinsEntity;

public final class ControllerBulletinsEntityBuilder extends AbstractEntityBuilder<ControllerBulletinsEntityBuilder> {
  private List<BulletinEntity> bulletins;

  private List<BulletinEntity> controllerServiceBulletins;

  private List<BulletinEntity> reportingTaskBulletins;

  /**
   * System level bulletins to be reported to the user.
   */
  public List<BulletinEntity> getBulletins() {
    return bulletins;
  }

  /**
   * System level bulletins to be reported to the user.
   */
  public ControllerBulletinsEntityBuilder setBulletins(final List<BulletinEntity> bulletins) {
    this.bulletins = bulletins;
    return this;
  }

  /**
   * Controller service bulletins to be reported to the user.
   */
  public List<BulletinEntity> getControllerServiceBulletins() {
    return controllerServiceBulletins;
  }

  /**
   * Controller service bulletins to be reported to the user.
   */
  public ControllerBulletinsEntityBuilder setControllerServiceBulletins(final List<BulletinEntity> controllerServiceBulletins) {
    this.controllerServiceBulletins = controllerServiceBulletins;
    return this;
  }

  /**
   * Reporting task bulletins to be reported to the user.
   */
  public List<BulletinEntity> getReportingTaskBulletins() {
    return reportingTaskBulletins;
  }

  /**
   * Reporting task bulletins to be reported to the user.
   */
  public ControllerBulletinsEntityBuilder setReportingTaskBulletins(final List<BulletinEntity> reportingTaskBulletins) {
    this.reportingTaskBulletins = reportingTaskBulletins;
    return this;
  }

  public ControllerBulletinsEntity build() {
    final ControllerBulletinsEntity controllerBulletinsEntity = new ControllerBulletinsEntity();
    super.setPropertyValues(controllerBulletinsEntity);
    controllerBulletinsEntity.setBulletins(bulletins);
    controllerBulletinsEntity.setControllerServiceBulletins(controllerServiceBulletins);
    controllerBulletinsEntity.setReportingTaskBulletins(reportingTaskBulletins);
    return controllerBulletinsEntity;
  }

  public static ControllerBulletinsEntityBuilder of(final ControllerBulletinsEntity controllerBulletinsEntity) {
    final ControllerBulletinsEntityBuilder controllerBulletinsEntityBuilder = new ControllerBulletinsEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(controllerBulletinsEntityBuilder, controllerBulletinsEntity);
    controllerBulletinsEntityBuilder.setBulletins(controllerBulletinsEntity.getBulletins());
    controllerBulletinsEntityBuilder.setControllerServiceBulletins(controllerBulletinsEntity.getControllerServiceBulletins());
    controllerBulletinsEntityBuilder.setReportingTaskBulletins(controllerBulletinsEntity.getReportingTaskBulletins());
    return controllerBulletinsEntityBuilder;
  }
}
