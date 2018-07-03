package com.tibtech.nifi.csv;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class CSVRecordSetWriter {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.csv.CSVRecordSetWriter";

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
   * Specifies which "format" the CSV data is in, or specifies if custom formatting should be used.
   */
  public static final String CSV_FORMAT_PROPERTY = "CSV Format";

  /**
   * The character that is used to separate values/fields in a CSV Record
   */
  public static final String VALUE_SEPARATOR_PROPERTY = "Value Separator";

  /**
   * Specifies whether or not the CSV column names should be written out as the first line.
   */
  public static final String INCLUDE_HEADER_LINE_PROPERTY = "Include Header Line";

  /**
   * The character that is used to quote values so that escape characters do not have to be used
   */
  public static final String QUOTE_CHARACTER_PROPERTY = "Quote Character";

  /**
   * The character that is used to escape characters that would otherwise have a specific meaning to the CSV Parser.
   */
  public static final String ESCAPE_CHARACTER_PROPERTY = "Escape Character";

  /**
   * The character that is used to denote the start of a comment. Any line that begins with this comment will be ignored.
   */
  public static final String COMMENT_MARKER_PROPERTY = "Comment Marker";

  /**
   * Specifies a String that, if present as a value in the CSV, should be considered a null field instead of using the literal value.
   */
  public static final String NULL_STRING_PROPERTY = "Null String";

  /**
   * Whether or not white space should be removed from the beginning and end of fields
   */
  public static final String TRIM_FIELDS_PROPERTY = "Trim Fields";

  /**
   * Specifies how fields should be quoted when they are written
   */
  public static final String QUOTE_MODE_PROPERTY = "Quote Mode";

  /**
   * Specifies the characters to use in order to separate CSV Records
   */
  public static final String RECORD_SEPARATOR_PROPERTY = "Record Separator";

  /**
   * If true, a trailing delimiter will be added to each CSV Record that is written. If false, the trailing delimiter will be omitted.
   */
  public static final String INCLUDE_TRAILING_DELIMITER_PROPERTY = "Include Trailing Delimiter";

  /**
   * The Character Encoding that is used to encode/decode the CSV file
   */
  public static final String CSVUTILS_CHARACTER_SET_PROPERTY = "csvutils-character-set";

  private final Map<String, String> properties;

  public CSVRecordSetWriter() {
    this.properties = new HashMap<>();
  }

  public CSVRecordSetWriter(final Map<String, String> properties) {
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
  public final CSVRecordSetWriter setSchemaWriteStrategy(final String schemaWriteStrategy) {
    properties.put(SCHEMA_WRITE_STRATEGY_PROPERTY, schemaWriteStrategy);
    return this;
  }

  /**
   * Specifies how the schema for a Record should be added to the data.
   */
  public final CSVRecordSetWriter removeSchemaWriteStrategy() {
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
  public final CSVRecordSetWriter setSchemaAccessStrategy(final String schemaAccessStrategy) {
    properties.put(SCHEMA_ACCESS_STRATEGY_PROPERTY, schemaAccessStrategy);
    return this;
  }

  /**
   * Specifies how to obtain the schema that is to be used for interpreting the data.
   */
  public final CSVRecordSetWriter removeSchemaAccessStrategy() {
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
  public final CSVRecordSetWriter setSchemaRegistry(final String schemaRegistry) {
    properties.put(SCHEMA_REGISTRY_PROPERTY, schemaRegistry);
    return this;
  }

  /**
   * Specifies the Controller Service to use for the Schema Registry
   */
  public final CSVRecordSetWriter removeSchemaRegistry() {
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
  public final CSVRecordSetWriter setSchemaName(final String schemaName) {
    properties.put(SCHEMA_NAME_PROPERTY, schemaName);
    return this;
  }

  /**
   * Specifies the name of the schema to lookup in the Schema Registry property
   */
  public final CSVRecordSetWriter removeSchemaName() {
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
  public final CSVRecordSetWriter setSchemaVersion(final String schemaVersion) {
    properties.put(SCHEMA_VERSION_PROPERTY, schemaVersion);
    return this;
  }

  /**
   * Specifies the version of the schema to lookup in the Schema Registry. If not specified then the latest version of the schema will be retrieved.
   */
  public final CSVRecordSetWriter removeSchemaVersion() {
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
  public final CSVRecordSetWriter setSchemaBranch(final String schemaBranch) {
    properties.put(SCHEMA_BRANCH_PROPERTY, schemaBranch);
    return this;
  }

  /**
   * Specifies the name of the branch to use when looking up the schema in the Schema Registry property. If the chosen Schema Registry does not support branching, this value will be ignored.
   */
  public final CSVRecordSetWriter removeSchemaBranch() {
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
  public final CSVRecordSetWriter setSchemaText(final String schemaText) {
    properties.put(SCHEMA_TEXT_PROPERTY, schemaText);
    return this;
  }

  /**
   * The text of an Avro-formatted Schema
   */
  public final CSVRecordSetWriter removeSchemaText() {
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
  public final CSVRecordSetWriter setDateFormat(final String dateFormat) {
    properties.put(DATE_FORMAT_PROPERTY, dateFormat);
    return this;
  }

  /**
   * Specifies the format to use when reading/writing Date fields. If not specified, Date fields will be assumed to be number of milliseconds since epoch (Midnight, Jan 1, 1970 GMT). If specified, the value must match the Java Simple Date Format (for example, MM/dd/yyyy for a two-digit month, followed by a two-digit day, followed by a four-digit year, all separated by '/' characters, as in 01/01/2017).
   */
  public final CSVRecordSetWriter removeDateFormat() {
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
  public final CSVRecordSetWriter setTimeFormat(final String timeFormat) {
    properties.put(TIME_FORMAT_PROPERTY, timeFormat);
    return this;
  }

  /**
   * Specifies the format to use when reading/writing Time fields. If not specified, Time fields will be assumed to be number of milliseconds since epoch (Midnight, Jan 1, 1970 GMT). If specified, the value must match the Java Simple Date Format (for example, HH:mm:ss for a two-digit hour in 24-hour format, followed by a two-digit minute, followed by a two-digit second, all separated by ':' characters, as in 18:04:15).
   */
  public final CSVRecordSetWriter removeTimeFormat() {
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
  public final CSVRecordSetWriter setTimestampFormat(final String timestampFormat) {
    properties.put(TIMESTAMP_FORMAT_PROPERTY, timestampFormat);
    return this;
  }

  /**
   * Specifies the format to use when reading/writing Timestamp fields. If not specified, Timestamp fields will be assumed to be number of milliseconds since epoch (Midnight, Jan 1, 1970 GMT). If specified, the value must match the Java Simple Date Format (for example, MM/dd/yyyy HH:mm:ss for a two-digit month, followed by a two-digit day, followed by a four-digit year, all separated by '/' characters; and then followed by a two-digit hour in 24-hour format, followed by a two-digit minute, followed by a two-digit second, all separated by ':' characters, as in 01/01/2017 18:04:15).
   */
  public final CSVRecordSetWriter removeTimestampFormat() {
    properties.remove(TIMESTAMP_FORMAT_PROPERTY);
    return this;
  }

  /**
   * Specifies which "format" the CSV data is in, or specifies if custom formatting should be used.
   */
  public final String getCsvFormat() {
    return properties.get(CSV_FORMAT_PROPERTY);
  }

  /**
   * Specifies which "format" the CSV data is in, or specifies if custom formatting should be used.
   */
  public final CSVRecordSetWriter setCsvFormat(final String csvFormat) {
    properties.put(CSV_FORMAT_PROPERTY, csvFormat);
    return this;
  }

  /**
   * Specifies which "format" the CSV data is in, or specifies if custom formatting should be used.
   */
  public final CSVRecordSetWriter removeCsvFormat() {
    properties.remove(CSV_FORMAT_PROPERTY);
    return this;
  }

  /**
   * The character that is used to separate values/fields in a CSV Record
   */
  public final String getValueSeparator() {
    return properties.get(VALUE_SEPARATOR_PROPERTY);
  }

  /**
   * The character that is used to separate values/fields in a CSV Record
   */
  public final CSVRecordSetWriter setValueSeparator(final String valueSeparator) {
    properties.put(VALUE_SEPARATOR_PROPERTY, valueSeparator);
    return this;
  }

  /**
   * The character that is used to separate values/fields in a CSV Record
   */
  public final CSVRecordSetWriter removeValueSeparator() {
    properties.remove(VALUE_SEPARATOR_PROPERTY);
    return this;
  }

  /**
   * Specifies whether or not the CSV column names should be written out as the first line.
   */
  public final String getIncludeHeaderLine() {
    return properties.get(INCLUDE_HEADER_LINE_PROPERTY);
  }

  /**
   * Specifies whether or not the CSV column names should be written out as the first line.
   */
  public final CSVRecordSetWriter setIncludeHeaderLine(final String includeHeaderLine) {
    properties.put(INCLUDE_HEADER_LINE_PROPERTY, includeHeaderLine);
    return this;
  }

  /**
   * Specifies whether or not the CSV column names should be written out as the first line.
   */
  public final CSVRecordSetWriter removeIncludeHeaderLine() {
    properties.remove(INCLUDE_HEADER_LINE_PROPERTY);
    return this;
  }

  /**
   * The character that is used to quote values so that escape characters do not have to be used
   */
  public final String getQuoteCharacter() {
    return properties.get(QUOTE_CHARACTER_PROPERTY);
  }

  /**
   * The character that is used to quote values so that escape characters do not have to be used
   */
  public final CSVRecordSetWriter setQuoteCharacter(final String quoteCharacter) {
    properties.put(QUOTE_CHARACTER_PROPERTY, quoteCharacter);
    return this;
  }

  /**
   * The character that is used to quote values so that escape characters do not have to be used
   */
  public final CSVRecordSetWriter removeQuoteCharacter() {
    properties.remove(QUOTE_CHARACTER_PROPERTY);
    return this;
  }

  /**
   * The character that is used to escape characters that would otherwise have a specific meaning to the CSV Parser.
   */
  public final String getEscapeCharacter() {
    return properties.get(ESCAPE_CHARACTER_PROPERTY);
  }

  /**
   * The character that is used to escape characters that would otherwise have a specific meaning to the CSV Parser.
   */
  public final CSVRecordSetWriter setEscapeCharacter(final String escapeCharacter) {
    properties.put(ESCAPE_CHARACTER_PROPERTY, escapeCharacter);
    return this;
  }

  /**
   * The character that is used to escape characters that would otherwise have a specific meaning to the CSV Parser.
   */
  public final CSVRecordSetWriter removeEscapeCharacter() {
    properties.remove(ESCAPE_CHARACTER_PROPERTY);
    return this;
  }

  /**
   * The character that is used to denote the start of a comment. Any line that begins with this comment will be ignored.
   */
  public final String getCommentMarker() {
    return properties.get(COMMENT_MARKER_PROPERTY);
  }

  /**
   * The character that is used to denote the start of a comment. Any line that begins with this comment will be ignored.
   */
  public final CSVRecordSetWriter setCommentMarker(final String commentMarker) {
    properties.put(COMMENT_MARKER_PROPERTY, commentMarker);
    return this;
  }

  /**
   * The character that is used to denote the start of a comment. Any line that begins with this comment will be ignored.
   */
  public final CSVRecordSetWriter removeCommentMarker() {
    properties.remove(COMMENT_MARKER_PROPERTY);
    return this;
  }

  /**
   * Specifies a String that, if present as a value in the CSV, should be considered a null field instead of using the literal value.
   */
  public final String getNullString() {
    return properties.get(NULL_STRING_PROPERTY);
  }

  /**
   * Specifies a String that, if present as a value in the CSV, should be considered a null field instead of using the literal value.
   */
  public final CSVRecordSetWriter setNullString(final String nullString) {
    properties.put(NULL_STRING_PROPERTY, nullString);
    return this;
  }

  /**
   * Specifies a String that, if present as a value in the CSV, should be considered a null field instead of using the literal value.
   */
  public final CSVRecordSetWriter removeNullString() {
    properties.remove(NULL_STRING_PROPERTY);
    return this;
  }

  /**
   * Whether or not white space should be removed from the beginning and end of fields
   */
  public final String getTrimFields() {
    return properties.get(TRIM_FIELDS_PROPERTY);
  }

  /**
   * Whether or not white space should be removed from the beginning and end of fields
   */
  public final CSVRecordSetWriter setTrimFields(final String trimFields) {
    properties.put(TRIM_FIELDS_PROPERTY, trimFields);
    return this;
  }

  /**
   * Whether or not white space should be removed from the beginning and end of fields
   */
  public final CSVRecordSetWriter removeTrimFields() {
    properties.remove(TRIM_FIELDS_PROPERTY);
    return this;
  }

  /**
   * Specifies how fields should be quoted when they are written
   */
  public final String getQuoteMode() {
    return properties.get(QUOTE_MODE_PROPERTY);
  }

  /**
   * Specifies how fields should be quoted when they are written
   */
  public final CSVRecordSetWriter setQuoteMode(final String quoteMode) {
    properties.put(QUOTE_MODE_PROPERTY, quoteMode);
    return this;
  }

  /**
   * Specifies how fields should be quoted when they are written
   */
  public final CSVRecordSetWriter removeQuoteMode() {
    properties.remove(QUOTE_MODE_PROPERTY);
    return this;
  }

  /**
   * Specifies the characters to use in order to separate CSV Records
   */
  public final String getRecordSeparator() {
    return properties.get(RECORD_SEPARATOR_PROPERTY);
  }

  /**
   * Specifies the characters to use in order to separate CSV Records
   */
  public final CSVRecordSetWriter setRecordSeparator(final String recordSeparator) {
    properties.put(RECORD_SEPARATOR_PROPERTY, recordSeparator);
    return this;
  }

  /**
   * Specifies the characters to use in order to separate CSV Records
   */
  public final CSVRecordSetWriter removeRecordSeparator() {
    properties.remove(RECORD_SEPARATOR_PROPERTY);
    return this;
  }

  /**
   * If true, a trailing delimiter will be added to each CSV Record that is written. If false, the trailing delimiter will be omitted.
   */
  public final String getIncludeTrailingDelimiter() {
    return properties.get(INCLUDE_TRAILING_DELIMITER_PROPERTY);
  }

  /**
   * If true, a trailing delimiter will be added to each CSV Record that is written. If false, the trailing delimiter will be omitted.
   */
  public final CSVRecordSetWriter setIncludeTrailingDelimiter(
      final String includeTrailingDelimiter) {
    properties.put(INCLUDE_TRAILING_DELIMITER_PROPERTY, includeTrailingDelimiter);
    return this;
  }

  /**
   * If true, a trailing delimiter will be added to each CSV Record that is written. If false, the trailing delimiter will be omitted.
   */
  public final CSVRecordSetWriter removeIncludeTrailingDelimiter() {
    properties.remove(INCLUDE_TRAILING_DELIMITER_PROPERTY);
    return this;
  }

  /**
   * The Character Encoding that is used to encode/decode the CSV file
   */
  public final String getCsvutilsCharacterSet() {
    return properties.get(CSVUTILS_CHARACTER_SET_PROPERTY);
  }

  /**
   * The Character Encoding that is used to encode/decode the CSV file
   */
  public final CSVRecordSetWriter setCsvutilsCharacterSet(final String csvutilsCharacterSet) {
    properties.put(CSVUTILS_CHARACTER_SET_PROPERTY, csvutilsCharacterSet);
    return this;
  }

  /**
   * The Character Encoding that is used to encode/decode the CSV file
   */
  public final CSVRecordSetWriter removeCsvutilsCharacterSet() {
    properties.remove(CSVUTILS_CHARACTER_SET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final CSVRecordSetWriter setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final CSVRecordSetWriter removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<CSVRecordSetWriter, CSVRecordSetWriter> configurator) {
    return configurator.apply(new CSVRecordSetWriter()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CSVRecordSetWriter.class) final Closure<CSVRecordSetWriter> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.csv.CSVRecordSetWriter> code = closure.rehydrate(c, com.tibtech.nifi.csv.CSVRecordSetWriter.class, com.tibtech.nifi.csv.CSVRecordSetWriter.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<CSVRecordSetWriter, CSVRecordSetWriter> configurator) {
    return configurator.apply(new CSVRecordSetWriter(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CSVRecordSetWriter.class) final Closure<CSVRecordSetWriter> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.csv.CSVRecordSetWriter> code = closure.rehydrate(c, com.tibtech.nifi.csv.CSVRecordSetWriter.class, com.tibtech.nifi.csv.CSVRecordSetWriter.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
