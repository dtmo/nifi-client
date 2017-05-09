package com.tibtech.nifi.web.api.dto;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Integer;
import java.lang.String;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.FlowSnippetDTO;
import org.apache.nifi.web.api.dto.ProcessGroupDTO;

public final class ProcessGroupDTOBuilder extends AbstractComponentDTOBuilder<ProcessGroupDTOBuilder> {
  private Integer activeRemotePortCount;

  private String comments;

  private FlowSnippetDTO contents;

  private Integer disabledCount;

  private Integer inactiveRemotePortCount;

  private Integer inputPortCount;

  private Integer invalidCount;

  private String name;

  private Integer outputPortCount;

  private Integer runningCount;

  private Integer stoppedCount;

  /**
   * The number of active remote ports in the process group.
   */
  public Integer getActiveRemotePortCount() {
    return activeRemotePortCount;
  }

  /**
   * The number of active remote ports in the process group.
   */
  public ProcessGroupDTOBuilder setActiveRemotePortCount(final Integer activeRemotePortCount) {
    this.activeRemotePortCount = activeRemotePortCount;
    return this;
  }

  /**
   * The comments for the process group.
   */
  public String getComments() {
    return comments;
  }

  /**
   * The comments for the process group.
   */
  public ProcessGroupDTOBuilder setComments(final String comments) {
    this.comments = comments;
    return this;
  }

  /**
   * The contents of this process group.
   */
  public FlowSnippetDTO getContents() {
    return contents;
  }

  /**
   * The contents of this process group.
   */
  public ProcessGroupDTOBuilder setContents(final FlowSnippetDTO contents) {
    this.contents = contents;
    return this;
  }

  /**
   * The contents of this process group.
   */
  public ProcessGroupDTOBuilder setContents(final Consumer<FlowSnippetDTOBuilder> configurator) {
    final FlowSnippetDTOBuilder builder = (contents != null ? FlowSnippetDTOBuilder.of(contents) : new FlowSnippetDTOBuilder());
    configurator.accept(builder);
    return setContents(builder.build());
  }

  /**
   * The contents of this process group.
   */
  public ProcessGroupDTOBuilder setContents(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FlowSnippetDTOBuilder.class) final Closure<FlowSnippetDTOBuilder> closure) {
    return setContents(c -> {
      final Closure<FlowSnippetDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * The number of disabled components in the process group.
   */
  public Integer getDisabledCount() {
    return disabledCount;
  }

  /**
   * The number of disabled components in the process group.
   */
  public ProcessGroupDTOBuilder setDisabledCount(final Integer disabledCount) {
    this.disabledCount = disabledCount;
    return this;
  }

  /**
   * The number of inactive remote ports in the process group.
   */
  public Integer getInactiveRemotePortCount() {
    return inactiveRemotePortCount;
  }

  /**
   * The number of inactive remote ports in the process group.
   */
  public ProcessGroupDTOBuilder setInactiveRemotePortCount(final Integer inactiveRemotePortCount) {
    this.inactiveRemotePortCount = inactiveRemotePortCount;
    return this;
  }

  /**
   * The number of input ports in the process group.
   */
  public Integer getInputPortCount() {
    return inputPortCount;
  }

  /**
   * The number of input ports in the process group.
   */
  public ProcessGroupDTOBuilder setInputPortCount(final Integer inputPortCount) {
    this.inputPortCount = inputPortCount;
    return this;
  }

  /**
   * The number of invalid components in the process group.
   */
  public Integer getInvalidCount() {
    return invalidCount;
  }

  /**
   * The number of invalid components in the process group.
   */
  public ProcessGroupDTOBuilder setInvalidCount(final Integer invalidCount) {
    this.invalidCount = invalidCount;
    return this;
  }

  /**
   * The name of the process group.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the process group.
   */
  public ProcessGroupDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * The number of output ports in the process group.
   */
  public Integer getOutputPortCount() {
    return outputPortCount;
  }

  /**
   * The number of output ports in the process group.
   */
  public ProcessGroupDTOBuilder setOutputPortCount(final Integer outputPortCount) {
    this.outputPortCount = outputPortCount;
    return this;
  }

  /**
   * The number of running components in this process group.
   */
  public Integer getRunningCount() {
    return runningCount;
  }

  /**
   * The number of running components in this process group.
   */
  public ProcessGroupDTOBuilder setRunningCount(final Integer runningCount) {
    this.runningCount = runningCount;
    return this;
  }

  /**
   * The number of stopped components in the process group.
   */
  public Integer getStoppedCount() {
    return stoppedCount;
  }

  /**
   * The number of stopped components in the process group.
   */
  public ProcessGroupDTOBuilder setStoppedCount(final Integer stoppedCount) {
    this.stoppedCount = stoppedCount;
    return this;
  }

  public ProcessGroupDTO build() {
    final ProcessGroupDTO processGroupDTO = new ProcessGroupDTO();
    super.setPropertyValues(processGroupDTO);
    processGroupDTO.setActiveRemotePortCount(activeRemotePortCount);
    processGroupDTO.setComments(comments);
    processGroupDTO.setContents(contents);
    processGroupDTO.setDisabledCount(disabledCount);
    processGroupDTO.setInactiveRemotePortCount(inactiveRemotePortCount);
    processGroupDTO.setInputPortCount(inputPortCount);
    processGroupDTO.setInvalidCount(invalidCount);
    processGroupDTO.setName(name);
    processGroupDTO.setOutputPortCount(outputPortCount);
    processGroupDTO.setRunningCount(runningCount);
    processGroupDTO.setStoppedCount(stoppedCount);
    return processGroupDTO;
  }

  public static ProcessGroupDTOBuilder of(final ProcessGroupDTO processGroupDTO) {
    final ProcessGroupDTOBuilder processGroupDTOBuilder = new ProcessGroupDTOBuilder();
    AbstractComponentDTOBuilder.setBuilderValues(processGroupDTOBuilder, processGroupDTO);
    processGroupDTOBuilder.setActiveRemotePortCount(processGroupDTO.getActiveRemotePortCount());
    processGroupDTOBuilder.setComments(processGroupDTO.getComments());
    processGroupDTOBuilder.setContents(processGroupDTO.getContents());
    processGroupDTOBuilder.setDisabledCount(processGroupDTO.getDisabledCount());
    processGroupDTOBuilder.setInactiveRemotePortCount(processGroupDTO.getInactiveRemotePortCount());
    processGroupDTOBuilder.setInputPortCount(processGroupDTO.getInputPortCount());
    processGroupDTOBuilder.setInvalidCount(processGroupDTO.getInvalidCount());
    processGroupDTOBuilder.setName(processGroupDTO.getName());
    processGroupDTOBuilder.setOutputPortCount(processGroupDTO.getOutputPortCount());
    processGroupDTOBuilder.setRunningCount(processGroupDTO.getRunningCount());
    processGroupDTOBuilder.setStoppedCount(processGroupDTO.getStoppedCount());
    return processGroupDTOBuilder;
  }
}
