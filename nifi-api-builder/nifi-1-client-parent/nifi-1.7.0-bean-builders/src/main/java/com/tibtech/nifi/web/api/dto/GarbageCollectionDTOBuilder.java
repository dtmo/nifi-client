package com.tibtech.nifi.web.api.dto;

import java.lang.Long;
import java.lang.String;
import org.apache.nifi.web.api.dto.SystemDiagnosticsSnapshotDTO;

public final class GarbageCollectionDTOBuilder {
  private long collectionCount;

  private Long collectionMillis;

  private String collectionTime;

  private String name;

  /**
   * The number of times garbage collection has run.
   */
  public long getCollectionCount() {
    return collectionCount;
  }

  /**
   * The number of times garbage collection has run.
   */
  public GarbageCollectionDTOBuilder setCollectionCount(final long collectionCount) {
    this.collectionCount = collectionCount;
    return this;
  }

  /**
   * The total number of milliseconds spent garbage collecting.
   */
  public Long getCollectionMillis() {
    return collectionMillis;
  }

  /**
   * The total number of milliseconds spent garbage collecting.
   */
  public GarbageCollectionDTOBuilder setCollectionMillis(final Long collectionMillis) {
    this.collectionMillis = collectionMillis;
    return this;
  }

  /**
   * The total amount of time spent garbage collecting.
   */
  public String getCollectionTime() {
    return collectionTime;
  }

  /**
   * The total amount of time spent garbage collecting.
   */
  public GarbageCollectionDTOBuilder setCollectionTime(final String collectionTime) {
    this.collectionTime = collectionTime;
    return this;
  }

  /**
   * The name of the garbage collector.
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the garbage collector.
   */
  public GarbageCollectionDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  public SystemDiagnosticsSnapshotDTO.GarbageCollectionDTO build() {
    final SystemDiagnosticsSnapshotDTO.GarbageCollectionDTO garbageCollectionDTO = new SystemDiagnosticsSnapshotDTO.GarbageCollectionDTO();
    garbageCollectionDTO.setCollectionCount(collectionCount);
    garbageCollectionDTO.setCollectionMillis(collectionMillis);
    garbageCollectionDTO.setCollectionTime(collectionTime);
    garbageCollectionDTO.setName(name);
    return garbageCollectionDTO;
  }

  public static GarbageCollectionDTOBuilder of(final SystemDiagnosticsSnapshotDTO.GarbageCollectionDTO garbageCollectionDTO) {
    final GarbageCollectionDTOBuilder garbageCollectionDTOBuilder = new GarbageCollectionDTOBuilder();
    garbageCollectionDTOBuilder.setCollectionCount(garbageCollectionDTO.getCollectionCount());
    garbageCollectionDTOBuilder.setCollectionMillis(garbageCollectionDTO.getCollectionMillis());
    garbageCollectionDTOBuilder.setCollectionTime(garbageCollectionDTO.getCollectionTime());
    garbageCollectionDTOBuilder.setName(garbageCollectionDTO.getName());
    return garbageCollectionDTOBuilder;
  }
}
