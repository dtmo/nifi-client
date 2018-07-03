package com.tibtech.nifi.processors.websocket;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutWebSocket {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.websocket.PutWebSocket";

  /**
   * A NiFi Expression to retrieve the session id. If not specified, a message will be sent to all connected WebSocket peers for the WebSocket controller service endpoint.
   */
  public static final String WEBSOCKET_SESSION_ID_PROPERTY = "websocket-session-id";

  /**
   * A NiFi Expression to retrieve the id of a WebSocket ControllerService.
   */
  public static final String WEBSOCKET_CONTROLLER_SERVICE_ID_PROPERTY = "websocket-controller-service-id";

  /**
   * A NiFi Expression to retrieve the endpoint id of a WebSocket ControllerService.
   */
  public static final String WEBSOCKET_ENDPOINT_ID_PROPERTY = "websocket-endpoint-id";

  /**
   * The type of message content: TEXT or BINARY
   */
  public static final String WEBSOCKET_MESSAGE_TYPE_PROPERTY = "websocket-message-type";

  private final Map<String, String> properties;

  public PutWebSocket() {
    this.properties = new HashMap<>();
  }

  public PutWebSocket(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * A NiFi Expression to retrieve the session id. If not specified, a message will be sent to all connected WebSocket peers for the WebSocket controller service endpoint.
   */
  public final String getWebsocketSessionId() {
    return properties.get(WEBSOCKET_SESSION_ID_PROPERTY);
  }

  /**
   * A NiFi Expression to retrieve the session id. If not specified, a message will be sent to all connected WebSocket peers for the WebSocket controller service endpoint.
   */
  public final PutWebSocket setWebsocketSessionId(final String websocketSessionId) {
    properties.put(WEBSOCKET_SESSION_ID_PROPERTY, websocketSessionId);
    return this;
  }

  /**
   * A NiFi Expression to retrieve the session id. If not specified, a message will be sent to all connected WebSocket peers for the WebSocket controller service endpoint.
   */
  public final PutWebSocket removeWebsocketSessionId() {
    properties.remove(WEBSOCKET_SESSION_ID_PROPERTY);
    return this;
  }

  /**
   * A NiFi Expression to retrieve the id of a WebSocket ControllerService.
   */
  public final String getWebsocketControllerServiceId() {
    return properties.get(WEBSOCKET_CONTROLLER_SERVICE_ID_PROPERTY);
  }

  /**
   * A NiFi Expression to retrieve the id of a WebSocket ControllerService.
   */
  public final PutWebSocket setWebsocketControllerServiceId(
      final String websocketControllerServiceId) {
    properties.put(WEBSOCKET_CONTROLLER_SERVICE_ID_PROPERTY, websocketControllerServiceId);
    return this;
  }

  /**
   * A NiFi Expression to retrieve the id of a WebSocket ControllerService.
   */
  public final PutWebSocket removeWebsocketControllerServiceId() {
    properties.remove(WEBSOCKET_CONTROLLER_SERVICE_ID_PROPERTY);
    return this;
  }

  /**
   * A NiFi Expression to retrieve the endpoint id of a WebSocket ControllerService.
   */
  public final String getWebsocketEndpointId() {
    return properties.get(WEBSOCKET_ENDPOINT_ID_PROPERTY);
  }

  /**
   * A NiFi Expression to retrieve the endpoint id of a WebSocket ControllerService.
   */
  public final PutWebSocket setWebsocketEndpointId(final String websocketEndpointId) {
    properties.put(WEBSOCKET_ENDPOINT_ID_PROPERTY, websocketEndpointId);
    return this;
  }

  /**
   * A NiFi Expression to retrieve the endpoint id of a WebSocket ControllerService.
   */
  public final PutWebSocket removeWebsocketEndpointId() {
    properties.remove(WEBSOCKET_ENDPOINT_ID_PROPERTY);
    return this;
  }

  /**
   * The type of message content: TEXT or BINARY
   */
  public final String getWebsocketMessageType() {
    return properties.get(WEBSOCKET_MESSAGE_TYPE_PROPERTY);
  }

  /**
   * The type of message content: TEXT or BINARY
   */
  public final PutWebSocket setWebsocketMessageType(final String websocketMessageType) {
    properties.put(WEBSOCKET_MESSAGE_TYPE_PROPERTY, websocketMessageType);
    return this;
  }

  /**
   * The type of message content: TEXT or BINARY
   */
  public final PutWebSocket removeWebsocketMessageType() {
    properties.remove(WEBSOCKET_MESSAGE_TYPE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutWebSocket setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutWebSocket removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<PutWebSocket, PutWebSocket> configurator) {
    return configurator.apply(new PutWebSocket()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutWebSocket.class) final Closure<PutWebSocket> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.websocket.PutWebSocket> code = closure.rehydrate(c, com.tibtech.nifi.processors.websocket.PutWebSocket.class, com.tibtech.nifi.processors.websocket.PutWebSocket.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutWebSocket, PutWebSocket> configurator) {
    return configurator.apply(new PutWebSocket(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutWebSocket.class) final Closure<PutWebSocket> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.websocket.PutWebSocket> code = closure.rehydrate(c, com.tibtech.nifi.processors.websocket.PutWebSocket.class, com.tibtech.nifi.processors.websocket.PutWebSocket.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
