package com.tibtech.nifi.web.api.dto.status;

import java.lang.String;
import org.apache.nifi.web.api.dto.status.StatusDescriptorDTO;

public final class StatusDescriptorDTOBuilder {
  private String description;

  private String field;

  private String formatter;

  private String label;

  /**
   * The description of the status field.
   */
  public String getDescription() {
    return description;
  }

  /**
   * The description of the status field.
   */
  public StatusDescriptorDTOBuilder setDescription(final String description) {
    this.description = description;
    return this;
  }

  /**
   * The name of the status field.
   */
  public String getField() {
    return field;
  }

  /**
   * The name of the status field.
   */
  public StatusDescriptorDTOBuilder setField(final String field) {
    this.field = field;
    return this;
  }

  /**
   * The formatter for the status descriptor.
   */
  public String getFormatter() {
    return formatter;
  }

  /**
   * The formatter for the status descriptor.
   */
  public StatusDescriptorDTOBuilder setFormatter(final String formatter) {
    this.formatter = formatter;
    return this;
  }

  /**
   * The label for the status field.
   */
  public String getLabel() {
    return label;
  }

  /**
   * The label for the status field.
   */
  public StatusDescriptorDTOBuilder setLabel(final String label) {
    this.label = label;
    return this;
  }

  public StatusDescriptorDTO build() {
    final StatusDescriptorDTO statusDescriptorDTO = new StatusDescriptorDTO();
    statusDescriptorDTO.setDescription(description);
    statusDescriptorDTO.setField(field);
    statusDescriptorDTO.setFormatter(formatter);
    statusDescriptorDTO.setLabel(label);
    return statusDescriptorDTO;
  }

  public static StatusDescriptorDTOBuilder of(final StatusDescriptorDTO statusDescriptorDTO) {
    final StatusDescriptorDTOBuilder statusDescriptorDTOBuilder = new StatusDescriptorDTOBuilder();
    statusDescriptorDTOBuilder.setDescription(statusDescriptorDTO.getDescription());
    statusDescriptorDTOBuilder.setField(statusDescriptorDTO.getField());
    statusDescriptorDTOBuilder.setFormatter(statusDescriptorDTO.getFormatter());
    statusDescriptorDTOBuilder.setLabel(statusDescriptorDTO.getLabel());
    return statusDescriptorDTOBuilder;
  }
}
