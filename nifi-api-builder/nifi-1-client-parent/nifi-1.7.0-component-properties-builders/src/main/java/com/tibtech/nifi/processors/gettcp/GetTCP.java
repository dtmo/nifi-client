package com.tibtech.nifi.processors.gettcp;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GetTCP {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.gettcp.GetTCP";

  /**
   * A comma delimited list of the endpoints to connect to. The format should be <server_address>:<port>. Only one server will be connected to at a time, the others will be used as fail overs.
   */
  public static final String ENDPOINT_LIST_PROPERTY = "endpoint-list";

  /**
   * The number of times to try and establish a connection, before using a backup host if available. This same attempt count would be used for a backup host as well.
   */
  public static final String CONNECTION_ATTEMPT_TIMEOUT_PROPERTY = "connection-attempt-timeout";

  /**
   * The number of seconds to wait before attempting to reconnect to the endpoint.
   */
  public static final String RECONNECT_INTERVAL_PROPERTY = "reconnect-interval";

  /**
   * The size of the buffer to receive data in. Default 16384 (16MB).
   */
  public static final String RECEIVE_BUFFER_SIZE_PROPERTY = "receive-buffer-size";

  /**
   * Byte value which denotes end of message. Must be specified as integer within the valid byte range (-128 thru 127). For example, '13' = Carriage return and '10' = New line. Default '13'.
   */
  public static final String END_OF_MESSAGE_BYTE_PROPERTY = "end-of-message-byte";

  private final Map<String, String> properties;

  public GetTCP() {
    this.properties = new HashMap<>();
  }

  public GetTCP(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * A comma delimited list of the endpoints to connect to. The format should be <server_address>:<port>. Only one server will be connected to at a time, the others will be used as fail overs.
   */
  public final String getEndpointList() {
    return properties.get(ENDPOINT_LIST_PROPERTY);
  }

  /**
   * A comma delimited list of the endpoints to connect to. The format should be <server_address>:<port>. Only one server will be connected to at a time, the others will be used as fail overs.
   */
  public final GetTCP setEndpointList(final String endpointList) {
    properties.put(ENDPOINT_LIST_PROPERTY, endpointList);
    return this;
  }

  /**
   * A comma delimited list of the endpoints to connect to. The format should be <server_address>:<port>. Only one server will be connected to at a time, the others will be used as fail overs.
   */
  public final GetTCP removeEndpointList() {
    properties.remove(ENDPOINT_LIST_PROPERTY);
    return this;
  }

  /**
   * The number of times to try and establish a connection, before using a backup host if available. This same attempt count would be used for a backup host as well.
   */
  public final String getConnectionAttemptTimeout() {
    return properties.get(CONNECTION_ATTEMPT_TIMEOUT_PROPERTY);
  }

  /**
   * The number of times to try and establish a connection, before using a backup host if available. This same attempt count would be used for a backup host as well.
   */
  public final GetTCP setConnectionAttemptTimeout(final String connectionAttemptTimeout) {
    properties.put(CONNECTION_ATTEMPT_TIMEOUT_PROPERTY, connectionAttemptTimeout);
    return this;
  }

  /**
   * The number of times to try and establish a connection, before using a backup host if available. This same attempt count would be used for a backup host as well.
   */
  public final GetTCP removeConnectionAttemptTimeout() {
    properties.remove(CONNECTION_ATTEMPT_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The number of seconds to wait before attempting to reconnect to the endpoint.
   */
  public final String getReconnectInterval() {
    return properties.get(RECONNECT_INTERVAL_PROPERTY);
  }

  /**
   * The number of seconds to wait before attempting to reconnect to the endpoint.
   */
  public final GetTCP setReconnectInterval(final String reconnectInterval) {
    properties.put(RECONNECT_INTERVAL_PROPERTY, reconnectInterval);
    return this;
  }

  /**
   * The number of seconds to wait before attempting to reconnect to the endpoint.
   */
  public final GetTCP removeReconnectInterval() {
    properties.remove(RECONNECT_INTERVAL_PROPERTY);
    return this;
  }

  /**
   * The size of the buffer to receive data in. Default 16384 (16MB).
   */
  public final String getReceiveBufferSize() {
    return properties.get(RECEIVE_BUFFER_SIZE_PROPERTY);
  }

  /**
   * The size of the buffer to receive data in. Default 16384 (16MB).
   */
  public final GetTCP setReceiveBufferSize(final String receiveBufferSize) {
    properties.put(RECEIVE_BUFFER_SIZE_PROPERTY, receiveBufferSize);
    return this;
  }

  /**
   * The size of the buffer to receive data in. Default 16384 (16MB).
   */
  public final GetTCP removeReceiveBufferSize() {
    properties.remove(RECEIVE_BUFFER_SIZE_PROPERTY);
    return this;
  }

  /**
   * Byte value which denotes end of message. Must be specified as integer within the valid byte range (-128 thru 127). For example, '13' = Carriage return and '10' = New line. Default '13'.
   */
  public final String getEndOfMessageByte() {
    return properties.get(END_OF_MESSAGE_BYTE_PROPERTY);
  }

  /**
   * Byte value which denotes end of message. Must be specified as integer within the valid byte range (-128 thru 127). For example, '13' = Carriage return and '10' = New line. Default '13'.
   */
  public final GetTCP setEndOfMessageByte(final String endOfMessageByte) {
    properties.put(END_OF_MESSAGE_BYTE_PROPERTY, endOfMessageByte);
    return this;
  }

  /**
   * Byte value which denotes end of message. Must be specified as integer within the valid byte range (-128 thru 127). For example, '13' = Carriage return and '10' = New line. Default '13'.
   */
  public final GetTCP removeEndOfMessageByte() {
    properties.remove(END_OF_MESSAGE_BYTE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GetTCP setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GetTCP removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<GetTCP, GetTCP> configurator) {
    return configurator.apply(new GetTCP()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetTCP.class) final Closure<GetTCP> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.gettcp.GetTCP> code = closure.rehydrate(c, com.tibtech.nifi.processors.gettcp.GetTCP.class, com.tibtech.nifi.processors.gettcp.GetTCP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<GetTCP, GetTCP> configurator) {
    return configurator.apply(new GetTCP(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetTCP.class) final Closure<GetTCP> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.gettcp.GetTCP> code = closure.rehydrate(c, com.tibtech.nifi.processors.gettcp.GetTCP.class, com.tibtech.nifi.processors.gettcp.GetTCP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
