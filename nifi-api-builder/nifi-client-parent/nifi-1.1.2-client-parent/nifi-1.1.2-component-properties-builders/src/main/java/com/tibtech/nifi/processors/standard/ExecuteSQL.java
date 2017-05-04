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
  public final ExecuteSQL setDatabaseConnectionPoolingService(final String databaseConnectionPoolingService) {
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

  public static final Map<String, String> build(final Function<ExecuteSQL, ExecuteSQL> configurator) {
    return configurator.apply(new ExecuteSQL()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExecuteSQL.class) final Closure<ExecuteSQL> closure) {
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
