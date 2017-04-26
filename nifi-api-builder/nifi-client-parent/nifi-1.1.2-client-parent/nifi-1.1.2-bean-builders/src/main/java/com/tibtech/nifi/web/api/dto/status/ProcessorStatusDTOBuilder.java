package com.tibtech.nifi.web.api.dto.status;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import org.apache.nifi.web.api.dto.status.NodeProcessorStatusSnapshotDTO;
import org.apache.nifi.web.api.dto.status.ProcessorStatusDTO;
import org.apache.nifi.web.api.dto.status.ProcessorStatusSnapshotDTO;

public final class ProcessorStatusDTOBuilder {
  private ProcessorStatusSnapshotDTO aggregateSnapshot;

  private String groupId;

  private String id;

  private String name;

  private List<NodeProcessorStatusSnapshotDTO> nodeSnapshots;

  private String runStatus;

  private Date statsLastRefreshed;

  private String type;

  /**
   * A status snapshot that represents the aggregate stats of all nodes in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this represents the stats of the single instance.
   */
  public ProcessorStatusSnapshotDTO getAggregateSnapshot() {
    return aggregateSnapshot;
  }

  /**
   * A status snapshot that represents the aggregate stats of all nodes in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this represents the stats of the single instance.
   */
  public ProcessorStatusDTOBuilder setAggregateSnapshot(final ProcessorStatusSnapshotDTO aggregateSnapshot) {
    this.aggregateSnapshot = aggregateSnapshot;
    return this;
  }

  /**
   * A status snapshot that represents the aggregate stats of all nodes in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this represents the stats of the single instance.
   */
  public ProcessorStatusDTOBuilder setAggregateSnapshot(final Function<ProcessorStatusSnapshotDTOBuilder, ProcessorStatusSnapshotDTOBuilder> configurator) {
    return setAggregateSnapshot(configurator.apply(new ProcessorStatusSnapshotDTOBuilder()).build());
  }

  /**
   * A status snapshot that represents the aggregate stats of all nodes in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this represents the stats of the single instance.
   */
  public ProcessorStatusDTOBuilder setAggregateSnapshot(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ProcessorStatusSnapshotDTOBuilder.class) final Closure<ProcessorStatusSnapshotDTOBuilder> closure) {
    return setAggregateSnapshot(c -> {
      final Closure<ProcessorStatusSnapshotDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
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
  public ProcessorStatusDTOBuilder setGroupId(final String groupId) {
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
  public ProcessorStatusDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The name of the Processor
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the Processor
   */
  public ProcessorStatusDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  /**
   * A status snapshot for each node in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this may be null.
   */
  public List<NodeProcessorStatusSnapshotDTO> getNodeSnapshots() {
    return nodeSnapshots;
  }

  /**
   * A status snapshot for each node in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this may be null.
   */
  public ProcessorStatusDTOBuilder setNodeSnapshots(final List<NodeProcessorStatusSnapshotDTO> nodeSnapshots) {
    this.nodeSnapshots = nodeSnapshots;
    return this;
  }

  /**
   * The run status of the Processor
   */
  public String getRunStatus() {
    return runStatus;
  }

  /**
   * The run status of the Processor
   */
  public ProcessorStatusDTOBuilder setRunStatus(final String runStatus) {
    this.runStatus = runStatus;
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
  public ProcessorStatusDTOBuilder setStatsLastRefreshed(final Date statsLastRefreshed) {
    this.statsLastRefreshed = statsLastRefreshed;
    return this;
  }

  /**
   * The type of the Processor
   */
  public String getType() {
    return type;
  }

  /**
   * The type of the Processor
   */
  public ProcessorStatusDTOBuilder setType(final String type) {
    this.type = type;
    return this;
  }

  public ProcessorStatusDTO build() {
    final ProcessorStatusDTO processorStatusDTO = new ProcessorStatusDTO();
    processorStatusDTO.setAggregateSnapshot(aggregateSnapshot);
    processorStatusDTO.setGroupId(groupId);
    processorStatusDTO.setId(id);
    processorStatusDTO.setName(name);
    processorStatusDTO.setNodeSnapshots(nodeSnapshots);
    processorStatusDTO.setRunStatus(runStatus);
    processorStatusDTO.setStatsLastRefreshed(statsLastRefreshed);
    processorStatusDTO.setType(type);
    return processorStatusDTO;
  }

  public static ProcessorStatusDTOBuilder of(final ProcessorStatusDTO processorStatusDTO) {
    final ProcessorStatusDTOBuilder processorStatusDTOBuilder = new ProcessorStatusDTOBuilder();
    processorStatusDTOBuilder.setAggregateSnapshot(processorStatusDTO.getAggregateSnapshot());
    processorStatusDTOBuilder.setGroupId(processorStatusDTO.getGroupId());
    processorStatusDTOBuilder.setId(processorStatusDTO.getId());
    processorStatusDTOBuilder.setName(processorStatusDTO.getName());
    processorStatusDTOBuilder.setNodeSnapshots(processorStatusDTO.getNodeSnapshots());
    processorStatusDTOBuilder.setRunStatus(processorStatusDTO.getRunStatus());
    processorStatusDTOBuilder.setStatsLastRefreshed(processorStatusDTO.getStatsLastRefreshed());
    processorStatusDTOBuilder.setType(processorStatusDTO.getType());
    return processorStatusDTOBuilder;
  }
}
