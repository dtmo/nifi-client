package com.tibtech.nifi.web.api.dto;

import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import org.apache.nifi.web.api.dto.PropertyDescriptorDTO;
import org.apache.nifi.web.api.entity.AllowableValueEntity;

public final class PropertyDescriptorDTOBuilder {
  private List<AllowableValueEntity> allowableValues;

  private String defaultValue;

  private String description;

  private String displayName;

  private Boolean dynamic;

  private String identifiesControllerService;

  private String name;

  private Boolean required;

  private Boolean sensitive;

  private Boolean supportsEl;

  /**
   * Allowable values for the property. If empty then the allowed values are not constrained.
   */
  public List<AllowableValueEntity> getAllowableValues() {
    return allowableValues;
  }

  /**
   * Allowable values for the property. If empty then the allowed values are not constrained.
   */
  public PropertyDescriptorDTOBuilder setAllowableValues(final List<AllowableValueEntity> allowableValues) {
    this.allowableValues = allowableValues;
    return this;
  }

  /**
   * The default value for the property.
   */
  public String getDefaultValue() {
    return defaultValue;
  }

  /**
   * The default value for the property.
   */
  public PropertyDescriptorDTOBuilder setDefaultValue(final String defaultValue) {
    this.defaultValue = defaultValue;
    return this;
  }

  /**
   * The description for the property. Used to relay additional details to a user or provide a mechanism of documenting intent.
   */
  public String getDescription() {
    return description;
  }

  /**
   * The description for the property. Used to relay additional details to a user or provide a mechanism of documenting intent.
   */
  public PropertyDescriptorDTOBuilder setDescription(final String description) {
    this.description = description;
    return this;
  }

  /**
   * The human readable name for the property.
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * The human readable name for the property.
   */
  public PropertyDescriptorDTOBuilder setDisplayName(final String displayName) {
    this.displayName = displayName;
    return this;
  }

  /**
   * Whether the property is dynamic (user-defined).
   */
  public Boolean getDynamic() {
    return dynamic;
  }

  /**
   * Whether the property is dynamic (user-defined).
   */
  public PropertyDescriptorDTOBuilder setDynamic(final Boolean dynamic) {
    this.dynamic = dynamic;
    return this;
  }

  /**
   * If the property identifies a controller service, this returns the fully qualified type.
   */
  public String getIdentifiesControllerService() {
    return identifiesControllerService;
  }

  /**
   * If the property identifies a controller service, this returns the fully qualified type.
   */
  public PropertyDescriptorDTOBuilder setIdentifiesControllerService(final String identifiesControllerService) {
    this.identifiesControllerService = identifiesControllerService;
    return this;
  }

  /**
   * The name for the property.
   */
  public String getName() {
    return name;
  }

  /**
   * The name for the property.
   */
  public PropertyDescriptorDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * Whether the property is required.
   */
  public Boolean getRequired() {
    return required;
  }

  /**
   * Whether the property is required.
   */
  public PropertyDescriptorDTOBuilder setRequired(final Boolean required) {
    this.required = required;
    return this;
  }

  /**
   * Whether the property is sensitive and protected whenever stored or represented.
   */
  public Boolean getSensitive() {
    return sensitive;
  }

  /**
   * Whether the property is sensitive and protected whenever stored or represented.
   */
  public PropertyDescriptorDTOBuilder setSensitive(final Boolean sensitive) {
    this.sensitive = sensitive;
    return this;
  }

  /**
   * Whether the property supports expression language.
   */
  public Boolean getSupportsEl() {
    return supportsEl;
  }

  /**
   * Whether the property supports expression language.
   */
  public PropertyDescriptorDTOBuilder setSupportsEl(final Boolean supportsEl) {
    this.supportsEl = supportsEl;
    return this;
  }

  public PropertyDescriptorDTO build() {
    final PropertyDescriptorDTO propertyDescriptorDTO = new PropertyDescriptorDTO();
    propertyDescriptorDTO.setAllowableValues(allowableValues);
    propertyDescriptorDTO.setDefaultValue(defaultValue);
    propertyDescriptorDTO.setDescription(description);
    propertyDescriptorDTO.setDisplayName(displayName);
    propertyDescriptorDTO.setDynamic(dynamic);
    propertyDescriptorDTO.setIdentifiesControllerService(identifiesControllerService);
    propertyDescriptorDTO.setName(name);
    propertyDescriptorDTO.setRequired(required);
    propertyDescriptorDTO.setSensitive(sensitive);
    propertyDescriptorDTO.setSupportsEl(supportsEl);
    return propertyDescriptorDTO;
  }

  public static PropertyDescriptorDTOBuilder of(final PropertyDescriptorDTO propertyDescriptorDTO) {
    final PropertyDescriptorDTOBuilder propertyDescriptorDTOBuilder = new PropertyDescriptorDTOBuilder();
    propertyDescriptorDTOBuilder.setAllowableValues(propertyDescriptorDTO.getAllowableValues());
    propertyDescriptorDTOBuilder.setDefaultValue(propertyDescriptorDTO.getDefaultValue());
    propertyDescriptorDTOBuilder.setDescription(propertyDescriptorDTO.getDescription());
    propertyDescriptorDTOBuilder.setDisplayName(propertyDescriptorDTO.getDisplayName());
    propertyDescriptorDTOBuilder.setDynamic(propertyDescriptorDTO.isDynamic());
    propertyDescriptorDTOBuilder.setIdentifiesControllerService(propertyDescriptorDTO.getIdentifiesControllerService());
    propertyDescriptorDTOBuilder.setName(propertyDescriptorDTO.getName());
    propertyDescriptorDTOBuilder.setRequired(propertyDescriptorDTO.isRequired());
    propertyDescriptorDTOBuilder.setSensitive(propertyDescriptorDTO.isSensitive());
    propertyDescriptorDTOBuilder.setSupportsEl(propertyDescriptorDTO.getSupportsEl());
    return propertyDescriptorDTOBuilder;
  }
}
