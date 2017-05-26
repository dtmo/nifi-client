package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutTCP {
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
   * Specifies whether to send each FlowFile's content on an individual connection.
   */
  public static final String CONNECTION_PER_FLOW_FILE_PROPERTY = "Connection Per FlowFile";

  /**
   * Specifies the delimiter to use when sending messages out over the same TCP stream. The delimiter is appended to each FlowFile message that is transmitted over the stream so that the receiver can determine when one message ends and the next message begins. Users should ensure that the FlowFile content does not contain the delimiter character to avoid errors. In order to use a new line character you can enter '\n'. For a tab character use '\t'. Finally for a carriage return use '\r'.
   */
  public static final String OUTGOING_MESSAGE_DELIMITER_PROPERTY = "Outgoing Message Delimiter";

  /**
   * The timeout for connecting to and communicating with the destination. Does not apply to UDP
   */
  public static final String TIMEOUT_PROPERTY = "Timeout";

  /**
   * The Controller Service to use in order to obtain an SSL Context. If this property is set, messages will be sent over a secure connection.
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  /**
   * Specifies the character set of the data being sent.
   */
  public static final String CHARACTER_SET_PROPERTY = "Character Set";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The ip address or hostname of the destination.
   */
  public final String getHostname() {
    return properties.get(HOSTNAME_PROPERTY);
  }

  /**
   * The ip address or hostname of the destination.
   */
  public final PutTCP setHostname(final String hostname) {
    properties.put(HOSTNAME_PROPERTY, hostname);
    return this;
  }

  /**
   * The ip address or hostname of the destination.
   */
  public final PutTCP removeHostname() {
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
  public final PutTCP setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * The port on the destination.
   */
  public final PutTCP removePort() {
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
  public final PutTCP setMaxSizeOfSocketSendBuffer(final String maxSizeOfSocketSendBuffer) {
    properties.put(MAX_SIZE_OF_SOCKET_SEND_BUFFER_PROPERTY, maxSizeOfSocketSendBuffer);
    return this;
  }

  /**
   * The maximum size of the socket send buffer that should be used. This is a suggestion to the Operating System to indicate how big the socket buffer should be. If this value is set too low, the buffer may fill up before the data can be read, and incoming data will be dropped.
   */
  public final PutTCP removeMaxSizeOfSocketSendBuffer() {
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
  public final PutTCP setIdleConnectionExpiration(final String idleConnectionExpiration) {
    properties.put(IDLE_CONNECTION_EXPIRATION_PROPERTY, idleConnectionExpiration);
    return this;
  }

  /**
   * The amount of time a connection should be held open without being used before closing the connection.
   */
  public final PutTCP removeIdleConnectionExpiration() {
    properties.remove(IDLE_CONNECTION_EXPIRATION_PROPERTY);
    return this;
  }

  /**
   * Specifies whether to send each FlowFile's content on an individual connection.
   */
  public final String getConnectionPerFlowFile() {
    return properties.get(CONNECTION_PER_FLOW_FILE_PROPERTY);
  }

  /**
   * Specifies whether to send each FlowFile's content on an individual connection.
   */
  public final PutTCP setConnectionPerFlowFile(final String connectionPerFlowFile) {
    properties.put(CONNECTION_PER_FLOW_FILE_PROPERTY, connectionPerFlowFile);
    return this;
  }

  /**
   * Specifies whether to send each FlowFile's content on an individual connection.
   */
  public final PutTCP removeConnectionPerFlowFile() {
    properties.remove(CONNECTION_PER_FLOW_FILE_PROPERTY);
    return this;
  }

  /**
   * Specifies the delimiter to use when sending messages out over the same TCP stream. The delimiter is appended to each FlowFile message that is transmitted over the stream so that the receiver can determine when one message ends and the next message begins. Users should ensure that the FlowFile content does not contain the delimiter character to avoid errors. In order to use a new line character you can enter '\n'. For a tab character use '\t'. Finally for a carriage return use '\r'.
   */
  public final String getOutgoingMessageDelimiter() {
    return properties.get(OUTGOING_MESSAGE_DELIMITER_PROPERTY);
  }

  /**
   * Specifies the delimiter to use when sending messages out over the same TCP stream. The delimiter is appended to each FlowFile message that is transmitted over the stream so that the receiver can determine when one message ends and the next message begins. Users should ensure that the FlowFile content does not contain the delimiter character to avoid errors. In order to use a new line character you can enter '\n'. For a tab character use '\t'. Finally for a carriage return use '\r'.
   */
  public final PutTCP setOutgoingMessageDelimiter(final String outgoingMessageDelimiter) {
    properties.put(OUTGOING_MESSAGE_DELIMITER_PROPERTY, outgoingMessageDelimiter);
    return this;
  }

  /**
   * Specifies the delimiter to use when sending messages out over the same TCP stream. The delimiter is appended to each FlowFile message that is transmitted over the stream so that the receiver can determine when one message ends and the next message begins. Users should ensure that the FlowFile content does not contain the delimiter character to avoid errors. In order to use a new line character you can enter '\n'. For a tab character use '\t'. Finally for a carriage return use '\r'.
   */
  public final PutTCP removeOutgoingMessageDelimiter() {
    properties.remove(OUTGOING_MESSAGE_DELIMITER_PROPERTY);
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
  public final PutTCP setTimeout(final String timeout) {
    properties.put(TIMEOUT_PROPERTY, timeout);
    return this;
  }

  /**
   * The timeout for connecting to and communicating with the destination. Does not apply to UDP
   */
  public final PutTCP removeTimeout() {
    properties.remove(TIMEOUT_PROPERTY);
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
  public final PutTCP setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context. If this property is set, messages will be sent over a secure connection.
   */
  public final PutTCP removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
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
  public final PutTCP setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * Specifies the character set of the data being sent.
   */
  public final PutTCP removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutTCP setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutTCP removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutTCP, PutTCP> configurator) {
    return configurator.apply(new PutTCP()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutTCP.class) final Closure<PutTCP> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.PutTCP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.PutTCP.class, com.tibtech.nifi.processors.standard.PutTCP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
