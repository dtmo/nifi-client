package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import org.apache.nifi.web.api.dto.AccessStatusDTO;

public final class AccessStatusDTOBuilder {
  private String identity;

  private String message;

  private String status;

  /**
   * The user identity.
   */
  public String getIdentity() {
    return identity;
  }

  /**
   * The user identity.
   */
  public AccessStatusDTOBuilder setIdentity(final String identity) {
    this.identity = identity;
    return this;
  }

  /**
   * Additional details about the user access status.
   */
  public String getMessage() {
    return message;
  }

  /**
   * Additional details about the user access status.
   */
  public AccessStatusDTOBuilder setMessage(final String message) {
    this.message = message;
    return this;
  }

  /**
   * The user access status.
   */
  public String getStatus() {
    return status;
  }

  /**
   * The user access status.
   */
  public AccessStatusDTOBuilder setStatus(final String status) {
    this.status = status;
    return this;
  }

  public AccessStatusDTO build() {
    final AccessStatusDTO accessStatusDTO = new AccessStatusDTO();
    accessStatusDTO.setIdentity(identity);
    accessStatusDTO.setMessage(message);
    accessStatusDTO.setStatus(status);
    return accessStatusDTO;
  }

  public static AccessStatusDTOBuilder of(final AccessStatusDTO accessStatusDTO) {
    final AccessStatusDTOBuilder accessStatusDTOBuilder = new AccessStatusDTOBuilder();
    accessStatusDTOBuilder.setIdentity(accessStatusDTO.getIdentity());
    accessStatusDTOBuilder.setMessage(accessStatusDTO.getMessage());
    accessStatusDTOBuilder.setStatus(accessStatusDTO.getStatus());
    return accessStatusDTOBuilder;
  }
}
