package com.tibtech.nifi.web.api.entity;

import java.util.Set;
import org.apache.nifi.web.api.entity.RegistriesEntity;
import org.apache.nifi.web.api.entity.RegistryEntity;

public final class RegistriesEntityBuilder extends AbstractEntityBuilder<RegistriesEntityBuilder> {
  private Set<RegistryEntity> registries;

  public Set<RegistryEntity> getRegistries() {
    return registries;
  }

  public RegistriesEntityBuilder setRegistries(final Set<RegistryEntity> registries) {
    this.registries = registries;
    return this;
  }

  public RegistriesEntity build() {
    final RegistriesEntity registriesEntity = new RegistriesEntity();
    super.setPropertyValues(registriesEntity);
    registriesEntity.setRegistries(registries);
    return registriesEntity;
  }

  public static RegistriesEntityBuilder of(final RegistriesEntity registriesEntity) {
    final RegistriesEntityBuilder registriesEntityBuilder = new RegistriesEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(registriesEntityBuilder, registriesEntity);
    registriesEntityBuilder.setRegistries(registriesEntity.getRegistries());
    return registriesEntityBuilder;
  }
}
