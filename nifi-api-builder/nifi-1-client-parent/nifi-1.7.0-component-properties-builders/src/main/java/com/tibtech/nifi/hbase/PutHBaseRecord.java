package com.tibtech.nifi.hbase;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutHBaseRecord {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.hbase.PutHBaseRecord";

  /**
   * Specifies the Controller Service to use for parsing incoming data and determining the data's schema
   */
  public static final String RECORD_READER_PROPERTY = "record-reader";

  /**
   * Specifies the Controller Service to use for accessing HBase.
   */
  public static final String H_BASE_CLIENT_SERVICE_PROPERTY = "HBase Client Service";

  /**
   * The name of the HBase Table to put data into
   */
  public static final String TABLE_NAME_PROPERTY = "Table Name";

  /**
   * Specifies the name of a record field whose value should be used as the row id for the given record.
   */
  public static final String ROW_IDENTIFIER_FIELD_NAME_PROPERTY = "Row Identifier Field Name";

  /**
   * Specifies the data type of Row ID used when inserting data into HBase. The default behavior is to convert the row id to a UTF-8 byte array. Choosing Binary will convert a binary formatted string to the correct byte[] representation. The Binary option should be used if you are using Binary row keys in HBase
   */
  public static final String ROW_IDENTIFIER_ENCODING_STRATEGY_PROPERTY = "Row Identifier Encoding Strategy";

  /**
   * Handle null field values as either an empty string or skip them altogether.
   */
  public static final String HBASE_RECORD_NULL_FIELD_STRATEGY_PROPERTY = "hbase-record-null-field-strategy";

  /**
   * The Column Family to use when inserting data into HBase
   */
  public static final String COLUMN_FAMILY_PROPERTY = "Column Family";

  /**
   * When using visibility labels, any value set in this field will be applied to all cells that are written unless an attribute with the convention "visibility.COLUMN_FAMILY.COLUMN_QUALIFIER" is present on the flowfile. If this field is left blank, it will be assumed that no visibility is to be set unless visibility-related attributes are set. NOTE: this configuration will have no effect on your data if you have not enabled visibility labels in the HBase cluster.
   */
  public static final String HBASE_DEFAULT_VIS_STRING_PROPERTY = "hbase-default-vis-string";

  /**
   * A record path that points to part of the record which contains a path to a mapping of visibility strings to record paths
   */
  public static final String PUT_HB_REC_VISIBILITY_RECORD_PATH_PROPERTY = "put-hb-rec-visibility-record-path";

  /**
   * Specifies the name of a record field whose value should be used as the timestamp for the cells in HBase. The value of this field must be a number, string, or date that can be converted to a long. If this field is left blank, HBase will use the current time.
   */
  public static final String TIMESTAMP_FIELD_NAME_PROPERTY = "timestamp-field-name";

  /**
   * The maximum number of records to be sent to HBase at any one time from the record set.
   */
  public static final String BATCH_SIZE_PROPERTY = "Batch Size";

  /**
   * Indicates how to handle complex fields, i.e. fields that do not have a single text value.
   */
  public static final String COMPLEX_FIELD_STRATEGY_PROPERTY = "Complex Field Strategy";

  /**
   * Indicates how to store the value of each field in HBase. The default behavior is to convert each value from the record to a String, and store the UTF-8 bytes. Choosing Bytes will interpret the type of each field from the record, and convert the value to the byte representation of that type, meaning an integer will be stored as the byte representation of that integer.
   */
  public static final String FIELD_ENCODING_STRATEGY_PROPERTY = "Field Encoding Strategy";

  private final Map<String, String> properties;

  public PutHBaseRecord() {
    this.properties = new HashMap<>();
  }

  public PutHBaseRecord(final Map<String, String> properties) {
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
  public final PutHBaseRecord setRecordReader(final String recordReader) {
    properties.put(RECORD_READER_PROPERTY, recordReader);
    return this;
  }

  /**
   * Specifies the Controller Service to use for parsing incoming data and determining the data's schema
   */
  public final PutHBaseRecord removeRecordReader() {
    properties.remove(RECORD_READER_PROPERTY);
    return this;
  }

  /**
   * Specifies the Controller Service to use for accessing HBase.
   */
  public final String getHBaseClientService() {
    return properties.get(H_BASE_CLIENT_SERVICE_PROPERTY);
  }

  /**
   * Specifies the Controller Service to use for accessing HBase.
   */
  public final PutHBaseRecord setHBaseClientService(final String hBaseClientService) {
    properties.put(H_BASE_CLIENT_SERVICE_PROPERTY, hBaseClientService);
    return this;
  }

  /**
   * Specifies the Controller Service to use for accessing HBase.
   */
  public final PutHBaseRecord removeHBaseClientService() {
    properties.remove(H_BASE_CLIENT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The name of the HBase Table to put data into
   */
  public final String getTableName() {
    return properties.get(TABLE_NAME_PROPERTY);
  }

  /**
   * The name of the HBase Table to put data into
   */
  public final PutHBaseRecord setTableName(final String tableName) {
    properties.put(TABLE_NAME_PROPERTY, tableName);
    return this;
  }

  /**
   * The name of the HBase Table to put data into
   */
  public final PutHBaseRecord removeTableName() {
    properties.remove(TABLE_NAME_PROPERTY);
    return this;
  }

  /**
   * Specifies the name of a record field whose value should be used as the row id for the given record.
   */
  public final String getRowIdentifierFieldName() {
    return properties.get(ROW_IDENTIFIER_FIELD_NAME_PROPERTY);
  }

  /**
   * Specifies the name of a record field whose value should be used as the row id for the given record.
   */
  public final PutHBaseRecord setRowIdentifierFieldName(final String rowIdentifierFieldName) {
    properties.put(ROW_IDENTIFIER_FIELD_NAME_PROPERTY, rowIdentifierFieldName);
    return this;
  }

  /**
   * Specifies the name of a record field whose value should be used as the row id for the given record.
   */
  public final PutHBaseRecord removeRowIdentifierFieldName() {
    properties.remove(ROW_IDENTIFIER_FIELD_NAME_PROPERTY);
    return this;
  }

  /**
   * Specifies the data type of Row ID used when inserting data into HBase. The default behavior is to convert the row id to a UTF-8 byte array. Choosing Binary will convert a binary formatted string to the correct byte[] representation. The Binary option should be used if you are using Binary row keys in HBase
   */
  public final String getRowIdentifierEncodingStrategy() {
    return properties.get(ROW_IDENTIFIER_ENCODING_STRATEGY_PROPERTY);
  }

  /**
   * Specifies the data type of Row ID used when inserting data into HBase. The default behavior is to convert the row id to a UTF-8 byte array. Choosing Binary will convert a binary formatted string to the correct byte[] representation. The Binary option should be used if you are using Binary row keys in HBase
   */
  public final PutHBaseRecord setRowIdentifierEncodingStrategy(
      final String rowIdentifierEncodingStrategy) {
    properties.put(ROW_IDENTIFIER_ENCODING_STRATEGY_PROPERTY, rowIdentifierEncodingStrategy);
    return this;
  }

  /**
   * Specifies the data type of Row ID used when inserting data into HBase. The default behavior is to convert the row id to a UTF-8 byte array. Choosing Binary will convert a binary formatted string to the correct byte[] representation. The Binary option should be used if you are using Binary row keys in HBase
   */
  public final PutHBaseRecord removeRowIdentifierEncodingStrategy() {
    properties.remove(ROW_IDENTIFIER_ENCODING_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * Handle null field values as either an empty string or skip them altogether.
   */
  public final String getHbaseRecordNullFieldStrategy() {
    return properties.get(HBASE_RECORD_NULL_FIELD_STRATEGY_PROPERTY);
  }

  /**
   * Handle null field values as either an empty string or skip them altogether.
   */
  public final PutHBaseRecord setHbaseRecordNullFieldStrategy(
      final String hbaseRecordNullFieldStrategy) {
    properties.put(HBASE_RECORD_NULL_FIELD_STRATEGY_PROPERTY, hbaseRecordNullFieldStrategy);
    return this;
  }

  /**
   * Handle null field values as either an empty string or skip them altogether.
   */
  public final PutHBaseRecord removeHbaseRecordNullFieldStrategy() {
    properties.remove(HBASE_RECORD_NULL_FIELD_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * The Column Family to use when inserting data into HBase
   */
  public final String getColumnFamily() {
    return properties.get(COLUMN_FAMILY_PROPERTY);
  }

  /**
   * The Column Family to use when inserting data into HBase
   */
  public final PutHBaseRecord setColumnFamily(final String columnFamily) {
    properties.put(COLUMN_FAMILY_PROPERTY, columnFamily);
    return this;
  }

  /**
   * The Column Family to use when inserting data into HBase
   */
  public final PutHBaseRecord removeColumnFamily() {
    properties.remove(COLUMN_FAMILY_PROPERTY);
    return this;
  }

  /**
   * When using visibility labels, any value set in this field will be applied to all cells that are written unless an attribute with the convention "visibility.COLUMN_FAMILY.COLUMN_QUALIFIER" is present on the flowfile. If this field is left blank, it will be assumed that no visibility is to be set unless visibility-related attributes are set. NOTE: this configuration will have no effect on your data if you have not enabled visibility labels in the HBase cluster.
   */
  public final String getHbaseDefaultVisString() {
    return properties.get(HBASE_DEFAULT_VIS_STRING_PROPERTY);
  }

  /**
   * When using visibility labels, any value set in this field will be applied to all cells that are written unless an attribute with the convention "visibility.COLUMN_FAMILY.COLUMN_QUALIFIER" is present on the flowfile. If this field is left blank, it will be assumed that no visibility is to be set unless visibility-related attributes are set. NOTE: this configuration will have no effect on your data if you have not enabled visibility labels in the HBase cluster.
   */
  public final PutHBaseRecord setHbaseDefaultVisString(final String hbaseDefaultVisString) {
    properties.put(HBASE_DEFAULT_VIS_STRING_PROPERTY, hbaseDefaultVisString);
    return this;
  }

  /**
   * When using visibility labels, any value set in this field will be applied to all cells that are written unless an attribute with the convention "visibility.COLUMN_FAMILY.COLUMN_QUALIFIER" is present on the flowfile. If this field is left blank, it will be assumed that no visibility is to be set unless visibility-related attributes are set. NOTE: this configuration will have no effect on your data if you have not enabled visibility labels in the HBase cluster.
   */
  public final PutHBaseRecord removeHbaseDefaultVisString() {
    properties.remove(HBASE_DEFAULT_VIS_STRING_PROPERTY);
    return this;
  }

  /**
   * A record path that points to part of the record which contains a path to a mapping of visibility strings to record paths
   */
  public final String getPutHbRecVisibilityRecordPath() {
    return properties.get(PUT_HB_REC_VISIBILITY_RECORD_PATH_PROPERTY);
  }

  /**
   * A record path that points to part of the record which contains a path to a mapping of visibility strings to record paths
   */
  public final PutHBaseRecord setPutHbRecVisibilityRecordPath(
      final String putHbRecVisibilityRecordPath) {
    properties.put(PUT_HB_REC_VISIBILITY_RECORD_PATH_PROPERTY, putHbRecVisibilityRecordPath);
    return this;
  }

  /**
   * A record path that points to part of the record which contains a path to a mapping of visibility strings to record paths
   */
  public final PutHBaseRecord removePutHbRecVisibilityRecordPath() {
    properties.remove(PUT_HB_REC_VISIBILITY_RECORD_PATH_PROPERTY);
    return this;
  }

  /**
   * Specifies the name of a record field whose value should be used as the timestamp for the cells in HBase. The value of this field must be a number, string, or date that can be converted to a long. If this field is left blank, HBase will use the current time.
   */
  public final String getTimestampFieldName() {
    return properties.get(TIMESTAMP_FIELD_NAME_PROPERTY);
  }

  /**
   * Specifies the name of a record field whose value should be used as the timestamp for the cells in HBase. The value of this field must be a number, string, or date that can be converted to a long. If this field is left blank, HBase will use the current time.
   */
  public final PutHBaseRecord setTimestampFieldName(final String timestampFieldName) {
    properties.put(TIMESTAMP_FIELD_NAME_PROPERTY, timestampFieldName);
    return this;
  }

  /**
   * Specifies the name of a record field whose value should be used as the timestamp for the cells in HBase. The value of this field must be a number, string, or date that can be converted to a long. If this field is left blank, HBase will use the current time.
   */
  public final PutHBaseRecord removeTimestampFieldName() {
    properties.remove(TIMESTAMP_FIELD_NAME_PROPERTY);
    return this;
  }

  /**
   * The maximum number of records to be sent to HBase at any one time from the record set.
   */
  public final String getBatchSize() {
    return properties.get(BATCH_SIZE_PROPERTY);
  }

  /**
   * The maximum number of records to be sent to HBase at any one time from the record set.
   */
  public final PutHBaseRecord setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * The maximum number of records to be sent to HBase at any one time from the record set.
   */
  public final PutHBaseRecord removeBatchSize() {
    properties.remove(BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * Indicates how to handle complex fields, i.e. fields that do not have a single text value.
   */
  public final String getComplexFieldStrategy() {
    return properties.get(COMPLEX_FIELD_STRATEGY_PROPERTY);
  }

  /**
   * Indicates how to handle complex fields, i.e. fields that do not have a single text value.
   */
  public final PutHBaseRecord setComplexFieldStrategy(final String complexFieldStrategy) {
    properties.put(COMPLEX_FIELD_STRATEGY_PROPERTY, complexFieldStrategy);
    return this;
  }

  /**
   * Indicates how to handle complex fields, i.e. fields that do not have a single text value.
   */
  public final PutHBaseRecord removeComplexFieldStrategy() {
    properties.remove(COMPLEX_FIELD_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * Indicates how to store the value of each field in HBase. The default behavior is to convert each value from the record to a String, and store the UTF-8 bytes. Choosing Bytes will interpret the type of each field from the record, and convert the value to the byte representation of that type, meaning an integer will be stored as the byte representation of that integer.
   */
  public final String getFieldEncodingStrategy() {
    return properties.get(FIELD_ENCODING_STRATEGY_PROPERTY);
  }

  /**
   * Indicates how to store the value of each field in HBase. The default behavior is to convert each value from the record to a String, and store the UTF-8 bytes. Choosing Bytes will interpret the type of each field from the record, and convert the value to the byte representation of that type, meaning an integer will be stored as the byte representation of that integer.
   */
  public final PutHBaseRecord setFieldEncodingStrategy(final String fieldEncodingStrategy) {
    properties.put(FIELD_ENCODING_STRATEGY_PROPERTY, fieldEncodingStrategy);
    return this;
  }

  /**
   * Indicates how to store the value of each field in HBase. The default behavior is to convert each value from the record to a String, and store the UTF-8 bytes. Choosing Bytes will interpret the type of each field from the record, and convert the value to the byte representation of that type, meaning an integer will be stored as the byte representation of that integer.
   */
  public final PutHBaseRecord removeFieldEncodingStrategy() {
    properties.remove(FIELD_ENCODING_STRATEGY_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutHBaseRecord setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutHBaseRecord removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<PutHBaseRecord, PutHBaseRecord> configurator) {
    return configurator.apply(new PutHBaseRecord()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutHBaseRecord.class) final Closure<PutHBaseRecord> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.hbase.PutHBaseRecord> code = closure.rehydrate(c, com.tibtech.nifi.hbase.PutHBaseRecord.class, com.tibtech.nifi.hbase.PutHBaseRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutHBaseRecord, PutHBaseRecord> configurator) {
    return configurator.apply(new PutHBaseRecord(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutHBaseRecord.class) final Closure<PutHBaseRecord> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.hbase.PutHBaseRecord> code = closure.rehydrate(c, com.tibtech.nifi.hbase.PutHBaseRecord.class, com.tibtech.nifi.hbase.PutHBaseRecord.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
