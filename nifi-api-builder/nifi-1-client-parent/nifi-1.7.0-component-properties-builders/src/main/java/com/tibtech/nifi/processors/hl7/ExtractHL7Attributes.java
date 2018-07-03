package com.tibtech.nifi.processors.hl7;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ExtractHL7Attributes {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.hl7.ExtractHL7Attributes";

  /**
   * The Character Encoding that is used to encode the HL7 data
   */
  public static final String CHARACTER_ENCODING_PROPERTY = "Character Encoding";

  /**
   * Whether or not to use HL7 segment names in attributes
   */
  public static final String USE_SEGMENT_NAMES_PROPERTY = "use-segment-names";

  /**
   * Whether or not to parse HL7 segment fields into attributes
   */
  public static final String PARSE_SEGMENT_FIELDS_PROPERTY = "parse-segment-fields";

  /**
   * Whether or not to validate HL7 message values
   */
  public static final String SKIP_VALIDATION_PROPERTY = "skip-validation";

  /**
   * The HL7 version to use for parsing and validation
   */
  public static final String HL_7_INPUT_VERSION_PROPERTY = "hl7-input-version";

  private final Map<String, String> properties;

  public ExtractHL7Attributes() {
    this.properties = new HashMap<>();
  }

  public ExtractHL7Attributes(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The Character Encoding that is used to encode the HL7 data
   */
  public final String getCharacterEncoding() {
    return properties.get(CHARACTER_ENCODING_PROPERTY);
  }

  /**
   * The Character Encoding that is used to encode the HL7 data
   */
  public final ExtractHL7Attributes setCharacterEncoding(final String characterEncoding) {
    properties.put(CHARACTER_ENCODING_PROPERTY, characterEncoding);
    return this;
  }

  /**
   * The Character Encoding that is used to encode the HL7 data
   */
  public final ExtractHL7Attributes removeCharacterEncoding() {
    properties.remove(CHARACTER_ENCODING_PROPERTY);
    return this;
  }

  /**
   * Whether or not to use HL7 segment names in attributes
   */
  public final String getUseSegmentNames() {
    return properties.get(USE_SEGMENT_NAMES_PROPERTY);
  }

  /**
   * Whether or not to use HL7 segment names in attributes
   */
  public final ExtractHL7Attributes setUseSegmentNames(final String useSegmentNames) {
    properties.put(USE_SEGMENT_NAMES_PROPERTY, useSegmentNames);
    return this;
  }

  /**
   * Whether or not to use HL7 segment names in attributes
   */
  public final ExtractHL7Attributes removeUseSegmentNames() {
    properties.remove(USE_SEGMENT_NAMES_PROPERTY);
    return this;
  }

  /**
   * Whether or not to parse HL7 segment fields into attributes
   */
  public final String getParseSegmentFields() {
    return properties.get(PARSE_SEGMENT_FIELDS_PROPERTY);
  }

  /**
   * Whether or not to parse HL7 segment fields into attributes
   */
  public final ExtractHL7Attributes setParseSegmentFields(final String parseSegmentFields) {
    properties.put(PARSE_SEGMENT_FIELDS_PROPERTY, parseSegmentFields);
    return this;
  }

  /**
   * Whether or not to parse HL7 segment fields into attributes
   */
  public final ExtractHL7Attributes removeParseSegmentFields() {
    properties.remove(PARSE_SEGMENT_FIELDS_PROPERTY);
    return this;
  }

  /**
   * Whether or not to validate HL7 message values
   */
  public final String getSkipValidation() {
    return properties.get(SKIP_VALIDATION_PROPERTY);
  }

  /**
   * Whether or not to validate HL7 message values
   */
  public final ExtractHL7Attributes setSkipValidation(final String skipValidation) {
    properties.put(SKIP_VALIDATION_PROPERTY, skipValidation);
    return this;
  }

  /**
   * Whether or not to validate HL7 message values
   */
  public final ExtractHL7Attributes removeSkipValidation() {
    properties.remove(SKIP_VALIDATION_PROPERTY);
    return this;
  }

  /**
   * The HL7 version to use for parsing and validation
   */
  public final String getHl7InputVersion() {
    return properties.get(HL_7_INPUT_VERSION_PROPERTY);
  }

  /**
   * The HL7 version to use for parsing and validation
   */
  public final ExtractHL7Attributes setHl7InputVersion(final String hl7InputVersion) {
    properties.put(HL_7_INPUT_VERSION_PROPERTY, hl7InputVersion);
    return this;
  }

  /**
   * The HL7 version to use for parsing and validation
   */
  public final ExtractHL7Attributes removeHl7InputVersion() {
    properties.remove(HL_7_INPUT_VERSION_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ExtractHL7Attributes setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ExtractHL7Attributes removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ExtractHL7Attributes, ExtractHL7Attributes> configurator) {
    return configurator.apply(new ExtractHL7Attributes()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExtractHL7Attributes.class) final Closure<ExtractHL7Attributes> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.hl7.ExtractHL7Attributes> code = closure.rehydrate(c, com.tibtech.nifi.processors.hl7.ExtractHL7Attributes.class, com.tibtech.nifi.processors.hl7.ExtractHL7Attributes.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ExtractHL7Attributes, ExtractHL7Attributes> configurator) {
    return configurator.apply(new ExtractHL7Attributes(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExtractHL7Attributes.class) final Closure<ExtractHL7Attributes> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.hl7.ExtractHL7Attributes> code = closure.rehydrate(c, com.tibtech.nifi.processors.hl7.ExtractHL7Attributes.class, com.tibtech.nifi.processors.hl7.ExtractHL7Attributes.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
