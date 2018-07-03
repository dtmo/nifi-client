package com.tibtech.nifi.hbase;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutHBaseJSON {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.hbase.PutHBaseJSON";

  /**
   * Specifies the Controller Service to use for accessing HBase.
   */
  public static final String H_BASE_CLIENT_SERVICE_PROPERTY = "HBase Client Service";

  /**
   * The name of the HBase Table to put data into
   */
  public static final String TABLE_NAME_PROPERTY = "Table Name";

  /**
   * Specifies the Row ID to use when inserting data into HBase
   */
  public static final String ROW_IDENTIFIER_PROPERTY = "Row Identifier";

  /**
   * Specifies the name of a JSON element whose value should be used as the row id for the given JSON document.
   */
  public static final String ROW_IDENTIFIER_FIELD_NAME_PROPERTY = "Row Identifier Field Name";

  /**
   * Specifies the data type of Row ID used when inserting data into HBase. The default behavior is to convert the row id to a UTF-8 byte array. Choosing Binary will convert a binary formatted string to the correct byte[] representation. The Binary option should be used if you are using Binary row keys in HBase
   */
  public static final String ROW_IDENTIFIER_ENCODING_STRATEGY_PROPERTY = "Row Identifier Encoding Strategy";

  /**
   * The Column Family to use when inserting data into HBase
   */
  public static final String COLUMN_FAMILY_PROPERTY = "Column Family";

  /**
   * The timestamp for the cells being created in HBase. This field can be left blank and HBase will use the current time.
   */
  public static final String TIMESTAMP_PROPERTY = "timestamp";

  /**
   * The maximum number of FlowFiles to process in a single execution. The FlowFiles will be grouped by table, and a single Put per table will be performed.
   */
  public static final String BATCH_SIZE_PROPERTY = "Batch Size";

  /**
   * Indicates how to handle complex fields, i.e. fields that do not have a single text value.
   */
  public static final String COMPLEX_FIELD_STRATEGY_PROPERTY = "Complex Field Strategy";

  /**
   * Indicates how to store the value of each field in HBase. The default behavior is to convert each value from the JSON to a String, and store the UTF-8 bytes. Choosing Bytes will interpret the type of each field from the JSON, and convert the value to the byte representation of that type, meaning an integer will be stored as the byte representation of that integer.
   */
  public static final String FIELD_ENCODING_STRATEGY_PROPERTY = "Field Encoding Strategy";

  private final Map<String, String> properties;

  public PutHBaseJSON() {
    this.properties = new HashMap<>();
  }

  public PutHBaseJSON(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
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
  public final PutHBaseJSON setHBaseClientService(final String hBaseClientService) {
    properties.put(H_BASE_CLIENT_SERVICE_PROPERTY, hBaseClientService);
    return this;
  }

  /**
   * Specifies the Controller Service to use for accessing HBase.
   */
  public final PutHBaseJSON removeHBaseClientService() {
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
  public final PutHBaseJSON setTableName(final String tableName) {
    properties.put(TABLE_NAME_PROPERTY, tableName);
    return this;
  }

  /**
   * The name of the HBase Table to put data into
   */
  public final PutHBaseJSON removeTableName() {
    properties.remove(TABLE_NAME_PROPERTY);
    return this;
  }

  /**
   * Specifies the Row ID to use when inserting data into HBase
   */
  public final String getRowIdentifier() {
    return properties.get(ROW_IDENTIFIER_PROPERTY);
  }

  /**
   * Specifies the Row ID to use when inserting data into HBase
   */
  public final PutHBaseJSON setRowIdentifier(final String rowIdentifier) {
    properties.put(ROW_IDENTIFIER_PROPERTY, rowIdentifier);
    return this;
  }

  /**
   * Specifies the Row ID to use when inserting data into HBase
   */
  public final PutHBaseJSON removeRowIdentifier() {
    properties.remove(ROW_IDENTIFIER_PROPERTY);
    return this;
  }

  /**
   * Specifies the name of a JSON element whose value should be used as the row id for the given JSON document.
   */
  public final String getRowIdentifierFieldName() {
    return properties.get(ROW_IDENTIFIER_FIELD_NAME_PROPERTY);
  }

  /**
   * Specifies the name of a JSON element whose value should be used as the row id for the given JSON document.
   */
  public final PutHBaseJSON setRowIdentifierFieldName(final String rowIdentifierFieldName) {
    properties.put(ROW_IDENTIFIER_FIELD_NAME_PROPERTY, rowIdentifierFieldName);
    return this;
  }

  /**
   * Specifies the name of a JSON element whose value should be used as the row id for the given JSON document.
   */
  public final PutHBaseJSON removeRowIdentifierFieldName() {
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
  public final PutHBaseJSON setRowIdentifierEncodingStrategy(
      final String rowIdentifierEncodingStrategy) {
    properties.put(ROW_IDENTIFIER_ENCODING_STRATEGY_PROPERTY, rowIdentifierEncodingStrategy);
    return this;
  }

  /**
   * Specifies the data type of Row ID used when inserting data into HBase. The default behavior is to convert the row id to a UTF-8 byte array. Choosing Binary will convert a binary formatted string to the correct byte[] representation. The Binary option should be used if you are using Binary row keys in HBase
   */
  public final PutHBaseJSON removeRowIdentifierEncodingStrategy() {
    properties.remove(ROW_IDENTIFIER_ENCODING_STRATEGY_PROPERTY);
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
  public final PutHBaseJSON setColumnFamily(final String columnFamily) {
    properties.put(COLUMN_FAMILY_PROPERTY, columnFamily);
    return this;
  }

  /**
   * The Column Family to use when inserting data into HBase
   */
  public final PutHBaseJSON removeColumnFamily() {
    properties.remove(COLUMN_FAMILY_PROPERTY);
    return this;
  }

  /**
   * The timestamp for the cells being created in HBase. This field can be left blank and HBase will use the current time.
   */
  public final String getTimestamp() {
    return properties.get(TIMESTAMP_PROPERTY);
  }

  /**
   * The timestamp for the cells being created in HBase. This field can be left blank and HBase will use the current time.
   */
  public final PutHBaseJSON setTimestamp(final String timestamp) {
    properties.put(TIMESTAMP_PROPERTY, timestamp);
    return this;
  }

  /**
   * The timestamp for the cells being created in HBase. This field can be left blank and HBase will use the current time.
   */
  public final PutHBaseJSON removeTimestamp() {
    properties.remove(TIMESTAMP_PROPERTY);
    return this;
  }

  /**
   * The maximum number of FlowFiles to process in a single execution. The FlowFiles will be grouped by table, and a single Put per table will be performed.
   */
  public final String getBatchSize() {
    return properties.get(BATCH_SIZE_PROPERTY);
  }

  /**
   * The maximum number of FlowFiles to process in a single execution. The FlowFiles will be grouped by table, and a single Put per table will be performed.
   */
  public final PutHBaseJSON setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * The maximum number of FlowFiles to process in a single execution. The FlowFiles will be grouped by table, and a single Put per table will be performed.
   */
  public final PutHBaseJSON removeBatchSize() {
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
  public final PutHBaseJSON setComplexFieldStrategy(final String complexFieldStrategy) {
    properties.put(COMPLEX_FIELD_STRATEGY_PROPERTY, complexFieldStrategy);
    return this;
  }

  /**
   * Indicates how to handle complex fields, i.e. fields that do not have a single text value.
   */
  public final PutHBaseJSON removeComplexFieldStrategy() {
    properties.remove(COMPLEX_FIELD_STRATEGY_PROPERTY);
    return this;
  }

  /**
   * Indicates how to store the value of each field in HBase. The default behavior is to convert each value from the JSON to a String, and store the UTF-8 bytes. Choosing Bytes will interpret the type of each field from the JSON, and convert the value to the byte representation of that type, meaning an integer will be stored as the byte representation of that integer.
   */
  public final String getFieldEncodingStrategy() {
    return properties.get(FIELD_ENCODING_STRATEGY_PROPERTY);
  }

  /**
   * Indicates how to store the value of each field in HBase. The default behavior is to convert each value from the JSON to a String, and store the UTF-8 bytes. Choosing Bytes will interpret the type of each field from the JSON, and convert the value to the byte representation of that type, meaning an integer will be stored as the byte representation of that integer.
   */
  public final PutHBaseJSON setFieldEncodingStrategy(final String fieldEncodingStrategy) {
    properties.put(FIELD_ENCODING_STRATEGY_PROPERTY, fieldEncodingStrategy);
    return this;
  }

  /**
   * Indicates how to store the value of each field in HBase. The default behavior is to convert each value from the JSON to a String, and store the UTF-8 bytes. Choosing Bytes will interpret the type of each field from the JSON, and convert the value to the byte representation of that type, meaning an integer will be stored as the byte representation of that integer.
   */
  public final PutHBaseJSON removeFieldEncodingStrategy() {
    properties.remove(FIELD_ENCODING_STRATEGY_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutHBaseJSON setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutHBaseJSON removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<PutHBaseJSON, PutHBaseJSON> configurator) {
    return configurator.apply(new PutHBaseJSON()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutHBaseJSON.class) final Closure<PutHBaseJSON> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.hbase.PutHBaseJSON> code = closure.rehydrate(c, com.tibtech.nifi.hbase.PutHBaseJSON.class, com.tibtech.nifi.hbase.PutHBaseJSON.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutHBaseJSON, PutHBaseJSON> configurator) {
    return configurator.apply(new PutHBaseJSON(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutHBaseJSON.class) final Closure<PutHBaseJSON> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.hbase.PutHBaseJSON> code = closure.rehydrate(c, com.tibtech.nifi.hbase.PutHBaseJSON.class, com.tibtech.nifi.hbase.PutHBaseJSON.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
