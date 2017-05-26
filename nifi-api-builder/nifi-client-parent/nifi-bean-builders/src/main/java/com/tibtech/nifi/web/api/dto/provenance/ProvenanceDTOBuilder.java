package com.tibtech.nifi.web.api.dto.provenance;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.function.Function;
import org.apache.nifi.web.api.dto.provenance.ProvenanceDTO;
import org.apache.nifi.web.api.dto.provenance.ProvenanceRequestDTO;
import org.apache.nifi.web.api.dto.provenance.ProvenanceResultsDTO;

public final class ProvenanceDTOBuilder {
  private Date expiration;

  private Boolean finished;

  private String id;

  private Integer percentCompleted;

  private ProvenanceRequestDTO request;

  private ProvenanceResultsDTO results;

  private Date submissionTime;

  private String uri;

  /**
   * The timestamp when the query will expire.
   */
  public Date getExpiration() {
    return expiration;
  }

  /**
   * The timestamp when the query will expire.
   */
  public ProvenanceDTOBuilder setExpiration(final Date expiration) {
    this.expiration = expiration;
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
  public ProvenanceDTOBuilder setFinished(final Boolean finished) {
    this.finished = finished;
    return this;
  }

  /**
   * The id of the provenance query.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the provenance query.
   */
  public ProvenanceDTOBuilder setId(final String id) {
    this.id = id;
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
  public ProvenanceDTOBuilder setPercentCompleted(final Integer percentCompleted) {
    this.percentCompleted = percentCompleted;
    return this;
  }

  /**
   * The provenance request.
   */
  public ProvenanceRequestDTO getRequest() {
    return request;
  }

  /**
   * The provenance request.
   */
  public ProvenanceDTOBuilder setRequest(final ProvenanceRequestDTO request) {
    this.request = request;
    return this;
  }

  /**
   * The provenance request.
   */
  public ProvenanceDTOBuilder setRequest(final Function<ProvenanceRequestDTOBuilder, ProvenanceRequestDTOBuilder> configurator) {
    return setRequest(configurator.apply(new ProvenanceRequestDTOBuilder()).build());
  }

  /**
   * The provenance request.
   */
  public ProvenanceDTOBuilder setRequest(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProvenanceRequestDTOBuilder.class) final Closure<ProvenanceRequestDTOBuilder> closure) {
    return setRequest(c -> {
      final Closure<ProvenanceRequestDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  /**
   * The provenance results.
   */
  public ProvenanceResultsDTO getResults() {
    return results;
  }

  /**
   * The provenance results.
   */
  public ProvenanceDTOBuilder setResults(final ProvenanceResultsDTO results) {
    this.results = results;
    return this;
  }

  /**
   * The provenance results.
   */
  public ProvenanceDTOBuilder setResults(final Function<ProvenanceResultsDTOBuilder, ProvenanceResultsDTOBuilder> configurator) {
    return setResults(configurator.apply(new ProvenanceResultsDTOBuilder()).build());
  }

  /**
   * The provenance results.
   */
  public ProvenanceDTOBuilder setResults(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProvenanceResultsDTOBuilder.class) final Closure<ProvenanceResultsDTOBuilder> closure) {
    return setResults(c -> {
      final Closure<ProvenanceResultsDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
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
  public ProvenanceDTOBuilder setSubmissionTime(final Date submissionTime) {
    this.submissionTime = submissionTime;
    return this;
  }

  /**
   * The URI for this query. Used for obtaining/deleting the request at a later time
   */
  public String getUri() {
    return uri;
  }

  /**
   * The URI for this query. Used for obtaining/deleting the request at a later time
   */
  public ProvenanceDTOBuilder setUri(final String uri) {
    this.uri = uri;
    return this;
  }

  public ProvenanceDTO build() {
    final ProvenanceDTO provenanceDTO = new ProvenanceDTO();
    provenanceDTO.setExpiration(expiration);
    provenanceDTO.setFinished(finished);
    provenanceDTO.setId(id);
    provenanceDTO.setPercentCompleted(percentCompleted);
    provenanceDTO.setRequest(request);
    provenanceDTO.setResults(results);
    provenanceDTO.setSubmissionTime(submissionTime);
    provenanceDTO.setUri(uri);
    return provenanceDTO;
  }

  public static ProvenanceDTOBuilder of(final ProvenanceDTO provenanceDTO) {
    final ProvenanceDTOBuilder provenanceDTOBuilder = new ProvenanceDTOBuilder();
    provenanceDTOBuilder.setExpiration(provenanceDTO.getExpiration());
    provenanceDTOBuilder.setFinished(provenanceDTO.isFinished());
    provenanceDTOBuilder.setId(provenanceDTO.getId());
    provenanceDTOBuilder.setPercentCompleted(provenanceDTO.getPercentCompleted());
    provenanceDTOBuilder.setRequest(provenanceDTO.getRequest());
    provenanceDTOBuilder.setResults(provenanceDTO.getResults());
    provenanceDTOBuilder.setSubmissionTime(provenanceDTO.getSubmissionTime());
    provenanceDTOBuilder.setUri(provenanceDTO.getUri());
    return provenanceDTOBuilder;
  }
}
