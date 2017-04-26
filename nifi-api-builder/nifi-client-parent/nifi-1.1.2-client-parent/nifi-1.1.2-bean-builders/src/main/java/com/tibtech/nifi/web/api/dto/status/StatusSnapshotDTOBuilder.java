package com.tibtech.nifi.web.api.dto.status;

import java.lang.Long;
import java.lang.String;
import java.util.Date;
import java.util.Map;
import org.apache.nifi.web.api.dto.status.StatusSnapshotDTO;

public final class StatusSnapshotDTOBuilder {
  private Map<String, Long> statusMetrics;

  private Date timestamp;

  /**
   * The status metrics.
   */
  public Map<String, Long> getStatusMetrics() {
    return statusMetrics;
  }

  /**
   * The status metrics.
   */
  public StatusSnapshotDTOBuilder setStatusMetrics(final Map<String, Long> statusMetrics) {
    this.statusMetrics = statusMetrics;
    return this;
  }

  /**
   * The timestamp of the snapshot.
   */
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * The timestamp of the snapshot.
   */
  public StatusSnapshotDTOBuilder setTimestamp(final Date timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  public StatusSnapshotDTO build() {
    final StatusSnapshotDTO statusSnapshotDTO = new StatusSnapshotDTO();
    statusSnapshotDTO.setStatusMetrics(statusMetrics);
    statusSnapshotDTO.setTimestamp(timestamp);
    return statusSnapshotDTO;
  }

  public static StatusSnapshotDTOBuilder of(final StatusSnapshotDTO statusSnapshotDTO) {
    final StatusSnapshotDTOBuilder statusSnapshotDTOBuilder = new StatusSnapshotDTOBuilder();
    statusSnapshotDTOBuilder.setStatusMetrics(statusSnapshotDTO.getStatusMetrics());
    statusSnapshotDTOBuilder.setTimestamp(statusSnapshotDTO.getTimestamp());
    return statusSnapshotDTOBuilder;
  }
}
