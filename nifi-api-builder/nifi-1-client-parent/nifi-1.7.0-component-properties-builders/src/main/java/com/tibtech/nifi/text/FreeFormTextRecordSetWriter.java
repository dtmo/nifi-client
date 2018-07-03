package com.tibtech.nifi.text;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class FreeFormTextRecordSetWriter {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.text.FreeFormTextRecordSetWriter";

  /**
   * The text to use when writing the results. This property will evaluate the Expression Language using any of the fields available in a Record.
   */
  public static final String TEXT_PROPERTY = "Text";

  /**
   * The Character set to use when writing the data to the FlowFile
   */
  public static final String CHARACTER_SET_PROPERTY = "Character Set";

  private final Map<String, String> properties;

  public FreeFormTextRecordSetWriter() {
    this.properties = new HashMap<>();
  }

  public FreeFormTextRecordSetWriter(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The text to use when writing the results. This property will evaluate the Expression Language using any of the fields available in a Record.
   */
  public final String getText() {
    return properties.get(TEXT_PROPERTY);
  }

  /**
   * The text to use when writing the results. This property will evaluate the Expression Language using any of the fields available in a Record.
   */
  public final FreeFormTextRecordSetWriter setText(final String text) {
    properties.put(TEXT_PROPERTY, text);
    return this;
  }

  /**
   * The text to use when writing the results. This property will evaluate the Expression Language using any of the fields available in a Record.
   */
  public final FreeFormTextRecordSetWriter removeText() {
    properties.remove(TEXT_PROPERTY);
    return this;
  }

  /**
   * The Character set to use when writing the data to the FlowFile
   */
  public final String getCharacterSet() {
    return properties.get(CHARACTER_SET_PROPERTY);
  }

  /**
   * The Character set to use when writing the data to the FlowFile
   */
  public final FreeFormTextRecordSetWriter setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * The Character set to use when writing the data to the FlowFile
   */
  public final FreeFormTextRecordSetWriter removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final FreeFormTextRecordSetWriter setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final FreeFormTextRecordSetWriter removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<FreeFormTextRecordSetWriter, FreeFormTextRecordSetWriter> configurator) {
    return configurator.apply(new FreeFormTextRecordSetWriter()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FreeFormTextRecordSetWriter.class) final Closure<FreeFormTextRecordSetWriter> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.text.FreeFormTextRecordSetWriter> code = closure.rehydrate(c, com.tibtech.nifi.text.FreeFormTextRecordSetWriter.class, com.tibtech.nifi.text.FreeFormTextRecordSetWriter.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<FreeFormTextRecordSetWriter, FreeFormTextRecordSetWriter> configurator) {
    return configurator.apply(new FreeFormTextRecordSetWriter(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = FreeFormTextRecordSetWriter.class) final Closure<FreeFormTextRecordSetWriter> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.text.FreeFormTextRecordSetWriter> code = closure.rehydrate(c, com.tibtech.nifi.text.FreeFormTextRecordSetWriter.class, com.tibtech.nifi.text.FreeFormTextRecordSetWriter.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
