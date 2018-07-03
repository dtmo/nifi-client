package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class UpdateRecord {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.UpdateRecord";

  /**
   * Specifies the Controller Service to use for reading incoming data
   */
  public static final String RECORD_READER_PROPERTY = "record-reader";

  /**
   * Specifies the Controller Service to use for writing out the records
   */
  public static final String RECORD_WRITER_PROPERTY = "record-writer";

  /**
   * Specifies how to interpret the configured replacement values
   */
  public static final String REPLACEMENT_VALUE_STRATEGY_PROPERTY = "replacement-value-strategy";

  private final Map<String, String> properties;

  public UpdateRecord() {
    this.properties = new HashMap<>();
  }

  public UpdateRecord(final Map<String, String> properties) {
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
  public final UpdateRecord setRecordReader(final String recordReader) {
    properties.put(RECORD_READER_PROPERTY, recordReader);
    return this;
  }

  /**
   * Specifies the Controller Service to use for reading incoming data
   */
  public final UpdateRecord removeRecordReader() {
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
  public final UpdateRecord setRecordWriter(final String recordWriter) {
    properties.put(RECORD_WRITER_PROPERTY, recordWriter);
    return this;
  }

  /**
   * Specifies the Controller Service to use for writing out the records
   */
  public final UpdateRecord removeRecordWriter() {
    properties.remove(RECORD_WRITER_PROPERTY);
    return this;
  }

  /**
   * Specifies how to interpret the configured replacement values
   */
  public final String getReplacementValueStrategy() {
    return properties.get(REPLACEMENT_VALUE_STRATEGY_PROPERTY);
  }

  /**
   * Specifies how to interpret the configured replacement values
   */
  public final UpdateRecord setReplacementValueStrategy(final String replacementValueStrategy) {
    properties.put(REPLACEMENT_VALUE_STRATEGY_PROPERTY, replacementValueStrategy);
    return this;
  }

  /**
   * Specifies how to interpret the configured replacement values
   */
  public final UpdateRecord removeReplacementValueStrategy() {
    properties.remove(REPLACEMENT_VALUE_STRATEGY_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final UpdateRecord setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final UpdateRecord removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<UpdateRecord, UpdateRecord> configurator) {
    return configurator.apply(new UpdateRecord()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = UpdateRecord.class) final Closure<UpdateRecord> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.UpdateRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.UpdateRecord.class, com.tibtech.nifi.processors.standard.UpdateRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<UpdateRecord, UpdateRecord> configurator) {
    return configurator.apply(new UpdateRecord(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = UpdateRecord.class) final Closure<UpdateRecord> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.UpdateRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.UpdateRecord.class, com.tibtech.nifi.processors.standard.UpdateRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
