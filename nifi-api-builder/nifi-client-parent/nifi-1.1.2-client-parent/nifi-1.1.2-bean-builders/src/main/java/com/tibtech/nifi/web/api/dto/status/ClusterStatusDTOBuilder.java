package com.tibtech.nifi.web.api.dto.status;

import java.util.Collection;
import org.apache.nifi.web.api.dto.status.ClusterStatusDTO;
import org.apache.nifi.web.api.dto.status.NodeStatusDTO;

public final class ClusterStatusDTOBuilder {
  private Collection<NodeStatusDTO> nodeStatus;

  /**
   * The status of each node.
   */
  public Collection<NodeStatusDTO> getNodeStatus() {
    return nodeStatus;
  }

  /**
   * The status of each node.
   */
  public ClusterStatusDTOBuilder setNodeStatus(final Collection<NodeStatusDTO> nodeStatus) {
    this.nodeStatus = nodeStatus;
    return this;
  }

  public ClusterStatusDTO build() {
    final ClusterStatusDTO clusterStatusDTO = new ClusterStatusDTO();
    clusterStatusDTO.setNodeStatus(nodeStatus);
    return clusterStatusDTO;
  }

  public static ClusterStatusDTOBuilder of(final ClusterStatusDTO clusterStatusDTO) {
    final ClusterStatusDTOBuilder clusterStatusDTOBuilder = new ClusterStatusDTOBuilder();
    clusterStatusDTOBuilder.setNodeStatus(clusterStatusDTO.getNodeStatus());
    return clusterStatusDTOBuilder;
  }
}
