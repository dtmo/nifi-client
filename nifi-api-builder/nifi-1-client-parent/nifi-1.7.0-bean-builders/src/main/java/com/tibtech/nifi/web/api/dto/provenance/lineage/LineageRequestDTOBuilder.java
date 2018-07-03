package com.tibtech.nifi.web.api.dto.provenance.lineage;

import java.lang.Long;
import java.lang.String;
import org.apache.nifi.web.api.dto.provenance.lineage.LineageRequestDTO;

public final class LineageRequestDTOBuilder {
  private String clusterNodeId;

  private Long eventId;

  private LineageRequestDTO.LineageRequestType lineageRequestType;

  private String uuid;

  /**
   * The id of the node where this lineage originated if clustered.
   */
  public String getClusterNodeId() {
    return clusterNodeId;
  }

  /**
   * The id of the node where this lineage originated if clustered.
   */
  public LineageRequestDTOBuilder setClusterNodeId(final String clusterNodeId) {
    this.clusterNodeId = clusterNodeId;
    return this;
  }

  /**
   * The event id that was used to generate this lineage, if applicable. The event id is allowed for any type of lineageRequestType. If the lineageRequestType is FLOWFILE and the flowfile uuid is also included in the request, the event id will be ignored.
   */
  public Long getEventId() {
    return eventId;
  }

  /**
   * The event id that was used to generate this lineage, if applicable. The event id is allowed for any type of lineageRequestType. If the lineageRequestType is FLOWFILE and the flowfile uuid is also included in the request, the event id will be ignored.
   */
  public LineageRequestDTOBuilder setEventId(final Long eventId) {
    this.eventId = eventId;
    return this;
  }

  /**
   * The type of lineage request. PARENTS will return the lineage for the flowfiles that are parents of the specified event. CHILDREN will return the lineage for the flowfiles that are children of the specified event. FLOWFILE will return the lineage for the specified flowfile.
   */
  public LineageRequestDTO.LineageRequestType getLineageRequestType() {
    return lineageRequestType;
  }

  /**
   * The type of lineage request. PARENTS will return the lineage for the flowfiles that are parents of the specified event. CHILDREN will return the lineage for the flowfiles that are children of the specified event. FLOWFILE will return the lineage for the specified flowfile.
   */
  public LineageRequestDTOBuilder setLineageRequestType(final LineageRequestDTO.LineageRequestType lineageRequestType) {
    this.lineageRequestType = lineageRequestType;
    return this;
  }

  /**
   * The flowfile uuid that was used to generate the lineage. The flowfile uuid is only allowed when the lineageRequestType is FLOWFILE and will take precedence over event id.
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * The flowfile uuid that was used to generate the lineage. The flowfile uuid is only allowed when the lineageRequestType is FLOWFILE and will take precedence over event id.
   */
  public LineageRequestDTOBuilder setUuid(final String uuid) {
    this.uuid = uuid;
    return this;
  }

  public LineageRequestDTO build() {
    final LineageRequestDTO lineageRequestDTO = new LineageRequestDTO();
    lineageRequestDTO.setClusterNodeId(clusterNodeId);
    lineageRequestDTO.setEventId(eventId);
    lineageRequestDTO.setLineageRequestType(lineageRequestType);
    lineageRequestDTO.setUuid(uuid);
    return lineageRequestDTO;
  }

  public static LineageRequestDTOBuilder of(final LineageRequestDTO lineageRequestDTO) {
    final LineageRequestDTOBuilder lineageRequestDTOBuilder = new LineageRequestDTOBuilder();
    lineageRequestDTOBuilder.setClusterNodeId(lineageRequestDTO.getClusterNodeId());
    lineageRequestDTOBuilder.setEventId(lineageRequestDTO.getEventId());
    lineageRequestDTOBuilder.setLineageRequestType(lineageRequestDTO.getLineageRequestType());
    lineageRequestDTOBuilder.setUuid(lineageRequestDTO.getUuid());
    return lineageRequestDTOBuilder;
  }
}
