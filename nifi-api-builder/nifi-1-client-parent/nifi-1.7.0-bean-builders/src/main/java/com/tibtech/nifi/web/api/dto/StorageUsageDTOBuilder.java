package com.tibtech.nifi.web.api.dto;

import java.lang.Long;
import java.lang.String;
import org.apache.nifi.web.api.dto.SystemDiagnosticsSnapshotDTO;

public final class StorageUsageDTOBuilder {
  private String freeSpace;

  private Long freeSpaceBytes;

  private String identifier;

  private String totalSpace;

  private Long totalSpaceBytes;

  private String usedSpace;

  private Long usedSpaceBytes;

  private String utilization;

  /**
   * Amount of free space.
   */
  public String getFreeSpace() {
    return freeSpace;
  }

  /**
   * Amount of free space.
   */
  public StorageUsageDTOBuilder setFreeSpace(final String freeSpace) {
    this.freeSpace = freeSpace;
    return this;
  }

  /**
   * The number of bytes of free space.
   */
  public Long getFreeSpaceBytes() {
    return freeSpaceBytes;
  }

  /**
   * The number of bytes of free space.
   */
  public StorageUsageDTOBuilder setFreeSpaceBytes(final Long freeSpaceBytes) {
    this.freeSpaceBytes = freeSpaceBytes;
    return this;
  }

  /**
   * The identifier of this storage location. The identifier will correspond to the identifier keyed in the storage configuration.
   */
  public String getIdentifier() {
    return identifier;
  }

  /**
   * The identifier of this storage location. The identifier will correspond to the identifier keyed in the storage configuration.
   */
  public StorageUsageDTOBuilder setIdentifier(final String identifier) {
    this.identifier = identifier;
    return this;
  }

  /**
   * Amount of total space.
   */
  public String getTotalSpace() {
    return totalSpace;
  }

  /**
   * Amount of total space.
   */
  public StorageUsageDTOBuilder setTotalSpace(final String totalSpace) {
    this.totalSpace = totalSpace;
    return this;
  }

  /**
   * The number of bytes of total space.
   */
  public Long getTotalSpaceBytes() {
    return totalSpaceBytes;
  }

  /**
   * The number of bytes of total space.
   */
  public StorageUsageDTOBuilder setTotalSpaceBytes(final Long totalSpaceBytes) {
    this.totalSpaceBytes = totalSpaceBytes;
    return this;
  }

  /**
   * Amount of used space.
   */
  public String getUsedSpace() {
    return usedSpace;
  }

  /**
   * Amount of used space.
   */
  public StorageUsageDTOBuilder setUsedSpace(final String usedSpace) {
    this.usedSpace = usedSpace;
    return this;
  }

  /**
   * The number of bytes of used space.
   */
  public Long getUsedSpaceBytes() {
    return usedSpaceBytes;
  }

  /**
   * The number of bytes of used space.
   */
  public StorageUsageDTOBuilder setUsedSpaceBytes(final Long usedSpaceBytes) {
    this.usedSpaceBytes = usedSpaceBytes;
    return this;
  }

  /**
   * Utilization of this storage location.
   */
  public String getUtilization() {
    return utilization;
  }

  /**
   * Utilization of this storage location.
   */
  public StorageUsageDTOBuilder setUtilization(final String utilization) {
    this.utilization = utilization;
    return this;
  }

  public SystemDiagnosticsSnapshotDTO.StorageUsageDTO build() {
    final SystemDiagnosticsSnapshotDTO.StorageUsageDTO storageUsageDTO = new SystemDiagnosticsSnapshotDTO.StorageUsageDTO();
    storageUsageDTO.setFreeSpace(freeSpace);
    storageUsageDTO.setFreeSpaceBytes(freeSpaceBytes);
    storageUsageDTO.setIdentifier(identifier);
    storageUsageDTO.setTotalSpace(totalSpace);
    storageUsageDTO.setTotalSpaceBytes(totalSpaceBytes);
    storageUsageDTO.setUsedSpace(usedSpace);
    storageUsageDTO.setUsedSpaceBytes(usedSpaceBytes);
    storageUsageDTO.setUtilization(utilization);
    return storageUsageDTO;
  }

  public static StorageUsageDTOBuilder of(
      final SystemDiagnosticsSnapshotDTO.StorageUsageDTO storageUsageDTO) {
    final StorageUsageDTOBuilder storageUsageDTOBuilder = new StorageUsageDTOBuilder();
    storageUsageDTOBuilder.setFreeSpace(storageUsageDTO.getFreeSpace());
    storageUsageDTOBuilder.setFreeSpaceBytes(storageUsageDTO.getFreeSpaceBytes());
    storageUsageDTOBuilder.setIdentifier(storageUsageDTO.getIdentifier());
    storageUsageDTOBuilder.setTotalSpace(storageUsageDTO.getTotalSpace());
    storageUsageDTOBuilder.setTotalSpaceBytes(storageUsageDTO.getTotalSpaceBytes());
    storageUsageDTOBuilder.setUsedSpace(storageUsageDTO.getUsedSpace());
    storageUsageDTOBuilder.setUsedSpaceBytes(storageUsageDTO.getUsedSpaceBytes());
    storageUsageDTOBuilder.setUtilization(storageUsageDTO.getUtilization());
    return storageUsageDTOBuilder;
  }
}
