package com.tibtech.nifi.web.api.dto.action.details;

import org.apache.nifi.web.api.dto.action.details.ActionDetailsDTO;

public abstract class AbstractActionDetailsDTOBuilder<T extends AbstractActionDetailsDTOBuilder<T>> {
  protected void setPropertyValues(final ActionDetailsDTO actionDetailsDTO) {
  }

  protected static void setBuilderValues(
      final AbstractActionDetailsDTOBuilder abstractActionDetailsDTOBuilder,
      final ActionDetailsDTO actionDetailsDTO) {
  }
}
