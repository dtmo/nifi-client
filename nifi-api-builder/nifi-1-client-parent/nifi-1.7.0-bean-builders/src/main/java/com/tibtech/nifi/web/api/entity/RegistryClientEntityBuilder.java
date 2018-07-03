package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.RegistryDTO;
import org.apache.nifi.web.api.entity.RegistryClientEntity;

public final class RegistryClientEntityBuilder extends AbstractComponentEntityBuilder<RegistryClientEntityBuilder> {
  private RegistryDTO component;

  public RegistryDTO getComponent() {
    return component;
  }

  public RegistryClientEntityBuilder setComponent(final RegistryDTO component) {
    this.component = component;
    return this;
  }

  public RegistryClientEntity build() {
    final RegistryClientEntity registryClientEntity = new RegistryClientEntity();
    super.setPropertyValues(registryClientEntity);
    registryClientEntity.setComponent(component);
    return registryClientEntity;
  }

  public static RegistryClientEntityBuilder of(final RegistryClientEntity registryClientEntity) {
    final RegistryClientEntityBuilder registryClientEntityBuilder = new RegistryClientEntityBuilder();
    AbstractComponentEntityBuilder.setBuilderValues(registryClientEntityBuilder, registryClientEntity);
    registryClientEntityBuilder.setComponent(registryClientEntity.getComponent());
    return registryClientEntityBuilder;
  }
}
