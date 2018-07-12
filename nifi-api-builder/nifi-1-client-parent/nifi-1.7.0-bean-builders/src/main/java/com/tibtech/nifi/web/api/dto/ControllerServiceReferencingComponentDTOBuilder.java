package com.tibtech.nifi.web.api.dto;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.nifi.web.api.dto.ControllerServiceReferencingComponentDTO;
import org.apache.nifi.web.api.dto.PropertyDescriptorDTO;
import org.apache.nifi.web.api.entity.ControllerServiceReferencingComponentEntity;

public final class ControllerServiceReferencingComponentDTOBuilder {
  private Integer activeThreadCount;

  private Map<String, PropertyDescriptorDTO> descriptors;

  private String groupId;

  private String id;

  private String name;

  private Map<String, String> properties;

  private Boolean referenceCycle;

  private String referenceType;

  private Set<ControllerServiceReferencingComponentEntity> referencingComponents;

  private String state;

  private String type;

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
  public ControllerServiceReferencingComponentDTOBuilder setActiveThreadCount(
      final Integer activeThreadCount) {
    this.activeThreadCount = activeThreadCount;
    return this;
  }

  /**
   * The descriptors for the component properties.
   */
  public Map<String, PropertyDescriptorDTO> getDescriptors() {
    return descriptors;
  }

  /**
   * The descriptors for the component properties.
   */
  public ControllerServiceReferencingComponentDTOBuilder setDescriptors(
      final Map<String, PropertyDescriptorDTO> descriptors) {
    this.descriptors = descriptors;
    return this;
  }

  /**
   * The group id for the component referencing a controller service. If this component is another controller service or a reporting task, this field is blank.
   */
  public String getGroupId() {
    return groupId;
  }

  /**
   * The group id for the component referencing a controller service. If this component is another controller service or a reporting task, this field is blank.
   */
  public ControllerServiceReferencingComponentDTOBuilder setGroupId(final String groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * The id of the component referencing a controller service.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the component referencing a controller service.
   */
  public ControllerServiceReferencingComponentDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The name of the component referencing a controller service.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the component referencing a controller service.
   */
  public ControllerServiceReferencingComponentDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * The properties for the component.
   */
  public Map<String, String> getProperties() {
    return properties;
  }

  /**
   * The properties for the component.
   */
  public ControllerServiceReferencingComponentDTOBuilder setProperties(
      final Map<String, String> properties) {
    this.properties = properties;
    return this;
  }

  /**
   * If the referencing component represents a controller service, this indicates whether it has already been represented in this hierarchy.
   */
  public Boolean getReferenceCycle() {
    return referenceCycle;
  }

  /**
   * If the referencing component represents a controller service, this indicates whether it has already been represented in this hierarchy.
   */
  public ControllerServiceReferencingComponentDTOBuilder setReferenceCycle(
      final Boolean referenceCycle) {
    this.referenceCycle = referenceCycle;
    return this;
  }

  /**
   * The type of reference this is.
   */
  public String getReferenceType() {
    return referenceType;
  }

  /**
   * The type of reference this is.
   */
  public ControllerServiceReferencingComponentDTOBuilder setReferenceType(
      final String referenceType) {
    this.referenceType = referenceType;
    return this;
  }

  /**
   * If the referencing component represents a controller service, these are the components that reference it.
   */
  public Set<ControllerServiceReferencingComponentEntity> getReferencingComponents() {
    return referencingComponents;
  }

  /**
   * If the referencing component represents a controller service, these are the components that reference it.
   */
  public ControllerServiceReferencingComponentDTOBuilder setReferencingComponents(
      final Set<ControllerServiceReferencingComponentEntity> referencingComponents) {
    this.referencingComponents = referencingComponents;
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
  public ControllerServiceReferencingComponentDTOBuilder setState(final String state) {
    this.state = state;
    return this;
  }

  /**
   * The type of the component referencing a controller service.
   */
  public String getType() {
    return type;
  }

  /**
   * The type of the component referencing a controller service.
   */
  public ControllerServiceReferencingComponentDTOBuilder setType(final String type) {
    this.type = type;
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
  public ControllerServiceReferencingComponentDTOBuilder setValidationErrors(
      final Collection<String> validationErrors) {
    this.validationErrors = validationErrors;
    return this;
  }

  public ControllerServiceReferencingComponentDTO build() {
    final ControllerServiceReferencingComponentDTO controllerServiceReferencingComponentDTO = new ControllerServiceReferencingComponentDTO();
    controllerServiceReferencingComponentDTO.setActiveThreadCount(activeThreadCount);
    controllerServiceReferencingComponentDTO.setDescriptors(descriptors);
    controllerServiceReferencingComponentDTO.setGroupId(groupId);
    controllerServiceReferencingComponentDTO.setId(id);
    controllerServiceReferencingComponentDTO.setName(name);
    controllerServiceReferencingComponentDTO.setProperties(properties);
    controllerServiceReferencingComponentDTO.setReferenceCycle(referenceCycle);
    controllerServiceReferencingComponentDTO.setReferenceType(referenceType);
    controllerServiceReferencingComponentDTO.setReferencingComponents(referencingComponents);
    controllerServiceReferencingComponentDTO.setState(state);
    controllerServiceReferencingComponentDTO.setType(type);
    controllerServiceReferencingComponentDTO.setValidationErrors(validationErrors);
    return controllerServiceReferencingComponentDTO;
  }

  public static ControllerServiceReferencingComponentDTOBuilder of(
      final ControllerServiceReferencingComponentDTO controllerServiceReferencingComponentDTO) {
    final ControllerServiceReferencingComponentDTOBuilder controllerServiceReferencingComponentDTOBuilder = new ControllerServiceReferencingComponentDTOBuilder();
    controllerServiceReferencingComponentDTOBuilder.setActiveThreadCount(controllerServiceReferencingComponentDTO.getActiveThreadCount());
    controllerServiceReferencingComponentDTOBuilder.setDescriptors(controllerServiceReferencingComponentDTO.getDescriptors());
    controllerServiceReferencingComponentDTOBuilder.setGroupId(controllerServiceReferencingComponentDTO.getGroupId());
    controllerServiceReferencingComponentDTOBuilder.setId(controllerServiceReferencingComponentDTO.getId());
    controllerServiceReferencingComponentDTOBuilder.setName(controllerServiceReferencingComponentDTO.getName());
    controllerServiceReferencingComponentDTOBuilder.setProperties(controllerServiceReferencingComponentDTO.getProperties());
    controllerServiceReferencingComponentDTOBuilder.setReferenceCycle(controllerServiceReferencingComponentDTO.getReferenceCycle());
    controllerServiceReferencingComponentDTOBuilder.setReferenceType(controllerServiceReferencingComponentDTO.getReferenceType());
    controllerServiceReferencingComponentDTOBuilder.setReferencingComponents(controllerServiceReferencingComponentDTO.getReferencingComponents());
    controllerServiceReferencingComponentDTOBuilder.setState(controllerServiceReferencingComponentDTO.getState());
    controllerServiceReferencingComponentDTOBuilder.setType(controllerServiceReferencingComponentDTO.getType());
    controllerServiceReferencingComponentDTOBuilder.setValidationErrors(controllerServiceReferencingComponentDTO.getValidationErrors());
    return controllerServiceReferencingComponentDTOBuilder;
  }
}
