package com.tibtech.nifi.distributed.cache.server.map;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class DistributedMapCacheServer {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.distributed.cache.server.map.DistributedMapCacheServer";

  /**
   * The port to listen on for incoming connections
   */
  public static final String PORT_PROPERTY = "Port";

  /**
   * The maximum number of cache entries that the cache can hold
   */
  public static final String MAXIMUM_CACHE_ENTRIES_PROPERTY = "Maximum Cache Entries";

  /**
   * Determines which strategy should be used to evict values from the cache to make room for new entries
   */
  public static final String EVICTION_STRATEGY_PROPERTY = "Eviction Strategy";

  /**
   * If specified, the cache will be persisted in the given directory; if not specified, the cache will be in-memory only
   */
  public static final String PERSISTENCE_DIRECTORY_PROPERTY = "Persistence Directory";

  /**
   * If specified, this service will be used to create an SSL Context that will be used to secure communications; if not specified, communications will not be secure
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  private final Map<String, String> properties;

  public DistributedMapCacheServer() {
    this.properties = new HashMap<>();
  }

  public DistributedMapCacheServer(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The port to listen on for incoming connections
   */
  public final String getPort() {
    return properties.get(PORT_PROPERTY);
  }

  /**
   * The port to listen on for incoming connections
   */
  public final DistributedMapCacheServer setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * The port to listen on for incoming connections
   */
  public final DistributedMapCacheServer removePort() {
    properties.remove(PORT_PROPERTY);
    return this;
  }

  /**
   * The maximum number of cache entries that the cache can hold
   */
  public final String getMaximumCacheEntries() {
    return properties.get(MAXIMUM_CACHE_ENTRIES_PROPERTY);
  }

  /**
   * The maximum number of cache entries that the cache can hold
   */
  public final DistributedMapCacheServer setMaximumCacheEntries(final String maximumCacheEntries) {
    properties.put(MAXIMUM_CACHE_ENTRIES_PROPERTY, maximumCacheEntries);
    return this;
  }

  /**
   * The maximum number of cache entries that the cache can hold
   */
  public final DistributedMapCacheServer removeMaximumCacheEntries() {
    properties.remove(MAXIMUM_CACHE_ENTRIES_PROPERTY);
    return this;
  }

  /**
   * Determines which strategy should be used to evict values from the cache to make room for new entries
   */
  public final String getEvictionStrategy() {
    return properties.get(EVICTION_STRATEGY_PROPERTY);
  }

  /**
   * Determines which strategy should be used to evict values from the cache to make room for new entries
   */
  public final DistributedMapCacheServer setEvictionStrategy(final String evictionStrategy) {
    properties.put(EVICTION_STRATEGY_PROPERTY, evictionStrategy);
    return this;
  }

  /**
   * Determines which strategy should be used to evict values from the cache to make room for new entries
   */
  public final DistributedMapCacheServer removeEvictionStrategy() {
    properties.remove(EVICTION_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * If specified, the cache will be persisted in the given directory; if not specified, the cache will be in-memory only
   */
  public final String getPersistenceDirectory() {
    return properties.get(PERSISTENCE_DIRECTORY_PROPERTY);
  }

  /**
   * If specified, the cache will be persisted in the given directory; if not specified, the cache will be in-memory only
   */
  public final DistributedMapCacheServer setPersistenceDirectory(
      final String persistenceDirectory) {
    properties.put(PERSISTENCE_DIRECTORY_PROPERTY, persistenceDirectory);
    return this;
  }

  /**
   * If specified, the cache will be persisted in the given directory; if not specified, the cache will be in-memory only
   */
  public final DistributedMapCacheServer removePersistenceDirectory() {
    properties.remove(PERSISTENCE_DIRECTORY_PROPERTY);
    return this;
  }

  /**
   * If specified, this service will be used to create an SSL Context that will be used to secure communications; if not specified, communications will not be secure
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * If specified, this service will be used to create an SSL Context that will be used to secure communications; if not specified, communications will not be secure
   */
  public final DistributedMapCacheServer setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * If specified, this service will be used to create an SSL Context that will be used to secure communications; if not specified, communications will not be secure
   */
  public final DistributedMapCacheServer removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final DistributedMapCacheServer setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final DistributedMapCacheServer removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<DistributedMapCacheServer, DistributedMapCacheServer> configurator) {
    return configurator.apply(new DistributedMapCacheServer()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DistributedMapCacheServer.class) final Closure<DistributedMapCacheServer> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.distributed.cache.server.map.DistributedMapCacheServer> code = closure.rehydrate(c, com.tibtech.nifi.distributed.cache.server.map.DistributedMapCacheServer.class, com.tibtech.nifi.distributed.cache.server.map.DistributedMapCacheServer.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<DistributedMapCacheServer, DistributedMapCacheServer> configurator) {
    return configurator.apply(new DistributedMapCacheServer(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DistributedMapCacheServer.class) final Closure<DistributedMapCacheServer> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.distributed.cache.server.map.DistributedMapCacheServer> code = closure.rehydrate(c, com.tibtech.nifi.distributed.cache.server.map.DistributedMapCacheServer.class, com.tibtech.nifi.distributed.cache.server.map.DistributedMapCacheServer.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
