package com.tibtech.nifi.jms.processors;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ConsumeJMS {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.jms.processors.ConsumeJMS";

  /**
   * The Controller Service that is used to obtain ConnectionFactory
   */
  public static final String CONNECTION_FACTORY_SERVICE_PROPERTY = "Connection Factory Service";

  /**
   * The name of the JMS Destination. Usually provided by the administrator (e.g., 'topic://myTopic' or 'myTopic').
   */
  public static final String DESTINATION_NAME_PROPERTY = "Destination Name";

  /**
   * The type of the JMS Destination. Could be one of 'QUEUE' or 'TOPIC'. Usually provided by the administrator. Defaults to 'QUEUE'
   */
  public static final String DESTINATION_TYPE_PROPERTY = "Destination Type";

  /**
   * User Name used for authentication and authorization.
   */
  public static final String USER_NAME_PROPERTY = "User Name";

  /**
   * Password used for authentication and authorization.
   */
  public static final String PASSWORD_PROPERTY = "Password";

  /**
   * The client id to be set on the connection, if set. For durable non shared consumer this is mandatory, for all others it is optional, typically with shared consumers it is undesirable to be set. Please see JMS spec for further details
   */
  public static final String CONNECTION_CLIENT_ID_PROPERTY = "Connection Client ID";

  /**
   * This property is deprecated and no longer has any effect on the Processor. It will be removed in a later version.
   */
  public static final String SESSION_CACHE_SIZE_PROPERTY = "Session Cache size";

  /**
   * The name of the character set to use to construct or interpret TextMessages
   */
  public static final String CHARACTER_SET_PROPERTY = "character-set";

  /**
   * The JMS Acknowledgement Mode. Using Auto Acknowledge can cause messages to be lost on restart of NiFi but may provide better performance than Client Acknowledge.
   */
  public static final String ACKNOWLEDGEMENT_MODE_PROPERTY = "Acknowledgement Mode";

  /**
   * If destination is Topic if present then make it the consumer durable. @see https://docs.oracle.com/javaee/7/api/javax/jms/Session.html#createDurableConsumer-javax.jms.Topic-java.lang.String-
   */
  public static final String DURABLE_SUBSCRIPTION_PROPERTY = "Durable subscription";

  /**
   * If destination is Topic if present then make it the consumer shared. @see https://docs.oracle.com/javaee/7/api/javax/jms/Session.html#createSharedConsumer-javax.jms.Topic-java.lang.String-
   */
  public static final String SHARED_SUBSCRIPTION_PROPERTY = "Shared subscription";

  /**
   * The name of the subscription to use if destination is Topic and is shared or durable.
   */
  public static final String SUBSCRIPTION_NAME_PROPERTY = "Subscription Name";

  private final Map<String, String> properties;

  public ConsumeJMS() {
    this.properties = new HashMap<>();
  }

  public ConsumeJMS(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The Controller Service that is used to obtain ConnectionFactory
   */
  public final String getConnectionFactoryService() {
    return properties.get(CONNECTION_FACTORY_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service that is used to obtain ConnectionFactory
   */
  public final ConsumeJMS setConnectionFactoryService(final String connectionFactoryService) {
    properties.put(CONNECTION_FACTORY_SERVICE_PROPERTY, connectionFactoryService);
    return this;
  }

  /**
   * The Controller Service that is used to obtain ConnectionFactory
   */
  public final ConsumeJMS removeConnectionFactoryService() {
    properties.remove(CONNECTION_FACTORY_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The name of the JMS Destination. Usually provided by the administrator (e.g., 'topic://myTopic' or 'myTopic').
   */
  public final String getDestinationName() {
    return properties.get(DESTINATION_NAME_PROPERTY);
  }

  /**
   * The name of the JMS Destination. Usually provided by the administrator (e.g., 'topic://myTopic' or 'myTopic').
   */
  public final ConsumeJMS setDestinationName(final String destinationName) {
    properties.put(DESTINATION_NAME_PROPERTY, destinationName);
    return this;
  }

  /**
   * The name of the JMS Destination. Usually provided by the administrator (e.g., 'topic://myTopic' or 'myTopic').
   */
  public final ConsumeJMS removeDestinationName() {
    properties.remove(DESTINATION_NAME_PROPERTY);
    return this;
  }

  /**
   * The type of the JMS Destination. Could be one of 'QUEUE' or 'TOPIC'. Usually provided by the administrator. Defaults to 'QUEUE'
   */
  public final String getDestinationType() {
    return properties.get(DESTINATION_TYPE_PROPERTY);
  }

  /**
   * The type of the JMS Destination. Could be one of 'QUEUE' or 'TOPIC'. Usually provided by the administrator. Defaults to 'QUEUE'
   */
  public final ConsumeJMS setDestinationType(final String destinationType) {
    properties.put(DESTINATION_TYPE_PROPERTY, destinationType);
    return this;
  }

  /**
   * The type of the JMS Destination. Could be one of 'QUEUE' or 'TOPIC'. Usually provided by the administrator. Defaults to 'QUEUE'
   */
  public final ConsumeJMS removeDestinationType() {
    properties.remove(DESTINATION_TYPE_PROPERTY);
    return this;
  }

  /**
   * User Name used for authentication and authorization.
   */
  public final String getUserName() {
    return properties.get(USER_NAME_PROPERTY);
  }

  /**
   * User Name used for authentication and authorization.
   */
  public final ConsumeJMS setUserName(final String userName) {
    properties.put(USER_NAME_PROPERTY, userName);
    return this;
  }

  /**
   * User Name used for authentication and authorization.
   */
  public final ConsumeJMS removeUserName() {
    properties.remove(USER_NAME_PROPERTY);
    return this;
  }

  /**
   * Password used for authentication and authorization.
   */
  public final String getPassword() {
    return properties.get(PASSWORD_PROPERTY);
  }

  /**
   * Password used for authentication and authorization.
   */
  public final ConsumeJMS setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password used for authentication and authorization.
   */
  public final ConsumeJMS removePassword() {
    properties.remove(PASSWORD_PROPERTY);
    return this;
  }

  /**
   * The client id to be set on the connection, if set. For durable non shared consumer this is mandatory, for all others it is optional, typically with shared consumers it is undesirable to be set. Please see JMS spec for further details
   */
  public final String getConnectionClientId() {
    return properties.get(CONNECTION_CLIENT_ID_PROPERTY);
  }

  /**
   * The client id to be set on the connection, if set. For durable non shared consumer this is mandatory, for all others it is optional, typically with shared consumers it is undesirable to be set. Please see JMS spec for further details
   */
  public final ConsumeJMS setConnectionClientId(final String connectionClientId) {
    properties.put(CONNECTION_CLIENT_ID_PROPERTY, connectionClientId);
    return this;
  }

  /**
   * The client id to be set on the connection, if set. For durable non shared consumer this is mandatory, for all others it is optional, typically with shared consumers it is undesirable to be set. Please see JMS spec for further details
   */
  public final ConsumeJMS removeConnectionClientId() {
    properties.remove(CONNECTION_CLIENT_ID_PROPERTY);
    return this;
  }

  /**
   * This property is deprecated and no longer has any effect on the Processor. It will be removed in a later version.
   */
  public final String getSessionCacheSize() {
    return properties.get(SESSION_CACHE_SIZE_PROPERTY);
  }

  /**
   * This property is deprecated and no longer has any effect on the Processor. It will be removed in a later version.
   */
  public final ConsumeJMS setSessionCacheSize(final String sessionCacheSize) {
    properties.put(SESSION_CACHE_SIZE_PROPERTY, sessionCacheSize);
    return this;
  }

  /**
   * This property is deprecated and no longer has any effect on the Processor. It will be removed in a later version.
   */
  public final ConsumeJMS removeSessionCacheSize() {
    properties.remove(SESSION_CACHE_SIZE_PROPERTY);
    return this;
  }

  /**
   * The name of the character set to use to construct or interpret TextMessages
   */
  public final String getCharacterSet() {
    return properties.get(CHARACTER_SET_PROPERTY);
  }

  /**
   * The name of the character set to use to construct or interpret TextMessages
   */
  public final ConsumeJMS setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * The name of the character set to use to construct or interpret TextMessages
   */
  public final ConsumeJMS removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
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
  public final ConsumeJMS setAcknowledgementMode(final String acknowledgementMode) {
    properties.put(ACKNOWLEDGEMENT_MODE_PROPERTY, acknowledgementMode);
    return this;
  }

  /**
   * The JMS Acknowledgement Mode. Using Auto Acknowledge can cause messages to be lost on restart of NiFi but may provide better performance than Client Acknowledge.
   */
  public final ConsumeJMS removeAcknowledgementMode() {
    properties.remove(ACKNOWLEDGEMENT_MODE_PROPERTY);
    return this;
  }

  /**
   * If destination is Topic if present then make it the consumer durable. @see https://docs.oracle.com/javaee/7/api/javax/jms/Session.html#createDurableConsumer-javax.jms.Topic-java.lang.String-
   */
  public final String getDurableSubscription() {
    return properties.get(DURABLE_SUBSCRIPTION_PROPERTY);
  }

  /**
   * If destination is Topic if present then make it the consumer durable. @see https://docs.oracle.com/javaee/7/api/javax/jms/Session.html#createDurableConsumer-javax.jms.Topic-java.lang.String-
   */
  public final ConsumeJMS setDurableSubscription(final String durableSubscription) {
    properties.put(DURABLE_SUBSCRIPTION_PROPERTY, durableSubscription);
    return this;
  }

  /**
   * If destination is Topic if present then make it the consumer durable. @see https://docs.oracle.com/javaee/7/api/javax/jms/Session.html#createDurableConsumer-javax.jms.Topic-java.lang.String-
   */
  public final ConsumeJMS removeDurableSubscription() {
    properties.remove(DURABLE_SUBSCRIPTION_PROPERTY);
    return this;
  }

  /**
   * If destination is Topic if present then make it the consumer shared. @see https://docs.oracle.com/javaee/7/api/javax/jms/Session.html#createSharedConsumer-javax.jms.Topic-java.lang.String-
   */
  public final String getSharedSubscription() {
    return properties.get(SHARED_SUBSCRIPTION_PROPERTY);
  }

  /**
   * If destination is Topic if present then make it the consumer shared. @see https://docs.oracle.com/javaee/7/api/javax/jms/Session.html#createSharedConsumer-javax.jms.Topic-java.lang.String-
   */
  public final ConsumeJMS setSharedSubscription(final String sharedSubscription) {
    properties.put(SHARED_SUBSCRIPTION_PROPERTY, sharedSubscription);
    return this;
  }

  /**
   * If destination is Topic if present then make it the consumer shared. @see https://docs.oracle.com/javaee/7/api/javax/jms/Session.html#createSharedConsumer-javax.jms.Topic-java.lang.String-
   */
  public final ConsumeJMS removeSharedSubscription() {
    properties.remove(SHARED_SUBSCRIPTION_PROPERTY);
    return this;
  }

  /**
   * The name of the subscription to use if destination is Topic and is shared or durable.
   */
  public final String getSubscriptionName() {
    return properties.get(SUBSCRIPTION_NAME_PROPERTY);
  }

  /**
   * The name of the subscription to use if destination is Topic and is shared or durable.
   */
  public final ConsumeJMS setSubscriptionName(final String subscriptionName) {
    properties.put(SUBSCRIPTION_NAME_PROPERTY, subscriptionName);
    return this;
  }

  /**
   * The name of the subscription to use if destination is Topic and is shared or durable.
   */
  public final ConsumeJMS removeSubscriptionName() {
    properties.remove(SUBSCRIPTION_NAME_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ConsumeJMS setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ConsumeJMS removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ConsumeJMS, ConsumeJMS> configurator) {
    return configurator.apply(new ConsumeJMS()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConsumeJMS.class) final Closure<ConsumeJMS> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.jms.processors.ConsumeJMS> code = closure.rehydrate(c, com.tibtech.nifi.jms.processors.ConsumeJMS.class, com.tibtech.nifi.jms.processors.ConsumeJMS.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ConsumeJMS, ConsumeJMS> configurator) {
    return configurator.apply(new ConsumeJMS(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConsumeJMS.class) final Closure<ConsumeJMS> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.jms.processors.ConsumeJMS> code = closure.rehydrate(c, com.tibtech.nifi.jms.processors.ConsumeJMS.class, com.tibtech.nifi.jms.processors.ConsumeJMS.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
