package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ListenUDP {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ListenUDP";

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
   * IP, or name, of a remote host. Only Datagrams from the specified Sending Host Port and this host will be accepted. Improves Performance. May be a system property or an environment variable.
   */
  public static final String SENDING_HOST_PROPERTY = "Sending Host";

  /**
   * Port being used by remote host to send Datagrams. Only Datagrams from the specified Sending Host and this port will be accepted. Improves Performance. May be a system property or an environment variable.
   */
  public static final String SENDING_HOST_PORT_PROPERTY = "Sending Host Port";

  private final Map<String, String> properties;

  public ListenUDP() {
    this.properties = new HashMap<>();
  }

  public ListenUDP(final Map<String, String> properties) {
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
  public final ListenUDP setLocalNetworkInterface(final String localNetworkInterface) {
    properties.put(LOCAL_NETWORK_INTERFACE_PROPERTY, localNetworkInterface);
    return this;
  }

  /**
   * The name of a local network interface to be used to restrict listening to a specific LAN.
   */
  public final ListenUDP removeLocalNetworkInterface() {
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
  public final ListenUDP setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * The port to listen on for communication.
   */
  public final ListenUDP removePort() {
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
  public final ListenUDP setReceiveBufferSize(final String receiveBufferSize) {
    properties.put(RECEIVE_BUFFER_SIZE_PROPERTY, receiveBufferSize);
    return this;
  }

  /**
   * The size of each buffer used to receive messages. Adjust this value appropriately based on the expected size of the incoming messages.
   */
  public final ListenUDP removeReceiveBufferSize() {
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
  public final ListenUDP setMaxSizeOfMessageQueue(final String maxSizeOfMessageQueue) {
    properties.put(MAX_SIZE_OF_MESSAGE_QUEUE_PROPERTY, maxSizeOfMessageQueue);
    return this;
  }

  /**
   * The maximum size of the internal queue used to buffer messages being transferred from the underlying channel to the processor. Setting this value higher allows more messages to be buffered in memory during surges of incoming messages, but increases the total memory used by the processor.
   */
  public final ListenUDP removeMaxSizeOfMessageQueue() {
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
  public final ListenUDP setMaxSizeOfSocketBuffer(final String maxSizeOfSocketBuffer) {
    properties.put(MAX_SIZE_OF_SOCKET_BUFFER_PROPERTY, maxSizeOfSocketBuffer);
    return this;
  }

  /**
   * The maximum size of the socket buffer that should be used. This is a suggestion to the Operating System to indicate how big the socket buffer should be. If this value is set too low, the buffer may fill up before the data can be read, and incoming data will be dropped.
   */
  public final ListenUDP removeMaxSizeOfSocketBuffer() {
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
  public final ListenUDP setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * Specifies the character set of the received data.
   */
  public final ListenUDP removeCharacterSet() {
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
  public final ListenUDP setMaxBatchSize(final String maxBatchSize) {
    properties.put(MAX_BATCH_SIZE_PROPERTY, maxBatchSize);
    return this;
  }

  /**
   * The maximum number of messages to add to a single FlowFile. If multiple messages are available, they will be concatenated along with the <Message Delimiter> up to this configured maximum number of messages
   */
  public final ListenUDP removeMaxBatchSize() {
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
  public final ListenUDP setMessageDelimiter(final String messageDelimiter) {
    properties.put(MESSAGE_DELIMITER_PROPERTY, messageDelimiter);
    return this;
  }

  /**
   * Specifies the delimiter to place between messages when multiple messages are bundled together (see <Max Batch Size> property).
   */
  public final ListenUDP removeMessageDelimiter() {
    properties.remove(MESSAGE_DELIMITER_PROPERTY);
    return this;
  }

  /**
   * IP, or name, of a remote host. Only Datagrams from the specified Sending Host Port and this host will be accepted. Improves Performance. May be a system property or an environment variable.
   */
  public final String getSendingHost() {
    return properties.get(SENDING_HOST_PROPERTY);
  }

  /**
   * IP, or name, of a remote host. Only Datagrams from the specified Sending Host Port and this host will be accepted. Improves Performance. May be a system property or an environment variable.
   */
  public final ListenUDP setSendingHost(final String sendingHost) {
    properties.put(SENDING_HOST_PROPERTY, sendingHost);
    return this;
  }

  /**
   * IP, or name, of a remote host. Only Datagrams from the specified Sending Host Port and this host will be accepted. Improves Performance. May be a system property or an environment variable.
   */
  public final ListenUDP removeSendingHost() {
    properties.remove(SENDING_HOST_PROPERTY);
    return this;
  }

  /**
   * Port being used by remote host to send Datagrams. Only Datagrams from the specified Sending Host and this port will be accepted. Improves Performance. May be a system property or an environment variable.
   */
  public final String getSendingHostPort() {
    return properties.get(SENDING_HOST_PORT_PROPERTY);
  }

  /**
   * Port being used by remote host to send Datagrams. Only Datagrams from the specified Sending Host and this port will be accepted. Improves Performance. May be a system property or an environment variable.
   */
  public final ListenUDP setSendingHostPort(final String sendingHostPort) {
    properties.put(SENDING_HOST_PORT_PROPERTY, sendingHostPort);
    return this;
  }

  /**
   * Port being used by remote host to send Datagrams. Only Datagrams from the specified Sending Host and this port will be accepted. Improves Performance. May be a system property or an environment variable.
   */
  public final ListenUDP removeSendingHostPort() {
    properties.remove(SENDING_HOST_PORT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ListenUDP setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ListenUDP removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ListenUDP, ListenUDP> configurator) {
    return configurator.apply(new ListenUDP()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListenUDP.class) final Closure<ListenUDP> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ListenUDP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ListenUDP.class, com.tibtech.nifi.processors.standard.ListenUDP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ListenUDP, ListenUDP> configurator) {
    return configurator.apply(new ListenUDP(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListenUDP.class) final Closure<ListenUDP> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.ListenUDP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ListenUDP.class, com.tibtech.nifi.processors.standard.ListenUDP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
