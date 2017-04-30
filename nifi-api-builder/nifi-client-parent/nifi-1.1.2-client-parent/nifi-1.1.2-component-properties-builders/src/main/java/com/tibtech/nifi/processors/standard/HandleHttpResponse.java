package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class HandleHttpResponse {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.HandleHttpResponse";

  /**
   * The HTTP Status Code to use when responding to the HTTP Request. See Section 10 of RFC 2616 for more information.
   */
  public static final String HTTP_STATUS_CODE_PROPERTY = "HTTP Status Code";

  /**
   * The HTTP Context Map Controller Service to use for caching the HTTP Request Information
   */
  public static final String HTTP_CONTEXT_MAP_PROPERTY = "HTTP Context Map";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The HTTP Status Code to use when responding to the HTTP Request. See Section 10 of RFC 2616 for more information.
   */
  public final String getHttpStatusCode() {
    return properties.get(HTTP_STATUS_CODE_PROPERTY);
  }

  /**
   * The HTTP Status Code to use when responding to the HTTP Request. See Section 10 of RFC 2616 for more information.
   */
  public final HandleHttpResponse setHttpStatusCode(final String httpStatusCode) {
    properties.put(HTTP_STATUS_CODE_PROPERTY, httpStatusCode);
    return this;
  }

  /**
   * The HTTP Status Code to use when responding to the HTTP Request. See Section 10 of RFC 2616 for more information.
   */
  public final HandleHttpResponse removeHttpStatusCode() {
    properties.remove(HTTP_STATUS_CODE_PROPERTY);
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
  public final HandleHttpResponse setHttpContextMap(final String httpContextMap) {
    properties.put(HTTP_CONTEXT_MAP_PROPERTY, httpContextMap);
    return this;
  }

  /**
   * The HTTP Context Map Controller Service to use for caching the HTTP Request Information
   */
  public final HandleHttpResponse removeHttpContextMap() {
    properties.remove(HTTP_CONTEXT_MAP_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final HandleHttpResponse setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final HandleHttpResponse removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<HandleHttpResponse, HandleHttpResponse> configurator) {
    return configurator.apply(new HandleHttpResponse()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = HandleHttpResponse.class) final Closure<HandleHttpResponse> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.HandleHttpResponse> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.HandleHttpResponse.class, com.tibtech.nifi.processors.standard.HandleHttpResponse.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
