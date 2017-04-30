package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class DetectDuplicate {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.DetectDuplicate";

  /**
   * A FlowFile attribute, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the value used to identify duplicates; it is this value that is cached
   */
  public static final String CACHE_ENTRY_IDENTIFIER_PROPERTY = "Cache Entry Identifier";

  /**
   * When a FlowFile is added to the cache, this value is stored along with it so that if a duplicate is found, this description of the original FlowFile will be added to the duplicate's "original.flowfile.description" attribute
   */
  public static final String FLOW_FILE_DESCRIPTION_PROPERTY = "FlowFile Description";

  /**
   * Time interval to age off cached FlowFiles
   */
  public static final String AGE_OFF_DURATION_PROPERTY = "Age Off Duration";

  /**
   * The Controller Service that is used to cache unique identifiers, used to determine duplicates
   */
  public static final String DISTRIBUTED_CACHE_SERVICE_PROPERTY = "Distributed Cache Service";

  /**
   * When true this cause the processor to check for duplicates and cache the Entry Identifier. When false, the processor would only check for duplicates and not cache the Entry Identifier, requiring another processor to add identifiers to the distributed cache.
   */
  public static final String CACHE_THE_ENTRY_IDENTIFIER_PROPERTY = "Cache The Entry Identifier";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * A FlowFile attribute, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the value used to identify duplicates; it is this value that is cached
   */
  public final String getCacheEntryIdentifier() {
    return properties.get(CACHE_ENTRY_IDENTIFIER_PROPERTY);
  }

  /**
   * A FlowFile attribute, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the value used to identify duplicates; it is this value that is cached
   */
  public final DetectDuplicate setCacheEntryIdentifier(final String cacheEntryIdentifier) {
    properties.put(CACHE_ENTRY_IDENTIFIER_PROPERTY, cacheEntryIdentifier);
    return this;
  }

  /**
   * A FlowFile attribute, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the value used to identify duplicates; it is this value that is cached
   */
  public final DetectDuplicate removeCacheEntryIdentifier() {
    properties.remove(CACHE_ENTRY_IDENTIFIER_PROPERTY);
    return this;
  }

  /**
   * When a FlowFile is added to the cache, this value is stored along with it so that if a duplicate is found, this description of the original FlowFile will be added to the duplicate's "original.flowfile.description" attribute
   */
  public final String getFlowFileDescription() {
    return properties.get(FLOW_FILE_DESCRIPTION_PROPERTY);
  }

  /**
   * When a FlowFile is added to the cache, this value is stored along with it so that if a duplicate is found, this description of the original FlowFile will be added to the duplicate's "original.flowfile.description" attribute
   */
  public final DetectDuplicate setFlowFileDescription(final String flowFileDescription) {
    properties.put(FLOW_FILE_DESCRIPTION_PROPERTY, flowFileDescription);
    return this;
  }

  /**
   * When a FlowFile is added to the cache, this value is stored along with it so that if a duplicate is found, this description of the original FlowFile will be added to the duplicate's "original.flowfile.description" attribute
   */
  public final DetectDuplicate removeFlowFileDescription() {
    properties.remove(FLOW_FILE_DESCRIPTION_PROPERTY);
    return this;
  }

  /**
   * Time interval to age off cached FlowFiles
   */
  public final String getAgeOffDuration() {
    return properties.get(AGE_OFF_DURATION_PROPERTY);
  }

  /**
   * Time interval to age off cached FlowFiles
   */
  public final DetectDuplicate setAgeOffDuration(final String ageOffDuration) {
    properties.put(AGE_OFF_DURATION_PROPERTY, ageOffDuration);
    return this;
  }

  /**
   * Time interval to age off cached FlowFiles
   */
  public final DetectDuplicate removeAgeOffDuration() {
    properties.remove(AGE_OFF_DURATION_PROPERTY);
    return this;
  }

  /**
   * The Controller Service that is used to cache unique identifiers, used to determine duplicates
   */
  public final String getDistributedCacheService() {
    return properties.get(DISTRIBUTED_CACHE_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service that is used to cache unique identifiers, used to determine duplicates
   */
  public final DetectDuplicate setDistributedCacheService(final String distributedCacheService) {
    properties.put(DISTRIBUTED_CACHE_SERVICE_PROPERTY, distributedCacheService);
    return this;
  }

  /**
   * The Controller Service that is used to cache unique identifiers, used to determine duplicates
   */
  public final DetectDuplicate removeDistributedCacheService() {
    properties.remove(DISTRIBUTED_CACHE_SERVICE_PROPERTY);
    return this;
  }

  /**
   * When true this cause the processor to check for duplicates and cache the Entry Identifier. When false, the processor would only check for duplicates and not cache the Entry Identifier, requiring another processor to add identifiers to the distributed cache.
   */
  public final String getCacheTheEntryIdentifier() {
    return properties.get(CACHE_THE_ENTRY_IDENTIFIER_PROPERTY);
  }

  /**
   * When true this cause the processor to check for duplicates and cache the Entry Identifier. When false, the processor would only check for duplicates and not cache the Entry Identifier, requiring another processor to add identifiers to the distributed cache.
   */
  public final DetectDuplicate setCacheTheEntryIdentifier(final String cacheTheEntryIdentifier) {
    properties.put(CACHE_THE_ENTRY_IDENTIFIER_PROPERTY, cacheTheEntryIdentifier);
    return this;
  }

  /**
   * When true this cause the processor to check for duplicates and cache the Entry Identifier. When false, the processor would only check for duplicates and not cache the Entry Identifier, requiring another processor to add identifiers to the distributed cache.
   */
  public final DetectDuplicate removeCacheTheEntryIdentifier() {
    properties.remove(CACHE_THE_ENTRY_IDENTIFIER_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final DetectDuplicate setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final DetectDuplicate removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<DetectDuplicate, DetectDuplicate> configurator) {
    return configurator.apply(new DetectDuplicate()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DetectDuplicate.class) final Closure<DetectDuplicate> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.DetectDuplicate> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.DetectDuplicate.class, com.tibtech.nifi.processors.standard.DetectDuplicate.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
