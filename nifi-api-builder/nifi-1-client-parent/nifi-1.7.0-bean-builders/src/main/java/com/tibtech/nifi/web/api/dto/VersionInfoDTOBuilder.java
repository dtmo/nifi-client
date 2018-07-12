package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import java.util.Date;
import org.apache.nifi.web.api.dto.SystemDiagnosticsSnapshotDTO;

public final class VersionInfoDTOBuilder {
  private String buildBranch;

  private String buildRevision;

  private String buildTag;

  private Date buildTimestamp;

  private String javaVendor;

  private String javaVersion;

  private String niFiVersion;

  private String osArchitecture;

  private String osName;

  private String osVersion;

  /**
   * Build branch
   */
  public String getBuildBranch() {
    return buildBranch;
  }

  /**
   * Build branch
   */
  public VersionInfoDTOBuilder setBuildBranch(final String buildBranch) {
    this.buildBranch = buildBranch;
    return this;
  }

  /**
   * Build revision or commit hash
   */
  public String getBuildRevision() {
    return buildRevision;
  }

  /**
   * Build revision or commit hash
   */
  public VersionInfoDTOBuilder setBuildRevision(final String buildRevision) {
    this.buildRevision = buildRevision;
    return this;
  }

  /**
   * Build tag
   */
  public String getBuildTag() {
    return buildTag;
  }

  /**
   * Build tag
   */
  public VersionInfoDTOBuilder setBuildTag(final String buildTag) {
    this.buildTag = buildTag;
    return this;
  }

  /**
   * Build timestamp
   */
  public Date getBuildTimestamp() {
    return buildTimestamp;
  }

  /**
   * Build timestamp
   */
  public VersionInfoDTOBuilder setBuildTimestamp(final Date buildTimestamp) {
    this.buildTimestamp = buildTimestamp;
    return this;
  }

  /**
   * Java JVM vendor
   */
  public String getJavaVendor() {
    return javaVendor;
  }

  /**
   * Java JVM vendor
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

  public SystemDiagnosticsSnapshotDTO.VersionInfoDTO build() {
    final SystemDiagnosticsSnapshotDTO.VersionInfoDTO versionInfoDTO = new SystemDiagnosticsSnapshotDTO.VersionInfoDTO();
    versionInfoDTO.setBuildBranch(buildBranch);
    versionInfoDTO.setBuildRevision(buildRevision);
    versionInfoDTO.setBuildTag(buildTag);
    versionInfoDTO.setBuildTimestamp(buildTimestamp);
    versionInfoDTO.setJavaVendor(javaVendor);
    versionInfoDTO.setJavaVersion(javaVersion);
    versionInfoDTO.setNiFiVersion(niFiVersion);
    versionInfoDTO.setOsArchitecture(osArchitecture);
    versionInfoDTO.setOsName(osName);
    versionInfoDTO.setOsVersion(osVersion);
    return versionInfoDTO;
  }

  public static VersionInfoDTOBuilder of(
      final SystemDiagnosticsSnapshotDTO.VersionInfoDTO versionInfoDTO) {
    final VersionInfoDTOBuilder versionInfoDTOBuilder = new VersionInfoDTOBuilder();
    versionInfoDTOBuilder.setBuildBranch(versionInfoDTO.getBuildBranch());
    versionInfoDTOBuilder.setBuildRevision(versionInfoDTO.getBuildRevision());
    versionInfoDTOBuilder.setBuildTag(versionInfoDTO.getBuildTag());
    versionInfoDTOBuilder.setBuildTimestamp(versionInfoDTO.getBuildTimestamp());
    versionInfoDTOBuilder.setJavaVendor(versionInfoDTO.getJavaVendor());
    versionInfoDTOBuilder.setJavaVersion(versionInfoDTO.getJavaVersion());
    versionInfoDTOBuilder.setNiFiVersion(versionInfoDTO.getNiFiVersion());
    versionInfoDTOBuilder.setOsArchitecture(versionInfoDTO.getOsArchitecture());
    versionInfoDTOBuilder.setOsName(versionInfoDTO.getOsName());
    versionInfoDTOBuilder.setOsVersion(versionInfoDTO.getOsVersion());
    return versionInfoDTOBuilder;
  }
}
