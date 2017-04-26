package com.tibtech.nifi.web.api.entity;

import java.lang.Integer;
import org.apache.nifi.web.api.dto.RemoteProcessGroupDTO;
import org.apache.nifi.web.api.dto.status.RemoteProcessGroupStatusDTO;
import org.apache.nifi.web.api.entity.RemoteProcessGroupEntity;

public final class RemoteProcessGroupEntityBuilder extends AbstractComponentEntityBuilder<RemoteProcessGroupEntityBuilder> {
  private RemoteProcessGroupDTO component;

  private Integer inputPortCount;

  private Integer outputPortCount;

  private RemoteProcessGroupStatusDTO status;

  public RemoteProcessGroupDTO getComponent() {
    return component;
  }

  public RemoteProcessGroupEntityBuilder setComponent(final RemoteProcessGroupDTO component) {
    this.component = component;
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
  public RemoteProcessGroupEntityBuilder setInputPortCount(final Integer inputPortCount) {
    this.inputPortCount = inputPortCount;
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
  public RemoteProcessGroupEntityBuilder setOutputPortCount(final Integer outputPortCount) {
    this.outputPortCount = outputPortCount;
    return this;
  }

  /**
   * The status of the remote process group.
   */
  public RemoteProcessGroupStatusDTO getStatus() {
    return status;
  }

  /**
   * The status of the remote process group.
   */
  public RemoteProcessGroupEntityBuilder setStatus(final RemoteProcessGroupStatusDTO status) {
    this.status = status;
    return this;
  }

  public RemoteProcessGroupEntity build() {
    final RemoteProcessGroupEntity remoteProcessGroupEntity = new RemoteProcessGroupEntity();
    super.setPropertyValues(remoteProcessGroupEntity);
    remoteProcessGroupEntity.setComponent(component);
    remoteProcessGroupEntity.setInputPortCount(inputPortCount);
    remoteProcessGroupEntity.setOutputPortCount(outputPortCount);
    remoteProcessGroupEntity.setStatus(status);
    return remoteProcessGroupEntity;
  }

  public static RemoteProcessGroupEntityBuilder of(final RemoteProcessGroupEntity remoteProcessGroupEntity) {
    final RemoteProcessGroupEntityBuilder remoteProcessGroupEntityBuilder = new RemoteProcessGroupEntityBuilder();
    AbstractComponentEntityBuilder.setBuilderValues(remoteProcessGroupEntityBuilder, remoteProcessGroupEntity);
    remoteProcessGroupEntityBuilder.setComponent(remoteProcessGroupEntity.getComponent());
    remoteProcessGroupEntityBuilder.setInputPortCount(remoteProcessGroupEntity.getInputPortCount());
    remoteProcessGroupEntityBuilder.setOutputPortCount(remoteProcessGroupEntity.getOutputPortCount());
    remoteProcessGroupEntityBuilder.setStatus(remoteProcessGroupEntity.getStatus());
    return remoteProcessGroupEntityBuilder;
  }
}
