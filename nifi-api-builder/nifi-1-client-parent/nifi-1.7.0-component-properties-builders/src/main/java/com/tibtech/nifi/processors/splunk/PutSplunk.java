package com.tibtech.nifi.processors.splunk;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutSplunk {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.splunk.PutSplunk";

  /**
   * The ip address or hostname of the destination.
   */
  public static final String HOSTNAME_PROPERTY = "Hostname";

  /**
   * The port on the destination.
   */
  public static final String PORT_PROPERTY = "Port";

  /**
   * The maximum size of the socket send buffer that should be used. This is a suggestion to the Operating System to indicate how big the socket buffer should be. If this value is set too low, the buffer may fill up before the data can be read, and incoming data will be dropped.
   */
  public static final String MAX_SIZE_OF_SOCKET_SEND_BUFFER_PROPERTY = "Max Size of Socket Send Buffer";

  /**
   * The amount of time a connection should be held open without being used before closing the connection.
   */
  public static final String IDLE_CONNECTION_EXPIRATION_PROPERTY = "Idle Connection Expiration";

  /**
   * The timeout for connecting to and communicating with the destination. Does not apply to UDP
   */
  public static final String TIMEOUT_PROPERTY = "Timeout";

  /**
   * Specifies the character set of the data being sent.
   */
  public static final String CHARACTER_SET_PROPERTY = "Character Set";

  /**
   * The protocol for communication.
   */
  public static final String PROTOCOL_PROPERTY = "Protocol";

  /**
   * Specifies the delimiter to use for splitting apart multiple messages within a single FlowFile. If not specified, the entire content of the FlowFile will be used as a single message. If specified, the contents of the FlowFile will be split on this delimiter and each section sent as a separate message. Note that if messages are delimited and some messages for a given FlowFile are transferred successfully while others are not, the messages will be split into individual FlowFiles, such that those messages that were successfully sent are routed to the 'success' relationship while other messages are sent to the 'failure' relationship.
   */
  public static final String MESSAGE_DELIMITER_PROPERTY = "Message Delimiter";

  /**
   * The Controller Service to use in order to obtain an SSL Context. If this property is set, messages will be sent over a secure connection.
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  private final Map<String, String> properties;

  public PutSplunk() {
    this.properties = new HashMap<>();
  }

  public PutSplunk(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The ip address or hostname of the destination.
   */
  public final String getHostname() {
    return properties.get(HOSTNAME_PROPERTY);
  }

  /**
   * The ip address or hostname of the destination.
   */
  public final PutSplunk setHostname(final String hostname) {
    properties.put(HOSTNAME_PROPERTY, hostname);
    return this;
  }

  /**
   * The ip address or hostname of the destination.
   */
  public final PutSplunk removeHostname() {
    properties.remove(HOSTNAME_PROPERTY);
    return this;
  }

  /**
   * The port on the destination.
   */
  public final String getPort() {
    return properties.get(PORT_PROPERTY);
  }

  /**
   * The port on the destination.
   */
  public final PutSplunk setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * The port on the destination.
   */
  public final PutSplunk removePort() {
    properties.remove(PORT_PROPERTY);
    return this;
  }

  /**
   * The maximum size of the socket send buffer that should be used. This is a suggestion to the Operating System to indicate how big the socket buffer should be. If this value is set too low, the buffer may fill up before the data can be read, and incoming data will be dropped.
   */
  public final String getMaxSizeOfSocketSendBuffer() {
    return properties.get(MAX_SIZE_OF_SOCKET_SEND_BUFFER_PROPERTY);
  }

  /**
   * The maximum size of the socket send buffer that should be used. This is a suggestion to the Operating System to indicate how big the socket buffer should be. If this value is set too low, the buffer may fill up before the data can be read, and incoming data will be dropped.
   */
  public final PutSplunk setMaxSizeOfSocketSendBuffer(final String maxSizeOfSocketSendBuffer) {
    properties.put(MAX_SIZE_OF_SOCKET_SEND_BUFFER_PROPERTY, maxSizeOfSocketSendBuffer);
    return this;
  }

  /**
   * The maximum size of the socket send buffer that should be used. This is a suggestion to the Operating System to indicate how big the socket buffer should be. If this value is set too low, the buffer may fill up before the data can be read, and incoming data will be dropped.
   */
  public final PutSplunk removeMaxSizeOfSocketSendBuffer() {
    properties.remove(MAX_SIZE_OF_SOCKET_SEND_BUFFER_PROPERTY);
    return this;
  }

  /**
   * The amount of time a connection should be held open without being used before closing the connection.
   */
  public final String getIdleConnectionExpiration() {
    return properties.get(IDLE_CONNECTION_EXPIRATION_PROPERTY);
  }

  /**
   * The amount of time a connection should be held open without being used before closing the connection.
   */
  public final PutSplunk setIdleConnectionExpiration(final String idleConnectionExpiration) {
    properties.put(IDLE_CONNECTION_EXPIRATION_PROPERTY, idleConnectionExpiration);
    return this;
  }

  /**
   * The amount of time a connection should be held open without being used before closing the connection.
   */
  public final PutSplunk removeIdleConnectionExpiration() {
    properties.remove(IDLE_CONNECTION_EXPIRATION_PROPERTY);
    return this;
  }

  /**
   * The timeout for connecting to and communicating with the destination. Does not apply to UDP
   */
  public final String getTimeout() {
    return properties.get(TIMEOUT_PROPERTY);
  }

  /**
   * The timeout for connecting to and communicating with the destination. Does not apply to UDP
   */
  public final PutSplunk setTimeout(final String timeout) {
    properties.put(TIMEOUT_PROPERTY, timeout);
    return this;
  }

  /**
   * The timeout for connecting to and communicating with the destination. Does not apply to UDP
   */
  public final PutSplunk removeTimeout() {
    properties.remove(TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * Specifies the character set of the data being sent.
   */
  public final String getCharacterSet() {
    return properties.get(CHARACTER_SET_PROPERTY);
  }

  /**
   * Specifies the character set of the data being sent.
   */
  public final PutSplunk setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * Specifies the character set of the data being sent.
   */
  public final PutSplunk removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
    return this;
  }

  /**
   * The protocol for communication.
   */
  public final String getProtocol() {
    return properties.get(PROTOCOL_PROPERTY);
  }

  /**
   * The protocol for communication.
   */
  public final PutSplunk setProtocol(final String protocol) {
    properties.put(PROTOCOL_PROPERTY, protocol);
    return this;
  }

  /**
   * The protocol for communication.
   */
  public final PutSplunk removeProtocol() {
    properties.remove(PROTOCOL_PROPERTY);
    return this;
  }

  /**
   * Specifies the delimiter to use for splitting apart multiple messages within a single FlowFile. If not specified, the entire content of the FlowFile will be used as a single message. If specified, the contents of the FlowFile will be split on this delimiter and each section sent as a separate message. Note that if messages are delimited and some messages for a given FlowFile are transferred successfully while others are not, the messages will be split into individual FlowFiles, such that those messages that were successfully sent are routed to the 'success' relationship while other messages are sent to the 'failure' relationship.
   */
  public final String getMessageDelimiter() {
    return properties.get(MESSAGE_DELIMITER_PROPERTY);
  }

  /**
   * Specifies the delimiter to use for splitting apart multiple messages within a single FlowFile. If not specified, the entire content of the FlowFile will be used as a single message. If specified, the contents of the FlowFile will be split on this delimiter and each section sent as a separate message. Note that if messages are delimited and some messages for a given FlowFile are transferred successfully while others are not, the messages will be split into individual FlowFiles, such that those messages that were successfully sent are routed to the 'success' relationship while other messages are sent to the 'failure' relationship.
   */
  public final PutSplunk setMessageDelimiter(final String messageDelimiter) {
    properties.put(MESSAGE_DELIMITER_PROPERTY, messageDelimiter);
    return this;
  }

  /**
   * Specifies the delimiter to use for splitting apart multiple messages within a single FlowFile. If not specified, the entire content of the FlowFile will be used as a single message. If specified, the contents of the FlowFile will be split on this delimiter and each section sent as a separate message. Note that if messages are delimited and some messages for a given FlowFile are transferred successfully while others are not, the messages will be split into individual FlowFiles, such that those messages that were successfully sent are routed to the 'success' relationship while other messages are sent to the 'failure' relationship.
   */
  public final PutSplunk removeMessageDelimiter() {
    properties.remove(MESSAGE_DELIMITER_PROPERTY);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context. If this property is set, messages will be sent over a secure connection.
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context. If this property is set, messages will be sent over a secure connection.
   */
  public final PutSplunk setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context. If this property is set, messages will be sent over a secure connection.
   */
  public final PutSplunk removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutSplunk setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutSplunk removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutSplunk, PutSplunk> configurator) {
    return configurator.apply(new PutSplunk()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutSplunk.class) final Closure<PutSplunk> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.splunk.PutSplunk> code = closure.rehydrate(c, com.tibtech.nifi.processors.splunk.PutSplunk.class, com.tibtech.nifi.processors.splunk.PutSplunk.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutSplunk, PutSplunk> configurator) {
    return configurator.apply(new PutSplunk(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutSplunk.class) final Closure<PutSplunk> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.splunk.PutSplunk> code = closure.rehydrate(c, com.tibtech.nifi.processors.splunk.PutSplunk.class, com.tibtech.nifi.processors.splunk.PutSplunk.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
