package com.tibtech.nifi.web.api.dto;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.util.List;
import java.util.function.Consumer;
import org.apache.nifi.web.api.dto.CountersDTO;
import org.apache.nifi.web.api.dto.CountersSnapshotDTO;
import org.apache.nifi.web.api.dto.NodeCountersSnapshotDTO;

public final class CountersDTOBuilder {
  private CountersSnapshotDTO aggregateSnapshot;

  private List<NodeCountersSnapshotDTO> nodeSnapshots;

  /**
   * A Counters snapshot that represents the aggregate values of all nodes in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this represents the stats of the single instance.
   */
  public CountersSnapshotDTO getAggregateSnapshot() {
    return aggregateSnapshot;
  }

  /**
   * A Counters snapshot that represents the aggregate values of all nodes in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this represents the stats of the single instance.
   */
  public CountersDTOBuilder setAggregateSnapshot(final CountersSnapshotDTO aggregateSnapshot) {
    this.aggregateSnapshot = aggregateSnapshot;
    return this;
  }

  /**
   * A Counters snapshot that represents the aggregate values of all nodes in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this represents the stats of the single instance.
   */
  public CountersDTOBuilder setAggregateSnapshot(final Consumer<CountersSnapshotDTOBuilder> configurator) {
    final CountersSnapshotDTOBuilder builder = (aggregateSnapshot != null ? CountersSnapshotDTOBuilder.of(aggregateSnapshot) : new CountersSnapshotDTOBuilder());
    configurator.accept(builder);
    return setAggregateSnapshot(builder.build());
  }

  /**
   * A Counters snapshot that represents the aggregate values of all nodes in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this represents the stats of the single instance.
   */
  public CountersDTOBuilder setAggregateSnapshot(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CountersSnapshotDTOBuilder.class) final Closure<CountersSnapshotDTOBuilder> closure) {
    return setAggregateSnapshot(c -> {
      final Closure<CountersSnapshotDTOBuilder> code = closure.rehydrate(c, this, this);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
    } );
  }

  /**
   * A Counters snapshot for each node in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this may be null.
   */
  public List<NodeCountersSnapshotDTO> getNodeSnapshots() {
    return nodeSnapshots;
  }

  /**
   * A Counters snapshot for each node in the cluster. If the NiFi instance is a standalone instance, rather than a cluster, this may be null.
   */
  public CountersDTOBuilder setNodeSnapshots(final List<NodeCountersSnapshotDTO> nodeSnapshots) {
    this.nodeSnapshots = nodeSnapshots;
    return this;
  }

  public CountersDTO build() {
    final CountersDTO countersDTO = new CountersDTO();
    countersDTO.setAggregateSnapshot(aggregateSnapshot);
    countersDTO.setNodeSnapshots(nodeSnapshots);
    return countersDTO;
  }

  public static CountersDTOBuilder of(final CountersDTO countersDTO) {
    final CountersDTOBuilder countersDTOBuilder = new CountersDTOBuilder();
    countersDTOBuilder.setAggregateSnapshot(countersDTO.getAggregateSnapshot());
    countersDTOBuilder.setNodeSnapshots(countersDTO.getNodeSnapshots());
    return countersDTOBuilder;
  }
}
