package com.tibtech.nifi.web.api.dto.diagnostics;

import java.lang.Long;
import java.util.Date;
import org.apache.nifi.web.api.dto.diagnostics.GCDiagnosticsSnapshotDTO;

public final class GCDiagnosticsSnapshotDTOBuilder {
  private Long collectionCount;

  private Long collectionMillis;

  private Date timestamp;

  /**
   * The number of times that Garbage Collection has occurred
   */
  public Long getCollectionCount() {
    return collectionCount;
  }

  /**
   * The number of times that Garbage Collection has occurred
   */
  public GCDiagnosticsSnapshotDTOBuilder setCollectionCount(final Long collectionCount) {
    this.collectionCount = collectionCount;
    return this;
  }

  /**
   * The number of milliseconds that the Garbage Collector spent performing Garbage Collection duties
   */
  public Long getCollectionMillis() {
    return collectionMillis;
  }

  /**
   * The number of milliseconds that the Garbage Collector spent performing Garbage Collection duties
   */
  public GCDiagnosticsSnapshotDTOBuilder setCollectionMillis(final Long collectionMillis) {
    this.collectionMillis = collectionMillis;
    return this;
  }

  /**
   * The timestamp of when the Snapshot was taken
   */
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * The timestamp of when the Snapshot was taken
   */
  public GCDiagnosticsSnapshotDTOBuilder setTimestamp(final Date timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  public GCDiagnosticsSnapshotDTO build() {
    final GCDiagnosticsSnapshotDTO gCDiagnosticsSnapshotDTO = new GCDiagnosticsSnapshotDTO();
    gCDiagnosticsSnapshotDTO.setCollectionCount(collectionCount);
    gCDiagnosticsSnapshotDTO.setCollectionMillis(collectionMillis);
    gCDiagnosticsSnapshotDTO.setTimestamp(timestamp);
    return gCDiagnosticsSnapshotDTO;
  }

  public static GCDiagnosticsSnapshotDTOBuilder of(
      final GCDiagnosticsSnapshotDTO gCDiagnosticsSnapshotDTO) {
    final GCDiagnosticsSnapshotDTOBuilder gCDiagnosticsSnapshotDTOBuilder = new GCDiagnosticsSnapshotDTOBuilder();
    gCDiagnosticsSnapshotDTOBuilder.setCollectionCount(gCDiagnosticsSnapshotDTO.getCollectionCount());
    gCDiagnosticsSnapshotDTOBuilder.setCollectionMillis(gCDiagnosticsSnapshotDTO.getCollectionMillis());
    gCDiagnosticsSnapshotDTOBuilder.setTimestamp(gCDiagnosticsSnapshotDTO.getTimestamp());
    return gCDiagnosticsSnapshotDTOBuilder;
  }
}
