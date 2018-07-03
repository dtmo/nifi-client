package com.tibtech.nifi.processors.azure.eventhub;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ConsumeAzureEventHub {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.azure.eventhub.ConsumeAzureEventHub";

  /**
   * The Azure Namespace that the Event Hub is assigned to. This is generally equal to <Event Hub Name>-ns.
   */
  public static final String EVENT_HUB_NAMESPACE_PROPERTY = "event-hub-namespace";

  /**
   * The name of the Azure Event Hub to pull messages from.
   */
  public static final String EVENT_HUB_NAME_PROPERTY = "event-hub-name";

  /**
   * The name of the Event Hub Shared Access Policy. This Policy must have Listen permissions.
   */
  public static final String EVENT_HUB_SHARED_ACCESS_POLICY_NAME_PROPERTY = "event-hub-shared-access-policy-name";

  /**
   * The primary key of the Event Hub Shared Access Policy.
   */
  public static final String EVENT_HUB_SHARED_ACCESS_POLICY_PRIMARY_KEY_PROPERTY = "event-hub-shared-access-policy-primary-key";

  /**
   * The name of the Event Hub Consumer Group to use.
   */
  public static final String EVENT_HUB_CONSUMER_GROUP_PROPERTY = "event-hub-consumer-group";

  /**
   * The hostname of this Event Hub Consumer instance. If not specified, an unique identifier is generated in 'nifi-<UUID>' format.
   */
  public static final String EVENT_HUB_CONSUMER_HOSTNAME_PROPERTY = "event-hub-consumer-hostname";

  /**
   * The Record Reader to use for reading received messages. The Event Hub name can be referred by Expression Language '${eventhub.name}' to access a schema.
   */
  public static final String RECORD_READER_PROPERTY = "record-reader";

  /**
   * The Record Writer to use for serializing Records to an output FlowFile. The Event Hub name can be referred by Expression Language '${eventhub.name}' to access a schema. If not specified, each message will create a FlowFile.
   */
  public static final String RECORD_WRITER_PROPERTY = "record-writer";

  /**
   * Specify where to start receiving messages if offset is not stored in Azure Storage.
   */
  public static final String EVENT_HUB_INITIAL_OFFSET_PROPERTY = "event-hub-initial-offset";

  /**
   *
   */
  public static final String EVENT_HUB_PREFETCH_COUNT_PROPERTY = "event-hub-prefetch-count";

  /**
   * The number of messages to process within a NiFi session. This parameter affects throughput and consistency. NiFi commits its session and Event Hub checkpoint after processing this number of messages. If NiFi session is committed, but failed to create an Event Hub checkpoint, then it is possible that the same messages to be retrieved again. The higher number, the higher throughput, but possibly less consistent.
   */
  public static final String EVENT_HUB_BATCH_SIZE_PROPERTY = "event-hub-batch-size";

  /**
   * The amount of time this consumer should wait to receive the Prefetch Count before returning.
   */
  public static final String EVENT_HUB_MESSAGE_RECEIVE_TIMEOUT_PROPERTY = "event-hub-message-receive-timeout";

  /**
   * Name of the Azure Storage account to store Event Hub Consumer Group state.
   */
  public static final String STORAGE_ACCOUNT_NAME_PROPERTY = "storage-account-name";

  /**
   * The Azure Storage account key to store Event Hub Consumer Group state.
   */
  public static final String STORAGE_ACCOUNT_KEY_PROPERTY = "storage-account-key";

  /**
   * Name of the Azure Storage Container to store Event Hub Consumer Group state. If not specified, Event Hub name is used.
   */
  public static final String STORAGE_CONTAINER_NAME_PROPERTY = "storage-container-name";

  private final Map<String, String> properties;

  public ConsumeAzureEventHub() {
    this.properties = new HashMap<>();
  }

  public ConsumeAzureEventHub(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The Azure Namespace that the Event Hub is assigned to. This is generally equal to <Event Hub Name>-ns.
   */
  public final String getEventHubNamespace() {
    return properties.get(EVENT_HUB_NAMESPACE_PROPERTY);
  }

  /**
   * The Azure Namespace that the Event Hub is assigned to. This is generally equal to <Event Hub Name>-ns.
   */
  public final ConsumeAzureEventHub setEventHubNamespace(final String eventHubNamespace) {
    properties.put(EVENT_HUB_NAMESPACE_PROPERTY, eventHubNamespace);
    return this;
  }

  /**
   * The Azure Namespace that the Event Hub is assigned to. This is generally equal to <Event Hub Name>-ns.
   */
  public final ConsumeAzureEventHub removeEventHubNamespace() {
    properties.remove(EVENT_HUB_NAMESPACE_PROPERTY);
    return this;
  }

  /**
   * The name of the Azure Event Hub to pull messages from.
   */
  public final String getEventHubName() {
    return properties.get(EVENT_HUB_NAME_PROPERTY);
  }

  /**
   * The name of the Azure Event Hub to pull messages from.
   */
  public final ConsumeAzureEventHub setEventHubName(final String eventHubName) {
    properties.put(EVENT_HUB_NAME_PROPERTY, eventHubName);
    return this;
  }

  /**
   * The name of the Azure Event Hub to pull messages from.
   */
  public final ConsumeAzureEventHub removeEventHubName() {
    properties.remove(EVENT_HUB_NAME_PROPERTY);
    return this;
  }

  /**
   * The name of the Event Hub Shared Access Policy. This Policy must have Listen permissions.
   */
  public final String getEventHubSharedAccessPolicyName() {
    return properties.get(EVENT_HUB_SHARED_ACCESS_POLICY_NAME_PROPERTY);
  }

  /**
   * The name of the Event Hub Shared Access Policy. This Policy must have Listen permissions.
   */
  public final ConsumeAzureEventHub setEventHubSharedAccessPolicyName(
      final String eventHubSharedAccessPolicyName) {
    properties.put(EVENT_HUB_SHARED_ACCESS_POLICY_NAME_PROPERTY, eventHubSharedAccessPolicyName);
    return this;
  }

  /**
   * The name of the Event Hub Shared Access Policy. This Policy must have Listen permissions.
   */
  public final ConsumeAzureEventHub removeEventHubSharedAccessPolicyName() {
    properties.remove(EVENT_HUB_SHARED_ACCESS_POLICY_NAME_PROPERTY);
    return this;
  }

  /**
   * The primary key of the Event Hub Shared Access Policy.
   */
  public final String getEventHubSharedAccessPolicyPrimaryKey() {
    return properties.get(EVENT_HUB_SHARED_ACCESS_POLICY_PRIMARY_KEY_PROPERTY);
  }

  /**
   * The primary key of the Event Hub Shared Access Policy.
   */
  public final ConsumeAzureEventHub setEventHubSharedAccessPolicyPrimaryKey(
      final String eventHubSharedAccessPolicyPrimaryKey) {
    properties.put(EVENT_HUB_SHARED_ACCESS_POLICY_PRIMARY_KEY_PROPERTY, eventHubSharedAccessPolicyPrimaryKey);
    return this;
  }

  /**
   * The primary key of the Event Hub Shared Access Policy.
   */
  public final ConsumeAzureEventHub removeEventHubSharedAccessPolicyPrimaryKey() {
    properties.remove(EVENT_HUB_SHARED_ACCESS_POLICY_PRIMARY_KEY_PROPERTY);
    return this;
  }

  /**
   * The name of the Event Hub Consumer Group to use.
   */
  public final String getEventHubConsumerGroup() {
    return properties.get(EVENT_HUB_CONSUMER_GROUP_PROPERTY);
  }

  /**
   * The name of the Event Hub Consumer Group to use.
   */
  public final ConsumeAzureEventHub setEventHubConsumerGroup(final String eventHubConsumerGroup) {
    properties.put(EVENT_HUB_CONSUMER_GROUP_PROPERTY, eventHubConsumerGroup);
    return this;
  }

  /**
   * The name of the Event Hub Consumer Group to use.
   */
  public final ConsumeAzureEventHub removeEventHubConsumerGroup() {
    properties.remove(EVENT_HUB_CONSUMER_GROUP_PROPERTY);
    return this;
  }

  /**
   * The hostname of this Event Hub Consumer instance. If not specified, an unique identifier is generated in 'nifi-<UUID>' format.
   */
  public final String getEventHubConsumerHostname() {
    return properties.get(EVENT_HUB_CONSUMER_HOSTNAME_PROPERTY);
  }

  /**
   * The hostname of this Event Hub Consumer instance. If not specified, an unique identifier is generated in 'nifi-<UUID>' format.
   */
  public final ConsumeAzureEventHub setEventHubConsumerHostname(
      final String eventHubConsumerHostname) {
    properties.put(EVENT_HUB_CONSUMER_HOSTNAME_PROPERTY, eventHubConsumerHostname);
    return this;
  }

  /**
   * The hostname of this Event Hub Consumer instance. If not specified, an unique identifier is generated in 'nifi-<UUID>' format.
   */
  public final ConsumeAzureEventHub removeEventHubConsumerHostname() {
    properties.remove(EVENT_HUB_CONSUMER_HOSTNAME_PROPERTY);
    return this;
  }

  /**
   * The Record Reader to use for reading received messages. The Event Hub name can be referred by Expression Language '${eventhub.name}' to access a schema.
   */
  public final String getRecordReader() {
    return properties.get(RECORD_READER_PROPERTY);
  }

  /**
   * The Record Reader to use for reading received messages. The Event Hub name can be referred by Expression Language '${eventhub.name}' to access a schema.
   */
  public final ConsumeAzureEventHub setRecordReader(final String recordReader) {
    properties.put(RECORD_READER_PROPERTY, recordReader);
    return this;
  }

  /**
   * The Record Reader to use for reading received messages. The Event Hub name can be referred by Expression Language '${eventhub.name}' to access a schema.
   */
  public final ConsumeAzureEventHub removeRecordReader() {
    properties.remove(RECORD_READER_PROPERTY);
    return this;
  }

  /**
   * The Record Writer to use for serializing Records to an output FlowFile. The Event Hub name can be referred by Expression Language '${eventhub.name}' to access a schema. If not specified, each message will create a FlowFile.
   */
  public final String getRecordWriter() {
    return properties.get(RECORD_WRITER_PROPERTY);
  }

  /**
   * The Record Writer to use for serializing Records to an output FlowFile. The Event Hub name can be referred by Expression Language '${eventhub.name}' to access a schema. If not specified, each message will create a FlowFile.
   */
  public final ConsumeAzureEventHub setRecordWriter(final String recordWriter) {
    properties.put(RECORD_WRITER_PROPERTY, recordWriter);
    return this;
  }

  /**
   * The Record Writer to use for serializing Records to an output FlowFile. The Event Hub name can be referred by Expression Language '${eventhub.name}' to access a schema. If not specified, each message will create a FlowFile.
   */
  public final ConsumeAzureEventHub removeRecordWriter() {
    properties.remove(RECORD_WRITER_PROPERTY);
    return this;
  }

  /**
   * Specify where to start receiving messages if offset is not stored in Azure Storage.
   */
  public final String getEventHubInitialOffset() {
    return properties.get(EVENT_HUB_INITIAL_OFFSET_PROPERTY);
  }

  /**
   * Specify where to start receiving messages if offset is not stored in Azure Storage.
   */
  public final ConsumeAzureEventHub setEventHubInitialOffset(final String eventHubInitialOffset) {
    properties.put(EVENT_HUB_INITIAL_OFFSET_PROPERTY, eventHubInitialOffset);
    return this;
  }

  /**
   * Specify where to start receiving messages if offset is not stored in Azure Storage.
   */
  public final ConsumeAzureEventHub removeEventHubInitialOffset() {
    properties.remove(EVENT_HUB_INITIAL_OFFSET_PROPERTY);
    return this;
  }

  /**
   *
   */
  public final String getEventHubPrefetchCount() {
    return properties.get(EVENT_HUB_PREFETCH_COUNT_PROPERTY);
  }

  /**
   *
   */
  public final ConsumeAzureEventHub setEventHubPrefetchCount(final String eventHubPrefetchCount) {
    properties.put(EVENT_HUB_PREFETCH_COUNT_PROPERTY, eventHubPrefetchCount);
    return this;
  }

  /**
   *
   */
  public final ConsumeAzureEventHub removeEventHubPrefetchCount() {
    properties.remove(EVENT_HUB_PREFETCH_COUNT_PROPERTY);
    return this;
  }

  /**
   * The number of messages to process within a NiFi session. This parameter affects throughput and consistency. NiFi commits its session and Event Hub checkpoint after processing this number of messages. If NiFi session is committed, but failed to create an Event Hub checkpoint, then it is possible that the same messages to be retrieved again. The higher number, the higher throughput, but possibly less consistent.
   */
  public final String getEventHubBatchSize() {
    return properties.get(EVENT_HUB_BATCH_SIZE_PROPERTY);
  }

  /**
   * The number of messages to process within a NiFi session. This parameter affects throughput and consistency. NiFi commits its session and Event Hub checkpoint after processing this number of messages. If NiFi session is committed, but failed to create an Event Hub checkpoint, then it is possible that the same messages to be retrieved again. The higher number, the higher throughput, but possibly less consistent.
   */
  public final ConsumeAzureEventHub setEventHubBatchSize(final String eventHubBatchSize) {
    properties.put(EVENT_HUB_BATCH_SIZE_PROPERTY, eventHubBatchSize);
    return this;
  }

  /**
   * The number of messages to process within a NiFi session. This parameter affects throughput and consistency. NiFi commits its session and Event Hub checkpoint after processing this number of messages. If NiFi session is committed, but failed to create an Event Hub checkpoint, then it is possible that the same messages to be retrieved again. The higher number, the higher throughput, but possibly less consistent.
   */
  public final ConsumeAzureEventHub removeEventHubBatchSize() {
    properties.remove(EVENT_HUB_BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * The amount of time this consumer should wait to receive the Prefetch Count before returning.
   */
  public final String getEventHubMessageReceiveTimeout() {
    return properties.get(EVENT_HUB_MESSAGE_RECEIVE_TIMEOUT_PROPERTY);
  }

  /**
   * The amount of time this consumer should wait to receive the Prefetch Count before returning.
   */
  public final ConsumeAzureEventHub setEventHubMessageReceiveTimeout(
      final String eventHubMessageReceiveTimeout) {
    properties.put(EVENT_HUB_MESSAGE_RECEIVE_TIMEOUT_PROPERTY, eventHubMessageReceiveTimeout);
    return this;
  }

  /**
   * The amount of time this consumer should wait to receive the Prefetch Count before returning.
   */
  public final ConsumeAzureEventHub removeEventHubMessageReceiveTimeout() {
    properties.remove(EVENT_HUB_MESSAGE_RECEIVE_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * Name of the Azure Storage account to store Event Hub Consumer Group state.
   */
  public final String getStorageAccountName() {
    return properties.get(STORAGE_ACCOUNT_NAME_PROPERTY);
  }

  /**
   * Name of the Azure Storage account to store Event Hub Consumer Group state.
   */
  public final ConsumeAzureEventHub setStorageAccountName(final String storageAccountName) {
    properties.put(STORAGE_ACCOUNT_NAME_PROPERTY, storageAccountName);
    return this;
  }

  /**
   * Name of the Azure Storage account to store Event Hub Consumer Group state.
   */
  public final ConsumeAzureEventHub removeStorageAccountName() {
    properties.remove(STORAGE_ACCOUNT_NAME_PROPERTY);
    return this;
  }

  /**
   * The Azure Storage account key to store Event Hub Consumer Group state.
   */
  public final String getStorageAccountKey() {
    return properties.get(STORAGE_ACCOUNT_KEY_PROPERTY);
  }

  /**
   * The Azure Storage account key to store Event Hub Consumer Group state.
   */
  public final ConsumeAzureEventHub setStorageAccountKey(final String storageAccountKey) {
    properties.put(STORAGE_ACCOUNT_KEY_PROPERTY, storageAccountKey);
    return this;
  }

  /**
   * The Azure Storage account key to store Event Hub Consumer Group state.
   */
  public final ConsumeAzureEventHub removeStorageAccountKey() {
    properties.remove(STORAGE_ACCOUNT_KEY_PROPERTY);
    return this;
  }

  /**
   * Name of the Azure Storage Container to store Event Hub Consumer Group state. If not specified, Event Hub name is used.
   */
  public final String getStorageContainerName() {
    return properties.get(STORAGE_CONTAINER_NAME_PROPERTY);
  }

  /**
   * Name of the Azure Storage Container to store Event Hub Consumer Group state. If not specified, Event Hub name is used.
   */
  public final ConsumeAzureEventHub setStorageContainerName(final String storageContainerName) {
    properties.put(STORAGE_CONTAINER_NAME_PROPERTY, storageContainerName);
    return this;
  }

  /**
   * Name of the Azure Storage Container to store Event Hub Consumer Group state. If not specified, Event Hub name is used.
   */
  public final ConsumeAzureEventHub removeStorageContainerName() {
    properties.remove(STORAGE_CONTAINER_NAME_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ConsumeAzureEventHub setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ConsumeAzureEventHub removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ConsumeAzureEventHub, ConsumeAzureEventHub> configurator) {
    return configurator.apply(new ConsumeAzureEventHub()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConsumeAzureEventHub.class) final Closure<ConsumeAzureEventHub> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.azure.eventhub.ConsumeAzureEventHub> code = closure.rehydrate(c, com.tibtech.nifi.processors.azure.eventhub.ConsumeAzureEventHub.class, com.tibtech.nifi.processors.azure.eventhub.ConsumeAzureEventHub.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ConsumeAzureEventHub, ConsumeAzureEventHub> configurator) {
    return configurator.apply(new ConsumeAzureEventHub(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConsumeAzureEventHub.class) final Closure<ConsumeAzureEventHub> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.azure.eventhub.ConsumeAzureEventHub> code = closure.rehydrate(c, com.tibtech.nifi.processors.azure.eventhub.ConsumeAzureEventHub.class, com.tibtech.nifi.processors.azure.eventhub.ConsumeAzureEventHub.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
