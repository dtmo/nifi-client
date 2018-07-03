package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.entity.ComponentEntity;

public final class ComponentEntityBuilder extends AbstractComponentEntityBuilder<ComponentEntityBuilder> {
  public ComponentEntity build() {
    final ComponentEntity componentEntity = new ComponentEntity();
    super.setPropertyValues(componentEntity);
    return componentEntity;
  }

  public static ComponentEntityBuilder of(final ComponentEntity componentEntity) {
    final ComponentEntityBuilder componentEntityBuilder = new ComponentEntityBuilder();
    AbstractComponentEntityBuilder.setBuilderValues(componentEntityBuilder, componentEntity);
    return componentEntityBuilder;
  }
}
