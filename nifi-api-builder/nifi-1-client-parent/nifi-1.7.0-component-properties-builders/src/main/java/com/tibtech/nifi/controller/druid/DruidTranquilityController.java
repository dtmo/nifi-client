package com.tibtech.nifi.controller.druid;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class DruidTranquilityController {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.controller.druid.DruidTranquilityController";

  /**
   * A data source is the Druid equivalent of a database table.
   */
  public static final String DRUID_CS_DATA_SOURCE_PROPERTY = "druid-cs-data-source";

  /**
   * A comma-separated list of host:port pairs, each corresponding to a ZooKeeper server. Ex: localhost:2181
   */
  public static final String DRUID_CS_ZK_CONNECT_STRING_PROPERTY = "druid-cs-zk-connect-string";

  /**
   * When a connection to Zookeeper needs to be retried, this property specifies the amount of time (in milliseconds) to wait at first before retrying.
   */
  public static final String DRUID_CS_ZK_RETRY_BASE_SLEEP_PROPERTY = "druid-cs-zk-retry-base-sleep";

  /**
   * When a connection to Zookeeper needs to be retried, this property specifies how many times to attempt reconnection.
   */
  public static final String DRUID_CS_ZK_RETRY_MAX_RETRIES_PROPERTY = "druid-cs-zk-retry-max-retries";

  /**
   * When a connection to Zookeeper needs to be retried, this property specifies the amount of time to sleep (in milliseconds) between retries.
   */
  public static final String DRUID_CS_ZK_RETRY_SLEEP_PROPERTY = "druid-cs-zk-retry-sleep";

  /**
   * Druid Index Service path as defined via the Druid Overlord druid.service property.
   */
  public static final String DRUID_CS_INDEX_SERVICE_PATH_PROPERTY = "druid-cs-index-service-path";

  /**
   * Druid Discovery Path as configured in Druid Common druid.discovery.curator.path property
   */
  public static final String DRUID_CS_DISCOVERY_PATH_PROPERTY = "druid-cs-discovery-path";

  /**
   * The number of partitions in the Druid cluster.
   */
  public static final String DRUID_CS_CLUSTER_PARTITIONS_PROPERTY = "druid-cs-cluster-partitions";

  /**
   * The replication factor for the Druid cluster.
   */
  public static final String DRUID_CS_CLUSTER_REPLICATION_PROPERTY = "druid-cs-cluster-replication";

  /**
   * A comma separated list of field names that will be stored as dimensions on ingest.
   */
  public static final String DRUID_CS_DIMENSIONS_LIST_PROPERTY = "druid-cs-dimensions-list";

  /**
   * Tranquility-compliant JSON string that defines what aggregators to apply on ingest.Example: [{	"type" : "count",	"name" : "count",},{	"name" : "value_sum",	"type" : "doubleSum",	"fieldName" : "value"},{	"fieldName" : "value",	"name" : "value_min",	"type" : "doubleMin"},{	"type" : "doubleMax",	"name" : "value_max",	"fieldName" : "value"}]
   */
  public static final String DRUID_CS_AGGREGATORS_DESCRIPTOR_PROPERTY = "druid-cs-aggregators-descriptor";

  /**
   * Time unit by which to group and aggregate/rollup events. The value must be at least as large as the value of Query Granularity.
   */
  public static final String DRUID_CS_SEGMENT_GRANULARITY_PROPERTY = "druid-cs-segment-granularity";

  /**
   * Time unit by which to group and aggregate/rollup events. The value must be less than or equal to the value of Segment Granularity.
   */
  public static final String DRUID_CS_QUERY_GRANULARITY_PROPERTY = "druid-cs-query-granularity";

  /**
   * Grace period to allow late arriving events for real time ingest.
   */
  public static final String DRUID_CS_WINDOW_PERIOD_PROPERTY = "druid-cs-window-period";

  /**
   * The name of the field that will be used as the timestamp. Should be in ISO8601 format.
   */
  public static final String DRUID_CS_TIMESTAMP_FIELD_PROPERTY = "druid-cs-timestamp-field";

  /**
   * Maximum number of messages to send at once.
   */
  public static final String DRUID_CS_BATCH_SIZE_PROPERTY = "druid-cs-batch-size";

  /**
   * Maximum number of batches that may be in flight before service blocks and waits for one to finish.
   */
  public static final String DRUID_CS_MAX_PENDING_BATCHES_PROPERTY = "druid-cs-max-pending-batches";

  /**
   * Wait this long for batches to collect more messages (up to Batch Size) before sending them. Set to zero to disable waiting. Set to -1 to always wait for complete batches before sending. 
   */
  public static final String DRUID_CS_LINGER_MILLIS_PROPERTY = "druid-cs-linger-millis";

  private final Map<String, String> properties;

  public DruidTranquilityController() {
    this.properties = new HashMap<>();
  }

  public DruidTranquilityController(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * A data source is the Druid equivalent of a database table.
   */
  public final String getDruidCsDataSource() {
    return properties.get(DRUID_CS_DATA_SOURCE_PROPERTY);
  }

  /**
   * A data source is the Druid equivalent of a database table.
   */
  public final DruidTranquilityController setDruidCsDataSource(final String druidCsDataSource) {
    properties.put(DRUID_CS_DATA_SOURCE_PROPERTY, druidCsDataSource);
    return this;
  }

  /**
   * A data source is the Druid equivalent of a database table.
   */
  public final DruidTranquilityController removeDruidCsDataSource() {
    properties.remove(DRUID_CS_DATA_SOURCE_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of host:port pairs, each corresponding to a ZooKeeper server. Ex: localhost:2181
   */
  public final String getDruidCsZkConnectString() {
    return properties.get(DRUID_CS_ZK_CONNECT_STRING_PROPERTY);
  }

  /**
   * A comma-separated list of host:port pairs, each corresponding to a ZooKeeper server. Ex: localhost:2181
   */
  public final DruidTranquilityController setDruidCsZkConnectString(
      final String druidCsZkConnectString) {
    properties.put(DRUID_CS_ZK_CONNECT_STRING_PROPERTY, druidCsZkConnectString);
    return this;
  }

  /**
   * A comma-separated list of host:port pairs, each corresponding to a ZooKeeper server. Ex: localhost:2181
   */
  public final DruidTranquilityController removeDruidCsZkConnectString() {
    properties.remove(DRUID_CS_ZK_CONNECT_STRING_PROPERTY);
    return this;
  }

  /**
   * When a connection to Zookeeper needs to be retried, this property specifies the amount of time (in milliseconds) to wait at first before retrying.
   */
  public final String getDruidCsZkRetryBaseSleep() {
    return properties.get(DRUID_CS_ZK_RETRY_BASE_SLEEP_PROPERTY);
  }

  /**
   * When a connection to Zookeeper needs to be retried, this property specifies the amount of time (in milliseconds) to wait at first before retrying.
   */
  public final DruidTranquilityController setDruidCsZkRetryBaseSleep(
      final String druidCsZkRetryBaseSleep) {
    properties.put(DRUID_CS_ZK_RETRY_BASE_SLEEP_PROPERTY, druidCsZkRetryBaseSleep);
    return this;
  }

  /**
   * When a connection to Zookeeper needs to be retried, this property specifies the amount of time (in milliseconds) to wait at first before retrying.
   */
  public final DruidTranquilityController removeDruidCsZkRetryBaseSleep() {
    properties.remove(DRUID_CS_ZK_RETRY_BASE_SLEEP_PROPERTY);
    return this;
  }

  /**
   * When a connection to Zookeeper needs to be retried, this property specifies how many times to attempt reconnection.
   */
  public final String getDruidCsZkRetryMaxRetries() {
    return properties.get(DRUID_CS_ZK_RETRY_MAX_RETRIES_PROPERTY);
  }

  /**
   * When a connection to Zookeeper needs to be retried, this property specifies how many times to attempt reconnection.
   */
  public final DruidTranquilityController setDruidCsZkRetryMaxRetries(
      final String druidCsZkRetryMaxRetries) {
    properties.put(DRUID_CS_ZK_RETRY_MAX_RETRIES_PROPERTY, druidCsZkRetryMaxRetries);
    return this;
  }

  /**
   * When a connection to Zookeeper needs to be retried, this property specifies how many times to attempt reconnection.
   */
  public final DruidTranquilityController removeDruidCsZkRetryMaxRetries() {
    properties.remove(DRUID_CS_ZK_RETRY_MAX_RETRIES_PROPERTY);
    return this;
  }

  /**
   * When a connection to Zookeeper needs to be retried, this property specifies the amount of time to sleep (in milliseconds) between retries.
   */
  public final String getDruidCsZkRetrySleep() {
    return properties.get(DRUID_CS_ZK_RETRY_SLEEP_PROPERTY);
  }

  /**
   * When a connection to Zookeeper needs to be retried, this property specifies the amount of time to sleep (in milliseconds) between retries.
   */
  public final DruidTranquilityController setDruidCsZkRetrySleep(final String druidCsZkRetrySleep) {
    properties.put(DRUID_CS_ZK_RETRY_SLEEP_PROPERTY, druidCsZkRetrySleep);
    return this;
  }

  /**
   * When a connection to Zookeeper needs to be retried, this property specifies the amount of time to sleep (in milliseconds) between retries.
   */
  public final DruidTranquilityController removeDruidCsZkRetrySleep() {
    properties.remove(DRUID_CS_ZK_RETRY_SLEEP_PROPERTY);
    return this;
  }

  /**
   * Druid Index Service path as defined via the Druid Overlord druid.service property.
   */
  public final String getDruidCsIndexServicePath() {
    return properties.get(DRUID_CS_INDEX_SERVICE_PATH_PROPERTY);
  }

  /**
   * Druid Index Service path as defined via the Druid Overlord druid.service property.
   */
  public final DruidTranquilityController setDruidCsIndexServicePath(
      final String druidCsIndexServicePath) {
    properties.put(DRUID_CS_INDEX_SERVICE_PATH_PROPERTY, druidCsIndexServicePath);
    return this;
  }

  /**
   * Druid Index Service path as defined via the Druid Overlord druid.service property.
   */
  public final DruidTranquilityController removeDruidCsIndexServicePath() {
    properties.remove(DRUID_CS_INDEX_SERVICE_PATH_PROPERTY);
    return this;
  }

  /**
   * Druid Discovery Path as configured in Druid Common druid.discovery.curator.path property
   */
  public final String getDruidCsDiscoveryPath() {
    return properties.get(DRUID_CS_DISCOVERY_PATH_PROPERTY);
  }

  /**
   * Druid Discovery Path as configured in Druid Common druid.discovery.curator.path property
   */
  public final DruidTranquilityController setDruidCsDiscoveryPath(
      final String druidCsDiscoveryPath) {
    properties.put(DRUID_CS_DISCOVERY_PATH_PROPERTY, druidCsDiscoveryPath);
    return this;
  }

  /**
   * Druid Discovery Path as configured in Druid Common druid.discovery.curator.path property
   */
  public final DruidTranquilityController removeDruidCsDiscoveryPath() {
    properties.remove(DRUID_CS_DISCOVERY_PATH_PROPERTY);
    return this;
  }

  /**
   * The number of partitions in the Druid cluster.
   */
  public final String getDruidCsClusterPartitions() {
    return properties.get(DRUID_CS_CLUSTER_PARTITIONS_PROPERTY);
  }

  /**
   * The number of partitions in the Druid cluster.
   */
  public final DruidTranquilityController setDruidCsClusterPartitions(
      final String druidCsClusterPartitions) {
    properties.put(DRUID_CS_CLUSTER_PARTITIONS_PROPERTY, druidCsClusterPartitions);
    return this;
  }

  /**
   * The number of partitions in the Druid cluster.
   */
  public final DruidTranquilityController removeDruidCsClusterPartitions() {
    properties.remove(DRUID_CS_CLUSTER_PARTITIONS_PROPERTY);
    return this;
  }

  /**
   * The replication factor for the Druid cluster.
   */
  public final String getDruidCsClusterReplication() {
    return properties.get(DRUID_CS_CLUSTER_REPLICATION_PROPERTY);
  }

  /**
   * The replication factor for the Druid cluster.
   */
  public final DruidTranquilityController setDruidCsClusterReplication(
      final String druidCsClusterReplication) {
    properties.put(DRUID_CS_CLUSTER_REPLICATION_PROPERTY, druidCsClusterReplication);
    return this;
  }

  /**
   * The replication factor for the Druid cluster.
   */
  public final DruidTranquilityController removeDruidCsClusterReplication() {
    properties.remove(DRUID_CS_CLUSTER_REPLICATION_PROPERTY);
    return this;
  }

  /**
   * A comma separated list of field names that will be stored as dimensions on ingest.
   */
  public final String getDruidCsDimensionsList() {
    return properties.get(DRUID_CS_DIMENSIONS_LIST_PROPERTY);
  }

  /**
   * A comma separated list of field names that will be stored as dimensions on ingest.
   */
  public final DruidTranquilityController setDruidCsDimensionsList(
      final String druidCsDimensionsList) {
    properties.put(DRUID_CS_DIMENSIONS_LIST_PROPERTY, druidCsDimensionsList);
    return this;
  }

  /**
   * A comma separated list of field names that will be stored as dimensions on ingest.
   */
  public final DruidTranquilityController removeDruidCsDimensionsList() {
    properties.remove(DRUID_CS_DIMENSIONS_LIST_PROPERTY);
    return this;
  }

  /**
   * Tranquility-compliant JSON string that defines what aggregators to apply on ingest.Example: [{	"type" : "count",	"name" : "count",},{	"name" : "value_sum",	"type" : "doubleSum",	"fieldName" : "value"},{	"fieldName" : "value",	"name" : "value_min",	"type" : "doubleMin"},{	"type" : "doubleMax",	"name" : "value_max",	"fieldName" : "value"}]
   */
  public final String getDruidCsAggregatorsDescriptor() {
    return properties.get(DRUID_CS_AGGREGATORS_DESCRIPTOR_PROPERTY);
  }

  /**
   * Tranquility-compliant JSON string that defines what aggregators to apply on ingest.Example: [{	"type" : "count",	"name" : "count",},{	"name" : "value_sum",	"type" : "doubleSum",	"fieldName" : "value"},{	"fieldName" : "value",	"name" : "value_min",	"type" : "doubleMin"},{	"type" : "doubleMax",	"name" : "value_max",	"fieldName" : "value"}]
   */
  public final DruidTranquilityController setDruidCsAggregatorsDescriptor(
      final String druidCsAggregatorsDescriptor) {
    properties.put(DRUID_CS_AGGREGATORS_DESCRIPTOR_PROPERTY, druidCsAggregatorsDescriptor);
    return this;
  }

  /**
   * Tranquility-compliant JSON string that defines what aggregators to apply on ingest.Example: [{	"type" : "count",	"name" : "count",},{	"name" : "value_sum",	"type" : "doubleSum",	"fieldName" : "value"},{	"fieldName" : "value",	"name" : "value_min",	"type" : "doubleMin"},{	"type" : "doubleMax",	"name" : "value_max",	"fieldName" : "value"}]
   */
  public final DruidTranquilityController removeDruidCsAggregatorsDescriptor() {
    properties.remove(DRUID_CS_AGGREGATORS_DESCRIPTOR_PROPERTY);
    return this;
  }

  /**
   * Time unit by which to group and aggregate/rollup events. The value must be at least as large as the value of Query Granularity.
   */
  public final String getDruidCsSegmentGranularity() {
    return properties.get(DRUID_CS_SEGMENT_GRANULARITY_PROPERTY);
  }

  /**
   * Time unit by which to group and aggregate/rollup events. The value must be at least as large as the value of Query Granularity.
   */
  public final DruidTranquilityController setDruidCsSegmentGranularity(
      final String druidCsSegmentGranularity) {
    properties.put(DRUID_CS_SEGMENT_GRANULARITY_PROPERTY, druidCsSegmentGranularity);
    return this;
  }

  /**
   * Time unit by which to group and aggregate/rollup events. The value must be at least as large as the value of Query Granularity.
   */
  public final DruidTranquilityController removeDruidCsSegmentGranularity() {
    properties.remove(DRUID_CS_SEGMENT_GRANULARITY_PROPERTY);
    return this;
  }

  /**
   * Time unit by which to group and aggregate/rollup events. The value must be less than or equal to the value of Segment Granularity.
   */
  public final String getDruidCsQueryGranularity() {
    return properties.get(DRUID_CS_QUERY_GRANULARITY_PROPERTY);
  }

  /**
   * Time unit by which to group and aggregate/rollup events. The value must be less than or equal to the value of Segment Granularity.
   */
  public final DruidTranquilityController setDruidCsQueryGranularity(
      final String druidCsQueryGranularity) {
    properties.put(DRUID_CS_QUERY_GRANULARITY_PROPERTY, druidCsQueryGranularity);
    return this;
  }

  /**
   * Time unit by which to group and aggregate/rollup events. The value must be less than or equal to the value of Segment Granularity.
   */
  public final DruidTranquilityController removeDruidCsQueryGranularity() {
    properties.remove(DRUID_CS_QUERY_GRANULARITY_PROPERTY);
    return this;
  }

  /**
   * Grace period to allow late arriving events for real time ingest.
   */
  public final String getDruidCsWindowPeriod() {
    return properties.get(DRUID_CS_WINDOW_PERIOD_PROPERTY);
  }

  /**
   * Grace period to allow late arriving events for real time ingest.
   */
  public final DruidTranquilityController setDruidCsWindowPeriod(final String druidCsWindowPeriod) {
    properties.put(DRUID_CS_WINDOW_PERIOD_PROPERTY, druidCsWindowPeriod);
    return this;
  }

  /**
   * Grace period to allow late arriving events for real time ingest.
   */
  public final DruidTranquilityController removeDruidCsWindowPeriod() {
    properties.remove(DRUID_CS_WINDOW_PERIOD_PROPERTY);
    return this;
  }

  /**
   * The name of the field that will be used as the timestamp. Should be in ISO8601 format.
   */
  public final String getDruidCsTimestampField() {
    return properties.get(DRUID_CS_TIMESTAMP_FIELD_PROPERTY);
  }

  /**
   * The name of the field that will be used as the timestamp. Should be in ISO8601 format.
   */
  public final DruidTranquilityController setDruidCsTimestampField(
      final String druidCsTimestampField) {
    properties.put(DRUID_CS_TIMESTAMP_FIELD_PROPERTY, druidCsTimestampField);
    return this;
  }

  /**
   * The name of the field that will be used as the timestamp. Should be in ISO8601 format.
   */
  public final DruidTranquilityController removeDruidCsTimestampField() {
    properties.remove(DRUID_CS_TIMESTAMP_FIELD_PROPERTY);
    return this;
  }

  /**
   * Maximum number of messages to send at once.
   */
  public final String getDruidCsBatchSize() {
    return properties.get(DRUID_CS_BATCH_SIZE_PROPERTY);
  }

  /**
   * Maximum number of messages to send at once.
   */
  public final DruidTranquilityController setDruidCsBatchSize(final String druidCsBatchSize) {
    properties.put(DRUID_CS_BATCH_SIZE_PROPERTY, druidCsBatchSize);
    return this;
  }

  /**
   * Maximum number of messages to send at once.
   */
  public final DruidTranquilityController removeDruidCsBatchSize() {
    properties.remove(DRUID_CS_BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * Maximum number of batches that may be in flight before service blocks and waits for one to finish.
   */
  public final String getDruidCsMaxPendingBatches() {
    return properties.get(DRUID_CS_MAX_PENDING_BATCHES_PROPERTY);
  }

  /**
   * Maximum number of batches that may be in flight before service blocks and waits for one to finish.
   */
  public final DruidTranquilityController setDruidCsMaxPendingBatches(
      final String druidCsMaxPendingBatches) {
    properties.put(DRUID_CS_MAX_PENDING_BATCHES_PROPERTY, druidCsMaxPendingBatches);
    return this;
  }

  /**
   * Maximum number of batches that may be in flight before service blocks and waits for one to finish.
   */
  public final DruidTranquilityController removeDruidCsMaxPendingBatches() {
    properties.remove(DRUID_CS_MAX_PENDING_BATCHES_PROPERTY);
    return this;
  }

  /**
   * Wait this long for batches to collect more messages (up to Batch Size) before sending them. Set to zero to disable waiting. Set to -1 to always wait for complete batches before sending. 
   */
  public final String getDruidCsLingerMillis() {
    return properties.get(DRUID_CS_LINGER_MILLIS_PROPERTY);
  }

  /**
   * Wait this long for batches to collect more messages (up to Batch Size) before sending them. Set to zero to disable waiting. Set to -1 to always wait for complete batches before sending. 
   */
  public final DruidTranquilityController setDruidCsLingerMillis(final String druidCsLingerMillis) {
    properties.put(DRUID_CS_LINGER_MILLIS_PROPERTY, druidCsLingerMillis);
    return this;
  }

  /**
   * Wait this long for batches to collect more messages (up to Batch Size) before sending them. Set to zero to disable waiting. Set to -1 to always wait for complete batches before sending. 
   */
  public final DruidTranquilityController removeDruidCsLingerMillis() {
    properties.remove(DRUID_CS_LINGER_MILLIS_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final DruidTranquilityController setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final DruidTranquilityController removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<DruidTranquilityController, DruidTranquilityController> configurator) {
    return configurator.apply(new DruidTranquilityController()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DruidTranquilityController.class) final Closure<DruidTranquilityController> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.controller.druid.DruidTranquilityController> code = closure.rehydrate(c, com.tibtech.nifi.controller.druid.DruidTranquilityController.class, com.tibtech.nifi.controller.druid.DruidTranquilityController.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<DruidTranquilityController, DruidTranquilityController> configurator) {
    return configurator.apply(new DruidTranquilityController(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DruidTranquilityController.class) final Closure<DruidTranquilityController> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.controller.druid.DruidTranquilityController> code = closure.rehydrate(c, com.tibtech.nifi.controller.druid.DruidTranquilityController.class, com.tibtech.nifi.controller.druid.DruidTranquilityController.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
