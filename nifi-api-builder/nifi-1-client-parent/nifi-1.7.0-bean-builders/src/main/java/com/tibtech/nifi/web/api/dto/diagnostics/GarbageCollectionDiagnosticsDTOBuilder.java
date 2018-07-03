package com.tibtech.nifi.web.api.dto.diagnostics;

import java.lang.String;
import java.util.List;
import org.apache.nifi.web.api.dto.diagnostics.GCDiagnosticsSnapshotDTO;
import org.apache.nifi.web.api.dto.diagnostics.GarbageCollectionDiagnosticsDTO;

public final class GarbageCollectionDiagnosticsDTOBuilder {
  private String memoryManagerName;

  private List<GCDiagnosticsSnapshotDTO> snapshots;

  /**
   * The name of the Memory Manager that this Garbage Collection information pertains to
   */
  public String getMemoryManagerName() {
    return memoryManagerName;
  }

  /**
   * The name of the Memory Manager that this Garbage Collection information pertains to
   */
  public GarbageCollectionDiagnosticsDTOBuilder setMemoryManagerName(final String memoryManagerName) {
    this.memoryManagerName = memoryManagerName;
    return this;
  }

  /**
   * A list of snapshots that have been taken to determine the health of the JVM's heap
   */
  public List<GCDiagnosticsSnapshotDTO> getSnapshots() {
    return snapshots;
  }

  /**
   * A list of snapshots that have been taken to determine the health of the JVM's heap
   */
  public GarbageCollectionDiagnosticsDTOBuilder setSnapshots(final List<GCDiagnosticsSnapshotDTO> snapshots) {
    this.snapshots = snapshots;
    return this;
  }

  public GarbageCollectionDiagnosticsDTO build() {
    final GarbageCollectionDiagnosticsDTO garbageCollectionDiagnosticsDTO = new GarbageCollectionDiagnosticsDTO();
    garbageCollectionDiagnosticsDTO.setMemoryManagerName(memoryManagerName);
    garbageCollectionDiagnosticsDTO.setSnapshots(snapshots);
    return garbageCollectionDiagnosticsDTO;
  }

  public static GarbageCollectionDiagnosticsDTOBuilder of(final GarbageCollectionDiagnosticsDTO garbageCollectionDiagnosticsDTO) {
    final GarbageCollectionDiagnosticsDTOBuilder garbageCollectionDiagnosticsDTOBuilder = new GarbageCollectionDiagnosticsDTOBuilder();
    garbageCollectionDiagnosticsDTOBuilder.setMemoryManagerName(garbageCollectionDiagnosticsDTO.getMemoryManagerName());
    garbageCollectionDiagnosticsDTOBuilder.setSnapshots(garbageCollectionDiagnosticsDTO.getSnapshots());
    return garbageCollectionDiagnosticsDTOBuilder;
  }
}
