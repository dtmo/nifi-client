package com.tibtech.nifi.web.api.entity;

import java.lang.String;
import org.apache.nifi.web.api.dto.ComponentReferenceDTO;
import org.apache.nifi.web.api.entity.ComponentReferenceEntity;

public final class ComponentReferenceEntityBuilder extends AbstractComponentEntityBuilder<ComponentReferenceEntityBuilder> {
  private ComponentReferenceDTO component;

  private String parentGroupId;

  public ComponentReferenceDTO getComponent() {
    return component;
  }

  public ComponentReferenceEntityBuilder setComponent(final ComponentReferenceDTO component) {
    this.component = component;
    return this;
  }

  /**
   * The id of parent process group of this component if applicable.
   */
  public String getParentGroupId() {
    return parentGroupId;
  }

  /**
   * The id of parent process group of this component if applicable.
   */
  public ComponentReferenceEntityBuilder setParentGroupId(final String parentGroupId) {
    this.parentGroupId = parentGroupId;
    return this;
  }

  public ComponentReferenceEntity build() {
    final ComponentReferenceEntity componentReferenceEntity = new ComponentReferenceEntity();
    super.setPropertyValues(componentReferenceEntity);
    componentReferenceEntity.setComponent(component);
    componentReferenceEntity.setParentGroupId(parentGroupId);
    return componentReferenceEntity;
  }

  public static ComponentReferenceEntityBuilder of(final ComponentReferenceEntity componentReferenceEntity) {
    final ComponentReferenceEntityBuilder componentReferenceEntityBuilder = new ComponentReferenceEntityBuilder();
    AbstractComponentEntityBuilder.setBuilderValues(componentReferenceEntityBuilder, componentReferenceEntity);
    componentReferenceEntityBuilder.setComponent(componentReferenceEntity.getComponent());
    componentReferenceEntityBuilder.setParentGroupId(componentReferenceEntity.getParentGroupId());
    return componentReferenceEntityBuilder;
  }
}
