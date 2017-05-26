package com.tibtech.nifi.processors.aws.credentials.provider.service;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class AWSCredentialsProviderControllerService {
  /**
   * If true, uses the Default Credential chain, including EC2 instance profiles or roles, environment variables, default user credentials, etc.
   */
  public static final String DEFAULT_CREDENTIALS_PROPERTY = "default-credentials";

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
   * The AWS profile name for credentials from the profile configuration file.
   */
  public static final String PROFILE_NAME_PROPERTY = "profile-name";

  /**
   * If true, uses Anonymous credentials
   */
  public static final String ANONYMOUS_CREDENTIALS_PROPERTY = "anonymous-credentials";

  /**
   * The AWS Role ARN for cross account access. This is used in conjunction with role name and session timeout
   */
  public static final String ASSUME_ROLE_ARN_PROPERTY = "Assume Role ARN";

  /**
   * The AWS Role Name for cross account access. This is used in conjunction with role ARN and session time out
   */
  public static final String ASSUME_ROLE_SESSION_NAME_PROPERTY = "Assume Role Session Name";

  /**
   * Session time for role based session (between 900 and 3600 seconds). This is used in conjunction with role ARN and name
   */
  public static final String SESSION_TIME_PROPERTY = "Session Time";

  /**
   * External ID for cross-account access. This is used in conjunction with role arn, role name, and optional session time out
   */
  public static final String ASSUME_ROLE_EXTERNAL_ID_PROPERTY = "assume-role-external-id";

  /**
   * Proxy host for cross-account access, if needed within your environment. This will configure a proxy to request for temporary access keys into another AWS account
   */
  public static final String ASSUME_ROLE_PROXY_HOST_PROPERTY = "assume-role-proxy-host";

  /**
   * Proxy pot for cross-account access, if needed within your environment. This will configure a proxy to request for temporary access keys into another AWS account
   */
  public static final String ASSUME_ROLE_PROXY_PORT_PROPERTY = "assume-role-proxy-port";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * If true, uses the Default Credential chain, including EC2 instance profiles or roles, environment variables, default user credentials, etc.
   */
  public final String getDefaultCredentials() {
    return properties.get(DEFAULT_CREDENTIALS_PROPERTY);
  }

  /**
   * If true, uses the Default Credential chain, including EC2 instance profiles or roles, environment variables, default user credentials, etc.
   */
  public final AWSCredentialsProviderControllerService setDefaultCredentials(final String defaultCredentials) {
    properties.put(DEFAULT_CREDENTIALS_PROPERTY, defaultCredentials);
    return this;
  }

  /**
   * If true, uses the Default Credential chain, including EC2 instance profiles or roles, environment variables, default user credentials, etc.
   */
  public final AWSCredentialsProviderControllerService removeDefaultCredentials() {
    properties.remove(DEFAULT_CREDENTIALS_PROPERTY);
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
  public final AWSCredentialsProviderControllerService setAccessKey(final String accessKey) {
    properties.put(ACCESS_KEY_PROPERTY, accessKey);
    return this;
  }

  /**
   *
   */
  public final AWSCredentialsProviderControllerService removeAccessKey() {
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
  public final AWSCredentialsProviderControllerService setSecretKey(final String secretKey) {
    properties.put(SECRET_KEY_PROPERTY, secretKey);
    return this;
  }

  /**
   *
   */
  public final AWSCredentialsProviderControllerService removeSecretKey() {
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
  public final AWSCredentialsProviderControllerService setCredentialsFile(final String credentialsFile) {
    properties.put(CREDENTIALS_FILE_PROPERTY, credentialsFile);
    return this;
  }

  /**
   * Path to a file containing AWS access key and secret key in properties file format.
   */
  public final AWSCredentialsProviderControllerService removeCredentialsFile() {
    properties.remove(CREDENTIALS_FILE_PROPERTY);
    return this;
  }

  /**
   * The AWS profile name for credentials from the profile configuration file.
   */
  public final String getProfileName() {
    return properties.get(PROFILE_NAME_PROPERTY);
  }

  /**
   * The AWS profile name for credentials from the profile configuration file.
   */
  public final AWSCredentialsProviderControllerService setProfileName(final String profileName) {
    properties.put(PROFILE_NAME_PROPERTY, profileName);
    return this;
  }

  /**
   * The AWS profile name for credentials from the profile configuration file.
   */
  public final AWSCredentialsProviderControllerService removeProfileName() {
    properties.remove(PROFILE_NAME_PROPERTY);
    return this;
  }

  /**
   * If true, uses Anonymous credentials
   */
  public final String getAnonymousCredentials() {
    return properties.get(ANONYMOUS_CREDENTIALS_PROPERTY);
  }

  /**
   * If true, uses Anonymous credentials
   */
  public final AWSCredentialsProviderControllerService setAnonymousCredentials(final String anonymousCredentials) {
    properties.put(ANONYMOUS_CREDENTIALS_PROPERTY, anonymousCredentials);
    return this;
  }

  /**
   * If true, uses Anonymous credentials
   */
  public final AWSCredentialsProviderControllerService removeAnonymousCredentials() {
    properties.remove(ANONYMOUS_CREDENTIALS_PROPERTY);
    return this;
  }

  /**
   * The AWS Role ARN for cross account access. This is used in conjunction with role name and session timeout
   */
  public final String getAssumeRoleArn() {
    return properties.get(ASSUME_ROLE_ARN_PROPERTY);
  }

  /**
   * The AWS Role ARN for cross account access. This is used in conjunction with role name and session timeout
   */
  public final AWSCredentialsProviderControllerService setAssumeRoleArn(final String assumeRoleArn) {
    properties.put(ASSUME_ROLE_ARN_PROPERTY, assumeRoleArn);
    return this;
  }

  /**
   * The AWS Role ARN for cross account access. This is used in conjunction with role name and session timeout
   */
  public final AWSCredentialsProviderControllerService removeAssumeRoleArn() {
    properties.remove(ASSUME_ROLE_ARN_PROPERTY);
    return this;
  }

  /**
   * The AWS Role Name for cross account access. This is used in conjunction with role ARN and session time out
   */
  public final String getAssumeRoleSessionName() {
    return properties.get(ASSUME_ROLE_SESSION_NAME_PROPERTY);
  }

  /**
   * The AWS Role Name for cross account access. This is used in conjunction with role ARN and session time out
   */
  public final AWSCredentialsProviderControllerService setAssumeRoleSessionName(final String assumeRoleSessionName) {
    properties.put(ASSUME_ROLE_SESSION_NAME_PROPERTY, assumeRoleSessionName);
    return this;
  }

  /**
   * The AWS Role Name for cross account access. This is used in conjunction with role ARN and session time out
   */
  public final AWSCredentialsProviderControllerService removeAssumeRoleSessionName() {
    properties.remove(ASSUME_ROLE_SESSION_NAME_PROPERTY);
    return this;
  }

  /**
   * Session time for role based session (between 900 and 3600 seconds). This is used in conjunction with role ARN and name
   */
  public final String getSessionTime() {
    return properties.get(SESSION_TIME_PROPERTY);
  }

  /**
   * Session time for role based session (between 900 and 3600 seconds). This is used in conjunction with role ARN and name
   */
  public final AWSCredentialsProviderControllerService setSessionTime(final String sessionTime) {
    properties.put(SESSION_TIME_PROPERTY, sessionTime);
    return this;
  }

  /**
   * Session time for role based session (between 900 and 3600 seconds). This is used in conjunction with role ARN and name
   */
  public final AWSCredentialsProviderControllerService removeSessionTime() {
    properties.remove(SESSION_TIME_PROPERTY);
    return this;
  }

  /**
   * External ID for cross-account access. This is used in conjunction with role arn, role name, and optional session time out
   */
  public final String getAssumeRoleExternalId() {
    return properties.get(ASSUME_ROLE_EXTERNAL_ID_PROPERTY);
  }

  /**
   * External ID for cross-account access. This is used in conjunction with role arn, role name, and optional session time out
   */
  public final AWSCredentialsProviderControllerService setAssumeRoleExternalId(final String assumeRoleExternalId) {
    properties.put(ASSUME_ROLE_EXTERNAL_ID_PROPERTY, assumeRoleExternalId);
    return this;
  }

  /**
   * External ID for cross-account access. This is used in conjunction with role arn, role name, and optional session time out
   */
  public final AWSCredentialsProviderControllerService removeAssumeRoleExternalId() {
    properties.remove(ASSUME_ROLE_EXTERNAL_ID_PROPERTY);
    return this;
  }

  /**
   * Proxy host for cross-account access, if needed within your environment. This will configure a proxy to request for temporary access keys into another AWS account
   */
  public final String getAssumeRoleProxyHost() {
    return properties.get(ASSUME_ROLE_PROXY_HOST_PROPERTY);
  }

  /**
   * Proxy host for cross-account access, if needed within your environment. This will configure a proxy to request for temporary access keys into another AWS account
   */
  public final AWSCredentialsProviderControllerService setAssumeRoleProxyHost(final String assumeRoleProxyHost) {
    properties.put(ASSUME_ROLE_PROXY_HOST_PROPERTY, assumeRoleProxyHost);
    return this;
  }

  /**
   * Proxy host for cross-account access, if needed within your environment. This will configure a proxy to request for temporary access keys into another AWS account
   */
  public final AWSCredentialsProviderControllerService removeAssumeRoleProxyHost() {
    properties.remove(ASSUME_ROLE_PROXY_HOST_PROPERTY);
    return this;
  }

  /**
   * Proxy pot for cross-account access, if needed within your environment. This will configure a proxy to request for temporary access keys into another AWS account
   */
  public final String getAssumeRoleProxyPort() {
    return properties.get(ASSUME_ROLE_PROXY_PORT_PROPERTY);
  }

  /**
   * Proxy pot for cross-account access, if needed within your environment. This will configure a proxy to request for temporary access keys into another AWS account
   */
  public final AWSCredentialsProviderControllerService setAssumeRoleProxyPort(final String assumeRoleProxyPort) {
    properties.put(ASSUME_ROLE_PROXY_PORT_PROPERTY, assumeRoleProxyPort);
    return this;
  }

  /**
   * Proxy pot for cross-account access, if needed within your environment. This will configure a proxy to request for temporary access keys into another AWS account
   */
  public final AWSCredentialsProviderControllerService removeAssumeRoleProxyPort() {
    properties.remove(ASSUME_ROLE_PROXY_PORT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final AWSCredentialsProviderControllerService setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final AWSCredentialsProviderControllerService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<AWSCredentialsProviderControllerService, AWSCredentialsProviderControllerService> configurator) {
    return configurator.apply(new AWSCredentialsProviderControllerService()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = AWSCredentialsProviderControllerService.class) final Closure<AWSCredentialsProviderControllerService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.aws.credentials.provider.service.AWSCredentialsProviderControllerService> code = closure.rehydrate(c, com.tibtech.nifi.processors.aws.credentials.provider.service.AWSCredentialsProviderControllerService.class, com.tibtech.nifi.processors.aws.credentials.provider.service.AWSCredentialsProviderControllerService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
