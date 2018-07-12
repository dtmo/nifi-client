package com.tibtech.nifi.web.api.dto;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import org.apache.nifi.web.api.dto.FlowConfigurationDTO;

public final class FlowConfigurationDTOBuilder {
  private Long autoRefreshIntervalSeconds;

  private Date currentTime;

  private String defaultBackPressureDataSizeThreshold;

  private Long defaultBackPressureObjectThreshold;

  private Boolean supportsConfigurableAuthorizer;

  private Boolean supportsConfigurableUsersAndGroups;

  private Boolean supportsManagedAuthorizer;

  private Integer timeOffset;

  /**
   * The interval in seconds between the automatic NiFi refresh requests.
   */
  public Long getAutoRefreshIntervalSeconds() {
    return autoRefreshIntervalSeconds;
  }

  /**
   * The interval in seconds between the automatic NiFi refresh requests.
   */
  public FlowConfigurationDTOBuilder setAutoRefreshIntervalSeconds(
      final Long autoRefreshIntervalSeconds) {
    this.autoRefreshIntervalSeconds = autoRefreshIntervalSeconds;
    return this;
  }

  /**
   * The current time on the system.
   */
  public Date getCurrentTime() {
    return currentTime;
  }

  /**
   * The current time on the system.
   */
  public FlowConfigurationDTOBuilder setCurrentTime(final Date currentTime) {
    this.currentTime = currentTime;
    return this;
  }

  /**
   * The default back pressure data size threshold.
   */
  public String getDefaultBackPressureDataSizeThreshold() {
    return defaultBackPressureDataSizeThreshold;
  }

  /**
   * The default back pressure data size threshold.
   */
  public FlowConfigurationDTOBuilder setDefaultBackPressureDataSizeThreshold(
      final String defaultBackPressureDataSizeThreshold) {
    this.defaultBackPressureDataSizeThreshold = defaultBackPressureDataSizeThreshold;
    return this;
  }

  /**
   * The default back pressure object threshold.
   */
  public Long getDefaultBackPressureObjectThreshold() {
    return defaultBackPressureObjectThreshold;
  }

  /**
   * The default back pressure object threshold.
   */
  public FlowConfigurationDTOBuilder setDefaultBackPressureObjectThreshold(
      final Long defaultBackPressureObjectThreshold) {
    this.defaultBackPressureObjectThreshold = defaultBackPressureObjectThreshold;
    return this;
  }

  /**
   * Whether this NiFi supports a configurable authorizer.
   */
  public Boolean getSupportsConfigurableAuthorizer() {
    return supportsConfigurableAuthorizer;
  }

  /**
   * Whether this NiFi supports a configurable authorizer.
   */
  public FlowConfigurationDTOBuilder setSupportsConfigurableAuthorizer(
      final Boolean supportsConfigurableAuthorizer) {
    this.supportsConfigurableAuthorizer = supportsConfigurableAuthorizer;
    return this;
  }

  /**
   * Whether this NiFi supports configurable users and groups.
   */
  public Boolean getSupportsConfigurableUsersAndGroups() {
    return supportsConfigurableUsersAndGroups;
  }

  /**
   * Whether this NiFi supports configurable users and groups.
   */
  public FlowConfigurationDTOBuilder setSupportsConfigurableUsersAndGroups(
      final Boolean supportsConfigurableUsersAndGroups) {
    this.supportsConfigurableUsersAndGroups = supportsConfigurableUsersAndGroups;
    return this;
  }

  /**
   * Whether this NiFi supports a managed authorizer. Managed authorizers can visualize users, groups, and policies in the UI.
   */
  public Boolean getSupportsManagedAuthorizer() {
    return supportsManagedAuthorizer;
  }

  /**
   * Whether this NiFi supports a managed authorizer. Managed authorizers can visualize users, groups, and policies in the UI.
   */
  public FlowConfigurationDTOBuilder setSupportsManagedAuthorizer(
      final Boolean supportsManagedAuthorizer) {
    this.supportsManagedAuthorizer = supportsManagedAuthorizer;
    return this;
  }

  /**
   * The time offset of the system.
   */
  public Integer getTimeOffset() {
    return timeOffset;
  }

  /**
   * The time offset of the system.
   */
  public FlowConfigurationDTOBuilder setTimeOffset(final Integer timeOffset) {
    this.timeOffset = timeOffset;
    return this;
  }

  public FlowConfigurationDTO build() {
    final FlowConfigurationDTO flowConfigurationDTO = new FlowConfigurationDTO();
    flowConfigurationDTO.setAutoRefreshIntervalSeconds(autoRefreshIntervalSeconds);
    flowConfigurationDTO.setCurrentTime(currentTime);
    flowConfigurationDTO.setDefaultBackPressureDataSizeThreshold(defaultBackPressureDataSizeThreshold);
    flowConfigurationDTO.setDefaultBackPressureObjectThreshold(defaultBackPressureObjectThreshold);
    flowConfigurationDTO.setSupportsConfigurableAuthorizer(supportsConfigurableAuthorizer);
    flowConfigurationDTO.setSupportsConfigurableUsersAndGroups(supportsConfigurableUsersAndGroups);
    flowConfigurationDTO.setSupportsManagedAuthorizer(supportsManagedAuthorizer);
    flowConfigurationDTO.setTimeOffset(timeOffset);
    return flowConfigurationDTO;
  }

  public static FlowConfigurationDTOBuilder of(final FlowConfigurationDTO flowConfigurationDTO) {
    final FlowConfigurationDTOBuilder flowConfigurationDTOBuilder = new FlowConfigurationDTOBuilder();
    flowConfigurationDTOBuilder.setAutoRefreshIntervalSeconds(flowConfigurationDTO.getAutoRefreshIntervalSeconds());
    flowConfigurationDTOBuilder.setCurrentTime(flowConfigurationDTO.getCurrentTime());
    flowConfigurationDTOBuilder.setDefaultBackPressureDataSizeThreshold(flowConfigurationDTO.getDefaultBackPressureDataSizeThreshold());
    flowConfigurationDTOBuilder.setDefaultBackPressureObjectThreshold(flowConfigurationDTO.getDefaultBackPressureObjectThreshold());
    flowConfigurationDTOBuilder.setSupportsConfigurableAuthorizer(flowConfigurationDTO.getSupportsConfigurableAuthorizer());
    flowConfigurationDTOBuilder.setSupportsConfigurableUsersAndGroups(flowConfigurationDTO.getSupportsConfigurableUsersAndGroups());
    flowConfigurationDTOBuilder.setSupportsManagedAuthorizer(flowConfigurationDTO.getSupportsManagedAuthorizer());
    flowConfigurationDTOBuilder.setTimeOffset(flowConfigurationDTO.getTimeOffset());
    return flowConfigurationDTOBuilder;
  }
}
