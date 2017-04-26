package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import org.apache.nifi.web.api.dto.ComponentReferenceDTO;

public final class ComponentReferenceDTOBuilder extends AbstractComponentDTOBuilder<ComponentReferenceDTOBuilder> {
  private String id;

  private String name;

  private String parentGroupId;

  /**
   * The id of the component.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the component.
   */
  public ComponentReferenceDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The name of the component.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the component.
   */
  public ComponentReferenceDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * The id of parent process group of this component if applicable.
   */
  public String getParentGroupId() {
    return parentGroupId;
  }

  /**
   * The id of parent process group of this component if applicable.
   */
  public ComponentReferenceDTOBuilder setParentGroupId(final String parentGroupId) {
    this.parentGroupId = parentGroupId;
    return this;
  }

  public ComponentReferenceDTO build() {
    final ComponentReferenceDTO componentReferenceDTO = new ComponentReferenceDTO();
    super.setPropertyValues(componentReferenceDTO);
    componentReferenceDTO.setId(id);
    componentReferenceDTO.setName(name);
    componentReferenceDTO.setParentGroupId(parentGroupId);
    return componentReferenceDTO;
  }

  public static ComponentReferenceDTOBuilder of(final ComponentReferenceDTO componentReferenceDTO) {
    final ComponentReferenceDTOBuilder componentReferenceDTOBuilder = new ComponentReferenceDTOBuilder();
    AbstractComponentDTOBuilder.setBuilderValues(componentReferenceDTOBuilder, componentReferenceDTO);
    componentReferenceDTOBuilder.setId(componentReferenceDTO.getId());
    componentReferenceDTOBuilder.setName(componentReferenceDTO.getName());
    componentReferenceDTOBuilder.setParentGroupId(componentReferenceDTO.getParentGroupId());
    return componentReferenceDTOBuilder;
  }
}
