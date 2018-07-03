package com.tibtech.nifi.processors.poi;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ConvertExcelToCSVProcessor {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.poi.ConvertExcelToCSVProcessor";

  /**
   * Comma separated list of Excel document sheet names that should be extracted from the excel document. If this property is left blank then all of the sheets will be extracted from the Excel document. The list of names is case in-sensitive. Any sheets not specified in this value will be ignored.
   */
  public static final String EXTRACT_SHEETS_PROPERTY = "extract-sheets";

  /**
   * The row number of the first row to start processing.Use this to skip over rows of data at the top of your worksheet that are not part of the dataset.Empty rows of data anywhere in the spreadsheet will always be skipped, no matter what this value is set to.
   */
  public static final String EXCEL_EXTRACT_FIRST_ROW_PROPERTY = "excel-extract-first-row";

  /**
   * Comma delimited list of column numbers to skip. Use the columns number and not the letter designation. Use this to skip over columns anywhere in your worksheet that you don't want extracted as part of the record.
   */
  public static final String EXCEL_EXTRACT_COLUMN_TO_SKIP_PROPERTY = "excel-extract-column-to-skip";

  /**
   * Should the cell values be written to CSV using the formatting applied in Excel, or should they be printed as raw values.
   */
  public static final String EXCEL_FORMAT_VALUES_PROPERTY = "excel-format-values";

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

  private final Map<String, String> properties;

  public ConvertExcelToCSVProcessor() {
    this.properties = new HashMap<>();
  }

  public ConvertExcelToCSVProcessor(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Comma separated list of Excel document sheet names that should be extracted from the excel document. If this property is left blank then all of the sheets will be extracted from the Excel document. The list of names is case in-sensitive. Any sheets not specified in this value will be ignored.
   */
  public final String getExtractSheets() {
    return properties.get(EXTRACT_SHEETS_PROPERTY);
  }

  /**
   * Comma separated list of Excel document sheet names that should be extracted from the excel document. If this property is left blank then all of the sheets will be extracted from the Excel document. The list of names is case in-sensitive. Any sheets not specified in this value will be ignored.
   */
  public final ConvertExcelToCSVProcessor setExtractSheets(final String extractSheets) {
    properties.put(EXTRACT_SHEETS_PROPERTY, extractSheets);
    return this;
  }

  /**
   * Comma separated list of Excel document sheet names that should be extracted from the excel document. If this property is left blank then all of the sheets will be extracted from the Excel document. The list of names is case in-sensitive. Any sheets not specified in this value will be ignored.
   */
  public final ConvertExcelToCSVProcessor removeExtractSheets() {
    properties.remove(EXTRACT_SHEETS_PROPERTY);
    return this;
  }

  /**
   * The row number of the first row to start processing.Use this to skip over rows of data at the top of your worksheet that are not part of the dataset.Empty rows of data anywhere in the spreadsheet will always be skipped, no matter what this value is set to.
   */
  public final String getExcelExtractFirstRow() {
    return properties.get(EXCEL_EXTRACT_FIRST_ROW_PROPERTY);
  }

  /**
   * The row number of the first row to start processing.Use this to skip over rows of data at the top of your worksheet that are not part of the dataset.Empty rows of data anywhere in the spreadsheet will always be skipped, no matter what this value is set to.
   */
  public final ConvertExcelToCSVProcessor setExcelExtractFirstRow(
      final String excelExtractFirstRow) {
    properties.put(EXCEL_EXTRACT_FIRST_ROW_PROPERTY, excelExtractFirstRow);
    return this;
  }

  /**
   * The row number of the first row to start processing.Use this to skip over rows of data at the top of your worksheet that are not part of the dataset.Empty rows of data anywhere in the spreadsheet will always be skipped, no matter what this value is set to.
   */
  public final ConvertExcelToCSVProcessor removeExcelExtractFirstRow() {
    properties.remove(EXCEL_EXTRACT_FIRST_ROW_PROPERTY);
    return this;
  }

  /**
   * Comma delimited list of column numbers to skip. Use the columns number and not the letter designation. Use this to skip over columns anywhere in your worksheet that you don't want extracted as part of the record.
   */
  public final String getExcelExtractColumnToSkip() {
    return properties.get(EXCEL_EXTRACT_COLUMN_TO_SKIP_PROPERTY);
  }

  /**
   * Comma delimited list of column numbers to skip. Use the columns number and not the letter designation. Use this to skip over columns anywhere in your worksheet that you don't want extracted as part of the record.
   */
  public final ConvertExcelToCSVProcessor setExcelExtractColumnToSkip(
      final String excelExtractColumnToSkip) {
    properties.put(EXCEL_EXTRACT_COLUMN_TO_SKIP_PROPERTY, excelExtractColumnToSkip);
    return this;
  }

  /**
   * Comma delimited list of column numbers to skip. Use the columns number and not the letter designation. Use this to skip over columns anywhere in your worksheet that you don't want extracted as part of the record.
   */
  public final ConvertExcelToCSVProcessor removeExcelExtractColumnToSkip() {
    properties.remove(EXCEL_EXTRACT_COLUMN_TO_SKIP_PROPERTY);
    return this;
  }

  /**
   * Should the cell values be written to CSV using the formatting applied in Excel, or should they be printed as raw values.
   */
  public final String getExcelFormatValues() {
    return properties.get(EXCEL_FORMAT_VALUES_PROPERTY);
  }

  /**
   * Should the cell values be written to CSV using the formatting applied in Excel, or should they be printed as raw values.
   */
  public final ConvertExcelToCSVProcessor setExcelFormatValues(final String excelFormatValues) {
    properties.put(EXCEL_FORMAT_VALUES_PROPERTY, excelFormatValues);
    return this;
  }

  /**
   * Should the cell values be written to CSV using the formatting applied in Excel, or should they be printed as raw values.
   */
  public final ConvertExcelToCSVProcessor removeExcelFormatValues() {
    properties.remove(EXCEL_FORMAT_VALUES_PROPERTY);
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
  public final ConvertExcelToCSVProcessor setCsvFormat(final String csvFormat) {
    properties.put(CSV_FORMAT_PROPERTY, csvFormat);
    return this;
  }

  /**
   * Specifies which "format" the CSV data is in, or specifies if custom formatting should be used.
   */
  public final ConvertExcelToCSVProcessor removeCsvFormat() {
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
  public final ConvertExcelToCSVProcessor setValueSeparator(final String valueSeparator) {
    properties.put(VALUE_SEPARATOR_PROPERTY, valueSeparator);
    return this;
  }

  /**
   * The character that is used to separate values/fields in a CSV Record
   */
  public final ConvertExcelToCSVProcessor removeValueSeparator() {
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
  public final ConvertExcelToCSVProcessor setIncludeHeaderLine(final String includeHeaderLine) {
    properties.put(INCLUDE_HEADER_LINE_PROPERTY, includeHeaderLine);
    return this;
  }

  /**
   * Specifies whether or not the CSV column names should be written out as the first line.
   */
  public final ConvertExcelToCSVProcessor removeIncludeHeaderLine() {
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
  public final ConvertExcelToCSVProcessor setQuoteCharacter(final String quoteCharacter) {
    properties.put(QUOTE_CHARACTER_PROPERTY, quoteCharacter);
    return this;
  }

  /**
   * The character that is used to quote values so that escape characters do not have to be used
   */
  public final ConvertExcelToCSVProcessor removeQuoteCharacter() {
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
  public final ConvertExcelToCSVProcessor setEscapeCharacter(final String escapeCharacter) {
    properties.put(ESCAPE_CHARACTER_PROPERTY, escapeCharacter);
    return this;
  }

  /**
   * The character that is used to escape characters that would otherwise have a specific meaning to the CSV Parser.
   */
  public final ConvertExcelToCSVProcessor removeEscapeCharacter() {
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
  public final ConvertExcelToCSVProcessor setCommentMarker(final String commentMarker) {
    properties.put(COMMENT_MARKER_PROPERTY, commentMarker);
    return this;
  }

  /**
   * The character that is used to denote the start of a comment. Any line that begins with this comment will be ignored.
   */
  public final ConvertExcelToCSVProcessor removeCommentMarker() {
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
  public final ConvertExcelToCSVProcessor setNullString(final String nullString) {
    properties.put(NULL_STRING_PROPERTY, nullString);
    return this;
  }

  /**
   * Specifies a String that, if present as a value in the CSV, should be considered a null field instead of using the literal value.
   */
  public final ConvertExcelToCSVProcessor removeNullString() {
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
  public final ConvertExcelToCSVProcessor setTrimFields(final String trimFields) {
    properties.put(TRIM_FIELDS_PROPERTY, trimFields);
    return this;
  }

  /**
   * Whether or not white space should be removed from the beginning and end of fields
   */
  public final ConvertExcelToCSVProcessor removeTrimFields() {
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
  public final ConvertExcelToCSVProcessor setQuoteMode(final String quoteMode) {
    properties.put(QUOTE_MODE_PROPERTY, quoteMode);
    return this;
  }

  /**
   * Specifies how fields should be quoted when they are written
   */
  public final ConvertExcelToCSVProcessor removeQuoteMode() {
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
  public final ConvertExcelToCSVProcessor setRecordSeparator(final String recordSeparator) {
    properties.put(RECORD_SEPARATOR_PROPERTY, recordSeparator);
    return this;
  }

  /**
   * Specifies the characters to use in order to separate CSV Records
   */
  public final ConvertExcelToCSVProcessor removeRecordSeparator() {
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
  public final ConvertExcelToCSVProcessor setIncludeTrailingDelimiter(
      final String includeTrailingDelimiter) {
    properties.put(INCLUDE_TRAILING_DELIMITER_PROPERTY, includeTrailingDelimiter);
    return this;
  }

  /**
   * If true, a trailing delimiter will be added to each CSV Record that is written. If false, the trailing delimiter will be omitted.
   */
  public final ConvertExcelToCSVProcessor removeIncludeTrailingDelimiter() {
    properties.remove(INCLUDE_TRAILING_DELIMITER_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ConvertExcelToCSVProcessor setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final ConvertExcelToCSVProcessor removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ConvertExcelToCSVProcessor, ConvertExcelToCSVProcessor> configurator) {
    return configurator.apply(new ConvertExcelToCSVProcessor()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConvertExcelToCSVProcessor.class) final Closure<ConvertExcelToCSVProcessor> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.poi.ConvertExcelToCSVProcessor> code = closure.rehydrate(c, com.tibtech.nifi.processors.poi.ConvertExcelToCSVProcessor.class, com.tibtech.nifi.processors.poi.ConvertExcelToCSVProcessor.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ConvertExcelToCSVProcessor, ConvertExcelToCSVProcessor> configurator) {
    return configurator.apply(new ConvertExcelToCSVProcessor(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConvertExcelToCSVProcessor.class) final Closure<ConvertExcelToCSVProcessor> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.poi.ConvertExcelToCSVProcessor> code = closure.rehydrate(c, com.tibtech.nifi.processors.poi.ConvertExcelToCSVProcessor.class, com.tibtech.nifi.processors.poi.ConvertExcelToCSVProcessor.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
