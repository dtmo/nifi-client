package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutUDP {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.PutUDP";

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
  public final PutUDP setHostname(final String hostname) {
    properties.put(HOSTNAME_PROPERTY, hostname);
    return this;
  }

  /**
   * The ip address or hostname of the destination.
   */
  public final PutUDP removeHostname() {
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
  public final PutUDP setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * The port on the destination.
   */
  public final PutUDP removePort() {
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
  public final PutUDP setMaxSizeOfSocketSendBuffer(final String maxSizeOfSocketSendBuffer) {
    properties.put(MAX_SIZE_OF_SOCKET_SEND_BUFFER_PROPERTY, maxSizeOfSocketSendBuffer);
    return this;
  }

  /**
   * The maximum size of the socket send buffer that should be used. This is a suggestion to the Operating System to indicate how big the socket buffer should be. If this value is set too low, the buffer may fill up before the data can be read, and incoming data will be dropped.
   */
  public final PutUDP removeMaxSizeOfSocketSendBuffer() {
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
  public final PutUDP setIdleConnectionExpiration(final String idleConnectionExpiration) {
    properties.put(IDLE_CONNECTION_EXPIRATION_PROPERTY, idleConnectionExpiration);
    return this;
  }

  /**
   * The amount of time a connection should be held open without being used before closing the connection.
   */
  public final PutUDP removeIdleConnectionExpiration() {
    properties.remove(IDLE_CONNECTION_EXPIRATION_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutUDP setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutUDP removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<PutUDP, PutUDP> configurator) {
    return configurator.apply(new PutUDP()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutUDP.class) final Closure<PutUDP> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.PutUDP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.PutUDP.class, com.tibtech.nifi.processors.standard.PutUDP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
