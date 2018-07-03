package com.tibtech.nifi.processors.aws.sns;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutSNS {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.aws.sns.PutSNS";

  /**
   * The name of the resource to which notifications should be published
   */
  public static final String AMAZON_RESOURCE_NAME_ARN_PROPERTY = "Amazon Resource Name (ARN)";

  /**
   * The type of Amazon Resource Name that is being used.
   */
  public static final String ARN_TYPE_PROPERTY = "ARN Type";

  /**
   * The optional subject to use for any subscribers that are subscribed via E-mail
   */
  public static final String E_MAIL_SUBJECT_PROPERTY = "E-mail Subject";

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
   * If true, the contents of the FlowFile must be JSON with a top-level element named 'default'. Additional elements can be used to send different messages to different protocols. See the Amazon SNS Documentation for more information.
   */
  public static final String USE_JSON_STRUCTURE_PROPERTY = "Use JSON Structure";

  /**
   * The character set in which the FlowFile's content is encoded
   */
  public static final String CHARACTER_SET_PROPERTY = "Character Set";

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

  public PutSNS() {
    this.properties = new HashMap<>();
  }

  public PutSNS(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The name of the resource to which notifications should be published
   */
  public final String getAmazonResourceNameArn() {
    return properties.get(AMAZON_RESOURCE_NAME_ARN_PROPERTY);
  }

  /**
   * The name of the resource to which notifications should be published
   */
  public final PutSNS setAmazonResourceNameArn(final String amazonResourceNameArn) {
    properties.put(AMAZON_RESOURCE_NAME_ARN_PROPERTY, amazonResourceNameArn);
    return this;
  }

  /**
   * The name of the resource to which notifications should be published
   */
  public final PutSNS removeAmazonResourceNameArn() {
    properties.remove(AMAZON_RESOURCE_NAME_ARN_PROPERTY);
    return this;
  }

  /**
   * The type of Amazon Resource Name that is being used.
   */
  public final String getArnType() {
    return properties.get(ARN_TYPE_PROPERTY);
  }

  /**
   * The type of Amazon Resource Name that is being used.
   */
  public final PutSNS setArnType(final String arnType) {
    properties.put(ARN_TYPE_PROPERTY, arnType);
    return this;
  }

  /**
   * The type of Amazon Resource Name that is being used.
   */
  public final PutSNS removeArnType() {
    properties.remove(ARN_TYPE_PROPERTY);
    return this;
  }

  /**
   * The optional subject to use for any subscribers that are subscribed via E-mail
   */
  public final String getEMailSubject() {
    return properties.get(E_MAIL_SUBJECT_PROPERTY);
  }

  /**
   * The optional subject to use for any subscribers that are subscribed via E-mail
   */
  public final PutSNS setEMailSubject(final String eMailSubject) {
    properties.put(E_MAIL_SUBJECT_PROPERTY, eMailSubject);
    return this;
  }

  /**
   * The optional subject to use for any subscribers that are subscribed via E-mail
   */
  public final PutSNS removeEMailSubject() {
    properties.remove(E_MAIL_SUBJECT_PROPERTY);
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
  public final PutSNS setRegion(final String region) {
    properties.put(REGION_PROPERTY, region);
    return this;
  }

  /**
   *
   */
  public final PutSNS removeRegion() {
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
  public final PutSNS setAccessKey(final String accessKey) {
    properties.put(ACCESS_KEY_PROPERTY, accessKey);
    return this;
  }

  /**
   *
   */
  public final PutSNS removeAccessKey() {
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
  public final PutSNS setSecretKey(final String secretKey) {
    properties.put(SECRET_KEY_PROPERTY, secretKey);
    return this;
  }

  /**
   *
   */
  public final PutSNS removeSecretKey() {
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
  public final PutSNS setCredentialsFile(final String credentialsFile) {
    properties.put(CREDENTIALS_FILE_PROPERTY, credentialsFile);
    return this;
  }

  /**
   * Path to a file containing AWS access key and secret key in properties file format.
   */
  public final PutSNS removeCredentialsFile() {
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
  public final PutSNS setAwsCredentialsProviderService(final String awsCredentialsProviderService) {
    properties.put(AWS_CREDENTIALS_PROVIDER_SERVICE_PROPERTY, awsCredentialsProviderService);
    return this;
  }

  /**
   * The Controller Service that is used to obtain aws credentials provider
   */
  public final PutSNS removeAwsCredentialsProviderService() {
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
  public final PutSNS setCommunicationsTimeout(final String communicationsTimeout) {
    properties.put(COMMUNICATIONS_TIMEOUT_PROPERTY, communicationsTimeout);
    return this;
  }

  /**
   *
   */
  public final PutSNS removeCommunicationsTimeout() {
    properties.remove(COMMUNICATIONS_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * If true, the contents of the FlowFile must be JSON with a top-level element named 'default'. Additional elements can be used to send different messages to different protocols. See the Amazon SNS Documentation for more information.
   */
  public final String getUseJsonStructure() {
    return properties.get(USE_JSON_STRUCTURE_PROPERTY);
  }

  /**
   * If true, the contents of the FlowFile must be JSON with a top-level element named 'default'. Additional elements can be used to send different messages to different protocols. See the Amazon SNS Documentation for more information.
   */
  public final PutSNS setUseJsonStructure(final String useJsonStructure) {
    properties.put(USE_JSON_STRUCTURE_PROPERTY, useJsonStructure);
    return this;
  }

  /**
   * If true, the contents of the FlowFile must be JSON with a top-level element named 'default'. Additional elements can be used to send different messages to different protocols. See the Amazon SNS Documentation for more information.
   */
  public final PutSNS removeUseJsonStructure() {
    properties.remove(USE_JSON_STRUCTURE_PROPERTY);
    return this;
  }

  /**
   * The character set in which the FlowFile's content is encoded
   */
  public final String getCharacterSet() {
    return properties.get(CHARACTER_SET_PROPERTY);
  }

  /**
   * The character set in which the FlowFile's content is encoded
   */
  public final PutSNS setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * The character set in which the FlowFile's content is encoded
   */
  public final PutSNS removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
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
  public final PutSNS setProxyHost(final String proxyHost) {
    properties.put(PROXY_HOST_PROPERTY, proxyHost);
    return this;
  }

  /**
   * Proxy host name or IP
   */
  public final PutSNS removeProxyHost() {
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
  public final PutSNS setProxyHostPort(final String proxyHostPort) {
    properties.put(PROXY_HOST_PORT_PROPERTY, proxyHostPort);
    return this;
  }

  /**
   * Proxy host port
   */
  public final PutSNS removeProxyHostPort() {
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
  public final PutSNS setProxyUserName(final String proxyUserName) {
    properties.put(PROXY_USER_NAME_PROPERTY, proxyUserName);
    return this;
  }

  /**
   * Proxy username
   */
  public final PutSNS removeProxyUserName() {
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
  public final PutSNS setProxyUserPassword(final String proxyUserPassword) {
    properties.put(PROXY_USER_PASSWORD_PROPERTY, proxyUserPassword);
    return this;
  }

  /**
   * Proxy password
   */
  public final PutSNS removeProxyUserPassword() {
    properties.remove(PROXY_USER_PASSWORD_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutSNS setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutSNS removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutSNS, PutSNS> configurator) {
    return configurator.apply(new PutSNS()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutSNS.class) final Closure<PutSNS> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.aws.sns.PutSNS> code = closure.rehydrate(c, com.tibtech.nifi.processors.aws.sns.PutSNS.class, com.tibtech.nifi.processors.aws.sns.PutSNS.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutSNS, PutSNS> configurator) {
    return configurator.apply(new PutSNS(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutSNS.class) final Closure<PutSNS> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.aws.sns.PutSNS> code = closure.rehydrate(c, com.tibtech.nifi.processors.aws.sns.PutSNS.class, com.tibtech.nifi.processors.aws.sns.PutSNS.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
