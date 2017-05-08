package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import java.util.Date;
import org.apache.nifi.web.api.dto.AboutDTO;

public final class AboutDTOBuilder {
  private String buildBranch;

  private String buildRevision;

  private String buildTag;

  private Date buildTimestamp;

  private String contentViewerUrl;

  private Date timezone;

  private String title;

  private String uri;

  private String version;

  /**
   * Build branch
   */
  public String getBuildBranch() {
    return buildBranch;
  }

  /**
   * Build branch
   */
  public AboutDTOBuilder setBuildBranch(final String buildBranch) {
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
  public AboutDTOBuilder setBuildRevision(final String buildRevision) {
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
  public AboutDTOBuilder setBuildTag(final String buildTag) {
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
  public AboutDTOBuilder setBuildTimestamp(final Date buildTimestamp) {
    this.buildTimestamp = buildTimestamp;
    return this;
  }

  /**
   * The URL for the content viewer if configured.
   */
  public String getContentViewerUrl() {
    return contentViewerUrl;
  }

  /**
   * The URL for the content viewer if configured.
   */
  public AboutDTOBuilder setContentViewerUrl(final String contentViewerUrl) {
    this.contentViewerUrl = contentViewerUrl;
    return this;
  }

  /**
   * The timezone of the NiFi instance.
   */
  public Date getTimezone() {
    return timezone;
  }

  /**
   * The timezone of the NiFi instance.
   */
  public AboutDTOBuilder setTimezone(final Date timezone) {
    this.timezone = timezone;
    return this;
  }

  /**
   * The title to be used on the page and in the about dialog.
   */
  public String getTitle() {
    return title;
  }

  /**
   * The title to be used on the page and in the about dialog.
   */
  public AboutDTOBuilder setTitle(final String title) {
    this.title = title;
    return this;
  }

  /**
   * The URI for the NiFi.
   */
  public String getUri() {
    return uri;
  }

  /**
   * The URI for the NiFi.
   */
  public AboutDTOBuilder setUri(final String uri) {
    this.uri = uri;
    return this;
  }

  /**
   * The version of this NiFi.
   */
  public String getVersion() {
    return version;
  }

  /**
   * The version of this NiFi.
   */
  public AboutDTOBuilder setVersion(final String version) {
    this.version = version;
    return this;
  }

  public AboutDTO build() {
    final AboutDTO aboutDTO = new AboutDTO();
    aboutDTO.setBuildBranch(buildBranch);
    aboutDTO.setBuildRevision(buildRevision);
    aboutDTO.setBuildTag(buildTag);
    aboutDTO.setBuildTimestamp(buildTimestamp);
    aboutDTO.setContentViewerUrl(contentViewerUrl);
    aboutDTO.setTimezone(timezone);
    aboutDTO.setTitle(title);
    aboutDTO.setUri(uri);
    aboutDTO.setVersion(version);
    return aboutDTO;
  }

  public static AboutDTOBuilder of(final AboutDTO aboutDTO) {
    final AboutDTOBuilder aboutDTOBuilder = new AboutDTOBuilder();
    aboutDTOBuilder.setBuildBranch(aboutDTO.getBuildBranch());
    aboutDTOBuilder.setBuildRevision(aboutDTO.getBuildRevision());
    aboutDTOBuilder.setBuildTag(aboutDTO.getBuildTag());
    aboutDTOBuilder.setBuildTimestamp(aboutDTO.getBuildTimestamp());
    aboutDTOBuilder.setContentViewerUrl(aboutDTO.getContentViewerUrl());
    aboutDTOBuilder.setTimezone(aboutDTO.getTimezone());
    aboutDTOBuilder.setTitle(aboutDTO.getTitle());
    aboutDTOBuilder.setUri(aboutDTO.getUri());
    aboutDTOBuilder.setVersion(aboutDTO.getVersion());
    return aboutDTOBuilder;
  }
}
