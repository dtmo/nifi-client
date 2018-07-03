package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ForkRecord {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ForkRecord";

  /**
   * Specifies the Controller Service to use for reading incoming data
   */
  public static final String RECORD_READER_PROPERTY = "record-reader";

  /**
   * Specifies the Controller Service to use for writing out the records
   */
  public static final String RECORD_WRITER_PROPERTY = "record-writer";

  /**
   * Specifies the forking mode of the processor
   */
  public static final String FORK_MODE_PROPERTY = "fork-mode";

  /**
   * This parameter is only valid with the 'extract' mode. If set to true, all the fields from the root level to the given array will be added as fields of each element of the array to fork.
   */
  public static final String INCLUDE_PARENT_FIELDS_PROPERTY = "include-parent-fields";

  private final Map<String, String> properties;

  public ForkRecord() {
    this.properties = new HashMap<>();
  }

  public ForkRecord(final Map<String, String> properties) {
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
  public final ForkRecord setRecordReader(final String recordReader) {
    properties.put(RECORD_READER_PROPERTY, recordReader);
    return this;
  }

  /**
   * Specifies the Controller Service to use for reading incoming data
   */
  public final ForkRecord removeRecordReader() {
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
  public final ForkRecord setRecordWriter(final String recordWriter) {
    properties.put(RECORD_WRITER_PROPERTY, recordWriter);
    return this;
  }

  /**
   * Specifies the Controller Service to use for writing out the records
   */
  public final ForkRecord removeRecordWriter() {
    properties.remove(RECORD_WRITER_PROPERTY);
    return this;
  }

  /**
   * Specifies the forking mode of the processor
   */
  public final String getForkMode() {
    return properties.get(FORK_MODE_PROPERTY);
  }

  /**
   * Specifies the forking mode of the processor
   */
  public final ForkRecord setForkMode(final String forkMode) {
    properties.put(FORK_MODE_PROPERTY, forkMode);
    return this;
  }

  /**
   * Specifies the forking mode of the processor
   */
  public final ForkRecord removeForkMode() {
    properties.remove(FORK_MODE_PROPERTY);
    return this;
  }

  /**
   * This parameter is only valid with the 'extract' mode. If set to true, all the fields from the root level to the given array will be added as fields of each element of the array to fork.
   */
  public final String getIncludeParentFields() {
    return properties.get(INCLUDE_PARENT_FIELDS_PROPERTY);
  }

  /**
   * This parameter is only valid with the 'extract' mode. If set to true, all the fields from the root level to the given array will be added as fields of each element of the array to fork.
   */
  public final ForkRecord setIncludeParentFields(final String includeParentFields) {
    properties.put(INCLUDE_PARENT_FIELDS_PROPERTY, includeParentFields);
    return this;
  }

  /**
   * This parameter is only valid with the 'extract' mode. If set to true, all the fields from the root level to the given array will be added as fields of each element of the array to fork.
   */
  public final ForkRecord removeIncludeParentFields() {
    properties.remove(INCLUDE_PARENT_FIELDS_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ForkRecord setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ForkRecord removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ForkRecord, ForkRecord> configurator) {
    return configurator.apply(new ForkRecord()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ForkRecord.class) final Closure<ForkRecord> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ForkRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ForkRecord.class, com.tibtech.nifi.processors.standard.ForkRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ForkRecord, ForkRecord> configurator) {
    return configurator.apply(new ForkRecord(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ForkRecord.class) final Closure<ForkRecord> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.ForkRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ForkRecord.class, com.tibtech.nifi.processors.standard.ForkRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
