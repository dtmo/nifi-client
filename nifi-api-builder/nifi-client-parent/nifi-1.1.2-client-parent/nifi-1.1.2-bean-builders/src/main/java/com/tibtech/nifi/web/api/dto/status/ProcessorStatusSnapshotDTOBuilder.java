package com.tibtech.nifi.web.api.dto.status;

import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import org.apache.nifi.web.api.dto.status.ProcessorStatusSnapshotDTO;

public final class ProcessorStatusSnapshotDTOBuilder {
  private Integer activeThreadCount;

  private Long bytesIn;

  private Long bytesOut;

  private Long bytesRead;

  private Long bytesWritten;

  private Integer flowFilesIn;

  private Integer flowFilesOut;

  private String groupId;

  private String id;

  private String input;

  private String name;

  private String output;

  private String read;

  private String runStatus;

  private Integer taskCount;

  private String tasks;

  private String tasksDuration;

  private Long tasksDurationNanos;

  private String type;

  private String written;

  /**
   * The number of threads currently executing in the processor.
   */
  public Integer getActiveThreadCount() {
    return activeThreadCount;
  }

  /**
   * The number of threads currently executing in the processor.
   */
  public ProcessorStatusSnapshotDTOBuilder setActiveThreadCount(final Integer activeThreadCount) {
    this.activeThreadCount = activeThreadCount;
    return this;
  }

  /**
   * The size of the FlowFiles that have been accepted in the last 5 minutes
   */
  public Long getBytesIn() {
    return bytesIn;
  }

  /**
   * The size of the FlowFiles that have been accepted in the last 5 minutes
   */
  public ProcessorStatusSnapshotDTOBuilder setBytesIn(final Long bytesIn) {
    this.bytesIn = bytesIn;
    return this;
  }

  /**
   * The size of the FlowFiles transferred to a Connection in the last 5 minutes
   */
  public Long getBytesOut() {
    return bytesOut;
  }

  /**
   * The size of the FlowFiles transferred to a Connection in the last 5 minutes
   */
  public ProcessorStatusSnapshotDTOBuilder setBytesOut(final Long bytesOut) {
    this.bytesOut = bytesOut;
    return this;
  }

  /**
   * The number of bytes read by this Processor in the last 5 mintues
   */
  public Long getBytesRead() {
    return bytesRead;
  }

  /**
   * The number of bytes read by this Processor in the last 5 mintues
   */
  public ProcessorStatusSnapshotDTOBuilder setBytesRead(final Long bytesRead) {
    this.bytesRead = bytesRead;
    return this;
  }

  /**
   * The number of bytes written by this Processor in the last 5 minutes
   */
  public Long getBytesWritten() {
    return bytesWritten;
  }

  /**
   * The number of bytes written by this Processor in the last 5 minutes
   */
  public ProcessorStatusSnapshotDTOBuilder setBytesWritten(final Long bytesWritten) {
    this.bytesWritten = bytesWritten;
    return this;
  }

  /**
   * The number of FlowFiles that have been accepted in the last 5 minutes
   */
  public Integer getFlowFilesIn() {
    return flowFilesIn;
  }

  /**
   * The number of FlowFiles that have been accepted in the last 5 minutes
   */
  public ProcessorStatusSnapshotDTOBuilder setFlowFilesIn(final Integer flowFilesIn) {
    this.flowFilesIn = flowFilesIn;
    return this;
  }

  /**
   * The number of FlowFiles transferred to a Connection in the last 5 minutes
   */
  public Integer getFlowFilesOut() {
    return flowFilesOut;
  }

  /**
   * The number of FlowFiles transferred to a Connection in the last 5 minutes
   */
  public ProcessorStatusSnapshotDTOBuilder setFlowFilesOut(final Integer flowFilesOut) {
    this.flowFilesOut = flowFilesOut;
    return this;
  }

  /**
   * The id of the parent process group to which the processor belongs.
   */
  public String getGroupId() {
    return groupId;
  }

  /**
   * The id of the parent process group to which the processor belongs.
   */
  public ProcessorStatusSnapshotDTOBuilder setGroupId(final String groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * The id of the processor.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the processor.
   */
  public ProcessorStatusSnapshotDTOBuilder setId(final String id) {
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
  public ProcessorStatusSnapshotDTOBuilder setInput(final String input) {
    this.input = input;
    return this;
  }

  /**
   * The name of the prcessor.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the prcessor.
   */
  public ProcessorStatusSnapshotDTOBuilder setName(final String name) {
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
  public ProcessorStatusSnapshotDTOBuilder setOutput(final String output) {
    this.output = output;
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
  public ProcessorStatusSnapshotDTOBuilder setRead(final String read) {
    this.read = read;
    return this;
  }

  /**
   * The state of the processor.
   */
  public String getRunStatus() {
    return runStatus;
  }

  /**
   * The state of the processor.
   */
  public ProcessorStatusSnapshotDTOBuilder setRunStatus(final String runStatus) {
    this.runStatus = runStatus;
    return this;
  }

  /**
   * The number of times this Processor has run in the last 5 minutes
   */
  public Integer getTaskCount() {
    return taskCount;
  }

  /**
   * The number of times this Processor has run in the last 5 minutes
   */
  public ProcessorStatusSnapshotDTOBuilder setTaskCount(final Integer taskCount) {
    this.taskCount = taskCount;
    return this;
  }

  /**
   * The total number of task this connectable has completed over the last 5 minutes.
   */
  public String getTasks() {
    return tasks;
  }

  /**
   * The total number of task this connectable has completed over the last 5 minutes.
   */
  public ProcessorStatusSnapshotDTOBuilder setTasks(final String tasks) {
    this.tasks = tasks;
    return this;
  }

  /**
   * The total duration of all tasks for this connectable over the last 5 minutes.
   */
  public String getTasksDuration() {
    return tasksDuration;
  }

  /**
   * The total duration of all tasks for this connectable over the last 5 minutes.
   */
  public ProcessorStatusSnapshotDTOBuilder setTasksDuration(final String tasksDuration) {
    this.tasksDuration = tasksDuration;
    return this;
  }

  /**
   * The number of nanoseconds that this Processor has spent running in the last 5 minutes
   */
  public Long getTasksDurationNanos() {
    return tasksDurationNanos;
  }

  /**
   * The number of nanoseconds that this Processor has spent running in the last 5 minutes
   */
  public ProcessorStatusSnapshotDTOBuilder setTasksDurationNanos(final Long tasksDurationNanos) {
    this.tasksDurationNanos = tasksDurationNanos;
    return this;
  }

  /**
   * The type of the processor.
   */
  public String getType() {
    return type;
  }

  /**
   * The type of the processor.
   */
  public ProcessorStatusSnapshotDTOBuilder setType(final String type) {
    this.type = type;
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
  public ProcessorStatusSnapshotDTOBuilder setWritten(final String written) {
    this.written = written;
    return this;
  }

  public ProcessorStatusSnapshotDTO build() {
    final ProcessorStatusSnapshotDTO processorStatusSnapshotDTO = new ProcessorStatusSnapshotDTO();
    processorStatusSnapshotDTO.setActiveThreadCount(activeThreadCount);
    processorStatusSnapshotDTO.setBytesIn(bytesIn);
    processorStatusSnapshotDTO.setBytesOut(bytesOut);
    processorStatusSnapshotDTO.setBytesRead(bytesRead);
    processorStatusSnapshotDTO.setBytesWritten(bytesWritten);
    processorStatusSnapshotDTO.setFlowFilesIn(flowFilesIn);
    processorStatusSnapshotDTO.setFlowFilesOut(flowFilesOut);
    processorStatusSnapshotDTO.setGroupId(groupId);
    processorStatusSnapshotDTO.setId(id);
    processorStatusSnapshotDTO.setInput(input);
    processorStatusSnapshotDTO.setName(name);
    processorStatusSnapshotDTO.setOutput(output);
    processorStatusSnapshotDTO.setRead(read);
    processorStatusSnapshotDTO.setRunStatus(runStatus);
    processorStatusSnapshotDTO.setTaskCount(taskCount);
    processorStatusSnapshotDTO.setTasks(tasks);
    processorStatusSnapshotDTO.setTasksDuration(tasksDuration);
    processorStatusSnapshotDTO.setTasksDurationNanos(tasksDurationNanos);
    processorStatusSnapshotDTO.setType(type);
    processorStatusSnapshotDTO.setWritten(written);
    return processorStatusSnapshotDTO;
  }

  public static ProcessorStatusSnapshotDTOBuilder of(final ProcessorStatusSnapshotDTO processorStatusSnapshotDTO) {
    final ProcessorStatusSnapshotDTOBuilder processorStatusSnapshotDTOBuilder = new ProcessorStatusSnapshotDTOBuilder();
    processorStatusSnapshotDTOBuilder.setActiveThreadCount(processorStatusSnapshotDTO.getActiveThreadCount());
    processorStatusSnapshotDTOBuilder.setBytesIn(processorStatusSnapshotDTO.getBytesIn());
    processorStatusSnapshotDTOBuilder.setBytesOut(processorStatusSnapshotDTO.getBytesOut());
    processorStatusSnapshotDTOBuilder.setBytesRead(processorStatusSnapshotDTO.getBytesRead());
    processorStatusSnapshotDTOBuilder.setBytesWritten(processorStatusSnapshotDTO.getBytesWritten());
    processorStatusSnapshotDTOBuilder.setFlowFilesIn(processorStatusSnapshotDTO.getFlowFilesIn());
    processorStatusSnapshotDTOBuilder.setFlowFilesOut(processorStatusSnapshotDTO.getFlowFilesOut());
    processorStatusSnapshotDTOBuilder.setGroupId(processorStatusSnapshotDTO.getGroupId());
    processorStatusSnapshotDTOBuilder.setId(processorStatusSnapshotDTO.getId());
    processorStatusSnapshotDTOBuilder.setInput(processorStatusSnapshotDTO.getInput());
    processorStatusSnapshotDTOBuilder.setName(processorStatusSnapshotDTO.getName());
    processorStatusSnapshotDTOBuilder.setOutput(processorStatusSnapshotDTO.getOutput());
    processorStatusSnapshotDTOBuilder.setRead(processorStatusSnapshotDTO.getRead());
    processorStatusSnapshotDTOBuilder.setRunStatus(processorStatusSnapshotDTO.getRunStatus());
    processorStatusSnapshotDTOBuilder.setTaskCount(processorStatusSnapshotDTO.getTaskCount());
    processorStatusSnapshotDTOBuilder.setTasks(processorStatusSnapshotDTO.getTasks());
    processorStatusSnapshotDTOBuilder.setTasksDuration(processorStatusSnapshotDTO.getTasksDuration());
    processorStatusSnapshotDTOBuilder.setTasksDurationNanos(processorStatusSnapshotDTO.getTasksDurationNanos());
    processorStatusSnapshotDTOBuilder.setType(processorStatusSnapshotDTO.getType());
    processorStatusSnapshotDTOBuilder.setWritten(processorStatusSnapshotDTO.getWritten());
    return processorStatusSnapshotDTOBuilder;
  }
}
