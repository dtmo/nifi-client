package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class FlattenJson {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.FlattenJson";

  /**
   * The separator character used for joining keys. Must be a JSON-legal character.
   */
  public static final String FLATTEN_JSON_SEPARATOR_PROPERTY = "flatten-json-separator";

  /**
   * Specifies how json is flattened
   */
  public static final String FLATTEN_MODE_PROPERTY = "flatten-mode";

  private final Map<String, String> properties;

  public FlattenJson() {
    this.properties = new HashMap<>();
  }

  public FlattenJson(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The separator character used for joining keys. Must be a JSON-legal character.
   */
  public final String getFlattenJsonSeparator() {
    return properties.get(FLATTEN_JSON_SEPARATOR_PROPERTY);
  }

  /**
   * The separator character used for joining keys. Must be a JSON-legal character.
   */
  public final FlattenJson setFlattenJsonSeparator(final String flattenJsonSeparator) {
    properties.put(FLATTEN_JSON_SEPARATOR_PROPERTY, flattenJsonSeparator);
    return this;
  }

  /**
   * The separator character used for joining keys. Must be a JSON-legal character.
   */
  public final FlattenJson removeFlattenJsonSeparator() {
    properties.remove(FLATTEN_JSON_SEPARATOR_PROPERTY);
    return this;
  }

  /**
   * Specifies how json is flattened
   */
  public final String getFlattenMode() {
    return properties.get(FLATTEN_MODE_PROPERTY);
  }

  /**
   * Specifies how json is flattened
   */
  public final FlattenJson setFlattenMode(final String flattenMode) {
    properties.put(FLATTEN_MODE_PROPERTY, flattenMode);
    return this;
  }

  /**
   * Specifies how json is flattened
   */
  public final FlattenJson removeFlattenMode() {
    properties.remove(FLATTEN_MODE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final FlattenJson setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final FlattenJson removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<FlattenJson, FlattenJson> configurator) {
    return configurator.apply(new FlattenJson()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FlattenJson.class) final Closure<FlattenJson> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.FlattenJson> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.FlattenJson.class, com.tibtech.nifi.processors.standard.FlattenJson.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<FlattenJson, FlattenJson> configurator) {
    return configurator.apply(new FlattenJson(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FlattenJson.class) final Closure<FlattenJson> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.FlattenJson> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.FlattenJson.class, com.tibtech.nifi.processors.standard.FlattenJson.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
