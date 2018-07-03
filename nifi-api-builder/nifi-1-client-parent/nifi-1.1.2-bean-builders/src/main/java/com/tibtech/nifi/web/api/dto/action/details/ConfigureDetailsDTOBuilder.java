package com.tibtech.nifi.web.api.dto.action.details;

import java.lang.String;
import org.apache.nifi.web.api.dto.action.details.ConfigureDetailsDTO;

public final class ConfigureDetailsDTOBuilder extends AbstractActionDetailsDTOBuilder<ConfigureDetailsDTOBuilder> {
  private String name;

  private String previousValue;

  private String value;

  /**
   * The name of the property that was modified.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the property that was modified.
   */
  public ConfigureDetailsDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * The previous value.
   */
  public String getPreviousValue() {
    return previousValue;
  }

  /**
   * The previous value.
   */
  public ConfigureDetailsDTOBuilder setPreviousValue(final String previousValue) {
    this.previousValue = previousValue;
    return this;
  }

  /**
   * The new value.
   */
  public String getValue() {
    return value;
  }

  /**
   * The new value.
   */
  public ConfigureDetailsDTOBuilder setValue(final String value) {
    this.value = value;
    return this;
  }

  public ConfigureDetailsDTO build() {
    final ConfigureDetailsDTO configureDetailsDTO = new ConfigureDetailsDTO();
    super.setPropertyValues(configureDetailsDTO);
    configureDetailsDTO.setName(name);
    configureDetailsDTO.setPreviousValue(previousValue);
    configureDetailsDTO.setValue(value);
    return configureDetailsDTO;
  }

  public static ConfigureDetailsDTOBuilder of(final ConfigureDetailsDTO configureDetailsDTO) {
    final ConfigureDetailsDTOBuilder configureDetailsDTOBuilder = new ConfigureDetailsDTOBuilder();
    AbstractActionDetailsDTOBuilder.setBuilderValues(configureDetailsDTOBuilder, configureDetailsDTO);
    configureDetailsDTOBuilder.setName(configureDetailsDTO.getName());
    configureDetailsDTOBuilder.setPreviousValue(configureDetailsDTO.getPreviousValue());
    configureDetailsDTOBuilder.setValue(configureDetailsDTO.getValue());
    return configureDetailsDTOBuilder;
  }
}
