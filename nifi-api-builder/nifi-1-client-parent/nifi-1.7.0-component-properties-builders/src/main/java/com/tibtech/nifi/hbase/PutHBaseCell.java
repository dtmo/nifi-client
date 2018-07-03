package com.tibtech.nifi.hbase;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutHBaseCell {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.hbase.PutHBaseCell";

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
   * Specifies the data type of Row ID used when inserting data into HBase. The default behavior is to convert the row id to a UTF-8 byte array. Choosing Binary will convert a binary formatted string to the correct byte[] representation. The Binary option should be used if you are using Binary row keys in HBase
   */
  public static final String ROW_IDENTIFIER_ENCODING_STRATEGY_PROPERTY = "Row Identifier Encoding Strategy";

  /**
   * The Column Family to use when inserting data into HBase
   */
  public static final String COLUMN_FAMILY_PROPERTY = "Column Family";

  /**
   * The Column Qualifier to use when inserting data into HBase
   */
  public static final String COLUMN_QUALIFIER_PROPERTY = "Column Qualifier";

  /**
   * The timestamp for the cells being created in HBase. This field can be left blank and HBase will use the current time.
   */
  public static final String TIMESTAMP_PROPERTY = "timestamp";

  /**
   * The maximum number of FlowFiles to process in a single execution. The FlowFiles will be grouped by table, and a single Put per table will be performed.
   */
  public static final String BATCH_SIZE_PROPERTY = "Batch Size";

  private final Map<String, String> properties;

  public PutHBaseCell() {
    this.properties = new HashMap<>();
  }

  public PutHBaseCell(final Map<String, String> properties) {
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
  public final PutHBaseCell setHBaseClientService(final String hBaseClientService) {
    properties.put(H_BASE_CLIENT_SERVICE_PROPERTY, hBaseClientService);
    return this;
  }

  /**
   * Specifies the Controller Service to use for accessing HBase.
   */
  public final PutHBaseCell removeHBaseClientService() {
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
  public final PutHBaseCell setTableName(final String tableName) {
    properties.put(TABLE_NAME_PROPERTY, tableName);
    return this;
  }

  /**
   * The name of the HBase Table to put data into
   */
  public final PutHBaseCell removeTableName() {
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
  public final PutHBaseCell setRowIdentifier(final String rowIdentifier) {
    properties.put(ROW_IDENTIFIER_PROPERTY, rowIdentifier);
    return this;
  }

  /**
   * Specifies the Row ID to use when inserting data into HBase
   */
  public final PutHBaseCell removeRowIdentifier() {
    properties.remove(ROW_IDENTIFIER_PROPERTY);
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
  public final PutHBaseCell setRowIdentifierEncodingStrategy(
      final String rowIdentifierEncodingStrategy) {
    properties.put(ROW_IDENTIFIER_ENCODING_STRATEGY_PROPERTY, rowIdentifierEncodingStrategy);
    return this;
  }

  /**
   * Specifies the data type of Row ID used when inserting data into HBase. The default behavior is to convert the row id to a UTF-8 byte array. Choosing Binary will convert a binary formatted string to the correct byte[] representation. The Binary option should be used if you are using Binary row keys in HBase
   */
  public final PutHBaseCell removeRowIdentifierEncodingStrategy() {
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
  public final PutHBaseCell setColumnFamily(final String columnFamily) {
    properties.put(COLUMN_FAMILY_PROPERTY, columnFamily);
    return this;
  }

  /**
   * The Column Family to use when inserting data into HBase
   */
  public final PutHBaseCell removeColumnFamily() {
    properties.remove(COLUMN_FAMILY_PROPERTY);
    return this;
  }

  /**
   * The Column Qualifier to use when inserting data into HBase
   */
  public final String getColumnQualifier() {
    return properties.get(COLUMN_QUALIFIER_PROPERTY);
  }

  /**
   * The Column Qualifier to use when inserting data into HBase
   */
  public final PutHBaseCell setColumnQualifier(final String columnQualifier) {
    properties.put(COLUMN_QUALIFIER_PROPERTY, columnQualifier);
    return this;
  }

  /**
   * The Column Qualifier to use when inserting data into HBase
   */
  public final PutHBaseCell removeColumnQualifier() {
    properties.remove(COLUMN_QUALIFIER_PROPERTY);
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
  public final PutHBaseCell setTimestamp(final String timestamp) {
    properties.put(TIMESTAMP_PROPERTY, timestamp);
    return this;
  }

  /**
   * The timestamp for the cells being created in HBase. This field can be left blank and HBase will use the current time.
   */
  public final PutHBaseCell removeTimestamp() {
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
  public final PutHBaseCell setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * The maximum number of FlowFiles to process in a single execution. The FlowFiles will be grouped by table, and a single Put per table will be performed.
   */
  public final PutHBaseCell removeBatchSize() {
    properties.remove(BATCH_SIZE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutHBaseCell setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutHBaseCell removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<PutHBaseCell, PutHBaseCell> configurator) {
    return configurator.apply(new PutHBaseCell()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutHBaseCell.class) final Closure<PutHBaseCell> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.hbase.PutHBaseCell> code = closure.rehydrate(c, com.tibtech.nifi.hbase.PutHBaseCell.class, com.tibtech.nifi.hbase.PutHBaseCell.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutHBaseCell, PutHBaseCell> configurator) {
    return configurator.apply(new PutHBaseCell(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutHBaseCell.class) final Closure<PutHBaseCell> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.hbase.PutHBaseCell> code = closure.rehydrate(c, com.tibtech.nifi.hbase.PutHBaseCell.class, com.tibtech.nifi.hbase.PutHBaseCell.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
