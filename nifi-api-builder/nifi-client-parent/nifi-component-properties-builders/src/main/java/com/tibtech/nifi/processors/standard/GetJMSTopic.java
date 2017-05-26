package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GetJMSTopic {
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

  /**
   * If true, connections to the specified topic will use Durable Subscription so that messages are queued when we are not pulling them
   */
  public static final String USE_DURABLE_SUBSCRIPTION_PROPERTY = "Use Durable Subscription";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The Provider used for the JMS Server
   */
  public final String getJmsProvider() {
    return properties.get(JMS_PROVIDER_PROPERTY);
  }

  /**
   * The Provider used for the JMS Server
   */
  public final GetJMSTopic setJmsProvider(final String jmsProvider) {
    properties.put(JMS_PROVIDER_PROPERTY, jmsProvider);
    return this;
  }

  /**
   * The Provider used for the JMS Server
   */
  public final GetJMSTopic removeJmsProvider() {
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
  public final GetJMSTopic setUrl(final String url) {
    properties.put(URL_PROPERTY, url);
    return this;
  }

  /**
   * The URL of the JMS Server
   */
  public final GetJMSTopic removeUrl() {
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
  public final GetJMSTopic setDestinationName(final String destinationName) {
    properties.put(DESTINATION_NAME_PROPERTY, destinationName);
    return this;
  }

  /**
   * The name of the JMS Topic or queue to use
   */
  public final GetJMSTopic removeDestinationName() {
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
  public final GetJMSTopic setCommunicationsTimeout(final String communicationsTimeout) {
    properties.put(COMMUNICATIONS_TIMEOUT_PROPERTY, communicationsTimeout);
    return this;
  }

  /**
   * The amount of time to wait when attempting to receive a message before giving up and assuming failure
   */
  public final GetJMSTopic removeCommunicationsTimeout() {
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
  public final GetJMSTopic setMessageBatchSize(final String messageBatchSize) {
    properties.put(MESSAGE_BATCH_SIZE_PROPERTY, messageBatchSize);
    return this;
  }

  /**
   * The number of messages to pull/push in a single iteration of the processor
   */
  public final GetJMSTopic removeMessageBatchSize() {
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
  public final GetJMSTopic setUsername(final String username) {
    properties.put(USERNAME_PROPERTY, username);
    return this;
  }

  /**
   * Username used for authentication and authorization
   */
  public final GetJMSTopic removeUsername() {
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
  public final GetJMSTopic setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password used for authentication and authorization
   */
  public final GetJMSTopic removePassword() {
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
  public final GetJMSTopic setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context.
   */
  public final GetJMSTopic removeSslContextService() {
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
  public final GetJMSTopic setAcknowledgementMode(final String acknowledgementMode) {
    properties.put(ACKNOWLEDGEMENT_MODE_PROPERTY, acknowledgementMode);
    return this;
  }

  /**
   * The JMS Acknowledgement Mode. Using Auto Acknowledge can cause messages to be lost on restart of NiFi but may provide better performance than Client Acknowledge.
   */
  public final GetJMSTopic removeAcknowledgementMode() {
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
  public final GetJMSTopic setMessageSelector(final String messageSelector) {
    properties.put(MESSAGE_SELECTOR_PROPERTY, messageSelector);
    return this;
  }

  /**
   * The JMS Message Selector to use in order to narrow the messages that are pulled
   */
  public final GetJMSTopic removeMessageSelector() {
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
  public final GetJMSTopic setCopyJmsPropertiesToAttributes(final String copyJmsPropertiesToAttributes) {
    properties.put(COPY_JMS_PROPERTIES_TO_ATTRIBUTES_PROPERTY, copyJmsPropertiesToAttributes);
    return this;
  }

  /**
   * Whether or not the JMS Message Properties should be copied to the FlowFile Attributes; if so, the attribute name will be jms.XXX, where XXX is the JMS Property name
   */
  public final GetJMSTopic removeCopyJmsPropertiesToAttributes() {
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
  public final GetJMSTopic setClientIdPrefix(final String clientIdPrefix) {
    properties.put(CLIENT_ID_PREFIX_PROPERTY, clientIdPrefix);
    return this;
  }

  /**
   * A human-readable ID that can be used to associate connections with yourself so that the maintainers of the JMS Server know who to contact if problems arise
   */
  public final GetJMSTopic removeClientIdPrefix() {
    properties.remove(CLIENT_ID_PREFIX_PROPERTY);
    return this;
  }

  /**
   * If true, connections to the specified topic will use Durable Subscription so that messages are queued when we are not pulling them
   */
  public final String getUseDurableSubscription() {
    return properties.get(USE_DURABLE_SUBSCRIPTION_PROPERTY);
  }

  /**
   * If true, connections to the specified topic will use Durable Subscription so that messages are queued when we are not pulling them
   */
  public final GetJMSTopic setUseDurableSubscription(final String useDurableSubscription) {
    properties.put(USE_DURABLE_SUBSCRIPTION_PROPERTY, useDurableSubscription);
    return this;
  }

  /**
   * If true, connections to the specified topic will use Durable Subscription so that messages are queued when we are not pulling them
   */
  public final GetJMSTopic removeUseDurableSubscription() {
    properties.remove(USE_DURABLE_SUBSCRIPTION_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GetJMSTopic setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GetJMSTopic removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<GetJMSTopic, GetJMSTopic> configurator) {
    return configurator.apply(new GetJMSTopic()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetJMSTopic.class) final Closure<GetJMSTopic> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.GetJMSTopic> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.GetJMSTopic.class, com.tibtech.nifi.processors.standard.GetJMSTopic.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
