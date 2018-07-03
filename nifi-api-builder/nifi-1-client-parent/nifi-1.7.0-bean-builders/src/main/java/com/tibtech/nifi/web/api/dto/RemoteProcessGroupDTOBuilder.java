package com.tibtech.nifi.web.api.dto;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.Collection;
import java.util.Date;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.RemoteProcessGroupContentsDTO;
import org.apache.nifi.web.api.dto.RemoteProcessGroupDTO;

public final class RemoteProcessGroupDTOBuilder extends AbstractComponentDTOBuilder<RemoteProcessGroupDTOBuilder> {
  private Integer activeRemoteInputPortCount;

  private Integer activeRemoteOutputPortCount;

  private Collection<String> authorizationIssues;

  private String comments;

  private String communicationsTimeout;

  private RemoteProcessGroupContentsDTO contents;

  private Date flowRefreshed;

  private Integer inactiveRemoteInputPortCount;

  private Integer inactiveRemoteOutputPortCount;

  private Integer inputPortCount;

  private String localNetworkInterface;

  private String name;

  private Integer outputPortCount;

  private String proxyHost;

  private String proxyPassword;

  private Integer proxyPort;

  private String proxyUser;

  private Boolean targetSecure;

  private String targetUri;

  private String targetUris;

  private Boolean transmitting;

  private String transportProtocol;

  private Collection<String> validationErrors;

  private String yieldDuration;

  /**
   * The number of active remote input ports.
   */
  public Integer getActiveRemoteInputPortCount() {
    return activeRemoteInputPortCount;
  }

  /**
   * The number of active remote input ports.
   */
  public RemoteProcessGroupDTOBuilder setActiveRemoteInputPortCount(final Integer activeRemoteInputPortCount) {
    this.activeRemoteInputPortCount = activeRemoteInputPortCount;
    return this;
  }

  /**
   * The number of active remote output ports.
   */
  public Integer getActiveRemoteOutputPortCount() {
    return activeRemoteOutputPortCount;
  }

  /**
   * The number of active remote output ports.
   */
  public RemoteProcessGroupDTOBuilder setActiveRemoteOutputPortCount(final Integer activeRemoteOutputPortCount) {
    this.activeRemoteOutputPortCount = activeRemoteOutputPortCount;
    return this;
  }

  /**
   * Any remote authorization issues for the remote process group.
   */
  public Collection<String> getAuthorizationIssues() {
    return authorizationIssues;
  }

  /**
   * Any remote authorization issues for the remote process group.
   */
  public RemoteProcessGroupDTOBuilder setAuthorizationIssues(final Collection<String> authorizationIssues) {
    this.authorizationIssues = authorizationIssues;
    return this;
  }

  /**
   * The comments for the remote process group.
   */
  public String getComments() {
    return comments;
  }

  /**
   * The comments for the remote process group.
   */
  public RemoteProcessGroupDTOBuilder setComments(final String comments) {
    this.comments = comments;
    return this;
  }

  /**
   * The time period used for the timeout when communicating with the target.
   */
  public String getCommunicationsTimeout() {
    return communicationsTimeout;
  }

  /**
   * The time period used for the timeout when communicating with the target.
   */
  public RemoteProcessGroupDTOBuilder setCommunicationsTimeout(final String communicationsTimeout) {
    this.communicationsTimeout = communicationsTimeout;
    return this;
  }

  /**
   * The contents of the remote process group. Will contain available input/output ports.
   */
  public RemoteProcessGroupContentsDTO getContents() {
    return contents;
  }

  /**
   * The contents of the remote process group. Will contain available input/output ports.
   */
  public RemoteProcessGroupDTOBuilder setContents(final RemoteProcessGroupContentsDTO contents) {
    this.contents = contents;
    return this;
  }

  /**
   * The contents of the remote process group. Will contain available input/output ports.
   */
  public RemoteProcessGroupDTOBuilder setContents(final Consumer<RemoteProcessGroupContentsDTOBuilder> configurator) {
    final RemoteProcessGroupContentsDTOBuilder builder = (contents != null ? RemoteProcessGroupContentsDTOBuilder.of(contents) : new RemoteProcessGroupContentsDTOBuilder());
    configurator.accept(builder);
    return setContents(builder.build());
  }

  /**
   * The contents of the remote process group. Will contain available input/output ports.
   */
  public RemoteProcessGroupDTOBuilder setContents(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = RemoteProcessGroupContentsDTOBuilder.class) final Closure<RemoteProcessGroupContentsDTOBuilder> closure) {
    return setContents(c -> {
      final Closure<RemoteProcessGroupContentsDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * The timestamp when this remote process group was last refreshed.
   */
  public Date getFlowRefreshed() {
    return flowRefreshed;
  }

  /**
   * The timestamp when this remote process group was last refreshed.
   */
  public RemoteProcessGroupDTOBuilder setFlowRefreshed(final Date flowRefreshed) {
    this.flowRefreshed = flowRefreshed;
    return this;
  }

  /**
   * The number of inactive remote input ports.
   */
  public Integer getInactiveRemoteInputPortCount() {
    return inactiveRemoteInputPortCount;
  }

  /**
   * The number of inactive remote input ports.
   */
  public RemoteProcessGroupDTOBuilder setInactiveRemoteInputPortCount(final Integer inactiveRemoteInputPortCount) {
    this.inactiveRemoteInputPortCount = inactiveRemoteInputPortCount;
    return this;
  }

  /**
   * The number of inactive remote output ports.
   */
  public Integer getInactiveRemoteOutputPortCount() {
    return inactiveRemoteOutputPortCount;
  }

  /**
   * The number of inactive remote output ports.
   */
  public RemoteProcessGroupDTOBuilder setInactiveRemoteOutputPortCount(final Integer inactiveRemoteOutputPortCount) {
    this.inactiveRemoteOutputPortCount = inactiveRemoteOutputPortCount;
    return this;
  }

  /**
   * The number of remote input ports currently available on the target.
   */
  public Integer getInputPortCount() {
    return inputPortCount;
  }

  /**
   * The number of remote input ports currently available on the target.
   */
  public RemoteProcessGroupDTOBuilder setInputPortCount(final Integer inputPortCount) {
    this.inputPortCount = inputPortCount;
    return this;
  }

  /**
   * The local network interface to send/receive data. If not specified, any local address is used. If clustered, all nodes must have an interface with this identifier.
   */
  public String getLocalNetworkInterface() {
    return localNetworkInterface;
  }

  /**
   * The local network interface to send/receive data. If not specified, any local address is used. If clustered, all nodes must have an interface with this identifier.
   */
  public RemoteProcessGroupDTOBuilder setLocalNetworkInterface(final String localNetworkInterface) {
    this.localNetworkInterface = localNetworkInterface;
    return this;
  }

  public String getName() {
    return name;
  }

  public RemoteProcessGroupDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * The number of remote output ports currently available on the target.
   */
  public Integer getOutputPortCount() {
    return outputPortCount;
  }

  /**
   * The number of remote output ports currently available on the target.
   */
  public RemoteProcessGroupDTOBuilder setOutputPortCount(final Integer outputPortCount) {
    this.outputPortCount = outputPortCount;
    return this;
  }

  public String getProxyHost() {
    return proxyHost;
  }

  public RemoteProcessGroupDTOBuilder setProxyHost(final String proxyHost) {
    this.proxyHost = proxyHost;
    return this;
  }

  public String getProxyPassword() {
    return proxyPassword;
  }

  public RemoteProcessGroupDTOBuilder setProxyPassword(final String proxyPassword) {
    this.proxyPassword = proxyPassword;
    return this;
  }

  public Integer getProxyPort() {
    return proxyPort;
  }

  public RemoteProcessGroupDTOBuilder setProxyPort(final Integer proxyPort) {
    this.proxyPort = proxyPort;
    return this;
  }

  public String getProxyUser() {
    return proxyUser;
  }

  public RemoteProcessGroupDTOBuilder setProxyUser(final String proxyUser) {
    this.proxyUser = proxyUser;
    return this;
  }

  /**
   * Whether the target is running securely.
   */
  public Boolean getTargetSecure() {
    return targetSecure;
  }

  /**
   * Whether the target is running securely.
   */
  public RemoteProcessGroupDTOBuilder setTargetSecure(final Boolean targetSecure) {
    this.targetSecure = targetSecure;
    return this;
  }

  /**
   * The target URI of the remote process group. If target uri is not set, but uris are set, then returns the first url in the urls. If neither target uri nor uris are set, then returns null.
   */
  public String getTargetUri() {
    return targetUri;
  }

  /**
   * The target URI of the remote process group. If target uri is not set, but uris are set, then returns the first url in the urls. If neither target uri nor uris are set, then returns null.
   */
  public RemoteProcessGroupDTOBuilder setTargetUri(final String targetUri) {
    this.targetUri = targetUri;
    return this;
  }

  /**
   * The target URI of the remote process group. If target uris is not set but target uri is set, then returns a collection containing the single target uri. If neither target uris nor uris are set, then returns null.
   */
  public String getTargetUris() {
    return targetUris;
  }

  /**
   * The target URI of the remote process group. If target uris is not set but target uri is set, then returns a collection containing the single target uri. If neither target uris nor uris are set, then returns null.
   */
  public RemoteProcessGroupDTOBuilder setTargetUris(final String targetUris) {
    this.targetUris = targetUris;
    return this;
  }

  /**
   * Whether the remote process group is actively transmitting.
   */
  public Boolean getTransmitting() {
    return transmitting;
  }

  /**
   * Whether the remote process group is actively transmitting.
   */
  public RemoteProcessGroupDTOBuilder setTransmitting(final Boolean transmitting) {
    this.transmitting = transmitting;
    return this;
  }

  public String getTransportProtocol() {
    return transportProtocol;
  }

  public RemoteProcessGroupDTOBuilder setTransportProtocol(final String transportProtocol) {
    this.transportProtocol = transportProtocol;
    return this;
  }

  /**
   * The validation errors for the remote process group. These validation errors represent the problems with the remote process group that must be resolved before it can transmit.
   */
  public Collection<String> getValidationErrors() {
    return validationErrors;
  }

  /**
   * The validation errors for the remote process group. These validation errors represent the problems with the remote process group that must be resolved before it can transmit.
   */
  public RemoteProcessGroupDTOBuilder setValidationErrors(final Collection<String> validationErrors) {
    this.validationErrors = validationErrors;
    return this;
  }

  /**
   * When yielding, this amount of time must elapse before the remote process group is scheduled again.
   */
  public String getYieldDuration() {
    return yieldDuration;
  }

  /**
   * When yielding, this amount of time must elapse before the remote process group is scheduled again.
   */
  public RemoteProcessGroupDTOBuilder setYieldDuration(final String yieldDuration) {
    this.yieldDuration = yieldDuration;
    return this;
  }

  public RemoteProcessGroupDTO build() {
    final RemoteProcessGroupDTO remoteProcessGroupDTO = new RemoteProcessGroupDTO();
    super.setPropertyValues(remoteProcessGroupDTO);
    remoteProcessGroupDTO.setActiveRemoteInputPortCount(activeRemoteInputPortCount);
    remoteProcessGroupDTO.setActiveRemoteOutputPortCount(activeRemoteOutputPortCount);
    remoteProcessGroupDTO.setAuthorizationIssues(authorizationIssues);
    remoteProcessGroupDTO.setComments(comments);
    remoteProcessGroupDTO.setCommunicationsTimeout(communicationsTimeout);
    remoteProcessGroupDTO.setContents(contents);
    remoteProcessGroupDTO.setFlowRefreshed(flowRefreshed);
    remoteProcessGroupDTO.setInactiveRemoteInputPortCount(inactiveRemoteInputPortCount);
    remoteProcessGroupDTO.setInactiveRemoteOutputPortCount(inactiveRemoteOutputPortCount);
    remoteProcessGroupDTO.setInputPortCount(inputPortCount);
    remoteProcessGroupDTO.setLocalNetworkInterface(localNetworkInterface);
    remoteProcessGroupDTO.setName(name);
    remoteProcessGroupDTO.setOutputPortCount(outputPortCount);
    remoteProcessGroupDTO.setProxyHost(proxyHost);
    remoteProcessGroupDTO.setProxyPassword(proxyPassword);
    remoteProcessGroupDTO.setProxyPort(proxyPort);
    remoteProcessGroupDTO.setProxyUser(proxyUser);
    remoteProcessGroupDTO.setTargetSecure(targetSecure);
    remoteProcessGroupDTO.setTargetUri(targetUri);
    remoteProcessGroupDTO.setTargetUris(targetUris);
    remoteProcessGroupDTO.setTransmitting(transmitting);
    remoteProcessGroupDTO.setTransportProtocol(transportProtocol);
    remoteProcessGroupDTO.setValidationErrors(validationErrors);
    remoteProcessGroupDTO.setYieldDuration(yieldDuration);
    return remoteProcessGroupDTO;
  }

  public static RemoteProcessGroupDTOBuilder of(final RemoteProcessGroupDTO remoteProcessGroupDTO) {
    final RemoteProcessGroupDTOBuilder remoteProcessGroupDTOBuilder = new RemoteProcessGroupDTOBuilder();
    AbstractComponentDTOBuilder.setBuilderValues(remoteProcessGroupDTOBuilder, remoteProcessGroupDTO);
    remoteProcessGroupDTOBuilder.setActiveRemoteInputPortCount(remoteProcessGroupDTO.getActiveRemoteInputPortCount());
    remoteProcessGroupDTOBuilder.setActiveRemoteOutputPortCount(remoteProcessGroupDTO.getActiveRemoteOutputPortCount());
    remoteProcessGroupDTOBuilder.setAuthorizationIssues(remoteProcessGroupDTO.getAuthorizationIssues());
    remoteProcessGroupDTOBuilder.setComments(remoteProcessGroupDTO.getComments());
    remoteProcessGroupDTOBuilder.setCommunicationsTimeout(remoteProcessGroupDTO.getCommunicationsTimeout());
    remoteProcessGroupDTOBuilder.setContents(remoteProcessGroupDTO.getContents());
    remoteProcessGroupDTOBuilder.setFlowRefreshed(remoteProcessGroupDTO.getFlowRefreshed());
    remoteProcessGroupDTOBuilder.setInactiveRemoteInputPortCount(remoteProcessGroupDTO.getInactiveRemoteInputPortCount());
    remoteProcessGroupDTOBuilder.setInactiveRemoteOutputPortCount(remoteProcessGroupDTO.getInactiveRemoteOutputPortCount());
    remoteProcessGroupDTOBuilder.setInputPortCount(remoteProcessGroupDTO.getInputPortCount());
    remoteProcessGroupDTOBuilder.setLocalNetworkInterface(remoteProcessGroupDTO.getLocalNetworkInterface());
    remoteProcessGroupDTOBuilder.setName(remoteProcessGroupDTO.getName());
    remoteProcessGroupDTOBuilder.setOutputPortCount(remoteProcessGroupDTO.getOutputPortCount());
    remoteProcessGroupDTOBuilder.setProxyHost(remoteProcessGroupDTO.getProxyHost());
    remoteProcessGroupDTOBuilder.setProxyPassword(remoteProcessGroupDTO.getProxyPassword());
    remoteProcessGroupDTOBuilder.setProxyPort(remoteProcessGroupDTO.getProxyPort());
    remoteProcessGroupDTOBuilder.setProxyUser(remoteProcessGroupDTO.getProxyUser());
    remoteProcessGroupDTOBuilder.setTargetSecure(remoteProcessGroupDTO.isTargetSecure());
    remoteProcessGroupDTOBuilder.setTargetUri(remoteProcessGroupDTO.getTargetUri());
    remoteProcessGroupDTOBuilder.setTargetUris(remoteProcessGroupDTO.getTargetUris());
    remoteProcessGroupDTOBuilder.setTransmitting(remoteProcessGroupDTO.isTransmitting());
    remoteProcessGroupDTOBuilder.setTransportProtocol(remoteProcessGroupDTO.getTransportProtocol());
    remoteProcessGroupDTOBuilder.setValidationErrors(remoteProcessGroupDTO.getValidationErrors());
    remoteProcessGroupDTOBuilder.setYieldDuration(remoteProcessGroupDTO.getYieldDuration());
    return remoteProcessGroupDTOBuilder;
  }
}
