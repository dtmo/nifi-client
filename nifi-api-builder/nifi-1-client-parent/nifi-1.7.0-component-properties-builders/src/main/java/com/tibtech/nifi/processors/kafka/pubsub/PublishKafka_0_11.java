package com.tibtech.nifi.processors.kafka.pubsub;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PublishKafka_0_11 {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.kafka.pubsub.PublishKafka_0_11";

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
   * The name of the Kafka Topic to publish to.
   */
  public static final String TOPIC_PROPERTY = "topic";

  /**
   * Specifies the requirement for guaranteeing that a message is sent to Kafka. Corresponds to Kafka's 'acks' property.
   */
  public static final String ACKS_PROPERTY = "acks";

  /**
   * Specifies whether or not NiFi should provide Transactional guarantees when communicating with Kafka. If there is a problem sending data to Kafka, and this property is set to false, then the messages that have already been sent to Kafka will continue on and be delivered to consumers. If this is set to true, then the Kafka transaction will be rolled back so that those messages are not available to consumers. Setting this to true requires that the <Delivery Guarantee> property be set to "Guarantee Replicated Delivery."
   */
  public static final String USE_TRANSACTIONS_PROPERTY = "use-transactions";

  /**
   * A Regular Expression that is matched against all FlowFile attribute names. Any attribute whose name matches the regex will be added to the Kafka messages as a Header. If not specified, no FlowFile attributes will be added as headers.
   */
  public static final String ATTRIBUTE_NAME_REGEX_PROPERTY = "attribute-name-regex";

  /**
   * For any attribute that is added as a message header, as configured via the <Attributes to Send as Headers> property, this property indicates the Character Encoding to use for serializing the headers.
   */
  public static final String MESSAGE_HEADER_ENCODING_PROPERTY = "message-header-encoding";

  /**
   * The Key to use for the Message. If not specified, the flow file attribute 'kafka.key' is used as the message key, if it is present.Beware that setting Kafka key and demarcating at the same time may potentially lead to many Kafka messages with the same key.Normally this is not a problem as Kafka does not enforce or assume message and key uniqueness. Still, setting the demarcator and Kafka key at the same time poses a risk of data loss on Kafka. During a topic compaction on Kafka, messages will be deduplicated based on this key.
   */
  public static final String KAFKA_KEY_PROPERTY = "kafka-key";

  /**
   * FlowFiles that are emitted have an attribute named 'kafka.key'. This property dictates how the value of the attribute should be encoded.
   */
  public static final String KEY_ATTRIBUTE_ENCODING_PROPERTY = "key-attribute-encoding";

  /**
   * Specifies the string (interpreted as UTF-8) to use for demarcating multiple messages within a single FlowFile. If not specified, the entire content of the FlowFile will be used as a single message. If specified, the contents of the FlowFile will be split on this delimiter and each section sent as a separate Kafka message. To enter special character such as 'new line' use CTRL+Enter or Shift+Enter, depending on your OS.
   */
  public static final String MESSAGE_DEMARCATOR_PROPERTY = "message-demarcator";

  /**
   * The maximum size of a request in bytes. Corresponds to Kafka's 'max.request.size' property and defaults to 1 MB (1048576).
   */
  public static final String MAX_REQUEST_SIZE_PROPERTY = "max.request.size";

  /**
   * After sending a message to Kafka, this indicates the amount of time that we are willing to wait for a response from Kafka. If Kafka does not acknowledge the message within this time period, the FlowFile will be routed to 'failure'.
   */
  public static final String ACK_WAIT_TIME_PROPERTY = "ack.wait.time";

  /**
   * The amount of time publisher will wait to obtain metadata or wait for the buffer to flush during the 'send' call before failing the entire 'send' call. Corresponds to Kafka's 'max.block.ms' property
   */
  public static final String MAX_BLOCK_MS_PROPERTY = "max.block.ms";

  /**
   * Specifies which class to use to compute a partition id for a message. Corresponds to Kafka's 'partitioner.class' property.
   */
  public static final String PARTITIONER_CLASS_PROPERTY = "partitioner.class";

  /**
   * This parameter allows you to specify the compression codec for all data generated by this producer.
   */
  public static final String COMPRESSION_TYPE_PROPERTY = "compression.type";

  private final Map<String, String> properties;

  public PublishKafka_0_11() {
    this.properties = new HashMap<>();
  }

  public PublishKafka_0_11(final Map<String, String> properties) {
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
  public final PublishKafka_0_11 setBootstrapServers(final String bootstrapServers) {
    properties.put(BOOTSTRAP_SERVERS_PROPERTY, bootstrapServers);
    return this;
  }

  /**
   * A comma-separated list of known Kafka Brokers in the format <host>:<port>
   */
  public final PublishKafka_0_11 removeBootstrapServers() {
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
  public final PublishKafka_0_11 setSecurityProtocol(final String securityProtocol) {
    properties.put(SECURITY_PROTOCOL_PROPERTY, securityProtocol);
    return this;
  }

  /**
   * Protocol used to communicate with brokers. Corresponds to Kafka's 'security.protocol' property.
   */
  public final PublishKafka_0_11 removeSecurityProtocol() {
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
  public final PublishKafka_0_11 setKerberosCredentialsService(
      final String kerberosCredentialsService) {
    properties.put(KERBEROS_CREDENTIALS_SERVICE_PROPERTY, kerberosCredentialsService);
    return this;
  }

  /**
   * Specifies the Kerberos Credentials Controller Service that should be used for authenticating with Kerberos
   */
  public final PublishKafka_0_11 removeKerberosCredentialsService() {
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
  public final PublishKafka_0_11 setSaslKerberosServiceName(final String saslKerberosServiceName) {
    properties.put(SASL_KERBEROS_SERVICE_NAME_PROPERTY, saslKerberosServiceName);
    return this;
  }

  /**
   * The Kerberos principal name that Kafka runs as. This can be defined either in Kafka's JAAS config or in Kafka's config. Corresponds to Kafka's 'security.protocol' property.It is ignored unless one of the SASL options of the <Security Protocol> are selected.
   */
  public final PublishKafka_0_11 removeSaslKerberosServiceName() {
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
  public final PublishKafka_0_11 setSaslKerberosPrincipal(final String saslKerberosPrincipal) {
    properties.put(SASL_KERBEROS_PRINCIPAL_PROPERTY, saslKerberosPrincipal);
    return this;
  }

  /**
   * The Kerberos principal that will be used to connect to brokers. If not set, it is expected to set a JAAS configuration file in the JVM properties defined in the bootstrap.conf file. This principal will be set into 'sasl.jaas.config' Kafka's property.
   */
  public final PublishKafka_0_11 removeSaslKerberosPrincipal() {
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
  public final PublishKafka_0_11 setSaslKerberosKeytab(final String saslKerberosKeytab) {
    properties.put(SASL_KERBEROS_KEYTAB_PROPERTY, saslKerberosKeytab);
    return this;
  }

  /**
   * The Kerberos keytab that will be used to connect to brokers. If not set, it is expected to set a JAAS configuration file in the JVM properties defined in the bootstrap.conf file. This principal will be set into 'sasl.jaas.config' Kafka's property.
   */
  public final PublishKafka_0_11 removeSaslKerberosKeytab() {
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
  public final PublishKafka_0_11 setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * Specifies the SSL Context Service to use for communicating with Kafka.
   */
  public final PublishKafka_0_11 removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The name of the Kafka Topic to publish to.
   */
  public final String getTopic() {
    return properties.get(TOPIC_PROPERTY);
  }

  /**
   * The name of the Kafka Topic to publish to.
   */
  public final PublishKafka_0_11 setTopic(final String topic) {
    properties.put(TOPIC_PROPERTY, topic);
    return this;
  }

  /**
   * The name of the Kafka Topic to publish to.
   */
  public final PublishKafka_0_11 removeTopic() {
    properties.remove(TOPIC_PROPERTY);
    return this;
  }

  /**
   * Specifies the requirement for guaranteeing that a message is sent to Kafka. Corresponds to Kafka's 'acks' property.
   */
  public final String getAcks() {
    return properties.get(ACKS_PROPERTY);
  }

  /**
   * Specifies the requirement for guaranteeing that a message is sent to Kafka. Corresponds to Kafka's 'acks' property.
   */
  public final PublishKafka_0_11 setAcks(final String acks) {
    properties.put(ACKS_PROPERTY, acks);
    return this;
  }

  /**
   * Specifies the requirement for guaranteeing that a message is sent to Kafka. Corresponds to Kafka's 'acks' property.
   */
  public final PublishKafka_0_11 removeAcks() {
    properties.remove(ACKS_PROPERTY);
    return this;
  }

  /**
   * Specifies whether or not NiFi should provide Transactional guarantees when communicating with Kafka. If there is a problem sending data to Kafka, and this property is set to false, then the messages that have already been sent to Kafka will continue on and be delivered to consumers. If this is set to true, then the Kafka transaction will be rolled back so that those messages are not available to consumers. Setting this to true requires that the <Delivery Guarantee> property be set to "Guarantee Replicated Delivery."
   */
  public final String getUseTransactions() {
    return properties.get(USE_TRANSACTIONS_PROPERTY);
  }

  /**
   * Specifies whether or not NiFi should provide Transactional guarantees when communicating with Kafka. If there is a problem sending data to Kafka, and this property is set to false, then the messages that have already been sent to Kafka will continue on and be delivered to consumers. If this is set to true, then the Kafka transaction will be rolled back so that those messages are not available to consumers. Setting this to true requires that the <Delivery Guarantee> property be set to "Guarantee Replicated Delivery."
   */
  public final PublishKafka_0_11 setUseTransactions(final String useTransactions) {
    properties.put(USE_TRANSACTIONS_PROPERTY, useTransactions);
    return this;
  }

  /**
   * Specifies whether or not NiFi should provide Transactional guarantees when communicating with Kafka. If there is a problem sending data to Kafka, and this property is set to false, then the messages that have already been sent to Kafka will continue on and be delivered to consumers. If this is set to true, then the Kafka transaction will be rolled back so that those messages are not available to consumers. Setting this to true requires that the <Delivery Guarantee> property be set to "Guarantee Replicated Delivery."
   */
  public final PublishKafka_0_11 removeUseTransactions() {
    properties.remove(USE_TRANSACTIONS_PROPERTY);
    return this;
  }

  /**
   * A Regular Expression that is matched against all FlowFile attribute names. Any attribute whose name matches the regex will be added to the Kafka messages as a Header. If not specified, no FlowFile attributes will be added as headers.
   */
  public final String getAttributeNameRegex() {
    return properties.get(ATTRIBUTE_NAME_REGEX_PROPERTY);
  }

  /**
   * A Regular Expression that is matched against all FlowFile attribute names. Any attribute whose name matches the regex will be added to the Kafka messages as a Header. If not specified, no FlowFile attributes will be added as headers.
   */
  public final PublishKafka_0_11 setAttributeNameRegex(final String attributeNameRegex) {
    properties.put(ATTRIBUTE_NAME_REGEX_PROPERTY, attributeNameRegex);
    return this;
  }

  /**
   * A Regular Expression that is matched against all FlowFile attribute names. Any attribute whose name matches the regex will be added to the Kafka messages as a Header. If not specified, no FlowFile attributes will be added as headers.
   */
  public final PublishKafka_0_11 removeAttributeNameRegex() {
    properties.remove(ATTRIBUTE_NAME_REGEX_PROPERTY);
    return this;
  }

  /**
   * For any attribute that is added as a message header, as configured via the <Attributes to Send as Headers> property, this property indicates the Character Encoding to use for serializing the headers.
   */
  public final String getMessageHeaderEncoding() {
    return properties.get(MESSAGE_HEADER_ENCODING_PROPERTY);
  }

  /**
   * For any attribute that is added as a message header, as configured via the <Attributes to Send as Headers> property, this property indicates the Character Encoding to use for serializing the headers.
   */
  public final PublishKafka_0_11 setMessageHeaderEncoding(final String messageHeaderEncoding) {
    properties.put(MESSAGE_HEADER_ENCODING_PROPERTY, messageHeaderEncoding);
    return this;
  }

  /**
   * For any attribute that is added as a message header, as configured via the <Attributes to Send as Headers> property, this property indicates the Character Encoding to use for serializing the headers.
   */
  public final PublishKafka_0_11 removeMessageHeaderEncoding() {
    properties.remove(MESSAGE_HEADER_ENCODING_PROPERTY);
    return this;
  }

  /**
   * The Key to use for the Message. If not specified, the flow file attribute 'kafka.key' is used as the message key, if it is present.Beware that setting Kafka key and demarcating at the same time may potentially lead to many Kafka messages with the same key.Normally this is not a problem as Kafka does not enforce or assume message and key uniqueness. Still, setting the demarcator and Kafka key at the same time poses a risk of data loss on Kafka. During a topic compaction on Kafka, messages will be deduplicated based on this key.
   */
  public final String getKafkaKey() {
    return properties.get(KAFKA_KEY_PROPERTY);
  }

  /**
   * The Key to use for the Message. If not specified, the flow file attribute 'kafka.key' is used as the message key, if it is present.Beware that setting Kafka key and demarcating at the same time may potentially lead to many Kafka messages with the same key.Normally this is not a problem as Kafka does not enforce or assume message and key uniqueness. Still, setting the demarcator and Kafka key at the same time poses a risk of data loss on Kafka. During a topic compaction on Kafka, messages will be deduplicated based on this key.
   */
  public final PublishKafka_0_11 setKafkaKey(final String kafkaKey) {
    properties.put(KAFKA_KEY_PROPERTY, kafkaKey);
    return this;
  }

  /**
   * The Key to use for the Message. If not specified, the flow file attribute 'kafka.key' is used as the message key, if it is present.Beware that setting Kafka key and demarcating at the same time may potentially lead to many Kafka messages with the same key.Normally this is not a problem as Kafka does not enforce or assume message and key uniqueness. Still, setting the demarcator and Kafka key at the same time poses a risk of data loss on Kafka. During a topic compaction on Kafka, messages will be deduplicated based on this key.
   */
  public final PublishKafka_0_11 removeKafkaKey() {
    properties.remove(KAFKA_KEY_PROPERTY);
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
  public final PublishKafka_0_11 setKeyAttributeEncoding(final String keyAttributeEncoding) {
    properties.put(KEY_ATTRIBUTE_ENCODING_PROPERTY, keyAttributeEncoding);
    return this;
  }

  /**
   * FlowFiles that are emitted have an attribute named 'kafka.key'. This property dictates how the value of the attribute should be encoded.
   */
  public final PublishKafka_0_11 removeKeyAttributeEncoding() {
    properties.remove(KEY_ATTRIBUTE_ENCODING_PROPERTY);
    return this;
  }

  /**
   * Specifies the string (interpreted as UTF-8) to use for demarcating multiple messages within a single FlowFile. If not specified, the entire content of the FlowFile will be used as a single message. If specified, the contents of the FlowFile will be split on this delimiter and each section sent as a separate Kafka message. To enter special character such as 'new line' use CTRL+Enter or Shift+Enter, depending on your OS.
   */
  public final String getMessageDemarcator() {
    return properties.get(MESSAGE_DEMARCATOR_PROPERTY);
  }

  /**
   * Specifies the string (interpreted as UTF-8) to use for demarcating multiple messages within a single FlowFile. If not specified, the entire content of the FlowFile will be used as a single message. If specified, the contents of the FlowFile will be split on this delimiter and each section sent as a separate Kafka message. To enter special character such as 'new line' use CTRL+Enter or Shift+Enter, depending on your OS.
   */
  public final PublishKafka_0_11 setMessageDemarcator(final String messageDemarcator) {
    properties.put(MESSAGE_DEMARCATOR_PROPERTY, messageDemarcator);
    return this;
  }

  /**
   * Specifies the string (interpreted as UTF-8) to use for demarcating multiple messages within a single FlowFile. If not specified, the entire content of the FlowFile will be used as a single message. If specified, the contents of the FlowFile will be split on this delimiter and each section sent as a separate Kafka message. To enter special character such as 'new line' use CTRL+Enter or Shift+Enter, depending on your OS.
   */
  public final PublishKafka_0_11 removeMessageDemarcator() {
    properties.remove(MESSAGE_DEMARCATOR_PROPERTY);
    return this;
  }

  /**
   * The maximum size of a request in bytes. Corresponds to Kafka's 'max.request.size' property and defaults to 1 MB (1048576).
   */
  public final String getMaxRequestSize() {
    return properties.get(MAX_REQUEST_SIZE_PROPERTY);
  }

  /**
   * The maximum size of a request in bytes. Corresponds to Kafka's 'max.request.size' property and defaults to 1 MB (1048576).
   */
  public final PublishKafka_0_11 setMaxRequestSize(final String maxRequestSize) {
    properties.put(MAX_REQUEST_SIZE_PROPERTY, maxRequestSize);
    return this;
  }

  /**
   * The maximum size of a request in bytes. Corresponds to Kafka's 'max.request.size' property and defaults to 1 MB (1048576).
   */
  public final PublishKafka_0_11 removeMaxRequestSize() {
    properties.remove(MAX_REQUEST_SIZE_PROPERTY);
    return this;
  }

  /**
   * After sending a message to Kafka, this indicates the amount of time that we are willing to wait for a response from Kafka. If Kafka does not acknowledge the message within this time period, the FlowFile will be routed to 'failure'.
   */
  public final String getAckWaitTime() {
    return properties.get(ACK_WAIT_TIME_PROPERTY);
  }

  /**
   * After sending a message to Kafka, this indicates the amount of time that we are willing to wait for a response from Kafka. If Kafka does not acknowledge the message within this time period, the FlowFile will be routed to 'failure'.
   */
  public final PublishKafka_0_11 setAckWaitTime(final String ackWaitTime) {
    properties.put(ACK_WAIT_TIME_PROPERTY, ackWaitTime);
    return this;
  }

  /**
   * After sending a message to Kafka, this indicates the amount of time that we are willing to wait for a response from Kafka. If Kafka does not acknowledge the message within this time period, the FlowFile will be routed to 'failure'.
   */
  public final PublishKafka_0_11 removeAckWaitTime() {
    properties.remove(ACK_WAIT_TIME_PROPERTY);
    return this;
  }

  /**
   * The amount of time publisher will wait to obtain metadata or wait for the buffer to flush during the 'send' call before failing the entire 'send' call. Corresponds to Kafka's 'max.block.ms' property
   */
  public final String getMaxBlockMs() {
    return properties.get(MAX_BLOCK_MS_PROPERTY);
  }

  /**
   * The amount of time publisher will wait to obtain metadata or wait for the buffer to flush during the 'send' call before failing the entire 'send' call. Corresponds to Kafka's 'max.block.ms' property
   */
  public final PublishKafka_0_11 setMaxBlockMs(final String maxBlockMs) {
    properties.put(MAX_BLOCK_MS_PROPERTY, maxBlockMs);
    return this;
  }

  /**
   * The amount of time publisher will wait to obtain metadata or wait for the buffer to flush during the 'send' call before failing the entire 'send' call. Corresponds to Kafka's 'max.block.ms' property
   */
  public final PublishKafka_0_11 removeMaxBlockMs() {
    properties.remove(MAX_BLOCK_MS_PROPERTY);
    return this;
  }

  /**
   * Specifies which class to use to compute a partition id for a message. Corresponds to Kafka's 'partitioner.class' property.
   */
  public final String getPartitionerClass() {
    return properties.get(PARTITIONER_CLASS_PROPERTY);
  }

  /**
   * Specifies which class to use to compute a partition id for a message. Corresponds to Kafka's 'partitioner.class' property.
   */
  public final PublishKafka_0_11 setPartitionerClass(final String partitionerClass) {
    properties.put(PARTITIONER_CLASS_PROPERTY, partitionerClass);
    return this;
  }

  /**
   * Specifies which class to use to compute a partition id for a message. Corresponds to Kafka's 'partitioner.class' property.
   */
  public final PublishKafka_0_11 removePartitionerClass() {
    properties.remove(PARTITIONER_CLASS_PROPERTY);
    return this;
  }

  /**
   * This parameter allows you to specify the compression codec for all data generated by this producer.
   */
  public final String getCompressionType() {
    return properties.get(COMPRESSION_TYPE_PROPERTY);
  }

  /**
   * This parameter allows you to specify the compression codec for all data generated by this producer.
   */
  public final PublishKafka_0_11 setCompressionType(final String compressionType) {
    properties.put(COMPRESSION_TYPE_PROPERTY, compressionType);
    return this;
  }

  /**
   * This parameter allows you to specify the compression codec for all data generated by this producer.
   */
  public final PublishKafka_0_11 removeCompressionType() {
    properties.remove(COMPRESSION_TYPE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PublishKafka_0_11 setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PublishKafka_0_11 removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<PublishKafka_0_11, PublishKafka_0_11> configurator) {
    return configurator.apply(new PublishKafka_0_11()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PublishKafka_0_11.class) final Closure<PublishKafka_0_11> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.kafka.pubsub.PublishKafka_0_11> code = closure.rehydrate(c, com.tibtech.nifi.processors.kafka.pubsub.PublishKafka_0_11.class, com.tibtech.nifi.processors.kafka.pubsub.PublishKafka_0_11.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PublishKafka_0_11, PublishKafka_0_11> configurator) {
    return configurator.apply(new PublishKafka_0_11(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PublishKafka_0_11.class) final Closure<PublishKafka_0_11> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.kafka.pubsub.PublishKafka_0_11> code = closure.rehydrate(c, com.tibtech.nifi.processors.kafka.pubsub.PublishKafka_0_11.class, com.tibtech.nifi.processors.kafka.pubsub.PublishKafka_0_11.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
