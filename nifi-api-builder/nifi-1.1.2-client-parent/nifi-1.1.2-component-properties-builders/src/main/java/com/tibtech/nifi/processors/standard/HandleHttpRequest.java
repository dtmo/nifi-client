package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class HandleHttpRequest {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.HandleHttpRequest";

  /**
   * The Port to listen on for incoming HTTP requests
   */
  public static final String LISTENING_PORT_PROPERTY = "Listening Port";

  /**
   * The Hostname to bind to. If not specified, will bind to all hosts
   */
  public static final String HOSTNAME_PROPERTY = "Hostname";

  /**
   * The SSL Context Service to use in order to secure the server. If specified, the server will accept only HTTPS requests; otherwise, the server will accept only HTTP requests
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  /**
   * The HTTP Context Map Controller Service to use for caching the HTTP Request Information
   */
  public static final String HTTP_CONTEXT_MAP_PROPERTY = "HTTP Context Map";

  /**
   * A Regular Expression that specifies the valid HTTP Paths that are allowed in the incoming URL Requests. If this value is specified and the path of the HTTP Requests does not match this Regular Expression, the Processor will respond with a 404: NotFound
   */
  public static final String ALLOWED_PATHS_PROPERTY = "Allowed Paths";

  /**
   * The character set to use for decoding URL parameters if the HTTP Request does not supply one
   */
  public static final String DEFAULT_URL_CHARACTER_SET_PROPERTY = "Default URL Character Set";

  /**
   * Allow HTTP GET Method
   */
  public static final String ALLOW_GET_PROPERTY = "Allow GET";

  /**
   * Allow HTTP POST Method
   */
  public static final String ALLOW_POST_PROPERTY = "Allow POST";

  /**
   * Allow HTTP PUT Method
   */
  public static final String ALLOW_PUT_PROPERTY = "Allow PUT";

  /**
   * Allow HTTP DELETE Method
   */
  public static final String ALLOW_DELETE_PROPERTY = "Allow DELETE";

  /**
   * Allow HTTP HEAD Method
   */
  public static final String ALLOW_HEAD_PROPERTY = "Allow HEAD";

  /**
   * Allow HTTP OPTIONS Method
   */
  public static final String ALLOW_OPTIONS_PROPERTY = "Allow OPTIONS";

  /**
   * A comma-separated list of non-standard HTTP Methods that should be allowed
   */
  public static final String ADDITIONAL_HTTP_METHODS_PROPERTY = "Additional HTTP Methods";

  /**
   * Specifies whether or not the Processor should authenticate clients. This value is ignored if the <SSL Context Service> Property is not specified or the SSL Context provided uses only a KeyStore and not a TrustStore.
   */
  public static final String CLIENT_AUTHENTICATION_PROPERTY = "Client Authentication";

  /**
   * The size of the queue for Http Request Containers
   */
  public static final String CONTAINER_QUEUE_SIZE_PROPERTY = "container-queue-size";

  private final Map<String, String> properties;

  public HandleHttpRequest() {
    this.properties = new HashMap<>();
  }

  public HandleHttpRequest(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The Port to listen on for incoming HTTP requests
   */
  public final String getListeningPort() {
    return properties.get(LISTENING_PORT_PROPERTY);
  }

  /**
   * The Port to listen on for incoming HTTP requests
   */
  public final HandleHttpRequest setListeningPort(final String listeningPort) {
    properties.put(LISTENING_PORT_PROPERTY, listeningPort);
    return this;
  }

  /**
   * The Port to listen on for incoming HTTP requests
   */
  public final HandleHttpRequest removeListeningPort() {
    properties.remove(LISTENING_PORT_PROPERTY);
    return this;
  }

  /**
   * The Hostname to bind to. If not specified, will bind to all hosts
   */
  public final String getHostname() {
    return properties.get(HOSTNAME_PROPERTY);
  }

  /**
   * The Hostname to bind to. If not specified, will bind to all hosts
   */
  public final HandleHttpRequest setHostname(final String hostname) {
    properties.put(HOSTNAME_PROPERTY, hostname);
    return this;
  }

  /**
   * The Hostname to bind to. If not specified, will bind to all hosts
   */
  public final HandleHttpRequest removeHostname() {
    properties.remove(HOSTNAME_PROPERTY);
    return this;
  }

  /**
   * The SSL Context Service to use in order to secure the server. If specified, the server will accept only HTTPS requests; otherwise, the server will accept only HTTP requests
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * The SSL Context Service to use in order to secure the server. If specified, the server will accept only HTTPS requests; otherwise, the server will accept only HTTP requests
   */
  public final HandleHttpRequest setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The SSL Context Service to use in order to secure the server. If specified, the server will accept only HTTPS requests; otherwise, the server will accept only HTTP requests
   */
  public final HandleHttpRequest removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The HTTP Context Map Controller Service to use for caching the HTTP Request Information
   */
  public final String getHttpContextMap() {
    return properties.get(HTTP_CONTEXT_MAP_PROPERTY);
  }

  /**
   * The HTTP Context Map Controller Service to use for caching the HTTP Request Information
   */
  public final HandleHttpRequest setHttpContextMap(final String httpContextMap) {
    properties.put(HTTP_CONTEXT_MAP_PROPERTY, httpContextMap);
    return this;
  }

  /**
   * The HTTP Context Map Controller Service to use for caching the HTTP Request Information
   */
  public final HandleHttpRequest removeHttpContextMap() {
    properties.remove(HTTP_CONTEXT_MAP_PROPERTY);
    return this;
  }

  /**
   * A Regular Expression that specifies the valid HTTP Paths that are allowed in the incoming URL Requests. If this value is specified and the path of the HTTP Requests does not match this Regular Expression, the Processor will respond with a 404: NotFound
   */
  public final String getAllowedPaths() {
    return properties.get(ALLOWED_PATHS_PROPERTY);
  }

  /**
   * A Regular Expression that specifies the valid HTTP Paths that are allowed in the incoming URL Requests. If this value is specified and the path of the HTTP Requests does not match this Regular Expression, the Processor will respond with a 404: NotFound
   */
  public final HandleHttpRequest setAllowedPaths(final String allowedPaths) {
    properties.put(ALLOWED_PATHS_PROPERTY, allowedPaths);
    return this;
  }

  /**
   * A Regular Expression that specifies the valid HTTP Paths that are allowed in the incoming URL Requests. If this value is specified and the path of the HTTP Requests does not match this Regular Expression, the Processor will respond with a 404: NotFound
   */
  public final HandleHttpRequest removeAllowedPaths() {
    properties.remove(ALLOWED_PATHS_PROPERTY);
    return this;
  }

  /**
   * The character set to use for decoding URL parameters if the HTTP Request does not supply one
   */
  public final String getDefaultUrlCharacterSet() {
    return properties.get(DEFAULT_URL_CHARACTER_SET_PROPERTY);
  }

  /**
   * The character set to use for decoding URL parameters if the HTTP Request does not supply one
   */
  public final HandleHttpRequest setDefaultUrlCharacterSet(final String defaultUrlCharacterSet) {
    properties.put(DEFAULT_URL_CHARACTER_SET_PROPERTY, defaultUrlCharacterSet);
    return this;
  }

  /**
   * The character set to use for decoding URL parameters if the HTTP Request does not supply one
   */
  public final HandleHttpRequest removeDefaultUrlCharacterSet() {
    properties.remove(DEFAULT_URL_CHARACTER_SET_PROPERTY);
    return this;
  }

  /**
   * Allow HTTP GET Method
   */
  public final String getAllowGet() {
    return properties.get(ALLOW_GET_PROPERTY);
  }

  /**
   * Allow HTTP GET Method
   */
  public final HandleHttpRequest setAllowGet(final String allowGet) {
    properties.put(ALLOW_GET_PROPERTY, allowGet);
    return this;
  }

  /**
   * Allow HTTP GET Method
   */
  public final HandleHttpRequest removeAllowGet() {
    properties.remove(ALLOW_GET_PROPERTY);
    return this;
  }

  /**
   * Allow HTTP POST Method
   */
  public final String getAllowPost() {
    return properties.get(ALLOW_POST_PROPERTY);
  }

  /**
   * Allow HTTP POST Method
   */
  public final HandleHttpRequest setAllowPost(final String allowPost) {
    properties.put(ALLOW_POST_PROPERTY, allowPost);
    return this;
  }

  /**
   * Allow HTTP POST Method
   */
  public final HandleHttpRequest removeAllowPost() {
    properties.remove(ALLOW_POST_PROPERTY);
    return this;
  }

  /**
   * Allow HTTP PUT Method
   */
  public final String getAllowPut() {
    return properties.get(ALLOW_PUT_PROPERTY);
  }

  /**
   * Allow HTTP PUT Method
   */
  public final HandleHttpRequest setAllowPut(final String allowPut) {
    properties.put(ALLOW_PUT_PROPERTY, allowPut);
    return this;
  }

  /**
   * Allow HTTP PUT Method
   */
  public final HandleHttpRequest removeAllowPut() {
    properties.remove(ALLOW_PUT_PROPERTY);
    return this;
  }

  /**
   * Allow HTTP DELETE Method
   */
  public final String getAllowDelete() {
    return properties.get(ALLOW_DELETE_PROPERTY);
  }

  /**
   * Allow HTTP DELETE Method
   */
  public final HandleHttpRequest setAllowDelete(final String allowDelete) {
    properties.put(ALLOW_DELETE_PROPERTY, allowDelete);
    return this;
  }

  /**
   * Allow HTTP DELETE Method
   */
  public final HandleHttpRequest removeAllowDelete() {
    properties.remove(ALLOW_DELETE_PROPERTY);
    return this;
  }

  /**
   * Allow HTTP HEAD Method
   */
  public final String getAllowHead() {
    return properties.get(ALLOW_HEAD_PROPERTY);
  }

  /**
   * Allow HTTP HEAD Method
   */
  public final HandleHttpRequest setAllowHead(final String allowHead) {
    properties.put(ALLOW_HEAD_PROPERTY, allowHead);
    return this;
  }

  /**
   * Allow HTTP HEAD Method
   */
  public final HandleHttpRequest removeAllowHead() {
    properties.remove(ALLOW_HEAD_PROPERTY);
    return this;
  }

  /**
   * Allow HTTP OPTIONS Method
   */
  public final String getAllowOptions() {
    return properties.get(ALLOW_OPTIONS_PROPERTY);
  }

  /**
   * Allow HTTP OPTIONS Method
   */
  public final HandleHttpRequest setAllowOptions(final String allowOptions) {
    properties.put(ALLOW_OPTIONS_PROPERTY, allowOptions);
    return this;
  }

  /**
   * Allow HTTP OPTIONS Method
   */
  public final HandleHttpRequest removeAllowOptions() {
    properties.remove(ALLOW_OPTIONS_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of non-standard HTTP Methods that should be allowed
   */
  public final String getAdditionalHttpMethods() {
    return properties.get(ADDITIONAL_HTTP_METHODS_PROPERTY);
  }

  /**
   * A comma-separated list of non-standard HTTP Methods that should be allowed
   */
  public final HandleHttpRequest setAdditionalHttpMethods(final String additionalHttpMethods) {
    properties.put(ADDITIONAL_HTTP_METHODS_PROPERTY, additionalHttpMethods);
    return this;
  }

  /**
   * A comma-separated list of non-standard HTTP Methods that should be allowed
   */
  public final HandleHttpRequest removeAdditionalHttpMethods() {
    properties.remove(ADDITIONAL_HTTP_METHODS_PROPERTY);
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
  public final HandleHttpRequest setClientAuthentication(final String clientAuthentication) {
    properties.put(CLIENT_AUTHENTICATION_PROPERTY, clientAuthentication);
    return this;
  }

  /**
   * Specifies whether or not the Processor should authenticate clients. This value is ignored if the <SSL Context Service> Property is not specified or the SSL Context provided uses only a KeyStore and not a TrustStore.
   */
  public final HandleHttpRequest removeClientAuthentication() {
    properties.remove(CLIENT_AUTHENTICATION_PROPERTY);
    return this;
  }

  /**
   * The size of the queue for Http Request Containers
   */
  public final String getContainerQueueSize() {
    return properties.get(CONTAINER_QUEUE_SIZE_PROPERTY);
  }

  /**
   * The size of the queue for Http Request Containers
   */
  public final HandleHttpRequest setContainerQueueSize(final String containerQueueSize) {
    properties.put(CONTAINER_QUEUE_SIZE_PROPERTY, containerQueueSize);
    return this;
  }

  /**
   * The size of the queue for Http Request Containers
   */
  public final HandleHttpRequest removeContainerQueueSize() {
    properties.remove(CONTAINER_QUEUE_SIZE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final HandleHttpRequest setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final HandleHttpRequest removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<HandleHttpRequest, HandleHttpRequest> configurator) {
    return configurator.apply(new HandleHttpRequest()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = HandleHttpRequest.class) final Closure<HandleHttpRequest> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.HandleHttpRequest> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.HandleHttpRequest.class, com.tibtech.nifi.processors.standard.HandleHttpRequest.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<HandleHttpRequest, HandleHttpRequest> configurator) {
    return configurator.apply(new HandleHttpRequest(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = HandleHttpRequest.class) final Closure<HandleHttpRequest> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.HandleHttpRequest> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.HandleHttpRequest.class, com.tibtech.nifi.processors.standard.HandleHttpRequest.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
