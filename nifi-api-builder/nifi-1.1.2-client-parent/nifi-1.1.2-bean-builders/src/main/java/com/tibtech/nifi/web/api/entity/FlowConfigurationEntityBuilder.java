package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.FlowConfigurationDTO;
import org.apache.nifi.web.api.entity.FlowConfigurationEntity;

public final class FlowConfigurationEntityBuilder extends AbstractEntityBuilder<FlowConfigurationEntityBuilder> {
  private FlowConfigurationDTO flowConfiguration;

  /**
   * The controller configuration.
   */
  public FlowConfigurationDTO getFlowConfiguration() {
    return flowConfiguration;
  }

  /**
   * The controller configuration.
   */
  public FlowConfigurationEntityBuilder setFlowConfiguration(final FlowConfigurationDTO flowConfiguration) {
    this.flowConfiguration = flowConfiguration;
    return this;
  }

  public FlowConfigurationEntity build() {
    final FlowConfigurationEntity flowConfigurationEntity = new FlowConfigurationEntity();
    super.setPropertyValues(flowConfigurationEntity);
    flowConfigurationEntity.setFlowConfiguration(flowConfiguration);
    return flowConfigurationEntity;
  }

  public static FlowConfigurationEntityBuilder of(final FlowConfigurationEntity flowConfigurationEntity) {
    final FlowConfigurationEntityBuilder flowConfigurationEntityBuilder = new FlowConfigurationEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(flowConfigurationEntityBuilder, flowConfigurationEntity);
    flowConfigurationEntityBuilder.setFlowConfiguration(flowConfigurationEntity.getFlowConfiguration());
    return flowConfigurationEntityBuilder;
  }
}
