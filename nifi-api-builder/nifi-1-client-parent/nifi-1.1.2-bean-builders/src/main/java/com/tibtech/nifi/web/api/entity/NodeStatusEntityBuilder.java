package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.status.NodeStatusDTO;
import org.apache.nifi.web.api.entity.NodeStatusEntity;

public final class NodeStatusEntityBuilder extends AbstractEntityBuilder<NodeStatusEntityBuilder> {
  private NodeStatusDTO nodeStatus;

  public NodeStatusDTO getNodeStatus() {
    return nodeStatus;
  }

  public NodeStatusEntityBuilder setNodeStatus(final NodeStatusDTO nodeStatus) {
    this.nodeStatus = nodeStatus;
    return this;
  }

  public NodeStatusEntity build() {
    final NodeStatusEntity nodeStatusEntity = new NodeStatusEntity();
    super.setPropertyValues(nodeStatusEntity);
    nodeStatusEntity.setNodeStatus(nodeStatus);
    return nodeStatusEntity;
  }

  public static NodeStatusEntityBuilder of(final NodeStatusEntity nodeStatusEntity) {
    final NodeStatusEntityBuilder nodeStatusEntityBuilder = new NodeStatusEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(nodeStatusEntityBuilder, nodeStatusEntity);
    nodeStatusEntityBuilder.setNodeStatus(nodeStatusEntity.getNodeStatus());
    return nodeStatusEntityBuilder;
  }
}
