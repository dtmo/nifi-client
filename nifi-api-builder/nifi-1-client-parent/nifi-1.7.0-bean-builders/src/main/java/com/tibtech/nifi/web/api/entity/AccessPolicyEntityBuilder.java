package com.tibtech.nifi.web.api.entity;

import java.util.Date;
import org.apache.nifi.web.api.dto.AccessPolicyDTO;
import org.apache.nifi.web.api.entity.AccessPolicyEntity;

public final class AccessPolicyEntityBuilder extends AbstractComponentEntityBuilder<AccessPolicyEntityBuilder> {
  private AccessPolicyDTO component;

  private Date generated;

  public AccessPolicyDTO getComponent() {
    return component;
  }

  public AccessPolicyEntityBuilder setComponent(final AccessPolicyDTO component) {
    this.component = component;
    return this;
  }

  /**
   * When this content was generated.
   */
  public Date getGenerated() {
    return generated;
  }

  /**
   * When this content was generated.
   */
  public AccessPolicyEntityBuilder setGenerated(final Date generated) {
    this.generated = generated;
    return this;
  }

  public AccessPolicyEntity build() {
    final AccessPolicyEntity accessPolicyEntity = new AccessPolicyEntity();
    super.setPropertyValues(accessPolicyEntity);
    accessPolicyEntity.setComponent(component);
    accessPolicyEntity.setGenerated(generated);
    return accessPolicyEntity;
  }

  public static AccessPolicyEntityBuilder of(final AccessPolicyEntity accessPolicyEntity) {
    final AccessPolicyEntityBuilder accessPolicyEntityBuilder = new AccessPolicyEntityBuilder();
    AbstractComponentEntityBuilder.setBuilderValues(accessPolicyEntityBuilder, accessPolicyEntity);
    accessPolicyEntityBuilder.setComponent(accessPolicyEntity.getComponent());
    accessPolicyEntityBuilder.setGenerated(accessPolicyEntity.getGenerated());
    return accessPolicyEntityBuilder;
  }
}
