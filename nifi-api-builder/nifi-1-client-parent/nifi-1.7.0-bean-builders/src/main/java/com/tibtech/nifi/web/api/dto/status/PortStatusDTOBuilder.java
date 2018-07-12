package com.tibtech.nifi.web.api.dto.status;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.Boolean;
import java.lang.String;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.status.NodePortStatusSnapshotDTO;
import org.apache.nifi.web.api.dto.status.PortStatusDTO;
import org.apache.nifi.web.api.dto.status.PortStatusSnapshotDTO;

public final class PortStatusDTOBuilder {
  private PortStatusSnapshotDTO aggregateSnapshot;

  private String groupId;

  private String id;

  private String name;

  private List<NodePortStatusSnapshotDTO> nodeSnapshots;

  private String runStatus;

  private Date statsLastRefreshed;

  private Boolean transmitting;

  /**
   * A status snapshot that represents the aggregate stats of all nodes in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this represents the stats of the single instance.
   */
  public PortStatusSnapshotDTO getAggregateSnapshot() {
    return aggregateSnapshot;
  }

  /**
   * A status snapshot that represents the aggregate stats of all nodes in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this represents the stats of the single instance.
   */
  public PortStatusDTOBuilder setAggregateSnapshot(final PortStatusSnapshotDTO aggregateSnapshot) {
    this.aggregateSnapshot = aggregateSnapshot;
    return this;
  }

  /**
   * A status snapshot that represents the aggregate stats of all nodes in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this represents the stats of the single instance.
   */
  public PortStatusDTOBuilder setAggregateSnapshot(
      final Consumer<PortStatusSnapshotDTOBuilder> configurator) {
    final PortStatusSnapshotDTOBuilder builder = (aggregateSnapshot != null ? PortStatusSnapshotDTOBuilder.of(aggregateSnapshot) : new PortStatusSnapshotDTOBuilder());
    configurator.accept(builder);
    return setAggregateSnapshot(builder.build());
  }

  /**
   * A status snapshot that represents the aggregate stats of all nodes in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this represents the stats of the single instance.
   */
  public PortStatusDTOBuilder setAggregateSnapshot(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PortStatusSnapshotDTOBuilder.class) final Closure<PortStatusSnapshotDTOBuilder> closure) {
    return setAggregateSnapshot(c -> {
      final Closure<PortStatusSnapshotDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * The id of the parent process group of the port.
   */
  public String getGroupId() {
    return groupId;
  }

  /**
   * The id of the parent process group of the port.
   */
  public PortStatusDTOBuilder setGroupId(final String groupId) {
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
  public PortStatusDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The name of the port.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the port.
   */
  public PortStatusDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * A status snapshot for each node in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this may be null.
   */
  public List<NodePortStatusSnapshotDTO> getNodeSnapshots() {
    return nodeSnapshots;
  }

  /**
   * A status snapshot for each node in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this may be null.
   */
  public PortStatusDTOBuilder setNodeSnapshots(
      final List<NodePortStatusSnapshotDTO> nodeSnapshots) {
    this.nodeSnapshots = nodeSnapshots;
    return this;
  }

  /**
   * The run status of the port.
   */
  public String getRunStatus() {
    return runStatus;
  }

  /**
   * The run status of the port.
   */
  public PortStatusDTOBuilder setRunStatus(final String runStatus) {
    this.runStatus = runStatus;
    return this;
  }

  /**
   * The time the status for the process group was last refreshed.
   */
  public Date getStatsLastRefreshed() {
    return statsLastRefreshed;
  }

  /**
   * The time the status for the process group was last refreshed.
   */
  public PortStatusDTOBuilder setStatsLastRefreshed(final Date statsLastRefreshed) {
    this.statsLastRefreshed = statsLastRefreshed;
    return this;
  }

  /**
   * Whether the port has incoming or outgoing connections to a remote NiFi.
   */
  public Boolean getTransmitting() {
    return transmitting;
  }

  /**
   * Whether the port has incoming or outgoing connections to a remote NiFi.
   */
  public PortStatusDTOBuilder setTransmitting(final Boolean transmitting) {
    this.transmitting = transmitting;
    return this;
  }

  public PortStatusDTO build() {
    final PortStatusDTO portStatusDTO = new PortStatusDTO();
    portStatusDTO.setAggregateSnapshot(aggregateSnapshot);
    portStatusDTO.setGroupId(groupId);
    portStatusDTO.setId(id);
    portStatusDTO.setName(name);
    portStatusDTO.setNodeSnapshots(nodeSnapshots);
    portStatusDTO.setRunStatus(runStatus);
    portStatusDTO.setStatsLastRefreshed(statsLastRefreshed);
    portStatusDTO.setTransmitting(transmitting);
    return portStatusDTO;
  }

  public static PortStatusDTOBuilder of(final PortStatusDTO portStatusDTO) {
    final PortStatusDTOBuilder portStatusDTOBuilder = new PortStatusDTOBuilder();
    portStatusDTOBuilder.setAggregateSnapshot(portStatusDTO.getAggregateSnapshot());
    portStatusDTOBuilder.setGroupId(portStatusDTO.getGroupId());
    portStatusDTOBuilder.setId(portStatusDTO.getId());
    portStatusDTOBuilder.setName(portStatusDTO.getName());
    portStatusDTOBuilder.setNodeSnapshots(portStatusDTO.getNodeSnapshots());
    portStatusDTOBuilder.setRunStatus(portStatusDTO.getRunStatus());
    portStatusDTOBuilder.setStatsLastRefreshed(portStatusDTO.getStatsLastRefreshed());
    portStatusDTOBuilder.setTransmitting(portStatusDTO.isTransmitting());
    return portStatusDTOBuilder;
  }
}
