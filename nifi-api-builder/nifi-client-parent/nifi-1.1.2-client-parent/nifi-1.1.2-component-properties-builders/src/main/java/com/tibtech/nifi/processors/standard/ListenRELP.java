package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ListenRELP {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ListenRELP";

  /**
   * The name of a local network interface to be used to restrict listening to a specific LAN.
   */
  public static final String LOCAL_NETWORK_INTERFACE_PROPERTY = "Local Network Interface";

  /**
   * The port to listen on for communication.
   */
  public static final String PORT_PROPERTY = "Port";

  /**
   * The size of each buffer used to receive messages. Adjust this value appropriately based on the expected size of the incoming messages.
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
   * Specifies the character set of the received data.
   */
  public static final String CHARACTER_SET_PROPERTY = "Character Set";

  /**
   * The maximum number of messages to add to a single FlowFile. If multiple messages are available, they will be concatenated along with the <Message Delimiter> up to this configured maximum number of messages
   */
  public static final String MAX_BATCH_SIZE_PROPERTY = "Max Batch Size";

  /**
   * Specifies the delimiter to place between messages when multiple messages are bundled together (see <Max Batch Size> property).
   */
  public static final String MESSAGE_DELIMITER_PROPERTY = "Message Delimiter";

  /**
   * The maximum number of concurrent TCP connections to accept.
   */
  public static final String MAX_NUMBER_OF_TCP_CONNECTIONS_PROPERTY = "Max Number of TCP Connections";

  /**
   * The Controller Service to use in order to obtain an SSL Context. If this property is set, messages will be received over a secure connection.
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  private final Map<String, String> properties;

  public ListenRELP() {
    this.properties = new HashMap<>();
  }

  public ListenRELP(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
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
  public final ListenRELP setLocalNetworkInterface(final String localNetworkInterface) {
    properties.put(LOCAL_NETWORK_INTERFACE_PROPERTY, localNetworkInterface);
    return this;
  }

  /**
   * The name of a local network interface to be used to restrict listening to a specific LAN.
   */
  public final ListenRELP removeLocalNetworkInterface() {
    properties.remove(LOCAL_NETWORK_INTERFACE_PROPERTY);
    return this;
  }

  /**
   * The port to listen on for communication.
   */
  public final String getPort() {
    return properties.get(PORT_PROPERTY);
  }

  /**
   * The port to listen on for communication.
   */
  public final ListenRELP setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * The port to listen on for communication.
   */
  public final ListenRELP removePort() {
    properties.remove(PORT_PROPERTY);
    return this;
  }

  /**
   * The size of each buffer used to receive messages. Adjust this value appropriately based on the expected size of the incoming messages.
   */
  public final String getReceiveBufferSize() {
    return properties.get(RECEIVE_BUFFER_SIZE_PROPERTY);
  }

  /**
   * The size of each buffer used to receive messages. Adjust this value appropriately based on the expected size of the incoming messages.
   */
  public final ListenRELP setReceiveBufferSize(final String receiveBufferSize) {
    properties.put(RECEIVE_BUFFER_SIZE_PROPERTY, receiveBufferSize);
    return this;
  }

  /**
   * The size of each buffer used to receive messages. Adjust this value appropriately based on the expected size of the incoming messages.
   */
  public final ListenRELP removeReceiveBufferSize() {
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
  public final ListenRELP setMaxSizeOfMessageQueue(final String maxSizeOfMessageQueue) {
    properties.put(MAX_SIZE_OF_MESSAGE_QUEUE_PROPERTY, maxSizeOfMessageQueue);
    return this;
  }

  /**
   * The maximum size of the internal queue used to buffer messages being transferred from the underlying channel to the processor. Setting this value higher allows more messages to be buffered in memory during surges of incoming messages, but increases the total memory used by the processor.
   */
  public final ListenRELP removeMaxSizeOfMessageQueue() {
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
  public final ListenRELP setMaxSizeOfSocketBuffer(final String maxSizeOfSocketBuffer) {
    properties.put(MAX_SIZE_OF_SOCKET_BUFFER_PROPERTY, maxSizeOfSocketBuffer);
    return this;
  }

  /**
   * The maximum size of the socket buffer that should be used. This is a suggestion to the Operating System to indicate how big the socket buffer should be. If this value is set too low, the buffer may fill up before the data can be read, and incoming data will be dropped.
   */
  public final ListenRELP removeMaxSizeOfSocketBuffer() {
    properties.remove(MAX_SIZE_OF_SOCKET_BUFFER_PROPERTY);
    return this;
  }

  /**
   * Specifies the character set of the received data.
   */
  public final String getCharacterSet() {
    return properties.get(CHARACTER_SET_PROPERTY);
  }

  /**
   * Specifies the character set of the received data.
   */
  public final ListenRELP setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * Specifies the character set of the received data.
   */
  public final ListenRELP removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
    return this;
  }

  /**
   * The maximum number of messages to add to a single FlowFile. If multiple messages are available, they will be concatenated along with the <Message Delimiter> up to this configured maximum number of messages
   */
  public final String getMaxBatchSize() {
    return properties.get(MAX_BATCH_SIZE_PROPERTY);
  }

  /**
   * The maximum number of messages to add to a single FlowFile. If multiple messages are available, they will be concatenated along with the <Message Delimiter> up to this configured maximum number of messages
   */
  public final ListenRELP setMaxBatchSize(final String maxBatchSize) {
    properties.put(MAX_BATCH_SIZE_PROPERTY, maxBatchSize);
    return this;
  }

  /**
   * The maximum number of messages to add to a single FlowFile. If multiple messages are available, they will be concatenated along with the <Message Delimiter> up to this configured maximum number of messages
   */
  public final ListenRELP removeMaxBatchSize() {
    properties.remove(MAX_BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * Specifies the delimiter to place between messages when multiple messages are bundled together (see <Max Batch Size> property).
   */
  public final String getMessageDelimiter() {
    return properties.get(MESSAGE_DELIMITER_PROPERTY);
  }

  /**
   * Specifies the delimiter to place between messages when multiple messages are bundled together (see <Max Batch Size> property).
   */
  public final ListenRELP setMessageDelimiter(final String messageDelimiter) {
    properties.put(MESSAGE_DELIMITER_PROPERTY, messageDelimiter);
    return this;
  }

  /**
   * Specifies the delimiter to place between messages when multiple messages are bundled together (see <Max Batch Size> property).
   */
  public final ListenRELP removeMessageDelimiter() {
    properties.remove(MESSAGE_DELIMITER_PROPERTY);
    return this;
  }

  /**
   * The maximum number of concurrent TCP connections to accept.
   */
  public final String getMaxNumberOfTcpConnections() {
    return properties.get(MAX_NUMBER_OF_TCP_CONNECTIONS_PROPERTY);
  }

  /**
   * The maximum number of concurrent TCP connections to accept.
   */
  public final ListenRELP setMaxNumberOfTcpConnections(final String maxNumberOfTcpConnections) {
    properties.put(MAX_NUMBER_OF_TCP_CONNECTIONS_PROPERTY, maxNumberOfTcpConnections);
    return this;
  }

  /**
   * The maximum number of concurrent TCP connections to accept.
   */
  public final ListenRELP removeMaxNumberOfTcpConnections() {
    properties.remove(MAX_NUMBER_OF_TCP_CONNECTIONS_PROPERTY);
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
  public final ListenRELP setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context. If this property is set, messages will be received over a secure connection.
   */
  public final ListenRELP removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ListenRELP setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ListenRELP removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ListenRELP, ListenRELP> configurator) {
    return configurator.apply(new ListenRELP()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListenRELP.class) final Closure<ListenRELP> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ListenRELP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ListenRELP.class, com.tibtech.nifi.processors.standard.ListenRELP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ListenRELP, ListenRELP> configurator) {
    return configurator.apply(new ListenRELP(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListenRELP.class) final Closure<ListenRELP> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.ListenRELP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ListenRELP.class, com.tibtech.nifi.processors.standard.ListenRELP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
