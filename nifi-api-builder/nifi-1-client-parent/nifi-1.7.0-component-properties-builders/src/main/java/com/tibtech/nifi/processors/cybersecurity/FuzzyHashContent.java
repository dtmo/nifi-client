package com.tibtech.nifi.processors.cybersecurity;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class FuzzyHashContent {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.cybersecurity.FuzzyHashContent";

  /**
   * The name of the FlowFile Attribute that should hold the Fuzzy Hash Value
   */
  public static final String ATTRIBUTE_NAME_PROPERTY = "ATTRIBUTE_NAME";

  /**
   * The hashing algorithm utilised
   */
  public static final String HASH_ALGORITHM_PROPERTY = "HASH_ALGORITHM";

  private final Map<String, String> properties;

  public FuzzyHashContent() {
    this.properties = new HashMap<>();
  }

  public FuzzyHashContent(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The name of the FlowFile Attribute that should hold the Fuzzy Hash Value
   */
  public final String getAttributeName() {
    return properties.get(ATTRIBUTE_NAME_PROPERTY);
  }

  /**
   * The name of the FlowFile Attribute that should hold the Fuzzy Hash Value
   */
  public final FuzzyHashContent setAttributeName(final String attributeName) {
    properties.put(ATTRIBUTE_NAME_PROPERTY, attributeName);
    return this;
  }

  /**
   * The name of the FlowFile Attribute that should hold the Fuzzy Hash Value
   */
  public final FuzzyHashContent removeAttributeName() {
    properties.remove(ATTRIBUTE_NAME_PROPERTY);
    return this;
  }

  /**
   * The hashing algorithm utilised
   */
  public final String getHashAlgorithm() {
    return properties.get(HASH_ALGORITHM_PROPERTY);
  }

  /**
   * The hashing algorithm utilised
   */
  public final FuzzyHashContent setHashAlgorithm(final String hashAlgorithm) {
    properties.put(HASH_ALGORITHM_PROPERTY, hashAlgorithm);
    return this;
  }

  /**
   * The hashing algorithm utilised
   */
  public final FuzzyHashContent removeHashAlgorithm() {
    properties.remove(HASH_ALGORITHM_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final FuzzyHashContent setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final FuzzyHashContent removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<FuzzyHashContent, FuzzyHashContent> configurator) {
    return configurator.apply(new FuzzyHashContent()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FuzzyHashContent.class) final Closure<FuzzyHashContent> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.cybersecurity.FuzzyHashContent> code = closure.rehydrate(c, com.tibtech.nifi.processors.cybersecurity.FuzzyHashContent.class, com.tibtech.nifi.processors.cybersecurity.FuzzyHashContent.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<FuzzyHashContent, FuzzyHashContent> configurator) {
    return configurator.apply(new FuzzyHashContent(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FuzzyHashContent.class) final Closure<FuzzyHashContent> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.cybersecurity.FuzzyHashContent> code = closure.rehydrate(c, com.tibtech.nifi.processors.cybersecurity.FuzzyHashContent.class, com.tibtech.nifi.processors.cybersecurity.FuzzyHashContent.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
