package com.tibtech.nifi.processors.azure.eventhub;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GetAzureEventHub {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.azure.eventhub.GetAzureEventHub";

  /**
   * The name of the Azure Event Hub to pull messages from
   */
  public static final String EVENT_HUB_NAME_PROPERTY = "Event Hub Name";

  /**
   * The Azure Namespace that the Event Hub is assigned to. This is generally equal to <Event Hub Name>-ns
   */
  public static final String EVENT_HUB_NAMESPACE_PROPERTY = "Event Hub Namespace";

  /**
   * The name of the Event Hub Shared Access Policy. This Policy must have Listen permissions.
   */
  public static final String SHARED_ACCESS_POLICY_NAME_PROPERTY = "Shared Access Policy Name";

  /**
   * The primary key of the Event Hub Shared Access Policy
   */
  public static final String SHARED_ACCESS_POLICY_PRIMARY_KEY_PROPERTY = "Shared Access Policy Primary Key";

  /**
   * The number of partitions that the Event Hub has. Only this number of partitions will be used, so it is important to ensure that if the number of partitions changes that this value be updated. Otherwise, some messages may not be consumed.
   */
  public static final String NUMBER_OF_EVENT_HUB_PARTITIONS_PROPERTY = "Number of Event Hub Partitions";

  /**
   * The name of the Event Hub Consumer Group to use when pulling events
   */
  public static final String EVENT_HUB_CONSUMER_GROUP_PROPERTY = "Event Hub Consumer Group";

  /**
   * A timestamp (ISO-8061 Instant) formatted as YYYY-MM-DDThhmmss.sssZ (2016-01-01T01:01:01.000Z) from which messages should have been enqueued in the EventHub to start reading from
   */
  public static final String EVENT_HUB_MESSAGE_ENQUEUE_TIME_PROPERTY = "Event Hub Message Enqueue Time";

  /**
   * The number of events that a receiver should fetch from an EventHubs partition before returning. Default(100)
   */
  public static final String PARTITION_RECIVIER_FETCH_SIZE_PROPERTY = "Partition Recivier Fetch Size";

  /**
   * The amount of time a Partition Receiver should wait to receive the Fetch Size before returning. Default(60000)
   */
  public static final String PARTITON_RECEIVER_TIMEOUT_MILLSECONDS_PROPERTY = "Partiton Receiver Timeout (millseconds)";

  private final Map<String, String> properties;

  public GetAzureEventHub() {
    this.properties = new HashMap<>();
  }

  public GetAzureEventHub(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The name of the Azure Event Hub to pull messages from
   */
  public final String getEventHubName() {
    return properties.get(EVENT_HUB_NAME_PROPERTY);
  }

  /**
   * The name of the Azure Event Hub to pull messages from
   */
  public final GetAzureEventHub setEventHubName(final String eventHubName) {
    properties.put(EVENT_HUB_NAME_PROPERTY, eventHubName);
    return this;
  }

  /**
   * The name of the Azure Event Hub to pull messages from
   */
  public final GetAzureEventHub removeEventHubName() {
    properties.remove(EVENT_HUB_NAME_PROPERTY);
    return this;
  }

  /**
   * The Azure Namespace that the Event Hub is assigned to. This is generally equal to <Event Hub Name>-ns
   */
  public final String getEventHubNamespace() {
    return properties.get(EVENT_HUB_NAMESPACE_PROPERTY);
  }

  /**
   * The Azure Namespace that the Event Hub is assigned to. This is generally equal to <Event Hub Name>-ns
   */
  public final GetAzureEventHub setEventHubNamespace(final String eventHubNamespace) {
    properties.put(EVENT_HUB_NAMESPACE_PROPERTY, eventHubNamespace);
    return this;
  }

  /**
   * The Azure Namespace that the Event Hub is assigned to. This is generally equal to <Event Hub Name>-ns
   */
  public final GetAzureEventHub removeEventHubNamespace() {
    properties.remove(EVENT_HUB_NAMESPACE_PROPERTY);
    return this;
  }

  /**
   * The name of the Event Hub Shared Access Policy. This Policy must have Listen permissions.
   */
  public final String getSharedAccessPolicyName() {
    return properties.get(SHARED_ACCESS_POLICY_NAME_PROPERTY);
  }

  /**
   * The name of the Event Hub Shared Access Policy. This Policy must have Listen permissions.
   */
  public final GetAzureEventHub setSharedAccessPolicyName(final String sharedAccessPolicyName) {
    properties.put(SHARED_ACCESS_POLICY_NAME_PROPERTY, sharedAccessPolicyName);
    return this;
  }

  /**
   * The name of the Event Hub Shared Access Policy. This Policy must have Listen permissions.
   */
  public final GetAzureEventHub removeSharedAccessPolicyName() {
    properties.remove(SHARED_ACCESS_POLICY_NAME_PROPERTY);
    return this;
  }

  /**
   * The primary key of the Event Hub Shared Access Policy
   */
  public final String getSharedAccessPolicyPrimaryKey() {
    return properties.get(SHARED_ACCESS_POLICY_PRIMARY_KEY_PROPERTY);
  }

  /**
   * The primary key of the Event Hub Shared Access Policy
   */
  public final GetAzureEventHub setSharedAccessPolicyPrimaryKey(final String sharedAccessPolicyPrimaryKey) {
    properties.put(SHARED_ACCESS_POLICY_PRIMARY_KEY_PROPERTY, sharedAccessPolicyPrimaryKey);
    return this;
  }

  /**
   * The primary key of the Event Hub Shared Access Policy
   */
  public final GetAzureEventHub removeSharedAccessPolicyPrimaryKey() {
    properties.remove(SHARED_ACCESS_POLICY_PRIMARY_KEY_PROPERTY);
    return this;
  }

  /**
   * The number of partitions that the Event Hub has. Only this number of partitions will be used, so it is important to ensure that if the number of partitions changes that this value be updated. Otherwise, some messages may not be consumed.
   */
  public final String getNumberOfEventHubPartitions() {
    return properties.get(NUMBER_OF_EVENT_HUB_PARTITIONS_PROPERTY);
  }

  /**
   * The number of partitions that the Event Hub has. Only this number of partitions will be used, so it is important to ensure that if the number of partitions changes that this value be updated. Otherwise, some messages may not be consumed.
   */
  public final GetAzureEventHub setNumberOfEventHubPartitions(final String numberOfEventHubPartitions) {
    properties.put(NUMBER_OF_EVENT_HUB_PARTITIONS_PROPERTY, numberOfEventHubPartitions);
    return this;
  }

  /**
   * The number of partitions that the Event Hub has. Only this number of partitions will be used, so it is important to ensure that if the number of partitions changes that this value be updated. Otherwise, some messages may not be consumed.
   */
  public final GetAzureEventHub removeNumberOfEventHubPartitions() {
    properties.remove(NUMBER_OF_EVENT_HUB_PARTITIONS_PROPERTY);
    return this;
  }

  /**
   * The name of the Event Hub Consumer Group to use when pulling events
   */
  public final String getEventHubConsumerGroup() {
    return properties.get(EVENT_HUB_CONSUMER_GROUP_PROPERTY);
  }

  /**
   * The name of the Event Hub Consumer Group to use when pulling events
   */
  public final GetAzureEventHub setEventHubConsumerGroup(final String eventHubConsumerGroup) {
    properties.put(EVENT_HUB_CONSUMER_GROUP_PROPERTY, eventHubConsumerGroup);
    return this;
  }

  /**
   * The name of the Event Hub Consumer Group to use when pulling events
   */
  public final GetAzureEventHub removeEventHubConsumerGroup() {
    properties.remove(EVENT_HUB_CONSUMER_GROUP_PROPERTY);
    return this;
  }

  /**
   * A timestamp (ISO-8061 Instant) formatted as YYYY-MM-DDThhmmss.sssZ (2016-01-01T01:01:01.000Z) from which messages should have been enqueued in the EventHub to start reading from
   */
  public final String getEventHubMessageEnqueueTime() {
    return properties.get(EVENT_HUB_MESSAGE_ENQUEUE_TIME_PROPERTY);
  }

  /**
   * A timestamp (ISO-8061 Instant) formatted as YYYY-MM-DDThhmmss.sssZ (2016-01-01T01:01:01.000Z) from which messages should have been enqueued in the EventHub to start reading from
   */
  public final GetAzureEventHub setEventHubMessageEnqueueTime(final String eventHubMessageEnqueueTime) {
    properties.put(EVENT_HUB_MESSAGE_ENQUEUE_TIME_PROPERTY, eventHubMessageEnqueueTime);
    return this;
  }

  /**
   * A timestamp (ISO-8061 Instant) formatted as YYYY-MM-DDThhmmss.sssZ (2016-01-01T01:01:01.000Z) from which messages should have been enqueued in the EventHub to start reading from
   */
  public final GetAzureEventHub removeEventHubMessageEnqueueTime() {
    properties.remove(EVENT_HUB_MESSAGE_ENQUEUE_TIME_PROPERTY);
    return this;
  }

  /**
   * The number of events that a receiver should fetch from an EventHubs partition before returning. Default(100)
   */
  public final String getPartitionRecivierFetchSize() {
    return properties.get(PARTITION_RECIVIER_FETCH_SIZE_PROPERTY);
  }

  /**
   * The number of events that a receiver should fetch from an EventHubs partition before returning. Default(100)
   */
  public final GetAzureEventHub setPartitionRecivierFetchSize(final String partitionRecivierFetchSize) {
    properties.put(PARTITION_RECIVIER_FETCH_SIZE_PROPERTY, partitionRecivierFetchSize);
    return this;
  }

  /**
   * The number of events that a receiver should fetch from an EventHubs partition before returning. Default(100)
   */
  public final GetAzureEventHub removePartitionRecivierFetchSize() {
    properties.remove(PARTITION_RECIVIER_FETCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * The amount of time a Partition Receiver should wait to receive the Fetch Size before returning. Default(60000)
   */
  public final String getPartitonReceiverTimeoutMillseconds() {
    return properties.get(PARTITON_RECEIVER_TIMEOUT_MILLSECONDS_PROPERTY);
  }

  /**
   * The amount of time a Partition Receiver should wait to receive the Fetch Size before returning. Default(60000)
   */
  public final GetAzureEventHub setPartitonReceiverTimeoutMillseconds(final String partitonReceiverTimeoutMillseconds) {
    properties.put(PARTITON_RECEIVER_TIMEOUT_MILLSECONDS_PROPERTY, partitonReceiverTimeoutMillseconds);
    return this;
  }

  /**
   * The amount of time a Partition Receiver should wait to receive the Fetch Size before returning. Default(60000)
   */
  public final GetAzureEventHub removePartitonReceiverTimeoutMillseconds() {
    properties.remove(PARTITON_RECEIVER_TIMEOUT_MILLSECONDS_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GetAzureEventHub setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GetAzureEventHub removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<GetAzureEventHub, GetAzureEventHub> configurator) {
    return configurator.apply(new GetAzureEventHub()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetAzureEventHub.class) final Closure<GetAzureEventHub> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.azure.eventhub.GetAzureEventHub> code = closure.rehydrate(c, com.tibtech.nifi.processors.azure.eventhub.GetAzureEventHub.class, com.tibtech.nifi.processors.azure.eventhub.GetAzureEventHub.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<GetAzureEventHub, GetAzureEventHub> configurator) {
    return configurator.apply(new GetAzureEventHub(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetAzureEventHub.class) final Closure<GetAzureEventHub> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.azure.eventhub.GetAzureEventHub> code = closure.rehydrate(c, com.tibtech.nifi.processors.azure.eventhub.GetAzureEventHub.class, com.tibtech.nifi.processors.azure.eventhub.GetAzureEventHub.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
