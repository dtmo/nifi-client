package com.tibtech.nifi.web.api.dto;

import java.lang.Integer;
import java.lang.String;
import java.util.Collection;
import org.apache.nifi.web.api.dto.AffectedComponentDTO;

public final class AffectedComponentDTOBuilder {
  private Integer activeThreadCount;

  private String id;

  private String name;

  private String processGroupId;

  private String referenceType;

  private String state;

  private Collection<String> validationErrors;

  /**
   * The number of active threads for the referencing component.
   */
  public Integer getActiveThreadCount() {
    return activeThreadCount;
  }

  /**
   * The number of active threads for the referencing component.
   */
  public AffectedComponentDTOBuilder setActiveThreadCount(final Integer activeThreadCount) {
    this.activeThreadCount = activeThreadCount;
    return this;
  }

  /**
   * The UUID of this component
   */
  public String getId() {
    return id;
  }

  /**
   * The UUID of this component
   */
  public AffectedComponentDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The name of this component.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of this component.
   */
  public AffectedComponentDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * The UUID of the Process Group that this component is in
   */
  public String getProcessGroupId() {
    return processGroupId;
  }

  /**
   * The UUID of the Process Group that this component is in
   */
  public AffectedComponentDTOBuilder setProcessGroupId(final String processGroupId) {
    this.processGroupId = processGroupId;
    return this;
  }

  /**
   * The type of this component
   */
  public String getReferenceType() {
    return referenceType;
  }

  /**
   * The type of this component
   */
  public AffectedComponentDTOBuilder setReferenceType(final String referenceType) {
    this.referenceType = referenceType;
    return this;
  }

  /**
   * The scheduled state of a processor or reporting task referencing a controller service. If this component is another controller service, this field represents the controller service state.
   */
  public String getState() {
    return state;
  }

  /**
   * The scheduled state of a processor or reporting task referencing a controller service. If this component is another controller service, this field represents the controller service state.
   */
  public AffectedComponentDTOBuilder setState(final String state) {
    this.state = state;
    return this;
  }

  /**
   * The validation errors for the component.
   */
  public Collection<String> getValidationErrors() {
    return validationErrors;
  }

  /**
   * The validation errors for the component.
   */
  public AffectedComponentDTOBuilder setValidationErrors(final Collection<String> validationErrors) {
    this.validationErrors = validationErrors;
    return this;
  }

  public AffectedComponentDTO build() {
    final AffectedComponentDTO affectedComponentDTO = new AffectedComponentDTO();
    affectedComponentDTO.setActiveThreadCount(activeThreadCount);
    affectedComponentDTO.setId(id);
    affectedComponentDTO.setName(name);
    affectedComponentDTO.setProcessGroupId(processGroupId);
    affectedComponentDTO.setReferenceType(referenceType);
    affectedComponentDTO.setState(state);
    affectedComponentDTO.setValidationErrors(validationErrors);
    return affectedComponentDTO;
  }

  public static AffectedComponentDTOBuilder of(final AffectedComponentDTO affectedComponentDTO) {
    final AffectedComponentDTOBuilder affectedComponentDTOBuilder = new AffectedComponentDTOBuilder();
    affectedComponentDTOBuilder.setActiveThreadCount(affectedComponentDTO.getActiveThreadCount());
    affectedComponentDTOBuilder.setId(affectedComponentDTO.getId());
    affectedComponentDTOBuilder.setName(affectedComponentDTO.getName());
    affectedComponentDTOBuilder.setProcessGroupId(affectedComponentDTO.getProcessGroupId());
    affectedComponentDTOBuilder.setReferenceType(affectedComponentDTO.getReferenceType());
    affectedComponentDTOBuilder.setState(affectedComponentDTO.getState());
    affectedComponentDTOBuilder.setValidationErrors(affectedComponentDTO.getValidationErrors());
    return affectedComponentDTOBuilder;
  }
}
