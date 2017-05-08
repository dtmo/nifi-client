package com.tibtech.nifi.web.api.dto.action;

import java.lang.Integer;
import java.util.Collection;
import java.util.Date;
import org.apache.nifi.web.api.dto.action.HistoryDTO;
import org.apache.nifi.web.api.entity.ActionEntity;

public final class HistoryDTOBuilder {
  private Collection<ActionEntity> actions;

  private Date lastRefreshed;

  private Integer total;

  /**
   * The actions.
   */
  public Collection<ActionEntity> getActions() {
    return actions;
  }

  /**
   * The actions.
   */
  public HistoryDTOBuilder setActions(final Collection<ActionEntity> actions) {
    this.actions = actions;
    return this;
  }

  /**
   * The timestamp when the report was generated.
   */
  public Date getLastRefreshed() {
    return lastRefreshed;
  }

  /**
   * The timestamp when the report was generated.
   */
  public HistoryDTOBuilder setLastRefreshed(final Date lastRefreshed) {
    this.lastRefreshed = lastRefreshed;
    return this;
  }

  /**
   * The number of number of actions that matched the search criteria..
   */
  public Integer getTotal() {
    return total;
  }

  /**
   * The number of number of actions that matched the search criteria..
   */
  public HistoryDTOBuilder setTotal(final Integer total) {
    this.total = total;
    return this;
  }

  public HistoryDTO build() {
    final HistoryDTO historyDTO = new HistoryDTO();
    historyDTO.setActions(actions);
    historyDTO.setLastRefreshed(lastRefreshed);
    historyDTO.setTotal(total);
    return historyDTO;
  }

  public static HistoryDTOBuilder of(final HistoryDTO historyDTO) {
    final HistoryDTOBuilder historyDTOBuilder = new HistoryDTOBuilder();
    historyDTOBuilder.setActions(historyDTO.getActions());
    historyDTOBuilder.setLastRefreshed(historyDTO.getLastRefreshed());
    historyDTOBuilder.setTotal(historyDTO.getTotal());
    return historyDTOBuilder;
  }
}
