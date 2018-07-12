package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import java.util.Map;
import org.apache.nifi.web.api.dto.RevisionDTO;
import org.apache.nifi.web.api.dto.SnippetDTO;

public final class SnippetDTOBuilder {
  private Map<String, RevisionDTO> connections;

  private Map<String, RevisionDTO> funnels;

  private String id;

  private Map<String, RevisionDTO> inputPorts;

  private Map<String, RevisionDTO> labels;

  private Map<String, RevisionDTO> outputPorts;

  private String parentGroupId;

  private Map<String, RevisionDTO> processGroups;

  private Map<String, RevisionDTO> processors;

  private Map<String, RevisionDTO> remoteProcessGroups;

  private String uri;

  /**
   * The ids of the connections in this snippet. These ids will be populated within each response. They can be specified when creating a snippet. However, once a snippet has been created its contents cannot be modified (these ids are ignored during update requests).
   */
  public Map<String, RevisionDTO> getConnections() {
    return connections;
  }

  /**
   * The ids of the connections in this snippet. These ids will be populated within each response. They can be specified when creating a snippet. However, once a snippet has been created its contents cannot be modified (these ids are ignored during update requests).
   */
  public SnippetDTOBuilder setConnections(final Map<String, RevisionDTO> connections) {
    this.connections = connections;
    return this;
  }

  /**
   * The ids of the funnels in this snippet. These ids will be populated within each response. They can be specified when creating a snippet. However, once a snippet has been created its contents cannot be modified (these ids are ignored during update requests).
   */
  public Map<String, RevisionDTO> getFunnels() {
    return funnels;
  }

  /**
   * The ids of the funnels in this snippet. These ids will be populated within each response. They can be specified when creating a snippet. However, once a snippet has been created its contents cannot be modified (these ids are ignored during update requests).
   */
  public SnippetDTOBuilder setFunnels(final Map<String, RevisionDTO> funnels) {
    this.funnels = funnels;
    return this;
  }

  /**
   * The id of the snippet.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the snippet.
   */
  public SnippetDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The ids of the input ports in this snippet. These ids will be populated within each response. They can be specified when creating a snippet. However, once a snippet has been created its contents cannot be modified (these ids are ignored during update requests).
   */
  public Map<String, RevisionDTO> getInputPorts() {
    return inputPorts;
  }

  /**
   * The ids of the input ports in this snippet. These ids will be populated within each response. They can be specified when creating a snippet. However, once a snippet has been created its contents cannot be modified (these ids are ignored during update requests).
   */
  public SnippetDTOBuilder setInputPorts(final Map<String, RevisionDTO> inputPorts) {
    this.inputPorts = inputPorts;
    return this;
  }

  /**
   * The ids of the labels in this snippet. These ids will be populated within each response. They can be specified when creating a snippet. However, once a snippet has been created its contents cannot be modified (these ids are ignored during update requests).
   */
  public Map<String, RevisionDTO> getLabels() {
    return labels;
  }

  /**
   * The ids of the labels in this snippet. These ids will be populated within each response. They can be specified when creating a snippet. However, once a snippet has been created its contents cannot be modified (these ids are ignored during update requests).
   */
  public SnippetDTOBuilder setLabels(final Map<String, RevisionDTO> labels) {
    this.labels = labels;
    return this;
  }

  /**
   * The ids of the output ports in this snippet. These ids will be populated within each response. They can be specified when creating a snippet. However, once a snippet has been created its contents cannot be modified (these ids are ignored during update requests).
   */
  public Map<String, RevisionDTO> getOutputPorts() {
    return outputPorts;
  }

  /**
   * The ids of the output ports in this snippet. These ids will be populated within each response. They can be specified when creating a snippet. However, once a snippet has been created its contents cannot be modified (these ids are ignored during update requests).
   */
  public SnippetDTOBuilder setOutputPorts(final Map<String, RevisionDTO> outputPorts) {
    this.outputPorts = outputPorts;
    return this;
  }

  /**
   * The group id for the components in the snippet.
   */
  public String getParentGroupId() {
    return parentGroupId;
  }

  /**
   * The group id for the components in the snippet.
   */
  public SnippetDTOBuilder setParentGroupId(final String parentGroupId) {
    this.parentGroupId = parentGroupId;
    return this;
  }

  /**
   * The ids of the process groups in this snippet. These ids will be populated within each response. They can be specified when creating a snippet. However, once a snippet has been created its contents cannot be modified (these ids are ignored during update requests).
   */
  public Map<String, RevisionDTO> getProcessGroups() {
    return processGroups;
  }

  /**
   * The ids of the process groups in this snippet. These ids will be populated within each response. They can be specified when creating a snippet. However, once a snippet has been created its contents cannot be modified (these ids are ignored during update requests).
   */
  public SnippetDTOBuilder setProcessGroups(final Map<String, RevisionDTO> processGroups) {
    this.processGroups = processGroups;
    return this;
  }

  /**
   * The ids of the processors in this snippet. These ids will be populated within each response. They can be specified when creating a snippet. However, once a snippet has been created its contents cannot be modified (these ids are ignored during update requests).
   */
  public Map<String, RevisionDTO> getProcessors() {
    return processors;
  }

  /**
   * The ids of the processors in this snippet. These ids will be populated within each response. They can be specified when creating a snippet. However, once a snippet has been created its contents cannot be modified (these ids are ignored during update requests).
   */
  public SnippetDTOBuilder setProcessors(final Map<String, RevisionDTO> processors) {
    this.processors = processors;
    return this;
  }

  /**
   * The ids of the remote process groups in this snippet. These ids will be populated within each response. They can be specified when creating a snippet. However, once a snippet has been created its contents cannot be modified (these ids are ignored during update requests).
   */
  public Map<String, RevisionDTO> getRemoteProcessGroups() {
    return remoteProcessGroups;
  }

  /**
   * The ids of the remote process groups in this snippet. These ids will be populated within each response. They can be specified when creating a snippet. However, once a snippet has been created its contents cannot be modified (these ids are ignored during update requests).
   */
  public SnippetDTOBuilder setRemoteProcessGroups(
      final Map<String, RevisionDTO> remoteProcessGroups) {
    this.remoteProcessGroups = remoteProcessGroups;
    return this;
  }

  /**
   * The URI of the snippet.
   */
  public String getUri() {
    return uri;
  }

  /**
   * The URI of the snippet.
   */
  public SnippetDTOBuilder setUri(final String uri) {
    this.uri = uri;
    return this;
  }

  public SnippetDTO build() {
    final SnippetDTO snippetDTO = new SnippetDTO();
    snippetDTO.setConnections(connections);
    snippetDTO.setFunnels(funnels);
    snippetDTO.setId(id);
    snippetDTO.setInputPorts(inputPorts);
    snippetDTO.setLabels(labels);
    snippetDTO.setOutputPorts(outputPorts);
    snippetDTO.setParentGroupId(parentGroupId);
    snippetDTO.setProcessGroups(processGroups);
    snippetDTO.setProcessors(processors);
    snippetDTO.setRemoteProcessGroups(remoteProcessGroups);
    snippetDTO.setUri(uri);
    return snippetDTO;
  }

  public static SnippetDTOBuilder of(final SnippetDTO snippetDTO) {
    final SnippetDTOBuilder snippetDTOBuilder = new SnippetDTOBuilder();
    snippetDTOBuilder.setConnections(snippetDTO.getConnections());
    snippetDTOBuilder.setFunnels(snippetDTO.getFunnels());
    snippetDTOBuilder.setId(snippetDTO.getId());
    snippetDTOBuilder.setInputPorts(snippetDTO.getInputPorts());
    snippetDTOBuilder.setLabels(snippetDTO.getLabels());
    snippetDTOBuilder.setOutputPorts(snippetDTO.getOutputPorts());
    snippetDTOBuilder.setParentGroupId(snippetDTO.getParentGroupId());
    snippetDTOBuilder.setProcessGroups(snippetDTO.getProcessGroups());
    snippetDTOBuilder.setProcessors(snippetDTO.getProcessors());
    snippetDTOBuilder.setRemoteProcessGroups(snippetDTO.getRemoteProcessGroups());
    snippetDTOBuilder.setUri(snippetDTO.getUri());
    return snippetDTOBuilder;
  }
}
