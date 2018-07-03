package com.tibtech.nifi.hbase;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class DeleteHBaseRow {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.hbase.DeleteHBaseRow";

  /**
   * Specifies the Controller Service to use for accessing HBase.
   */
  public static final String H_BASE_CLIENT_SERVICE_PROPERTY = "HBase Client Service";

  /**
   * The name of the HBase Table.
   */
  public static final String TABLE_NAME_PROPERTY = "Table Name";

  /**
   * Specifies the Row ID to use when deleting data into HBase
   */
  public static final String ROW_IDENTIFIER_PROPERTY = "Row Identifier";

  /**
   * The location of the row ID to use for building the delete. Can be from the content or an expression language statement.
   */
  public static final String DELETE_HB_ROW_ID_LOCATION_PROPERTY = "delete-hb-row-id-location";

  /**
   * The number of flowfiles to fetch per run.
   */
  public static final String DELETE_HB_FLOWFILE_FETCH_COUNT_PROPERTY = "delete-hb-flowfile-fetch-count";

  /**
   * The number of deletes to send per batch.
   */
  public static final String DELETE_HB_BATCH_SIZE_PROPERTY = "delete-hb-batch-size";

  /**
   * The separator character(s) that separate multiple row keys when multiple row keys are provided in the flowfile content
   */
  public static final String DELETE_HB_SEPARATOR_PROPERTY = "delete-hb-separator";

  /**
   * If visibility labels are enabled, a row cannot be deleted without supplying its visibility label(s) in the delete request. Note: this visibility label will be applied to all cells within the row that is specified. If some cells have different visibility labels, they will not be deleted. When that happens, the failure to delete will be considered a success because HBase does not report it as a failure.
   */
  public static final String DELETE_VISIBILITY_LABEL_PROPERTY = "delete-visibility-label";

  /**
   * The character set used to encode the row key for HBase.
   */
  public static final String DELETE_CHAR_SET_PROPERTY = "delete-char-set";

  private final Map<String, String> properties;

  public DeleteHBaseRow() {
    this.properties = new HashMap<>();
  }

  public DeleteHBaseRow(final Map<String, String> properties) {
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
  public final DeleteHBaseRow setHBaseClientService(final String hBaseClientService) {
    properties.put(H_BASE_CLIENT_SERVICE_PROPERTY, hBaseClientService);
    return this;
  }

  /**
   * Specifies the Controller Service to use for accessing HBase.
   */
  public final DeleteHBaseRow removeHBaseClientService() {
    properties.remove(H_BASE_CLIENT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The name of the HBase Table.
   */
  public final String getTableName() {
    return properties.get(TABLE_NAME_PROPERTY);
  }

  /**
   * The name of the HBase Table.
   */
  public final DeleteHBaseRow setTableName(final String tableName) {
    properties.put(TABLE_NAME_PROPERTY, tableName);
    return this;
  }

  /**
   * The name of the HBase Table.
   */
  public final DeleteHBaseRow removeTableName() {
    properties.remove(TABLE_NAME_PROPERTY);
    return this;
  }

  /**
   * Specifies the Row ID to use when deleting data into HBase
   */
  public final String getRowIdentifier() {
    return properties.get(ROW_IDENTIFIER_PROPERTY);
  }

  /**
   * Specifies the Row ID to use when deleting data into HBase
   */
  public final DeleteHBaseRow setRowIdentifier(final String rowIdentifier) {
    properties.put(ROW_IDENTIFIER_PROPERTY, rowIdentifier);
    return this;
  }

  /**
   * Specifies the Row ID to use when deleting data into HBase
   */
  public final DeleteHBaseRow removeRowIdentifier() {
    properties.remove(ROW_IDENTIFIER_PROPERTY);
    return this;
  }

  /**
   * The location of the row ID to use for building the delete. Can be from the content or an expression language statement.
   */
  public final String getDeleteHbRowIdLocation() {
    return properties.get(DELETE_HB_ROW_ID_LOCATION_PROPERTY);
  }

  /**
   * The location of the row ID to use for building the delete. Can be from the content or an expression language statement.
   */
  public final DeleteHBaseRow setDeleteHbRowIdLocation(final String deleteHbRowIdLocation) {
    properties.put(DELETE_HB_ROW_ID_LOCATION_PROPERTY, deleteHbRowIdLocation);
    return this;
  }

  /**
   * The location of the row ID to use for building the delete. Can be from the content or an expression language statement.
   */
  public final DeleteHBaseRow removeDeleteHbRowIdLocation() {
    properties.remove(DELETE_HB_ROW_ID_LOCATION_PROPERTY);
    return this;
  }

  /**
   * The number of flowfiles to fetch per run.
   */
  public final String getDeleteHbFlowfileFetchCount() {
    return properties.get(DELETE_HB_FLOWFILE_FETCH_COUNT_PROPERTY);
  }

  /**
   * The number of flowfiles to fetch per run.
   */
  public final DeleteHBaseRow setDeleteHbFlowfileFetchCount(
      final String deleteHbFlowfileFetchCount) {
    properties.put(DELETE_HB_FLOWFILE_FETCH_COUNT_PROPERTY, deleteHbFlowfileFetchCount);
    return this;
  }

  /**
   * The number of flowfiles to fetch per run.
   */
  public final DeleteHBaseRow removeDeleteHbFlowfileFetchCount() {
    properties.remove(DELETE_HB_FLOWFILE_FETCH_COUNT_PROPERTY);
    return this;
  }

  /**
   * The number of deletes to send per batch.
   */
  public final String getDeleteHbBatchSize() {
    return properties.get(DELETE_HB_BATCH_SIZE_PROPERTY);
  }

  /**
   * The number of deletes to send per batch.
   */
  public final DeleteHBaseRow setDeleteHbBatchSize(final String deleteHbBatchSize) {
    properties.put(DELETE_HB_BATCH_SIZE_PROPERTY, deleteHbBatchSize);
    return this;
  }

  /**
   * The number of deletes to send per batch.
   */
  public final DeleteHBaseRow removeDeleteHbBatchSize() {
    properties.remove(DELETE_HB_BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * The separator character(s) that separate multiple row keys when multiple row keys are provided in the flowfile content
   */
  public final String getDeleteHbSeparator() {
    return properties.get(DELETE_HB_SEPARATOR_PROPERTY);
  }

  /**
   * The separator character(s) that separate multiple row keys when multiple row keys are provided in the flowfile content
   */
  public final DeleteHBaseRow setDeleteHbSeparator(final String deleteHbSeparator) {
    properties.put(DELETE_HB_SEPARATOR_PROPERTY, deleteHbSeparator);
    return this;
  }

  /**
   * The separator character(s) that separate multiple row keys when multiple row keys are provided in the flowfile content
   */
  public final DeleteHBaseRow removeDeleteHbSeparator() {
    properties.remove(DELETE_HB_SEPARATOR_PROPERTY);
    return this;
  }

  /**
   * If visibility labels are enabled, a row cannot be deleted without supplying its visibility label(s) in the delete request. Note: this visibility label will be applied to all cells within the row that is specified. If some cells have different visibility labels, they will not be deleted. When that happens, the failure to delete will be considered a success because HBase does not report it as a failure.
   */
  public final String getDeleteVisibilityLabel() {
    return properties.get(DELETE_VISIBILITY_LABEL_PROPERTY);
  }

  /**
   * If visibility labels are enabled, a row cannot be deleted without supplying its visibility label(s) in the delete request. Note: this visibility label will be applied to all cells within the row that is specified. If some cells have different visibility labels, they will not be deleted. When that happens, the failure to delete will be considered a success because HBase does not report it as a failure.
   */
  public final DeleteHBaseRow setDeleteVisibilityLabel(final String deleteVisibilityLabel) {
    properties.put(DELETE_VISIBILITY_LABEL_PROPERTY, deleteVisibilityLabel);
    return this;
  }

  /**
   * If visibility labels are enabled, a row cannot be deleted without supplying its visibility label(s) in the delete request. Note: this visibility label will be applied to all cells within the row that is specified. If some cells have different visibility labels, they will not be deleted. When that happens, the failure to delete will be considered a success because HBase does not report it as a failure.
   */
  public final DeleteHBaseRow removeDeleteVisibilityLabel() {
    properties.remove(DELETE_VISIBILITY_LABEL_PROPERTY);
    return this;
  }

  /**
   * The character set used to encode the row key for HBase.
   */
  public final String getDeleteCharSet() {
    return properties.get(DELETE_CHAR_SET_PROPERTY);
  }

  /**
   * The character set used to encode the row key for HBase.
   */
  public final DeleteHBaseRow setDeleteCharSet(final String deleteCharSet) {
    properties.put(DELETE_CHAR_SET_PROPERTY, deleteCharSet);
    return this;
  }

  /**
   * The character set used to encode the row key for HBase.
   */
  public final DeleteHBaseRow removeDeleteCharSet() {
    properties.remove(DELETE_CHAR_SET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final DeleteHBaseRow setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final DeleteHBaseRow removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<DeleteHBaseRow, DeleteHBaseRow> configurator) {
    return configurator.apply(new DeleteHBaseRow()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DeleteHBaseRow.class) final Closure<DeleteHBaseRow> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.hbase.DeleteHBaseRow> code = closure.rehydrate(c, com.tibtech.nifi.hbase.DeleteHBaseRow.class, com.tibtech.nifi.hbase.DeleteHBaseRow.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<DeleteHBaseRow, DeleteHBaseRow> configurator) {
    return configurator.apply(new DeleteHBaseRow(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DeleteHBaseRow.class) final Closure<DeleteHBaseRow> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.hbase.DeleteHBaseRow> code = closure.rehydrate(c, com.tibtech.nifi.hbase.DeleteHBaseRow.class, com.tibtech.nifi.hbase.DeleteHBaseRow.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
