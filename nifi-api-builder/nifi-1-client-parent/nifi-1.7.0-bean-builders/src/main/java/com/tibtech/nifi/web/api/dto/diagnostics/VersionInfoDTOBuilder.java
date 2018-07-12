package com.tibtech.nifi.web.api.dto.diagnostics;

import java.lang.String;
import org.apache.nifi.web.api.dto.diagnostics.JVMDiagnosticsSnapshotDTO;

public final class VersionInfoDTOBuilder {
  private String javaVendor;

  private String javaVersion;

  private String javaVmVendor;

  private String niFiVersion;

  private String osArchitecture;

  private String osName;

  private String osVersion;

  /**
   * Java vendor
   */
  public String getJavaVendor() {
    return javaVendor;
  }

  /**
   * Java vendor
   */
  public VersionInfoDTOBuilder setJavaVendor(final String javaVendor) {
    this.javaVendor = javaVendor;
    return this;
  }

  /**
   * Java version
   */
  public String getJavaVersion() {
    return javaVersion;
  }

  /**
   * Java version
   */
  public VersionInfoDTOBuilder setJavaVersion(final String javaVersion) {
    this.javaVersion = javaVersion;
    return this;
  }

  /**
   * Java VM Vendor
   */
  public String getJavaVmVendor() {
    return javaVmVendor;
  }

  /**
   * Java VM Vendor
   */
  public VersionInfoDTOBuilder setJavaVmVendor(final String javaVmVendor) {
    this.javaVmVendor = javaVmVendor;
    return this;
  }

  /**
   * The version of this NiFi.
   */
  public String getNiFiVersion() {
    return niFiVersion;
  }

  /**
   * The version of this NiFi.
   */
  public VersionInfoDTOBuilder setNiFiVersion(final String niFiVersion) {
    this.niFiVersion = niFiVersion;
    return this;
  }

  /**
   * Host operating system architecture
   */
  public String getOsArchitecture() {
    return osArchitecture;
  }

  /**
   * Host operating system architecture
   */
  public VersionInfoDTOBuilder setOsArchitecture(final String osArchitecture) {
    this.osArchitecture = osArchitecture;
    return this;
  }

  /**
   * Host operating system name
   */
  public String getOsName() {
    return osName;
  }

  /**
   * Host operating system name
   */
  public VersionInfoDTOBuilder setOsName(final String osName) {
    this.osName = osName;
    return this;
  }

  /**
   * Host operating system version
   */
  public String getOsVersion() {
    return osVersion;
  }

  /**
   * Host operating system version
   */
  public VersionInfoDTOBuilder setOsVersion(final String osVersion) {
    this.osVersion = osVersion;
    return this;
  }

  public JVMDiagnosticsSnapshotDTO.VersionInfoDTO build() {
    final JVMDiagnosticsSnapshotDTO.VersionInfoDTO versionInfoDTO = new JVMDiagnosticsSnapshotDTO.VersionInfoDTO();
    versionInfoDTO.setJavaVendor(javaVendor);
    versionInfoDTO.setJavaVersion(javaVersion);
    versionInfoDTO.setJavaVmVendor(javaVmVendor);
    versionInfoDTO.setNiFiVersion(niFiVersion);
    versionInfoDTO.setOsArchitecture(osArchitecture);
    versionInfoDTO.setOsName(osName);
    versionInfoDTO.setOsVersion(osVersion);
    return versionInfoDTO;
  }

  public static VersionInfoDTOBuilder of(
      final JVMDiagnosticsSnapshotDTO.VersionInfoDTO versionInfoDTO) {
    final VersionInfoDTOBuilder versionInfoDTOBuilder = new VersionInfoDTOBuilder();
    versionInfoDTOBuilder.setJavaVendor(versionInfoDTO.getJavaVendor());
    versionInfoDTOBuilder.setJavaVersion(versionInfoDTO.getJavaVersion());
    versionInfoDTOBuilder.setJavaVmVendor(versionInfoDTO.getJavaVmVendor());
    versionInfoDTOBuilder.setNiFiVersion(versionInfoDTO.getNiFiVersion());
    versionInfoDTOBuilder.setOsArchitecture(versionInfoDTO.getOsArchitecture());
    versionInfoDTOBuilder.setOsName(versionInfoDTO.getOsName());
    versionInfoDTOBuilder.setOsVersion(versionInfoDTO.getOsVersion());
    return versionInfoDTOBuilder;
  }
}
