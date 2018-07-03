package com.tibtech.nifi.web.api.entity;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import org.apache.nifi.web.api.dto.action.ActionDTO;
import org.apache.nifi.web.api.entity.ActionEntity;

public final class ActionEntityBuilder extends AbstractEntityBuilder<ActionEntityBuilder> {
  private ActionDTO action;

  private Boolean canRead;

  private Integer id;

  private String sourceId;

  private Date timestamp;

  public ActionDTO getAction() {
    return action;
  }

  public ActionEntityBuilder setAction(final ActionDTO action) {
    this.action = action;
    return this;
  }

  public Boolean getCanRead() {
    return canRead;
  }

  public ActionEntityBuilder setCanRead(final Boolean canRead) {
    this.canRead = canRead;
    return this;
  }

  public Integer getId() {
    return id;
  }

  public ActionEntityBuilder setId(final Integer id) {
    this.id = id;
    return this;
  }

  public String getSourceId() {
    return sourceId;
  }

  public ActionEntityBuilder setSourceId(final String sourceId) {
    this.sourceId = sourceId;
    return this;
  }

  /**
   * The timestamp of the action.
   */
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * The timestamp of the action.
   */
  public ActionEntityBuilder setTimestamp(final Date timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  public ActionEntity build() {
    final ActionEntity actionEntity = new ActionEntity();
    super.setPropertyValues(actionEntity);
    actionEntity.setAction(action);
    actionEntity.setCanRead(canRead);
    actionEntity.setId(id);
    actionEntity.setSourceId(sourceId);
    actionEntity.setTimestamp(timestamp);
    return actionEntity;
  }

  public static ActionEntityBuilder of(final ActionEntity actionEntity) {
    final ActionEntityBuilder actionEntityBuilder = new ActionEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(actionEntityBuilder, actionEntity);
    actionEntityBuilder.setAction(actionEntity.getAction());
    actionEntityBuilder.setCanRead(actionEntity.getCanRead());
    actionEntityBuilder.setId(actionEntity.getId());
    actionEntityBuilder.setSourceId(actionEntity.getSourceId());
    actionEntityBuilder.setTimestamp(actionEntity.getTimestamp());
    return actionEntityBuilder;
  }
}
