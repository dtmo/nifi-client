package com.tibtech.nifi.processors.hive;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutHiveStreaming {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.hive.PutHiveStreaming";

  /**
   * The URI location for the Hive Metastore. Note that this is not the location of the Hive Server. The default port for the Hive metastore is 9043.
   */
  public static final String HIVE_STREAM_METASTORE_URI_PROPERTY = "hive-stream-metastore-uri";

  /**
   * A file or comma separated list of files which contains the Hive configuration (hive-site.xml, e.g.). Without this, Hadoop will search the classpath for a 'hive-site.xml' file or will revert to a default configuration. Note that to enable authentication with Kerberos e.g., the appropriate properties must be set in the configuration files. Also note that if Max Concurrent Tasks is set to a number greater than one, the 'hcatalog.hive.client.cache.disabled' property will be forced to 'true' to avoid concurrency issues. Please see the Hive documentation for more details.
   */
  public static final String HIVE_CONFIG_RESOURCES_PROPERTY = "hive-config-resources";

  /**
   * The name of the database in which to put the data.
   */
  public static final String HIVE_STREAM_DATABASE_NAME_PROPERTY = "hive-stream-database-name";

  /**
   * The name of the database table in which to put the data.
   */
  public static final String HIVE_STREAM_TABLE_NAME_PROPERTY = "hive-stream-table-name";

  /**
   * A comma-delimited list of column names on which the table has been partitioned. The order of values in this list must correspond exactly to the order of partition columns specified during the table creation.
   */
  public static final String HIVE_STREAM_PARTITION_COLS_PROPERTY = "hive-stream-partition-cols";

  /**
   * Flag indicating whether partitions should be automatically created
   */
  public static final String HIVE_STREAM_AUTOCREATE_PARTITION_PROPERTY = "hive-stream-autocreate-partition";

  /**
   * The maximum number of open connections that can be allocated from this pool at the same time, or negative for no limit.
   */
  public static final String HIVE_STREAM_MAX_OPEN_CONNECTIONS_PROPERTY = "hive-stream-max-open-connections";

  /**
   * Indicates that a heartbeat should be sent when the specified number of seconds has elapsed. A value of 0 indicates that no heartbeat should be sent. Note that although this property supports Expression Language, it will not be evaluated against incoming FlowFile attributes.
   */
  public static final String HIVE_STREAM_HEARTBEAT_INTERVAL_PROPERTY = "hive-stream-heartbeat-interval";

  /**
   * A hint to Hive Streaming indicating how many transactions the processor task will need. This value must be greater than 1.
   */
  public static final String HIVE_STREAM_TRANSACTIONS_PER_BATCH_PROPERTY = "hive-stream-transactions-per-batch";

  /**
   * Number of records to process before committing the transaction. This value must be greater than 1.
   */
  public static final String HIVE_STREAM_RECORDS_PER_TRANSACTION_PROPERTY = "hive-stream-records-per-transaction";

  /**
   * The number of seconds allowed for a Hive Streaming operation to complete. A value of 0 indicates the processor should wait indefinitely on operations. Note that although this property supports Expression Language, it will not be evaluated against incoming FlowFile attributes.
   */
  public static final String HIVE_STREAM_CALL_TIMEOUT_PROPERTY = "hive-stream-call-timeout";

  /**
   * Specify how to handle error. By default (false), if an error occurs while processing a FlowFile, the FlowFile will be routed to 'failure' or 'retry' relationship based on error type, and processor can continue with next FlowFile. Instead, you may want to rollback currently processed FlowFiles and stop further processing immediately. In that case, you can do so by enabling this 'Rollback On Failure' property.  If enabled, failed FlowFiles will stay in the input relationship without penalizing it and being processed repeatedly until it gets processed successfully or removed by other means. It is important to set adequate 'Yield Duration' to avoid retrying too frequently.NOTE: When an error occurred after a Hive streaming transaction which is derived from the same input FlowFile is already committed, (i.e. a FlowFile contains more records than 'Records per Transaction' and a failure occurred at the 2nd transaction or later) then the succeeded records will be transferred to 'success' relationship while the original input FlowFile stays in incoming queue. Duplicated records can be created for the succeeded ones when the same FlowFile is processed again.
   */
  public static final String ROLLBACK_ON_FAILURE_PROPERTY = "rollback-on-failure";

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public static final String KERBEROS_CREDENTIALS_SERVICE_PROPERTY = "kerberos-credentials-service";

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public static final String KERBEROS_PRINCIPAL_PROPERTY = "Kerberos Principal";

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public static final String KERBEROS_KEYTAB_PROPERTY = "Kerberos Keytab";

  private final Map<String, String> properties;

  public PutHiveStreaming() {
    this.properties = new HashMap<>();
  }

  public PutHiveStreaming(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The URI location for the Hive Metastore. Note that this is not the location of the Hive Server. The default port for the Hive metastore is 9043.
   */
  public final String getHiveStreamMetastoreUri() {
    return properties.get(HIVE_STREAM_METASTORE_URI_PROPERTY);
  }

  /**
   * The URI location for the Hive Metastore. Note that this is not the location of the Hive Server. The default port for the Hive metastore is 9043.
   */
  public final PutHiveStreaming setHiveStreamMetastoreUri(final String hiveStreamMetastoreUri) {
    properties.put(HIVE_STREAM_METASTORE_URI_PROPERTY, hiveStreamMetastoreUri);
    return this;
  }

  /**
   * The URI location for the Hive Metastore. Note that this is not the location of the Hive Server. The default port for the Hive metastore is 9043.
   */
  public final PutHiveStreaming removeHiveStreamMetastoreUri() {
    properties.remove(HIVE_STREAM_METASTORE_URI_PROPERTY);
    return this;
  }

  /**
   * A file or comma separated list of files which contains the Hive configuration (hive-site.xml, e.g.). Without this, Hadoop will search the classpath for a 'hive-site.xml' file or will revert to a default configuration. Note that to enable authentication with Kerberos e.g., the appropriate properties must be set in the configuration files. Also note that if Max Concurrent Tasks is set to a number greater than one, the 'hcatalog.hive.client.cache.disabled' property will be forced to 'true' to avoid concurrency issues. Please see the Hive documentation for more details.
   */
  public final String getHiveConfigResources() {
    return properties.get(HIVE_CONFIG_RESOURCES_PROPERTY);
  }

  /**
   * A file or comma separated list of files which contains the Hive configuration (hive-site.xml, e.g.). Without this, Hadoop will search the classpath for a 'hive-site.xml' file or will revert to a default configuration. Note that to enable authentication with Kerberos e.g., the appropriate properties must be set in the configuration files. Also note that if Max Concurrent Tasks is set to a number greater than one, the 'hcatalog.hive.client.cache.disabled' property will be forced to 'true' to avoid concurrency issues. Please see the Hive documentation for more details.
   */
  public final PutHiveStreaming setHiveConfigResources(final String hiveConfigResources) {
    properties.put(HIVE_CONFIG_RESOURCES_PROPERTY, hiveConfigResources);
    return this;
  }

  /**
   * A file or comma separated list of files which contains the Hive configuration (hive-site.xml, e.g.). Without this, Hadoop will search the classpath for a 'hive-site.xml' file or will revert to a default configuration. Note that to enable authentication with Kerberos e.g., the appropriate properties must be set in the configuration files. Also note that if Max Concurrent Tasks is set to a number greater than one, the 'hcatalog.hive.client.cache.disabled' property will be forced to 'true' to avoid concurrency issues. Please see the Hive documentation for more details.
   */
  public final PutHiveStreaming removeHiveConfigResources() {
    properties.remove(HIVE_CONFIG_RESOURCES_PROPERTY);
    return this;
  }

  /**
   * The name of the database in which to put the data.
   */
  public final String getHiveStreamDatabaseName() {
    return properties.get(HIVE_STREAM_DATABASE_NAME_PROPERTY);
  }

  /**
   * The name of the database in which to put the data.
   */
  public final PutHiveStreaming setHiveStreamDatabaseName(final String hiveStreamDatabaseName) {
    properties.put(HIVE_STREAM_DATABASE_NAME_PROPERTY, hiveStreamDatabaseName);
    return this;
  }

  /**
   * The name of the database in which to put the data.
   */
  public final PutHiveStreaming removeHiveStreamDatabaseName() {
    properties.remove(HIVE_STREAM_DATABASE_NAME_PROPERTY);
    return this;
  }

  /**
   * The name of the database table in which to put the data.
   */
  public final String getHiveStreamTableName() {
    return properties.get(HIVE_STREAM_TABLE_NAME_PROPERTY);
  }

  /**
   * The name of the database table in which to put the data.
   */
  public final PutHiveStreaming setHiveStreamTableName(final String hiveStreamTableName) {
    properties.put(HIVE_STREAM_TABLE_NAME_PROPERTY, hiveStreamTableName);
    return this;
  }

  /**
   * The name of the database table in which to put the data.
   */
  public final PutHiveStreaming removeHiveStreamTableName() {
    properties.remove(HIVE_STREAM_TABLE_NAME_PROPERTY);
    return this;
  }

  /**
   * A comma-delimited list of column names on which the table has been partitioned. The order of values in this list must correspond exactly to the order of partition columns specified during the table creation.
   */
  public final String getHiveStreamPartitionCols() {
    return properties.get(HIVE_STREAM_PARTITION_COLS_PROPERTY);
  }

  /**
   * A comma-delimited list of column names on which the table has been partitioned. The order of values in this list must correspond exactly to the order of partition columns specified during the table creation.
   */
  public final PutHiveStreaming setHiveStreamPartitionCols(final String hiveStreamPartitionCols) {
    properties.put(HIVE_STREAM_PARTITION_COLS_PROPERTY, hiveStreamPartitionCols);
    return this;
  }

  /**
   * A comma-delimited list of column names on which the table has been partitioned. The order of values in this list must correspond exactly to the order of partition columns specified during the table creation.
   */
  public final PutHiveStreaming removeHiveStreamPartitionCols() {
    properties.remove(HIVE_STREAM_PARTITION_COLS_PROPERTY);
    return this;
  }

  /**
   * Flag indicating whether partitions should be automatically created
   */
  public final String getHiveStreamAutocreatePartition() {
    return properties.get(HIVE_STREAM_AUTOCREATE_PARTITION_PROPERTY);
  }

  /**
   * Flag indicating whether partitions should be automatically created
   */
  public final PutHiveStreaming setHiveStreamAutocreatePartition(
      final String hiveStreamAutocreatePartition) {
    properties.put(HIVE_STREAM_AUTOCREATE_PARTITION_PROPERTY, hiveStreamAutocreatePartition);
    return this;
  }

  /**
   * Flag indicating whether partitions should be automatically created
   */
  public final PutHiveStreaming removeHiveStreamAutocreatePartition() {
    properties.remove(HIVE_STREAM_AUTOCREATE_PARTITION_PROPERTY);
    return this;
  }

  /**
   * The maximum number of open connections that can be allocated from this pool at the same time, or negative for no limit.
   */
  public final String getHiveStreamMaxOpenConnections() {
    return properties.get(HIVE_STREAM_MAX_OPEN_CONNECTIONS_PROPERTY);
  }

  /**
   * The maximum number of open connections that can be allocated from this pool at the same time, or negative for no limit.
   */
  public final PutHiveStreaming setHiveStreamMaxOpenConnections(
      final String hiveStreamMaxOpenConnections) {
    properties.put(HIVE_STREAM_MAX_OPEN_CONNECTIONS_PROPERTY, hiveStreamMaxOpenConnections);
    return this;
  }

  /**
   * The maximum number of open connections that can be allocated from this pool at the same time, or negative for no limit.
   */
  public final PutHiveStreaming removeHiveStreamMaxOpenConnections() {
    properties.remove(HIVE_STREAM_MAX_OPEN_CONNECTIONS_PROPERTY);
    return this;
  }

  /**
   * Indicates that a heartbeat should be sent when the specified number of seconds has elapsed. A value of 0 indicates that no heartbeat should be sent. Note that although this property supports Expression Language, it will not be evaluated against incoming FlowFile attributes.
   */
  public final String getHiveStreamHeartbeatInterval() {
    return properties.get(HIVE_STREAM_HEARTBEAT_INTERVAL_PROPERTY);
  }

  /**
   * Indicates that a heartbeat should be sent when the specified number of seconds has elapsed. A value of 0 indicates that no heartbeat should be sent. Note that although this property supports Expression Language, it will not be evaluated against incoming FlowFile attributes.
   */
  public final PutHiveStreaming setHiveStreamHeartbeatInterval(
      final String hiveStreamHeartbeatInterval) {
    properties.put(HIVE_STREAM_HEARTBEAT_INTERVAL_PROPERTY, hiveStreamHeartbeatInterval);
    return this;
  }

  /**
   * Indicates that a heartbeat should be sent when the specified number of seconds has elapsed. A value of 0 indicates that no heartbeat should be sent. Note that although this property supports Expression Language, it will not be evaluated against incoming FlowFile attributes.
   */
  public final PutHiveStreaming removeHiveStreamHeartbeatInterval() {
    properties.remove(HIVE_STREAM_HEARTBEAT_INTERVAL_PROPERTY);
    return this;
  }

  /**
   * A hint to Hive Streaming indicating how many transactions the processor task will need. This value must be greater than 1.
   */
  public final String getHiveStreamTransactionsPerBatch() {
    return properties.get(HIVE_STREAM_TRANSACTIONS_PER_BATCH_PROPERTY);
  }

  /**
   * A hint to Hive Streaming indicating how many transactions the processor task will need. This value must be greater than 1.
   */
  public final PutHiveStreaming setHiveStreamTransactionsPerBatch(
      final String hiveStreamTransactionsPerBatch) {
    properties.put(HIVE_STREAM_TRANSACTIONS_PER_BATCH_PROPERTY, hiveStreamTransactionsPerBatch);
    return this;
  }

  /**
   * A hint to Hive Streaming indicating how many transactions the processor task will need. This value must be greater than 1.
   */
  public final PutHiveStreaming removeHiveStreamTransactionsPerBatch() {
    properties.remove(HIVE_STREAM_TRANSACTIONS_PER_BATCH_PROPERTY);
    return this;
  }

  /**
   * Number of records to process before committing the transaction. This value must be greater than 1.
   */
  public final String getHiveStreamRecordsPerTransaction() {
    return properties.get(HIVE_STREAM_RECORDS_PER_TRANSACTION_PROPERTY);
  }

  /**
   * Number of records to process before committing the transaction. This value must be greater than 1.
   */
  public final PutHiveStreaming setHiveStreamRecordsPerTransaction(
      final String hiveStreamRecordsPerTransaction) {
    properties.put(HIVE_STREAM_RECORDS_PER_TRANSACTION_PROPERTY, hiveStreamRecordsPerTransaction);
    return this;
  }

  /**
   * Number of records to process before committing the transaction. This value must be greater than 1.
   */
  public final PutHiveStreaming removeHiveStreamRecordsPerTransaction() {
    properties.remove(HIVE_STREAM_RECORDS_PER_TRANSACTION_PROPERTY);
    return this;
  }

  /**
   * The number of seconds allowed for a Hive Streaming operation to complete. A value of 0 indicates the processor should wait indefinitely on operations. Note that although this property supports Expression Language, it will not be evaluated against incoming FlowFile attributes.
   */
  public final String getHiveStreamCallTimeout() {
    return properties.get(HIVE_STREAM_CALL_TIMEOUT_PROPERTY);
  }

  /**
   * The number of seconds allowed for a Hive Streaming operation to complete. A value of 0 indicates the processor should wait indefinitely on operations. Note that although this property supports Expression Language, it will not be evaluated against incoming FlowFile attributes.
   */
  public final PutHiveStreaming setHiveStreamCallTimeout(final String hiveStreamCallTimeout) {
    properties.put(HIVE_STREAM_CALL_TIMEOUT_PROPERTY, hiveStreamCallTimeout);
    return this;
  }

  /**
   * The number of seconds allowed for a Hive Streaming operation to complete. A value of 0 indicates the processor should wait indefinitely on operations. Note that although this property supports Expression Language, it will not be evaluated against incoming FlowFile attributes.
   */
  public final PutHiveStreaming removeHiveStreamCallTimeout() {
    properties.remove(HIVE_STREAM_CALL_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * Specify how to handle error. By default (false), if an error occurs while processing a FlowFile, the FlowFile will be routed to 'failure' or 'retry' relationship based on error type, and processor can continue with next FlowFile. Instead, you may want to rollback currently processed FlowFiles and stop further processing immediately. In that case, you can do so by enabling this 'Rollback On Failure' property.  If enabled, failed FlowFiles will stay in the input relationship without penalizing it and being processed repeatedly until it gets processed successfully or removed by other means. It is important to set adequate 'Yield Duration' to avoid retrying too frequently.NOTE: When an error occurred after a Hive streaming transaction which is derived from the same input FlowFile is already committed, (i.e. a FlowFile contains more records than 'Records per Transaction' and a failure occurred at the 2nd transaction or later) then the succeeded records will be transferred to 'success' relationship while the original input FlowFile stays in incoming queue. Duplicated records can be created for the succeeded ones when the same FlowFile is processed again.
   */
  public final String getRollbackOnFailure() {
    return properties.get(ROLLBACK_ON_FAILURE_PROPERTY);
  }

  /**
   * Specify how to handle error. By default (false), if an error occurs while processing a FlowFile, the FlowFile will be routed to 'failure' or 'retry' relationship based on error type, and processor can continue with next FlowFile. Instead, you may want to rollback currently processed FlowFiles and stop further processing immediately. In that case, you can do so by enabling this 'Rollback On Failure' property.  If enabled, failed FlowFiles will stay in the input relationship without penalizing it and being processed repeatedly until it gets processed successfully or removed by other means. It is important to set adequate 'Yield Duration' to avoid retrying too frequently.NOTE: When an error occurred after a Hive streaming transaction which is derived from the same input FlowFile is already committed, (i.e. a FlowFile contains more records than 'Records per Transaction' and a failure occurred at the 2nd transaction or later) then the succeeded records will be transferred to 'success' relationship while the original input FlowFile stays in incoming queue. Duplicated records can be created for the succeeded ones when the same FlowFile is processed again.
   */
  public final PutHiveStreaming setRollbackOnFailure(final String rollbackOnFailure) {
    properties.put(ROLLBACK_ON_FAILURE_PROPERTY, rollbackOnFailure);
    return this;
  }

  /**
   * Specify how to handle error. By default (false), if an error occurs while processing a FlowFile, the FlowFile will be routed to 'failure' or 'retry' relationship based on error type, and processor can continue with next FlowFile. Instead, you may want to rollback currently processed FlowFiles and stop further processing immediately. In that case, you can do so by enabling this 'Rollback On Failure' property.  If enabled, failed FlowFiles will stay in the input relationship without penalizing it and being processed repeatedly until it gets processed successfully or removed by other means. It is important to set adequate 'Yield Duration' to avoid retrying too frequently.NOTE: When an error occurred after a Hive streaming transaction which is derived from the same input FlowFile is already committed, (i.e. a FlowFile contains more records than 'Records per Transaction' and a failure occurred at the 2nd transaction or later) then the succeeded records will be transferred to 'success' relationship while the original input FlowFile stays in incoming queue. Duplicated records can be created for the succeeded ones when the same FlowFile is processed again.
   */
  public final PutHiveStreaming removeRollbackOnFailure() {
    properties.remove(ROLLBACK_ON_FAILURE_PROPERTY);
    return this;
  }

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public final String getKerberosCredentialsService() {
    return properties.get(KERBEROS_CREDENTIALS_SERVICE_PROPERTY);
  }

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public final PutHiveStreaming setKerberosCredentialsService(
      final String kerberosCredentialsService) {
    properties.put(KERBEROS_CREDENTIALS_SERVICE_PROPERTY, kerberosCredentialsService);
    return this;
  }

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public final PutHiveStreaming removeKerberosCredentialsService() {
    properties.remove(KERBEROS_CREDENTIALS_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final String getKerberosPrincipal() {
    return properties.get(KERBEROS_PRINCIPAL_PROPERTY);
  }

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final PutHiveStreaming setKerberosPrincipal(final String kerberosPrincipal) {
    properties.put(KERBEROS_PRINCIPAL_PROPERTY, kerberosPrincipal);
    return this;
  }

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final PutHiveStreaming removeKerberosPrincipal() {
    properties.remove(KERBEROS_PRINCIPAL_PROPERTY);
    return this;
  }

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final String getKerberosKeytab() {
    return properties.get(KERBEROS_KEYTAB_PROPERTY);
  }

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final PutHiveStreaming setKerberosKeytab(final String kerberosKeytab) {
    properties.put(KERBEROS_KEYTAB_PROPERTY, kerberosKeytab);
    return this;
  }

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final PutHiveStreaming removeKerberosKeytab() {
    properties.remove(KERBEROS_KEYTAB_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutHiveStreaming setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutHiveStreaming removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<PutHiveStreaming, PutHiveStreaming> configurator) {
    return configurator.apply(new PutHiveStreaming()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutHiveStreaming.class) final Closure<PutHiveStreaming> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.hive.PutHiveStreaming> code = closure.rehydrate(c, com.tibtech.nifi.processors.hive.PutHiveStreaming.class, com.tibtech.nifi.processors.hive.PutHiveStreaming.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutHiveStreaming, PutHiveStreaming> configurator) {
    return configurator.apply(new PutHiveStreaming(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutHiveStreaming.class) final Closure<PutHiveStreaming> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.hive.PutHiveStreaming> code = closure.rehydrate(c, com.tibtech.nifi.processors.hive.PutHiveStreaming.class, com.tibtech.nifi.processors.hive.PutHiveStreaming.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
