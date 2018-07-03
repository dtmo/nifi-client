package com.tibtech.nifi.confluent.schemaregistry;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ConfluentSchemaRegistry {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.confluent.schemaregistry.ConfluentSchemaRegistry";

  /**
   * A comma-separated list of URLs of the Schema Registry to interact with
   */
  public static final String URL_PROPERTY = "url";

  /**
   * Specifies the SSL Context Service to use for interacting with the Confluent Schema Registry
   */
  public static final String SSL_CONTEXT_PROPERTY = "ssl-context";

  /**
   * Specifies how long to wait to receive data from the Schema Registry before considering the communications a failure
   */
  public static final String TIMEOUT_PROPERTY = "timeout";

  /**
   * Specifies how many Schemas should be cached from the Schema Registry
   */
  public static final String CACHE_SIZE_PROPERTY = "cache-size";

  /**
   * Specifies how long a Schema that is cached should remain in the cache. Once this time period elapses, a cached version of a schema will no longer be used, and the service will have to communicate with the Schema Registry again in order to obtain the schema.
   */
  public static final String CACHE_EXPIRATION_PROPERTY = "cache-expiration";

  private final Map<String, String> properties;

  public ConfluentSchemaRegistry() {
    this.properties = new HashMap<>();
  }

  public ConfluentSchemaRegistry(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * A comma-separated list of URLs of the Schema Registry to interact with
   */
  public final String getUrl() {
    return properties.get(URL_PROPERTY);
  }

  /**
   * A comma-separated list of URLs of the Schema Registry to interact with
   */
  public final ConfluentSchemaRegistry setUrl(final String url) {
    properties.put(URL_PROPERTY, url);
    return this;
  }

  /**
   * A comma-separated list of URLs of the Schema Registry to interact with
   */
  public final ConfluentSchemaRegistry removeUrl() {
    properties.remove(URL_PROPERTY);
    return this;
  }

  /**
   * Specifies the SSL Context Service to use for interacting with the Confluent Schema Registry
   */
  public final String getSslContext() {
    return properties.get(SSL_CONTEXT_PROPERTY);
  }

  /**
   * Specifies the SSL Context Service to use for interacting with the Confluent Schema Registry
   */
  public final ConfluentSchemaRegistry setSslContext(final String sslContext) {
    properties.put(SSL_CONTEXT_PROPERTY, sslContext);
    return this;
  }

  /**
   * Specifies the SSL Context Service to use for interacting with the Confluent Schema Registry
   */
  public final ConfluentSchemaRegistry removeSslContext() {
    properties.remove(SSL_CONTEXT_PROPERTY);
    return this;
  }

  /**
   * Specifies how long to wait to receive data from the Schema Registry before considering the communications a failure
   */
  public final String getTimeout() {
    return properties.get(TIMEOUT_PROPERTY);
  }

  /**
   * Specifies how long to wait to receive data from the Schema Registry before considering the communications a failure
   */
  public final ConfluentSchemaRegistry setTimeout(final String timeout) {
    properties.put(TIMEOUT_PROPERTY, timeout);
    return this;
  }

  /**
   * Specifies how long to wait to receive data from the Schema Registry before considering the communications a failure
   */
  public final ConfluentSchemaRegistry removeTimeout() {
    properties.remove(TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * Specifies how many Schemas should be cached from the Schema Registry
   */
  public final String getCacheSize() {
    return properties.get(CACHE_SIZE_PROPERTY);
  }

  /**
   * Specifies how many Schemas should be cached from the Schema Registry
   */
  public final ConfluentSchemaRegistry setCacheSize(final String cacheSize) {
    properties.put(CACHE_SIZE_PROPERTY, cacheSize);
    return this;
  }

  /**
   * Specifies how many Schemas should be cached from the Schema Registry
   */
  public final ConfluentSchemaRegistry removeCacheSize() {
    properties.remove(CACHE_SIZE_PROPERTY);
    return this;
  }

  /**
   * Specifies how long a Schema that is cached should remain in the cache. Once this time period elapses, a cached version of a schema will no longer be used, and the service will have to communicate with the Schema Registry again in order to obtain the schema.
   */
  public final String getCacheExpiration() {
    return properties.get(CACHE_EXPIRATION_PROPERTY);
  }

  /**
   * Specifies how long a Schema that is cached should remain in the cache. Once this time period elapses, a cached version of a schema will no longer be used, and the service will have to communicate with the Schema Registry again in order to obtain the schema.
   */
  public final ConfluentSchemaRegistry setCacheExpiration(final String cacheExpiration) {
    properties.put(CACHE_EXPIRATION_PROPERTY, cacheExpiration);
    return this;
  }

  /**
   * Specifies how long a Schema that is cached should remain in the cache. Once this time period elapses, a cached version of a schema will no longer be used, and the service will have to communicate with the Schema Registry again in order to obtain the schema.
   */
  public final ConfluentSchemaRegistry removeCacheExpiration() {
    properties.remove(CACHE_EXPIRATION_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ConfluentSchemaRegistry setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ConfluentSchemaRegistry removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ConfluentSchemaRegistry, ConfluentSchemaRegistry> configurator) {
    return configurator.apply(new ConfluentSchemaRegistry()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConfluentSchemaRegistry.class) final Closure<ConfluentSchemaRegistry> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.confluent.schemaregistry.ConfluentSchemaRegistry> code = closure.rehydrate(c, com.tibtech.nifi.confluent.schemaregistry.ConfluentSchemaRegistry.class, com.tibtech.nifi.confluent.schemaregistry.ConfluentSchemaRegistry.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ConfluentSchemaRegistry, ConfluentSchemaRegistry> configurator) {
    return configurator.apply(new ConfluentSchemaRegistry(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConfluentSchemaRegistry.class) final Closure<ConfluentSchemaRegistry> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.confluent.schemaregistry.ConfluentSchemaRegistry> code = closure.rehydrate(c, com.tibtech.nifi.confluent.schemaregistry.ConfluentSchemaRegistry.class, com.tibtech.nifi.confluent.schemaregistry.ConfluentSchemaRegistry.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
