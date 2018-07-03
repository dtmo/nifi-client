package com.tibtech.nifi.distributed.cache.client;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class DistributedMapCacheClientService {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.distributed.cache.client.DistributedMapCacheClientService";

  /**
   * The name of the server that is running the DistributedMapCacheServer service
   */
  public static final String SERVER_HOSTNAME_PROPERTY = "Server Hostname";

  /**
   * The port on the remote server that is to be used when communicating with the DistributedMapCacheServer service
   */
  public static final String SERVER_PORT_PROPERTY = "Server Port";

  /**
   * If specified, indicates the SSL Context Service that is used to communicate with the remote server. If not specified, communications will not be encrypted
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  /**
   * Specifies how long to wait when communicating with the remote server before determining that there is a communications failure if data cannot be sent or received
   */
  public static final String COMMUNICATIONS_TIMEOUT_PROPERTY = "Communications Timeout";

  private final Map<String, String> properties;

  public DistributedMapCacheClientService() {
    this.properties = new HashMap<>();
  }

  public DistributedMapCacheClientService(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The name of the server that is running the DistributedMapCacheServer service
   */
  public final String getServerHostname() {
    return properties.get(SERVER_HOSTNAME_PROPERTY);
  }

  /**
   * The name of the server that is running the DistributedMapCacheServer service
   */
  public final DistributedMapCacheClientService setServerHostname(final String serverHostname) {
    properties.put(SERVER_HOSTNAME_PROPERTY, serverHostname);
    return this;
  }

  /**
   * The name of the server that is running the DistributedMapCacheServer service
   */
  public final DistributedMapCacheClientService removeServerHostname() {
    properties.remove(SERVER_HOSTNAME_PROPERTY);
    return this;
  }

  /**
   * The port on the remote server that is to be used when communicating with the DistributedMapCacheServer service
   */
  public final String getServerPort() {
    return properties.get(SERVER_PORT_PROPERTY);
  }

  /**
   * The port on the remote server that is to be used when communicating with the DistributedMapCacheServer service
   */
  public final DistributedMapCacheClientService setServerPort(final String serverPort) {
    properties.put(SERVER_PORT_PROPERTY, serverPort);
    return this;
  }

  /**
   * The port on the remote server that is to be used when communicating with the DistributedMapCacheServer service
   */
  public final DistributedMapCacheClientService removeServerPort() {
    properties.remove(SERVER_PORT_PROPERTY);
    return this;
  }

  /**
   * If specified, indicates the SSL Context Service that is used to communicate with the remote server. If not specified, communications will not be encrypted
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * If specified, indicates the SSL Context Service that is used to communicate with the remote server. If not specified, communications will not be encrypted
   */
  public final DistributedMapCacheClientService setSslContextService(
      final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * If specified, indicates the SSL Context Service that is used to communicate with the remote server. If not specified, communications will not be encrypted
   */
  public final DistributedMapCacheClientService removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Specifies how long to wait when communicating with the remote server before determining that there is a communications failure if data cannot be sent or received
   */
  public final String getCommunicationsTimeout() {
    return properties.get(COMMUNICATIONS_TIMEOUT_PROPERTY);
  }

  /**
   * Specifies how long to wait when communicating with the remote server before determining that there is a communications failure if data cannot be sent or received
   */
  public final DistributedMapCacheClientService setCommunicationsTimeout(
      final String communicationsTimeout) {
    properties.put(COMMUNICATIONS_TIMEOUT_PROPERTY, communicationsTimeout);
    return this;
  }

  /**
   * Specifies how long to wait when communicating with the remote server before determining that there is a communications failure if data cannot be sent or received
   */
  public final DistributedMapCacheClientService removeCommunicationsTimeout() {
    properties.remove(COMMUNICATIONS_TIMEOUT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final DistributedMapCacheClientService setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final DistributedMapCacheClientService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<DistributedMapCacheClientService, DistributedMapCacheClientService> configurator) {
    return configurator.apply(new DistributedMapCacheClientService()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DistributedMapCacheClientService.class) final Closure<DistributedMapCacheClientService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.distributed.cache.client.DistributedMapCacheClientService> code = closure.rehydrate(c, com.tibtech.nifi.distributed.cache.client.DistributedMapCacheClientService.class, com.tibtech.nifi.distributed.cache.client.DistributedMapCacheClientService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<DistributedMapCacheClientService, DistributedMapCacheClientService> configurator) {
    return configurator.apply(new DistributedMapCacheClientService(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DistributedMapCacheClientService.class) final Closure<DistributedMapCacheClientService> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.distributed.cache.client.DistributedMapCacheClientService> code = closure.rehydrate(c, com.tibtech.nifi.distributed.cache.client.DistributedMapCacheClientService.class, com.tibtech.nifi.distributed.cache.client.DistributedMapCacheClientService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
