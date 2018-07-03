package com.tibtech.nifi.web.api.dto;

import java.lang.Integer;
import java.lang.String;
import org.apache.nifi.web.api.dto.VersionControlInformationDTO;

public final class VersionControlInformationDTOBuilder {
  private String bucketId;

  private String bucketName;

  private String flowDescription;

  private String flowId;

  private String flowName;

  private String groupId;

  private String registryId;

  private String registryName;

  private String state;

  private String stateExplanation;

  private Integer version;

  /**
   * The ID of the bucket that the flow is stored in
   */
  public String getBucketId() {
    return bucketId;
  }

  /**
   * The ID of the bucket that the flow is stored in
   */
  public VersionControlInformationDTOBuilder setBucketId(final String bucketId) {
    this.bucketId = bucketId;
    return this;
  }

  /**
   * The name of the bucket that the flow is stored in
   */
  public String getBucketName() {
    return bucketName;
  }

  /**
   * The name of the bucket that the flow is stored in
   */
  public VersionControlInformationDTOBuilder setBucketName(final String bucketName) {
    this.bucketName = bucketName;
    return this;
  }

  /**
   * The description of the flow
   */
  public String getFlowDescription() {
    return flowDescription;
  }

  /**
   * The description of the flow
   */
  public VersionControlInformationDTOBuilder setFlowDescription(final String flowDescription) {
    this.flowDescription = flowDescription;
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
  public VersionControlInformationDTOBuilder setFlowId(final String flowId) {
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
  public VersionControlInformationDTOBuilder setFlowName(final String flowName) {
    this.flowName = flowName;
    return this;
  }

  /**
   * The ID of the Process Group that is under version control
   */
  public String getGroupId() {
    return groupId;
  }

  /**
   * The ID of the Process Group that is under version control
   */
  public VersionControlInformationDTOBuilder setGroupId(final String groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * The ID of the registry that the flow is stored in
   */
  public String getRegistryId() {
    return registryId;
  }

  /**
   * The ID of the registry that the flow is stored in
   */
  public VersionControlInformationDTOBuilder setRegistryId(final String registryId) {
    this.registryId = registryId;
    return this;
  }

  /**
   * The name of the registry that the flow is stored in
   */
  public String getRegistryName() {
    return registryName;
  }

  /**
   * The name of the registry that the flow is stored in
   */
  public VersionControlInformationDTOBuilder setRegistryName(final String registryName) {
    this.registryName = registryName;
    return this;
  }

  /**
   * The current state of the Process Group, as it relates to the Versioned Flow
   */
  public String getState() {
    return state;
  }

  /**
   * The current state of the Process Group, as it relates to the Versioned Flow
   */
  public VersionControlInformationDTOBuilder setState(final String state) {
    this.state = state;
    return this;
  }

  /**
   * Explanation of why the group is in the specified state
   */
  public String getStateExplanation() {
    return stateExplanation;
  }

  /**
   * Explanation of why the group is in the specified state
   */
  public VersionControlInformationDTOBuilder setStateExplanation(final String stateExplanation) {
    this.stateExplanation = stateExplanation;
    return this;
  }

  /**
   * The version of the flow
   */
  public Integer getVersion() {
    return version;
  }

  /**
   * The version of the flow
   */
  public VersionControlInformationDTOBuilder setVersion(final Integer version) {
    this.version = version;
    return this;
  }

  public VersionControlInformationDTO build() {
    final VersionControlInformationDTO versionControlInformationDTO = new VersionControlInformationDTO();
    versionControlInformationDTO.setBucketId(bucketId);
    versionControlInformationDTO.setBucketName(bucketName);
    versionControlInformationDTO.setFlowDescription(flowDescription);
    versionControlInformationDTO.setFlowId(flowId);
    versionControlInformationDTO.setFlowName(flowName);
    versionControlInformationDTO.setGroupId(groupId);
    versionControlInformationDTO.setRegistryId(registryId);
    versionControlInformationDTO.setRegistryName(registryName);
    versionControlInformationDTO.setState(state);
    versionControlInformationDTO.setStateExplanation(stateExplanation);
    versionControlInformationDTO.setVersion(version);
    return versionControlInformationDTO;
  }

  public static VersionControlInformationDTOBuilder of(final VersionControlInformationDTO versionControlInformationDTO) {
    final VersionControlInformationDTOBuilder versionControlInformationDTOBuilder = new VersionControlInformationDTOBuilder();
    versionControlInformationDTOBuilder.setBucketId(versionControlInformationDTO.getBucketId());
    versionControlInformationDTOBuilder.setBucketName(versionControlInformationDTO.getBucketName());
    versionControlInformationDTOBuilder.setFlowDescription(versionControlInformationDTO.getFlowDescription());
    versionControlInformationDTOBuilder.setFlowId(versionControlInformationDTO.getFlowId());
    versionControlInformationDTOBuilder.setFlowName(versionControlInformationDTO.getFlowName());
    versionControlInformationDTOBuilder.setGroupId(versionControlInformationDTO.getGroupId());
    versionControlInformationDTOBuilder.setRegistryId(versionControlInformationDTO.getRegistryId());
    versionControlInformationDTOBuilder.setRegistryName(versionControlInformationDTO.getRegistryName());
    versionControlInformationDTOBuilder.setState(versionControlInformationDTO.getState());
    versionControlInformationDTOBuilder.setStateExplanation(versionControlInformationDTO.getStateExplanation());
    versionControlInformationDTOBuilder.setVersion(versionControlInformationDTO.getVersion());
    return versionControlInformationDTOBuilder;
  }
}
