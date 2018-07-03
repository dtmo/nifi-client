package com.tibtech.nifi.update.attributes.entity;

import java.lang.Long;
import java.lang.String;
import org.apache.nifi.update.attributes.dto.RuleDTO;
import org.apache.nifi.update.attributes.entity.RuleEntity;

public final class RuleEntityBuilder {
  private String clientId;

  private String processorId;

  private Long revision;

  private RuleDTO rule;

  public String getClientId() {
    return clientId;
  }

  public RuleEntityBuilder setClientId(final String clientId) {
    this.clientId = clientId;
    return this;
  }

  public String getProcessorId() {
    return processorId;
  }

  public RuleEntityBuilder setProcessorId(final String processorId) {
    this.processorId = processorId;
    return this;
  }

  public Long getRevision() {
    return revision;
  }

  public RuleEntityBuilder setRevision(final Long revision) {
    this.revision = revision;
    return this;
  }

  public RuleDTO getRule() {
    return rule;
  }

  public RuleEntityBuilder setRule(final RuleDTO rule) {
    this.rule = rule;
    return this;
  }

  public RuleEntity build() {
    final RuleEntity ruleEntity = new RuleEntity();
    ruleEntity.setClientId(clientId);
    ruleEntity.setProcessorId(processorId);
    ruleEntity.setRevision(revision);
    ruleEntity.setRule(rule);
    return ruleEntity;
  }

  public static RuleEntityBuilder of(final RuleEntity ruleEntity) {
    final RuleEntityBuilder ruleEntityBuilder = new RuleEntityBuilder();
    ruleEntityBuilder.setClientId(ruleEntity.getClientId());
    ruleEntityBuilder.setProcessorId(ruleEntity.getProcessorId());
    ruleEntityBuilder.setRevision(ruleEntity.getRevision());
    ruleEntityBuilder.setRule(ruleEntity.getRule());
    return ruleEntityBuilder;
  }
}
