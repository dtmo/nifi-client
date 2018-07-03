package com.tibtech.nifi.web.api.dto.provenance;

import java.lang.String;
import org.apache.nifi.web.api.dto.provenance.AttributeDTO;

public final class AttributeDTOBuilder {
  private String name;

  private String previousValue;

  private String value;

  /**
   * The attribute name.
   */
  public String getName() {
    return name;
  }

  /**
   * The attribute name.
   */
  public AttributeDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * The value of the attribute before the event took place.
   */
  public String getPreviousValue() {
    return previousValue;
  }

  /**
   * The value of the attribute before the event took place.
   */
  public AttributeDTOBuilder setPreviousValue(final String previousValue) {
    this.previousValue = previousValue;
    return this;
  }

  /**
   * The attribute value.
   */
  public String getValue() {
    return value;
  }

  /**
   * The attribute value.
   */
  public AttributeDTOBuilder setValue(final String value) {
    this.value = value;
    return this;
  }

  public AttributeDTO build() {
    final AttributeDTO attributeDTO = new AttributeDTO();
    attributeDTO.setName(name);
    attributeDTO.setPreviousValue(previousValue);
    attributeDTO.setValue(value);
    return attributeDTO;
  }

  public static AttributeDTOBuilder of(final AttributeDTO attributeDTO) {
    final AttributeDTOBuilder attributeDTOBuilder = new AttributeDTOBuilder();
    attributeDTOBuilder.setName(attributeDTO.getName());
    attributeDTOBuilder.setPreviousValue(attributeDTO.getPreviousValue());
    attributeDTOBuilder.setValue(attributeDTO.getValue());
    return attributeDTOBuilder;
  }
}
