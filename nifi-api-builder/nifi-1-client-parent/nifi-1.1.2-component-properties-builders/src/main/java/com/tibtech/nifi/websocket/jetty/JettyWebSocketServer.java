package com.tibtech.nifi.websocket.jetty;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class JettyWebSocketServer {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.websocket.jetty.JettyWebSocketServer";

  /**
   * The size of the input (read from network layer) buffer size.
   */
  public static final String INPUT_BUFFER_SIZE_PROPERTY = "input-buffer-size";

  /**
   * The maximum size of a text message during parsing/generating.
   */
  public static final String MAX_TEXT_MESSAGE_SIZE_PROPERTY = "max-text-message-size";

  /**
   * The maximum size of a binary message during parsing/generating.
   */
  public static final String MAX_BINARY_MESSAGE_SIZE_PROPERTY = "max-binary-message-size";

  /**
   * The port number on which this WebSocketServer listens to.
   */
  public static final String LISTEN_PORT_PROPERTY = "listen-port";

  /**
   * The SSL Context Service to use in order to secure the server. If specified, the server will accept only WSS requests; otherwise, the server will accept only WS requests
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "ssl-context-service";

  /**
   * Specifies whether or not the Processor should authenticate clients. This value is ignored if the <SSL Context Service> Property is not specified or the SSL Context provided uses only a KeyStore and not a TrustStore.
   */
  public static final String CLIENT_AUTHENTICATION_PROPERTY = "client-authentication";

  private final Map<String, String> properties;

  public JettyWebSocketServer() {
    this.properties = new HashMap<>();
  }

  public JettyWebSocketServer(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The size of the input (read from network layer) buffer size.
   */
  public final String getInputBufferSize() {
    return properties.get(INPUT_BUFFER_SIZE_PROPERTY);
  }

  /**
   * The size of the input (read from network layer) buffer size.
   */
  public final JettyWebSocketServer setInputBufferSize(final String inputBufferSize) {
    properties.put(INPUT_BUFFER_SIZE_PROPERTY, inputBufferSize);
    return this;
  }

  /**
   * The size of the input (read from network layer) buffer size.
   */
  public final JettyWebSocketServer removeInputBufferSize() {
    properties.remove(INPUT_BUFFER_SIZE_PROPERTY);
    return this;
  }

  /**
   * The maximum size of a text message during parsing/generating.
   */
  public final String getMaxTextMessageSize() {
    return properties.get(MAX_TEXT_MESSAGE_SIZE_PROPERTY);
  }

  /**
   * The maximum size of a text message during parsing/generating.
   */
  public final JettyWebSocketServer setMaxTextMessageSize(final String maxTextMessageSize) {
    properties.put(MAX_TEXT_MESSAGE_SIZE_PROPERTY, maxTextMessageSize);
    return this;
  }

  /**
   * The maximum size of a text message during parsing/generating.
   */
  public final JettyWebSocketServer removeMaxTextMessageSize() {
    properties.remove(MAX_TEXT_MESSAGE_SIZE_PROPERTY);
    return this;
  }

  /**
   * The maximum size of a binary message during parsing/generating.
   */
  public final String getMaxBinaryMessageSize() {
    return properties.get(MAX_BINARY_MESSAGE_SIZE_PROPERTY);
  }

  /**
   * The maximum size of a binary message during parsing/generating.
   */
  public final JettyWebSocketServer setMaxBinaryMessageSize(final String maxBinaryMessageSize) {
    properties.put(MAX_BINARY_MESSAGE_SIZE_PROPERTY, maxBinaryMessageSize);
    return this;
  }

  /**
   * The maximum size of a binary message during parsing/generating.
   */
  public final JettyWebSocketServer removeMaxBinaryMessageSize() {
    properties.remove(MAX_BINARY_MESSAGE_SIZE_PROPERTY);
    return this;
  }

  /**
   * The port number on which this WebSocketServer listens to.
   */
  public final String getListenPort() {
    return properties.get(LISTEN_PORT_PROPERTY);
  }

  /**
   * The port number on which this WebSocketServer listens to.
   */
  public final JettyWebSocketServer setListenPort(final String listenPort) {
    properties.put(LISTEN_PORT_PROPERTY, listenPort);
    return this;
  }

  /**
   * The port number on which this WebSocketServer listens to.
   */
  public final JettyWebSocketServer removeListenPort() {
    properties.remove(LISTEN_PORT_PROPERTY);
    return this;
  }

  /**
   * The SSL Context Service to use in order to secure the server. If specified, the server will accept only WSS requests; otherwise, the server will accept only WS requests
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * The SSL Context Service to use in order to secure the server. If specified, the server will accept only WSS requests; otherwise, the server will accept only WS requests
   */
  public final JettyWebSocketServer setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The SSL Context Service to use in order to secure the server. If specified, the server will accept only WSS requests; otherwise, the server will accept only WS requests
   */
  public final JettyWebSocketServer removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Specifies whether or not the Processor should authenticate clients. This value is ignored if the <SSL Context Service> Property is not specified or the SSL Context provided uses only a KeyStore and not a TrustStore.
   */
  public final String getClientAuthentication() {
    return properties.get(CLIENT_AUTHENTICATION_PROPERTY);
  }

  /**
   * Specifies whether or not the Processor should authenticate clients. This value is ignored if the <SSL Context Service> Property is not specified or the SSL Context provided uses only a KeyStore and not a TrustStore.
   */
  public final JettyWebSocketServer setClientAuthentication(final String clientAuthentication) {
    properties.put(CLIENT_AUTHENTICATION_PROPERTY, clientAuthentication);
    return this;
  }

  /**
   * Specifies whether or not the Processor should authenticate clients. This value is ignored if the <SSL Context Service> Property is not specified or the SSL Context provided uses only a KeyStore and not a TrustStore.
   */
  public final JettyWebSocketServer removeClientAuthentication() {
    properties.remove(CLIENT_AUTHENTICATION_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final JettyWebSocketServer setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final JettyWebSocketServer removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<JettyWebSocketServer, JettyWebSocketServer> configurator) {
    return configurator.apply(new JettyWebSocketServer()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = JettyWebSocketServer.class) final Closure<JettyWebSocketServer> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.websocket.jetty.JettyWebSocketServer> code = closure.rehydrate(c, com.tibtech.nifi.websocket.jetty.JettyWebSocketServer.class, com.tibtech.nifi.websocket.jetty.JettyWebSocketServer.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<JettyWebSocketServer, JettyWebSocketServer> configurator) {
    return configurator.apply(new JettyWebSocketServer(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = JettyWebSocketServer.class) final Closure<JettyWebSocketServer> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.websocket.jetty.JettyWebSocketServer> code = closure.rehydrate(c, com.tibtech.nifi.websocket.jetty.JettyWebSocketServer.class, com.tibtech.nifi.websocket.jetty.JettyWebSocketServer.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
