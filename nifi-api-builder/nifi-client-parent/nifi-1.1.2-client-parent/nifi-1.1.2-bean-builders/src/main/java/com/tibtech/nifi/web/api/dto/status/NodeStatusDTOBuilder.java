package com.tibtech.nifi.web.api.dto.status;

import com.tibtech.nifi.web.api.dto.NodeDTOBuilder;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.util.function.Function;
import org.apache.nifi.web.api.dto.NodeDTO;
import org.apache.nifi.web.api.dto.status.NodeStatusDTO;
import org.apache.nifi.web.api.dto.status.ProcessGroupStatusDTO;

public final class NodeStatusDTOBuilder {
  private ProcessGroupStatusDTO controllerStatus;

  private NodeDTO node;

  /**
   * The controller status for each node.
   */
  public ProcessGroupStatusDTO getControllerStatus() {
    return controllerStatus;
  }

  /**
   * The controller status for each node.
   */
  public NodeStatusDTOBuilder setControllerStatus(final ProcessGroupStatusDTO controllerStatus) {
    this.controllerStatus = controllerStatus;
    return this;
  }

  /**
   * The controller status for each node.
   */
  public NodeStatusDTOBuilder setControllerStatus(final Function<ProcessGroupStatusDTOBuilder, ProcessGroupStatusDTOBuilder> configurator) {
    return setControllerStatus(configurator.apply(controllerStatus != null ? ProcessGroupStatusDTOBuilder.of(controllerStatus) : new ProcessGroupStatusDTOBuilder()).build());
  }

  /**
   * The controller status for each node.
   */
  public NodeStatusDTOBuilder setControllerStatus(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessGroupStatusDTOBuilder.class) final Closure<ProcessGroupStatusDTOBuilder> closure) {
    return setControllerStatus(c -> {
      final Closure<ProcessGroupStatusDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  /**
   * The node.
   */
  public NodeDTO getNode() {
    return node;
  }

  /**
   * The node.
   */
  public NodeStatusDTOBuilder setNode(final NodeDTO node) {
    this.node = node;
    return this;
  }

  /**
   * The node.
   */
  public NodeStatusDTOBuilder setNode(final Function<NodeDTOBuilder, NodeDTOBuilder> configurator) {
    return setNode(configurator.apply(node != null ? NodeDTOBuilder.of(node) : new NodeDTOBuilder()).build());
  }

  /**
   * The node.
   */
  public NodeStatusDTOBuilder setNode(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = NodeDTOBuilder.class) final Closure<NodeDTOBuilder> closure) {
    return setNode(c -> {
      final Closure<NodeDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public NodeStatusDTO build() {
    final NodeStatusDTO nodeStatusDTO = new NodeStatusDTO();
    nodeStatusDTO.setControllerStatus(controllerStatus);
    nodeStatusDTO.setNode(node);
    return nodeStatusDTO;
  }

  public static NodeStatusDTOBuilder of(final NodeStatusDTO nodeStatusDTO) {
    final NodeStatusDTOBuilder nodeStatusDTOBuilder = new NodeStatusDTOBuilder();
    nodeStatusDTOBuilder.setControllerStatus(nodeStatusDTO.getControllerStatus());
    nodeStatusDTOBuilder.setNode(nodeStatusDTO.getNode());
    return nodeStatusDTOBuilder;
  }
}
