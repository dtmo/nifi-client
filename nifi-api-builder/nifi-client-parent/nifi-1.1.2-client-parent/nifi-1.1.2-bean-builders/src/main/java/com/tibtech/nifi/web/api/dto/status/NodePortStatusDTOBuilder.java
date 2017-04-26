package com.tibtech.nifi.web.api.dto.status;

import com.tibtech.nifi.web.api.dto.NodeDTOBuilder;
import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.util.function.Function;
import org.apache.nifi.web.api.dto.NodeDTO;
import org.apache.nifi.web.api.dto.status.NodePortStatusDTO;
import org.apache.nifi.web.api.dto.status.PortStatusDTO;

public final class NodePortStatusDTOBuilder {
  private NodeDTO node;

  private PortStatusDTO portStatus;

  /**
   * The node.
   */
  public NodeDTO getNode() {
    return node;
  }

  /**
   * The node.
   */
  public NodePortStatusDTOBuilder setNode(final NodeDTO node) {
    this.node = node;
    return this;
  }

  /**
   * The node.
   */
  public NodePortStatusDTOBuilder setNode(final Function<NodeDTOBuilder, NodeDTOBuilder> configurator) {
    return setNode(configurator.apply(new NodeDTOBuilder()).build());
  }

  /**
   * The node.
   */
  public NodePortStatusDTOBuilder setNode(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = NodeDTOBuilder.class) final Closure<NodeDTOBuilder> closure) {
    return setNode(c -> {
      final Closure<NodeDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  /**
   * The port status from the node.
   */
  public PortStatusDTO getPortStatus() {
    return portStatus;
  }

  /**
   * The port status from the node.
   */
  public NodePortStatusDTOBuilder setPortStatus(final PortStatusDTO portStatus) {
    this.portStatus = portStatus;
    return this;
  }

  /**
   * The port status from the node.
   */
  public NodePortStatusDTOBuilder setPortStatus(final Function<PortStatusDTOBuilder, PortStatusDTOBuilder> configurator) {
    return setPortStatus(configurator.apply(new PortStatusDTOBuilder()).build());
  }

  /**
   * The port status from the node.
   */
  public NodePortStatusDTOBuilder setPortStatus(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PortStatusDTOBuilder.class) final Closure<PortStatusDTOBuilder> closure) {
    return setPortStatus(c -> {
      final Closure<PortStatusDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public NodePortStatusDTO build() {
    final NodePortStatusDTO nodePortStatusDTO = new NodePortStatusDTO();
    nodePortStatusDTO.setNode(node);
    nodePortStatusDTO.setPortStatus(portStatus);
    return nodePortStatusDTO;
  }

  public static NodePortStatusDTOBuilder of(final NodePortStatusDTO nodePortStatusDTO) {
    final NodePortStatusDTOBuilder nodePortStatusDTOBuilder = new NodePortStatusDTOBuilder();
    nodePortStatusDTOBuilder.setNode(nodePortStatusDTO.getNode());
    nodePortStatusDTOBuilder.setPortStatus(nodePortStatusDTO.getPortStatus());
    return nodePortStatusDTOBuilder;
  }
}
