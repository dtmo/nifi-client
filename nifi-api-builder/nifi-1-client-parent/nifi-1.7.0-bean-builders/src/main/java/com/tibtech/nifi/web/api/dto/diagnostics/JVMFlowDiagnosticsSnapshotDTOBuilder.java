package com.tibtech.nifi.web.api.dto.diagnostics;

import java.lang.Integer;
import java.lang.String;
import java.util.Set;
import org.apache.nifi.web.api.dto.BundleDTO;
import org.apache.nifi.web.api.dto.diagnostics.JVMFlowDiagnosticsSnapshotDTO;

public final class JVMFlowDiagnosticsSnapshotDTOBuilder {
  private Integer activeEventDrivenThreads;

  private Integer activeTimerDrivenThreads;

  private Set<BundleDTO> bundlesLoaded;

  private String timeZone;

  private String uptime;

  /**
   * The number of event-driven threads that are active
   */
  public Integer getActiveEventDrivenThreads() {
    return activeEventDrivenThreads;
  }

  /**
   * The number of event-driven threads that are active
   */
  public JVMFlowDiagnosticsSnapshotDTOBuilder setActiveEventDrivenThreads(
      final Integer activeEventDrivenThreads) {
    this.activeEventDrivenThreads = activeEventDrivenThreads;
    return this;
  }

  /**
   * The number of timer-driven threads that are active
   */
  public Integer getActiveTimerDrivenThreads() {
    return activeTimerDrivenThreads;
  }

  /**
   * The number of timer-driven threads that are active
   */
  public JVMFlowDiagnosticsSnapshotDTOBuilder setActiveTimerDrivenThreads(
      final Integer activeTimerDrivenThreads) {
    this.activeTimerDrivenThreads = activeTimerDrivenThreads;
    return this;
  }

  /**
   * The NiFi Bundles (NARs) that are loaded by NiFi
   */
  public Set<BundleDTO> getBundlesLoaded() {
    return bundlesLoaded;
  }

  /**
   * The NiFi Bundles (NARs) that are loaded by NiFi
   */
  public JVMFlowDiagnosticsSnapshotDTOBuilder setBundlesLoaded(final Set<BundleDTO> bundlesLoaded) {
    this.bundlesLoaded = bundlesLoaded;
    return this;
  }

  /**
   * The name of the Time Zone that is configured, if available
   */
  public String getTimeZone() {
    return timeZone;
  }

  /**
   * The name of the Time Zone that is configured, if available
   */
  public JVMFlowDiagnosticsSnapshotDTOBuilder setTimeZone(final String timeZone) {
    this.timeZone = timeZone;
    return this;
  }

  /**
   * How long this node has been running, formatted as hours:minutes:seconds.milliseconds
   */
  public String getUptime() {
    return uptime;
  }

  /**
   * How long this node has been running, formatted as hours:minutes:seconds.milliseconds
   */
  public JVMFlowDiagnosticsSnapshotDTOBuilder setUptime(final String uptime) {
    this.uptime = uptime;
    return this;
  }

  public JVMFlowDiagnosticsSnapshotDTO build() {
    final JVMFlowDiagnosticsSnapshotDTO jVMFlowDiagnosticsSnapshotDTO = new JVMFlowDiagnosticsSnapshotDTO();
    jVMFlowDiagnosticsSnapshotDTO.setActiveEventDrivenThreads(activeEventDrivenThreads);
    jVMFlowDiagnosticsSnapshotDTO.setActiveTimerDrivenThreads(activeTimerDrivenThreads);
    jVMFlowDiagnosticsSnapshotDTO.setBundlesLoaded(bundlesLoaded);
    jVMFlowDiagnosticsSnapshotDTO.setTimeZone(timeZone);
    jVMFlowDiagnosticsSnapshotDTO.setUptime(uptime);
    return jVMFlowDiagnosticsSnapshotDTO;
  }

  public static JVMFlowDiagnosticsSnapshotDTOBuilder of(
      final JVMFlowDiagnosticsSnapshotDTO jVMFlowDiagnosticsSnapshotDTO) {
    final JVMFlowDiagnosticsSnapshotDTOBuilder jVMFlowDiagnosticsSnapshotDTOBuilder = new JVMFlowDiagnosticsSnapshotDTOBuilder();
    jVMFlowDiagnosticsSnapshotDTOBuilder.setActiveEventDrivenThreads(jVMFlowDiagnosticsSnapshotDTO.getActiveEventDrivenThreads());
    jVMFlowDiagnosticsSnapshotDTOBuilder.setActiveTimerDrivenThreads(jVMFlowDiagnosticsSnapshotDTO.getActiveTimerDrivenThreads());
    jVMFlowDiagnosticsSnapshotDTOBuilder.setBundlesLoaded(jVMFlowDiagnosticsSnapshotDTO.getBundlesLoaded());
    jVMFlowDiagnosticsSnapshotDTOBuilder.setTimeZone(jVMFlowDiagnosticsSnapshotDTO.getTimeZone());
    jVMFlowDiagnosticsSnapshotDTOBuilder.setUptime(jVMFlowDiagnosticsSnapshotDTO.getUptime());
    return jVMFlowDiagnosticsSnapshotDTOBuilder;
  }
}
