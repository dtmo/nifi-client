package com.tibtech.nifi.web.api.dto;

import java.lang.String;
import java.util.Date;
import org.apache.nifi.web.api.dto.PreviousValueDTO;

public final class PreviousValueDTOBuilder {
  private String previousValue;

  private Date timestamp;

  private String userIdentity;

  /**
   * The previous value.
   */
  public String getPreviousValue() {
    return previousValue;
  }

  /**
   * The previous value.
   */
  public PreviousValueDTOBuilder setPreviousValue(final String previousValue) {
    this.previousValue = previousValue;
    return this;
  }

  /**
   * The timestamp when the value was modified.
   */
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * The timestamp when the value was modified.
   */
  public PreviousValueDTOBuilder setTimestamp(final Date timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * The user who changed the previous value.
   */
  public String getUserIdentity() {
    return userIdentity;
  }

  /**
   * The user who changed the previous value.
   */
  public PreviousValueDTOBuilder setUserIdentity(final String userIdentity) {
    this.userIdentity = userIdentity;
    return this;
  }

  public PreviousValueDTO build() {
    final PreviousValueDTO previousValueDTO = new PreviousValueDTO();
    previousValueDTO.setPreviousValue(previousValue);
    previousValueDTO.setTimestamp(timestamp);
    previousValueDTO.setUserIdentity(userIdentity);
    return previousValueDTO;
  }

  public static PreviousValueDTOBuilder of(final PreviousValueDTO previousValueDTO) {
    final PreviousValueDTOBuilder previousValueDTOBuilder = new PreviousValueDTOBuilder();
    previousValueDTOBuilder.setPreviousValue(previousValueDTO.getPreviousValue());
    previousValueDTOBuilder.setTimestamp(previousValueDTO.getTimestamp());
    previousValueDTOBuilder.setUserIdentity(previousValueDTO.getUserIdentity());
    return previousValueDTOBuilder;
  }
}
