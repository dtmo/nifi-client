package com.tibtech.nifi.redis.service;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class RedisDistributedMapCacheClientService {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.redis.service.RedisDistributedMapCacheClientService";

  /**
   *
   */
  public static final String REDIS_CONNECTION_POOL_PROPERTY = "redis-connection-pool";

  /**
   * Indicates how long the data should exist in Redis. Setting '0 secs' would mean the data would exist forever
   */
  public static final String REDIS_CACHE_TTL_PROPERTY = "redis-cache-ttl";

  private final Map<String, String> properties;

  public RedisDistributedMapCacheClientService() {
    this.properties = new HashMap<>();
  }

  public RedisDistributedMapCacheClientService(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   *
   */
  public final String getRedisConnectionPool() {
    return properties.get(REDIS_CONNECTION_POOL_PROPERTY);
  }

  /**
   *
   */
  public final RedisDistributedMapCacheClientService setRedisConnectionPool(
      final String redisConnectionPool) {
    properties.put(REDIS_CONNECTION_POOL_PROPERTY, redisConnectionPool);
    return this;
  }

  /**
   *
   */
  public final RedisDistributedMapCacheClientService removeRedisConnectionPool() {
    properties.remove(REDIS_CONNECTION_POOL_PROPERTY);
    return this;
  }

  /**
   * Indicates how long the data should exist in Redis. Setting '0 secs' would mean the data would exist forever
   */
  public final String getRedisCacheTtl() {
    return properties.get(REDIS_CACHE_TTL_PROPERTY);
  }

  /**
   * Indicates how long the data should exist in Redis. Setting '0 secs' would mean the data would exist forever
   */
  public final RedisDistributedMapCacheClientService setRedisCacheTtl(final String redisCacheTtl) {
    properties.put(REDIS_CACHE_TTL_PROPERTY, redisCacheTtl);
    return this;
  }

  /**
   * Indicates how long the data should exist in Redis. Setting '0 secs' would mean the data would exist forever
   */
  public final RedisDistributedMapCacheClientService removeRedisCacheTtl() {
    properties.remove(REDIS_CACHE_TTL_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final RedisDistributedMapCacheClientService setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final RedisDistributedMapCacheClientService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<RedisDistributedMapCacheClientService, RedisDistributedMapCacheClientService> configurator) {
    return configurator.apply(new RedisDistributedMapCacheClientService()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = RedisDistributedMapCacheClientService.class) final Closure<RedisDistributedMapCacheClientService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.redis.service.RedisDistributedMapCacheClientService> code = closure.rehydrate(c, com.tibtech.nifi.redis.service.RedisDistributedMapCacheClientService.class, com.tibtech.nifi.redis.service.RedisDistributedMapCacheClientService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<RedisDistributedMapCacheClientService, RedisDistributedMapCacheClientService> configurator) {
    return configurator.apply(new RedisDistributedMapCacheClientService(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = RedisDistributedMapCacheClientService.class) final Closure<RedisDistributedMapCacheClientService> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.redis.service.RedisDistributedMapCacheClientService> code = closure.rehydrate(c, com.tibtech.nifi.redis.service.RedisDistributedMapCacheClientService.class, com.tibtech.nifi.redis.service.RedisDistributedMapCacheClientService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
