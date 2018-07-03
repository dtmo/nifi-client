package com.tibtech.nifi.web.api.dto.diagnostics;

import java.lang.Long;
import java.lang.String;
import org.apache.nifi.web.api.dto.diagnostics.RepositoryUsageDTO;

public final class RepositoryUsageDTOBuilder {
  private String fileStoreHash;

  private String freeSpace;

  private Long freeSpaceBytes;

  private String name;

  private String totalSpace;

  private Long totalSpaceBytes;

  private String utilization;

  /**
   * A SHA-256 hash of the File Store name/path that is used to store the repository's data. This information is exposed as a hash in order to avoid exposing potentially sensitive information that is not generally relevant. What is typically relevant is whether or not multiple repositories on the same node are using the same File Store, as this indicates that the repositories are competing for the resources of the backing disk/storage mechanism.
   */
  public String getFileStoreHash() {
    return fileStoreHash;
  }

  /**
   * A SHA-256 hash of the File Store name/path that is used to store the repository's data. This information is exposed as a hash in order to avoid exposing potentially sensitive information that is not generally relevant. What is typically relevant is whether or not multiple repositories on the same node are using the same File Store, as this indicates that the repositories are competing for the resources of the backing disk/storage mechanism.
   */
  public RepositoryUsageDTOBuilder setFileStoreHash(final String fileStoreHash) {
    this.fileStoreHash = fileStoreHash;
    return this;
  }

  /**
   * Amount of free space.
   */
  public String getFreeSpace() {
    return freeSpace;
  }

  /**
   * Amount of free space.
   */
  public RepositoryUsageDTOBuilder setFreeSpace(final String freeSpace) {
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
  public RepositoryUsageDTOBuilder setFreeSpaceBytes(final Long freeSpaceBytes) {
    this.freeSpaceBytes = freeSpaceBytes;
    return this;
  }

  /**
   * The name of the repository
   */
  public String getName() {
    return name;
  }

  /**
   * The name of the repository
   */
  public RepositoryUsageDTOBuilder setName(final String name) {
    this.name = name;
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
  public RepositoryUsageDTOBuilder setTotalSpace(final String totalSpace) {
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
  public RepositoryUsageDTOBuilder setTotalSpaceBytes(final Long totalSpaceBytes) {
    this.totalSpaceBytes = totalSpaceBytes;
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
  public RepositoryUsageDTOBuilder setUtilization(final String utilization) {
    this.utilization = utilization;
    return this;
  }

  public RepositoryUsageDTO build() {
    final RepositoryUsageDTO repositoryUsageDTO = new RepositoryUsageDTO();
    repositoryUsageDTO.setFileStoreHash(fileStoreHash);
    repositoryUsageDTO.setFreeSpace(freeSpace);
    repositoryUsageDTO.setFreeSpaceBytes(freeSpaceBytes);
    repositoryUsageDTO.setName(name);
    repositoryUsageDTO.setTotalSpace(totalSpace);
    repositoryUsageDTO.setTotalSpaceBytes(totalSpaceBytes);
    repositoryUsageDTO.setUtilization(utilization);
    return repositoryUsageDTO;
  }

  public static RepositoryUsageDTOBuilder of(final RepositoryUsageDTO repositoryUsageDTO) {
    final RepositoryUsageDTOBuilder repositoryUsageDTOBuilder = new RepositoryUsageDTOBuilder();
    repositoryUsageDTOBuilder.setFileStoreHash(repositoryUsageDTO.getFileStoreHash());
    repositoryUsageDTOBuilder.setFreeSpace(repositoryUsageDTO.getFreeSpace());
    repositoryUsageDTOBuilder.setFreeSpaceBytes(repositoryUsageDTO.getFreeSpaceBytes());
    repositoryUsageDTOBuilder.setName(repositoryUsageDTO.getName());
    repositoryUsageDTOBuilder.setTotalSpace(repositoryUsageDTO.getTotalSpace());
    repositoryUsageDTOBuilder.setTotalSpaceBytes(repositoryUsageDTO.getTotalSpaceBytes());
    repositoryUsageDTOBuilder.setUtilization(repositoryUsageDTO.getUtilization());
    return repositoryUsageDTOBuilder;
  }
}
