package com.tibtech.nifi.dbcp;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class DBCPConnectionPoolPropertiesBuilder {
  /**
   * A database connection URL used to connect to a database. May contain database system name, host, port, database name and some parameters. The exact syntax of a database connection URL is specified by your DBMS.
   */
  public static final String DATABASE_CONNECTION_URL = "Database Connection URL";

  /**
   * Database driver class name
   */
  public static final String DATABASE_DRIVER_CLASS_NAME = "Database Driver Class Name";

  /**
   * Comma-separated list of files/folders and/or URLs containing the driver JAR and its dependencies (if any). For example '/var/tmp/mariadb-java-client-1.1.7.jar'
   */
  public static final String DATABASE_DRIVER_LOCATIONS = "database-driver-locations";

  /**
   * Database user name
   */
  public static final String DATABASE_USER = "Database User";

  /**
   * The password for the database user
   */
  public static final String PASSWORD = "Password";

  /**
   * The maximum amount of time that the pool will wait (when there are no available connections)  for a connection to be returned before failing, or -1 to wait indefinitely. 
   */
  public static final String MAX_WAIT_TIME = "Max Wait Time";

  /**
   * The maximum number of active connections that can be allocated from this pool at the same time,  or negative for no limit.
   */
  public static final String MAX_TOTAL_CONNECTIONS = "Max Total Connections";

  /**
   * Validation query used to validate connections before returning them. When connection is invalid, it get's dropped and new valid connection will be returned. Note!! Using validation might have some performance penalty.
   */
  public static final String VALIDATION_QUERY = "Validation-query";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * A database connection URL used to connect to a database. May contain database system name, host, port, database name and some parameters. The exact syntax of a database connection URL is specified by your DBMS.
   */
  public final String getDatabaseConnectionUrl() {
    return properties.get(DATABASE_CONNECTION_URL_PROPERTY);
  }

  /**
   * A database connection URL used to connect to a database. May contain database system name, host, port, database name and some parameters. The exact syntax of a database connection URL is specified by your DBMS.
   */
  public final DBCPConnectionPoolPropertiesBuilder setDatabaseConnectionUrl(final String databaseConnectionUrl) {
    properties.put(DATABASE_CONNECTION_URL_PROPERTY, databaseConnectionUrl);
    return this;
  }

  /**
   * A database connection URL used to connect to a database. May contain database system name, host, port, database name and some parameters. The exact syntax of a database connection URL is specified by your DBMS.
   */
  public final DBCPConnectionPoolPropertiesBuilder removeDatabaseConnectionUrl() {
    properties.remove(DATABASE_CONNECTION_URL_PROPERTY);
    return this;
  }

  /**
   * Database driver class name
   */
  public final String getDatabaseDriverClassName() {
    return properties.get(DATABASE_DRIVER_CLASS_NAME_PROPERTY);
  }

  /**
   * Database driver class name
   */
  public final DBCPConnectionPoolPropertiesBuilder setDatabaseDriverClassName(final String databaseDriverClassName) {
    properties.put(DATABASE_DRIVER_CLASS_NAME_PROPERTY, databaseDriverClassName);
    return this;
  }

  /**
   * Database driver class name
   */
  public final DBCPConnectionPoolPropertiesBuilder removeDatabaseDriverClassName() {
    properties.remove(DATABASE_DRIVER_CLASS_NAME_PROPERTY);
    return this;
  }

  /**
   * Comma-separated list of files/folders and/or URLs containing the driver JAR and its dependencies (if any). For example '/var/tmp/mariadb-java-client-1.1.7.jar'
   */
  public final String getDatabaseDriverLocations() {
    return properties.get(DATABASE_DRIVER_LOCATIONS_PROPERTY);
  }

  /**
   * Comma-separated list of files/folders and/or URLs containing the driver JAR and its dependencies (if any). For example '/var/tmp/mariadb-java-client-1.1.7.jar'
   */
  public final DBCPConnectionPoolPropertiesBuilder setDatabaseDriverLocations(final String databaseDriverLocations) {
    properties.put(DATABASE_DRIVER_LOCATIONS_PROPERTY, databaseDriverLocations);
    return this;
  }

  /**
   * Comma-separated list of files/folders and/or URLs containing the driver JAR and its dependencies (if any). For example '/var/tmp/mariadb-java-client-1.1.7.jar'
   */
  public final DBCPConnectionPoolPropertiesBuilder removeDatabaseDriverLocations() {
    properties.remove(DATABASE_DRIVER_LOCATIONS_PROPERTY);
    return this;
  }

  /**
   * Database user name
   */
  public final String getDatabaseUser() {
    return properties.get(DATABASE_USER_PROPERTY);
  }

  /**
   * Database user name
   */
  public final DBCPConnectionPoolPropertiesBuilder setDatabaseUser(final String databaseUser) {
    properties.put(DATABASE_USER_PROPERTY, databaseUser);
    return this;
  }

  /**
   * Database user name
   */
  public final DBCPConnectionPoolPropertiesBuilder removeDatabaseUser() {
    properties.remove(DATABASE_USER_PROPERTY);
    return this;
  }

  /**
   * The password for the database user
   */
  public final String getPassword() {
    return properties.get(PASSWORD_PROPERTY);
  }

  /**
   * The password for the database user
   */
  public final DBCPConnectionPoolPropertiesBuilder setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * The password for the database user
   */
  public final DBCPConnectionPoolPropertiesBuilder removePassword() {
    properties.remove(PASSWORD_PROPERTY);
    return this;
  }

  /**
   * The maximum amount of time that the pool will wait (when there are no available connections)  for a connection to be returned before failing, or -1 to wait indefinitely. 
   */
  public final String getMaxWaitTime() {
    return properties.get(MAX_WAIT_TIME_PROPERTY);
  }

  /**
   * The maximum amount of time that the pool will wait (when there are no available connections)  for a connection to be returned before failing, or -1 to wait indefinitely. 
   */
  public final DBCPConnectionPoolPropertiesBuilder setMaxWaitTime(final String maxWaitTime) {
    properties.put(MAX_WAIT_TIME_PROPERTY, maxWaitTime);
    return this;
  }

  /**
   * The maximum amount of time that the pool will wait (when there are no available connections)  for a connection to be returned before failing, or -1 to wait indefinitely. 
   */
  public final DBCPConnectionPoolPropertiesBuilder removeMaxWaitTime() {
    properties.remove(MAX_WAIT_TIME_PROPERTY);
    return this;
  }

  /**
   * The maximum number of active connections that can be allocated from this pool at the same time,  or negative for no limit.
   */
  public final String getMaxTotalConnections() {
    return properties.get(MAX_TOTAL_CONNECTIONS_PROPERTY);
  }

  /**
   * The maximum number of active connections that can be allocated from this pool at the same time,  or negative for no limit.
   */
  public final DBCPConnectionPoolPropertiesBuilder setMaxTotalConnections(final String maxTotalConnections) {
    properties.put(MAX_TOTAL_CONNECTIONS_PROPERTY, maxTotalConnections);
    return this;
  }

  /**
   * The maximum number of active connections that can be allocated from this pool at the same time,  or negative for no limit.
   */
  public final DBCPConnectionPoolPropertiesBuilder removeMaxTotalConnections() {
    properties.remove(MAX_TOTAL_CONNECTIONS_PROPERTY);
    return this;
  }

  /**
   * Validation query used to validate connections before returning them. When connection is invalid, it get's dropped and new valid connection will be returned. Note!! Using validation might have some performance penalty.
   */
  public final String getValidationQuery() {
    return properties.get(VALIDATION_QUERY_PROPERTY);
  }

  /**
   * Validation query used to validate connections before returning them. When connection is invalid, it get's dropped and new valid connection will be returned. Note!! Using validation might have some performance penalty.
   */
  public final DBCPConnectionPoolPropertiesBuilder setValidationQuery(final String validationQuery) {
    properties.put(VALIDATION_QUERY_PROPERTY, validationQuery);
    return this;
  }

  /**
   * Validation query used to validate connections before returning them. When connection is invalid, it get's dropped and new valid connection will be returned. Note!! Using validation might have some performance penalty.
   */
  public final DBCPConnectionPoolPropertiesBuilder removeValidationQuery() {
    properties.remove(VALIDATION_QUERY_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final DBCPConnectionPoolPropertiesBuilder setDynamicProperty(final String name,
      final String value) {
    properties.put(name, value);
    return this;
  }

  public final DBCPConnectionPoolPropertiesBuilder removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<DBCPConnectionPoolPropertiesBuilder, DBCPConnectionPoolPropertiesBuilder> configurator) {
    return configurator.apply(new DBCPConnectionPoolPropertiesBuilder()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = DBCPConnectionPoolPropertiesBuilder.class) final Closure<DBCPConnectionPoolPropertiesBuilder> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.dbcp.DBCPConnectionPoolPropertiesBuilder> code = closure.rehydrate(c, com.tibtech.nifi.dbcp.DBCPConnectionPoolPropertiesBuilder.class, com.tibtech.nifi.dbcp.DBCPConnectionPoolPropertiesBuilder.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
