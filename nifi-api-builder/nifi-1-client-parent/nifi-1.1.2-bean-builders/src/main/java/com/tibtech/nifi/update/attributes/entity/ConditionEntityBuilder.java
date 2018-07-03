package com.tibtech.nifi.update.attributes.entity;

import java.lang.Long;
import java.lang.String;
import org.apache.nifi.update.attributes.dto.ConditionDTO;
import org.apache.nifi.update.attributes.entity.ConditionEntity;

public final class ConditionEntityBuilder {
  private String clientId;

  private ConditionDTO condition;

  private String processorId;

  private Long revision;

  public String getClientId() {
    return clientId;
  }

  public ConditionEntityBuilder setClientId(final String clientId) {
    this.clientId = clientId;
    return this;
  }

  public ConditionDTO getCondition() {
    return condition;
  }

  public ConditionEntityBuilder setCondition(final ConditionDTO condition) {
    this.condition = condition;
    return this;
  }

  public String getProcessorId() {
    return processorId;
  }

  public ConditionEntityBuilder setProcessorId(final String processorId) {
    this.processorId = processorId;
    return this;
  }

  public Long getRevision() {
    return revision;
  }

  public ConditionEntityBuilder setRevision(final Long revision) {
    this.revision = revision;
    return this;
  }

  public ConditionEntity build() {
    final ConditionEntity conditionEntity = new ConditionEntity();
    conditionEntity.setClientId(clientId);
    conditionEntity.setCondition(condition);
    conditionEntity.setProcessorId(processorId);
    conditionEntity.setRevision(revision);
    return conditionEntity;
  }

  public static ConditionEntityBuilder of(final ConditionEntity conditionEntity) {
    final ConditionEntityBuilder conditionEntityBuilder = new ConditionEntityBuilder();
    conditionEntityBuilder.setClientId(conditionEntity.getClientId());
    conditionEntityBuilder.setCondition(conditionEntity.getCondition());
    conditionEntityBuilder.setProcessorId(conditionEntity.getProcessorId());
    conditionEntityBuilder.setRevision(conditionEntity.getRevision());
    return conditionEntityBuilder;
  }
}
