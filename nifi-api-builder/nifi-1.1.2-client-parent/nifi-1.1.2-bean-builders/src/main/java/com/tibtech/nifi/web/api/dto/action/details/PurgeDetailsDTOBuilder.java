package com.tibtech.nifi.web.api.dto.action.details;

import java.util.Date;
import org.apache.nifi.web.api.dto.action.details.PurgeDetailsDTO;

public final class PurgeDetailsDTOBuilder extends AbstractActionDetailsDTOBuilder<PurgeDetailsDTOBuilder> {
  private Date endDate;

  /**
   * The end date for the purge action.
   */
  public Date getEndDate() {
    return endDate;
  }

  /**
   * The end date for the purge action.
   */
  public PurgeDetailsDTOBuilder setEndDate(final Date endDate) {
    this.endDate = endDate;
    return this;
  }

  public PurgeDetailsDTO build() {
    final PurgeDetailsDTO purgeDetailsDTO = new PurgeDetailsDTO();
    super.setPropertyValues(purgeDetailsDTO);
    purgeDetailsDTO.setEndDate(endDate);
    return purgeDetailsDTO;
  }

  public static PurgeDetailsDTOBuilder of(final PurgeDetailsDTO purgeDetailsDTO) {
    final PurgeDetailsDTOBuilder purgeDetailsDTOBuilder = new PurgeDetailsDTOBuilder();
    AbstractActionDetailsDTOBuilder.setBuilderValues(purgeDetailsDTOBuilder, purgeDetailsDTO);
    purgeDetailsDTOBuilder.setEndDate(purgeDetailsDTO.getEndDate());
    return purgeDetailsDTOBuilder;
  }
}
