package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import org.apache.nifi.web.api.dto.StateEntryDTO;

public final class StateEntryDTOBuilder {
  private String clusterNodeAddress;

  private String clusterNodeId;

  private String key;

  private String value;

  /**
   * The label for the node where the state originated.
   */
  public String getClusterNodeAddress() {
    return clusterNodeAddress;
  }

  /**
   * The label for the node where the state originated.
   */
  public StateEntryDTOBuilder setClusterNodeAddress(final String clusterNodeAddress) {
    this.clusterNodeAddress = clusterNodeAddress;
    return this;
  }

  /**
   * The identifier for the node where the state originated.
   */
  public String getClusterNodeId() {
    return clusterNodeId;
  }

  /**
   * The identifier for the node where the state originated.
   */
  public StateEntryDTOBuilder setClusterNodeId(final String clusterNodeId) {
    this.clusterNodeId = clusterNodeId;
    return this;
  }

  /**
   * The key for this state.
   */
  public String getKey() {
    return key;
  }

  /**
   * The key for this state.
   */
  public StateEntryDTOBuilder setKey(final String key) {
    this.key = key;
    return this;
  }

  /**
   * The value for this state.
   */
  public String getValue() {
    return value;
  }

  /**
   * The value for this state.
   */
  public StateEntryDTOBuilder setValue(final String value) {
    this.value = value;
    return this;
  }

  public StateEntryDTO build() {
    final StateEntryDTO stateEntryDTO = new StateEntryDTO();
    stateEntryDTO.setClusterNodeAddress(clusterNodeAddress);
    stateEntryDTO.setClusterNodeId(clusterNodeId);
    stateEntryDTO.setKey(key);
    stateEntryDTO.setValue(value);
    return stateEntryDTO;
  }

  public static StateEntryDTOBuilder of(final StateEntryDTO stateEntryDTO) {
    final StateEntryDTOBuilder stateEntryDTOBuilder = new StateEntryDTOBuilder();
    stateEntryDTOBuilder.setClusterNodeAddress(stateEntryDTO.getClusterNodeAddress());
    stateEntryDTOBuilder.setClusterNodeId(stateEntryDTO.getClusterNodeId());
    stateEntryDTOBuilder.setKey(stateEntryDTO.getKey());
    stateEntryDTOBuilder.setValue(stateEntryDTO.getValue());
    return stateEntryDTOBuilder;
  }
}
