package com.tibtech.nifi.processors.ignite.cache;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GetIgniteCache {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.ignite.cache.GetIgniteCache";

  /**
   * Ignite spring configuration file, <path>/<ignite-configuration>.xml. If the configuration file is not provided, default Ignite configuration configuration is used which binds to 127.0.0.1:47500..47509
   */
  public static final String IGNITE_SPRING_PROPERTIES_XML_FILE_PROPERTY = "ignite-spring-properties-xml-file";

  /**
   * The name of the ignite cache
   */
  public static final String IGNITE_CACHE_NAME_PROPERTY = "ignite-cache-name";

  /**
   * A FlowFile attribute, or attribute expression used for determining Ignite cache key for the Flow File content
   */
  public static final String IGNITE_CACHE_ENTRY_IDENTIFIER_PROPERTY = "ignite-cache-entry-identifier";

  private final Map<String, String> properties;

  public GetIgniteCache() {
    this.properties = new HashMap<>();
  }

  public GetIgniteCache(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Ignite spring configuration file, <path>/<ignite-configuration>.xml. If the configuration file is not provided, default Ignite configuration configuration is used which binds to 127.0.0.1:47500..47509
   */
  public final String getIgniteSpringPropertiesXmlFile() {
    return properties.get(IGNITE_SPRING_PROPERTIES_XML_FILE_PROPERTY);
  }

  /**
   * Ignite spring configuration file, <path>/<ignite-configuration>.xml. If the configuration file is not provided, default Ignite configuration configuration is used which binds to 127.0.0.1:47500..47509
   */
  public final GetIgniteCache setIgniteSpringPropertiesXmlFile(final String igniteSpringPropertiesXmlFile) {
    properties.put(IGNITE_SPRING_PROPERTIES_XML_FILE_PROPERTY, igniteSpringPropertiesXmlFile);
    return this;
  }

  /**
   * Ignite spring configuration file, <path>/<ignite-configuration>.xml. If the configuration file is not provided, default Ignite configuration configuration is used which binds to 127.0.0.1:47500..47509
   */
  public final GetIgniteCache removeIgniteSpringPropertiesXmlFile() {
    properties.remove(IGNITE_SPRING_PROPERTIES_XML_FILE_PROPERTY);
    return this;
  }

  /**
   * The name of the ignite cache
   */
  public final String getIgniteCacheName() {
    return properties.get(IGNITE_CACHE_NAME_PROPERTY);
  }

  /**
   * The name of the ignite cache
   */
  public final GetIgniteCache setIgniteCacheName(final String igniteCacheName) {
    properties.put(IGNITE_CACHE_NAME_PROPERTY, igniteCacheName);
    return this;
  }

  /**
   * The name of the ignite cache
   */
  public final GetIgniteCache removeIgniteCacheName() {
    properties.remove(IGNITE_CACHE_NAME_PROPERTY);
    return this;
  }

  /**
   * A FlowFile attribute, or attribute expression used for determining Ignite cache key for the Flow File content
   */
  public final String getIgniteCacheEntryIdentifier() {
    return properties.get(IGNITE_CACHE_ENTRY_IDENTIFIER_PROPERTY);
  }

  /**
   * A FlowFile attribute, or attribute expression used for determining Ignite cache key for the Flow File content
   */
  public final GetIgniteCache setIgniteCacheEntryIdentifier(final String igniteCacheEntryIdentifier) {
    properties.put(IGNITE_CACHE_ENTRY_IDENTIFIER_PROPERTY, igniteCacheEntryIdentifier);
    return this;
  }

  /**
   * A FlowFile attribute, or attribute expression used for determining Ignite cache key for the Flow File content
   */
  public final GetIgniteCache removeIgniteCacheEntryIdentifier() {
    properties.remove(IGNITE_CACHE_ENTRY_IDENTIFIER_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GetIgniteCache setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GetIgniteCache removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<GetIgniteCache, GetIgniteCache> configurator) {
    return configurator.apply(new GetIgniteCache()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetIgniteCache.class) final Closure<GetIgniteCache> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.ignite.cache.GetIgniteCache> code = closure.rehydrate(c, com.tibtech.nifi.processors.ignite.cache.GetIgniteCache.class, com.tibtech.nifi.processors.ignite.cache.GetIgniteCache.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<GetIgniteCache, GetIgniteCache> configurator) {
    return configurator.apply(new GetIgniteCache(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetIgniteCache.class) final Closure<GetIgniteCache> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.ignite.cache.GetIgniteCache> code = closure.rehydrate(c, com.tibtech.nifi.processors.ignite.cache.GetIgniteCache.class, com.tibtech.nifi.processors.ignite.cache.GetIgniteCache.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
