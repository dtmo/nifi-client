package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutDistributedMapCache {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.PutDistributedMapCache";

  /**
   * A FlowFile attribute, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the cache key
   */
  public static final String CACHE_ENTRY_IDENTIFIER_PROPERTY = "Cache Entry Identifier";

  /**
   * The Controller Service that is used to cache flow files
   */
  public static final String DISTRIBUTED_CACHE_SERVICE_PROPERTY = "Distributed Cache Service";

  /**
   * Determines how the cache is updated if the cache already contains the entry
   */
  public static final String CACHE_UPDATE_STRATEGY_PROPERTY = "Cache update strategy";

  /**
   * The maximum amount of data to put into cache
   */
  public static final String MAX_CACHE_ENTRY_SIZE_PROPERTY = "Max cache entry size";

  private final Map<String, String> properties;

  public PutDistributedMapCache() {
    this.properties = new HashMap<>();
  }

  public PutDistributedMapCache(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * A FlowFile attribute, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the cache key
   */
  public final String getCacheEntryIdentifier() {
    return properties.get(CACHE_ENTRY_IDENTIFIER_PROPERTY);
  }

  /**
   * A FlowFile attribute, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the cache key
   */
  public final PutDistributedMapCache setCacheEntryIdentifier(final String cacheEntryIdentifier) {
    properties.put(CACHE_ENTRY_IDENTIFIER_PROPERTY, cacheEntryIdentifier);
    return this;
  }

  /**
   * A FlowFile attribute, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the cache key
   */
  public final PutDistributedMapCache removeCacheEntryIdentifier() {
    properties.remove(CACHE_ENTRY_IDENTIFIER_PROPERTY);
    return this;
  }

  /**
   * The Controller Service that is used to cache flow files
   */
  public final String getDistributedCacheService() {
    return properties.get(DISTRIBUTED_CACHE_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service that is used to cache flow files
   */
  public final PutDistributedMapCache setDistributedCacheService(
      final String distributedCacheService) {
    properties.put(DISTRIBUTED_CACHE_SERVICE_PROPERTY, distributedCacheService);
    return this;
  }

  /**
   * The Controller Service that is used to cache flow files
   */
  public final PutDistributedMapCache removeDistributedCacheService() {
    properties.remove(DISTRIBUTED_CACHE_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Determines how the cache is updated if the cache already contains the entry
   */
  public final String getCacheUpdateStrategy() {
    return properties.get(CACHE_UPDATE_STRATEGY_PROPERTY);
  }

  /**
   * Determines how the cache is updated if the cache already contains the entry
   */
  public final PutDistributedMapCache setCacheUpdateStrategy(final String cacheUpdateStrategy) {
    properties.put(CACHE_UPDATE_STRATEGY_PROPERTY, cacheUpdateStrategy);
    return this;
  }

  /**
   * Determines how the cache is updated if the cache already contains the entry
   */
  public final PutDistributedMapCache removeCacheUpdateStrategy() {
    properties.remove(CACHE_UPDATE_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * The maximum amount of data to put into cache
   */
  public final String getMaxCacheEntrySize() {
    return properties.get(MAX_CACHE_ENTRY_SIZE_PROPERTY);
  }

  /**
   * The maximum amount of data to put into cache
   */
  public final PutDistributedMapCache setMaxCacheEntrySize(final String maxCacheEntrySize) {
    properties.put(MAX_CACHE_ENTRY_SIZE_PROPERTY, maxCacheEntrySize);
    return this;
  }

  /**
   * The maximum amount of data to put into cache
   */
  public final PutDistributedMapCache removeMaxCacheEntrySize() {
    properties.remove(MAX_CACHE_ENTRY_SIZE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutDistributedMapCache setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutDistributedMapCache removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<PutDistributedMapCache, PutDistributedMapCache> configurator) {
    return configurator.apply(new PutDistributedMapCache()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutDistributedMapCache.class) final Closure<PutDistributedMapCache> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.PutDistributedMapCache> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.PutDistributedMapCache.class, com.tibtech.nifi.processors.standard.PutDistributedMapCache.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutDistributedMapCache, PutDistributedMapCache> configurator) {
    return configurator.apply(new PutDistributedMapCache(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutDistributedMapCache.class) final Closure<PutDistributedMapCache> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.PutDistributedMapCache> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.PutDistributedMapCache.class, com.tibtech.nifi.processors.standard.PutDistributedMapCache.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
