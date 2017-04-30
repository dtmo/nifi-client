package com.tibtech.nifi.processors.avro;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ConvertAvroToJSON {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.avro.ConvertAvroToJSON";

  /**
   * Determines how stream of records is exposed: either as a sequence of single Objects (none) (i.e. writing every Object to a new line), or as an array of Objects (array).
   */
  public static final String JSON_CONTAINER_OPTIONS_PROPERTY = "JSON container options";

  /**
   * Determines if the resulting output for empty records or a single record should be wrapped in a container array as specified by 'JSON container options'
   */
  public static final String WRAP_SINGLE_RECORD_PROPERTY = "Wrap Single Record";

  /**
   * If the Avro records do not contain the schema (datum only), it must be specified here.
   */
  public static final String AVRO_SCHEMA_PROPERTY = "Avro schema";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Determines how stream of records is exposed: either as a sequence of single Objects (none) (i.e. writing every Object to a new line), or as an array of Objects (array).
   */
  public final String getJsonContainerOptions() {
    return properties.get(JSON_CONTAINER_OPTIONS_PROPERTY);
  }

  /**
   * Determines how stream of records is exposed: either as a sequence of single Objects (none) (i.e. writing every Object to a new line), or as an array of Objects (array).
   */
  public final ConvertAvroToJSON setJsonContainerOptions(final String jsonContainerOptions) {
    properties.put(JSON_CONTAINER_OPTIONS_PROPERTY, jsonContainerOptions);
    return this;
  }

  /**
   * Determines how stream of records is exposed: either as a sequence of single Objects (none) (i.e. writing every Object to a new line), or as an array of Objects (array).
   */
  public final ConvertAvroToJSON removeJsonContainerOptions() {
    properties.remove(JSON_CONTAINER_OPTIONS_PROPERTY);
    return this;
  }

  /**
   * Determines if the resulting output for empty records or a single record should be wrapped in a container array as specified by 'JSON container options'
   */
  public final String getWrapSingleRecord() {
    return properties.get(WRAP_SINGLE_RECORD_PROPERTY);
  }

  /**
   * Determines if the resulting output for empty records or a single record should be wrapped in a container array as specified by 'JSON container options'
   */
  public final ConvertAvroToJSON setWrapSingleRecord(final String wrapSingleRecord) {
    properties.put(WRAP_SINGLE_RECORD_PROPERTY, wrapSingleRecord);
    return this;
  }

  /**
   * Determines if the resulting output for empty records or a single record should be wrapped in a container array as specified by 'JSON container options'
   */
  public final ConvertAvroToJSON removeWrapSingleRecord() {
    properties.remove(WRAP_SINGLE_RECORD_PROPERTY);
    return this;
  }

  /**
   * If the Avro records do not contain the schema (datum only), it must be specified here.
   */
  public final String getAvroSchema() {
    return properties.get(AVRO_SCHEMA_PROPERTY);
  }

  /**
   * If the Avro records do not contain the schema (datum only), it must be specified here.
   */
  public final ConvertAvroToJSON setAvroSchema(final String avroSchema) {
    properties.put(AVRO_SCHEMA_PROPERTY, avroSchema);
    return this;
  }

  /**
   * If the Avro records do not contain the schema (datum only), it must be specified here.
   */
  public final ConvertAvroToJSON removeAvroSchema() {
    properties.remove(AVRO_SCHEMA_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ConvertAvroToJSON setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ConvertAvroToJSON removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ConvertAvroToJSON, ConvertAvroToJSON> configurator) {
    return configurator.apply(new ConvertAvroToJSON()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConvertAvroToJSON.class) final Closure<ConvertAvroToJSON> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.avro.ConvertAvroToJSON> code = closure.rehydrate(c, com.tibtech.nifi.processors.avro.ConvertAvroToJSON.class, com.tibtech.nifi.processors.avro.ConvertAvroToJSON.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
