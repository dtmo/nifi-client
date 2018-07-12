package com.tibtech.nifi.web.api.dto;

import java.lang.Boolean;
import org.apache.nifi.web.api.dto.AccessConfigurationDTO;

public final class AccessConfigurationDTOBuilder {
  private Boolean supportsLogin;

  /**
   * Indicates whether or not this NiFi supports user login.
   */
  public Boolean getSupportsLogin() {
    return supportsLogin;
  }

  /**
   * Indicates whether or not this NiFi supports user login.
   */
  public AccessConfigurationDTOBuilder setSupportsLogin(final Boolean supportsLogin) {
    this.supportsLogin = supportsLogin;
    return this;
  }

  public AccessConfigurationDTO build() {
    final AccessConfigurationDTO accessConfigurationDTO = new AccessConfigurationDTO();
    accessConfigurationDTO.setSupportsLogin(supportsLogin);
    return accessConfigurationDTO;
  }

  public static AccessConfigurationDTOBuilder of(
      final AccessConfigurationDTO accessConfigurationDTO) {
    final AccessConfigurationDTOBuilder accessConfigurationDTOBuilder = new AccessConfigurationDTOBuilder();
    accessConfigurationDTOBuilder.setSupportsLogin(accessConfigurationDTO.getSupportsLogin());
    return accessConfigurationDTOBuilder;
  }
}
