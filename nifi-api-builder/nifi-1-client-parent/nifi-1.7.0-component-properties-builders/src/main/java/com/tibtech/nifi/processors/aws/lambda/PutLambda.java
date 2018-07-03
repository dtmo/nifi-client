package com.tibtech.nifi.processors.aws.lambda;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutLambda {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.aws.lambda.PutLambda";

  /**
   * The Lambda Function Name
   */
  public static final String AMAZON_LAMBDA_NAME_PROPERTY = "Amazon Lambda Name";

  /**
   * The Lambda Function Version
   */
  public static final String AMAZON_LAMBDA_QUALIFIER_VERSION_PROPERTY = "Amazon Lambda Qualifier (version)";

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

  public PutLambda() {
    this.properties = new HashMap<>();
  }

  public PutLambda(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The Lambda Function Name
   */
  public final String getAmazonLambdaName() {
    return properties.get(AMAZON_LAMBDA_NAME_PROPERTY);
  }

  /**
   * The Lambda Function Name
   */
  public final PutLambda setAmazonLambdaName(final String amazonLambdaName) {
    properties.put(AMAZON_LAMBDA_NAME_PROPERTY, amazonLambdaName);
    return this;
  }

  /**
   * The Lambda Function Name
   */
  public final PutLambda removeAmazonLambdaName() {
    properties.remove(AMAZON_LAMBDA_NAME_PROPERTY);
    return this;
  }

  /**
   * The Lambda Function Version
   */
  public final String getAmazonLambdaQualifierVersion() {
    return properties.get(AMAZON_LAMBDA_QUALIFIER_VERSION_PROPERTY);
  }

  /**
   * The Lambda Function Version
   */
  public final PutLambda setAmazonLambdaQualifierVersion(
      final String amazonLambdaQualifierVersion) {
    properties.put(AMAZON_LAMBDA_QUALIFIER_VERSION_PROPERTY, amazonLambdaQualifierVersion);
    return this;
  }

  /**
   * The Lambda Function Version
   */
  public final PutLambda removeAmazonLambdaQualifierVersion() {
    properties.remove(AMAZON_LAMBDA_QUALIFIER_VERSION_PROPERTY);
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
  public final PutLambda setRegion(final String region) {
    properties.put(REGION_PROPERTY, region);
    return this;
  }

  /**
   *
   */
  public final PutLambda removeRegion() {
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
  public final PutLambda setAccessKey(final String accessKey) {
    properties.put(ACCESS_KEY_PROPERTY, accessKey);
    return this;
  }

  /**
   *
   */
  public final PutLambda removeAccessKey() {
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
  public final PutLambda setSecretKey(final String secretKey) {
    properties.put(SECRET_KEY_PROPERTY, secretKey);
    return this;
  }

  /**
   *
   */
  public final PutLambda removeSecretKey() {
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
  public final PutLambda setCredentialsFile(final String credentialsFile) {
    properties.put(CREDENTIALS_FILE_PROPERTY, credentialsFile);
    return this;
  }

  /**
   * Path to a file containing AWS access key and secret key in properties file format.
   */
  public final PutLambda removeCredentialsFile() {
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
  public final PutLambda setAwsCredentialsProviderService(
      final String awsCredentialsProviderService) {
    properties.put(AWS_CREDENTIALS_PROVIDER_SERVICE_PROPERTY, awsCredentialsProviderService);
    return this;
  }

  /**
   * The Controller Service that is used to obtain aws credentials provider
   */
  public final PutLambda removeAwsCredentialsProviderService() {
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
  public final PutLambda setCommunicationsTimeout(final String communicationsTimeout) {
    properties.put(COMMUNICATIONS_TIMEOUT_PROPERTY, communicationsTimeout);
    return this;
  }

  /**
   *
   */
  public final PutLambda removeCommunicationsTimeout() {
    properties.remove(COMMUNICATIONS_TIMEOUT_PROPERTY);
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
  public final PutLambda setProxyConfigurationService(final String proxyConfigurationService) {
    properties.put(PROXY_CONFIGURATION_SERVICE_PROPERTY, proxyConfigurationService);
    return this;
  }

  /**
   * Specifies the Proxy Configuration Controller Service to proxy network requests. If set, it supersedes proxy settings configured per component. Supported proxies: HTTP + AuthN
   */
  public final PutLambda removeProxyConfigurationService() {
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
  public final PutLambda setProxyHost(final String proxyHost) {
    properties.put(PROXY_HOST_PROPERTY, proxyHost);
    return this;
  }

  /**
   * Proxy host name or IP
   */
  public final PutLambda removeProxyHost() {
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
  public final PutLambda setProxyHostPort(final String proxyHostPort) {
    properties.put(PROXY_HOST_PORT_PROPERTY, proxyHostPort);
    return this;
  }

  /**
   * Proxy host port
   */
  public final PutLambda removeProxyHostPort() {
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
  public final PutLambda setProxyUserName(final String proxyUserName) {
    properties.put(PROXY_USER_NAME_PROPERTY, proxyUserName);
    return this;
  }

  /**
   * Proxy username
   */
  public final PutLambda removeProxyUserName() {
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
  public final PutLambda setProxyUserPassword(final String proxyUserPassword) {
    properties.put(PROXY_USER_PASSWORD_PROPERTY, proxyUserPassword);
    return this;
  }

  /**
   * Proxy password
   */
  public final PutLambda removeProxyUserPassword() {
    properties.remove(PROXY_USER_PASSWORD_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutLambda setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutLambda removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutLambda, PutLambda> configurator) {
    return configurator.apply(new PutLambda()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutLambda.class) final Closure<PutLambda> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.aws.lambda.PutLambda> code = closure.rehydrate(c, com.tibtech.nifi.processors.aws.lambda.PutLambda.class, com.tibtech.nifi.processors.aws.lambda.PutLambda.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutLambda, PutLambda> configurator) {
    return configurator.apply(new PutLambda(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutLambda.class) final Closure<PutLambda> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.aws.lambda.PutLambda> code = closure.rehydrate(c, com.tibtech.nifi.processors.aws.lambda.PutLambda.class, com.tibtech.nifi.processors.aws.lambda.PutLambda.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
