package com.tibtech.nifi.web.api.dto;

import java.lang.Integer;
import java.lang.String;
import org.apache.nifi.web.api.dto.ClusterSummaryDTO;

public final class ClusterSummaryDTOBuilder {
  private Integer connectedNodeCount;

  private String connectedNodes;

  private Integer totalNodeCount;

  /**
   * The number of nodes that are currently connected to the cluster
   */
  public Integer getConnectedNodeCount() {
    return connectedNodeCount;
  }

  /**
   * The number of nodes that are currently connected to the cluster
   */
  public ClusterSummaryDTOBuilder setConnectedNodeCount(final Integer connectedNodeCount) {
    this.connectedNodeCount = connectedNodeCount;
    return this;
  }

  /**
   * When clustered, reports the number of nodes connected vs the number of nodes in the cluster.
   */
  public String getConnectedNodes() {
    return connectedNodes;
  }

  /**
   * When clustered, reports the number of nodes connected vs the number of nodes in the cluster.
   */
  public ClusterSummaryDTOBuilder setConnectedNodes(final String connectedNodes) {
    this.connectedNodes = connectedNodes;
    return this;
  }

  /**
   * The number of nodes in the cluster, regardless of whether or not they are connected
   */
  public Integer getTotalNodeCount() {
    return totalNodeCount;
  }

  /**
   * The number of nodes in the cluster, regardless of whether or not they are connected
   */
  public ClusterSummaryDTOBuilder setTotalNodeCount(final Integer totalNodeCount) {
    this.totalNodeCount = totalNodeCount;
    return this;
  }

  public ClusterSummaryDTO build() {
    final ClusterSummaryDTO clusterSummaryDTO = new ClusterSummaryDTO();
    clusterSummaryDTO.setConnectedNodeCount(connectedNodeCount);
    clusterSummaryDTO.setConnectedNodes(connectedNodes);
    clusterSummaryDTO.setTotalNodeCount(totalNodeCount);
    return clusterSummaryDTO;
  }

  public static ClusterSummaryDTOBuilder of(final ClusterSummaryDTO clusterSummaryDTO) {
    final ClusterSummaryDTOBuilder clusterSummaryDTOBuilder = new ClusterSummaryDTOBuilder();
    clusterSummaryDTOBuilder.setConnectedNodeCount(clusterSummaryDTO.getConnectedNodeCount());
    clusterSummaryDTOBuilder.setConnectedNodes(clusterSummaryDTO.getConnectedNodes());
    clusterSummaryDTOBuilder.setTotalNodeCount(clusterSummaryDTO.getTotalNodeCount());
    return clusterSummaryDTOBuilder;
  }
}
