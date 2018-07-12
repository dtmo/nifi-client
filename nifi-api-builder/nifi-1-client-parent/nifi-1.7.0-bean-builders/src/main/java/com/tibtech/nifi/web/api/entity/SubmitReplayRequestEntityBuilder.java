package com.tibtech.nifi.web.api.entity;

import java.lang.Long;
import java.lang.String;
import org.apache.nifi.web.api.entity.SubmitReplayRequestEntity;

public final class SubmitReplayRequestEntityBuilder extends AbstractEntityBuilder<SubmitReplayRequestEntityBuilder> {
  private String clusterNodeId;

  private Long eventId;

  /**
   * The identifier of the node where to submit the replay request.
   */
  public String getClusterNodeId() {
    return clusterNodeId;
  }

  /**
   * The identifier of the node where to submit the replay request.
   */
  public SubmitReplayRequestEntityBuilder setClusterNodeId(final String clusterNodeId) {
    this.clusterNodeId = clusterNodeId;
    return this;
  }

  /**
   * The event identifier
   */
  public Long getEventId() {
    return eventId;
  }

  /**
   * The event identifier
   */
  public SubmitReplayRequestEntityBuilder setEventId(final Long eventId) {
    this.eventId = eventId;
    return this;
  }

  public SubmitReplayRequestEntity build() {
    final SubmitReplayRequestEntity submitReplayRequestEntity = new SubmitReplayRequestEntity();
    super.setPropertyValues(submitReplayRequestEntity);
    submitReplayRequestEntity.setClusterNodeId(clusterNodeId);
    submitReplayRequestEntity.setEventId(eventId);
    return submitReplayRequestEntity;
  }

  public static SubmitReplayRequestEntityBuilder of(
      final SubmitReplayRequestEntity submitReplayRequestEntity) {
    final SubmitReplayRequestEntityBuilder submitReplayRequestEntityBuilder = new SubmitReplayRequestEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(submitReplayRequestEntityBuilder, submitReplayRequestEntity);
    submitReplayRequestEntityBuilder.setClusterNodeId(submitReplayRequestEntity.getClusterNodeId());
    submitReplayRequestEntityBuilder.setEventId(submitReplayRequestEntity.getEventId());
    return submitReplayRequestEntityBuilder;
  }
}
