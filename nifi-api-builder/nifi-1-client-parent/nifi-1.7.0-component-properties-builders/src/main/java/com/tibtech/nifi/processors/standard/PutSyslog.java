package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutSyslog {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.PutSyslog";

  /**
   * The ip address or hostname of the Syslog server. Note that Expression language is not evaluated per FlowFile.
   */
  public static final String HOSTNAME_PROPERTY = "Hostname";

  /**
   * The protocol for Syslog communication.
   */
  public static final String PROTOCOL_PROPERTY = "Protocol";

  /**
   * The port for Syslog communication. Note that Expression language is not evaluated per FlowFile.
   */
  public static final String PORT_PROPERTY = "Port";

  /**
   * The maximum size of the socket send buffer that should be used. This is a suggestion to the Operating System to indicate how big the socket buffer should be. If this value is set too low, the buffer may fill up before the data can be read, and incoming data will be dropped. Note that Expression language is not evaluated per FlowFile.
   */
  public static final String MAX_SIZE_OF_SOCKET_SEND_BUFFER_PROPERTY = "Max Size of Socket Send Buffer";

  /**
   * The Controller Service to use in order to obtain an SSL Context. If this property is set, syslog messages will be sent over a secure connection.
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  /**
   * The amount of time a connection should be held open without being used before closing the connection. Note that Expression language is not evaluated per FlowFile.
   */
  public static final String IDLE_CONNECTION_EXPIRATION_PROPERTY = "Idle Connection Expiration";

  /**
   * The timeout for connecting to and communicating with the syslog server. Does not apply to UDP. Note that Expression language is not evaluated per FlowFile.
   */
  public static final String TIMEOUT_PROPERTY = "Timeout";

  /**
   * The number of incoming FlowFiles to process in a single execution of this processor. Note that Expression language is not evaluated per FlowFile.
   */
  public static final String BATCH_SIZE_PROPERTY = "Batch Size";

  /**
   * Specifies the character set of the Syslog messages. Note that Expression language is not evaluated per FlowFile.
   */
  public static final String CHARACTER_SET_PROPERTY = "Character Set";

  /**
   * The priority for the Syslog messages, excluding < >.
   */
  public static final String MESSAGE_PRIORITY_PROPERTY = "Message Priority";

  /**
   * The version for the Syslog messages.
   */
  public static final String MESSAGE_VERSION_PROPERTY = "Message Version";

  /**
   * The timestamp for the Syslog messages. The timestamp can be an RFC5424 timestamp with a format of "yyyy-MM-dd'T'HH:mm:ss.SZ" or "yyyy-MM-dd'T'HH:mm:ss.S+hh:mm", " or it can be an RFC3164 timestamp with a format of "MMM d HH:mm:ss".
   */
  public static final String MESSAGE_TIMESTAMP_PROPERTY = "Message Timestamp";

  /**
   * The hostname for the Syslog messages.
   */
  public static final String MESSAGE_HOSTNAME_PROPERTY = "Message Hostname";

  /**
   * The body for the Syslog messages.
   */
  public static final String MESSAGE_BODY_PROPERTY = "Message Body";

  private final Map<String, String> properties;

  public PutSyslog() {
    this.properties = new HashMap<>();
  }

  public PutSyslog(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The ip address or hostname of the Syslog server. Note that Expression language is not evaluated per FlowFile.
   */
  public final String getHostname() {
    return properties.get(HOSTNAME_PROPERTY);
  }

  /**
   * The ip address or hostname of the Syslog server. Note that Expression language is not evaluated per FlowFile.
   */
  public final PutSyslog setHostname(final String hostname) {
    properties.put(HOSTNAME_PROPERTY, hostname);
    return this;
  }

  /**
   * The ip address or hostname of the Syslog server. Note that Expression language is not evaluated per FlowFile.
   */
  public final PutSyslog removeHostname() {
    properties.remove(HOSTNAME_PROPERTY);
    return this;
  }

  /**
   * The protocol for Syslog communication.
   */
  public final String getProtocol() {
    return properties.get(PROTOCOL_PROPERTY);
  }

  /**
   * The protocol for Syslog communication.
   */
  public final PutSyslog setProtocol(final String protocol) {
    properties.put(PROTOCOL_PROPERTY, protocol);
    return this;
  }

  /**
   * The protocol for Syslog communication.
   */
  public final PutSyslog removeProtocol() {
    properties.remove(PROTOCOL_PROPERTY);
    return this;
  }

  /**
   * The port for Syslog communication. Note that Expression language is not evaluated per FlowFile.
   */
  public final String getPort() {
    return properties.get(PORT_PROPERTY);
  }

  /**
   * The port for Syslog communication. Note that Expression language is not evaluated per FlowFile.
   */
  public final PutSyslog setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * The port for Syslog communication. Note that Expression language is not evaluated per FlowFile.
   */
  public final PutSyslog removePort() {
    properties.remove(PORT_PROPERTY);
    return this;
  }

  /**
   * The maximum size of the socket send buffer that should be used. This is a suggestion to the Operating System to indicate how big the socket buffer should be. If this value is set too low, the buffer may fill up before the data can be read, and incoming data will be dropped. Note that Expression language is not evaluated per FlowFile.
   */
  public final String getMaxSizeOfSocketSendBuffer() {
    return properties.get(MAX_SIZE_OF_SOCKET_SEND_BUFFER_PROPERTY);
  }

  /**
   * The maximum size of the socket send buffer that should be used. This is a suggestion to the Operating System to indicate how big the socket buffer should be. If this value is set too low, the buffer may fill up before the data can be read, and incoming data will be dropped. Note that Expression language is not evaluated per FlowFile.
   */
  public final PutSyslog setMaxSizeOfSocketSendBuffer(final String maxSizeOfSocketSendBuffer) {
    properties.put(MAX_SIZE_OF_SOCKET_SEND_BUFFER_PROPERTY, maxSizeOfSocketSendBuffer);
    return this;
  }

  /**
   * The maximum size of the socket send buffer that should be used. This is a suggestion to the Operating System to indicate how big the socket buffer should be. If this value is set too low, the buffer may fill up before the data can be read, and incoming data will be dropped. Note that Expression language is not evaluated per FlowFile.
   */
  public final PutSyslog removeMaxSizeOfSocketSendBuffer() {
    properties.remove(MAX_SIZE_OF_SOCKET_SEND_BUFFER_PROPERTY);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context. If this property is set, syslog messages will be sent over a secure connection.
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context. If this property is set, syslog messages will be sent over a secure connection.
   */
  public final PutSyslog setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context. If this property is set, syslog messages will be sent over a secure connection.
   */
  public final PutSyslog removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The amount of time a connection should be held open without being used before closing the connection. Note that Expression language is not evaluated per FlowFile.
   */
  public final String getIdleConnectionExpiration() {
    return properties.get(IDLE_CONNECTION_EXPIRATION_PROPERTY);
  }

  /**
   * The amount of time a connection should be held open without being used before closing the connection. Note that Expression language is not evaluated per FlowFile.
   */
  public final PutSyslog setIdleConnectionExpiration(final String idleConnectionExpiration) {
    properties.put(IDLE_CONNECTION_EXPIRATION_PROPERTY, idleConnectionExpiration);
    return this;
  }

  /**
   * The amount of time a connection should be held open without being used before closing the connection. Note that Expression language is not evaluated per FlowFile.
   */
  public final PutSyslog removeIdleConnectionExpiration() {
    properties.remove(IDLE_CONNECTION_EXPIRATION_PROPERTY);
    return this;
  }

  /**
   * The timeout for connecting to and communicating with the syslog server. Does not apply to UDP. Note that Expression language is not evaluated per FlowFile.
   */
  public final String getTimeout() {
    return properties.get(TIMEOUT_PROPERTY);
  }

  /**
   * The timeout for connecting to and communicating with the syslog server. Does not apply to UDP. Note that Expression language is not evaluated per FlowFile.
   */
  public final PutSyslog setTimeout(final String timeout) {
    properties.put(TIMEOUT_PROPERTY, timeout);
    return this;
  }

  /**
   * The timeout for connecting to and communicating with the syslog server. Does not apply to UDP. Note that Expression language is not evaluated per FlowFile.
   */
  public final PutSyslog removeTimeout() {
    properties.remove(TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The number of incoming FlowFiles to process in a single execution of this processor. Note that Expression language is not evaluated per FlowFile.
   */
  public final String getBatchSize() {
    return properties.get(BATCH_SIZE_PROPERTY);
  }

  /**
   * The number of incoming FlowFiles to process in a single execution of this processor. Note that Expression language is not evaluated per FlowFile.
   */
  public final PutSyslog setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * The number of incoming FlowFiles to process in a single execution of this processor. Note that Expression language is not evaluated per FlowFile.
   */
  public final PutSyslog removeBatchSize() {
    properties.remove(BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * Specifies the character set of the Syslog messages. Note that Expression language is not evaluated per FlowFile.
   */
  public final String getCharacterSet() {
    return properties.get(CHARACTER_SET_PROPERTY);
  }

  /**
   * Specifies the character set of the Syslog messages. Note that Expression language is not evaluated per FlowFile.
   */
  public final PutSyslog setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * Specifies the character set of the Syslog messages. Note that Expression language is not evaluated per FlowFile.
   */
  public final PutSyslog removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
    return this;
  }

  /**
   * The priority for the Syslog messages, excluding < >.
   */
  public final String getMessagePriority() {
    return properties.get(MESSAGE_PRIORITY_PROPERTY);
  }

  /**
   * The priority for the Syslog messages, excluding < >.
   */
  public final PutSyslog setMessagePriority(final String messagePriority) {
    properties.put(MESSAGE_PRIORITY_PROPERTY, messagePriority);
    return this;
  }

  /**
   * The priority for the Syslog messages, excluding < >.
   */
  public final PutSyslog removeMessagePriority() {
    properties.remove(MESSAGE_PRIORITY_PROPERTY);
    return this;
  }

  /**
   * The version for the Syslog messages.
   */
  public final String getMessageVersion() {
    return properties.get(MESSAGE_VERSION_PROPERTY);
  }

  /**
   * The version for the Syslog messages.
   */
  public final PutSyslog setMessageVersion(final String messageVersion) {
    properties.put(MESSAGE_VERSION_PROPERTY, messageVersion);
    return this;
  }

  /**
   * The version for the Syslog messages.
   */
  public final PutSyslog removeMessageVersion() {
    properties.remove(MESSAGE_VERSION_PROPERTY);
    return this;
  }

  /**
   * The timestamp for the Syslog messages. The timestamp can be an RFC5424 timestamp with a format of "yyyy-MM-dd'T'HH:mm:ss.SZ" or "yyyy-MM-dd'T'HH:mm:ss.S+hh:mm", " or it can be an RFC3164 timestamp with a format of "MMM d HH:mm:ss".
   */
  public final String getMessageTimestamp() {
    return properties.get(MESSAGE_TIMESTAMP_PROPERTY);
  }

  /**
   * The timestamp for the Syslog messages. The timestamp can be an RFC5424 timestamp with a format of "yyyy-MM-dd'T'HH:mm:ss.SZ" or "yyyy-MM-dd'T'HH:mm:ss.S+hh:mm", " or it can be an RFC3164 timestamp with a format of "MMM d HH:mm:ss".
   */
  public final PutSyslog setMessageTimestamp(final String messageTimestamp) {
    properties.put(MESSAGE_TIMESTAMP_PROPERTY, messageTimestamp);
    return this;
  }

  /**
   * The timestamp for the Syslog messages. The timestamp can be an RFC5424 timestamp with a format of "yyyy-MM-dd'T'HH:mm:ss.SZ" or "yyyy-MM-dd'T'HH:mm:ss.S+hh:mm", " or it can be an RFC3164 timestamp with a format of "MMM d HH:mm:ss".
   */
  public final PutSyslog removeMessageTimestamp() {
    properties.remove(MESSAGE_TIMESTAMP_PROPERTY);
    return this;
  }

  /**
   * The hostname for the Syslog messages.
   */
  public final String getMessageHostname() {
    return properties.get(MESSAGE_HOSTNAME_PROPERTY);
  }

  /**
   * The hostname for the Syslog messages.
   */
  public final PutSyslog setMessageHostname(final String messageHostname) {
    properties.put(MESSAGE_HOSTNAME_PROPERTY, messageHostname);
    return this;
  }

  /**
   * The hostname for the Syslog messages.
   */
  public final PutSyslog removeMessageHostname() {
    properties.remove(MESSAGE_HOSTNAME_PROPERTY);
    return this;
  }

  /**
   * The body for the Syslog messages.
   */
  public final String getMessageBody() {
    return properties.get(MESSAGE_BODY_PROPERTY);
  }

  /**
   * The body for the Syslog messages.
   */
  public final PutSyslog setMessageBody(final String messageBody) {
    properties.put(MESSAGE_BODY_PROPERTY, messageBody);
    return this;
  }

  /**
   * The body for the Syslog messages.
   */
  public final PutSyslog removeMessageBody() {
    properties.remove(MESSAGE_BODY_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutSyslog setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutSyslog removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutSyslog, PutSyslog> configurator) {
    return configurator.apply(new PutSyslog()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutSyslog.class) final Closure<PutSyslog> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.PutSyslog> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.PutSyslog.class, com.tibtech.nifi.processors.standard.PutSyslog.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutSyslog, PutSyslog> configurator) {
    return configurator.apply(new PutSyslog(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutSyslog.class) final Closure<PutSyslog> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.PutSyslog> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.PutSyslog.class, com.tibtech.nifi.processors.standard.PutSyslog.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
