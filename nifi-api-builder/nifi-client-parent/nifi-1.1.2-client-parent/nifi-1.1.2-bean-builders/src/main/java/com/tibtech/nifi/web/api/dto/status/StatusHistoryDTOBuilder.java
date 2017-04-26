package com.tibtech.nifi.web.api.dto.status;

import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import org.apache.nifi.web.api.dto.status.NodeStatusSnapshotsDTO;
import org.apache.nifi.web.api.dto.status.StatusDescriptorDTO;
import org.apache.nifi.web.api.dto.status.StatusHistoryDTO;
import org.apache.nifi.web.api.dto.status.StatusSnapshotDTO;

public final class StatusHistoryDTOBuilder {
  private List<StatusSnapshotDTO> aggregateSnapshots;

  private LinkedHashMap<String, String> componentDetails;

  private List<StatusDescriptorDTO> fieldDescriptors;

  private Date generated;

  private List<NodeStatusSnapshotsDTO> nodeSnapshots;

  /**
   * A list of StatusSnapshotDTO objects that provide the actual metric values for the component. If the NiFi instance is clustered, this will represent the aggregate status across all nodes. If the NiFi instance is not clustered, this will represent the status of the entire NiFi instance.
   */
  public List<StatusSnapshotDTO> getAggregateSnapshots() {
    return aggregateSnapshots;
  }

  /**
   * A list of StatusSnapshotDTO objects that provide the actual metric values for the component. If the NiFi instance is clustered, this will represent the aggregate status across all nodes. If the NiFi instance is not clustered, this will represent the status of the entire NiFi instance.
   */
  public StatusHistoryDTOBuilder setAggregateSnapshots(final List<StatusSnapshotDTO> aggregateSnapshots) {
    this.aggregateSnapshots = aggregateSnapshots;
    return this;
  }

  /**
   * A Map of key/value pairs that describe the component that the status history belongs to
   */
  public LinkedHashMap<String, String> getComponentDetails() {
    return componentDetails;
  }

  /**
   * A Map of key/value pairs that describe the component that the status history belongs to
   */
  public StatusHistoryDTOBuilder setComponentDetails(final LinkedHashMap<String, String> componentDetails) {
    this.componentDetails = componentDetails;
    return this;
  }

  /**
   * The Descriptors that provide information on each of the metrics provided in the status history
   */
  public List<StatusDescriptorDTO> getFieldDescriptors() {
    return fieldDescriptors;
  }

  /**
   * The Descriptors that provide information on each of the metrics provided in the status history
   */
  public StatusHistoryDTOBuilder setFieldDescriptors(final List<StatusDescriptorDTO> fieldDescriptors) {
    this.fieldDescriptors = fieldDescriptors;
    return this;
  }

  /**
   * When the status history was generated.
   */
  public Date getGenerated() {
    return generated;
  }

  /**
   * When the status history was generated.
   */
  public StatusHistoryDTOBuilder setGenerated(final Date generated) {
    this.generated = generated;
    return this;
  }

  /**
   * The NodeStatusSnapshotsDTO objects that provide the actual metric values for the component, for each node. If the NiFi instance is not clustered, this value will be null.
   */
  public List<NodeStatusSnapshotsDTO> getNodeSnapshots() {
    return nodeSnapshots;
  }

  /**
   * The NodeStatusSnapshotsDTO objects that provide the actual metric values for the component, for each node. If the NiFi instance is not clustered, this value will be null.
   */
  public StatusHistoryDTOBuilder setNodeSnapshots(final List<NodeStatusSnapshotsDTO> nodeSnapshots) {
    this.nodeSnapshots = nodeSnapshots;
    return this;
  }

  public StatusHistoryDTO build() {
    final StatusHistoryDTO statusHistoryDTO = new StatusHistoryDTO();
    statusHistoryDTO.setAggregateSnapshots(aggregateSnapshots);
    statusHistoryDTO.setComponentDetails(componentDetails);
    statusHistoryDTO.setFieldDescriptors(fieldDescriptors);
    statusHistoryDTO.setGenerated(generated);
    statusHistoryDTO.setNodeSnapshots(nodeSnapshots);
    return statusHistoryDTO;
  }

  public static StatusHistoryDTOBuilder of(final StatusHistoryDTO statusHistoryDTO) {
    final StatusHistoryDTOBuilder statusHistoryDTOBuilder = new StatusHistoryDTOBuilder();
    statusHistoryDTOBuilder.setAggregateSnapshots(statusHistoryDTO.getAggregateSnapshots());
    statusHistoryDTOBuilder.setComponentDetails(statusHistoryDTO.getComponentDetails());
    statusHistoryDTOBuilder.setFieldDescriptors(statusHistoryDTO.getFieldDescriptors());
    statusHistoryDTOBuilder.setGenerated(statusHistoryDTO.getGenerated());
    statusHistoryDTOBuilder.setNodeSnapshots(statusHistoryDTO.getNodeSnapshots());
    return statusHistoryDTOBuilder;
  }
}
