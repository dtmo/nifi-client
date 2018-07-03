package com.tibtech.nifi.web.api.dto.provenance.lineage;

import java.lang.Long;
import java.lang.String;
import java.util.Date;
import java.util.List;
import org.apache.nifi.web.api.dto.provenance.lineage.ProvenanceNodeDTO;

public final class ProvenanceNodeDTOBuilder {
  private List<String> childUuids;

  private String clusterNodeIdentifier;

  private String eventType;

  private String flowFileUuid;

  private String id;

  private Long millis;

  private List<String> parentUuids;

  private Date timestamp;

  private String type;

  /**
   * The uuid of the childrent flowfiles of the provenance event.
   */
  public List<String> getChildUuids() {
    return childUuids;
  }

  /**
   * The uuid of the childrent flowfiles of the provenance event.
   */
  public ProvenanceNodeDTOBuilder setChildUuids(final List<String> childUuids) {
    this.childUuids = childUuids;
    return this;
  }

  /**
   * The identifier of the node that this event/flowfile originated from.
   */
  public String getClusterNodeIdentifier() {
    return clusterNodeIdentifier;
  }

  /**
   * The identifier of the node that this event/flowfile originated from.
   */
  public ProvenanceNodeDTOBuilder setClusterNodeIdentifier(final String clusterNodeIdentifier) {
    this.clusterNodeIdentifier = clusterNodeIdentifier;
    return this;
  }

  /**
   * If the type is EVENT, this is the type of event.
   */
  public String getEventType() {
    return eventType;
  }

  /**
   * If the type is EVENT, this is the type of event.
   */
  public ProvenanceNodeDTOBuilder setEventType(final String eventType) {
    this.eventType = eventType;
    return this;
  }

  /**
   * The uuid of the flowfile associated with the provenance event.
   */
  public String getFlowFileUuid() {
    return flowFileUuid;
  }

  /**
   * The uuid of the flowfile associated with the provenance event.
   */
  public ProvenanceNodeDTOBuilder setFlowFileUuid(final String flowFileUuid) {
    this.flowFileUuid = flowFileUuid;
    return this;
  }

  /**
   * The id of the node.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the node.
   */
  public ProvenanceNodeDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The timestamp of the node in milliseconds.
   */
  public Long getMillis() {
    return millis;
  }

  /**
   * The timestamp of the node in milliseconds.
   */
  public ProvenanceNodeDTOBuilder setMillis(final Long millis) {
    this.millis = millis;
    return this;
  }

  /**
   * The uuid of the parent flowfiles of the provenance event.
   */
  public List<String> getParentUuids() {
    return parentUuids;
  }

  /**
   * The uuid of the parent flowfiles of the provenance event.
   */
  public ProvenanceNodeDTOBuilder setParentUuids(final List<String> parentUuids) {
    this.parentUuids = parentUuids;
    return this;
  }

  /**
   * The timestamp of the node formatted.
   */
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * The timestamp of the node formatted.
   */
  public ProvenanceNodeDTOBuilder setTimestamp(final Date timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * The type of the node.
   */
  public String getType() {
    return type;
  }

  /**
   * The type of the node.
   */
  public ProvenanceNodeDTOBuilder setType(final String type) {
    this.type = type;
    return this;
  }

  public ProvenanceNodeDTO build() {
    final ProvenanceNodeDTO provenanceNodeDTO = new ProvenanceNodeDTO();
    provenanceNodeDTO.setChildUuids(childUuids);
    provenanceNodeDTO.setClusterNodeIdentifier(clusterNodeIdentifier);
    provenanceNodeDTO.setEventType(eventType);
    provenanceNodeDTO.setFlowFileUuid(flowFileUuid);
    provenanceNodeDTO.setId(id);
    provenanceNodeDTO.setMillis(millis);
    provenanceNodeDTO.setParentUuids(parentUuids);
    provenanceNodeDTO.setTimestamp(timestamp);
    provenanceNodeDTO.setType(type);
    return provenanceNodeDTO;
  }

  public static ProvenanceNodeDTOBuilder of(final ProvenanceNodeDTO provenanceNodeDTO) {
    final ProvenanceNodeDTOBuilder provenanceNodeDTOBuilder = new ProvenanceNodeDTOBuilder();
    provenanceNodeDTOBuilder.setChildUuids(provenanceNodeDTO.getChildUuids());
    provenanceNodeDTOBuilder.setClusterNodeIdentifier(provenanceNodeDTO.getClusterNodeIdentifier());
    provenanceNodeDTOBuilder.setEventType(provenanceNodeDTO.getEventType());
    provenanceNodeDTOBuilder.setFlowFileUuid(provenanceNodeDTO.getFlowFileUuid());
    provenanceNodeDTOBuilder.setId(provenanceNodeDTO.getId());
    provenanceNodeDTOBuilder.setMillis(provenanceNodeDTO.getMillis());
    provenanceNodeDTOBuilder.setParentUuids(provenanceNodeDTO.getParentUuids());
    provenanceNodeDTOBuilder.setTimestamp(provenanceNodeDTO.getTimestamp());
    provenanceNodeDTOBuilder.setType(provenanceNodeDTO.getType());
    return provenanceNodeDTOBuilder;
  }
}
