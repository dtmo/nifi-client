package com.tibtech.nifi.update.attributes.entity;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;
import java.util.List;
import org.apache.nifi.update.attributes.entity.EvaluationContextEntity;

public final class EvaluationContextEntityBuilder {
  private String clientId;

  private Boolean disconnectedNodeAcknowledged;

  private String flowFilePolicy;

  private String processorId;

  private Long revision;

  private List<String> ruleOrder;

  public String getClientId() {
    return clientId;
  }

  public EvaluationContextEntityBuilder setClientId(final String clientId) {
    this.clientId = clientId;
    return this;
  }

  public Boolean getDisconnectedNodeAcknowledged() {
    return disconnectedNodeAcknowledged;
  }

  public EvaluationContextEntityBuilder setDisconnectedNodeAcknowledged(final Boolean disconnectedNodeAcknowledged) {
    this.disconnectedNodeAcknowledged = disconnectedNodeAcknowledged;
    return this;
  }

  public String getFlowFilePolicy() {
    return flowFilePolicy;
  }

  public EvaluationContextEntityBuilder setFlowFilePolicy(final String flowFilePolicy) {
    this.flowFilePolicy = flowFilePolicy;
    return this;
  }

  public String getProcessorId() {
    return processorId;
  }

  public EvaluationContextEntityBuilder setProcessorId(final String processorId) {
    this.processorId = processorId;
    return this;
  }

  public Long getRevision() {
    return revision;
  }

  public EvaluationContextEntityBuilder setRevision(final Long revision) {
    this.revision = revision;
    return this;
  }

  public List<String> getRuleOrder() {
    return ruleOrder;
  }

  public EvaluationContextEntityBuilder setRuleOrder(final List<String> ruleOrder) {
    this.ruleOrder = ruleOrder;
    return this;
  }

  public EvaluationContextEntity build() {
    final EvaluationContextEntity evaluationContextEntity = new EvaluationContextEntity();
    evaluationContextEntity.setClientId(clientId);
    evaluationContextEntity.setDisconnectedNodeAcknowledged(disconnectedNodeAcknowledged);
    evaluationContextEntity.setFlowFilePolicy(flowFilePolicy);
    evaluationContextEntity.setProcessorId(processorId);
    evaluationContextEntity.setRevision(revision);
    evaluationContextEntity.setRuleOrder(ruleOrder);
    return evaluationContextEntity;
  }

  public static EvaluationContextEntityBuilder of(final EvaluationContextEntity evaluationContextEntity) {
    final EvaluationContextEntityBuilder evaluationContextEntityBuilder = new EvaluationContextEntityBuilder();
    evaluationContextEntityBuilder.setClientId(evaluationContextEntity.getClientId());
    evaluationContextEntityBuilder.setDisconnectedNodeAcknowledged(evaluationContextEntity.isDisconnectedNodeAcknowledged());
    evaluationContextEntityBuilder.setFlowFilePolicy(evaluationContextEntity.getFlowFilePolicy());
    evaluationContextEntityBuilder.setProcessorId(evaluationContextEntity.getProcessorId());
    evaluationContextEntityBuilder.setRevision(evaluationContextEntity.getRevision());
    evaluationContextEntityBuilder.setRuleOrder(evaluationContextEntity.getRuleOrder());
    return evaluationContextEntityBuilder;
  }
}
