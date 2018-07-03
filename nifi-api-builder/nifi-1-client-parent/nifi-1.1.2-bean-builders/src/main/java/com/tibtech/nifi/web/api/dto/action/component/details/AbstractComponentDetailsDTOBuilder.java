package com.tibtech.nifi.web.api.dto.action.component.details;

import org.apache.nifi.web.api.dto.action.component.details.ComponentDetailsDTO;

public abstract class AbstractComponentDetailsDTOBuilder<T extends AbstractComponentDetailsDTOBuilder<T>> {
  protected void setPropertyValues(final ComponentDetailsDTO componentDetailsDTO) {
  }

  protected static void setBuilderValues(final AbstractComponentDetailsDTOBuilder abstractComponentDetailsDTOBuilder,
      final ComponentDetailsDTO componentDetailsDTO) {
  }
}
