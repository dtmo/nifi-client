package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import java.util.List;
import org.apache.nifi.web.api.dto.StateEntryDTO;
import org.apache.nifi.web.api.dto.StateMapDTO;

public final class StateMapDTOBuilder {
  private String scope;

  private List<StateEntryDTO> state;

  private int totalEntryCount;

  /**
   * The scope of this StateMap.
   */
  public String getScope() {
    return scope;
  }

  /**
   * The scope of this StateMap.
   */
  public StateMapDTOBuilder setScope(final String scope) {
    this.scope = scope;
    return this;
  }

  /**
   * The state.
   */
  public List<StateEntryDTO> getState() {
    return state;
  }

  /**
   * The state.
   */
  public StateMapDTOBuilder setState(final List<StateEntryDTO> state) {
    this.state = state;
    return this;
  }

  /**
   * The total number of state entries. When the state map is lengthy, only of portion of the entries are returned.
   */
  public int getTotalEntryCount() {
    return totalEntryCount;
  }

  /**
   * The total number of state entries. When the state map is lengthy, only of portion of the entries are returned.
   */
  public StateMapDTOBuilder setTotalEntryCount(final int totalEntryCount) {
    this.totalEntryCount = totalEntryCount;
    return this;
  }

  public StateMapDTO build() {
    final StateMapDTO stateMapDTO = new StateMapDTO();
    stateMapDTO.setScope(scope);
    stateMapDTO.setState(state);
    stateMapDTO.setTotalEntryCount(totalEntryCount);
    return stateMapDTO;
  }

  public static StateMapDTOBuilder of(final StateMapDTO stateMapDTO) {
    final StateMapDTOBuilder stateMapDTOBuilder = new StateMapDTOBuilder();
    stateMapDTOBuilder.setScope(stateMapDTO.getScope());
    stateMapDTOBuilder.setState(stateMapDTO.getState());
    stateMapDTOBuilder.setTotalEntryCount(stateMapDTO.getTotalEntryCount());
    return stateMapDTOBuilder;
  }
}
