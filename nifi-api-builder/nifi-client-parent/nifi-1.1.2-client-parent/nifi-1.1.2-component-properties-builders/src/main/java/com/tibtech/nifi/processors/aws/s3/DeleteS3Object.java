package com.tibtech.nifi.processors.aws.s3;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class DeleteS3Object {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.aws.s3.DeleteS3Object";

  /**
   *
   */
  public static final String OBJECT_KEY_PROPERTY = "Object Key";

  /**
   *
   */
  public static final String BUCKET_PROPERTY = "Bucket";

  /**
   *
   */
  public static final String ACCESS_KEY_PROPERTY = "Access Key";

  /**
   *
   */
  public static final String SECRET_KEY_PROPERTY = "Secret Key";

  /**
   * Path to a file containing AWS access key and secret key in properties file format.
   */
  public static final String CREDENTIALS_FILE_PROPERTY = "Credentials File";

  /**
   * The Controller Service that is used to obtain aws credentials provider
   */
  public static final String AWS_CREDENTIALS_PROVIDER_SERVICE_PROPERTY = "AWS Credentials Provider service";

  /**
   *
   */
  public static final String REGION_PROPERTY = "Region";

  /**
   *
   */
  public static final String COMMUNICATIONS_TIMEOUT_PROPERTY = "Communications Timeout";

  /**
   * The Version of the Object to delete
   */
  public static final String VERSION_PROPERTY = "Version";

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have Full Control for an object
   */
  public static final String FULL_CONTROL_USER_LIST_PROPERTY = "FullControl User List";

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have Read Access for an object
   */
  public static final String READ_PERMISSION_USER_LIST_PROPERTY = "Read Permission User List";

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have Write Access for an object
   */
  public static final String WRITE_PERMISSION_USER_LIST_PROPERTY = "Write Permission User List";

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have permissions to read the Access Control List for an object
   */
  public static final String READ_ACL_USER_LIST_PROPERTY = "Read ACL User List";

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have permissions to change the Access Control List for an object
   */
  public static final String WRITE_ACL_USER_LIST_PROPERTY = "Write ACL User List";

  /**
   * The Amazon ID to use for the object's owner
   */
  public static final String OWNER_PROPERTY = "Owner";

  /**
   * Specifies an optional SSL Context Service that, if provided, will be used to create connections
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  /**
   * Endpoint URL to use instead of the AWS default including scheme, host, port, and path. The AWS libraries select an endpoint URL based on the AWS region, but this property overrides the selected endpoint URL, allowing use with other S3-compatible endpoints.
   */
  public static final String ENDPOINT_OVERRIDE_URL_PROPERTY = "Endpoint Override URL";

  /**
   * The AWS libraries use the default signer but this property allows you to specify a custom signer to support older S3-compatible services.
   */
  public static final String SIGNER_OVERRIDE_PROPERTY = "Signer Override";

  /**
   * Proxy host name or IP
   */
  public static final String PROXY_HOST_PROPERTY = "Proxy Host";

  /**
   * Proxy host port
   */
  public static final String PROXY_HOST_PORT_PROPERTY = "Proxy Host Port";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   *
   */
  public final String getObjectKey() {
    return properties.get(OBJECT_KEY_PROPERTY);
  }

  /**
   *
   */
  public final DeleteS3Object setObjectKey(final String objectKey) {
    properties.put(OBJECT_KEY_PROPERTY, objectKey);
    return this;
  }

  /**
   *
   */
  public final DeleteS3Object removeObjectKey() {
    properties.remove(OBJECT_KEY_PROPERTY);
    return this;
  }

  /**
   *
   */
  public final String getBucket() {
    return properties.get(BUCKET_PROPERTY);
  }

  /**
   *
   */
  public final DeleteS3Object setBucket(final String bucket) {
    properties.put(BUCKET_PROPERTY, bucket);
    return this;
  }

  /**
   *
   */
  public final DeleteS3Object removeBucket() {
    properties.remove(BUCKET_PROPERTY);
    return this;
  }

  /**
   *
   */
  public final String getAccessKey() {
    return properties.get(ACCESS_KEY_PROPERTY);
  }

  /**
   *
   */
  public final DeleteS3Object setAccessKey(final String accessKey) {
    properties.put(ACCESS_KEY_PROPERTY, accessKey);
    return this;
  }

  /**
   *
   */
  public final DeleteS3Object removeAccessKey() {
    properties.remove(ACCESS_KEY_PROPERTY);
    return this;
  }

  /**
   *
   */
  public final String getSecretKey() {
    return properties.get(SECRET_KEY_PROPERTY);
  }

  /**
   *
   */
  public final DeleteS3Object setSecretKey(final String secretKey) {
    properties.put(SECRET_KEY_PROPERTY, secretKey);
    return this;
  }

  /**
   *
   */
  public final DeleteS3Object removeSecretKey() {
    properties.remove(SECRET_KEY_PROPERTY);
    return this;
  }

  /**
   * Path to a file containing AWS access key and secret key in properties file format.
   */
  public final String getCredentialsFile() {
    return properties.get(CREDENTIALS_FILE_PROPERTY);
  }

  /**
   * Path to a file containing AWS access key and secret key in properties file format.
   */
  public final DeleteS3Object setCredentialsFile(final String credentialsFile) {
    properties.put(CREDENTIALS_FILE_PROPERTY, credentialsFile);
    return this;
  }

  /**
   * Path to a file containing AWS access key and secret key in properties file format.
   */
  public final DeleteS3Object removeCredentialsFile() {
    properties.remove(CREDENTIALS_FILE_PROPERTY);
    return this;
  }

  /**
   * The Controller Service that is used to obtain aws credentials provider
   */
  public final String getAwsCredentialsProviderService() {
    return properties.get(AWS_CREDENTIALS_PROVIDER_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service that is used to obtain aws credentials provider
   */
  public final DeleteS3Object setAwsCredentialsProviderService(final String awsCredentialsProviderService) {
    properties.put(AWS_CREDENTIALS_PROVIDER_SERVICE_PROPERTY, awsCredentialsProviderService);
    return this;
  }

  /**
   * The Controller Service that is used to obtain aws credentials provider
   */
  public final DeleteS3Object removeAwsCredentialsProviderService() {
    properties.remove(AWS_CREDENTIALS_PROVIDER_SERVICE_PROPERTY);
    return this;
  }

  /**
   *
   */
  public final String getRegion() {
    return properties.get(REGION_PROPERTY);
  }

  /**
   *
   */
  public final DeleteS3Object setRegion(final String region) {
    properties.put(REGION_PROPERTY, region);
    return this;
  }

  /**
   *
   */
  public final DeleteS3Object removeRegion() {
    properties.remove(REGION_PROPERTY);
    return this;
  }

  /**
   *
   */
  public final String getCommunicationsTimeout() {
    return properties.get(COMMUNICATIONS_TIMEOUT_PROPERTY);
  }

  /**
   *
   */
  public final DeleteS3Object setCommunicationsTimeout(final String communicationsTimeout) {
    properties.put(COMMUNICATIONS_TIMEOUT_PROPERTY, communicationsTimeout);
    return this;
  }

  /**
   *
   */
  public final DeleteS3Object removeCommunicationsTimeout() {
    properties.remove(COMMUNICATIONS_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The Version of the Object to delete
   */
  public final String getVersion() {
    return properties.get(VERSION_PROPERTY);
  }

  /**
   * The Version of the Object to delete
   */
  public final DeleteS3Object setVersion(final String version) {
    properties.put(VERSION_PROPERTY, version);
    return this;
  }

  /**
   * The Version of the Object to delete
   */
  public final DeleteS3Object removeVersion() {
    properties.remove(VERSION_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have Full Control for an object
   */
  public final String getFullControlUserList() {
    return properties.get(FULL_CONTROL_USER_LIST_PROPERTY);
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have Full Control for an object
   */
  public final DeleteS3Object setFullControlUserList(final String fullControlUserList) {
    properties.put(FULL_CONTROL_USER_LIST_PROPERTY, fullControlUserList);
    return this;
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have Full Control for an object
   */
  public final DeleteS3Object removeFullControlUserList() {
    properties.remove(FULL_CONTROL_USER_LIST_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have Read Access for an object
   */
  public final String getReadPermissionUserList() {
    return properties.get(READ_PERMISSION_USER_LIST_PROPERTY);
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have Read Access for an object
   */
  public final DeleteS3Object setReadPermissionUserList(final String readPermissionUserList) {
    properties.put(READ_PERMISSION_USER_LIST_PROPERTY, readPermissionUserList);
    return this;
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have Read Access for an object
   */
  public final DeleteS3Object removeReadPermissionUserList() {
    properties.remove(READ_PERMISSION_USER_LIST_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have Write Access for an object
   */
  public final String getWritePermissionUserList() {
    return properties.get(WRITE_PERMISSION_USER_LIST_PROPERTY);
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have Write Access for an object
   */
  public final DeleteS3Object setWritePermissionUserList(final String writePermissionUserList) {
    properties.put(WRITE_PERMISSION_USER_LIST_PROPERTY, writePermissionUserList);
    return this;
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have Write Access for an object
   */
  public final DeleteS3Object removeWritePermissionUserList() {
    properties.remove(WRITE_PERMISSION_USER_LIST_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have permissions to read the Access Control List for an object
   */
  public final String getReadAclUserList() {
    return properties.get(READ_ACL_USER_LIST_PROPERTY);
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have permissions to read the Access Control List for an object
   */
  public final DeleteS3Object setReadAclUserList(final String readAclUserList) {
    properties.put(READ_ACL_USER_LIST_PROPERTY, readAclUserList);
    return this;
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have permissions to read the Access Control List for an object
   */
  public final DeleteS3Object removeReadAclUserList() {
    properties.remove(READ_ACL_USER_LIST_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have permissions to change the Access Control List for an object
   */
  public final String getWriteAclUserList() {
    return properties.get(WRITE_ACL_USER_LIST_PROPERTY);
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have permissions to change the Access Control List for an object
   */
  public final DeleteS3Object setWriteAclUserList(final String writeAclUserList) {
    properties.put(WRITE_ACL_USER_LIST_PROPERTY, writeAclUserList);
    return this;
  }

  /**
   * A comma-separated list of Amazon User ID's or E-mail addresses that specifies who should have permissions to change the Access Control List for an object
   */
  public final DeleteS3Object removeWriteAclUserList() {
    properties.remove(WRITE_ACL_USER_LIST_PROPERTY);
    return this;
  }

  /**
   * The Amazon ID to use for the object's owner
   */
  public final String getOwner() {
    return properties.get(OWNER_PROPERTY);
  }

  /**
   * The Amazon ID to use for the object's owner
   */
  public final DeleteS3Object setOwner(final String owner) {
    properties.put(OWNER_PROPERTY, owner);
    return this;
  }

  /**
   * The Amazon ID to use for the object's owner
   */
  public final DeleteS3Object removeOwner() {
    properties.remove(OWNER_PROPERTY);
    return this;
  }

  /**
   * Specifies an optional SSL Context Service that, if provided, will be used to create connections
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * Specifies an optional SSL Context Service that, if provided, will be used to create connections
   */
  public final DeleteS3Object setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * Specifies an optional SSL Context Service that, if provided, will be used to create connections
   */
  public final DeleteS3Object removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Endpoint URL to use instead of the AWS default including scheme, host, port, and path. The AWS libraries select an endpoint URL based on the AWS region, but this property overrides the selected endpoint URL, allowing use with other S3-compatible endpoints.
   */
  public final String getEndpointOverrideUrl() {
    return properties.get(ENDPOINT_OVERRIDE_URL_PROPERTY);
  }

  /**
   * Endpoint URL to use instead of the AWS default including scheme, host, port, and path. The AWS libraries select an endpoint URL based on the AWS region, but this property overrides the selected endpoint URL, allowing use with other S3-compatible endpoints.
   */
  public final DeleteS3Object setEndpointOverrideUrl(final String endpointOverrideUrl) {
    properties.put(ENDPOINT_OVERRIDE_URL_PROPERTY, endpointOverrideUrl);
    return this;
  }

  /**
   * Endpoint URL to use instead of the AWS default including scheme, host, port, and path. The AWS libraries select an endpoint URL based on the AWS region, but this property overrides the selected endpoint URL, allowing use with other S3-compatible endpoints.
   */
  public final DeleteS3Object removeEndpointOverrideUrl() {
    properties.remove(ENDPOINT_OVERRIDE_URL_PROPERTY);
    return this;
  }

  /**
   * The AWS libraries use the default signer but this property allows you to specify a custom signer to support older S3-compatible services.
   */
  public final String getSignerOverride() {
    return properties.get(SIGNER_OVERRIDE_PROPERTY);
  }

  /**
   * The AWS libraries use the default signer but this property allows you to specify a custom signer to support older S3-compatible services.
   */
  public final DeleteS3Object setSignerOverride(final String signerOverride) {
    properties.put(SIGNER_OVERRIDE_PROPERTY, signerOverride);
    return this;
  }

  /**
   * The AWS libraries use the default signer but this property allows you to specify a custom signer to support older S3-compatible services.
   */
  public final DeleteS3Object removeSignerOverride() {
    properties.remove(SIGNER_OVERRIDE_PROPERTY);
    return this;
  }

  /**
   * Proxy host name or IP
   */
  public final String getProxyHost() {
    return properties.get(PROXY_HOST_PROPERTY);
  }

  /**
   * Proxy host name or IP
   */
  public final DeleteS3Object setProxyHost(final String proxyHost) {
    properties.put(PROXY_HOST_PROPERTY, proxyHost);
    return this;
  }

  /**
   * Proxy host name or IP
   */
  public final DeleteS3Object removeProxyHost() {
    properties.remove(PROXY_HOST_PROPERTY);
    return this;
  }

  /**
   * Proxy host port
   */
  public final String getProxyHostPort() {
    return properties.get(PROXY_HOST_PORT_PROPERTY);
  }

  /**
   * Proxy host port
   */
  public final DeleteS3Object setProxyHostPort(final String proxyHostPort) {
    properties.put(PROXY_HOST_PORT_PROPERTY, proxyHostPort);
    return this;
  }

  /**
   * Proxy host port
   */
  public final DeleteS3Object removeProxyHostPort() {
    properties.remove(PROXY_HOST_PORT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final DeleteS3Object setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final DeleteS3Object removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<DeleteS3Object, DeleteS3Object> configurator) {
    return configurator.apply(new DeleteS3Object()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DeleteS3Object.class) final Closure<DeleteS3Object> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.aws.s3.DeleteS3Object> code = closure.rehydrate(c, com.tibtech.nifi.processors.aws.s3.DeleteS3Object.class, com.tibtech.nifi.processors.aws.s3.DeleteS3Object.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
