package com.tibtech.nifi.couchbase;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class CouchbaseKeyValueLookupService {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.couchbase.CouchbaseKeyValueLookupService";

  /**
   * A Couchbase Cluster Controller Service which manages connections to a Couchbase cluster.
   */
  public static final String CLUSTER_CONTROLLER_SERVICE_PROPERTY = "cluster-controller-service";

  /**
   * The name of bucket to access.
   */
  public static final String BUCKET_NAME_PROPERTY = "bucket-name";

  /**
   * The Sub-Document lookup path within the target JSON document.
   */
  public static final String LOOKUP_SUB_DOC_PATH_PROPERTY = "lookup-sub-doc-path";

  private final Map<String, String> properties;

  public CouchbaseKeyValueLookupService() {
    this.properties = new HashMap<>();
  }

  public CouchbaseKeyValueLookupService(final Map<String, String> properties) {
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
  public final CouchbaseKeyValueLookupService setClusterControllerService(
      final String clusterControllerService) {
    properties.put(CLUSTER_CONTROLLER_SERVICE_PROPERTY, clusterControllerService);
    return this;
  }

  /**
   * A Couchbase Cluster Controller Service which manages connections to a Couchbase cluster.
   */
  public final CouchbaseKeyValueLookupService removeClusterControllerService() {
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
  public final CouchbaseKeyValueLookupService setBucketName(final String bucketName) {
    properties.put(BUCKET_NAME_PROPERTY, bucketName);
    return this;
  }

  /**
   * The name of bucket to access.
   */
  public final CouchbaseKeyValueLookupService removeBucketName() {
    properties.remove(BUCKET_NAME_PROPERTY);
    return this;
  }

  /**
   * The Sub-Document lookup path within the target JSON document.
   */
  public final String getLookupSubDocPath() {
    return properties.get(LOOKUP_SUB_DOC_PATH_PROPERTY);
  }

  /**
   * The Sub-Document lookup path within the target JSON document.
   */
  public final CouchbaseKeyValueLookupService setLookupSubDocPath(final String lookupSubDocPath) {
    properties.put(LOOKUP_SUB_DOC_PATH_PROPERTY, lookupSubDocPath);
    return this;
  }

  /**
   * The Sub-Document lookup path within the target JSON document.
   */
  public final CouchbaseKeyValueLookupService removeLookupSubDocPath() {
    properties.remove(LOOKUP_SUB_DOC_PATH_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final CouchbaseKeyValueLookupService setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final CouchbaseKeyValueLookupService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<CouchbaseKeyValueLookupService, CouchbaseKeyValueLookupService> configurator) {
    return configurator.apply(new CouchbaseKeyValueLookupService()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CouchbaseKeyValueLookupService.class) final Closure<CouchbaseKeyValueLookupService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.couchbase.CouchbaseKeyValueLookupService> code = closure.rehydrate(c, com.tibtech.nifi.couchbase.CouchbaseKeyValueLookupService.class, com.tibtech.nifi.couchbase.CouchbaseKeyValueLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<CouchbaseKeyValueLookupService, CouchbaseKeyValueLookupService> configurator) {
    return configurator.apply(new CouchbaseKeyValueLookupService(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CouchbaseKeyValueLookupService.class) final Closure<CouchbaseKeyValueLookupService> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.couchbase.CouchbaseKeyValueLookupService> code = closure.rehydrate(c, com.tibtech.nifi.couchbase.CouchbaseKeyValueLookupService.class, com.tibtech.nifi.couchbase.CouchbaseKeyValueLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
