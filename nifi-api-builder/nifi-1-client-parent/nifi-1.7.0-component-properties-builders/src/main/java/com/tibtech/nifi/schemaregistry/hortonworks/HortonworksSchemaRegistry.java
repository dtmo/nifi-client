package com.tibtech.nifi.schemaregistry.hortonworks;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class HortonworksSchemaRegistry {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.schemaregistry.hortonworks.HortonworksSchemaRegistry";

  /**
   * URL of the schema registry that this Controller Service should connect to, including version. For example, http://localhost:9090/api/v1
   */
  public static final String URL_PROPERTY = "url";

  /**
   * Specifies how many Schemas should be cached from the Hortonworks Schema Registry
   */
  public static final String CACHE_SIZE_PROPERTY = "cache-size";

  /**
   * Specifies how long a Schema that is cached should remain in the cache. Once this time period elapses, a cached version of a schema will no longer be used, and the service will have to communicate with the Hortonworks Schema Registry again in order to obtain the schema.
   */
  public static final String CACHE_EXPIRATION_PROPERTY = "cache-expiration";

  private final Map<String, String> properties;

  public HortonworksSchemaRegistry() {
    this.properties = new HashMap<>();
  }

  public HortonworksSchemaRegistry(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * URL of the schema registry that this Controller Service should connect to, including version. For example, http://localhost:9090/api/v1
   */
  public final String getUrl() {
    return properties.get(URL_PROPERTY);
  }

  /**
   * URL of the schema registry that this Controller Service should connect to, including version. For example, http://localhost:9090/api/v1
   */
  public final HortonworksSchemaRegistry setUrl(final String url) {
    properties.put(URL_PROPERTY, url);
    return this;
  }

  /**
   * URL of the schema registry that this Controller Service should connect to, including version. For example, http://localhost:9090/api/v1
   */
  public final HortonworksSchemaRegistry removeUrl() {
    properties.remove(URL_PROPERTY);
    return this;
  }

  /**
   * Specifies how many Schemas should be cached from the Hortonworks Schema Registry
   */
  public final String getCacheSize() {
    return properties.get(CACHE_SIZE_PROPERTY);
  }

  /**
   * Specifies how many Schemas should be cached from the Hortonworks Schema Registry
   */
  public final HortonworksSchemaRegistry setCacheSize(final String cacheSize) {
    properties.put(CACHE_SIZE_PROPERTY, cacheSize);
    return this;
  }

  /**
   * Specifies how many Schemas should be cached from the Hortonworks Schema Registry
   */
  public final HortonworksSchemaRegistry removeCacheSize() {
    properties.remove(CACHE_SIZE_PROPERTY);
    return this;
  }

  /**
   * Specifies how long a Schema that is cached should remain in the cache. Once this time period elapses, a cached version of a schema will no longer be used, and the service will have to communicate with the Hortonworks Schema Registry again in order to obtain the schema.
   */
  public final String getCacheExpiration() {
    return properties.get(CACHE_EXPIRATION_PROPERTY);
  }

  /**
   * Specifies how long a Schema that is cached should remain in the cache. Once this time period elapses, a cached version of a schema will no longer be used, and the service will have to communicate with the Hortonworks Schema Registry again in order to obtain the schema.
   */
  public final HortonworksSchemaRegistry setCacheExpiration(final String cacheExpiration) {
    properties.put(CACHE_EXPIRATION_PROPERTY, cacheExpiration);
    return this;
  }

  /**
   * Specifies how long a Schema that is cached should remain in the cache. Once this time period elapses, a cached version of a schema will no longer be used, and the service will have to communicate with the Hortonworks Schema Registry again in order to obtain the schema.
   */
  public final HortonworksSchemaRegistry removeCacheExpiration() {
    properties.remove(CACHE_EXPIRATION_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final HortonworksSchemaRegistry setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final HortonworksSchemaRegistry removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<HortonworksSchemaRegistry, HortonworksSchemaRegistry> configurator) {
    return configurator.apply(new HortonworksSchemaRegistry()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = HortonworksSchemaRegistry.class) final Closure<HortonworksSchemaRegistry> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.schemaregistry.hortonworks.HortonworksSchemaRegistry> code = closure.rehydrate(c, com.tibtech.nifi.schemaregistry.hortonworks.HortonworksSchemaRegistry.class, com.tibtech.nifi.schemaregistry.hortonworks.HortonworksSchemaRegistry.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<HortonworksSchemaRegistry, HortonworksSchemaRegistry> configurator) {
    return configurator.apply(new HortonworksSchemaRegistry(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = HortonworksSchemaRegistry.class) final Closure<HortonworksSchemaRegistry> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.schemaregistry.hortonworks.HortonworksSchemaRegistry> code = closure.rehydrate(c, com.tibtech.nifi.schemaregistry.hortonworks.HortonworksSchemaRegistry.class, com.tibtech.nifi.schemaregistry.hortonworks.HortonworksSchemaRegistry.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
