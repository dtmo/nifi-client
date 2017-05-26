package com.tibtech.nifi.web.api.dto;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;
import java.util.Date;
import org.apache.nifi.web.api.dto.FlowConfigurationDTO;

public final class FlowConfigurationDTOBuilder {
  private Long autoRefreshIntervalSeconds;

  private Date currentTime;

  private Boolean supportsConfigurableAuthorizer;

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
  public FlowConfigurationDTOBuilder setAutoRefreshIntervalSeconds(final Long autoRefreshIntervalSeconds) {
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
   * Whether this NiFi supports a configurable authorizer.
   */
  public Boolean getSupportsConfigurableAuthorizer() {
    return supportsConfigurableAuthorizer;
  }

  /**
   * Whether this NiFi supports a configurable authorizer.
   */
  public FlowConfigurationDTOBuilder setSupportsConfigurableAuthorizer(final Boolean supportsConfigurableAuthorizer) {
    this.supportsConfigurableAuthorizer = supportsConfigurableAuthorizer;
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
    flowConfigurationDTO.setSupportsConfigurableAuthorizer(supportsConfigurableAuthorizer);
    flowConfigurationDTO.setTimeOffset(timeOffset);
    return flowConfigurationDTO;
  }

  public static FlowConfigurationDTOBuilder of(final FlowConfigurationDTO flowConfigurationDTO) {
    final FlowConfigurationDTOBuilder flowConfigurationDTOBuilder = new FlowConfigurationDTOBuilder();
    flowConfigurationDTOBuilder.setAutoRefreshIntervalSeconds(flowConfigurationDTO.getAutoRefreshIntervalSeconds());
    flowConfigurationDTOBuilder.setCurrentTime(flowConfigurationDTO.getCurrentTime());
    flowConfigurationDTOBuilder.setSupportsConfigurableAuthorizer(flowConfigurationDTO.getSupportsConfigurableAuthorizer());
    flowConfigurationDTOBuilder.setTimeOffset(flowConfigurationDTO.getTimeOffset());
    return flowConfigurationDTOBuilder;
  }
}
