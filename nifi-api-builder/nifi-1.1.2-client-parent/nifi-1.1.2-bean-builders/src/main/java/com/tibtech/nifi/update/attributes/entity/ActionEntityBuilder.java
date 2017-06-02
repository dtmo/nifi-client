package com.tibtech.nifi.update.attributes.entity;

import java.lang.Long;
import java.lang.String;
import org.apache.nifi.update.attributes.dto.ActionDTO;
import org.apache.nifi.update.attributes.entity.ActionEntity;

public final class ActionEntityBuilder {
  private ActionDTO action;

  private String clientId;

  private String processorId;

  private Long revision;

  public ActionDTO getAction() {
    return action;
  }

  public ActionEntityBuilder setAction(final ActionDTO action) {
    this.action = action;
    return this;
  }

  public String getClientId() {
    return clientId;
  }

  public ActionEntityBuilder setClientId(final String clientId) {
    this.clientId = clientId;
    return this;
  }

  public String getProcessorId() {
    return processorId;
  }

  public ActionEntityBuilder setProcessorId(final String processorId) {
    this.processorId = processorId;
    return this;
  }

  public Long getRevision() {
    return revision;
  }

  public ActionEntityBuilder setRevision(final Long revision) {
    this.revision = revision;
    return this;
  }

  public ActionEntity build() {
    final ActionEntity actionEntity = new ActionEntity();
    actionEntity.setAction(action);
    actionEntity.setClientId(clientId);
    actionEntity.setProcessorId(processorId);
    actionEntity.setRevision(revision);
    return actionEntity;
  }

  public static ActionEntityBuilder of(final ActionEntity actionEntity) {
    final ActionEntityBuilder actionEntityBuilder = new ActionEntityBuilder();
    actionEntityBuilder.setAction(actionEntity.getAction());
    actionEntityBuilder.setClientId(actionEntity.getClientId());
    actionEntityBuilder.setProcessorId(actionEntity.getProcessorId());
    actionEntityBuilder.setRevision(actionEntity.getRevision());
    return actionEntityBuilder;
  }
}
