package com.tibtech.nifi.web.api.dto.diagnostics;

import java.lang.Integer;
import java.lang.String;
import org.apache.nifi.web.api.dto.diagnostics.ThreadDumpDTO;

public final class ThreadDumpDTOBuilder {
  private Integer apiPort;

  private String nodeAddress;

  private String nodeId;

  private String stackTrace;

  private boolean taskTerminated;

  private long threadActiveMillis;

  private String threadName;

  /**
   * The port the node is listening for API requests.
   */
  public Integer getApiPort() {
    return apiPort;
  }

  /**
   * The port the node is listening for API requests.
   */
  public ThreadDumpDTOBuilder setApiPort(final Integer apiPort) {
    this.apiPort = apiPort;
    return this;
  }

  /**
   * The address of the node in the cluster
   */
  public String getNodeAddress() {
    return nodeAddress;
  }

  /**
   * The address of the node in the cluster
   */
  public ThreadDumpDTOBuilder setNodeAddress(final String nodeAddress) {
    this.nodeAddress = nodeAddress;
    return this;
  }

  /**
   * The ID of the node in the cluster
   */
  public String getNodeId() {
    return nodeId;
  }

  /**
   * The ID of the node in the cluster
   */
  public ThreadDumpDTOBuilder setNodeId(final String nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /**
   * The stack trace for the thread
   */
  public String getStackTrace() {
    return stackTrace;
  }

  /**
   * The stack trace for the thread
   */
  public ThreadDumpDTOBuilder setStackTrace(final String stackTrace) {
    this.stackTrace = stackTrace;
    return this;
  }

  /**
   * Indicates whether or not the user has requested that the task be terminated. If this is true, it may indicate that the thread is in a state where it will continue running indefinitely without returning.
   */
  public boolean getTaskTerminated() {
    return taskTerminated;
  }

  /**
   * Indicates whether or not the user has requested that the task be terminated. If this is true, it may indicate that the thread is in a state where it will continue running indefinitely without returning.
   */
  public ThreadDumpDTOBuilder setTaskTerminated(final boolean taskTerminated) {
    this.taskTerminated = taskTerminated;
    return this;
  }

  /**
   * The number of milliseconds that the thread has been executing in the Processor
   */
  public long getThreadActiveMillis() {
    return threadActiveMillis;
  }

  /**
   * The number of milliseconds that the thread has been executing in the Processor
   */
  public ThreadDumpDTOBuilder setThreadActiveMillis(final long threadActiveMillis) {
    this.threadActiveMillis = threadActiveMillis;
    return this;
  }

  /**
   * The name of the thread
   */
  public String getThreadName() {
    return threadName;
  }

  /**
   * The name of the thread
   */
  public ThreadDumpDTOBuilder setThreadName(final String threadName) {
    this.threadName = threadName;
    return this;
  }

  public ThreadDumpDTO build() {
    final ThreadDumpDTO threadDumpDTO = new ThreadDumpDTO();
    threadDumpDTO.setApiPort(apiPort);
    threadDumpDTO.setNodeAddress(nodeAddress);
    threadDumpDTO.setNodeId(nodeId);
    threadDumpDTO.setStackTrace(stackTrace);
    threadDumpDTO.setTaskTerminated(taskTerminated);
    threadDumpDTO.setThreadActiveMillis(threadActiveMillis);
    threadDumpDTO.setThreadName(threadName);
    return threadDumpDTO;
  }

  public static ThreadDumpDTOBuilder of(final ThreadDumpDTO threadDumpDTO) {
    final ThreadDumpDTOBuilder threadDumpDTOBuilder = new ThreadDumpDTOBuilder();
    threadDumpDTOBuilder.setApiPort(threadDumpDTO.getApiPort());
    threadDumpDTOBuilder.setNodeAddress(threadDumpDTO.getNodeAddress());
    threadDumpDTOBuilder.setNodeId(threadDumpDTO.getNodeId());
    threadDumpDTOBuilder.setStackTrace(threadDumpDTO.getStackTrace());
    threadDumpDTOBuilder.setTaskTerminated(threadDumpDTO.isTaskTerminated());
    threadDumpDTOBuilder.setThreadActiveMillis(threadDumpDTO.getThreadActiveMillis());
    threadDumpDTOBuilder.setThreadName(threadDumpDTO.getThreadName());
    return threadDumpDTOBuilder;
  }
}
