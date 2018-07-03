package com.tibtech.nifi.web.api.entity;

import java.util.Set;
import org.apache.nifi.web.api.entity.RegistryClientEntity;
import org.apache.nifi.web.api.entity.RegistryClientsEntity;

public final class RegistryClientsEntityBuilder extends AbstractEntityBuilder<RegistryClientsEntityBuilder> {
  private Set<RegistryClientEntity> registries;

  public Set<RegistryClientEntity> getRegistries() {
    return registries;
  }

  public RegistryClientsEntityBuilder setRegistries(final Set<RegistryClientEntity> registries) {
    this.registries = registries;
    return this;
  }

  public RegistryClientsEntity build() {
    final RegistryClientsEntity registryClientsEntity = new RegistryClientsEntity();
    super.setPropertyValues(registryClientsEntity);
    registryClientsEntity.setRegistries(registries);
    return registryClientsEntity;
  }

  public static RegistryClientsEntityBuilder of(final RegistryClientsEntity registryClientsEntity) {
    final RegistryClientsEntityBuilder registryClientsEntityBuilder = new RegistryClientsEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(registryClientsEntityBuilder, registryClientsEntity);
    registryClientsEntityBuilder.setRegistries(registryClientsEntity.getRegistries());
    return registryClientsEntityBuilder;
  }
}
