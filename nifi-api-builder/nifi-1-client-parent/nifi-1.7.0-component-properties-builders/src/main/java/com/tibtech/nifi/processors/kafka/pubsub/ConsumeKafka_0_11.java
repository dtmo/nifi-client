package com.tibtech.nifi.processors.kafka.pubsub;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ConsumeKafka_0_11 {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.kafka.pubsub.ConsumeKafka_0_11";

  /**
   * A comma-separated list of known Kafka Brokers in the format <host>:<port>
   */
  public static final String BOOTSTRAP_SERVERS_PROPERTY = "bootstrap.servers";

  /**
   * Protocol used to communicate with brokers. Corresponds to Kafka's 'security.protocol' property.
   */
  public static final String SECURITY_PROTOCOL_PROPERTY = "security.protocol";

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public static final String KERBEROS_CREDENTIALS_SERVICE_PROPERTY = "kerberos-credentials-service";

  /**
   * The Kerberos principal name that Kafka runs as. This can be defined either in Kafka's JAAS config or in Kafka's config. Corresponds to Kafka's 'security.protocol' property.It is ignored unless one of the SASL options of the <Security Protocol> are selected.
   */
  public static final String SASL_KERBEROS_SERVICE_NAME_PROPERTY = "sasl.kerberos.service.name";

  /**
   * The Kerberos principal that will be used to connect to brokers. If not set, it is expected to set a JAAS configuration file in the JVM properties defined in the bootstrap.conf file. This principal will be set into 'sasl.jaas.config' Kafka's property.
   */
  public static final String SASL_KERBEROS_PRINCIPAL_PROPERTY = "sasl.kerberos.principal";

  /**
   * The Kerberos keytab that will be used to connect to brokers. If not set, it is expected to set a JAAS configuration file in the JVM properties defined in the bootstrap.conf file. This principal will be set into 'sasl.jaas.config' Kafka's property.
   */
  public static final String SASL_KERBEROS_KEYTAB_PROPERTY = "sasl.kerberos.keytab";

  /**
   * Specifies the SSL Context Service to use for communicating with Kafka.
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "ssl.context.service";

  /**
   * The name of the Kafka Topic(s) to pull from. More than one can be supplied if comma separated.
   */
  public static final String TOPIC_PROPERTY = "topic";

  /**
   * Specifies whether the Topic(s) provided are a comma separated list of names or a single regular expression
   */
  public static final String TOPIC_TYPE_PROPERTY = "topic_type";

  /**
   * Specifies whether or not NiFi should honor transactional guarantees when communicating with Kafka. If false, the Processor will use an "isolation level" of read_uncomitted. This means that messages will be received as soon as they are written to Kafka but will be pulled, even if the producer cancels the transactions. If this value is true, NiFi will not receive any messages for which the producer's transaction was canceled, but this can result in some latency since the consumer must wait for the producer to finish its entire transaction instead of pulling as the messages become available.
   */
  public static final String HONOR_TRANSACTIONS_PROPERTY = "honor-transactions";

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
   * Any message header that is found on a Kafka message will be added to the outbound FlowFile as an attribute. This property indicates the Character Encoding to use for deserializing the headers.
   */
  public static final String MESSAGE_HEADER_ENCODING_PROPERTY = "message-header-encoding";

  /**
   * A Regular Expression that is matched against all message headers. Any message header whose name matches the regex will be added to the FlowFile as an Attribute. If not specified, no Header values will be added as FlowFile attributes. If two messages have a different value for the same header and that header is selected by the provided regex, then those two messages must be added to different FlowFiles. As a result, users should be cautious about using a regex like ".*" if messages are expected to have header values that are unique per message, such as an identifier or timestamp, because it will prevent NiFi from bundling the messages together efficiently.
   */
  public static final String HEADER_NAME_REGEX_PROPERTY = "header-name-regex";

  /**
   * Specifies the maximum number of records Kafka should return in a single poll.
   */
  public static final String MAX_POLL_RECORDS_PROPERTY = "max.poll.records";

  /**
   * Specifies the maximum amount of time allowed to pass before offsets must be committed. This value impacts how often offsets will be committed.  Committing offsets less often increases throughput but also increases the window of potential data duplication in the event of a rebalance or JVM restart between commits.  This value is also related to maximum poll records and the use of a message demarcator.  When using a message demarcator we can have far more uncommitted messages than when we're not as there is much less for us to keep track of in memory.
   */
  public static final String MAX_UNCOMMIT_OFFSET_WAIT_PROPERTY = "max-uncommit-offset-wait";

  private final Map<String, String> properties;

  public ConsumeKafka_0_11() {
    this.properties = new HashMap<>();
  }

  public ConsumeKafka_0_11(final Map<String, String> properties) {
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
  public final ConsumeKafka_0_11 setBootstrapServers(final String bootstrapServers) {
    properties.put(BOOTSTRAP_SERVERS_PROPERTY, bootstrapServers);
    return this;
  }

  /**
   * A comma-separated list of known Kafka Brokers in the format <host>:<port>
   */
  public final ConsumeKafka_0_11 removeBootstrapServers() {
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
  public final ConsumeKafka_0_11 setSecurityProtocol(final String securityProtocol) {
    properties.put(SECURITY_PROTOCOL_PROPERTY, securityProtocol);
    return this;
  }

  /**
   * Protocol used to communicate with brokers. Corresponds to Kafka's 'security.protocol' property.
   */
  public final ConsumeKafka_0_11 removeSecurityProtocol() {
    properties.remove(SECURITY_PROTOCOL_PROPERTY);
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
  public final ConsumeKafka_0_11 setKerberosCredentialsService(
      final String kerberosCredentialsService) {
    properties.put(KERBEROS_CREDENTIALS_SERVICE_PROPERTY, kerberosCredentialsService);
    return this;
  }

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public final ConsumeKafka_0_11 removeKerberosCredentialsService() {
    properties.remove(KERBEROS_CREDENTIALS_SERVICE_PROPERTY);
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
  public final ConsumeKafka_0_11 setSaslKerberosServiceName(final String saslKerberosServiceName) {
    properties.put(SASL_KERBEROS_SERVICE_NAME_PROPERTY, saslKerberosServiceName);
    return this;
  }

  /**
   * The Kerberos principal name that Kafka runs as. This can be defined either in Kafka's JAAS config or in Kafka's config. Corresponds to Kafka's 'security.protocol' property.It is ignored unless one of the SASL options of the <Security Protocol> are selected.
   */
  public final ConsumeKafka_0_11 removeSaslKerberosServiceName() {
    properties.remove(SASL_KERBEROS_SERVICE_NAME_PROPERTY);
    return this;
  }

  /**
   * The Kerberos principal that will be used to connect to brokers. If not set, it is expected to set a JAAS configuration file in the JVM properties defined in the bootstrap.conf file. This principal will be set into 'sasl.jaas.config' Kafka's property.
   */
  public final String getSaslKerberosPrincipal() {
    return properties.get(SASL_KERBEROS_PRINCIPAL_PROPERTY);
  }

  /**
   * The Kerberos principal that will be used to connect to brokers. If not set, it is expected to set a JAAS configuration file in the JVM properties defined in the bootstrap.conf file. This principal will be set into 'sasl.jaas.config' Kafka's property.
   */
  public final ConsumeKafka_0_11 setSaslKerberosPrincipal(final String saslKerberosPrincipal) {
    properties.put(SASL_KERBEROS_PRINCIPAL_PROPERTY, saslKerberosPrincipal);
    return this;
  }

  /**
   * The Kerberos principal that will be used to connect to brokers. If not set, it is expected to set a JAAS configuration file in the JVM properties defined in the bootstrap.conf file. This principal will be set into 'sasl.jaas.config' Kafka's property.
   */
  public final ConsumeKafka_0_11 removeSaslKerberosPrincipal() {
    properties.remove(SASL_KERBEROS_PRINCIPAL_PROPERTY);
    return this;
  }

  /**
   * The Kerberos keytab that will be used to connect to brokers. If not set, it is expected to set a JAAS configuration file in the JVM properties defined in the bootstrap.conf file. This principal will be set into 'sasl.jaas.config' Kafka's property.
   */
  public final String getSaslKerberosKeytab() {
    return properties.get(SASL_KERBEROS_KEYTAB_PROPERTY);
  }

  /**
   * The Kerberos keytab that will be used to connect to brokers. If not set, it is expected to set a JAAS configuration file in the JVM properties defined in the bootstrap.conf file. This principal will be set into 'sasl.jaas.config' Kafka's property.
   */
  public final ConsumeKafka_0_11 setSaslKerberosKeytab(final String saslKerberosKeytab) {
    properties.put(SASL_KERBEROS_KEYTAB_PROPERTY, saslKerberosKeytab);
    return this;
  }

  /**
   * The Kerberos keytab that will be used to connect to brokers. If not set, it is expected to set a JAAS configuration file in the JVM properties defined in the bootstrap.conf file. This principal will be set into 'sasl.jaas.config' Kafka's property.
   */
  public final ConsumeKafka_0_11 removeSaslKerberosKeytab() {
    properties.remove(SASL_KERBEROS_KEYTAB_PROPERTY);
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
  public final ConsumeKafka_0_11 setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * Specifies the SSL Context Service to use for communicating with Kafka.
   */
  public final ConsumeKafka_0_11 removeSslContextService() {
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
  public final ConsumeKafka_0_11 setTopic(final String topic) {
    properties.put(TOPIC_PROPERTY, topic);
    return this;
  }

  /**
   * The name of the Kafka Topic(s) to pull from. More than one can be supplied if comma separated.
   */
  public final ConsumeKafka_0_11 removeTopic() {
    properties.remove(TOPIC_PROPERTY);
    return this;
  }

  /**
   * Specifies whether the Topic(s) provided are a comma separated list of names or a single regular expression
   */
  public final String getTopicType() {
    return properties.get(TOPIC_TYPE_PROPERTY);
  }

  /**
   * Specifies whether the Topic(s) provided are a comma separated list of names or a single regular expression
   */
  public final ConsumeKafka_0_11 setTopicType(final String topicType) {
    properties.put(TOPIC_TYPE_PROPERTY, topicType);
    return this;
  }

  /**
   * Specifies whether the Topic(s) provided are a comma separated list of names or a single regular expression
   */
  public final ConsumeKafka_0_11 removeTopicType() {
    properties.remove(TOPIC_TYPE_PROPERTY);
    return this;
  }

  /**
   * Specifies whether or not NiFi should honor transactional guarantees when communicating with Kafka. If false, the Processor will use an "isolation level" of read_uncomitted. This means that messages will be received as soon as they are written to Kafka but will be pulled, even if the producer cancels the transactions. If this value is true, NiFi will not receive any messages for which the producer's transaction was canceled, but this can result in some latency since the consumer must wait for the producer to finish its entire transaction instead of pulling as the messages become available.
   */
  public final String getHonorTransactions() {
    return properties.get(HONOR_TRANSACTIONS_PROPERTY);
  }

  /**
   * Specifies whether or not NiFi should honor transactional guarantees when communicating with Kafka. If false, the Processor will use an "isolation level" of read_uncomitted. This means that messages will be received as soon as they are written to Kafka but will be pulled, even if the producer cancels the transactions. If this value is true, NiFi will not receive any messages for which the producer's transaction was canceled, but this can result in some latency since the consumer must wait for the producer to finish its entire transaction instead of pulling as the messages become available.
   */
  public final ConsumeKafka_0_11 setHonorTransactions(final String honorTransactions) {
    properties.put(HONOR_TRANSACTIONS_PROPERTY, honorTransactions);
    return this;
  }

  /**
   * Specifies whether or not NiFi should honor transactional guarantees when communicating with Kafka. If false, the Processor will use an "isolation level" of read_uncomitted. This means that messages will be received as soon as they are written to Kafka but will be pulled, even if the producer cancels the transactions. If this value is true, NiFi will not receive any messages for which the producer's transaction was canceled, but this can result in some latency since the consumer must wait for the producer to finish its entire transaction instead of pulling as the messages become available.
   */
  public final ConsumeKafka_0_11 removeHonorTransactions() {
    properties.remove(HONOR_TRANSACTIONS_PROPERTY);
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
  public final ConsumeKafka_0_11 setGroupId(final String groupId) {
    properties.put(GROUP_ID_PROPERTY, groupId);
    return this;
  }

  /**
   * A Group ID is used to identify consumers that are within the same consumer group. Corresponds to Kafka's 'group.id' property.
   */
  public final ConsumeKafka_0_11 removeGroupId() {
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
  public final ConsumeKafka_0_11 setAutoOffsetReset(final String autoOffsetReset) {
    properties.put(AUTO_OFFSET_RESET_PROPERTY, autoOffsetReset);
    return this;
  }

  /**
   * Allows you to manage the condition when there is no initial offset in Kafka or if the current offset does not exist any more on the server (e.g. because that data has been deleted). Corresponds to Kafka's 'auto.offset.reset' property.
   */
  public final ConsumeKafka_0_11 removeAutoOffsetReset() {
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
  public final ConsumeKafka_0_11 setKeyAttributeEncoding(final String keyAttributeEncoding) {
    properties.put(KEY_ATTRIBUTE_ENCODING_PROPERTY, keyAttributeEncoding);
    return this;
  }

  /**
   * FlowFiles that are emitted have an attribute named 'kafka.key'. This property dictates how the value of the attribute should be encoded.
   */
  public final ConsumeKafka_0_11 removeKeyAttributeEncoding() {
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
  public final ConsumeKafka_0_11 setMessageDemarcator(final String messageDemarcator) {
    properties.put(MESSAGE_DEMARCATOR_PROPERTY, messageDemarcator);
    return this;
  }

  /**
   * Since KafkaConsumer receives messages in batches, you have an option to output FlowFiles which contains all Kafka messages in a single batch for a given topic and partition and this property allows you to provide a string (interpreted as UTF-8) to use for demarcating apart multiple Kafka messages. This is an optional property and if not provided each Kafka message received will result in a single FlowFile which  time it is triggered. To enter special character such as 'new line' use CTRL+Enter or Shift+Enter depending on the OS
   */
  public final ConsumeKafka_0_11 removeMessageDemarcator() {
    properties.remove(MESSAGE_DEMARCATOR_PROPERTY);
    return this;
  }

  /**
   * Any message header that is found on a Kafka message will be added to the outbound FlowFile as an attribute. This property indicates the Character Encoding to use for deserializing the headers.
   */
  public final String getMessageHeaderEncoding() {
    return properties.get(MESSAGE_HEADER_ENCODING_PROPERTY);
  }

  /**
   * Any message header that is found on a Kafka message will be added to the outbound FlowFile as an attribute. This property indicates the Character Encoding to use for deserializing the headers.
   */
  public final ConsumeKafka_0_11 setMessageHeaderEncoding(final String messageHeaderEncoding) {
    properties.put(MESSAGE_HEADER_ENCODING_PROPERTY, messageHeaderEncoding);
    return this;
  }

  /**
   * Any message header that is found on a Kafka message will be added to the outbound FlowFile as an attribute. This property indicates the Character Encoding to use for deserializing the headers.
   */
  public final ConsumeKafka_0_11 removeMessageHeaderEncoding() {
    properties.remove(MESSAGE_HEADER_ENCODING_PROPERTY);
    return this;
  }

  /**
   * A Regular Expression that is matched against all message headers. Any message header whose name matches the regex will be added to the FlowFile as an Attribute. If not specified, no Header values will be added as FlowFile attributes. If two messages have a different value for the same header and that header is selected by the provided regex, then those two messages must be added to different FlowFiles. As a result, users should be cautious about using a regex like ".*" if messages are expected to have header values that are unique per message, such as an identifier or timestamp, because it will prevent NiFi from bundling the messages together efficiently.
   */
  public final String getHeaderNameRegex() {
    return properties.get(HEADER_NAME_REGEX_PROPERTY);
  }

  /**
   * A Regular Expression that is matched against all message headers. Any message header whose name matches the regex will be added to the FlowFile as an Attribute. If not specified, no Header values will be added as FlowFile attributes. If two messages have a different value for the same header and that header is selected by the provided regex, then those two messages must be added to different FlowFiles. As a result, users should be cautious about using a regex like ".*" if messages are expected to have header values that are unique per message, such as an identifier or timestamp, because it will prevent NiFi from bundling the messages together efficiently.
   */
  public final ConsumeKafka_0_11 setHeaderNameRegex(final String headerNameRegex) {
    properties.put(HEADER_NAME_REGEX_PROPERTY, headerNameRegex);
    return this;
  }

  /**
   * A Regular Expression that is matched against all message headers. Any message header whose name matches the regex will be added to the FlowFile as an Attribute. If not specified, no Header values will be added as FlowFile attributes. If two messages have a different value for the same header and that header is selected by the provided regex, then those two messages must be added to different FlowFiles. As a result, users should be cautious about using a regex like ".*" if messages are expected to have header values that are unique per message, such as an identifier or timestamp, because it will prevent NiFi from bundling the messages together efficiently.
   */
  public final ConsumeKafka_0_11 removeHeaderNameRegex() {
    properties.remove(HEADER_NAME_REGEX_PROPERTY);
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
  public final ConsumeKafka_0_11 setMaxPollRecords(final String maxPollRecords) {
    properties.put(MAX_POLL_RECORDS_PROPERTY, maxPollRecords);
    return this;
  }

  /**
   * Specifies the maximum number of records Kafka should return in a single poll.
   */
  public final ConsumeKafka_0_11 removeMaxPollRecords() {
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
  public final ConsumeKafka_0_11 setMaxUncommitOffsetWait(final String maxUncommitOffsetWait) {
    properties.put(MAX_UNCOMMIT_OFFSET_WAIT_PROPERTY, maxUncommitOffsetWait);
    return this;
  }

  /**
   * Specifies the maximum amount of time allowed to pass before offsets must be committed. This value impacts how often offsets will be committed.  Committing offsets less often increases throughput but also increases the window of potential data duplication in the event of a rebalance or JVM restart between commits.  This value is also related to maximum poll records and the use of a message demarcator.  When using a message demarcator we can have far more uncommitted messages than when we're not as there is much less for us to keep track of in memory.
   */
  public final ConsumeKafka_0_11 removeMaxUncommitOffsetWait() {
    properties.remove(MAX_UNCOMMIT_OFFSET_WAIT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ConsumeKafka_0_11 setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ConsumeKafka_0_11 removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ConsumeKafka_0_11, ConsumeKafka_0_11> configurator) {
    return configurator.apply(new ConsumeKafka_0_11()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConsumeKafka_0_11.class) final Closure<ConsumeKafka_0_11> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.kafka.pubsub.ConsumeKafka_0_11> code = closure.rehydrate(c, com.tibtech.nifi.processors.kafka.pubsub.ConsumeKafka_0_11.class, com.tibtech.nifi.processors.kafka.pubsub.ConsumeKafka_0_11.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ConsumeKafka_0_11, ConsumeKafka_0_11> configurator) {
    return configurator.apply(new ConsumeKafka_0_11(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConsumeKafka_0_11.class) final Closure<ConsumeKafka_0_11> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.kafka.pubsub.ConsumeKafka_0_11> code = closure.rehydrate(c, com.tibtech.nifi.processors.kafka.pubsub.ConsumeKafka_0_11.class, com.tibtech.nifi.processors.kafka.pubsub.ConsumeKafka_0_11.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
