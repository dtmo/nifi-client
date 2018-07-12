package com.tibtech.nifi.web.api.dto.provenance;

import java.lang.Boolean;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import org.apache.nifi.web.api.dto.provenance.AttributeDTO;
import org.apache.nifi.web.api.dto.provenance.ProvenanceEventDTO;

public final class ProvenanceEventDTOBuilder {
  private String alternateIdentifierUri;

  private Collection<AttributeDTO> attributes;

  private List<String> childUuids;

  private String clusterNodeAddress;

  private String clusterNodeId;

  private String componentId;

  private String componentName;

  private String componentType;

  private Boolean contentEqual;

  private String details;

  private Long eventDuration;

  private Long eventId;

  private Date eventTime;

  private String eventType;

  private String fileSize;

  private Long fileSizeBytes;

  private String flowFileUuid;

  private String groupId;

  private String id;

  private Boolean inputContentAvailable;

  private String inputContentClaimContainer;

  private String inputContentClaimFileSize;

  private Long inputContentClaimFileSizeBytes;

  private String inputContentClaimIdentifier;

  private Long inputContentClaimOffset;

  private String inputContentClaimSection;

  private Long lineageDuration;

  private Boolean outputContentAvailable;

  private String outputContentClaimContainer;

  private String outputContentClaimFileSize;

  private Long outputContentClaimFileSizeBytes;

  private String outputContentClaimIdentifier;

  private Long outputContentClaimOffset;

  private String outputContentClaimSection;

  private List<String> parentUuids;

  private String relationship;

  private Boolean replayAvailable;

  private String replayExplanation;

  private String sourceConnectionIdentifier;

  private String sourceSystemFlowFileId;

  private String transitUri;

  /**
   * The alternate identifier uri for the fileflow for the event.
   */
  public String getAlternateIdentifierUri() {
    return alternateIdentifierUri;
  }

  /**
   * The alternate identifier uri for the fileflow for the event.
   */
  public ProvenanceEventDTOBuilder setAlternateIdentifierUri(final String alternateIdentifierUri) {
    this.alternateIdentifierUri = alternateIdentifierUri;
    return this;
  }

  /**
   * The attributes of the flowfile for the event.
   */
  public Collection<AttributeDTO> getAttributes() {
    return attributes;
  }

  /**
   * The attributes of the flowfile for the event.
   */
  public ProvenanceEventDTOBuilder setAttributes(final Collection<AttributeDTO> attributes) {
    this.attributes = attributes;
    return this;
  }

  /**
   * The child uuids for the event.
   */
  public List<String> getChildUuids() {
    return childUuids;
  }

  /**
   * The child uuids for the event.
   */
  public ProvenanceEventDTOBuilder setChildUuids(final List<String> childUuids) {
    this.childUuids = childUuids;
    return this;
  }

  /**
   * The label for the node where the event originated.
   */
  public String getClusterNodeAddress() {
    return clusterNodeAddress;
  }

  /**
   * The label for the node where the event originated.
   */
  public ProvenanceEventDTOBuilder setClusterNodeAddress(final String clusterNodeAddress) {
    this.clusterNodeAddress = clusterNodeAddress;
    return this;
  }

  /**
   * The identifier for the node where the event originated.
   */
  public String getClusterNodeId() {
    return clusterNodeId;
  }

  /**
   * The identifier for the node where the event originated.
   */
  public ProvenanceEventDTOBuilder setClusterNodeId(final String clusterNodeId) {
    this.clusterNodeId = clusterNodeId;
    return this;
  }

  /**
   * The id of the component that generated the event.
   */
  public String getComponentId() {
    return componentId;
  }

  /**
   * The id of the component that generated the event.
   */
  public ProvenanceEventDTOBuilder setComponentId(final String componentId) {
    this.componentId = componentId;
    return this;
  }

  /**
   * The name of the component that generated the event.
   */
  public String getComponentName() {
    return componentName;
  }

  /**
   * The name of the component that generated the event.
   */
  public ProvenanceEventDTOBuilder setComponentName(final String componentName) {
    this.componentName = componentName;
    return this;
  }

  /**
   * The type of the component that generated the event.
   */
  public String getComponentType() {
    return componentType;
  }

  /**
   * The type of the component that generated the event.
   */
  public ProvenanceEventDTOBuilder setComponentType(final String componentType) {
    this.componentType = componentType;
    return this;
  }

  /**
   * Whether the input and output content claim is the same.
   */
  public Boolean getContentEqual() {
    return contentEqual;
  }

  /**
   * Whether the input and output content claim is the same.
   */
  public ProvenanceEventDTOBuilder setContentEqual(final Boolean contentEqual) {
    this.contentEqual = contentEqual;
    return this;
  }

  /**
   * The event details.
   */
  public String getDetails() {
    return details;
  }

  /**
   * The event details.
   */
  public ProvenanceEventDTOBuilder setDetails(final String details) {
    this.details = details;
    return this;
  }

  /**
   * The event duration in milliseconds.
   */
  public Long getEventDuration() {
    return eventDuration;
  }

  /**
   * The event duration in milliseconds.
   */
  public ProvenanceEventDTOBuilder setEventDuration(final Long eventDuration) {
    this.eventDuration = eventDuration;
    return this;
  }

  /**
   * The event id. This is a one up number thats unique per node.
   */
  public Long getEventId() {
    return eventId;
  }

  /**
   * The event id. This is a one up number thats unique per node.
   */
  public ProvenanceEventDTOBuilder setEventId(final Long eventId) {
    this.eventId = eventId;
    return this;
  }

  /**
   * The timestamp of the event.
   */
  public Date getEventTime() {
    return eventTime;
  }

  /**
   * The timestamp of the event.
   */
  public ProvenanceEventDTOBuilder setEventTime(final Date eventTime) {
    this.eventTime = eventTime;
    return this;
  }

  /**
   * The type of the event.
   */
  public String getEventType() {
    return eventType;
  }

  /**
   * The type of the event.
   */
  public ProvenanceEventDTOBuilder setEventType(final String eventType) {
    this.eventType = eventType;
    return this;
  }

  /**
   * The size of the flowfile for the event.
   */
  public String getFileSize() {
    return fileSize;
  }

  /**
   * The size of the flowfile for the event.
   */
  public ProvenanceEventDTOBuilder setFileSize(final String fileSize) {
    this.fileSize = fileSize;
    return this;
  }

  /**
   * The size of the flowfile in bytes for the event.
   */
  public Long getFileSizeBytes() {
    return fileSizeBytes;
  }

  /**
   * The size of the flowfile in bytes for the event.
   */
  public ProvenanceEventDTOBuilder setFileSizeBytes(final Long fileSizeBytes) {
    this.fileSizeBytes = fileSizeBytes;
    return this;
  }

  /**
   * The uuid of the flowfile for the event.
   */
  public String getFlowFileUuid() {
    return flowFileUuid;
  }

  /**
   * The uuid of the flowfile for the event.
   */
  public ProvenanceEventDTOBuilder setFlowFileUuid(final String flowFileUuid) {
    this.flowFileUuid = flowFileUuid;
    return this;
  }

  /**
   * The id of the group that the component resides in. If the component is no longer in the flow, the group id will not be set.
   */
  public String getGroupId() {
    return groupId;
  }

  /**
   * The id of the group that the component resides in. If the component is no longer in the flow, the group id will not be set.
   */
  public ProvenanceEventDTOBuilder setGroupId(final String groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * The event uuid.
   */
  public String getId() {
    return id;
  }

  /**
   * The event uuid.
   */
  public ProvenanceEventDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * Whether the input content is still available.
   */
  public Boolean getInputContentAvailable() {
    return inputContentAvailable;
  }

  /**
   * Whether the input content is still available.
   */
  public ProvenanceEventDTOBuilder setInputContentAvailable(final Boolean inputContentAvailable) {
    this.inputContentAvailable = inputContentAvailable;
    return this;
  }

  /**
   * The container in which the input content claim lives.
   */
  public String getInputContentClaimContainer() {
    return inputContentClaimContainer;
  }

  /**
   * The container in which the input content claim lives.
   */
  public ProvenanceEventDTOBuilder setInputContentClaimContainer(
      final String inputContentClaimContainer) {
    this.inputContentClaimContainer = inputContentClaimContainer;
    return this;
  }

  /**
   * The file size of the input content claim formatted.
   */
  public String getInputContentClaimFileSize() {
    return inputContentClaimFileSize;
  }

  /**
   * The file size of the input content claim formatted.
   */
  public ProvenanceEventDTOBuilder setInputContentClaimFileSize(
      final String inputContentClaimFileSize) {
    this.inputContentClaimFileSize = inputContentClaimFileSize;
    return this;
  }

  /**
   * The file size of the intput content claim in bytes.
   */
  public Long getInputContentClaimFileSizeBytes() {
    return inputContentClaimFileSizeBytes;
  }

  /**
   * The file size of the intput content claim in bytes.
   */
  public ProvenanceEventDTOBuilder setInputContentClaimFileSizeBytes(
      final Long inputContentClaimFileSizeBytes) {
    this.inputContentClaimFileSizeBytes = inputContentClaimFileSizeBytes;
    return this;
  }

  /**
   * The identifier of the input content claim.
   */
  public String getInputContentClaimIdentifier() {
    return inputContentClaimIdentifier;
  }

  /**
   * The identifier of the input content claim.
   */
  public ProvenanceEventDTOBuilder setInputContentClaimIdentifier(
      final String inputContentClaimIdentifier) {
    this.inputContentClaimIdentifier = inputContentClaimIdentifier;
    return this;
  }

  /**
   * The offset into the input content claim where the flowfiles content begins.
   */
  public Long getInputContentClaimOffset() {
    return inputContentClaimOffset;
  }

  /**
   * The offset into the input content claim where the flowfiles content begins.
   */
  public ProvenanceEventDTOBuilder setInputContentClaimOffset(final Long inputContentClaimOffset) {
    this.inputContentClaimOffset = inputContentClaimOffset;
    return this;
  }

  /**
   * The section in which the input content claim lives.
   */
  public String getInputContentClaimSection() {
    return inputContentClaimSection;
  }

  /**
   * The section in which the input content claim lives.
   */
  public ProvenanceEventDTOBuilder setInputContentClaimSection(
      final String inputContentClaimSection) {
    this.inputContentClaimSection = inputContentClaimSection;
    return this;
  }

  /**
   * The duration since the lineage began, in milliseconds.
   */
  public Long getLineageDuration() {
    return lineageDuration;
  }

  /**
   * The duration since the lineage began, in milliseconds.
   */
  public ProvenanceEventDTOBuilder setLineageDuration(final Long lineageDuration) {
    this.lineageDuration = lineageDuration;
    return this;
  }

  /**
   * Whether the output content is still available.
   */
  public Boolean getOutputContentAvailable() {
    return outputContentAvailable;
  }

  /**
   * Whether the output content is still available.
   */
  public ProvenanceEventDTOBuilder setOutputContentAvailable(final Boolean outputContentAvailable) {
    this.outputContentAvailable = outputContentAvailable;
    return this;
  }

  /**
   * The container in which the output content claim lives.
   */
  public String getOutputContentClaimContainer() {
    return outputContentClaimContainer;
  }

  /**
   * The container in which the output content claim lives.
   */
  public ProvenanceEventDTOBuilder setOutputContentClaimContainer(
      final String outputContentClaimContainer) {
    this.outputContentClaimContainer = outputContentClaimContainer;
    return this;
  }

  /**
   * The file size of the output content claim formatted.
   */
  public String getOutputContentClaimFileSize() {
    return outputContentClaimFileSize;
  }

  /**
   * The file size of the output content claim formatted.
   */
  public ProvenanceEventDTOBuilder setOutputContentClaimFileSize(
      final String outputContentClaimFileSize) {
    this.outputContentClaimFileSize = outputContentClaimFileSize;
    return this;
  }

  /**
   * The file size of the output content claim in bytes.
   */
  public Long getOutputContentClaimFileSizeBytes() {
    return outputContentClaimFileSizeBytes;
  }

  /**
   * The file size of the output content claim in bytes.
   */
  public ProvenanceEventDTOBuilder setOutputContentClaimFileSizeBytes(
      final Long outputContentClaimFileSizeBytes) {
    this.outputContentClaimFileSizeBytes = outputContentClaimFileSizeBytes;
    return this;
  }

  /**
   * The identifier of the output content claim.
   */
  public String getOutputContentClaimIdentifier() {
    return outputContentClaimIdentifier;
  }

  /**
   * The identifier of the output content claim.
   */
  public ProvenanceEventDTOBuilder setOutputContentClaimIdentifier(
      final String outputContentClaimIdentifier) {
    this.outputContentClaimIdentifier = outputContentClaimIdentifier;
    return this;
  }

  /**
   * The offset into the output content claim where the flowfiles content begins.
   */
  public Long getOutputContentClaimOffset() {
    return outputContentClaimOffset;
  }

  /**
   * The offset into the output content claim where the flowfiles content begins.
   */
  public ProvenanceEventDTOBuilder setOutputContentClaimOffset(
      final Long outputContentClaimOffset) {
    this.outputContentClaimOffset = outputContentClaimOffset;
    return this;
  }

  /**
   * The section in which the output content claim lives.
   */
  public String getOutputContentClaimSection() {
    return outputContentClaimSection;
  }

  /**
   * The section in which the output content claim lives.
   */
  public ProvenanceEventDTOBuilder setOutputContentClaimSection(
      final String outputContentClaimSection) {
    this.outputContentClaimSection = outputContentClaimSection;
    return this;
  }

  /**
   * The parent uuids for the event.
   */
  public List<String> getParentUuids() {
    return parentUuids;
  }

  /**
   * The parent uuids for the event.
   */
  public ProvenanceEventDTOBuilder setParentUuids(final List<String> parentUuids) {
    this.parentUuids = parentUuids;
    return this;
  }

  /**
   * The relationship to which the flowfile was routed if the event is of type ROUTE.
   */
  public String getRelationship() {
    return relationship;
  }

  /**
   * The relationship to which the flowfile was routed if the event is of type ROUTE.
   */
  public ProvenanceEventDTOBuilder setRelationship(final String relationship) {
    this.relationship = relationship;
    return this;
  }

  /**
   * Whether or not replay is available.
   */
  public Boolean getReplayAvailable() {
    return replayAvailable;
  }

  /**
   * Whether or not replay is available.
   */
  public ProvenanceEventDTOBuilder setReplayAvailable(final Boolean replayAvailable) {
    this.replayAvailable = replayAvailable;
    return this;
  }

  /**
   * Explanation as to why replay is unavailable.
   */
  public String getReplayExplanation() {
    return replayExplanation;
  }

  /**
   * Explanation as to why replay is unavailable.
   */
  public ProvenanceEventDTOBuilder setReplayExplanation(final String replayExplanation) {
    this.replayExplanation = replayExplanation;
    return this;
  }

  /**
   * The identifier of the queue/connection from which the flowfile was pulled to genereate this event. May be null if the queue/connection is unknown or the flowfile was generated from this event.
   */
  public String getSourceConnectionIdentifier() {
    return sourceConnectionIdentifier;
  }

  /**
   * The identifier of the queue/connection from which the flowfile was pulled to genereate this event. May be null if the queue/connection is unknown or the flowfile was generated from this event.
   */
  public ProvenanceEventDTOBuilder setSourceConnectionIdentifier(
      final String sourceConnectionIdentifier) {
    this.sourceConnectionIdentifier = sourceConnectionIdentifier;
    return this;
  }

  /**
   * The source system flowfile id.
   */
  public String getSourceSystemFlowFileId() {
    return sourceSystemFlowFileId;
  }

  /**
   * The source system flowfile id.
   */
  public ProvenanceEventDTOBuilder setSourceSystemFlowFileId(final String sourceSystemFlowFileId) {
    this.sourceSystemFlowFileId = sourceSystemFlowFileId;
    return this;
  }

  /**
   * The source/destination system uri if the event was a RECEIVE/SEND.
   */
  public String getTransitUri() {
    return transitUri;
  }

  /**
   * The source/destination system uri if the event was a RECEIVE/SEND.
   */
  public ProvenanceEventDTOBuilder setTransitUri(final String transitUri) {
    this.transitUri = transitUri;
    return this;
  }

  public ProvenanceEventDTO build() {
    final ProvenanceEventDTO provenanceEventDTO = new ProvenanceEventDTO();
    provenanceEventDTO.setAlternateIdentifierUri(alternateIdentifierUri);
    provenanceEventDTO.setAttributes(attributes);
    provenanceEventDTO.setChildUuids(childUuids);
    provenanceEventDTO.setClusterNodeAddress(clusterNodeAddress);
    provenanceEventDTO.setClusterNodeId(clusterNodeId);
    provenanceEventDTO.setComponentId(componentId);
    provenanceEventDTO.setComponentName(componentName);
    provenanceEventDTO.setComponentType(componentType);
    provenanceEventDTO.setContentEqual(contentEqual);
    provenanceEventDTO.setDetails(details);
    provenanceEventDTO.setEventDuration(eventDuration);
    provenanceEventDTO.setEventId(eventId);
    provenanceEventDTO.setEventTime(eventTime);
    provenanceEventDTO.setEventType(eventType);
    provenanceEventDTO.setFileSize(fileSize);
    provenanceEventDTO.setFileSizeBytes(fileSizeBytes);
    provenanceEventDTO.setFlowFileUuid(flowFileUuid);
    provenanceEventDTO.setGroupId(groupId);
    provenanceEventDTO.setId(id);
    provenanceEventDTO.setInputContentAvailable(inputContentAvailable);
    provenanceEventDTO.setInputContentClaimContainer(inputContentClaimContainer);
    provenanceEventDTO.setInputContentClaimFileSize(inputContentClaimFileSize);
    provenanceEventDTO.setInputContentClaimFileSizeBytes(inputContentClaimFileSizeBytes);
    provenanceEventDTO.setInputContentClaimIdentifier(inputContentClaimIdentifier);
    provenanceEventDTO.setInputContentClaimOffset(inputContentClaimOffset);
    provenanceEventDTO.setInputContentClaimSection(inputContentClaimSection);
    provenanceEventDTO.setLineageDuration(lineageDuration);
    provenanceEventDTO.setOutputContentAvailable(outputContentAvailable);
    provenanceEventDTO.setOutputContentClaimContainer(outputContentClaimContainer);
    provenanceEventDTO.setOutputContentClaimFileSize(outputContentClaimFileSize);
    provenanceEventDTO.setOutputContentClaimFileSizeBytes(outputContentClaimFileSizeBytes);
    provenanceEventDTO.setOutputContentClaimIdentifier(outputContentClaimIdentifier);
    provenanceEventDTO.setOutputContentClaimOffset(outputContentClaimOffset);
    provenanceEventDTO.setOutputContentClaimSection(outputContentClaimSection);
    provenanceEventDTO.setParentUuids(parentUuids);
    provenanceEventDTO.setRelationship(relationship);
    provenanceEventDTO.setReplayAvailable(replayAvailable);
    provenanceEventDTO.setReplayExplanation(replayExplanation);
    provenanceEventDTO.setSourceConnectionIdentifier(sourceConnectionIdentifier);
    provenanceEventDTO.setSourceSystemFlowFileId(sourceSystemFlowFileId);
    provenanceEventDTO.setTransitUri(transitUri);
    return provenanceEventDTO;
  }

  public static ProvenanceEventDTOBuilder of(final ProvenanceEventDTO provenanceEventDTO) {
    final ProvenanceEventDTOBuilder provenanceEventDTOBuilder = new ProvenanceEventDTOBuilder();
    provenanceEventDTOBuilder.setAlternateIdentifierUri(provenanceEventDTO.getAlternateIdentifierUri());
    provenanceEventDTOBuilder.setAttributes(provenanceEventDTO.getAttributes());
    provenanceEventDTOBuilder.setChildUuids(provenanceEventDTO.getChildUuids());
    provenanceEventDTOBuilder.setClusterNodeAddress(provenanceEventDTO.getClusterNodeAddress());
    provenanceEventDTOBuilder.setClusterNodeId(provenanceEventDTO.getClusterNodeId());
    provenanceEventDTOBuilder.setComponentId(provenanceEventDTO.getComponentId());
    provenanceEventDTOBuilder.setComponentName(provenanceEventDTO.getComponentName());
    provenanceEventDTOBuilder.setComponentType(provenanceEventDTO.getComponentType());
    provenanceEventDTOBuilder.setContentEqual(provenanceEventDTO.getContentEqual());
    provenanceEventDTOBuilder.setDetails(provenanceEventDTO.getDetails());
    provenanceEventDTOBuilder.setEventDuration(provenanceEventDTO.getEventDuration());
    provenanceEventDTOBuilder.setEventId(provenanceEventDTO.getEventId());
    provenanceEventDTOBuilder.setEventTime(provenanceEventDTO.getEventTime());
    provenanceEventDTOBuilder.setEventType(provenanceEventDTO.getEventType());
    provenanceEventDTOBuilder.setFileSize(provenanceEventDTO.getFileSize());
    provenanceEventDTOBuilder.setFileSizeBytes(provenanceEventDTO.getFileSizeBytes());
    provenanceEventDTOBuilder.setFlowFileUuid(provenanceEventDTO.getFlowFileUuid());
    provenanceEventDTOBuilder.setGroupId(provenanceEventDTO.getGroupId());
    provenanceEventDTOBuilder.setId(provenanceEventDTO.getId());
    provenanceEventDTOBuilder.setInputContentAvailable(provenanceEventDTO.getInputContentAvailable());
    provenanceEventDTOBuilder.setInputContentClaimContainer(provenanceEventDTO.getInputContentClaimContainer());
    provenanceEventDTOBuilder.setInputContentClaimFileSize(provenanceEventDTO.getInputContentClaimFileSize());
    provenanceEventDTOBuilder.setInputContentClaimFileSizeBytes(provenanceEventDTO.getInputContentClaimFileSizeBytes());
    provenanceEventDTOBuilder.setInputContentClaimIdentifier(provenanceEventDTO.getInputContentClaimIdentifier());
    provenanceEventDTOBuilder.setInputContentClaimOffset(provenanceEventDTO.getInputContentClaimOffset());
    provenanceEventDTOBuilder.setInputContentClaimSection(provenanceEventDTO.getInputContentClaimSection());
    provenanceEventDTOBuilder.setLineageDuration(provenanceEventDTO.getLineageDuration());
    provenanceEventDTOBuilder.setOutputContentAvailable(provenanceEventDTO.getOutputContentAvailable());
    provenanceEventDTOBuilder.setOutputContentClaimContainer(provenanceEventDTO.getOutputContentClaimContainer());
    provenanceEventDTOBuilder.setOutputContentClaimFileSize(provenanceEventDTO.getOutputContentClaimFileSize());
    provenanceEventDTOBuilder.setOutputContentClaimFileSizeBytes(provenanceEventDTO.getOutputContentClaimFileSizeBytes());
    provenanceEventDTOBuilder.setOutputContentClaimIdentifier(provenanceEventDTO.getOutputContentClaimIdentifier());
    provenanceEventDTOBuilder.setOutputContentClaimOffset(provenanceEventDTO.getOutputContentClaimOffset());
    provenanceEventDTOBuilder.setOutputContentClaimSection(provenanceEventDTO.getOutputContentClaimSection());
    provenanceEventDTOBuilder.setParentUuids(provenanceEventDTO.getParentUuids());
    provenanceEventDTOBuilder.setRelationship(provenanceEventDTO.getRelationship());
    provenanceEventDTOBuilder.setReplayAvailable(provenanceEventDTO.getReplayAvailable());
    provenanceEventDTOBuilder.setReplayExplanation(provenanceEventDTO.getReplayExplanation());
    provenanceEventDTOBuilder.setSourceConnectionIdentifier(provenanceEventDTO.getSourceConnectionIdentifier());
    provenanceEventDTOBuilder.setSourceSystemFlowFileId(provenanceEventDTO.getSourceSystemFlowFileId());
    provenanceEventDTOBuilder.setTransitUri(provenanceEventDTO.getTransitUri());
    return provenanceEventDTOBuilder;
  }
}
