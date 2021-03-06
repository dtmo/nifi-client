package com.tibtech.nifi.amqp.processors;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ConsumeAMQP {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.amqp.processors.ConsumeAMQP";

  /**
   * The name of the existing AMQP Queue from which messages will be consumed. Usually pre-defined by AMQP administrator. 
   */
  public static final String QUEUE_PROPERTY = "Queue";

  /**
   * If true, messages that are received will be auto-acknowledged by the AMQP Broker. This generally will provide better throughput but could result in messages being lost upon restart of NiFi
   */
  public static final String AUTO_ACKNOWLEDGE_PROPERTY = "auto.acknowledge";

  /**
   * The maximum number of messages that should be pulled in a single session. Once this many messages have been received (or once no more messages are readily available), the messages received will be transferred to the 'success' relationship and the messages will be acknowledged with the AMQP Broker. Setting this value to a larger number could result in better performance, particularly for very small messages, but can also result in more messages being duplicated upon sudden restart of NiFi.
   */
  public static final String BATCH_SIZE_PROPERTY = "batch.size";

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
   * Authenticate using the SSL certificate common name rather than user name/password.
   */
  public static final String CERT_AUTHENTICATION_PROPERTY = "cert-authentication";

  /**
   * Client authentication policy when connecting to secure (TLS/SSL) AMQP broker. Possible values are REQUIRED, WANT, NONE. This property is only used when an SSL Context has been defined and enabled.
   */
  public static final String SSL_CLIENT_AUTH_PROPERTY = "ssl-client-auth";

  private final Map<String, String> properties;

  public ConsumeAMQP() {
    this.properties = new HashMap<>();
  }

  public ConsumeAMQP(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The name of the existing AMQP Queue from which messages will be consumed. Usually pre-defined by AMQP administrator. 
   */
  public final String getQueue() {
    return properties.get(QUEUE_PROPERTY);
  }

  /**
   * The name of the existing AMQP Queue from which messages will be consumed. Usually pre-defined by AMQP administrator. 
   */
  public final ConsumeAMQP setQueue(final String queue) {
    properties.put(QUEUE_PROPERTY, queue);
    return this;
  }

  /**
   * The name of the existing AMQP Queue from which messages will be consumed. Usually pre-defined by AMQP administrator. 
   */
  public final ConsumeAMQP removeQueue() {
    properties.remove(QUEUE_PROPERTY);
    return this;
  }

  /**
   * If true, messages that are received will be auto-acknowledged by the AMQP Broker. This generally will provide better throughput but could result in messages being lost upon restart of NiFi
   */
  public final String getAutoAcknowledge() {
    return properties.get(AUTO_ACKNOWLEDGE_PROPERTY);
  }

  /**
   * If true, messages that are received will be auto-acknowledged by the AMQP Broker. This generally will provide better throughput but could result in messages being lost upon restart of NiFi
   */
  public final ConsumeAMQP setAutoAcknowledge(final String autoAcknowledge) {
    properties.put(AUTO_ACKNOWLEDGE_PROPERTY, autoAcknowledge);
    return this;
  }

  /**
   * If true, messages that are received will be auto-acknowledged by the AMQP Broker. This generally will provide better throughput but could result in messages being lost upon restart of NiFi
   */
  public final ConsumeAMQP removeAutoAcknowledge() {
    properties.remove(AUTO_ACKNOWLEDGE_PROPERTY);
    return this;
  }

  /**
   * The maximum number of messages that should be pulled in a single session. Once this many messages have been received (or once no more messages are readily available), the messages received will be transferred to the 'success' relationship and the messages will be acknowledged with the AMQP Broker. Setting this value to a larger number could result in better performance, particularly for very small messages, but can also result in more messages being duplicated upon sudden restart of NiFi.
   */
  public final String getBatchSize() {
    return properties.get(BATCH_SIZE_PROPERTY);
  }

  /**
   * The maximum number of messages that should be pulled in a single session. Once this many messages have been received (or once no more messages are readily available), the messages received will be transferred to the 'success' relationship and the messages will be acknowledged with the AMQP Broker. Setting this value to a larger number could result in better performance, particularly for very small messages, but can also result in more messages being duplicated upon sudden restart of NiFi.
   */
  public final ConsumeAMQP setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * The maximum number of messages that should be pulled in a single session. Once this many messages have been received (or once no more messages are readily available), the messages received will be transferred to the 'success' relationship and the messages will be acknowledged with the AMQP Broker. Setting this value to a larger number could result in better performance, particularly for very small messages, but can also result in more messages being duplicated upon sudden restart of NiFi.
   */
  public final ConsumeAMQP removeBatchSize() {
    properties.remove(BATCH_SIZE_PROPERTY);
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
  public final ConsumeAMQP setHostName(final String hostName) {
    properties.put(HOST_NAME_PROPERTY, hostName);
    return this;
  }

  /**
   * Network address of AMQP broker (e.g., localhost)
   */
  public final ConsumeAMQP removeHostName() {
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
  public final ConsumeAMQP setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * Numeric value identifying Port of AMQP broker (e.g., 5671)
   */
  public final ConsumeAMQP removePort() {
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
  public final ConsumeAMQP setVirtualHost(final String virtualHost) {
    properties.put(VIRTUAL_HOST_PROPERTY, virtualHost);
    return this;
  }

  /**
   * Virtual Host name which segregates AMQP system for enhanced security.
   */
  public final ConsumeAMQP removeVirtualHost() {
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
  public final ConsumeAMQP setUserName(final String userName) {
    properties.put(USER_NAME_PROPERTY, userName);
    return this;
  }

  /**
   * User Name used for authentication and authorization.
   */
  public final ConsumeAMQP removeUserName() {
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
  public final ConsumeAMQP setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password used for authentication and authorization.
   */
  public final ConsumeAMQP removePassword() {
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
  public final ConsumeAMQP setAmqpVersion(final String amqpVersion) {
    properties.put(AMQP_VERSION_PROPERTY, amqpVersion);
    return this;
  }

  /**
   * AMQP Version. Currently only supports AMQP v0.9.1.
   */
  public final ConsumeAMQP removeAmqpVersion() {
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
  public final ConsumeAMQP setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public final ConsumeAMQP removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Authenticate using the SSL certificate common name rather than user name/password.
   */
  public final String getCertAuthentication() {
    return properties.get(CERT_AUTHENTICATION_PROPERTY);
  }

  /**
   * Authenticate using the SSL certificate common name rather than user name/password.
   */
  public final ConsumeAMQP setCertAuthentication(final String certAuthentication) {
    properties.put(CERT_AUTHENTICATION_PROPERTY, certAuthentication);
    return this;
  }

  /**
   * Authenticate using the SSL certificate common name rather than user name/password.
   */
  public final ConsumeAMQP removeCertAuthentication() {
    properties.remove(CERT_AUTHENTICATION_PROPERTY);
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
  public final ConsumeAMQP setSslClientAuth(final String sslClientAuth) {
    properties.put(SSL_CLIENT_AUTH_PROPERTY, sslClientAuth);
    return this;
  }

  /**
   * Client authentication policy when connecting to secure (TLS/SSL) AMQP broker. Possible values are REQUIRED, WANT, NONE. This property is only used when an SSL Context has been defined and enabled.
   */
  public final ConsumeAMQP removeSslClientAuth() {
    properties.remove(SSL_CLIENT_AUTH_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ConsumeAMQP setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ConsumeAMQP removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ConsumeAMQP, ConsumeAMQP> configurator) {
    return configurator.apply(new ConsumeAMQP()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConsumeAMQP.class) final Closure<ConsumeAMQP> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.amqp.processors.ConsumeAMQP> code = closure.rehydrate(c, com.tibtech.nifi.amqp.processors.ConsumeAMQP.class, com.tibtech.nifi.amqp.processors.ConsumeAMQP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ConsumeAMQP, ConsumeAMQP> configurator) {
    return configurator.apply(new ConsumeAMQP(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConsumeAMQP.class) final Closure<ConsumeAMQP> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.amqp.processors.ConsumeAMQP> code = closure.rehydrate(c, com.tibtech.nifi.amqp.processors.ConsumeAMQP.class, com.tibtech.nifi.amqp.processors.ConsumeAMQP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
