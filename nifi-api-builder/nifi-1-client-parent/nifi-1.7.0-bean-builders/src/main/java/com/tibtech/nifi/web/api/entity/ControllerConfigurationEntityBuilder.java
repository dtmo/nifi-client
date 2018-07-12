package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import org.apache.nifi.web.api.dto.PermissionsDTO;
import org.apache.nifi.web.api.dto.RevisionDTO;
import org.apache.nifi.web.api.entity.ControllerConfigurationEntity;

public final class ControllerConfigurationEntityBuilder extends AbstractEntityBuilder<ControllerConfigurationEntityBuilder> {
  private Boolean disconnectedNodeAcknowledged;

  private PermissionsDTO permissions;

  private RevisionDTO revision;

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  public Boolean getDisconnectedNodeAcknowledged() {
    return disconnectedNodeAcknowledged;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  public ControllerConfigurationEntityBuilder setDisconnectedNodeAcknowledged(
      final Boolean disconnectedNodeAcknowledged) {
    this.disconnectedNodeAcknowledged = disconnectedNodeAcknowledged;
    return this;
  }

  /**
   * The permissions for this component.
   */
  public PermissionsDTO getPermissions() {
    return permissions;
  }

  /**
   * The permissions for this component.
   */
  public ControllerConfigurationEntityBuilder setPermissions(final PermissionsDTO permissions) {
    this.permissions = permissions;
    return this;
  }

  /**
   * The revision for this request/response. The revision is required for any mutable flow requests and is included in all responses.
   */
  public RevisionDTO getRevision() {
    return revision;
  }

  /**
   * The revision for this request/response. The revision is required for any mutable flow requests and is included in all responses.
   */
  public ControllerConfigurationEntityBuilder setRevision(final RevisionDTO revision) {
    this.revision = revision;
    return this;
  }

  public ControllerConfigurationEntity build() {
    final ControllerConfigurationEntity controllerConfigurationEntity = new ControllerConfigurationEntity();
    super.setPropertyValues(controllerConfigurationEntity);
    controllerConfigurationEntity.setDisconnectedNodeAcknowledged(disconnectedNodeAcknowledged);
    controllerConfigurationEntity.setPermissions(permissions);
    controllerConfigurationEntity.setRevision(revision);
    return controllerConfigurationEntity;
  }

  public static ControllerConfigurationEntityBuilder of(
      final ControllerConfigurationEntity controllerConfigurationEntity) {
    final ControllerConfigurationEntityBuilder controllerConfigurationEntityBuilder = new ControllerConfigurationEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(controllerConfigurationEntityBuilder, controllerConfigurationEntity);
    controllerConfigurationEntityBuilder.setDisconnectedNodeAcknowledged(controllerConfigurationEntity.isDisconnectedNodeAcknowledged());
    controllerConfigurationEntityBuilder.setPermissions(controllerConfigurationEntity.getPermissions());
    controllerConfigurationEntityBuilder.setRevision(controllerConfigurationEntity.getRevision());
    return controllerConfigurationEntityBuilder;
  }
}
