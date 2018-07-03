package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import org.apache.nifi.web.api.dto.AllowableValueDTO;
import org.apache.nifi.web.api.entity.AllowableValueEntity;

public final class AllowableValueEntityBuilder extends AbstractEntityBuilder<AllowableValueEntityBuilder> {
  private AllowableValueDTO allowableValue;

  private Boolean canRead;

  public AllowableValueDTO getAllowableValue() {
    return allowableValue;
  }

  public AllowableValueEntityBuilder setAllowableValue(final AllowableValueDTO allowableValue) {
    this.allowableValue = allowableValue;
    return this;
  }

  public Boolean getCanRead() {
    return canRead;
  }

  public AllowableValueEntityBuilder setCanRead(final Boolean canRead) {
    this.canRead = canRead;
    return this;
  }

  public AllowableValueEntity build() {
    final AllowableValueEntity allowableValueEntity = new AllowableValueEntity();
    super.setPropertyValues(allowableValueEntity);
    allowableValueEntity.setAllowableValue(allowableValue);
    allowableValueEntity.setCanRead(canRead);
    return allowableValueEntity;
  }

  public static AllowableValueEntityBuilder of(final AllowableValueEntity allowableValueEntity) {
    final AllowableValueEntityBuilder allowableValueEntityBuilder = new AllowableValueEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(allowableValueEntityBuilder, allowableValueEntity);
    allowableValueEntityBuilder.setAllowableValue(allowableValueEntity.getAllowableValue());
    allowableValueEntityBuilder.setCanRead(allowableValueEntity.getCanRead());
    return allowableValueEntityBuilder;
  }
}
