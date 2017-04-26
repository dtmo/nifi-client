package com.tibtech.nifi.web.api.dto.status;

import java.lang.Integer;
import java.lang.String;
import java.util.List;
import org.apache.nifi.web.api.dto.status.NodeStatusSnapshotsDTO;
import org.apache.nifi.web.api.dto.status.StatusSnapshotDTO;

public final class NodeStatusSnapshotsDTOBuilder {
  private String address;

  private Integer apiPort;

  private String nodeId;

  private List<StatusSnapshotDTO> statusSnapshots;

  /**
   * The node's host/ip address.
   */
  public String getAddress() {
    return address;
  }

  /**
   * The node's host/ip address.
   */
  public NodeStatusSnapshotsDTOBuilder setAddress(final String address) {
    this.address = address;
    return this;
  }

  /**
   * The port the node is listening for API requests.
   */
  public Integer getApiPort() {
    return apiPort;
  }

  /**
   * The port the node is listening for API requests.
   */
  public NodeStatusSnapshotsDTOBuilder setApiPort(final Integer apiPort) {
    this.apiPort = apiPort;
    return this;
  }

  /**
   * The id of the node.
   */
  public String getNodeId() {
    return nodeId;
  }

  /**
   * The id of the node.
   */
  public NodeStatusSnapshotsDTOBuilder setNodeId(final String nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /**
   * A list of StatusSnapshotDTO objects that provide the actual metric values for the component for this node.
   */
  public List<StatusSnapshotDTO> getStatusSnapshots() {
    return statusSnapshots;
  }

  /**
   * A list of StatusSnapshotDTO objects that provide the actual metric values for the component for this node.
   */
  public NodeStatusSnapshotsDTOBuilder setStatusSnapshots(final List<StatusSnapshotDTO> statusSnapshots) {
    this.statusSnapshots = statusSnapshots;
    return this;
  }

  public NodeStatusSnapshotsDTO build() {
    final NodeStatusSnapshotsDTO nodeStatusSnapshotsDTO = new NodeStatusSnapshotsDTO();
    nodeStatusSnapshotsDTO.setAddress(address);
    nodeStatusSnapshotsDTO.setApiPort(apiPort);
    nodeStatusSnapshotsDTO.setNodeId(nodeId);
    nodeStatusSnapshotsDTO.setStatusSnapshots(statusSnapshots);
    return nodeStatusSnapshotsDTO;
  }

  public static NodeStatusSnapshotsDTOBuilder of(final NodeStatusSnapshotsDTO nodeStatusSnapshotsDTO) {
    final NodeStatusSnapshotsDTOBuilder nodeStatusSnapshotsDTOBuilder = new NodeStatusSnapshotsDTOBuilder();
    nodeStatusSnapshotsDTOBuilder.setAddress(nodeStatusSnapshotsDTO.getAddress());
    nodeStatusSnapshotsDTOBuilder.setApiPort(nodeStatusSnapshotsDTO.getApiPort());
    nodeStatusSnapshotsDTOBuilder.setNodeId(nodeStatusSnapshotsDTO.getNodeId());
    nodeStatusSnapshotsDTOBuilder.setStatusSnapshots(nodeStatusSnapshotsDTO.getStatusSnapshots());
    return nodeStatusSnapshotsDTOBuilder;
  }
}
