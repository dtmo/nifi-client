package com.tibtech.nifi.web.api.dto;

import java.lang.Integer;
import org.apache.nifi.web.api.dto.ControllerConfigurationDTO;

public final class ControllerConfigurationDTOBuilder {
  private Integer maxEventDrivenThreadCount;

  private Integer maxTimerDrivenThreadCount;

  /**
   * The maximum number of event driven threads the NiFi has available.
   */
  public Integer getMaxEventDrivenThreadCount() {
    return maxEventDrivenThreadCount;
  }

  /**
   * The maximum number of event driven threads the NiFi has available.
   */
  public ControllerConfigurationDTOBuilder setMaxEventDrivenThreadCount(final Integer maxEventDrivenThreadCount) {
    this.maxEventDrivenThreadCount = maxEventDrivenThreadCount;
    return this;
  }

  /**
   * The maximum number of timer driven threads the NiFi has available.
   */
  public Integer getMaxTimerDrivenThreadCount() {
    return maxTimerDrivenThreadCount;
  }

  /**
   * The maximum number of timer driven threads the NiFi has available.
   */
  public ControllerConfigurationDTOBuilder setMaxTimerDrivenThreadCount(final Integer maxTimerDrivenThreadCount) {
    this.maxTimerDrivenThreadCount = maxTimerDrivenThreadCount;
    return this;
  }

  public ControllerConfigurationDTO build() {
    final ControllerConfigurationDTO controllerConfigurationDTO = new ControllerConfigurationDTO();
    controllerConfigurationDTO.setMaxEventDrivenThreadCount(maxEventDrivenThreadCount);
    controllerConfigurationDTO.setMaxTimerDrivenThreadCount(maxTimerDrivenThreadCount);
    return controllerConfigurationDTO;
  }

  public static ControllerConfigurationDTOBuilder of(final ControllerConfigurationDTO controllerConfigurationDTO) {
    final ControllerConfigurationDTOBuilder controllerConfigurationDTOBuilder = new ControllerConfigurationDTOBuilder();
    controllerConfigurationDTOBuilder.setMaxEventDrivenThreadCount(controllerConfigurationDTO.getMaxEventDrivenThreadCount());
    controllerConfigurationDTOBuilder.setMaxTimerDrivenThreadCount(controllerConfigurationDTO.getMaxTimerDrivenThreadCount());
    return controllerConfigurationDTOBuilder;
  }
}
