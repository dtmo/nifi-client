package com.tibtech.nifi.processors.ignite.cache;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutIgniteCache {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.ignite.cache.PutIgniteCache";

  /**
   * Ignite spring configuration file, <path>/<ignite-configuration>.xml. If the configuration file is not provided, default Ignite configuration configuration is used which binds to 127.0.0.1:47500..47509
   */
  public static final String IGNITE_SPRING_PROPERTIES_XML_FILE_PROPERTY = "ignite-spring-properties-xml-file";

  /**
   * The name of the ignite cache
   */
  public static final String IGNITE_CACHE_NAME_PROPERTY = "ignite-cache-name";

  /**
   * Batch size for entries (1-500).
   */
  public static final String BATCH_SIZE_FOR_ENTRIES_PROPERTY = "batch-size-for-entries";

  /**
   * A FlowFile attribute, or attribute expression used for determining Ignite cache key for the Flow File content
   */
  public static final String IGNITE_CACHE_ENTRY_IDENTIFIER_PROPERTY = "ignite-cache-entry-identifier";

  /**
   * Data streamer per node parallelism
   */
  public static final String DATA_STREAMER_PER_NODE_PARALLEL_OPERATIONS_PROPERTY = "data-streamer-per-node-parallel-operations";

  /**
   * Data streamer per node buffer size (1-500).
   */
  public static final String DATA_STREAMER_PER_NODE_BUFFER_SIZE_PROPERTY = "data-streamer-per-node-buffer-size";

  /**
   * Data streamer flush interval in millis seconds
   */
  public static final String DATA_STREAMER_AUTO_FLUSH_FREQUENCY_IN_MILLIS_PROPERTY = "data-streamer-auto-flush-frequency-in-millis";

  /**
   * Whether to override values already in the cache
   */
  public static final String DATA_STREAMER_ALLOW_OVERRIDE_PROPERTY = "data-streamer-allow-override";

  private final Map<String, String> properties;

  public PutIgniteCache() {
    this.properties = new HashMap<>();
  }

  public PutIgniteCache(final Map<String, String> properties) {
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
  public final PutIgniteCache setIgniteSpringPropertiesXmlFile(
      final String igniteSpringPropertiesXmlFile) {
    properties.put(IGNITE_SPRING_PROPERTIES_XML_FILE_PROPERTY, igniteSpringPropertiesXmlFile);
    return this;
  }

  /**
   * Ignite spring configuration file, <path>/<ignite-configuration>.xml. If the configuration file is not provided, default Ignite configuration configuration is used which binds to 127.0.0.1:47500..47509
   */
  public final PutIgniteCache removeIgniteSpringPropertiesXmlFile() {
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
  public final PutIgniteCache setIgniteCacheName(final String igniteCacheName) {
    properties.put(IGNITE_CACHE_NAME_PROPERTY, igniteCacheName);
    return this;
  }

  /**
   * The name of the ignite cache
   */
  public final PutIgniteCache removeIgniteCacheName() {
    properties.remove(IGNITE_CACHE_NAME_PROPERTY);
    return this;
  }

  /**
   * Batch size for entries (1-500).
   */
  public final String getBatchSizeForEntries() {
    return properties.get(BATCH_SIZE_FOR_ENTRIES_PROPERTY);
  }

  /**
   * Batch size for entries (1-500).
   */
  public final PutIgniteCache setBatchSizeForEntries(final String batchSizeForEntries) {
    properties.put(BATCH_SIZE_FOR_ENTRIES_PROPERTY, batchSizeForEntries);
    return this;
  }

  /**
   * Batch size for entries (1-500).
   */
  public final PutIgniteCache removeBatchSizeForEntries() {
    properties.remove(BATCH_SIZE_FOR_ENTRIES_PROPERTY);
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
  public final PutIgniteCache setIgniteCacheEntryIdentifier(
      final String igniteCacheEntryIdentifier) {
    properties.put(IGNITE_CACHE_ENTRY_IDENTIFIER_PROPERTY, igniteCacheEntryIdentifier);
    return this;
  }

  /**
   * A FlowFile attribute, or attribute expression used for determining Ignite cache key for the Flow File content
   */
  public final PutIgniteCache removeIgniteCacheEntryIdentifier() {
    properties.remove(IGNITE_CACHE_ENTRY_IDENTIFIER_PROPERTY);
    return this;
  }

  /**
   * Data streamer per node parallelism
   */
  public final String getDataStreamerPerNodeParallelOperations() {
    return properties.get(DATA_STREAMER_PER_NODE_PARALLEL_OPERATIONS_PROPERTY);
  }

  /**
   * Data streamer per node parallelism
   */
  public final PutIgniteCache setDataStreamerPerNodeParallelOperations(
      final String dataStreamerPerNodeParallelOperations) {
    properties.put(DATA_STREAMER_PER_NODE_PARALLEL_OPERATIONS_PROPERTY, dataStreamerPerNodeParallelOperations);
    return this;
  }

  /**
   * Data streamer per node parallelism
   */
  public final PutIgniteCache removeDataStreamerPerNodeParallelOperations() {
    properties.remove(DATA_STREAMER_PER_NODE_PARALLEL_OPERATIONS_PROPERTY);
    return this;
  }

  /**
   * Data streamer per node buffer size (1-500).
   */
  public final String getDataStreamerPerNodeBufferSize() {
    return properties.get(DATA_STREAMER_PER_NODE_BUFFER_SIZE_PROPERTY);
  }

  /**
   * Data streamer per node buffer size (1-500).
   */
  public final PutIgniteCache setDataStreamerPerNodeBufferSize(
      final String dataStreamerPerNodeBufferSize) {
    properties.put(DATA_STREAMER_PER_NODE_BUFFER_SIZE_PROPERTY, dataStreamerPerNodeBufferSize);
    return this;
  }

  /**
   * Data streamer per node buffer size (1-500).
   */
  public final PutIgniteCache removeDataStreamerPerNodeBufferSize() {
    properties.remove(DATA_STREAMER_PER_NODE_BUFFER_SIZE_PROPERTY);
    return this;
  }

  /**
   * Data streamer flush interval in millis seconds
   */
  public final String getDataStreamerAutoFlushFrequencyInMillis() {
    return properties.get(DATA_STREAMER_AUTO_FLUSH_FREQUENCY_IN_MILLIS_PROPERTY);
  }

  /**
   * Data streamer flush interval in millis seconds
   */
  public final PutIgniteCache setDataStreamerAutoFlushFrequencyInMillis(
      final String dataStreamerAutoFlushFrequencyInMillis) {
    properties.put(DATA_STREAMER_AUTO_FLUSH_FREQUENCY_IN_MILLIS_PROPERTY, dataStreamerAutoFlushFrequencyInMillis);
    return this;
  }

  /**
   * Data streamer flush interval in millis seconds
   */
  public final PutIgniteCache removeDataStreamerAutoFlushFrequencyInMillis() {
    properties.remove(DATA_STREAMER_AUTO_FLUSH_FREQUENCY_IN_MILLIS_PROPERTY);
    return this;
  }

  /**
   * Whether to override values already in the cache
   */
  public final String getDataStreamerAllowOverride() {
    return properties.get(DATA_STREAMER_ALLOW_OVERRIDE_PROPERTY);
  }

  /**
   * Whether to override values already in the cache
   */
  public final PutIgniteCache setDataStreamerAllowOverride(final String dataStreamerAllowOverride) {
    properties.put(DATA_STREAMER_ALLOW_OVERRIDE_PROPERTY, dataStreamerAllowOverride);
    return this;
  }

  /**
   * Whether to override values already in the cache
   */
  public final PutIgniteCache removeDataStreamerAllowOverride() {
    properties.remove(DATA_STREAMER_ALLOW_OVERRIDE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutIgniteCache setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutIgniteCache removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<PutIgniteCache, PutIgniteCache> configurator) {
    return configurator.apply(new PutIgniteCache()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutIgniteCache.class) final Closure<PutIgniteCache> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.ignite.cache.PutIgniteCache> code = closure.rehydrate(c, com.tibtech.nifi.processors.ignite.cache.PutIgniteCache.class, com.tibtech.nifi.processors.ignite.cache.PutIgniteCache.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutIgniteCache, PutIgniteCache> configurator) {
    return configurator.apply(new PutIgniteCache(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutIgniteCache.class) final Closure<PutIgniteCache> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.ignite.cache.PutIgniteCache> code = closure.rehydrate(c, com.tibtech.nifi.processors.ignite.cache.PutIgniteCache.class, com.tibtech.nifi.processors.ignite.cache.PutIgniteCache.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
