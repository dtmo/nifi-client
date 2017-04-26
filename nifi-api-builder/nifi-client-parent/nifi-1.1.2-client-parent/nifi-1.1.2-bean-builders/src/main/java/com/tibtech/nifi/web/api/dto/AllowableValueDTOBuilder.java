package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import org.apache.nifi.web.api.dto.AllowableValueDTO;

public final class AllowableValueDTOBuilder {
  private String description;

  private String displayName;

  private String value;

  /**
   * A description for this allowable value.
   */
  public String getDescription() {
    return description;
  }

  /**
   * A description for this allowable value.
   */
  public AllowableValueDTOBuilder setDescription(final String description) {
    this.description = description;
    return this;
  }

  /**
   * A human readable value that is allowed for the property descriptor.
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * A human readable value that is allowed for the property descriptor.
   */
  public AllowableValueDTOBuilder setDisplayName(final String displayName) {
    this.displayName = displayName;
    return this;
  }

  /**
   * A value that is allowed for the property descriptor.
   */
  public String getValue() {
    return value;
  }

  /**
   * A value that is allowed for the property descriptor.
   */
  public AllowableValueDTOBuilder setValue(final String value) {
    this.value = value;
    return this;
  }

  public AllowableValueDTO build() {
    final AllowableValueDTO allowableValueDTO = new AllowableValueDTO();
    allowableValueDTO.setDescription(description);
    allowableValueDTO.setDisplayName(displayName);
    allowableValueDTO.setValue(value);
    return allowableValueDTO;
  }

  public static AllowableValueDTOBuilder of(final AllowableValueDTO allowableValueDTO) {
    final AllowableValueDTOBuilder allowableValueDTOBuilder = new AllowableValueDTOBuilder();
    allowableValueDTOBuilder.setDescription(allowableValueDTO.getDescription());
    allowableValueDTOBuilder.setDisplayName(allowableValueDTO.getDisplayName());
    allowableValueDTOBuilder.setValue(allowableValueDTO.getValue());
    return allowableValueDTOBuilder;
  }
}
