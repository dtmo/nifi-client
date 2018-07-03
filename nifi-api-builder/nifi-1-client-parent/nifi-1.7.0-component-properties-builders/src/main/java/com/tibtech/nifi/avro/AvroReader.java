package com.tibtech.nifi.avro;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class AvroReader {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.avro.AvroReader";

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

  private final Map<String, String> properties;

  public AvroReader() {
    this.properties = new HashMap<>();
  }

  public AvroReader(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
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
  public final AvroReader setSchemaAccessStrategy(final String schemaAccessStrategy) {
    properties.put(SCHEMA_ACCESS_STRATEGY_PROPERTY, schemaAccessStrategy);
    return this;
  }

  /**
   * Specifies how to obtain the schema that is to be used for interpreting the data.
   */
  public final AvroReader removeSchemaAccessStrategy() {
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
  public final AvroReader setSchemaRegistry(final String schemaRegistry) {
    properties.put(SCHEMA_REGISTRY_PROPERTY, schemaRegistry);
    return this;
  }

  /**
   * Specifies the Controller Service to use for the Schema Registry
   */
  public final AvroReader removeSchemaRegistry() {
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
  public final AvroReader setSchemaName(final String schemaName) {
    properties.put(SCHEMA_NAME_PROPERTY, schemaName);
    return this;
  }

  /**
   * Specifies the name of the schema to lookup in the Schema Registry property
   */
  public final AvroReader removeSchemaName() {
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
  public final AvroReader setSchemaVersion(final String schemaVersion) {
    properties.put(SCHEMA_VERSION_PROPERTY, schemaVersion);
    return this;
  }

  /**
   * Specifies the version of the schema to lookup in the Schema Registry. If not specified then the latest version of the schema will be retrieved.
   */
  public final AvroReader removeSchemaVersion() {
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
  public final AvroReader setSchemaBranch(final String schemaBranch) {
    properties.put(SCHEMA_BRANCH_PROPERTY, schemaBranch);
    return this;
  }

  /**
   * Specifies the name of the branch to use when looking up the schema in the Schema Registry property. If the chosen Schema Registry does not support branching, this value will be ignored.
   */
  public final AvroReader removeSchemaBranch() {
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
  public final AvroReader setSchemaText(final String schemaText) {
    properties.put(SCHEMA_TEXT_PROPERTY, schemaText);
    return this;
  }

  /**
   * The text of an Avro-formatted Schema
   */
  public final AvroReader removeSchemaText() {
    properties.remove(SCHEMA_TEXT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final AvroReader setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final AvroReader removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<AvroReader, AvroReader> configurator) {
    return configurator.apply(new AvroReader()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = AvroReader.class) final Closure<AvroReader> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.avro.AvroReader> code = closure.rehydrate(c, com.tibtech.nifi.avro.AvroReader.class, com.tibtech.nifi.avro.AvroReader.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<AvroReader, AvroReader> configurator) {
    return configurator.apply(new AvroReader(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = AvroReader.class) final Closure<AvroReader> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.avro.AvroReader> code = closure.rehydrate(c, com.tibtech.nifi.avro.AvroReader.class, com.tibtech.nifi.avro.AvroReader.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
