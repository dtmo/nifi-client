package com.tibtech.nifi.web.api.dto;

import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.apache.nifi.web.api.dto.NodeDTO;
import org.apache.nifi.web.api.dto.NodeEventDTO;

public final class NodeDTOBuilder {
  private Integer activeThreadCount;

  private String address;

  private Integer apiPort;

  private Date connectionRequested;

  private List<NodeEventDTO> events;

  private Date heartbeat;

  private String nodeId;

  private Date nodeStartTime;

  private String queued;

  private Set<String> roles;

  private String status;

  /**
   * The active threads for the NiFi on the node.
   */
  public Integer getActiveThreadCount() {
    return activeThreadCount;
  }

  /**
   * The active threads for the NiFi on the node.
   */
  public NodeDTOBuilder setActiveThreadCount(final Integer activeThreadCount) {
    this.activeThreadCount = activeThreadCount;
    return this;
  }

  /**
   * The node's host/ip address.
   */
  public String getAddress() {
    return address;
  }

  /**
   * The node's host/ip address.
   */
  public NodeDTOBuilder setAddress(final String address) {
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
  public NodeDTOBuilder setApiPort(final Integer apiPort) {
    this.apiPort = apiPort;
    return this;
  }

  /**
   * The time of the node's last connection request.
   */
  public Date getConnectionRequested() {
    return connectionRequested;
  }

  /**
   * The time of the node's last connection request.
   */
  public NodeDTOBuilder setConnectionRequested(final Date connectionRequested) {
    this.connectionRequested = connectionRequested;
    return this;
  }

  /**
   * The node's events.
   */
  public List<NodeEventDTO> getEvents() {
    return events;
  }

  /**
   * The node's events.
   */
  public NodeDTOBuilder setEvents(final List<NodeEventDTO> events) {
    this.events = events;
    return this;
  }

  /**
   * the time of the nodes's last heartbeat.
   */
  public Date getHeartbeat() {
    return heartbeat;
  }

  /**
   * the time of the nodes's last heartbeat.
   */
  public NodeDTOBuilder setHeartbeat(final Date heartbeat) {
    this.heartbeat = heartbeat;
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
  public NodeDTOBuilder setNodeId(final String nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /**
   * The time at which this Node was last refreshed.
   */
  public Date getNodeStartTime() {
    return nodeStartTime;
  }

  /**
   * The time at which this Node was last refreshed.
   */
  public NodeDTOBuilder setNodeStartTime(final Date nodeStartTime) {
    this.nodeStartTime = nodeStartTime;
    return this;
  }

  /**
   * The queue the NiFi on the node.
   */
  public String getQueued() {
    return queued;
  }

  /**
   * The queue the NiFi on the node.
   */
  public NodeDTOBuilder setQueued(final String queued) {
    this.queued = queued;
    return this;
  }

  /**
   * The roles of this node.
   */
  public Set<String> getRoles() {
    return roles;
  }

  /**
   * The roles of this node.
   */
  public NodeDTOBuilder setRoles(final Set<String> roles) {
    this.roles = roles;
    return this;
  }

  /**
   * The node's status.
   */
  public String getStatus() {
    return status;
  }

  /**
   * The node's status.
   */
  public NodeDTOBuilder setStatus(final String status) {
    this.status = status;
    return this;
  }

  public NodeDTO build() {
    final NodeDTO nodeDTO = new NodeDTO();
    nodeDTO.setActiveThreadCount(activeThreadCount);
    nodeDTO.setAddress(address);
    nodeDTO.setApiPort(apiPort);
    nodeDTO.setConnectionRequested(connectionRequested);
    nodeDTO.setEvents(events);
    nodeDTO.setHeartbeat(heartbeat);
    nodeDTO.setNodeId(nodeId);
    nodeDTO.setNodeStartTime(nodeStartTime);
    nodeDTO.setQueued(queued);
    nodeDTO.setRoles(roles);
    nodeDTO.setStatus(status);
    return nodeDTO;
  }

  public static NodeDTOBuilder of(final NodeDTO nodeDTO) {
    final NodeDTOBuilder nodeDTOBuilder = new NodeDTOBuilder();
    nodeDTOBuilder.setActiveThreadCount(nodeDTO.getActiveThreadCount());
    nodeDTOBuilder.setAddress(nodeDTO.getAddress());
    nodeDTOBuilder.setApiPort(nodeDTO.getApiPort());
    nodeDTOBuilder.setConnectionRequested(nodeDTO.getConnectionRequested());
    nodeDTOBuilder.setEvents(nodeDTO.getEvents());
    nodeDTOBuilder.setHeartbeat(nodeDTO.getHeartbeat());
    nodeDTOBuilder.setNodeId(nodeDTO.getNodeId());
    nodeDTOBuilder.setNodeStartTime(nodeDTO.getNodeStartTime());
    nodeDTOBuilder.setQueued(nodeDTO.getQueued());
    nodeDTOBuilder.setRoles(nodeDTO.getRoles());
    nodeDTOBuilder.setStatus(nodeDTO.getStatus());
    return nodeDTOBuilder;
  }
}
