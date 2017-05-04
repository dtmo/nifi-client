package com.tibtech.nifi.processors.kite;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ConvertJSONToAvro {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.kite.ConvertJSONToAvro";

  /**
   * A comma-separated list of Hadoop configuration files
   */
  public static final String HADOOP_CONFIGURATION_FILES_PROPERTY = "Hadoop configuration files";

  /**
   * Outgoing Avro schema for each record created from a JSON object
   */
  public static final String RECORD_SCHEMA_PROPERTY = "Record schema";

  /**
   * Compression type to use when writting Avro files. Default is Snappy.
   */
  public static final String KITE_COMPRESSION_TYPE_PROPERTY = "kite-compression-type";

  private final Map<String, String> properties;

  public ConvertJSONToAvro() {
    this.properties = new HashMap<>();
  }

  public ConvertJSONToAvro(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * A comma-separated list of Hadoop configuration files
   */
  public final String getHadoopConfigurationFiles() {
    return properties.get(HADOOP_CONFIGURATION_FILES_PROPERTY);
  }

  /**
   * A comma-separated list of Hadoop configuration files
   */
  public final ConvertJSONToAvro setHadoopConfigurationFiles(final String hadoopConfigurationFiles) {
    properties.put(HADOOP_CONFIGURATION_FILES_PROPERTY, hadoopConfigurationFiles);
    return this;
  }

  /**
   * A comma-separated list of Hadoop configuration files
   */
  public final ConvertJSONToAvro removeHadoopConfigurationFiles() {
    properties.remove(HADOOP_CONFIGURATION_FILES_PROPERTY);
    return this;
  }

  /**
   * Outgoing Avro schema for each record created from a JSON object
   */
  public final String getRecordSchema() {
    return properties.get(RECORD_SCHEMA_PROPERTY);
  }

  /**
   * Outgoing Avro schema for each record created from a JSON object
   */
  public final ConvertJSONToAvro setRecordSchema(final String recordSchema) {
    properties.put(RECORD_SCHEMA_PROPERTY, recordSchema);
    return this;
  }

  /**
   * Outgoing Avro schema for each record created from a JSON object
   */
  public final ConvertJSONToAvro removeRecordSchema() {
    properties.remove(RECORD_SCHEMA_PROPERTY);
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
  public final ConvertJSONToAvro setKiteCompressionType(final String kiteCompressionType) {
    properties.put(KITE_COMPRESSION_TYPE_PROPERTY, kiteCompressionType);
    return this;
  }

  /**
   * Compression type to use when writting Avro files. Default is Snappy.
   */
  public final ConvertJSONToAvro removeKiteCompressionType() {
    properties.remove(KITE_COMPRESSION_TYPE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ConvertJSONToAvro setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ConvertJSONToAvro removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<ConvertJSONToAvro, ConvertJSONToAvro> configurator) {
    return configurator.apply(new ConvertJSONToAvro()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConvertJSONToAvro.class) final Closure<ConvertJSONToAvro> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.kite.ConvertJSONToAvro> code = closure.rehydrate(c, com.tibtech.nifi.processors.kite.ConvertJSONToAvro.class, com.tibtech.nifi.processors.kite.ConvertJSONToAvro.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ConvertJSONToAvro, ConvertJSONToAvro> configurator) {
    return configurator.apply(new ConvertJSONToAvro(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConvertJSONToAvro.class) final Closure<ConvertJSONToAvro> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.kite.ConvertJSONToAvro> code = closure.rehydrate(c, com.tibtech.nifi.processors.kite.ConvertJSONToAvro.class, com.tibtech.nifi.processors.kite.ConvertJSONToAvro.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
