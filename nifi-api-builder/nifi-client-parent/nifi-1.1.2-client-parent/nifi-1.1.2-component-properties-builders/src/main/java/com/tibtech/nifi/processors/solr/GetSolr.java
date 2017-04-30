package com.tibtech.nifi.processors.solr;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public final class GetSolr {
  /**
   * The component type name.
   */
  public static final String COMPONENT_TYPE = "org.apache.nifi.processors.solr.GetSolr";

  /**
   * The type of Solr instance, Cloud or Standard.
   */
  public static final String SOLR_TYPE_PROPERTY = "Solr Type";

  /**
   * The Solr url for a Solr Type of Standard (ex: http://localhost:8984/solr/gettingstarted), or the ZooKeeper hosts for a Solr Type of Cloud (ex: localhost:9983).
   */
  public static final String SOLR_LOCATION_PROPERTY = "Solr Location";

  /**
   * The Solr collection name, only used with a Solr Type of Cloud
   */
  public static final String COLLECTION_PROPERTY = "Collection";

  /**
   * A query to execute against Solr
   */
  public static final String SOLR_QUERY_PROPERTY = "Solr Query";

  /**
   * Comma-separated list of fields names to return
   */
  public static final String RETURN_FIELDS_PROPERTY = "Return Fields";

  /**
   * A Solr sort clause, ex: field1 asc, field2 desc
   */
  public static final String SORT_CLAUSE_PROPERTY = "Sort Clause";

  /**
   * The name of a date field in Solr used to filter results
   */
  public static final String DATE_FIELD_PROPERTY = "Date Field";

  /**
   * Number of rows per Solr query
   */
  public static final String BATCH_SIZE_PROPERTY = "Batch Size";

  /**
   * The name of the JAAS configuration entry to use when performing Kerberos authentication to Solr. If this property is not provided, Kerberos authentication will not be attempted. The value must match an entry in the file specified by the system property java.security.auth.login.config.
   */
  public static final String JAAS_CLIENT_APP_NAME_PROPERTY = "JAAS Client App Name";

  /**
   * The Controller Service to use in order to obtain an SSL Context. This property must be set when communicating with a Solr over https.
   */
  public static final String SSL_CONTEXT_SERVICE_PROPERTY = "SSL Context Service";

  /**
   * The amount of time to wait for data on a socket connection to Solr. A value of 0 indicates an infinite timeout.
   */
  public static final String SOLR_SOCKET_TIMEOUT_PROPERTY = "Solr Socket Timeout";

  /**
   * The amount of time to wait when establishing a connection to Solr. A value of 0 indicates an infinite timeout.
   */
  public static final String SOLR_CONNECTION_TIMEOUT_PROPERTY = "Solr Connection Timeout";

  /**
   * The maximum number of total connections allowed from the Solr client to Solr.
   */
  public static final String SOLR_MAXIMUM_CONNECTIONS_PROPERTY = "Solr Maximum Connections";

  /**
   * The maximum number of connections allowed from the Solr client to a single Solr host.
   */
  public static final String SOLR_MAXIMUM_CONNECTIONS_PER_HOST_PROPERTY = "Solr Maximum Connections Per Host";

  /**
   * The amount of time to wait for data on a connection to ZooKeeper, only used with a Solr Type of Cloud.
   */
  public static final String ZOO_KEEPER_CLIENT_TIMEOUT_PROPERTY = "ZooKeeper Client Timeout";

  /**
   * The amount of time to wait when establishing a connection to ZooKeeper, only used with a Solr Type of Cloud.
   */
  public static final String ZOO_KEEPER_CONNECTION_TIMEOUT_PROPERTY = "ZooKeeper Connection Timeout";

  private final Map<String, String> properties = new HashMap<String, String>();

  /**
   * The type of Solr instance, Cloud or Standard.
   */
  public final String getSolrType() {
    return properties.get(SOLR_TYPE_PROPERTY);
  }

  /**
   * The type of Solr instance, Cloud or Standard.
   */
  public final GetSolr setSolrType(final String solrType) {
    properties.put(SOLR_TYPE_PROPERTY, solrType);
    return this;
  }

  /**
   * The type of Solr instance, Cloud or Standard.
   */
  public final GetSolr removeSolrType() {
    properties.remove(SOLR_TYPE_PROPERTY);
    return this;
  }

  /**
   * The Solr url for a Solr Type of Standard (ex: http://localhost:8984/solr/gettingstarted), or the ZooKeeper hosts for a Solr Type of Cloud (ex: localhost:9983).
   */
  public final String getSolrLocation() {
    return properties.get(SOLR_LOCATION_PROPERTY);
  }

  /**
   * The Solr url for a Solr Type of Standard (ex: http://localhost:8984/solr/gettingstarted), or the ZooKeeper hosts for a Solr Type of Cloud (ex: localhost:9983).
   */
  public final GetSolr setSolrLocation(final String solrLocation) {
    properties.put(SOLR_LOCATION_PROPERTY, solrLocation);
    return this;
  }

  /**
   * The Solr url for a Solr Type of Standard (ex: http://localhost:8984/solr/gettingstarted), or the ZooKeeper hosts for a Solr Type of Cloud (ex: localhost:9983).
   */
  public final GetSolr removeSolrLocation() {
    properties.remove(SOLR_LOCATION_PROPERTY);
    return this;
  }

  /**
   * The Solr collection name, only used with a Solr Type of Cloud
   */
  public final String getCollection() {
    return properties.get(COLLECTION_PROPERTY);
  }

  /**
   * The Solr collection name, only used with a Solr Type of Cloud
   */
  public final GetSolr setCollection(final String collection) {
    properties.put(COLLECTION_PROPERTY, collection);
    return this;
  }

  /**
   * The Solr collection name, only used with a Solr Type of Cloud
   */
  public final GetSolr removeCollection() {
    properties.remove(COLLECTION_PROPERTY);
    return this;
  }

  /**
   * A query to execute against Solr
   */
  public final String getSolrQuery() {
    return properties.get(SOLR_QUERY_PROPERTY);
  }

  /**
   * A query to execute against Solr
   */
  public final GetSolr setSolrQuery(final String solrQuery) {
    properties.put(SOLR_QUERY_PROPERTY, solrQuery);
    return this;
  }

  /**
   * A query to execute against Solr
   */
  public final GetSolr removeSolrQuery() {
    properties.remove(SOLR_QUERY_PROPERTY);
    return this;
  }

  /**
   * Comma-separated list of fields names to return
   */
  public final String getReturnFields() {
    return properties.get(RETURN_FIELDS_PROPERTY);
  }

  /**
   * Comma-separated list of fields names to return
   */
  public final GetSolr setReturnFields(final String returnFields) {
    properties.put(RETURN_FIELDS_PROPERTY, returnFields);
    return this;
  }

  /**
   * Comma-separated list of fields names to return
   */
  public final GetSolr removeReturnFields() {
    properties.remove(RETURN_FIELDS_PROPERTY);
    return this;
  }

  /**
   * A Solr sort clause, ex: field1 asc, field2 desc
   */
  public final String getSortClause() {
    return properties.get(SORT_CLAUSE_PROPERTY);
  }

  /**
   * A Solr sort clause, ex: field1 asc, field2 desc
   */
  public final GetSolr setSortClause(final String sortClause) {
    properties.put(SORT_CLAUSE_PROPERTY, sortClause);
    return this;
  }

  /**
   * A Solr sort clause, ex: field1 asc, field2 desc
   */
  public final GetSolr removeSortClause() {
    properties.remove(SORT_CLAUSE_PROPERTY);
    return this;
  }

  /**
   * The name of a date field in Solr used to filter results
   */
  public final String getDateField() {
    return properties.get(DATE_FIELD_PROPERTY);
  }

  /**
   * The name of a date field in Solr used to filter results
   */
  public final GetSolr setDateField(final String dateField) {
    properties.put(DATE_FIELD_PROPERTY, dateField);
    return this;
  }

  /**
   * The name of a date field in Solr used to filter results
   */
  public final GetSolr removeDateField() {
    properties.remove(DATE_FIELD_PROPERTY);
    return this;
  }

  /**
   * Number of rows per Solr query
   */
  public final String getBatchSize() {
    return properties.get(BATCH_SIZE_PROPERTY);
  }

  /**
   * Number of rows per Solr query
   */
  public final GetSolr setBatchSize(final String batchSize) {
    properties.put(BATCH_SIZE_PROPERTY, batchSize);
    return this;
  }

  /**
   * Number of rows per Solr query
   */
  public final GetSolr removeBatchSize() {
    properties.remove(BATCH_SIZE_PROPERTY);
    return this;
  }

  /**
   * The name of the JAAS configuration entry to use when performing Kerberos authentication to Solr. If this property is not provided, Kerberos authentication will not be attempted. The value must match an entry in the file specified by the system property java.security.auth.login.config.
   */
  public final String getJaasClientAppName() {
    return properties.get(JAAS_CLIENT_APP_NAME_PROPERTY);
  }

  /**
   * The name of the JAAS configuration entry to use when performing Kerberos authentication to Solr. If this property is not provided, Kerberos authentication will not be attempted. The value must match an entry in the file specified by the system property java.security.auth.login.config.
   */
  public final GetSolr setJaasClientAppName(final String jaasClientAppName) {
    properties.put(JAAS_CLIENT_APP_NAME_PROPERTY, jaasClientAppName);
    return this;
  }

  /**
   * The name of the JAAS configuration entry to use when performing Kerberos authentication to Solr. If this property is not provided, Kerberos authentication will not be attempted. The value must match an entry in the file specified by the system property java.security.auth.login.config.
   */
  public final GetSolr removeJaasClientAppName() {
    properties.remove(JAAS_CLIENT_APP_NAME_PROPERTY);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context. This property must be set when communicating with a Solr over https.
   */
  public final String getSslContextService() {
    return properties.get(SSL_CONTEXT_SERVICE_PROPERTY);
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context. This property must be set when communicating with a Solr over https.
   */
  public final GetSolr setSslContextService(final String sslContextService) {
    properties.put(SSL_CONTEXT_SERVICE_PROPERTY, sslContextService);
    return this;
  }

  /**
   * The Controller Service to use in order to obtain an SSL Context. This property must be set when communicating with a Solr over https.
   */
  public final GetSolr removeSslContextService() {
    properties.remove(SSL_CONTEXT_SERVICE_PROPERTY);
    return this;
  }

  /**
   * The amount of time to wait for data on a socket connection to Solr. A value of 0 indicates an infinite timeout.
   */
  public final String getSolrSocketTimeout() {
    return properties.get(SOLR_SOCKET_TIMEOUT_PROPERTY);
  }

  /**
   * The amount of time to wait for data on a socket connection to Solr. A value of 0 indicates an infinite timeout.
   */
  public final GetSolr setSolrSocketTimeout(final String solrSocketTimeout) {
    properties.put(SOLR_SOCKET_TIMEOUT_PROPERTY, solrSocketTimeout);
    return this;
  }

  /**
   * The amount of time to wait for data on a socket connection to Solr. A value of 0 indicates an infinite timeout.
   */
  public final GetSolr removeSolrSocketTimeout() {
    properties.remove(SOLR_SOCKET_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The amount of time to wait when establishing a connection to Solr. A value of 0 indicates an infinite timeout.
   */
  public final String getSolrConnectionTimeout() {
    return properties.get(SOLR_CONNECTION_TIMEOUT_PROPERTY);
  }

  /**
   * The amount of time to wait when establishing a connection to Solr. A value of 0 indicates an infinite timeout.
   */
  public final GetSolr setSolrConnectionTimeout(final String solrConnectionTimeout) {
    properties.put(SOLR_CONNECTION_TIMEOUT_PROPERTY, solrConnectionTimeout);
    return this;
  }

  /**
   * The amount of time to wait when establishing a connection to Solr. A value of 0 indicates an infinite timeout.
   */
  public final GetSolr removeSolrConnectionTimeout() {
    properties.remove(SOLR_CONNECTION_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The maximum number of total connections allowed from the Solr client to Solr.
   */
  public final String getSolrMaximumConnections() {
    return properties.get(SOLR_MAXIMUM_CONNECTIONS_PROPERTY);
  }

  /**
   * The maximum number of total connections allowed from the Solr client to Solr.
   */
  public final GetSolr setSolrMaximumConnections(final String solrMaximumConnections) {
    properties.put(SOLR_MAXIMUM_CONNECTIONS_PROPERTY, solrMaximumConnections);
    return this;
  }

  /**
   * The maximum number of total connections allowed from the Solr client to Solr.
   */
  public final GetSolr removeSolrMaximumConnections() {
    properties.remove(SOLR_MAXIMUM_CONNECTIONS_PROPERTY);
    return this;
  }

  /**
   * The maximum number of connections allowed from the Solr client to a single Solr host.
   */
  public final String getSolrMaximumConnectionsPerHost() {
    return properties.get(SOLR_MAXIMUM_CONNECTIONS_PER_HOST_PROPERTY);
  }

  /**
   * The maximum number of connections allowed from the Solr client to a single Solr host.
   */
  public final GetSolr setSolrMaximumConnectionsPerHost(final String solrMaximumConnectionsPerHost) {
    properties.put(SOLR_MAXIMUM_CONNECTIONS_PER_HOST_PROPERTY, solrMaximumConnectionsPerHost);
    return this;
  }

  /**
   * The maximum number of connections allowed from the Solr client to a single Solr host.
   */
  public final GetSolr removeSolrMaximumConnectionsPerHost() {
    properties.remove(SOLR_MAXIMUM_CONNECTIONS_PER_HOST_PROPERTY);
    return this;
  }

  /**
   * The amount of time to wait for data on a connection to ZooKeeper, only used with a Solr Type of Cloud.
   */
  public final String getZooKeeperClientTimeout() {
    return properties.get(ZOO_KEEPER_CLIENT_TIMEOUT_PROPERTY);
  }

  /**
   * The amount of time to wait for data on a connection to ZooKeeper, only used with a Solr Type of Cloud.
   */
  public final GetSolr setZooKeeperClientTimeout(final String zooKeeperClientTimeout) {
    properties.put(ZOO_KEEPER_CLIENT_TIMEOUT_PROPERTY, zooKeeperClientTimeout);
    return this;
  }

  /**
   * The amount of time to wait for data on a connection to ZooKeeper, only used with a Solr Type of Cloud.
   */
  public final GetSolr removeZooKeeperClientTimeout() {
    properties.remove(ZOO_KEEPER_CLIENT_TIMEOUT_PROPERTY);
    return this;
  }

  /**
   * The amount of time to wait when establishing a connection to ZooKeeper, only used with a Solr Type of Cloud.
   */
  public final String getZooKeeperConnectionTimeout() {
    return properties.get(ZOO_KEEPER_CONNECTION_TIMEOUT_PROPERTY);
  }

  /**
   * The amount of time to wait when establishing a connection to ZooKeeper, only used with a Solr Type of Cloud.
   */
  public final GetSolr setZooKeeperConnectionTimeout(final String zooKeeperConnectionTimeout) {
    properties.put(ZOO_KEEPER_CONNECTION_TIMEOUT_PROPERTY, zooKeeperConnectionTimeout);
    return this;
  }

  /**
   * The amount of time to wait when establishing a connection to ZooKeeper, only used with a Solr Type of Cloud.
   */
  public final GetSolr removeZooKeeperConnectionTimeout() {
    properties.remove(ZOO_KEEPER_CONNECTION_TIMEOUT_PROPERTY);
    return this;
  }

  public final String getDynamicProperty(final String name) {
    return properties.get(name);
  }

  public final GetSolr setDynamicProperty(final String name, final String value) {
    properties.put(name, value);
    return this;
  }

  public final GetSolr removeDynamicProperty(final String name) {
    properties.remove(name);
    return this;
  }

  public final Map<String, String> build() {
    return properties;
  }

  public static final Map<String, String> build(final Function<GetSolr, GetSolr> configurator) {
    return configurator.apply(new GetSolr()).build();
  }

  public static final Map<String, String> build(@DelegatesTo(strategy = Closure.DELEGATE_ONLY, value = GetSolr.class) final Closure<GetSolr> closure) {
    return build(c -> {
      final Closure<com.tibtech.nifi.processors.solr.GetSolr> code = closure.rehydrate(c, com.tibtech.nifi.processors.solr.GetSolr.class, com.tibtech.nifi.processors.solr.GetSolr.class);
      code.setResolveStrategy(Closure.DELEGATE_ONLY);
      code.call();
      return c;
    } );
  }
}
