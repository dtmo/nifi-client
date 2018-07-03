package com.tibtech.nifi.web.api.entity;

import java.util.Set;
import org.apache.nifi.web.api.dto.ComponentDifferenceDTO;
import org.apache.nifi.web.api.entity.FlowComparisonEntity;

public final class FlowComparisonEntityBuilder extends AbstractEntityBuilder<FlowComparisonEntityBuilder> {
  private Set<ComponentDifferenceDTO> componentDifferences;

  /**
   * The list of differences for each component in the flow that is not the same between the two flows
   */
  public Set<ComponentDifferenceDTO> getComponentDifferences() {
    return componentDifferences;
  }

  /**
   * The list of differences for each component in the flow that is not the same between the two flows
   */
  public FlowComparisonEntityBuilder setComponentDifferences(final Set<ComponentDifferenceDTO> componentDifferences) {
    this.componentDifferences = componentDifferences;
    return this;
  }

  public FlowComparisonEntity build() {
    final FlowComparisonEntity flowComparisonEntity = new FlowComparisonEntity();
    super.setPropertyValues(flowComparisonEntity);
    flowComparisonEntity.setComponentDifferences(componentDifferences);
    return flowComparisonEntity;
  }

  public static FlowComparisonEntityBuilder of(final FlowComparisonEntity flowComparisonEntity) {
    final FlowComparisonEntityBuilder flowComparisonEntityBuilder = new FlowComparisonEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(flowComparisonEntityBuilder, flowComparisonEntity);
    flowComparisonEntityBuilder.setComponentDifferences(flowComparisonEntity.getComponentDifferences());
    return flowComparisonEntityBuilder;
  }
}
