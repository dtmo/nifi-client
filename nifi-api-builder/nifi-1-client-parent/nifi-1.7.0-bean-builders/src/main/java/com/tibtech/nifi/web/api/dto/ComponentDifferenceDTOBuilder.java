package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import java.util.List;
import org.apache.nifi.web.api.dto.ComponentDifferenceDTO;
import org.apache.nifi.web.api.dto.DifferenceDTO;

public final class ComponentDifferenceDTOBuilder {
  private String componentId;

  private String componentName;

  private String componentType;

  private List<DifferenceDTO> differences;

  private String processGroupId;

  /**
   * The ID of the component
   */
  public String getComponentId() {
    return componentId;
  }

  /**
   * The ID of the component
   */
  public ComponentDifferenceDTOBuilder setComponentId(final String componentId) {
    this.componentId = componentId;
    return this;
  }

  /**
   * The name of the component
   */
  public String getComponentName() {
    return componentName;
  }

  /**
   * The name of the component
   */
  public ComponentDifferenceDTOBuilder setComponentName(final String componentName) {
    this.componentName = componentName;
    return this;
  }

  /**
   * The type of component
   */
  public String getComponentType() {
    return componentType;
  }

  /**
   * The type of component
   */
  public ComponentDifferenceDTOBuilder setComponentType(final String componentType) {
    this.componentType = componentType;
    return this;
  }

  /**
   * The differences in the component between the two flows
   */
  public List<DifferenceDTO> getDifferences() {
    return differences;
  }

  /**
   * The differences in the component between the two flows
   */
  public ComponentDifferenceDTOBuilder setDifferences(final List<DifferenceDTO> differences) {
    this.differences = differences;
    return this;
  }

  /**
   * The ID of the Process Group that the component belongs to
   */
  public String getProcessGroupId() {
    return processGroupId;
  }

  /**
   * The ID of the Process Group that the component belongs to
   */
  public ComponentDifferenceDTOBuilder setProcessGroupId(final String processGroupId) {
    this.processGroupId = processGroupId;
    return this;
  }

  public ComponentDifferenceDTO build() {
    final ComponentDifferenceDTO componentDifferenceDTO = new ComponentDifferenceDTO();
    componentDifferenceDTO.setComponentId(componentId);
    componentDifferenceDTO.setComponentName(componentName);
    componentDifferenceDTO.setComponentType(componentType);
    componentDifferenceDTO.setDifferences(differences);
    componentDifferenceDTO.setProcessGroupId(processGroupId);
    return componentDifferenceDTO;
  }

  public static ComponentDifferenceDTOBuilder of(final ComponentDifferenceDTO componentDifferenceDTO) {
    final ComponentDifferenceDTOBuilder componentDifferenceDTOBuilder = new ComponentDifferenceDTOBuilder();
    componentDifferenceDTOBuilder.setComponentId(componentDifferenceDTO.getComponentId());
    componentDifferenceDTOBuilder.setComponentName(componentDifferenceDTO.getComponentName());
    componentDifferenceDTOBuilder.setComponentType(componentDifferenceDTO.getComponentType());
    componentDifferenceDTOBuilder.setDifferences(componentDifferenceDTO.getDifferences());
    componentDifferenceDTOBuilder.setProcessGroupId(componentDifferenceDTO.getProcessGroupId());
    return componentDifferenceDTOBuilder;
  }
}
