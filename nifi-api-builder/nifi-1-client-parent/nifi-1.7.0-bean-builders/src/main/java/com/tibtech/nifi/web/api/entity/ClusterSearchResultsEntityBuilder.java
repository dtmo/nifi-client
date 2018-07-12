package com.tibtech.nifi.web.api.entity;

import java.util.List;
import org.apache.nifi.web.api.dto.search.NodeSearchResultDTO;
import org.apache.nifi.web.api.entity.ClusterSearchResultsEntity;

public final class ClusterSearchResultsEntityBuilder {
  private List<NodeSearchResultDTO> nodeResults;

  public List<NodeSearchResultDTO> getNodeResults() {
    return nodeResults;
  }

  public ClusterSearchResultsEntityBuilder setNodeResults(
      final List<NodeSearchResultDTO> nodeResults) {
    this.nodeResults = nodeResults;
    return this;
  }

  public ClusterSearchResultsEntity build() {
    final ClusterSearchResultsEntity clusterSearchResultsEntity = new ClusterSearchResultsEntity();
    clusterSearchResultsEntity.setNodeResults(nodeResults);
    return clusterSearchResultsEntity;
  }

  public static ClusterSearchResultsEntityBuilder of(
      final ClusterSearchResultsEntity clusterSearchResultsEntity) {
    final ClusterSearchResultsEntityBuilder clusterSearchResultsEntityBuilder = new ClusterSearchResultsEntityBuilder();
    clusterSearchResultsEntityBuilder.setNodeResults(clusterSearchResultsEntity.getNodeResults());
    return clusterSearchResultsEntityBuilder;
  }
}
