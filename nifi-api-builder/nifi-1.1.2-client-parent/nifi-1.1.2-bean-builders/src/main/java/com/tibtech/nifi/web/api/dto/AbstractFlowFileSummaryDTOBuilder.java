package com.tibtech.nifi.web.api.dto;

import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import org.apache.nifi.web.api.dto.FlowFileSummaryDTO;

public abstract class AbstractFlowFileSummaryDTOBuilder<T extends AbstractFlowFileSummaryDTOBuilder<T>> {
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
  public T setClusterNodeAddress(final String clusterNodeAddress) {
    this.clusterNodeAddress = clusterNodeAddress;
    return (T) this;
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
  public T setClusterNodeId(final String clusterNodeId) {
    this.clusterNodeId = clusterNodeId;
    return (T) this;
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
  public T setFilename(final String filename) {
    this.filename = filename;
    return (T) this;
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
  public T setLineageDuration(final Long lineageDuration) {
    this.lineageDuration = lineageDuration;
    return (T) this;
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
  public T setPosition(final Integer position) {
    this.position = position;
    return (T) this;
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
  public T setQueuedDuration(final Long queuedDuration) {
    this.queuedDuration = queuedDuration;
    return (T) this;
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
  public T setSize(final Long size) {
    this.size = size;
    return (T) this;
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
  public T setUri(final String uri) {
    this.uri = uri;
    return (T) this;
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
  public T setUuid(final String uuid) {
    this.uuid = uuid;
    return (T) this;
  }

  protected void setPropertyValues(final FlowFileSummaryDTO flowFileSummaryDTO) {
    flowFileSummaryDTO.setClusterNodeAddress(clusterNodeAddress);
    flowFileSummaryDTO.setClusterNodeId(clusterNodeId);
    flowFileSummaryDTO.setFilename(filename);
    flowFileSummaryDTO.setLineageDuration(lineageDuration);
    flowFileSummaryDTO.setPosition(position);
    flowFileSummaryDTO.setQueuedDuration(queuedDuration);
    flowFileSummaryDTO.setSize(size);
    flowFileSummaryDTO.setUri(uri);
    flowFileSummaryDTO.setUuid(uuid);
  }

  protected static void setBuilderValues(final AbstractFlowFileSummaryDTOBuilder abstractFlowFileSummaryDTOBuilder,
      final FlowFileSummaryDTO flowFileSummaryDTO) {
    abstractFlowFileSummaryDTOBuilder.setClusterNodeAddress(flowFileSummaryDTO.getClusterNodeAddress());
    abstractFlowFileSummaryDTOBuilder.setClusterNodeId(flowFileSummaryDTO.getClusterNodeId());
    abstractFlowFileSummaryDTOBuilder.setFilename(flowFileSummaryDTO.getFilename());
    abstractFlowFileSummaryDTOBuilder.setLineageDuration(flowFileSummaryDTO.getLineageDuration());
    abstractFlowFileSummaryDTOBuilder.setPosition(flowFileSummaryDTO.getPosition());
    abstractFlowFileSummaryDTOBuilder.setQueuedDuration(flowFileSummaryDTO.getQueuedDuration());
    abstractFlowFileSummaryDTOBuilder.setSize(flowFileSummaryDTO.getSize());
    abstractFlowFileSummaryDTOBuilder.setUri(flowFileSummaryDTO.getUri());
    abstractFlowFileSummaryDTOBuilder.setUuid(flowFileSummaryDTO.getUuid());
  }
}
