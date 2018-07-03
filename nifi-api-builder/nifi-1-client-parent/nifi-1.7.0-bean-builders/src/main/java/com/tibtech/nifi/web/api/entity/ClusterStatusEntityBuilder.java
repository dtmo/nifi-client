package com.tibtech.nifi.web.api.entity;

import org.apache.nifi.web.api.dto.status.ClusterStatusDTO;
import org.apache.nifi.web.api.entity.ClusterStatusEntity;

public final class ClusterStatusEntityBuilder extends AbstractEntityBuilder<ClusterStatusEntityBuilder> {
  private ClusterStatusDTO clusterStatus;

  public ClusterStatusDTO getClusterStatus() {
    return clusterStatus;
  }

  public ClusterStatusEntityBuilder setClusterStatus(final ClusterStatusDTO clusterStatus) {
    this.clusterStatus = clusterStatus;
    return this;
  }

  public ClusterStatusEntity build() {
    final ClusterStatusEntity clusterStatusEntity = new ClusterStatusEntity();
    super.setPropertyValues(clusterStatusEntity);
    clusterStatusEntity.setClusterStatus(clusterStatus);
    return clusterStatusEntity;
  }

  public static ClusterStatusEntityBuilder of(final ClusterStatusEntity clusterStatusEntity) {
    final ClusterStatusEntityBuilder clusterStatusEntityBuilder = new ClusterStatusEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(clusterStatusEntityBuilder, clusterStatusEntity);
    clusterStatusEntityBuilder.setClusterStatus(clusterStatusEntity.getClusterStatus());
    return clusterStatusEntityBuilder;
  }
}
