package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class RouteOnContent {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.RouteOnContent";

  /**
   * Specifies whether the entire content of the file must match the regular expression exactly, or if any part of the file (up to Content Buffer Size) can contain the regular expression in order to be considered a match
   */
  public static final String MATCH_REQUIREMENT_PROPERTY = "Match Requirement";

  /**
   * The Character Set in which the file is encoded
   */
  public static final String CHARACTER_SET_PROPERTY = "Character Set";

  /**
   * Specifies the maximum amount of data to buffer in order to apply the regular expressions. If the size of the FlowFile exceeds this value, any amount of this value will be ignored
   */
  public static final String CONTENT_BUFFER_SIZE_PROPERTY = "Content Buffer Size";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Specifies whether the entire content of the file must match the regular expression exactly, or if any part of the file (up to Content Buffer Size) can contain the regular expression in order to be considered a match
   */
  public final String getMatchRequirement() {
    return properties.get(MATCH_REQUIREMENT_PROPERTY);
  }

  /**
   * Specifies whether the entire content of the file must match the regular expression exactly, or if any part of the file (up to Content Buffer Size) can contain the regular expression in order to be considered a match
   */
  public final RouteOnContent setMatchRequirement(final String matchRequirement) {
    properties.put(MATCH_REQUIREMENT_PROPERTY, matchRequirement);
    return this;
  }

  /**
   * Specifies whether the entire content of the file must match the regular expression exactly, or if any part of the file (up to Content Buffer Size) can contain the regular expression in order to be considered a match
   */
  public final RouteOnContent removeMatchRequirement() {
    properties.remove(MATCH_REQUIREMENT_PROPERTY);
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
  public final RouteOnContent setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * The Character Set in which the file is encoded
   */
  public final RouteOnContent removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
    return this;
  }

  /**
   * Specifies the maximum amount of data to buffer in order to apply the regular expressions. If the size of the FlowFile exceeds this value, any amount of this value will be ignored
   */
  public final String getContentBufferSize() {
    return properties.get(CONTENT_BUFFER_SIZE_PROPERTY);
  }

  /**
   * Specifies the maximum amount of data to buffer in order to apply the regular expressions. If the size of the FlowFile exceeds this value, any amount of this value will be ignored
   */
  public final RouteOnContent setContentBufferSize(final String contentBufferSize) {
    properties.put(CONTENT_BUFFER_SIZE_PROPERTY, contentBufferSize);
    return this;
  }

  /**
   * Specifies the maximum amount of data to buffer in order to apply the regular expressions. If the size of the FlowFile exceeds this value, any amount of this value will be ignored
   */
  public final RouteOnContent removeContentBufferSize() {
    properties.remove(CONTENT_BUFFER_SIZE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final RouteOnContent setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final RouteOnContent removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<RouteOnContent, RouteOnContent> configurator) {
    return configurator.apply(new RouteOnContent()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = RouteOnContent.class) final Closure<RouteOnContent> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.RouteOnContent> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.RouteOnContent.class, com.tibtech.nifi.processors.standard.RouteOnContent.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
