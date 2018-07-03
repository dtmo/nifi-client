package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class QueryDatabaseTable {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.QueryDatabaseTable";

  /**
   * The Controller Service that is used to obtain a connection to the database.
   */
  public static final String DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY = "Database Connection Pooling Service";

  /**
   * The type/flavor of database, used for generating database-specific code. In many cases the Generic type should suffice, but some databases (such as Oracle) require custom SQL clauses. 
   */
  public static final String DB_FETCH_DB_TYPE_PROPERTY = "db-fetch-db-type";

  /**
   * The name of the database table to be queried. When a custom query is used, this property is used to alias the query and appears as an attribute on the FlowFile.
   */
  public static final String TABLE_NAME_PROPERTY = "Table Name";

  /**
   * A comma-separated list of column names to be used in the query. If your database requires special treatment of the names (quoting, e.g.), each name should include such treatment. If no column names are supplied, all columns in the specified table will be returned. NOTE: It is important to use consistent column names for a given table for incremental fetch to work properly.
   */
  public static final String COLUMNS_TO_RETURN_PROPERTY = "Columns to Return";

  /**
   * A custom clause to be added in the WHERE condition when building SQL queries.
   */
  public static final String DB_FETCH_WHERE_CLAUSE_PROPERTY = "db-fetch-where-clause";

  /**
   * A custom SQL query used to retrieve data. Instead of building a SQL query from other properties, this query will be wrapped as a sub-query. Query must have no ORDER BY statement.
   */
  public static final String DB_FETCH_SQL_QUERY_PROPERTY = "db-fetch-sql-query";

  /**
   * A comma-separated list of column names. The processor will keep track of the maximum value for each column that has been returned since the processor started running. Using multiple columns implies an order to the column list, and each column's values are expected to increase more slowly than the previous columns' values. Thus, using multiple columns implies a hierarchical structure of columns, which is usually used for partitioning tables. This processor can be used to retrieve only those rows that have been added/updated since the last retrieval. Note that some JDBC types such as bit/boolean are not conducive to maintaining maximum value, so columns of these types should not be listed in this property, and will result in error(s) during processing. If no columns are provided, all rows from the table will be considered, which could have a performance impact. NOTE: It is important to use consistent max-value column names for a given table for incremental fetch to work properly.
   */
  public static final String MAXIMUM_VALUE_COLUMNS_PROPERTY = "Maximum-value Columns";

  /**
   * The maximum amount of time allowed for a running SQL select query , zero means there is no limit. Max time less than 1 second will be equal to zero.
   */
  public static final String MAX_WAIT_TIME_PROPERTY = "Max Wait Time";

  /**
   * The number of result rows to be fetched from the result set at a time. This is a hint to the database driver and may not be honored and/or exact. If the value specified is zero, then the hint is ignored.
   */
  public static final String FETCH_SIZE_PROPERTY = "Fetch Size";

  /**
   * The maximum number of result rows that will be included in a single FlowFile. This will allow you to break up very large result sets into multiple FlowFiles. If the value specified is zero, then all rows are returned in a single FlowFile.
   */
  public static final String QDBT_MAX_ROWS_PROPERTY = "qdbt-max-rows";

  /**
   * The number of output FlowFiles to queue before committing the process session. When set to zero, the session will be committed when all result set rows have been processed and the output FlowFiles are ready for transfer to the downstream relationship. For large result sets, this can cause a large burst of FlowFiles to be transferred at the end of processor execution. If this property is set, then when the specified number of FlowFiles are ready for transfer, then the session will be committed, thus releasing the FlowFiles to the downstream relationship. NOTE: The maxvalue.* and fragment.count attributes will not be set on FlowFiles when this property is set.
   */
  public static final String QDBT_OUTPUT_BATCH_SIZE_PROPERTY = "qdbt-output-batch-size";

  /**
   * The maximum number of fragments. If the value specified is zero, then all fragments are returned. This prevents OutOfMemoryError when this processor ingests huge table. NOTE: Setting this property can result in data loss, as the incoming results are not ordered, and fragments may end at arbitrary boundaries where rows are not included in the result set.
   */
  public static final String QDBT_MAX_FRAGS_PROPERTY = "qdbt-max-frags";

  /**
   * Whether to change non-Avro-compatible characters in column names to Avro-compatible characters. For example, colons and periods will be changed to underscores in order to build a valid Avro record.
   */
  public static final String DBF_NORMALIZE_PROPERTY = "dbf-normalize";

  /**
   * Whether to use Avro Logical Types for DECIMAL/NUMBER, DATE, TIME and TIMESTAMP columns. If disabled, written as string. If enabled, Logical types are used and written as its underlying type, specifically, DECIMAL/NUMBER as logical 'decimal': written as bytes with additional precision and scale meta data, DATE as logical 'date-millis': written as int denoting days since Unix epoch (1970-01-01), TIME as logical 'time-millis': written as int denoting milliseconds since Unix epoch, and TIMESTAMP as logical 'timestamp-millis': written as long denoting milliseconds since Unix epoch. If a reader of written Avro records also knows these logical types, then these values can be deserialized with more context depending on reader implementation.
   */
  public static final String DBF_USER_LOGICAL_TYPES_PROPERTY = "dbf-user-logical-types";

  /**
   * When a DECIMAL/NUMBER value is written as a 'decimal' Avro logical type, a specific 'precision' denoting number of available digits is required. Generally, precision is defined by column data type definition or database engines default. However undefined precision (0) can be returned from some database engines. 'Default Decimal Precision' is used when writing those undefined precision numbers.
   */
  public static final String DBF_DEFAULT_PRECISION_PROPERTY = "dbf-default-precision";

  /**
   * When a DECIMAL/NUMBER value is written as a 'decimal' Avro logical type, a specific 'scale' denoting number of available decimal digits is required. Generally, scale is defined by column data type definition or database engines default. However when undefined precision (0) is returned, scale can also be uncertain with some database engines. 'Default Decimal Scale' is used when writing those undefined numbers. If a value has more decimals than specified scale, then the value will be rounded-up, e.g. 1.53 becomes 2 with scale 0, and 1.5 with scale 1.
   */
  public static final String DBF_DEFAULT_SCALE_PROPERTY = "dbf-default-scale";

  private final Map<String, String> properties;

  public QueryDatabaseTable() {
    this.properties = new HashMap<>();
  }

  public QueryDatabaseTable(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The Controller Service that is used to obtain a connection to the database.
   */
  public final String getDatabaseConnectionPoolingService() {
    return properties.get(DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service that is used to obtain a connection to the database.
   */
  public final QueryDatabaseTable setDatabaseConnectionPoolingService(
      final String databaseConnectionPoolingService) {
    properties.put(DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY, databaseConnectionPoolingService);
    return this;
  }

  /**
   * The Controller Service that is used to obtain a connection to the database.
   */
  public final QueryDatabaseTable removeDatabaseConnectionPoolingService() {
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
  public final QueryDatabaseTable setDbFetchDbType(final String dbFetchDbType) {
    properties.put(DB_FETCH_DB_TYPE_PROPERTY, dbFetchDbType);
    return this;
  }

  /**
   * The type/flavor of database, used for generating database-specific code. In many cases the Generic type should suffice, but some databases (such as Oracle) require custom SQL clauses. 
   */
  public final QueryDatabaseTable removeDbFetchDbType() {
    properties.remove(DB_FETCH_DB_TYPE_PROPERTY);
    return this;
  }

  /**
   * The name of the database table to be queried. When a custom query is used, this property is used to alias the query and appears as an attribute on the FlowFile.
   */
  public final String getTableName() {
    return properties.get(TABLE_NAME_PROPERTY);
  }

  /**
   * The name of the database table to be queried. When a custom query is used, this property is used to alias the query and appears as an attribute on the FlowFile.
   */
  public final QueryDatabaseTable setTableName(final String tableName) {
    properties.put(TABLE_NAME_PROPERTY, tableName);
    return this;
  }

  /**
   * The name of the database table to be queried. When a custom query is used, this property is used to alias the query and appears as an attribute on the FlowFile.
   */
  public final QueryDatabaseTable removeTableName() {
    properties.remove(TABLE_NAME_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of column names to be used in the query. If your database requires special treatment of the names (quoting, e.g.), each name should include such treatment. If no column names are supplied, all columns in the specified table will be returned. NOTE: It is important to use consistent column names for a given table for incremental fetch to work properly.
   */
  public final String getColumnsToReturn() {
    return properties.get(COLUMNS_TO_RETURN_PROPERTY);
  }

  /**
   * A comma-separated list of column names to be used in the query. If your database requires special treatment of the names (quoting, e.g.), each name should include such treatment. If no column names are supplied, all columns in the specified table will be returned. NOTE: It is important to use consistent column names for a given table for incremental fetch to work properly.
   */
  public final QueryDatabaseTable setColumnsToReturn(final String columnsToReturn) {
    properties.put(COLUMNS_TO_RETURN_PROPERTY, columnsToReturn);
    return this;
  }

  /**
   * A comma-separated list of column names to be used in the query. If your database requires special treatment of the names (quoting, e.g.), each name should include such treatment. If no column names are supplied, all columns in the specified table will be returned. NOTE: It is important to use consistent column names for a given table for incremental fetch to work properly.
   */
  public final QueryDatabaseTable removeColumnsToReturn() {
    properties.remove(COLUMNS_TO_RETURN_PROPERTY);
    return this;
  }

  /**
   * A custom clause to be added in the WHERE condition when building SQL queries.
   */
  public final String getDbFetchWhereClause() {
    return properties.get(DB_FETCH_WHERE_CLAUSE_PROPERTY);
  }

  /**
   * A custom clause to be added in the WHERE condition when building SQL queries.
   */
  public final QueryDatabaseTable setDbFetchWhereClause(final String dbFetchWhereClause) {
    properties.put(DB_FETCH_WHERE_CLAUSE_PROPERTY, dbFetchWhereClause);
    return this;
  }

  /**
   * A custom clause to be added in the WHERE condition when building SQL queries.
   */
  public final QueryDatabaseTable removeDbFetchWhereClause() {
    properties.remove(DB_FETCH_WHERE_CLAUSE_PROPERTY);
    return this;
  }

  /**
   * A custom SQL query used to retrieve data. Instead of building a SQL query from other properties, this query will be wrapped as a sub-query. Query must have no ORDER BY statement.
   */
  public final String getDbFetchSqlQuery() {
    return properties.get(DB_FETCH_SQL_QUERY_PROPERTY);
  }

  /**
   * A custom SQL query used to retrieve data. Instead of building a SQL query from other properties, this query will be wrapped as a sub-query. Query must have no ORDER BY statement.
   */
  public final QueryDatabaseTable setDbFetchSqlQuery(final String dbFetchSqlQuery) {
    properties.put(DB_FETCH_SQL_QUERY_PROPERTY, dbFetchSqlQuery);
    return this;
  }

  /**
   * A custom SQL query used to retrieve data. Instead of building a SQL query from other properties, this query will be wrapped as a sub-query. Query must have no ORDER BY statement.
   */
  public final QueryDatabaseTable removeDbFetchSqlQuery() {
    properties.remove(DB_FETCH_SQL_QUERY_PROPERTY);
    return this;
  }

  /**
   * A comma-separated list of column names. The processor will keep track of the maximum value for each column that has been returned since the processor started running. Using multiple columns implies an order to the column list, and each column's values are expected to increase more slowly than the previous columns' values. Thus, using multiple columns implies a hierarchical structure of columns, which is usually used for partitioning tables. This processor can be used to retrieve only those rows that have been added/updated since the last retrieval. Note that some JDBC types such as bit/boolean are not conducive to maintaining maximum value, so columns of these types should not be listed in this property, and will result in error(s) during processing. If no columns are provided, all rows from the table will be considered, which could have a performance impact. NOTE: It is important to use consistent max-value column names for a given table for incremental fetch to work properly.
   */
  public final String getMaximumValueColumns() {
    return properties.get(MAXIMUM_VALUE_COLUMNS_PROPERTY);
  }

  /**
   * A comma-separated list of column names. The processor will keep track of the maximum value for each column that has been returned since the processor started running. Using multiple columns implies an order to the column list, and each column's values are expected to increase more slowly than the previous columns' values. Thus, using multiple columns implies a hierarchical structure of columns, which is usually used for partitioning tables. This processor can be used to retrieve only those rows that have been added/updated since the last retrieval. Note that some JDBC types such as bit/boolean are not conducive to maintaining maximum value, so columns of these types should not be listed in this property, and will result in error(s) during processing. If no columns are provided, all rows from the table will be considered, which could have a performance impact. NOTE: It is important to use consistent max-value column names for a given table for incremental fetch to work properly.
   */
  public final QueryDatabaseTable setMaximumValueColumns(final String maximumValueColumns) {
    properties.put(MAXIMUM_VALUE_COLUMNS_PROPERTY, maximumValueColumns);
    return this;
  }

  /**
   * A comma-separated list of column names. The processor will keep track of the maximum value for each column that has been returned since the processor started running. Using multiple columns implies an order to the column list, and each column's values are expected to increase more slowly than the previous columns' values. Thus, using multiple columns implies a hierarchical structure of columns, which is usually used for partitioning tables. This processor can be used to retrieve only those rows that have been added/updated since the last retrieval. Note that some JDBC types such as bit/boolean are not conducive to maintaining maximum value, so columns of these types should not be listed in this property, and will result in error(s) during processing. If no columns are provided, all rows from the table will be considered, which could have a performance impact. NOTE: It is important to use consistent max-value column names for a given table for incremental fetch to work properly.
   */
  public final QueryDatabaseTable removeMaximumValueColumns() {
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
  public final QueryDatabaseTable setMaxWaitTime(final String maxWaitTime) {
    properties.put(MAX_WAIT_TIME_PROPERTY, maxWaitTime);
    return this;
  }

  /**
   * The maximum amount of time allowed for a running SQL select query , zero means there is no limit. Max time less than 1 second will be equal to zero.
   */
  public final QueryDatabaseTable removeMaxWaitTime() {
    properties.remove(MAX_WAIT_TIME_PROPERTY);
    return this;
  }

  /**
   * The number of result rows to be fetched from the result set at a time. This is a hint to the database driver and may not be honored and/or exact. If the value specified is zero, then the hint is ignored.
   */
  public final String getFetchSize() {
    return properties.get(FETCH_SIZE_PROPERTY);
  }

  /**
   * The number of result rows to be fetched from the result set at a time. This is a hint to the database driver and may not be honored and/or exact. If the value specified is zero, then the hint is ignored.
   */
  public final QueryDatabaseTable setFetchSize(final String fetchSize) {
    properties.put(FETCH_SIZE_PROPERTY, fetchSize);
    return this;
  }

  /**
   * The number of result rows to be fetched from the result set at a time. This is a hint to the database driver and may not be honored and/or exact. If the value specified is zero, then the hint is ignored.
   */
  public final QueryDatabaseTable removeFetchSize() {
    properties.remove(FETCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * The maximum number of result rows that will be included in a single FlowFile. This will allow you to break up very large result sets into multiple FlowFiles. If the value specified is zero, then all rows are returned in a single FlowFile.
   */
  public final String getQdbtMaxRows() {
    return properties.get(QDBT_MAX_ROWS_PROPERTY);
  }

  /**
   * The maximum number of result rows that will be included in a single FlowFile. This will allow you to break up very large result sets into multiple FlowFiles. If the value specified is zero, then all rows are returned in a single FlowFile.
   */
  public final QueryDatabaseTable setQdbtMaxRows(final String qdbtMaxRows) {
    properties.put(QDBT_MAX_ROWS_PROPERTY, qdbtMaxRows);
    return this;
  }

  /**
   * The maximum number of result rows that will be included in a single FlowFile. This will allow you to break up very large result sets into multiple FlowFiles. If the value specified is zero, then all rows are returned in a single FlowFile.
   */
  public final QueryDatabaseTable removeQdbtMaxRows() {
    properties.remove(QDBT_MAX_ROWS_PROPERTY);
    return this;
  }

  /**
   * The number of output FlowFiles to queue before committing the process session. When set to zero, the session will be committed when all result set rows have been processed and the output FlowFiles are ready for transfer to the downstream relationship. For large result sets, this can cause a large burst of FlowFiles to be transferred at the end of processor execution. If this property is set, then when the specified number of FlowFiles are ready for transfer, then the session will be committed, thus releasing the FlowFiles to the downstream relationship. NOTE: The maxvalue.* and fragment.count attributes will not be set on FlowFiles when this property is set.
   */
  public final String getQdbtOutputBatchSize() {
    return properties.get(QDBT_OUTPUT_BATCH_SIZE_PROPERTY);
  }

  /**
   * The number of output FlowFiles to queue before committing the process session. When set to zero, the session will be committed when all result set rows have been processed and the output FlowFiles are ready for transfer to the downstream relationship. For large result sets, this can cause a large burst of FlowFiles to be transferred at the end of processor execution. If this property is set, then when the specified number of FlowFiles are ready for transfer, then the session will be committed, thus releasing the FlowFiles to the downstream relationship. NOTE: The maxvalue.* and fragment.count attributes will not be set on FlowFiles when this property is set.
   */
  public final QueryDatabaseTable setQdbtOutputBatchSize(final String qdbtOutputBatchSize) {
    properties.put(QDBT_OUTPUT_BATCH_SIZE_PROPERTY, qdbtOutputBatchSize);
    return this;
  }

  /**
   * The number of output FlowFiles to queue before committing the process session. When set to zero, the session will be committed when all result set rows have been processed and the output FlowFiles are ready for transfer to the downstream relationship. For large result sets, this can cause a large burst of FlowFiles to be transferred at the end of processor execution. If this property is set, then when the specified number of FlowFiles are ready for transfer, then the session will be committed, thus releasing the FlowFiles to the downstream relationship. NOTE: The maxvalue.* and fragment.count attributes will not be set on FlowFiles when this property is set.
   */
  public final QueryDatabaseTable removeQdbtOutputBatchSize() {
    properties.remove(QDBT_OUTPUT_BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * The maximum number of fragments. If the value specified is zero, then all fragments are returned. This prevents OutOfMemoryError when this processor ingests huge table. NOTE: Setting this property can result in data loss, as the incoming results are not ordered, and fragments may end at arbitrary boundaries where rows are not included in the result set.
   */
  public final String getQdbtMaxFrags() {
    return properties.get(QDBT_MAX_FRAGS_PROPERTY);
  }

  /**
   * The maximum number of fragments. If the value specified is zero, then all fragments are returned. This prevents OutOfMemoryError when this processor ingests huge table. NOTE: Setting this property can result in data loss, as the incoming results are not ordered, and fragments may end at arbitrary boundaries where rows are not included in the result set.
   */
  public final QueryDatabaseTable setQdbtMaxFrags(final String qdbtMaxFrags) {
    properties.put(QDBT_MAX_FRAGS_PROPERTY, qdbtMaxFrags);
    return this;
  }

  /**
   * The maximum number of fragments. If the value specified is zero, then all fragments are returned. This prevents OutOfMemoryError when this processor ingests huge table. NOTE: Setting this property can result in data loss, as the incoming results are not ordered, and fragments may end at arbitrary boundaries where rows are not included in the result set.
   */
  public final QueryDatabaseTable removeQdbtMaxFrags() {
    properties.remove(QDBT_MAX_FRAGS_PROPERTY);
    return this;
  }

  /**
   * Whether to change non-Avro-compatible characters in column names to Avro-compatible characters. For example, colons and periods will be changed to underscores in order to build a valid Avro record.
   */
  public final String getDbfNormalize() {
    return properties.get(DBF_NORMALIZE_PROPERTY);
  }

  /**
   * Whether to change non-Avro-compatible characters in column names to Avro-compatible characters. For example, colons and periods will be changed to underscores in order to build a valid Avro record.
   */
  public final QueryDatabaseTable setDbfNormalize(final String dbfNormalize) {
    properties.put(DBF_NORMALIZE_PROPERTY, dbfNormalize);
    return this;
  }

  /**
   * Whether to change non-Avro-compatible characters in column names to Avro-compatible characters. For example, colons and periods will be changed to underscores in order to build a valid Avro record.
   */
  public final QueryDatabaseTable removeDbfNormalize() {
    properties.remove(DBF_NORMALIZE_PROPERTY);
    return this;
  }

  /**
   * Whether to use Avro Logical Types for DECIMAL/NUMBER, DATE, TIME and TIMESTAMP columns. If disabled, written as string. If enabled, Logical types are used and written as its underlying type, specifically, DECIMAL/NUMBER as logical 'decimal': written as bytes with additional precision and scale meta data, DATE as logical 'date-millis': written as int denoting days since Unix epoch (1970-01-01), TIME as logical 'time-millis': written as int denoting milliseconds since Unix epoch, and TIMESTAMP as logical 'timestamp-millis': written as long denoting milliseconds since Unix epoch. If a reader of written Avro records also knows these logical types, then these values can be deserialized with more context depending on reader implementation.
   */
  public final String getDbfUserLogicalTypes() {
    return properties.get(DBF_USER_LOGICAL_TYPES_PROPERTY);
  }

  /**
   * Whether to use Avro Logical Types for DECIMAL/NUMBER, DATE, TIME and TIMESTAMP columns. If disabled, written as string. If enabled, Logical types are used and written as its underlying type, specifically, DECIMAL/NUMBER as logical 'decimal': written as bytes with additional precision and scale meta data, DATE as logical 'date-millis': written as int denoting days since Unix epoch (1970-01-01), TIME as logical 'time-millis': written as int denoting milliseconds since Unix epoch, and TIMESTAMP as logical 'timestamp-millis': written as long denoting milliseconds since Unix epoch. If a reader of written Avro records also knows these logical types, then these values can be deserialized with more context depending on reader implementation.
   */
  public final QueryDatabaseTable setDbfUserLogicalTypes(final String dbfUserLogicalTypes) {
    properties.put(DBF_USER_LOGICAL_TYPES_PROPERTY, dbfUserLogicalTypes);
    return this;
  }

  /**
   * Whether to use Avro Logical Types for DECIMAL/NUMBER, DATE, TIME and TIMESTAMP columns. If disabled, written as string. If enabled, Logical types are used and written as its underlying type, specifically, DECIMAL/NUMBER as logical 'decimal': written as bytes with additional precision and scale meta data, DATE as logical 'date-millis': written as int denoting days since Unix epoch (1970-01-01), TIME as logical 'time-millis': written as int denoting milliseconds since Unix epoch, and TIMESTAMP as logical 'timestamp-millis': written as long denoting milliseconds since Unix epoch. If a reader of written Avro records also knows these logical types, then these values can be deserialized with more context depending on reader implementation.
   */
  public final QueryDatabaseTable removeDbfUserLogicalTypes() {
    properties.remove(DBF_USER_LOGICAL_TYPES_PROPERTY);
    return this;
  }

  /**
   * When a DECIMAL/NUMBER value is written as a 'decimal' Avro logical type, a specific 'precision' denoting number of available digits is required. Generally, precision is defined by column data type definition or database engines default. However undefined precision (0) can be returned from some database engines. 'Default Decimal Precision' is used when writing those undefined precision numbers.
   */
  public final String getDbfDefaultPrecision() {
    return properties.get(DBF_DEFAULT_PRECISION_PROPERTY);
  }

  /**
   * When a DECIMAL/NUMBER value is written as a 'decimal' Avro logical type, a specific 'precision' denoting number of available digits is required. Generally, precision is defined by column data type definition or database engines default. However undefined precision (0) can be returned from some database engines. 'Default Decimal Precision' is used when writing those undefined precision numbers.
   */
  public final QueryDatabaseTable setDbfDefaultPrecision(final String dbfDefaultPrecision) {
    properties.put(DBF_DEFAULT_PRECISION_PROPERTY, dbfDefaultPrecision);
    return this;
  }

  /**
   * When a DECIMAL/NUMBER value is written as a 'decimal' Avro logical type, a specific 'precision' denoting number of available digits is required. Generally, precision is defined by column data type definition or database engines default. However undefined precision (0) can be returned from some database engines. 'Default Decimal Precision' is used when writing those undefined precision numbers.
   */
  public final QueryDatabaseTable removeDbfDefaultPrecision() {
    properties.remove(DBF_DEFAULT_PRECISION_PROPERTY);
    return this;
  }

  /**
   * When a DECIMAL/NUMBER value is written as a 'decimal' Avro logical type, a specific 'scale' denoting number of available decimal digits is required. Generally, scale is defined by column data type definition or database engines default. However when undefined precision (0) is returned, scale can also be uncertain with some database engines. 'Default Decimal Scale' is used when writing those undefined numbers. If a value has more decimals than specified scale, then the value will be rounded-up, e.g. 1.53 becomes 2 with scale 0, and 1.5 with scale 1.
   */
  public final String getDbfDefaultScale() {
    return properties.get(DBF_DEFAULT_SCALE_PROPERTY);
  }

  /**
   * When a DECIMAL/NUMBER value is written as a 'decimal' Avro logical type, a specific 'scale' denoting number of available decimal digits is required. Generally, scale is defined by column data type definition or database engines default. However when undefined precision (0) is returned, scale can also be uncertain with some database engines. 'Default Decimal Scale' is used when writing those undefined numbers. If a value has more decimals than specified scale, then the value will be rounded-up, e.g. 1.53 becomes 2 with scale 0, and 1.5 with scale 1.
   */
  public final QueryDatabaseTable setDbfDefaultScale(final String dbfDefaultScale) {
    properties.put(DBF_DEFAULT_SCALE_PROPERTY, dbfDefaultScale);
    return this;
  }

  /**
   * When a DECIMAL/NUMBER value is written as a 'decimal' Avro logical type, a specific 'scale' denoting number of available decimal digits is required. Generally, scale is defined by column data type definition or database engines default. However when undefined precision (0) is returned, scale can also be uncertain with some database engines. 'Default Decimal Scale' is used when writing those undefined numbers. If a value has more decimals than specified scale, then the value will be rounded-up, e.g. 1.53 becomes 2 with scale 0, and 1.5 with scale 1.
   */
  public final QueryDatabaseTable removeDbfDefaultScale() {
    properties.remove(DBF_DEFAULT_SCALE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final QueryDatabaseTable setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final QueryDatabaseTable removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<QueryDatabaseTable, QueryDatabaseTable> configurator) {
    return configurator.apply(new QueryDatabaseTable()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = QueryDatabaseTable.class) final Closure<QueryDatabaseTable> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.QueryDatabaseTable> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.QueryDatabaseTable.class, com.tibtech.nifi.processors.standard.QueryDatabaseTable.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<QueryDatabaseTable, QueryDatabaseTable> configurator) {
    return configurator.apply(new QueryDatabaseTable(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = QueryDatabaseTable.class) final Closure<QueryDatabaseTable> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.QueryDatabaseTable> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.QueryDatabaseTable.class, com.tibtech.nifi.processors.standard.QueryDatabaseTable.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
