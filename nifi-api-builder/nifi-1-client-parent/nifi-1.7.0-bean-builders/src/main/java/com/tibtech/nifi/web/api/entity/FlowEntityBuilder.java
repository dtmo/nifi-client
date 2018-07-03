package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.flow.FlowDTO;
import org.apache.nifi.web.api.entity.FlowEntity;

public final class FlowEntityBuilder extends AbstractEntityBuilder<FlowEntityBuilder> {
  private FlowDTO flow;

  public FlowDTO getFlow() {
    return flow;
  }

  public FlowEntityBuilder setFlow(final FlowDTO flow) {
    this.flow = flow;
    return this;
  }

  public FlowEntity build() {
    final FlowEntity flowEntity = new FlowEntity();
    super.setPropertyValues(flowEntity);
    flowEntity.setFlow(flow);
    return flowEntity;
  }

  public static FlowEntityBuilder of(final FlowEntity flowEntity) {
    final FlowEntityBuilder flowEntityBuilder = new FlowEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(flowEntityBuilder, flowEntity);
    flowEntityBuilder.setFlow(flowEntity.getFlow());
    return flowEntityBuilder;
  }
}
