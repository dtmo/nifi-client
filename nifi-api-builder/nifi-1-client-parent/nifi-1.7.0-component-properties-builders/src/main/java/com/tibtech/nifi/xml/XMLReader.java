package com.tibtech.nifi.xml;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class XMLReader {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.xml.XMLReader";

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
   * This property defines whether the reader expects a FlowFile to consist of a single Record or a series of Records with a "wrapper element". Because XML does not provide for a way to read a series of XML documents from a stream directly, it is common to combine many XML documents by concatenating them and then wrapping the entire XML blob  with a "wrapper element". This property dictates whether the reader expects a FlowFile to consist of a single Record or a series of Records with a "wrapper element" that will be ignored.
   */
  public static final String RECORD_FORMAT_PROPERTY = "record_format";

  /**
   * If this property is set, the name of attributes will be prepended with a prefix when they are added to a record.
   */
  public static final String ATTRIBUTE_PREFIX_PROPERTY = "attribute_prefix";

  /**
   * If tags with content (e. g. <field>content</field>) are defined as nested records in the schema, the name of the tag will be used as name for the record and the value of this property will be used as name for the field. If tags with content shall be parsed together with attributes (e. g. <field attribute="123">content</field>), they have to be defined as records. For additional information, see the section of processor usage.
   */
  public static final String CONTENT_FIELD_NAME_PROPERTY = "content_field_name";

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

  private final Map<String, String> properties;

  public XMLReader() {
    this.properties = new HashMap<>();
  }

  public XMLReader(final Map<String, String> properties) {
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
  public final XMLReader setSchemaAccessStrategy(final String schemaAccessStrategy) {
    properties.put(SCHEMA_ACCESS_STRATEGY_PROPERTY, schemaAccessStrategy);
    return this;
  }

  /**
   * Specifies how to obtain the schema that is to be used for interpreting the data.
   */
  public final XMLReader removeSchemaAccessStrategy() {
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
  public final XMLReader setSchemaRegistry(final String schemaRegistry) {
    properties.put(SCHEMA_REGISTRY_PROPERTY, schemaRegistry);
    return this;
  }

  /**
   * Specifies the Controller Service to use for the Schema Registry
   */
  public final XMLReader removeSchemaRegistry() {
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
  public final XMLReader setSchemaName(final String schemaName) {
    properties.put(SCHEMA_NAME_PROPERTY, schemaName);
    return this;
  }

  /**
   * Specifies the name of the schema to lookup in the Schema Registry property
   */
  public final XMLReader removeSchemaName() {
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
  public final XMLReader setSchemaVersion(final String schemaVersion) {
    properties.put(SCHEMA_VERSION_PROPERTY, schemaVersion);
    return this;
  }

  /**
   * Specifies the version of the schema to lookup in the Schema Registry. If not specified then the latest version of the schema will be retrieved.
   */
  public final XMLReader removeSchemaVersion() {
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
  public final XMLReader setSchemaBranch(final String schemaBranch) {
    properties.put(SCHEMA_BRANCH_PROPERTY, schemaBranch);
    return this;
  }

  /**
   * Specifies the name of the branch to use when looking up the schema in the Schema Registry property. If the chosen Schema Registry does not support branching, this value will be ignored.
   */
  public final XMLReader removeSchemaBranch() {
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
  public final XMLReader setSchemaText(final String schemaText) {
    properties.put(SCHEMA_TEXT_PROPERTY, schemaText);
    return this;
  }

  /**
   * The text of an Avro-formatted Schema
   */
  public final XMLReader removeSchemaText() {
    properties.remove(SCHEMA_TEXT_PROPERTY);
    return this;
  }

  /**
   * This property defines whether the reader expects a FlowFile to consist of a single Record or a series of Records with a "wrapper element". Because XML does not provide for a way to read a series of XML documents from a stream directly, it is common to combine many XML documents by concatenating them and then wrapping the entire XML blob  with a "wrapper element". This property dictates whether the reader expects a FlowFile to consist of a single Record or a series of Records with a "wrapper element" that will be ignored.
   */
  public final String getRecordFormat() {
    return properties.get(RECORD_FORMAT_PROPERTY);
  }

  /**
   * This property defines whether the reader expects a FlowFile to consist of a single Record or a series of Records with a "wrapper element". Because XML does not provide for a way to read a series of XML documents from a stream directly, it is common to combine many XML documents by concatenating them and then wrapping the entire XML blob  with a "wrapper element". This property dictates whether the reader expects a FlowFile to consist of a single Record or a series of Records with a "wrapper element" that will be ignored.
   */
  public final XMLReader setRecordFormat(final String recordFormat) {
    properties.put(RECORD_FORMAT_PROPERTY, recordFormat);
    return this;
  }

  /**
   * This property defines whether the reader expects a FlowFile to consist of a single Record or a series of Records with a "wrapper element". Because XML does not provide for a way to read a series of XML documents from a stream directly, it is common to combine many XML documents by concatenating them and then wrapping the entire XML blob  with a "wrapper element". This property dictates whether the reader expects a FlowFile to consist of a single Record or a series of Records with a "wrapper element" that will be ignored.
   */
  public final XMLReader removeRecordFormat() {
    properties.remove(RECORD_FORMAT_PROPERTY);
    return this;
  }

  /**
   * If this property is set, the name of attributes will be prepended with a prefix when they are added to a record.
   */
  public final String getAttributePrefix() {
    return properties.get(ATTRIBUTE_PREFIX_PROPERTY);
  }

  /**
   * If this property is set, the name of attributes will be prepended with a prefix when they are added to a record.
   */
  public final XMLReader setAttributePrefix(final String attributePrefix) {
    properties.put(ATTRIBUTE_PREFIX_PROPERTY, attributePrefix);
    return this;
  }

  /**
   * If this property is set, the name of attributes will be prepended with a prefix when they are added to a record.
   */
  public final XMLReader removeAttributePrefix() {
    properties.remove(ATTRIBUTE_PREFIX_PROPERTY);
    return this;
  }

  /**
   * If tags with content (e. g. <field>content</field>) are defined as nested records in the schema, the name of the tag will be used as name for the record and the value of this property will be used as name for the field. If tags with content shall be parsed together with attributes (e. g. <field attribute="123">content</field>), they have to be defined as records. For additional information, see the section of processor usage.
   */
  public final String getContentFieldName() {
    return properties.get(CONTENT_FIELD_NAME_PROPERTY);
  }

  /**
   * If tags with content (e. g. <field>content</field>) are defined as nested records in the schema, the name of the tag will be used as name for the record and the value of this property will be used as name for the field. If tags with content shall be parsed together with attributes (e. g. <field attribute="123">content</field>), they have to be defined as records. For additional information, see the section of processor usage.
   */
  public final XMLReader setContentFieldName(final String contentFieldName) {
    properties.put(CONTENT_FIELD_NAME_PROPERTY, contentFieldName);
    return this;
  }

  /**
   * If tags with content (e. g. <field>content</field>) are defined as nested records in the schema, the name of the tag will be used as name for the record and the value of this property will be used as name for the field. If tags with content shall be parsed together with attributes (e. g. <field attribute="123">content</field>), they have to be defined as records. For additional information, see the section of processor usage.
   */
  public final XMLReader removeContentFieldName() {
    properties.remove(CONTENT_FIELD_NAME_PROPERTY);
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
  public final XMLReader setDateFormat(final String dateFormat) {
    properties.put(DATE_FORMAT_PROPERTY, dateFormat);
    return this;
  }

  /**
   * Specifies the format to use when reading/writing Date fields. If not specified, Date fields will be assumed to be number of milliseconds since epoch (Midnight, Jan 1, 1970 GMT). If specified, the value must match the Java Simple Date Format (for example, MM/dd/yyyy for a two-digit month, followed by a two-digit day, followed by a four-digit year, all separated by '/' characters, as in 01/01/2017).
   */
  public final XMLReader removeDateFormat() {
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
  public final XMLReader setTimeFormat(final String timeFormat) {
    properties.put(TIME_FORMAT_PROPERTY, timeFormat);
    return this;
  }

  /**
   * Specifies the format to use when reading/writing Time fields. If not specified, Time fields will be assumed to be number of milliseconds since epoch (Midnight, Jan 1, 1970 GMT). If specified, the value must match the Java Simple Date Format (for example, HH:mm:ss for a two-digit hour in 24-hour format, followed by a two-digit minute, followed by a two-digit second, all separated by ':' characters, as in 18:04:15).
   */
  public final XMLReader removeTimeFormat() {
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
  public final XMLReader setTimestampFormat(final String timestampFormat) {
    properties.put(TIMESTAMP_FORMAT_PROPERTY, timestampFormat);
    return this;
  }

  /**
   * Specifies the format to use when reading/writing Timestamp fields. If not specified, Timestamp fields will be assumed to be number of milliseconds since epoch (Midnight, Jan 1, 1970 GMT). If specified, the value must match the Java Simple Date Format (for example, MM/dd/yyyy HH:mm:ss for a two-digit month, followed by a two-digit day, followed by a four-digit year, all separated by '/' characters; and then followed by a two-digit hour in 24-hour format, followed by a two-digit minute, followed by a two-digit second, all separated by ':' characters, as in 01/01/2017 18:04:15).
   */
  public final XMLReader removeTimestampFormat() {
    properties.remove(TIMESTAMP_FORMAT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final XMLReader setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final XMLReader removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<XMLReader, XMLReader> configurator) {
    return configurator.apply(new XMLReader()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = XMLReader.class) final Closure<XMLReader> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.xml.XMLReader> code = closure.rehydrate(c, com.tibtech.nifi.xml.XMLReader.class, com.tibtech.nifi.xml.XMLReader.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<XMLReader, XMLReader> configurator) {
    return configurator.apply(new XMLReader(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = XMLReader.class) final Closure<XMLReader> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.xml.XMLReader> code = closure.rehydrate(c, com.tibtech.nifi.xml.XMLReader.class, com.tibtech.nifi.xml.XMLReader.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
