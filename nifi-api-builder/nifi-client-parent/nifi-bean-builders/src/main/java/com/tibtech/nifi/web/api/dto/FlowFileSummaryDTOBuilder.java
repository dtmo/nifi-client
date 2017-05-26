package com.tibtech.nifi.web.api.dto;

import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import org.apache.nifi.web.api.dto.FlowFileSummaryDTO;

public final class FlowFileSummaryDTOBuilder extends AbstractFlowFileSummaryDTOBuilder<FlowFileSummaryDTOBuilder> {
  private String clusterNodeAddress;

  private String clusterNodeId;

  private String filename;

  private Long lineageDuration;

  private Integer position;

  private Long queuedDuration;

  private Long size;

  private String uri;

  private String uuid;

  /**
   * The label for the node where this FlowFile resides.
   */
  public String getClusterNodeAddress() {
    return clusterNodeAddress;
  }

  /**
   * The label for the node where this FlowFile resides.
   */
  public FlowFileSummaryDTOBuilder setClusterNodeAddress(final String clusterNodeAddress) {
    this.clusterNodeAddress = clusterNodeAddress;
    return this;
  }

  /**
   * The id of the node where this FlowFile resides.
   */
  public String getClusterNodeId() {
    return clusterNodeId;
  }

  /**
   * The id of the node where this FlowFile resides.
   */
  public FlowFileSummaryDTOBuilder setClusterNodeId(final String clusterNodeId) {
    this.clusterNodeId = clusterNodeId;
    return this;
  }

  /**
   * The FlowFile filename.
   */
  public String getFilename() {
    return filename;
  }

  /**
   * The FlowFile filename.
   */
  public FlowFileSummaryDTOBuilder setFilename(final String filename) {
    this.filename = filename;
    return this;
  }

  /**
   * Duration since the FlowFile's greatest ancestor entered the flow.
   */
  public Long getLineageDuration() {
    return lineageDuration;
  }

  /**
   * Duration since the FlowFile's greatest ancestor entered the flow.
   */
  public FlowFileSummaryDTOBuilder setLineageDuration(final Long lineageDuration) {
    this.lineageDuration = lineageDuration;
    return this;
  }

  /**
   * The FlowFile's position in the queue.
   */
  public Integer getPosition() {
    return position;
  }

  /**
   * The FlowFile's position in the queue.
   */
  public FlowFileSummaryDTOBuilder setPosition(final Integer position) {
    this.position = position;
    return this;
  }

  /**
   * How long this FlowFile has been enqueued.
   */
  public Long getQueuedDuration() {
    return queuedDuration;
  }

  /**
   * How long this FlowFile has been enqueued.
   */
  public FlowFileSummaryDTOBuilder setQueuedDuration(final Long queuedDuration) {
    this.queuedDuration = queuedDuration;
    return this;
  }

  /**
   * The FlowFile file size.
   */
  public Long getSize() {
    return size;
  }

  /**
   * The FlowFile file size.
   */
  public FlowFileSummaryDTOBuilder setSize(final Long size) {
    this.size = size;
    return this;
  }

  /**
   * The URI that can be used to access this FlowFile.
   */
  public String getUri() {
    return uri;
  }

  /**
   * The URI that can be used to access this FlowFile.
   */
  public FlowFileSummaryDTOBuilder setUri(final String uri) {
    this.uri = uri;
    return this;
  }

  /**
   * The FlowFile UUID.
   */
  public String getUuid() {
    return uuid;
  }

  /**
   * The FlowFile UUID.
   */
  public FlowFileSummaryDTOBuilder setUuid(final String uuid) {
    this.uuid = uuid;
    return this;
  }

  public FlowFileSummaryDTO build() {
    final FlowFileSummaryDTO flowFileSummaryDTO = new FlowFileSummaryDTO();
    super.setPropertyValues(flowFileSummaryDTO);
    flowFileSummaryDTO.setClusterNodeAddress(clusterNodeAddress);
    flowFileSummaryDTO.setClusterNodeId(clusterNodeId);
    flowFileSummaryDTO.setFilename(filename);
    flowFileSummaryDTO.setLineageDuration(lineageDuration);
    flowFileSummaryDTO.setPosition(position);
    flowFileSummaryDTO.setQueuedDuration(queuedDuration);
    flowFileSummaryDTO.setSize(size);
    flowFileSummaryDTO.setUri(uri);
    flowFileSummaryDTO.setUuid(uuid);
    return flowFileSummaryDTO;
  }

  public static FlowFileSummaryDTOBuilder of(final FlowFileSummaryDTO flowFileSummaryDTO) {
    final FlowFileSummaryDTOBuilder flowFileSummaryDTOBuilder = new FlowFileSummaryDTOBuilder();
    AbstractFlowFileSummaryDTOBuilder.setBuilderValues(flowFileSummaryDTOBuilder, flowFileSummaryDTO);
    flowFileSummaryDTOBuilder.setClusterNodeAddress(flowFileSummaryDTO.getClusterNodeAddress());
    flowFileSummaryDTOBuilder.setClusterNodeId(flowFileSummaryDTO.getClusterNodeId());
    flowFileSummaryDTOBuilder.setFilename(flowFileSummaryDTO.getFilename());
    flowFileSummaryDTOBuilder.setLineageDuration(flowFileSummaryDTO.getLineageDuration());
    flowFileSummaryDTOBuilder.setPosition(flowFileSummaryDTO.getPosition());
    flowFileSummaryDTOBuilder.setQueuedDuration(flowFileSummaryDTO.getQueuedDuration());
    flowFileSummaryDTOBuilder.setSize(flowFileSummaryDTO.getSize());
    flowFileSummaryDTOBuilder.setUri(flowFileSummaryDTO.getUri());
    flowFileSummaryDTOBuilder.setUuid(flowFileSummaryDTO.getUuid());
    return flowFileSummaryDTOBuilder;
  }
}
