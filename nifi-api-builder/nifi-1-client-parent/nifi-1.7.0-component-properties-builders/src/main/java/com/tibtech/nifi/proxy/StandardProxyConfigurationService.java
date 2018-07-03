package com.tibtech.nifi.proxy;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class StandardProxyConfigurationService {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.proxy.StandardProxyConfigurationService";

  /**
   * Proxy type.
   */
  public static final String PROXY_TYPE_PROPERTY = "proxy-type";

  /**
   * Proxy server hostname or ip-address.
   */
  public static final String PROXY_SERVER_HOST_PROPERTY = "proxy-server-host";

  /**
   * Proxy server port number.
   */
  public static final String PROXY_SERVER_PORT_PROPERTY = "proxy-server-port";

  /**
   * The name of the proxy client for user authentication.
   */
  public static final String PROXY_USER_NAME_PROPERTY = "proxy-user-name";

  /**
   * The password of the proxy client for user authentication.
   */
  public static final String PROXY_USER_PASSWORD_PROPERTY = "proxy-user-password";

  private final Map<String, String> properties;

  public StandardProxyConfigurationService() {
    this.properties = new HashMap<>();
  }

  public StandardProxyConfigurationService(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Proxy type.
   */
  public final String getProxyType() {
    return properties.get(PROXY_TYPE_PROPERTY);
  }

  /**
   * Proxy type.
   */
  public final StandardProxyConfigurationService setProxyType(final String proxyType) {
    properties.put(PROXY_TYPE_PROPERTY, proxyType);
    return this;
  }

  /**
   * Proxy type.
   */
  public final StandardProxyConfigurationService removeProxyType() {
    properties.remove(PROXY_TYPE_PROPERTY);
    return this;
  }

  /**
   * Proxy server hostname or ip-address.
   */
  public final String getProxyServerHost() {
    return properties.get(PROXY_SERVER_HOST_PROPERTY);
  }

  /**
   * Proxy server hostname or ip-address.
   */
  public final StandardProxyConfigurationService setProxyServerHost(final String proxyServerHost) {
    properties.put(PROXY_SERVER_HOST_PROPERTY, proxyServerHost);
    return this;
  }

  /**
   * Proxy server hostname or ip-address.
   */
  public final StandardProxyConfigurationService removeProxyServerHost() {
    properties.remove(PROXY_SERVER_HOST_PROPERTY);
    return this;
  }

  /**
   * Proxy server port number.
   */
  public final String getProxyServerPort() {
    return properties.get(PROXY_SERVER_PORT_PROPERTY);
  }

  /**
   * Proxy server port number.
   */
  public final StandardProxyConfigurationService setProxyServerPort(final String proxyServerPort) {
    properties.put(PROXY_SERVER_PORT_PROPERTY, proxyServerPort);
    return this;
  }

  /**
   * Proxy server port number.
   */
  public final StandardProxyConfigurationService removeProxyServerPort() {
    properties.remove(PROXY_SERVER_PORT_PROPERTY);
    return this;
  }

  /**
   * The name of the proxy client for user authentication.
   */
  public final String getProxyUserName() {
    return properties.get(PROXY_USER_NAME_PROPERTY);
  }

  /**
   * The name of the proxy client for user authentication.
   */
  public final StandardProxyConfigurationService setProxyUserName(final String proxyUserName) {
    properties.put(PROXY_USER_NAME_PROPERTY, proxyUserName);
    return this;
  }

  /**
   * The name of the proxy client for user authentication.
   */
  public final StandardProxyConfigurationService removeProxyUserName() {
    properties.remove(PROXY_USER_NAME_PROPERTY);
    return this;
  }

  /**
   * The password of the proxy client for user authentication.
   */
  public final String getProxyUserPassword() {
    return properties.get(PROXY_USER_PASSWORD_PROPERTY);
  }

  /**
   * The password of the proxy client for user authentication.
   */
  public final StandardProxyConfigurationService setProxyUserPassword(
      final String proxyUserPassword) {
    properties.put(PROXY_USER_PASSWORD_PROPERTY, proxyUserPassword);
    return this;
  }

  /**
   * The password of the proxy client for user authentication.
   */
  public final StandardProxyConfigurationService removeProxyUserPassword() {
    properties.remove(PROXY_USER_PASSWORD_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final StandardProxyConfigurationService setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final StandardProxyConfigurationService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<StandardProxyConfigurationService, StandardProxyConfigurationService> configurator) {
    return configurator.apply(new StandardProxyConfigurationService()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = StandardProxyConfigurationService.class) final Closure<StandardProxyConfigurationService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.proxy.StandardProxyConfigurationService> code = closure.rehydrate(c, com.tibtech.nifi.proxy.StandardProxyConfigurationService.class, com.tibtech.nifi.proxy.StandardProxyConfigurationService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<StandardProxyConfigurationService, StandardProxyConfigurationService> configurator) {
    return configurator.apply(new StandardProxyConfigurationService(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = StandardProxyConfigurationService.class) final Closure<StandardProxyConfigurationService> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.proxy.StandardProxyConfigurationService> code = closure.rehydrate(c, com.tibtech.nifi.proxy.StandardProxyConfigurationService.class, com.tibtech.nifi.proxy.StandardProxyConfigurationService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
