package com.tibtech.nifi.websocket.jetty;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class JettyWebSocketClient {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.websocket.jetty.JettyWebSocketClient";

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
   * The WebSocket URI this client connects to.
   */
  public static final String WEBSOCKET_URI_PROPERTY = "websocket-uri";

  /**
   * The SSL Context Service to use in order to secure the server. If specified, the server will accept only WSS requests; otherwise, the server will accept only WS requests
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "ssl-context-service";

  /**
   * The timeout to connect the WebSocket URI.
   */
  public static final String CONNECTION_TIMEOUT_PROPERTY = "connection-timeout";

  /**
   * The interval between session maintenance activities. A WebSocket session established with a WebSocket server can be terminated due to different reasons including restarting the WebSocket server or timing out inactive sessions. This session maintenance activity is periodically executed in order to reconnect those lost sessions, so that a WebSocket client can reuse the same session id transparently after it reconnects successfully.  The maintenance activity is executed until corresponding processors or this controller service is stopped.
   */
  public static final String SESSION_MAINTENANCE_INTERVAL_PROPERTY = "session-maintenance-interval";

  /**
   * The user name for Basic Authentication.
   */
  public static final String USER_NAME_PROPERTY = "user-name";

  /**
   * The user password for Basic Authentication.
   */
  public static final String USER_PASSWORD_PROPERTY = "user-password";

  /**
   * The charset for Basic Authentication header base64 string.
   */
  public static final String AUTHENTICATION_CHARSET_PROPERTY = "authentication-charset";

  private final Map<String, String> properties;

  public JettyWebSocketClient() {
    this.properties = new HashMap<>();
  }

  public JettyWebSocketClient(final Map<String, String> properties) {
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
  public final JettyWebSocketClient setInputBufferSize(final String inputBufferSize) {
    properties.put(INPUT_BUFFER_SIZE_PROPERTY, inputBufferSize);
    return this;
  }

  /**
   * The size of the input (read from network layer) buffer size.
   */
  public final JettyWebSocketClient removeInputBufferSize() {
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
  public final JettyWebSocketClient setMaxTextMessageSize(final String maxTextMessageSize) {
    properties.put(MAX_TEXT_MESSAGE_SIZE_PROPERTY, maxTextMessageSize);
    return this;
  }

  /**
   * The maximum size of a text message during parsing/generating.
   */
  public final JettyWebSocketClient removeMaxTextMessageSize() {
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
  public final JettyWebSocketClient setMaxBinaryMessageSize(final String maxBinaryMessageSize) {
    properties.put(MAX_BINARY_MESSAGE_SIZE_PROPERTY, maxBinaryMessageSize);
    return this;
  }

  /**
   * The maximum size of a binary message during parsing/generating.
   */
  public final JettyWebSocketClient removeMaxBinaryMessageSize() {
    properties.remove(MAX_BINARY_MESSAGE_SIZE_PROPERTY);
    return this;
  }

  /**
   * The WebSocket URI this client connects to.
   */
  public final String getWebsocketUri() {
    return properties.get(WEBSOCKET_URI_PROPERTY);
  }

  /**
   * The WebSocket URI this client connects to.
   */
  public final JettyWebSocketClient setWebsocketUri(final String websocketUri) {
    properties.put(WEBSOCKET_URI_PROPERTY, websocketUri);
    return this;
  }

  /**
   * The WebSocket URI this client connects to.
   */
  public final JettyWebSocketClient removeWebsocketUri() {
    properties.remove(WEBSOCKET_URI_PROPERTY);
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
  public final JettyWebSocketClient setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The SSL Context Service to use in order to secure the server. If specified, the server will accept only WSS requests; otherwise, the server will accept only WS requests
   */
  public final JettyWebSocketClient removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The timeout to connect the WebSocket URI.
   */
  public final String getConnectionTimeout() {
    return properties.get(CONNECTION_TIMEOUT_PROPERTY);
  }

  /**
   * The timeout to connect the WebSocket URI.
   */
  public final JettyWebSocketClient setConnectionTimeout(final String connectionTimeout) {
    properties.put(CONNECTION_TIMEOUT_PROPERTY, connectionTimeout);
    return this;
  }

  /**
   * The timeout to connect the WebSocket URI.
   */
  public final JettyWebSocketClient removeConnectionTimeout() {
    properties.remove(CONNECTION_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The interval between session maintenance activities. A WebSocket session established with a WebSocket server can be terminated due to different reasons including restarting the WebSocket server or timing out inactive sessions. This session maintenance activity is periodically executed in order to reconnect those lost sessions, so that a WebSocket client can reuse the same session id transparently after it reconnects successfully.  The maintenance activity is executed until corresponding processors or this controller service is stopped.
   */
  public final String getSessionMaintenanceInterval() {
    return properties.get(SESSION_MAINTENANCE_INTERVAL_PROPERTY);
  }

  /**
   * The interval between session maintenance activities. A WebSocket session established with a WebSocket server can be terminated due to different reasons including restarting the WebSocket server or timing out inactive sessions. This session maintenance activity is periodically executed in order to reconnect those lost sessions, so that a WebSocket client can reuse the same session id transparently after it reconnects successfully.  The maintenance activity is executed until corresponding processors or this controller service is stopped.
   */
  public final JettyWebSocketClient setSessionMaintenanceInterval(
      final String sessionMaintenanceInterval) {
    properties.put(SESSION_MAINTENANCE_INTERVAL_PROPERTY, sessionMaintenanceInterval);
    return this;
  }

  /**
   * The interval between session maintenance activities. A WebSocket session established with a WebSocket server can be terminated due to different reasons including restarting the WebSocket server or timing out inactive sessions. This session maintenance activity is periodically executed in order to reconnect those lost sessions, so that a WebSocket client can reuse the same session id transparently after it reconnects successfully.  The maintenance activity is executed until corresponding processors or this controller service is stopped.
   */
  public final JettyWebSocketClient removeSessionMaintenanceInterval() {
    properties.remove(SESSION_MAINTENANCE_INTERVAL_PROPERTY);
    return this;
  }

  /**
   * The user name for Basic Authentication.
   */
  public final String getUserName() {
    return properties.get(USER_NAME_PROPERTY);
  }

  /**
   * The user name for Basic Authentication.
   */
  public final JettyWebSocketClient setUserName(final String userName) {
    properties.put(USER_NAME_PROPERTY, userName);
    return this;
  }

  /**
   * The user name for Basic Authentication.
   */
  public final JettyWebSocketClient removeUserName() {
    properties.remove(USER_NAME_PROPERTY);
    return this;
  }

  /**
   * The user password for Basic Authentication.
   */
  public final String getUserPassword() {
    return properties.get(USER_PASSWORD_PROPERTY);
  }

  /**
   * The user password for Basic Authentication.
   */
  public final JettyWebSocketClient setUserPassword(final String userPassword) {
    properties.put(USER_PASSWORD_PROPERTY, userPassword);
    return this;
  }

  /**
   * The user password for Basic Authentication.
   */
  public final JettyWebSocketClient removeUserPassword() {
    properties.remove(USER_PASSWORD_PROPERTY);
    return this;
  }

  /**
   * The charset for Basic Authentication header base64 string.
   */
  public final String getAuthenticationCharset() {
    return properties.get(AUTHENTICATION_CHARSET_PROPERTY);
  }

  /**
   * The charset for Basic Authentication header base64 string.
   */
  public final JettyWebSocketClient setAuthenticationCharset(final String authenticationCharset) {
    properties.put(AUTHENTICATION_CHARSET_PROPERTY, authenticationCharset);
    return this;
  }

  /**
   * The charset for Basic Authentication header base64 string.
   */
  public final JettyWebSocketClient removeAuthenticationCharset() {
    properties.remove(AUTHENTICATION_CHARSET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final JettyWebSocketClient setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final JettyWebSocketClient removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<JettyWebSocketClient, JettyWebSocketClient> configurator) {
    return configurator.apply(new JettyWebSocketClient()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = JettyWebSocketClient.class) final Closure<JettyWebSocketClient> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.websocket.jetty.JettyWebSocketClient> code = closure.rehydrate(c, com.tibtech.nifi.websocket.jetty.JettyWebSocketClient.class, com.tibtech.nifi.websocket.jetty.JettyWebSocketClient.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<JettyWebSocketClient, JettyWebSocketClient> configurator) {
    return configurator.apply(new JettyWebSocketClient(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = JettyWebSocketClient.class) final Closure<JettyWebSocketClient> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.websocket.jetty.JettyWebSocketClient> code = closure.rehydrate(c, com.tibtech.nifi.websocket.jetty.JettyWebSocketClient.class, com.tibtech.nifi.websocket.jetty.JettyWebSocketClient.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
