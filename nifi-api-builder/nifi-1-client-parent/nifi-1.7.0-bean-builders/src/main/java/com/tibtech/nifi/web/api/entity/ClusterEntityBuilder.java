package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.ClusterDTO;
import org.apache.nifi.web.api.entity.ClusterEntity;

public final class ClusterEntityBuilder extends AbstractEntityBuilder<ClusterEntityBuilder> {
  private ClusterDTO cluster;

  public ClusterDTO getCluster() {
    return cluster;
  }

  public ClusterEntityBuilder setCluster(final ClusterDTO cluster) {
    this.cluster = cluster;
    return this;
  }

  public ClusterEntity build() {
    final ClusterEntity clusterEntity = new ClusterEntity();
    super.setPropertyValues(clusterEntity);
    clusterEntity.setCluster(cluster);
    return clusterEntity;
  }

  public static ClusterEntityBuilder of(final ClusterEntity clusterEntity) {
    final ClusterEntityBuilder clusterEntityBuilder = new ClusterEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(clusterEntityBuilder, clusterEntity);
    clusterEntityBuilder.setCluster(clusterEntity.getCluster());
    return clusterEntityBuilder;
  }
}
