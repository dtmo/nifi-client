package com.tibtech.nifi.processors.kafka.pubsub;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ConsumeKafka {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.kafka.pubsub.ConsumeKafka";

  /**
   * A comma-separated list of known Kafka Brokers in the format <host>:<port>
   */
  public static final String BOOTSTRAP_SERVERS_PROPERTY = "bootstrap.servers";

  /**
   * Protocol used to communicate with brokers. Corresponds to Kafka's 'security.protocol' property.
   */
  public static final String SECURITY_PROTOCOL_PROPERTY = "security.protocol";

  /**
   * The Kerberos principal name that Kafka runs as. This can be defined either in Kafka's JAAS config or in Kafka's config. Corresponds to Kafka's 'security.protocol' property.It is ignored unless one of the SASL options of the <Security Protocol> are selected.
   */
  public static final String SASL_KERBEROS_SERVICE_NAME_PROPERTY = "sasl.kerberos.service.name";

  /**
   * Specifies the SSL Context Service to use for communicating with Kafka.
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "ssl.context.service";

  /**
   * The name of the Kafka Topic(s) to pull from. More than one can be supplied if comma separated.
   */
  public static final String TOPIC_PROPERTY = "topic";

  /**
   * A Group ID is used to identify consumers that are within the same consumer group. Corresponds to Kafka's 'group.id' property.
   */
  public static final String GROUP_ID_PROPERTY = "group.id";

  /**
   * Allows you to manage the condition when there is no initial offset in Kafka or if the current offset does not exist any more on the server (e.g. because that data has been deleted). Corresponds to Kafka's 'auto.offset.reset' property.
   */
  public static final String AUTO_OFFSET_RESET_PROPERTY = "auto.offset.reset";

  /**
   * FlowFiles that are emitted have an attribute named 'kafka.key'. This property dictates how the value of the attribute should be encoded.
   */
  public static final String KEY_ATTRIBUTE_ENCODING_PROPERTY = "key-attribute-encoding";

  /**
   * Since KafkaConsumer receives messages in batches, you have an option to output FlowFiles which contains all Kafka messages in a single batch for a given topic and partition and this property allows you to provide a string (interpreted as UTF-8) to use for demarcating apart multiple Kafka messages. This is an optional property and if not provided each Kafka message received will result in a single FlowFile which  time it is triggered. To enter special character such as 'new line' use CTRL+Enter or Shift+Enter depending on the OS
   */
  public static final String MESSAGE_DEMARCATOR_PROPERTY = "message-demarcator";

  /**
   * Specifies the maximum number of records Kafka should return in a single poll.
   */
  public static final String MAX_POLL_RECORDS_PROPERTY = "max.poll.records";

  /**
   * Specifies the maximum amount of time allowed to pass before offsets must be committed. This value impacts how often offsets will be committed.  Committing offsets less often increases throughput but also increases the window of potential data duplication in the event of a rebalance or JVM restart between commits.  This value is also related to maximum poll records and the use of a message demarcator.  When using a message demarcator we can have far more uncommitted messages than when we're not as there is much less for us to keep track of in memory.
   */
  public static final String MAX_UNCOMMIT_OFFSET_WAIT_PROPERTY = "max-uncommit-offset-wait";

  private final Map<String, String> properties;

  public ConsumeKafka() {
    this.properties = new HashMap<>();
  }

  public ConsumeKafka(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * A comma-separated list of known Kafka Brokers in the format <host>:<port>
   */
  public final String getBootstrapServers() {
    return properties.get(BOOTSTRAP_SERVERS_PROPERTY);
  }

  /**
   * A comma-separated list of known Kafka Brokers in the format <host>:<port>
   */
  public final ConsumeKafka setBootstrapServers(final String bootstrapServers) {
    properties.put(BOOTSTRAP_SERVERS_PROPERTY, bootstrapServers);
    return this;
  }

  /**
   * A comma-separated list of known Kafka Brokers in the format <host>:<port>
   */
  public final ConsumeKafka removeBootstrapServers() {
    properties.remove(BOOTSTRAP_SERVERS_PROPERTY);
    return this;
  }

  /**
   * Protocol used to communicate with brokers. Corresponds to Kafka's 'security.protocol' property.
   */
  public final String getSecurityProtocol() {
    return properties.get(SECURITY_PROTOCOL_PROPERTY);
  }

  /**
   * Protocol used to communicate with brokers. Corresponds to Kafka's 'security.protocol' property.
   */
  public final ConsumeKafka setSecurityProtocol(final String securityProtocol) {
    properties.put(SECURITY_PROTOCOL_PROPERTY, securityProtocol);
    return this;
  }

  /**
   * Protocol used to communicate with brokers. Corresponds to Kafka's 'security.protocol' property.
   */
  public final ConsumeKafka removeSecurityProtocol() {
    properties.remove(SECURITY_PROTOCOL_PROPERTY);
    return this;
  }

  /**
   * The Kerberos principal name that Kafka runs as. This can be defined either in Kafka's JAAS config or in Kafka's config. Corresponds to Kafka's 'security.protocol' property.It is ignored unless one of the SASL options of the <Security Protocol> are selected.
   */
  public final String getSaslKerberosServiceName() {
    return properties.get(SASL_KERBEROS_SERVICE_NAME_PROPERTY);
  }

  /**
   * The Kerberos principal name that Kafka runs as. This can be defined either in Kafka's JAAS config or in Kafka's config. Corresponds to Kafka's 'security.protocol' property.It is ignored unless one of the SASL options of the <Security Protocol> are selected.
   */
  public final ConsumeKafka setSaslKerberosServiceName(final String saslKerberosServiceName) {
    properties.put(SASL_KERBEROS_SERVICE_NAME_PROPERTY, saslKerberosServiceName);
    return this;
  }

  /**
   * The Kerberos principal name that Kafka runs as. This can be defined either in Kafka's JAAS config or in Kafka's config. Corresponds to Kafka's 'security.protocol' property.It is ignored unless one of the SASL options of the <Security Protocol> are selected.
   */
  public final ConsumeKafka removeSaslKerberosServiceName() {
    properties.remove(SASL_KERBEROS_SERVICE_NAME_PROPERTY);
    return this;
  }

  /**
   * Specifies the SSL Context Service to use for communicating with Kafka.
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * Specifies the SSL Context Service to use for communicating with Kafka.
   */
  public final ConsumeKafka setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * Specifies the SSL Context Service to use for communicating with Kafka.
   */
  public final ConsumeKafka removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The name of the Kafka Topic(s) to pull from. More than one can be supplied if comma separated.
   */
  public final String getTopic() {
    return properties.get(TOPIC_PROPERTY);
  }

  /**
   * The name of the Kafka Topic(s) to pull from. More than one can be supplied if comma separated.
   */
  public final ConsumeKafka setTopic(final String topic) {
    properties.put(TOPIC_PROPERTY, topic);
    return this;
  }

  /**
   * The name of the Kafka Topic(s) to pull from. More than one can be supplied if comma separated.
   */
  public final ConsumeKafka removeTopic() {
    properties.remove(TOPIC_PROPERTY);
    return this;
  }

  /**
   * A Group ID is used to identify consumers that are within the same consumer group. Corresponds to Kafka's 'group.id' property.
   */
  public final String getGroupId() {
    return properties.get(GROUP_ID_PROPERTY);
  }

  /**
   * A Group ID is used to identify consumers that are within the same consumer group. Corresponds to Kafka's 'group.id' property.
   */
  public final ConsumeKafka setGroupId(final String groupId) {
    properties.put(GROUP_ID_PROPERTY, groupId);
    return this;
  }

  /**
   * A Group ID is used to identify consumers that are within the same consumer group. Corresponds to Kafka's 'group.id' property.
   */
  public final ConsumeKafka removeGroupId() {
    properties.remove(GROUP_ID_PROPERTY);
    return this;
  }

  /**
   * Allows you to manage the condition when there is no initial offset in Kafka or if the current offset does not exist any more on the server (e.g. because that data has been deleted). Corresponds to Kafka's 'auto.offset.reset' property.
   */
  public final String getAutoOffsetReset() {
    return properties.get(AUTO_OFFSET_RESET_PROPERTY);
  }

  /**
   * Allows you to manage the condition when there is no initial offset in Kafka or if the current offset does not exist any more on the server (e.g. because that data has been deleted). Corresponds to Kafka's 'auto.offset.reset' property.
   */
  public final ConsumeKafka setAutoOffsetReset(final String autoOffsetReset) {
    properties.put(AUTO_OFFSET_RESET_PROPERTY, autoOffsetReset);
    return this;
  }

  /**
   * Allows you to manage the condition when there is no initial offset in Kafka or if the current offset does not exist any more on the server (e.g. because that data has been deleted). Corresponds to Kafka's 'auto.offset.reset' property.
   */
  public final ConsumeKafka removeAutoOffsetReset() {
    properties.remove(AUTO_OFFSET_RESET_PROPERTY);
    return this;
  }

  /**
   * FlowFiles that are emitted have an attribute named 'kafka.key'. This property dictates how the value of the attribute should be encoded.
   */
  public final String getKeyAttributeEncoding() {
    return properties.get(KEY_ATTRIBUTE_ENCODING_PROPERTY);
  }

  /**
   * FlowFiles that are emitted have an attribute named 'kafka.key'. This property dictates how the value of the attribute should be encoded.
   */
  public final ConsumeKafka setKeyAttributeEncoding(final String keyAttributeEncoding) {
    properties.put(KEY_ATTRIBUTE_ENCODING_PROPERTY, keyAttributeEncoding);
    return this;
  }

  /**
   * FlowFiles that are emitted have an attribute named 'kafka.key'. This property dictates how the value of the attribute should be encoded.
   */
  public final ConsumeKafka removeKeyAttributeEncoding() {
    properties.remove(KEY_ATTRIBUTE_ENCODING_PROPERTY);
    return this;
  }

  /**
   * Since KafkaConsumer receives messages in batches, you have an option to output FlowFiles which contains all Kafka messages in a single batch for a given topic and partition and this property allows you to provide a string (interpreted as UTF-8) to use for demarcating apart multiple Kafka messages. This is an optional property and if not provided each Kafka message received will result in a single FlowFile which  time it is triggered. To enter special character such as 'new line' use CTRL+Enter or Shift+Enter depending on the OS
   */
  public final String getMessageDemarcator() {
    return properties.get(MESSAGE_DEMARCATOR_PROPERTY);
  }

  /**
   * Since KafkaConsumer receives messages in batches, you have an option to output FlowFiles which contains all Kafka messages in a single batch for a given topic and partition and this property allows you to provide a string (interpreted as UTF-8) to use for demarcating apart multiple Kafka messages. This is an optional property and if not provided each Kafka message received will result in a single FlowFile which  time it is triggered. To enter special character such as 'new line' use CTRL+Enter or Shift+Enter depending on the OS
   */
  public final ConsumeKafka setMessageDemarcator(final String messageDemarcator) {
    properties.put(MESSAGE_DEMARCATOR_PROPERTY, messageDemarcator);
    return this;
  }

  /**
   * Since KafkaConsumer receives messages in batches, you have an option to output FlowFiles which contains all Kafka messages in a single batch for a given topic and partition and this property allows you to provide a string (interpreted as UTF-8) to use for demarcating apart multiple Kafka messages. This is an optional property and if not provided each Kafka message received will result in a single FlowFile which  time it is triggered. To enter special character such as 'new line' use CTRL+Enter or Shift+Enter depending on the OS
   */
  public final ConsumeKafka removeMessageDemarcator() {
    properties.remove(MESSAGE_DEMARCATOR_PROPERTY);
    return this;
  }

  /**
   * Specifies the maximum number of records Kafka should return in a single poll.
   */
  public final String getMaxPollRecords() {
    return properties.get(MAX_POLL_RECORDS_PROPERTY);
  }

  /**
   * Specifies the maximum number of records Kafka should return in a single poll.
   */
  public final ConsumeKafka setMaxPollRecords(final String maxPollRecords) {
    properties.put(MAX_POLL_RECORDS_PROPERTY, maxPollRecords);
    return this;
  }

  /**
   * Specifies the maximum number of records Kafka should return in a single poll.
   */
  public final ConsumeKafka removeMaxPollRecords() {
    properties.remove(MAX_POLL_RECORDS_PROPERTY);
    return this;
  }

  /**
   * Specifies the maximum amount of time allowed to pass before offsets must be committed. This value impacts how often offsets will be committed.  Committing offsets less often increases throughput but also increases the window of potential data duplication in the event of a rebalance or JVM restart between commits.  This value is also related to maximum poll records and the use of a message demarcator.  When using a message demarcator we can have far more uncommitted messages than when we're not as there is much less for us to keep track of in memory.
   */
  public final String getMaxUncommitOffsetWait() {
    return properties.get(MAX_UNCOMMIT_OFFSET_WAIT_PROPERTY);
  }

  /**
   * Specifies the maximum amount of time allowed to pass before offsets must be committed. This value impacts how often offsets will be committed.  Committing offsets less often increases throughput but also increases the window of potential data duplication in the event of a rebalance or JVM restart between commits.  This value is also related to maximum poll records and the use of a message demarcator.  When using a message demarcator we can have far more uncommitted messages than when we're not as there is much less for us to keep track of in memory.
   */
  public final ConsumeKafka setMaxUncommitOffsetWait(final String maxUncommitOffsetWait) {
    properties.put(MAX_UNCOMMIT_OFFSET_WAIT_PROPERTY, maxUncommitOffsetWait);
    return this;
  }

  /**
   * Specifies the maximum amount of time allowed to pass before offsets must be committed. This value impacts how often offsets will be committed.  Committing offsets less often increases throughput but also increases the window of potential data duplication in the event of a rebalance or JVM restart between commits.  This value is also related to maximum poll records and the use of a message demarcator.  When using a message demarcator we can have far more uncommitted messages than when we're not as there is much less for us to keep track of in memory.
   */
  public final ConsumeKafka removeMaxUncommitOffsetWait() {
    properties.remove(MAX_UNCOMMIT_OFFSET_WAIT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ConsumeKafka setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ConsumeKafka removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ConsumeKafka, ConsumeKafka> configurator) {
    return configurator.apply(new ConsumeKafka()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConsumeKafka.class) final Closure<ConsumeKafka> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.kafka.pubsub.ConsumeKafka> code = closure.rehydrate(c, com.tibtech.nifi.processors.kafka.pubsub.ConsumeKafka.class, com.tibtech.nifi.processors.kafka.pubsub.ConsumeKafka.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ConsumeKafka, ConsumeKafka> configurator) {
    return configurator.apply(new ConsumeKafka(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConsumeKafka.class) final Closure<ConsumeKafka> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.kafka.pubsub.ConsumeKafka> code = closure.rehydrate(c, com.tibtech.nifi.processors.kafka.pubsub.ConsumeKafka.class, com.tibtech.nifi.processors.kafka.pubsub.ConsumeKafka.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
