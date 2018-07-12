package com.tibtech.nifi.web.api.dto;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Integer;
import java.lang.String;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.CountersSnapshotDTO;
import org.apache.nifi.web.api.dto.NodeCountersSnapshotDTO;

public final class NodeCountersSnapshotDTOBuilder {
  private String address;

  private Integer apiPort;

  private String nodeId;

  private CountersSnapshotDTO snapshot;

  /**
   * The API address of the node
   */
  public String getAddress() {
    return address;
  }

  /**
   * The API address of the node
   */
  public NodeCountersSnapshotDTOBuilder setAddress(final String address) {
    this.address = address;
    return this;
  }

  /**
   * The API port used to communicate with the node
   */
  public Integer getApiPort() {
    return apiPort;
  }

  /**
   * The API port used to communicate with the node
   */
  public NodeCountersSnapshotDTOBuilder setApiPort(final Integer apiPort) {
    this.apiPort = apiPort;
    return this;
  }

  /**
   * The unique ID that identifies the node
   */
  public String getNodeId() {
    return nodeId;
  }

  /**
   * The unique ID that identifies the node
   */
  public NodeCountersSnapshotDTOBuilder setNodeId(final String nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /**
   * The counters from the node.
   */
  public CountersSnapshotDTO getSnapshot() {
    return snapshot;
  }

  /**
   * The counters from the node.
   */
  public NodeCountersSnapshotDTOBuilder setSnapshot(final CountersSnapshotDTO snapshot) {
    this.snapshot = snapshot;
    return this;
  }

  /**
   * The counters from the node.
   */
  public NodeCountersSnapshotDTOBuilder setSnapshot(
      final Consumer<CountersSnapshotDTOBuilder> configurator) {
    final CountersSnapshotDTOBuilder builder = (snapshot != null ? CountersSnapshotDTOBuilder.of(snapshot) : new CountersSnapshotDTOBuilder());
    configurator.accept(builder);
    return setSnapshot(builder.build());
  }

  /**
   * The counters from the node.
   */
  public NodeCountersSnapshotDTOBuilder setSnapshot(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CountersSnapshotDTOBuilder.class) final Closure<CountersSnapshotDTOBuilder> closure) {
    return setSnapshot(c -> {
      final Closure<CountersSnapshotDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  public NodeCountersSnapshotDTO build() {
    final NodeCountersSnapshotDTO nodeCountersSnapshotDTO = new NodeCountersSnapshotDTO();
    nodeCountersSnapshotDTO.setAddress(address);
    nodeCountersSnapshotDTO.setApiPort(apiPort);
    nodeCountersSnapshotDTO.setNodeId(nodeId);
    nodeCountersSnapshotDTO.setSnapshot(snapshot);
    return nodeCountersSnapshotDTO;
  }

  public static NodeCountersSnapshotDTOBuilder of(
      final NodeCountersSnapshotDTO nodeCountersSnapshotDTO) {
    final NodeCountersSnapshotDTOBuilder nodeCountersSnapshotDTOBuilder = new NodeCountersSnapshotDTOBuilder();
    nodeCountersSnapshotDTOBuilder.setAddress(nodeCountersSnapshotDTO.getAddress());
    nodeCountersSnapshotDTOBuilder.setApiPort(nodeCountersSnapshotDTO.getApiPort());
    nodeCountersSnapshotDTOBuilder.setNodeId(nodeCountersSnapshotDTO.getNodeId());
    nodeCountersSnapshotDTOBuilder.setSnapshot(nodeCountersSnapshotDTO.getSnapshot());
    return nodeCountersSnapshotDTOBuilder;
  }
}
