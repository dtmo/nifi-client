package com.tibtech.nifi.web.api.dto;

import java.util.Collection;
import java.util.Date;
import org.apache.nifi.web.api.dto.ClusterDTO;
import org.apache.nifi.web.api.dto.NodeDTO;

public final class ClusterDTOBuilder {
  private Date generated;

  private Collection<NodeDTO> nodes;

  /**
   * The timestamp the report was generated.
   */
  public Date getGenerated() {
    return generated;
  }

  /**
   * The timestamp the report was generated.
   */
  public ClusterDTOBuilder setGenerated(final Date generated) {
    this.generated = generated;
    return this;
  }

  /**
   * The collection of nodes that are part of the cluster.
   */
  public Collection<NodeDTO> getNodes() {
    return nodes;
  }

  /**
   * The collection of nodes that are part of the cluster.
   */
  public ClusterDTOBuilder setNodes(final Collection<NodeDTO> nodes) {
    this.nodes = nodes;
    return this;
  }

  public ClusterDTO build() {
    final ClusterDTO clusterDTO = new ClusterDTO();
    clusterDTO.setGenerated(generated);
    clusterDTO.setNodes(nodes);
    return clusterDTO;
  }

  public static ClusterDTOBuilder of(final ClusterDTO clusterDTO) {
    final ClusterDTOBuilder clusterDTOBuilder = new ClusterDTOBuilder();
    clusterDTOBuilder.setGenerated(clusterDTO.getGenerated());
    clusterDTOBuilder.setNodes(clusterDTO.getNodes());
    return clusterDTOBuilder;
  }
}
