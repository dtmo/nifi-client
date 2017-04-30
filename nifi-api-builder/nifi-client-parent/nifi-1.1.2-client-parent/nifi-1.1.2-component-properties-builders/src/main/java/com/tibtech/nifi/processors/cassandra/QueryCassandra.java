package com.tibtech.nifi.processors.cassandra;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class QueryCassandra {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.cassandra.QueryCassandra";

  /**
   * Contact points are addresses of Cassandra nodes. The list of contact points should be comma-separated and in hostname:port format. Example node1:port,node2:port,.... The default client port for Cassandra is 9042, but the port(s) must be explicitly specified.
   */
  public static final String CASSANDRA_CONTACT_POINTS_PROPERTY = "Cassandra Contact Points";

  /**
   * The Cassandra Keyspace to connect to. If no keyspace is specified, the query will need to include the keyspace name before any table reference.
   */
  public static final String KEYSPACE_PROPERTY = "Keyspace";

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  /**
   * Client authentication policy when connecting to secure (TLS/SSL) cluster. Possible values are REQUIRED, WANT, NONE. This property is only used when an SSL Context has been defined and enabled.
   */
  public static final String CLIENT_AUTH_PROPERTY = "Client Auth";

  /**
   * Username to access the Cassandra cluster
   */
  public static final String USERNAME_PROPERTY = "Username";

  /**
   * Password to access the Cassandra cluster
   */
  public static final String PASSWORD_PROPERTY = "Password";

  /**
   * The strategy for how many replicas must respond before results are returned.
   */
  public static final String CONSISTENCY_LEVEL_PROPERTY = "Consistency Level";

  /**
   * Specifies the character set of the record data.
   */
  public static final String CHARACTER_SET_PROPERTY = "Character Set";

  /**
   * CQL select query
   */
  public static final String CQL_SELECT_QUERY_PROPERTY = "CQL select query";

  /**
   * The maximum amount of time allowed for a running CQL select query. Must be of format <duration> <TimeUnit> where <duration> is a non-negative integer and TimeUnit is a supported Time Unit, such as: nanos, millis, secs, mins, hrs, days. A value of zero means there is no limit. 
   */
  public static final String MAX_WAIT_TIME_PROPERTY = "Max Wait Time";

  /**
   * The number of result rows to be fetched from the result set at a time. Zero is the default and means there is no limit.
   */
  public static final String FETCH_SIZE_PROPERTY = "Fetch size";

  /**
   * The format to which the result rows will be converted. If JSON is selected, the output will contain an object with field 'results' containing an array of result rows. Each row in the array is a map of the named column to its value. For example: { "results": [{"userid":1, "name":"Joe Smith"}]}
   */
  public static final String OUTPUT_FORMAT_PROPERTY = "Output Format";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * Contact points are addresses of Cassandra nodes. The list of contact points should be comma-separated and in hostname:port format. Example node1:port,node2:port,.... The default client port for Cassandra is 9042, but the port(s) must be explicitly specified.
   */
  public final String getCassandraContactPoints() {
    return properties.get(CASSANDRA_CONTACT_POINTS_PROPERTY);
  }

  /**
   * Contact points are addresses of Cassandra nodes. The list of contact points should be comma-separated and in hostname:port format. Example node1:port,node2:port,.... The default client port for Cassandra is 9042, but the port(s) must be explicitly specified.
   */
  public final QueryCassandra setCassandraContactPoints(final String cassandraContactPoints) {
    properties.put(CASSANDRA_CONTACT_POINTS_PROPERTY, cassandraContactPoints);
    return this;
  }

  /**
   * Contact points are addresses of Cassandra nodes. The list of contact points should be comma-separated and in hostname:port format. Example node1:port,node2:port,.... The default client port for Cassandra is 9042, but the port(s) must be explicitly specified.
   */
  public final QueryCassandra removeCassandraContactPoints() {
    properties.remove(CASSANDRA_CONTACT_POINTS_PROPERTY);
    return this;
  }

  /**
   * The Cassandra Keyspace to connect to. If no keyspace is specified, the query will need to include the keyspace name before any table reference.
   */
  public final String getKeyspace() {
    return properties.get(KEYSPACE_PROPERTY);
  }

  /**
   * The Cassandra Keyspace to connect to. If no keyspace is specified, the query will need to include the keyspace name before any table reference.
   */
  public final QueryCassandra setKeyspace(final String keyspace) {
    properties.put(KEYSPACE_PROPERTY, keyspace);
    return this;
  }

  /**
   * The Cassandra Keyspace to connect to. If no keyspace is specified, the query will need to include the keyspace name before any table reference.
   */
  public final QueryCassandra removeKeyspace() {
    properties.remove(KEYSPACE_PROPERTY);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public final QueryCassandra setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The SSL Context Service used to provide client certificate information for TLS/SSL connections.
   */
  public final QueryCassandra removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * Client authentication policy when connecting to secure (TLS/SSL) cluster. Possible values are REQUIRED, WANT, NONE. This property is only used when an SSL Context has been defined and enabled.
   */
  public final String getClientAuth() {
    return properties.get(CLIENT_AUTH_PROPERTY);
  }

  /**
   * Client authentication policy when connecting to secure (TLS/SSL) cluster. Possible values are REQUIRED, WANT, NONE. This property is only used when an SSL Context has been defined and enabled.
   */
  public final QueryCassandra setClientAuth(final String clientAuth) {
    properties.put(CLIENT_AUTH_PROPERTY, clientAuth);
    return this;
  }

  /**
   * Client authentication policy when connecting to secure (TLS/SSL) cluster. Possible values are REQUIRED, WANT, NONE. This property is only used when an SSL Context has been defined and enabled.
   */
  public final QueryCassandra removeClientAuth() {
    properties.remove(CLIENT_AUTH_PROPERTY);
    return this;
  }

  /**
   * Username to access the Cassandra cluster
   */
  public final String getUsername() {
    return properties.get(USERNAME_PROPERTY);
  }

  /**
   * Username to access the Cassandra cluster
   */
  public final QueryCassandra setUsername(final String username) {
    properties.put(USERNAME_PROPERTY, username);
    return this;
  }

  /**
   * Username to access the Cassandra cluster
   */
  public final QueryCassandra removeUsername() {
    properties.remove(USERNAME_PROPERTY);
    return this;
  }

  /**
   * Password to access the Cassandra cluster
   */
  public final String getPassword() {
    return properties.get(PASSWORD_PROPERTY);
  }

  /**
   * Password to access the Cassandra cluster
   */
  public final QueryCassandra setPassword(final String password) {
    properties.put(PASSWORD_PROPERTY, password);
    return this;
  }

  /**
   * Password to access the Cassandra cluster
   */
  public final QueryCassandra removePassword() {
    properties.remove(PASSWORD_PROPERTY);
    return this;
  }

  /**
   * The strategy for how many replicas must respond before results are returned.
   */
  public final String getConsistencyLevel() {
    return properties.get(CONSISTENCY_LEVEL_PROPERTY);
  }

  /**
   * The strategy for how many replicas must respond before results are returned.
   */
  public final QueryCassandra setConsistencyLevel(final String consistencyLevel) {
    properties.put(CONSISTENCY_LEVEL_PROPERTY, consistencyLevel);
    return this;
  }

  /**
   * The strategy for how many replicas must respond before results are returned.
   */
  public final QueryCassandra removeConsistencyLevel() {
    properties.remove(CONSISTENCY_LEVEL_PROPERTY);
    return this;
  }

  /**
   * Specifies the character set of the record data.
   */
  public final String getCharacterSet() {
    return properties.get(CHARACTER_SET_PROPERTY);
  }

  /**
   * Specifies the character set of the record data.
   */
  public final QueryCassandra setCharacterSet(final String characterSet) {
    properties.put(CHARACTER_SET_PROPERTY, characterSet);
    return this;
  }

  /**
   * Specifies the character set of the record data.
   */
  public final QueryCassandra removeCharacterSet() {
    properties.remove(CHARACTER_SET_PROPERTY);
    return this;
  }

  /**
   * CQL select query
   */
  public final String getCqlSelectQuery() {
    return properties.get(CQL_SELECT_QUERY_PROPERTY);
  }

  /**
   * CQL select query
   */
  public final QueryCassandra setCqlSelectQuery(final String cqlSelectQuery) {
    properties.put(CQL_SELECT_QUERY_PROPERTY, cqlSelectQuery);
    return this;
  }

  /**
   * CQL select query
   */
  public final QueryCassandra removeCqlSelectQuery() {
    properties.remove(CQL_SELECT_QUERY_PROPERTY);
    return this;
  }

  /**
   * The maximum amount of time allowed for a running CQL select query. Must be of format <duration> <TimeUnit> where <duration> is a non-negative integer and TimeUnit is a supported Time Unit, such as: nanos, millis, secs, mins, hrs, days. A value of zero means there is no limit. 
   */
  public final String getMaxWaitTime() {
    return properties.get(MAX_WAIT_TIME_PROPERTY);
  }

  /**
   * The maximum amount of time allowed for a running CQL select query. Must be of format <duration> <TimeUnit> where <duration> is a non-negative integer and TimeUnit is a supported Time Unit, such as: nanos, millis, secs, mins, hrs, days. A value of zero means there is no limit. 
   */
  public final QueryCassandra setMaxWaitTime(final String maxWaitTime) {
    properties.put(MAX_WAIT_TIME_PROPERTY, maxWaitTime);
    return this;
  }

  /**
   * The maximum amount of time allowed for a running CQL select query. Must be of format <duration> <TimeUnit> where <duration> is a non-negative integer and TimeUnit is a supported Time Unit, such as: nanos, millis, secs, mins, hrs, days. A value of zero means there is no limit. 
   */
  public final QueryCassandra removeMaxWaitTime() {
    properties.remove(MAX_WAIT_TIME_PROPERTY);
    return this;
  }

  /**
   * The number of result rows to be fetched from the result set at a time. Zero is the default and means there is no limit.
   */
  public final String getFetchSize() {
    return properties.get(FETCH_SIZE_PROPERTY);
  }

  /**
   * The number of result rows to be fetched from the result set at a time. Zero is the default and means there is no limit.
   */
  public final QueryCassandra setFetchSize(final String fetchSize) {
    properties.put(FETCH_SIZE_PROPERTY, fetchSize);
    return this;
  }

  /**
   * The number of result rows to be fetched from the result set at a time. Zero is the default and means there is no limit.
   */
  public final QueryCassandra removeFetchSize() {
    properties.remove(FETCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * The format to which the result rows will be converted. If JSON is selected, the output will contain an object with field 'results' containing an array of result rows. Each row in the array is a map of the named column to its value. For example: { "results": [{"userid":1, "name":"Joe Smith"}]}
   */
  public final String getOutputFormat() {
    return properties.get(OUTPUT_FORMAT_PROPERTY);
  }

  /**
   * The format to which the result rows will be converted. If JSON is selected, the output will contain an object with field 'results' containing an array of result rows. Each row in the array is a map of the named column to its value. For example: { "results": [{"userid":1, "name":"Joe Smith"}]}
   */
  public final QueryCassandra setOutputFormat(final String outputFormat) {
    properties.put(OUTPUT_FORMAT_PROPERTY, outputFormat);
    return this;
  }

  /**
   * The format to which the result rows will be converted. If JSON is selected, the output will contain an object with field 'results' containing an array of result rows. Each row in the array is a map of the named column to its value. For example: { "results": [{"userid":1, "name":"Joe Smith"}]}
   */
  public final QueryCassandra removeOutputFormat() {
    properties.remove(OUTPUT_FORMAT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final QueryCassandra setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final QueryCassandra removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<QueryCassandra, QueryCassandra> configurator) {
    return configurator.apply(new QueryCassandra()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = QueryCassandra.class) final Closure<QueryCassandra> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.cassandra.QueryCassandra> code = closure.rehydrate(c, com.tibtech.nifi.processors.cassandra.QueryCassandra.class, com.tibtech.nifi.processors.cassandra.QueryCassandra.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
