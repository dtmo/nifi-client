package com.tibtech.nifi.web.api.dto.status;

import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import org.apache.nifi.web.api.dto.status.ConnectionStatusSnapshotDTO;

public final class ConnectionStatusSnapshotDTOBuilder {
  private Long bytesIn;

  private Long bytesOut;

  private Long bytesQueued;

  private String destinationId;

  private String destinationName;

  private Integer flowFilesIn;

  private Integer flowFilesOut;

  private Integer flowFilesQueued;

  private String groupId;

  private String id;

  private String input;

  private String name;

  private String output;

  private Integer percentUseBytes;

  private Integer percentUseCount;

  private String queued;

  private String queuedCount;

  private String queuedSize;

  private String sourceId;

  private String sourceName;

  /**
   * The size of the FlowFiles that have come into the connection in the last 5 minutes.
   */
  public Long getBytesIn() {
    return bytesIn;
  }

  /**
   * The size of the FlowFiles that have come into the connection in the last 5 minutes.
   */
  public ConnectionStatusSnapshotDTOBuilder setBytesIn(final Long bytesIn) {
    this.bytesIn = bytesIn;
    return this;
  }

  /**
   * The number of bytes that have left the connection in the last 5 minutes.
   */
  public Long getBytesOut() {
    return bytesOut;
  }

  /**
   * The number of bytes that have left the connection in the last 5 minutes.
   */
  public ConnectionStatusSnapshotDTOBuilder setBytesOut(final Long bytesOut) {
    this.bytesOut = bytesOut;
    return this;
  }

  /**
   * The size of the FlowFiles that are currently queued in the connection.
   */
  public Long getBytesQueued() {
    return bytesQueued;
  }

  /**
   * The size of the FlowFiles that are currently queued in the connection.
   */
  public ConnectionStatusSnapshotDTOBuilder setBytesQueued(final Long bytesQueued) {
    this.bytesQueued = bytesQueued;
    return this;
  }

  /**
   * The id of the destination of the connection.
   */
  public String getDestinationId() {
    return destinationId;
  }

  /**
   * The id of the destination of the connection.
   */
  public ConnectionStatusSnapshotDTOBuilder setDestinationId(final String destinationId) {
    this.destinationId = destinationId;
    return this;
  }

  /**
   * The name of the destination of the connection.
   */
  public String getDestinationName() {
    return destinationName;
  }

  /**
   * The name of the destination of the connection.
   */
  public ConnectionStatusSnapshotDTOBuilder setDestinationName(final String destinationName) {
    this.destinationName = destinationName;
    return this;
  }

  /**
   * The number of FlowFiles that have come into the connection in the last 5 minutes.
   */
  public Integer getFlowFilesIn() {
    return flowFilesIn;
  }

  /**
   * The number of FlowFiles that have come into the connection in the last 5 minutes.
   */
  public ConnectionStatusSnapshotDTOBuilder setFlowFilesIn(final Integer flowFilesIn) {
    this.flowFilesIn = flowFilesIn;
    return this;
  }

  /**
   * The number of FlowFiles that have left the connection in the last 5 minutes.
   */
  public Integer getFlowFilesOut() {
    return flowFilesOut;
  }

  /**
   * The number of FlowFiles that have left the connection in the last 5 minutes.
   */
  public ConnectionStatusSnapshotDTOBuilder setFlowFilesOut(final Integer flowFilesOut) {
    this.flowFilesOut = flowFilesOut;
    return this;
  }

  /**
   * The number of FlowFiles that are currently queued in the connection.
   */
  public Integer getFlowFilesQueued() {
    return flowFilesQueued;
  }

  /**
   * The number of FlowFiles that are currently queued in the connection.
   */
  public ConnectionStatusSnapshotDTOBuilder setFlowFilesQueued(final Integer flowFilesQueued) {
    this.flowFilesQueued = flowFilesQueued;
    return this;
  }

  /**
   * The id of the process group the connection belongs to.
   */
  public String getGroupId() {
    return groupId;
  }

  /**
   * The id of the process group the connection belongs to.
   */
  public ConnectionStatusSnapshotDTOBuilder setGroupId(final String groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * The id of the connection.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the connection.
   */
  public ConnectionStatusSnapshotDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The input count/size for the connection in the last 5 minutes, pretty printed.
   */
  public String getInput() {
    return input;
  }

  /**
   * The input count/size for the connection in the last 5 minutes, pretty printed.
   */
  public ConnectionStatusSnapshotDTOBuilder setInput(final String input) {
    this.input = input;
    return this;
  }

  /**
   * The name of the connection.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the connection.
   */
  public ConnectionStatusSnapshotDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * The output count/sie for the connection in the last 5 minutes, pretty printed.
   */
  public String getOutput() {
    return output;
  }

  /**
   * The output count/sie for the connection in the last 5 minutes, pretty printed.
   */
  public ConnectionStatusSnapshotDTOBuilder setOutput(final String output) {
    this.output = output;
    return this;
  }

  /**
   * Connection percent use regarding queued flow files size and backpressure threshold if configured.
   */
  public Integer getPercentUseBytes() {
    return percentUseBytes;
  }

  /**
   * Connection percent use regarding queued flow files size and backpressure threshold if configured.
   */
  public ConnectionStatusSnapshotDTOBuilder setPercentUseBytes(final Integer percentUseBytes) {
    this.percentUseBytes = percentUseBytes;
    return this;
  }

  /**
   * Connection percent use regarding queued flow files count and backpressure threshold if configured.
   */
  public Integer getPercentUseCount() {
    return percentUseCount;
  }

  /**
   * Connection percent use regarding queued flow files count and backpressure threshold if configured.
   */
  public ConnectionStatusSnapshotDTOBuilder setPercentUseCount(final Integer percentUseCount) {
    this.percentUseCount = percentUseCount;
    return this;
  }

  /**
   * The total count and size of queued flowfiles formatted.
   */
  public String getQueued() {
    return queued;
  }

  /**
   * The total count and size of queued flowfiles formatted.
   */
  public ConnectionStatusSnapshotDTOBuilder setQueued(final String queued) {
    this.queued = queued;
    return this;
  }

  /**
   * The number of flowfiles that are queued, pretty printed.
   */
  public String getQueuedCount() {
    return queuedCount;
  }

  /**
   * The number of flowfiles that are queued, pretty printed.
   */
  public ConnectionStatusSnapshotDTOBuilder setQueuedCount(final String queuedCount) {
    this.queuedCount = queuedCount;
    return this;
  }

  /**
   * The total size of flowfiles that are queued formatted.
   */
  public String getQueuedSize() {
    return queuedSize;
  }

  /**
   * The total size of flowfiles that are queued formatted.
   */
  public ConnectionStatusSnapshotDTOBuilder setQueuedSize(final String queuedSize) {
    this.queuedSize = queuedSize;
    return this;
  }

  /**
   * The id of the source of the connection.
   */
  public String getSourceId() {
    return sourceId;
  }

  /**
   * The id of the source of the connection.
   */
  public ConnectionStatusSnapshotDTOBuilder setSourceId(final String sourceId) {
    this.sourceId = sourceId;
    return this;
  }

  /**
   * The name of the source of the connection.
   */
  public String getSourceName() {
    return sourceName;
  }

  /**
   * The name of the source of the connection.
   */
  public ConnectionStatusSnapshotDTOBuilder setSourceName(final String sourceName) {
    this.sourceName = sourceName;
    return this;
  }

  public ConnectionStatusSnapshotDTO build() {
    final ConnectionStatusSnapshotDTO connectionStatusSnapshotDTO = new ConnectionStatusSnapshotDTO();
    connectionStatusSnapshotDTO.setBytesIn(bytesIn);
    connectionStatusSnapshotDTO.setBytesOut(bytesOut);
    connectionStatusSnapshotDTO.setBytesQueued(bytesQueued);
    connectionStatusSnapshotDTO.setDestinationId(destinationId);
    connectionStatusSnapshotDTO.setDestinationName(destinationName);
    connectionStatusSnapshotDTO.setFlowFilesIn(flowFilesIn);
    connectionStatusSnapshotDTO.setFlowFilesOut(flowFilesOut);
    connectionStatusSnapshotDTO.setFlowFilesQueued(flowFilesQueued);
    connectionStatusSnapshotDTO.setGroupId(groupId);
    connectionStatusSnapshotDTO.setId(id);
    connectionStatusSnapshotDTO.setInput(input);
    connectionStatusSnapshotDTO.setName(name);
    connectionStatusSnapshotDTO.setOutput(output);
    connectionStatusSnapshotDTO.setPercentUseBytes(percentUseBytes);
    connectionStatusSnapshotDTO.setPercentUseCount(percentUseCount);
    connectionStatusSnapshotDTO.setQueued(queued);
    connectionStatusSnapshotDTO.setQueuedCount(queuedCount);
    connectionStatusSnapshotDTO.setQueuedSize(queuedSize);
    connectionStatusSnapshotDTO.setSourceId(sourceId);
    connectionStatusSnapshotDTO.setSourceName(sourceName);
    return connectionStatusSnapshotDTO;
  }

  public static ConnectionStatusSnapshotDTOBuilder of(final ConnectionStatusSnapshotDTO connectionStatusSnapshotDTO) {
    final ConnectionStatusSnapshotDTOBuilder connectionStatusSnapshotDTOBuilder = new ConnectionStatusSnapshotDTOBuilder();
    connectionStatusSnapshotDTOBuilder.setBytesIn(connectionStatusSnapshotDTO.getBytesIn());
    connectionStatusSnapshotDTOBuilder.setBytesOut(connectionStatusSnapshotDTO.getBytesOut());
    connectionStatusSnapshotDTOBuilder.setBytesQueued(connectionStatusSnapshotDTO.getBytesQueued());
    connectionStatusSnapshotDTOBuilder.setDestinationId(connectionStatusSnapshotDTO.getDestinationId());
    connectionStatusSnapshotDTOBuilder.setDestinationName(connectionStatusSnapshotDTO.getDestinationName());
    connectionStatusSnapshotDTOBuilder.setFlowFilesIn(connectionStatusSnapshotDTO.getFlowFilesIn());
    connectionStatusSnapshotDTOBuilder.setFlowFilesOut(connectionStatusSnapshotDTO.getFlowFilesOut());
    connectionStatusSnapshotDTOBuilder.setFlowFilesQueued(connectionStatusSnapshotDTO.getFlowFilesQueued());
    connectionStatusSnapshotDTOBuilder.setGroupId(connectionStatusSnapshotDTO.getGroupId());
    connectionStatusSnapshotDTOBuilder.setId(connectionStatusSnapshotDTO.getId());
    connectionStatusSnapshotDTOBuilder.setInput(connectionStatusSnapshotDTO.getInput());
    connectionStatusSnapshotDTOBuilder.setName(connectionStatusSnapshotDTO.getName());
    connectionStatusSnapshotDTOBuilder.setOutput(connectionStatusSnapshotDTO.getOutput());
    connectionStatusSnapshotDTOBuilder.setPercentUseBytes(connectionStatusSnapshotDTO.getPercentUseBytes());
    connectionStatusSnapshotDTOBuilder.setPercentUseCount(connectionStatusSnapshotDTO.getPercentUseCount());
    connectionStatusSnapshotDTOBuilder.setQueued(connectionStatusSnapshotDTO.getQueued());
    connectionStatusSnapshotDTOBuilder.setQueuedCount(connectionStatusSnapshotDTO.getQueuedCount());
    connectionStatusSnapshotDTOBuilder.setQueuedSize(connectionStatusSnapshotDTO.getQueuedSize());
    connectionStatusSnapshotDTOBuilder.setSourceId(connectionStatusSnapshotDTO.getSourceId());
    connectionStatusSnapshotDTOBuilder.setSourceName(connectionStatusSnapshotDTO.getSourceName());
    return connectionStatusSnapshotDTOBuilder;
  }
}
