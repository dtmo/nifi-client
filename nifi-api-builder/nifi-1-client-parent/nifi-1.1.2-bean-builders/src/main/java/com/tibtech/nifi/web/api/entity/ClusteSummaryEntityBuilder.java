package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.ClusterSummaryDTO;
import org.apache.nifi.web.api.entity.ClusteSummaryEntity;

public final class ClusteSummaryEntityBuilder extends AbstractEntityBuilder<ClusteSummaryEntityBuilder> {
  private ClusterSummaryDTO clusterSummary;

  public ClusterSummaryDTO getClusterSummary() {
    return clusterSummary;
  }

  public ClusteSummaryEntityBuilder setClusterSummary(final ClusterSummaryDTO clusterSummary) {
    this.clusterSummary = clusterSummary;
    return this;
  }

  public ClusteSummaryEntity build() {
    final ClusteSummaryEntity clusteSummaryEntity = new ClusteSummaryEntity();
    super.setPropertyValues(clusteSummaryEntity);
    clusteSummaryEntity.setClusterSummary(clusterSummary);
    return clusteSummaryEntity;
  }

  public static ClusteSummaryEntityBuilder of(final ClusteSummaryEntity clusteSummaryEntity) {
    final ClusteSummaryEntityBuilder clusteSummaryEntityBuilder = new ClusteSummaryEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(clusteSummaryEntityBuilder, clusteSummaryEntity);
    clusteSummaryEntityBuilder.setClusterSummary(clusteSummaryEntity.getClusterSummary());
    return clusteSummaryEntityBuilder;
  }
}
