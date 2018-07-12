package com.tibtech.nifi.web.api.dto;

import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Set;
import org.apache.nifi.web.api.dto.ControllerDTO;
import org.apache.nifi.web.api.dto.PortDTO;

public final class ControllerDTOBuilder {
  private Integer activeRemotePortCount;

  private String comments;

  private Integer disabledCount;

  private String id;

  private Integer inactiveRemotePortCount;

  private Integer inputPortCount;

  private Set<PortDTO> inputPorts;

  private String instanceId;

  private Integer invalidCount;

  private String name;

  private Integer outputPortCount;

  private Set<PortDTO> outputPorts;

  private Integer remoteSiteHttpListeningPort;

  private Integer remoteSiteListeningPort;

  private Integer runningCount;

  private Boolean siteToSiteSecure;

  private Integer stoppedCount;

  /**
   * The number of active remote ports contained in the NiFi.
   */
  public Integer getActiveRemotePortCount() {
    return activeRemotePortCount;
  }

  /**
   * The number of active remote ports contained in the NiFi.
   */
  public ControllerDTOBuilder setActiveRemotePortCount(final Integer activeRemotePortCount) {
    this.activeRemotePortCount = activeRemotePortCount;
    return this;
  }

  /**
   * The comments for the NiFi.
   */
  public String getComments() {
    return comments;
  }

  /**
   * The comments for the NiFi.
   */
  public ControllerDTOBuilder setComments(final String comments) {
    this.comments = comments;
    return this;
  }

  /**
   * The number of disabled components in the NiFi.
   */
  public Integer getDisabledCount() {
    return disabledCount;
  }

  /**
   * The number of disabled components in the NiFi.
   */
  public ControllerDTOBuilder setDisabledCount(final Integer disabledCount) {
    this.disabledCount = disabledCount;
    return this;
  }

  /**
   * The id of the NiFi.
   */
  public String getId() {
    return id;
  }

  /**
   * The id of the NiFi.
   */
  public ControllerDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The number of inactive remote ports contained in the NiFi.
   */
  public Integer getInactiveRemotePortCount() {
    return inactiveRemotePortCount;
  }

  /**
   * The number of inactive remote ports contained in the NiFi.
   */
  public ControllerDTOBuilder setInactiveRemotePortCount(final Integer inactiveRemotePortCount) {
    this.inactiveRemotePortCount = inactiveRemotePortCount;
    return this;
  }

  /**
   * The number of input ports contained in the NiFi.
   */
  public Integer getInputPortCount() {
    return inputPortCount;
  }

  /**
   * The number of input ports contained in the NiFi.
   */
  public ControllerDTOBuilder setInputPortCount(final Integer inputPortCount) {
    this.inputPortCount = inputPortCount;
    return this;
  }

  /**
   * The input ports available to send data to for the NiFi.
   */
  public Set<PortDTO> getInputPorts() {
    return inputPorts;
  }

  /**
   * The input ports available to send data to for the NiFi.
   */
  public ControllerDTOBuilder setInputPorts(final Set<PortDTO> inputPorts) {
    this.inputPorts = inputPorts;
    return this;
  }

  /**
   * If clustered, the id of the Cluster Manager, otherwise the id of the NiFi.
   */
  public String getInstanceId() {
    return instanceId;
  }

  /**
   * If clustered, the id of the Cluster Manager, otherwise the id of the NiFi.
   */
  public ControllerDTOBuilder setInstanceId(final String instanceId) {
    this.instanceId = instanceId;
    return this;
  }

  /**
   * The number of invalid components in the NiFi.
   */
  public Integer getInvalidCount() {
    return invalidCount;
  }

  /**
   * The number of invalid components in the NiFi.
   */
  public ControllerDTOBuilder setInvalidCount(final Integer invalidCount) {
    this.invalidCount = invalidCount;
    return this;
  }

  /**
   * The name of the NiFi.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the NiFi.
   */
  public ControllerDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * The number of output ports in the NiFi.
   */
  public Integer getOutputPortCount() {
    return outputPortCount;
  }

  /**
   * The number of output ports in the NiFi.
   */
  public ControllerDTOBuilder setOutputPortCount(final Integer outputPortCount) {
    this.outputPortCount = outputPortCount;
    return this;
  }

  /**
   * The output ports available to received data from the NiFi.
   */
  public Set<PortDTO> getOutputPorts() {
    return outputPorts;
  }

  /**
   * The output ports available to received data from the NiFi.
   */
  public ControllerDTOBuilder setOutputPorts(final Set<PortDTO> outputPorts) {
    this.outputPorts = outputPorts;
    return this;
  }

  /**
   * The HTTP(S) Port on which this instance is listening for Remote Transfers of Flow Files. If this instance is not configured to receive Flow Files from remote instances, this will be null.
   */
  public Integer getRemoteSiteHttpListeningPort() {
    return remoteSiteHttpListeningPort;
  }

  /**
   * The HTTP(S) Port on which this instance is listening for Remote Transfers of Flow Files. If this instance is not configured to receive Flow Files from remote instances, this will be null.
   */
  public ControllerDTOBuilder setRemoteSiteHttpListeningPort(
      final Integer remoteSiteHttpListeningPort) {
    this.remoteSiteHttpListeningPort = remoteSiteHttpListeningPort;
    return this;
  }

  /**
   * The Socket Port on which this instance is listening for Remote Transfers of Flow Files. If this instance is not configured to receive Flow Files from remote instances, this will be null.
   */
  public Integer getRemoteSiteListeningPort() {
    return remoteSiteListeningPort;
  }

  /**
   * The Socket Port on which this instance is listening for Remote Transfers of Flow Files. If this instance is not configured to receive Flow Files from remote instances, this will be null.
   */
  public ControllerDTOBuilder setRemoteSiteListeningPort(final Integer remoteSiteListeningPort) {
    this.remoteSiteListeningPort = remoteSiteListeningPort;
    return this;
  }

  /**
   * The number of running components in the NiFi.
   */
  public Integer getRunningCount() {
    return runningCount;
  }

  /**
   * The number of running components in the NiFi.
   */
  public ControllerDTOBuilder setRunningCount(final Integer runningCount) {
    this.runningCount = runningCount;
    return this;
  }

  /**
   * Indicates whether or not Site-to-Site communications with this instance is secure (2-way authentication).
   */
  public Boolean getSiteToSiteSecure() {
    return siteToSiteSecure;
  }

  /**
   * Indicates whether or not Site-to-Site communications with this instance is secure (2-way authentication).
   */
  public ControllerDTOBuilder setSiteToSiteSecure(final Boolean siteToSiteSecure) {
    this.siteToSiteSecure = siteToSiteSecure;
    return this;
  }

  /**
   * The number of stopped components in the NiFi.
   */
  public Integer getStoppedCount() {
    return stoppedCount;
  }

  /**
   * The number of stopped components in the NiFi.
   */
  public ControllerDTOBuilder setStoppedCount(final Integer stoppedCount) {
    this.stoppedCount = stoppedCount;
    return this;
  }

  public ControllerDTO build() {
    final ControllerDTO controllerDTO = new ControllerDTO();
    controllerDTO.setActiveRemotePortCount(activeRemotePortCount);
    controllerDTO.setComments(comments);
    controllerDTO.setDisabledCount(disabledCount);
    controllerDTO.setId(id);
    controllerDTO.setInactiveRemotePortCount(inactiveRemotePortCount);
    controllerDTO.setInputPortCount(inputPortCount);
    controllerDTO.setInputPorts(inputPorts);
    controllerDTO.setInstanceId(instanceId);
    controllerDTO.setInvalidCount(invalidCount);
    controllerDTO.setName(name);
    controllerDTO.setOutputPortCount(outputPortCount);
    controllerDTO.setOutputPorts(outputPorts);
    controllerDTO.setRemoteSiteHttpListeningPort(remoteSiteHttpListeningPort);
    controllerDTO.setRemoteSiteListeningPort(remoteSiteListeningPort);
    controllerDTO.setRunningCount(runningCount);
    controllerDTO.setSiteToSiteSecure(siteToSiteSecure);
    controllerDTO.setStoppedCount(stoppedCount);
    return controllerDTO;
  }

  public static ControllerDTOBuilder of(final ControllerDTO controllerDTO) {
    final ControllerDTOBuilder controllerDTOBuilder = new ControllerDTOBuilder();
    controllerDTOBuilder.setActiveRemotePortCount(controllerDTO.getActiveRemotePortCount());
    controllerDTOBuilder.setComments(controllerDTO.getComments());
    controllerDTOBuilder.setDisabledCount(controllerDTO.getDisabledCount());
    controllerDTOBuilder.setId(controllerDTO.getId());
    controllerDTOBuilder.setInactiveRemotePortCount(controllerDTO.getInactiveRemotePortCount());
    controllerDTOBuilder.setInputPortCount(controllerDTO.getInputPortCount());
    controllerDTOBuilder.setInputPorts(controllerDTO.getInputPorts());
    controllerDTOBuilder.setInstanceId(controllerDTO.getInstanceId());
    controllerDTOBuilder.setInvalidCount(controllerDTO.getInvalidCount());
    controllerDTOBuilder.setName(controllerDTO.getName());
    controllerDTOBuilder.setOutputPortCount(controllerDTO.getOutputPortCount());
    controllerDTOBuilder.setOutputPorts(controllerDTO.getOutputPorts());
    controllerDTOBuilder.setRemoteSiteHttpListeningPort(controllerDTO.getRemoteSiteHttpListeningPort());
    controllerDTOBuilder.setRemoteSiteListeningPort(controllerDTO.getRemoteSiteListeningPort());
    controllerDTOBuilder.setRunningCount(controllerDTO.getRunningCount());
    controllerDTOBuilder.setSiteToSiteSecure(controllerDTO.isSiteToSiteSecure());
    controllerDTOBuilder.setStoppedCount(controllerDTO.getStoppedCount());
    return controllerDTOBuilder;
  }
}
