package com.tibtech.nifi.web.api.dto;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Collection;
import java.util.Set;
import org.apache.nifi.web.api.dto.PortDTO;

public final class PortDTOBuilder extends AbstractComponentDTOBuilder<PortDTOBuilder> {
  private String comments;

  private Integer concurrentlySchedulableTaskCount;

  private Set<String> groupAccessControl;

  private String name;

  private String state;

  private Boolean transmitting;

  private String type;

  private Set<String> userAccessControl;

  private Collection<String> validationErrors;

  /**
   * The comments for the port.
   */
  public String getComments() {
    return comments;
  }

  /**
   * The comments for the port.
   */
  public PortDTOBuilder setComments(final String comments) {
    this.comments = comments;
    return this;
  }

  /**
   * The number of tasks that should be concurrently scheduled for the port.
   */
  public Integer getConcurrentlySchedulableTaskCount() {
    return concurrentlySchedulableTaskCount;
  }

  /**
   * The number of tasks that should be concurrently scheduled for the port.
   */
  public PortDTOBuilder setConcurrentlySchedulableTaskCount(
      final Integer concurrentlySchedulableTaskCount) {
    this.concurrentlySchedulableTaskCount = concurrentlySchedulableTaskCount;
    return this;
  }

  /**
   * The user groups that are allowed to access the port.
   */
  public Set<String> getGroupAccessControl() {
    return groupAccessControl;
  }

  /**
   * The user groups that are allowed to access the port.
   */
  public PortDTOBuilder setGroupAccessControl(final Set<String> groupAccessControl) {
    this.groupAccessControl = groupAccessControl;
    return this;
  }

  /**
   * The name of the port.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the port.
   */
  public PortDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * The state of the port.
   */
  public String getState() {
    return state;
  }

  /**
   * The state of the port.
   */
  public PortDTOBuilder setState(final String state) {
    this.state = state;
    return this;
  }

  /**
   * Whether the port has incoming or output connections to a remote NiFi. This is only applicable when the port is running in the root group.
   */
  public Boolean getTransmitting() {
    return transmitting;
  }

  /**
   * Whether the port has incoming or output connections to a remote NiFi. This is only applicable when the port is running in the root group.
   */
  public PortDTOBuilder setTransmitting(final Boolean transmitting) {
    this.transmitting = transmitting;
    return this;
  }

  /**
   * The type of port.
   */
  public String getType() {
    return type;
  }

  /**
   * The type of port.
   */
  public PortDTOBuilder setType(final String type) {
    this.type = type;
    return this;
  }

  /**
   * The users that are allowed to access the port.
   */
  public Set<String> getUserAccessControl() {
    return userAccessControl;
  }

  /**
   * The users that are allowed to access the port.
   */
  public PortDTOBuilder setUserAccessControl(final Set<String> userAccessControl) {
    this.userAccessControl = userAccessControl;
    return this;
  }

  /**
   * Gets the validation errors from this port. These validation errors represent the problems with the port that must be resolved before it can be started.
   */
  public Collection<String> getValidationErrors() {
    return validationErrors;
  }

  /**
   * Gets the validation errors from this port. These validation errors represent the problems with the port that must be resolved before it can be started.
   */
  public PortDTOBuilder setValidationErrors(final Collection<String> validationErrors) {
    this.validationErrors = validationErrors;
    return this;
  }

  public PortDTO build() {
    final PortDTO portDTO = new PortDTO();
    super.setPropertyValues(portDTO);
    portDTO.setComments(comments);
    portDTO.setConcurrentlySchedulableTaskCount(concurrentlySchedulableTaskCount);
    portDTO.setGroupAccessControl(groupAccessControl);
    portDTO.setName(name);
    portDTO.setState(state);
    portDTO.setTransmitting(transmitting);
    portDTO.setType(type);
    portDTO.setUserAccessControl(userAccessControl);
    portDTO.setValidationErrors(validationErrors);
    return portDTO;
  }

  public static PortDTOBuilder of(final PortDTO portDTO) {
    final PortDTOBuilder portDTOBuilder = new PortDTOBuilder();
    AbstractComponentDTOBuilder.setBuilderValues(portDTOBuilder, portDTO);
    portDTOBuilder.setComments(portDTO.getComments());
    portDTOBuilder.setConcurrentlySchedulableTaskCount(portDTO.getConcurrentlySchedulableTaskCount());
    portDTOBuilder.setGroupAccessControl(portDTO.getGroupAccessControl());
    portDTOBuilder.setName(portDTO.getName());
    portDTOBuilder.setState(portDTO.getState());
    portDTOBuilder.setTransmitting(portDTO.isTransmitting());
    portDTOBuilder.setType(portDTO.getType());
    portDTOBuilder.setUserAccessControl(portDTO.getUserAccessControl());
    portDTOBuilder.setValidationErrors(portDTO.getValidationErrors());
    return portDTOBuilder;
  }
}
