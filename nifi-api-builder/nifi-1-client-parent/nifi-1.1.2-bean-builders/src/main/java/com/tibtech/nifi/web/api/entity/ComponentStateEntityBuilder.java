package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.ComponentStateDTO;
import org.apache.nifi.web.api.entity.ComponentStateEntity;

public final class ComponentStateEntityBuilder extends AbstractEntityBuilder<ComponentStateEntityBuilder> {
  private ComponentStateDTO componentState;

  /**
   * The component state.
   */
  public ComponentStateDTO getComponentState() {
    return componentState;
  }

  /**
   * The component state.
   */
  public ComponentStateEntityBuilder setComponentState(final ComponentStateDTO componentState) {
    this.componentState = componentState;
    return this;
  }

  public ComponentStateEntity build() {
    final ComponentStateEntity componentStateEntity = new ComponentStateEntity();
    super.setPropertyValues(componentStateEntity);
    componentStateEntity.setComponentState(componentState);
    return componentStateEntity;
  }

  public static ComponentStateEntityBuilder of(final ComponentStateEntity componentStateEntity) {
    final ComponentStateEntityBuilder componentStateEntityBuilder = new ComponentStateEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(componentStateEntityBuilder, componentStateEntity);
    componentStateEntityBuilder.setComponentState(componentStateEntity.getComponentState());
    return componentStateEntityBuilder;
  }
}
