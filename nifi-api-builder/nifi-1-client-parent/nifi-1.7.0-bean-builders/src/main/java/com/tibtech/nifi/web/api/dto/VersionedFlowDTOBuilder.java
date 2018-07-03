package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import org.apache.nifi.web.api.dto.VersionedFlowDTO;

public final class VersionedFlowDTOBuilder {
  private String bucketId;

  private String comments;

  private String description;

  private String flowId;

  private String flowName;

  private String registryId;

  /**
   * The ID of the bucket where the flow is stored
   */
  public String getBucketId() {
    return bucketId;
  }

  /**
   * The ID of the bucket where the flow is stored
   */
  public VersionedFlowDTOBuilder setBucketId(final String bucketId) {
    this.bucketId = bucketId;
    return this;
  }

  /**
   * Comments for the changeset
   */
  public String getComments() {
    return comments;
  }

  /**
   * Comments for the changeset
   */
  public VersionedFlowDTOBuilder setComments(final String comments) {
    this.comments = comments;
    return this;
  }

  /**
   * A description of the flow
   */
  public String getDescription() {
    return description;
  }

  /**
   * A description of the flow
   */
  public VersionedFlowDTOBuilder setDescription(final String description) {
    this.description = description;
    return this;
  }

  /**
   * The ID of the flow
   */
  public String getFlowId() {
    return flowId;
  }

  /**
   * The ID of the flow
   */
  public VersionedFlowDTOBuilder setFlowId(final String flowId) {
    this.flowId = flowId;
    return this;
  }

  /**
   * The name of the flow
   */
  public String getFlowName() {
    return flowName;
  }

  /**
   * The name of the flow
   */
  public VersionedFlowDTOBuilder setFlowName(final String flowName) {
    this.flowName = flowName;
    return this;
  }

  /**
   * The ID of the registry that the flow is tracked to
   */
  public String getRegistryId() {
    return registryId;
  }

  /**
   * The ID of the registry that the flow is tracked to
   */
  public VersionedFlowDTOBuilder setRegistryId(final String registryId) {
    this.registryId = registryId;
    return this;
  }

  public VersionedFlowDTO build() {
    final VersionedFlowDTO versionedFlowDTO = new VersionedFlowDTO();
    versionedFlowDTO.setBucketId(bucketId);
    versionedFlowDTO.setComments(comments);
    versionedFlowDTO.setDescription(description);
    versionedFlowDTO.setFlowId(flowId);
    versionedFlowDTO.setFlowName(flowName);
    versionedFlowDTO.setRegistryId(registryId);
    return versionedFlowDTO;
  }

  public static VersionedFlowDTOBuilder of(final VersionedFlowDTO versionedFlowDTO) {
    final VersionedFlowDTOBuilder versionedFlowDTOBuilder = new VersionedFlowDTOBuilder();
    versionedFlowDTOBuilder.setBucketId(versionedFlowDTO.getBucketId());
    versionedFlowDTOBuilder.setComments(versionedFlowDTO.getComments());
    versionedFlowDTOBuilder.setDescription(versionedFlowDTO.getDescription());
    versionedFlowDTOBuilder.setFlowId(versionedFlowDTO.getFlowId());
    versionedFlowDTOBuilder.setFlowName(versionedFlowDTO.getFlowName());
    versionedFlowDTOBuilder.setRegistryId(versionedFlowDTO.getRegistryId());
    return versionedFlowDTOBuilder;
  }
}
