package com.tibtech.nifi.web.api.dto.status;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import org.apache.nifi.web.api.dto.status.PortStatusSnapshotDTO;

public final class PortStatusSnapshotDTOBuilder {
  private Integer activeThreadCount;

  private Long bytesIn;

  private Long bytesOut;

  private Integer flowFilesIn;

  private Integer flowFilesOut;

  private String groupId;

  private String id;

  private String input;

  private String name;

  private String output;

  private String runStatus;

  private Boolean transmitting;

  /**
   * The active thread count for the port.
   */
  public Integer getActiveThreadCount() {
    return activeThreadCount;
  }

  /**
   * The active thread count for the port.
   */
  public PortStatusSnapshotDTOBuilder setActiveThreadCount(final Integer activeThreadCount) {
    this.activeThreadCount = activeThreadCount;
    return this;
  }

  /**
   * The size of hte FlowFiles that have been accepted in the last 5 minutes.
   */
  public Long getBytesIn() {
    return bytesIn;
  }

  /**
   * The size of hte FlowFiles that have been accepted in the last 5 minutes.
   */
  public PortStatusSnapshotDTOBuilder setBytesIn(final Long bytesIn) {
    this.bytesIn = bytesIn;
    return this;
  }

  /**
   * The number of bytes that have been processed in the last 5 minutes.
   */
  public Long getBytesOut() {
    return bytesOut;
  }

  /**
   * The number of bytes that have been processed in the last 5 minutes.
   */
  public PortStatusSnapshotDTOBuilder setBytesOut(final Long bytesOut) {
    this.bytesOut = bytesOut;
    return this;
  }

  /**
   * The number of FlowFiles that have been accepted in the last 5 minutes.
   */
  public Integer getFlowFilesIn() {
    return flowFilesIn;
  }

  /**
   * The number of FlowFiles that have been accepted in the last 5 minutes.
   */
  public PortStatusSnapshotDTOBuilder setFlowFilesIn(final Integer flowFilesIn) {
    this.flowFilesIn = flowFilesIn;
    return this;
  }

  /**
   * The number of FlowFiles that have been processed in the last 5 minutes.
   */
  public Integer getFlowFilesOut() {
    return flowFilesOut;
  }

  /**
   * The number of FlowFiles that have been processed in the last 5 minutes.
   */
  public PortStatusSnapshotDTOBuilder setFlowFilesOut(final Integer flowFilesOut) {
    this.flowFilesOut = flowFilesOut;
    return this;
  }

  /**
   * The id of the parent process group of the port.
   */
  public String getGroupId() {
    return groupId;
  }

  /**
   * The id of the parent process group of the port.
   */
  public PortStatusSnapshotDTOBuilder setGroupId(final String groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * The id of the port.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the port.
   */
  public PortStatusSnapshotDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The count/size of flowfiles that have been accepted in the last 5 minutes.
   */
  public String getInput() {
    return input;
  }

  /**
   * The count/size of flowfiles that have been accepted in the last 5 minutes.
   */
  public PortStatusSnapshotDTOBuilder setInput(final String input) {
    this.input = input;
    return this;
  }

  /**
   * The name of the port.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the port.
   */
  public PortStatusSnapshotDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * The count/size of flowfiles that have been processed in the last 5 minutes.
   */
  public String getOutput() {
    return output;
  }

  /**
   * The count/size of flowfiles that have been processed in the last 5 minutes.
   */
  public PortStatusSnapshotDTOBuilder setOutput(final String output) {
    this.output = output;
    return this;
  }

  /**
   * The run status of the port.
   */
  public String getRunStatus() {
    return runStatus;
  }

  /**
   * The run status of the port.
   */
  public PortStatusSnapshotDTOBuilder setRunStatus(final String runStatus) {
    this.runStatus = runStatus;
    return this;
  }

  /**
   * Whether the port has incoming or outgoing connections to a remote NiFi.
   */
  public Boolean getTransmitting() {
    return transmitting;
  }

  /**
   * Whether the port has incoming or outgoing connections to a remote NiFi.
   */
  public PortStatusSnapshotDTOBuilder setTransmitting(final Boolean transmitting) {
    this.transmitting = transmitting;
    return this;
  }

  public PortStatusSnapshotDTO build() {
    final PortStatusSnapshotDTO portStatusSnapshotDTO = new PortStatusSnapshotDTO();
    portStatusSnapshotDTO.setActiveThreadCount(activeThreadCount);
    portStatusSnapshotDTO.setBytesIn(bytesIn);
    portStatusSnapshotDTO.setBytesOut(bytesOut);
    portStatusSnapshotDTO.setFlowFilesIn(flowFilesIn);
    portStatusSnapshotDTO.setFlowFilesOut(flowFilesOut);
    portStatusSnapshotDTO.setGroupId(groupId);
    portStatusSnapshotDTO.setId(id);
    portStatusSnapshotDTO.setInput(input);
    portStatusSnapshotDTO.setName(name);
    portStatusSnapshotDTO.setOutput(output);
    portStatusSnapshotDTO.setRunStatus(runStatus);
    portStatusSnapshotDTO.setTransmitting(transmitting);
    return portStatusSnapshotDTO;
  }

  public static PortStatusSnapshotDTOBuilder of(final PortStatusSnapshotDTO portStatusSnapshotDTO) {
    final PortStatusSnapshotDTOBuilder portStatusSnapshotDTOBuilder = new PortStatusSnapshotDTOBuilder();
    portStatusSnapshotDTOBuilder.setActiveThreadCount(portStatusSnapshotDTO.getActiveThreadCount());
    portStatusSnapshotDTOBuilder.setBytesIn(portStatusSnapshotDTO.getBytesIn());
    portStatusSnapshotDTOBuilder.setBytesOut(portStatusSnapshotDTO.getBytesOut());
    portStatusSnapshotDTOBuilder.setFlowFilesIn(portStatusSnapshotDTO.getFlowFilesIn());
    portStatusSnapshotDTOBuilder.setFlowFilesOut(portStatusSnapshotDTO.getFlowFilesOut());
    portStatusSnapshotDTOBuilder.setGroupId(portStatusSnapshotDTO.getGroupId());
    portStatusSnapshotDTOBuilder.setId(portStatusSnapshotDTO.getId());
    portStatusSnapshotDTOBuilder.setInput(portStatusSnapshotDTO.getInput());
    portStatusSnapshotDTOBuilder.setName(portStatusSnapshotDTO.getName());
    portStatusSnapshotDTOBuilder.setOutput(portStatusSnapshotDTO.getOutput());
    portStatusSnapshotDTOBuilder.setRunStatus(portStatusSnapshotDTO.getRunStatus());
    portStatusSnapshotDTOBuilder.setTransmitting(portStatusSnapshotDTO.isTransmitting());
    return portStatusSnapshotDTOBuilder;
  }
}
