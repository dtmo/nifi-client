package com.tibtech.nifi.update.attributes.dto;

import java.lang.String;
import org.apache.nifi.update.attributes.dto.ActionDTO;

public final class ActionDTOBuilder {
  private String attribute;

  private String id;

  private String value;

  public String getAttribute() {
    return attribute;
  }

  public ActionDTOBuilder setAttribute(final String attribute) {
    this.attribute = attribute;
    return this;
  }

  public String getId() {
    return id;
  }

  public ActionDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  public String getValue() {
    return value;
  }

  public ActionDTOBuilder setValue(final String value) {
    this.value = value;
    return this;
  }

  public ActionDTO build() {
    final ActionDTO actionDTO = new ActionDTO();
    actionDTO.setAttribute(attribute);
    actionDTO.setId(id);
    actionDTO.setValue(value);
    return actionDTO;
  }

  public static ActionDTOBuilder of(final ActionDTO actionDTO) {
    final ActionDTOBuilder actionDTOBuilder = new ActionDTOBuilder();
    actionDTOBuilder.setAttribute(actionDTO.getAttribute());
    actionDTOBuilder.setId(actionDTO.getId());
    actionDTOBuilder.setValue(actionDTO.getValue());
    return actionDTOBuilder;
  }
}
