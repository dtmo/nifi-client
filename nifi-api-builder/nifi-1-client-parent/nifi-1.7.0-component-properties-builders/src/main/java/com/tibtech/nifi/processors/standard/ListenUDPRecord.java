package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ListenUDPRecord {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ListenUDPRecord";

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
   * The amount of time to wait when polling the internal queue for more datagrams. If no datagrams are found after waiting for the configured timeout, then the processor will emit whatever records have been obtained up to that point.
   */
  public static final String POLL_TIMEOUT_PROPERTY = "poll-timeout";

  /**
   * The maximum number of datagrams to write as records to a single FlowFile. The Batch Size will only be reached when data is coming in more frequently than the Poll Timeout.
   */
  public static final String BATCH_SIZE_PROPERTY = "batch-size";

  /**
   * The Record Reader to use for reading the content of incoming datagrams.
   */
  public static final String RECORD_READER_PROPERTY = "record-reader";

  /**
   * The Record Writer to use in order to serialize the data before writing to a flow file.
   */
  public static final String RECORD_WRITER_PROPERTY = "record-writer";

  /**
   * IP, or name, of a remote host. Only Datagrams from the specified Sending Host Port and this host will be accepted. Improves Performance. May be a system property or an environment variable.
   */
  public static final String SENDING_HOST_PROPERTY = "sending-host";

  /**
   * Port being used by remote host to send Datagrams. Only Datagrams from the specified Sending Host and this port will be accepted. Improves Performance. May be a system property or an environment variable.
   */
  public static final String SENDING_HOST_PORT_PROPERTY = "sending-host-port";

  private final Map<String, String> properties;

  public ListenUDPRecord() {
    this.properties = new HashMap<>();
  }

  public ListenUDPRecord(final Map<String, String> properties) {
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
  public final ListenUDPRecord setLocalNetworkInterface(final String localNetworkInterface) {
    properties.put(LOCAL_NETWORK_INTERFACE_PROPERTY, localNetworkInterface);
    return this;
  }

  /**
   * The name of a local network interface to be used to restrict listening to a specific LAN.
   */
  public final ListenUDPRecord removeLocalNetworkInterface() {
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
  public final ListenUDPRecord setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * The port to listen on for communication.
   */
  public final ListenUDPRecord removePort() {
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
  public final ListenUDPRecord setReceiveBufferSize(final String receiveBufferSize) {
    properties.put(RECEIVE_BUFFER_SIZE_PROPERTY, receiveBufferSize);
    return this;
  }

  /**
   * The size of each buffer used to receive messages. Adjust this value appropriately based on the expected size of the incoming messages.
   */
  public final ListenUDPRecord removeReceiveBufferSize() {
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
  public final ListenUDPRecord setMaxSizeOfMessageQueue(final String maxSizeOfMessageQueue) {
    properties.put(MAX_SIZE_OF_MESSAGE_QUEUE_PROPERTY, maxSizeOfMessageQueue);
    return this;
  }

  /**
   * The maximum size of the internal queue used to buffer messages being transferred from the underlying channel to the processor. Setting this value higher allows more messages to be buffered in memory during surges of incoming messages, but increases the total memory used by the processor.
   */
  public final ListenUDPRecord removeMaxSizeOfMessageQueue() {
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
  public final ListenUDPRecord setMaxSizeOfSocketBuffer(final String maxSizeOfSocketBuffer) {
    properties.put(MAX_SIZE_OF_SOCKET_BUFFER_PROPERTY, maxSizeOfSocketBuffer);
    return this;
  }

  /**
   * The maximum size of the socket buffer that should be used. This is a suggestion to the Operating System to indicate how big the socket buffer should be. If this value is set too low, the buffer may fill up before the data can be read, and incoming data will be dropped.
   */
  public final ListenUDPRecord removeMaxSizeOfSocketBuffer() {
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
  public final ListenUDPRecord setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * Specifies the character set of the received data.
   */
  public final ListenUDPRecord removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
    return this;
  }

  /**
   * The amount of time to wait when polling the internal queue for more datagrams. If no datagrams are found after waiting for the configured timeout, then the processor will emit whatever records have been obtained up to that point.
   */
  public final String getPollTimeout() {
    return properties.get(POLL_TIMEOUT_PROPERTY);
  }

  /**
   * The amount of time to wait when polling the internal queue for more datagrams. If no datagrams are found after waiting for the configured timeout, then the processor will emit whatever records have been obtained up to that point.
   */
  public final ListenUDPRecord setPollTimeout(final String pollTimeout) {
    properties.put(POLL_TIMEOUT_PROPERTY, pollTimeout);
    return this;
  }

  /**
   * The amount of time to wait when polling the internal queue for more datagrams. If no datagrams are found after waiting for the configured timeout, then the processor will emit whatever records have been obtained up to that point.
   */
  public final ListenUDPRecord removePollTimeout() {
    properties.remove(POLL_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The maximum number of datagrams to write as records to a single FlowFile. The Batch Size will only be reached when data is coming in more frequently than the Poll Timeout.
   */
  public final String getBatchSize() {
    return properties.get(BATCH_SIZE_PROPERTY);
  }

  /**
   * The maximum number of datagrams to write as records to a single FlowFile. The Batch Size will only be reached when data is coming in more frequently than the Poll Timeout.
   */
  public final ListenUDPRecord setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * The maximum number of datagrams to write as records to a single FlowFile. The Batch Size will only be reached when data is coming in more frequently than the Poll Timeout.
   */
  public final ListenUDPRecord removeBatchSize() {
    properties.remove(BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * The Record Reader to use for reading the content of incoming datagrams.
   */
  public final String getRecordReader() {
    return properties.get(RECORD_READER_PROPERTY);
  }

  /**
   * The Record Reader to use for reading the content of incoming datagrams.
   */
  public final ListenUDPRecord setRecordReader(final String recordReader) {
    properties.put(RECORD_READER_PROPERTY, recordReader);
    return this;
  }

  /**
   * The Record Reader to use for reading the content of incoming datagrams.
   */
  public final ListenUDPRecord removeRecordReader() {
    properties.remove(RECORD_READER_PROPERTY);
    return this;
  }

  /**
   * The Record Writer to use in order to serialize the data before writing to a flow file.
   */
  public final String getRecordWriter() {
    return properties.get(RECORD_WRITER_PROPERTY);
  }

  /**
   * The Record Writer to use in order to serialize the data before writing to a flow file.
   */
  public final ListenUDPRecord setRecordWriter(final String recordWriter) {
    properties.put(RECORD_WRITER_PROPERTY, recordWriter);
    return this;
  }

  /**
   * The Record Writer to use in order to serialize the data before writing to a flow file.
   */
  public final ListenUDPRecord removeRecordWriter() {
    properties.remove(RECORD_WRITER_PROPERTY);
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
  public final ListenUDPRecord setSendingHost(final String sendingHost) {
    properties.put(SENDING_HOST_PROPERTY, sendingHost);
    return this;
  }

  /**
   * IP, or name, of a remote host. Only Datagrams from the specified Sending Host Port and this host will be accepted. Improves Performance. May be a system property or an environment variable.
   */
  public final ListenUDPRecord removeSendingHost() {
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
  public final ListenUDPRecord setSendingHostPort(final String sendingHostPort) {
    properties.put(SENDING_HOST_PORT_PROPERTY, sendingHostPort);
    return this;
  }

  /**
   * Port being used by remote host to send Datagrams. Only Datagrams from the specified Sending Host and this port will be accepted. Improves Performance. May be a system property or an environment variable.
   */
  public final ListenUDPRecord removeSendingHostPort() {
    properties.remove(SENDING_HOST_PORT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ListenUDPRecord setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ListenUDPRecord removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ListenUDPRecord, ListenUDPRecord> configurator) {
    return configurator.apply(new ListenUDPRecord()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListenUDPRecord.class) final Closure<ListenUDPRecord> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ListenUDPRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ListenUDPRecord.class, com.tibtech.nifi.processors.standard.ListenUDPRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ListenUDPRecord, ListenUDPRecord> configurator) {
    return configurator.apply(new ListenUDPRecord(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListenUDPRecord.class) final Closure<ListenUDPRecord> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.ListenUDPRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ListenUDPRecord.class, com.tibtech.nifi.processors.standard.ListenUDPRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
