package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.FlowFileDTO;
import org.apache.nifi.web.api.entity.FlowFileEntity;

public final class FlowFileEntityBuilder extends AbstractEntityBuilder<FlowFileEntityBuilder> {
  private FlowFileDTO flowFile;

  public FlowFileDTO getFlowFile() {
    return flowFile;
  }

  public FlowFileEntityBuilder setFlowFile(final FlowFileDTO flowFile) {
    this.flowFile = flowFile;
    return this;
  }

  public FlowFileEntity build() {
    final FlowFileEntity flowFileEntity = new FlowFileEntity();
    super.setPropertyValues(flowFileEntity);
    flowFileEntity.setFlowFile(flowFile);
    return flowFileEntity;
  }

  public static FlowFileEntityBuilder of(final FlowFileEntity flowFileEntity) {
    final FlowFileEntityBuilder flowFileEntityBuilder = new FlowFileEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(flowFileEntityBuilder, flowFileEntity);
    flowFileEntityBuilder.setFlowFile(flowFileEntity.getFlowFile());
    return flowFileEntityBuilder;
  }
}
