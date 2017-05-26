package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GenerateTableFetch {
  /**
   * The Controller Service that is used to obtain a connection to the database.
   */
  public static final String DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY = "Database Connection Pooling Service";

  /**
   * The type/flavor of database, used for generating database-specific code. In many cases the Generic type should suffice, but some databases (such as Oracle) require custom SQL clauses. 
   */
  public static final String DB_FETCH_DB_TYPE_PROPERTY = "db-fetch-db-type";

  /**
   * The name of the database table to be queried.
   */
  public static final String TABLE_NAME_PROPERTY = "Table Name";

  /**
   * A comma-separated list of column names to be used in the query. If your database requires special treatment of the names (quoting, e.g.), each name should include such treatment. If no column names are supplied, all columns in the specified table will be returned.
   */
  public static final String COLUMNS_TO_RETURN_PROPERTY = "Columns to Return";

  /**
   * A comma-separated list of column names. The processor will keep track of the maximum value for each column that has been returned since the processor started running. Using multiple columns implies an order to the column list, and each column's values are expected to increase more slowly than the previous columns' values. Thus, using multiple columns implies a hierarchical structure of columns, which is usually used for partitioning tables. This processor can be used to retrieve only those rows that have been added/updated since the last retrieval. Note that some JDBC types such as bit/boolean are not conducive to maintaining maximum value, so columns of these types should not be listed in this property, and will result in error(s) during processing. If no columns are provided, all rows from the table will be considered, which could have a performance impact.
   */
  public static final String MAXIMUM_VALUE_COLUMNS_PROPERTY = "Maximum-value Columns";

  /**
   * The maximum amount of time allowed for a running SQL select query , zero means there is no limit. Max time less than 1 second will be equal to zero.
   */
  public static final String MAX_WAIT_TIME_PROPERTY = "Max Wait Time";

  /**
   * The number of result rows to be fetched by each generated SQL statement. The total number of rows in the table divided by the partition size gives the number of SQL statements (i.e. FlowFiles) generated. A value of zero indicates that a single FlowFile is to be generated whose SQL statement will fetch all rows in the table.
   */
  public static final String GEN_TABLE_FETCH_PARTITION_SIZE_PROPERTY = "gen-table-fetch-partition-size";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The Controller Service that is used to obtain a connection to the database.
   */
  public final String getDatabaseConnectionPoolingService() {
    return properties.get(DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service that is used to obtain a connection to the database.
   */
  public final GenerateTableFetch setDatabaseConnectionPoolingService(final String databaseConnectionPoolingService) {
    properties.put(DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY, databaseConnectionPoolingService);
    return this;
  }

  /**
   * The Controller Service that is used to obtain a connection to the database.
   */
  public final GenerateTableFetch removeDatabaseConnectionPoolingService() {
    properties.remove(DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The type/flavor of database, used for generating database-specific code. In many cases the Generic type should suffice, but some databases (such as Oracle) require custom SQL clauses. 
   */
  public final String getDbFetchDbType() {
    return properties.get(DB_FETCH_DB_TYPE_PROPERTY);
  }

  /**
   * The type/flavor of database, used for generating database-specific code. In many cases the Generic type should suffice, but some databases (such as Oracle) require custom SQL clauses. 
   */
  public final GenerateTableFetch setDbFetchDbType(final String dbFetchDbType) {
    properties.put(DB_FETCH_DB_TYPE_PROPERTY, dbFetchDbType);
    return this;
  }

  /**
   * The type/flavor of database, used for generating database-specific code. In many cases the Generic type should suffice, but some databases (such as Oracle) require custom SQL clauses. 
   */
  public final GenerateTableFetch removeDbFetchDbType() {
    properties.remove(DB_FETCH_DB_TYPE_PROPERTY);
    return this;
  }

  /**
   * The name of the database table to be queried.
   */
  public final String getTableName() {
    return properties.get(TABLE_NAME_PROPERTY);
  }

  /**
   * The name of the database table to be queried.
   */
  public final GenerateTableFetch setTableName(final String tableName) {
    properties.put(TABLE_NAME_PROPERTY, tableName);
    return this;
  }

  /**
   * The name of the database table to be queried.
   */
  public final GenerateTableFetch removeTableName() {
    properties.remove(TABLE_NAME_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of column names to be used in the query. If your database requires special treatment of the names (quoting, e.g.), each name should include such treatment. If no column names are supplied, all columns in the specified table will be returned.
   */
  public final String getColumnsToReturn() {
    return properties.get(COLUMNS_TO_RETURN_PROPERTY);
  }

  /**
   * A comma-separated list of column names to be used in the query. If your database requires special treatment of the names (quoting, e.g.), each name should include such treatment. If no column names are supplied, all columns in the specified table will be returned.
   */
  public final GenerateTableFetch setColumnsToReturn(final String columnsToReturn) {
    properties.put(COLUMNS_TO_RETURN_PROPERTY, columnsToReturn);
    return this;
  }

  /**
   * A comma-separated list of column names to be used in the query. If your database requires special treatment of the names (quoting, e.g.), each name should include such treatment. If no column names are supplied, all columns in the specified table will be returned.
   */
  public final GenerateTableFetch removeColumnsToReturn() {
    properties.remove(COLUMNS_TO_RETURN_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of column names. The processor will keep track of the maximum value for each column that has been returned since the processor started running. Using multiple columns implies an order to the column list, and each column's values are expected to increase more slowly than the previous columns' values. Thus, using multiple columns implies a hierarchical structure of columns, which is usually used for partitioning tables. This processor can be used to retrieve only those rows that have been added/updated since the last retrieval. Note that some JDBC types such as bit/boolean are not conducive to maintaining maximum value, so columns of these types should not be listed in this property, and will result in error(s) during processing. If no columns are provided, all rows from the table will be considered, which could have a performance impact.
   */
  public final String getMaximumValueColumns() {
    return properties.get(MAXIMUM_VALUE_COLUMNS_PROPERTY);
  }

  /**
   * A comma-separated list of column names. The processor will keep track of the maximum value for each column that has been returned since the processor started running. Using multiple columns implies an order to the column list, and each column's values are expected to increase more slowly than the previous columns' values. Thus, using multiple columns implies a hierarchical structure of columns, which is usually used for partitioning tables. This processor can be used to retrieve only those rows that have been added/updated since the last retrieval. Note that some JDBC types such as bit/boolean are not conducive to maintaining maximum value, so columns of these types should not be listed in this property, and will result in error(s) during processing. If no columns are provided, all rows from the table will be considered, which could have a performance impact.
   */
  public final GenerateTableFetch setMaximumValueColumns(final String maximumValueColumns) {
    properties.put(MAXIMUM_VALUE_COLUMNS_PROPERTY, maximumValueColumns);
    return this;
  }

  /**
   * A comma-separated list of column names. The processor will keep track of the maximum value for each column that has been returned since the processor started running. Using multiple columns implies an order to the column list, and each column's values are expected to increase more slowly than the previous columns' values. Thus, using multiple columns implies a hierarchical structure of columns, which is usually used for partitioning tables. This processor can be used to retrieve only those rows that have been added/updated since the last retrieval. Note that some JDBC types such as bit/boolean are not conducive to maintaining maximum value, so columns of these types should not be listed in this property, and will result in error(s) during processing. If no columns are provided, all rows from the table will be considered, which could have a performance impact.
   */
  public final GenerateTableFetch removeMaximumValueColumns() {
    properties.remove(MAXIMUM_VALUE_COLUMNS_PROPERTY);
    return this;
  }

  /**
   * The maximum amount of time allowed for a running SQL select query , zero means there is no limit. Max time less than 1 second will be equal to zero.
   */
  public final String getMaxWaitTime() {
    return properties.get(MAX_WAIT_TIME_PROPERTY);
  }

  /**
   * The maximum amount of time allowed for a running SQL select query , zero means there is no limit. Max time less than 1 second will be equal to zero.
   */
  public final GenerateTableFetch setMaxWaitTime(final String maxWaitTime) {
    properties.put(MAX_WAIT_TIME_PROPERTY, maxWaitTime);
    return this;
  }

  /**
   * The maximum amount of time allowed for a running SQL select query , zero means there is no limit. Max time less than 1 second will be equal to zero.
   */
  public final GenerateTableFetch removeMaxWaitTime() {
    properties.remove(MAX_WAIT_TIME_PROPERTY);
    return this;
  }

  /**
   * The number of result rows to be fetched by each generated SQL statement. The total number of rows in the table divided by the partition size gives the number of SQL statements (i.e. FlowFiles) generated. A value of zero indicates that a single FlowFile is to be generated whose SQL statement will fetch all rows in the table.
   */
  public final String getGenTableFetchPartitionSize() {
    return properties.get(GEN_TABLE_FETCH_PARTITION_SIZE_PROPERTY);
  }

  /**
   * The number of result rows to be fetched by each generated SQL statement. The total number of rows in the table divided by the partition size gives the number of SQL statements (i.e. FlowFiles) generated. A value of zero indicates that a single FlowFile is to be generated whose SQL statement will fetch all rows in the table.
   */
  public final GenerateTableFetch setGenTableFetchPartitionSize(final String genTableFetchPartitionSize) {
    properties.put(GEN_TABLE_FETCH_PARTITION_SIZE_PROPERTY, genTableFetchPartitionSize);
    return this;
  }

  /**
   * The number of result rows to be fetched by each generated SQL statement. The total number of rows in the table divided by the partition size gives the number of SQL statements (i.e. FlowFiles) generated. A value of zero indicates that a single FlowFile is to be generated whose SQL statement will fetch all rows in the table.
   */
  public final GenerateTableFetch removeGenTableFetchPartitionSize() {
    properties.remove(GEN_TABLE_FETCH_PARTITION_SIZE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GenerateTableFetch setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GenerateTableFetch removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<GenerateTableFetch, GenerateTableFetch> configurator) {
    return configurator.apply(new GenerateTableFetch()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GenerateTableFetch.class) final Closure<GenerateTableFetch> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.GenerateTableFetch> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.GenerateTableFetch.class, com.tibtech.nifi.processors.standard.GenerateTableFetch.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
