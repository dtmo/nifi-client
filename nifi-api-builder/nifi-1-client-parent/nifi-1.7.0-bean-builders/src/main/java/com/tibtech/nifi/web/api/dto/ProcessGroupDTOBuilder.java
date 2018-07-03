package com.tibtech.nifi.web.api.dto;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Integer;
import java.lang.String;
import java.util.Map;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.FlowSnippetDTO;
import org.apache.nifi.web.api.dto.ProcessGroupDTO;
import org.apache.nifi.web.api.dto.VersionControlInformationDTO;

public final class ProcessGroupDTOBuilder extends AbstractComponentDTOBuilder<ProcessGroupDTOBuilder> {
  private Integer activeRemotePortCount;

  private String comments;

  private FlowSnippetDTO contents;

  private Integer disabledCount;

  private Integer inactiveRemotePortCount;

  private Integer inputPortCount;

  private Integer invalidCount;

  private Integer locallyModifiedAndStaleCount;

  private Integer locallyModifiedCount;

  private String name;

  private Integer outputPortCount;

  private Integer runningCount;

  private Integer staleCount;

  private Integer stoppedCount;

  private Integer syncFailureCount;

  private Integer upToDateCount;

  private Map<String, String> variables;

  private VersionControlInformationDTO versionControlInformation;

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
   * The number of locally modified and stale versioned process groups in the process group.
   */
  public Integer getLocallyModifiedAndStaleCount() {
    return locallyModifiedAndStaleCount;
  }

  /**
   * The number of locally modified and stale versioned process groups in the process group.
   */
  public ProcessGroupDTOBuilder setLocallyModifiedAndStaleCount(final Integer locallyModifiedAndStaleCount) {
    this.locallyModifiedAndStaleCount = locallyModifiedAndStaleCount;
    return this;
  }

  /**
   * The number of locally modified versioned process groups in the process group.
   */
  public Integer getLocallyModifiedCount() {
    return locallyModifiedCount;
  }

  /**
   * The number of locally modified versioned process groups in the process group.
   */
  public ProcessGroupDTOBuilder setLocallyModifiedCount(final Integer locallyModifiedCount) {
    this.locallyModifiedCount = locallyModifiedCount;
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
   * The number of stale versioned process groups in the process group.
   */
  public Integer getStaleCount() {
    return staleCount;
  }

  /**
   * The number of stale versioned process groups in the process group.
   */
  public ProcessGroupDTOBuilder setStaleCount(final Integer staleCount) {
    this.staleCount = staleCount;
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

  /**
   * The number of versioned process groups in the process group that are unable to sync to a registry.
   */
  public Integer getSyncFailureCount() {
    return syncFailureCount;
  }

  /**
   * The number of versioned process groups in the process group that are unable to sync to a registry.
   */
  public ProcessGroupDTOBuilder setSyncFailureCount(final Integer syncFailureCount) {
    this.syncFailureCount = syncFailureCount;
    return this;
  }

  /**
   * The number of up to date versioned process groups in the process group.
   */
  public Integer getUpToDateCount() {
    return upToDateCount;
  }

  /**
   * The number of up to date versioned process groups in the process group.
   */
  public ProcessGroupDTOBuilder setUpToDateCount(final Integer upToDateCount) {
    this.upToDateCount = upToDateCount;
    return this;
  }

  /**
   * The variables that are configured for the Process Group. Note that this map contains only those variables that are defined on this Process Group and not any variables that are defined in the parent Process Group, etc. I.e., this Map will not contain all variables that are accessible by components in this Process Group by rather only the variables that are defined for this Process Group itself.
   */
  public Map<String, String> getVariables() {
    return variables;
  }

  /**
   * The variables that are configured for the Process Group. Note that this map contains only those variables that are defined on this Process Group and not any variables that are defined in the parent Process Group, etc. I.e., this Map will not contain all variables that are accessible by components in this Process Group by rather only the variables that are defined for this Process Group itself.
   */
  public ProcessGroupDTOBuilder setVariables(final Map<String, String> variables) {
    this.variables = variables;
    return this;
  }

  /**
   * The Version Control information that indicates which Flow Registry, and where in the Flow Registry, this Process Group is tracking to; or null if this Process Group is not under version control
   */
  public VersionControlInformationDTO getVersionControlInformation() {
    return versionControlInformation;
  }

  /**
   * The Version Control information that indicates which Flow Registry, and where in the Flow Registry, this Process Group is tracking to; or null if this Process Group is not under version control
   */
  public ProcessGroupDTOBuilder setVersionControlInformation(final VersionControlInformationDTO versionControlInformation) {
    this.versionControlInformation = versionControlInformation;
    return this;
  }

  /**
   * The Version Control information that indicates which Flow Registry, and where in the Flow Registry, this Process Group is tracking to; or null if this Process Group is not under version control
   */
  public ProcessGroupDTOBuilder setVersionControlInformation(final Consumer<VersionControlInformationDTOBuilder> configurator) {
    final VersionControlInformationDTOBuilder builder = (versionControlInformation != null ? VersionControlInformationDTOBuilder.of(versionControlInformation) : new VersionControlInformationDTOBuilder());
    configurator.accept(builder);
    return setVersionControlInformation(builder.build());
  }

  /**
   * The Version Control information that indicates which Flow Registry, and where in the Flow Registry, this Process Group is tracking to; or null if this Process Group is not under version control
   */
  public ProcessGroupDTOBuilder setVersionControlInformation(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = VersionControlInformationDTOBuilder.class) final Closure<VersionControlInformationDTOBuilder> closure) {
    return setVersionControlInformation(c -> {
      final Closure<VersionControlInformationDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
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
    processGroupDTO.setLocallyModifiedAndStaleCount(locallyModifiedAndStaleCount);
    processGroupDTO.setLocallyModifiedCount(locallyModifiedCount);
    processGroupDTO.setName(name);
    processGroupDTO.setOutputPortCount(outputPortCount);
    processGroupDTO.setRunningCount(runningCount);
    processGroupDTO.setStaleCount(staleCount);
    processGroupDTO.setStoppedCount(stoppedCount);
    processGroupDTO.setSyncFailureCount(syncFailureCount);
    processGroupDTO.setUpToDateCount(upToDateCount);
    processGroupDTO.setVariables(variables);
    processGroupDTO.setVersionControlInformation(versionControlInformation);
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
    processGroupDTOBuilder.setLocallyModifiedAndStaleCount(processGroupDTO.getLocallyModifiedAndStaleCount());
    processGroupDTOBuilder.setLocallyModifiedCount(processGroupDTO.getLocallyModifiedCount());
    processGroupDTOBuilder.setName(processGroupDTO.getName());
    processGroupDTOBuilder.setOutputPortCount(processGroupDTO.getOutputPortCount());
    processGroupDTOBuilder.setRunningCount(processGroupDTO.getRunningCount());
    processGroupDTOBuilder.setStaleCount(processGroupDTO.getStaleCount());
    processGroupDTOBuilder.setStoppedCount(processGroupDTO.getStoppedCount());
    processGroupDTOBuilder.setSyncFailureCount(processGroupDTO.getSyncFailureCount());
    processGroupDTOBuilder.setUpToDateCount(processGroupDTO.getUpToDateCount());
    processGroupDTOBuilder.setVariables(processGroupDTO.getVariables());
    processGroupDTOBuilder.setVersionControlInformation(processGroupDTO.getVersionControlInformation());
    return processGroupDTOBuilder;
  }
}
