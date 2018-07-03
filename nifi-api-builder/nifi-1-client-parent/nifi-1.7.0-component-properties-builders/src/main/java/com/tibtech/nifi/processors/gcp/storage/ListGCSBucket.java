package com.tibtech.nifi.processors.gcp.storage;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ListGCSBucket {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.gcp.storage.ListGCSBucket";

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
   * The prefix used to filter the object list. In most cases, it should end with a forward slash ('/').
   */
  public static final String GCS_PREFIX_PROPERTY = "gcs-prefix";

  /**
   * Specifies whether to use GCS Generations, if applicable.  If false, only the latest version of each object will be returned.
   */
  public static final String GCS_USE_GENERATIONS_PROPERTY = "gcs-use-generations";

  private final Map<String, String> properties;

  public ListGCSBucket() {
    this.properties = new HashMap<>();
  }

  public ListGCSBucket(final Map<String, String> properties) {
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
  public final ListGCSBucket setGcpCredentialsProviderService(
      final String gcpCredentialsProviderService) {
    properties.put(GCP_CREDENTIALS_PROVIDER_SERVICE_PROPERTY, gcpCredentialsProviderService);
    return this;
  }

  /**
   * The Controller Service used to obtain Google Cloud Platform credentials.
   */
  public final ListGCSBucket removeGcpCredentialsProviderService() {
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
  public final ListGCSBucket setGcpProjectId(final String gcpProjectId) {
    properties.put(GCP_PROJECT_ID_PROPERTY, gcpProjectId);
    return this;
  }

  /**
   * Google Cloud Project ID
   */
  public final ListGCSBucket removeGcpProjectId() {
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
  public final ListGCSBucket setGcpRetryCount(final String gcpRetryCount) {
    properties.put(GCP_RETRY_COUNT_PROPERTY, gcpRetryCount);
    return this;
  }

  /**
   * How many retry attempts should be made before routing to the failure relationship.
   */
  public final ListGCSBucket removeGcpRetryCount() {
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
  public final ListGCSBucket setGcpProxyHost(final String gcpProxyHost) {
    properties.put(GCP_PROXY_HOST_PROPERTY, gcpProxyHost);
    return this;
  }

  /**
   * IP or hostname of the proxy to be used
   */
  public final ListGCSBucket removeGcpProxyHost() {
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
  public final ListGCSBucket setGcpProxyPort(final String gcpProxyPort) {
    properties.put(GCP_PROXY_PORT_PROPERTY, gcpProxyPort);
    return this;
  }

  /**
   * Proxy port number
   */
  public final ListGCSBucket removeGcpProxyPort() {
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
  public final ListGCSBucket setGcsBucket(final String gcsBucket) {
    properties.put(GCS_BUCKET_PROPERTY, gcsBucket);
    return this;
  }

  /**
   * Bucket of the object.
   */
  public final ListGCSBucket removeGcsBucket() {
    properties.remove(GCS_BUCKET_PROPERTY);
    return this;
  }

  /**
   * The prefix used to filter the object list. In most cases, it should end with a forward slash ('/').
   */
  public final String getGcsPrefix() {
    return properties.get(GCS_PREFIX_PROPERTY);
  }

  /**
   * The prefix used to filter the object list. In most cases, it should end with a forward slash ('/').
   */
  public final ListGCSBucket setGcsPrefix(final String gcsPrefix) {
    properties.put(GCS_PREFIX_PROPERTY, gcsPrefix);
    return this;
  }

  /**
   * The prefix used to filter the object list. In most cases, it should end with a forward slash ('/').
   */
  public final ListGCSBucket removeGcsPrefix() {
    properties.remove(GCS_PREFIX_PROPERTY);
    return this;
  }

  /**
   * Specifies whether to use GCS Generations, if applicable.  If false, only the latest version of each object will be returned.
   */
  public final String getGcsUseGenerations() {
    return properties.get(GCS_USE_GENERATIONS_PROPERTY);
  }

  /**
   * Specifies whether to use GCS Generations, if applicable.  If false, only the latest version of each object will be returned.
   */
  public final ListGCSBucket setGcsUseGenerations(final String gcsUseGenerations) {
    properties.put(GCS_USE_GENERATIONS_PROPERTY, gcsUseGenerations);
    return this;
  }

  /**
   * Specifies whether to use GCS Generations, if applicable.  If false, only the latest version of each object will be returned.
   */
  public final ListGCSBucket removeGcsUseGenerations() {
    properties.remove(GCS_USE_GENERATIONS_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ListGCSBucket setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ListGCSBucket removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ListGCSBucket, ListGCSBucket> configurator) {
    return configurator.apply(new ListGCSBucket()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListGCSBucket.class) final Closure<ListGCSBucket> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.gcp.storage.ListGCSBucket> code = closure.rehydrate(c, com.tibtech.nifi.processors.gcp.storage.ListGCSBucket.class, com.tibtech.nifi.processors.gcp.storage.ListGCSBucket.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ListGCSBucket, ListGCSBucket> configurator) {
    return configurator.apply(new ListGCSBucket(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListGCSBucket.class) final Closure<ListGCSBucket> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.gcp.storage.ListGCSBucket> code = closure.rehydrate(c, com.tibtech.nifi.processors.gcp.storage.ListGCSBucket.class, com.tibtech.nifi.processors.gcp.storage.ListGCSBucket.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
