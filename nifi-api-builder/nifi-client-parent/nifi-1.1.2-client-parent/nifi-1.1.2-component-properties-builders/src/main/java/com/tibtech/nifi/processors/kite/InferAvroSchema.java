package com.tibtech.nifi.processors.kite;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class InferAvroSchema {
  /**
   * Control if Avro schema is written as a new flowfile attribute 'inferred.avro.schema' or written in the flowfile content. Writing to flowfile content will overwrite any existing flowfile content.
   */
  public static final String SCHEMA_OUTPUT_DESTINATION_PROPERTY = "Schema Output Destination";

  /**
   * Content Type of data present in the incoming FlowFile's content. Only "json" or "csv" are supported. If this value is set to "use mime.type value" the incoming Flowfile's attribute "MIME_TYPE" will be used to determine the Content Type.
   */
  public static final String INPUT_CONTENT_TYPE_PROPERTY = "Input Content Type";

  /**
   * This property only applies to CSV content type. Comma separated string defining the column names expected in the CSV data. EX: "fname,lname,zip,address". The elements present in this string should be in the same order as the underlying data. Setting this property will cause the value of "Get CSV Header Definition From Data" to be ignored instead using this value.
   */
  public static final String CSV_HEADER_DEFINITION_PROPERTY = "CSV Header Definition";

  /**
   * This property only applies to CSV content type. If "true" the processor will attempt to read the CSV header definition from the first line of the input data.
   */
  public static final String GET_CSV_HEADER_DEFINITION_FROM_DATA_PROPERTY = "Get CSV Header Definition From Data";

  /**
   * This property only applies to CSV content type. Specifies the number of lines that should be skipped when reading the CSV data. Setting this value to 0 is equivalent to saying "the entire contents of the file should be read". If the property "Get CSV Header Definition From Data" is set then the first line of the CSV  file will be read in and treated as the CSV header definition. Since this will remove the header line from the data care should be taken to make sure the value of "CSV header Line Skip Count" is set to 0 to ensure no data is skipped.
   */
  public static final String CSV_HEADER_LINE_SKIP_COUNT_PROPERTY = "CSV Header Line Skip Count";

  /**
   * Delimiter character for CSV records
   */
  public static final String CSV_DELIMITER_PROPERTY = "CSV delimiter";

  /**
   * This property only applies to CSV content type. String that represents an escape sequence in the CSV FlowFile content data.
   */
  public static final String CSV_ESCAPE_STRING_PROPERTY = "CSV Escape String";

  /**
   * This property only applies to CSV content type. String that represents a literal quote character in the CSV FlowFile content data.
   */
  public static final String CSV_QUOTE_STRING_PROPERTY = "CSV Quote String";

  /**
   * If true the Avro output will be formatted.
   */
  public static final String PRETTY_AVRO_OUTPUT_PROPERTY = "Pretty Avro Output";

  /**
   * Value to be placed in the Avro record schema "name" field. The value must adhere to the Avro naming rules for fullname. If Expression Language is present then the evaluated value must adhere to the Avro naming rules.
   */
  public static final String AVRO_RECORD_NAME_PROPERTY = "Avro Record Name";

  /**
   * This property only applies to JSON content type. The number of JSON records that should be examined to determine the Avro schema. The higher the value the better chance kite has of detecting the appropriate type. However the default value of 10 is almost always enough.
   */
  public static final String NUMBER_OF_RECORDS_TO_ANALYZE_PROPERTY = "Number Of Records To Analyze";

  /**
   * Character encoding of CSV data.
   */
  public static final String CHARSET_PROPERTY = "Charset";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Control if Avro schema is written as a new flowfile attribute 'inferred.avro.schema' or written in the flowfile content. Writing to flowfile content will overwrite any existing flowfile content.
   */
  public final String getSchemaOutputDestination() {
    return properties.get(SCHEMA_OUTPUT_DESTINATION_PROPERTY);
  }

  /**
   * Control if Avro schema is written as a new flowfile attribute 'inferred.avro.schema' or written in the flowfile content. Writing to flowfile content will overwrite any existing flowfile content.
   */
  public final InferAvroSchema setSchemaOutputDestination(final String schemaOutputDestination) {
    properties.put(SCHEMA_OUTPUT_DESTINATION_PROPERTY, schemaOutputDestination);
    return this;
  }

  /**
   * Control if Avro schema is written as a new flowfile attribute 'inferred.avro.schema' or written in the flowfile content. Writing to flowfile content will overwrite any existing flowfile content.
   */
  public final InferAvroSchema removeSchemaOutputDestination() {
    properties.remove(SCHEMA_OUTPUT_DESTINATION_PROPERTY);
    return this;
  }

  /**
   * Content Type of data present in the incoming FlowFile's content. Only "json" or "csv" are supported. If this value is set to "use mime.type value" the incoming Flowfile's attribute "MIME_TYPE" will be used to determine the Content Type.
   */
  public final String getInputContentType() {
    return properties.get(INPUT_CONTENT_TYPE_PROPERTY);
  }

  /**
   * Content Type of data present in the incoming FlowFile's content. Only "json" or "csv" are supported. If this value is set to "use mime.type value" the incoming Flowfile's attribute "MIME_TYPE" will be used to determine the Content Type.
   */
  public final InferAvroSchema setInputContentType(final String inputContentType) {
    properties.put(INPUT_CONTENT_TYPE_PROPERTY, inputContentType);
    return this;
  }

  /**
   * Content Type of data present in the incoming FlowFile's content. Only "json" or "csv" are supported. If this value is set to "use mime.type value" the incoming Flowfile's attribute "MIME_TYPE" will be used to determine the Content Type.
   */
  public final InferAvroSchema removeInputContentType() {
    properties.remove(INPUT_CONTENT_TYPE_PROPERTY);
    return this;
  }

  /**
   * This property only applies to CSV content type. Comma separated string defining the column names expected in the CSV data. EX: "fname,lname,zip,address". The elements present in this string should be in the same order as the underlying data. Setting this property will cause the value of "Get CSV Header Definition From Data" to be ignored instead using this value.
   */
  public final String getCsvHeaderDefinition() {
    return properties.get(CSV_HEADER_DEFINITION_PROPERTY);
  }

  /**
   * This property only applies to CSV content type. Comma separated string defining the column names expected in the CSV data. EX: "fname,lname,zip,address". The elements present in this string should be in the same order as the underlying data. Setting this property will cause the value of "Get CSV Header Definition From Data" to be ignored instead using this value.
   */
  public final InferAvroSchema setCsvHeaderDefinition(final String csvHeaderDefinition) {
    properties.put(CSV_HEADER_DEFINITION_PROPERTY, csvHeaderDefinition);
    return this;
  }

  /**
   * This property only applies to CSV content type. Comma separated string defining the column names expected in the CSV data. EX: "fname,lname,zip,address". The elements present in this string should be in the same order as the underlying data. Setting this property will cause the value of "Get CSV Header Definition From Data" to be ignored instead using this value.
   */
  public final InferAvroSchema removeCsvHeaderDefinition() {
    properties.remove(CSV_HEADER_DEFINITION_PROPERTY);
    return this;
  }

  /**
   * This property only applies to CSV content type. If "true" the processor will attempt to read the CSV header definition from the first line of the input data.
   */
  public final String getGetCsvHeaderDefinitionFromData() {
    return properties.get(GET_CSV_HEADER_DEFINITION_FROM_DATA_PROPERTY);
  }

  /**
   * This property only applies to CSV content type. If "true" the processor will attempt to read the CSV header definition from the first line of the input data.
   */
  public final InferAvroSchema setGetCsvHeaderDefinitionFromData(final String getCsvHeaderDefinitionFromData) {
    properties.put(GET_CSV_HEADER_DEFINITION_FROM_DATA_PROPERTY, getCsvHeaderDefinitionFromData);
    return this;
  }

  /**
   * This property only applies to CSV content type. If "true" the processor will attempt to read the CSV header definition from the first line of the input data.
   */
  public final InferAvroSchema removeGetCsvHeaderDefinitionFromData() {
    properties.remove(GET_CSV_HEADER_DEFINITION_FROM_DATA_PROPERTY);
    return this;
  }

  /**
   * This property only applies to CSV content type. Specifies the number of lines that should be skipped when reading the CSV data. Setting this value to 0 is equivalent to saying "the entire contents of the file should be read". If the property "Get CSV Header Definition From Data" is set then the first line of the CSV  file will be read in and treated as the CSV header definition. Since this will remove the header line from the data care should be taken to make sure the value of "CSV header Line Skip Count" is set to 0 to ensure no data is skipped.
   */
  public final String getCsvHeaderLineSkipCount() {
    return properties.get(CSV_HEADER_LINE_SKIP_COUNT_PROPERTY);
  }

  /**
   * This property only applies to CSV content type. Specifies the number of lines that should be skipped when reading the CSV data. Setting this value to 0 is equivalent to saying "the entire contents of the file should be read". If the property "Get CSV Header Definition From Data" is set then the first line of the CSV  file will be read in and treated as the CSV header definition. Since this will remove the header line from the data care should be taken to make sure the value of "CSV header Line Skip Count" is set to 0 to ensure no data is skipped.
   */
  public final InferAvroSchema setCsvHeaderLineSkipCount(final String csvHeaderLineSkipCount) {
    properties.put(CSV_HEADER_LINE_SKIP_COUNT_PROPERTY, csvHeaderLineSkipCount);
    return this;
  }

  /**
   * This property only applies to CSV content type. Specifies the number of lines that should be skipped when reading the CSV data. Setting this value to 0 is equivalent to saying "the entire contents of the file should be read". If the property "Get CSV Header Definition From Data" is set then the first line of the CSV  file will be read in and treated as the CSV header definition. Since this will remove the header line from the data care should be taken to make sure the value of "CSV header Line Skip Count" is set to 0 to ensure no data is skipped.
   */
  public final InferAvroSchema removeCsvHeaderLineSkipCount() {
    properties.remove(CSV_HEADER_LINE_SKIP_COUNT_PROPERTY);
    return this;
  }

  /**
   * Delimiter character for CSV records
   */
  public final String getCsvDelimiter() {
    return properties.get(CSV_DELIMITER_PROPERTY);
  }

  /**
   * Delimiter character for CSV records
   */
  public final InferAvroSchema setCsvDelimiter(final String csvDelimiter) {
    properties.put(CSV_DELIMITER_PROPERTY, csvDelimiter);
    return this;
  }

  /**
   * Delimiter character for CSV records
   */
  public final InferAvroSchema removeCsvDelimiter() {
    properties.remove(CSV_DELIMITER_PROPERTY);
    return this;
  }

  /**
   * This property only applies to CSV content type. String that represents an escape sequence in the CSV FlowFile content data.
   */
  public final String getCsvEscapeString() {
    return properties.get(CSV_ESCAPE_STRING_PROPERTY);
  }

  /**
   * This property only applies to CSV content type. String that represents an escape sequence in the CSV FlowFile content data.
   */
  public final InferAvroSchema setCsvEscapeString(final String csvEscapeString) {
    properties.put(CSV_ESCAPE_STRING_PROPERTY, csvEscapeString);
    return this;
  }

  /**
   * This property only applies to CSV content type. String that represents an escape sequence in the CSV FlowFile content data.
   */
  public final InferAvroSchema removeCsvEscapeString() {
    properties.remove(CSV_ESCAPE_STRING_PROPERTY);
    return this;
  }

  /**
   * This property only applies to CSV content type. String that represents a literal quote character in the CSV FlowFile content data.
   */
  public final String getCsvQuoteString() {
    return properties.get(CSV_QUOTE_STRING_PROPERTY);
  }

  /**
   * This property only applies to CSV content type. String that represents a literal quote character in the CSV FlowFile content data.
   */
  public final InferAvroSchema setCsvQuoteString(final String csvQuoteString) {
    properties.put(CSV_QUOTE_STRING_PROPERTY, csvQuoteString);
    return this;
  }

  /**
   * This property only applies to CSV content type. String that represents a literal quote character in the CSV FlowFile content data.
   */
  public final InferAvroSchema removeCsvQuoteString() {
    properties.remove(CSV_QUOTE_STRING_PROPERTY);
    return this;
  }

  /**
   * If true the Avro output will be formatted.
   */
  public final String getPrettyAvroOutput() {
    return properties.get(PRETTY_AVRO_OUTPUT_PROPERTY);
  }

  /**
   * If true the Avro output will be formatted.
   */
  public final InferAvroSchema setPrettyAvroOutput(final String prettyAvroOutput) {
    properties.put(PRETTY_AVRO_OUTPUT_PROPERTY, prettyAvroOutput);
    return this;
  }

  /**
   * If true the Avro output will be formatted.
   */
  public final InferAvroSchema removePrettyAvroOutput() {
    properties.remove(PRETTY_AVRO_OUTPUT_PROPERTY);
    return this;
  }

  /**
   * Value to be placed in the Avro record schema "name" field. The value must adhere to the Avro naming rules for fullname. If Expression Language is present then the evaluated value must adhere to the Avro naming rules.
   */
  public final String getAvroRecordName() {
    return properties.get(AVRO_RECORD_NAME_PROPERTY);
  }

  /**
   * Value to be placed in the Avro record schema "name" field. The value must adhere to the Avro naming rules for fullname. If Expression Language is present then the evaluated value must adhere to the Avro naming rules.
   */
  public final InferAvroSchema setAvroRecordName(final String avroRecordName) {
    properties.put(AVRO_RECORD_NAME_PROPERTY, avroRecordName);
    return this;
  }

  /**
   * Value to be placed in the Avro record schema "name" field. The value must adhere to the Avro naming rules for fullname. If Expression Language is present then the evaluated value must adhere to the Avro naming rules.
   */
  public final InferAvroSchema removeAvroRecordName() {
    properties.remove(AVRO_RECORD_NAME_PROPERTY);
    return this;
  }

  /**
   * This property only applies to JSON content type. The number of JSON records that should be examined to determine the Avro schema. The higher the value the better chance kite has of detecting the appropriate type. However the default value of 10 is almost always enough.
   */
  public final String getNumberOfRecordsToAnalyze() {
    return properties.get(NUMBER_OF_RECORDS_TO_ANALYZE_PROPERTY);
  }

  /**
   * This property only applies to JSON content type. The number of JSON records that should be examined to determine the Avro schema. The higher the value the better chance kite has of detecting the appropriate type. However the default value of 10 is almost always enough.
   */
  public final InferAvroSchema setNumberOfRecordsToAnalyze(final String numberOfRecordsToAnalyze) {
    properties.put(NUMBER_OF_RECORDS_TO_ANALYZE_PROPERTY, numberOfRecordsToAnalyze);
    return this;
  }

  /**
   * This property only applies to JSON content type. The number of JSON records that should be examined to determine the Avro schema. The higher the value the better chance kite has of detecting the appropriate type. However the default value of 10 is almost always enough.
   */
  public final InferAvroSchema removeNumberOfRecordsToAnalyze() {
    properties.remove(NUMBER_OF_RECORDS_TO_ANALYZE_PROPERTY);
    return this;
  }

  /**
   * Character encoding of CSV data.
   */
  public final String getCharset() {
    return properties.get(CHARSET_PROPERTY);
  }

  /**
   * Character encoding of CSV data.
   */
  public final InferAvroSchema setCharset(final String charset) {
    properties.put(CHARSET_PROPERTY, charset);
    return this;
  }

  /**
   * Character encoding of CSV data.
   */
  public final InferAvroSchema removeCharset() {
    properties.remove(CHARSET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final InferAvroSchema setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final InferAvroSchema removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<InferAvroSchema, InferAvroSchema> configurator) {
    return configurator.apply(new InferAvroSchema()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = InferAvroSchema.class) final Closure<InferAvroSchema> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.kite.InferAvroSchema> code = closure.rehydrate(c, com.tibtech.nifi.processors.kite.InferAvroSchema.class, com.tibtech.nifi.processors.kite.InferAvroSchema.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
