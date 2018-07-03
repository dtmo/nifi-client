package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PartitionRecord {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.PartitionRecord";

  /**
   * Specifies the Controller Service to use for reading incoming data
   */
  public static final String RECORD_READER_PROPERTY = "record-reader";

  /**
   * Specifies the Controller Service to use for writing out the records
   */
  public static final String RECORD_WRITER_PROPERTY = "record-writer";

  private final Map<String, String> properties;

  public PartitionRecord() {
    this.properties = new HashMap<>();
  }

  public PartitionRecord(final Map<String, String> properties) {
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
  public final PartitionRecord setRecordReader(final String recordReader) {
    properties.put(RECORD_READER_PROPERTY, recordReader);
    return this;
  }

  /**
   * Specifies the Controller Service to use for reading incoming data
   */
  public final PartitionRecord removeRecordReader() {
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
  public final PartitionRecord setRecordWriter(final String recordWriter) {
    properties.put(RECORD_WRITER_PROPERTY, recordWriter);
    return this;
  }

  /**
   * Specifies the Controller Service to use for writing out the records
   */
  public final PartitionRecord removeRecordWriter() {
    properties.remove(RECORD_WRITER_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PartitionRecord setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PartitionRecord removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<PartitionRecord, PartitionRecord> configurator) {
    return configurator.apply(new PartitionRecord()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PartitionRecord.class) final Closure<PartitionRecord> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.PartitionRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.PartitionRecord.class, com.tibtech.nifi.processors.standard.PartitionRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PartitionRecord, PartitionRecord> configurator) {
    return configurator.apply(new PartitionRecord(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PartitionRecord.class) final Closure<PartitionRecord> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.PartitionRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.PartitionRecord.class, com.tibtech.nifi.processors.standard.PartitionRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
