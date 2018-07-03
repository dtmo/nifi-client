package com.tibtech.nifi.xml;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class XMLRecordSetWriter {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.xml.XMLRecordSetWriter";

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
   * Specifies how the writer should handle a null field
   */
  public static final String SUPPRESS_NULLS_PROPERTY = "suppress_nulls";

  /**
   * Specifies whether or not the XML should be pretty printed
   */
  public static final String PRETTY_PRINT_XML_PROPERTY = "pretty_print_xml";

  /**
   * Specifies the name of the XML root tag wrapping the record set. This property has to be defined if the writer is supposed to write multiple records in a single FlowFile.
   */
  public static final String ROOT_TAG_NAME_PROPERTY = "root_tag_name";

  /**
   * Specifies the name of the XML record tag wrapping the record fields. If this is not set, the writer will use the record name in the schema.
   */
  public static final String RECORD_TAG_NAME_PROPERTY = "record_tag_name";

  /**
   * Specifies how the writer wraps elements of fields of type array
   */
  public static final String ARRAY_WRAPPING_PROPERTY = "array_wrapping";

  /**
   * Name of the tag used by property "Wrap Elements of Arrays" to write arrays
   */
  public static final String ARRAY_TAG_NAME_PROPERTY = "array_tag_name";

  /**
   * The Character set to use when writing the data to the FlowFile
   */
  public static final String CHARACTER_SET_PROPERTY = "Character Set";

  private final Map<String, String> properties;

  public XMLRecordSetWriter() {
    this.properties = new HashMap<>();
  }

  public XMLRecordSetWriter(final Map<String, String> properties) {
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
  public final XMLRecordSetWriter setSchemaWriteStrategy(final String schemaWriteStrategy) {
    properties.put(SCHEMA_WRITE_STRATEGY_PROPERTY, schemaWriteStrategy);
    return this;
  }

  /**
   * Specifies how the schema for a Record should be added to the data.
   */
  public final XMLRecordSetWriter removeSchemaWriteStrategy() {
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
  public final XMLRecordSetWriter setSchemaAccessStrategy(final String schemaAccessStrategy) {
    properties.put(SCHEMA_ACCESS_STRATEGY_PROPERTY, schemaAccessStrategy);
    return this;
  }

  /**
   * Specifies how to obtain the schema that is to be used for interpreting the data.
   */
  public final XMLRecordSetWriter removeSchemaAccessStrategy() {
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
  public final XMLRecordSetWriter setSchemaRegistry(final String schemaRegistry) {
    properties.put(SCHEMA_REGISTRY_PROPERTY, schemaRegistry);
    return this;
  }

  /**
   * Specifies the Controller Service to use for the Schema Registry
   */
  public final XMLRecordSetWriter removeSchemaRegistry() {
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
  public final XMLRecordSetWriter setSchemaName(final String schemaName) {
    properties.put(SCHEMA_NAME_PROPERTY, schemaName);
    return this;
  }

  /**
   * Specifies the name of the schema to lookup in the Schema Registry property
   */
  public final XMLRecordSetWriter removeSchemaName() {
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
  public final XMLRecordSetWriter setSchemaVersion(final String schemaVersion) {
    properties.put(SCHEMA_VERSION_PROPERTY, schemaVersion);
    return this;
  }

  /**
   * Specifies the version of the schema to lookup in the Schema Registry. If not specified then the latest version of the schema will be retrieved.
   */
  public final XMLRecordSetWriter removeSchemaVersion() {
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
  public final XMLRecordSetWriter setSchemaBranch(final String schemaBranch) {
    properties.put(SCHEMA_BRANCH_PROPERTY, schemaBranch);
    return this;
  }

  /**
   * Specifies the name of the branch to use when looking up the schema in the Schema Registry property. If the chosen Schema Registry does not support branching, this value will be ignored.
   */
  public final XMLRecordSetWriter removeSchemaBranch() {
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
  public final XMLRecordSetWriter setSchemaText(final String schemaText) {
    properties.put(SCHEMA_TEXT_PROPERTY, schemaText);
    return this;
  }

  /**
   * The text of an Avro-formatted Schema
   */
  public final XMLRecordSetWriter removeSchemaText() {
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
  public final XMLRecordSetWriter setDateFormat(final String dateFormat) {
    properties.put(DATE_FORMAT_PROPERTY, dateFormat);
    return this;
  }

  /**
   * Specifies the format to use when reading/writing Date fields. If not specified, Date fields will be assumed to be number of milliseconds since epoch (Midnight, Jan 1, 1970 GMT). If specified, the value must match the Java Simple Date Format (for example, MM/dd/yyyy for a two-digit month, followed by a two-digit day, followed by a four-digit year, all separated by '/' characters, as in 01/01/2017).
   */
  public final XMLRecordSetWriter removeDateFormat() {
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
  public final XMLRecordSetWriter setTimeFormat(final String timeFormat) {
    properties.put(TIME_FORMAT_PROPERTY, timeFormat);
    return this;
  }

  /**
   * Specifies the format to use when reading/writing Time fields. If not specified, Time fields will be assumed to be number of milliseconds since epoch (Midnight, Jan 1, 1970 GMT). If specified, the value must match the Java Simple Date Format (for example, HH:mm:ss for a two-digit hour in 24-hour format, followed by a two-digit minute, followed by a two-digit second, all separated by ':' characters, as in 18:04:15).
   */
  public final XMLRecordSetWriter removeTimeFormat() {
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
  public final XMLRecordSetWriter setTimestampFormat(final String timestampFormat) {
    properties.put(TIMESTAMP_FORMAT_PROPERTY, timestampFormat);
    return this;
  }

  /**
   * Specifies the format to use when reading/writing Timestamp fields. If not specified, Timestamp fields will be assumed to be number of milliseconds since epoch (Midnight, Jan 1, 1970 GMT). If specified, the value must match the Java Simple Date Format (for example, MM/dd/yyyy HH:mm:ss for a two-digit month, followed by a two-digit day, followed by a four-digit year, all separated by '/' characters; and then followed by a two-digit hour in 24-hour format, followed by a two-digit minute, followed by a two-digit second, all separated by ':' characters, as in 01/01/2017 18:04:15).
   */
  public final XMLRecordSetWriter removeTimestampFormat() {
    properties.remove(TIMESTAMP_FORMAT_PROPERTY);
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
  public final XMLRecordSetWriter setSuppressNulls(final String suppressNulls) {
    properties.put(SUPPRESS_NULLS_PROPERTY, suppressNulls);
    return this;
  }

  /**
   * Specifies how the writer should handle a null field
   */
  public final XMLRecordSetWriter removeSuppressNulls() {
    properties.remove(SUPPRESS_NULLS_PROPERTY);
    return this;
  }

  /**
   * Specifies whether or not the XML should be pretty printed
   */
  public final String getPrettyPrintXml() {
    return properties.get(PRETTY_PRINT_XML_PROPERTY);
  }

  /**
   * Specifies whether or not the XML should be pretty printed
   */
  public final XMLRecordSetWriter setPrettyPrintXml(final String prettyPrintXml) {
    properties.put(PRETTY_PRINT_XML_PROPERTY, prettyPrintXml);
    return this;
  }

  /**
   * Specifies whether or not the XML should be pretty printed
   */
  public final XMLRecordSetWriter removePrettyPrintXml() {
    properties.remove(PRETTY_PRINT_XML_PROPERTY);
    return this;
  }

  /**
   * Specifies the name of the XML root tag wrapping the record set. This property has to be defined if the writer is supposed to write multiple records in a single FlowFile.
   */
  public final String getRootTagName() {
    return properties.get(ROOT_TAG_NAME_PROPERTY);
  }

  /**
   * Specifies the name of the XML root tag wrapping the record set. This property has to be defined if the writer is supposed to write multiple records in a single FlowFile.
   */
  public final XMLRecordSetWriter setRootTagName(final String rootTagName) {
    properties.put(ROOT_TAG_NAME_PROPERTY, rootTagName);
    return this;
  }

  /**
   * Specifies the name of the XML root tag wrapping the record set. This property has to be defined if the writer is supposed to write multiple records in a single FlowFile.
   */
  public final XMLRecordSetWriter removeRootTagName() {
    properties.remove(ROOT_TAG_NAME_PROPERTY);
    return this;
  }

  /**
   * Specifies the name of the XML record tag wrapping the record fields. If this is not set, the writer will use the record name in the schema.
   */
  public final String getRecordTagName() {
    return properties.get(RECORD_TAG_NAME_PROPERTY);
  }

  /**
   * Specifies the name of the XML record tag wrapping the record fields. If this is not set, the writer will use the record name in the schema.
   */
  public final XMLRecordSetWriter setRecordTagName(final String recordTagName) {
    properties.put(RECORD_TAG_NAME_PROPERTY, recordTagName);
    return this;
  }

  /**
   * Specifies the name of the XML record tag wrapping the record fields. If this is not set, the writer will use the record name in the schema.
   */
  public final XMLRecordSetWriter removeRecordTagName() {
    properties.remove(RECORD_TAG_NAME_PROPERTY);
    return this;
  }

  /**
   * Specifies how the writer wraps elements of fields of type array
   */
  public final String getArrayWrapping() {
    return properties.get(ARRAY_WRAPPING_PROPERTY);
  }

  /**
   * Specifies how the writer wraps elements of fields of type array
   */
  public final XMLRecordSetWriter setArrayWrapping(final String arrayWrapping) {
    properties.put(ARRAY_WRAPPING_PROPERTY, arrayWrapping);
    return this;
  }

  /**
   * Specifies how the writer wraps elements of fields of type array
   */
  public final XMLRecordSetWriter removeArrayWrapping() {
    properties.remove(ARRAY_WRAPPING_PROPERTY);
    return this;
  }

  /**
   * Name of the tag used by property "Wrap Elements of Arrays" to write arrays
   */
  public final String getArrayTagName() {
    return properties.get(ARRAY_TAG_NAME_PROPERTY);
  }

  /**
   * Name of the tag used by property "Wrap Elements of Arrays" to write arrays
   */
  public final XMLRecordSetWriter setArrayTagName(final String arrayTagName) {
    properties.put(ARRAY_TAG_NAME_PROPERTY, arrayTagName);
    return this;
  }

  /**
   * Name of the tag used by property "Wrap Elements of Arrays" to write arrays
   */
  public final XMLRecordSetWriter removeArrayTagName() {
    properties.remove(ARRAY_TAG_NAME_PROPERTY);
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
  public final XMLRecordSetWriter setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * The Character set to use when writing the data to the FlowFile
   */
  public final XMLRecordSetWriter removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final XMLRecordSetWriter setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final XMLRecordSetWriter removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<XMLRecordSetWriter, XMLRecordSetWriter> configurator) {
    return configurator.apply(new XMLRecordSetWriter()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = XMLRecordSetWriter.class) final Closure<XMLRecordSetWriter> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.xml.XMLRecordSetWriter> code = closure.rehydrate(c, com.tibtech.nifi.xml.XMLRecordSetWriter.class, com.tibtech.nifi.xml.XMLRecordSetWriter.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<XMLRecordSetWriter, XMLRecordSetWriter> configurator) {
    return configurator.apply(new XMLRecordSetWriter(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = XMLRecordSetWriter.class) final Closure<XMLRecordSetWriter> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.xml.XMLRecordSetWriter> code = closure.rehydrate(c, com.tibtech.nifi.xml.XMLRecordSetWriter.class, com.tibtech.nifi.xml.XMLRecordSetWriter.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
