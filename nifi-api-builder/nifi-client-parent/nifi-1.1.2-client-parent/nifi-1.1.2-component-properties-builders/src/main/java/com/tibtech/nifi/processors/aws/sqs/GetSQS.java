package com.tibtech.nifi.processors.aws.sqs;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GetSQS {
  /**
   * The URL of the queue to act upon
   */
  public static final String QUEUE_URL_PROPERTY = "Queue URL";

  /**
   * Specifies whether the messages should be automatically deleted by the processors once they have been received.
   */
  public static final String AUTO_DELETE_MESSAGES_PROPERTY = "Auto Delete Messages";

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
   * The maximum number of messages to send in a single network request
   */
  public static final String BATCH_SIZE_PROPERTY = "Batch Size";

  /**
   *
   */
  public static final String COMMUNICATIONS_TIMEOUT_PROPERTY = "Communications Timeout";

  /**
   * The Character Set that should be used to encode the textual content of the SQS message
   */
  public static final String CHARACTER_SET_PROPERTY = "Character Set";

  /**
   * The amount of time after a message is received but not deleted that the message is hidden from other consumers
   */
  public static final String VISIBILITY_TIMEOUT_PROPERTY = "Visibility Timeout";

  /**
   * The maximum amount of time to wait on a long polling receive call. Setting this to a value of 1 second or greater will reduce the number of SQS requests and decrease fetch latency at the cost of a constantly active thread.
   */
  public static final String RECEIVE_MESSAGE_WAIT_TIME_PROPERTY = "Receive Message Wait Time";

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
   * The URL of the queue to act upon
   */
  public final String getQueueUrl() {
    return properties.get(QUEUE_URL_PROPERTY);
  }

  /**
   * The URL of the queue to act upon
   */
  public final GetSQS setQueueUrl(final String queueUrl) {
    properties.put(QUEUE_URL_PROPERTY, queueUrl);
    return this;
  }

  /**
   * The URL of the queue to act upon
   */
  public final GetSQS removeQueueUrl() {
    properties.remove(QUEUE_URL_PROPERTY);
    return this;
  }

  /**
   * Specifies whether the messages should be automatically deleted by the processors once they have been received.
   */
  public final String getAutoDeleteMessages() {
    return properties.get(AUTO_DELETE_MESSAGES_PROPERTY);
  }

  /**
   * Specifies whether the messages should be automatically deleted by the processors once they have been received.
   */
  public final GetSQS setAutoDeleteMessages(final String autoDeleteMessages) {
    properties.put(AUTO_DELETE_MESSAGES_PROPERTY, autoDeleteMessages);
    return this;
  }

  /**
   * Specifies whether the messages should be automatically deleted by the processors once they have been received.
   */
  public final GetSQS removeAutoDeleteMessages() {
    properties.remove(AUTO_DELETE_MESSAGES_PROPERTY);
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
  public final GetSQS setAccessKey(final String accessKey) {
    properties.put(ACCESS_KEY_PROPERTY, accessKey);
    return this;
  }

  /**
   *
   */
  public final GetSQS removeAccessKey() {
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
  public final GetSQS setSecretKey(final String secretKey) {
    properties.put(SECRET_KEY_PROPERTY, secretKey);
    return this;
  }

  /**
   *
   */
  public final GetSQS removeSecretKey() {
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
  public final GetSQS setCredentialsFile(final String credentialsFile) {
    properties.put(CREDENTIALS_FILE_PROPERTY, credentialsFile);
    return this;
  }

  /**
   * Path to a file containing AWS access key and secret key in properties file format.
   */
  public final GetSQS removeCredentialsFile() {
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
  public final GetSQS setAwsCredentialsProviderService(final String awsCredentialsProviderService) {
    properties.put(AWS_CREDENTIALS_PROVIDER_SERVICE_PROPERTY, awsCredentialsProviderService);
    return this;
  }

  /**
   * The Controller Service that is used to obtain aws credentials provider
   */
  public final GetSQS removeAwsCredentialsProviderService() {
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
  public final GetSQS setRegion(final String region) {
    properties.put(REGION_PROPERTY, region);
    return this;
  }

  /**
   *
   */
  public final GetSQS removeRegion() {
    properties.remove(REGION_PROPERTY);
    return this;
  }

  /**
   * The maximum number of messages to send in a single network request
   */
  public final String getBatchSize() {
    return properties.get(BATCH_SIZE_PROPERTY);
  }

  /**
   * The maximum number of messages to send in a single network request
   */
  public final GetSQS setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * The maximum number of messages to send in a single network request
   */
  public final GetSQS removeBatchSize() {
    properties.remove(BATCH_SIZE_PROPERTY);
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
  public final GetSQS setCommunicationsTimeout(final String communicationsTimeout) {
    properties.put(COMMUNICATIONS_TIMEOUT_PROPERTY, communicationsTimeout);
    return this;
  }

  /**
   *
   */
  public final GetSQS removeCommunicationsTimeout() {
    properties.remove(COMMUNICATIONS_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The Character Set that should be used to encode the textual content of the SQS message
   */
  public final String getCharacterSet() {
    return properties.get(CHARACTER_SET_PROPERTY);
  }

  /**
   * The Character Set that should be used to encode the textual content of the SQS message
   */
  public final GetSQS setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * The Character Set that should be used to encode the textual content of the SQS message
   */
  public final GetSQS removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
    return this;
  }

  /**
   * The amount of time after a message is received but not deleted that the message is hidden from other consumers
   */
  public final String getVisibilityTimeout() {
    return properties.get(VISIBILITY_TIMEOUT_PROPERTY);
  }

  /**
   * The amount of time after a message is received but not deleted that the message is hidden from other consumers
   */
  public final GetSQS setVisibilityTimeout(final String visibilityTimeout) {
    properties.put(VISIBILITY_TIMEOUT_PROPERTY, visibilityTimeout);
    return this;
  }

  /**
   * The amount of time after a message is received but not deleted that the message is hidden from other consumers
   */
  public final GetSQS removeVisibilityTimeout() {
    properties.remove(VISIBILITY_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The maximum amount of time to wait on a long polling receive call. Setting this to a value of 1 second or greater will reduce the number of SQS requests and decrease fetch latency at the cost of a constantly active thread.
   */
  public final String getReceiveMessageWaitTime() {
    return properties.get(RECEIVE_MESSAGE_WAIT_TIME_PROPERTY);
  }

  /**
   * The maximum amount of time to wait on a long polling receive call. Setting this to a value of 1 second or greater will reduce the number of SQS requests and decrease fetch latency at the cost of a constantly active thread.
   */
  public final GetSQS setReceiveMessageWaitTime(final String receiveMessageWaitTime) {
    properties.put(RECEIVE_MESSAGE_WAIT_TIME_PROPERTY, receiveMessageWaitTime);
    return this;
  }

  /**
   * The maximum amount of time to wait on a long polling receive call. Setting this to a value of 1 second or greater will reduce the number of SQS requests and decrease fetch latency at the cost of a constantly active thread.
   */
  public final GetSQS removeReceiveMessageWaitTime() {
    properties.remove(RECEIVE_MESSAGE_WAIT_TIME_PROPERTY);
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
  public final GetSQS setProxyHost(final String proxyHost) {
    properties.put(PROXY_HOST_PROPERTY, proxyHost);
    return this;
  }

  /**
   * Proxy host name or IP
   */
  public final GetSQS removeProxyHost() {
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
  public final GetSQS setProxyHostPort(final String proxyHostPort) {
    properties.put(PROXY_HOST_PORT_PROPERTY, proxyHostPort);
    return this;
  }

  /**
   * Proxy host port
   */
  public final GetSQS removeProxyHostPort() {
    properties.remove(PROXY_HOST_PORT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GetSQS setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GetSQS removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<GetSQS, GetSQS> configurator) {
    return configurator.apply(new GetSQS()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetSQS.class) final Closure<GetSQS> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.aws.sqs.GetSQS> code = closure.rehydrate(c, com.tibtech.nifi.processors.aws.sqs.GetSQS.class, com.tibtech.nifi.processors.aws.sqs.GetSQS.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
