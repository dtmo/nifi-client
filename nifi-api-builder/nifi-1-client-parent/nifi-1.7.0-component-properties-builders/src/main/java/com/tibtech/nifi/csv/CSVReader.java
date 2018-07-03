package com.tibtech.nifi.csv;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class CSVReader {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.csv.CSVReader";

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
   * Specifies which parser to use to read CSV records. NOTE: Different parsers may support different subsets of functionality and may also exhibit different levels of performance.
   */
  public static final String CSV_READER_CSV_PARSER_PROPERTY = "csv-reader-csv-parser";

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
   * Specifies whether or not the first line of CSV should be considered a Header or should be considered a record. If the Schema Access Strategy indicates that the columns must be defined in the header, then this property will be ignored, since the header must always be present and won't be processed as a Record. Otherwise, if 'true', then the first line of CSV data will not be processed as a record and if 'false',then the first line will be interpreted as a record.
   */
  public static final String SKIP_HEADER_LINE_PROPERTY = "Skip Header Line";

  /**
   * If the first line of a CSV is a header, and the configured schema does not match the fields named in the header line, this controls how the Reader will interpret the fields. If this property is true, then the field names mapped to each column are driven only by the configured schema and any fields not in the schema will be ignored. If this property is false, then the field names found in the CSV Header will be used as the names of the fields.
   */
  public static final String IGNORE_CSV_HEADER_PROPERTY = "ignore-csv-header";

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
   * The Character Encoding that is used to encode/decode the CSV file
   */
  public static final String CSVUTILS_CHARACTER_SET_PROPERTY = "csvutils-character-set";

  private final Map<String, String> properties;

  public CSVReader() {
    this.properties = new HashMap<>();
  }

  public CSVReader(final Map<String, String> properties) {
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
  public final CSVReader setSchemaAccessStrategy(final String schemaAccessStrategy) {
    properties.put(SCHEMA_ACCESS_STRATEGY_PROPERTY, schemaAccessStrategy);
    return this;
  }

  /**
   * Specifies how to obtain the schema that is to be used for interpreting the data.
   */
  public final CSVReader removeSchemaAccessStrategy() {
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
  public final CSVReader setSchemaRegistry(final String schemaRegistry) {
    properties.put(SCHEMA_REGISTRY_PROPERTY, schemaRegistry);
    return this;
  }

  /**
   * Specifies the Controller Service to use for the Schema Registry
   */
  public final CSVReader removeSchemaRegistry() {
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
  public final CSVReader setSchemaName(final String schemaName) {
    properties.put(SCHEMA_NAME_PROPERTY, schemaName);
    return this;
  }

  /**
   * Specifies the name of the schema to lookup in the Schema Registry property
   */
  public final CSVReader removeSchemaName() {
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
  public final CSVReader setSchemaVersion(final String schemaVersion) {
    properties.put(SCHEMA_VERSION_PROPERTY, schemaVersion);
    return this;
  }

  /**
   * Specifies the version of the schema to lookup in the Schema Registry. If not specified then the latest version of the schema will be retrieved.
   */
  public final CSVReader removeSchemaVersion() {
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
  public final CSVReader setSchemaBranch(final String schemaBranch) {
    properties.put(SCHEMA_BRANCH_PROPERTY, schemaBranch);
    return this;
  }

  /**
   * Specifies the name of the branch to use when looking up the schema in the Schema Registry property. If the chosen Schema Registry does not support branching, this value will be ignored.
   */
  public final CSVReader removeSchemaBranch() {
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
  public final CSVReader setSchemaText(final String schemaText) {
    properties.put(SCHEMA_TEXT_PROPERTY, schemaText);
    return this;
  }

  /**
   * The text of an Avro-formatted Schema
   */
  public final CSVReader removeSchemaText() {
    properties.remove(SCHEMA_TEXT_PROPERTY);
    return this;
  }

  /**
   * Specifies which parser to use to read CSV records. NOTE: Different parsers may support different subsets of functionality and may also exhibit different levels of performance.
   */
  public final String getCsvReaderCsvParser() {
    return properties.get(CSV_READER_CSV_PARSER_PROPERTY);
  }

  /**
   * Specifies which parser to use to read CSV records. NOTE: Different parsers may support different subsets of functionality and may also exhibit different levels of performance.
   */
  public final CSVReader setCsvReaderCsvParser(final String csvReaderCsvParser) {
    properties.put(CSV_READER_CSV_PARSER_PROPERTY, csvReaderCsvParser);
    return this;
  }

  /**
   * Specifies which parser to use to read CSV records. NOTE: Different parsers may support different subsets of functionality and may also exhibit different levels of performance.
   */
  public final CSVReader removeCsvReaderCsvParser() {
    properties.remove(CSV_READER_CSV_PARSER_PROPERTY);
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
  public final CSVReader setDateFormat(final String dateFormat) {
    properties.put(DATE_FORMAT_PROPERTY, dateFormat);
    return this;
  }

  /**
   * Specifies the format to use when reading/writing Date fields. If not specified, Date fields will be assumed to be number of milliseconds since epoch (Midnight, Jan 1, 1970 GMT). If specified, the value must match the Java Simple Date Format (for example, MM/dd/yyyy for a two-digit month, followed by a two-digit day, followed by a four-digit year, all separated by '/' characters, as in 01/01/2017).
   */
  public final CSVReader removeDateFormat() {
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
  public final CSVReader setTimeFormat(final String timeFormat) {
    properties.put(TIME_FORMAT_PROPERTY, timeFormat);
    return this;
  }

  /**
   * Specifies the format to use when reading/writing Time fields. If not specified, Time fields will be assumed to be number of milliseconds since epoch (Midnight, Jan 1, 1970 GMT). If specified, the value must match the Java Simple Date Format (for example, HH:mm:ss for a two-digit hour in 24-hour format, followed by a two-digit minute, followed by a two-digit second, all separated by ':' characters, as in 18:04:15).
   */
  public final CSVReader removeTimeFormat() {
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
  public final CSVReader setTimestampFormat(final String timestampFormat) {
    properties.put(TIMESTAMP_FORMAT_PROPERTY, timestampFormat);
    return this;
  }

  /**
   * Specifies the format to use when reading/writing Timestamp fields. If not specified, Timestamp fields will be assumed to be number of milliseconds since epoch (Midnight, Jan 1, 1970 GMT). If specified, the value must match the Java Simple Date Format (for example, MM/dd/yyyy HH:mm:ss for a two-digit month, followed by a two-digit day, followed by a four-digit year, all separated by '/' characters; and then followed by a two-digit hour in 24-hour format, followed by a two-digit minute, followed by a two-digit second, all separated by ':' characters, as in 01/01/2017 18:04:15).
   */
  public final CSVReader removeTimestampFormat() {
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
  public final CSVReader setCsvFormat(final String csvFormat) {
    properties.put(CSV_FORMAT_PROPERTY, csvFormat);
    return this;
  }

  /**
   * Specifies which "format" the CSV data is in, or specifies if custom formatting should be used.
   */
  public final CSVReader removeCsvFormat() {
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
  public final CSVReader setValueSeparator(final String valueSeparator) {
    properties.put(VALUE_SEPARATOR_PROPERTY, valueSeparator);
    return this;
  }

  /**
   * The character that is used to separate values/fields in a CSV Record
   */
  public final CSVReader removeValueSeparator() {
    properties.remove(VALUE_SEPARATOR_PROPERTY);
    return this;
  }

  /**
   * Specifies whether or not the first line of CSV should be considered a Header or should be considered a record. If the Schema Access Strategy indicates that the columns must be defined in the header, then this property will be ignored, since the header must always be present and won't be processed as a Record. Otherwise, if 'true', then the first line of CSV data will not be processed as a record and if 'false',then the first line will be interpreted as a record.
   */
  public final String getSkipHeaderLine() {
    return properties.get(SKIP_HEADER_LINE_PROPERTY);
  }

  /**
   * Specifies whether or not the first line of CSV should be considered a Header or should be considered a record. If the Schema Access Strategy indicates that the columns must be defined in the header, then this property will be ignored, since the header must always be present and won't be processed as a Record. Otherwise, if 'true', then the first line of CSV data will not be processed as a record and if 'false',then the first line will be interpreted as a record.
   */
  public final CSVReader setSkipHeaderLine(final String skipHeaderLine) {
    properties.put(SKIP_HEADER_LINE_PROPERTY, skipHeaderLine);
    return this;
  }

  /**
   * Specifies whether or not the first line of CSV should be considered a Header or should be considered a record. If the Schema Access Strategy indicates that the columns must be defined in the header, then this property will be ignored, since the header must always be present and won't be processed as a Record. Otherwise, if 'true', then the first line of CSV data will not be processed as a record and if 'false',then the first line will be interpreted as a record.
   */
  public final CSVReader removeSkipHeaderLine() {
    properties.remove(SKIP_HEADER_LINE_PROPERTY);
    return this;
  }

  /**
   * If the first line of a CSV is a header, and the configured schema does not match the fields named in the header line, this controls how the Reader will interpret the fields. If this property is true, then the field names mapped to each column are driven only by the configured schema and any fields not in the schema will be ignored. If this property is false, then the field names found in the CSV Header will be used as the names of the fields.
   */
  public final String getIgnoreCsvHeader() {
    return properties.get(IGNORE_CSV_HEADER_PROPERTY);
  }

  /**
   * If the first line of a CSV is a header, and the configured schema does not match the fields named in the header line, this controls how the Reader will interpret the fields. If this property is true, then the field names mapped to each column are driven only by the configured schema and any fields not in the schema will be ignored. If this property is false, then the field names found in the CSV Header will be used as the names of the fields.
   */
  public final CSVReader setIgnoreCsvHeader(final String ignoreCsvHeader) {
    properties.put(IGNORE_CSV_HEADER_PROPERTY, ignoreCsvHeader);
    return this;
  }

  /**
   * If the first line of a CSV is a header, and the configured schema does not match the fields named in the header line, this controls how the Reader will interpret the fields. If this property is true, then the field names mapped to each column are driven only by the configured schema and any fields not in the schema will be ignored. If this property is false, then the field names found in the CSV Header will be used as the names of the fields.
   */
  public final CSVReader removeIgnoreCsvHeader() {
    properties.remove(IGNORE_CSV_HEADER_PROPERTY);
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
  public final CSVReader setQuoteCharacter(final String quoteCharacter) {
    properties.put(QUOTE_CHARACTER_PROPERTY, quoteCharacter);
    return this;
  }

  /**
   * The character that is used to quote values so that escape characters do not have to be used
   */
  public final CSVReader removeQuoteCharacter() {
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
  public final CSVReader setEscapeCharacter(final String escapeCharacter) {
    properties.put(ESCAPE_CHARACTER_PROPERTY, escapeCharacter);
    return this;
  }

  /**
   * The character that is used to escape characters that would otherwise have a specific meaning to the CSV Parser.
   */
  public final CSVReader removeEscapeCharacter() {
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
  public final CSVReader setCommentMarker(final String commentMarker) {
    properties.put(COMMENT_MARKER_PROPERTY, commentMarker);
    return this;
  }

  /**
   * The character that is used to denote the start of a comment. Any line that begins with this comment will be ignored.
   */
  public final CSVReader removeCommentMarker() {
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
  public final CSVReader setNullString(final String nullString) {
    properties.put(NULL_STRING_PROPERTY, nullString);
    return this;
  }

  /**
   * Specifies a String that, if present as a value in the CSV, should be considered a null field instead of using the literal value.
   */
  public final CSVReader removeNullString() {
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
  public final CSVReader setTrimFields(final String trimFields) {
    properties.put(TRIM_FIELDS_PROPERTY, trimFields);
    return this;
  }

  /**
   * Whether or not white space should be removed from the beginning and end of fields
   */
  public final CSVReader removeTrimFields() {
    properties.remove(TRIM_FIELDS_PROPERTY);
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
  public final CSVReader setCsvutilsCharacterSet(final String csvutilsCharacterSet) {
    properties.put(CSVUTILS_CHARACTER_SET_PROPERTY, csvutilsCharacterSet);
    return this;
  }

  /**
   * The Character Encoding that is used to encode/decode the CSV file
   */
  public final CSVReader removeCsvutilsCharacterSet() {
    properties.remove(CSVUTILS_CHARACTER_SET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final CSVReader setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final CSVReader removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<CSVReader, CSVReader> configurator) {
    return configurator.apply(new CSVReader()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CSVReader.class) final Closure<CSVReader> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.csv.CSVReader> code = closure.rehydrate(c, com.tibtech.nifi.csv.CSVReader.class, com.tibtech.nifi.csv.CSVReader.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<CSVReader, CSVReader> configurator) {
    return configurator.apply(new CSVReader(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = CSVReader.class) final Closure<CSVReader> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.csv.CSVReader> code = closure.rehydrate(c, com.tibtech.nifi.csv.CSVReader.class, com.tibtech.nifi.csv.CSVReader.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
