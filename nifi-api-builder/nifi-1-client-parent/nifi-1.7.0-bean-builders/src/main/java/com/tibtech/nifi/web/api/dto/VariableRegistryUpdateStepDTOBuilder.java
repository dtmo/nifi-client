package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import org.apache.nifi.web.api.dto.VariableRegistryUpdateStepDTO;

public final class VariableRegistryUpdateStepDTOBuilder {
  private boolean complete;

  private String description;

  private String failureReason;

  /**
   * Whether or not this step has completed
   */
  public boolean getComplete() {
    return complete;
  }

  /**
   * Whether or not this step has completed
   */
  public VariableRegistryUpdateStepDTOBuilder setComplete(final boolean complete) {
    this.complete = complete;
    return this;
  }

  /**
   * Explanation of what happens in this step
   */
  public String getDescription() {
    return description;
  }

  /**
   * Explanation of what happens in this step
   */
  public VariableRegistryUpdateStepDTOBuilder setDescription(final String description) {
    this.description = description;
    return this;
  }

  /**
   * An explanation of why this step failed, or null if this step did not fail
   */
  public String getFailureReason() {
    return failureReason;
  }

  /**
   * An explanation of why this step failed, or null if this step did not fail
   */
  public VariableRegistryUpdateStepDTOBuilder setFailureReason(final String failureReason) {
    this.failureReason = failureReason;
    return this;
  }

  public VariableRegistryUpdateStepDTO build() {
    final VariableRegistryUpdateStepDTO variableRegistryUpdateStepDTO = new VariableRegistryUpdateStepDTO();
    variableRegistryUpdateStepDTO.setComplete(complete);
    variableRegistryUpdateStepDTO.setDescription(description);
    variableRegistryUpdateStepDTO.setFailureReason(failureReason);
    return variableRegistryUpdateStepDTO;
  }

  public static VariableRegistryUpdateStepDTOBuilder of(final VariableRegistryUpdateStepDTO variableRegistryUpdateStepDTO) {
    final VariableRegistryUpdateStepDTOBuilder variableRegistryUpdateStepDTOBuilder = new VariableRegistryUpdateStepDTOBuilder();
    variableRegistryUpdateStepDTOBuilder.setComplete(variableRegistryUpdateStepDTO.isComplete());
    variableRegistryUpdateStepDTOBuilder.setDescription(variableRegistryUpdateStepDTO.getDescription());
    variableRegistryUpdateStepDTOBuilder.setFailureReason(variableRegistryUpdateStepDTO.getFailureReason());
    return variableRegistryUpdateStepDTOBuilder;
  }
}
