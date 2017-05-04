package com.tibtech.nifi.processors.aws.dynamodb;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class DeleteDynamoDB {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.aws.dynamodb.DeleteDynamoDB";

  /**
   * The DynamoDB table name
   */
  public static final String TABLE_NAME_PROPERTY = "Table Name";

  /**
   * The hash key name of the item
   */
  public static final String HASH_KEY_NAME_PROPERTY = "Hash Key Name";

  /**
   * The range key name of the item
   */
  public static final String RANGE_KEY_NAME_PROPERTY = "Range Key Name";

  /**
   * The hash key value of the item
   */
  public static final String HASH_KEY_VALUE_PROPERTY = "Hash Key Value";

  /**
   *
   */
  public static final String RANGE_KEY_VALUE_PROPERTY = "Range Key Value";

  /**
   * The hash key value type of the item
   */
  public static final String HASH_KEY_VALUE_TYPE_PROPERTY = "Hash Key Value Type";

  /**
   * The range key value type of the item
   */
  public static final String RANGE_KEY_VALUE_TYPE_PROPERTY = "Range Key Value Type";

  /**
   * The items to be retrieved in one batch
   */
  public static final String BATCH_ITEMS_FOR_EACH_REQUEST_BETWEEN_1_AND_50_PROPERTY = "Batch items for each request (between 1 and 50)";

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

  private final Map<String, String> properties;

  public DeleteDynamoDB() {
    this.properties = new HashMap<>();
  }

  public DeleteDynamoDB(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The DynamoDB table name
   */
  public final String getTableName() {
    return properties.get(TABLE_NAME_PROPERTY);
  }

  /**
   * The DynamoDB table name
   */
  public final DeleteDynamoDB setTableName(final String tableName) {
    properties.put(TABLE_NAME_PROPERTY, tableName);
    return this;
  }

  /**
   * The DynamoDB table name
   */
  public final DeleteDynamoDB removeTableName() {
    properties.remove(TABLE_NAME_PROPERTY);
    return this;
  }

  /**
   * The hash key name of the item
   */
  public final String getHashKeyName() {
    return properties.get(HASH_KEY_NAME_PROPERTY);
  }

  /**
   * The hash key name of the item
   */
  public final DeleteDynamoDB setHashKeyName(final String hashKeyName) {
    properties.put(HASH_KEY_NAME_PROPERTY, hashKeyName);
    return this;
  }

  /**
   * The hash key name of the item
   */
  public final DeleteDynamoDB removeHashKeyName() {
    properties.remove(HASH_KEY_NAME_PROPERTY);
    return this;
  }

  /**
   * The range key name of the item
   */
  public final String getRangeKeyName() {
    return properties.get(RANGE_KEY_NAME_PROPERTY);
  }

  /**
   * The range key name of the item
   */
  public final DeleteDynamoDB setRangeKeyName(final String rangeKeyName) {
    properties.put(RANGE_KEY_NAME_PROPERTY, rangeKeyName);
    return this;
  }

  /**
   * The range key name of the item
   */
  public final DeleteDynamoDB removeRangeKeyName() {
    properties.remove(RANGE_KEY_NAME_PROPERTY);
    return this;
  }

  /**
   * The hash key value of the item
   */
  public final String getHashKeyValue() {
    return properties.get(HASH_KEY_VALUE_PROPERTY);
  }

  /**
   * The hash key value of the item
   */
  public final DeleteDynamoDB setHashKeyValue(final String hashKeyValue) {
    properties.put(HASH_KEY_VALUE_PROPERTY, hashKeyValue);
    return this;
  }

  /**
   * The hash key value of the item
   */
  public final DeleteDynamoDB removeHashKeyValue() {
    properties.remove(HASH_KEY_VALUE_PROPERTY);
    return this;
  }

  /**
   *
   */
  public final String getRangeKeyValue() {
    return properties.get(RANGE_KEY_VALUE_PROPERTY);
  }

  /**
   *
   */
  public final DeleteDynamoDB setRangeKeyValue(final String rangeKeyValue) {
    properties.put(RANGE_KEY_VALUE_PROPERTY, rangeKeyValue);
    return this;
  }

  /**
   *
   */
  public final DeleteDynamoDB removeRangeKeyValue() {
    properties.remove(RANGE_KEY_VALUE_PROPERTY);
    return this;
  }

  /**
   * The hash key value type of the item
   */
  public final String getHashKeyValueType() {
    return properties.get(HASH_KEY_VALUE_TYPE_PROPERTY);
  }

  /**
   * The hash key value type of the item
   */
  public final DeleteDynamoDB setHashKeyValueType(final String hashKeyValueType) {
    properties.put(HASH_KEY_VALUE_TYPE_PROPERTY, hashKeyValueType);
    return this;
  }

  /**
   * The hash key value type of the item
   */
  public final DeleteDynamoDB removeHashKeyValueType() {
    properties.remove(HASH_KEY_VALUE_TYPE_PROPERTY);
    return this;
  }

  /**
   * The range key value type of the item
   */
  public final String getRangeKeyValueType() {
    return properties.get(RANGE_KEY_VALUE_TYPE_PROPERTY);
  }

  /**
   * The range key value type of the item
   */
  public final DeleteDynamoDB setRangeKeyValueType(final String rangeKeyValueType) {
    properties.put(RANGE_KEY_VALUE_TYPE_PROPERTY, rangeKeyValueType);
    return this;
  }

  /**
   * The range key value type of the item
   */
  public final DeleteDynamoDB removeRangeKeyValueType() {
    properties.remove(RANGE_KEY_VALUE_TYPE_PROPERTY);
    return this;
  }

  /**
   * The items to be retrieved in one batch
   */
  public final String getBatchItemsForEachRequestBetween1And50() {
    return properties.get(BATCH_ITEMS_FOR_EACH_REQUEST_BETWEEN_1_AND_50_PROPERTY);
  }

  /**
   * The items to be retrieved in one batch
   */
  public final DeleteDynamoDB setBatchItemsForEachRequestBetween1And50(final String batchItemsForEachRequestBetween1And50) {
    properties.put(BATCH_ITEMS_FOR_EACH_REQUEST_BETWEEN_1_AND_50_PROPERTY, batchItemsForEachRequestBetween1And50);
    return this;
  }

  /**
   * The items to be retrieved in one batch
   */
  public final DeleteDynamoDB removeBatchItemsForEachRequestBetween1And50() {
    properties.remove(BATCH_ITEMS_FOR_EACH_REQUEST_BETWEEN_1_AND_50_PROPERTY);
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
  public final DeleteDynamoDB setRegion(final String region) {
    properties.put(REGION_PROPERTY, region);
    return this;
  }

  /**
   *
   */
  public final DeleteDynamoDB removeRegion() {
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
  public final DeleteDynamoDB setAccessKey(final String accessKey) {
    properties.put(ACCESS_KEY_PROPERTY, accessKey);
    return this;
  }

  /**
   *
   */
  public final DeleteDynamoDB removeAccessKey() {
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
  public final DeleteDynamoDB setSecretKey(final String secretKey) {
    properties.put(SECRET_KEY_PROPERTY, secretKey);
    return this;
  }

  /**
   *
   */
  public final DeleteDynamoDB removeSecretKey() {
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
  public final DeleteDynamoDB setCredentialsFile(final String credentialsFile) {
    properties.put(CREDENTIALS_FILE_PROPERTY, credentialsFile);
    return this;
  }

  /**
   * Path to a file containing AWS access key and secret key in properties file format.
   */
  public final DeleteDynamoDB removeCredentialsFile() {
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
  public final DeleteDynamoDB setAwsCredentialsProviderService(final String awsCredentialsProviderService) {
    properties.put(AWS_CREDENTIALS_PROVIDER_SERVICE_PROPERTY, awsCredentialsProviderService);
    return this;
  }

  /**
   * The Controller Service that is used to obtain aws credentials provider
   */
  public final DeleteDynamoDB removeAwsCredentialsProviderService() {
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
  public final DeleteDynamoDB setCommunicationsTimeout(final String communicationsTimeout) {
    properties.put(COMMUNICATIONS_TIMEOUT_PROPERTY, communicationsTimeout);
    return this;
  }

  /**
   *
   */
  public final DeleteDynamoDB removeCommunicationsTimeout() {
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
  public final DeleteDynamoDB setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * Specifies an optional SSL Context Service that, if provided, will be used to create connections
   */
  public final DeleteDynamoDB removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final DeleteDynamoDB setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final DeleteDynamoDB removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<DeleteDynamoDB, DeleteDynamoDB> configurator) {
    return configurator.apply(new DeleteDynamoDB()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DeleteDynamoDB.class) final Closure<DeleteDynamoDB> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.aws.dynamodb.DeleteDynamoDB> code = closure.rehydrate(c, com.tibtech.nifi.processors.aws.dynamodb.DeleteDynamoDB.class, com.tibtech.nifi.processors.aws.dynamodb.DeleteDynamoDB.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<DeleteDynamoDB, DeleteDynamoDB> configurator) {
    return configurator.apply(new DeleteDynamoDB(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DeleteDynamoDB.class) final Closure<DeleteDynamoDB> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.aws.dynamodb.DeleteDynamoDB> code = closure.rehydrate(c, com.tibtech.nifi.processors.aws.dynamodb.DeleteDynamoDB.class, com.tibtech.nifi.processors.aws.dynamodb.DeleteDynamoDB.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
