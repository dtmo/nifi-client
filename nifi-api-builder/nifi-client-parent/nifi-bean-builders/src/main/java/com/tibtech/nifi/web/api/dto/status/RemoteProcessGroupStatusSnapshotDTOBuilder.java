package com.tibtech.nifi.web.api.dto.status;

import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import org.apache.nifi.web.api.dto.status.RemoteProcessGroupStatusSnapshotDTO;

public final class RemoteProcessGroupStatusSnapshotDTOBuilder {
  private Integer activeThreadCount;

  private Long bytesReceived;

  private Long bytesSent;

  private Integer flowFilesReceived;

  private Integer flowFilesSent;

  private String groupId;

  private String id;

  private String name;

  private String received;

  private String sent;

  private String targetUri;

  private String transmissionStatus;

  /**
   * The number of active threads for the remote process group.
   */
  public Integer getActiveThreadCount() {
    return activeThreadCount;
  }

  /**
   * The number of active threads for the remote process group.
   */
  public RemoteProcessGroupStatusSnapshotDTOBuilder setActiveThreadCount(final Integer activeThreadCount) {
    this.activeThreadCount = activeThreadCount;
    return this;
  }

  /**
   * The size of the FlowFiles received from the remote process group in the last 5 minutes.
   */
  public Long getBytesReceived() {
    return bytesReceived;
  }

  /**
   * The size of the FlowFiles received from the remote process group in the last 5 minutes.
   */
  public RemoteProcessGroupStatusSnapshotDTOBuilder setBytesReceived(final Long bytesReceived) {
    this.bytesReceived = bytesReceived;
    return this;
  }

  /**
   * The size of the FlowFiles sent to the remote process group in the last 5 minutes.
   */
  public Long getBytesSent() {
    return bytesSent;
  }

  /**
   * The size of the FlowFiles sent to the remote process group in the last 5 minutes.
   */
  public RemoteProcessGroupStatusSnapshotDTOBuilder setBytesSent(final Long bytesSent) {
    this.bytesSent = bytesSent;
    return this;
  }

  /**
   * The number of FlowFiles received from the remote process group in the last 5 minutes.
   */
  public Integer getFlowFilesReceived() {
    return flowFilesReceived;
  }

  /**
   * The number of FlowFiles received from the remote process group in the last 5 minutes.
   */
  public RemoteProcessGroupStatusSnapshotDTOBuilder setFlowFilesReceived(final Integer flowFilesReceived) {
    this.flowFilesReceived = flowFilesReceived;
    return this;
  }

  /**
   * The number of FlowFiles sent to the remote process group in the last 5 minutes.
   */
  public Integer getFlowFilesSent() {
    return flowFilesSent;
  }

  /**
   * The number of FlowFiles sent to the remote process group in the last 5 minutes.
   */
  public RemoteProcessGroupStatusSnapshotDTOBuilder setFlowFilesSent(final Integer flowFilesSent) {
    this.flowFilesSent = flowFilesSent;
    return this;
  }

  /**
   * The id of the parent process group the remote process group resides in.
   */
  public String getGroupId() {
    return groupId;
  }

  /**
   * The id of the parent process group the remote process group resides in.
   */
  public RemoteProcessGroupStatusSnapshotDTOBuilder setGroupId(final String groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * The id of the remote process group.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the remote process group.
   */
  public RemoteProcessGroupStatusSnapshotDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The name of the remote process group.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the remote process group.
   */
  public RemoteProcessGroupStatusSnapshotDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * The count/size of the flowfiles received from the remote process group in the last 5 minutes.
   */
  public String getReceived() {
    return received;
  }

  /**
   * The count/size of the flowfiles received from the remote process group in the last 5 minutes.
   */
  public RemoteProcessGroupStatusSnapshotDTOBuilder setReceived(final String received) {
    this.received = received;
    return this;
  }

  /**
   * The count/size of the flowfiles sent to the remote process group in the last 5 minutes.
   */
  public String getSent() {
    return sent;
  }

  /**
   * The count/size of the flowfiles sent to the remote process group in the last 5 minutes.
   */
  public RemoteProcessGroupStatusSnapshotDTOBuilder setSent(final String sent) {
    this.sent = sent;
    return this;
  }

  /**
   * The URI of the target system.
   */
  public String getTargetUri() {
    return targetUri;
  }

  /**
   * The URI of the target system.
   */
  public RemoteProcessGroupStatusSnapshotDTOBuilder setTargetUri(final String targetUri) {
    this.targetUri = targetUri;
    return this;
  }

  /**
   * The transmission status of the remote process group.
   */
  public String getTransmissionStatus() {
    return transmissionStatus;
  }

  /**
   * The transmission status of the remote process group.
   */
  public RemoteProcessGroupStatusSnapshotDTOBuilder setTransmissionStatus(final String transmissionStatus) {
    this.transmissionStatus = transmissionStatus;
    return this;
  }

  public RemoteProcessGroupStatusSnapshotDTO build() {
    final RemoteProcessGroupStatusSnapshotDTO remoteProcessGroupStatusSnapshotDTO = new RemoteProcessGroupStatusSnapshotDTO();
    remoteProcessGroupStatusSnapshotDTO.setActiveThreadCount(activeThreadCount);
    remoteProcessGroupStatusSnapshotDTO.setBytesReceived(bytesReceived);
    remoteProcessGroupStatusSnapshotDTO.setBytesSent(bytesSent);
    remoteProcessGroupStatusSnapshotDTO.setFlowFilesReceived(flowFilesReceived);
    remoteProcessGroupStatusSnapshotDTO.setFlowFilesSent(flowFilesSent);
    remoteProcessGroupStatusSnapshotDTO.setGroupId(groupId);
    remoteProcessGroupStatusSnapshotDTO.setId(id);
    remoteProcessGroupStatusSnapshotDTO.setName(name);
    remoteProcessGroupStatusSnapshotDTO.setReceived(received);
    remoteProcessGroupStatusSnapshotDTO.setSent(sent);
    remoteProcessGroupStatusSnapshotDTO.setTargetUri(targetUri);
    remoteProcessGroupStatusSnapshotDTO.setTransmissionStatus(transmissionStatus);
    return remoteProcessGroupStatusSnapshotDTO;
  }

  public static RemoteProcessGroupStatusSnapshotDTOBuilder of(final RemoteProcessGroupStatusSnapshotDTO remoteProcessGroupStatusSnapshotDTO) {
    final RemoteProcessGroupStatusSnapshotDTOBuilder remoteProcessGroupStatusSnapshotDTOBuilder = new RemoteProcessGroupStatusSnapshotDTOBuilder();
    remoteProcessGroupStatusSnapshotDTOBuilder.setActiveThreadCount(remoteProcessGroupStatusSnapshotDTO.getActiveThreadCount());
    remoteProcessGroupStatusSnapshotDTOBuilder.setBytesReceived(remoteProcessGroupStatusSnapshotDTO.getBytesReceived());
    remoteProcessGroupStatusSnapshotDTOBuilder.setBytesSent(remoteProcessGroupStatusSnapshotDTO.getBytesSent());
    remoteProcessGroupStatusSnapshotDTOBuilder.setFlowFilesReceived(remoteProcessGroupStatusSnapshotDTO.getFlowFilesReceived());
    remoteProcessGroupStatusSnapshotDTOBuilder.setFlowFilesSent(remoteProcessGroupStatusSnapshotDTO.getFlowFilesSent());
    remoteProcessGroupStatusSnapshotDTOBuilder.setGroupId(remoteProcessGroupStatusSnapshotDTO.getGroupId());
    remoteProcessGroupStatusSnapshotDTOBuilder.setId(remoteProcessGroupStatusSnapshotDTO.getId());
    remoteProcessGroupStatusSnapshotDTOBuilder.setName(remoteProcessGroupStatusSnapshotDTO.getName());
    remoteProcessGroupStatusSnapshotDTOBuilder.setReceived(remoteProcessGroupStatusSnapshotDTO.getReceived());
    remoteProcessGroupStatusSnapshotDTOBuilder.setSent(remoteProcessGroupStatusSnapshotDTO.getSent());
    remoteProcessGroupStatusSnapshotDTOBuilder.setTargetUri(remoteProcessGroupStatusSnapshotDTO.getTargetUri());
    remoteProcessGroupStatusSnapshotDTOBuilder.setTransmissionStatus(remoteProcessGroupStatusSnapshotDTO.getTransmissionStatus());
    return remoteProcessGroupStatusSnapshotDTOBuilder;
  }
}
