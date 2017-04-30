package com.tibtech.nifi.http;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class StandardHttpContextMap {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.http.StandardHttpContextMap";

  /**
   * The maximum number of HTTP requests that can be outstanding at any one time. Any attempt to register an additional HTTP Request will cause an error
   */
  public static final String MAXIMUM_OUTSTANDING_REQUESTS_PROPERTY = "Maximum Outstanding Requests";

  /**
   * Specifies how long an HTTP Request should be left unanswered before being evicted from the cache and being responded to with a Service Unavailable status code
   */
  public static final String REQUEST_EXPIRATION_PROPERTY = "Request Expiration";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The maximum number of HTTP requests that can be outstanding at any one time. Any attempt to register an additional HTTP Request will cause an error
   */
  public final String getMaximumOutstandingRequests() {
    return properties.get(MAXIMUM_OUTSTANDING_REQUESTS_PROPERTY);
  }

  /**
   * The maximum number of HTTP requests that can be outstanding at any one time. Any attempt to register an additional HTTP Request will cause an error
   */
  public final StandardHttpContextMap setMaximumOutstandingRequests(final String maximumOutstandingRequests) {
    properties.put(MAXIMUM_OUTSTANDING_REQUESTS_PROPERTY, maximumOutstandingRequests);
    return this;
  }

  /**
   * The maximum number of HTTP requests that can be outstanding at any one time. Any attempt to register an additional HTTP Request will cause an error
   */
  public final StandardHttpContextMap removeMaximumOutstandingRequests() {
    properties.remove(MAXIMUM_OUTSTANDING_REQUESTS_PROPERTY);
    return this;
  }

  /**
   * Specifies how long an HTTP Request should be left unanswered before being evicted from the cache and being responded to with a Service Unavailable status code
   */
  public final String getRequestExpiration() {
    return properties.get(REQUEST_EXPIRATION_PROPERTY);
  }

  /**
   * Specifies how long an HTTP Request should be left unanswered before being evicted from the cache and being responded to with a Service Unavailable status code
   */
  public final StandardHttpContextMap setRequestExpiration(final String requestExpiration) {
    properties.put(REQUEST_EXPIRATION_PROPERTY, requestExpiration);
    return this;
  }

  /**
   * Specifies how long an HTTP Request should be left unanswered before being evicted from the cache and being responded to with a Service Unavailable status code
   */
  public final StandardHttpContextMap removeRequestExpiration() {
    properties.remove(REQUEST_EXPIRATION_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final StandardHttpContextMap setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final StandardHttpContextMap removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<StandardHttpContextMap, StandardHttpContextMap> configurator) {
    return configurator.apply(new StandardHttpContextMap()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = StandardHttpContextMap.class) final Closure<StandardHttpContextMap> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.http.StandardHttpContextMap> code = closure.rehydrate(c, com.tibtech.nifi.http.StandardHttpContextMap.class, com.tibtech.nifi.http.StandardHttpContextMap.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
