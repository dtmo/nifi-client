package com.tibtech.nifi.avro;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class AvroRecordSetWriter {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.avro.AvroRecordSetWriter";

  /**
   * Specifies how the schema for a Record should be added to the data.
   */
  public static final String SCHEMA_WRITE_STRATEGY_PROPERTY = "Schema Write Strategy";

  /**
   * Specifies how to obtain the schema that is to be used for interpreting the data.
   */
  public static final String SCHEMA_ACCESS_STRATEGY_PROPERTY = "schema-access-strategy";

  /**
   * Specifies the Controller Service to use for the Schema Registry
   */
  public static final String SCHEMA_REGISTRY_PROPERTY = "schema-registry";

  /**
   * Specifies the name of the schema to lookup in the Schema Registry property
   */
  public static final String SCHEMA_NAME_PROPERTY = "schema-name";

  /**
   * Specifies the version of the schema to lookup in the Schema Registry. If not specified then the latest version of the schema will be retrieved.
   */
  public static final String SCHEMA_VERSION_PROPERTY = "schema-version";

  /**
   * Specifies the name of the branch to use when looking up the schema in the Schema Registry property. If the chosen Schema Registry does not support branching, this value will be ignored.
   */
  public static final String SCHEMA_BRANCH_PROPERTY = "schema-branch";

  /**
   * The text of an Avro-formatted Schema
   */
  public static final String SCHEMA_TEXT_PROPERTY = "schema-text";

  /**
   * Compression type to use when writing Avro files. Default is None.
   */
  public static final String COMPRESSION_FORMAT_PROPERTY = "compression-format";

  private final Map<String, String> properties;

  public AvroRecordSetWriter() {
    this.properties = new HashMap<>();
  }

  public AvroRecordSetWriter(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Specifies how the schema for a Record should be added to the data.
   */
  public final String getSchemaWriteStrategy() {
    return properties.get(SCHEMA_WRITE_STRATEGY_PROPERTY);
  }

  /**
   * Specifies how the schema for a Record should be added to the data.
   */
  public final AvroRecordSetWriter setSchemaWriteStrategy(final String schemaWriteStrategy) {
    properties.put(SCHEMA_WRITE_STRATEGY_PROPERTY, schemaWriteStrategy);
    return this;
  }

  /**
   * Specifies how the schema for a Record should be added to the data.
   */
  public final AvroRecordSetWriter removeSchemaWriteStrategy() {
    properties.remove(SCHEMA_WRITE_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * Specifies how to obtain the schema that is to be used for interpreting the data.
   */
  public final String getSchemaAccessStrategy() {
    return properties.get(SCHEMA_ACCESS_STRATEGY_PROPERTY);
  }

  /**
   * Specifies how to obtain the schema that is to be used for interpreting the data.
   */
  public final AvroRecordSetWriter setSchemaAccessStrategy(final String schemaAccessStrategy) {
    properties.put(SCHEMA_ACCESS_STRATEGY_PROPERTY, schemaAccessStrategy);
    return this;
  }

  /**
   * Specifies how to obtain the schema that is to be used for interpreting the data.
   */
  public final AvroRecordSetWriter removeSchemaAccessStrategy() {
    properties.remove(SCHEMA_ACCESS_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * Specifies the Controller Service to use for the Schema Registry
   */
  public final String getSchemaRegistry() {
    return properties.get(SCHEMA_REGISTRY_PROPERTY);
  }

  /**
   * Specifies the Controller Service to use for the Schema Registry
   */
  public final AvroRecordSetWriter setSchemaRegistry(final String schemaRegistry) {
    properties.put(SCHEMA_REGISTRY_PROPERTY, schemaRegistry);
    return this;
  }

  /**
   * Specifies the Controller Service to use for the Schema Registry
   */
  public final AvroRecordSetWriter removeSchemaRegistry() {
    properties.remove(SCHEMA_REGISTRY_PROPERTY);
    return this;
  }

  /**
   * Specifies the name of the schema to lookup in the Schema Registry property
   */
  public final String getSchemaName() {
    return properties.get(SCHEMA_NAME_PROPERTY);
  }

  /**
   * Specifies the name of the schema to lookup in the Schema Registry property
   */
  public final AvroRecordSetWriter setSchemaName(final String schemaName) {
    properties.put(SCHEMA_NAME_PROPERTY, schemaName);
    return this;
  }

  /**
   * Specifies the name of the schema to lookup in the Schema Registry property
   */
  public final AvroRecordSetWriter removeSchemaName() {
    properties.remove(SCHEMA_NAME_PROPERTY);
    return this;
  }

  /**
   * Specifies the version of the schema to lookup in the Schema Registry. If not specified then the latest version of the schema will be retrieved.
   */
  public final String getSchemaVersion() {
    return properties.get(SCHEMA_VERSION_PROPERTY);
  }

  /**
   * Specifies the version of the schema to lookup in the Schema Registry. If not specified then the latest version of the schema will be retrieved.
   */
  public final AvroRecordSetWriter setSchemaVersion(final String schemaVersion) {
    properties.put(SCHEMA_VERSION_PROPERTY, schemaVersion);
    return this;
  }

  /**
   * Specifies the version of the schema to lookup in the Schema Registry. If not specified then the latest version of the schema will be retrieved.
   */
  public final AvroRecordSetWriter removeSchemaVersion() {
    properties.remove(SCHEMA_VERSION_PROPERTY);
    return this;
  }

  /**
   * Specifies the name of the branch to use when looking up the schema in the Schema Registry property. If the chosen Schema Registry does not support branching, this value will be ignored.
   */
  public final String getSchemaBranch() {
    return properties.get(SCHEMA_BRANCH_PROPERTY);
  }

  /**
   * Specifies the name of the branch to use when looking up the schema in the Schema Registry property. If the chosen Schema Registry does not support branching, this value will be ignored.
   */
  public final AvroRecordSetWriter setSchemaBranch(final String schemaBranch) {
    properties.put(SCHEMA_BRANCH_PROPERTY, schemaBranch);
    return this;
  }

  /**
   * Specifies the name of the branch to use when looking up the schema in the Schema Registry property. If the chosen Schema Registry does not support branching, this value will be ignored.
   */
  public final AvroRecordSetWriter removeSchemaBranch() {
    properties.remove(SCHEMA_BRANCH_PROPERTY);
    return this;
  }

  /**
   * The text of an Avro-formatted Schema
   */
  public final String getSchemaText() {
    return properties.get(SCHEMA_TEXT_PROPERTY);
  }

  /**
   * The text of an Avro-formatted Schema
   */
  public final AvroRecordSetWriter setSchemaText(final String schemaText) {
    properties.put(SCHEMA_TEXT_PROPERTY, schemaText);
    return this;
  }

  /**
   * The text of an Avro-formatted Schema
   */
  public final AvroRecordSetWriter removeSchemaText() {
    properties.remove(SCHEMA_TEXT_PROPERTY);
    return this;
  }

  /**
   * Compression type to use when writing Avro files. Default is None.
   */
  public final String getCompressionFormat() {
    return properties.get(COMPRESSION_FORMAT_PROPERTY);
  }

  /**
   * Compression type to use when writing Avro files. Default is None.
   */
  public final AvroRecordSetWriter setCompressionFormat(final String compressionFormat) {
    properties.put(COMPRESSION_FORMAT_PROPERTY, compressionFormat);
    return this;
  }

  /**
   * Compression type to use when writing Avro files. Default is None.
   */
  public final AvroRecordSetWriter removeCompressionFormat() {
    properties.remove(COMPRESSION_FORMAT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final AvroRecordSetWriter setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final AvroRecordSetWriter removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<AvroRecordSetWriter, AvroRecordSetWriter> configurator) {
    return configurator.apply(new AvroRecordSetWriter()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = AvroRecordSetWriter.class) final Closure<AvroRecordSetWriter> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.avro.AvroRecordSetWriter> code = closure.rehydrate(c, com.tibtech.nifi.avro.AvroRecordSetWriter.class, com.tibtech.nifi.avro.AvroRecordSetWriter.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<AvroRecordSetWriter, AvroRecordSetWriter> configurator) {
    return configurator.apply(new AvroRecordSetWriter(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = AvroRecordSetWriter.class) final Closure<AvroRecordSetWriter> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.avro.AvroRecordSetWriter> code = closure.rehydrate(c, com.tibtech.nifi.avro.AvroRecordSetWriter.class, com.tibtech.nifi.avro.AvroRecordSetWriter.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
