package com.tibtech.nifi.json;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class JsonRecordSetWriter {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.json.JsonRecordSetWriter";

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
   * Specifies the format to use when reading/writing Date fields. If not specified, Date fields will be assumed to be number of milliseconds since epoch (Midnight, Jan 1, 1970 GMT). If specified, the value must match the Java Simple Date Format (for example, MM/dd/yyyy for a two-digit month, followed by a two-digit day, followed by a four-digit year, all separated by '/' characters, as in 01/01/2017).
   */
  public static final String DATE_FORMAT_PROPERTY = "Date Format";

  /**
   * Specifies the format to use when reading/writing Time fields. If not specified, Time fields will be assumed to be number of milliseconds since epoch (Midnight, Jan 1, 1970 GMT). If specified, the value must match the Java Simple Date Format (for example, HH:mm:ss for a two-digit hour in 24-hour format, followed by a two-digit minute, followed by a two-digit second, all separated by ':' characters, as in 18:04:15).
   */
  public static final String TIME_FORMAT_PROPERTY = "Time Format";

  /**
   * Specifies the format to use when reading/writing Timestamp fields. If not specified, Timestamp fields will be assumed to be number of milliseconds since epoch (Midnight, Jan 1, 1970 GMT). If specified, the value must match the Java Simple Date Format (for example, MM/dd/yyyy HH:mm:ss for a two-digit month, followed by a two-digit day, followed by a four-digit year, all separated by '/' characters; and then followed by a two-digit hour in 24-hour format, followed by a two-digit minute, followed by a two-digit second, all separated by ':' characters, as in 01/01/2017 18:04:15).
   */
  public static final String TIMESTAMP_FORMAT_PROPERTY = "Timestamp Format";

  /**
   * Specifies whether or not the JSON should be pretty printed
   */
  public static final String PRETTY_PRINT_JSON_PROPERTY = "Pretty Print JSON";

  /**
   * Specifies how the writer should handle a null field
   */
  public static final String SUPPRESS_NULLS_PROPERTY = "suppress-nulls";

  /**
   * Specifies how the writer should output the JSON records (as an array or one object per line, e.g.) Note that if 'One Line Per Object' is selected, then Pretty Print JSON must be false.
   */
  public static final String OUTPUT_GROUPING_PROPERTY = "output-grouping";

  private final Map<String, String> properties;

  public JsonRecordSetWriter() {
    this.properties = new HashMap<>();
  }

  public JsonRecordSetWriter(final Map<String, String> properties) {
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
  public final JsonRecordSetWriter setSchemaWriteStrategy(final String schemaWriteStrategy) {
    properties.put(SCHEMA_WRITE_STRATEGY_PROPERTY, schemaWriteStrategy);
    return this;
  }

  /**
   * Specifies how the schema for a Record should be added to the data.
   */
  public final JsonRecordSetWriter removeSchemaWriteStrategy() {
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
  public final JsonRecordSetWriter setSchemaAccessStrategy(final String schemaAccessStrategy) {
    properties.put(SCHEMA_ACCESS_STRATEGY_PROPERTY, schemaAccessStrategy);
    return this;
  }

  /**
   * Specifies how to obtain the schema that is to be used for interpreting the data.
   */
  public final JsonRecordSetWriter removeSchemaAccessStrategy() {
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
  public final JsonRecordSetWriter setSchemaRegistry(final String schemaRegistry) {
    properties.put(SCHEMA_REGISTRY_PROPERTY, schemaRegistry);
    return this;
  }

  /**
   * Specifies the Controller Service to use for the Schema Registry
   */
  public final JsonRecordSetWriter removeSchemaRegistry() {
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
  public final JsonRecordSetWriter setSchemaName(final String schemaName) {
    properties.put(SCHEMA_NAME_PROPERTY, schemaName);
    return this;
  }

  /**
   * Specifies the name of the schema to lookup in the Schema Registry property
   */
  public final JsonRecordSetWriter removeSchemaName() {
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
  public final JsonRecordSetWriter setSchemaVersion(final String schemaVersion) {
    properties.put(SCHEMA_VERSION_PROPERTY, schemaVersion);
    return this;
  }

  /**
   * Specifies the version of the schema to lookup in the Schema Registry. If not specified then the latest version of the schema will be retrieved.
   */
  public final JsonRecordSetWriter removeSchemaVersion() {
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
  public final JsonRecordSetWriter setSchemaBranch(final String schemaBranch) {
    properties.put(SCHEMA_BRANCH_PROPERTY, schemaBranch);
    return this;
  }

  /**
   * Specifies the name of the branch to use when looking up the schema in the Schema Registry property. If the chosen Schema Registry does not support branching, this value will be ignored.
   */
  public final JsonRecordSetWriter removeSchemaBranch() {
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
  public final JsonRecordSetWriter setSchemaText(final String schemaText) {
    properties.put(SCHEMA_TEXT_PROPERTY, schemaText);
    return this;
  }

  /**
   * The text of an Avro-formatted Schema
   */
  public final JsonRecordSetWriter removeSchemaText() {
    properties.remove(SCHEMA_TEXT_PROPERTY);
    return this;
  }

  /**
   * Specifies the format to use when reading/writing Date fields. If not specified, Date fields will be assumed to be number of milliseconds since epoch (Midnight, Jan 1, 1970 GMT). If specified, the value must match the Java Simple Date Format (for example, MM/dd/yyyy for a two-digit month, followed by a two-digit day, followed by a four-digit year, all separated by '/' characters, as in 01/01/2017).
   */
  public final String getDateFormat() {
    return properties.get(DATE_FORMAT_PROPERTY);
  }

  /**
   * Specifies the format to use when reading/writing Date fields. If not specified, Date fields will be assumed to be number of milliseconds since epoch (Midnight, Jan 1, 1970 GMT). If specified, the value must match the Java Simple Date Format (for example, MM/dd/yyyy for a two-digit month, followed by a two-digit day, followed by a four-digit year, all separated by '/' characters, as in 01/01/2017).
   */
  public final JsonRecordSetWriter setDateFormat(final String dateFormat) {
    properties.put(DATE_FORMAT_PROPERTY, dateFormat);
    return this;
  }

  /**
   * Specifies the format to use when reading/writing Date fields. If not specified, Date fields will be assumed to be number of milliseconds since epoch (Midnight, Jan 1, 1970 GMT). If specified, the value must match the Java Simple Date Format (for example, MM/dd/yyyy for a two-digit month, followed by a two-digit day, followed by a four-digit year, all separated by '/' characters, as in 01/01/2017).
   */
  public final JsonRecordSetWriter removeDateFormat() {
    properties.remove(DATE_FORMAT_PROPERTY);
    return this;
  }

  /**
   * Specifies the format to use when reading/writing Time fields. If not specified, Time fields will be assumed to be number of milliseconds since epoch (Midnight, Jan 1, 1970 GMT). If specified, the value must match the Java Simple Date Format (for example, HH:mm:ss for a two-digit hour in 24-hour format, followed by a two-digit minute, followed by a two-digit second, all separated by ':' characters, as in 18:04:15).
   */
  public final String getTimeFormat() {
    return properties.get(TIME_FORMAT_PROPERTY);
  }

  /**
   * Specifies the format to use when reading/writing Time fields. If not specified, Time fields will be assumed to be number of milliseconds since epoch (Midnight, Jan 1, 1970 GMT). If specified, the value must match the Java Simple Date Format (for example, HH:mm:ss for a two-digit hour in 24-hour format, followed by a two-digit minute, followed by a two-digit second, all separated by ':' characters, as in 18:04:15).
   */
  public final JsonRecordSetWriter setTimeFormat(final String timeFormat) {
    properties.put(TIME_FORMAT_PROPERTY, timeFormat);
    return this;
  }

  /**
   * Specifies the format to use when reading/writing Time fields. If not specified, Time fields will be assumed to be number of milliseconds since epoch (Midnight, Jan 1, 1970 GMT). If specified, the value must match the Java Simple Date Format (for example, HH:mm:ss for a two-digit hour in 24-hour format, followed by a two-digit minute, followed by a two-digit second, all separated by ':' characters, as in 18:04:15).
   */
  public final JsonRecordSetWriter removeTimeFormat() {
    properties.remove(TIME_FORMAT_PROPERTY);
    return this;
  }

  /**
   * Specifies the format to use when reading/writing Timestamp fields. If not specified, Timestamp fields will be assumed to be number of milliseconds since epoch (Midnight, Jan 1, 1970 GMT). If specified, the value must match the Java Simple Date Format (for example, MM/dd/yyyy HH:mm:ss for a two-digit month, followed by a two-digit day, followed by a four-digit year, all separated by '/' characters; and then followed by a two-digit hour in 24-hour format, followed by a two-digit minute, followed by a two-digit second, all separated by ':' characters, as in 01/01/2017 18:04:15).
   */
  public final String getTimestampFormat() {
    return properties.get(TIMESTAMP_FORMAT_PROPERTY);
  }

  /**
   * Specifies the format to use when reading/writing Timestamp fields. If not specified, Timestamp fields will be assumed to be number of milliseconds since epoch (Midnight, Jan 1, 1970 GMT). If specified, the value must match the Java Simple Date Format (for example, MM/dd/yyyy HH:mm:ss for a two-digit month, followed by a two-digit day, followed by a four-digit year, all separated by '/' characters; and then followed by a two-digit hour in 24-hour format, followed by a two-digit minute, followed by a two-digit second, all separated by ':' characters, as in 01/01/2017 18:04:15).
   */
  public final JsonRecordSetWriter setTimestampFormat(final String timestampFormat) {
    properties.put(TIMESTAMP_FORMAT_PROPERTY, timestampFormat);
    return this;
  }

  /**
   * Specifies the format to use when reading/writing Timestamp fields. If not specified, Timestamp fields will be assumed to be number of milliseconds since epoch (Midnight, Jan 1, 1970 GMT). If specified, the value must match the Java Simple Date Format (for example, MM/dd/yyyy HH:mm:ss for a two-digit month, followed by a two-digit day, followed by a four-digit year, all separated by '/' characters; and then followed by a two-digit hour in 24-hour format, followed by a two-digit minute, followed by a two-digit second, all separated by ':' characters, as in 01/01/2017 18:04:15).
   */
  public final JsonRecordSetWriter removeTimestampFormat() {
    properties.remove(TIMESTAMP_FORMAT_PROPERTY);
    return this;
  }

  /**
   * Specifies whether or not the JSON should be pretty printed
   */
  public final String getPrettyPrintJson() {
    return properties.get(PRETTY_PRINT_JSON_PROPERTY);
  }

  /**
   * Specifies whether or not the JSON should be pretty printed
   */
  public final JsonRecordSetWriter setPrettyPrintJson(final String prettyPrintJson) {
    properties.put(PRETTY_PRINT_JSON_PROPERTY, prettyPrintJson);
    return this;
  }

  /**
   * Specifies whether or not the JSON should be pretty printed
   */
  public final JsonRecordSetWriter removePrettyPrintJson() {
    properties.remove(PRETTY_PRINT_JSON_PROPERTY);
    return this;
  }

  /**
   * Specifies how the writer should handle a null field
   */
  public final String getSuppressNulls() {
    return properties.get(SUPPRESS_NULLS_PROPERTY);
  }

  /**
   * Specifies how the writer should handle a null field
   */
  public final JsonRecordSetWriter setSuppressNulls(final String suppressNulls) {
    properties.put(SUPPRESS_NULLS_PROPERTY, suppressNulls);
    return this;
  }

  /**
   * Specifies how the writer should handle a null field
   */
  public final JsonRecordSetWriter removeSuppressNulls() {
    properties.remove(SUPPRESS_NULLS_PROPERTY);
    return this;
  }

  /**
   * Specifies how the writer should output the JSON records (as an array or one object per line, e.g.) Note that if 'One Line Per Object' is selected, then Pretty Print JSON must be false.
   */
  public final String getOutputGrouping() {
    return properties.get(OUTPUT_GROUPING_PROPERTY);
  }

  /**
   * Specifies how the writer should output the JSON records (as an array or one object per line, e.g.) Note that if 'One Line Per Object' is selected, then Pretty Print JSON must be false.
   */
  public final JsonRecordSetWriter setOutputGrouping(final String outputGrouping) {
    properties.put(OUTPUT_GROUPING_PROPERTY, outputGrouping);
    return this;
  }

  /**
   * Specifies how the writer should output the JSON records (as an array or one object per line, e.g.) Note that if 'One Line Per Object' is selected, then Pretty Print JSON must be false.
   */
  public final JsonRecordSetWriter removeOutputGrouping() {
    properties.remove(OUTPUT_GROUPING_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final JsonRecordSetWriter setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final JsonRecordSetWriter removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<JsonRecordSetWriter, JsonRecordSetWriter> configurator) {
    return configurator.apply(new JsonRecordSetWriter()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = JsonRecordSetWriter.class) final Closure<JsonRecordSetWriter> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.json.JsonRecordSetWriter> code = closure.rehydrate(c, com.tibtech.nifi.json.JsonRecordSetWriter.class, com.tibtech.nifi.json.JsonRecordSetWriter.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<JsonRecordSetWriter, JsonRecordSetWriter> configurator) {
    return configurator.apply(new JsonRecordSetWriter(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = JsonRecordSetWriter.class) final Closure<JsonRecordSetWriter> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.json.JsonRecordSetWriter> code = closure.rehydrate(c, com.tibtech.nifi.json.JsonRecordSetWriter.class, com.tibtech.nifi.json.JsonRecordSetWriter.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
