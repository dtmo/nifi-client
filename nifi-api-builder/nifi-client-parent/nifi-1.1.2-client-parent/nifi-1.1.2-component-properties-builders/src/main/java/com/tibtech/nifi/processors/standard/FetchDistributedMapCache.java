package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class FetchDistributedMapCache {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.FetchDistributedMapCache";

  /**
   * A FlowFile attribute, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the value used to identify duplicates; it is this value that is cached
   */
  public static final String CACHE_ENTRY_IDENTIFIER_PROPERTY = "Cache Entry Identifier";

  /**
   * The Controller Service that is used to get the cached values.
   */
  public static final String DISTRIBUTED_CACHE_SERVICE_PROPERTY = "Distributed Cache Service";

  /**
   * If set, the cache value received will be put into an attribute of the FlowFile instead of a the content of theFlowFile. The attribute key to put to is determined by evaluating value of this property.
   */
  public static final String PUT_CACHE_VALUE_IN_ATTRIBUTE_PROPERTY = "Put Cache Value In Attribute";

  /**
   * If routing the cache value to an attribute of the FlowFile (by setting the "Put Cache Value in attribute" property), the number of characters put to the attribute value will be at most this amount. This is important because attributes are held in memory and large attributes will quickly cause out of memory issues. If the output goes longer than this value, it will be truncated to fit. Consider making this smaller if able.
   */
  public static final String MAX_LENGTH_TO_PUT_IN_ATTRIBUTE_PROPERTY = "Max Length To Put In Attribute";

  /**
   * The Character Set in which the cached value is encoded. This will only be used when routing to an attribute.
   */
  public static final String CHARACTER_SET_PROPERTY = "Character Set";

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
  public final FetchDistributedMapCache setCacheEntryIdentifier(final String cacheEntryIdentifier) {
    properties.put(CACHE_ENTRY_IDENTIFIER_PROPERTY, cacheEntryIdentifier);
    return this;
  }

  /**
   * A FlowFile attribute, or the results of an Attribute Expression Language statement, which will be evaluated against a FlowFile in order to determine the value used to identify duplicates; it is this value that is cached
   */
  public final FetchDistributedMapCache removeCacheEntryIdentifier() {
    properties.remove(CACHE_ENTRY_IDENTIFIER_PROPERTY);
    return this;
  }

  /**
   * The Controller Service that is used to get the cached values.
   */
  public final String getDistributedCacheService() {
    return properties.get(DISTRIBUTED_CACHE_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service that is used to get the cached values.
   */
  public final FetchDistributedMapCache setDistributedCacheService(final String distributedCacheService) {
    properties.put(DISTRIBUTED_CACHE_SERVICE_PROPERTY, distributedCacheService);
    return this;
  }

  /**
   * The Controller Service that is used to get the cached values.
   */
  public final FetchDistributedMapCache removeDistributedCacheService() {
    properties.remove(DISTRIBUTED_CACHE_SERVICE_PROPERTY);
    return this;
  }

  /**
   * If set, the cache value received will be put into an attribute of the FlowFile instead of a the content of theFlowFile. The attribute key to put to is determined by evaluating value of this property.
   */
  public final String getPutCacheValueInAttribute() {
    return properties.get(PUT_CACHE_VALUE_IN_ATTRIBUTE_PROPERTY);
  }

  /**
   * If set, the cache value received will be put into an attribute of the FlowFile instead of a the content of theFlowFile. The attribute key to put to is determined by evaluating value of this property.
   */
  public final FetchDistributedMapCache setPutCacheValueInAttribute(final String putCacheValueInAttribute) {
    properties.put(PUT_CACHE_VALUE_IN_ATTRIBUTE_PROPERTY, putCacheValueInAttribute);
    return this;
  }

  /**
   * If set, the cache value received will be put into an attribute of the FlowFile instead of a the content of theFlowFile. The attribute key to put to is determined by evaluating value of this property.
   */
  public final FetchDistributedMapCache removePutCacheValueInAttribute() {
    properties.remove(PUT_CACHE_VALUE_IN_ATTRIBUTE_PROPERTY);
    return this;
  }

  /**
   * If routing the cache value to an attribute of the FlowFile (by setting the "Put Cache Value in attribute" property), the number of characters put to the attribute value will be at most this amount. This is important because attributes are held in memory and large attributes will quickly cause out of memory issues. If the output goes longer than this value, it will be truncated to fit. Consider making this smaller if able.
   */
  public final String getMaxLengthToPutInAttribute() {
    return properties.get(MAX_LENGTH_TO_PUT_IN_ATTRIBUTE_PROPERTY);
  }

  /**
   * If routing the cache value to an attribute of the FlowFile (by setting the "Put Cache Value in attribute" property), the number of characters put to the attribute value will be at most this amount. This is important because attributes are held in memory and large attributes will quickly cause out of memory issues. If the output goes longer than this value, it will be truncated to fit. Consider making this smaller if able.
   */
  public final FetchDistributedMapCache setMaxLengthToPutInAttribute(final String maxLengthToPutInAttribute) {
    properties.put(MAX_LENGTH_TO_PUT_IN_ATTRIBUTE_PROPERTY, maxLengthToPutInAttribute);
    return this;
  }

  /**
   * If routing the cache value to an attribute of the FlowFile (by setting the "Put Cache Value in attribute" property), the number of characters put to the attribute value will be at most this amount. This is important because attributes are held in memory and large attributes will quickly cause out of memory issues. If the output goes longer than this value, it will be truncated to fit. Consider making this smaller if able.
   */
  public final FetchDistributedMapCache removeMaxLengthToPutInAttribute() {
    properties.remove(MAX_LENGTH_TO_PUT_IN_ATTRIBUTE_PROPERTY);
    return this;
  }

  /**
   * The Character Set in which the cached value is encoded. This will only be used when routing to an attribute.
   */
  public final String getCharacterSet() {
    return properties.get(CHARACTER_SET_PROPERTY);
  }

  /**
   * The Character Set in which the cached value is encoded. This will only be used when routing to an attribute.
   */
  public final FetchDistributedMapCache setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * The Character Set in which the cached value is encoded. This will only be used when routing to an attribute.
   */
  public final FetchDistributedMapCache removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final FetchDistributedMapCache setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final FetchDistributedMapCache removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<FetchDistributedMapCache, FetchDistributedMapCache> configurator) {
    return configurator.apply(new FetchDistributedMapCache()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FetchDistributedMapCache.class) final Closure<FetchDistributedMapCache> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.FetchDistributedMapCache> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.FetchDistributedMapCache.class, com.tibtech.nifi.processors.standard.FetchDistributedMapCache.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
