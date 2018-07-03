package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ListenSyslog {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ListenSyslog";

  /**
   * The protocol for Syslog communication.
   */
  public static final String PROTOCOL_PROPERTY = "Protocol";

  /**
   * The port for Syslog communication. Note that Expression language is not evaluated per FlowFile.
   */
  public static final String PORT_PROPERTY = "Port";

  /**
   * The name of a local network interface to be used to restrict listening to a specific LAN.
   */
  public static final String LOCAL_NETWORK_INTERFACE_PROPERTY = "Local Network Interface";

  /**
   * The Controller Service to use in order to obtain an SSL Context. If this property is set, syslog messages will be received over a secure connection.
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  /**
   * The client authentication policy to use for the SSL Context. Only used if an SSL Context Service is provided.
   */
  public static final String CLIENT_AUTH_PROPERTY = "Client Auth";

  /**
   * The size of each buffer used to receive Syslog messages. Adjust this value appropriately based on the expected size of the incoming Syslog messages. When UDP is selected each buffer will hold one Syslog message. When TCP is selected messages are read from an incoming connection until the buffer is full, or the connection is closed. 
   */
  public static final String RECEIVE_BUFFER_SIZE_PROPERTY = "Receive Buffer Size";

  /**
   * The maximum size of the internal queue used to buffer messages being transferred from the underlying channel to the processor. Setting this value higher allows more messages to be buffered in memory during surges of incoming messages, but increases the total memory used by the processor.
   */
  public static final String MAX_SIZE_OF_MESSAGE_QUEUE_PROPERTY = "Max Size of Message Queue";

  /**
   * The maximum size of the socket buffer that should be used. This is a suggestion to the Operating System to indicate how big the socket buffer should be. If this value is set too low, the buffer may fill up before the data can be read, and incoming data will be dropped.
   */
  public static final String MAX_SIZE_OF_SOCKET_BUFFER_PROPERTY = "Max Size of Socket Buffer";

  /**
   * The maximum number of concurrent connections to accept Syslog messages in TCP mode.
   */
  public static final String MAX_NUMBER_OF_TCP_CONNECTIONS_PROPERTY = "Max Number of TCP Connections";

  /**
   * The maximum number of Syslog events to add to a single FlowFile. If multiple events are available, they will be concatenated along with the <Message Delimiter> up to this configured maximum number of messages
   */
  public static final String MAX_BATCH_SIZE_PROPERTY = "Max Batch Size";

  /**
   * Specifies the delimiter to place between Syslog messages when multiple messages are bundled together (see <Max Batch Size> property).
   */
  public static final String MESSAGE_DELIMITER_PROPERTY = "Message Delimiter";

  /**
   * Indicates if the processor should parse the Syslog messages. If set to false, each outgoing FlowFile will only contain the sender, protocol, and port, and no additional attributes.
   */
  public static final String PARSE_MESSAGES_PROPERTY = "Parse Messages";

  /**
   * Specifies the character set of the Syslog messages. Note that Expression language is not evaluated per FlowFile.
   */
  public static final String CHARACTER_SET_PROPERTY = "Character Set";

  private final Map<String, String> properties;

  public ListenSyslog() {
    this.properties = new HashMap<>();
  }

  public ListenSyslog(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
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
  public final ListenSyslog setProtocol(final String protocol) {
    properties.put(PROTOCOL_PROPERTY, protocol);
    return this;
  }

  /**
   * The protocol for Syslog communication.
   */
  public final ListenSyslog removeProtocol() {
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
  public final ListenSyslog setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * The port for Syslog communication. Note that Expression language is not evaluated per FlowFile.
   */
  public final ListenSyslog removePort() {
    properties.remove(PORT_PROPERTY);
    return this;
  }

  /**
   * The name of a local network interface to be used to restrict listening to a specific LAN.
   */
  public final String getLocalNetworkInterface() {
    return properties.get(LOCAL_NETWORK_INTERFACE_PROPERTY);
  }

  /**
   * The name of a local network interface to be used to restrict listening to a specific LAN.
   */
  public final ListenSyslog setLocalNetworkInterface(final String localNetworkInterface) {
    properties.put(LOCAL_NETWORK_INTERFACE_PROPERTY, localNetworkInterface);
    return this;
  }

  /**
   * The name of a local network interface to be used to restrict listening to a specific LAN.
   */
  public final ListenSyslog removeLocalNetworkInterface() {
    properties.remove(LOCAL_NETWORK_INTERFACE_PROPERTY);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context. If this property is set, syslog messages will be received over a secure connection.
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context. If this property is set, syslog messages will be received over a secure connection.
   */
  public final ListenSyslog setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context. If this property is set, syslog messages will be received over a secure connection.
   */
  public final ListenSyslog removeSslContextService() {
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
  public final ListenSyslog setClientAuth(final String clientAuth) {
    properties.put(CLIENT_AUTH_PROPERTY, clientAuth);
    return this;
  }

  /**
   * The client authentication policy to use for the SSL Context. Only used if an SSL Context Service is provided.
   */
  public final ListenSyslog removeClientAuth() {
    properties.remove(CLIENT_AUTH_PROPERTY);
    return this;
  }

  /**
   * The size of each buffer used to receive Syslog messages. Adjust this value appropriately based on the expected size of the incoming Syslog messages. When UDP is selected each buffer will hold one Syslog message. When TCP is selected messages are read from an incoming connection until the buffer is full, or the connection is closed. 
   */
  public final String getReceiveBufferSize() {
    return properties.get(RECEIVE_BUFFER_SIZE_PROPERTY);
  }

  /**
   * The size of each buffer used to receive Syslog messages. Adjust this value appropriately based on the expected size of the incoming Syslog messages. When UDP is selected each buffer will hold one Syslog message. When TCP is selected messages are read from an incoming connection until the buffer is full, or the connection is closed. 
   */
  public final ListenSyslog setReceiveBufferSize(final String receiveBufferSize) {
    properties.put(RECEIVE_BUFFER_SIZE_PROPERTY, receiveBufferSize);
    return this;
  }

  /**
   * The size of each buffer used to receive Syslog messages. Adjust this value appropriately based on the expected size of the incoming Syslog messages. When UDP is selected each buffer will hold one Syslog message. When TCP is selected messages are read from an incoming connection until the buffer is full, or the connection is closed. 
   */
  public final ListenSyslog removeReceiveBufferSize() {
    properties.remove(RECEIVE_BUFFER_SIZE_PROPERTY);
    return this;
  }

  /**
   * The maximum size of the internal queue used to buffer messages being transferred from the underlying channel to the processor. Setting this value higher allows more messages to be buffered in memory during surges of incoming messages, but increases the total memory used by the processor.
   */
  public final String getMaxSizeOfMessageQueue() {
    return properties.get(MAX_SIZE_OF_MESSAGE_QUEUE_PROPERTY);
  }

  /**
   * The maximum size of the internal queue used to buffer messages being transferred from the underlying channel to the processor. Setting this value higher allows more messages to be buffered in memory during surges of incoming messages, but increases the total memory used by the processor.
   */
  public final ListenSyslog setMaxSizeOfMessageQueue(final String maxSizeOfMessageQueue) {
    properties.put(MAX_SIZE_OF_MESSAGE_QUEUE_PROPERTY, maxSizeOfMessageQueue);
    return this;
  }

  /**
   * The maximum size of the internal queue used to buffer messages being transferred from the underlying channel to the processor. Setting this value higher allows more messages to be buffered in memory during surges of incoming messages, but increases the total memory used by the processor.
   */
  public final ListenSyslog removeMaxSizeOfMessageQueue() {
    properties.remove(MAX_SIZE_OF_MESSAGE_QUEUE_PROPERTY);
    return this;
  }

  /**
   * The maximum size of the socket buffer that should be used. This is a suggestion to the Operating System to indicate how big the socket buffer should be. If this value is set too low, the buffer may fill up before the data can be read, and incoming data will be dropped.
   */
  public final String getMaxSizeOfSocketBuffer() {
    return properties.get(MAX_SIZE_OF_SOCKET_BUFFER_PROPERTY);
  }

  /**
   * The maximum size of the socket buffer that should be used. This is a suggestion to the Operating System to indicate how big the socket buffer should be. If this value is set too low, the buffer may fill up before the data can be read, and incoming data will be dropped.
   */
  public final ListenSyslog setMaxSizeOfSocketBuffer(final String maxSizeOfSocketBuffer) {
    properties.put(MAX_SIZE_OF_SOCKET_BUFFER_PROPERTY, maxSizeOfSocketBuffer);
    return this;
  }

  /**
   * The maximum size of the socket buffer that should be used. This is a suggestion to the Operating System to indicate how big the socket buffer should be. If this value is set too low, the buffer may fill up before the data can be read, and incoming data will be dropped.
   */
  public final ListenSyslog removeMaxSizeOfSocketBuffer() {
    properties.remove(MAX_SIZE_OF_SOCKET_BUFFER_PROPERTY);
    return this;
  }

  /**
   * The maximum number of concurrent connections to accept Syslog messages in TCP mode.
   */
  public final String getMaxNumberOfTcpConnections() {
    return properties.get(MAX_NUMBER_OF_TCP_CONNECTIONS_PROPERTY);
  }

  /**
   * The maximum number of concurrent connections to accept Syslog messages in TCP mode.
   */
  public final ListenSyslog setMaxNumberOfTcpConnections(final String maxNumberOfTcpConnections) {
    properties.put(MAX_NUMBER_OF_TCP_CONNECTIONS_PROPERTY, maxNumberOfTcpConnections);
    return this;
  }

  /**
   * The maximum number of concurrent connections to accept Syslog messages in TCP mode.
   */
  public final ListenSyslog removeMaxNumberOfTcpConnections() {
    properties.remove(MAX_NUMBER_OF_TCP_CONNECTIONS_PROPERTY);
    return this;
  }

  /**
   * The maximum number of Syslog events to add to a single FlowFile. If multiple events are available, they will be concatenated along with the <Message Delimiter> up to this configured maximum number of messages
   */
  public final String getMaxBatchSize() {
    return properties.get(MAX_BATCH_SIZE_PROPERTY);
  }

  /**
   * The maximum number of Syslog events to add to a single FlowFile. If multiple events are available, they will be concatenated along with the <Message Delimiter> up to this configured maximum number of messages
   */
  public final ListenSyslog setMaxBatchSize(final String maxBatchSize) {
    properties.put(MAX_BATCH_SIZE_PROPERTY, maxBatchSize);
    return this;
  }

  /**
   * The maximum number of Syslog events to add to a single FlowFile. If multiple events are available, they will be concatenated along with the <Message Delimiter> up to this configured maximum number of messages
   */
  public final ListenSyslog removeMaxBatchSize() {
    properties.remove(MAX_BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * Specifies the delimiter to place between Syslog messages when multiple messages are bundled together (see <Max Batch Size> property).
   */
  public final String getMessageDelimiter() {
    return properties.get(MESSAGE_DELIMITER_PROPERTY);
  }

  /**
   * Specifies the delimiter to place between Syslog messages when multiple messages are bundled together (see <Max Batch Size> property).
   */
  public final ListenSyslog setMessageDelimiter(final String messageDelimiter) {
    properties.put(MESSAGE_DELIMITER_PROPERTY, messageDelimiter);
    return this;
  }

  /**
   * Specifies the delimiter to place between Syslog messages when multiple messages are bundled together (see <Max Batch Size> property).
   */
  public final ListenSyslog removeMessageDelimiter() {
    properties.remove(MESSAGE_DELIMITER_PROPERTY);
    return this;
  }

  /**
   * Indicates if the processor should parse the Syslog messages. If set to false, each outgoing FlowFile will only contain the sender, protocol, and port, and no additional attributes.
   */
  public final String getParseMessages() {
    return properties.get(PARSE_MESSAGES_PROPERTY);
  }

  /**
   * Indicates if the processor should parse the Syslog messages. If set to false, each outgoing FlowFile will only contain the sender, protocol, and port, and no additional attributes.
   */
  public final ListenSyslog setParseMessages(final String parseMessages) {
    properties.put(PARSE_MESSAGES_PROPERTY, parseMessages);
    return this;
  }

  /**
   * Indicates if the processor should parse the Syslog messages. If set to false, each outgoing FlowFile will only contain the sender, protocol, and port, and no additional attributes.
   */
  public final ListenSyslog removeParseMessages() {
    properties.remove(PARSE_MESSAGES_PROPERTY);
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
  public final ListenSyslog setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * Specifies the character set of the Syslog messages. Note that Expression language is not evaluated per FlowFile.
   */
  public final ListenSyslog removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ListenSyslog setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ListenSyslog removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ListenSyslog, ListenSyslog> configurator) {
    return configurator.apply(new ListenSyslog()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListenSyslog.class) final Closure<ListenSyslog> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ListenSyslog> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ListenSyslog.class, com.tibtech.nifi.processors.standard.ListenSyslog.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ListenSyslog, ListenSyslog> configurator) {
    return configurator.apply(new ListenSyslog(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListenSyslog.class) final Closure<ListenSyslog> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.ListenSyslog> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ListenSyslog.class, com.tibtech.nifi.processors.standard.ListenSyslog.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
