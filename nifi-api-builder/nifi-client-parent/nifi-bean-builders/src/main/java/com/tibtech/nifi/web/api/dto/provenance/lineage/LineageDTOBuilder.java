package com.tibtech.nifi.web.api.dto.provenance.lineage;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.function.Function;
import org.apache.nifi.web.api.dto.provenance.lineage.LineageDTO;
import org.apache.nifi.web.api.dto.provenance.lineage.LineageRequestDTO;
import org.apache.nifi.web.api.dto.provenance.lineage.LineageResultsDTO;

public final class LineageDTOBuilder {
  private Date expiration;

  private Boolean finished;

  private String id;

  private Integer percentCompleted;

  private LineageRequestDTO request;

  private LineageResultsDTO results;

  private Date submissionTime;

  private String uri;

  /**
   * When the lineage query will expire.
   */
  public Date getExpiration() {
    return expiration;
  }

  /**
   * When the lineage query will expire.
   */
  public LineageDTOBuilder setExpiration(final Date expiration) {
    this.expiration = expiration;
    return this;
  }

  /**
   * Whether the lineage query has finished.
   */
  public Boolean getFinished() {
    return finished;
  }

  /**
   * Whether the lineage query has finished.
   */
  public LineageDTOBuilder setFinished(final Boolean finished) {
    this.finished = finished;
    return this;
  }

  /**
   * The id of this lineage query.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of this lineage query.
   */
  public LineageDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The percent complete for the lineage query.
   */
  public Integer getPercentCompleted() {
    return percentCompleted;
  }

  /**
   * The percent complete for the lineage query.
   */
  public LineageDTOBuilder setPercentCompleted(final Integer percentCompleted) {
    this.percentCompleted = percentCompleted;
    return this;
  }

  /**
   * The initial lineage result.
   */
  public LineageRequestDTO getRequest() {
    return request;
  }

  /**
   * The initial lineage result.
   */
  public LineageDTOBuilder setRequest(final LineageRequestDTO request) {
    this.request = request;
    return this;
  }

  /**
   * The initial lineage result.
   */
  public LineageDTOBuilder setRequest(final Function<LineageRequestDTOBuilder, LineageRequestDTOBuilder> configurator) {
    return setRequest(configurator.apply(new LineageRequestDTOBuilder()).build());
  }

  /**
   * The initial lineage result.
   */
  public LineageDTOBuilder setRequest(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = LineageRequestDTOBuilder.class) final Closure<LineageRequestDTOBuilder> closure) {
    return setRequest(c -> {
      final Closure<LineageRequestDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  /**
   * The results of the lineage query.
   */
  public LineageResultsDTO getResults() {
    return results;
  }

  /**
   * The results of the lineage query.
   */
  public LineageDTOBuilder setResults(final LineageResultsDTO results) {
    this.results = results;
    return this;
  }

  /**
   * The results of the lineage query.
   */
  public LineageDTOBuilder setResults(final Function<LineageResultsDTOBuilder, LineageResultsDTOBuilder> configurator) {
    return setResults(configurator.apply(new LineageResultsDTOBuilder()).build());
  }

  /**
   * The results of the lineage query.
   */
  public LineageDTOBuilder setResults(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = LineageResultsDTOBuilder.class) final Closure<LineageResultsDTOBuilder> closure) {
    return setResults(c -> {
      final Closure<LineageResultsDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  /**
   * When the lineage query was submitted.
   */
  public Date getSubmissionTime() {
    return submissionTime;
  }

  /**
   * When the lineage query was submitted.
   */
  public LineageDTOBuilder setSubmissionTime(final Date submissionTime) {
    this.submissionTime = submissionTime;
    return this;
  }

  /**
   * The URI for this lineage query for later retrieval and deletion.
   */
  public String getUri() {
    return uri;
  }

  /**
   * The URI for this lineage query for later retrieval and deletion.
   */
  public LineageDTOBuilder setUri(final String uri) {
    this.uri = uri;
    return this;
  }

  public LineageDTO build() {
    final LineageDTO lineageDTO = new LineageDTO();
    lineageDTO.setExpiration(expiration);
    lineageDTO.setFinished(finished);
    lineageDTO.setId(id);
    lineageDTO.setPercentCompleted(percentCompleted);
    lineageDTO.setRequest(request);
    lineageDTO.setResults(results);
    lineageDTO.setSubmissionTime(submissionTime);
    lineageDTO.setUri(uri);
    return lineageDTO;
  }

  public static LineageDTOBuilder of(final LineageDTO lineageDTO) {
    final LineageDTOBuilder lineageDTOBuilder = new LineageDTOBuilder();
    lineageDTOBuilder.setExpiration(lineageDTO.getExpiration());
    lineageDTOBuilder.setFinished(lineageDTO.getFinished());
    lineageDTOBuilder.setId(lineageDTO.getId());
    lineageDTOBuilder.setPercentCompleted(lineageDTO.getPercentCompleted());
    lineageDTOBuilder.setRequest(lineageDTO.getRequest());
    lineageDTOBuilder.setResults(lineageDTO.getResults());
    lineageDTOBuilder.setSubmissionTime(lineageDTO.getSubmissionTime());
    lineageDTOBuilder.setUri(lineageDTO.getUri());
    return lineageDTOBuilder;
  }
}
