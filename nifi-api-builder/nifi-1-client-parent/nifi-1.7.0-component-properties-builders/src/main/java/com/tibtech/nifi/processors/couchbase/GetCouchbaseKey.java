package com.tibtech.nifi.processors.couchbase;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GetCouchbaseKey {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.couchbase.GetCouchbaseKey";

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
   * If set, the retrieved value will be put into an attribute of the FlowFile instead of a the content of the FlowFile. The attribute key to put to is determined by evaluating value of this property.
   */
  public static final String PUT_TO_ATTRIBUTE_PROPERTY = "put-to-attribute";

  private final Map<String, String> properties;

  public GetCouchbaseKey() {
    this.properties = new HashMap<>();
  }

  public GetCouchbaseKey(final Map<String, String> properties) {
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
  public final GetCouchbaseKey setClusterControllerService(final String clusterControllerService) {
    properties.put(CLUSTER_CONTROLLER_SERVICE_PROPERTY, clusterControllerService);
    return this;
  }

  /**
   * A Couchbase Cluster Controller Service which manages connections to a Couchbase cluster.
   */
  public final GetCouchbaseKey removeClusterControllerService() {
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
  public final GetCouchbaseKey setBucketName(final String bucketName) {
    properties.put(BUCKET_NAME_PROPERTY, bucketName);
    return this;
  }

  /**
   * The name of bucket to access.
   */
  public final GetCouchbaseKey removeBucketName() {
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
  public final GetCouchbaseKey setDocumentType(final String documentType) {
    properties.put(DOCUMENT_TYPE_PROPERTY, documentType);
    return this;
  }

  /**
   * The type of contents.
   */
  public final GetCouchbaseKey removeDocumentType() {
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
  public final GetCouchbaseKey setDocumentId(final String documentId) {
    properties.put(DOCUMENT_ID_PROPERTY, documentId);
    return this;
  }

  /**
   * A static, fixed Couchbase document id, or an expression to construct the Couchbase document id.
   */
  public final GetCouchbaseKey removeDocumentId() {
    properties.remove(DOCUMENT_ID_PROPERTY);
    return this;
  }

  /**
   * If set, the retrieved value will be put into an attribute of the FlowFile instead of a the content of the FlowFile. The attribute key to put to is determined by evaluating value of this property.
   */
  public final String getPutToAttribute() {
    return properties.get(PUT_TO_ATTRIBUTE_PROPERTY);
  }

  /**
   * If set, the retrieved value will be put into an attribute of the FlowFile instead of a the content of the FlowFile. The attribute key to put to is determined by evaluating value of this property.
   */
  public final GetCouchbaseKey setPutToAttribute(final String putToAttribute) {
    properties.put(PUT_TO_ATTRIBUTE_PROPERTY, putToAttribute);
    return this;
  }

  /**
   * If set, the retrieved value will be put into an attribute of the FlowFile instead of a the content of the FlowFile. The attribute key to put to is determined by evaluating value of this property.
   */
  public final GetCouchbaseKey removePutToAttribute() {
    properties.remove(PUT_TO_ATTRIBUTE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GetCouchbaseKey setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GetCouchbaseKey removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<GetCouchbaseKey, GetCouchbaseKey> configurator) {
    return configurator.apply(new GetCouchbaseKey()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetCouchbaseKey.class) final Closure<GetCouchbaseKey> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.couchbase.GetCouchbaseKey> code = closure.rehydrate(c, com.tibtech.nifi.processors.couchbase.GetCouchbaseKey.class, com.tibtech.nifi.processors.couchbase.GetCouchbaseKey.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<GetCouchbaseKey, GetCouchbaseKey> configurator) {
    return configurator.apply(new GetCouchbaseKey(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetCouchbaseKey.class) final Closure<GetCouchbaseKey> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.couchbase.GetCouchbaseKey> code = closure.rehydrate(c, com.tibtech.nifi.processors.couchbase.GetCouchbaseKey.class, com.tibtech.nifi.processors.couchbase.GetCouchbaseKey.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
