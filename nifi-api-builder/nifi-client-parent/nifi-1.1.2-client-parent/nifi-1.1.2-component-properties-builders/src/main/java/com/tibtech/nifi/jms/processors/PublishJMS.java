package com.tibtech.nifi.jms.processors;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PublishJMS {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.jms.processors.PublishJMS";

  /**
   * The Controller Service that is used to obtain ConnectionFactory
   */
  public static final String CONNECTION_FACTORY_SERVICE_PROPERTY = "Connection Factory Service";

  /**
   * The name of the JMS Destination. Usually provided by the administrator (e.g., 'topic://myTopic' or 'myTopic').
   */
  public static final String DESTINATION_NAME_PROPERTY = "Destination Name";

  /**
   * The type of the JMS Destination. Could be one of 'QUEUE' or 'TOPIC'. Usually provided by the administrator. Defaults to 'TOPIC
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
   * The maximum limit for the number of cached Sessions.
   */
  public static final String SESSION_CACHE_SIZE_PROPERTY = "Session Cache size";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The Controller Service that is used to obtain ConnectionFactory
   */
  public final String getConnectionFactoryService() {
    return properties.get(CONNECTION_FACTORY_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service that is used to obtain ConnectionFactory
   */
  public final PublishJMS setConnectionFactoryService(final String connectionFactoryService) {
    properties.put(CONNECTION_FACTORY_SERVICE_PROPERTY, connectionFactoryService);
    return this;
  }

  /**
   * The Controller Service that is used to obtain ConnectionFactory
   */
  public final PublishJMS removeConnectionFactoryService() {
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
  public final PublishJMS setDestinationName(final String destinationName) {
    properties.put(DESTINATION_NAME_PROPERTY, destinationName);
    return this;
  }

  /**
   * The name of the JMS Destination. Usually provided by the administrator (e.g., 'topic://myTopic' or 'myTopic').
   */
  public final PublishJMS removeDestinationName() {
    properties.remove(DESTINATION_NAME_PROPERTY);
    return this;
  }

  /**
   * The type of the JMS Destination. Could be one of 'QUEUE' or 'TOPIC'. Usually provided by the administrator. Defaults to 'TOPIC
   */
  public final String getDestinationType() {
    return properties.get(DESTINATION_TYPE_PROPERTY);
  }

  /**
   * The type of the JMS Destination. Could be one of 'QUEUE' or 'TOPIC'. Usually provided by the administrator. Defaults to 'TOPIC
   */
  public final PublishJMS setDestinationType(final String destinationType) {
    properties.put(DESTINATION_TYPE_PROPERTY, destinationType);
    return this;
  }

  /**
   * The type of the JMS Destination. Could be one of 'QUEUE' or 'TOPIC'. Usually provided by the administrator. Defaults to 'TOPIC
   */
  public final PublishJMS removeDestinationType() {
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
  public final PublishJMS setUserName(final String userName) {
    properties.put(USER_NAME_PROPERTY, userName);
    return this;
  }

  /**
   * User Name used for authentication and authorization.
   */
  public final PublishJMS removeUserName() {
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
  public final PublishJMS setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password used for authentication and authorization.
   */
  public final PublishJMS removePassword() {
    properties.remove(PASSWORD_PROPERTY);
    return this;
  }

  /**
   * The maximum limit for the number of cached Sessions.
   */
  public final String getSessionCacheSize() {
    return properties.get(SESSION_CACHE_SIZE_PROPERTY);
  }

  /**
   * The maximum limit for the number of cached Sessions.
   */
  public final PublishJMS setSessionCacheSize(final String sessionCacheSize) {
    properties.put(SESSION_CACHE_SIZE_PROPERTY, sessionCacheSize);
    return this;
  }

  /**
   * The maximum limit for the number of cached Sessions.
   */
  public final PublishJMS removeSessionCacheSize() {
    properties.remove(SESSION_CACHE_SIZE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PublishJMS setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PublishJMS removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PublishJMS, PublishJMS> configurator) {
    return configurator.apply(new PublishJMS()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PublishJMS.class) final Closure<PublishJMS> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.jms.processors.PublishJMS> code = closure.rehydrate(c, com.tibtech.nifi.jms.processors.PublishJMS.class, com.tibtech.nifi.jms.processors.PublishJMS.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
