package com.tibtech.nifi.processors.couchbase;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutCouchbaseKey {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.couchbase.PutCouchbaseKey";

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
   * A static, fixed Couchbase document id, or an expression to construct the Couchbase document id.
   */
  public static final String DOCUMENT_ID_PROPERTY = "document-id";

  /**
   * Durability constraint about disk persistence.
   */
  public static final String PERSIST_TO_PROPERTY = "persist-to";

  /**
   * Durability constraint about replication.
   */
  public static final String REPLICATE_TO_PROPERTY = "replicate-to";

  private final Map<String, String> properties;

  public PutCouchbaseKey() {
    this.properties = new HashMap<>();
  }

  public PutCouchbaseKey(final Map<String, String> properties) {
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
  public final PutCouchbaseKey setClusterControllerService(final String clusterControllerService) {
    properties.put(CLUSTER_CONTROLLER_SERVICE_PROPERTY, clusterControllerService);
    return this;
  }

  /**
   * A Couchbase Cluster Controller Service which manages connections to a Couchbase cluster.
   */
  public final PutCouchbaseKey removeClusterControllerService() {
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
  public final PutCouchbaseKey setBucketName(final String bucketName) {
    properties.put(BUCKET_NAME_PROPERTY, bucketName);
    return this;
  }

  /**
   * The name of bucket to access.
   */
  public final PutCouchbaseKey removeBucketName() {
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
  public final PutCouchbaseKey setDocumentType(final String documentType) {
    properties.put(DOCUMENT_TYPE_PROPERTY, documentType);
    return this;
  }

  /**
   * The type of contents.
   */
  public final PutCouchbaseKey removeDocumentType() {
    properties.remove(DOCUMENT_TYPE_PROPERTY);
    return this;
  }

  /**
   * A static, fixed Couchbase document id, or an expression to construct the Couchbase document id.
   */
  public final String getDocumentId() {
    return properties.get(DOCUMENT_ID_PROPERTY);
  }

  /**
   * A static, fixed Couchbase document id, or an expression to construct the Couchbase document id.
   */
  public final PutCouchbaseKey setDocumentId(final String documentId) {
    properties.put(DOCUMENT_ID_PROPERTY, documentId);
    return this;
  }

  /**
   * A static, fixed Couchbase document id, or an expression to construct the Couchbase document id.
   */
  public final PutCouchbaseKey removeDocumentId() {
    properties.remove(DOCUMENT_ID_PROPERTY);
    return this;
  }

  /**
   * Durability constraint about disk persistence.
   */
  public final String getPersistTo() {
    return properties.get(PERSIST_TO_PROPERTY);
  }

  /**
   * Durability constraint about disk persistence.
   */
  public final PutCouchbaseKey setPersistTo(final String persistTo) {
    properties.put(PERSIST_TO_PROPERTY, persistTo);
    return this;
  }

  /**
   * Durability constraint about disk persistence.
   */
  public final PutCouchbaseKey removePersistTo() {
    properties.remove(PERSIST_TO_PROPERTY);
    return this;
  }

  /**
   * Durability constraint about replication.
   */
  public final String getReplicateTo() {
    return properties.get(REPLICATE_TO_PROPERTY);
  }

  /**
   * Durability constraint about replication.
   */
  public final PutCouchbaseKey setReplicateTo(final String replicateTo) {
    properties.put(REPLICATE_TO_PROPERTY, replicateTo);
    return this;
  }

  /**
   * Durability constraint about replication.
   */
  public final PutCouchbaseKey removeReplicateTo() {
    properties.remove(REPLICATE_TO_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutCouchbaseKey setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutCouchbaseKey removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<PutCouchbaseKey, PutCouchbaseKey> configurator) {
    return configurator.apply(new PutCouchbaseKey()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutCouchbaseKey.class) final Closure<PutCouchbaseKey> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.couchbase.PutCouchbaseKey> code = closure.rehydrate(c, com.tibtech.nifi.processors.couchbase.PutCouchbaseKey.class, com.tibtech.nifi.processors.couchbase.PutCouchbaseKey.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutCouchbaseKey, PutCouchbaseKey> configurator) {
    return configurator.apply(new PutCouchbaseKey(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutCouchbaseKey.class) final Closure<PutCouchbaseKey> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.couchbase.PutCouchbaseKey> code = closure.rehydrate(c, com.tibtech.nifi.processors.couchbase.PutCouchbaseKey.class, com.tibtech.nifi.processors.couchbase.PutCouchbaseKey.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
