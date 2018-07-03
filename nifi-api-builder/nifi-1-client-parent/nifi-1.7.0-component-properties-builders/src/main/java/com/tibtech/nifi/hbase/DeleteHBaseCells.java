package com.tibtech.nifi.hbase;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class DeleteHBaseCells {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.hbase.DeleteHBaseCells";

  /**
   * Specifies the Controller Service to use for accessing HBase.
   */
  public static final String H_BASE_CLIENT_SERVICE_PROPERTY = "HBase Client Service";

  /**
   * The name of the HBase Table.
   */
  public static final String TABLE_NAME_PROPERTY = "Table Name";

  /**
   * Each line of the flowfile content is separated into components for building a delete using thisseparator. It should be something other than a single colon or a comma because these are values that are associated with columns and visibility labels respectively. To delete a row with ID xyz, column family abc, column qualifier def and visibility label PII&PHI, one would specify xyz::::abc::::def::::PII&PHI given the default value
   */
  public static final String DELETE_HBASE_CELL_SEPARATOR_PROPERTY = "delete-hbase-cell-separator";

  private final Map<String, String> properties;

  public DeleteHBaseCells() {
    this.properties = new HashMap<>();
  }

  public DeleteHBaseCells(final Map<String, String> properties) {
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
  public final DeleteHBaseCells setHBaseClientService(final String hBaseClientService) {
    properties.put(H_BASE_CLIENT_SERVICE_PROPERTY, hBaseClientService);
    return this;
  }

  /**
   * Specifies the Controller Service to use for accessing HBase.
   */
  public final DeleteHBaseCells removeHBaseClientService() {
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
  public final DeleteHBaseCells setTableName(final String tableName) {
    properties.put(TABLE_NAME_PROPERTY, tableName);
    return this;
  }

  /**
   * The name of the HBase Table.
   */
  public final DeleteHBaseCells removeTableName() {
    properties.remove(TABLE_NAME_PROPERTY);
    return this;
  }

  /**
   * Each line of the flowfile content is separated into components for building a delete using thisseparator. It should be something other than a single colon or a comma because these are values that are associated with columns and visibility labels respectively. To delete a row with ID xyz, column family abc, column qualifier def and visibility label PII&PHI, one would specify xyz::::abc::::def::::PII&PHI given the default value
   */
  public final String getDeleteHbaseCellSeparator() {
    return properties.get(DELETE_HBASE_CELL_SEPARATOR_PROPERTY);
  }

  /**
   * Each line of the flowfile content is separated into components for building a delete using thisseparator. It should be something other than a single colon or a comma because these are values that are associated with columns and visibility labels respectively. To delete a row with ID xyz, column family abc, column qualifier def and visibility label PII&PHI, one would specify xyz::::abc::::def::::PII&PHI given the default value
   */
  public final DeleteHBaseCells setDeleteHbaseCellSeparator(final String deleteHbaseCellSeparator) {
    properties.put(DELETE_HBASE_CELL_SEPARATOR_PROPERTY, deleteHbaseCellSeparator);
    return this;
  }

  /**
   * Each line of the flowfile content is separated into components for building a delete using thisseparator. It should be something other than a single colon or a comma because these are values that are associated with columns and visibility labels respectively. To delete a row with ID xyz, column family abc, column qualifier def and visibility label PII&PHI, one would specify xyz::::abc::::def::::PII&PHI given the default value
   */
  public final DeleteHBaseCells removeDeleteHbaseCellSeparator() {
    properties.remove(DELETE_HBASE_CELL_SEPARATOR_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final DeleteHBaseCells setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final DeleteHBaseCells removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<DeleteHBaseCells, DeleteHBaseCells> configurator) {
    return configurator.apply(new DeleteHBaseCells()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DeleteHBaseCells.class) final Closure<DeleteHBaseCells> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.hbase.DeleteHBaseCells> code = closure.rehydrate(c, com.tibtech.nifi.hbase.DeleteHBaseCells.class, com.tibtech.nifi.hbase.DeleteHBaseCells.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<DeleteHBaseCells, DeleteHBaseCells> configurator) {
    return configurator.apply(new DeleteHBaseCells(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DeleteHBaseCells.class) final Closure<DeleteHBaseCells> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.hbase.DeleteHBaseCells> code = closure.rehydrate(c, com.tibtech.nifi.hbase.DeleteHBaseCells.class, com.tibtech.nifi.hbase.DeleteHBaseCells.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
