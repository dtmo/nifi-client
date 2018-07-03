package com.tibtech.nifi.web.api.entity;

import java.lang.String;
import org.apache.nifi.web.api.dto.BucketDTO;
import org.apache.nifi.web.api.dto.PermissionsDTO;
import org.apache.nifi.web.api.entity.BucketEntity;

public final class BucketEntityBuilder extends AbstractEntityBuilder<BucketEntityBuilder> {
  private BucketDTO bucket;

  private String id;

  private PermissionsDTO permissions;

  public BucketDTO getBucket() {
    return bucket;
  }

  public BucketEntityBuilder setBucket(final BucketDTO bucket) {
    this.bucket = bucket;
    return this;
  }

  public String getId() {
    return id;
  }

  public BucketEntityBuilder setId(final String id) {
    this.id = id;
    return this;
  }

  public PermissionsDTO getPermissions() {
    return permissions;
  }

  public BucketEntityBuilder setPermissions(final PermissionsDTO permissions) {
    this.permissions = permissions;
    return this;
  }

  public BucketEntity build() {
    final BucketEntity bucketEntity = new BucketEntity();
    super.setPropertyValues(bucketEntity);
    bucketEntity.setBucket(bucket);
    bucketEntity.setId(id);
    bucketEntity.setPermissions(permissions);
    return bucketEntity;
  }

  public static BucketEntityBuilder of(final BucketEntity bucketEntity) {
    final BucketEntityBuilder bucketEntityBuilder = new BucketEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(bucketEntityBuilder, bucketEntity);
    bucketEntityBuilder.setBucket(bucketEntity.getBucket());
    bucketEntityBuilder.setId(bucketEntity.getId());
    bucketEntityBuilder.setPermissions(bucketEntity.getPermissions());
    return bucketEntityBuilder;
  }
}
