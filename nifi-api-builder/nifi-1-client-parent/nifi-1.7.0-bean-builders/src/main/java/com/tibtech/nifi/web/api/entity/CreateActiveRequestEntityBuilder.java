package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import java.lang.String;
import org.apache.nifi.web.api.entity.CreateActiveRequestEntity;

public final class CreateActiveRequestEntityBuilder extends AbstractEntityBuilder<CreateActiveRequestEntityBuilder> {
  private Boolean disconnectedNodeAcknowledged;

  private String processGroupId;

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  public Boolean getDisconnectedNodeAcknowledged() {
    return disconnectedNodeAcknowledged;
  }

  /**
   * Acknowledges that this node is disconnected to allow for mutable requests to proceed.
   */
  public CreateActiveRequestEntityBuilder setDisconnectedNodeAcknowledged(
      final Boolean disconnectedNodeAcknowledged) {
    this.disconnectedNodeAcknowledged = disconnectedNodeAcknowledged;
    return this;
  }

  /**
   * The Process Group ID that this active request will update
   */
  public String getProcessGroupId() {
    return processGroupId;
  }

  /**
   * The Process Group ID that this active request will update
   */
  public CreateActiveRequestEntityBuilder setProcessGroupId(final String processGroupId) {
    this.processGroupId = processGroupId;
    return this;
  }

  public CreateActiveRequestEntity build() {
    final CreateActiveRequestEntity createActiveRequestEntity = new CreateActiveRequestEntity();
    super.setPropertyValues(createActiveRequestEntity);
    createActiveRequestEntity.setDisconnectedNodeAcknowledged(disconnectedNodeAcknowledged);
    createActiveRequestEntity.setProcessGroupId(processGroupId);
    return createActiveRequestEntity;
  }

  public static CreateActiveRequestEntityBuilder of(
      final CreateActiveRequestEntity createActiveRequestEntity) {
    final CreateActiveRequestEntityBuilder createActiveRequestEntityBuilder = new CreateActiveRequestEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(createActiveRequestEntityBuilder, createActiveRequestEntity);
    createActiveRequestEntityBuilder.setDisconnectedNodeAcknowledged(createActiveRequestEntity.isDisconnectedNodeAcknowledged());
    createActiveRequestEntityBuilder.setProcessGroupId(createActiveRequestEntity.getProcessGroupId());
    return createActiveRequestEntityBuilder;
  }
}
