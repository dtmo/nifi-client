package com.tibtech.nifi.web.api.dto.status;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.status.NodeRemoteProcessGroupStatusSnapshotDTO;
import org.apache.nifi.web.api.dto.status.RemoteProcessGroupStatusDTO;
import org.apache.nifi.web.api.dto.status.RemoteProcessGroupStatusSnapshotDTO;

public final class RemoteProcessGroupStatusDTOBuilder {
  private RemoteProcessGroupStatusSnapshotDTO aggregateSnapshot;

  private String groupId;

  private String id;

  private String name;

  private List<NodeRemoteProcessGroupStatusSnapshotDTO> nodeSnapshots;

  private Date statsLastRefreshed;

  private String targetUri;

  private String transmissionStatus;

  /**
   * A status snapshot that represents the aggregate stats of all nodes in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this represents the stats of the single instance.
   */
  public RemoteProcessGroupStatusSnapshotDTO getAggregateSnapshot() {
    return aggregateSnapshot;
  }

  /**
   * A status snapshot that represents the aggregate stats of all nodes in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this represents the stats of the single instance.
   */
  public RemoteProcessGroupStatusDTOBuilder setAggregateSnapshot(
      final RemoteProcessGroupStatusSnapshotDTO aggregateSnapshot) {
    this.aggregateSnapshot = aggregateSnapshot;
    return this;
  }

  /**
   * A status snapshot that represents the aggregate stats of all nodes in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this represents the stats of the single instance.
   */
  public RemoteProcessGroupStatusDTOBuilder setAggregateSnapshot(
      final Consumer<RemoteProcessGroupStatusSnapshotDTOBuilder> configurator) {
    final RemoteProcessGroupStatusSnapshotDTOBuilder builder = (aggregateSnapshot != null ? RemoteProcessGroupStatusSnapshotDTOBuilder.of(aggregateSnapshot) : new RemoteProcessGroupStatusSnapshotDTOBuilder());
    configurator.accept(builder);
    return setAggregateSnapshot(builder.build());
  }

  /**
   * A status snapshot that represents the aggregate stats of all nodes in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this represents the stats of the single instance.
   */
  public RemoteProcessGroupStatusDTOBuilder setAggregateSnapshot(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = RemoteProcessGroupStatusSnapshotDTOBuilder.class) final Closure<RemoteProcessGroupStatusSnapshotDTOBuilder> closure) {
    return setAggregateSnapshot(c -> {
      final Closure<RemoteProcessGroupStatusSnapshotDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * The unique ID of the process group that the Processor belongs to
   */
  public String getGroupId() {
    return groupId;
  }

  /**
   * The unique ID of the process group that the Processor belongs to
   */
  public RemoteProcessGroupStatusDTOBuilder setGroupId(final String groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * The unique ID of the Processor
   */
  public String getId() {
    return id;
  }

  /**
   * The unique ID of the Processor
   */
  public RemoteProcessGroupStatusDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The name of the remote process group.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the remote process group.
   */
  public RemoteProcessGroupStatusDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * A status snapshot for each node in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this may be null.
   */
  public List<NodeRemoteProcessGroupStatusSnapshotDTO> getNodeSnapshots() {
    return nodeSnapshots;
  }

  /**
   * A status snapshot for each node in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this may be null.
   */
  public RemoteProcessGroupStatusDTOBuilder setNodeSnapshots(
      final List<NodeRemoteProcessGroupStatusSnapshotDTO> nodeSnapshots) {
    this.nodeSnapshots = nodeSnapshots;
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
  public RemoteProcessGroupStatusDTOBuilder setStatsLastRefreshed(final Date statsLastRefreshed) {
    this.statsLastRefreshed = statsLastRefreshed;
    return this;
  }

  /**
   * The URI of the target system.
   */
  public String getTargetUri() {
    return targetUri;
  }

  /**
   * The URI of the target system.
   */
  public RemoteProcessGroupStatusDTOBuilder setTargetUri(final String targetUri) {
    this.targetUri = targetUri;
    return this;
  }

  /**
   * The transmission status of the remote process group.
   */
  public String getTransmissionStatus() {
    return transmissionStatus;
  }

  /**
   * The transmission status of the remote process group.
   */
  public RemoteProcessGroupStatusDTOBuilder setTransmissionStatus(final String transmissionStatus) {
    this.transmissionStatus = transmissionStatus;
    return this;
  }

  public RemoteProcessGroupStatusDTO build() {
    final RemoteProcessGroupStatusDTO remoteProcessGroupStatusDTO = new RemoteProcessGroupStatusDTO();
    remoteProcessGroupStatusDTO.setAggregateSnapshot(aggregateSnapshot);
    remoteProcessGroupStatusDTO.setGroupId(groupId);
    remoteProcessGroupStatusDTO.setId(id);
    remoteProcessGroupStatusDTO.setName(name);
    remoteProcessGroupStatusDTO.setNodeSnapshots(nodeSnapshots);
    remoteProcessGroupStatusDTO.setStatsLastRefreshed(statsLastRefreshed);
    remoteProcessGroupStatusDTO.setTargetUri(targetUri);
    remoteProcessGroupStatusDTO.setTransmissionStatus(transmissionStatus);
    return remoteProcessGroupStatusDTO;
  }

  public static RemoteProcessGroupStatusDTOBuilder of(
      final RemoteProcessGroupStatusDTO remoteProcessGroupStatusDTO) {
    final RemoteProcessGroupStatusDTOBuilder remoteProcessGroupStatusDTOBuilder = new RemoteProcessGroupStatusDTOBuilder();
    remoteProcessGroupStatusDTOBuilder.setAggregateSnapshot(remoteProcessGroupStatusDTO.getAggregateSnapshot());
    remoteProcessGroupStatusDTOBuilder.setGroupId(remoteProcessGroupStatusDTO.getGroupId());
    remoteProcessGroupStatusDTOBuilder.setId(remoteProcessGroupStatusDTO.getId());
    remoteProcessGroupStatusDTOBuilder.setName(remoteProcessGroupStatusDTO.getName());
    remoteProcessGroupStatusDTOBuilder.setNodeSnapshots(remoteProcessGroupStatusDTO.getNodeSnapshots());
    remoteProcessGroupStatusDTOBuilder.setStatsLastRefreshed(remoteProcessGroupStatusDTO.getStatsLastRefreshed());
    remoteProcessGroupStatusDTOBuilder.setTargetUri(remoteProcessGroupStatusDTO.getTargetUri());
    remoteProcessGroupStatusDTOBuilder.setTransmissionStatus(remoteProcessGroupStatusDTO.getTransmissionStatus());
    return remoteProcessGroupStatusDTOBuilder;
  }
}
