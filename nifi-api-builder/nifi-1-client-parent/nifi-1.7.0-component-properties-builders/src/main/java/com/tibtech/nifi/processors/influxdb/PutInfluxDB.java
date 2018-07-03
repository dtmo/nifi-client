package com.tibtech.nifi.processors.influxdb;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class PutInfluxDB {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.influxdb.PutInfluxDB";

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

  /**
   * InfluxDB consistency level
   */
  public static final String INFLUXDB_CONSISTENCY_LEVEL_PROPERTY = "influxdb-consistency-level";

  /**
   * Retention policy for the saving the records
   */
  public static final String INFLUXDB_RETENTION_POLICY_PROPERTY = "influxdb-retention-policy";

  /**
   * Maximum size of records allowed to be posted in one batch
   */
  public static final String INFLUXDB_MAX_RECORDS_SIZE_PROPERTY = "influxdb-max-records-size";

  private final Map<String, String> properties;

  public PutInfluxDB() {
    this.properties = new HashMap<>();
  }

  public PutInfluxDB(final Map<String, String> properties) {
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
  public final PutInfluxDB setInfluxdbDbname(final String influxdbDbname) {
    properties.put(INFLUXDB_DBNAME_PROPERTY, influxdbDbname);
    return this;
  }

  /**
   * InfluxDB database to connect to
   */
  public final PutInfluxDB removeInfluxdbDbname() {
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
  public final PutInfluxDB setInfluxdbUrl(final String influxdbUrl) {
    properties.put(INFLUXDB_URL_PROPERTY, influxdbUrl);
    return this;
  }

  /**
   * InfluxDB URL to connect to. Eg: http://influxdb:8086
   */
  public final PutInfluxDB removeInfluxdbUrl() {
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
  public final PutInfluxDB setInfluxDbMaxConnectionTimeOutSeconds(
      final String influxDbMaxConnectionTimeOutSeconds) {
    properties.put(INFLUX_DB_MAX_CONNECTION_TIME_OUT_SECONDS_PROPERTY, influxDbMaxConnectionTimeOutSeconds);
    return this;
  }

  /**
   * The maximum time for establishing connection to the InfluxDB
   */
  public final PutInfluxDB removeInfluxDbMaxConnectionTimeOutSeconds() {
    properties.remove(INFLUX_DB_MAX_CONNECTION_TIME_OUT_SECONDS_PROPERTY);
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
  public final PutInfluxDB setInfluxdbUsername(final String influxdbUsername) {
    properties.put(INFLUXDB_USERNAME_PROPERTY, influxdbUsername);
    return this;
  }

  /**
   * Username for accessing InfluxDB
   */
  public final PutInfluxDB removeInfluxdbUsername() {
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
  public final PutInfluxDB setInfluxdbPassword(final String influxdbPassword) {
    properties.put(INFLUXDB_PASSWORD_PROPERTY, influxdbPassword);
    return this;
  }

  /**
   * Password for user
   */
  public final PutInfluxDB removeInfluxdbPassword() {
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
  public final PutInfluxDB setInfluxdbCharset(final String influxdbCharset) {
    properties.put(INFLUXDB_CHARSET_PROPERTY, influxdbCharset);
    return this;
  }

  /**
   * Specifies the character set of the document data.
   */
  public final PutInfluxDB removeInfluxdbCharset() {
    properties.remove(INFLUXDB_CHARSET_PROPERTY);
    return this;
  }

  /**
   * InfluxDB consistency level
   */
  public final String getInfluxdbConsistencyLevel() {
    return properties.get(INFLUXDB_CONSISTENCY_LEVEL_PROPERTY);
  }

  /**
   * InfluxDB consistency level
   */
  public final PutInfluxDB setInfluxdbConsistencyLevel(final String influxdbConsistencyLevel) {
    properties.put(INFLUXDB_CONSISTENCY_LEVEL_PROPERTY, influxdbConsistencyLevel);
    return this;
  }

  /**
   * InfluxDB consistency level
   */
  public final PutInfluxDB removeInfluxdbConsistencyLevel() {
    properties.remove(INFLUXDB_CONSISTENCY_LEVEL_PROPERTY);
    return this;
  }

  /**
   * Retention policy for the saving the records
   */
  public final String getInfluxdbRetentionPolicy() {
    return properties.get(INFLUXDB_RETENTION_POLICY_PROPERTY);
  }

  /**
   * Retention policy for the saving the records
   */
  public final PutInfluxDB setInfluxdbRetentionPolicy(final String influxdbRetentionPolicy) {
    properties.put(INFLUXDB_RETENTION_POLICY_PROPERTY, influxdbRetentionPolicy);
    return this;
  }

  /**
   * Retention policy for the saving the records
   */
  public final PutInfluxDB removeInfluxdbRetentionPolicy() {
    properties.remove(INFLUXDB_RETENTION_POLICY_PROPERTY);
    return this;
  }

  /**
   * Maximum size of records allowed to be posted in one batch
   */
  public final String getInfluxdbMaxRecordsSize() {
    return properties.get(INFLUXDB_MAX_RECORDS_SIZE_PROPERTY);
  }

  /**
   * Maximum size of records allowed to be posted in one batch
   */
  public final PutInfluxDB setInfluxdbMaxRecordsSize(final String influxdbMaxRecordsSize) {
    properties.put(INFLUXDB_MAX_RECORDS_SIZE_PROPERTY, influxdbMaxRecordsSize);
    return this;
  }

  /**
   * Maximum size of records allowed to be posted in one batch
   */
  public final PutInfluxDB removeInfluxdbMaxRecordsSize() {
    properties.remove(INFLUXDB_MAX_RECORDS_SIZE_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final PutInfluxDB setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final PutInfluxDB removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(
      final Function<PutInfluxDB, PutInfluxDB> configurator) {
    return configurator.apply(new PutInfluxDB()).build();
  }

  public static final Map<String, String> build(
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutInfluxDB.class) final Closure<PutInfluxDB> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.influxdb.PutInfluxDB> code = closure.rehydrate(c, com.tibtech.nifi.processors.influxdb.PutInfluxDB.class, com.tibtech.nifi.processors.influxdb.PutInfluxDB.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      final Function<PutInfluxDB, PutInfluxDB> configurator) {
    return configurator.apply(new PutInfluxDB(properties)).build();
  }

  public static final Map<String, String> update(final Map<String, String> properties,
      @DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = PutInfluxDB.class) final Closure<PutInfluxDB> closure) {
    return update(properties, c -> {
      final Closure<com.tibtech.nifi.processors.influxdb.PutInfluxDB> code = closure.rehydrate(c, com.tibtech.nifi.processors.influxdb.PutInfluxDB.class, com.tibtech.nifi.processors.influxdb.PutInfluxDB.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
