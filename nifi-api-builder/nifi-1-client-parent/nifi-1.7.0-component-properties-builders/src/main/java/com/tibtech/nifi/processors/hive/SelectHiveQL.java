package com.tibtech.nifi.processors.hive;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class SelectHiveQL {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.hive.SelectHiveQL";

  /**
   * The Hive Controller Service that is used to obtain connection(s) to the Hive database
   */
  public static final String HIVE_DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY = "Hive Database Connection Pooling Service";

  /**
   * HiveQL pre-query to execute. Semicolon-delimited list of queries. Example: 'set tez.queue.name=queue1; set hive.exec.orc.split.strategy=ETL; set hive.exec.reducers.bytes.per.reducer=1073741824'. Note, the results/outputs of these queries will be suppressed if successfully executed.
   */
  public static final String HIVE_PRE_QUERY_PROPERTY = "hive-pre-query";

  /**
   * HiveQL SELECT query to execute. If this is not set, the query is assumed to be in the content of an incoming FlowFile.
   */
  public static final String HIVE_QUERY_PROPERTY = "hive-query";

  /**
   * HiveQL post-query to execute. Semicolon-delimited list of queries. Note, the results/outputs of these queries will be suppressed if successfully executed.
   */
  public static final String HIVE_POST_QUERY_PROPERTY = "hive-post-query";

  /**
   * The number of result rows to be fetched from the result set at a time. This is a hint to the driver and may not be honored and/or exact. If the value specified is zero, then the hint is ignored.
   */
  public static final String HIVE_FETCH_SIZE_PROPERTY = "hive-fetch-size";

  /**
   * The maximum number of result rows that will be included in a single FlowFile. This will allow you to break up very large result sets into multiple FlowFiles. If the value specified is zero, then all rows are returned in a single FlowFile.
   */
  public static final String HIVE_MAX_ROWS_PROPERTY = "hive-max-rows";

  /**
   * The maximum number of fragments. If the value specified is zero, then all fragments are returned. This prevents OutOfMemoryError when this processor ingests huge table.
   */
  public static final String HIVE_MAX_FRAGS_PROPERTY = "hive-max-frags";

  /**
   * How to represent the records coming from Hive (Avro, CSV, e.g.)
   */
  public static final String HIVE_OUTPUT_FORMAT_PROPERTY = "hive-output-format";

  /**
   * Whether to change non-Avro-compatible characters in column names to Avro-compatible characters. For example, colons and periods will be changed to underscores in order to build a valid Avro record.
   */
  public static final String HIVE_NORMALIZE_AVRO_PROPERTY = "hive-normalize-avro";

  /**
   * Include Header in Output
   */
  public static final String CSV_HEADER_PROPERTY = "csv-header";

  /**
   * Comma separated list of header fields
   */
  public static final String CSV_ALT_HEADER_PROPERTY = "csv-alt-header";

  /**
   * CSV Delimiter used to separate fields
   */
  public static final String CSV_DELIMITER_PROPERTY = "csv-delimiter";

  /**
   * Whether to force quoting of CSV fields. Note that this might conflict with the setting for CSV Escape.
   */
  public static final String CSV_QUOTE_PROPERTY = "csv-quote";

  /**
   * Whether to escape CSV strings in output. Note that this might conflict with the setting for CSV Quote.
   */
  public static final String CSV_ESCAPE_PROPERTY = "csv-escape";

  /**
   * Specifies the character set of the record data.
   */
  public static final String HIVE_CHARSET_PROPERTY = "hive-charset";

  private final Map<String, String> properties;

  public SelectHiveQL() {
    this.properties = new HashMap<>();
  }

  public SelectHiveQL(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The Hive Controller Service that is used to obtain connection(s) to the Hive database
   */
  public final String getHiveDatabaseConnectionPoolingService() {
    return properties.get(HIVE_DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY);
  }

  /**
   * The Hive Controller Service that is used to obtain connection(s) to the Hive database
   */
  public final SelectHiveQL setHiveDatabaseConnectionPoolingService(
      final String hiveDatabaseConnectionPoolingService) {
    properties.put(HIVE_DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY, hiveDatabaseConnectionPoolingService);
    return this;
  }

  /**
   * The Hive Controller Service that is used to obtain connection(s) to the Hive database
   */
  public final SelectHiveQL removeHiveDatabaseConnectionPoolingService() {
    properties.remove(HIVE_DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY);
    return this;
  }

  /**
   * HiveQL pre-query to execute. Semicolon-delimited list of queries. Example: 'set tez.queue.name=queue1; set hive.exec.orc.split.strategy=ETL; set hive.exec.reducers.bytes.per.reducer=1073741824'. Note, the results/outputs of these queries will be suppressed if successfully executed.
   */
  public final String getHivePreQuery() {
    return properties.get(HIVE_PRE_QUERY_PROPERTY);
  }

  /**
   * HiveQL pre-query to execute. Semicolon-delimited list of queries. Example: 'set tez.queue.name=queue1; set hive.exec.orc.split.strategy=ETL; set hive.exec.reducers.bytes.per.reducer=1073741824'. Note, the results/outputs of these queries will be suppressed if successfully executed.
   */
  public final SelectHiveQL setHivePreQuery(final String hivePreQuery) {
    properties.put(HIVE_PRE_QUERY_PROPERTY, hivePreQuery);
    return this;
  }

  /**
   * HiveQL pre-query to execute. Semicolon-delimited list of queries. Example: 'set tez.queue.name=queue1; set hive.exec.orc.split.strategy=ETL; set hive.exec.reducers.bytes.per.reducer=1073741824'. Note, the results/outputs of these queries will be suppressed if successfully executed.
   */
  public final SelectHiveQL removeHivePreQuery() {
    properties.remove(HIVE_PRE_QUERY_PROPERTY);
    return this;
  }

  /**
   * HiveQL SELECT query to execute. If this is not set, the query is assumed to be in the content of an incoming FlowFile.
   */
  public final String getHiveQuery() {
    return properties.get(HIVE_QUERY_PROPERTY);
  }

  /**
   * HiveQL SELECT query to execute. If this is not set, the query is assumed to be in the content of an incoming FlowFile.
   */
  public final SelectHiveQL setHiveQuery(final String hiveQuery) {
    properties.put(HIVE_QUERY_PROPERTY, hiveQuery);
    return this;
  }

  /**
   * HiveQL SELECT query to execute. If this is not set, the query is assumed to be in the content of an incoming FlowFile.
   */
  public final SelectHiveQL removeHiveQuery() {
    properties.remove(HIVE_QUERY_PROPERTY);
    return this;
  }

  /**
   * HiveQL post-query to execute. Semicolon-delimited list of queries. Note, the results/outputs of these queries will be suppressed if successfully executed.
   */
  public final String getHivePostQuery() {
    return properties.get(HIVE_POST_QUERY_PROPERTY);
  }

  /**
   * HiveQL post-query to execute. Semicolon-delimited list of queries. Note, the results/outputs of these queries will be suppressed if successfully executed.
   */
  public final SelectHiveQL setHivePostQuery(final String hivePostQuery) {
    properties.put(HIVE_POST_QUERY_PROPERTY, hivePostQuery);
    return this;
  }

  /**
   * HiveQL post-query to execute. Semicolon-delimited list of queries. Note, the results/outputs of these queries will be suppressed if successfully executed.
   */
  public final SelectHiveQL removeHivePostQuery() {
    properties.remove(HIVE_POST_QUERY_PROPERTY);
    return this;
  }

  /**
   * The number of result rows to be fetched from the result set at a time. This is a hint to the driver and may not be honored and/or exact. If the value specified is zero, then the hint is ignored.
   */
  public final String getHiveFetchSize() {
    return properties.get(HIVE_FETCH_SIZE_PROPERTY);
  }

  /**
   * The number of result rows to be fetched from the result set at a time. This is a hint to the driver and may not be honored and/or exact. If the value specified is zero, then the hint is ignored.
   */
  public final SelectHiveQL setHiveFetchSize(final String hiveFetchSize) {
    properties.put(HIVE_FETCH_SIZE_PROPERTY, hiveFetchSize);
    return this;
  }

  /**
   * The number of result rows to be fetched from the result set at a time. This is a hint to the driver and may not be honored and/or exact. If the value specified is zero, then the hint is ignored.
   */
  public final SelectHiveQL removeHiveFetchSize() {
    properties.remove(HIVE_FETCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * The maximum number of result rows that will be included in a single FlowFile. This will allow you to break up very large result sets into multiple FlowFiles. If the value specified is zero, then all rows are returned in a single FlowFile.
   */
  public final String getHiveMaxRows() {
    return properties.get(HIVE_MAX_ROWS_PROPERTY);
  }

  /**
   * The maximum number of result rows that will be included in a single FlowFile. This will allow you to break up very large result sets into multiple FlowFiles. If the value specified is zero, then all rows are returned in a single FlowFile.
   */
  public final SelectHiveQL setHiveMaxRows(final String hiveMaxRows) {
    properties.put(HIVE_MAX_ROWS_PROPERTY, hiveMaxRows);
    return this;
  }

  /**
   * The maximum number of result rows that will be included in a single FlowFile. This will allow you to break up very large result sets into multiple FlowFiles. If the value specified is zero, then all rows are returned in a single FlowFile.
   */
  public final SelectHiveQL removeHiveMaxRows() {
    properties.remove(HIVE_MAX_ROWS_PROPERTY);
    return this;
  }

  /**
   * The maximum number of fragments. If the value specified is zero, then all fragments are returned. This prevents OutOfMemoryError when this processor ingests huge table.
   */
  public final String getHiveMaxFrags() {
    return properties.get(HIVE_MAX_FRAGS_PROPERTY);
  }

  /**
   * The maximum number of fragments. If the value specified is zero, then all fragments are returned. This prevents OutOfMemoryError when this processor ingests huge table.
   */
  public final SelectHiveQL setHiveMaxFrags(final String hiveMaxFrags) {
    properties.put(HIVE_MAX_FRAGS_PROPERTY, hiveMaxFrags);
    return this;
  }

  /**
   * The maximum number of fragments. If the value specified is zero, then all fragments are returned. This prevents OutOfMemoryError when this processor ingests huge table.
   */
  public final SelectHiveQL removeHiveMaxFrags() {
    properties.remove(HIVE_MAX_FRAGS_PROPERTY);
    return this;
  }

  /**
   * How to represent the records coming from Hive (Avro, CSV, e.g.)
   */
  public final String getHiveOutputFormat() {
    return properties.get(HIVE_OUTPUT_FORMAT_PROPERTY);
  }

  /**
   * How to represent the records coming from Hive (Avro, CSV, e.g.)
   */
  public final SelectHiveQL setHiveOutputFormat(final String hiveOutputFormat) {
    properties.put(HIVE_OUTPUT_FORMAT_PROPERTY, hiveOutputFormat);
    return this;
  }

  /**
   * How to represent the records coming from Hive (Avro, CSV, e.g.)
   */
  public final SelectHiveQL removeHiveOutputFormat() {
    properties.remove(HIVE_OUTPUT_FORMAT_PROPERTY);
    return this;
  }

  /**
   * Whether to change non-Avro-compatible characters in column names to Avro-compatible characters. For example, colons and periods will be changed to underscores in order to build a valid Avro record.
   */
  public final String getHiveNormalizeAvro() {
    return properties.get(HIVE_NORMALIZE_AVRO_PROPERTY);
  }

  /**
   * Whether to change non-Avro-compatible characters in column names to Avro-compatible characters. For example, colons and periods will be changed to underscores in order to build a valid Avro record.
   */
  public final SelectHiveQL setHiveNormalizeAvro(final String hiveNormalizeAvro) {
    properties.put(HIVE_NORMALIZE_AVRO_PROPERTY, hiveNormalizeAvro);
    return this;
  }

  /**
   * Whether to change non-Avro-compatible characters in column names to Avro-compatible characters. For example, colons and periods will be changed to underscores in order to build a valid Avro record.
   */
  public final SelectHiveQL removeHiveNormalizeAvro() {
    properties.remove(HIVE_NORMALIZE_AVRO_PROPERTY);
    return this;
  }

  /**
   * Include Header in Output
   */
  public final String getCsvHeader() {
    return properties.get(CSV_HEADER_PROPERTY);
  }

  /**
   * Include Header in Output
   */
  public final SelectHiveQL setCsvHeader(final String csvHeader) {
    properties.put(CSV_HEADER_PROPERTY, csvHeader);
    return this;
  }

  /**
   * Include Header in Output
   */
  public final SelectHiveQL removeCsvHeader() {
    properties.remove(CSV_HEADER_PROPERTY);
    return this;
  }

  /**
   * Comma separated list of header fields
   */
  public final String getCsvAltHeader() {
    return properties.get(CSV_ALT_HEADER_PROPERTY);
  }

  /**
   * Comma separated list of header fields
   */
  public final SelectHiveQL setCsvAltHeader(final String csvAltHeader) {
    properties.put(CSV_ALT_HEADER_PROPERTY, csvAltHeader);
    return this;
  }

  /**
   * Comma separated list of header fields
   */
  public final SelectHiveQL removeCsvAltHeader() {
    properties.remove(CSV_ALT_HEADER_PROPERTY);
    return this;
  }

  /**
   * CSV Delimiter used to separate fields
   */
  public final String getCsvDelimiter() {
    return properties.get(CSV_DELIMITER_PROPERTY);
  }

  /**
   * CSV Delimiter used to separate fields
   */
  public final SelectHiveQL setCsvDelimiter(final String csvDelimiter) {
    properties.put(CSV_DELIMITER_PROPERTY, csvDelimiter);
    return this;
  }

  /**
   * CSV Delimiter used to separate fields
   */
  public final SelectHiveQL removeCsvDelimiter() {
    properties.remove(CSV_DELIMITER_PROPERTY);
    return this;
  }

  /**
   * Whether to force quoting of CSV fields. Note that this might conflict with the setting for CSV Escape.
   */
  public final String getCsvQuote() {
    return properties.get(CSV_QUOTE_PROPERTY);
  }

  /**
   * Whether to force quoting of CSV fields. Note that this might conflict with the setting for CSV Escape.
   */
  public final SelectHiveQL setCsvQuote(final String csvQuote) {
    properties.put(CSV_QUOTE_PROPERTY, csvQuote);
    return this;
  }

  /**
   * Whether to force quoting of CSV fields. Note that this might conflict with the setting for CSV Escape.
   */
  public final SelectHiveQL removeCsvQuote() {
    properties.remove(CSV_QUOTE_PROPERTY);
    return this;
  }

  /**
   * Whether to escape CSV strings in output. Note that this might conflict with the setting for CSV Quote.
   */
  public final String getCsvEscape() {
    return properties.get(CSV_ESCAPE_PROPERTY);
  }

  /**
   * Whether to escape CSV strings in output. Note that this might conflict with the setting for CSV Quote.
   */
  public final SelectHiveQL setCsvEscape(final String csvEscape) {
    properties.put(CSV_ESCAPE_PROPERTY, csvEscape);
    return this;
  }

  /**
   * Whether to escape CSV strings in output. Note that this might conflict with the setting for CSV Quote.
   */
  public final SelectHiveQL removeCsvEscape() {
    properties.remove(CSV_ESCAPE_PROPERTY);
    return this;
  }

  /**
   * Specifies the character set of the record data.
   */
  public final String getHiveCharset() {
    return properties.get(HIVE_CHARSET_PROPERTY);
  }

  /**
   * Specifies the character set of the record data.
   */
  public final SelectHiveQL setHiveCharset(final String hiveCharset) {
    properties.put(HIVE_CHARSET_PROPERTY, hiveCharset);
    return this;
  }

  /**
   * Specifies the character set of the record data.
   */
  public final SelectHiveQL removeHiveCharset() {
    properties.remove(HIVE_CHARSET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final SelectHiveQL setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final SelectHiveQL removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<SelectHiveQL, SelectHiveQL> configurator) {
    return configurator.apply(new SelectHiveQL()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SelectHiveQL.class) final Closure<SelectHiveQL> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.hive.SelectHiveQL> code = closure.rehydrate(c, com.tibtech.nifi.processors.hive.SelectHiveQL.class, com.tibtech.nifi.processors.hive.SelectHiveQL.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<SelectHiveQL, SelectHiveQL> configurator) {
    return configurator.apply(new SelectHiveQL(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SelectHiveQL.class) final Closure<SelectHiveQL> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.hive.SelectHiveQL> code = closure.rehydrate(c, com.tibtech.nifi.processors.hive.SelectHiveQL.class, com.tibtech.nifi.processors.hive.SelectHiveQL.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
