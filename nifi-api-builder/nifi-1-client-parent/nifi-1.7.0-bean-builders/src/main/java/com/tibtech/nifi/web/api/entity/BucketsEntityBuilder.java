package com.tibtech.nifi.web.api.entity;

import java.util.Set;
import org.apache.nifi.web.api.entity.BucketEntity;
import org.apache.nifi.web.api.entity.BucketsEntity;

public final class BucketsEntityBuilder extends AbstractEntityBuilder<BucketsEntityBuilder> {
  private Set<BucketEntity> buckets;

  public Set<BucketEntity> getBuckets() {
    return buckets;
  }

  public BucketsEntityBuilder setBuckets(final Set<BucketEntity> buckets) {
    this.buckets = buckets;
    return this;
  }

  public BucketsEntity build() {
    final BucketsEntity bucketsEntity = new BucketsEntity();
    super.setPropertyValues(bucketsEntity);
    bucketsEntity.setBuckets(buckets);
    return bucketsEntity;
  }

  public static BucketsEntityBuilder of(final BucketsEntity bucketsEntity) {
    final BucketsEntityBuilder bucketsEntityBuilder = new BucketsEntityBuilder();
    AbstractEntityBuilder.setBuilderValues(bucketsEntityBuilder, bucketsEntity);
    bucketsEntityBuilder.setBuckets(bucketsEntity.getBuckets());
    return bucketsEntityBuilder;
  }
}
