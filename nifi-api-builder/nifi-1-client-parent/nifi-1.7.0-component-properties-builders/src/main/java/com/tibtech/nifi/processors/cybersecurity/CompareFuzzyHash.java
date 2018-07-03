package com.tibtech.nifi.processors.cybersecurity;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class CompareFuzzyHash {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.cybersecurity.CompareFuzzyHash";

  /**
   * Path to the file containing hashes to be validated against
   */
  public static final String HASH_LIST_FILE_PROPERTY = "HASH_LIST_FILE";

  /**
   * The hashing algorithm utilised
   */
  public static final String HASH_ALGORITHM_PROPERTY = "HASH_ALGORITHM";

  /**
   * The name of the FlowFile Attribute that should hold the Fuzzy Hash Value
   */
  public static final String ATTRIBUTE_NAME_PROPERTY = "ATTRIBUTE_NAME";

  /**
   * The similarity score must exceed or be equal to in order formatch to be considered true. Refer to Additional Information for differences between TLSH and SSDEEP scores and how they relate to this property.
   */
  public static final String MATCH_THRESHOLD_PROPERTY = "MATCH_THRESHOLD";

  /**
   * Defines if the Processor should try to match as many entries as possible (multi-match) or if it should stop after the first match (single)
   */
  public static final String MATCHING_MODE_PROPERTY = "MATCHING_MODE";

  private final Map<String, String> properties;

  public CompareFuzzyHash() {
    this.properties = new HashMap<>();
  }

  public CompareFuzzyHash(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Path to the file containing hashes to be validated against
   */
  public final String getHashListFile() {
    return properties.get(HASH_LIST_FILE_PROPERTY);
  }

  /**
   * Path to the file containing hashes to be validated against
   */
  public final CompareFuzzyHash setHashListFile(final String hashListFile) {
    properties.put(HASH_LIST_FILE_PROPERTY, hashListFile);
    return this;
  }

  /**
   * Path to the file containing hashes to be validated against
   */
  public final CompareFuzzyHash removeHashListFile() {
    properties.remove(HASH_LIST_FILE_PROPERTY);
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
  public final CompareFuzzyHash setHashAlgorithm(final String hashAlgorithm) {
    properties.put(HASH_ALGORITHM_PROPERTY, hashAlgorithm);
    return this;
  }

  /**
   * The hashing algorithm utilised
   */
  public final CompareFuzzyHash removeHashAlgorithm() {
    properties.remove(HASH_ALGORITHM_PROPERTY);
    return this;
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
  public final CompareFuzzyHash setAttributeName(final String attributeName) {
    properties.put(ATTRIBUTE_NAME_PROPERTY, attributeName);
    return this;
  }

  /**
   * The name of the FlowFile Attribute that should hold the Fuzzy Hash Value
   */
  public final CompareFuzzyHash removeAttributeName() {
    properties.remove(ATTRIBUTE_NAME_PROPERTY);
    return this;
  }

  /**
   * The similarity score must exceed or be equal to in order formatch to be considered true. Refer to Additional Information for differences between TLSH and SSDEEP scores and how they relate to this property.
   */
  public final String getMatchThreshold() {
    return properties.get(MATCH_THRESHOLD_PROPERTY);
  }

  /**
   * The similarity score must exceed or be equal to in order formatch to be considered true. Refer to Additional Information for differences between TLSH and SSDEEP scores and how they relate to this property.
   */
  public final CompareFuzzyHash setMatchThreshold(final String matchThreshold) {
    properties.put(MATCH_THRESHOLD_PROPERTY, matchThreshold);
    return this;
  }

  /**
   * The similarity score must exceed or be equal to in order formatch to be considered true. Refer to Additional Information for differences between TLSH and SSDEEP scores and how they relate to this property.
   */
  public final CompareFuzzyHash removeMatchThreshold() {
    properties.remove(MATCH_THRESHOLD_PROPERTY);
    return this;
  }

  /**
   * Defines if the Processor should try to match as many entries as possible (multi-match) or if it should stop after the first match (single)
   */
  public final String getMatchingMode() {
    return properties.get(MATCHING_MODE_PROPERTY);
  }

  /**
   * Defines if the Processor should try to match as many entries as possible (multi-match) or if it should stop after the first match (single)
   */
  public final CompareFuzzyHash setMatchingMode(final String matchingMode) {
    properties.put(MATCHING_MODE_PROPERTY, matchingMode);
    return this;
  }

  /**
   * Defines if the Processor should try to match as many entries as possible (multi-match) or if it should stop after the first match (single)
   */
  public final CompareFuzzyHash removeMatchingMode() {
    properties.remove(MATCHING_MODE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final CompareFuzzyHash setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final CompareFuzzyHash removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<CompareFuzzyHash, CompareFuzzyHash> configurator) {
    return configurator.apply(new CompareFuzzyHash()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CompareFuzzyHash.class) final Closure<CompareFuzzyHash> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.cybersecurity.CompareFuzzyHash> code = closure.rehydrate(c, com.tibtech.nifi.processors.cybersecurity.CompareFuzzyHash.class, com.tibtech.nifi.processors.cybersecurity.CompareFuzzyHash.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<CompareFuzzyHash, CompareFuzzyHash> configurator) {
    return configurator.apply(new CompareFuzzyHash(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CompareFuzzyHash.class) final Closure<CompareFuzzyHash> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.cybersecurity.CompareFuzzyHash> code = closure.rehydrate(c, com.tibtech.nifi.processors.cybersecurity.CompareFuzzyHash.class, com.tibtech.nifi.processors.cybersecurity.CompareFuzzyHash.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
