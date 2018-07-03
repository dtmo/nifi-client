package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ListenHTTP {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ListenHTTP";

  /**
   * Base path for incoming connections
   */
  public static final String BASE_PATH_PROPERTY = "Base Path";

  /**
   * The Port to listen on for incoming connections
   */
  public static final String LISTENING_PORT_PROPERTY = "Listening Port";

  /**
   * The maximum amount of data to receive per second; this allows the bandwidth to be throttled to a specified data rate; if not specified, the data rate is not throttled
   */
  public static final String MAX_DATA_TO_RECEIVE_PER_SECOND_PROPERTY = "Max Data to Receive per Second";

  /**
   * The Controller Service to use in order to obtain an SSL Context
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  /**
   * A Regular Expression to apply against the Distinguished Name of incoming connections. If the Pattern does not match the DN, the connection will be refused.
   */
  public static final String AUTHORIZED_DN_PATTERN_PROPERTY = "Authorized DN Pattern";

  /**
   * The maximum amount of time to wait for a FlowFile to be confirmed before it is removed from the cache
   */
  public static final String MAX_UNCONFIRMED_FLOWFILE_TIME_PROPERTY = "Max Unconfirmed Flowfile Time";

  /**
   * Specifies the Regular Expression that determines the names of HTTP Headers that should be passed along as FlowFile attributes
   */
  public static final String HTTP_HEADERS_TO_RECEIVE_AS_ATTRIBUTES_REGEX_PROPERTY = "HTTP Headers to receive as Attributes (Regex)";

  /**
   * The HTTP return code returned after every HTTP call
   */
  public static final String RETURN_CODE_PROPERTY = "Return Code";

  private final Map<String, String> properties;

  public ListenHTTP() {
    this.properties = new HashMap<>();
  }

  public ListenHTTP(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Base path for incoming connections
   */
  public final String getBasePath() {
    return properties.get(BASE_PATH_PROPERTY);
  }

  /**
   * Base path for incoming connections
   */
  public final ListenHTTP setBasePath(final String basePath) {
    properties.put(BASE_PATH_PROPERTY, basePath);
    return this;
  }

  /**
   * Base path for incoming connections
   */
  public final ListenHTTP removeBasePath() {
    properties.remove(BASE_PATH_PROPERTY);
    return this;
  }

  /**
   * The Port to listen on for incoming connections
   */
  public final String getListeningPort() {
    return properties.get(LISTENING_PORT_PROPERTY);
  }

  /**
   * The Port to listen on for incoming connections
   */
  public final ListenHTTP setListeningPort(final String listeningPort) {
    properties.put(LISTENING_PORT_PROPERTY, listeningPort);
    return this;
  }

  /**
   * The Port to listen on for incoming connections
   */
  public final ListenHTTP removeListeningPort() {
    properties.remove(LISTENING_PORT_PROPERTY);
    return this;
  }

  /**
   * The maximum amount of data to receive per second; this allows the bandwidth to be throttled to a specified data rate; if not specified, the data rate is not throttled
   */
  public final String getMaxDataToReceivePerSecond() {
    return properties.get(MAX_DATA_TO_RECEIVE_PER_SECOND_PROPERTY);
  }

  /**
   * The maximum amount of data to receive per second; this allows the bandwidth to be throttled to a specified data rate; if not specified, the data rate is not throttled
   */
  public final ListenHTTP setMaxDataToReceivePerSecond(final String maxDataToReceivePerSecond) {
    properties.put(MAX_DATA_TO_RECEIVE_PER_SECOND_PROPERTY, maxDataToReceivePerSecond);
    return this;
  }

  /**
   * The maximum amount of data to receive per second; this allows the bandwidth to be throttled to a specified data rate; if not specified, the data rate is not throttled
   */
  public final ListenHTTP removeMaxDataToReceivePerSecond() {
    properties.remove(MAX_DATA_TO_RECEIVE_PER_SECOND_PROPERTY);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context
   */
  public final ListenHTTP setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context
   */
  public final ListenHTTP removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * A Regular Expression to apply against the Distinguished Name of incoming connections. If the Pattern does not match the DN, the connection will be refused.
   */
  public final String getAuthorizedDnPattern() {
    return properties.get(AUTHORIZED_DN_PATTERN_PROPERTY);
  }

  /**
   * A Regular Expression to apply against the Distinguished Name of incoming connections. If the Pattern does not match the DN, the connection will be refused.
   */
  public final ListenHTTP setAuthorizedDnPattern(final String authorizedDnPattern) {
    properties.put(AUTHORIZED_DN_PATTERN_PROPERTY, authorizedDnPattern);
    return this;
  }

  /**
   * A Regular Expression to apply against the Distinguished Name of incoming connections. If the Pattern does not match the DN, the connection will be refused.
   */
  public final ListenHTTP removeAuthorizedDnPattern() {
    properties.remove(AUTHORIZED_DN_PATTERN_PROPERTY);
    return this;
  }

  /**
   * The maximum amount of time to wait for a FlowFile to be confirmed before it is removed from the cache
   */
  public final String getMaxUnconfirmedFlowfileTime() {
    return properties.get(MAX_UNCONFIRMED_FLOWFILE_TIME_PROPERTY);
  }

  /**
   * The maximum amount of time to wait for a FlowFile to be confirmed before it is removed from the cache
   */
  public final ListenHTTP setMaxUnconfirmedFlowfileTime(final String maxUnconfirmedFlowfileTime) {
    properties.put(MAX_UNCONFIRMED_FLOWFILE_TIME_PROPERTY, maxUnconfirmedFlowfileTime);
    return this;
  }

  /**
   * The maximum amount of time to wait for a FlowFile to be confirmed before it is removed from the cache
   */
  public final ListenHTTP removeMaxUnconfirmedFlowfileTime() {
    properties.remove(MAX_UNCONFIRMED_FLOWFILE_TIME_PROPERTY);
    return this;
  }

  /**
   * Specifies the Regular Expression that determines the names of HTTP Headers that should be passed along as FlowFile attributes
   */
  public final String getHttpHeadersToReceiveAsAttributesRegex() {
    return properties.get(HTTP_HEADERS_TO_RECEIVE_AS_ATTRIBUTES_REGEX_PROPERTY);
  }

  /**
   * Specifies the Regular Expression that determines the names of HTTP Headers that should be passed along as FlowFile attributes
   */
  public final ListenHTTP setHttpHeadersToReceiveAsAttributesRegex(
      final String httpHeadersToReceiveAsAttributesRegex) {
    properties.put(HTTP_HEADERS_TO_RECEIVE_AS_ATTRIBUTES_REGEX_PROPERTY, httpHeadersToReceiveAsAttributesRegex);
    return this;
  }

  /**
   * Specifies the Regular Expression that determines the names of HTTP Headers that should be passed along as FlowFile attributes
   */
  public final ListenHTTP removeHttpHeadersToReceiveAsAttributesRegex() {
    properties.remove(HTTP_HEADERS_TO_RECEIVE_AS_ATTRIBUTES_REGEX_PROPERTY);
    return this;
  }

  /**
   * The HTTP return code returned after every HTTP call
   */
  public final String getReturnCode() {
    return properties.get(RETURN_CODE_PROPERTY);
  }

  /**
   * The HTTP return code returned after every HTTP call
   */
  public final ListenHTTP setReturnCode(final String returnCode) {
    properties.put(RETURN_CODE_PROPERTY, returnCode);
    return this;
  }

  /**
   * The HTTP return code returned after every HTTP call
   */
  public final ListenHTTP removeReturnCode() {
    properties.remove(RETURN_CODE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ListenHTTP setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ListenHTTP removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ListenHTTP, ListenHTTP> configurator) {
    return configurator.apply(new ListenHTTP()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListenHTTP.class) final Closure<ListenHTTP> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ListenHTTP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ListenHTTP.class, com.tibtech.nifi.processors.standard.ListenHTTP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ListenHTTP, ListenHTTP> configurator) {
    return configurator.apply(new ListenHTTP(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ListenHTTP.class) final Closure<ListenHTTP> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.ListenHTTP> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ListenHTTP.class, com.tibtech.nifi.processors.standard.ListenHTTP.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
