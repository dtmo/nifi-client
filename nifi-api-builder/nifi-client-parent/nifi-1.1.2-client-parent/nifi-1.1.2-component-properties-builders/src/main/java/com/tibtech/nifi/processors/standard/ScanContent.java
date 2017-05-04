package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ScanContent {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ScanContent";

  /**
   * The filename of the terms dictionary
   */
  public static final String DICTIONARY_FILE_PROPERTY = "Dictionary File";

  /**
   * Indicates how the dictionary is encoded. If 'text', dictionary terms are new-line delimited and UTF-8 encoded; if 'binary', dictionary terms are denoted by a 4-byte integer indicating the term length followed by the term itself
   */
  public static final String DICTIONARY_ENCODING_PROPERTY = "Dictionary Encoding";

  private final Map<String, String> properties;

  public ScanContent() {
    this.properties = new HashMap<>();
  }

  public ScanContent(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The filename of the terms dictionary
   */
  public final String getDictionaryFile() {
    return properties.get(DICTIONARY_FILE_PROPERTY);
  }

  /**
   * The filename of the terms dictionary
   */
  public final ScanContent setDictionaryFile(final String dictionaryFile) {
    properties.put(DICTIONARY_FILE_PROPERTY, dictionaryFile);
    return this;
  }

  /**
   * The filename of the terms dictionary
   */
  public final ScanContent removeDictionaryFile() {
    properties.remove(DICTIONARY_FILE_PROPERTY);
    return this;
  }

  /**
   * Indicates how the dictionary is encoded. If 'text', dictionary terms are new-line delimited and UTF-8 encoded; if 'binary', dictionary terms are denoted by a 4-byte integer indicating the term length followed by the term itself
   */
  public final String getDictionaryEncoding() {
    return properties.get(DICTIONARY_ENCODING_PROPERTY);
  }

  /**
   * Indicates how the dictionary is encoded. If 'text', dictionary terms are new-line delimited and UTF-8 encoded; if 'binary', dictionary terms are denoted by a 4-byte integer indicating the term length followed by the term itself
   */
  public final ScanContent setDictionaryEncoding(final String dictionaryEncoding) {
    properties.put(DICTIONARY_ENCODING_PROPERTY, dictionaryEncoding);
    return this;
  }

  /**
   * Indicates how the dictionary is encoded. If 'text', dictionary terms are new-line delimited and UTF-8 encoded; if 'binary', dictionary terms are denoted by a 4-byte integer indicating the term length followed by the term itself
   */
  public final ScanContent removeDictionaryEncoding() {
    properties.remove(DICTIONARY_ENCODING_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ScanContent setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ScanContent removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ScanContent, ScanContent> configurator) {
    return configurator.apply(new ScanContent()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ScanContent.class) final Closure<ScanContent> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ScanContent> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ScanContent.class, com.tibtech.nifi.processors.standard.ScanContent.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ScanContent, ScanContent> configurator) {
    return configurator.apply(new ScanContent(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ScanContent.class) final Closure<ScanContent> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.ScanContent> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ScanContent.class, com.tibtech.nifi.processors.standard.ScanContent.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
