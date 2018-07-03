package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import org.apache.nifi.web.api.dto.BundleDTO;

public final class BundleDTOBuilder {
  private String artifact;

  private String group;

  private String version;

  /**
   * The artifact of the bundle.
   */
  public String getArtifact() {
    return artifact;
  }

  /**
   * The artifact of the bundle.
   */
  public BundleDTOBuilder setArtifact(final String artifact) {
    this.artifact = artifact;
    return this;
  }

  /**
   * The group of the bundle.
   */
  public String getGroup() {
    return group;
  }

  /**
   * The group of the bundle.
   */
  public BundleDTOBuilder setGroup(final String group) {
    this.group = group;
    return this;
  }

  /**
   * The version of the bundle.
   */
  public String getVersion() {
    return version;
  }

  /**
   * The version of the bundle.
   */
  public BundleDTOBuilder setVersion(final String version) {
    this.version = version;
    return this;
  }

  public BundleDTO build() {
    final BundleDTO bundleDTO = new BundleDTO();
    bundleDTO.setArtifact(artifact);
    bundleDTO.setGroup(group);
    bundleDTO.setVersion(version);
    return bundleDTO;
  }

  public static BundleDTOBuilder of(final BundleDTO bundleDTO) {
    final BundleDTOBuilder bundleDTOBuilder = new BundleDTOBuilder();
    bundleDTOBuilder.setArtifact(bundleDTO.getArtifact());
    bundleDTOBuilder.setGroup(bundleDTO.getGroup());
    bundleDTOBuilder.setVersion(bundleDTO.getVersion());
    return bundleDTOBuilder;
  }
}
