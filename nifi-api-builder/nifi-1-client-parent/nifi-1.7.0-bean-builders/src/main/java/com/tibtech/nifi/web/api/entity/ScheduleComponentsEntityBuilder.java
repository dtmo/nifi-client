package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import java.lang.String;
import java.util.Map;
import org.apache.nifi.web.api.dto.RevisionDTO;
import org.apache.nifi.web.api.entity.ScheduleComponentsEntity;

public final class ScheduleComponentsEntityBuilder extends AbstractEntityBuilder<ScheduleComponentsEntityBuilder> {
  private Map<String, RevisionDTO> components;

  private Boolean disconnectedNodeAcknowledged;

  private String id;

  private String state;

  /**
   * Optional components to schedule. If not specified, all authorized descendant components will be used.
   */
  public Map<String, RevisionDTO> getComponents() {
    return components;
  }

  /**
   * Optional components to schedule. If not specified, all authorized descendant components will be used.
   */
  public ScheduleComponentsEntityBuilder setComponents(final Map<String, RevisionDTO> components) {
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
  public ScheduleComponentsEntityBuilder setDisconnectedNodeAcknowledged(
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
  public ScheduleComponentsEntityBuilder setId(final String id) {
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
  public ScheduleComponentsEntityBuilder setState(final String state) {
    this.state = state;
    return this;
  }

  public ScheduleComponentsEntity build() {
    final ScheduleComponentsEntity scheduleComponentsEntity = new ScheduleComponentsEntity();
    super.setPropertyValues(scheduleComponentsEntity);
    scheduleComponentsEntity.setComponents(components);
    scheduleComponentsEntity.setDisconnectedNodeAcknowledged(disconnectedNodeAcknowledged);
    scheduleComponentsEntity.setId(id);
    scheduleComponentsEntity.setState(state);
    return scheduleComponentsEntity;
  }

  public static ScheduleComponentsEntityBuilder of(
      final ScheduleComponentsEntity scheduleComponentsEntity) {
    final ScheduleComponentsEntityBuilder scheduleComponentsEntityBuilder = new ScheduleComponentsEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(scheduleComponentsEntityBuilder, scheduleComponentsEntity);
    scheduleComponentsEntityBuilder.setComponents(scheduleComponentsEntity.getComponents());
    scheduleComponentsEntityBuilder.setDisconnectedNodeAcknowledged(scheduleComponentsEntity.isDisconnectedNodeAcknowledged());
    scheduleComponentsEntityBuilder.setId(scheduleComponentsEntity.getId());
    scheduleComponentsEntityBuilder.setState(scheduleComponentsEntity.getState());
    return scheduleComponentsEntityBuilder;
  }
}
