package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class SplitRecord {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.SplitRecord";

  /**
   * Specifies the Controller Service to use for reading incoming data
   */
  public static final String RECORD_READER_PROPERTY = "Record Reader";

  /**
   * Specifies the Controller Service to use for writing out the records
   */
  public static final String RECORD_WRITER_PROPERTY = "Record Writer";

  /**
   * Specifies how many records should be written to each 'split' or 'segment' FlowFile
   */
  public static final String RECORDS_PER_SPLIT_PROPERTY = "Records Per Split";

  private final Map<String, String> properties;

  public SplitRecord() {
    this.properties = new HashMap<>();
  }

  public SplitRecord(final Map<String, String> properties) {
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
  public final SplitRecord setRecordReader(final String recordReader) {
    properties.put(RECORD_READER_PROPERTY, recordReader);
    return this;
  }

  /**
   * Specifies the Controller Service to use for reading incoming data
   */
  public final SplitRecord removeRecordReader() {
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
  public final SplitRecord setRecordWriter(final String recordWriter) {
    properties.put(RECORD_WRITER_PROPERTY, recordWriter);
    return this;
  }

  /**
   * Specifies the Controller Service to use for writing out the records
   */
  public final SplitRecord removeRecordWriter() {
    properties.remove(RECORD_WRITER_PROPERTY);
    return this;
  }

  /**
   * Specifies how many records should be written to each 'split' or 'segment' FlowFile
   */
  public final String getRecordsPerSplit() {
    return properties.get(RECORDS_PER_SPLIT_PROPERTY);
  }

  /**
   * Specifies how many records should be written to each 'split' or 'segment' FlowFile
   */
  public final SplitRecord setRecordsPerSplit(final String recordsPerSplit) {
    properties.put(RECORDS_PER_SPLIT_PROPERTY, recordsPerSplit);
    return this;
  }

  /**
   * Specifies how many records should be written to each 'split' or 'segment' FlowFile
   */
  public final SplitRecord removeRecordsPerSplit() {
    properties.remove(RECORDS_PER_SPLIT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final SplitRecord setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final SplitRecord removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<SplitRecord, SplitRecord> configurator) {
    return configurator.apply(new SplitRecord()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SplitRecord.class) final Closure<SplitRecord> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.SplitRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.SplitRecord.class, com.tibtech.nifi.processors.standard.SplitRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<SplitRecord, SplitRecord> configurator) {
    return configurator.apply(new SplitRecord(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = SplitRecord.class) final Closure<SplitRecord> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.SplitRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.SplitRecord.class, com.tibtech.nifi.processors.standard.SplitRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
