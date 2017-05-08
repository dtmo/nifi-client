package com.tibtech.nifi.web.api.dto;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import org.apache.nifi.web.api.dto.DropRequestDTO;

public final class DropRequestDTOBuilder {
  private String current;

  private Integer currentCount;

  private Long currentSize;

  private String dropped;

  private Integer droppedCount;

  private Long droppedSize;

  private String failureReason;

  private Boolean finished;

  private String id;

  private Date lastUpdated;

  private String original;

  private Integer originalCount;

  private Long originalSize;

  private Integer percentCompleted;

  private String state;

  private Date submissionTime;

  private String uri;

  /**
   * The count and size of flow files currently queued.
   */
  public String getCurrent() {
    return current;
  }

  /**
   * The count and size of flow files currently queued.
   */
  public DropRequestDTOBuilder setCurrent(final String current) {
    this.current = current;
    return this;
  }

  /**
   * The number of flow files currently queued.
   */
  public Integer getCurrentCount() {
    return currentCount;
  }

  /**
   * The number of flow files currently queued.
   */
  public DropRequestDTOBuilder setCurrentCount(final Integer currentCount) {
    this.currentCount = currentCount;
    return this;
  }

  /**
   * The size of flow files currently queued in bytes.
   */
  public Long getCurrentSize() {
    return currentSize;
  }

  /**
   * The size of flow files currently queued in bytes.
   */
  public DropRequestDTOBuilder setCurrentSize(final Long currentSize) {
    this.currentSize = currentSize;
    return this;
  }

  /**
   * The count and size of flow files that have been dropped thus far.
   */
  public String getDropped() {
    return dropped;
  }

  /**
   * The count and size of flow files that have been dropped thus far.
   */
  public DropRequestDTOBuilder setDropped(final String dropped) {
    this.dropped = dropped;
    return this;
  }

  /**
   * The number of flow files that have been dropped thus far.
   */
  public Integer getDroppedCount() {
    return droppedCount;
  }

  /**
   * The number of flow files that have been dropped thus far.
   */
  public DropRequestDTOBuilder setDroppedCount(final Integer droppedCount) {
    this.droppedCount = droppedCount;
    return this;
  }

  /**
   * The size of flow files that have been dropped thus far in bytes.
   */
  public Long getDroppedSize() {
    return droppedSize;
  }

  /**
   * The size of flow files that have been dropped thus far in bytes.
   */
  public DropRequestDTOBuilder setDroppedSize(final Long droppedSize) {
    this.droppedSize = droppedSize;
    return this;
  }

  /**
   * The reason, if any, that this drop request failed.
   */
  public String getFailureReason() {
    return failureReason;
  }

  /**
   * The reason, if any, that this drop request failed.
   */
  public DropRequestDTOBuilder setFailureReason(final String failureReason) {
    this.failureReason = failureReason;
    return this;
  }

  /**
   * Whether the query has finished.
   */
  public Boolean getFinished() {
    return finished;
  }

  /**
   * Whether the query has finished.
   */
  public DropRequestDTOBuilder setFinished(final Boolean finished) {
    this.finished = finished;
    return this;
  }

  /**
   * The id for this drop request.
   */
  public String getId() {
    return id;
  }

  /**
   * The id for this drop request.
   */
  public DropRequestDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The last time this drop request was updated.
   */
  public Date getLastUpdated() {
    return lastUpdated;
  }

  /**
   * The last time this drop request was updated.
   */
  public DropRequestDTOBuilder setLastUpdated(final Date lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

  /**
   * The count and size of flow files to be dropped as a result of this request.
   */
  public String getOriginal() {
    return original;
  }

  /**
   * The count and size of flow files to be dropped as a result of this request.
   */
  public DropRequestDTOBuilder setOriginal(final String original) {
    this.original = original;
    return this;
  }

  /**
   * The number of flow files to be dropped as a result of this request.
   */
  public Integer getOriginalCount() {
    return originalCount;
  }

  /**
   * The number of flow files to be dropped as a result of this request.
   */
  public DropRequestDTOBuilder setOriginalCount(final Integer originalCount) {
    this.originalCount = originalCount;
    return this;
  }

  /**
   * The size of flow files to be dropped as a result of this request in bytes.
   */
  public Long getOriginalSize() {
    return originalSize;
  }

  /**
   * The size of flow files to be dropped as a result of this request in bytes.
   */
  public DropRequestDTOBuilder setOriginalSize(final Long originalSize) {
    this.originalSize = originalSize;
    return this;
  }

  /**
   * The current percent complete.
   */
  public Integer getPercentCompleted() {
    return percentCompleted;
  }

  /**
   * The current percent complete.
   */
  public DropRequestDTOBuilder setPercentCompleted(final Integer percentCompleted) {
    this.percentCompleted = percentCompleted;
    return this;
  }

  /**
   * The current state of the drop request.
   */
  public String getState() {
    return state;
  }

  /**
   * The current state of the drop request.
   */
  public DropRequestDTOBuilder setState(final String state) {
    this.state = state;
    return this;
  }

  /**
   * The timestamp when the query was submitted.
   */
  public Date getSubmissionTime() {
    return submissionTime;
  }

  /**
   * The timestamp when the query was submitted.
   */
  public DropRequestDTOBuilder setSubmissionTime(final Date submissionTime) {
    this.submissionTime = submissionTime;
    return this;
  }

  /**
   * The URI for future requests to this drop request.
   */
  public String getUri() {
    return uri;
  }

  /**
   * The URI for future requests to this drop request.
   */
  public DropRequestDTOBuilder setUri(final String uri) {
    this.uri = uri;
    return this;
  }

  public DropRequestDTO build() {
    final DropRequestDTO dropRequestDTO = new DropRequestDTO();
    dropRequestDTO.setCurrent(current);
    dropRequestDTO.setCurrentCount(currentCount);
    dropRequestDTO.setCurrentSize(currentSize);
    dropRequestDTO.setDropped(dropped);
    dropRequestDTO.setDroppedCount(droppedCount);
    dropRequestDTO.setDroppedSize(droppedSize);
    dropRequestDTO.setFailureReason(failureReason);
    dropRequestDTO.setFinished(finished);
    dropRequestDTO.setId(id);
    dropRequestDTO.setLastUpdated(lastUpdated);
    dropRequestDTO.setOriginal(original);
    dropRequestDTO.setOriginalCount(originalCount);
    dropRequestDTO.setOriginalSize(originalSize);
    dropRequestDTO.setPercentCompleted(percentCompleted);
    dropRequestDTO.setState(state);
    dropRequestDTO.setSubmissionTime(submissionTime);
    dropRequestDTO.setUri(uri);
    return dropRequestDTO;
  }

  public static DropRequestDTOBuilder of(final DropRequestDTO dropRequestDTO) {
    final DropRequestDTOBuilder dropRequestDTOBuilder = new DropRequestDTOBuilder();
    dropRequestDTOBuilder.setCurrent(dropRequestDTO.getCurrent());
    dropRequestDTOBuilder.setCurrentCount(dropRequestDTO.getCurrentCount());
    dropRequestDTOBuilder.setCurrentSize(dropRequestDTO.getCurrentSize());
    dropRequestDTOBuilder.setDropped(dropRequestDTO.getDropped());
    dropRequestDTOBuilder.setDroppedCount(dropRequestDTO.getDroppedCount());
    dropRequestDTOBuilder.setDroppedSize(dropRequestDTO.getDroppedSize());
    dropRequestDTOBuilder.setFailureReason(dropRequestDTO.getFailureReason());
    dropRequestDTOBuilder.setFinished(dropRequestDTO.isFinished());
    dropRequestDTOBuilder.setId(dropRequestDTO.getId());
    dropRequestDTOBuilder.setLastUpdated(dropRequestDTO.getLastUpdated());
    dropRequestDTOBuilder.setOriginal(dropRequestDTO.getOriginal());
    dropRequestDTOBuilder.setOriginalCount(dropRequestDTO.getOriginalCount());
    dropRequestDTOBuilder.setOriginalSize(dropRequestDTO.getOriginalSize());
    dropRequestDTOBuilder.setPercentCompleted(dropRequestDTO.getPercentCompleted());
    dropRequestDTOBuilder.setState(dropRequestDTO.getState());
    dropRequestDTOBuilder.setSubmissionTime(dropRequestDTO.getSubmissionTime());
    dropRequestDTOBuilder.setUri(dropRequestDTO.getUri());
    return dropRequestDTOBuilder;
  }
}
