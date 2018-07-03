package com.tibtech.nifi.web.api.dto.action;

import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import org.apache.nifi.web.api.dto.action.HistoryQueryDTO;

public final class HistoryQueryDTOBuilder {
  private Integer count;

  private Date endDate;

  private Integer offset;

  private String sortColumn;

  private String sortOrder;

  private String sourceId;

  private Date startDate;

  private String userIdentity;

  /**
   * The number of actions to return.
   */
  public Integer getCount() {
    return count;
  }

  /**
   * The number of actions to return.
   */
  public HistoryQueryDTOBuilder setCount(final Integer count) {
    this.count = count;
    return this;
  }

  /**
   * The end date of actions to return.
   */
  public Date getEndDate() {
    return endDate;
  }

  /**
   * The end date of actions to return.
   */
  public HistoryQueryDTOBuilder setEndDate(final Date endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * The offset into the result set.
   */
  public Integer getOffset() {
    return offset;
  }

  /**
   * The offset into the result set.
   */
  public HistoryQueryDTOBuilder setOffset(final Integer offset) {
    this.offset = offset;
    return this;
  }

  /**
   * The field to sort on.
   */
  public String getSortColumn() {
    return sortColumn;
  }

  /**
   * The field to sort on.
   */
  public HistoryQueryDTOBuilder setSortColumn(final String sortColumn) {
    this.sortColumn = sortColumn;
    return this;
  }

  /**
   * The sort order.
   */
  public String getSortOrder() {
    return sortOrder;
  }

  /**
   * The sort order.
   */
  public HistoryQueryDTOBuilder setSortOrder(final String sortOrder) {
    this.sortOrder = sortOrder;
    return this;
  }

  /**
   * The id of the source component.
   */
  public String getSourceId() {
    return sourceId;
  }

  /**
   * The id of the source component.
   */
  public HistoryQueryDTOBuilder setSourceId(final String sourceId) {
    this.sourceId = sourceId;
    return this;
  }

  /**
   * The start date of actions to return.
   */
  public Date getStartDate() {
    return startDate;
  }

  /**
   * The start date of actions to return.
   */
  public HistoryQueryDTOBuilder setStartDate(final Date startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * The user identity.
   */
  public String getUserIdentity() {
    return userIdentity;
  }

  /**
   * The user identity.
   */
  public HistoryQueryDTOBuilder setUserIdentity(final String userIdentity) {
    this.userIdentity = userIdentity;
    return this;
  }

  public HistoryQueryDTO build() {
    final HistoryQueryDTO historyQueryDTO = new HistoryQueryDTO();
    historyQueryDTO.setCount(count);
    historyQueryDTO.setEndDate(endDate);
    historyQueryDTO.setOffset(offset);
    historyQueryDTO.setSortColumn(sortColumn);
    historyQueryDTO.setSortOrder(sortOrder);
    historyQueryDTO.setSourceId(sourceId);
    historyQueryDTO.setStartDate(startDate);
    historyQueryDTO.setUserIdentity(userIdentity);
    return historyQueryDTO;
  }

  public static HistoryQueryDTOBuilder of(final HistoryQueryDTO historyQueryDTO) {
    final HistoryQueryDTOBuilder historyQueryDTOBuilder = new HistoryQueryDTOBuilder();
    historyQueryDTOBuilder.setCount(historyQueryDTO.getCount());
    historyQueryDTOBuilder.setEndDate(historyQueryDTO.getEndDate());
    historyQueryDTOBuilder.setOffset(historyQueryDTO.getOffset());
    historyQueryDTOBuilder.setSortColumn(historyQueryDTO.getSortColumn());
    historyQueryDTOBuilder.setSortOrder(historyQueryDTO.getSortOrder());
    historyQueryDTOBuilder.setSourceId(historyQueryDTO.getSourceId());
    historyQueryDTOBuilder.setStartDate(historyQueryDTO.getStartDate());
    historyQueryDTOBuilder.setUserIdentity(historyQueryDTO.getUserIdentity());
    return historyQueryDTOBuilder;
  }
}
