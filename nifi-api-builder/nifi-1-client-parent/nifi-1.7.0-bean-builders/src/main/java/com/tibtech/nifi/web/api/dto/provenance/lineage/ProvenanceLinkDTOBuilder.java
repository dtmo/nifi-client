package com.tibtech.nifi.web.api.dto.provenance.lineage;

import java.lang.Long;
import java.lang.String;
import java.util.Date;
import org.apache.nifi.web.api.dto.provenance.lineage.ProvenanceLinkDTO;

public final class ProvenanceLinkDTOBuilder {
  private String flowFileUuid;

  private Long millis;

  private String sourceId;

  private String targetId;

  private Date timestamp;

  /**
   * The flowfile uuid that traversed the link.
   */
  public String getFlowFileUuid() {
    return flowFileUuid;
  }

  /**
   * The flowfile uuid that traversed the link.
   */
  public ProvenanceLinkDTOBuilder setFlowFileUuid(final String flowFileUuid) {
    this.flowFileUuid = flowFileUuid;
    return this;
  }

  /**
   * The timestamp of this link in milliseconds.
   */
  public Long getMillis() {
    return millis;
  }

  /**
   * The timestamp of this link in milliseconds.
   */
  public ProvenanceLinkDTOBuilder setMillis(final Long millis) {
    this.millis = millis;
    return this;
  }

  /**
   * The source node id of the link.
   */
  public String getSourceId() {
    return sourceId;
  }

  /**
   * The source node id of the link.
   */
  public ProvenanceLinkDTOBuilder setSourceId(final String sourceId) {
    this.sourceId = sourceId;
    return this;
  }

  /**
   * The target node id of the link.
   */
  public String getTargetId() {
    return targetId;
  }

  /**
   * The target node id of the link.
   */
  public ProvenanceLinkDTOBuilder setTargetId(final String targetId) {
    this.targetId = targetId;
    return this;
  }

  /**
   * The timestamp of the link (based on the destination).
   */
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * The timestamp of the link (based on the destination).
   */
  public ProvenanceLinkDTOBuilder setTimestamp(final Date timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  public ProvenanceLinkDTO build() {
    final ProvenanceLinkDTO provenanceLinkDTO = new ProvenanceLinkDTO();
    provenanceLinkDTO.setFlowFileUuid(flowFileUuid);
    provenanceLinkDTO.setMillis(millis);
    provenanceLinkDTO.setSourceId(sourceId);
    provenanceLinkDTO.setTargetId(targetId);
    provenanceLinkDTO.setTimestamp(timestamp);
    return provenanceLinkDTO;
  }

  public static ProvenanceLinkDTOBuilder of(final ProvenanceLinkDTO provenanceLinkDTO) {
    final ProvenanceLinkDTOBuilder provenanceLinkDTOBuilder = new ProvenanceLinkDTOBuilder();
    provenanceLinkDTOBuilder.setFlowFileUuid(provenanceLinkDTO.getFlowFileUuid());
    provenanceLinkDTOBuilder.setMillis(provenanceLinkDTO.getMillis());
    provenanceLinkDTOBuilder.setSourceId(provenanceLinkDTO.getSourceId());
    provenanceLinkDTOBuilder.setTargetId(provenanceLinkDTO.getTargetId());
    provenanceLinkDTOBuilder.setTimestamp(provenanceLinkDTO.getTimestamp());
    return provenanceLinkDTOBuilder;
  }
}
