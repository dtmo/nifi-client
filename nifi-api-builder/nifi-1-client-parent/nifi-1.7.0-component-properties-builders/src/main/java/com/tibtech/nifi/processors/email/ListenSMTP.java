package com.tibtech.nifi.processors.email;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ListenSMTP {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.email.ListenSMTP";

  /**
   * The TCP port the ListenSMTP processor will bind to.NOTE that on Unix derivative operating  systems this port must be higher than 1024 unless NiFi is running as with root user permissions.
   */
  public static final String SMTP_PORT_PROPERTY = "SMTP_PORT";

  /**
   * The maximum number of simultaneous SMTP connections.
   */
  public static final String SMTP_MAXIMUM_CONNECTIONS_PROPERTY = "SMTP_MAXIMUM_CONNECTIONS";

  /**
   * The maximum time to wait for an action of SMTP client.
   */
  public static final String SMTP_TIMEOUT_PROPERTY = "SMTP_TIMEOUT";

  /**
   * The maximum number of bytes the server will accept.
   */
  public static final String SMTP_MAXIMUM_MSG_SIZE_PROPERTY = "SMTP_MAXIMUM_MSG_SIZE";

  /**
   * The Controller Service to use in order to obtain an SSL Context. If this property is set, messages will be received over a secure connection.
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL_CONTEXT_SERVICE";

  /**
   * The client authentication policy to use for the SSL Context. Only used if an SSL Context Service is provided.
   */
  public static final String CLIENT_AUTH_PROPERTY = "CLIENT_AUTH";

  /**
   * The hostname to be embedded into the banner displayed when an SMTP client connects to the processor TCP port .
   */
  public static final String SMTP_HOSTNAME_PROPERTY = "SMTP_HOSTNAME";

  private final Map<String, String> properties;

  public ListenSMTP() {
    this.properties = new HashMap<>();
  }

  public ListenSMTP(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The TCP port the ListenSMTP processor will bind to.NOTE that on Unix derivative operating  systems this port must be higher than 1024 unless NiFi is running as with root user permissions.
   */
  public final String getSmtpPort() {
    return properties.get(SMTP_PORT_PROPERTY);
  }

  /**
   * The TCP port the ListenSMTP processor will bind to.NOTE that on Unix derivative operating  systems this port must be higher than 1024 unless NiFi is running as with root user permissions.
   */
  public final ListenSMTP setSmtpPort(final String smtpPort) {
    properties.put(SMTP_PORT_PROPERTY, smtpPort);
    return this;
  }

  /**
   * The TCP port the ListenSMTP processor will bind to.NOTE that on Unix derivative operating  systems this port must be higher than 1024 unless NiFi is running as with root user permissions.
   */
  public final ListenSMTP removeSmtpPort() {
    properties.remove(SMTP_PORT_PROPERTY);
    return this;
  }

  /**
   * The maximum number of simultaneous SMTP connections.
   */
  public final String getSmtpMaximumConnections() {
    return properties.get(SMTP_MAXIMUM_CONNECTIONS_PROPERTY);
  }

  /**
   * The maximum number of simultaneous SMTP connections.
   */
  public final ListenSMTP setSmtpMaximumConnections(final String smtpMaximumConnections) {
    properties.put(SMTP_MAXIMUM_CONNECTIONS_PROPERTY, smtpMaximumConnections);
    return this;
  }

  /**
   * The maximum number of simultaneous SMTP connections.
   */
  public final ListenSMTP removeSmtpMaximumConnections() {
    properties.remove(SMTP_MAXIMUM_CONNECTIONS_PROPERTY);
    return this;
  }

  /**
   * The maximum time to wait for an action of SMTP client.
   */
  public final String getSmtpTimeout() {
    return properties.get(SMTP_TIMEOUT_PROPERTY);
  }

  /**
   * The maximum time to wait for an action of SMTP client.
   */
  public final ListenSMTP setSmtpTimeout(final String smtpTimeout) {
    properties.put(SMTP_TIMEOUT_PROPERTY, smtpTimeout);
    return this;
  }

  /**
   * The maximum time to wait for an action of SMTP client.
   */
  public final ListenSMTP removeSmtpTimeout() {
    properties.remove(SMTP_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The maximum number of bytes the server will accept.
   */
  public final String getSmtpMaximumMsgSize() {
    return properties.get(SMTP_MAXIMUM_MSG_SIZE_PROPERTY);
  }

  /**
   * The maximum number of bytes the server will accept.
   */
  public final ListenSMTP setSmtpMaximumMsgSize(final String smtpMaximumMsgSize) {
    properties.put(SMTP_MAXIMUM_MSG_SIZE_PROPERTY, smtpMaximumMsgSize);
    return this;
  }

  /**
   * The maximum number of bytes the server will accept.
   */
  public final ListenSMTP removeSmtpMaximumMsgSize() {
    properties.remove(SMTP_MAXIMUM_MSG_SIZE_PROPERTY);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context. If this property is set, messages will be received over a secure connection.
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context. If this property is set, messages will be received over a secure connection.
   */
  public final ListenSMTP setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context. If this property is set, messages will be received over a secure connection.
   */
  public final ListenSMTP removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The client authentication policy to use for the SSL Context. Only used if an SSL Context Service is provided.
   */
  public final String getClientAuth() {
    return properties.get(CLIENT_AUTH_PROPERTY);
  }

  /**
   * The client authentication policy to use for the SSL Context. Only used if an SSL Context Service is provided.
   */
  public final ListenSMTP setClientAuth(final String clientAuth) {
    properties.put(CLIENT_AUTH_PROPERTY, clientAuth);
    return this;
  }

  /**
   * The client authentication policy to use for the SSL Context. Only used if an SSL Context Service is provided.
   */
  public final ListenSMTP removeClientAuth() {
    properties.remove(CLIENT_AUTH_PROPERTY);
    return this;
  }

  /**
   * The hostname to be embedded into the banner displayed when an SMTP client connects to the processor TCP port .
   */
  public final String getSmtpHostname() {
    return properties.get(SMTP_HOSTNAME_PROPERTY);
  }

  /**
   * The hostname to be embedded into the banner displayed when an SMTP client connects to the processor TCP port .
   */
  public final ListenSMTP setSmtpHostname(final String smtpHostname) {
    properties.put(SMTP_HOSTNAME_PROPERTY, smtpHostname);
    return this;
  }

  /**
   * The hostname to be embedded into the banner displayed when an SMTP client connects to the processor TCP port .
   */
  public final ListenSMTP removeSmtpHostname() {
    properties.remove(SMTP_HOSTNAME_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ListenSMTP setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ListenSMTP removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ListenSMTP, ListenSMTP> configurator) {
    return configurator.apply(new ListenSMTP()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListenSMTP.class) final Closure<ListenSMTP> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.email.ListenSMTP> code = closure.rehydrate(c, com.tibtech.nifi.processors.email.ListenSMTP.class, com.tibtech.nifi.processors.email.ListenSMTP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ListenSMTP, ListenSMTP> configurator) {
    return configurator.apply(new ListenSMTP(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListenSMTP.class) final Closure<ListenSMTP> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.email.ListenSMTP> code = closure.rehydrate(c, com.tibtech.nifi.processors.email.ListenSMTP.class, com.tibtech.nifi.processors.email.ListenSMTP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
