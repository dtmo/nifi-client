package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.AccessConfigurationDTO;
import org.apache.nifi.web.api.entity.AccessConfigurationEntity;

public final class AccessConfigurationEntityBuilder extends AbstractEntityBuilder<AccessConfigurationEntityBuilder> {
  private AccessConfigurationDTO config;

  public AccessConfigurationDTO getConfig() {
    return config;
  }

  public AccessConfigurationEntityBuilder setConfig(final AccessConfigurationDTO config) {
    this.config = config;
    return this;
  }

  public AccessConfigurationEntity build() {
    final AccessConfigurationEntity accessConfigurationEntity = new AccessConfigurationEntity();
    super.setPropertyValues(accessConfigurationEntity);
    accessConfigurationEntity.setConfig(config);
    return accessConfigurationEntity;
  }

  public static AccessConfigurationEntityBuilder of(final AccessConfigurationEntity accessConfigurationEntity) {
    final AccessConfigurationEntityBuilder accessConfigurationEntityBuilder = new AccessConfigurationEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(accessConfigurationEntityBuilder, accessConfigurationEntity);
    accessConfigurationEntityBuilder.setConfig(accessConfigurationEntity.getConfig());
    return accessConfigurationEntityBuilder;
  }
}
