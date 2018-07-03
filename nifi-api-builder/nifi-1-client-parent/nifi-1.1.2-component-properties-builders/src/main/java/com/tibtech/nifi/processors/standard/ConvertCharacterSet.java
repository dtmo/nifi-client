package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ConvertCharacterSet {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ConvertCharacterSet";

  /**
   * The name of the CharacterSet to expect for Input
   */
  public static final String INPUT_CHARACTER_SET_PROPERTY = "Input Character Set";

  /**
   * The name of the CharacterSet to convert to
   */
  public static final String OUTPUT_CHARACTER_SET_PROPERTY = "Output Character Set";

  private final Map<String, String> properties;

  public ConvertCharacterSet() {
    this.properties = new HashMap<>();
  }

  public ConvertCharacterSet(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The name of the CharacterSet to expect for Input
   */
  public final String getInputCharacterSet() {
    return properties.get(INPUT_CHARACTER_SET_PROPERTY);
  }

  /**
   * The name of the CharacterSet to expect for Input
   */
  public final ConvertCharacterSet setInputCharacterSet(final String inputCharacterSet) {
    properties.put(INPUT_CHARACTER_SET_PROPERTY, inputCharacterSet);
    return this;
  }

  /**
   * The name of the CharacterSet to expect for Input
   */
  public final ConvertCharacterSet removeInputCharacterSet() {
    properties.remove(INPUT_CHARACTER_SET_PROPERTY);
    return this;
  }

  /**
   * The name of the CharacterSet to convert to
   */
  public final String getOutputCharacterSet() {
    return properties.get(OUTPUT_CHARACTER_SET_PROPERTY);
  }

  /**
   * The name of the CharacterSet to convert to
   */
  public final ConvertCharacterSet setOutputCharacterSet(final String outputCharacterSet) {
    properties.put(OUTPUT_CHARACTER_SET_PROPERTY, outputCharacterSet);
    return this;
  }

  /**
   * The name of the CharacterSet to convert to
   */
  public final ConvertCharacterSet removeOutputCharacterSet() {
    properties.remove(OUTPUT_CHARACTER_SET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ConvertCharacterSet setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ConvertCharacterSet removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ConvertCharacterSet, ConvertCharacterSet> configurator) {
    return configurator.apply(new ConvertCharacterSet()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConvertCharacterSet.class) final Closure<ConvertCharacterSet> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ConvertCharacterSet> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ConvertCharacterSet.class, com.tibtech.nifi.processors.standard.ConvertCharacterSet.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ConvertCharacterSet, ConvertCharacterSet> configurator) {
    return configurator.apply(new ConvertCharacterSet(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConvertCharacterSet.class) final Closure<ConvertCharacterSet> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.ConvertCharacterSet> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ConvertCharacterSet.class, com.tibtech.nifi.processors.standard.ConvertCharacterSet.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
