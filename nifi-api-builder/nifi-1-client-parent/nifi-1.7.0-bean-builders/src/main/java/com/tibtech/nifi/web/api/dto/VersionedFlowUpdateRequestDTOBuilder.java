package com.tibtech.nifi.web.api.dto;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.Date;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.VersionControlInformationDTO;
import org.apache.nifi.web.api.dto.VersionedFlowUpdateRequestDTO;

public final class VersionedFlowUpdateRequestDTOBuilder {
  private boolean complete;

  private String failureReason;

  private Date lastUpdated;

  private int percentCompleted;

  private String processGroupId;

  private String requestId;

  private String state;

  private String uri;

  private VersionControlInformationDTO versionControlInformation;

  /**
   * Whether or not this request has completed
   */
  public boolean getComplete() {
    return complete;
  }

  /**
   * Whether or not this request has completed
   */
  public VersionedFlowUpdateRequestDTOBuilder setComplete(final boolean complete) {
    this.complete = complete;
    return this;
  }

  /**
   * An explanation of why this request failed, or null if this request has not failed
   */
  public String getFailureReason() {
    return failureReason;
  }

  /**
   * An explanation of why this request failed, or null if this request has not failed
   */
  public VersionedFlowUpdateRequestDTOBuilder setFailureReason(final String failureReason) {
    this.failureReason = failureReason;
    return this;
  }

  /**
   * The last time this request was updated.
   */
  public Date getLastUpdated() {
    return lastUpdated;
  }

  /**
   * The last time this request was updated.
   */
  public VersionedFlowUpdateRequestDTOBuilder setLastUpdated(final Date lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

  /**
   * The percentage complete for the request, between 0 and 100
   */
  public int getPercentCompleted() {
    return percentCompleted;
  }

  /**
   * The percentage complete for the request, between 0 and 100
   */
  public VersionedFlowUpdateRequestDTOBuilder setPercentCompleted(final int percentCompleted) {
    this.percentCompleted = percentCompleted;
    return this;
  }

  /**
   * The unique ID of the Process Group that the variable registry belongs to
   */
  public String getProcessGroupId() {
    return processGroupId;
  }

  /**
   * The unique ID of the Process Group that the variable registry belongs to
   */
  public VersionedFlowUpdateRequestDTOBuilder setProcessGroupId(final String processGroupId) {
    this.processGroupId = processGroupId;
    return this;
  }

  /**
   * The unique ID of this request.
   */
  public String getRequestId() {
    return requestId;
  }

  /**
   * The unique ID of this request.
   */
  public VersionedFlowUpdateRequestDTOBuilder setRequestId(final String requestId) {
    this.requestId = requestId;
    return this;
  }

  /**
   * The state of the request
   */
  public String getState() {
    return state;
  }

  /**
   * The state of the request
   */
  public VersionedFlowUpdateRequestDTOBuilder setState(final String state) {
    this.state = state;
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
  public VersionedFlowUpdateRequestDTOBuilder setUri(final String uri) {
    this.uri = uri;
    return this;
  }

  /**
   * The VersionControlInformation that describes where the Versioned Flow is located; this may not be populated until the request is completed.
   */
  public VersionControlInformationDTO getVersionControlInformation() {
    return versionControlInformation;
  }

  /**
   * The VersionControlInformation that describes where the Versioned Flow is located; this may not be populated until the request is completed.
   */
  public VersionedFlowUpdateRequestDTOBuilder setVersionControlInformation(
      final VersionControlInformationDTO versionControlInformation) {
    this.versionControlInformation = versionControlInformation;
    return this;
  }

  /**
   * The VersionControlInformation that describes where the Versioned Flow is located; this may not be populated until the request is completed.
   */
  public VersionedFlowUpdateRequestDTOBuilder setVersionControlInformation(
      final Consumer<VersionControlInformationDTOBuilder> configurator) {
    final VersionControlInformationDTOBuilder builder = (versionControlInformation != null ? VersionControlInformationDTOBuilder.of(versionControlInformation) : new VersionControlInformationDTOBuilder());
    configurator.accept(builder);
    return setVersionControlInformation(builder.build());
  }

  /**
   * The VersionControlInformation that describes where the Versioned Flow is located; this may not be populated until the request is completed.
   */
  public VersionedFlowUpdateRequestDTOBuilder setVersionControlInformation(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = VersionControlInformationDTOBuilder.class) final Closure<VersionControlInformationDTOBuilder> closure) {
    return setVersionControlInformation(c -> {
      final Closure<VersionControlInformationDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  public VersionedFlowUpdateRequestDTO build() {
    final VersionedFlowUpdateRequestDTO versionedFlowUpdateRequestDTO = new VersionedFlowUpdateRequestDTO();
    versionedFlowUpdateRequestDTO.setComplete(complete);
    versionedFlowUpdateRequestDTO.setFailureReason(failureReason);
    versionedFlowUpdateRequestDTO.setLastUpdated(lastUpdated);
    versionedFlowUpdateRequestDTO.setPercentCompleted(percentCompleted);
    versionedFlowUpdateRequestDTO.setProcessGroupId(processGroupId);
    versionedFlowUpdateRequestDTO.setRequestId(requestId);
    versionedFlowUpdateRequestDTO.setState(state);
    versionedFlowUpdateRequestDTO.setUri(uri);
    versionedFlowUpdateRequestDTO.setVersionControlInformation(versionControlInformation);
    return versionedFlowUpdateRequestDTO;
  }

  public static VersionedFlowUpdateRequestDTOBuilder of(
      final VersionedFlowUpdateRequestDTO versionedFlowUpdateRequestDTO) {
    final VersionedFlowUpdateRequestDTOBuilder versionedFlowUpdateRequestDTOBuilder = new VersionedFlowUpdateRequestDTOBuilder();
    versionedFlowUpdateRequestDTOBuilder.setComplete(versionedFlowUpdateRequestDTO.isComplete());
    versionedFlowUpdateRequestDTOBuilder.setFailureReason(versionedFlowUpdateRequestDTO.getFailureReason());
    versionedFlowUpdateRequestDTOBuilder.setLastUpdated(versionedFlowUpdateRequestDTO.getLastUpdated());
    versionedFlowUpdateRequestDTOBuilder.setPercentCompleted(versionedFlowUpdateRequestDTO.getPercentCompleted());
    versionedFlowUpdateRequestDTOBuilder.setProcessGroupId(versionedFlowUpdateRequestDTO.getProcessGroupId());
    versionedFlowUpdateRequestDTOBuilder.setRequestId(versionedFlowUpdateRequestDTO.getRequestId());
    versionedFlowUpdateRequestDTOBuilder.setState(versionedFlowUpdateRequestDTO.getState());
    versionedFlowUpdateRequestDTOBuilder.setUri(versionedFlowUpdateRequestDTO.getUri());
    versionedFlowUpdateRequestDTOBuilder.setVersionControlInformation(versionedFlowUpdateRequestDTO.getVersionControlInformation());
    return versionedFlowUpdateRequestDTOBuilder;
  }
}
