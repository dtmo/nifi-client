package com.tibtech.nifi.web.api.dto.diagnostics;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.diagnostics.JVMDiagnosticsSnapshotDTO;
import org.apache.nifi.web.api.dto.diagnostics.JVMFlowDiagnosticsSnapshotDTO;
import org.apache.nifi.web.api.dto.diagnostics.JVMSystemDiagnosticsSnapshotDTO;

public final class JVMDiagnosticsSnapshotDTOBuilder {
  private JVMFlowDiagnosticsSnapshotDTO flowDiagnosticsDto;

  private JVMSystemDiagnosticsSnapshotDTO systemDiagnosticsDto;

  /**
   * Flow-related diagnostics information
   */
  public JVMFlowDiagnosticsSnapshotDTO getFlowDiagnosticsDto() {
    return flowDiagnosticsDto;
  }

  /**
   * Flow-related diagnostics information
   */
  public JVMDiagnosticsSnapshotDTOBuilder setFlowDiagnosticsDto(
      final JVMFlowDiagnosticsSnapshotDTO flowDiagnosticsDto) {
    this.flowDiagnosticsDto = flowDiagnosticsDto;
    return this;
  }

  /**
   * Flow-related diagnostics information
   */
  public JVMDiagnosticsSnapshotDTOBuilder setFlowDiagnosticsDto(
      final Consumer<JVMFlowDiagnosticsSnapshotDTOBuilder> configurator) {
    final JVMFlowDiagnosticsSnapshotDTOBuilder builder = (flowDiagnosticsDto != null ? JVMFlowDiagnosticsSnapshotDTOBuilder.of(flowDiagnosticsDto) : new JVMFlowDiagnosticsSnapshotDTOBuilder());
    configurator.accept(builder);
    return setFlowDiagnosticsDto(builder.build());
  }

  /**
   * Flow-related diagnostics information
   */
  public JVMDiagnosticsSnapshotDTOBuilder setFlowDiagnosticsDto(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = JVMFlowDiagnosticsSnapshotDTOBuilder.class) final Closure<JVMFlowDiagnosticsSnapshotDTOBuilder> closure) {
    return setFlowDiagnosticsDto(c -> {
      final Closure<JVMFlowDiagnosticsSnapshotDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * System-related diagnostics information
   */
  public JVMSystemDiagnosticsSnapshotDTO getSystemDiagnosticsDto() {
    return systemDiagnosticsDto;
  }

  /**
   * System-related diagnostics information
   */
  public JVMDiagnosticsSnapshotDTOBuilder setSystemDiagnosticsDto(
      final JVMSystemDiagnosticsSnapshotDTO systemDiagnosticsDto) {
    this.systemDiagnosticsDto = systemDiagnosticsDto;
    return this;
  }

  /**
   * System-related diagnostics information
   */
  public JVMDiagnosticsSnapshotDTOBuilder setSystemDiagnosticsDto(
      final Consumer<JVMSystemDiagnosticsSnapshotDTOBuilder> configurator) {
    final JVMSystemDiagnosticsSnapshotDTOBuilder builder = (systemDiagnosticsDto != null ? JVMSystemDiagnosticsSnapshotDTOBuilder.of(systemDiagnosticsDto) : new JVMSystemDiagnosticsSnapshotDTOBuilder());
    configurator.accept(builder);
    return setSystemDiagnosticsDto(builder.build());
  }

  /**
   * System-related diagnostics information
   */
  public JVMDiagnosticsSnapshotDTOBuilder setSystemDiagnosticsDto(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = JVMSystemDiagnosticsSnapshotDTOBuilder.class) final Closure<JVMSystemDiagnosticsSnapshotDTOBuilder> closure) {
    return setSystemDiagnosticsDto(c -> {
      final Closure<JVMSystemDiagnosticsSnapshotDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  public JVMDiagnosticsSnapshotDTO build() {
    final JVMDiagnosticsSnapshotDTO jVMDiagnosticsSnapshotDTO = new JVMDiagnosticsSnapshotDTO();
    jVMDiagnosticsSnapshotDTO.setFlowDiagnosticsDto(flowDiagnosticsDto);
    jVMDiagnosticsSnapshotDTO.setSystemDiagnosticsDto(systemDiagnosticsDto);
    return jVMDiagnosticsSnapshotDTO;
  }

  public static JVMDiagnosticsSnapshotDTOBuilder of(
      final JVMDiagnosticsSnapshotDTO jVMDiagnosticsSnapshotDTO) {
    final JVMDiagnosticsSnapshotDTOBuilder jVMDiagnosticsSnapshotDTOBuilder = new JVMDiagnosticsSnapshotDTOBuilder();
    jVMDiagnosticsSnapshotDTOBuilder.setFlowDiagnosticsDto(jVMDiagnosticsSnapshotDTO.getFlowDiagnosticsDto());
    jVMDiagnosticsSnapshotDTOBuilder.setSystemDiagnosticsDto(jVMDiagnosticsSnapshotDTO.getSystemDiagnosticsDto());
    return jVMDiagnosticsSnapshotDTOBuilder;
  }
}
