package com.tibtech.nifi.processors.gcp.storage;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class DeleteGCSObject {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.gcp.storage.DeleteGCSObject";

  /**
   * The Controller Service used to obtain Google Cloud Platform credentials.
   */
  public static final String GCP_CREDENTIALS_PROVIDER_SERVICE_PROPERTY = "GCP Credentials Provider Service";

  /**
   * Google Cloud Project ID
   */
  public static final String GCP_PROJECT_ID_PROPERTY = "gcp-project-id";

  /**
   * How many retry attempts should be made before routing to the failure relationship.
   */
  public static final String GCP_RETRY_COUNT_PROPERTY = "gcp-retry-count";

  /**
   * IP or hostname of the proxy to be used
   */
  public static final String GCP_PROXY_HOST_PROPERTY = "gcp-proxy-host";

  /**
   * Proxy port number
   */
  public static final String GCP_PROXY_PORT_PROPERTY = "gcp-proxy-port";

  /**
   * Bucket of the object.
   */
  public static final String GCS_BUCKET_PROPERTY = "gcs-bucket";

  /**
   * Name of the object.
   */
  public static final String GCS_KEY_PROPERTY = "gcs-key";

  /**
   * The generation of the object to be deleted. If null, will use latest version of the object.
   */
  public static final String GCS_GENERATION_PROPERTY = "gcs-generation";

  private final Map<String, String> properties;

  public DeleteGCSObject() {
    this.properties = new HashMap<>();
  }

  public DeleteGCSObject(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The Controller Service used to obtain Google Cloud Platform credentials.
   */
  public final String getGcpCredentialsProviderService() {
    return properties.get(GCP_CREDENTIALS_PROVIDER_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service used to obtain Google Cloud Platform credentials.
   */
  public final DeleteGCSObject setGcpCredentialsProviderService(
      final String gcpCredentialsProviderService) {
    properties.put(GCP_CREDENTIALS_PROVIDER_SERVICE_PROPERTY, gcpCredentialsProviderService);
    return this;
  }

  /**
   * The Controller Service used to obtain Google Cloud Platform credentials.
   */
  public final DeleteGCSObject removeGcpCredentialsProviderService() {
    properties.remove(GCP_CREDENTIALS_PROVIDER_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Google Cloud Project ID
   */
  public final String getGcpProjectId() {
    return properties.get(GCP_PROJECT_ID_PROPERTY);
  }

  /**
   * Google Cloud Project ID
   */
  public final DeleteGCSObject setGcpProjectId(final String gcpProjectId) {
    properties.put(GCP_PROJECT_ID_PROPERTY, gcpProjectId);
    return this;
  }

  /**
   * Google Cloud Project ID
   */
  public final DeleteGCSObject removeGcpProjectId() {
    properties.remove(GCP_PROJECT_ID_PROPERTY);
    return this;
  }

  /**
   * How many retry attempts should be made before routing to the failure relationship.
   */
  public final String getGcpRetryCount() {
    return properties.get(GCP_RETRY_COUNT_PROPERTY);
  }

  /**
   * How many retry attempts should be made before routing to the failure relationship.
   */
  public final DeleteGCSObject setGcpRetryCount(final String gcpRetryCount) {
    properties.put(GCP_RETRY_COUNT_PROPERTY, gcpRetryCount);
    return this;
  }

  /**
   * How many retry attempts should be made before routing to the failure relationship.
   */
  public final DeleteGCSObject removeGcpRetryCount() {
    properties.remove(GCP_RETRY_COUNT_PROPERTY);
    return this;
  }

  /**
   * IP or hostname of the proxy to be used
   */
  public final String getGcpProxyHost() {
    return properties.get(GCP_PROXY_HOST_PROPERTY);
  }

  /**
   * IP or hostname of the proxy to be used
   */
  public final DeleteGCSObject setGcpProxyHost(final String gcpProxyHost) {
    properties.put(GCP_PROXY_HOST_PROPERTY, gcpProxyHost);
    return this;
  }

  /**
   * IP or hostname of the proxy to be used
   */
  public final DeleteGCSObject removeGcpProxyHost() {
    properties.remove(GCP_PROXY_HOST_PROPERTY);
    return this;
  }

  /**
   * Proxy port number
   */
  public final String getGcpProxyPort() {
    return properties.get(GCP_PROXY_PORT_PROPERTY);
  }

  /**
   * Proxy port number
   */
  public final DeleteGCSObject setGcpProxyPort(final String gcpProxyPort) {
    properties.put(GCP_PROXY_PORT_PROPERTY, gcpProxyPort);
    return this;
  }

  /**
   * Proxy port number
   */
  public final DeleteGCSObject removeGcpProxyPort() {
    properties.remove(GCP_PROXY_PORT_PROPERTY);
    return this;
  }

  /**
   * Bucket of the object.
   */
  public final String getGcsBucket() {
    return properties.get(GCS_BUCKET_PROPERTY);
  }

  /**
   * Bucket of the object.
   */
  public final DeleteGCSObject setGcsBucket(final String gcsBucket) {
    properties.put(GCS_BUCKET_PROPERTY, gcsBucket);
    return this;
  }

  /**
   * Bucket of the object.
   */
  public final DeleteGCSObject removeGcsBucket() {
    properties.remove(GCS_BUCKET_PROPERTY);
    return this;
  }

  /**
   * Name of the object.
   */
  public final String getGcsKey() {
    return properties.get(GCS_KEY_PROPERTY);
  }

  /**
   * Name of the object.
   */
  public final DeleteGCSObject setGcsKey(final String gcsKey) {
    properties.put(GCS_KEY_PROPERTY, gcsKey);
    return this;
  }

  /**
   * Name of the object.
   */
  public final DeleteGCSObject removeGcsKey() {
    properties.remove(GCS_KEY_PROPERTY);
    return this;
  }

  /**
   * The generation of the object to be deleted. If null, will use latest version of the object.
   */
  public final String getGcsGeneration() {
    return properties.get(GCS_GENERATION_PROPERTY);
  }

  /**
   * The generation of the object to be deleted. If null, will use latest version of the object.
   */
  public final DeleteGCSObject setGcsGeneration(final String gcsGeneration) {
    properties.put(GCS_GENERATION_PROPERTY, gcsGeneration);
    return this;
  }

  /**
   * The generation of the object to be deleted. If null, will use latest version of the object.
   */
  public final DeleteGCSObject removeGcsGeneration() {
    properties.remove(GCS_GENERATION_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final DeleteGCSObject setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final DeleteGCSObject removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<DeleteGCSObject, DeleteGCSObject> configurator) {
    return configurator.apply(new DeleteGCSObject()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DeleteGCSObject.class) final Closure<DeleteGCSObject> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.gcp.storage.DeleteGCSObject> code = closure.rehydrate(c, com.tibtech.nifi.processors.gcp.storage.DeleteGCSObject.class, com.tibtech.nifi.processors.gcp.storage.DeleteGCSObject.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<DeleteGCSObject, DeleteGCSObject> configurator) {
    return configurator.apply(new DeleteGCSObject(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DeleteGCSObject.class) final Closure<DeleteGCSObject> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.gcp.storage.DeleteGCSObject> code = closure.rehydrate(c, com.tibtech.nifi.processors.gcp.storage.DeleteGCSObject.class, com.tibtech.nifi.processors.gcp.storage.DeleteGCSObject.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
