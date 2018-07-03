package com.tibtech.nifi.processors.kite;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ConvertCSVToAvro {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.kite.ConvertCSVToAvro";

  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration.
   */
  public static final String HADOOP_CONFIGURATION_FILES_PROPERTY = "Hadoop configuration files";

  /**
   * Outgoing Avro schema for each record created from a CSV row
   */
  public static final String RECORD_SCHEMA_PROPERTY = "Record schema";

  /**
   * Character set for CSV files
   */
  public static final String CSV_CHARSET_PROPERTY = "CSV charset";

  /**
   * Delimiter character for CSV records
   */
  public static final String CSV_DELIMITER_PROPERTY = "CSV delimiter";

  /**
   * Quote character for CSV values
   */
  public static final String CSV_QUOTE_CHARACTER_PROPERTY = "CSV quote character";

  /**
   * Escape character for CSV values
   */
  public static final String CSV_ESCAPE_CHARACTER_PROPERTY = "CSV escape character";

  /**
   * Whether to use the first line as a header
   */
  public static final String USE_CSV_HEADER_LINE_PROPERTY = "Use CSV header line";

  /**
   * Number of lines to skip before reading header or data
   */
  public static final String LINES_TO_SKIP_PROPERTY = "Lines to skip";

  /**
   * Compression type to use when writting Avro files. Default is Snappy.
   */
  public static final String KITE_COMPRESSION_TYPE_PROPERTY = "kite-compression-type";

  private final Map<String, String> properties;

  public ConvertCSVToAvro() {
    this.properties = new HashMap<>();
  }

  public ConvertCSVToAvro(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration.
   */
  public final String getHadoopConfigurationFiles() {
    return properties.get(HADOOP_CONFIGURATION_FILES_PROPERTY);
  }

  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration.
   */
  public final ConvertCSVToAvro setHadoopConfigurationFiles(final String hadoopConfigurationFiles) {
    properties.put(HADOOP_CONFIGURATION_FILES_PROPERTY, hadoopConfigurationFiles);
    return this;
  }

  /**
   * A file or comma separated list of files which contains the Hadoop file system configuration. Without this, Hadoop will search the classpath for a 'core-site.xml' and 'hdfs-site.xml' file or will revert to a default configuration.
   */
  public final ConvertCSVToAvro removeHadoopConfigurationFiles() {
    properties.remove(HADOOP_CONFIGURATION_FILES_PROPERTY);
    return this;
  }

  /**
   * Outgoing Avro schema for each record created from a CSV row
   */
  public final String getRecordSchema() {
    return properties.get(RECORD_SCHEMA_PROPERTY);
  }

  /**
   * Outgoing Avro schema for each record created from a CSV row
   */
  public final ConvertCSVToAvro setRecordSchema(final String recordSchema) {
    properties.put(RECORD_SCHEMA_PROPERTY, recordSchema);
    return this;
  }

  /**
   * Outgoing Avro schema for each record created from a CSV row
   */
  public final ConvertCSVToAvro removeRecordSchema() {
    properties.remove(RECORD_SCHEMA_PROPERTY);
    return this;
  }

  /**
   * Character set for CSV files
   */
  public final String getCsvCharset() {
    return properties.get(CSV_CHARSET_PROPERTY);
  }

  /**
   * Character set for CSV files
   */
  public final ConvertCSVToAvro setCsvCharset(final String csvCharset) {
    properties.put(CSV_CHARSET_PROPERTY, csvCharset);
    return this;
  }

  /**
   * Character set for CSV files
   */
  public final ConvertCSVToAvro removeCsvCharset() {
    properties.remove(CSV_CHARSET_PROPERTY);
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
  public final ConvertCSVToAvro setCsvDelimiter(final String csvDelimiter) {
    properties.put(CSV_DELIMITER_PROPERTY, csvDelimiter);
    return this;
  }

  /**
   * Delimiter character for CSV records
   */
  public final ConvertCSVToAvro removeCsvDelimiter() {
    properties.remove(CSV_DELIMITER_PROPERTY);
    return this;
  }

  /**
   * Quote character for CSV values
   */
  public final String getCsvQuoteCharacter() {
    return properties.get(CSV_QUOTE_CHARACTER_PROPERTY);
  }

  /**
   * Quote character for CSV values
   */
  public final ConvertCSVToAvro setCsvQuoteCharacter(final String csvQuoteCharacter) {
    properties.put(CSV_QUOTE_CHARACTER_PROPERTY, csvQuoteCharacter);
    return this;
  }

  /**
   * Quote character for CSV values
   */
  public final ConvertCSVToAvro removeCsvQuoteCharacter() {
    properties.remove(CSV_QUOTE_CHARACTER_PROPERTY);
    return this;
  }

  /**
   * Escape character for CSV values
   */
  public final String getCsvEscapeCharacter() {
    return properties.get(CSV_ESCAPE_CHARACTER_PROPERTY);
  }

  /**
   * Escape character for CSV values
   */
  public final ConvertCSVToAvro setCsvEscapeCharacter(final String csvEscapeCharacter) {
    properties.put(CSV_ESCAPE_CHARACTER_PROPERTY, csvEscapeCharacter);
    return this;
  }

  /**
   * Escape character for CSV values
   */
  public final ConvertCSVToAvro removeCsvEscapeCharacter() {
    properties.remove(CSV_ESCAPE_CHARACTER_PROPERTY);
    return this;
  }

  /**
   * Whether to use the first line as a header
   */
  public final String getUseCsvHeaderLine() {
    return properties.get(USE_CSV_HEADER_LINE_PROPERTY);
  }

  /**
   * Whether to use the first line as a header
   */
  public final ConvertCSVToAvro setUseCsvHeaderLine(final String useCsvHeaderLine) {
    properties.put(USE_CSV_HEADER_LINE_PROPERTY, useCsvHeaderLine);
    return this;
  }

  /**
   * Whether to use the first line as a header
   */
  public final ConvertCSVToAvro removeUseCsvHeaderLine() {
    properties.remove(USE_CSV_HEADER_LINE_PROPERTY);
    return this;
  }

  /**
   * Number of lines to skip before reading header or data
   */
  public final String getLinesToSkip() {
    return properties.get(LINES_TO_SKIP_PROPERTY);
  }

  /**
   * Number of lines to skip before reading header or data
   */
  public final ConvertCSVToAvro setLinesToSkip(final String linesToSkip) {
    properties.put(LINES_TO_SKIP_PROPERTY, linesToSkip);
    return this;
  }

  /**
   * Number of lines to skip before reading header or data
   */
  public final ConvertCSVToAvro removeLinesToSkip() {
    properties.remove(LINES_TO_SKIP_PROPERTY);
    return this;
  }

  /**
   * Compression type to use when writting Avro files. Default is Snappy.
   */
  public final String getKiteCompressionType() {
    return properties.get(KITE_COMPRESSION_TYPE_PROPERTY);
  }

  /**
   * Compression type to use when writting Avro files. Default is Snappy.
   */
  public final ConvertCSVToAvro setKiteCompressionType(final String kiteCompressionType) {
    properties.put(KITE_COMPRESSION_TYPE_PROPERTY, kiteCompressionType);
    return this;
  }

  /**
   * Compression type to use when writting Avro files. Default is Snappy.
   */
  public final ConvertCSVToAvro removeKiteCompressionType() {
    properties.remove(KITE_COMPRESSION_TYPE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ConvertCSVToAvro setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ConvertCSVToAvro removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ConvertCSVToAvro, ConvertCSVToAvro> configurator) {
    return configurator.apply(new ConvertCSVToAvro()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConvertCSVToAvro.class) final Closure<ConvertCSVToAvro> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.kite.ConvertCSVToAvro> code = closure.rehydrate(c, com.tibtech.nifi.processors.kite.ConvertCSVToAvro.class, com.tibtech.nifi.processors.kite.ConvertCSVToAvro.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ConvertCSVToAvro, ConvertCSVToAvro> configurator) {
    return configurator.apply(new ConvertCSVToAvro(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ConvertCSVToAvro.class) final Closure<ConvertCSVToAvro> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.kite.ConvertCSVToAvro> code = closure.rehydrate(c, com.tibtech.nifi.processors.kite.ConvertCSVToAvro.class, com.tibtech.nifi.processors.kite.ConvertCSVToAvro.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
