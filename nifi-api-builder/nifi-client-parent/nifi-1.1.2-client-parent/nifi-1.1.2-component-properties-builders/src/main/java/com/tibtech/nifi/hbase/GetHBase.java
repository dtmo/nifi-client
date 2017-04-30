package com.tibtech.nifi.hbase;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GetHBase {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.hbase.GetHBase";

  /**
   * Specifies the Controller Service to use for accessing HBase.
   */
  public static final String H_BASE_CLIENT_SERVICE_PROPERTY = "HBase Client Service";

  /**
   * Specifies the Controller Service that should be used to maintain state about what has been pulled from HBase so that if a new node begins pulling data, it won't duplicate all of the work that has been done.
   */
  public static final String DISTRIBUTED_CACHE_SERVICE_PROPERTY = "Distributed Cache Service";

  /**
   * The name of the HBase Table to put data into
   */
  public static final String TABLE_NAME_PROPERTY = "Table Name";

  /**
   * A comma-separated list of "<colFamily>:<colQualifier>" pairs to return when scanning. To return all columns for a given family, leave off the qualifier such as "<colFamily1>,<colFamily2>".
   */
  public static final String COLUMNS_PROPERTY = "Columns";

  /**
   * An HBase filter expression that will be applied to the scan. This property can not be used when also using the Columns property.
   */
  public static final String FILTER_EXPRESSION_PROPERTY = "Filter Expression";

  /**
   * The time range to use on the first scan of a table. None will pull the entire table on the first scan, Current Time will pull entries from that point forward.
   */
  public static final String INITIAL_TIME_RANGE_PROPERTY = "Initial Time Range";

  /**
   * Specifies which character set is used to encode the data in HBase
   */
  public static final String CHARACTER_SET_PROPERTY = "Character Set";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Specifies the Controller Service to use for accessing HBase.
   */
  public final String getHBaseClientService() {
    return properties.get(H_BASE_CLIENT_SERVICE_PROPERTY);
  }

  /**
   * Specifies the Controller Service to use for accessing HBase.
   */
  public final GetHBase setHBaseClientService(final String hBaseClientService) {
    properties.put(H_BASE_CLIENT_SERVICE_PROPERTY, hBaseClientService);
    return this;
  }

  /**
   * Specifies the Controller Service to use for accessing HBase.
   */
  public final GetHBase removeHBaseClientService() {
    properties.remove(H_BASE_CLIENT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Specifies the Controller Service that should be used to maintain state about what has been pulled from HBase so that if a new node begins pulling data, it won't duplicate all of the work that has been done.
   */
  public final String getDistributedCacheService() {
    return properties.get(DISTRIBUTED_CACHE_SERVICE_PROPERTY);
  }

  /**
   * Specifies the Controller Service that should be used to maintain state about what has been pulled from HBase so that if a new node begins pulling data, it won't duplicate all of the work that has been done.
   */
  public final GetHBase setDistributedCacheService(final String distributedCacheService) {
    properties.put(DISTRIBUTED_CACHE_SERVICE_PROPERTY, distributedCacheService);
    return this;
  }

  /**
   * Specifies the Controller Service that should be used to maintain state about what has been pulled from HBase so that if a new node begins pulling data, it won't duplicate all of the work that has been done.
   */
  public final GetHBase removeDistributedCacheService() {
    properties.remove(DISTRIBUTED_CACHE_SERVICE_PROPERTY);
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
  public final GetHBase setTableName(final String tableName) {
    properties.put(TABLE_NAME_PROPERTY, tableName);
    return this;
  }

  /**
   * The name of the HBase Table to put data into
   */
  public final GetHBase removeTableName() {
    properties.remove(TABLE_NAME_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of "<colFamily>:<colQualifier>" pairs to return when scanning. To return all columns for a given family, leave off the qualifier such as "<colFamily1>,<colFamily2>".
   */
  public final String getColumns() {
    return properties.get(COLUMNS_PROPERTY);
  }

  /**
   * A comma-separated list of "<colFamily>:<colQualifier>" pairs to return when scanning. To return all columns for a given family, leave off the qualifier such as "<colFamily1>,<colFamily2>".
   */
  public final GetHBase setColumns(final String columns) {
    properties.put(COLUMNS_PROPERTY, columns);
    return this;
  }

  /**
   * A comma-separated list of "<colFamily>:<colQualifier>" pairs to return when scanning. To return all columns for a given family, leave off the qualifier such as "<colFamily1>,<colFamily2>".
   */
  public final GetHBase removeColumns() {
    properties.remove(COLUMNS_PROPERTY);
    return this;
  }

  /**
   * An HBase filter expression that will be applied to the scan. This property can not be used when also using the Columns property.
   */
  public final String getFilterExpression() {
    return properties.get(FILTER_EXPRESSION_PROPERTY);
  }

  /**
   * An HBase filter expression that will be applied to the scan. This property can not be used when also using the Columns property.
   */
  public final GetHBase setFilterExpression(final String filterExpression) {
    properties.put(FILTER_EXPRESSION_PROPERTY, filterExpression);
    return this;
  }

  /**
   * An HBase filter expression that will be applied to the scan. This property can not be used when also using the Columns property.
   */
  public final GetHBase removeFilterExpression() {
    properties.remove(FILTER_EXPRESSION_PROPERTY);
    return this;
  }

  /**
   * The time range to use on the first scan of a table. None will pull the entire table on the first scan, Current Time will pull entries from that point forward.
   */
  public final String getInitialTimeRange() {
    return properties.get(INITIAL_TIME_RANGE_PROPERTY);
  }

  /**
   * The time range to use on the first scan of a table. None will pull the entire table on the first scan, Current Time will pull entries from that point forward.
   */
  public final GetHBase setInitialTimeRange(final String initialTimeRange) {
    properties.put(INITIAL_TIME_RANGE_PROPERTY, initialTimeRange);
    return this;
  }

  /**
   * The time range to use on the first scan of a table. None will pull the entire table on the first scan, Current Time will pull entries from that point forward.
   */
  public final GetHBase removeInitialTimeRange() {
    properties.remove(INITIAL_TIME_RANGE_PROPERTY);
    return this;
  }

  /**
   * Specifies which character set is used to encode the data in HBase
   */
  public final String getCharacterSet() {
    return properties.get(CHARACTER_SET_PROPERTY);
  }

  /**
   * Specifies which character set is used to encode the data in HBase
   */
  public final GetHBase setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * Specifies which character set is used to encode the data in HBase
   */
  public final GetHBase removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GetHBase setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GetHBase removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<GetHBase, GetHBase> configurator) {
    return configurator.apply(new GetHBase()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetHBase.class) final Closure<GetHBase> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.hbase.GetHBase> code = closure.rehydrate(c, com.tibtech.nifi.hbase.GetHBase.class, com.tibtech.nifi.hbase.GetHBase.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
