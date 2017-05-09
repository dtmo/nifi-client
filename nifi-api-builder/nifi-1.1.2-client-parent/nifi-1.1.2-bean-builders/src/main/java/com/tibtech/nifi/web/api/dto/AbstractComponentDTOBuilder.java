package com.tibtech.nifi.web.api.dto;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.ComponentDTO;
import org.apache.nifi.web.api.dto.PositionDTO;

public abstract class AbstractComponentDTOBuilder<T extends AbstractComponentDTOBuilder<T>> {
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
  public T setId(final String id) {
    this.id = id;
    return (T) this;
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
  public T setParentGroupId(final String parentGroupId) {
    this.parentGroupId = parentGroupId;
    return (T) this;
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
  public T setPosition(final PositionDTO position) {
    this.position = position;
    return (T) this;
  }

  /**
   * The position of this component in the UI if applicable.
   */
  public AbstractComponentDTOBuilder setPosition(final Consumer<PositionDTOBuilder> configurator) {
    final PositionDTOBuilder builder = (position != null ? PositionDTOBuilder.of(position) : new PositionDTOBuilder());
    configurator.accept(builder);
    return setPosition(builder.build());
  }

  /**
   * The position of this component in the UI if applicable.
   */
  public AbstractComponentDTOBuilder setPosition(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PositionDTOBuilder.class) final Closure<PositionDTOBuilder> closure) {
    return setPosition(c -> {
      final Closure<PositionDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  protected void setPropertyValues(final ComponentDTO componentDTO) {
    componentDTO.setId(id);
    componentDTO.setParentGroupId(parentGroupId);
    componentDTO.setPosition(position);
  }

  protected static void setBuilderValues(final AbstractComponentDTOBuilder abstractComponentDTOBuilder,
      final ComponentDTO componentDTO) {
    abstractComponentDTOBuilder.setId(componentDTO.getId());
    abstractComponentDTOBuilder.setParentGroupId(componentDTO.getParentGroupId());
    abstractComponentDTOBuilder.setPosition(componentDTO.getPosition());
  }
}
