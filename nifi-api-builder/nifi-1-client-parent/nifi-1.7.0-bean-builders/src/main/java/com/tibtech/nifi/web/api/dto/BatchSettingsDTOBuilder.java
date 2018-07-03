package com.tibtech.nifi.web.api.dto;

import java.lang.Integer;
import java.lang.String;
import org.apache.nifi.web.api.dto.BatchSettingsDTO;

public final class BatchSettingsDTOBuilder {
  private Integer count;

  private String duration;

  private String size;

  /**
   * Preferred number of flow files to include in a transaction.
   */
  public Integer getCount() {
    return count;
  }

  /**
   * Preferred number of flow files to include in a transaction.
   */
  public BatchSettingsDTOBuilder setCount(final Integer count) {
    this.count = count;
    return this;
  }

  /**
   * Preferred amount of time that a transaction should span.
   */
  public String getDuration() {
    return duration;
  }

  /**
   * Preferred amount of time that a transaction should span.
   */
  public BatchSettingsDTOBuilder setDuration(final String duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Preferred number of bytes to include in a transaction.
   */
  public String getSize() {
    return size;
  }

  /**
   * Preferred number of bytes to include in a transaction.
   */
  public BatchSettingsDTOBuilder setSize(final String size) {
    this.size = size;
    return this;
  }

  public BatchSettingsDTO build() {
    final BatchSettingsDTO batchSettingsDTO = new BatchSettingsDTO();
    batchSettingsDTO.setCount(count);
    batchSettingsDTO.setDuration(duration);
    batchSettingsDTO.setSize(size);
    return batchSettingsDTO;
  }

  public static BatchSettingsDTOBuilder of(final BatchSettingsDTO batchSettingsDTO) {
    final BatchSettingsDTOBuilder batchSettingsDTOBuilder = new BatchSettingsDTOBuilder();
    batchSettingsDTOBuilder.setCount(batchSettingsDTO.getCount());
    batchSettingsDTOBuilder.setDuration(batchSettingsDTO.getDuration());
    batchSettingsDTOBuilder.setSize(batchSettingsDTO.getSize());
    return batchSettingsDTOBuilder;
  }
}
