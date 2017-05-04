package com.tibtech.nifi.amqp.processors;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PublishAMQP {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.amqp.processors.PublishAMQP";

  /**
   * The name of the AMQP Exchange the messages will be sent to. Usually provided by the AMQP administrator (e.g., 'amq.direct'). It is an optional property. If kept empty the messages will be sent to a default AMQP exchange.
   */
  public static final String EXCHANGE_NAME_PROPERTY = "Exchange Name";

  /**
   * The name of the Routing Key that will be used by AMQP to route messages from the exchange to a destination queue(s). Usually provided by the administrator (e.g., 'myKey')In the event when messages are sent to a default exchange this property corresponds to a destination queue name, otherwise a binding from the Exchange to a Queue via Routing Key must be set (usually by the AMQP administrator)
   */
  public static final String ROUTING_KEY_PROPERTY = "Routing Key";

  /**
   * Network address of AMQP broker (e.g., localhost)
   */
  public static final String HOST_NAME_PROPERTY = "Host Name";

  /**
   * Numeric value identifying Port of AMQP broker (e.g., 5671)
   */
  public static final String PORT_PROPERTY = "Port";

  /**
   * Virtual Host name which segregates AMQP system for enhanced security.
   */
  public static final String VIRTUAL_HOST_PROPERTY = "Virtual Host";

  /**
   * User Name used for authentication and authorization.
   */
  public static final String USER_NAME_PROPERTY = "User Name";

  /**
   * Password used for authentication and authorization.
   */
  public static final String PASSWORD_PROPERTY = "Password";

  /**
   * AMQP Version. Currently only supports AMQP v0.9.1.
   */
  public static final String AMQP_VERSION_PROPERTY = "AMQP Version";

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "ssl-context-service";

  /**
   * Client authentication policy when connecting to secure (TLS/SSL) AMQP broker. Possible values are REQUIRED, WANT, NONE. This property is only used when an SSL Context has been defined and enabled.
   */
  public static final String SSL_CLIENT_AUTH_PROPERTY = "ssl-client-auth";

  private final Map<String, String> properties;

  public PublishAMQP() {
    this.properties = new HashMap<>();
  }

  public PublishAMQP(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The name of the AMQP Exchange the messages will be sent to. Usually provided by the AMQP administrator (e.g., 'amq.direct'). It is an optional property. If kept empty the messages will be sent to a default AMQP exchange.
   */
  public final String getExchangeName() {
    return properties.get(EXCHANGE_NAME_PROPERTY);
  }

  /**
   * The name of the AMQP Exchange the messages will be sent to. Usually provided by the AMQP administrator (e.g., 'amq.direct'). It is an optional property. If kept empty the messages will be sent to a default AMQP exchange.
   */
  public final PublishAMQP setExchangeName(final String exchangeName) {
    properties.put(EXCHANGE_NAME_PROPERTY, exchangeName);
    return this;
  }

  /**
   * The name of the AMQP Exchange the messages will be sent to. Usually provided by the AMQP administrator (e.g., 'amq.direct'). It is an optional property. If kept empty the messages will be sent to a default AMQP exchange.
   */
  public final PublishAMQP removeExchangeName() {
    properties.remove(EXCHANGE_NAME_PROPERTY);
    return this;
  }

  /**
   * The name of the Routing Key that will be used by AMQP to route messages from the exchange to a destination queue(s). Usually provided by the administrator (e.g., 'myKey')In the event when messages are sent to a default exchange this property corresponds to a destination queue name, otherwise a binding from the Exchange to a Queue via Routing Key must be set (usually by the AMQP administrator)
   */
  public final String getRoutingKey() {
    return properties.get(ROUTING_KEY_PROPERTY);
  }

  /**
   * The name of the Routing Key that will be used by AMQP to route messages from the exchange to a destination queue(s). Usually provided by the administrator (e.g., 'myKey')In the event when messages are sent to a default exchange this property corresponds to a destination queue name, otherwise a binding from the Exchange to a Queue via Routing Key must be set (usually by the AMQP administrator)
   */
  public final PublishAMQP setRoutingKey(final String routingKey) {
    properties.put(ROUTING_KEY_PROPERTY, routingKey);
    return this;
  }

  /**
   * The name of the Routing Key that will be used by AMQP to route messages from the exchange to a destination queue(s). Usually provided by the administrator (e.g., 'myKey')In the event when messages are sent to a default exchange this property corresponds to a destination queue name, otherwise a binding from the Exchange to a Queue via Routing Key must be set (usually by the AMQP administrator)
   */
  public final PublishAMQP removeRoutingKey() {
    properties.remove(ROUTING_KEY_PROPERTY);
    return this;
  }

  /**
   * Network address of AMQP broker (e.g., localhost)
   */
  public final String getHostName() {
    return properties.get(HOST_NAME_PROPERTY);
  }

  /**
   * Network address of AMQP broker (e.g., localhost)
   */
  public final PublishAMQP setHostName(final String hostName) {
    properties.put(HOST_NAME_PROPERTY, hostName);
    return this;
  }

  /**
   * Network address of AMQP broker (e.g., localhost)
   */
  public final PublishAMQP removeHostName() {
    properties.remove(HOST_NAME_PROPERTY);
    return this;
  }

  /**
   * Numeric value identifying Port of AMQP broker (e.g., 5671)
   */
  public final String getPort() {
    return properties.get(PORT_PROPERTY);
  }

  /**
   * Numeric value identifying Port of AMQP broker (e.g., 5671)
   */
  public final PublishAMQP setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * Numeric value identifying Port of AMQP broker (e.g., 5671)
   */
  public final PublishAMQP removePort() {
    properties.remove(PORT_PROPERTY);
    return this;
  }

  /**
   * Virtual Host name which segregates AMQP system for enhanced security.
   */
  public final String getVirtualHost() {
    return properties.get(VIRTUAL_HOST_PROPERTY);
  }

  /**
   * Virtual Host name which segregates AMQP system for enhanced security.
   */
  public final PublishAMQP setVirtualHost(final String virtualHost) {
    properties.put(VIRTUAL_HOST_PROPERTY, virtualHost);
    return this;
  }

  /**
   * Virtual Host name which segregates AMQP system for enhanced security.
   */
  public final PublishAMQP removeVirtualHost() {
    properties.remove(VIRTUAL_HOST_PROPERTY);
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
  public final PublishAMQP setUserName(final String userName) {
    properties.put(USER_NAME_PROPERTY, userName);
    return this;
  }

  /**
   * User Name used for authentication and authorization.
   */
  public final PublishAMQP removeUserName() {
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
  public final PublishAMQP setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password used for authentication and authorization.
   */
  public final PublishAMQP removePassword() {
    properties.remove(PASSWORD_PROPERTY);
    return this;
  }

  /**
   * AMQP Version. Currently only supports AMQP v0.9.1.
   */
  public final String getAmqpVersion() {
    return properties.get(AMQP_VERSION_PROPERTY);
  }

  /**
   * AMQP Version. Currently only supports AMQP v0.9.1.
   */
  public final PublishAMQP setAmqpVersion(final String amqpVersion) {
    properties.put(AMQP_VERSION_PROPERTY, amqpVersion);
    return this;
  }

  /**
   * AMQP Version. Currently only supports AMQP v0.9.1.
   */
  public final PublishAMQP removeAmqpVersion() {
    properties.remove(AMQP_VERSION_PROPERTY);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public final PublishAMQP setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public final PublishAMQP removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Client authentication policy when connecting to secure (TLS/SSL) AMQP broker. Possible values are REQUIRED, WANT, NONE. This property is only used when an SSL Context has been defined and enabled.
   */
  public final String getSslClientAuth() {
    return properties.get(SSL_CLIENT_AUTH_PROPERTY);
  }

  /**
   * Client authentication policy when connecting to secure (TLS/SSL) AMQP broker. Possible values are REQUIRED, WANT, NONE. This property is only used when an SSL Context has been defined and enabled.
   */
  public final PublishAMQP setSslClientAuth(final String sslClientAuth) {
    properties.put(SSL_CLIENT_AUTH_PROPERTY, sslClientAuth);
    return this;
  }

  /**
   * Client authentication policy when connecting to secure (TLS/SSL) AMQP broker. Possible values are REQUIRED, WANT, NONE. This property is only used when an SSL Context has been defined and enabled.
   */
  public final PublishAMQP removeSslClientAuth() {
    properties.remove(SSL_CLIENT_AUTH_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PublishAMQP setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PublishAMQP removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PublishAMQP, PublishAMQP> configurator) {
    return configurator.apply(new PublishAMQP()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PublishAMQP.class) final Closure<PublishAMQP> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.amqp.processors.PublishAMQP> code = closure.rehydrate(c, com.tibtech.nifi.amqp.processors.PublishAMQP.class, com.tibtech.nifi.amqp.processors.PublishAMQP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PublishAMQP, PublishAMQP> configurator) {
    return configurator.apply(new PublishAMQP(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PublishAMQP.class) final Closure<PublishAMQP> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.amqp.processors.PublishAMQP> code = closure.rehydrate(c, com.tibtech.nifi.amqp.processors.PublishAMQP.class, com.tibtech.nifi.amqp.processors.PublishAMQP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
