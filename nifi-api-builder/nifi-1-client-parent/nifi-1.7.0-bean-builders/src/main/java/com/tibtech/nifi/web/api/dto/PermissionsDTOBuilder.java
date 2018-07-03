package com.tibtech.nifi.web.api.dto;

import org.apache.nifi.web.api.dto.PermissionsDTO;

public final class PermissionsDTOBuilder {
  private boolean canRead;

  private boolean canWrite;

  /**
   * Indicates whether the user can read a given resource.
   */
  public boolean getCanRead() {
    return canRead;
  }

  /**
   * Indicates whether the user can read a given resource.
   */
  public PermissionsDTOBuilder setCanRead(final boolean canRead) {
    this.canRead = canRead;
    return this;
  }

  /**
   * Indicates whether the user can write a given resource.
   */
  public boolean getCanWrite() {
    return canWrite;
  }

  /**
   * Indicates whether the user can write a given resource.
   */
  public PermissionsDTOBuilder setCanWrite(final boolean canWrite) {
    this.canWrite = canWrite;
    return this;
  }

  public PermissionsDTO build() {
    final PermissionsDTO permissionsDTO = new PermissionsDTO();
    permissionsDTO.setCanRead(canRead);
    permissionsDTO.setCanWrite(canWrite);
    return permissionsDTO;
  }

  public static PermissionsDTOBuilder of(final PermissionsDTO permissionsDTO) {
    final PermissionsDTOBuilder permissionsDTOBuilder = new PermissionsDTOBuilder();
    permissionsDTOBuilder.setCanRead(permissionsDTO.getCanRead());
    permissionsDTOBuilder.setCanWrite(permissionsDTO.getCanWrite());
    return permissionsDTOBuilder;
  }
}
