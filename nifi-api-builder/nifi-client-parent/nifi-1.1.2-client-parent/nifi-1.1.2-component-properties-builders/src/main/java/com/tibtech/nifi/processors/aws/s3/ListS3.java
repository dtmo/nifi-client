package com.tibtech.nifi.processors.aws.s3;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ListS3 {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.aws.s3.ListS3";

  /**
   *
   */
  public static final String BUCKET_PROPERTY = "Bucket";

  /**
   *
   */
  public static final String REGION_PROPERTY = "Region";

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
  public static final String COMMUNICATIONS_TIMEOUT_PROPERTY = "Communications Timeout";

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

  /**
   * The string used to delimit directories within the bucket. Please consult the AWS documentation for the correct use of this field.
   */
  public static final String DELIMITER_PROPERTY = "delimiter";

  /**
   * The prefix used to filter the object list. In most cases, it should end with a forward slash ('/').
   */
  public static final String PREFIX_PROPERTY = "prefix";

  /**
   * Specifies whether to use S3 versions, if applicable.  If false, only the latest version of each object will be returned.
   */
  public static final String USE_VERSIONS_PROPERTY = "use-versions";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   *
   */
  public final String getBucket() {
    return properties.get(BUCKET_PROPERTY);
  }

  /**
   *
   */
  public final ListS3 setBucket(final String bucket) {
    properties.put(BUCKET_PROPERTY, bucket);
    return this;
  }

  /**
   *
   */
  public final ListS3 removeBucket() {
    properties.remove(BUCKET_PROPERTY);
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
  public final ListS3 setRegion(final String region) {
    properties.put(REGION_PROPERTY, region);
    return this;
  }

  /**
   *
   */
  public final ListS3 removeRegion() {
    properties.remove(REGION_PROPERTY);
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
  public final ListS3 setAccessKey(final String accessKey) {
    properties.put(ACCESS_KEY_PROPERTY, accessKey);
    return this;
  }

  /**
   *
   */
  public final ListS3 removeAccessKey() {
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
  public final ListS3 setSecretKey(final String secretKey) {
    properties.put(SECRET_KEY_PROPERTY, secretKey);
    return this;
  }

  /**
   *
   */
  public final ListS3 removeSecretKey() {
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
  public final ListS3 setCredentialsFile(final String credentialsFile) {
    properties.put(CREDENTIALS_FILE_PROPERTY, credentialsFile);
    return this;
  }

  /**
   * Path to a file containing AWS access key and secret key in properties file format.
   */
  public final ListS3 removeCredentialsFile() {
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
  public final ListS3 setAwsCredentialsProviderService(final String awsCredentialsProviderService) {
    properties.put(AWS_CREDENTIALS_PROVIDER_SERVICE_PROPERTY, awsCredentialsProviderService);
    return this;
  }

  /**
   * The Controller Service that is used to obtain aws credentials provider
   */
  public final ListS3 removeAwsCredentialsProviderService() {
    properties.remove(AWS_CREDENTIALS_PROVIDER_SERVICE_PROPERTY);
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
  public final ListS3 setCommunicationsTimeout(final String communicationsTimeout) {
    properties.put(COMMUNICATIONS_TIMEOUT_PROPERTY, communicationsTimeout);
    return this;
  }

  /**
   *
   */
  public final ListS3 removeCommunicationsTimeout() {
    properties.remove(COMMUNICATIONS_TIMEOUT_PROPERTY);
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
  public final ListS3 setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * Specifies an optional SSL Context Service that, if provided, will be used to create connections
   */
  public final ListS3 removeSslContextService() {
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
  public final ListS3 setEndpointOverrideUrl(final String endpointOverrideUrl) {
    properties.put(ENDPOINT_OVERRIDE_URL_PROPERTY, endpointOverrideUrl);
    return this;
  }

  /**
   * Endpoint URL to use instead of the AWS default including scheme, host, port, and path. The AWS libraries select an endpoint URL based on the AWS region, but this property overrides the selected endpoint URL, allowing use with other S3-compatible endpoints.
   */
  public final ListS3 removeEndpointOverrideUrl() {
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
  public final ListS3 setSignerOverride(final String signerOverride) {
    properties.put(SIGNER_OVERRIDE_PROPERTY, signerOverride);
    return this;
  }

  /**
   * The AWS libraries use the default signer but this property allows you to specify a custom signer to support older S3-compatible services.
   */
  public final ListS3 removeSignerOverride() {
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
  public final ListS3 setProxyHost(final String proxyHost) {
    properties.put(PROXY_HOST_PROPERTY, proxyHost);
    return this;
  }

  /**
   * Proxy host name or IP
   */
  public final ListS3 removeProxyHost() {
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
  public final ListS3 setProxyHostPort(final String proxyHostPort) {
    properties.put(PROXY_HOST_PORT_PROPERTY, proxyHostPort);
    return this;
  }

  /**
   * Proxy host port
   */
  public final ListS3 removeProxyHostPort() {
    properties.remove(PROXY_HOST_PORT_PROPERTY);
    return this;
  }

  /**
   * The string used to delimit directories within the bucket. Please consult the AWS documentation for the correct use of this field.
   */
  public final String getDelimiter() {
    return properties.get(DELIMITER_PROPERTY);
  }

  /**
   * The string used to delimit directories within the bucket. Please consult the AWS documentation for the correct use of this field.
   */
  public final ListS3 setDelimiter(final String delimiter) {
    properties.put(DELIMITER_PROPERTY, delimiter);
    return this;
  }

  /**
   * The string used to delimit directories within the bucket. Please consult the AWS documentation for the correct use of this field.
   */
  public final ListS3 removeDelimiter() {
    properties.remove(DELIMITER_PROPERTY);
    return this;
  }

  /**
   * The prefix used to filter the object list. In most cases, it should end with a forward slash ('/').
   */
  public final String getPrefix() {
    return properties.get(PREFIX_PROPERTY);
  }

  /**
   * The prefix used to filter the object list. In most cases, it should end with a forward slash ('/').
   */
  public final ListS3 setPrefix(final String prefix) {
    properties.put(PREFIX_PROPERTY, prefix);
    return this;
  }

  /**
   * The prefix used to filter the object list. In most cases, it should end with a forward slash ('/').
   */
  public final ListS3 removePrefix() {
    properties.remove(PREFIX_PROPERTY);
    return this;
  }

  /**
   * Specifies whether to use S3 versions, if applicable.  If false, only the latest version of each object will be returned.
   */
  public final String getUseVersions() {
    return properties.get(USE_VERSIONS_PROPERTY);
  }

  /**
   * Specifies whether to use S3 versions, if applicable.  If false, only the latest version of each object will be returned.
   */
  public final ListS3 setUseVersions(final String useVersions) {
    properties.put(USE_VERSIONS_PROPERTY, useVersions);
    return this;
  }

  /**
   * Specifies whether to use S3 versions, if applicable.  If false, only the latest version of each object will be returned.
   */
  public final ListS3 removeUseVersions() {
    properties.remove(USE_VERSIONS_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ListS3 setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ListS3 removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ListS3, ListS3> configurator) {
    return configurator.apply(new ListS3()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListS3.class) final Closure<ListS3> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.aws.s3.ListS3> code = closure.rehydrate(c, com.tibtech.nifi.processors.aws.s3.ListS3.class, com.tibtech.nifi.processors.aws.s3.ListS3.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
