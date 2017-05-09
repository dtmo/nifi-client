package com.tibtech.nifi.web.api.dto;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.ComponentDTO;
import org.apache.nifi.web.api.dto.PositionDTO;

public final class ComponentDTOBuilder extends AbstractComponentDTOBuilder<ComponentDTOBuilder> {
  private String id;

  private String parentGroupId;

  private PositionDTO position;

  /**
   * The id of the component.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the component.
   */
  public ComponentDTOBuilder setId(final String id) {
    this.id = id;
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
  public ComponentDTOBuilder setParentGroupId(final String parentGroupId) {
    this.parentGroupId = parentGroupId;
    return this;
  }

  /**
   * The position of this component in the UI if applicable.
   */
  public PositionDTO getPosition() {
    return position;
  }

  /**
   * The position of this component in the UI if applicable.
   */
  public ComponentDTOBuilder setPosition(final PositionDTO position) {
    this.position = position;
    return this;
  }

  /**
   * The position of this component in the UI if applicable.
   */
  public ComponentDTOBuilder setPosition(final Consumer<PositionDTOBuilder> configurator) {
    final PositionDTOBuilder builder = (position != null ? PositionDTOBuilder.of(position) : new PositionDTOBuilder());
    configurator.accept(builder);
    return setPosition(builder.build());
  }

  /**
   * The position of this component in the UI if applicable.
   */
  public ComponentDTOBuilder setPosition(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PositionDTOBuilder.class) final Closure<PositionDTOBuilder> closure) {
    return setPosition(c -> {
      final Closure<PositionDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  public ComponentDTO build() {
    final ComponentDTO componentDTO = new ComponentDTO();
    super.setPropertyValues(componentDTO);
    componentDTO.setId(id);
    componentDTO.setParentGroupId(parentGroupId);
    componentDTO.setPosition(position);
    return componentDTO;
  }

  public static ComponentDTOBuilder of(final ComponentDTO componentDTO) {
    final ComponentDTOBuilder componentDTOBuilder = new ComponentDTOBuilder();
    AbstractComponentDTOBuilder.setBuilderValues(componentDTOBuilder, componentDTO);
    componentDTOBuilder.setId(componentDTO.getId());
    componentDTOBuilder.setParentGroupId(componentDTO.getParentGroupId());
    componentDTOBuilder.setPosition(componentDTO.getPosition());
    return componentDTOBuilder;
  }
}
