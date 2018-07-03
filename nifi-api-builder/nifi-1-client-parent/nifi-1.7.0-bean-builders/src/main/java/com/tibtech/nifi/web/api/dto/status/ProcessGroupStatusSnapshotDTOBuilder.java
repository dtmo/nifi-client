package com.tibtech.nifi.web.api.dto.status;

import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;
import org.apache.nifi.web.api.dto.status.ProcessGroupStatusSnapshotDTO;
import org.apache.nifi.web.api.entity.ConnectionStatusSnapshotEntity;
import org.apache.nifi.web.api.entity.PortStatusSnapshotEntity;
import org.apache.nifi.web.api.entity.ProcessGroupStatusSnapshotEntity;
import org.apache.nifi.web.api.entity.ProcessorStatusSnapshotEntity;
import org.apache.nifi.web.api.entity.RemoteProcessGroupStatusSnapshotEntity;

public final class ProcessGroupStatusSnapshotDTOBuilder {
  private Integer activeThreadCount;

  private Long bytesIn;

  private Long bytesOut;

  private Long bytesQueued;

  private Long bytesRead;

  private Long bytesReceived;

  private Long bytesSent;

  private Long bytesTransferred;

  private Long bytesWritten;

  private Collection<ConnectionStatusSnapshotEntity> connectionStatusSnapshots;

  private Integer flowFilesIn;

  private Integer flowFilesOut;

  private Integer flowFilesQueued;

  private Integer flowFilesReceived;

  private Integer flowFilesSent;

  private Integer flowFilesTransferred;

  private String id;

  private String input;

  private Collection<PortStatusSnapshotEntity> inputPortStatusSnapshots;

  private String name;

  private String output;

  private Collection<PortStatusSnapshotEntity> outputPortStatusSnapshots;

  private Collection<ProcessGroupStatusSnapshotEntity> processGroupStatusSnapshots;

  private Collection<ProcessorStatusSnapshotEntity> processorStatusSnapshots;

  private String queued;

  private String queuedCount;

  private String queuedSize;

  private String read;

  private String received;

  private Collection<RemoteProcessGroupStatusSnapshotEntity> remoteProcessGroupStatusSnapshots;

  private String sent;

  private Integer terminatedThreadCount;

  private String transferred;

  private String versionedFlowState;

  private String written;

  /**
   * The active thread count for this process group.
   */
  public Integer getActiveThreadCount() {
    return activeThreadCount;
  }

  /**
   * The active thread count for this process group.
   */
  public ProcessGroupStatusSnapshotDTOBuilder setActiveThreadCount(final Integer activeThreadCount) {
    this.activeThreadCount = activeThreadCount;
    return this;
  }

  /**
   * The number of bytes that have come into this ProcessGroup in the last 5 minutes
   */
  public Long getBytesIn() {
    return bytesIn;
  }

  /**
   * The number of bytes that have come into this ProcessGroup in the last 5 minutes
   */
  public ProcessGroupStatusSnapshotDTOBuilder setBytesIn(final Long bytesIn) {
    this.bytesIn = bytesIn;
    return this;
  }

  /**
   * The number of bytes transferred out of this ProcessGroup in the last 5 minutes
   */
  public Long getBytesOut() {
    return bytesOut;
  }

  /**
   * The number of bytes transferred out of this ProcessGroup in the last 5 minutes
   */
  public ProcessGroupStatusSnapshotDTOBuilder setBytesOut(final Long bytesOut) {
    this.bytesOut = bytesOut;
    return this;
  }

  /**
   * The number of bytes that are queued up in this ProcessGroup right now
   */
  public Long getBytesQueued() {
    return bytesQueued;
  }

  /**
   * The number of bytes that are queued up in this ProcessGroup right now
   */
  public ProcessGroupStatusSnapshotDTOBuilder setBytesQueued(final Long bytesQueued) {
    this.bytesQueued = bytesQueued;
    return this;
  }

  /**
   * The number of bytes read by components in this ProcessGroup in the last 5 minutes
   */
  public Long getBytesRead() {
    return bytesRead;
  }

  /**
   * The number of bytes read by components in this ProcessGroup in the last 5 minutes
   */
  public ProcessGroupStatusSnapshotDTOBuilder setBytesRead(final Long bytesRead) {
    this.bytesRead = bytesRead;
    return this;
  }

  /**
   * The number of bytes received from external sources by components within this ProcessGroup in the last 5 minutes
   */
  public Long getBytesReceived() {
    return bytesReceived;
  }

  /**
   * The number of bytes received from external sources by components within this ProcessGroup in the last 5 minutes
   */
  public ProcessGroupStatusSnapshotDTOBuilder setBytesReceived(final Long bytesReceived) {
    this.bytesReceived = bytesReceived;
    return this;
  }

  /**
   * The number of bytes sent to an external sink by components within this ProcessGroup in the last 5 minutes
   */
  public Long getBytesSent() {
    return bytesSent;
  }

  /**
   * The number of bytes sent to an external sink by components within this ProcessGroup in the last 5 minutes
   */
  public ProcessGroupStatusSnapshotDTOBuilder setBytesSent(final Long bytesSent) {
    this.bytesSent = bytesSent;
    return this;
  }

  /**
   * The number of bytes transferred in this ProcessGroup in the last 5 minutes
   */
  public Long getBytesTransferred() {
    return bytesTransferred;
  }

  /**
   * The number of bytes transferred in this ProcessGroup in the last 5 minutes
   */
  public ProcessGroupStatusSnapshotDTOBuilder setBytesTransferred(final Long bytesTransferred) {
    this.bytesTransferred = bytesTransferred;
    return this;
  }

  /**
   * The number of bytes written by components in this ProcessGroup in the last 5 minutes
   */
  public Long getBytesWritten() {
    return bytesWritten;
  }

  /**
   * The number of bytes written by components in this ProcessGroup in the last 5 minutes
   */
  public ProcessGroupStatusSnapshotDTOBuilder setBytesWritten(final Long bytesWritten) {
    this.bytesWritten = bytesWritten;
    return this;
  }

  /**
   * The status of all connections in the process group.
   */
  public Collection<ConnectionStatusSnapshotEntity> getConnectionStatusSnapshots() {
    return connectionStatusSnapshots;
  }

  /**
   * The status of all connections in the process group.
   */
  public ProcessGroupStatusSnapshotDTOBuilder setConnectionStatusSnapshots(final Collection<ConnectionStatusSnapshotEntity> connectionStatusSnapshots) {
    this.connectionStatusSnapshots = connectionStatusSnapshots;
    return this;
  }

  /**
   * The number of FlowFiles that have come into this ProcessGroup in the last 5 minutes
   */
  public Integer getFlowFilesIn() {
    return flowFilesIn;
  }

  /**
   * The number of FlowFiles that have come into this ProcessGroup in the last 5 minutes
   */
  public ProcessGroupStatusSnapshotDTOBuilder setFlowFilesIn(final Integer flowFilesIn) {
    this.flowFilesIn = flowFilesIn;
    return this;
  }

  /**
   * The number of FlowFiles transferred out of this ProcessGroup in the last 5 minutes
   */
  public Integer getFlowFilesOut() {
    return flowFilesOut;
  }

  /**
   * The number of FlowFiles transferred out of this ProcessGroup in the last 5 minutes
   */
  public ProcessGroupStatusSnapshotDTOBuilder setFlowFilesOut(final Integer flowFilesOut) {
    this.flowFilesOut = flowFilesOut;
    return this;
  }

  /**
   * The number of FlowFiles that are queued up in this ProcessGroup right now
   */
  public Integer getFlowFilesQueued() {
    return flowFilesQueued;
  }

  /**
   * The number of FlowFiles that are queued up in this ProcessGroup right now
   */
  public ProcessGroupStatusSnapshotDTOBuilder setFlowFilesQueued(final Integer flowFilesQueued) {
    this.flowFilesQueued = flowFilesQueued;
    return this;
  }

  /**
   * The number of FlowFiles received from external sources by components within this ProcessGroup in the last 5 minutes
   */
  public Integer getFlowFilesReceived() {
    return flowFilesReceived;
  }

  /**
   * The number of FlowFiles received from external sources by components within this ProcessGroup in the last 5 minutes
   */
  public ProcessGroupStatusSnapshotDTOBuilder setFlowFilesReceived(final Integer flowFilesReceived) {
    this.flowFilesReceived = flowFilesReceived;
    return this;
  }

  /**
   * The number of FlowFiles sent to an external sink by components within this ProcessGroup in the last 5 minutes
   */
  public Integer getFlowFilesSent() {
    return flowFilesSent;
  }

  /**
   * The number of FlowFiles sent to an external sink by components within this ProcessGroup in the last 5 minutes
   */
  public ProcessGroupStatusSnapshotDTOBuilder setFlowFilesSent(final Integer flowFilesSent) {
    this.flowFilesSent = flowFilesSent;
    return this;
  }

  /**
   * The number of FlowFiles transferred in this ProcessGroup in the last 5 minutes
   */
  public Integer getFlowFilesTransferred() {
    return flowFilesTransferred;
  }

  /**
   * The number of FlowFiles transferred in this ProcessGroup in the last 5 minutes
   */
  public ProcessGroupStatusSnapshotDTOBuilder setFlowFilesTransferred(final Integer flowFilesTransferred) {
    this.flowFilesTransferred = flowFilesTransferred;
    return this;
  }

  /**
   * The id of the process group.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the process group.
   */
  public ProcessGroupStatusSnapshotDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The input count/size for the process group in the last 5 minutes (pretty printed).
   */
  public String getInput() {
    return input;
  }

  /**
   * The input count/size for the process group in the last 5 minutes (pretty printed).
   */
  public ProcessGroupStatusSnapshotDTOBuilder setInput(final String input) {
    this.input = input;
    return this;
  }

  /**
   * The status of all input ports in the process group.
   */
  public Collection<PortStatusSnapshotEntity> getInputPortStatusSnapshots() {
    return inputPortStatusSnapshots;
  }

  /**
   * The status of all input ports in the process group.
   */
  public ProcessGroupStatusSnapshotDTOBuilder setInputPortStatusSnapshots(final Collection<PortStatusSnapshotEntity> inputPortStatusSnapshots) {
    this.inputPortStatusSnapshots = inputPortStatusSnapshots;
    return this;
  }

  /**
   * The name of this process group.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of this process group.
   */
  public ProcessGroupStatusSnapshotDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * The output count/size for the process group in the last 5 minutes.
   */
  public String getOutput() {
    return output;
  }

  /**
   * The output count/size for the process group in the last 5 minutes.
   */
  public ProcessGroupStatusSnapshotDTOBuilder setOutput(final String output) {
    this.output = output;
    return this;
  }

  /**
   * The status of all output ports in the process group.
   */
  public Collection<PortStatusSnapshotEntity> getOutputPortStatusSnapshots() {
    return outputPortStatusSnapshots;
  }

  /**
   * The status of all output ports in the process group.
   */
  public ProcessGroupStatusSnapshotDTOBuilder setOutputPortStatusSnapshots(final Collection<PortStatusSnapshotEntity> outputPortStatusSnapshots) {
    this.outputPortStatusSnapshots = outputPortStatusSnapshots;
    return this;
  }

  /**
   * The status of all process groups in the process group.
   */
  public Collection<ProcessGroupStatusSnapshotEntity> getProcessGroupStatusSnapshots() {
    return processGroupStatusSnapshots;
  }

  /**
   * The status of all process groups in the process group.
   */
  public ProcessGroupStatusSnapshotDTOBuilder setProcessGroupStatusSnapshots(final Collection<ProcessGroupStatusSnapshotEntity> processGroupStatusSnapshots) {
    this.processGroupStatusSnapshots = processGroupStatusSnapshots;
    return this;
  }

  /**
   * The status of all processors in the process group.
   */
  public Collection<ProcessorStatusSnapshotEntity> getProcessorStatusSnapshots() {
    return processorStatusSnapshots;
  }

  /**
   * The status of all processors in the process group.
   */
  public ProcessGroupStatusSnapshotDTOBuilder setProcessorStatusSnapshots(final Collection<ProcessorStatusSnapshotEntity> processorStatusSnapshots) {
    this.processorStatusSnapshots = processorStatusSnapshots;
    return this;
  }

  /**
   * The count/size that is queued in the the process group.
   */
  public String getQueued() {
    return queued;
  }

  /**
   * The count/size that is queued in the the process group.
   */
  public ProcessGroupStatusSnapshotDTOBuilder setQueued(final String queued) {
    this.queued = queued;
    return this;
  }

  /**
   * The count that is queued for the process group.
   */
  public String getQueuedCount() {
    return queuedCount;
  }

  /**
   * The count that is queued for the process group.
   */
  public ProcessGroupStatusSnapshotDTOBuilder setQueuedCount(final String queuedCount) {
    this.queuedCount = queuedCount;
    return this;
  }

  /**
   * The size that is queued for the process group.
   */
  public String getQueuedSize() {
    return queuedSize;
  }

  /**
   * The size that is queued for the process group.
   */
  public ProcessGroupStatusSnapshotDTOBuilder setQueuedSize(final String queuedSize) {
    this.queuedSize = queuedSize;
    return this;
  }

  /**
   * The number of bytes read in the last 5 minutes.
   */
  public String getRead() {
    return read;
  }

  /**
   * The number of bytes read in the last 5 minutes.
   */
  public ProcessGroupStatusSnapshotDTOBuilder setRead(final String read) {
    this.read = read;
    return this;
  }

  /**
   * The count/size sent to the process group in the last 5 minutes.
   */
  public String getReceived() {
    return received;
  }

  /**
   * The count/size sent to the process group in the last 5 minutes.
   */
  public ProcessGroupStatusSnapshotDTOBuilder setReceived(final String received) {
    this.received = received;
    return this;
  }

  /**
   * The status of all remote process groups in the process group.
   */
  public Collection<RemoteProcessGroupStatusSnapshotEntity> getRemoteProcessGroupStatusSnapshots() {
    return remoteProcessGroupStatusSnapshots;
  }

  /**
   * The status of all remote process groups in the process group.
   */
  public ProcessGroupStatusSnapshotDTOBuilder setRemoteProcessGroupStatusSnapshots(final Collection<RemoteProcessGroupStatusSnapshotEntity> remoteProcessGroupStatusSnapshots) {
    this.remoteProcessGroupStatusSnapshots = remoteProcessGroupStatusSnapshots;
    return this;
  }

  /**
   * The count/size sent from this process group in the last 5 minutes.
   */
  public String getSent() {
    return sent;
  }

  /**
   * The count/size sent from this process group in the last 5 minutes.
   */
  public ProcessGroupStatusSnapshotDTOBuilder setSent(final String sent) {
    this.sent = sent;
    return this;
  }

  /**
   * The number of threads currently terminated for the process group.
   */
  public Integer getTerminatedThreadCount() {
    return terminatedThreadCount;
  }

  /**
   * The number of threads currently terminated for the process group.
   */
  public ProcessGroupStatusSnapshotDTOBuilder setTerminatedThreadCount(final Integer terminatedThreadCount) {
    this.terminatedThreadCount = terminatedThreadCount;
    return this;
  }

  /**
   * The count/size transferred to/from queues in the process group in the last 5 minutes.
   */
  public String getTransferred() {
    return transferred;
  }

  /**
   * The count/size transferred to/from queues in the process group in the last 5 minutes.
   */
  public ProcessGroupStatusSnapshotDTOBuilder setTransferred(final String transferred) {
    this.transferred = transferred;
    return this;
  }

  /**
   * The current state of the Process Group, as it relates to the Versioned Flow
   */
  public String getVersionedFlowState() {
    return versionedFlowState;
  }

  /**
   * The current state of the Process Group, as it relates to the Versioned Flow
   */
  public ProcessGroupStatusSnapshotDTOBuilder setVersionedFlowState(final String versionedFlowState) {
    this.versionedFlowState = versionedFlowState;
    return this;
  }

  /**
   * The number of bytes written in the last 5 minutes.
   */
  public String getWritten() {
    return written;
  }

  /**
   * The number of bytes written in the last 5 minutes.
   */
  public ProcessGroupStatusSnapshotDTOBuilder setWritten(final String written) {
    this.written = written;
    return this;
  }

  public ProcessGroupStatusSnapshotDTO build() {
    final ProcessGroupStatusSnapshotDTO processGroupStatusSnapshotDTO = new ProcessGroupStatusSnapshotDTO();
    processGroupStatusSnapshotDTO.setActiveThreadCount(activeThreadCount);
    processGroupStatusSnapshotDTO.setBytesIn(bytesIn);
    processGroupStatusSnapshotDTO.setBytesOut(bytesOut);
    processGroupStatusSnapshotDTO.setBytesQueued(bytesQueued);
    processGroupStatusSnapshotDTO.setBytesRead(bytesRead);
    processGroupStatusSnapshotDTO.setBytesReceived(bytesReceived);
    processGroupStatusSnapshotDTO.setBytesSent(bytesSent);
    processGroupStatusSnapshotDTO.setBytesTransferred(bytesTransferred);
    processGroupStatusSnapshotDTO.setBytesWritten(bytesWritten);
    processGroupStatusSnapshotDTO.setConnectionStatusSnapshots(connectionStatusSnapshots);
    processGroupStatusSnapshotDTO.setFlowFilesIn(flowFilesIn);
    processGroupStatusSnapshotDTO.setFlowFilesOut(flowFilesOut);
    processGroupStatusSnapshotDTO.setFlowFilesQueued(flowFilesQueued);
    processGroupStatusSnapshotDTO.setFlowFilesReceived(flowFilesReceived);
    processGroupStatusSnapshotDTO.setFlowFilesSent(flowFilesSent);
    processGroupStatusSnapshotDTO.setFlowFilesTransferred(flowFilesTransferred);
    processGroupStatusSnapshotDTO.setId(id);
    processGroupStatusSnapshotDTO.setInput(input);
    processGroupStatusSnapshotDTO.setInputPortStatusSnapshots(inputPortStatusSnapshots);
    processGroupStatusSnapshotDTO.setName(name);
    processGroupStatusSnapshotDTO.setOutput(output);
    processGroupStatusSnapshotDTO.setOutputPortStatusSnapshots(outputPortStatusSnapshots);
    processGroupStatusSnapshotDTO.setProcessGroupStatusSnapshots(processGroupStatusSnapshots);
    processGroupStatusSnapshotDTO.setProcessorStatusSnapshots(processorStatusSnapshots);
    processGroupStatusSnapshotDTO.setQueued(queued);
    processGroupStatusSnapshotDTO.setQueuedCount(queuedCount);
    processGroupStatusSnapshotDTO.setQueuedSize(queuedSize);
    processGroupStatusSnapshotDTO.setRead(read);
    processGroupStatusSnapshotDTO.setReceived(received);
    processGroupStatusSnapshotDTO.setRemoteProcessGroupStatusSnapshots(remoteProcessGroupStatusSnapshots);
    processGroupStatusSnapshotDTO.setSent(sent);
    processGroupStatusSnapshotDTO.setTerminatedThreadCount(terminatedThreadCount);
    processGroupStatusSnapshotDTO.setTransferred(transferred);
    processGroupStatusSnapshotDTO.setVersionedFlowState(versionedFlowState);
    processGroupStatusSnapshotDTO.setWritten(written);
    return processGroupStatusSnapshotDTO;
  }

  public static ProcessGroupStatusSnapshotDTOBuilder of(final ProcessGroupStatusSnapshotDTO processGroupStatusSnapshotDTO) {
    final ProcessGroupStatusSnapshotDTOBuilder processGroupStatusSnapshotDTOBuilder = new ProcessGroupStatusSnapshotDTOBuilder();
    processGroupStatusSnapshotDTOBuilder.setActiveThreadCount(processGroupStatusSnapshotDTO.getActiveThreadCount());
    processGroupStatusSnapshotDTOBuilder.setBytesIn(processGroupStatusSnapshotDTO.getBytesIn());
    processGroupStatusSnapshotDTOBuilder.setBytesOut(processGroupStatusSnapshotDTO.getBytesOut());
    processGroupStatusSnapshotDTOBuilder.setBytesQueued(processGroupStatusSnapshotDTO.getBytesQueued());
    processGroupStatusSnapshotDTOBuilder.setBytesRead(processGroupStatusSnapshotDTO.getBytesRead());
    processGroupStatusSnapshotDTOBuilder.setBytesReceived(processGroupStatusSnapshotDTO.getBytesReceived());
    processGroupStatusSnapshotDTOBuilder.setBytesSent(processGroupStatusSnapshotDTO.getBytesSent());
    processGroupStatusSnapshotDTOBuilder.setBytesTransferred(processGroupStatusSnapshotDTO.getBytesTransferred());
    processGroupStatusSnapshotDTOBuilder.setBytesWritten(processGroupStatusSnapshotDTO.getBytesWritten());
    processGroupStatusSnapshotDTOBuilder.setConnectionStatusSnapshots(processGroupStatusSnapshotDTO.getConnectionStatusSnapshots());
    processGroupStatusSnapshotDTOBuilder.setFlowFilesIn(processGroupStatusSnapshotDTO.getFlowFilesIn());
    processGroupStatusSnapshotDTOBuilder.setFlowFilesOut(processGroupStatusSnapshotDTO.getFlowFilesOut());
    processGroupStatusSnapshotDTOBuilder.setFlowFilesQueued(processGroupStatusSnapshotDTO.getFlowFilesQueued());
    processGroupStatusSnapshotDTOBuilder.setFlowFilesReceived(processGroupStatusSnapshotDTO.getFlowFilesReceived());
    processGroupStatusSnapshotDTOBuilder.setFlowFilesSent(processGroupStatusSnapshotDTO.getFlowFilesSent());
    processGroupStatusSnapshotDTOBuilder.setFlowFilesTransferred(processGroupStatusSnapshotDTO.getFlowFilesTransferred());
    processGroupStatusSnapshotDTOBuilder.setId(processGroupStatusSnapshotDTO.getId());
    processGroupStatusSnapshotDTOBuilder.setInput(processGroupStatusSnapshotDTO.getInput());
    processGroupStatusSnapshotDTOBuilder.setInputPortStatusSnapshots(processGroupStatusSnapshotDTO.getInputPortStatusSnapshots());
    processGroupStatusSnapshotDTOBuilder.setName(processGroupStatusSnapshotDTO.getName());
    processGroupStatusSnapshotDTOBuilder.setOutput(processGroupStatusSnapshotDTO.getOutput());
    processGroupStatusSnapshotDTOBuilder.setOutputPortStatusSnapshots(processGroupStatusSnapshotDTO.getOutputPortStatusSnapshots());
    processGroupStatusSnapshotDTOBuilder.setProcessGroupStatusSnapshots(processGroupStatusSnapshotDTO.getProcessGroupStatusSnapshots());
    processGroupStatusSnapshotDTOBuilder.setProcessorStatusSnapshots(processGroupStatusSnapshotDTO.getProcessorStatusSnapshots());
    processGroupStatusSnapshotDTOBuilder.setQueued(processGroupStatusSnapshotDTO.getQueued());
    processGroupStatusSnapshotDTOBuilder.setQueuedCount(processGroupStatusSnapshotDTO.getQueuedCount());
    processGroupStatusSnapshotDTOBuilder.setQueuedSize(processGroupStatusSnapshotDTO.getQueuedSize());
    processGroupStatusSnapshotDTOBuilder.setRead(processGroupStatusSnapshotDTO.getRead());
    processGroupStatusSnapshotDTOBuilder.setReceived(processGroupStatusSnapshotDTO.getReceived());
    processGroupStatusSnapshotDTOBuilder.setRemoteProcessGroupStatusSnapshots(processGroupStatusSnapshotDTO.getRemoteProcessGroupStatusSnapshots());
    processGroupStatusSnapshotDTOBuilder.setSent(processGroupStatusSnapshotDTO.getSent());
    processGroupStatusSnapshotDTOBuilder.setTerminatedThreadCount(processGroupStatusSnapshotDTO.getTerminatedThreadCount());
    processGroupStatusSnapshotDTOBuilder.setTransferred(processGroupStatusSnapshotDTO.getTransferred());
    processGroupStatusSnapshotDTOBuilder.setVersionedFlowState(processGroupStatusSnapshotDTO.getVersionedFlowState());
    processGroupStatusSnapshotDTOBuilder.setWritten(processGroupStatusSnapshotDTO.getWritten());
    return processGroupStatusSnapshotDTOBuilder;
  }
}
