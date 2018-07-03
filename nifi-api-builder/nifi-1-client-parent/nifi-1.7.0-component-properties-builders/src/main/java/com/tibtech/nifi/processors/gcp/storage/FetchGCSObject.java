package com.tibtech.nifi.processors.gcp.storage;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class FetchGCSObject {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.gcp.storage.FetchGCSObject";

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
   * The generation of the Object to download. If null, will download latest generation.
   */
  public static final String GCS_GENERATION_PROPERTY = "gcs-generation";

  /**
   * An AES256 Key (encoded in base64) which the object has been encrypted in.
   */
  public static final String GCS_SERVER_SIDE_ENCRYPTION_KEY_PROPERTY = "gcs-server-side-encryption-key";

  private final Map<String, String> properties;

  public FetchGCSObject() {
    this.properties = new HashMap<>();
  }

  public FetchGCSObject(final Map<String, String> properties) {
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
  public final FetchGCSObject setGcpCredentialsProviderService(
      final String gcpCredentialsProviderService) {
    properties.put(GCP_CREDENTIALS_PROVIDER_SERVICE_PROPERTY, gcpCredentialsProviderService);
    return this;
  }

  /**
   * The Controller Service used to obtain Google Cloud Platform credentials.
   */
  public final FetchGCSObject removeGcpCredentialsProviderService() {
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
  public final FetchGCSObject setGcpProjectId(final String gcpProjectId) {
    properties.put(GCP_PROJECT_ID_PROPERTY, gcpProjectId);
    return this;
  }

  /**
   * Google Cloud Project ID
   */
  public final FetchGCSObject removeGcpProjectId() {
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
  public final FetchGCSObject setGcpRetryCount(final String gcpRetryCount) {
    properties.put(GCP_RETRY_COUNT_PROPERTY, gcpRetryCount);
    return this;
  }

  /**
   * How many retry attempts should be made before routing to the failure relationship.
   */
  public final FetchGCSObject removeGcpRetryCount() {
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
  public final FetchGCSObject setGcpProxyHost(final String gcpProxyHost) {
    properties.put(GCP_PROXY_HOST_PROPERTY, gcpProxyHost);
    return this;
  }

  /**
   * IP or hostname of the proxy to be used
   */
  public final FetchGCSObject removeGcpProxyHost() {
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
  public final FetchGCSObject setGcpProxyPort(final String gcpProxyPort) {
    properties.put(GCP_PROXY_PORT_PROPERTY, gcpProxyPort);
    return this;
  }

  /**
   * Proxy port number
   */
  public final FetchGCSObject removeGcpProxyPort() {
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
  public final FetchGCSObject setGcsBucket(final String gcsBucket) {
    properties.put(GCS_BUCKET_PROPERTY, gcsBucket);
    return this;
  }

  /**
   * Bucket of the object.
   */
  public final FetchGCSObject removeGcsBucket() {
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
  public final FetchGCSObject setGcsKey(final String gcsKey) {
    properties.put(GCS_KEY_PROPERTY, gcsKey);
    return this;
  }

  /**
   * Name of the object.
   */
  public final FetchGCSObject removeGcsKey() {
    properties.remove(GCS_KEY_PROPERTY);
    return this;
  }

  /**
   * The generation of the Object to download. If null, will download latest generation.
   */
  public final String getGcsGeneration() {
    return properties.get(GCS_GENERATION_PROPERTY);
  }

  /**
   * The generation of the Object to download. If null, will download latest generation.
   */
  public final FetchGCSObject setGcsGeneration(final String gcsGeneration) {
    properties.put(GCS_GENERATION_PROPERTY, gcsGeneration);
    return this;
  }

  /**
   * The generation of the Object to download. If null, will download latest generation.
   */
  public final FetchGCSObject removeGcsGeneration() {
    properties.remove(GCS_GENERATION_PROPERTY);
    return this;
  }

  /**
   * An AES256 Key (encoded in base64) which the object has been encrypted in.
   */
  public final String getGcsServerSideEncryptionKey() {
    return properties.get(GCS_SERVER_SIDE_ENCRYPTION_KEY_PROPERTY);
  }

  /**
   * An AES256 Key (encoded in base64) which the object has been encrypted in.
   */
  public final FetchGCSObject setGcsServerSideEncryptionKey(
      final String gcsServerSideEncryptionKey) {
    properties.put(GCS_SERVER_SIDE_ENCRYPTION_KEY_PROPERTY, gcsServerSideEncryptionKey);
    return this;
  }

  /**
   * An AES256 Key (encoded in base64) which the object has been encrypted in.
   */
  public final FetchGCSObject removeGcsServerSideEncryptionKey() {
    properties.remove(GCS_SERVER_SIDE_ENCRYPTION_KEY_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final FetchGCSObject setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final FetchGCSObject removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<FetchGCSObject, FetchGCSObject> configurator) {
    return configurator.apply(new FetchGCSObject()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FetchGCSObject.class) final Closure<FetchGCSObject> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.gcp.storage.FetchGCSObject> code = closure.rehydrate(c, com.tibtech.nifi.processors.gcp.storage.FetchGCSObject.class, com.tibtech.nifi.processors.gcp.storage.FetchGCSObject.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<FetchGCSObject, FetchGCSObject> configurator) {
    return configurator.apply(new FetchGCSObject(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FetchGCSObject.class) final Closure<FetchGCSObject> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.gcp.storage.FetchGCSObject> code = closure.rehydrate(c, com.tibtech.nifi.processors.gcp.storage.FetchGCSObject.class, com.tibtech.nifi.processors.gcp.storage.FetchGCSObject.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
