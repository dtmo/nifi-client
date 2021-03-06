package com.tibtech.nifi.web.api.dto.provenance;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.Map;
import org.apache.nifi.web.api.dto.provenance.ProvenanceRequestDTO;

public final class ProvenanceRequestDTOBuilder {
  private String clusterNodeId;

  private Date endDate;

  private Boolean incrementalResults;

  private Integer maxResults;

  private String maximumFileSize;

  private String minimumFileSize;

  private Map<String, String> searchTerms;

  private Date startDate;

  private Boolean summarize;

  /**
   * The id of the node in the cluster where this provenance originated.
   */
  public String getClusterNodeId() {
    return clusterNodeId;
  }

  /**
   * The id of the node in the cluster where this provenance originated.
   */
  public ProvenanceRequestDTOBuilder setClusterNodeId(final String clusterNodeId) {
    this.clusterNodeId = clusterNodeId;
    return this;
  }

  /**
   * The latest event time to include in the query.
   */
  public Date getEndDate() {
    return endDate;
  }

  /**
   * The latest event time to include in the query.
   */
  public ProvenanceRequestDTOBuilder setEndDate(final Date endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Whether or not incremental results are returned. If false, provenance events are only returned once the query completes. This property is true by default.
   */
  public Boolean getIncrementalResults() {
    return incrementalResults;
  }

  /**
   * Whether or not incremental results are returned. If false, provenance events are only returned once the query completes. This property is true by default.
   */
  public ProvenanceRequestDTOBuilder setIncrementalResults(final Boolean incrementalResults) {
    this.incrementalResults = incrementalResults;
    return this;
  }

  /**
   * The maximum number of results to include.
   */
  public Integer getMaxResults() {
    return maxResults;
  }

  /**
   * The maximum number of results to include.
   */
  public ProvenanceRequestDTOBuilder setMaxResults(final Integer maxResults) {
    this.maxResults = maxResults;
    return this;
  }

  /**
   * The maximum file size to include in the query.
   */
  public String getMaximumFileSize() {
    return maximumFileSize;
  }

  /**
   * The maximum file size to include in the query.
   */
  public ProvenanceRequestDTOBuilder setMaximumFileSize(final String maximumFileSize) {
    this.maximumFileSize = maximumFileSize;
    return this;
  }

  /**
   * The minimum file size to include in the query.
   */
  public String getMinimumFileSize() {
    return minimumFileSize;
  }

  /**
   * The minimum file size to include in the query.
   */
  public ProvenanceRequestDTOBuilder setMinimumFileSize(final String minimumFileSize) {
    this.minimumFileSize = minimumFileSize;
    return this;
  }

  /**
   * The search terms used to perform the search.
   */
  public Map<String, String> getSearchTerms() {
    return searchTerms;
  }

  /**
   * The search terms used to perform the search.
   */
  public ProvenanceRequestDTOBuilder setSearchTerms(final Map<String, String> searchTerms) {
    this.searchTerms = searchTerms;
    return this;
  }

  /**
   * The earliest event time to include in the query.
   */
  public Date getStartDate() {
    return startDate;
  }

  /**
   * The earliest event time to include in the query.
   */
  public ProvenanceRequestDTOBuilder setStartDate(final Date startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Whether or not to summarize provenance events returned. This property is false by default.
   */
  public Boolean getSummarize() {
    return summarize;
  }

  /**
   * Whether or not to summarize provenance events returned. This property is false by default.
   */
  public ProvenanceRequestDTOBuilder setSummarize(final Boolean summarize) {
    this.summarize = summarize;
    return this;
  }

  public ProvenanceRequestDTO build() {
    final ProvenanceRequestDTO provenanceRequestDTO = new ProvenanceRequestDTO();
    provenanceRequestDTO.setClusterNodeId(clusterNodeId);
    provenanceRequestDTO.setEndDate(endDate);
    provenanceRequestDTO.setIncrementalResults(incrementalResults);
    provenanceRequestDTO.setMaxResults(maxResults);
    provenanceRequestDTO.setMaximumFileSize(maximumFileSize);
    provenanceRequestDTO.setMinimumFileSize(minimumFileSize);
    provenanceRequestDTO.setSearchTerms(searchTerms);
    provenanceRequestDTO.setStartDate(startDate);
    provenanceRequestDTO.setSummarize(summarize);
    return provenanceRequestDTO;
  }

  public static ProvenanceRequestDTOBuilder of(final ProvenanceRequestDTO provenanceRequestDTO) {
    final ProvenanceRequestDTOBuilder provenanceRequestDTOBuilder = new ProvenanceRequestDTOBuilder();
    provenanceRequestDTOBuilder.setClusterNodeId(provenanceRequestDTO.getClusterNodeId());
    provenanceRequestDTOBuilder.setEndDate(provenanceRequestDTO.getEndDate());
    provenanceRequestDTOBuilder.setIncrementalResults(provenanceRequestDTO.getIncrementalResults());
    provenanceRequestDTOBuilder.setMaxResults(provenanceRequestDTO.getMaxResults());
    provenanceRequestDTOBuilder.setMaximumFileSize(provenanceRequestDTO.getMaximumFileSize());
    provenanceRequestDTOBuilder.setMinimumFileSize(provenanceRequestDTO.getMinimumFileSize());
    provenanceRequestDTOBuilder.setSearchTerms(provenanceRequestDTO.getSearchTerms());
    provenanceRequestDTOBuilder.setStartDate(provenanceRequestDTO.getStartDate());
    provenanceRequestDTOBuilder.setSummarize(provenanceRequestDTO.getSummarize());
    return provenanceRequestDTOBuilder;
  }
}
