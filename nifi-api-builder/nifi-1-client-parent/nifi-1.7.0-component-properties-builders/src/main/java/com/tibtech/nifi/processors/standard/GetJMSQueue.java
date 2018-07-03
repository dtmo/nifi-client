package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GetJMSQueue {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.GetJMSQueue";

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
   * The JMS Acknowledgement Mode. Using Auto Acknowledge can cause messages to be lost on restart of NiFi but may provide better performance than Client Acknowledge.
   */
  public static final String ACKNOWLEDGEMENT_MODE_PROPERTY = "Acknowledgement Mode";

  /**
   * The JMS Message Selector to use in order to narrow the messages that are pulled
   */
  public static final String MESSAGE_SELECTOR_PROPERTY = "Message Selector";

  /**
   * Whether or not the JMS Message Properties should be copied to the FlowFile Attributes; if so, the attribute name will be jms.XXX, where XXX is the JMS Property name
   */
  public static final String COPY_JMS_PROPERTIES_TO_ATTRIBUTES_PROPERTY = "Copy JMS Properties to Attributes";

  /**
   * A human-readable ID that can be used to associate connections with yourself so that the maintainers of the JMS Server know who to contact if problems arise
   */
  public static final String CLIENT_ID_PREFIX_PROPERTY = "Client ID Prefix";

  private final Map<String, String> properties;

  public GetJMSQueue() {
    this.properties = new HashMap<>();
  }

  public GetJMSQueue(final Map<String, String> properties) {
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
  public final GetJMSQueue setJmsProvider(final String jmsProvider) {
    properties.put(JMS_PROVIDER_PROPERTY, jmsProvider);
    return this;
  }

  /**
   * The Provider used for the JMS Server
   */
  public final GetJMSQueue removeJmsProvider() {
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
  public final GetJMSQueue setUrl(final String url) {
    properties.put(URL_PROPERTY, url);
    return this;
  }

  /**
   * The URL of the JMS Server
   */
  public final GetJMSQueue removeUrl() {
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
  public final GetJMSQueue setDestinationName(final String destinationName) {
    properties.put(DESTINATION_NAME_PROPERTY, destinationName);
    return this;
  }

  /**
   * The name of the JMS Topic or queue to use
   */
  public final GetJMSQueue removeDestinationName() {
    properties.remove(DESTINATION_NAME_PROPERTY);
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
  public final GetJMSQueue setCommunicationsTimeout(final String communicationsTimeout) {
    properties.put(COMMUNICATIONS_TIMEOUT_PROPERTY, communicationsTimeout);
    return this;
  }

  /**
   * The amount of time to wait when attempting to receive a message before giving up and assuming failure
   */
  public final GetJMSQueue removeCommunicationsTimeout() {
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
  public final GetJMSQueue setMessageBatchSize(final String messageBatchSize) {
    properties.put(MESSAGE_BATCH_SIZE_PROPERTY, messageBatchSize);
    return this;
  }

  /**
   * The number of messages to pull/push in a single iteration of the processor
   */
  public final GetJMSQueue removeMessageBatchSize() {
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
  public final GetJMSQueue setUsername(final String username) {
    properties.put(USERNAME_PROPERTY, username);
    return this;
  }

  /**
   * Username used for authentication and authorization
   */
  public final GetJMSQueue removeUsername() {
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
  public final GetJMSQueue setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password used for authentication and authorization
   */
  public final GetJMSQueue removePassword() {
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
  public final GetJMSQueue setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context.
   */
  public final GetJMSQueue removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The JMS Acknowledgement Mode. Using Auto Acknowledge can cause messages to be lost on restart of NiFi but may provide better performance than Client Acknowledge.
   */
  public final String getAcknowledgementMode() {
    return properties.get(ACKNOWLEDGEMENT_MODE_PROPERTY);
  }

  /**
   * The JMS Acknowledgement Mode. Using Auto Acknowledge can cause messages to be lost on restart of NiFi but may provide better performance than Client Acknowledge.
   */
  public final GetJMSQueue setAcknowledgementMode(final String acknowledgementMode) {
    properties.put(ACKNOWLEDGEMENT_MODE_PROPERTY, acknowledgementMode);
    return this;
  }

  /**
   * The JMS Acknowledgement Mode. Using Auto Acknowledge can cause messages to be lost on restart of NiFi but may provide better performance than Client Acknowledge.
   */
  public final GetJMSQueue removeAcknowledgementMode() {
    properties.remove(ACKNOWLEDGEMENT_MODE_PROPERTY);
    return this;
  }

  /**
   * The JMS Message Selector to use in order to narrow the messages that are pulled
   */
  public final String getMessageSelector() {
    return properties.get(MESSAGE_SELECTOR_PROPERTY);
  }

  /**
   * The JMS Message Selector to use in order to narrow the messages that are pulled
   */
  public final GetJMSQueue setMessageSelector(final String messageSelector) {
    properties.put(MESSAGE_SELECTOR_PROPERTY, messageSelector);
    return this;
  }

  /**
   * The JMS Message Selector to use in order to narrow the messages that are pulled
   */
  public final GetJMSQueue removeMessageSelector() {
    properties.remove(MESSAGE_SELECTOR_PROPERTY);
    return this;
  }

  /**
   * Whether or not the JMS Message Properties should be copied to the FlowFile Attributes; if so, the attribute name will be jms.XXX, where XXX is the JMS Property name
   */
  public final String getCopyJmsPropertiesToAttributes() {
    return properties.get(COPY_JMS_PROPERTIES_TO_ATTRIBUTES_PROPERTY);
  }

  /**
   * Whether or not the JMS Message Properties should be copied to the FlowFile Attributes; if so, the attribute name will be jms.XXX, where XXX is the JMS Property name
   */
  public final GetJMSQueue setCopyJmsPropertiesToAttributes(
      final String copyJmsPropertiesToAttributes) {
    properties.put(COPY_JMS_PROPERTIES_TO_ATTRIBUTES_PROPERTY, copyJmsPropertiesToAttributes);
    return this;
  }

  /**
   * Whether or not the JMS Message Properties should be copied to the FlowFile Attributes; if so, the attribute name will be jms.XXX, where XXX is the JMS Property name
   */
  public final GetJMSQueue removeCopyJmsPropertiesToAttributes() {
    properties.remove(COPY_JMS_PROPERTIES_TO_ATTRIBUTES_PROPERTY);
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
  public final GetJMSQueue setClientIdPrefix(final String clientIdPrefix) {
    properties.put(CLIENT_ID_PREFIX_PROPERTY, clientIdPrefix);
    return this;
  }

  /**
   * A human-readable ID that can be used to associate connections with yourself so that the maintainers of the JMS Server know who to contact if problems arise
   */
  public final GetJMSQueue removeClientIdPrefix() {
    properties.remove(CLIENT_ID_PREFIX_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GetJMSQueue setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GetJMSQueue removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<GetJMSQueue, GetJMSQueue> configurator) {
    return configurator.apply(new GetJMSQueue()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetJMSQueue.class) final Closure<GetJMSQueue> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.GetJMSQueue> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.GetJMSQueue.class, com.tibtech.nifi.processors.standard.GetJMSQueue.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<GetJMSQueue, GetJMSQueue> configurator) {
    return configurator.apply(new GetJMSQueue(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetJMSQueue.class) final Closure<GetJMSQueue> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.GetJMSQueue> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.GetJMSQueue.class, com.tibtech.nifi.processors.standard.GetJMSQueue.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
