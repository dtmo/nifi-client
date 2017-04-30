package com.tibtech.nifi.processors.kafka;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GetKafka {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.kafka.GetKafka";

  /**
   * The Connection String to use in order to connect to ZooKeeper. This is often a comma-separated list of <host>:<port> combinations. For example, host1:2181,host2:2181,host3:2188
   */
  public static final String ZOO_KEEPER_CONNECTION_STRING_PROPERTY = "ZooKeeper Connection String";

  /**
   * The Kafka Topic to pull messages from
   */
  public static final String TOPIC_NAME_PROPERTY = "Topic Name";

  /**
   * Specifies how often to communicate with ZooKeeper to indicate which messages have been pulled. A longer time period will result in better overall performance but can result in more data duplication if a NiFi node is lost
   */
  public static final String ZOOKEEPER_COMMIT_FREQUENCY_PROPERTY = "Zookeeper Commit Frequency";

  /**
   * Specifies the maximum number of messages to combine into a single FlowFile. These messages will be concatenated together with the <Message Demarcator> string placed between the content of each message. If the messages from Kafka should not be concatenated together, leave this value at 1.
   */
  public static final String BATCH_SIZE_PROPERTY = "Batch Size";

  /**
   * Specifies the characters to use in order to demarcate multiple messages from Kafka. If the <Batch Size> property is set to 1, this value is ignored. Otherwise, for each two subsequent messages in the batch, this value will be placed in between them.
   */
  public static final String MESSAGE_DEMARCATOR_PROPERTY = "Message Demarcator";

  /**
   * Client Name to use when communicating with Kafka
   */
  public static final String CLIENT_NAME_PROPERTY = "Client Name";

  /**
   * A Group ID is used to identify consumers that are within the same consumer group
   */
  public static final String GROUP_ID_PROPERTY = "Group ID";

  /**
   * The amount of time to wait for a response from Kafka before determining that there is a communications error
   */
  public static final String KAFKA_COMMUNICATIONS_TIMEOUT_PROPERTY = "Kafka Communications Timeout";

  /**
   * The amount of time to wait for a response from ZooKeeper before determining that there is a communications error
   */
  public static final String ZOO_KEEPER_COMMUNICATIONS_TIMEOUT_PROPERTY = "ZooKeeper Communications Timeout";

  /**
   * Automatically reset the offset to the smallest or largest offset available on the broker
   */
  public static final String AUTO_OFFSET_RESET_PROPERTY = "Auto Offset Reset";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The Connection String to use in order to connect to ZooKeeper. This is often a comma-separated list of <host>:<port> combinations. For example, host1:2181,host2:2181,host3:2188
   */
  public final String getZooKeeperConnectionString() {
    return properties.get(ZOO_KEEPER_CONNECTION_STRING_PROPERTY);
  }

  /**
   * The Connection String to use in order to connect to ZooKeeper. This is often a comma-separated list of <host>:<port> combinations. For example, host1:2181,host2:2181,host3:2188
   */
  public final GetKafka setZooKeeperConnectionString(final String zooKeeperConnectionString) {
    properties.put(ZOO_KEEPER_CONNECTION_STRING_PROPERTY, zooKeeperConnectionString);
    return this;
  }

  /**
   * The Connection String to use in order to connect to ZooKeeper. This is often a comma-separated list of <host>:<port> combinations. For example, host1:2181,host2:2181,host3:2188
   */
  public final GetKafka removeZooKeeperConnectionString() {
    properties.remove(ZOO_KEEPER_CONNECTION_STRING_PROPERTY);
    return this;
  }

  /**
   * The Kafka Topic to pull messages from
   */
  public final String getTopicName() {
    return properties.get(TOPIC_NAME_PROPERTY);
  }

  /**
   * The Kafka Topic to pull messages from
   */
  public final GetKafka setTopicName(final String topicName) {
    properties.put(TOPIC_NAME_PROPERTY, topicName);
    return this;
  }

  /**
   * The Kafka Topic to pull messages from
   */
  public final GetKafka removeTopicName() {
    properties.remove(TOPIC_NAME_PROPERTY);
    return this;
  }

  /**
   * Specifies how often to communicate with ZooKeeper to indicate which messages have been pulled. A longer time period will result in better overall performance but can result in more data duplication if a NiFi node is lost
   */
  public final String getZookeeperCommitFrequency() {
    return properties.get(ZOOKEEPER_COMMIT_FREQUENCY_PROPERTY);
  }

  /**
   * Specifies how often to communicate with ZooKeeper to indicate which messages have been pulled. A longer time period will result in better overall performance but can result in more data duplication if a NiFi node is lost
   */
  public final GetKafka setZookeeperCommitFrequency(final String zookeeperCommitFrequency) {
    properties.put(ZOOKEEPER_COMMIT_FREQUENCY_PROPERTY, zookeeperCommitFrequency);
    return this;
  }

  /**
   * Specifies how often to communicate with ZooKeeper to indicate which messages have been pulled. A longer time period will result in better overall performance but can result in more data duplication if a NiFi node is lost
   */
  public final GetKafka removeZookeeperCommitFrequency() {
    properties.remove(ZOOKEEPER_COMMIT_FREQUENCY_PROPERTY);
    return this;
  }

  /**
   * Specifies the maximum number of messages to combine into a single FlowFile. These messages will be concatenated together with the <Message Demarcator> string placed between the content of each message. If the messages from Kafka should not be concatenated together, leave this value at 1.
   */
  public final String getBatchSize() {
    return properties.get(BATCH_SIZE_PROPERTY);
  }

  /**
   * Specifies the maximum number of messages to combine into a single FlowFile. These messages will be concatenated together with the <Message Demarcator> string placed between the content of each message. If the messages from Kafka should not be concatenated together, leave this value at 1.
   */
  public final GetKafka setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * Specifies the maximum number of messages to combine into a single FlowFile. These messages will be concatenated together with the <Message Demarcator> string placed between the content of each message. If the messages from Kafka should not be concatenated together, leave this value at 1.
   */
  public final GetKafka removeBatchSize() {
    properties.remove(BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * Specifies the characters to use in order to demarcate multiple messages from Kafka. If the <Batch Size> property is set to 1, this value is ignored. Otherwise, for each two subsequent messages in the batch, this value will be placed in between them.
   */
  public final String getMessageDemarcator() {
    return properties.get(MESSAGE_DEMARCATOR_PROPERTY);
  }

  /**
   * Specifies the characters to use in order to demarcate multiple messages from Kafka. If the <Batch Size> property is set to 1, this value is ignored. Otherwise, for each two subsequent messages in the batch, this value will be placed in between them.
   */
  public final GetKafka setMessageDemarcator(final String messageDemarcator) {
    properties.put(MESSAGE_DEMARCATOR_PROPERTY, messageDemarcator);
    return this;
  }

  /**
   * Specifies the characters to use in order to demarcate multiple messages from Kafka. If the <Batch Size> property is set to 1, this value is ignored. Otherwise, for each two subsequent messages in the batch, this value will be placed in between them.
   */
  public final GetKafka removeMessageDemarcator() {
    properties.remove(MESSAGE_DEMARCATOR_PROPERTY);
    return this;
  }

  /**
   * Client Name to use when communicating with Kafka
   */
  public final String getClientName() {
    return properties.get(CLIENT_NAME_PROPERTY);
  }

  /**
   * Client Name to use when communicating with Kafka
   */
  public final GetKafka setClientName(final String clientName) {
    properties.put(CLIENT_NAME_PROPERTY, clientName);
    return this;
  }

  /**
   * Client Name to use when communicating with Kafka
   */
  public final GetKafka removeClientName() {
    properties.remove(CLIENT_NAME_PROPERTY);
    return this;
  }

  /**
   * A Group ID is used to identify consumers that are within the same consumer group
   */
  public final String getGroupId() {
    return properties.get(GROUP_ID_PROPERTY);
  }

  /**
   * A Group ID is used to identify consumers that are within the same consumer group
   */
  public final GetKafka setGroupId(final String groupId) {
    properties.put(GROUP_ID_PROPERTY, groupId);
    return this;
  }

  /**
   * A Group ID is used to identify consumers that are within the same consumer group
   */
  public final GetKafka removeGroupId() {
    properties.remove(GROUP_ID_PROPERTY);
    return this;
  }

  /**
   * The amount of time to wait for a response from Kafka before determining that there is a communications error
   */
  public final String getKafkaCommunicationsTimeout() {
    return properties.get(KAFKA_COMMUNICATIONS_TIMEOUT_PROPERTY);
  }

  /**
   * The amount of time to wait for a response from Kafka before determining that there is a communications error
   */
  public final GetKafka setKafkaCommunicationsTimeout(final String kafkaCommunicationsTimeout) {
    properties.put(KAFKA_COMMUNICATIONS_TIMEOUT_PROPERTY, kafkaCommunicationsTimeout);
    return this;
  }

  /**
   * The amount of time to wait for a response from Kafka before determining that there is a communications error
   */
  public final GetKafka removeKafkaCommunicationsTimeout() {
    properties.remove(KAFKA_COMMUNICATIONS_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The amount of time to wait for a response from ZooKeeper before determining that there is a communications error
   */
  public final String getZooKeeperCommunicationsTimeout() {
    return properties.get(ZOO_KEEPER_COMMUNICATIONS_TIMEOUT_PROPERTY);
  }

  /**
   * The amount of time to wait for a response from ZooKeeper before determining that there is a communications error
   */
  public final GetKafka setZooKeeperCommunicationsTimeout(final String zooKeeperCommunicationsTimeout) {
    properties.put(ZOO_KEEPER_COMMUNICATIONS_TIMEOUT_PROPERTY, zooKeeperCommunicationsTimeout);
    return this;
  }

  /**
   * The amount of time to wait for a response from ZooKeeper before determining that there is a communications error
   */
  public final GetKafka removeZooKeeperCommunicationsTimeout() {
    properties.remove(ZOO_KEEPER_COMMUNICATIONS_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * Automatically reset the offset to the smallest or largest offset available on the broker
   */
  public final String getAutoOffsetReset() {
    return properties.get(AUTO_OFFSET_RESET_PROPERTY);
  }

  /**
   * Automatically reset the offset to the smallest or largest offset available on the broker
   */
  public final GetKafka setAutoOffsetReset(final String autoOffsetReset) {
    properties.put(AUTO_OFFSET_RESET_PROPERTY, autoOffsetReset);
    return this;
  }

  /**
   * Automatically reset the offset to the smallest or largest offset available on the broker
   */
  public final GetKafka removeAutoOffsetReset() {
    properties.remove(AUTO_OFFSET_RESET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GetKafka setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GetKafka removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<GetKafka, GetKafka> configurator) {
    return configurator.apply(new GetKafka()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetKafka.class) final Closure<GetKafka> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.kafka.GetKafka> code = closure.rehydrate(c, com.tibtech.nifi.processors.kafka.GetKafka.class, com.tibtech.nifi.processors.kafka.GetKafka.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
