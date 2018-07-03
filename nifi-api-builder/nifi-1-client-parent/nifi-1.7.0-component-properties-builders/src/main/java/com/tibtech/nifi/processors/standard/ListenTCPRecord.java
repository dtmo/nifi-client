package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ListenTCPRecord {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ListenTCPRecord";

  /**
   * The name of a local network interface to be used to restrict listening to a specific LAN.
   */
  public static final String LOCAL_NETWORK_INTERFACE_PROPERTY = "Local Network Interface";

  /**
   * The port to listen on for communication.
   */
  public static final String PORT_PROPERTY = "port";

  /**
   * The maximum size of the socket buffer that should be used. This is a suggestion to the Operating System to indicate how big the socket buffer should be. If this value is set too low, the buffer may fill up before the data can be read, and incoming data will be dropped.
   */
  public static final String MAX_SIZE_SOCKET_BUFFER_PROPERTY = "max-size-socket-buffer";

  /**
   * The maximum number of concurrent TCP connections to accept. In cases where clients are keeping a connection open, the concurrent tasks for the processor should be adjusted to match the Max Number of TCP Connections allowed, so that there is a task processing each connection.
   */
  public static final String MAX_NUMBER_TCP_CONNECTIONS_PROPERTY = "max-number-tcp-connections";

  /**
   * The amount of time to wait before timing out when reading from a connection.
   */
  public static final String READ_TIMEOUT_PROPERTY = "read-timeout";

  /**
   * The Record Reader to use for incoming FlowFiles
   */
  public static final String RECORD_READER_PROPERTY = "record-reader";

  /**
   * The Record Writer to use in order to serialize the data before writing to a FlowFile
   */
  public static final String RECORD_WRITER_PROPERTY = "record-writer";

  /**
   * Indicates how to deal with an error while reading the next record from a connection, when previous records have already been read from the connection.
   */
  public static final String READER_ERROR_HANDLING_STRATEGY_PROPERTY = "reader-error-handling-strategy";

  /**
   * The maximum number of records to write to a single FlowFile.
   */
  public static final String RECORD_BATCH_SIZE_PROPERTY = "record-batch-size";

  /**
   * The Controller Service to use in order to obtain an SSL Context. If this property is set, messages will be received over a secure connection.
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "ssl-context-service";

  /**
   * The client authentication policy to use for the SSL Context. Only used if an SSL Context Service is provided.
   */
  public static final String CLIENT_AUTH_PROPERTY = "client-auth";

  private final Map<String, String> properties;

  public ListenTCPRecord() {
    this.properties = new HashMap<>();
  }

  public ListenTCPRecord(final Map<String, String> properties) {
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
  public final ListenTCPRecord setLocalNetworkInterface(final String localNetworkInterface) {
    properties.put(LOCAL_NETWORK_INTERFACE_PROPERTY, localNetworkInterface);
    return this;
  }

  /**
   * The name of a local network interface to be used to restrict listening to a specific LAN.
   */
  public final ListenTCPRecord removeLocalNetworkInterface() {
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
  public final ListenTCPRecord setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * The port to listen on for communication.
   */
  public final ListenTCPRecord removePort() {
    properties.remove(PORT_PROPERTY);
    return this;
  }

  /**
   * The maximum size of the socket buffer that should be used. This is a suggestion to the Operating System to indicate how big the socket buffer should be. If this value is set too low, the buffer may fill up before the data can be read, and incoming data will be dropped.
   */
  public final String getMaxSizeSocketBuffer() {
    return properties.get(MAX_SIZE_SOCKET_BUFFER_PROPERTY);
  }

  /**
   * The maximum size of the socket buffer that should be used. This is a suggestion to the Operating System to indicate how big the socket buffer should be. If this value is set too low, the buffer may fill up before the data can be read, and incoming data will be dropped.
   */
  public final ListenTCPRecord setMaxSizeSocketBuffer(final String maxSizeSocketBuffer) {
    properties.put(MAX_SIZE_SOCKET_BUFFER_PROPERTY, maxSizeSocketBuffer);
    return this;
  }

  /**
   * The maximum size of the socket buffer that should be used. This is a suggestion to the Operating System to indicate how big the socket buffer should be. If this value is set too low, the buffer may fill up before the data can be read, and incoming data will be dropped.
   */
  public final ListenTCPRecord removeMaxSizeSocketBuffer() {
    properties.remove(MAX_SIZE_SOCKET_BUFFER_PROPERTY);
    return this;
  }

  /**
   * The maximum number of concurrent TCP connections to accept. In cases where clients are keeping a connection open, the concurrent tasks for the processor should be adjusted to match the Max Number of TCP Connections allowed, so that there is a task processing each connection.
   */
  public final String getMaxNumberTcpConnections() {
    return properties.get(MAX_NUMBER_TCP_CONNECTIONS_PROPERTY);
  }

  /**
   * The maximum number of concurrent TCP connections to accept. In cases where clients are keeping a connection open, the concurrent tasks for the processor should be adjusted to match the Max Number of TCP Connections allowed, so that there is a task processing each connection.
   */
  public final ListenTCPRecord setMaxNumberTcpConnections(final String maxNumberTcpConnections) {
    properties.put(MAX_NUMBER_TCP_CONNECTIONS_PROPERTY, maxNumberTcpConnections);
    return this;
  }

  /**
   * The maximum number of concurrent TCP connections to accept. In cases where clients are keeping a connection open, the concurrent tasks for the processor should be adjusted to match the Max Number of TCP Connections allowed, so that there is a task processing each connection.
   */
  public final ListenTCPRecord removeMaxNumberTcpConnections() {
    properties.remove(MAX_NUMBER_TCP_CONNECTIONS_PROPERTY);
    return this;
  }

  /**
   * The amount of time to wait before timing out when reading from a connection.
   */
  public final String getReadTimeout() {
    return properties.get(READ_TIMEOUT_PROPERTY);
  }

  /**
   * The amount of time to wait before timing out when reading from a connection.
   */
  public final ListenTCPRecord setReadTimeout(final String readTimeout) {
    properties.put(READ_TIMEOUT_PROPERTY, readTimeout);
    return this;
  }

  /**
   * The amount of time to wait before timing out when reading from a connection.
   */
  public final ListenTCPRecord removeReadTimeout() {
    properties.remove(READ_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The Record Reader to use for incoming FlowFiles
   */
  public final String getRecordReader() {
    return properties.get(RECORD_READER_PROPERTY);
  }

  /**
   * The Record Reader to use for incoming FlowFiles
   */
  public final ListenTCPRecord setRecordReader(final String recordReader) {
    properties.put(RECORD_READER_PROPERTY, recordReader);
    return this;
  }

  /**
   * The Record Reader to use for incoming FlowFiles
   */
  public final ListenTCPRecord removeRecordReader() {
    properties.remove(RECORD_READER_PROPERTY);
    return this;
  }

  /**
   * The Record Writer to use in order to serialize the data before writing to a FlowFile
   */
  public final String getRecordWriter() {
    return properties.get(RECORD_WRITER_PROPERTY);
  }

  /**
   * The Record Writer to use in order to serialize the data before writing to a FlowFile
   */
  public final ListenTCPRecord setRecordWriter(final String recordWriter) {
    properties.put(RECORD_WRITER_PROPERTY, recordWriter);
    return this;
  }

  /**
   * The Record Writer to use in order to serialize the data before writing to a FlowFile
   */
  public final ListenTCPRecord removeRecordWriter() {
    properties.remove(RECORD_WRITER_PROPERTY);
    return this;
  }

  /**
   * Indicates how to deal with an error while reading the next record from a connection, when previous records have already been read from the connection.
   */
  public final String getReaderErrorHandlingStrategy() {
    return properties.get(READER_ERROR_HANDLING_STRATEGY_PROPERTY);
  }

  /**
   * Indicates how to deal with an error while reading the next record from a connection, when previous records have already been read from the connection.
   */
  public final ListenTCPRecord setReaderErrorHandlingStrategy(
      final String readerErrorHandlingStrategy) {
    properties.put(READER_ERROR_HANDLING_STRATEGY_PROPERTY, readerErrorHandlingStrategy);
    return this;
  }

  /**
   * Indicates how to deal with an error while reading the next record from a connection, when previous records have already been read from the connection.
   */
  public final ListenTCPRecord removeReaderErrorHandlingStrategy() {
    properties.remove(READER_ERROR_HANDLING_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * The maximum number of records to write to a single FlowFile.
   */
  public final String getRecordBatchSize() {
    return properties.get(RECORD_BATCH_SIZE_PROPERTY);
  }

  /**
   * The maximum number of records to write to a single FlowFile.
   */
  public final ListenTCPRecord setRecordBatchSize(final String recordBatchSize) {
    properties.put(RECORD_BATCH_SIZE_PROPERTY, recordBatchSize);
    return this;
  }

  /**
   * The maximum number of records to write to a single FlowFile.
   */
  public final ListenTCPRecord removeRecordBatchSize() {
    properties.remove(RECORD_BATCH_SIZE_PROPERTY);
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
  public final ListenTCPRecord setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context. If this property is set, messages will be received over a secure connection.
   */
  public final ListenTCPRecord removeSslContextService() {
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
  public final ListenTCPRecord setClientAuth(final String clientAuth) {
    properties.put(CLIENT_AUTH_PROPERTY, clientAuth);
    return this;
  }

  /**
   * The client authentication policy to use for the SSL Context. Only used if an SSL Context Service is provided.
   */
  public final ListenTCPRecord removeClientAuth() {
    properties.remove(CLIENT_AUTH_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ListenTCPRecord setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ListenTCPRecord removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ListenTCPRecord, ListenTCPRecord> configurator) {
    return configurator.apply(new ListenTCPRecord()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListenTCPRecord.class) final Closure<ListenTCPRecord> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ListenTCPRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ListenTCPRecord.class, com.tibtech.nifi.processors.standard.ListenTCPRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ListenTCPRecord, ListenTCPRecord> configurator) {
    return configurator.apply(new ListenTCPRecord(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListenTCPRecord.class) final Closure<ListenTCPRecord> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.ListenTCPRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ListenTCPRecord.class, com.tibtech.nifi.processors.standard.ListenTCPRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
