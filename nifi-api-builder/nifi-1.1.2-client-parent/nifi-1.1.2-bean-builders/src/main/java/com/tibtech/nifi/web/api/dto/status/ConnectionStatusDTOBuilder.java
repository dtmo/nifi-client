package com.tibtech.nifi.web.api.dto.status;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import org.apache.nifi.web.api.dto.status.ConnectionStatusDTO;
import org.apache.nifi.web.api.dto.status.ConnectionStatusSnapshotDTO;
import org.apache.nifi.web.api.dto.status.NodeConnectionStatusSnapshotDTO;

public final class ConnectionStatusDTOBuilder {
  private ConnectionStatusSnapshotDTO aggregateSnapshot;

  private String destinationId;

  private String destinationName;

  private String groupId;

  private String id;

  private String name;

  private List<NodeConnectionStatusSnapshotDTO> nodeSnapshots;

  private String sourceId;

  private String sourceName;

  private Date statsLastRefreshed;

  /**
   * The status snapshot that represents the aggregate stats of the cluster
   */
  public ConnectionStatusSnapshotDTO getAggregateSnapshot() {
    return aggregateSnapshot;
  }

  /**
   * The status snapshot that represents the aggregate stats of the cluster
   */
  public ConnectionStatusDTOBuilder setAggregateSnapshot(final ConnectionStatusSnapshotDTO aggregateSnapshot) {
    this.aggregateSnapshot = aggregateSnapshot;
    return this;
  }

  /**
   * The status snapshot that represents the aggregate stats of the cluster
   */
  public ConnectionStatusDTOBuilder setAggregateSnapshot(final Function<ConnectionStatusSnapshotDTOBuilder, ConnectionStatusSnapshotDTOBuilder> configurator) {
    return setAggregateSnapshot(configurator.apply(aggregateSnapshot != null ? ConnectionStatusSnapshotDTOBuilder.of(aggregateSnapshot) : new ConnectionStatusSnapshotDTOBuilder()).build());
  }

  /**
   * The status snapshot that represents the aggregate stats of the cluster
   */
  public ConnectionStatusDTOBuilder setAggregateSnapshot(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConnectionStatusSnapshotDTOBuilder.class) final Closure<ConnectionStatusSnapshotDTOBuilder> closure) {
    return setAggregateSnapshot(c -> {
      final Closure<ConnectionStatusSnapshotDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  /**
   * The ID of the destination component
   */
  public String getDestinationId() {
    return destinationId;
  }

  /**
   * The ID of the destination component
   */
  public ConnectionStatusDTOBuilder setDestinationId(final String destinationId) {
    this.destinationId = destinationId;
    return this;
  }

  /**
   * The name of the destination component
   */
  public String getDestinationName() {
    return destinationName;
  }

  /**
   * The name of the destination component
   */
  public ConnectionStatusDTOBuilder setDestinationName(final String destinationName) {
    this.destinationName = destinationName;
    return this;
  }

  /**
   * The ID of the Process Group that the connection belongs to
   */
  public String getGroupId() {
    return groupId;
  }

  /**
   * The ID of the Process Group that the connection belongs to
   */
  public ConnectionStatusDTOBuilder setGroupId(final String groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * The ID of the connection
   */
  public String getId() {
    return id;
  }

  /**
   * The ID of the connection
   */
  public ConnectionStatusDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The name of the connection
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the connection
   */
  public ConnectionStatusDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * A list of status snapshots for each node
   */
  public List<NodeConnectionStatusSnapshotDTO> getNodeSnapshots() {
    return nodeSnapshots;
  }

  /**
   * A list of status snapshots for each node
   */
  public ConnectionStatusDTOBuilder setNodeSnapshots(final List<NodeConnectionStatusSnapshotDTO> nodeSnapshots) {
    this.nodeSnapshots = nodeSnapshots;
    return this;
  }

  /**
   * The ID of the source component
   */
  public String getSourceId() {
    return sourceId;
  }

  /**
   * The ID of the source component
   */
  public ConnectionStatusDTOBuilder setSourceId(final String sourceId) {
    this.sourceId = sourceId;
    return this;
  }

  /**
   * The name of the source component
   */
  public String getSourceName() {
    return sourceName;
  }

  /**
   * The name of the source component
   */
  public ConnectionStatusDTOBuilder setSourceName(final String sourceName) {
    this.sourceName = sourceName;
    return this;
  }

  /**
   * The timestamp of when the stats were last refreshed
   */
  public Date getStatsLastRefreshed() {
    return statsLastRefreshed;
  }

  /**
   * The timestamp of when the stats were last refreshed
   */
  public ConnectionStatusDTOBuilder setStatsLastRefreshed(final Date statsLastRefreshed) {
    this.statsLastRefreshed = statsLastRefreshed;
    return this;
  }

  public ConnectionStatusDTO build() {
    final ConnectionStatusDTO connectionStatusDTO = new ConnectionStatusDTO();
    connectionStatusDTO.setAggregateSnapshot(aggregateSnapshot);
    connectionStatusDTO.setDestinationId(destinationId);
    connectionStatusDTO.setDestinationName(destinationName);
    connectionStatusDTO.setGroupId(groupId);
    connectionStatusDTO.setId(id);
    connectionStatusDTO.setName(name);
    connectionStatusDTO.setNodeSnapshots(nodeSnapshots);
    connectionStatusDTO.setSourceId(sourceId);
    connectionStatusDTO.setSourceName(sourceName);
    connectionStatusDTO.setStatsLastRefreshed(statsLastRefreshed);
    return connectionStatusDTO;
  }

  public static ConnectionStatusDTOBuilder of(final ConnectionStatusDTO connectionStatusDTO) {
    final ConnectionStatusDTOBuilder connectionStatusDTOBuilder = new ConnectionStatusDTOBuilder();
    connectionStatusDTOBuilder.setAggregateSnapshot(connectionStatusDTO.getAggregateSnapshot());
    connectionStatusDTOBuilder.setDestinationId(connectionStatusDTO.getDestinationId());
    connectionStatusDTOBuilder.setDestinationName(connectionStatusDTO.getDestinationName());
    connectionStatusDTOBuilder.setGroupId(connectionStatusDTO.getGroupId());
    connectionStatusDTOBuilder.setId(connectionStatusDTO.getId());
    connectionStatusDTOBuilder.setName(connectionStatusDTO.getName());
    connectionStatusDTOBuilder.setNodeSnapshots(connectionStatusDTO.getNodeSnapshots());
    connectionStatusDTOBuilder.setSourceId(connectionStatusDTO.getSourceId());
    connectionStatusDTOBuilder.setSourceName(connectionStatusDTO.getSourceName());
    connectionStatusDTOBuilder.setStatsLastRefreshed(connectionStatusDTO.getStatsLastRefreshed());
    return connectionStatusDTOBuilder;
  }
}
