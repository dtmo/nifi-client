package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.action.HistoryDTO;
import org.apache.nifi.web.api.entity.HistoryEntity;

public final class HistoryEntityBuilder extends AbstractEntityBuilder<HistoryEntityBuilder> {
  private HistoryDTO history;

  public HistoryDTO getHistory() {
    return history;
  }

  public HistoryEntityBuilder setHistory(final HistoryDTO history) {
    this.history = history;
    return this;
  }

  public HistoryEntity build() {
    final HistoryEntity historyEntity = new HistoryEntity();
    super.setPropertyValues(historyEntity);
    historyEntity.setHistory(history);
    return historyEntity;
  }

  public static HistoryEntityBuilder of(final HistoryEntity historyEntity) {
    final HistoryEntityBuilder historyEntityBuilder = new HistoryEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(historyEntityBuilder, historyEntity);
    historyEntityBuilder.setHistory(historyEntity.getHistory());
    return historyEntityBuilder;
  }
}
