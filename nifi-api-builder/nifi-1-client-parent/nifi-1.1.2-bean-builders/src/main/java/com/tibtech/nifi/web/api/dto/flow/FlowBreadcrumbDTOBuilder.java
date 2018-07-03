package com.tibtech.nifi.web.api.dto.flow;

import java.lang.String;
import org.apache.nifi.web.api.dto.flow.FlowBreadcrumbDTO;

public final class FlowBreadcrumbDTOBuilder {
  private String id;

  private String name;

  /**
   * The id of the group.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the group.
   */
  public FlowBreadcrumbDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The id of the group.
   */
  public String getName() {
    return name;
  }

  /**
   * The id of the group.
   */
  public FlowBreadcrumbDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  public FlowBreadcrumbDTO build() {
    final FlowBreadcrumbDTO flowBreadcrumbDTO = new FlowBreadcrumbDTO();
    flowBreadcrumbDTO.setId(id);
    flowBreadcrumbDTO.setName(name);
    return flowBreadcrumbDTO;
  }

  public static FlowBreadcrumbDTOBuilder of(final FlowBreadcrumbDTO flowBreadcrumbDTO) {
    final FlowBreadcrumbDTOBuilder flowBreadcrumbDTOBuilder = new FlowBreadcrumbDTOBuilder();
    flowBreadcrumbDTOBuilder.setId(flowBreadcrumbDTO.getId());
    flowBreadcrumbDTOBuilder.setName(flowBreadcrumbDTO.getName());
    return flowBreadcrumbDTOBuilder;
  }
}
