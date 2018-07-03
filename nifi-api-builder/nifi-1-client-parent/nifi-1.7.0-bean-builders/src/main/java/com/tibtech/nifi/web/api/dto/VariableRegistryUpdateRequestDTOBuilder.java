package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.nifi.web.api.dto.VariableRegistryUpdateRequestDTO;
import org.apache.nifi.web.api.dto.VariableRegistryUpdateStepDTO;
import org.apache.nifi.web.api.entity.AffectedComponentEntity;

public final class VariableRegistryUpdateRequestDTOBuilder {
  private Set<AffectedComponentEntity> affectedComponents;

  private boolean complete;

  private String failureReason;

  private Date lastUpdated;

  private String processGroupId;

  private String requestId;

  private Date submissionTime;

  private List<VariableRegistryUpdateStepDTO> updateSteps;

  private String uri;

  /**
   * A set of all components that will be affected if the value of this variable is changed
   */
  public Set<AffectedComponentEntity> getAffectedComponents() {
    return affectedComponents;
  }

  /**
   * A set of all components that will be affected if the value of this variable is changed
   */
  public VariableRegistryUpdateRequestDTOBuilder setAffectedComponents(final Set<AffectedComponentEntity> affectedComponents) {
    this.affectedComponents = affectedComponents;
    return this;
  }

  /**
   * Whether or not this request has completed
   */
  public boolean getComplete() {
    return complete;
  }

  /**
   * Whether or not this request has completed
   */
  public VariableRegistryUpdateRequestDTOBuilder setComplete(final boolean complete) {
    this.complete = complete;
    return this;
  }

  /**
   * An explanation of why this request failed, or null if this request has not failed
   */
  public String getFailureReason() {
    return failureReason;
  }

  /**
   * An explanation of why this request failed, or null if this request has not failed
   */
  public VariableRegistryUpdateRequestDTOBuilder setFailureReason(final String failureReason) {
    this.failureReason = failureReason;
    return this;
  }

  /**
   * The last time this request was updated.
   */
  public Date getLastUpdated() {
    return lastUpdated;
  }

  /**
   * The last time this request was updated.
   */
  public VariableRegistryUpdateRequestDTOBuilder setLastUpdated(final Date lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

  /**
   * The unique ID of the Process Group that the variable registry belongs to
   */
  public String getProcessGroupId() {
    return processGroupId;
  }

  /**
   * The unique ID of the Process Group that the variable registry belongs to
   */
  public VariableRegistryUpdateRequestDTOBuilder setProcessGroupId(final String processGroupId) {
    this.processGroupId = processGroupId;
    return this;
  }

  /**
   * The unique ID of this request.
   */
  public String getRequestId() {
    return requestId;
  }

  /**
   * The unique ID of this request.
   */
  public VariableRegistryUpdateRequestDTOBuilder setRequestId(final String requestId) {
    this.requestId = requestId;
    return this;
  }

  /**
   * The time at which this request was submitted.
   */
  public Date getSubmissionTime() {
    return submissionTime;
  }

  /**
   * The time at which this request was submitted.
   */
  public VariableRegistryUpdateRequestDTOBuilder setSubmissionTime(final Date submissionTime) {
    this.submissionTime = submissionTime;
    return this;
  }

  /**
   * The steps that are required in order to complete the request, along with the status of each
   */
  public List<VariableRegistryUpdateStepDTO> getUpdateSteps() {
    return updateSteps;
  }

  /**
   * The steps that are required in order to complete the request, along with the status of each
   */
  public VariableRegistryUpdateRequestDTOBuilder setUpdateSteps(final List<VariableRegistryUpdateStepDTO> updateSteps) {
    this.updateSteps = updateSteps;
    return this;
  }

  /**
   * The URI for future requests to this drop request.
   */
  public String getUri() {
    return uri;
  }

  /**
   * The URI for future requests to this drop request.
   */
  public VariableRegistryUpdateRequestDTOBuilder setUri(final String uri) {
    this.uri = uri;
    return this;
  }

  public VariableRegistryUpdateRequestDTO build() {
    final VariableRegistryUpdateRequestDTO variableRegistryUpdateRequestDTO = new VariableRegistryUpdateRequestDTO();
    variableRegistryUpdateRequestDTO.setAffectedComponents(affectedComponents);
    variableRegistryUpdateRequestDTO.setComplete(complete);
    variableRegistryUpdateRequestDTO.setFailureReason(failureReason);
    variableRegistryUpdateRequestDTO.setLastUpdated(lastUpdated);
    variableRegistryUpdateRequestDTO.setProcessGroupId(processGroupId);
    variableRegistryUpdateRequestDTO.setRequestId(requestId);
    variableRegistryUpdateRequestDTO.setSubmissionTime(submissionTime);
    variableRegistryUpdateRequestDTO.setUpdateSteps(updateSteps);
    variableRegistryUpdateRequestDTO.setUri(uri);
    return variableRegistryUpdateRequestDTO;
  }

  public static VariableRegistryUpdateRequestDTOBuilder of(final VariableRegistryUpdateRequestDTO variableRegistryUpdateRequestDTO) {
    final VariableRegistryUpdateRequestDTOBuilder variableRegistryUpdateRequestDTOBuilder = new VariableRegistryUpdateRequestDTOBuilder();
    variableRegistryUpdateRequestDTOBuilder.setAffectedComponents(variableRegistryUpdateRequestDTO.getAffectedComponents());
    variableRegistryUpdateRequestDTOBuilder.setComplete(variableRegistryUpdateRequestDTO.isComplete());
    variableRegistryUpdateRequestDTOBuilder.setFailureReason(variableRegistryUpdateRequestDTO.getFailureReason());
    variableRegistryUpdateRequestDTOBuilder.setLastUpdated(variableRegistryUpdateRequestDTO.getLastUpdated());
    variableRegistryUpdateRequestDTOBuilder.setProcessGroupId(variableRegistryUpdateRequestDTO.getProcessGroupId());
    variableRegistryUpdateRequestDTOBuilder.setRequestId(variableRegistryUpdateRequestDTO.getRequestId());
    variableRegistryUpdateRequestDTOBuilder.setSubmissionTime(variableRegistryUpdateRequestDTO.getSubmissionTime());
    variableRegistryUpdateRequestDTOBuilder.setUpdateSteps(variableRegistryUpdateRequestDTO.getUpdateSteps());
    variableRegistryUpdateRequestDTOBuilder.setUri(variableRegistryUpdateRequestDTO.getUri());
    return variableRegistryUpdateRequestDTOBuilder;
  }
}
