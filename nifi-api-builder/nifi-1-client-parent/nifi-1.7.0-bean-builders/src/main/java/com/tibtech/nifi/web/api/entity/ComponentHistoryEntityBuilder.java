package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.ComponentHistoryDTO;
import org.apache.nifi.web.api.entity.ComponentHistoryEntity;

public final class ComponentHistoryEntityBuilder extends AbstractEntityBuilder<ComponentHistoryEntityBuilder> {
  private ComponentHistoryDTO componentHistory;

  public ComponentHistoryDTO getComponentHistory() {
    return componentHistory;
  }

  public ComponentHistoryEntityBuilder setComponentHistory(final ComponentHistoryDTO componentHistory) {
    this.componentHistory = componentHistory;
    return this;
  }

  public ComponentHistoryEntity build() {
    final ComponentHistoryEntity componentHistoryEntity = new ComponentHistoryEntity();
    super.setPropertyValues(componentHistoryEntity);
    componentHistoryEntity.setComponentHistory(componentHistory);
    return componentHistoryEntity;
  }

  public static ComponentHistoryEntityBuilder of(final ComponentHistoryEntity componentHistoryEntity) {
    final ComponentHistoryEntityBuilder componentHistoryEntityBuilder = new ComponentHistoryEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(componentHistoryEntityBuilder, componentHistoryEntity);
    componentHistoryEntityBuilder.setComponentHistory(componentHistoryEntity.getComponentHistory());
    return componentHistoryEntityBuilder;
  }
}
