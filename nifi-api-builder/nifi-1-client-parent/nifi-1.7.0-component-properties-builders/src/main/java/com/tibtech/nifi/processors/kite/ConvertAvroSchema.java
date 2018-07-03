package com.tibtech.nifi.processors.kite;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ConvertAvroSchema {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.kite.ConvertAvroSchema";

  /**
   * Avro Schema of Input Flowfiles.  This can be a URI (dataset, view, or resource) or literal JSON schema.
   */
  public static final String INPUT_SCHEMA_PROPERTY = "Input Schema";

  /**
   * Avro Schema of Output Flowfiles.  This can be a URI (dataset, view, or resource) or literal JSON schema.
   */
  public static final String OUTPUT_SCHEMA_PROPERTY = "Output Schema";

  /**
   * Locale to use for scanning data (see https://docs.oracle.com/javase/7/docs/api/java/util/Locale.html)or " default" for JVM default
   */
  public static final String LOCALE_PROPERTY = "Locale";

  /**
   * Compression type to use when writting Avro files. Default is Snappy.
   */
  public static final String KITE_COMPRESSION_TYPE_PROPERTY = "kite-compression-type";

  private final Map<String, String> properties;

  public ConvertAvroSchema() {
    this.properties = new HashMap<>();
  }

  public ConvertAvroSchema(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Avro Schema of Input Flowfiles.  This can be a URI (dataset, view, or resource) or literal JSON schema.
   */
  public final String getInputSchema() {
    return properties.get(INPUT_SCHEMA_PROPERTY);
  }

  /**
   * Avro Schema of Input Flowfiles.  This can be a URI (dataset, view, or resource) or literal JSON schema.
   */
  public final ConvertAvroSchema setInputSchema(final String inputSchema) {
    properties.put(INPUT_SCHEMA_PROPERTY, inputSchema);
    return this;
  }

  /**
   * Avro Schema of Input Flowfiles.  This can be a URI (dataset, view, or resource) or literal JSON schema.
   */
  public final ConvertAvroSchema removeInputSchema() {
    properties.remove(INPUT_SCHEMA_PROPERTY);
    return this;
  }

  /**
   * Avro Schema of Output Flowfiles.  This can be a URI (dataset, view, or resource) or literal JSON schema.
   */
  public final String getOutputSchema() {
    return properties.get(OUTPUT_SCHEMA_PROPERTY);
  }

  /**
   * Avro Schema of Output Flowfiles.  This can be a URI (dataset, view, or resource) or literal JSON schema.
   */
  public final ConvertAvroSchema setOutputSchema(final String outputSchema) {
    properties.put(OUTPUT_SCHEMA_PROPERTY, outputSchema);
    return this;
  }

  /**
   * Avro Schema of Output Flowfiles.  This can be a URI (dataset, view, or resource) or literal JSON schema.
   */
  public final ConvertAvroSchema removeOutputSchema() {
    properties.remove(OUTPUT_SCHEMA_PROPERTY);
    return this;
  }

  /**
   * Locale to use for scanning data (see https://docs.oracle.com/javase/7/docs/api/java/util/Locale.html)or " default" for JVM default
   */
  public final String getLocale() {
    return properties.get(LOCALE_PROPERTY);
  }

  /**
   * Locale to use for scanning data (see https://docs.oracle.com/javase/7/docs/api/java/util/Locale.html)or " default" for JVM default
   */
  public final ConvertAvroSchema setLocale(final String locale) {
    properties.put(LOCALE_PROPERTY, locale);
    return this;
  }

  /**
   * Locale to use for scanning data (see https://docs.oracle.com/javase/7/docs/api/java/util/Locale.html)or " default" for JVM default
   */
  public final ConvertAvroSchema removeLocale() {
    properties.remove(LOCALE_PROPERTY);
    return this;
  }

  /**
   * Compression type to use when writting Avro files. Default is Snappy.
   */
  public final String getKiteCompressionType() {
    return properties.get(KITE_COMPRESSION_TYPE_PROPERTY);
  }

  /**
   * Compression type to use when writting Avro files. Default is Snappy.
   */
  public final ConvertAvroSchema setKiteCompressionType(final String kiteCompressionType) {
    properties.put(KITE_COMPRESSION_TYPE_PROPERTY, kiteCompressionType);
    return this;
  }

  /**
   * Compression type to use when writting Avro files. Default is Snappy.
   */
  public final ConvertAvroSchema removeKiteCompressionType() {
    properties.remove(KITE_COMPRESSION_TYPE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ConvertAvroSchema setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ConvertAvroSchema removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ConvertAvroSchema, ConvertAvroSchema> configurator) {
    return configurator.apply(new ConvertAvroSchema()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConvertAvroSchema.class) final Closure<ConvertAvroSchema> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.kite.ConvertAvroSchema> code = closure.rehydrate(c, com.tibtech.nifi.processors.kite.ConvertAvroSchema.class, com.tibtech.nifi.processors.kite.ConvertAvroSchema.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ConvertAvroSchema, ConvertAvroSchema> configurator) {
    return configurator.apply(new ConvertAvroSchema(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConvertAvroSchema.class) final Closure<ConvertAvroSchema> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.kite.ConvertAvroSchema> code = closure.rehydrate(c, com.tibtech.nifi.processors.kite.ConvertAvroSchema.class, com.tibtech.nifi.processors.kite.ConvertAvroSchema.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
