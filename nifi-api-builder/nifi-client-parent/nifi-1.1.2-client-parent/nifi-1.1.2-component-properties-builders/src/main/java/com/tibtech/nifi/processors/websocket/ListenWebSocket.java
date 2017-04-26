package com.tibtech.nifi.processors.websocket;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ListenWebSocket {
  /**
   * A WebSocket SERVER Controller Service which can accept WebSocket requests.
   */
  public static final String WEBSOCKET_SERVER_CONTROLLER_SERVICE_PROPERTY = "websocket-server-controller-service";

  /**
   * The WetSocket URL Path on which this processor listens to. Must starts with '/', e.g. '/example'.
   */
  public static final String SERVER_URL_PATH_PROPERTY = "server-url-path";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * A WebSocket SERVER Controller Service which can accept WebSocket requests.
   */
  public final String getWebsocketServerControllerService() {
    return properties.get(WEBSOCKET_SERVER_CONTROLLER_SERVICE_PROPERTY);
  }

  /**
   * A WebSocket SERVER Controller Service which can accept WebSocket requests.
   */
  public final ListenWebSocket setWebsocketServerControllerService(final String websocketServerControllerService) {
    properties.put(WEBSOCKET_SERVER_CONTROLLER_SERVICE_PROPERTY, websocketServerControllerService);
    return this;
  }

  /**
   * A WebSocket SERVER Controller Service which can accept WebSocket requests.
   */
  public final ListenWebSocket removeWebsocketServerControllerService() {
    properties.remove(WEBSOCKET_SERVER_CONTROLLER_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The WetSocket URL Path on which this processor listens to. Must starts with '/', e.g. '/example'.
   */
  public final String getServerUrlPath() {
    return properties.get(SERVER_URL_PATH_PROPERTY);
  }

  /**
   * The WetSocket URL Path on which this processor listens to. Must starts with '/', e.g. '/example'.
   */
  public final ListenWebSocket setServerUrlPath(final String serverUrlPath) {
    properties.put(SERVER_URL_PATH_PROPERTY, serverUrlPath);
    return this;
  }

  /**
   * The WetSocket URL Path on which this processor listens to. Must starts with '/', e.g. '/example'.
   */
  public final ListenWebSocket removeServerUrlPath() {
    properties.remove(SERVER_URL_PATH_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ListenWebSocket setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ListenWebSocket removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ListenWebSocket, ListenWebSocket> configurator) {
    return configurator.apply(new ListenWebSocket()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListenWebSocket.class) final Closure<ListenWebSocket> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.websocket.ListenWebSocket> code = closure.rehydrate(c, com.tibtech.nifi.processors.websocket.ListenWebSocket.class, com.tibtech.nifi.processors.websocket.ListenWebSocket.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
