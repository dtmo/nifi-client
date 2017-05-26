package com.tibtech.nifi.web.api.dto;

import java.lang.Boolean;
import java.lang.String;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.apache.nifi.web.api.dto.ControllerServiceDTO;
import org.apache.nifi.web.api.dto.PropertyDescriptorDTO;
import org.apache.nifi.web.api.entity.ControllerServiceReferencingComponentEntity;

public final class ControllerServiceDTOBuilder extends AbstractComponentDTOBuilder<ControllerServiceDTOBuilder> {
  private String annotationData;

  private String comments;

  private String customUiUrl;

  private Map<String, PropertyDescriptorDTO> descriptors;

  private String name;

  private Boolean persistsState;

  private Map<String, String> properties;

  private Set<ControllerServiceReferencingComponentEntity> referencingComponents;

  private Boolean restricted;

  private String state;

  private String type;

  private Collection<String> validationErrors;

  /**
   * The annotation for the controller service. This is how the custom UI relays configuration to the controller service.
   */
  public String getAnnotationData() {
    return annotationData;
  }

  /**
   * The annotation for the controller service. This is how the custom UI relays configuration to the controller service.
   */
  public ControllerServiceDTOBuilder setAnnotationData(final String annotationData) {
    this.annotationData = annotationData;
    return this;
  }

  /**
   * The comments for the controller service.
   */
  public String getComments() {
    return comments;
  }

  /**
   * The comments for the controller service.
   */
  public ControllerServiceDTOBuilder setComments(final String comments) {
    this.comments = comments;
    return this;
  }

  /**
   * The URL for the controller services custom configuration UI if applicable.
   */
  public String getCustomUiUrl() {
    return customUiUrl;
  }

  /**
   * The URL for the controller services custom configuration UI if applicable.
   */
  public ControllerServiceDTOBuilder setCustomUiUrl(final String customUiUrl) {
    this.customUiUrl = customUiUrl;
    return this;
  }

  /**
   * The descriptors for the controller service properties.
   */
  public Map<String, PropertyDescriptorDTO> getDescriptors() {
    return descriptors;
  }

  /**
   * The descriptors for the controller service properties.
   */
  public ControllerServiceDTOBuilder setDescriptors(final Map<String, PropertyDescriptorDTO> descriptors) {
    this.descriptors = descriptors;
    return this;
  }

  /**
   * The name of the controller service.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the controller service.
   */
  public ControllerServiceDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * Whether the controller service persists state.
   */
  public Boolean getPersistsState() {
    return persistsState;
  }

  /**
   * Whether the controller service persists state.
   */
  public ControllerServiceDTOBuilder setPersistsState(final Boolean persistsState) {
    this.persistsState = persistsState;
    return this;
  }

  /**
   * The properties of the controller service.
   */
  public Map<String, String> getProperties() {
    return properties;
  }

  /**
   * The properties of the controller service.
   */
  public ControllerServiceDTOBuilder setProperties(final Map<String, String> properties) {
    this.properties = properties;
    return this;
  }

  /**
   * All components referencing this controller service.
   */
  public Set<ControllerServiceReferencingComponentEntity> getReferencingComponents() {
    return referencingComponents;
  }

  /**
   * All components referencing this controller service.
   */
  public ControllerServiceDTOBuilder setReferencingComponents(final Set<ControllerServiceReferencingComponentEntity> referencingComponents) {
    this.referencingComponents = referencingComponents;
    return this;
  }

  /**
   * Whether the controller service requires elevated privileges.
   */
  public Boolean getRestricted() {
    return restricted;
  }

  /**
   * Whether the controller service requires elevated privileges.
   */
  public ControllerServiceDTOBuilder setRestricted(final Boolean restricted) {
    this.restricted = restricted;
    return this;
  }

  /**
   * The state of the controller service.
   */
  public String getState() {
    return state;
  }

  /**
   * The state of the controller service.
   */
  public ControllerServiceDTOBuilder setState(final String state) {
    this.state = state;
    return this;
  }

  /**
   * The type of the controller service.
   */
  public String getType() {
    return type;
  }

  /**
   * The type of the controller service.
   */
  public ControllerServiceDTOBuilder setType(final String type) {
    this.type = type;
    return this;
  }

  /**
   * The validation errors from the controller service. These validation errors represent the problems with the controller service that must be resolved before it can be enabled.
   */
  public Collection<String> getValidationErrors() {
    return validationErrors;
  }

  /**
   * The validation errors from the controller service. These validation errors represent the problems with the controller service that must be resolved before it can be enabled.
   */
  public ControllerServiceDTOBuilder setValidationErrors(final Collection<String> validationErrors) {
    this.validationErrors = validationErrors;
    return this;
  }

  public ControllerServiceDTO build() {
    final ControllerServiceDTO controllerServiceDTO = new ControllerServiceDTO();
    super.setPropertyValues(controllerServiceDTO);
    controllerServiceDTO.setAnnotationData(annotationData);
    controllerServiceDTO.setComments(comments);
    controllerServiceDTO.setCustomUiUrl(customUiUrl);
    controllerServiceDTO.setDescriptors(descriptors);
    controllerServiceDTO.setName(name);
    controllerServiceDTO.setPersistsState(persistsState);
    controllerServiceDTO.setProperties(properties);
    controllerServiceDTO.setReferencingComponents(referencingComponents);
    controllerServiceDTO.setRestricted(restricted);
    controllerServiceDTO.setState(state);
    controllerServiceDTO.setType(type);
    controllerServiceDTO.setValidationErrors(validationErrors);
    return controllerServiceDTO;
  }

  public static ControllerServiceDTOBuilder of(final ControllerServiceDTO controllerServiceDTO) {
    final ControllerServiceDTOBuilder controllerServiceDTOBuilder = new ControllerServiceDTOBuilder();
    AbstractComponentDTOBuilder.setBuilderValues(controllerServiceDTOBuilder, controllerServiceDTO);
    controllerServiceDTOBuilder.setAnnotationData(controllerServiceDTO.getAnnotationData());
    controllerServiceDTOBuilder.setComments(controllerServiceDTO.getComments());
    controllerServiceDTOBuilder.setCustomUiUrl(controllerServiceDTO.getCustomUiUrl());
    controllerServiceDTOBuilder.setDescriptors(controllerServiceDTO.getDescriptors());
    controllerServiceDTOBuilder.setName(controllerServiceDTO.getName());
    controllerServiceDTOBuilder.setPersistsState(controllerServiceDTO.getPersistsState());
    controllerServiceDTOBuilder.setProperties(controllerServiceDTO.getProperties());
    controllerServiceDTOBuilder.setReferencingComponents(controllerServiceDTO.getReferencingComponents());
    controllerServiceDTOBuilder.setRestricted(controllerServiceDTO.getRestricted());
    controllerServiceDTOBuilder.setState(controllerServiceDTO.getState());
    controllerServiceDTOBuilder.setType(controllerServiceDTO.getType());
    controllerServiceDTOBuilder.setValidationErrors(controllerServiceDTO.getValidationErrors());
    return controllerServiceDTOBuilder;
  }
}
