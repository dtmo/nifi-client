package com.tibtech.nifi.web.api.dto;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import org.apache.nifi.web.api.dto.FlowFileSummaryDTO;
import org.apache.nifi.web.api.dto.ListingRequestDTO;
import org.apache.nifi.web.api.dto.QueueSizeDTO;

public final class ListingRequestDTOBuilder {
  private String failureReason;

  private Boolean finished;

  private List<FlowFileSummaryDTO> flowFileSummaries;

  private String id;

  private Date lastUpdated;

  private Integer maxResults;

  private Integer percentCompleted;

  private QueueSizeDTO queueSize;

  private String state;

  private Date submissionTime;

  private String uri;

  /**
   * The reason, if any, that this listing request failed.
   */
  public String getFailureReason() {
    return failureReason;
  }

  /**
   * The reason, if any, that this listing request failed.
   */
  public ListingRequestDTOBuilder setFailureReason(final String failureReason) {
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
  public ListingRequestDTOBuilder setFinished(final Boolean finished) {
    this.finished = finished;
    return this;
  }

  /**
   * The FlowFile summaries. The summaries will be populated once the request has completed.
   */
  public List<FlowFileSummaryDTO> getFlowFileSummaries() {
    return flowFileSummaries;
  }

  /**
   * The FlowFile summaries. The summaries will be populated once the request has completed.
   */
  public ListingRequestDTOBuilder setFlowFileSummaries(final List<FlowFileSummaryDTO> flowFileSummaries) {
    this.flowFileSummaries = flowFileSummaries;
    return this;
  }

  /**
   * The id for this listing request.
   */
  public String getId() {
    return id;
  }

  /**
   * The id for this listing request.
   */
  public ListingRequestDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The last time this listing request was updated.
   */
  public Date getLastUpdated() {
    return lastUpdated;
  }

  /**
   * The last time this listing request was updated.
   */
  public ListingRequestDTOBuilder setLastUpdated(final Date lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

  /**
   * The maximum number of FlowFileSummary objects to return
   */
  public Integer getMaxResults() {
    return maxResults;
  }

  /**
   * The maximum number of FlowFileSummary objects to return
   */
  public ListingRequestDTOBuilder setMaxResults(final Integer maxResults) {
    this.maxResults = maxResults;
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
  public ListingRequestDTOBuilder setPercentCompleted(final Integer percentCompleted) {
    this.percentCompleted = percentCompleted;
    return this;
  }

  /**
   * The size of the queue
   */
  public QueueSizeDTO getQueueSize() {
    return queueSize;
  }

  /**
   * The size of the queue
   */
  public ListingRequestDTOBuilder setQueueSize(final QueueSizeDTO queueSize) {
    this.queueSize = queueSize;
    return this;
  }

  /**
   * The size of the queue
   */
  public ListingRequestDTOBuilder setQueueSize(final Function<QueueSizeDTOBuilder, QueueSizeDTOBuilder> configurator) {
    return setQueueSize(configurator.apply(new QueueSizeDTOBuilder()).build());
  }

  /**
   * The size of the queue
   */
  public ListingRequestDTOBuilder setQueueSize(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = QueueSizeDTOBuilder.class) final Closure<QueueSizeDTOBuilder> closure) {
    return setQueueSize(c -> {
      final Closure<QueueSizeDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  /**
   * The current state of the listing request.
   */
  public String getState() {
    return state;
  }

  /**
   * The current state of the listing request.
   */
  public ListingRequestDTOBuilder setState(final String state) {
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
  public ListingRequestDTOBuilder setSubmissionTime(final Date submissionTime) {
    this.submissionTime = submissionTime;
    return this;
  }

  /**
   * The URI for future requests to this listing request.
   */
  public String getUri() {
    return uri;
  }

  /**
   * The URI for future requests to this listing request.
   */
  public ListingRequestDTOBuilder setUri(final String uri) {
    this.uri = uri;
    return this;
  }

  public ListingRequestDTO build() {
    final ListingRequestDTO listingRequestDTO = new ListingRequestDTO();
    listingRequestDTO.setFailureReason(failureReason);
    listingRequestDTO.setFinished(finished);
    listingRequestDTO.setFlowFileSummaries(flowFileSummaries);
    listingRequestDTO.setId(id);
    listingRequestDTO.setLastUpdated(lastUpdated);
    listingRequestDTO.setMaxResults(maxResults);
    listingRequestDTO.setPercentCompleted(percentCompleted);
    listingRequestDTO.setQueueSize(queueSize);
    listingRequestDTO.setState(state);
    listingRequestDTO.setSubmissionTime(submissionTime);
    listingRequestDTO.setUri(uri);
    return listingRequestDTO;
  }

  public static ListingRequestDTOBuilder of(final ListingRequestDTO listingRequestDTO) {
    final ListingRequestDTOBuilder listingRequestDTOBuilder = new ListingRequestDTOBuilder();
    listingRequestDTOBuilder.setFailureReason(listingRequestDTO.getFailureReason());
    listingRequestDTOBuilder.setFinished(listingRequestDTO.getFinished());
    listingRequestDTOBuilder.setFlowFileSummaries(listingRequestDTO.getFlowFileSummaries());
    listingRequestDTOBuilder.setId(listingRequestDTO.getId());
    listingRequestDTOBuilder.setLastUpdated(listingRequestDTO.getLastUpdated());
    listingRequestDTOBuilder.setMaxResults(listingRequestDTO.getMaxResults());
    listingRequestDTOBuilder.setPercentCompleted(listingRequestDTO.getPercentCompleted());
    listingRequestDTOBuilder.setQueueSize(listingRequestDTO.getQueueSize());
    listingRequestDTOBuilder.setState(listingRequestDTO.getState());
    listingRequestDTOBuilder.setSubmissionTime(listingRequestDTO.getSubmissionTime());
    listingRequestDTOBuilder.setUri(listingRequestDTO.getUri());
    return listingRequestDTOBuilder;
  }
}
