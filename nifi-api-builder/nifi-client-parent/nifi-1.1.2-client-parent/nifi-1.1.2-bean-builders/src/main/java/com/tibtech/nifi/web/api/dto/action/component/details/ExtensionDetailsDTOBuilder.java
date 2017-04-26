package com.tibtech.nifi.web.api.dto.action.component.details;

import java.lang.String;
import org.apache.nifi.web.api.dto.action.component.details.ExtensionDetailsDTO;

public final class ExtensionDetailsDTOBuilder extends AbstractComponentDetailsDTOBuilder<ExtensionDetailsDTOBuilder> {
  private String type;

  /**
   * The fully qualified type of extension.
   */
  public String getType() {
    return type;
  }

  /**
   * The fully qualified type of extension.
   */
  public ExtensionDetailsDTOBuilder setType(final String type) {
    this.type = type;
    return this;
  }

  public ExtensionDetailsDTO build() {
    final ExtensionDetailsDTO extensionDetailsDTO = new ExtensionDetailsDTO();
    super.setPropertyValues(extensionDetailsDTO);
    extensionDetailsDTO.setType(type);
    return extensionDetailsDTO;
  }

  public static ExtensionDetailsDTOBuilder of(final ExtensionDetailsDTO extensionDetailsDTO) {
    final ExtensionDetailsDTOBuilder extensionDetailsDTOBuilder = new ExtensionDetailsDTOBuilder();
    AbstractComponentDetailsDTOBuilder.setBuilderValues(extensionDetailsDTOBuilder, extensionDetailsDTO);
    extensionDetailsDTOBuilder.setType(extensionDetailsDTO.getType());
    return extensionDetailsDTOBuilder;
  }
}
