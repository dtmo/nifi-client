package com.tibtech.nifi.lookup;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class DistributedMapCacheLookupService {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.lookup.DistributedMapCacheLookupService";

  /**
   * The Controller Service that is used to get the cached values.
   */
  public static final String DISTRIBUTED_MAP_CACHE_SERVICE_PROPERTY = "distributed-map-cache-service";

  /**
   * Specifies a character encoding to use.
   */
  public static final String CHARACTER_ENCODING_PROPERTY = "character-encoding";

  private final Map<String, String> properties;

  public DistributedMapCacheLookupService() {
    this.properties = new HashMap<>();
  }

  public DistributedMapCacheLookupService(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The Controller Service that is used to get the cached values.
   */
  public final String getDistributedMapCacheService() {
    return properties.get(DISTRIBUTED_MAP_CACHE_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service that is used to get the cached values.
   */
  public final DistributedMapCacheLookupService setDistributedMapCacheService(
      final String distributedMapCacheService) {
    properties.put(DISTRIBUTED_MAP_CACHE_SERVICE_PROPERTY, distributedMapCacheService);
    return this;
  }

  /**
   * The Controller Service that is used to get the cached values.
   */
  public final DistributedMapCacheLookupService removeDistributedMapCacheService() {
    properties.remove(DISTRIBUTED_MAP_CACHE_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Specifies a character encoding to use.
   */
  public final String getCharacterEncoding() {
    return properties.get(CHARACTER_ENCODING_PROPERTY);
  }

  /**
   * Specifies a character encoding to use.
   */
  public final DistributedMapCacheLookupService setCharacterEncoding(
      final String characterEncoding) {
    properties.put(CHARACTER_ENCODING_PROPERTY, characterEncoding);
    return this;
  }

  /**
   * Specifies a character encoding to use.
   */
  public final DistributedMapCacheLookupService removeCharacterEncoding() {
    properties.remove(CHARACTER_ENCODING_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final DistributedMapCacheLookupService setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final DistributedMapCacheLookupService removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<DistributedMapCacheLookupService, DistributedMapCacheLookupService> configurator) {
    return configurator.apply(new DistributedMapCacheLookupService()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DistributedMapCacheLookupService.class) final Closure<DistributedMapCacheLookupService> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.lookup.DistributedMapCacheLookupService> code = closure.rehydrate(c, com.tibtech.nifi.lookup.DistributedMapCacheLookupService.class, com.tibtech.nifi.lookup.DistributedMapCacheLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<DistributedMapCacheLookupService, DistributedMapCacheLookupService> configurator) {
    return configurator.apply(new DistributedMapCacheLookupService(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DistributedMapCacheLookupService.class) final Closure<DistributedMapCacheLookupService> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.lookup.DistributedMapCacheLookupService> code = closure.rehydrate(c, com.tibtech.nifi.lookup.DistributedMapCacheLookupService.class, com.tibtech.nifi.lookup.DistributedMapCacheLookupService.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
