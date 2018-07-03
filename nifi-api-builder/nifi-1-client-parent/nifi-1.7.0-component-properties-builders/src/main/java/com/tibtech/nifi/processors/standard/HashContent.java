package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class HashContent {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.HashContent";

  /**
   * The name of the FlowFile Attribute into which the Hash Value should be written. If the value already exists, it will be overwritten
   */
  public static final String HASH_ATTRIBUTE_NAME_PROPERTY = "Hash Attribute Name";

  /**
   * Determines what hashing algorithm should be used to perform the hashing function
   */
  public static final String HASH_ALGORITHM_PROPERTY = "Hash Algorithm";

  private final Map<String, String> properties;

  public HashContent() {
    this.properties = new HashMap<>();
  }

  public HashContent(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The name of the FlowFile Attribute into which the Hash Value should be written. If the value already exists, it will be overwritten
   */
  public final String getHashAttributeName() {
    return properties.get(HASH_ATTRIBUTE_NAME_PROPERTY);
  }

  /**
   * The name of the FlowFile Attribute into which the Hash Value should be written. If the value already exists, it will be overwritten
   */
  public final HashContent setHashAttributeName(final String hashAttributeName) {
    properties.put(HASH_ATTRIBUTE_NAME_PROPERTY, hashAttributeName);
    return this;
  }

  /**
   * The name of the FlowFile Attribute into which the Hash Value should be written. If the value already exists, it will be overwritten
   */
  public final HashContent removeHashAttributeName() {
    properties.remove(HASH_ATTRIBUTE_NAME_PROPERTY);
    return this;
  }

  /**
   * Determines what hashing algorithm should be used to perform the hashing function
   */
  public final String getHashAlgorithm() {
    return properties.get(HASH_ALGORITHM_PROPERTY);
  }

  /**
   * Determines what hashing algorithm should be used to perform the hashing function
   */
  public final HashContent setHashAlgorithm(final String hashAlgorithm) {
    properties.put(HASH_ALGORITHM_PROPERTY, hashAlgorithm);
    return this;
  }

  /**
   * Determines what hashing algorithm should be used to perform the hashing function
   */
  public final HashContent removeHashAlgorithm() {
    properties.remove(HASH_ALGORITHM_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final HashContent setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final HashContent removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<HashContent, HashContent> configurator) {
    return configurator.apply(new HashContent()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = HashContent.class) final Closure<HashContent> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.HashContent> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.HashContent.class, com.tibtech.nifi.processors.standard.HashContent.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<HashContent, HashContent> configurator) {
    return configurator.apply(new HashContent(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = HashContent.class) final Closure<HashContent> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.HashContent> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.HashContent.class, com.tibtech.nifi.processors.standard.HashContent.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
