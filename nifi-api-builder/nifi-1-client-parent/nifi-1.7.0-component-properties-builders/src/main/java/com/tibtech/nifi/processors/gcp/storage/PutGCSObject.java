package com.tibtech.nifi.processors.gcp.storage;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutGCSObject {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.gcp.storage.PutGCSObject";

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
   * Content Type for the file, i.e. text/plain
   */
  public static final String GCS_CONTENT_TYPE_PROPERTY = "gcs-content-type";

  /**
   * MD5 Hash (encoded in Base64) of the file for server-side validation.
   */
  public static final String GCS_OBJECT_MD_5_PROPERTY = "gcs-object-md5";

  /**
   * CRC32C Checksum (encoded in Base64, big-Endian order) of the file for server-side validation.
   */
  public static final String GCS_OBJECT_CRC_32_C_PROPERTY = "gcs-object-crc32c";

  /**
   * Access Control to be attached to the object uploaded. Not providing this will revert to bucket defaults.
   */
  public static final String GCS_OBJECT_ACL_PROPERTY = "gcs-object-acl";

  /**
   * An AES256 Encryption Key (encoded in base64) for server-side encryption of the object.
   */
  public static final String GCS_SERVER_SIDE_ENCRYPTION_KEY_PROPERTY = "gcs-server-side-encryption-key";

  /**
   * If false, the upload to GCS will succeed only if the object does not exist.
   */
  public static final String GCS_OVERWRITE_OBJECT_PROPERTY = "gcs-overwrite-object";

  /**
   * Type of RFC-6266 Content Disposition to be attached to the object
   */
  public static final String GCS_CONTENT_DISPOSITION_TYPE_PROPERTY = "gcs-content-disposition-type";

  private final Map<String, String> properties;

  public PutGCSObject() {
    this.properties = new HashMap<>();
  }

  public PutGCSObject(final Map<String, String> properties) {
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
  public final PutGCSObject setGcpCredentialsProviderService(
      final String gcpCredentialsProviderService) {
    properties.put(GCP_CREDENTIALS_PROVIDER_SERVICE_PROPERTY, gcpCredentialsProviderService);
    return this;
  }

  /**
   * The Controller Service used to obtain Google Cloud Platform credentials.
   */
  public final PutGCSObject removeGcpCredentialsProviderService() {
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
  public final PutGCSObject setGcpProjectId(final String gcpProjectId) {
    properties.put(GCP_PROJECT_ID_PROPERTY, gcpProjectId);
    return this;
  }

  /**
   * Google Cloud Project ID
   */
  public final PutGCSObject removeGcpProjectId() {
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
  public final PutGCSObject setGcpRetryCount(final String gcpRetryCount) {
    properties.put(GCP_RETRY_COUNT_PROPERTY, gcpRetryCount);
    return this;
  }

  /**
   * How many retry attempts should be made before routing to the failure relationship.
   */
  public final PutGCSObject removeGcpRetryCount() {
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
  public final PutGCSObject setGcpProxyHost(final String gcpProxyHost) {
    properties.put(GCP_PROXY_HOST_PROPERTY, gcpProxyHost);
    return this;
  }

  /**
   * IP or hostname of the proxy to be used
   */
  public final PutGCSObject removeGcpProxyHost() {
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
  public final PutGCSObject setGcpProxyPort(final String gcpProxyPort) {
    properties.put(GCP_PROXY_PORT_PROPERTY, gcpProxyPort);
    return this;
  }

  /**
   * Proxy port number
   */
  public final PutGCSObject removeGcpProxyPort() {
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
  public final PutGCSObject setGcsBucket(final String gcsBucket) {
    properties.put(GCS_BUCKET_PROPERTY, gcsBucket);
    return this;
  }

  /**
   * Bucket of the object.
   */
  public final PutGCSObject removeGcsBucket() {
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
  public final PutGCSObject setGcsKey(final String gcsKey) {
    properties.put(GCS_KEY_PROPERTY, gcsKey);
    return this;
  }

  /**
   * Name of the object.
   */
  public final PutGCSObject removeGcsKey() {
    properties.remove(GCS_KEY_PROPERTY);
    return this;
  }

  /**
   * Content Type for the file, i.e. text/plain
   */
  public final String getGcsContentType() {
    return properties.get(GCS_CONTENT_TYPE_PROPERTY);
  }

  /**
   * Content Type for the file, i.e. text/plain
   */
  public final PutGCSObject setGcsContentType(final String gcsContentType) {
    properties.put(GCS_CONTENT_TYPE_PROPERTY, gcsContentType);
    return this;
  }

  /**
   * Content Type for the file, i.e. text/plain
   */
  public final PutGCSObject removeGcsContentType() {
    properties.remove(GCS_CONTENT_TYPE_PROPERTY);
    return this;
  }

  /**
   * MD5 Hash (encoded in Base64) of the file for server-side validation.
   */
  public final String getGcsObjectMd5() {
    return properties.get(GCS_OBJECT_MD_5_PROPERTY);
  }

  /**
   * MD5 Hash (encoded in Base64) of the file for server-side validation.
   */
  public final PutGCSObject setGcsObjectMd5(final String gcsObjectMd5) {
    properties.put(GCS_OBJECT_MD_5_PROPERTY, gcsObjectMd5);
    return this;
  }

  /**
   * MD5 Hash (encoded in Base64) of the file for server-side validation.
   */
  public final PutGCSObject removeGcsObjectMd5() {
    properties.remove(GCS_OBJECT_MD_5_PROPERTY);
    return this;
  }

  /**
   * CRC32C Checksum (encoded in Base64, big-Endian order) of the file for server-side validation.
   */
  public final String getGcsObjectCrc32C() {
    return properties.get(GCS_OBJECT_CRC_32_C_PROPERTY);
  }

  /**
   * CRC32C Checksum (encoded in Base64, big-Endian order) of the file for server-side validation.
   */
  public final PutGCSObject setGcsObjectCrc32C(final String gcsObjectCrc32C) {
    properties.put(GCS_OBJECT_CRC_32_C_PROPERTY, gcsObjectCrc32C);
    return this;
  }

  /**
   * CRC32C Checksum (encoded in Base64, big-Endian order) of the file for server-side validation.
   */
  public final PutGCSObject removeGcsObjectCrc32C() {
    properties.remove(GCS_OBJECT_CRC_32_C_PROPERTY);
    return this;
  }

  /**
   * Access Control to be attached to the object uploaded. Not providing this will revert to bucket defaults.
   */
  public final String getGcsObjectAcl() {
    return properties.get(GCS_OBJECT_ACL_PROPERTY);
  }

  /**
   * Access Control to be attached to the object uploaded. Not providing this will revert to bucket defaults.
   */
  public final PutGCSObject setGcsObjectAcl(final String gcsObjectAcl) {
    properties.put(GCS_OBJECT_ACL_PROPERTY, gcsObjectAcl);
    return this;
  }

  /**
   * Access Control to be attached to the object uploaded. Not providing this will revert to bucket defaults.
   */
  public final PutGCSObject removeGcsObjectAcl() {
    properties.remove(GCS_OBJECT_ACL_PROPERTY);
    return this;
  }

  /**
   * An AES256 Encryption Key (encoded in base64) for server-side encryption of the object.
   */
  public final String getGcsServerSideEncryptionKey() {
    return properties.get(GCS_SERVER_SIDE_ENCRYPTION_KEY_PROPERTY);
  }

  /**
   * An AES256 Encryption Key (encoded in base64) for server-side encryption of the object.
   */
  public final PutGCSObject setGcsServerSideEncryptionKey(final String gcsServerSideEncryptionKey) {
    properties.put(GCS_SERVER_SIDE_ENCRYPTION_KEY_PROPERTY, gcsServerSideEncryptionKey);
    return this;
  }

  /**
   * An AES256 Encryption Key (encoded in base64) for server-side encryption of the object.
   */
  public final PutGCSObject removeGcsServerSideEncryptionKey() {
    properties.remove(GCS_SERVER_SIDE_ENCRYPTION_KEY_PROPERTY);
    return this;
  }

  /**
   * If false, the upload to GCS will succeed only if the object does not exist.
   */
  public final String getGcsOverwriteObject() {
    return properties.get(GCS_OVERWRITE_OBJECT_PROPERTY);
  }

  /**
   * If false, the upload to GCS will succeed only if the object does not exist.
   */
  public final PutGCSObject setGcsOverwriteObject(final String gcsOverwriteObject) {
    properties.put(GCS_OVERWRITE_OBJECT_PROPERTY, gcsOverwriteObject);
    return this;
  }

  /**
   * If false, the upload to GCS will succeed only if the object does not exist.
   */
  public final PutGCSObject removeGcsOverwriteObject() {
    properties.remove(GCS_OVERWRITE_OBJECT_PROPERTY);
    return this;
  }

  /**
   * Type of RFC-6266 Content Disposition to be attached to the object
   */
  public final String getGcsContentDispositionType() {
    return properties.get(GCS_CONTENT_DISPOSITION_TYPE_PROPERTY);
  }

  /**
   * Type of RFC-6266 Content Disposition to be attached to the object
   */
  public final PutGCSObject setGcsContentDispositionType(final String gcsContentDispositionType) {
    properties.put(GCS_CONTENT_DISPOSITION_TYPE_PROPERTY, gcsContentDispositionType);
    return this;
  }

  /**
   * Type of RFC-6266 Content Disposition to be attached to the object
   */
  public final PutGCSObject removeGcsContentDispositionType() {
    properties.remove(GCS_CONTENT_DISPOSITION_TYPE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutGCSObject setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutGCSObject removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<PutGCSObject, PutGCSObject> configurator) {
    return configurator.apply(new PutGCSObject()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutGCSObject.class) final Closure<PutGCSObject> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.gcp.storage.PutGCSObject> code = closure.rehydrate(c, com.tibtech.nifi.processors.gcp.storage.PutGCSObject.class, com.tibtech.nifi.processors.gcp.storage.PutGCSObject.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutGCSObject, PutGCSObject> configurator) {
    return configurator.apply(new PutGCSObject(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutGCSObject.class) final Closure<PutGCSObject> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.gcp.storage.PutGCSObject> code = closure.rehydrate(c, com.tibtech.nifi.processors.gcp.storage.PutGCSObject.class, com.tibtech.nifi.processors.gcp.storage.PutGCSObject.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
