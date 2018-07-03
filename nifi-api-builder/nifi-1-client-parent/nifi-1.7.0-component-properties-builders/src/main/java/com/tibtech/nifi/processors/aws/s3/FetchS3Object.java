package com.tibtech.nifi.processors.aws.s3;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class FetchS3Object {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.aws.s3.FetchS3Object";

  /**
   *
   */
  public static final String BUCKET_PROPERTY = "Bucket";

  /**
   *
   */
  public static final String OBJECT_KEY_PROPERTY = "Object Key";

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
   * The Version of the Object to download
   */
  public static final String VERSION_PROPERTY = "Version";

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
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN
   */
  public static final String PROXY_CONFIGURATION_SERVICE_PROPERTY = "proxy-configuration-service";

  /**
   * Proxy host name or IP
   */
  public static final String PROXY_HOST_PROPERTY = "Proxy Host";

  /**
   * Proxy host port
   */
  public static final String PROXY_HOST_PORT_PROPERTY = "Proxy Host Port";

  /**
   * Proxy username
   */
  public static final String PROXY_USER_NAME_PROPERTY = "proxy-user-name";

  /**
   * Proxy password
   */
  public static final String PROXY_USER_PASSWORD_PROPERTY = "proxy-user-password";

  private final Map<String, String> properties;

  public FetchS3Object() {
    this.properties = new HashMap<>();
  }

  public FetchS3Object(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
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
  public final FetchS3Object setBucket(final String bucket) {
    properties.put(BUCKET_PROPERTY, bucket);
    return this;
  }

  /**
   *
   */
  public final FetchS3Object removeBucket() {
    properties.remove(BUCKET_PROPERTY);
    return this;
  }

  /**
   *
   */
  public final String getObjectKey() {
    return properties.get(OBJECT_KEY_PROPERTY);
  }

  /**
   *
   */
  public final FetchS3Object setObjectKey(final String objectKey) {
    properties.put(OBJECT_KEY_PROPERTY, objectKey);
    return this;
  }

  /**
   *
   */
  public final FetchS3Object removeObjectKey() {
    properties.remove(OBJECT_KEY_PROPERTY);
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
  public final FetchS3Object setRegion(final String region) {
    properties.put(REGION_PROPERTY, region);
    return this;
  }

  /**
   *
   */
  public final FetchS3Object removeRegion() {
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
  public final FetchS3Object setAccessKey(final String accessKey) {
    properties.put(ACCESS_KEY_PROPERTY, accessKey);
    return this;
  }

  /**
   *
   */
  public final FetchS3Object removeAccessKey() {
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
  public final FetchS3Object setSecretKey(final String secretKey) {
    properties.put(SECRET_KEY_PROPERTY, secretKey);
    return this;
  }

  /**
   *
   */
  public final FetchS3Object removeSecretKey() {
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
  public final FetchS3Object setCredentialsFile(final String credentialsFile) {
    properties.put(CREDENTIALS_FILE_PROPERTY, credentialsFile);
    return this;
  }

  /**
   * Path to a file containing AWS access key and secret key in properties file format.
   */
  public final FetchS3Object removeCredentialsFile() {
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
  public final FetchS3Object setAwsCredentialsProviderService(
      final String awsCredentialsProviderService) {
    properties.put(AWS_CREDENTIALS_PROVIDER_SERVICE_PROPERTY, awsCredentialsProviderService);
    return this;
  }

  /**
   * The Controller Service that is used to obtain aws credentials provider
   */
  public final FetchS3Object removeAwsCredentialsProviderService() {
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
  public final FetchS3Object setCommunicationsTimeout(final String communicationsTimeout) {
    properties.put(COMMUNICATIONS_TIMEOUT_PROPERTY, communicationsTimeout);
    return this;
  }

  /**
   *
   */
  public final FetchS3Object removeCommunicationsTimeout() {
    properties.remove(COMMUNICATIONS_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The Version of the Object to download
   */
  public final String getVersion() {
    return properties.get(VERSION_PROPERTY);
  }

  /**
   * The Version of the Object to download
   */
  public final FetchS3Object setVersion(final String version) {
    properties.put(VERSION_PROPERTY, version);
    return this;
  }

  /**
   * The Version of the Object to download
   */
  public final FetchS3Object removeVersion() {
    properties.remove(VERSION_PROPERTY);
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
  public final FetchS3Object setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * Specifies an optional SSL Context Service that, if provided, will be used to create connections
   */
  public final FetchS3Object removeSslContextService() {
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
  public final FetchS3Object setEndpointOverrideUrl(final String endpointOverrideUrl) {
    properties.put(ENDPOINT_OVERRIDE_URL_PROPERTY, endpointOverrideUrl);
    return this;
  }

  /**
   * Endpoint URL to use instead of the AWS default including scheme, host, port, and path. The AWS libraries select an endpoint URL based on the AWS region, but this property overrides the selected endpoint URL, allowing use with other S3-compatible endpoints.
   */
  public final FetchS3Object removeEndpointOverrideUrl() {
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
  public final FetchS3Object setSignerOverride(final String signerOverride) {
    properties.put(SIGNER_OVERRIDE_PROPERTY, signerOverride);
    return this;
  }

  /**
   * The AWS libraries use the default signer but this property allows you to specify a custom signer to support older S3-compatible services.
   */
  public final FetchS3Object removeSignerOverride() {
    properties.remove(SIGNER_OVERRIDE_PROPERTY);
    return this;
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN
   */
  public final String getProxyConfigurationService() {
    return properties.get(PROXY_CONFIGURATION_SERVICE_PROPERTY);
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN
   */
  public final FetchS3Object setProxyConfigurationService(final String proxyConfigurationService) {
    properties.put(PROXY_CONFIGURATION_SERVICE_PROPERTY, proxyConfigurationService);
    return this;
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN
   */
  public final FetchS3Object removeProxyConfigurationService() {
    properties.remove(PROXY_CONFIGURATION_SERVICE_PROPERTY);
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
  public final FetchS3Object setProxyHost(final String proxyHost) {
    properties.put(PROXY_HOST_PROPERTY, proxyHost);
    return this;
  }

  /**
   * Proxy host name or IP
   */
  public final FetchS3Object removeProxyHost() {
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
  public final FetchS3Object setProxyHostPort(final String proxyHostPort) {
    properties.put(PROXY_HOST_PORT_PROPERTY, proxyHostPort);
    return this;
  }

  /**
   * Proxy host port
   */
  public final FetchS3Object removeProxyHostPort() {
    properties.remove(PROXY_HOST_PORT_PROPERTY);
    return this;
  }

  /**
   * Proxy username
   */
  public final String getProxyUserName() {
    return properties.get(PROXY_USER_NAME_PROPERTY);
  }

  /**
   * Proxy username
   */
  public final FetchS3Object setProxyUserName(final String proxyUserName) {
    properties.put(PROXY_USER_NAME_PROPERTY, proxyUserName);
    return this;
  }

  /**
   * Proxy username
   */
  public final FetchS3Object removeProxyUserName() {
    properties.remove(PROXY_USER_NAME_PROPERTY);
    return this;
  }

  /**
   * Proxy password
   */
  public final String getProxyUserPassword() {
    return properties.get(PROXY_USER_PASSWORD_PROPERTY);
  }

  /**
   * Proxy password
   */
  public final FetchS3Object setProxyUserPassword(final String proxyUserPassword) {
    properties.put(PROXY_USER_PASSWORD_PROPERTY, proxyUserPassword);
    return this;
  }

  /**
   * Proxy password
   */
  public final FetchS3Object removeProxyUserPassword() {
    properties.remove(PROXY_USER_PASSWORD_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final FetchS3Object setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final FetchS3Object removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<FetchS3Object, FetchS3Object> configurator) {
    return configurator.apply(new FetchS3Object()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FetchS3Object.class) final Closure<FetchS3Object> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.aws.s3.FetchS3Object> code = closure.rehydrate(c, com.tibtech.nifi.processors.aws.s3.FetchS3Object.class, com.tibtech.nifi.processors.aws.s3.FetchS3Object.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<FetchS3Object, FetchS3Object> configurator) {
    return configurator.apply(new FetchS3Object(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FetchS3Object.class) final Closure<FetchS3Object> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.aws.s3.FetchS3Object> code = closure.rehydrate(c, com.tibtech.nifi.processors.aws.s3.FetchS3Object.class, com.tibtech.nifi.processors.aws.s3.FetchS3Object.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
