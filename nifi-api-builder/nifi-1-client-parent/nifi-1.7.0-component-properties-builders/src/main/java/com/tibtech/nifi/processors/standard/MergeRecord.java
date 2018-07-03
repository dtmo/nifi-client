package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class MergeRecord {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.MergeRecord";

  /**
   * Specifies the Controller Service to use for reading incoming data
   */
  public static final String RECORD_READER_PROPERTY = "record-reader";

  /**
   * Specifies the Controller Service to use for writing out the records
   */
  public static final String RECORD_WRITER_PROPERTY = "record-writer";

  /**
   * Specifies the algorithm used to merge records. The 'Defragment' algorithm combines fragments that are associated by attributes back into a single cohesive FlowFile. The 'Bin-Packing Algorithm' generates a FlowFile populated by arbitrarily chosen FlowFiles
   */
  public static final String MERGE_STRATEGY_PROPERTY = "merge-strategy";

  /**
   * If specified, two FlowFiles will be binned together only if they have the same value for this Attribute. If not specified, FlowFiles are bundled by the order in which they are pulled from the queue.
   */
  public static final String CORRELATION_ATTRIBUTE_NAME_PROPERTY = "correlation-attribute-name";

  /**
   * Determines which FlowFile attributes should be added to the bundle. If 'Keep All Unique Attributes' is selected, any attribute on any FlowFile that gets bundled will be kept unless its value conflicts with the value from another FlowFile. If 'Keep Only Common Attributes' is selected, only the attributes that exist on all FlowFiles in the bundle, with the same value, will be preserved.
   */
  public static final String ATTRIBUTE_STRATEGY_PROPERTY = "Attribute Strategy";

  /**
   * The minimum number of records to include in a bin
   */
  public static final String MIN_RECORDS_PROPERTY = "min-records";

  /**
   * The maximum number of Records to include in a bin. This is a 'soft limit' in that if a FlowFIle is added to a bin, all records in that FlowFile will be added, so this limit may be exceeded by up to the number of records in the last input FlowFile.
   */
  public static final String MAX_RECORDS_PROPERTY = "max-records";

  /**
   * The minimum size of for the bin
   */
  public static final String MIN_BIN_SIZE_PROPERTY = "min-bin-size";

  /**
   * The maximum size for the bundle. If not specified, there is no maximum. This is a 'soft limit' in that if a FlowFile is added to a bin, all records in that FlowFile will be added, so this limit may be exceeded by up to the number of bytes in last input FlowFile.
   */
  public static final String MAX_BIN_SIZE_PROPERTY = "max-bin-size";

  /**
   * The maximum age of a Bin that will trigger a Bin to be complete. Expected format is <duration> <time unit> where <duration> is a positive integer and time unit is one of seconds, minutes, hours
   */
  public static final String MAX_BIN_AGE_PROPERTY = "max-bin-age";

  /**
   * Specifies the maximum number of bins that can be held in memory at any one time. This number should not be smaller than the maximum number of conurrent threads for this Processor, or the bins that are created will often consist only of a single incoming FlowFile.
   */
  public static final String MAX_BIN_COUNT_PROPERTY = "max.bin.count";

  private final Map<String, String> properties;

  public MergeRecord() {
    this.properties = new HashMap<>();
  }

  public MergeRecord(final Map<String, String> properties) {
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
  public final MergeRecord setRecordReader(final String recordReader) {
    properties.put(RECORD_READER_PROPERTY, recordReader);
    return this;
  }

  /**
   * Specifies the Controller Service to use for reading incoming data
   */
  public final MergeRecord removeRecordReader() {
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
  public final MergeRecord setRecordWriter(final String recordWriter) {
    properties.put(RECORD_WRITER_PROPERTY, recordWriter);
    return this;
  }

  /**
   * Specifies the Controller Service to use for writing out the records
   */
  public final MergeRecord removeRecordWriter() {
    properties.remove(RECORD_WRITER_PROPERTY);
    return this;
  }

  /**
   * Specifies the algorithm used to merge records. The 'Defragment' algorithm combines fragments that are associated by attributes back into a single cohesive FlowFile. The 'Bin-Packing Algorithm' generates a FlowFile populated by arbitrarily chosen FlowFiles
   */
  public final String getMergeStrategy() {
    return properties.get(MERGE_STRATEGY_PROPERTY);
  }

  /**
   * Specifies the algorithm used to merge records. The 'Defragment' algorithm combines fragments that are associated by attributes back into a single cohesive FlowFile. The 'Bin-Packing Algorithm' generates a FlowFile populated by arbitrarily chosen FlowFiles
   */
  public final MergeRecord setMergeStrategy(final String mergeStrategy) {
    properties.put(MERGE_STRATEGY_PROPERTY, mergeStrategy);
    return this;
  }

  /**
   * Specifies the algorithm used to merge records. The 'Defragment' algorithm combines fragments that are associated by attributes back into a single cohesive FlowFile. The 'Bin-Packing Algorithm' generates a FlowFile populated by arbitrarily chosen FlowFiles
   */
  public final MergeRecord removeMergeStrategy() {
    properties.remove(MERGE_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * If specified, two FlowFiles will be binned together only if they have the same value for this Attribute. If not specified, FlowFiles are bundled by the order in which they are pulled from the queue.
   */
  public final String getCorrelationAttributeName() {
    return properties.get(CORRELATION_ATTRIBUTE_NAME_PROPERTY);
  }

  /**
   * If specified, two FlowFiles will be binned together only if they have the same value for this Attribute. If not specified, FlowFiles are bundled by the order in which they are pulled from the queue.
   */
  public final MergeRecord setCorrelationAttributeName(final String correlationAttributeName) {
    properties.put(CORRELATION_ATTRIBUTE_NAME_PROPERTY, correlationAttributeName);
    return this;
  }

  /**
   * If specified, two FlowFiles will be binned together only if they have the same value for this Attribute. If not specified, FlowFiles are bundled by the order in which they are pulled from the queue.
   */
  public final MergeRecord removeCorrelationAttributeName() {
    properties.remove(CORRELATION_ATTRIBUTE_NAME_PROPERTY);
    return this;
  }

  /**
   * Determines which FlowFile attributes should be added to the bundle. If 'Keep All Unique Attributes' is selected, any attribute on any FlowFile that gets bundled will be kept unless its value conflicts with the value from another FlowFile. If 'Keep Only Common Attributes' is selected, only the attributes that exist on all FlowFiles in the bundle, with the same value, will be preserved.
   */
  public final String getAttributeStrategy() {
    return properties.get(ATTRIBUTE_STRATEGY_PROPERTY);
  }

  /**
   * Determines which FlowFile attributes should be added to the bundle. If 'Keep All Unique Attributes' is selected, any attribute on any FlowFile that gets bundled will be kept unless its value conflicts with the value from another FlowFile. If 'Keep Only Common Attributes' is selected, only the attributes that exist on all FlowFiles in the bundle, with the same value, will be preserved.
   */
  public final MergeRecord setAttributeStrategy(final String attributeStrategy) {
    properties.put(ATTRIBUTE_STRATEGY_PROPERTY, attributeStrategy);
    return this;
  }

  /**
   * Determines which FlowFile attributes should be added to the bundle. If 'Keep All Unique Attributes' is selected, any attribute on any FlowFile that gets bundled will be kept unless its value conflicts with the value from another FlowFile. If 'Keep Only Common Attributes' is selected, only the attributes that exist on all FlowFiles in the bundle, with the same value, will be preserved.
   */
  public final MergeRecord removeAttributeStrategy() {
    properties.remove(ATTRIBUTE_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * The minimum number of records to include in a bin
   */
  public final String getMinRecords() {
    return properties.get(MIN_RECORDS_PROPERTY);
  }

  /**
   * The minimum number of records to include in a bin
   */
  public final MergeRecord setMinRecords(final String minRecords) {
    properties.put(MIN_RECORDS_PROPERTY, minRecords);
    return this;
  }

  /**
   * The minimum number of records to include in a bin
   */
  public final MergeRecord removeMinRecords() {
    properties.remove(MIN_RECORDS_PROPERTY);
    return this;
  }

  /**
   * The maximum number of Records to include in a bin. This is a 'soft limit' in that if a FlowFIle is added to a bin, all records in that FlowFile will be added, so this limit may be exceeded by up to the number of records in the last input FlowFile.
   */
  public final String getMaxRecords() {
    return properties.get(MAX_RECORDS_PROPERTY);
  }

  /**
   * The maximum number of Records to include in a bin. This is a 'soft limit' in that if a FlowFIle is added to a bin, all records in that FlowFile will be added, so this limit may be exceeded by up to the number of records in the last input FlowFile.
   */
  public final MergeRecord setMaxRecords(final String maxRecords) {
    properties.put(MAX_RECORDS_PROPERTY, maxRecords);
    return this;
  }

  /**
   * The maximum number of Records to include in a bin. This is a 'soft limit' in that if a FlowFIle is added to a bin, all records in that FlowFile will be added, so this limit may be exceeded by up to the number of records in the last input FlowFile.
   */
  public final MergeRecord removeMaxRecords() {
    properties.remove(MAX_RECORDS_PROPERTY);
    return this;
  }

  /**
   * The minimum size of for the bin
   */
  public final String getMinBinSize() {
    return properties.get(MIN_BIN_SIZE_PROPERTY);
  }

  /**
   * The minimum size of for the bin
   */
  public final MergeRecord setMinBinSize(final String minBinSize) {
    properties.put(MIN_BIN_SIZE_PROPERTY, minBinSize);
    return this;
  }

  /**
   * The minimum size of for the bin
   */
  public final MergeRecord removeMinBinSize() {
    properties.remove(MIN_BIN_SIZE_PROPERTY);
    return this;
  }

  /**
   * The maximum size for the bundle. If not specified, there is no maximum. This is a 'soft limit' in that if a FlowFile is added to a bin, all records in that FlowFile will be added, so this limit may be exceeded by up to the number of bytes in last input FlowFile.
   */
  public final String getMaxBinSize() {
    return properties.get(MAX_BIN_SIZE_PROPERTY);
  }

  /**
   * The maximum size for the bundle. If not specified, there is no maximum. This is a 'soft limit' in that if a FlowFile is added to a bin, all records in that FlowFile will be added, so this limit may be exceeded by up to the number of bytes in last input FlowFile.
   */
  public final MergeRecord setMaxBinSize(final String maxBinSize) {
    properties.put(MAX_BIN_SIZE_PROPERTY, maxBinSize);
    return this;
  }

  /**
   * The maximum size for the bundle. If not specified, there is no maximum. This is a 'soft limit' in that if a FlowFile is added to a bin, all records in that FlowFile will be added, so this limit may be exceeded by up to the number of bytes in last input FlowFile.
   */
  public final MergeRecord removeMaxBinSize() {
    properties.remove(MAX_BIN_SIZE_PROPERTY);
    return this;
  }

  /**
   * The maximum age of a Bin that will trigger a Bin to be complete. Expected format is <duration> <time unit> where <duration> is a positive integer and time unit is one of seconds, minutes, hours
   */
  public final String getMaxBinAge() {
    return properties.get(MAX_BIN_AGE_PROPERTY);
  }

  /**
   * The maximum age of a Bin that will trigger a Bin to be complete. Expected format is <duration> <time unit> where <duration> is a positive integer and time unit is one of seconds, minutes, hours
   */
  public final MergeRecord setMaxBinAge(final String maxBinAge) {
    properties.put(MAX_BIN_AGE_PROPERTY, maxBinAge);
    return this;
  }

  /**
   * The maximum age of a Bin that will trigger a Bin to be complete. Expected format is <duration> <time unit> where <duration> is a positive integer and time unit is one of seconds, minutes, hours
   */
  public final MergeRecord removeMaxBinAge() {
    properties.remove(MAX_BIN_AGE_PROPERTY);
    return this;
  }

  /**
   * Specifies the maximum number of bins that can be held in memory at any one time. This number should not be smaller than the maximum number of conurrent threads for this Processor, or the bins that are created will often consist only of a single incoming FlowFile.
   */
  public final String getMaxBinCount() {
    return properties.get(MAX_BIN_COUNT_PROPERTY);
  }

  /**
   * Specifies the maximum number of bins that can be held in memory at any one time. This number should not be smaller than the maximum number of conurrent threads for this Processor, or the bins that are created will often consist only of a single incoming FlowFile.
   */
  public final MergeRecord setMaxBinCount(final String maxBinCount) {
    properties.put(MAX_BIN_COUNT_PROPERTY, maxBinCount);
    return this;
  }

  /**
   * Specifies the maximum number of bins that can be held in memory at any one time. This number should not be smaller than the maximum number of conurrent threads for this Processor, or the bins that are created will often consist only of a single incoming FlowFile.
   */
  public final MergeRecord removeMaxBinCount() {
    properties.remove(MAX_BIN_COUNT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final MergeRecord setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final MergeRecord removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<MergeRecord, MergeRecord> configurator) {
    return configurator.apply(new MergeRecord()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = MergeRecord.class) final Closure<MergeRecord> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.MergeRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.MergeRecord.class, com.tibtech.nifi.processors.standard.MergeRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<MergeRecord, MergeRecord> configurator) {
    return configurator.apply(new MergeRecord(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = MergeRecord.class) final Closure<MergeRecord> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.MergeRecord> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.MergeRecord.class, com.tibtech.nifi.processors.standard.MergeRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
