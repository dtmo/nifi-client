package com.tibtech.nifi.processors.ccda;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ExtractCCDAAttributes {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.ccda.ExtractCCDAAttributes";

  /**
   * Whether or not to validate CDA message values
   */
  public static final String SKIP_VALIDATION_PROPERTY = "skip-validation";

  private final Map<String, String> properties;

  public ExtractCCDAAttributes() {
    this.properties = new HashMap<>();
  }

  public ExtractCCDAAttributes(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Whether or not to validate CDA message values
   */
  public final String getSkipValidation() {
    return properties.get(SKIP_VALIDATION_PROPERTY);
  }

  /**
   * Whether or not to validate CDA message values
   */
  public final ExtractCCDAAttributes setSkipValidation(final String skipValidation) {
    properties.put(SKIP_VALIDATION_PROPERTY, skipValidation);
    return this;
  }

  /**
   * Whether or not to validate CDA message values
   */
  public final ExtractCCDAAttributes removeSkipValidation() {
    properties.remove(SKIP_VALIDATION_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ExtractCCDAAttributes setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ExtractCCDAAttributes removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ExtractCCDAAttributes, ExtractCCDAAttributes> configurator) {
    return configurator.apply(new ExtractCCDAAttributes()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExtractCCDAAttributes.class) final Closure<ExtractCCDAAttributes> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.ccda.ExtractCCDAAttributes> code = closure.rehydrate(c, com.tibtech.nifi.processors.ccda.ExtractCCDAAttributes.class, com.tibtech.nifi.processors.ccda.ExtractCCDAAttributes.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ExtractCCDAAttributes, ExtractCCDAAttributes> configurator) {
    return configurator.apply(new ExtractCCDAAttributes(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExtractCCDAAttributes.class) final Closure<ExtractCCDAAttributes> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.ccda.ExtractCCDAAttributes> code = closure.rehydrate(c, com.tibtech.nifi.processors.ccda.ExtractCCDAAttributes.class, com.tibtech.nifi.processors.ccda.ExtractCCDAAttributes.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
