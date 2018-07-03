package com.tibtech.nifi.web.api.dto;

import java.lang.Long;
import java.lang.String;
import org.apache.nifi.web.api.dto.BucketDTO;

public final class BucketDTOBuilder {
  private Long created;

  private String description;

  private String id;

  private String name;

  /**
   * The created timestamp of this bucket
   */
  public Long getCreated() {
    return created;
  }

  /**
   * The created timestamp of this bucket
   */
  public BucketDTOBuilder setCreated(final Long created) {
    this.created = created;
    return this;
  }

  /**
   * The bucket description
   */
  public String getDescription() {
    return description;
  }

  /**
   * The bucket description
   */
  public BucketDTOBuilder setDescription(final String description) {
    this.description = description;
    return this;
  }

  /**
   * The bucket identifier
   */
  public String getId() {
    return id;
  }

  /**
   * The bucket identifier
   */
  public BucketDTOBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  /**
   * The bucket name
   */
  public String getName() {
    return name;
  }

  /**
   * The bucket name
   */
  public BucketDTOBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  public BucketDTO build() {
    final BucketDTO bucketDTO = new BucketDTO();
    bucketDTO.setCreated(created);
    bucketDTO.setDescription(description);
    bucketDTO.setId(id);
    bucketDTO.setName(name);
    return bucketDTO;
  }

  public static BucketDTOBuilder of(final BucketDTO bucketDTO) {
    final BucketDTOBuilder bucketDTOBuilder = new BucketDTOBuilder();
    bucketDTOBuilder.setCreated(bucketDTO.getCreated());
    bucketDTOBuilder.setDescription(bucketDTO.getDescription());
    bucketDTOBuilder.setId(bucketDTO.getId());
    bucketDTOBuilder.setName(bucketDTO.getName());
    return bucketDTOBuilder;
  }
}
