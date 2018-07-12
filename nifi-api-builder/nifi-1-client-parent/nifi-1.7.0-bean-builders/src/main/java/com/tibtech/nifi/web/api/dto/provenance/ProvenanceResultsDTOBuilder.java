package com.tibtech.nifi.web.api.dto.provenance;

import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.nifi.web.api.dto.provenance.ProvenanceEventDTO;
import org.apache.nifi.web.api.dto.provenance.ProvenanceResultsDTO;

public final class ProvenanceResultsDTOBuilder {
  private Set<String> errors;

  private Date generated;

  private Date oldestEvent;

  private List<ProvenanceEventDTO> provenanceEvents;

  private Integer timeOffset;

  private String total;

  private Long totalCount;

  /**
   * Any errors that occurred while performing the provenance request.
   */
  public Set<String> getErrors() {
    return errors;
  }

  /**
   * Any errors that occurred while performing the provenance request.
   */
  public ProvenanceResultsDTOBuilder setErrors(final Set<String> errors) {
    this.errors = errors;
    return this;
  }

  /**
   * Then the search was performed.
   */
  public Date getGenerated() {
    return generated;
  }

  /**
   * Then the search was performed.
   */
  public ProvenanceResultsDTOBuilder setGenerated(final Date generated) {
    this.generated = generated;
    return this;
  }

  /**
   * The oldest event available in the provenance repository.
   */
  public Date getOldestEvent() {
    return oldestEvent;
  }

  /**
   * The oldest event available in the provenance repository.
   */
  public ProvenanceResultsDTOBuilder setOldestEvent(final Date oldestEvent) {
    this.oldestEvent = oldestEvent;
    return this;
  }

  /**
   * The provenance events that matched the search criteria.
   */
  public List<ProvenanceEventDTO> getProvenanceEvents() {
    return provenanceEvents;
  }

  /**
   * The provenance events that matched the search criteria.
   */
  public ProvenanceResultsDTOBuilder setProvenanceEvents(
      final List<ProvenanceEventDTO> provenanceEvents) {
    this.provenanceEvents = provenanceEvents;
    return this;
  }

  /**
   * The time offset of the server that's used for event time.
   */
  public Integer getTimeOffset() {
    return timeOffset;
  }

  /**
   * The time offset of the server that's used for event time.
   */
  public ProvenanceResultsDTOBuilder setTimeOffset(final Integer timeOffset) {
    this.timeOffset = timeOffset;
    return this;
  }

  /**
   * The total number of results formatted.
   */
  public String getTotal() {
    return total;
  }

  /**
   * The total number of results formatted.
   */
  public ProvenanceResultsDTOBuilder setTotal(final String total) {
    this.total = total;
    return this;
  }

  /**
   * The total number of results.
   */
  public Long getTotalCount() {
    return totalCount;
  }

  /**
   * The total number of results.
   */
  public ProvenanceResultsDTOBuilder setTotalCount(final Long totalCount) {
    this.totalCount = totalCount;
    return this;
  }

  public ProvenanceResultsDTO build() {
    final ProvenanceResultsDTO provenanceResultsDTO = new ProvenanceResultsDTO();
    provenanceResultsDTO.setErrors(errors);
    provenanceResultsDTO.setGenerated(generated);
    provenanceResultsDTO.setOldestEvent(oldestEvent);
    provenanceResultsDTO.setProvenanceEvents(provenanceEvents);
    provenanceResultsDTO.setTimeOffset(timeOffset);
    provenanceResultsDTO.setTotal(total);
    provenanceResultsDTO.setTotalCount(totalCount);
    return provenanceResultsDTO;
  }

  public static ProvenanceResultsDTOBuilder of(final ProvenanceResultsDTO provenanceResultsDTO) {
    final ProvenanceResultsDTOBuilder provenanceResultsDTOBuilder = new ProvenanceResultsDTOBuilder();
    provenanceResultsDTOBuilder.setErrors(provenanceResultsDTO.getErrors());
    provenanceResultsDTOBuilder.setGenerated(provenanceResultsDTO.getGenerated());
    provenanceResultsDTOBuilder.setOldestEvent(provenanceResultsDTO.getOldestEvent());
    provenanceResultsDTOBuilder.setProvenanceEvents(provenanceResultsDTO.getProvenanceEvents());
    provenanceResultsDTOBuilder.setTimeOffset(provenanceResultsDTO.getTimeOffset());
    provenanceResultsDTOBuilder.setTotal(provenanceResultsDTO.getTotal());
    provenanceResultsDTOBuilder.setTotalCount(provenanceResultsDTO.getTotalCount());
    return provenanceResultsDTOBuilder;
  }
}
