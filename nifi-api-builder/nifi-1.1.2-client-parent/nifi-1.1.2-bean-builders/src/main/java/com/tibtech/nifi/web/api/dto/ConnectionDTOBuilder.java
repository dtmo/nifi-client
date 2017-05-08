package com.tibtech.nifi.web.api.dto;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import org.apache.nifi.web.api.dto.ConnectableDTO;
import org.apache.nifi.web.api.dto.ConnectionDTO;
import org.apache.nifi.web.api.dto.PositionDTO;

public final class ConnectionDTOBuilder extends AbstractComponentDTOBuilder<ConnectionDTOBuilder> {
  private Set<String> availableRelationships;

  private String backPressureDataSizeThreshold;

  private Long backPressureObjectThreshold;

  private List<PositionDTO> bends;

  private ConnectableDTO destination;

  private String flowFileExpiration;

  private Integer labelIndex;

  private String name;

  private List<String> prioritizers;

  private Set<String> selectedRelationships;

  private ConnectableDTO source;

  private Long zIndex;

  /**
   * The relationships that the source of the connection currently supports.
   */
  public Set<String> getAvailableRelationships() {
    return availableRelationships;
  }

  /**
   * The relationships that the source of the connection currently supports.
   */
  public ConnectionDTOBuilder setAvailableRelationships(final Set<String> availableRelationships) {
    this.availableRelationships = availableRelationships;
    return this;
  }

  /**
   * The object data size threshold for determining when back pressure is applied. Updating this value is a passive change in the sense that it won't impact whether existing files over the limit are affected but it does help feeder processors to stop pushing too much into this work queue.
   */
  public String getBackPressureDataSizeThreshold() {
    return backPressureDataSizeThreshold;
  }

  /**
   * The object data size threshold for determining when back pressure is applied. Updating this value is a passive change in the sense that it won't impact whether existing files over the limit are affected but it does help feeder processors to stop pushing too much into this work queue.
   */
  public ConnectionDTOBuilder setBackPressureDataSizeThreshold(final String backPressureDataSizeThreshold) {
    this.backPressureDataSizeThreshold = backPressureDataSizeThreshold;
    return this;
  }

  /**
   * The object count threshold for determining when back pressure is applied. Updating this value is a passive change in the sense that it won't impact whether existing files over the limit are affected but it does help feeder processors to stop pushing too much into this work queue.
   */
  public Long getBackPressureObjectThreshold() {
    return backPressureObjectThreshold;
  }

  /**
   * The object count threshold for determining when back pressure is applied. Updating this value is a passive change in the sense that it won't impact whether existing files over the limit are affected but it does help feeder processors to stop pushing too much into this work queue.
   */
  public ConnectionDTOBuilder setBackPressureObjectThreshold(final Long backPressureObjectThreshold) {
    this.backPressureObjectThreshold = backPressureObjectThreshold;
    return this;
  }

  /**
   * The bend points on the connection.
   */
  public List<PositionDTO> getBends() {
    return bends;
  }

  /**
   * The bend points on the connection.
   */
  public ConnectionDTOBuilder setBends(final List<PositionDTO> bends) {
    this.bends = bends;
    return this;
  }

  /**
   * The destination of the connection.
   */
  public ConnectableDTO getDestination() {
    return destination;
  }

  /**
   * The destination of the connection.
   */
  public ConnectionDTOBuilder setDestination(final ConnectableDTO destination) {
    this.destination = destination;
    return this;
  }

  /**
   * The destination of the connection.
   */
  public ConnectionDTOBuilder setDestination(final Function<ConnectableDTOBuilder, ConnectableDTOBuilder> configurator) {
    return setDestination(configurator.apply(destination != null ? ConnectableDTOBuilder.of(destination) : new ConnectableDTOBuilder()).build());
  }

  /**
   * The destination of the connection.
   */
  public ConnectionDTOBuilder setDestination(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConnectableDTOBuilder.class) final Closure<ConnectableDTOBuilder> closure) {
    return setDestination(c -> {
      final Closure<ConnectableDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  /**
   * The amount of time a flow file may be in the flow before it will be automatically aged out of the flow. Once a flow file reaches this age it will be terminated from the flow the next time a processor attempts to start work on it.
   */
  public String getFlowFileExpiration() {
    return flowFileExpiration;
  }

  /**
   * The amount of time a flow file may be in the flow before it will be automatically aged out of the flow. Once a flow file reaches this age it will be terminated from the flow the next time a processor attempts to start work on it.
   */
  public ConnectionDTOBuilder setFlowFileExpiration(final String flowFileExpiration) {
    this.flowFileExpiration = flowFileExpiration;
    return this;
  }

  /**
   * The index of the bend point where to place the connection label.
   */
  public Integer getLabelIndex() {
    return labelIndex;
  }

  /**
   * The index of the bend point where to place the connection label.
   */
  public ConnectionDTOBuilder setLabelIndex(final Integer labelIndex) {
    this.labelIndex = labelIndex;
    return this;
  }

  /**
   * The name of the connection.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the connection.
   */
  public ConnectionDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * The comparators used to prioritize the queue.
   */
  public List<String> getPrioritizers() {
    return prioritizers;
  }

  /**
   * The comparators used to prioritize the queue.
   */
  public ConnectionDTOBuilder setPrioritizers(final List<String> prioritizers) {
    this.prioritizers = prioritizers;
    return this;
  }

  /**
   * The selected relationship that comprise the connection.
   */
  public Set<String> getSelectedRelationships() {
    return selectedRelationships;
  }

  /**
   * The selected relationship that comprise the connection.
   */
  public ConnectionDTOBuilder setSelectedRelationships(final Set<String> selectedRelationships) {
    this.selectedRelationships = selectedRelationships;
    return this;
  }

  /**
   * The source of the connection.
   */
  public ConnectableDTO getSource() {
    return source;
  }

  /**
   * The source of the connection.
   */
  public ConnectionDTOBuilder setSource(final ConnectableDTO source) {
    this.source = source;
    return this;
  }

  /**
   * The source of the connection.
   */
  public ConnectionDTOBuilder setSource(final Function<ConnectableDTOBuilder, ConnectableDTOBuilder> configurator) {
    return setSource(configurator.apply(source != null ? ConnectableDTOBuilder.of(source) : new ConnectableDTOBuilder()).build());
  }

  /**
   * The source of the connection.
   */
  public ConnectionDTOBuilder setSource(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConnectableDTOBuilder.class) final Closure<ConnectableDTOBuilder> closure) {
    return setSource(c -> {
      final Closure<ConnectableDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  /**
   * The z index of the connection.
   */
  public Long getZIndex() {
    return zIndex;
  }

  /**
   * The z index of the connection.
   */
  public ConnectionDTOBuilder setZIndex(final Long zIndex) {
    this.zIndex = zIndex;
    return this;
  }

  public ConnectionDTO build() {
    final ConnectionDTO connectionDTO = new ConnectionDTO();
    super.setPropertyValues(connectionDTO);
    connectionDTO.setAvailableRelationships(availableRelationships);
    connectionDTO.setBackPressureDataSizeThreshold(backPressureDataSizeThreshold);
    connectionDTO.setBackPressureObjectThreshold(backPressureObjectThreshold);
    connectionDTO.setBends(bends);
    connectionDTO.setDestination(destination);
    connectionDTO.setFlowFileExpiration(flowFileExpiration);
    connectionDTO.setLabelIndex(labelIndex);
    connectionDTO.setName(name);
    connectionDTO.setPrioritizers(prioritizers);
    connectionDTO.setSelectedRelationships(selectedRelationships);
    connectionDTO.setSource(source);
    connectionDTO.setzIndex(zIndex);
    return connectionDTO;
  }

  public static ConnectionDTOBuilder of(final ConnectionDTO connectionDTO) {
    final ConnectionDTOBuilder connectionDTOBuilder = new ConnectionDTOBuilder();
    AbstractComponentDTOBuilder.setBuilderValues(connectionDTOBuilder, connectionDTO);
    connectionDTOBuilder.setAvailableRelationships(connectionDTO.getAvailableRelationships());
    connectionDTOBuilder.setBackPressureDataSizeThreshold(connectionDTO.getBackPressureDataSizeThreshold());
    connectionDTOBuilder.setBackPressureObjectThreshold(connectionDTO.getBackPressureObjectThreshold());
    connectionDTOBuilder.setBends(connectionDTO.getBends());
    connectionDTOBuilder.setDestination(connectionDTO.getDestination());
    connectionDTOBuilder.setFlowFileExpiration(connectionDTO.getFlowFileExpiration());
    connectionDTOBuilder.setLabelIndex(connectionDTO.getLabelIndex());
    connectionDTOBuilder.setName(connectionDTO.getName());
    connectionDTOBuilder.setPrioritizers(connectionDTO.getPrioritizers());
    connectionDTOBuilder.setSelectedRelationships(connectionDTO.getSelectedRelationships());
    connectionDTOBuilder.setSource(connectionDTO.getSource());
    connectionDTOBuilder.setZIndex(connectionDTO.getzIndex());
    return connectionDTOBuilder;
  }
}
