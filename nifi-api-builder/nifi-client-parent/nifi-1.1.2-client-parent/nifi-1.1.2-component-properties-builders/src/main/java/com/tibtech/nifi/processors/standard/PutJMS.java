package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutJMS {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.PutJMS";

  /**
   * The Provider used for the JMS Server
   */
  public static final String JMS_PROVIDER_PROPERTY = "JMS Provider";

  /**
   * The URL of the JMS Server
   */
  public static final String URL_PROPERTY = "URL";

  /**
   * The name of the JMS Topic or queue to use
   */
  public static final String DESTINATION_NAME_PROPERTY = "Destination Name";

  /**
   * The type of the JMS Destination to use
   */
  public static final String DESTINATION_TYPE_PROPERTY = "Destination Type";

  /**
   * The amount of time to wait when attempting to receive a message before giving up and assuming failure
   */
  public static final String COMMUNICATIONS_TIMEOUT_PROPERTY = "Communications Timeout";

  /**
   * The number of messages to pull/push in a single iteration of the processor
   */
  public static final String MESSAGE_BATCH_SIZE_PROPERTY = "Message Batch Size";

  /**
   * Username used for authentication and authorization
   */
  public static final String USERNAME_PROPERTY = "Username";

  /**
   * Password used for authentication and authorization
   */
  public static final String PASSWORD_PROPERTY = "Password";

  /**
   * The Controller Service to use in order to obtain an SSL Context.
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  /**
   * The Type of JMS Message to Construct
   */
  public static final String MESSAGE_TYPE_PROPERTY = "Message Type";

  /**
   * The Priority of the Message
   */
  public static final String MESSAGE_PRIORITY_PROPERTY = "Message Priority";

  /**
   * The name of the queue to which a reply to should be added
   */
  public static final String REPLY_TO_QUEUE_PROPERTY = "Reply-To Queue";

  /**
   * The maximum amount of data that can be buffered for a JMS Message. If a FlowFile's size exceeds this value, the FlowFile will be routed to failure.
   */
  public static final String MAX_BUFFER_SIZE_PROPERTY = "Max Buffer Size";

  /**
   * The amount of time that the message should live on the destination before being removed; if not specified, the message will never expire.
   */
  public static final String MESSAGE_TIME_TO_LIVE_PROPERTY = "Message Time to Live";

  /**
   * Whether or not FlowFile Attributes should be translated into JMS Message Properties. If true, all attributes starting with 'jms.' will be set as Properties on the JMS Message (without the 'jms.' prefix). If an attribute exists that starts with the same value but ends in '.type', that attribute will be used to determine the JMS Message Property type.
   */
  public static final String COPY_ATTRIBUTES_TO_JMS_PROPERTIES_PROPERTY = "Copy Attributes to JMS Properties";

  /**
   * A human-readable ID that can be used to associate connections with yourself so that the maintainers of the JMS Server know who to contact if problems arise
   */
  public static final String CLIENT_ID_PREFIX_PROPERTY = "Client ID Prefix";

  private final Map<String, String> properties;

  public PutJMS() {
    this.properties = new HashMap<>();
  }

  public PutJMS(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The Provider used for the JMS Server
   */
  public final String getJmsProvider() {
    return properties.get(JMS_PROVIDER_PROPERTY);
  }

  /**
   * The Provider used for the JMS Server
   */
  public final PutJMS setJmsProvider(final String jmsProvider) {
    properties.put(JMS_PROVIDER_PROPERTY, jmsProvider);
    return this;
  }

  /**
   * The Provider used for the JMS Server
   */
  public final PutJMS removeJmsProvider() {
    properties.remove(JMS_PROVIDER_PROPERTY);
    return this;
  }

  /**
   * The URL of the JMS Server
   */
  public final String getUrl() {
    return properties.get(URL_PROPERTY);
  }

  /**
   * The URL of the JMS Server
   */
  public final PutJMS setUrl(final String url) {
    properties.put(URL_PROPERTY, url);
    return this;
  }

  /**
   * The URL of the JMS Server
   */
  public final PutJMS removeUrl() {
    properties.remove(URL_PROPERTY);
    return this;
  }

  /**
   * The name of the JMS Topic or queue to use
   */
  public final String getDestinationName() {
    return properties.get(DESTINATION_NAME_PROPERTY);
  }

  /**
   * The name of the JMS Topic or queue to use
   */
  public final PutJMS setDestinationName(final String destinationName) {
    properties.put(DESTINATION_NAME_PROPERTY, destinationName);
    return this;
  }

  /**
   * The name of the JMS Topic or queue to use
   */
  public final PutJMS removeDestinationName() {
    properties.remove(DESTINATION_NAME_PROPERTY);
    return this;
  }

  /**
   * The type of the JMS Destination to use
   */
  public final String getDestinationType() {
    return properties.get(DESTINATION_TYPE_PROPERTY);
  }

  /**
   * The type of the JMS Destination to use
   */
  public final PutJMS setDestinationType(final String destinationType) {
    properties.put(DESTINATION_TYPE_PROPERTY, destinationType);
    return this;
  }

  /**
   * The type of the JMS Destination to use
   */
  public final PutJMS removeDestinationType() {
    properties.remove(DESTINATION_TYPE_PROPERTY);
    return this;
  }

  /**
   * The amount of time to wait when attempting to receive a message before giving up and assuming failure
   */
  public final String getCommunicationsTimeout() {
    return properties.get(COMMUNICATIONS_TIMEOUT_PROPERTY);
  }

  /**
   * The amount of time to wait when attempting to receive a message before giving up and assuming failure
   */
  public final PutJMS setCommunicationsTimeout(final String communicationsTimeout) {
    properties.put(COMMUNICATIONS_TIMEOUT_PROPERTY, communicationsTimeout);
    return this;
  }

  /**
   * The amount of time to wait when attempting to receive a message before giving up and assuming failure
   */
  public final PutJMS removeCommunicationsTimeout() {
    properties.remove(COMMUNICATIONS_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The number of messages to pull/push in a single iteration of the processor
   */
  public final String getMessageBatchSize() {
    return properties.get(MESSAGE_BATCH_SIZE_PROPERTY);
  }

  /**
   * The number of messages to pull/push in a single iteration of the processor
   */
  public final PutJMS setMessageBatchSize(final String messageBatchSize) {
    properties.put(MESSAGE_BATCH_SIZE_PROPERTY, messageBatchSize);
    return this;
  }

  /**
   * The number of messages to pull/push in a single iteration of the processor
   */
  public final PutJMS removeMessageBatchSize() {
    properties.remove(MESSAGE_BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * Username used for authentication and authorization
   */
  public final String getUsername() {
    return properties.get(USERNAME_PROPERTY);
  }

  /**
   * Username used for authentication and authorization
   */
  public final PutJMS setUsername(final String username) {
    properties.put(USERNAME_PROPERTY, username);
    return this;
  }

  /**
   * Username used for authentication and authorization
   */
  public final PutJMS removeUsername() {
    properties.remove(USERNAME_PROPERTY);
    return this;
  }

  /**
   * Password used for authentication and authorization
   */
  public final String getPassword() {
    return properties.get(PASSWORD_PROPERTY);
  }

  /**
   * Password used for authentication and authorization
   */
  public final PutJMS setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password used for authentication and authorization
   */
  public final PutJMS removePassword() {
    properties.remove(PASSWORD_PROPERTY);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context.
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context.
   */
  public final PutJMS setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context.
   */
  public final PutJMS removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The Type of JMS Message to Construct
   */
  public final String getMessageType() {
    return properties.get(MESSAGE_TYPE_PROPERTY);
  }

  /**
   * The Type of JMS Message to Construct
   */
  public final PutJMS setMessageType(final String messageType) {
    properties.put(MESSAGE_TYPE_PROPERTY, messageType);
    return this;
  }

  /**
   * The Type of JMS Message to Construct
   */
  public final PutJMS removeMessageType() {
    properties.remove(MESSAGE_TYPE_PROPERTY);
    return this;
  }

  /**
   * The Priority of the Message
   */
  public final String getMessagePriority() {
    return properties.get(MESSAGE_PRIORITY_PROPERTY);
  }

  /**
   * The Priority of the Message
   */
  public final PutJMS setMessagePriority(final String messagePriority) {
    properties.put(MESSAGE_PRIORITY_PROPERTY, messagePriority);
    return this;
  }

  /**
   * The Priority of the Message
   */
  public final PutJMS removeMessagePriority() {
    properties.remove(MESSAGE_PRIORITY_PROPERTY);
    return this;
  }

  /**
   * The name of the queue to which a reply to should be added
   */
  public final String getReplyToQueue() {
    return properties.get(REPLY_TO_QUEUE_PROPERTY);
  }

  /**
   * The name of the queue to which a reply to should be added
   */
  public final PutJMS setReplyToQueue(final String replyToQueue) {
    properties.put(REPLY_TO_QUEUE_PROPERTY, replyToQueue);
    return this;
  }

  /**
   * The name of the queue to which a reply to should be added
   */
  public final PutJMS removeReplyToQueue() {
    properties.remove(REPLY_TO_QUEUE_PROPERTY);
    return this;
  }

  /**
   * The maximum amount of data that can be buffered for a JMS Message. If a FlowFile's size exceeds this value, the FlowFile will be routed to failure.
   */
  public final String getMaxBufferSize() {
    return properties.get(MAX_BUFFER_SIZE_PROPERTY);
  }

  /**
   * The maximum amount of data that can be buffered for a JMS Message. If a FlowFile's size exceeds this value, the FlowFile will be routed to failure.
   */
  public final PutJMS setMaxBufferSize(final String maxBufferSize) {
    properties.put(MAX_BUFFER_SIZE_PROPERTY, maxBufferSize);
    return this;
  }

  /**
   * The maximum amount of data that can be buffered for a JMS Message. If a FlowFile's size exceeds this value, the FlowFile will be routed to failure.
   */
  public final PutJMS removeMaxBufferSize() {
    properties.remove(MAX_BUFFER_SIZE_PROPERTY);
    return this;
  }

  /**
   * The amount of time that the message should live on the destination before being removed; if not specified, the message will never expire.
   */
  public final String getMessageTimeToLive() {
    return properties.get(MESSAGE_TIME_TO_LIVE_PROPERTY);
  }

  /**
   * The amount of time that the message should live on the destination before being removed; if not specified, the message will never expire.
   */
  public final PutJMS setMessageTimeToLive(final String messageTimeToLive) {
    properties.put(MESSAGE_TIME_TO_LIVE_PROPERTY, messageTimeToLive);
    return this;
  }

  /**
   * The amount of time that the message should live on the destination before being removed; if not specified, the message will never expire.
   */
  public final PutJMS removeMessageTimeToLive() {
    properties.remove(MESSAGE_TIME_TO_LIVE_PROPERTY);
    return this;
  }

  /**
   * Whether or not FlowFile Attributes should be translated into JMS Message Properties. If true, all attributes starting with 'jms.' will be set as Properties on the JMS Message (without the 'jms.' prefix). If an attribute exists that starts with the same value but ends in '.type', that attribute will be used to determine the JMS Message Property type.
   */
  public final String getCopyAttributesToJmsProperties() {
    return properties.get(COPY_ATTRIBUTES_TO_JMS_PROPERTIES_PROPERTY);
  }

  /**
   * Whether or not FlowFile Attributes should be translated into JMS Message Properties. If true, all attributes starting with 'jms.' will be set as Properties on the JMS Message (without the 'jms.' prefix). If an attribute exists that starts with the same value but ends in '.type', that attribute will be used to determine the JMS Message Property type.
   */
  public final PutJMS setCopyAttributesToJmsProperties(final String copyAttributesToJmsProperties) {
    properties.put(COPY_ATTRIBUTES_TO_JMS_PROPERTIES_PROPERTY, copyAttributesToJmsProperties);
    return this;
  }

  /**
   * Whether or not FlowFile Attributes should be translated into JMS Message Properties. If true, all attributes starting with 'jms.' will be set as Properties on the JMS Message (without the 'jms.' prefix). If an attribute exists that starts with the same value but ends in '.type', that attribute will be used to determine the JMS Message Property type.
   */
  public final PutJMS removeCopyAttributesToJmsProperties() {
    properties.remove(COPY_ATTRIBUTES_TO_JMS_PROPERTIES_PROPERTY);
    return this;
  }

  /**
   * A human-readable ID that can be used to associate connections with yourself so that the maintainers of the JMS Server know who to contact if problems arise
   */
  public final String getClientIdPrefix() {
    return properties.get(CLIENT_ID_PREFIX_PROPERTY);
  }

  /**
   * A human-readable ID that can be used to associate connections with yourself so that the maintainers of the JMS Server know who to contact if problems arise
   */
  public final PutJMS setClientIdPrefix(final String clientIdPrefix) {
    properties.put(CLIENT_ID_PREFIX_PROPERTY, clientIdPrefix);
    return this;
  }

  /**
   * A human-readable ID that can be used to associate connections with yourself so that the maintainers of the JMS Server know who to contact if problems arise
   */
  public final PutJMS removeClientIdPrefix() {
    properties.remove(CLIENT_ID_PREFIX_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutJMS setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutJMS removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutJMS, PutJMS> configurator) {
    return configurator.apply(new PutJMS()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutJMS.class) final Closure<PutJMS> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.PutJMS> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.PutJMS.class, com.tibtech.nifi.processors.standard.PutJMS.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutJMS, PutJMS> configurator) {
    return configurator.apply(new PutJMS(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutJMS.class) final Closure<PutJMS> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.PutJMS> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.PutJMS.class, com.tibtech.nifi.processors.standard.PutJMS.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
