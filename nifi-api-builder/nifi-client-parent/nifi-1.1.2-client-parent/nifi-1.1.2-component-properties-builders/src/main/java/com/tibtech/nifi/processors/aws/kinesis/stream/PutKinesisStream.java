package com.tibtech.nifi.processors.aws.kinesis.stream;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutKinesisStream {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.aws.kinesis.stream.PutKinesisStream";

  /**
   * The name of Kinesis Stream
   */
  public static final String KINESIS_STREAM_NAME_PROPERTY = "kinesis-stream-name";

  /**
   * The partition key attribute.  If it is not set, a random value is used
   */
  public static final String AMAZON_KINESIS_STREAM_PARTITION_KEY_PROPERTY = "amazon-kinesis-stream-partition-key";

  /**
   * Batch size for messages (1-500).
   */
  public static final String MESSAGE_BATCH_SIZE_PROPERTY = "message-batch-size";

  /**
   * Max message buffer size in Mega-bytes
   */
  public static final String MAX_MESSAGE_BUFFER_SIZE_PROPERTY = "max-message-buffer-size";

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
   * Proxy host name or IP
   */
  public static final String PROXY_HOST_PROPERTY = "Proxy Host";

  /**
   * Proxy host port
   */
  public static final String PROXY_HOST_PORT_PROPERTY = "Proxy Host Port";

  private final Map<String, String> properties;

  public PutKinesisStream() {
    this.properties = new HashMap<>();
  }

  public PutKinesisStream(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The name of Kinesis Stream
   */
  public final String getKinesisStreamName() {
    return properties.get(KINESIS_STREAM_NAME_PROPERTY);
  }

  /**
   * The name of Kinesis Stream
   */
  public final PutKinesisStream setKinesisStreamName(final String kinesisStreamName) {
    properties.put(KINESIS_STREAM_NAME_PROPERTY, kinesisStreamName);
    return this;
  }

  /**
   * The name of Kinesis Stream
   */
  public final PutKinesisStream removeKinesisStreamName() {
    properties.remove(KINESIS_STREAM_NAME_PROPERTY);
    return this;
  }

  /**
   * The partition key attribute.  If it is not set, a random value is used
   */
  public final String getAmazonKinesisStreamPartitionKey() {
    return properties.get(AMAZON_KINESIS_STREAM_PARTITION_KEY_PROPERTY);
  }

  /**
   * The partition key attribute.  If it is not set, a random value is used
   */
  public final PutKinesisStream setAmazonKinesisStreamPartitionKey(final String amazonKinesisStreamPartitionKey) {
    properties.put(AMAZON_KINESIS_STREAM_PARTITION_KEY_PROPERTY, amazonKinesisStreamPartitionKey);
    return this;
  }

  /**
   * The partition key attribute.  If it is not set, a random value is used
   */
  public final PutKinesisStream removeAmazonKinesisStreamPartitionKey() {
    properties.remove(AMAZON_KINESIS_STREAM_PARTITION_KEY_PROPERTY);
    return this;
  }

  /**
   * Batch size for messages (1-500).
   */
  public final String getMessageBatchSize() {
    return properties.get(MESSAGE_BATCH_SIZE_PROPERTY);
  }

  /**
   * Batch size for messages (1-500).
   */
  public final PutKinesisStream setMessageBatchSize(final String messageBatchSize) {
    properties.put(MESSAGE_BATCH_SIZE_PROPERTY, messageBatchSize);
    return this;
  }

  /**
   * Batch size for messages (1-500).
   */
  public final PutKinesisStream removeMessageBatchSize() {
    properties.remove(MESSAGE_BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * Max message buffer size in Mega-bytes
   */
  public final String getMaxMessageBufferSize() {
    return properties.get(MAX_MESSAGE_BUFFER_SIZE_PROPERTY);
  }

  /**
   * Max message buffer size in Mega-bytes
   */
  public final PutKinesisStream setMaxMessageBufferSize(final String maxMessageBufferSize) {
    properties.put(MAX_MESSAGE_BUFFER_SIZE_PROPERTY, maxMessageBufferSize);
    return this;
  }

  /**
   * Max message buffer size in Mega-bytes
   */
  public final PutKinesisStream removeMaxMessageBufferSize() {
    properties.remove(MAX_MESSAGE_BUFFER_SIZE_PROPERTY);
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
  public final PutKinesisStream setRegion(final String region) {
    properties.put(REGION_PROPERTY, region);
    return this;
  }

  /**
   *
   */
  public final PutKinesisStream removeRegion() {
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
  public final PutKinesisStream setAccessKey(final String accessKey) {
    properties.put(ACCESS_KEY_PROPERTY, accessKey);
    return this;
  }

  /**
   *
   */
  public final PutKinesisStream removeAccessKey() {
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
  public final PutKinesisStream setSecretKey(final String secretKey) {
    properties.put(SECRET_KEY_PROPERTY, secretKey);
    return this;
  }

  /**
   *
   */
  public final PutKinesisStream removeSecretKey() {
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
  public final PutKinesisStream setCredentialsFile(final String credentialsFile) {
    properties.put(CREDENTIALS_FILE_PROPERTY, credentialsFile);
    return this;
  }

  /**
   * Path to a file containing AWS access key and secret key in properties file format.
   */
  public final PutKinesisStream removeCredentialsFile() {
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
  public final PutKinesisStream setAwsCredentialsProviderService(final String awsCredentialsProviderService) {
    properties.put(AWS_CREDENTIALS_PROVIDER_SERVICE_PROPERTY, awsCredentialsProviderService);
    return this;
  }

  /**
   * The Controller Service that is used to obtain aws credentials provider
   */
  public final PutKinesisStream removeAwsCredentialsProviderService() {
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
  public final PutKinesisStream setCommunicationsTimeout(final String communicationsTimeout) {
    properties.put(COMMUNICATIONS_TIMEOUT_PROPERTY, communicationsTimeout);
    return this;
  }

  /**
   *
   */
  public final PutKinesisStream removeCommunicationsTimeout() {
    properties.remove(COMMUNICATIONS_TIMEOUT_PROPERTY);
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
  public final PutKinesisStream setProxyHost(final String proxyHost) {
    properties.put(PROXY_HOST_PROPERTY, proxyHost);
    return this;
  }

  /**
   * Proxy host name or IP
   */
  public final PutKinesisStream removeProxyHost() {
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
  public final PutKinesisStream setProxyHostPort(final String proxyHostPort) {
    properties.put(PROXY_HOST_PORT_PROPERTY, proxyHostPort);
    return this;
  }

  /**
   * Proxy host port
   */
  public final PutKinesisStream removeProxyHostPort() {
    properties.remove(PROXY_HOST_PORT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutKinesisStream setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutKinesisStream removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutKinesisStream, PutKinesisStream> configurator) {
    return configurator.apply(new PutKinesisStream()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutKinesisStream.class) final Closure<PutKinesisStream> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.aws.kinesis.stream.PutKinesisStream> code = closure.rehydrate(c, com.tibtech.nifi.processors.aws.kinesis.stream.PutKinesisStream.class, com.tibtech.nifi.processors.aws.kinesis.stream.PutKinesisStream.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutKinesisStream, PutKinesisStream> configurator) {
    return configurator.apply(new PutKinesisStream(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutKinesisStream.class) final Closure<PutKinesisStream> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.aws.kinesis.stream.PutKinesisStream> code = closure.rehydrate(c, com.tibtech.nifi.processors.aws.kinesis.stream.PutKinesisStream.class, com.tibtech.nifi.processors.aws.kinesis.stream.PutKinesisStream.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
