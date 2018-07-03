package com.tibtech.nifi.processors.standard;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ExecuteSQL {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.standard.ExecuteSQL";

  /**
   * The Controller Service that is used to obtain connection to database
   */
  public static final String DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY = "Database Connection Pooling Service";

  /**
   * The SQL select query to execute. The query can be empty, a constant value, or built from attributes using Expression Language. If this property is specified, it will be used regardless of the content of incoming flowfiles. If this property is empty, the content of the incoming flow file is expected to contain a valid SQL select query, to be issued by the processor to the database. Note that Expression Language is not evaluated for flow file contents.
   */
  public static final String SQL_SELECT_QUERY_PROPERTY = "SQL select query";

  /**
   * The maximum amount of time allowed for a running SQL select query  , zero means there is no limit. Max time less than 1 second will be equal to zero.
   */
  public static final String MAX_WAIT_TIME_PROPERTY = "Max Wait Time";

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

  public ExecuteSQL() {
    this.properties = new HashMap<>();
  }

  public ExecuteSQL(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * The Controller Service that is used to obtain connection to database
   */
  public final String getDatabaseConnectionPoolingService() {
    return properties.get(DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service that is used to obtain connection to database
   */
  public final ExecuteSQL setDatabaseConnectionPoolingService(
      final String databaseConnectionPoolingService) {
    properties.put(DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY, databaseConnectionPoolingService);
    return this;
  }

  /**
   * The Controller Service that is used to obtain connection to database
   */
  public final ExecuteSQL removeDatabaseConnectionPoolingService() {
    properties.remove(DATABASE_CONNECTION_POOLING_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The SQL select query to execute. The query can be empty, a constant value, or built from attributes using Expression Language. If this property is specified, it will be used regardless of the content of incoming flowfiles. If this property is empty, the content of the incoming flow file is expected to contain a valid SQL select query, to be issued by the processor to the database. Note that Expression Language is not evaluated for flow file contents.
   */
  public final String getSqlSelectQuery() {
    return properties.get(SQL_SELECT_QUERY_PROPERTY);
  }

  /**
   * The SQL select query to execute. The query can be empty, a constant value, or built from attributes using Expression Language. If this property is specified, it will be used regardless of the content of incoming flowfiles. If this property is empty, the content of the incoming flow file is expected to contain a valid SQL select query, to be issued by the processor to the database. Note that Expression Language is not evaluated for flow file contents.
   */
  public final ExecuteSQL setSqlSelectQuery(final String sqlSelectQuery) {
    properties.put(SQL_SELECT_QUERY_PROPERTY, sqlSelectQuery);
    return this;
  }

  /**
   * The SQL select query to execute. The query can be empty, a constant value, or built from attributes using Expression Language. If this property is specified, it will be used regardless of the content of incoming flowfiles. If this property is empty, the content of the incoming flow file is expected to contain a valid SQL select query, to be issued by the processor to the database. Note that Expression Language is not evaluated for flow file contents.
   */
  public final ExecuteSQL removeSqlSelectQuery() {
    properties.remove(SQL_SELECT_QUERY_PROPERTY);
    return this;
  }

  /**
   * The maximum amount of time allowed for a running SQL select query  , zero means there is no limit. Max time less than 1 second will be equal to zero.
   */
  public final String getMaxWaitTime() {
    return properties.get(MAX_WAIT_TIME_PROPERTY);
  }

  /**
   * The maximum amount of time allowed for a running SQL select query  , zero means there is no limit. Max time less than 1 second will be equal to zero.
   */
  public final ExecuteSQL setMaxWaitTime(final String maxWaitTime) {
    properties.put(MAX_WAIT_TIME_PROPERTY, maxWaitTime);
    return this;
  }

  /**
   * The maximum amount of time allowed for a running SQL select query  , zero means there is no limit. Max time less than 1 second will be equal to zero.
   */
  public final ExecuteSQL removeMaxWaitTime() {
    properties.remove(MAX_WAIT_TIME_PROPERTY);
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
  public final ExecuteSQL setDbfNormalize(final String dbfNormalize) {
    properties.put(DBF_NORMALIZE_PROPERTY, dbfNormalize);
    return this;
  }

  /**
   * Whether to change non-Avro-compatible characters in column names to Avro-compatible characters. For example, colons and periods will be changed to underscores in order to build a valid Avro record.
   */
  public final ExecuteSQL removeDbfNormalize() {
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
  public final ExecuteSQL setDbfUserLogicalTypes(final String dbfUserLogicalTypes) {
    properties.put(DBF_USER_LOGICAL_TYPES_PROPERTY, dbfUserLogicalTypes);
    return this;
  }

  /**
   * Whether to use Avro Logical Types for DECIMAL/NUMBER, DATE, TIME and TIMESTAMP columns. If disabled, written as string. If enabled, Logical types are used and written as its underlying type, specifically, DECIMAL/NUMBER as logical 'decimal': written as bytes with additional precision and scale meta data, DATE as logical 'date-millis': written as int denoting days since Unix epoch (1970-01-01), TIME as logical 'time-millis': written as int denoting milliseconds since Unix epoch, and TIMESTAMP as logical 'timestamp-millis': written as long denoting milliseconds since Unix epoch. If a reader of written Avro records also knows these logical types, then these values can be deserialized with more context depending on reader implementation.
   */
  public final ExecuteSQL removeDbfUserLogicalTypes() {
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
  public final ExecuteSQL setDbfDefaultPrecision(final String dbfDefaultPrecision) {
    properties.put(DBF_DEFAULT_PRECISION_PROPERTY, dbfDefaultPrecision);
    return this;
  }

  /**
   * When a DECIMAL/NUMBER value is written as a 'decimal' Avro logical type, a specific 'precision' denoting number of available digits is required. Generally, precision is defined by column data type definition or database engines default. However undefined precision (0) can be returned from some database engines. 'Default Decimal Precision' is used when writing those undefined precision numbers.
   */
  public final ExecuteSQL removeDbfDefaultPrecision() {
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
  public final ExecuteSQL setDbfDefaultScale(final String dbfDefaultScale) {
    properties.put(DBF_DEFAULT_SCALE_PROPERTY, dbfDefaultScale);
    return this;
  }

  /**
   * When a DECIMAL/NUMBER value is written as a 'decimal' Avro logical type, a specific 'scale' denoting number of available decimal digits is required. Generally, scale is defined by column data type definition or database engines default. However when undefined precision (0) is returned, scale can also be uncertain with some database engines. 'Default Decimal Scale' is used when writing those undefined numbers. If a value has more decimals than specified scale, then the value will be rounded-up, e.g. 1.53 becomes 2 with scale 0, and 1.5 with scale 1.
   */
  public final ExecuteSQL removeDbfDefaultScale() {
    properties.remove(DBF_DEFAULT_SCALE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ExecuteSQL setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ExecuteSQL removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ExecuteSQL, ExecuteSQL> configurator) {
    return configurator.apply(new ExecuteSQL()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExecuteSQL.class) final Closure<ExecuteSQL> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.standard.ExecuteSQL> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ExecuteSQL.class, com.tibtech.nifi.processors.standard.ExecuteSQL.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ExecuteSQL, ExecuteSQL> configurator) {
    return configurator.apply(new ExecuteSQL(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExecuteSQL.class) final Closure<ExecuteSQL> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.standard.ExecuteSQL> code = closure.rehydrate(c, com.tibtech.nifi.processors.standard.ExecuteSQL.class, com.tibtech.nifi.processors.standard.ExecuteSQL.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
