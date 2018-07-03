package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.RegistryDTO;
import org.apache.nifi.web.api.entity.RegistryEntity;

public final class RegistryEntityBuilder {
  private RegistryDTO registry;

  public RegistryDTO getRegistry() {
    return registry;
  }

  public RegistryEntityBuilder setRegistry(final RegistryDTO registry) {
    this.registry = registry;
    return this;
  }

  public RegistryEntity build() {
    final RegistryEntity registryEntity = new RegistryEntity();
    registryEntity.setRegistry(registry);
    return registryEntity;
  }

  public static RegistryEntityBuilder of(final RegistryEntity registryEntity) {
    final RegistryEntityBuilder registryEntityBuilder = new RegistryEntityBuilder();
    registryEntityBuilder.setRegistry(registryEntity.getRegistry());
    return registryEntityBuilder;
  }
}
