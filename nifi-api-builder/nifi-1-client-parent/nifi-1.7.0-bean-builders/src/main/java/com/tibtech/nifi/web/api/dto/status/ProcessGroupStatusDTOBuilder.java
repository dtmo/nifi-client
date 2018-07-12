package com.tibtech.nifi.web.api.dto.status;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.status.NodeProcessGroupStatusSnapshotDTO;
import org.apache.nifi.web.api.dto.status.ProcessGroupStatusDTO;
import org.apache.nifi.web.api.dto.status.ProcessGroupStatusSnapshotDTO;

public final class ProcessGroupStatusDTOBuilder {
  private ProcessGroupStatusSnapshotDTO aggregateSnapshot;

  private String id;

  private String name;

  private List<NodeProcessGroupStatusSnapshotDTO> nodeSnapshots;

  private Date statsLastRefreshed;

  /**
   * The aggregate status of all nodes in the cluster
   */
  public ProcessGroupStatusSnapshotDTO getAggregateSnapshot() {
    return aggregateSnapshot;
  }

  /**
   * The aggregate status of all nodes in the cluster
   */
  public ProcessGroupStatusDTOBuilder setAggregateSnapshot(
      final ProcessGroupStatusSnapshotDTO aggregateSnapshot) {
    this.aggregateSnapshot = aggregateSnapshot;
    return this;
  }

  /**
   * The aggregate status of all nodes in the cluster
   */
  public ProcessGroupStatusDTOBuilder setAggregateSnapshot(
      final Consumer<ProcessGroupStatusSnapshotDTOBuilder> configurator) {
    final ProcessGroupStatusSnapshotDTOBuilder builder = (aggregateSnapshot != null ? ProcessGroupStatusSnapshotDTOBuilder.of(aggregateSnapshot) : new ProcessGroupStatusSnapshotDTOBuilder());
    configurator.accept(builder);
    return setAggregateSnapshot(builder.build());
  }

  /**
   * The aggregate status of all nodes in the cluster
   */
  public ProcessGroupStatusDTOBuilder setAggregateSnapshot(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessGroupStatusSnapshotDTOBuilder.class) final Closure<ProcessGroupStatusSnapshotDTOBuilder> closure) {
    return setAggregateSnapshot(c -> {
      final Closure<ProcessGroupStatusSnapshotDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * The ID of the Process Group
   */
  public String getId() {
    return id;
  }

  /**
   * The ID of the Process Group
   */
  public ProcessGroupStatusDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The name of the Process Group
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the Process Group
   */
  public ProcessGroupStatusDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * The status reported by each node in the cluster. If the NiFi instance is a standalone instance, rather than a clustered instance, this value may be null.
   */
  public List<NodeProcessGroupStatusSnapshotDTO> getNodeSnapshots() {
    return nodeSnapshots;
  }

  /**
   * The status reported by each node in the cluster. If the NiFi instance is a standalone instance, rather than a clustered instance, this value may be null.
   */
  public ProcessGroupStatusDTOBuilder setNodeSnapshots(
      final List<NodeProcessGroupStatusSnapshotDTO> nodeSnapshots) {
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
  public ProcessGroupStatusDTOBuilder setStatsLastRefreshed(final Date statsLastRefreshed) {
    this.statsLastRefreshed = statsLastRefreshed;
    return this;
  }

  public ProcessGroupStatusDTO build() {
    final ProcessGroupStatusDTO processGroupStatusDTO = new ProcessGroupStatusDTO();
    processGroupStatusDTO.setAggregateSnapshot(aggregateSnapshot);
    processGroupStatusDTO.setId(id);
    processGroupStatusDTO.setName(name);
    processGroupStatusDTO.setNodeSnapshots(nodeSnapshots);
    processGroupStatusDTO.setStatsLastRefreshed(statsLastRefreshed);
    return processGroupStatusDTO;
  }

  public static ProcessGroupStatusDTOBuilder of(final ProcessGroupStatusDTO processGroupStatusDTO) {
    final ProcessGroupStatusDTOBuilder processGroupStatusDTOBuilder = new ProcessGroupStatusDTOBuilder();
    processGroupStatusDTOBuilder.setAggregateSnapshot(processGroupStatusDTO.getAggregateSnapshot());
    processGroupStatusDTOBuilder.setId(processGroupStatusDTO.getId());
    processGroupStatusDTOBuilder.setName(processGroupStatusDTO.getName());
    processGroupStatusDTOBuilder.setNodeSnapshots(processGroupStatusDTO.getNodeSnapshots());
    processGroupStatusDTOBuilder.setStatsLastRefreshed(processGroupStatusDTO.getStatsLastRefreshed());
    return processGroupStatusDTOBuilder;
  }
}
