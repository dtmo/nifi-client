package com.tibtech.nifi.web.api.dto;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.function.Function;
import org.apache.nifi.web.api.dto.ComponentStateDTO;
import org.apache.nifi.web.api.dto.StateMapDTO;

public final class ComponentStateDTOBuilder {
  private StateMapDTO clusterState;

  private String componentId;

  private StateMapDTO localState;

  private String stateDescription;

  /**
   * The cluster state for this component, or null if this NiFi is a standalone instance.
   */
  public StateMapDTO getClusterState() {
    return clusterState;
  }

  /**
   * The cluster state for this component, or null if this NiFi is a standalone instance.
   */
  public ComponentStateDTOBuilder setClusterState(final StateMapDTO clusterState) {
    this.clusterState = clusterState;
    return this;
  }

  /**
   * The cluster state for this component, or null if this NiFi is a standalone instance.
   */
  public ComponentStateDTOBuilder setClusterState(final Function<StateMapDTOBuilder, StateMapDTOBuilder> configurator) {
    return setClusterState(configurator.apply(new StateMapDTOBuilder()).build());
  }

  /**
   * The cluster state for this component, or null if this NiFi is a standalone instance.
   */
  public ComponentStateDTOBuilder setClusterState(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = StateMapDTOBuilder.class) final Closure<StateMapDTOBuilder> closure) {
    return setClusterState(c -> {
      final Closure<StateMapDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  /**
   * The component identifier.
   */
  public String getComponentId() {
    return componentId;
  }

  /**
   * The component identifier.
   */
  public ComponentStateDTOBuilder setComponentId(final String componentId) {
    this.componentId = componentId;
    return this;
  }

  /**
   * The local state for this component.
   */
  public StateMapDTO getLocalState() {
    return localState;
  }

  /**
   * The local state for this component.
   */
  public ComponentStateDTOBuilder setLocalState(final StateMapDTO localState) {
    this.localState = localState;
    return this;
  }

  /**
   * The local state for this component.
   */
  public ComponentStateDTOBuilder setLocalState(final Function<StateMapDTOBuilder, StateMapDTOBuilder> configurator) {
    return setLocalState(configurator.apply(new StateMapDTOBuilder()).build());
  }

  /**
   * The local state for this component.
   */
  public ComponentStateDTOBuilder setLocalState(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = StateMapDTOBuilder.class) final Closure<StateMapDTOBuilder> closure) {
    return setLocalState(c -> {
      final Closure<StateMapDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  /**
   * Description of the state this component persists.
   */
  public String getStateDescription() {
    return stateDescription;
  }

  /**
   * Description of the state this component persists.
   */
  public ComponentStateDTOBuilder setStateDescription(final String stateDescription) {
    this.stateDescription = stateDescription;
    return this;
  }

  public ComponentStateDTO build() {
    final ComponentStateDTO componentStateDTO = new ComponentStateDTO();
    componentStateDTO.setClusterState(clusterState);
    componentStateDTO.setComponentId(componentId);
    componentStateDTO.setLocalState(localState);
    componentStateDTO.setStateDescription(stateDescription);
    return componentStateDTO;
  }

  public static ComponentStateDTOBuilder of(final ComponentStateDTO componentStateDTO) {
    final ComponentStateDTOBuilder componentStateDTOBuilder = new ComponentStateDTOBuilder();
    componentStateDTOBuilder.setClusterState(componentStateDTO.getClusterState());
    componentStateDTOBuilder.setComponentId(componentStateDTO.getComponentId());
    componentStateDTOBuilder.setLocalState(componentStateDTO.getLocalState());
    componentStateDTOBuilder.setStateDescription(componentStateDTO.getStateDescription());
    return componentStateDTOBuilder;
  }
}
