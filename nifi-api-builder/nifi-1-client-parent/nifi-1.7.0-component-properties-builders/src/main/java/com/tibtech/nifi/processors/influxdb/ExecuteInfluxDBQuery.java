package com.tibtech.nifi.processors.influxdb;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class ExecuteInfluxDBQuery {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.influxdb.ExecuteInfluxDBQuery";

  /**
   * InfluxDB database to connect to
   */
  public static final String INFLUXDB_DBNAME_PROPERTY = "influxdb-dbname";

  /**
   * InfluxDB URL to connect to. Eg: http://influxdb:8086
   */
  public static final String INFLUXDB_URL_PROPERTY = "influxdb-url";

  /**
   * The maximum time for establishing connection to the InfluxDB
   */
  public static final String INFLUX_DB_MAX_CONNECTION_TIME_OUT_SECONDS_PROPERTY = "InfluxDB Max Connection Time Out (seconds)";

  /**
   * The time unit of query results from the InfluxDB
   */
  public static final String INFLUXDB_QUERY_RESULT_TIME_UNIT_PROPERTY = "influxdb-query-result-time-unit";

  /**
   * The InfluxDB query to execute. Note: If there are incoming connections, then the query is created from incoming FlowFile's content otherwise it is created from this property.
   */
  public static final String INFLUXDB_QUERY_PROPERTY = "influxdb-query";

  /**
   * Chunking can be used to return results in a stream of smaller batches (each has a partial results up to a chunk size) rather than as a single response. Chunking queries can return an unlimited number of rows. Note: Chunking is enable when result chunk size is greater than 0
   */
  public static final String INFLUXDB_QUERY_CHUNK_SIZE_PROPERTY = "influxdb-query-chunk-size";

  /**
   * Username for accessing InfluxDB
   */
  public static final String INFLUXDB_USERNAME_PROPERTY = "influxdb-username";

  /**
   * Password for user
   */
  public static final String INFLUXDB_PASSWORD_PROPERTY = "influxdb-password";

  /**
   * Specifies the character set of the document data.
   */
  public static final String INFLUXDB_CHARSET_PROPERTY = "influxdb-charset";

  private final Map<String, String> properties;

  public ExecuteInfluxDBQuery() {
    this.properties = new HashMap<>();
  }

  public ExecuteInfluxDBQuery(final Map<String, String> properties) {
    this.properties = new HashMap<>(properties);
  }

  /**
   * InfluxDB database to connect to
   */
  public final String getInfluxdbDbname() {
    return properties.get(INFLUXDB_DBNAME_PROPERTY);
  }

  /**
   * InfluxDB database to connect to
   */
  public final ExecuteInfluxDBQuery setInfluxdbDbname(final String influxdbDbname) {
    properties.put(INFLUXDB_DBNAME_PROPERTY, influxdbDbname);
    return this;
  }

  /**
   * InfluxDB database to connect to
   */
  public final ExecuteInfluxDBQuery removeInfluxdbDbname() {
    properties.remove(INFLUXDB_DBNAME_PROPERTY);
    return this;
  }

  /**
   * InfluxDB URL to connect to. Eg: http://influxdb:8086
   */
  public final String getInfluxdbUrl() {
    return properties.get(INFLUXDB_URL_PROPERTY);
  }

  /**
   * InfluxDB URL to connect to. Eg: http://influxdb:8086
   */
  public final ExecuteInfluxDBQuery setInfluxdbUrl(final String influxdbUrl) {
    properties.put(INFLUXDB_URL_PROPERTY, influxdbUrl);
    return this;
  }

  /**
   * InfluxDB URL to connect to. Eg: http://influxdb:8086
   */
  public final ExecuteInfluxDBQuery removeInfluxdbUrl() {
    properties.remove(INFLUXDB_URL_PROPERTY);
    return this;
  }

  /**
   * The maximum time for establishing connection to the InfluxDB
   */
  public final String getInfluxDbMaxConnectionTimeOutSeconds() {
    return properties.get(INFLUX_DB_MAX_CONNECTION_TIME_OUT_SECONDS_PROPERTY);
  }

  /**
   * The maximum time for establishing connection to the InfluxDB
   */
  public final ExecuteInfluxDBQuery setInfluxDbMaxConnectionTimeOutSeconds(
      final String influxDbMaxConnectionTimeOutSeconds) {
    properties.put(INFLUX_DB_MAX_CONNECTION_TIME_OUT_SECONDS_PROPERTY, influxDbMaxConnectionTimeOutSeconds);
    return this;
  }

  /**
   * The maximum time for establishing connection to the InfluxDB
   */
  public final ExecuteInfluxDBQuery removeInfluxDbMaxConnectionTimeOutSeconds() {
    properties.remove(INFLUX_DB_MAX_CONNECTION_TIME_OUT_SECONDS_PROPERTY);
    return this;
  }

  /**
   * The time unit of query results from the InfluxDB
   */
  public final String getInfluxdbQueryResultTimeUnit() {
    return properties.get(INFLUXDB_QUERY_RESULT_TIME_UNIT_PROPERTY);
  }

  /**
   * The time unit of query results from the InfluxDB
   */
  public final ExecuteInfluxDBQuery setInfluxdbQueryResultTimeUnit(
      final String influxdbQueryResultTimeUnit) {
    properties.put(INFLUXDB_QUERY_RESULT_TIME_UNIT_PROPERTY, influxdbQueryResultTimeUnit);
    return this;
  }

  /**
   * The time unit of query results from the InfluxDB
   */
  public final ExecuteInfluxDBQuery removeInfluxdbQueryResultTimeUnit() {
    properties.remove(INFLUXDB_QUERY_RESULT_TIME_UNIT_PROPERTY);
    return this;
  }

  /**
   * The InfluxDB query to execute. Note: If there are incoming connections, then the query is created from incoming FlowFile's content otherwise it is created from this property.
   */
  public final String getInfluxdbQuery() {
    return properties.get(INFLUXDB_QUERY_PROPERTY);
  }

  /**
   * The InfluxDB query to execute. Note: If there are incoming connections, then the query is created from incoming FlowFile's content otherwise it is created from this property.
   */
  public final ExecuteInfluxDBQuery setInfluxdbQuery(final String influxdbQuery) {
    properties.put(INFLUXDB_QUERY_PROPERTY, influxdbQuery);
    return this;
  }

  /**
   * The InfluxDB query to execute. Note: If there are incoming connections, then the query is created from incoming FlowFile's content otherwise it is created from this property.
   */
  public final ExecuteInfluxDBQuery removeInfluxdbQuery() {
    properties.remove(INFLUXDB_QUERY_PROPERTY);
    return this;
  }

  /**
   * Chunking can be used to return results in a stream of smaller batches (each has a partial results up to a chunk size) rather than as a single response. Chunking queries can return an unlimited number of rows. Note: Chunking is enable when result chunk size is greater than 0
   */
  public final String getInfluxdbQueryChunkSize() {
    return properties.get(INFLUXDB_QUERY_CHUNK_SIZE_PROPERTY);
  }

  /**
   * Chunking can be used to return results in a stream of smaller batches (each has a partial results up to a chunk size) rather than as a single response. Chunking queries can return an unlimited number of rows. Note: Chunking is enable when result chunk size is greater than 0
   */
  public final ExecuteInfluxDBQuery setInfluxdbQueryChunkSize(final String influxdbQueryChunkSize) {
    properties.put(INFLUXDB_QUERY_CHUNK_SIZE_PROPERTY, influxdbQueryChunkSize);
    return this;
  }

  /**
   * Chunking can be used to return results in a stream of smaller batches (each has a partial results up to a chunk size) rather than as a single response. Chunking queries can return an unlimited number of rows. Note: Chunking is enable when result chunk size is greater than 0
   */
  public final ExecuteInfluxDBQuery removeInfluxdbQueryChunkSize() {
    properties.remove(INFLUXDB_QUERY_CHUNK_SIZE_PROPERTY);
    return this;
  }

  /**
   * Username for accessing InfluxDB
   */
  public final String getInfluxdbUsername() {
    return properties.get(INFLUXDB_USERNAME_PROPERTY);
  }

  /**
   * Username for accessing InfluxDB
   */
  public final ExecuteInfluxDBQuery setInfluxdbUsername(final String influxdbUsername) {
    properties.put(INFLUXDB_USERNAME_PROPERTY, influxdbUsername);
    return this;
  }

  /**
   * Username for accessing InfluxDB
   */
  public final ExecuteInfluxDBQuery removeInfluxdbUsername() {
    properties.remove(INFLUXDB_USERNAME_PROPERTY);
    return this;
  }

  /**
   * Password for user
   */
  public final String getInfluxdbPassword() {
    return properties.get(INFLUXDB_PASSWORD_PROPERTY);
  }

  /**
   * Password for user
   */
  public final ExecuteInfluxDBQuery setInfluxdbPassword(final String influxdbPassword) {
    properties.put(INFLUXDB_PASSWORD_PROPERTY, influxdbPassword);
    return this;
  }

  /**
   * Password for user
   */
  public final ExecuteInfluxDBQuery removeInfluxdbPassword() {
    properties.remove(INFLUXDB_PASSWORD_PROPERTY);
    return this;
  }

  /**
   * Specifies the character set of the document data.
   */
  public final String getInfluxdbCharset() {
    return properties.get(INFLUXDB_CHARSET_PROPERTY);
  }

  /**
   * Specifies the character set of the document data.
   */
  public final ExecuteInfluxDBQuery setInfluxdbCharset(final String influxdbCharset) {
    properties.put(INFLUXDB_CHARSET_PROPERTY, influxdbCharset);
    return this;
  }

  /**
   * Specifies the character set of the document data.
   */
  public final ExecuteInfluxDBQuery removeInfluxdbCharset() {
    properties.remove(INFLUXDB_CHARSET_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final ExecuteInfluxDBQuery setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final ExecuteInfluxDBQuery removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<ExecuteInfluxDBQuery, ExecuteInfluxDBQuery> configurator) {
    return configurator.apply(new ExecuteInfluxDBQuery()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExecuteInfluxDBQuery.class) final Closure<ExecuteInfluxDBQuery> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.influxdb.ExecuteInfluxDBQuery> code = closure.rehydrate(c, com.tibtech.nifi.processors.influxdb.ExecuteInfluxDBQuery.class, com.tibtech.nifi.processors.influxdb.ExecuteInfluxDBQuery.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<ExecuteInfluxDBQuery, ExecuteInfluxDBQuery> configurator) {
    return configurator.apply(new ExecuteInfluxDBQuery(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = ExecuteInfluxDBQuery.class) final Closure<ExecuteInfluxDBQuery> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.influxdb.ExecuteInfluxDBQuery> code = closure.rehydrate(c, com.tibtech.nifi.processors.influxdb.ExecuteInfluxDBQuery.class, com.tibtech.nifi.processors.influxdb.ExecuteInfluxDBQuery.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
