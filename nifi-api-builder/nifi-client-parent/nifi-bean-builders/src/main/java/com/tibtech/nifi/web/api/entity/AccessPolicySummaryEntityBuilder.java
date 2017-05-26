package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.AccessPolicySummaryDTO;
import org.apache.nifi.web.api.entity.AccessPolicySummaryEntity;

public final class AccessPolicySummaryEntityBuilder extends AbstractComponentEntityBuilder<AccessPolicySummaryEntityBuilder> {
  private AccessPolicySummaryDTO component;

  public AccessPolicySummaryDTO getComponent() {
    return component;
  }

  public AccessPolicySummaryEntityBuilder setComponent(final AccessPolicySummaryDTO component) {
    this.component = component;
    return this;
  }

  public AccessPolicySummaryEntity build() {
    final AccessPolicySummaryEntity accessPolicySummaryEntity = new AccessPolicySummaryEntity();
    super.setPropertyValues(accessPolicySummaryEntity);
    accessPolicySummaryEntity.setComponent(component);
    return accessPolicySummaryEntity;
  }

  public static AccessPolicySummaryEntityBuilder of(final AccessPolicySummaryEntity accessPolicySummaryEntity) {
    final AccessPolicySummaryEntityBuilder accessPolicySummaryEntityBuilder = new AccessPolicySummaryEntityBuilder();
    AbstractComponentEntityBuilder.setBuilderValues(accessPolicySummaryEntityBuilder, accessPolicySummaryEntity);
    accessPolicySummaryEntityBuilder.setComponent(accessPolicySummaryEntity.getComponent());
    return accessPolicySummaryEntityBuilder;
  }
}
