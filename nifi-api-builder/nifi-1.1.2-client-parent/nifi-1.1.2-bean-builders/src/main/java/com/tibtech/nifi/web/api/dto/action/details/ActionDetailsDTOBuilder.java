package com.tibtech.nifi.web.api.dto.action.details;

import org.apache.nifi.web.api.dto.action.details.ActionDetailsDTO;

public final class ActionDetailsDTOBuilder extends AbstractActionDetailsDTOBuilder<ActionDetailsDTOBuilder> {
  public ActionDetailsDTO build() {
    final ActionDetailsDTO actionDetailsDTO = new ActionDetailsDTO();
    super.setPropertyValues(actionDetailsDTO);
    return actionDetailsDTO;
  }

  public static ActionDetailsDTOBuilder of(final ActionDetailsDTO actionDetailsDTO) {
    final ActionDetailsDTOBuilder actionDetailsDTOBuilder = new ActionDetailsDTOBuilder();
    AbstractActionDetailsDTOBuilder.setBuilderValues(actionDetailsDTOBuilder, actionDetailsDTO);
    return actionDetailsDTOBuilder;
  }
}
