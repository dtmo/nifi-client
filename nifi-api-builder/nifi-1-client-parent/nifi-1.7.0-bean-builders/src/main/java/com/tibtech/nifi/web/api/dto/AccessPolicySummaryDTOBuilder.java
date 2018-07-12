package com.tibtech.nifi.web.api.dto;

import org.apache.nifi.web.api.dto.AccessPolicySummaryDTO;

public final class AccessPolicySummaryDTOBuilder extends AbstractAccessPolicySummaryDTOBuilder<AccessPolicySummaryDTOBuilder> {
  public AccessPolicySummaryDTO build() {
    final AccessPolicySummaryDTO accessPolicySummaryDTO = new AccessPolicySummaryDTO();
    super.setPropertyValues(accessPolicySummaryDTO);
    return accessPolicySummaryDTO;
  }

  public static AccessPolicySummaryDTOBuilder of(
      final AccessPolicySummaryDTO accessPolicySummaryDTO) {
    final AccessPolicySummaryDTOBuilder accessPolicySummaryDTOBuilder = new AccessPolicySummaryDTOBuilder();
    AbstractAccessPolicySummaryDTOBuilder.setBuilderValues(accessPolicySummaryDTOBuilder, accessPolicySummaryDTO);
    return accessPolicySummaryDTOBuilder;
  }
}
