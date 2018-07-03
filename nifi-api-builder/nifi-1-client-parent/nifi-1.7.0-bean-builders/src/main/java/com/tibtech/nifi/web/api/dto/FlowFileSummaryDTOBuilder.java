package com.tibtech.nifi.web.api.dto;

import org.apache.nifi.web.api.dto.FlowFileSummaryDTO;

public final class FlowFileSummaryDTOBuilder extends AbstractFlowFileSummaryDTOBuilder<FlowFileSummaryDTOBuilder> {
  public FlowFileSummaryDTO build() {
    final FlowFileSummaryDTO flowFileSummaryDTO = new FlowFileSummaryDTO();
    super.setPropertyValues(flowFileSummaryDTO);
    return flowFileSummaryDTO;
  }

  public static FlowFileSummaryDTOBuilder of(final FlowFileSummaryDTO flowFileSummaryDTO) {
    final FlowFileSummaryDTOBuilder flowFileSummaryDTOBuilder = new FlowFileSummaryDTOBuilder();
    AbstractFlowFileSummaryDTOBuilder.setBuilderValues(flowFileSummaryDTOBuilder, flowFileSummaryDTO);
    return flowFileSummaryDTOBuilder;
  }
}
