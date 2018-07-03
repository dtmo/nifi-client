package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class QueryRecord {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.QueryRecord";

  /**
   * Specifies the Controller Service to use for parsing incoming data and determining the data's schema
   */
  public static final String RECORD_READER_PROPERTY = "record-reader";

  /**
   * Specifies the Controller Service to use for writing results to a FlowFile
   */
  public static final String RECORD_WRITER_PROPERTY = "record-writer";

  /**
   * When running the SQL statement against an incoming FlowFile, if the result has no data, this property specifies whether or not a FlowFile will be sent to the corresponding relationship
   */
  public static final String INCLUDE_ZERO_RECORD_FLOWFILES_PROPERTY = "include-zero-record-flowfiles";

  /**
   * Parsing the SQL query and deriving the FlowFile's schema is relatively expensive. If this value is set to true, the Processor will cache these values so that the Processor is much more efficient and much faster. However, if this is done, then the schema that is derived for the first FlowFile processed must apply to all FlowFiles. If all FlowFiles will not have the exact same schema, or if the SQL SELECT statement uses the Expression Language, this value should be set to false.
   */
  public static final String CACHE_SCHEMA_PROPERTY = "cache-schema";

  private final Map<String, String> properties;

  public QueryRecord() {
    this.properties = new HashMap<>();
  }

  public QueryRecord(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Specifies the Controller Service to use for parsing incoming data and determining the data's schema
   */
  public final String getRecordReader() {
    return properties.get(RECORD_READER_PROPERTY);
  }

  /**
   * Specifies the Controller Service to use for parsing incoming data and determining the data's schema
   */
  public final QueryRecord setRecordReader(final String recordReader) {
    properties.put(RECORD_READER_PROPERTY, recordReader);
    return this;
  }

  /**
   * Specifies the Controller Service to use for parsing incoming data and determining the data's schema
   */
  public final QueryRecord removeRecordReader() {
    properties.remove(RECORD_READER_PROPERTY);
    return this;
  }

  /**
   * Specifies the Controller Service to use for writing results to a FlowFile
   */
  public final String getRecordWriter() {
    return properties.get(RECORD_WRITER_PROPERTY);
  }

  /**
   * Specifies the Controller Service to use for writing results to a FlowFile
   */
  public final QueryRecord setRecordWriter(final String recordWriter) {
    properties.put(RECORD_WRITER_PROPERTY, recordWriter);
    return this;
  }

  /**
   * Specifies the Controller Service to use for writing results to a FlowFile
   */
  public final QueryRecord removeRecordWriter() {
    properties.remove(RECORD_WRITER_PROPERTY);
    return this;
  }

  /**
   * When running the SQL statement against an incoming FlowFile, if the result has no data, this property specifies whether or not a FlowFile will be sent to the corresponding relationship
   */
  public final String getIncludeZeroRecordFlowfiles() {
    return properties.get(INCLUDE_ZERO_RECORD_FLOWFILES_PROPERTY);
  }

  /**
   * When running the SQL statement against an incoming FlowFile, if the result has no data, this property specifies whether or not a FlowFile will be sent to the corresponding relationship
   */
  public final QueryRecord setIncludeZeroRecordFlowfiles(final String includeZeroRecordFlowfiles) {
    properties.put(INCLUDE_ZERO_RECORD_FLOWFILES_PROPERTY, includeZeroRecordFlowfiles);
    return this;
  }

  /**
   * When running the SQL statement against an incoming FlowFile, if the result has no data, this property specifies whether or not a FlowFile will be sent to the corresponding relationship
   */
  public final QueryRecord removeIncludeZeroRecordFlowfiles() {
    properties.remove(INCLUDE_ZERO_RECORD_FLOWFILES_PROPERTY);
    return this;
  }

  /**
   * Parsing the SQL query and deriving the FlowFile's schema is relatively expensive. If this value is set to true, the Processor will cache these values so that the Processor is much more efficient and much faster. However, if this is done, then the schema that is derived for the first FlowFile processed must apply to all FlowFiles. If all FlowFiles will not have the exact same schema, or if the SQL SELECT statement uses the Expression Language, this value should be set to false.
   */
  public final String getCacheSchema() {
    return properties.get(CACHE_SCHEMA_PROPERTY);
  }

  /**
   * Parsing the SQL query and deriving the FlowFile's schema is relatively expensive. If this value is set to true, the Processor will cache these values so that the Processor is much more efficient and much faster. However, if this is done, then the schema that is derived for the first FlowFile processed must apply to all FlowFiles. If all FlowFiles will not have the exact same schema, or if the SQL SELECT statement uses the Expression Language, this value should be set to false.
   */
  public final QueryRecord setCacheSchema(final String cacheSchema) {
    properties.put(CACHE_SCHEMA_PROPERTY, cacheSchema);
    return this;
  }

  /**
   * Parsing the SQL query and deriving the FlowFile's schema is relatively expensive. If this value is set to true, the Processor will cache these values so that the Processor is much more efficient and much faster. However, if this is done, then the schema that is derived for the first FlowFile processed must apply to all FlowFiles. If all FlowFiles will not have the exact same schema, or if the SQL SELECT statement uses the Expression Language, this value should be set to false.
   */
  public final QueryRecord removeCacheSchema() {
    properties.remove(CACHE_SCHEMA_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final QueryRecord setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final QueryRecord removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<QueryRecord, QueryRecord> configurator) {
    return configurator.apply(new QueryRecord()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = QueryRecord.class) final Closure<QueryRecord> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.QueryRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.QueryRecord.class, com.tibtech.nifi.processors.standard.QueryRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<QueryRecord, QueryRecord> configurator) {
    return configurator.apply(new QueryRecord(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = QueryRecord.class) final Closure<QueryRecord> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.QueryRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.QueryRecord.class, com.tibtech.nifi.processors.standard.QueryRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
