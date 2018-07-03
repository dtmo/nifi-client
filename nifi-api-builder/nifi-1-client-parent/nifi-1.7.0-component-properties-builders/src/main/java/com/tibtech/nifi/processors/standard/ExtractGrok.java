package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ExtractGrok {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ExtractGrok";

  /**
   * Grok expression. If other Grok expressions are referenced in this expression, they must be provided in the Grok Pattern File if set or exist in the default Grok patterns
   */
  public static final String GROK_EXPRESSION_PROPERTY = "Grok Expression";

  /**
   * Grok Pattern file definition.  This file will be loaded after the default Grok patterns file.  If not set, then only the Grok Expression and the default Grok patterns will be used.
   */
  public static final String GROK_PATTERN_FILE_PROPERTY = "Grok Pattern file";

  /**
   * Control if Grok output value is written as a new flowfile attributes, in this case each of the Grok identifier that is matched in the flowfile will be added as an attribute, prefixed with "grok." or written in the flowfile content. Writing to flowfile content will overwrite any existing flowfile content.
   */
  public static final String DESTINATION_PROPERTY = "Destination";

  /**
   * The Character Set in which the file is encoded
   */
  public static final String CHARACTER_SET_PROPERTY = "Character Set";

  /**
   * Specifies the maximum amount of data to buffer (per file) in order to apply the Grok expressions. Files larger than the specified maximum will not be fully evaluated.
   */
  public static final String MAXIMUM_BUFFER_SIZE_PROPERTY = "Maximum Buffer Size";

  /**
   * Only store named captures from grok
   */
  public static final String NAMED_CAPTURES_ONLY_PROPERTY = "Named captures only";

  /**
   * If true, then empty capture values will be included in the returned capture map.
   */
  public static final String KEEP_EMPTY_CAPTURES_PROPERTY = "Keep Empty Captures";

  private final Map<String, String> properties;

  public ExtractGrok() {
    this.properties = new HashMap<>();
  }

  public ExtractGrok(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Grok expression. If other Grok expressions are referenced in this expression, they must be provided in the Grok Pattern File if set or exist in the default Grok patterns
   */
  public final String getGrokExpression() {
    return properties.get(GROK_EXPRESSION_PROPERTY);
  }

  /**
   * Grok expression. If other Grok expressions are referenced in this expression, they must be provided in the Grok Pattern File if set or exist in the default Grok patterns
   */
  public final ExtractGrok setGrokExpression(final String grokExpression) {
    properties.put(GROK_EXPRESSION_PROPERTY, grokExpression);
    return this;
  }

  /**
   * Grok expression. If other Grok expressions are referenced in this expression, they must be provided in the Grok Pattern File if set or exist in the default Grok patterns
   */
  public final ExtractGrok removeGrokExpression() {
    properties.remove(GROK_EXPRESSION_PROPERTY);
    return this;
  }

  /**
   * Grok Pattern file definition.  This file will be loaded after the default Grok patterns file.  If not set, then only the Grok Expression and the default Grok patterns will be used.
   */
  public final String getGrokPatternFile() {
    return properties.get(GROK_PATTERN_FILE_PROPERTY);
  }

  /**
   * Grok Pattern file definition.  This file will be loaded after the default Grok patterns file.  If not set, then only the Grok Expression and the default Grok patterns will be used.
   */
  public final ExtractGrok setGrokPatternFile(final String grokPatternFile) {
    properties.put(GROK_PATTERN_FILE_PROPERTY, grokPatternFile);
    return this;
  }

  /**
   * Grok Pattern file definition.  This file will be loaded after the default Grok patterns file.  If not set, then only the Grok Expression and the default Grok patterns will be used.
   */
  public final ExtractGrok removeGrokPatternFile() {
    properties.remove(GROK_PATTERN_FILE_PROPERTY);
    return this;
  }

  /**
   * Control if Grok output value is written as a new flowfile attributes, in this case each of the Grok identifier that is matched in the flowfile will be added as an attribute, prefixed with "grok." or written in the flowfile content. Writing to flowfile content will overwrite any existing flowfile content.
   */
  public final String getDestination() {
    return properties.get(DESTINATION_PROPERTY);
  }

  /**
   * Control if Grok output value is written as a new flowfile attributes, in this case each of the Grok identifier that is matched in the flowfile will be added as an attribute, prefixed with "grok." or written in the flowfile content. Writing to flowfile content will overwrite any existing flowfile content.
   */
  public final ExtractGrok setDestination(final String destination) {
    properties.put(DESTINATION_PROPERTY, destination);
    return this;
  }

  /**
   * Control if Grok output value is written as a new flowfile attributes, in this case each of the Grok identifier that is matched in the flowfile will be added as an attribute, prefixed with "grok." or written in the flowfile content. Writing to flowfile content will overwrite any existing flowfile content.
   */
  public final ExtractGrok removeDestination() {
    properties.remove(DESTINATION_PROPERTY);
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
  public final ExtractGrok setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * The Character Set in which the file is encoded
   */
  public final ExtractGrok removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
    return this;
  }

  /**
   * Specifies the maximum amount of data to buffer (per file) in order to apply the Grok expressions. Files larger than the specified maximum will not be fully evaluated.
   */
  public final String getMaximumBufferSize() {
    return properties.get(MAXIMUM_BUFFER_SIZE_PROPERTY);
  }

  /**
   * Specifies the maximum amount of data to buffer (per file) in order to apply the Grok expressions. Files larger than the specified maximum will not be fully evaluated.
   */
  public final ExtractGrok setMaximumBufferSize(final String maximumBufferSize) {
    properties.put(MAXIMUM_BUFFER_SIZE_PROPERTY, maximumBufferSize);
    return this;
  }

  /**
   * Specifies the maximum amount of data to buffer (per file) in order to apply the Grok expressions. Files larger than the specified maximum will not be fully evaluated.
   */
  public final ExtractGrok removeMaximumBufferSize() {
    properties.remove(MAXIMUM_BUFFER_SIZE_PROPERTY);
    return this;
  }

  /**
   * Only store named captures from grok
   */
  public final String getNamedCapturesOnly() {
    return properties.get(NAMED_CAPTURES_ONLY_PROPERTY);
  }

  /**
   * Only store named captures from grok
   */
  public final ExtractGrok setNamedCapturesOnly(final String namedCapturesOnly) {
    properties.put(NAMED_CAPTURES_ONLY_PROPERTY, namedCapturesOnly);
    return this;
  }

  /**
   * Only store named captures from grok
   */
  public final ExtractGrok removeNamedCapturesOnly() {
    properties.remove(NAMED_CAPTURES_ONLY_PROPERTY);
    return this;
  }

  /**
   * If true, then empty capture values will be included in the returned capture map.
   */
  public final String getKeepEmptyCaptures() {
    return properties.get(KEEP_EMPTY_CAPTURES_PROPERTY);
  }

  /**
   * If true, then empty capture values will be included in the returned capture map.
   */
  public final ExtractGrok setKeepEmptyCaptures(final String keepEmptyCaptures) {
    properties.put(KEEP_EMPTY_CAPTURES_PROPERTY, keepEmptyCaptures);
    return this;
  }

  /**
   * If true, then empty capture values will be included in the returned capture map.
   */
  public final ExtractGrok removeKeepEmptyCaptures() {
    properties.remove(KEEP_EMPTY_CAPTURES_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ExtractGrok setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ExtractGrok removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ExtractGrok, ExtractGrok> configurator) {
    return configurator.apply(new ExtractGrok()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExtractGrok.class) final Closure<ExtractGrok> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ExtractGrok> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ExtractGrok.class, com.tibtech.nifi.processors.standard.ExtractGrok.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ExtractGrok, ExtractGrok> configurator) {
    return configurator.apply(new ExtractGrok(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExtractGrok.class) final Closure<ExtractGrok> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.ExtractGrok> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ExtractGrok.class, com.tibtech.nifi.processors.standard.ExtractGrok.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
