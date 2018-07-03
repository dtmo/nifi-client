package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ParseCEF {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ParseCEF";

  /**
   * Indicates whether the results of the CEF parser are written to the FlowFile content or a FlowFile attribute; if using flowfile-attributeattribute, fields will be populated as attributes. If set to flowfile-content, the CEF extension field will be converted into a flat JSON object.
   */
  public static final String FIELDS_DESTINATION_PROPERTY = "FIELDS_DESTINATION";

  /**
   * When using flowfile-content (i.e. JSON output), add the original CEF message to the resulting JSON object. The original message is added as a string to _raw.
   */
  public static final String APPEND_RAW_MESSAGE_TO_JSON_PROPERTY = "APPEND_RAW_MESSAGE_TO_JSON";

  /**
   * Timezone to be used when representing date fields. UTC will convert all dates to UTC, while Local Timezone will convert them to the timezone used by NiFi.
   */
  public static final String TIME_REPRESENTATION_PROPERTY = "TIME_REPRESENTATION";

  /**
   * The IETF BCP 47 representation of the Locale to be used when parsing date fields with long or short month names (e.g. may <en-US> vs. mai. <fr-FR>. The defaultvalue is generally safe. Only change if having issues parsing CEF messages
   */
  public static final String DATETIME_REPRESENTATION_PROPERTY = "DATETIME_REPRESENTATION";

  private final Map<String, String> properties;

  public ParseCEF() {
    this.properties = new HashMap<>();
  }

  public ParseCEF(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Indicates whether the results of the CEF parser are written to the FlowFile content or a FlowFile attribute; if using flowfile-attributeattribute, fields will be populated as attributes. If set to flowfile-content, the CEF extension field will be converted into a flat JSON object.
   */
  public final String getFieldsDestination() {
    return properties.get(FIELDS_DESTINATION_PROPERTY);
  }

  /**
   * Indicates whether the results of the CEF parser are written to the FlowFile content or a FlowFile attribute; if using flowfile-attributeattribute, fields will be populated as attributes. If set to flowfile-content, the CEF extension field will be converted into a flat JSON object.
   */
  public final ParseCEF setFieldsDestination(final String fieldsDestination) {
    properties.put(FIELDS_DESTINATION_PROPERTY, fieldsDestination);
    return this;
  }

  /**
   * Indicates whether the results of the CEF parser are written to the FlowFile content or a FlowFile attribute; if using flowfile-attributeattribute, fields will be populated as attributes. If set to flowfile-content, the CEF extension field will be converted into a flat JSON object.
   */
  public final ParseCEF removeFieldsDestination() {
    properties.remove(FIELDS_DESTINATION_PROPERTY);
    return this;
  }

  /**
   * When using flowfile-content (i.e. JSON output), add the original CEF message to the resulting JSON object. The original message is added as a string to _raw.
   */
  public final String getAppendRawMessageToJson() {
    return properties.get(APPEND_RAW_MESSAGE_TO_JSON_PROPERTY);
  }

  /**
   * When using flowfile-content (i.e. JSON output), add the original CEF message to the resulting JSON object. The original message is added as a string to _raw.
   */
  public final ParseCEF setAppendRawMessageToJson(final String appendRawMessageToJson) {
    properties.put(APPEND_RAW_MESSAGE_TO_JSON_PROPERTY, appendRawMessageToJson);
    return this;
  }

  /**
   * When using flowfile-content (i.e. JSON output), add the original CEF message to the resulting JSON object. The original message is added as a string to _raw.
   */
  public final ParseCEF removeAppendRawMessageToJson() {
    properties.remove(APPEND_RAW_MESSAGE_TO_JSON_PROPERTY);
    return this;
  }

  /**
   * Timezone to be used when representing date fields. UTC will convert all dates to UTC, while Local Timezone will convert them to the timezone used by NiFi.
   */
  public final String getTimeRepresentation() {
    return properties.get(TIME_REPRESENTATION_PROPERTY);
  }

  /**
   * Timezone to be used when representing date fields. UTC will convert all dates to UTC, while Local Timezone will convert them to the timezone used by NiFi.
   */
  public final ParseCEF setTimeRepresentation(final String timeRepresentation) {
    properties.put(TIME_REPRESENTATION_PROPERTY, timeRepresentation);
    return this;
  }

  /**
   * Timezone to be used when representing date fields. UTC will convert all dates to UTC, while Local Timezone will convert them to the timezone used by NiFi.
   */
  public final ParseCEF removeTimeRepresentation() {
    properties.remove(TIME_REPRESENTATION_PROPERTY);
    return this;
  }

  /**
   * The IETF BCP 47 representation of the Locale to be used when parsing date fields with long or short month names (e.g. may <en-US> vs. mai. <fr-FR>. The defaultvalue is generally safe. Only change if having issues parsing CEF messages
   */
  public final String getDatetimeRepresentation() {
    return properties.get(DATETIME_REPRESENTATION_PROPERTY);
  }

  /**
   * The IETF BCP 47 representation of the Locale to be used when parsing date fields with long or short month names (e.g. may <en-US> vs. mai. <fr-FR>. The defaultvalue is generally safe. Only change if having issues parsing CEF messages
   */
  public final ParseCEF setDatetimeRepresentation(final String datetimeRepresentation) {
    properties.put(DATETIME_REPRESENTATION_PROPERTY, datetimeRepresentation);
    return this;
  }

  /**
   * The IETF BCP 47 representation of the Locale to be used when parsing date fields with long or short month names (e.g. may <en-US> vs. mai. <fr-FR>. The defaultvalue is generally safe. Only change if having issues parsing CEF messages
   */
  public final ParseCEF removeDatetimeRepresentation() {
    properties.remove(DATETIME_REPRESENTATION_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ParseCEF setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ParseCEF removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ParseCEF, ParseCEF> configurator) {
    return configurator.apply(new ParseCEF()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ParseCEF.class) final Closure<ParseCEF> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ParseCEF> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ParseCEF.class, com.tibtech.nifi.processors.standard.ParseCEF.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ParseCEF, ParseCEF> configurator) {
    return configurator.apply(new ParseCEF(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ParseCEF.class) final Closure<ParseCEF> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.ParseCEF> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ParseCEF.class, com.tibtech.nifi.processors.standard.ParseCEF.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
