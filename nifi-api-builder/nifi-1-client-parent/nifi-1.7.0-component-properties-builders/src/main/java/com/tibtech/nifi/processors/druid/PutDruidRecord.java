package com.tibtech.nifi.processors.druid;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutDruidRecord {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.druid.PutDruidRecord";

  /**
   * Specifies the Controller Service to use for parsing incoming data and determining the data's schema.
   */
  public static final String PUTDRUID_RECORD_READER_PROPERTY = "putdruid-record-reader";

  /**
   * The Record Writer to use in order to serialize the data to outgoing relationships.
   */
  public static final String PUTDRUID_RECORD_WRITER_PROPERTY = "putdruid-record-writer";

  /**
   * Tranquility Service to use for sending events to Druid.
   */
  public static final String PUTDRUID_TRANQUILITY_SERVICE_PROPERTY = "putdruid-tranquility-service";

  private final Map<String, String> properties;

  public PutDruidRecord() {
    this.properties = new HashMap<>();
  }

  public PutDruidRecord(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * Specifies the Controller Service to use for parsing incoming data and determining the data's schema.
   */
  public final String getPutdruidRecordReader() {
    return properties.get(PUTDRUID_RECORD_READER_PROPERTY);
  }

  /**
   * Specifies the Controller Service to use for parsing incoming data and determining the data's schema.
   */
  public final PutDruidRecord setPutdruidRecordReader(final String putdruidRecordReader) {
    properties.put(PUTDRUID_RECORD_READER_PROPERTY, putdruidRecordReader);
    return this;
  }

  /**
   * Specifies the Controller Service to use for parsing incoming data and determining the data's schema.
   */
  public final PutDruidRecord removePutdruidRecordReader() {
    properties.remove(PUTDRUID_RECORD_READER_PROPERTY);
    return this;
  }

  /**
   * The Record Writer to use in order to serialize the data to outgoing relationships.
   */
  public final String getPutdruidRecordWriter() {
    return properties.get(PUTDRUID_RECORD_WRITER_PROPERTY);
  }

  /**
   * The Record Writer to use in order to serialize the data to outgoing relationships.
   */
  public final PutDruidRecord setPutdruidRecordWriter(final String putdruidRecordWriter) {
    properties.put(PUTDRUID_RECORD_WRITER_PROPERTY, putdruidRecordWriter);
    return this;
  }

  /**
   * The Record Writer to use in order to serialize the data to outgoing relationships.
   */
  public final PutDruidRecord removePutdruidRecordWriter() {
    properties.remove(PUTDRUID_RECORD_WRITER_PROPERTY);
    return this;
  }

  /**
   * Tranquility Service to use for sending events to Druid.
   */
  public final String getPutdruidTranquilityService() {
    return properties.get(PUTDRUID_TRANQUILITY_SERVICE_PROPERTY);
  }

  /**
   * Tranquility Service to use for sending events to Druid.
   */
  public final PutDruidRecord setPutdruidTranquilityService(
      final String putdruidTranquilityService) {
    properties.put(PUTDRUID_TRANQUILITY_SERVICE_PROPERTY, putdruidTranquilityService);
    return this;
  }

  /**
   * Tranquility Service to use for sending events to Druid.
   */
  public final PutDruidRecord removePutdruidTranquilityService() {
    properties.remove(PUTDRUID_TRANQUILITY_SERVICE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutDruidRecord setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutDruidRecord removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<PutDruidRecord, PutDruidRecord> configurator) {
    return configurator.apply(new PutDruidRecord()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutDruidRecord.class) final Closure<PutDruidRecord> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.druid.PutDruidRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.druid.PutDruidRecord.class, com.tibtech.nifi.processors.druid.PutDruidRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutDruidRecord, PutDruidRecord> configurator) {
    return configurator.apply(new PutDruidRecord(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutDruidRecord.class) final Closure<PutDruidRecord> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.druid.PutDruidRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.druid.PutDruidRecord.class, com.tibtech.nifi.processors.druid.PutDruidRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
