package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ReplaceTextWithMapping {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ReplaceTextWithMapping";

  /**
   * The Regular Expression to search for in the FlowFile content
   */
  public static final String REGULAR_EXPRESSION_PROPERTY = "Regular Expression";

  /**
   * The number of the matching group of the provided regex to replace with the corresponding value from the mapping file (if it exists).
   */
  public static final String MATCHING_GROUP_PROPERTY = "Matching Group";

  /**
   * The name of the file (including the full path) containing the Mappings.
   */
  public static final String MAPPING_FILE_PROPERTY = "Mapping File";

  /**
   * The polling interval in seconds to check for updates to the mapping file. The default is 60s.
   */
  public static final String MAPPING_FILE_REFRESH_INTERVAL_PROPERTY = "Mapping File Refresh Interval";

  /**
   * The Character Set in which the file is encoded
   */
  public static final String CHARACTER_SET_PROPERTY = "Character Set";

  /**
   * Specifies the maximum amount of data to buffer (per file) in order to apply the regular expressions. If a FlowFile is larger than this value, the FlowFile will be routed to 'failure'
   */
  public static final String MAXIMUM_BUFFER_SIZE_PROPERTY = "Maximum Buffer Size";

  private final Map<String, String> properties;

  public ReplaceTextWithMapping() {
    this.properties = new HashMap<>();
  }

  public ReplaceTextWithMapping(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The Regular Expression to search for in the FlowFile content
   */
  public final String getRegularExpression() {
    return properties.get(REGULAR_EXPRESSION_PROPERTY);
  }

  /**
   * The Regular Expression to search for in the FlowFile content
   */
  public final ReplaceTextWithMapping setRegularExpression(final String regularExpression) {
    properties.put(REGULAR_EXPRESSION_PROPERTY, regularExpression);
    return this;
  }

  /**
   * The Regular Expression to search for in the FlowFile content
   */
  public final ReplaceTextWithMapping removeRegularExpression() {
    properties.remove(REGULAR_EXPRESSION_PROPERTY);
    return this;
  }

  /**
   * The number of the matching group of the provided regex to replace with the corresponding value from the mapping file (if it exists).
   */
  public final String getMatchingGroup() {
    return properties.get(MATCHING_GROUP_PROPERTY);
  }

  /**
   * The number of the matching group of the provided regex to replace with the corresponding value from the mapping file (if it exists).
   */
  public final ReplaceTextWithMapping setMatchingGroup(final String matchingGroup) {
    properties.put(MATCHING_GROUP_PROPERTY, matchingGroup);
    return this;
  }

  /**
   * The number of the matching group of the provided regex to replace with the corresponding value from the mapping file (if it exists).
   */
  public final ReplaceTextWithMapping removeMatchingGroup() {
    properties.remove(MATCHING_GROUP_PROPERTY);
    return this;
  }

  /**
   * The name of the file (including the full path) containing the Mappings.
   */
  public final String getMappingFile() {
    return properties.get(MAPPING_FILE_PROPERTY);
  }

  /**
   * The name of the file (including the full path) containing the Mappings.
   */
  public final ReplaceTextWithMapping setMappingFile(final String mappingFile) {
    properties.put(MAPPING_FILE_PROPERTY, mappingFile);
    return this;
  }

  /**
   * The name of the file (including the full path) containing the Mappings.
   */
  public final ReplaceTextWithMapping removeMappingFile() {
    properties.remove(MAPPING_FILE_PROPERTY);
    return this;
  }

  /**
   * The polling interval in seconds to check for updates to the mapping file. The default is 60s.
   */
  public final String getMappingFileRefreshInterval() {
    return properties.get(MAPPING_FILE_REFRESH_INTERVAL_PROPERTY);
  }

  /**
   * The polling interval in seconds to check for updates to the mapping file. The default is 60s.
   */
  public final ReplaceTextWithMapping setMappingFileRefreshInterval(
      final String mappingFileRefreshInterval) {
    properties.put(MAPPING_FILE_REFRESH_INTERVAL_PROPERTY, mappingFileRefreshInterval);
    return this;
  }

  /**
   * The polling interval in seconds to check for updates to the mapping file. The default is 60s.
   */
  public final ReplaceTextWithMapping removeMappingFileRefreshInterval() {
    properties.remove(MAPPING_FILE_REFRESH_INTERVAL_PROPERTY);
    return this;
  }

  /**
   * The Character Set in which the file is encoded
   */
  public final String getCharacterSet() {
    return properties.get(CHARACTER_SET_PROPERTY);
  }

  /**
   * The Character Set in which the file is encoded
   */
  public final ReplaceTextWithMapping setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * The Character Set in which the file is encoded
   */
  public final ReplaceTextWithMapping removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
    return this;
  }

  /**
   * Specifies the maximum amount of data to buffer (per file) in order to apply the regular expressions. If a FlowFile is larger than this value, the FlowFile will be routed to 'failure'
   */
  public final String getMaximumBufferSize() {
    return properties.get(MAXIMUM_BUFFER_SIZE_PROPERTY);
  }

  /**
   * Specifies the maximum amount of data to buffer (per file) in order to apply the regular expressions. If a FlowFile is larger than this value, the FlowFile will be routed to 'failure'
   */
  public final ReplaceTextWithMapping setMaximumBufferSize(final String maximumBufferSize) {
    properties.put(MAXIMUM_BUFFER_SIZE_PROPERTY, maximumBufferSize);
    return this;
  }

  /**
   * Specifies the maximum amount of data to buffer (per file) in order to apply the regular expressions. If a FlowFile is larger than this value, the FlowFile will be routed to 'failure'
   */
  public final ReplaceTextWithMapping removeMaximumBufferSize() {
    properties.remove(MAXIMUM_BUFFER_SIZE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ReplaceTextWithMapping setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ReplaceTextWithMapping removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ReplaceTextWithMapping, ReplaceTextWithMapping> configurator) {
    return configurator.apply(new ReplaceTextWithMapping()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ReplaceTextWithMapping.class) final Closure<ReplaceTextWithMapping> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ReplaceTextWithMapping> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ReplaceTextWithMapping.class, com.tibtech.nifi.processors.standard.ReplaceTextWithMapping.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ReplaceTextWithMapping, ReplaceTextWithMapping> configurator) {
    return configurator.apply(new ReplaceTextWithMapping(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ReplaceTextWithMapping.class) final Closure<ReplaceTextWithMapping> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.ReplaceTextWithMapping> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ReplaceTextWithMapping.class, com.tibtech.nifi.processors.standard.ReplaceTextWithMapping.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
