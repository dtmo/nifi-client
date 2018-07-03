package com.tibtech.nifi.couchbase;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class CouchbaseMapCacheClient {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.couchbase.CouchbaseMapCacheClient";

  /**
   * A Couchbase Cluster Controller Service which manages connections to a Couchbase cluster.
   */
  public static final String CLUSTER_CONTROLLER_SERVICE_PROPERTY = "cluster-controller-service";

  /**
   * The name of bucket to access.
   */
  public static final String BUCKET_NAME_PROPERTY = "bucket-name";

  private final Map<String, String> properties;

  public CouchbaseMapCacheClient() {
    this.properties = new HashMap<>();
  }

  public CouchbaseMapCacheClient(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * A Couchbase Cluster Controller Service which manages connections to a Couchbase cluster.
   */
  public final String getClusterControllerService() {
    return properties.get(CLUSTER_CONTROLLER_SERVICE_PROPERTY);
  }

  /**
   * A Couchbase Cluster Controller Service which manages connections to a Couchbase cluster.
   */
  public final CouchbaseMapCacheClient setClusterControllerService(
      final String clusterControllerService) {
    properties.put(CLUSTER_CONTROLLER_SERVICE_PROPERTY, clusterControllerService);
    return this;
  }

  /**
   * A Couchbase Cluster Controller Service which manages connections to a Couchbase cluster.
   */
  public final CouchbaseMapCacheClient removeClusterControllerService() {
    properties.remove(CLUSTER_CONTROLLER_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The name of bucket to access.
   */
  public final String getBucketName() {
    return properties.get(BUCKET_NAME_PROPERTY);
  }

  /**
   * The name of bucket to access.
   */
  public final CouchbaseMapCacheClient setBucketName(final String bucketName) {
    properties.put(BUCKET_NAME_PROPERTY, bucketName);
    return this;
  }

  /**
   * The name of bucket to access.
   */
  public final CouchbaseMapCacheClient removeBucketName() {
    properties.remove(BUCKET_NAME_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final CouchbaseMapCacheClient setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final CouchbaseMapCacheClient removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<CouchbaseMapCacheClient, CouchbaseMapCacheClient> configurator) {
    return configurator.apply(new CouchbaseMapCacheClient()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CouchbaseMapCacheClient.class) final Closure<CouchbaseMapCacheClient> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.couchbase.CouchbaseMapCacheClient> code = closure.rehydrate(c, com.tibtech.nifi.couchbase.CouchbaseMapCacheClient.class, com.tibtech.nifi.couchbase.CouchbaseMapCacheClient.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<CouchbaseMapCacheClient, CouchbaseMapCacheClient> configurator) {
    return configurator.apply(new CouchbaseMapCacheClient(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CouchbaseMapCacheClient.class) final Closure<CouchbaseMapCacheClient> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.couchbase.CouchbaseMapCacheClient> code = closure.rehydrate(c, com.tibtech.nifi.couchbase.CouchbaseMapCacheClient.class, com.tibtech.nifi.couchbase.CouchbaseMapCacheClient.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
