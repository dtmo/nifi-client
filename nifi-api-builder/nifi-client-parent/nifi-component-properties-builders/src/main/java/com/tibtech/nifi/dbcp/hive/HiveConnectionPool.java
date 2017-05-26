package com.tibtech.nifi.dbcp.hive;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class HiveConnectionPool {
  /**
   * A database connection URL used to connect to a database. May contain database system name, host, port, database name and some parameters. The exact syntax of a database connection URL is specified by the Hive documentation. For example, the server principal is often included as a connection parameter when connecting to a secure Hive server.
   */
  public static final String HIVE_DB_CONNECT_URL_PROPERTY = "hive-db-connect-url";

  /**
   * A file or comma separated list of files which contains the Hive configuration (hive-site.xml, e.g.). Without this, Hadoop will search the classpath for a 'hive-site.xml' file or will revert to a default configuration. Note that to enable authentication with Kerberos e.g., the appropriate properties must be set in the configuration files. Please see the Hive documentation for more details.
   */
  public static final String HIVE_CONFIG_RESOURCES_PROPERTY = "hive-config-resources";

  /**
   * Database user name
   */
  public static final String HIVE_DB_USER_PROPERTY = "hive-db-user";

  /**
   * The password for the database user
   */
  public static final String HIVE_DB_PASSWORD_PROPERTY = "hive-db-password";

  /**
   * The maximum amount of time that the pool will wait (when there are no available connections)  for a connection to be returned before failing, or -1 to wait indefinitely. 
   */
  public static final String HIVE_MAX_WAIT_TIME_PROPERTY = "hive-max-wait-time";

  /**
   * The maximum number of active connections that can be allocated from this pool at the same time, or negative for no limit.
   */
  public static final String HIVE_MAX_TOTAL_CONNECTIONS_PROPERTY = "hive-max-total-connections";

  /**
   * Validation query used to validate connections before returning them. When a borrowed connection is invalid, it gets dropped and a new valid connection will be returned. NOTE: Using validation may have a performance penalty.
   */
  public static final String VALIDATION_QUERY_PROPERTY = "Validation-query";

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public static final String KERBEROS_PRINCIPAL_PROPERTY = "Kerberos Principal";

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public static final String KERBEROS_KEYTAB_PROPERTY = "Kerberos Keytab";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * A database connection URL used to connect to a database. May contain database system name, host, port, database name and some parameters. The exact syntax of a database connection URL is specified by the Hive documentation. For example, the server principal is often included as a connection parameter when connecting to a secure Hive server.
   */
  public final String getHiveDbConnectUrl() {
    return properties.get(HIVE_DB_CONNECT_URL_PROPERTY);
  }

  /**
   * A database connection URL used to connect to a database. May contain database system name, host, port, database name and some parameters. The exact syntax of a database connection URL is specified by the Hive documentation. For example, the server principal is often included as a connection parameter when connecting to a secure Hive server.
   */
  public final HiveConnectionPool setHiveDbConnectUrl(final String hiveDbConnectUrl) {
    properties.put(HIVE_DB_CONNECT_URL_PROPERTY, hiveDbConnectUrl);
    return this;
  }

  /**
   * A database connection URL used to connect to a database. May contain database system name, host, port, database name and some parameters. The exact syntax of a database connection URL is specified by the Hive documentation. For example, the server principal is often included as a connection parameter when connecting to a secure Hive server.
   */
  public final HiveConnectionPool removeHiveDbConnectUrl() {
    properties.remove(HIVE_DB_CONNECT_URL_PROPERTY);
    return this;
  }

  /**
   * A file or comma separated list of files which contains the Hive configuration (hive-site.xml, e.g.). Without this, Hadoop will search the classpath for a 'hive-site.xml' file or will revert to a default configuration. Note that to enable authentication with Kerberos e.g., the appropriate properties must be set in the configuration files. Please see the Hive documentation for more details.
   */
  public final String getHiveConfigResources() {
    return properties.get(HIVE_CONFIG_RESOURCES_PROPERTY);
  }

  /**
   * A file or comma separated list of files which contains the Hive configuration (hive-site.xml, e.g.). Without this, Hadoop will search the classpath for a 'hive-site.xml' file or will revert to a default configuration. Note that to enable authentication with Kerberos e.g., the appropriate properties must be set in the configuration files. Please see the Hive documentation for more details.
   */
  public final HiveConnectionPool setHiveConfigResources(final String hiveConfigResources) {
    properties.put(HIVE_CONFIG_RESOURCES_PROPERTY, hiveConfigResources);
    return this;
  }

  /**
   * A file or comma separated list of files which contains the Hive configuration (hive-site.xml, e.g.). Without this, Hadoop will search the classpath for a 'hive-site.xml' file or will revert to a default configuration. Note that to enable authentication with Kerberos e.g., the appropriate properties must be set in the configuration files. Please see the Hive documentation for more details.
   */
  public final HiveConnectionPool removeHiveConfigResources() {
    properties.remove(HIVE_CONFIG_RESOURCES_PROPERTY);
    return this;
  }

  /**
   * Database user name
   */
  public final String getHiveDbUser() {
    return properties.get(HIVE_DB_USER_PROPERTY);
  }

  /**
   * Database user name
   */
  public final HiveConnectionPool setHiveDbUser(final String hiveDbUser) {
    properties.put(HIVE_DB_USER_PROPERTY, hiveDbUser);
    return this;
  }

  /**
   * Database user name
   */
  public final HiveConnectionPool removeHiveDbUser() {
    properties.remove(HIVE_DB_USER_PROPERTY);
    return this;
  }

  /**
   * The password for the database user
   */
  public final String getHiveDbPassword() {
    return properties.get(HIVE_DB_PASSWORD_PROPERTY);
  }

  /**
   * The password for the database user
   */
  public final HiveConnectionPool setHiveDbPassword(final String hiveDbPassword) {
    properties.put(HIVE_DB_PASSWORD_PROPERTY, hiveDbPassword);
    return this;
  }

  /**
   * The password for the database user
   */
  public final HiveConnectionPool removeHiveDbPassword() {
    properties.remove(HIVE_DB_PASSWORD_PROPERTY);
    return this;
  }

  /**
   * The maximum amount of time that the pool will wait (when there are no available connections)  for a connection to be returned before failing, or -1 to wait indefinitely. 
   */
  public final String getHiveMaxWaitTime() {
    return properties.get(HIVE_MAX_WAIT_TIME_PROPERTY);
  }

  /**
   * The maximum amount of time that the pool will wait (when there are no available connections)  for a connection to be returned before failing, or -1 to wait indefinitely. 
   */
  public final HiveConnectionPool setHiveMaxWaitTime(final String hiveMaxWaitTime) {
    properties.put(HIVE_MAX_WAIT_TIME_PROPERTY, hiveMaxWaitTime);
    return this;
  }

  /**
   * The maximum amount of time that the pool will wait (when there are no available connections)  for a connection to be returned before failing, or -1 to wait indefinitely. 
   */
  public final HiveConnectionPool removeHiveMaxWaitTime() {
    properties.remove(HIVE_MAX_WAIT_TIME_PROPERTY);
    return this;
  }

  /**
   * The maximum number of active connections that can be allocated from this pool at the same time, or negative for no limit.
   */
  public final String getHiveMaxTotalConnections() {
    return properties.get(HIVE_MAX_TOTAL_CONNECTIONS_PROPERTY);
  }

  /**
   * The maximum number of active connections that can be allocated from this pool at the same time, or negative for no limit.
   */
  public final HiveConnectionPool setHiveMaxTotalConnections(final String hiveMaxTotalConnections) {
    properties.put(HIVE_MAX_TOTAL_CONNECTIONS_PROPERTY, hiveMaxTotalConnections);
    return this;
  }

  /**
   * The maximum number of active connections that can be allocated from this pool at the same time, or negative for no limit.
   */
  public final HiveConnectionPool removeHiveMaxTotalConnections() {
    properties.remove(HIVE_MAX_TOTAL_CONNECTIONS_PROPERTY);
    return this;
  }

  /**
   * Validation query used to validate connections before returning them. When a borrowed connection is invalid, it gets dropped and a new valid connection will be returned. NOTE: Using validation may have a performance penalty.
   */
  public final String getValidationQuery() {
    return properties.get(VALIDATION_QUERY_PROPERTY);
  }

  /**
   * Validation query used to validate connections before returning them. When a borrowed connection is invalid, it gets dropped and a new valid connection will be returned. NOTE: Using validation may have a performance penalty.
   */
  public final HiveConnectionPool setValidationQuery(final String validationQuery) {
    properties.put(VALIDATION_QUERY_PROPERTY, validationQuery);
    return this;
  }

  /**
   * Validation query used to validate connections before returning them. When a borrowed connection is invalid, it gets dropped and a new valid connection will be returned. NOTE: Using validation may have a performance penalty.
   */
  public final HiveConnectionPool removeValidationQuery() {
    properties.remove(VALIDATION_QUERY_PROPERTY);
    return this;
  }

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final String getKerberosPrincipal() {
    return properties.get(KERBEROS_PRINCIPAL_PROPERTY);
  }

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final HiveConnectionPool setKerberosPrincipal(final String kerberosPrincipal) {
    properties.put(KERBEROS_PRINCIPAL_PROPERTY, kerberosPrincipal);
    return this;
  }

  /**
   * Kerberos principal to authenticate as. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final HiveConnectionPool removeKerberosPrincipal() {
    properties.remove(KERBEROS_PRINCIPAL_PROPERTY);
    return this;
  }

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final String getKerberosKeytab() {
    return properties.get(KERBEROS_KEYTAB_PROPERTY);
  }

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final HiveConnectionPool setKerberosKeytab(final String kerberosKeytab) {
    properties.put(KERBEROS_KEYTAB_PROPERTY, kerberosKeytab);
    return this;
  }

  /**
   * Kerberos keytab associated with the principal. Requires nifi.kerberos.krb5.file to be set in your nifi.properties
   */
  public final HiveConnectionPool removeKerberosKeytab() {
    properties.remove(KERBEROS_KEYTAB_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final HiveConnectionPool setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final HiveConnectionPool removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<HiveConnectionPool, HiveConnectionPool> configurator) {
    return configurator.apply(new HiveConnectionPool()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = HiveConnectionPool.class) final Closure<HiveConnectionPool> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.dbcp.hive.HiveConnectionPool> code = closure.rehydrate(c, com.tibtech.nifi.dbcp.hive.HiveConnectionPool.class, com.tibtech.nifi.dbcp.hive.HiveConnectionPool.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
