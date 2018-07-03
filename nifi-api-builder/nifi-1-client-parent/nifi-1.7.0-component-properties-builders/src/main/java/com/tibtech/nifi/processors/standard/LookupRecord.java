package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class LookupRecord {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.LookupRecord";

  /**
   * Specifies the Controller Service to use for reading incoming data
   */
  public static final String RECORD_READER_PROPERTY = "record-reader";

  /**
   * Specifies the Controller Service to use for writing out the records
   */
  public static final String RECORD_WRITER_PROPERTY = "record-writer";

  /**
   * The Lookup Service to use in order to lookup a value in each Record
   */
  public static final String LOOKUP_SERVICE_PROPERTY = "lookup-service";

  /**
   * A RecordPath that points to the field whose value should be updated with whatever value is returned from the Lookup Service. If not specified, the value that is returned from the Lookup Service will be ignored, except for determining whether the FlowFile should be routed to the 'matched' or 'unmatched' Relationship.
   */
  public static final String RESULT_RECORD_PATH_PROPERTY = "result-record-path";

  /**
   * Specifies how to route records after a Lookup has completed
   */
  public static final String ROUTING_STRATEGY_PROPERTY = "routing-strategy";

  /**
   * When a result is obtained that contains a Record, this property determines whether the Record itself is inserted at the configured path or if the contents of the Record (i.e., the sub-fields) will be inserted at the configured path.
   */
  public static final String RESULT_CONTENTS_PROPERTY = "result-contents";

  private final Map<String, String> properties;

  public LookupRecord() {
    this.properties = new HashMap<>();
  }

  public LookupRecord(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Specifies the Controller Service to use for reading incoming data
   */
  public final String getRecordReader() {
    return properties.get(RECORD_READER_PROPERTY);
  }

  /**
   * Specifies the Controller Service to use for reading incoming data
   */
  public final LookupRecord setRecordReader(final String recordReader) {
    properties.put(RECORD_READER_PROPERTY, recordReader);
    return this;
  }

  /**
   * Specifies the Controller Service to use for reading incoming data
   */
  public final LookupRecord removeRecordReader() {
    properties.remove(RECORD_READER_PROPERTY);
    return this;
  }

  /**
   * Specifies the Controller Service to use for writing out the records
   */
  public final String getRecordWriter() {
    return properties.get(RECORD_WRITER_PROPERTY);
  }

  /**
   * Specifies the Controller Service to use for writing out the records
   */
  public final LookupRecord setRecordWriter(final String recordWriter) {
    properties.put(RECORD_WRITER_PROPERTY, recordWriter);
    return this;
  }

  /**
   * Specifies the Controller Service to use for writing out the records
   */
  public final LookupRecord removeRecordWriter() {
    properties.remove(RECORD_WRITER_PROPERTY);
    return this;
  }

  /**
   * The Lookup Service to use in order to lookup a value in each Record
   */
  public final String getLookupService() {
    return properties.get(LOOKUP_SERVICE_PROPERTY);
  }

  /**
   * The Lookup Service to use in order to lookup a value in each Record
   */
  public final LookupRecord setLookupService(final String lookupService) {
    properties.put(LOOKUP_SERVICE_PROPERTY, lookupService);
    return this;
  }

  /**
   * The Lookup Service to use in order to lookup a value in each Record
   */
  public final LookupRecord removeLookupService() {
    properties.remove(LOOKUP_SERVICE_PROPERTY);
    return this;
  }

  /**
   * A RecordPath that points to the field whose value should be updated with whatever value is returned from the Lookup Service. If not specified, the value that is returned from the Lookup Service will be ignored, except for determining whether the FlowFile should be routed to the 'matched' or 'unmatched' Relationship.
   */
  public final String getResultRecordPath() {
    return properties.get(RESULT_RECORD_PATH_PROPERTY);
  }

  /**
   * A RecordPath that points to the field whose value should be updated with whatever value is returned from the Lookup Service. If not specified, the value that is returned from the Lookup Service will be ignored, except for determining whether the FlowFile should be routed to the 'matched' or 'unmatched' Relationship.
   */
  public final LookupRecord setResultRecordPath(final String resultRecordPath) {
    properties.put(RESULT_RECORD_PATH_PROPERTY, resultRecordPath);
    return this;
  }

  /**
   * A RecordPath that points to the field whose value should be updated with whatever value is returned from the Lookup Service. If not specified, the value that is returned from the Lookup Service will be ignored, except for determining whether the FlowFile should be routed to the 'matched' or 'unmatched' Relationship.
   */
  public final LookupRecord removeResultRecordPath() {
    properties.remove(RESULT_RECORD_PATH_PROPERTY);
    return this;
  }

  /**
   * Specifies how to route records after a Lookup has completed
   */
  public final String getRoutingStrategy() {
    return properties.get(ROUTING_STRATEGY_PROPERTY);
  }

  /**
   * Specifies how to route records after a Lookup has completed
   */
  public final LookupRecord setRoutingStrategy(final String routingStrategy) {
    properties.put(ROUTING_STRATEGY_PROPERTY, routingStrategy);
    return this;
  }

  /**
   * Specifies how to route records after a Lookup has completed
   */
  public final LookupRecord removeRoutingStrategy() {
    properties.remove(ROUTING_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * When a result is obtained that contains a Record, this property determines whether the Record itself is inserted at the configured path or if the contents of the Record (i.e., the sub-fields) will be inserted at the configured path.
   */
  public final String getResultContents() {
    return properties.get(RESULT_CONTENTS_PROPERTY);
  }

  /**
   * When a result is obtained that contains a Record, this property determines whether the Record itself is inserted at the configured path or if the contents of the Record (i.e., the sub-fields) will be inserted at the configured path.
   */
  public final LookupRecord setResultContents(final String resultContents) {
    properties.put(RESULT_CONTENTS_PROPERTY, resultContents);
    return this;
  }

  /**
   * When a result is obtained that contains a Record, this property determines whether the Record itself is inserted at the configured path or if the contents of the Record (i.e., the sub-fields) will be inserted at the configured path.
   */
  public final LookupRecord removeResultContents() {
    properties.remove(RESULT_CONTENTS_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final LookupRecord setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final LookupRecord removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<LookupRecord, LookupRecord> configurator) {
    return configurator.apply(new LookupRecord()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = LookupRecord.class) final Closure<LookupRecord> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.LookupRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.LookupRecord.class, com.tibtech.nifi.processors.standard.LookupRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<LookupRecord, LookupRecord> configurator) {
    return configurator.apply(new LookupRecord(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = LookupRecord.class) final Closure<LookupRecord> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.LookupRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.LookupRecord.class, com.tibtech.nifi.processors.standard.LookupRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
