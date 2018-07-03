package com.tibtech.nifi.update.attributes.entity;

import java.lang.Long;
import java.lang.String;
import java.util.List;
import org.apache.nifi.update.attributes.dto.RuleDTO;
import org.apache.nifi.update.attributes.entity.RulesEntity;

public final class RulesEntityBuilder {
  private String clientId;

  private String processorId;

  private Long revision;

  private List<RuleDTO> rules;

  public String getClientId() {
    return clientId;
  }

  public RulesEntityBuilder setClientId(final String clientId) {
    this.clientId = clientId;
    return this;
  }

  public String getProcessorId() {
    return processorId;
  }

  public RulesEntityBuilder setProcessorId(final String processorId) {
    this.processorId = processorId;
    return this;
  }

  public Long getRevision() {
    return revision;
  }

  public RulesEntityBuilder setRevision(final Long revision) {
    this.revision = revision;
    return this;
  }

  public List<RuleDTO> getRules() {
    return rules;
  }

  public RulesEntityBuilder setRules(final List<RuleDTO> rules) {
    this.rules = rules;
    return this;
  }

  public RulesEntity build() {
    final RulesEntity rulesEntity = new RulesEntity();
    rulesEntity.setClientId(clientId);
    rulesEntity.setProcessorId(processorId);
    rulesEntity.setRevision(revision);
    rulesEntity.setRules(rules);
    return rulesEntity;
  }

  public static RulesEntityBuilder of(final RulesEntity rulesEntity) {
    final RulesEntityBuilder rulesEntityBuilder = new RulesEntityBuilder();
    rulesEntityBuilder.setClientId(rulesEntity.getClientId());
    rulesEntityBuilder.setProcessorId(rulesEntity.getProcessorId());
    rulesEntityBuilder.setRevision(rulesEntity.getRevision());
    rulesEntityBuilder.setRules(rulesEntity.getRules());
    return rulesEntityBuilder;
  }
}
