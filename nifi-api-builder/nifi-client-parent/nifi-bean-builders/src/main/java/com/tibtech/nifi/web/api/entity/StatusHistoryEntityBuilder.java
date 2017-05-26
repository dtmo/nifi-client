package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import org.apache.nifi.web.api.dto.status.StatusHistoryDTO;
import org.apache.nifi.web.api.entity.StatusHistoryEntity;

public final class StatusHistoryEntityBuilder extends AbstractEntityBuilder<StatusHistoryEntityBuilder> {
  private Boolean canRead;

  private StatusHistoryDTO statusHistory;

  public Boolean getCanRead() {
    return canRead;
  }

  public StatusHistoryEntityBuilder setCanRead(final Boolean canRead) {
    this.canRead = canRead;
    return this;
  }

  public StatusHistoryDTO getStatusHistory() {
    return statusHistory;
  }

  public StatusHistoryEntityBuilder setStatusHistory(final StatusHistoryDTO statusHistory) {
    this.statusHistory = statusHistory;
    return this;
  }

  public StatusHistoryEntity build() {
    final StatusHistoryEntity statusHistoryEntity = new StatusHistoryEntity();
    super.setPropertyValues(statusHistoryEntity);
    statusHistoryEntity.setCanRead(canRead);
    statusHistoryEntity.setStatusHistory(statusHistory);
    return statusHistoryEntity;
  }

  public static StatusHistoryEntityBuilder of(final StatusHistoryEntity statusHistoryEntity) {
    final StatusHistoryEntityBuilder statusHistoryEntityBuilder = new StatusHistoryEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(statusHistoryEntityBuilder, statusHistoryEntity);
    statusHistoryEntityBuilder.setCanRead(statusHistoryEntity.getCanRead());
    statusHistoryEntityBuilder.setStatusHistory(statusHistoryEntity.getStatusHistory());
    return statusHistoryEntityBuilder;
  }
}
