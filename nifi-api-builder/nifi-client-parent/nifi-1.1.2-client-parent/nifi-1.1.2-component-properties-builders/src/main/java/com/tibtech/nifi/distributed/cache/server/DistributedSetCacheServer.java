package com.tibtech.nifi.distributed.cache.server;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class DistributedSetCacheServer {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.distributed.cache.server.DistributedSetCacheServer";

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

  public DistributedSetCacheServer() {
    this.properties = new HashMap<>();
  }

  public DistributedSetCacheServer(final Map<String, String> properties) {
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
  public final DistributedSetCacheServer setPort(final String port) {
    properties.put(PORT_PROPERTY, port);
    return this;
  }

  /**
   * The port to listen on for incoming connections
   */
  public final DistributedSetCacheServer removePort() {
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
  public final DistributedSetCacheServer setMaximumCacheEntries(final String maximumCacheEntries) {
    properties.put(MAXIMUM_CACHE_ENTRIES_PROPERTY, maximumCacheEntries);
    return this;
  }

  /**
   * The maximum number of cache entries that the cache can hold
   */
  public final DistributedSetCacheServer removeMaximumCacheEntries() {
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
  public final DistributedSetCacheServer setEvictionStrategy(final String evictionStrategy) {
    properties.put(EVICTION_STRATEGY_PROPERTY, evictionStrategy);
    return this;
  }

  /**
   * Determines which strategy should be used to evict values from the cache to make room for new entries
   */
  public final DistributedSetCacheServer removeEvictionStrategy() {
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
  public final DistributedSetCacheServer setPersistenceDirectory(final String persistenceDirectory) {
    properties.put(PERSISTENCE_DIRECTORY_PROPERTY, persistenceDirectory);
    return this;
  }

  /**
   * If specified, the cache will be persisted in the given directory; if not specified, the cache will be in-memory only
   */
  public final DistributedSetCacheServer removePersistenceDirectory() {
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
  public final DistributedSetCacheServer setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * If specified, this service will be used to create an SSL Context that will be used to secure communications; if not specified, communications will not be secure
   */
  public final DistributedSetCacheServer removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final DistributedSetCacheServer setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final DistributedSetCacheServer removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<DistributedSetCacheServer, DistributedSetCacheServer> configurator) {
    return configurator.apply(new DistributedSetCacheServer()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DistributedSetCacheServer.class) final Closure<DistributedSetCacheServer> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.distributed.cache.server.DistributedSetCacheServer> code = closure.rehydrate(c, com.tibtech.nifi.distributed.cache.server.DistributedSetCacheServer.class, com.tibtech.nifi.distributed.cache.server.DistributedSetCacheServer.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<DistributedSetCacheServer, DistributedSetCacheServer> configurator) {
    return configurator.apply(new DistributedSetCacheServer(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DistributedSetCacheServer.class) final Closure<DistributedSetCacheServer> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.distributed.cache.server.DistributedSetCacheServer> code = closure.rehydrate(c, com.tibtech.nifi.distributed.cache.server.DistributedSetCacheServer.class, com.tibtech.nifi.distributed.cache.server.DistributedSetCacheServer.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
