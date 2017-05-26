package com.tibtech.nifi.processors.websocket;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ConnectWebSocket {
  /**
   * A WebSocket CLIENT Controller Service which can connect to a WebSocket server.
   */
  public static final String WEBSOCKET_CLIENT_CONTROLLER_SERVICE_PROPERTY = "websocket-client-controller-service";

  /**
   * The client ID to identify WebSocket session. It should be unique within the WebSocket Client Controller Service. Otherwise, it throws WebSocketConfigurationException when it gets started.
   */
  public static final String WEBSOCKET_CLIENT_ID_PROPERTY = "websocket-client-id";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * A WebSocket CLIENT Controller Service which can connect to a WebSocket server.
   */
  public final String getWebsocketClientControllerService() {
    return properties.get(WEBSOCKET_CLIENT_CONTROLLER_SERVICE_PROPERTY);
  }

  /**
   * A WebSocket CLIENT Controller Service which can connect to a WebSocket server.
   */
  public final ConnectWebSocket setWebsocketClientControllerService(final String websocketClientControllerService) {
    properties.put(WEBSOCKET_CLIENT_CONTROLLER_SERVICE_PROPERTY, websocketClientControllerService);
    return this;
  }

  /**
   * A WebSocket CLIENT Controller Service which can connect to a WebSocket server.
   */
  public final ConnectWebSocket removeWebsocketClientControllerService() {
    properties.remove(WEBSOCKET_CLIENT_CONTROLLER_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The client ID to identify WebSocket session. It should be unique within the WebSocket Client Controller Service. Otherwise, it throws WebSocketConfigurationException when it gets started.
   */
  public final String getWebsocketClientId() {
    return properties.get(WEBSOCKET_CLIENT_ID_PROPERTY);
  }

  /**
   * The client ID to identify WebSocket session. It should be unique within the WebSocket Client Controller Service. Otherwise, it throws WebSocketConfigurationException when it gets started.
   */
  public final ConnectWebSocket setWebsocketClientId(final String websocketClientId) {
    properties.put(WEBSOCKET_CLIENT_ID_PROPERTY, websocketClientId);
    return this;
  }

  /**
   * The client ID to identify WebSocket session. It should be unique within the WebSocket Client Controller Service. Otherwise, it throws WebSocketConfigurationException when it gets started.
   */
  public final ConnectWebSocket removeWebsocketClientId() {
    properties.remove(WEBSOCKET_CLIENT_ID_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ConnectWebSocket setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ConnectWebSocket removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ConnectWebSocket, ConnectWebSocket> configurator) {
    return configurator.apply(new ConnectWebSocket()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConnectWebSocket.class) final Closure<ConnectWebSocket> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.websocket.ConnectWebSocket> code = closure.rehydrate(c, com.tibtech.nifi.processors.websocket.ConnectWebSocket.class, com.tibtech.nifi.processors.websocket.ConnectWebSocket.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
