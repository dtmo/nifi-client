package com.tibtech.nifi.couchbase;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class CouchbaseRecordLookupService {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.couchbase.CouchbaseRecordLookupService";

  /**
   * A Couchbase Cluster Controller Service which manages connections to a Couchbase cluster.
   */
  public static final String CLUSTER_CONTROLLER_SERVICE_PROPERTY = "cluster-controller-service";

  /**
   * The name of bucket to access.
   */
  public static final String BUCKET_NAME_PROPERTY = "bucket-name";

  /**
   * The type of contents.
   */
  public static final String DOCUMENT_TYPE_PROPERTY = "document-type";

  /**
   * The Record Reader to use for parsing fetched document from Couchbase Server.
   */
  public static final String RECORD_READER_PROPERTY = "record-reader";

  private final Map<String, String> properties;

  public CouchbaseRecordLookupService() {
    this.properties = new HashMap<>();
  }

  public CouchbaseRecordLookupService(final Map<String, String> properties) {
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
  public final CouchbaseRecordLookupService setClusterControllerService(
      final String clusterControllerService) {
    properties.put(CLUSTER_CONTROLLER_SERVICE_PROPERTY, clusterControllerService);
    return this;
  }

  /**
   * A Couchbase Cluster Controller Service which manages connections to a Couchbase cluster.
   */
  public final CouchbaseRecordLookupService removeClusterControllerService() {
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
  public final CouchbaseRecordLookupService setBucketName(final String bucketName) {
    properties.put(BUCKET_NAME_PROPERTY, bucketName);
    return this;
  }

  /**
   * The name of bucket to access.
   */
  public final CouchbaseRecordLookupService removeBucketName() {
    properties.remove(BUCKET_NAME_PROPERTY);
    return this;
  }

  /**
   * The type of contents.
   */
  public final String getDocumentType() {
    return properties.get(DOCUMENT_TYPE_PROPERTY);
  }

  /**
   * The type of contents.
   */
  public final CouchbaseRecordLookupService setDocumentType(final String documentType) {
    properties.put(DOCUMENT_TYPE_PROPERTY, documentType);
    return this;
  }

  /**
   * The type of contents.
   */
  public final CouchbaseRecordLookupService removeDocumentType() {
    properties.remove(DOCUMENT_TYPE_PROPERTY);
    return this;
  }

  /**
   * The Record Reader to use for parsing fetched document from Couchbase Server.
   */
  public final String getRecordReader() {
    return properties.get(RECORD_READER_PROPERTY);
  }

  /**
   * The Record Reader to use for parsing fetched document from Couchbase Server.
   */
  public final CouchbaseRecordLookupService setRecordReader(final String recordReader) {
    properties.put(RECORD_READER_PROPERTY, recordReader);
    return this;
  }

  /**
   * The Record Reader to use for parsing fetched document from Couchbase Server.
   */
  public final CouchbaseRecordLookupService removeRecordReader() {
    properties.remove(RECORD_READER_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final CouchbaseRecordLookupService setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final CouchbaseRecordLookupService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<CouchbaseRecordLookupService, CouchbaseRecordLookupService> configurator) {
    return configurator.apply(new CouchbaseRecordLookupService()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CouchbaseRecordLookupService.class) final Closure<CouchbaseRecordLookupService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.couchbase.CouchbaseRecordLookupService> code = closure.rehydrate(c, com.tibtech.nifi.couchbase.CouchbaseRecordLookupService.class, com.tibtech.nifi.couchbase.CouchbaseRecordLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<CouchbaseRecordLookupService, CouchbaseRecordLookupService> configurator) {
    return configurator.apply(new CouchbaseRecordLookupService(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CouchbaseRecordLookupService.class) final Closure<CouchbaseRecordLookupService> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.couchbase.CouchbaseRecordLookupService> code = closure.rehydrate(c, com.tibtech.nifi.couchbase.CouchbaseRecordLookupService.class, com.tibtech.nifi.couchbase.CouchbaseRecordLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
