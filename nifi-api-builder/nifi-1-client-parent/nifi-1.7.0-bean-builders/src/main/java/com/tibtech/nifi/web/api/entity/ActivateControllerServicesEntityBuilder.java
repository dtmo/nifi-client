package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import java.lang.String;
import java.util.Map;
import org.apache.nifi.web.api.dto.RevisionDTO;
import org.apache.nifi.web.api.entity.ActivateControllerServicesEntity;

public final class ActivateControllerServicesEntityBuilder extends AbstractEntityBuilder<ActivateControllerServicesEntityBuilder> {
  private Map<String, RevisionDTO> components;

  private Boolean disconnectedNodeAcknowledged;

  private String id;

  private String state;

  /**
   * Optional services to schedule. If not specified, all authorized descendant controller services will be used.
   */
  public Map<String, RevisionDTO> getComponents() {
    return components;
  }

  /**
   * Optional services to schedule. If not specified, all authorized descendant controller services will be used.
   */
  public ActivateControllerServicesEntityBuilder setComponents(
      final Map<String, RevisionDTO> components) {
    this.components = components;
    return this;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  public Boolean getDisconnectedNodeAcknowledged() {
    return disconnectedNodeAcknowledged;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  public ActivateControllerServicesEntityBuilder setDisconnectedNodeAcknowledged(
      final Boolean disconnectedNodeAcknowledged) {
    this.disconnectedNodeAcknowledged = disconnectedNodeAcknowledged;
    return this;
  }

  /**
   * The id of the ProcessGroup
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the ProcessGroup
   */
  public ActivateControllerServicesEntityBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The desired state of the descendant components
   */
  public String getState() {
    return state;
  }

  /**
   * The desired state of the descendant components
   */
  public ActivateControllerServicesEntityBuilder setState(final String state) {
    this.state = state;
    return this;
  }

  public ActivateControllerServicesEntity build() {
    final ActivateControllerServicesEntity activateControllerServicesEntity = new ActivateControllerServicesEntity();
    super.setPropertyValues(activateControllerServicesEntity);
    activateControllerServicesEntity.setComponents(components);
    activateControllerServicesEntity.setDisconnectedNodeAcknowledged(disconnectedNodeAcknowledged);
    activateControllerServicesEntity.setId(id);
    activateControllerServicesEntity.setState(state);
    return activateControllerServicesEntity;
  }

  public static ActivateControllerServicesEntityBuilder of(
      final ActivateControllerServicesEntity activateControllerServicesEntity) {
    final ActivateControllerServicesEntityBuilder activateControllerServicesEntityBuilder = new ActivateControllerServicesEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(activateControllerServicesEntityBuilder, activateControllerServicesEntity);
    activateControllerServicesEntityBuilder.setComponents(activateControllerServicesEntity.getComponents());
    activateControllerServicesEntityBuilder.setDisconnectedNodeAcknowledged(activateControllerServicesEntity.isDisconnectedNodeAcknowledged());
    activateControllerServicesEntityBuilder.setId(activateControllerServicesEntity.getId());
    activateControllerServicesEntityBuilder.setState(activateControllerServicesEntity.getState());
    return activateControllerServicesEntityBuilder;
  }
}
