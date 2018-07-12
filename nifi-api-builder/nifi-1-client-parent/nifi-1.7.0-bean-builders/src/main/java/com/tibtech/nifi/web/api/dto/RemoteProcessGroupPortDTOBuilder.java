package com.tibtech.nifi.web.api.dto;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.BatchSettingsDTO;
import org.apache.nifi.web.api.dto.RemoteProcessGroupPortDTO;

public final class RemoteProcessGroupPortDTOBuilder {
  private BatchSettingsDTO batchSettings;

  private String comments;

  private Integer concurrentlySchedulableTaskCount;

  private Boolean connected;

  private Boolean exists;

  private String groupId;

  private String id;

  private String name;

  private String targetId;

  private Boolean targetRunning;

  private Boolean transmitting;

  private Boolean useCompression;

  private String versionedComponentId;

  /**
   * The batch settings for data transmission.
   */
  public BatchSettingsDTO getBatchSettings() {
    return batchSettings;
  }

  /**
   * The batch settings for data transmission.
   */
  public RemoteProcessGroupPortDTOBuilder setBatchSettings(final BatchSettingsDTO batchSettings) {
    this.batchSettings = batchSettings;
    return this;
  }

  /**
   * The batch settings for data transmission.
   */
  public RemoteProcessGroupPortDTOBuilder setBatchSettings(
      final Consumer<BatchSettingsDTOBuilder> configurator) {
    final BatchSettingsDTOBuilder builder = (batchSettings != null ? BatchSettingsDTOBuilder.of(batchSettings) : new BatchSettingsDTOBuilder());
    configurator.accept(builder);
    return setBatchSettings(builder.build());
  }

  /**
   * The batch settings for data transmission.
   */
  public RemoteProcessGroupPortDTOBuilder setBatchSettings(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = BatchSettingsDTOBuilder.class) final Closure<BatchSettingsDTOBuilder> closure) {
    return setBatchSettings(c -> {
      final Closure<BatchSettingsDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * The comments as configured on the target port.
   */
  public String getComments() {
    return comments;
  }

  /**
   * The comments as configured on the target port.
   */
  public RemoteProcessGroupPortDTOBuilder setComments(final String comments) {
    this.comments = comments;
    return this;
  }

  /**
   * The number of task that may transmit flowfiles to the target port concurrently.
   */
  public Integer getConcurrentlySchedulableTaskCount() {
    return concurrentlySchedulableTaskCount;
  }

  /**
   * The number of task that may transmit flowfiles to the target port concurrently.
   */
  public RemoteProcessGroupPortDTOBuilder setConcurrentlySchedulableTaskCount(
      final Integer concurrentlySchedulableTaskCount) {
    this.concurrentlySchedulableTaskCount = concurrentlySchedulableTaskCount;
    return this;
  }

  /**
   * Whether the port has either an incoming or outgoing connection.
   */
  public Boolean getConnected() {
    return connected;
  }

  /**
   * Whether the port has either an incoming or outgoing connection.
   */
  public RemoteProcessGroupPortDTOBuilder setConnected(final Boolean connected) {
    this.connected = connected;
    return this;
  }

  /**
   * Whether the target port exists.
   */
  public Boolean getExists() {
    return exists;
  }

  /**
   * Whether the target port exists.
   */
  public RemoteProcessGroupPortDTOBuilder setExists(final Boolean exists) {
    this.exists = exists;
    return this;
  }

  /**
   * The id of the remote process group that the port resides in.
   */
  public String getGroupId() {
    return groupId;
  }

  /**
   * The id of the remote process group that the port resides in.
   */
  public RemoteProcessGroupPortDTOBuilder setGroupId(final String groupId) {
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
  public RemoteProcessGroupPortDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The name of the target port.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the target port.
   */
  public RemoteProcessGroupPortDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * The id of the target port.
   */
  public String getTargetId() {
    return targetId;
  }

  /**
   * The id of the target port.
   */
  public RemoteProcessGroupPortDTOBuilder setTargetId(final String targetId) {
    this.targetId = targetId;
    return this;
  }

  /**
   * Whether the target port is running.
   */
  public Boolean getTargetRunning() {
    return targetRunning;
  }

  /**
   * Whether the target port is running.
   */
  public RemoteProcessGroupPortDTOBuilder setTargetRunning(final Boolean targetRunning) {
    this.targetRunning = targetRunning;
    return this;
  }

  /**
   * Whether the remote port is configured for transmission.
   */
  public Boolean getTransmitting() {
    return transmitting;
  }

  /**
   * Whether the remote port is configured for transmission.
   */
  public RemoteProcessGroupPortDTOBuilder setTransmitting(final Boolean transmitting) {
    this.transmitting = transmitting;
    return this;
  }

  /**
   * Whether the flowfiles are compressed when sent to the target port.
   */
  public Boolean getUseCompression() {
    return useCompression;
  }

  /**
   * Whether the flowfiles are compressed when sent to the target port.
   */
  public RemoteProcessGroupPortDTOBuilder setUseCompression(final Boolean useCompression) {
    this.useCompression = useCompression;
    return this;
  }

  /**
   * The ID of the corresponding component that is under version control
   */
  public String getVersionedComponentId() {
    return versionedComponentId;
  }

  /**
   * The ID of the corresponding component that is under version control
   */
  public RemoteProcessGroupPortDTOBuilder setVersionedComponentId(
      final String versionedComponentId) {
    this.versionedComponentId = versionedComponentId;
    return this;
  }

  public RemoteProcessGroupPortDTO build() {
    final RemoteProcessGroupPortDTO remoteProcessGroupPortDTO = new RemoteProcessGroupPortDTO();
    remoteProcessGroupPortDTO.setBatchSettings(batchSettings);
    remoteProcessGroupPortDTO.setComments(comments);
    remoteProcessGroupPortDTO.setConcurrentlySchedulableTaskCount(concurrentlySchedulableTaskCount);
    remoteProcessGroupPortDTO.setConnected(connected);
    remoteProcessGroupPortDTO.setExists(exists);
    remoteProcessGroupPortDTO.setGroupId(groupId);
    remoteProcessGroupPortDTO.setId(id);
    remoteProcessGroupPortDTO.setName(name);
    remoteProcessGroupPortDTO.setTargetId(targetId);
    remoteProcessGroupPortDTO.setTargetRunning(targetRunning);
    remoteProcessGroupPortDTO.setTransmitting(transmitting);
    remoteProcessGroupPortDTO.setUseCompression(useCompression);
    remoteProcessGroupPortDTO.setVersionedComponentId(versionedComponentId);
    return remoteProcessGroupPortDTO;
  }

  public static RemoteProcessGroupPortDTOBuilder of(
      final RemoteProcessGroupPortDTO remoteProcessGroupPortDTO) {
    final RemoteProcessGroupPortDTOBuilder remoteProcessGroupPortDTOBuilder = new RemoteProcessGroupPortDTOBuilder();
    remoteProcessGroupPortDTOBuilder.setBatchSettings(remoteProcessGroupPortDTO.getBatchSettings());
    remoteProcessGroupPortDTOBuilder.setComments(remoteProcessGroupPortDTO.getComments());
    remoteProcessGroupPortDTOBuilder.setConcurrentlySchedulableTaskCount(remoteProcessGroupPortDTO.getConcurrentlySchedulableTaskCount());
    remoteProcessGroupPortDTOBuilder.setConnected(remoteProcessGroupPortDTO.isConnected());
    remoteProcessGroupPortDTOBuilder.setExists(remoteProcessGroupPortDTO.getExists());
    remoteProcessGroupPortDTOBuilder.setGroupId(remoteProcessGroupPortDTO.getGroupId());
    remoteProcessGroupPortDTOBuilder.setId(remoteProcessGroupPortDTO.getId());
    remoteProcessGroupPortDTOBuilder.setName(remoteProcessGroupPortDTO.getName());
    remoteProcessGroupPortDTOBuilder.setTargetId(remoteProcessGroupPortDTO.getTargetId());
    remoteProcessGroupPortDTOBuilder.setTargetRunning(remoteProcessGroupPortDTO.isTargetRunning());
    remoteProcessGroupPortDTOBuilder.setTransmitting(remoteProcessGroupPortDTO.isTransmitting());
    remoteProcessGroupPortDTOBuilder.setUseCompression(remoteProcessGroupPortDTO.getUseCompression());
    remoteProcessGroupPortDTOBuilder.setVersionedComponentId(remoteProcessGroupPortDTO.getVersionedComponentId());
    return remoteProcessGroupPortDTOBuilder;
  }
}
