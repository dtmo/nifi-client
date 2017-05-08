package com.tibtech.nifi.web.api.dto;

import org.apache.nifi.web.api.dto.QueueSizeDTO;

public final class QueueSizeDTOBuilder {
  private long byteCount;

  private int objectCount;

  /**
   * The size of objects in a queue.
   */
  public long getByteCount() {
    return byteCount;
  }

  /**
   * The size of objects in a queue.
   */
  public QueueSizeDTOBuilder setByteCount(final long byteCount) {
    this.byteCount = byteCount;
    return this;
  }

  /**
   * The count of objects in a queue.
   */
  public int getObjectCount() {
    return objectCount;
  }

  /**
   * The count of objects in a queue.
   */
  public QueueSizeDTOBuilder setObjectCount(final int objectCount) {
    this.objectCount = objectCount;
    return this;
  }

  public QueueSizeDTO build() {
    final QueueSizeDTO queueSizeDTO = new QueueSizeDTO();
    queueSizeDTO.setByteCount(byteCount);
    queueSizeDTO.setObjectCount(objectCount);
    return queueSizeDTO;
  }

  public static QueueSizeDTOBuilder of(final QueueSizeDTO queueSizeDTO) {
    final QueueSizeDTOBuilder queueSizeDTOBuilder = new QueueSizeDTOBuilder();
    queueSizeDTOBuilder.setByteCount(queueSizeDTO.getByteCount());
    queueSizeDTOBuilder.setObjectCount(queueSizeDTO.getObjectCount());
    return queueSizeDTOBuilder;
  }
}
