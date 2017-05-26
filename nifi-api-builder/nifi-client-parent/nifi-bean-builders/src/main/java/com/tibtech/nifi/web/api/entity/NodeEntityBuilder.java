package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.NodeDTO;
import org.apache.nifi.web.api.entity.NodeEntity;

public final class NodeEntityBuilder extends AbstractEntityBuilder<NodeEntityBuilder> {
  private NodeDTO node;

  public NodeDTO getNode() {
    return node;
  }

  public NodeEntityBuilder setNode(final NodeDTO node) {
    this.node = node;
    return this;
  }

  public NodeEntity build() {
    final NodeEntity nodeEntity = new NodeEntity();
    super.setPropertyValues(nodeEntity);
    nodeEntity.setNode(node);
    return nodeEntity;
  }

  public static NodeEntityBuilder of(final NodeEntity nodeEntity) {
    final NodeEntityBuilder nodeEntityBuilder = new NodeEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(nodeEntityBuilder, nodeEntity);
    nodeEntityBuilder.setNode(nodeEntity.getNode());
    return nodeEntityBuilder;
  }
}
