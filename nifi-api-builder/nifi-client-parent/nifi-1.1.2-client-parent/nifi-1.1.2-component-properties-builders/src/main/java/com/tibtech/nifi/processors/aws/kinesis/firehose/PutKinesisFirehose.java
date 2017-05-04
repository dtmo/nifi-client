package com.tibtech.nifi.processors.aws.kinesis.firehose;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutKinesisFirehose {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.aws.kinesis.firehose.PutKinesisFirehose";

  /**
   * The name of kinesis firehose delivery stream
   */
  public static final String AMAZON_KINESIS_FIREHOSE_DELIVERY_STREAM_NAME_PROPERTY = "Amazon Kinesis Firehose Delivery Stream Name";

  /**
   * Batch size for messages (1-500).
   */
  public static final String BATCH_SIZE_PROPERTY = "Batch Size";

  /**
   * Max message buffer
   */
  public static final String MAX_MESSAGE_BUFFER_SIZE_PROPERTY = "Max message buffer size";

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

  public PutKinesisFirehose() {
    this.properties = new HashMap<>();
  }

  public PutKinesisFirehose(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The name of kinesis firehose delivery stream
   */
  public final String getAmazonKinesisFirehoseDeliveryStreamName() {
    return properties.get(AMAZON_KINESIS_FIREHOSE_DELIVERY_STREAM_NAME_PROPERTY);
  }

  /**
   * The name of kinesis firehose delivery stream
   */
  public final PutKinesisFirehose setAmazonKinesisFirehoseDeliveryStreamName(final String amazonKinesisFirehoseDeliveryStreamName) {
    properties.put(AMAZON_KINESIS_FIREHOSE_DELIVERY_STREAM_NAME_PROPERTY, amazonKinesisFirehoseDeliveryStreamName);
    return this;
  }

  /**
   * The name of kinesis firehose delivery stream
   */
  public final PutKinesisFirehose removeAmazonKinesisFirehoseDeliveryStreamName() {
    properties.remove(AMAZON_KINESIS_FIREHOSE_DELIVERY_STREAM_NAME_PROPERTY);
    return this;
  }

  /**
   * Batch size for messages (1-500).
   */
  public final String getBatchSize() {
    return properties.get(BATCH_SIZE_PROPERTY);
  }

  /**
   * Batch size for messages (1-500).
   */
  public final PutKinesisFirehose setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * Batch size for messages (1-500).
   */
  public final PutKinesisFirehose removeBatchSize() {
    properties.remove(BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * Max message buffer
   */
  public final String getMaxMessageBufferSize() {
    return properties.get(MAX_MESSAGE_BUFFER_SIZE_PROPERTY);
  }

  /**
   * Max message buffer
   */
  public final PutKinesisFirehose setMaxMessageBufferSize(final String maxMessageBufferSize) {
    properties.put(MAX_MESSAGE_BUFFER_SIZE_PROPERTY, maxMessageBufferSize);
    return this;
  }

  /**
   * Max message buffer
   */
  public final PutKinesisFirehose removeMaxMessageBufferSize() {
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
  public final PutKinesisFirehose setRegion(final String region) {
    properties.put(REGION_PROPERTY, region);
    return this;
  }

  /**
   *
   */
  public final PutKinesisFirehose removeRegion() {
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
  public final PutKinesisFirehose setAccessKey(final String accessKey) {
    properties.put(ACCESS_KEY_PROPERTY, accessKey);
    return this;
  }

  /**
   *
   */
  public final PutKinesisFirehose removeAccessKey() {
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
  public final PutKinesisFirehose setSecretKey(final String secretKey) {
    properties.put(SECRET_KEY_PROPERTY, secretKey);
    return this;
  }

  /**
   *
   */
  public final PutKinesisFirehose removeSecretKey() {
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
  public final PutKinesisFirehose setCredentialsFile(final String credentialsFile) {
    properties.put(CREDENTIALS_FILE_PROPERTY, credentialsFile);
    return this;
  }

  /**
   * Path to a file containing AWS access key and secret key in properties file format.
   */
  public final PutKinesisFirehose removeCredentialsFile() {
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
  public final PutKinesisFirehose setAwsCredentialsProviderService(final String awsCredentialsProviderService) {
    properties.put(AWS_CREDENTIALS_PROVIDER_SERVICE_PROPERTY, awsCredentialsProviderService);
    return this;
  }

  /**
   * The Controller Service that is used to obtain aws credentials provider
   */
  public final PutKinesisFirehose removeAwsCredentialsProviderService() {
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
  public final PutKinesisFirehose setCommunicationsTimeout(final String communicationsTimeout) {
    properties.put(COMMUNICATIONS_TIMEOUT_PROPERTY, communicationsTimeout);
    return this;
  }

  /**
   *
   */
  public final PutKinesisFirehose removeCommunicationsTimeout() {
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
  public final PutKinesisFirehose setProxyHost(final String proxyHost) {
    properties.put(PROXY_HOST_PROPERTY, proxyHost);
    return this;
  }

  /**
   * Proxy host name or IP
   */
  public final PutKinesisFirehose removeProxyHost() {
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
  public final PutKinesisFirehose setProxyHostPort(final String proxyHostPort) {
    properties.put(PROXY_HOST_PORT_PROPERTY, proxyHostPort);
    return this;
  }

  /**
   * Proxy host port
   */
  public final PutKinesisFirehose removeProxyHostPort() {
    properties.remove(PROXY_HOST_PORT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutKinesisFirehose setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutKinesisFirehose removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutKinesisFirehose, PutKinesisFirehose> configurator) {
    return configurator.apply(new PutKinesisFirehose()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutKinesisFirehose.class) final Closure<PutKinesisFirehose> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.aws.kinesis.firehose.PutKinesisFirehose> code = closure.rehydrate(c, com.tibtech.nifi.processors.aws.kinesis.firehose.PutKinesisFirehose.class, com.tibtech.nifi.processors.aws.kinesis.firehose.PutKinesisFirehose.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutKinesisFirehose, PutKinesisFirehose> configurator) {
    return configurator.apply(new PutKinesisFirehose(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutKinesisFirehose.class) final Closure<PutKinesisFirehose> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.aws.kinesis.firehose.PutKinesisFirehose> code = closure.rehydrate(c, com.tibtech.nifi.processors.aws.kinesis.firehose.PutKinesisFirehose.class, com.tibtech.nifi.processors.aws.kinesis.firehose.PutKinesisFirehose.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
